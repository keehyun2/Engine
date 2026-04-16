package com.ore.api.dto;

/**
 * Response DTO for job creation.
 */
public record JobCreateResponse(
    String jobId,
    String status
) {}
