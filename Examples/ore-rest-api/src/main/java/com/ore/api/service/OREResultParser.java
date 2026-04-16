package com.ore.api.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Service for parsing ORE CSV output files.
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class OREResultParser {

    private final ObjectMapper objectMapper;

    /**
     * Parse output files into a summary map.
     */
    public Map<String, Object> parseSummary(Path outputDir, String jobType) {
        Map<String, Object> summary = new HashMap<>();

        if (!Files.exists(outputDir)) {
            return summary;
        }

        // Parse NPV if available
        Map<String, Object> npvData = parseNPV(outputDir);
        if (!npvData.isEmpty()) {
            summary.put("npv", npvData);
        }

        // Parse flow count
        Integer flowCount = parseFlowCount(outputDir);
        if (flowCount != null) {
            summary.put("cashflowRows", flowCount);
        }

        return summary;
    }

    /**
     * Parse npv.csv file.
     */
    private Map<String, Object> parseNPV(Path outputDir) {
        Path npvFile = outputDir.resolve("npv.csv");
        if (!Files.exists(npvFile)) {
            return Map.of();
        }

        try {
            List<Map<String, String>> rows = readCSV(npvFile);
            if (rows.isEmpty()) {
                return Map.of();
            }

            double totalNpv = 0.0;
            List<Map<String, Object>> trades = new ArrayList<>();

            for (Map<String, String> row : rows) {
                String tradeId = row.getOrDefault("TradeId", row.getOrDefault("#TradeId", ""));
                String npvStr = row.get("NPV");
                String baseNpvStr = row.get("BaseNPV");
                String currency = row.getOrDefault("Currency", "");
                String baseCurrency = row.getOrDefault("BaseCurrency", "");

                double baseNpv = 0.0;
                if (baseNpvStr != null && !baseNpvStr.isBlank()) {
                    try {
                        baseNpv = Double.parseDouble(baseNpvStr);
                    } catch (NumberFormatException e) {
                        // Skip invalid values
                    }
                }

                totalNpv += baseNpv;

                Map<String, Object> trade = new HashMap<>();
                trade.put("tradeId", tradeId);
                trade.put("npv", npvStr);
                trade.put("currency", currency);
                trade.put("baseCurrency", baseCurrency);
                trade.put("baseNpv", baseNpv);
                trades.add(trade);
            }

            Map<String, Object> result = new HashMap<>();
            result.put("totalBaseNpv", Math.round(totalNpv * 100.0) / 100.0);
            result.put("tradeCount", trades.size());
            result.put("trades", trades);
            return result;

        } catch (Exception e) {
            log.warn("Failed to parse npv.csv: {}", e.getMessage());
            return Map.of();
        }
    }

    /**
     * Count rows in flows.csv.
     */
    private Integer parseFlowCount(Path outputDir) {
        Path flowFile = outputDir.resolve("flows.csv");
        if (!Files.exists(flowFile)) {
            return null;
        }

        try {
            return readCSV(flowFile).size();
        } catch (Exception e) {
            log.warn("Failed to parse flows.csv: {}", e.getMessage());
            return null;
        }
    }

    /**
     * Read CSV file into list of maps (column -> value).
     */
    private List<Map<String, String>> readCSV(Path csvFile) throws IOException {
        List<Map<String, String>> rows = new ArrayList<>();

        try (BufferedReader reader = Files.newBufferedReader(csvFile)) {
            String headerLine = reader.readLine();
            if (headerLine == null) {
                return rows;
            }

            String[] headers = parseCSVLine(headerLine);

            String line;
            while ((line = reader.readLine()) != null) {
                String[] values = parseCSVLine(line);
                Map<String, String> row = new HashMap<>();
                for (int i = 0; i < Math.min(headers.length, values.length); i++) {
                    row.put(headers[i].trim(), values[i].trim());
                }
                rows.add(row);
            }
        }

        return rows;
    }

    /**
     * Simple CSV line parser (handles quoted values).
     */
    private String[] parseCSVLine(String line) {
        List<String> result = new ArrayList<>();
        StringBuilder current = new StringBuilder();
        boolean inQuotes = false;

        for (int i = 0; i < line.length(); i++) {
            char c = line.charAt(i);

            if (c == '"') {
                inQuotes = !inQuotes;
            } else if (c == ',' && !inQuotes) {
                result.add(current.toString());
                current = new StringBuilder();
            } else {
                current.append(c);
            }
        }
        result.add(current.toString());

        return result.toArray(new String[0]);
    }
}
