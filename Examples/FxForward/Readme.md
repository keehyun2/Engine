# FxForward Example

## Overview

This example demonstrates the pricing and exposure analysis of a simple FX Forward contract using the Open Source Risk Engine (ORE).

## Trade Details

**FX Forward (FX_Forward_2D)**
- **Value Date**: 2022-02-02
- **Bought Currency**: EUR
- **Bought Amount**: 1,000,000 EUR
- **Sold Currency**: USD
- **Sold Amount**: 1,090,000 USD
- **Counterparty**: CPTY_A
- **Netting Set**: CPTY_A

## How to Run

```bash
cd /home/keehyun/dev/Engine/Examples/FxForward
ore Input/ore_fxforward.xml
```

## Input Files

- `ore_fxforward.xml` - Main ORE configuration
- `portfolio_fxforward.xml` - Portfolio definition (single FxForward trade)
- `curveconfig.xml` - Curve configuration
- `todaysmarket.xml` - Market configuration
- `conventions.xml` - Market conventions
- `pricingengine.xml` - Pricing engine configuration
- `simulation_fxforward.xml` - Simulation parameters
- `market.txt` - Market data
- `fixings.txt` - Fixing data
- `netting.xml` - Netting set definitions

## Output Files

Results are written to the `Output/` directory:
- `npv.csv` - Net present values
- `additional_results.csv` - Additional results
- `flows.csv` - Cash flows
- `curves.csv` - Yield curves
- `cube.dat` - NPV cube
- `scenariodata.csv` - Scenario data

## Analytics

The example runs the following analytics:
1. **NPV** - Net present valuation
2. **Cashflow** - Cash flow projection
3. **Curves** - Yield curve construction
4. **Simulation** - Monte Carlo simulation for exposure
5. **XVA** - Exposure profiles (EE, EPE, ENE)

## Key Differences from FxTaRF Example

This example simplifies the FxTaRF example to show a single FxForward trade:
- Only one trade instead of a FxTaRF with multiple FxForward hedges
- AMC (American Monte Carlo) is disabled since FxForward has no early exercise
- Simplified simulation configuration
