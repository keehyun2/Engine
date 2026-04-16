package com.ore.api.controller;

import com.ore.api.service.JobService;
import com.ore.api.service.StorageService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * REST controller for log retrieval.
 */
@Tag(name = "logs", description = "Log retrieval APIs")
@RestController
@RequestMapping("/api/jobs")
@RequiredArgsConstructor
public class LogController {

    private final JobService jobService;
    private final StorageService storageService;

    @Operation(summary = "Get ORE execution logs")
    @GetMapping("/{jobId}/logs")
    public ResponseEntity<String> getLogs(@PathVariable String jobId) {
        // Verify job exists
        jobService.getJob(jobId);

        String logContent = storageService.readLog(jobId);
        return ResponseEntity.ok()
            .contentType(MediaType.TEXT_PLAIN)
            .body(logContent);
    }
}
