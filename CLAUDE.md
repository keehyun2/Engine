# CLAUDE.md

This file provides guidance to Claude Code (claude.ai/code) when working with code in this repository.

## Project Overview

This is the **Open Source Risk Engine (ORE)**, a quantitative finance library for pricing and risk analysis. ORE extends QuantLib with additional models, instruments, and pricing engines for XVAs (valuation adjustments), market risk, credit risk, and exposure analytics.

**Architecture:**
- **QuantLib**: Core quantitative finance library (submodule)
- **QuantExt**: Extensions to QuantLib (simulation models, instruments, pricing engines)
- **OREData**: Data layer for trades, market data, configurations (XML-based)
- **OREAnalytics**: Pricing and risk analytics engines (XVA, sensitivities, stress testing, VaR)
- **App**: Main ORE application (`ore` executable)
- **ORE-SWIG**: Python bindings via SWIG

## Build Commands

**Prerequisites**: gcc/clang, Boost, CMake 3.15+

```bash
# Configure (from repo root)
mkdir build && cd build
cmake ..

# Build
cmake --build .

# Configure with specific preset (Linux, macOS, Windows)
cmake --preset linux-gcc-ninja-release
cmake --preset apple-arm64-ninja-release
cmake --preset windows-ninja-x64-release
```

**CMake Options** (set via `-D` or CMakePresets):
- `ORE_BUILD_DOC=ON/OFF` - Build documentation
- `ORE_BUILD_EXAMPLES=ON/OFF` - Build examples
- `ORE_BUILD_TESTS=ON/OFF` - Build test suite
- `ORE_BUILD_APP=ON/OFF` - Build main ORE application
- `ORE_BUILD_SWIG=ON/OFF` - Build Python bindings
- `ORE_ENABLE_OPENCL=ON/OFF` - Enable OpenCL for GPU support
- `ORE_ENABLE_CUDA=ON/OFF` - Enable CUDA for GPU support

## Running Tests

Test executables are built in `build/<library>/test/` directories:

```bash
# QuantLib tests
cd build/QuantLib/test-suite
./quantlib-test-suite

# QuantExt tests
cd build/QuantExt/test
./quantext-test-suite

# OREData tests
cd build/OREData/test
./ored-test-suite

# OREAnalytics tests
cd build/OREAnalytics/test
./orea-test-suite

# Run specific test (QuantLib example)
./quantlib-test-suite --log_level=all --run_test="QuantLib test suite/Swap tests"

# Run examples testsuite (pytest-based, if enabled)
cd /home/popos/dev/Engine/Examples
pytest run_examples_testsuite.py
```

## Running ORE

The main ORE application (`ore`) takes an XML configuration file as input:

```bash
ore path/to/ore.xml
```

Configuration files define:
- Portfolio (trades)
- Market data
- Curve configurations
- Pricing parameters
- Analytics to run (NPV, XVA, sensitivities, etc.)

## Code Architecture

**Library Layering** (bottom to top):
1. QuantLib → Core pricing engines, instruments, market data
2. QuantExt → Extended models (LG, HW, CrossAsset), inflation, credit
3. OREData → XML parsing, trade builders, market data loaders, configuration
4. OREAnalytics → Valuation engines, scenario generation, post-processing (XVA, sensitivity analysis, VaR)
5. App → ORE application shell (ore.cpp)

**Key namespaces:**
- `QuantLib` (ql) - Core QuantLib classes
- `QuantExt` (qle) - QuantLib extensions
- `ore::data` (ored) - Data layer, XML parsers, trade builders
- `ore::analytics` (orea) - Analytics engines, cube storage, scenario generation

**Important design patterns:**
- **Builder pattern**: `*Builder` classes construct complex objects from XML (e.g., `ore::data::TradeBuilder`, `ore::analytics::ScenarioGeneratorBuilder`)
- **Factory pattern**: `*Factory` classes create pricing engines and models
- **Singletons**: `ReferenceDataManager`, `CurveConfigurations` for global data access
- **Cube storage**: NPV cubes store results across dates/simulations (compressed sparse formats)

## Examples

The `Examples/` directory contains ~80 use cases organized by topic:
- **MinimalSetup** - Minimal configuration for pricing
- **Products** - 130+ product coverage demos
- **CurveBuilding** - Market curve bootstrapping
- **MarketRisk** - Sensitivity, stress testing, VaR
- **Exposure** - Exposure simulation (uncollateralised)
- **ExposureWithCollateral** - CSA, margin, netting
- **XvaRisk** - CVA, SA-CVA, BA-CVA
- **ScriptedTrade** - Custom payoff scripting language
- **AmericanMonteCarlo** - Fast exposure via regression
- **ORE-Python** - Python API demos
- **ORE-API** - REST API prototype

Each example has a `Readme.md` with instructions and expected results.

## Python Bindings

Python bindings are in `ORE-SWIG/` using SWIG. The module is built as `OREP` and provides access to ORE's C++ libraries from Python.

Key files:
- `ORE-SWIG/OREAnalytics-SWIG/SWIG/oreanalytics.i` - Main SWIG interface
- `ORE-SWIG/test/` - Python tests

## Common File Locations

- **Market conventions**: `Configurations/`
- **SIMM configurations**: `Configurations/SIMM/`
- **Docker setups**: `Docker/`
- **Python tools**: `Tools/PythonTools/`
- **XML schema**: `xsd/`

## Development Notes

- **C++20** standard required
- **Boost** is a heavy dependency (serialization, filesystem, threading, etc.)
- **XML** is the primary configuration format (parsed via RapidXML in `ThirdPartyLibs/`)
- **Multithreading**: Uses OpenMP for parallelization in some computationally intensive operations
- **GPU support**: Optional OpenCL/CUDA for accelerated valuations (Performance examples)

## Testing Strategy

- Unit tests use a custom test framework (see testsuites in each library)
- Python tests use pytest
- Examples serve as integration tests
- Each library has its own test suite with CMake configuration

## Known Issues

- Windows builds require MSVC or Ninja with specific compiler flags
- Boost version compatibility: tested with specific versions (see CMakePresets)
- Memory: Large portfolios/simulations can require significant RAM
