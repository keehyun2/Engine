package com.ore.api.exception;

/**
 * Exception thrown when ORE execution fails.
 */
public class OREExecutionException extends RuntimeException {
    public OREExecutionException(String message) {
        super(message);
    }

    public OREExecutionException(String message, Throwable cause) {
        super(message, cause);
    }
}
