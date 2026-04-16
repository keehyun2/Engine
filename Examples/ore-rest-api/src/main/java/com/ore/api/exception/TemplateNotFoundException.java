package com.ore.api.exception;

/**
 * Exception thrown when a template is not found.
 */
public class TemplateNotFoundException extends RuntimeException {
    public TemplateNotFoundException(String message) {
        super(message);
    }
}
