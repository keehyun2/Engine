package com.ore.api.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.prefs.BackingStoreException;

/**
 * Service for managing job directories and files.
 */
@Slf4j
@Service
public class StorageService {

    private final Path jobsBaseDir;

    public StorageService(@Value("${ore.jobs.base-dir}") String jobsBaseDir) {
        this.jobsBaseDir = Path.of(jobsBaseDir);
    }

    /**
     * Create job input and output directories.
     */
    public List<Path> createJobDirs(String jobId) throws IOException {
        Path inputDir = jobsBaseDir.resolve(jobId).resolve("input");
        Path outputDir = jobsBaseDir.resolve(jobId).resolve("output");

        Files.createDirectories(inputDir);
        Files.createDirectories(outputDir);

        log.info("Created job directories for {}", jobId);
        return List.of(inputDir, outputDir);
    }

    public Path getJobInputDir(String jobId) {
        return jobsBaseDir.resolve(jobId).resolve("input");
    }

    public Path getJobOutputDir(String jobId) {
        return jobsBaseDir.resolve(jobId).resolve("output");
    }

    /**
     * List all files in the job output directory.
     */
    public List<String> getOutputFiles(String jobId) {
        Path outputDir = getJobOutputDir(jobId);
        if (!Files.exists(outputDir)) {
            return List.of();
        }

        try {
            return Files.list(outputDir)
                .filter(Files::isRegularFile)
                .map(Path::getFileName)
                .map(Path::toString)
                .toList();
        } catch (IOException e) {
            log.warn("Failed to list output files for job {}: {}", jobId, e.getMessage());
            return List.of();
        }
    }

    /**
     * Get validated file path for a job.
     * Prevents path traversal attacks.
     */
    public Path getFilePath(String jobId, String filename) {
        validateFilename(filename);

        // Check output directory first, then input
        for (String base : List.of("output", "input")) {
            Path path = jobsBaseDir.resolve(jobId).resolve(base).resolve(filename);
            Path resolved = path.toAbsolutePath().normalize();
            Path allowedDir = jobsBaseDir.resolve(jobId).resolve(base).toAbsolutePath().normalize();

            if (resolved.startsWith(allowedDir) && Files.exists(path)) {
                return path;
            }
        }

        throw new IllegalArgumentException("File not found: " + filename);
    }

    /**
     * Read ORE log file content.
     */
    public String readLog(String jobId) {
        for (String base : List.of("output", "input")) {
            Path logPath = jobsBaseDir.resolve(jobId).resolve(base).resolve("log.txt");
            if (Files.exists(logPath)) {
                try {
                    return Files.readString(logPath);
                } catch (IOException e) {
                    log.warn("Failed to read log for job {}: {}", jobId, e.getMessage());
                }
            }
        }
        return "";
    }

    /**
     * Validate filename to prevent path traversal attacks.
     */
    private void validateFilename(String filename) {
        if (filename == null || filename.isBlank()) {
            throw new IllegalArgumentException("Filename cannot be empty");
        }
        if (filename.contains("..") || filename.contains("/") || filename.contains("\\")) {
            throw new IllegalArgumentException("Invalid filename: " + filename);
        }
        if (Path.of(filename).isAbsolute()) {
            throw new IllegalArgumentException("Absolute paths not allowed: " + filename);
        }
    }
}
