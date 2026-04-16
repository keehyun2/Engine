package com.ore.api.dto;

/**
 * Additional parameters for ORE configuration.
 */
public record Parameters(
    Setup setup,
    java.util.Map<String, String> markets,
    java.util.Map<String, Object> analytics
) {}
