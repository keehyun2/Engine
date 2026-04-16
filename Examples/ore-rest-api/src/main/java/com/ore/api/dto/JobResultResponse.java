package com.ore.api.dto;

import java.util.List;
import java.util.Map;

/**
 * Response DTO for job result.
 */
public record JobResultResponse(
    String jobId,
    String status,
    Map<String, Object> summary,
    List<String> files
) {
    public JobResultResponse {
        if (summary == null) {
            summary = Map.of();
        }
        if (files == null) {
            files = List.of();
        }
    }
}
