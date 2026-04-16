package com.ore.api.exception;

import com.ore.api.dto.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

/**
 * Global exception handler for REST API.
 */
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(JobNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleJobNotFound(
            JobNotFoundException ex,
            WebRequest request
    ) {
        ErrorResponse error = new ErrorResponse(
            HttpStatus.NOT_FOUND.value(),
            "JOB_NOT_FOUND",
            ex.getMessage(),
            request.getDescription(false).replace("uri=", "")
        );
        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(TemplateNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleTemplateNotFound(
            TemplateNotFoundException ex,
            WebRequest request
    ) {
        ErrorResponse error = new ErrorResponse(
            HttpStatus.NOT_FOUND.value(),
            "TEMPLATE_NOT_FOUND",
            ex.getMessage(),
            request.getDescription(false).replace("uri=", "")
        );
        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(OREExecutionException.class)
    public ResponseEntity<ErrorResponse> handleOREExecution(
            OREExecutionException ex,
            WebRequest request
    ) {
        ErrorResponse error = new ErrorResponse(
            HttpStatus.INTERNAL_SERVER_ERROR.value(),
            "ORE_EXECUTION_FAILED",
            ex.getMessage(),
            request.getDescription(false).replace("uri=", "")
        );
        return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<ErrorResponse> handleIllegalArgument(
            IllegalArgumentException ex,
            WebRequest request
    ) {
        ErrorResponse error = new ErrorResponse(
            HttpStatus.BAD_REQUEST.value(),
            "INVALID_REQUEST",
            ex.getMessage(),
            request.getDescription(false).replace("uri=", "")
        );
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, Object>> handleValidationExceptions(
            MethodArgumentNotValidException ex,
            WebRequest request
    ) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });

        Map<String, Object> response = new HashMap<>();
        response.put("timestamp", LocalDateTime.now());
        response.put("status", HttpStatus.BAD_REQUEST.value());
        response.put("error", "VALIDATION_ERROR");
        response.put("message", "Validation failed");
        response.put("details", errors);
        response.put("path", request.getDescription(false).replace("uri=", ""));

        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse> handleGlobalException(
            Exception ex,
            WebRequest request
    ) {
        ErrorResponse error = new ErrorResponse(
            HttpStatus.INTERNAL_SERVER_ERROR.value(),
            "INTERNAL_ERROR",
            ex.getMessage(),
            request.getDescription(false).replace("uri=", "")
        );
        return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
