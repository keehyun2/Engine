package com.ore.api.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ore.api.dto.OREInputs;
import com.ore.api.exception.JobNotFoundException;
import com.ore.api.model.Job;
import com.ore.api.repository.JobRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.nio.file.Path;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * Service for managing ORE jobs.
 */
@Slf4j
@Service
public class JobService {

    private final JobRepository jobRepository;
    private final ObjectMapper objectMapper;
    private final TemplateService templateService;
    private final StorageService storageService;
    private final OREWorker oreWorker;

    public JobService(
            JobRepository jobRepository,
            ObjectMapper objectMapper,
            TemplateService templateService,
            StorageService storageService,
            @Lazy OREWorker oreWorker
    ) {
        this.jobRepository = jobRepository;
        this.objectMapper = objectMapper;
        this.templateService = templateService;
        this.storageService = storageService;
        this.oreWorker = oreWorker;
    }

    /**
     * Create a new job.
     */
    @Transactional
    public String createJob(String jobType, String template, OREInputs inputs) {
        // Validate template
        List<String> availableTemplates = templateService.listTemplates();
        if (!availableTemplates.contains(template)) {
            throw new IllegalArgumentException(
                "Template '" + template + "' not found. Available: " + availableTemplates
            );
        }

        // Create job entity
        Job job = new Job();
        job.setId(UUID.randomUUID().toString());
        job.setJobType(jobType);
        job.setTemplate(template);
        job.setStatus("queued");
        job.setProgress(0);

        try {
            job.setRequestJson(objectMapper.writeValueAsString(inputs));
        } catch (Exception e) {
            throw new RuntimeException("Failed to serialize request JSON", e);
        }

        // Save to database
        jobRepository.save(job);
        log.info("Created job {} (type={}, template={})", job.getId(), jobType, template);

        // Create directories and render templates
        try {
            List<Path> dirs = storageService.createJobDirs(job.getId());
            Path inputDir = dirs.get(0);
            Path outputDir = dirs.get(1);

            templateService.renderJobInputs(template, inputs, inputDir, outputDir, jobType);

            // Execute asynchronously
            oreWorker.executeORE(job.getId());

        } catch (Exception e) {
            job.setStatus("failed");
            job.setErrorMessage(e.getMessage());
            jobRepository.save(job);
            throw new RuntimeException("Failed to initialize job", e);
        }

        return job.getId();
    }

    /**
     * Get job by ID.
     */
    public Job getJob(String jobId) {
        return jobRepository.findById(jobId)
            .orElseThrow(() -> new JobNotFoundException("Job not found: " + jobId));
    }

    /**
     * Get job type.
     */
    public String getJobType(String jobId) {
        return getJob(jobId).getJobType();
    }

    /**
     * Update job status.
     */
    @Transactional
    public void updateStatus(String jobId, String status, int progress) {
        Job job = getJob(jobId);
        job.setStatus(status);
        job.setProgress(progress);
        jobRepository.save(job);
    }

    /**
     * Mark job as completed.
     */
    @Transactional
    public void markJobCompleted(String jobId, Map<String, Object> summary, List<String> files) {
        Job job = getJob(jobId);
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

    /**
     * Mark job as failed.
     */
    @Transactional
    public void markJobFailed(String jobId, String errorMessage) {
        Job job = getJob(jobId);
        job.setStatus("failed");
        job.setProgress(0);
        job.setErrorMessage(errorMessage != null && errorMessage.length() > 2000
            ? errorMessage.substring(errorMessage.length() - 2000)
            : errorMessage);
        jobRepository.save(job);
    }

    /**
     * Cancel a queued job.
     */
    @Transactional
    public void cancelJob(String jobId) {
        Job job = getJob(jobId);
        if (!job.getStatus().equals("queued")) {
            throw new IllegalArgumentException("Cannot cancel job with status: " + job.getStatus());
        }
        job.setStatus("cancelled");
        jobRepository.save(job);
    }
}
