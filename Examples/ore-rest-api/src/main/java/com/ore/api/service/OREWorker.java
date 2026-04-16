package com.ore.api.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ore.api.config.OREConfig;
import com.ore.api.dto.OREInputs;
import com.ore.api.model.Job;
import com.ore.api.repository.JobRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

/**
 * Service for executing ORE subprocess and parsing results.
 */
@Slf4j
@Service
public class OREWorker {

    private final OREConfig oreConfig;
    private final ObjectMapper objectMapper;
    private final JobRepository jobRepository;
    private final StorageService storageService;
    private final OREResultParser resultParser;
    private final Path jobsBaseDir;

    public OREWorker(
            OREConfig oreConfig,
            ObjectMapper objectMapper,
            JobRepository jobRepository,
            StorageService storageService,
            OREResultParser resultParser,
            @Value("${ore.jobs.base-dir}") String jobsBaseDir
    ) {
        this.oreConfig = oreConfig;
        this.objectMapper = objectMapper;
        this.jobRepository = jobRepository;
        this.storageService = storageService;
        this.resultParser = resultParser;
        this.jobsBaseDir = Path.of(jobsBaseDir);
    }

    /**
     * Execute ORE asynchronously with @Async support.
     */
    @org.springframework.scheduling.annotation.Async("oreTaskExecutor")
    public CompletableFuture<Void> executeORE(String jobId) {
        return CompletableFuture.runAsync(() -> {
            try {
                doExecute(jobId);
            } catch (Exception e) {
                log.error("Error executing ORE job {}", jobId, e);
                markJobFailed(jobId, e.getMessage());
            }
        });
    }

    private void doExecute(String jobId) throws Exception {
        log.info("Starting ORE execution for job {}", jobId);

        // Update status to running
        updateStatus(jobId, "running", 10);

        Path inputDir = storageService.getJobInputDir(jobId);
        Path outputDir = storageService.getJobOutputDir(jobId);

        // Check ORE executable
        if (!oreConfig.isOREAvailable()) {
            throw new IllegalStateException("ORE executable not found. Configure ore.executable.path or set ORE_PATH environment variable.");
        }

        Path oreExe = Path.of(oreConfig.getPath());
        Path oreXml = inputDir.resolve("ore.xml");

        if (!Files.exists(oreXml)) {
            throw new IllegalStateException("ore.xml not found in job input directory");
        }

        // Build process
        ProcessBuilder pb = new ProcessBuilder(
            oreExe.toString(),
            "ore.xml"
        );
        pb.directory(inputDir.toFile());
        pb.redirectErrorStream(true);

        log.debug("Executing ORE: {} in directory {}", oreExe, inputDir);

        Process process = pb.start();

        // Capture output with timeout
        StringBuilder output = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(
                new InputStreamReader(process.getInputStream(), StandardCharsets.UTF_8))
        ) {
            String line;
            while ((line = reader.readLine()) != null) {
                output.append(line).append("\n");
            }
        }

        // Wait for process with timeout
        boolean completed = process.waitFor(oreConfig.getTimeoutSeconds(), TimeUnit.SECONDS);

        if (!completed) {
            process.destroyForcibly();
            throw new RuntimeException(String.format(
                "ORE execution timed out after %d seconds", oreConfig.getTimeoutSeconds()
            ));
        }

        int exitCode = process.exitValue();

        // Save log to output directory
        Files.createDirectories(outputDir);
        Path logFile = outputDir.resolve("log.txt");
        Files.writeString(logFile, output.toString(), StandardCharsets.UTF_8);

        if (exitCode != 0) {
            String error = output.length() > 2000 ? output.substring(output.length() - 2000) : output.toString();
            throw new RuntimeException(String.format("ORE exited with code %d: %s", exitCode, error.trim()));
        }

        // Parse results
        Job job = jobRepository.findById(jobId).orElse(null);
        String jobType = job != null ? job.getJobType() : "unknown";
        Map<String, Object> summary = resultParser.parseSummary(outputDir, jobType);
        List<String> outputFiles = storageService.getOutputFiles(jobId);

        markJobCompleted(jobId, summary, outputFiles);

        log.info("Job {} completed successfully. Output files: {}", jobId, outputFiles);
    }

    private void updateStatus(String jobId, String status, int progress) {
        Job job = jobRepository.findById(jobId).orElse(null);
        if (job != null) {
            job.setStatus(status);
            job.setProgress(progress);
            jobRepository.save(job);
        }
    }

    private void markJobFailed(String jobId, String errorMessage) {
        Job job = jobRepository.findById(jobId).orElse(null);
        if (job != null) {
            job.setStatus("failed");
            job.setProgress(0);
            job.setErrorMessage(errorMessage != null && errorMessage.length() > 2000
                ? errorMessage.substring(errorMessage.length() - 2000)
                : errorMessage);
            jobRepository.save(job);
        }
    }

    private void markJobCompleted(String jobId, Map<String, Object> summary, List<String> files) {
        Job job = jobRepository.findById(jobId).orElse(null);
        if (job != null) {
            job.setStatus("completed");
            job.setProgress(100);
            try {
                job.setResultJson(objectMapper.writeValueAsString(Map.of(
                    "summary", summary,
                    "files", files
                )));
            } catch (Exception e) {
                log.warn("Failed to serialize result JSON for job {}", jobId, e);
            }
            jobRepository.save(job);
        }
    }
}
