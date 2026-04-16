package com.ore.api.controller;

import com.ore.api.dto.*;
import com.ore.api.model.Job;
import com.ore.api.service.JobService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

/**
 * REST controller for job management.
 */
@Tag(name = "jobs", description = "Job management APIs")
@RestController
@RequestMapping("/api/jobs")
@RequiredArgsConstructor
public class JobController {

    private final JobService jobService;

    @Operation(summary = "Create a new ORE job")
    @PostMapping
    public ResponseEntity<JobCreateResponse> createJob(@Valid @RequestBody JobCreateRequest request) {
        String jobId = jobService.createJob(request.jobType(), request.template(), request.inputs());
        Job job = jobService.getJob(jobId);
        return ResponseEntity.status(201).body(new JobCreateResponse(jobId, job.getStatus()));
    }

    @Operation(summary = "Get job status")
    @GetMapping("/{jobId}")
    public ResponseEntity<JobResponse> getJobStatus(@PathVariable String jobId) {
        Job job = jobService.getJob(jobId);
        return ResponseEntity.ok(new JobResponse(
            job.getId(),
            job.getStatus(),
            job.getProgress(),
            job.getTemplate(),
            job.getJobType(),
            job.getCreatedAt(),
            job.getUpdatedAt()
        ));
    }

    @Operation(summary = "Get job result")
    @GetMapping("/{jobId}/result")
    public ResponseEntity<JobResultResponse> getJobResult(@PathVariable String jobId) {
        Job job = jobService.getJob(jobId);

        // The result JSON is stored in the database
        String resultJson = job.getResultJson();
        // In a real implementation, we'd parse this to extract summary and files
        // For now, return a basic response

        return ResponseEntity.ok(new JobResultResponse(
            job.getId(),
            job.getStatus(),
            null,  // summary would be parsed from resultJson
            List.of()  // files would be parsed from resultJson
        ));
    }

    @Operation(summary = "Cancel a queued job")
    @PostMapping("/{jobId}/cancel")
    public ResponseEntity<JobResponse> cancelJob(@PathVariable String jobId) {
        jobService.cancelJob(jobId);
        Job job = jobService.getJob(jobId);
        return ResponseEntity.ok(new JobResponse(
            job.getId(),
            job.getStatus(),
            job.getProgress(),
            job.getTemplate(),
            job.getJobType(),
            job.getCreatedAt(),
            job.getUpdatedAt()
        ));
    }
}
