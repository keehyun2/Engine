package com.ore.api.dto;

/**
 * Setup parameters for ORE configuration.
 */
public record Setup(
    String inputPath,
    String outputPath,
    String logFile,
    Integer logMask
) {}
