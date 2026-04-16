package com.ore.api.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;

/**
 * Request DTO for creating a new ORE job.
 */
public record JobCreateRequest(
    @NotBlank(message = "jobType is required")
    String jobType,

    @NotBlank(message = "template is required")
    String template,

    @Valid
    OREInputs inputs
) {}
