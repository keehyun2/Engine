package com.ore.api.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ore.api.dto.OREInputs;
import com.ore.api.dto.Parameters;
import com.ore.api.dto.Setup;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;
import org.springframework.core.io.ResourceLoader;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Service for rendering ORE XML templates using Thymeleaf.
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class TemplateService {

    private final TemplateEngine templateEngine;
    private final ResourceLoader resourceLoader;
    private final ObjectMapper objectMapper;

    @Value("${ore.templates.dir:classpath:templates}")
    private String templatesDir;

    @Value("${ore.shared-input-dir:../Input}")
    private String sharedInputDir;

    /**
     * Render ORE input files for a job.
     */
    public Path renderJobInputs(
            String templateName,
            OREInputs inputs,
            Path jobInputDir,
            Path jobOutputDir,
            String jobType
    ) {
        try {
            // Build template context
            Context context = buildContext(templateName, inputs, jobInputDir, jobOutputDir);

            // Write user-provided files
            writeUserFiles(inputs, jobInputDir);

            // Render ore.xml
            String templatePath = templateName + "/ore";
            String oreXml = templateEngine.process(templatePath, context);

            Path oreXmlPath = jobInputDir.resolve("ore.xml");
            Files.writeString(oreXmlPath, oreXml);

            log.info("Rendered ore.xml for template '{}'", templateName);
            return oreXmlPath;

        } catch (Exception e) {
            throw new RuntimeException("Failed to render template: " + templateName, e);
        }
    }

    private Context buildContext(
            String templateName,
            OREInputs inputs,
            Path jobInputDir,
            Path jobOutputDir
    ) {
        Map<String, Object> defaults = loadDefaults(templateName);

        Context context = new Context();

        // Build setup section
        @SuppressWarnings("unchecked")
        Map<String, Object> setup = (Map<String, Object>) defaults.getOrDefault("setup", new HashMap<>());
        setup = new HashMap<>(setup);
        setup.put("asOfDate", inputs.asOfDate());
        if (inputs.baseCurrency() != null) {
            setup.put("baseCurrency", inputs.baseCurrency());
        }

        // Compute relative path to shared input directory
        String sharedPath = computeRelativePath(jobInputDir, Path.of(sharedInputDir));
        setup.put("sharedInputDir", sharedPath);

        // Override shared file paths
        String[] sharedFiles = {
            "marketDataFile", "fixingDataFile", "curveConfigFile",
            "conventionsFile", "marketConfigFile", "pricingEnginesFile"
        };

        for (String key : sharedFiles) {
            Object value = setup.get(key);
            if (value instanceof String str && str.startsWith("../../Input/")) {
                String filename = str.substring("../../Input/".length());
                setup.put(key, sharedPath + "/" + filename);
            }
        }

        // Apply user parameters if provided
        if (inputs.parameters() != null && inputs.parameters().setup() != null) {
            applyUserOverrides(setup, inputs.parameters().setup());
        }

        context.setVariable("setup", setup);

        // Markets section
        @SuppressWarnings("unchecked")
        Map<String, String> markets = (Map<String, String>) defaults.getOrDefault("markets", new HashMap<>());
        if (inputs.parameters() != null && inputs.parameters().markets() != null) {
            markets.putAll(inputs.parameters().markets());
        }
        context.setVariable("markets", markets);

        // Analytics section
        @SuppressWarnings("unchecked")
        Map<String, Map<String, Object>> analytics =
            (Map<String, Map<String, Object>>) defaults.getOrDefault("analytics", new HashMap<>());

        if (inputs.parameters() != null && inputs.parameters().analytics() != null) {
            for (var entry : inputs.parameters().analytics().entrySet()) {
                analytics.computeIfAbsent(entry.getKey(), k -> new HashMap<>())
                    .putAll((Map<String, Object>) entry.getValue());
            }
        }
        context.setVariable("analytics", analytics);

        // Output path
        String outputPath = computeRelativePath(jobInputDir, jobOutputDir);
        context.setVariable("outputPath", outputPath);

        return context;
    }

    @SuppressWarnings("unchecked")
    private Map<String, Object> loadDefaults(String templateName) {
        try {
            String defaultsPath = "classpath:templates/" + templateName + "/defaults.yml";
            var resource = resourceLoader.getResource(defaultsPath);

            if (!resource.exists()) {
                log.debug("No defaults.yml found for template '{}'", templateName);
                return new HashMap<>();
            }

            // Parse YAML (simple approach - in production, use SnakeYAML)
            // For now, return empty map and let templates handle defaults
            return new HashMap<>();

        } catch (Exception e) {
            log.warn("Failed to load defaults for template '{}': {}", templateName, e.getMessage());
            return new HashMap<>();
        }
    }

    private void writeUserFiles(OREInputs inputs, Path jobInputDir) throws IOException {
        Files.createDirectories(jobInputDir);

        if (inputs.portfolioFile() != null) {
            Files.writeString(jobInputDir.resolve("portfolio.xml"), inputs.portfolioFile());
        }
        if (inputs.marketData() != null) {
            Files.writeString(jobInputDir.resolve("market.txt"), inputs.marketData());
        }
        if (inputs.fixingData() != null) {
            Files.writeString(jobInputDir.resolve("fixings.txt"), inputs.fixingData());
        }
        if (inputs.curveConfig() != null) {
            Files.writeString(jobInputDir.resolve("curveconfig.xml"), inputs.curveConfig());
        }
        if (inputs.conventions() != null) {
            Files.writeString(jobInputDir.resolve("conventions.xml"), inputs.conventions());
        }
        if (inputs.marketConfig() != null) {
            Files.writeString(jobInputDir.resolve("todaysmarket.xml"), inputs.marketConfig());
        }
        if (inputs.pricingEngines() != null) {
            Files.writeString(jobInputDir.resolve("pricingengine.xml"), inputs.pricingEngines());
        }
        if (inputs.simulationConfig() != null) {
            Files.writeString(jobInputDir.resolve("simulation.xml"), inputs.simulationConfig());
        }
        if (inputs.nettingSets() != null) {
            Files.writeString(jobInputDir.resolve("netting.xml"), inputs.nettingSets());
        }
    }

    private String computeRelativePath(Path from, Path to) {
        try {
            Path fromAbs = from.toAbsolutePath();
            Path toAbs = to.toAbsolutePath();

            Path relative = fromAbs.relativize(toAbs);
            String path = relative.toString().replace("\\", "/");

            // Count how many levels up we need to go
            int levels = 0;
            Path current = fromAbs;
            while (current != null && !current.startsWith(toAbs)) {
                current = current.getParent();
                levels++;
            }

            if (levels > 0) {
                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < levels; i++) {
                    sb.append("..");
                    if (i < levels - 1) sb.append("/");
                }
                return sb.toString();
            }

            return path.isEmpty() ? "." : path;
        } catch (IllegalArgumentException e) {
            // Can't compute relative path (different drives on Windows)
            return to.toAbsolutePath().toString();
        }
    }

    private void applyUserOverrides(Map<String, Object> target, Setup userSetup) {
        if (userSetup.inputPath() != null) target.put("inputPath", userSetup.inputPath());
        if (userSetup.outputPath() != null) target.put("outputPath", userSetup.outputPath());
        if (userSetup.logFile() != null) target.put("logFile", userSetup.logFile());
        if (userSetup.logMask() != null) target.put("logMask", userSetup.logMask());
    }

    public List<String> listTemplates() {
        try {
            var resource = resourceLoader.getResource("classpath:templates/");
            if (resource.exists()) {
                var file = resource.getFile();
                if (file.isDirectory()) {
                    return List.of(file.list((dir, name) -> new java.io.File(dir, name).isDirectory()));
                }
            }
        } catch (IOException e) {
            log.warn("Failed to list templates: {}", e.getMessage());
        }

        // Return default templates
        return List.of("pricing-basic", "xva-standard", "stress-ir-up", "stress-ir-down");
    }
}
