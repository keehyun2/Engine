package com.ore.api.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;

/**
 * ORE input parameters for job execution.
 */
public record OREInputs(
    @JsonProperty("asOfDate")
    @NotBlank(message = "asOfDate is required")
    String asOfDate,

    @JsonProperty("baseCurrency")
    String baseCurrency,

    @JsonProperty("portfolio")
    PortfolioData portfolio,

    @JsonProperty("portfolioFile")
    String portfolioFile,

    @JsonProperty("marketData")
    String marketData,

    @JsonProperty("fixingData")
    String fixingData,

    @JsonProperty("curveConfig")
    String curveConfig,

    @JsonProperty("conventions")
    String conventions,

    @JsonProperty("marketConfig")
    String marketConfig,

    @JsonProperty("pricingEngines")
    String pricingEngines,

    @JsonProperty("simulationConfig")
    String simulationConfig,

    @JsonProperty("nettingSets")
    String nettingSets,

    @JsonProperty("parameters")
    Parameters parameters
) {
    public OREInputs {
        if (baseCurrency == null || baseCurrency.isBlank()) {
            baseCurrency = "EUR";
        }
    }

    public record PortfolioData(
        String trades,
        String xml
    ) {}
}
