package com.ore.api.dto;

import java.time.LocalDateTime;

/**
 * Standard error response DTO.
 */
public record ErrorResponse(
    LocalDateTime timestamp,
    int status,
    String error,
    String message,
    String path
) {
    public ErrorResponse(int status, String code, String message, String path) {
        this(LocalDateTime.now(), status, code, message, path);
    }
}
