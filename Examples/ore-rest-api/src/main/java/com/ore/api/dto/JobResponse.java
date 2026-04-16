package com.ore.api.dto;

import java.time.LocalDateTime;

/**
 * Response DTO for job status.
 */
public record JobResponse(
    String jobId,
    String status,
    int progress,
    String template,
    String jobType,
    LocalDateTime createdAt,
    LocalDateTime updatedAt
) {}
