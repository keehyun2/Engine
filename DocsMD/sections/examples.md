# Examples

Over 80 Examples of ORE usage have been compiled since the first release
of ORE, in order to help users getting started and to serve as
plausibility checks for the results generated with ORE.

The examples a grouped by topic as shown in table
<a href="#tab_0" data-reference-type="ref" data-reference="tab_0">1</a>
below. The structure of the `ore/Examples` folder follows the same
structure as this User Guide section.

Change to each subsection below and the associated Examples subdirectory
to learn more about the list of cases.

<div class="center">

<div id="tab_0">

| Example topic            | Description                                                                                                              | Contained Legacy Examples                                         |
|:-------------------------|:-------------------------------------------------------------------------------------------------------------------------|:------------------------------------------------------------------|
| Academy                  | Basic ORE Academy examples, with minimal configuration                                                                   |                                                                   |
| Minimal Setup            | Example showing the minimal configuration required for pricing (market data, todays market, curve config, conventions)   | 14                                                                |
| Products                 | Demonstrate ORE’s product coverage across asset classes, 150+ products, vanilla and complex                              | 18-21, 27, 45-48, 51, 65-66, 71, 74                               |
| Curve Building           | Consistency check that market instruments are repriced correctly after bootstrap, demo several curve building features   | 26, 28-30, 49, 53, 59                                             |
| Market Risk              | Sensitivity, Stress Testing, Par Conversion, Parametric and HistSim VaR, P&L and P&L Explain, Market Risk Capital (SMRC) | 15, 22, 40, 50, 57-58, 62-63, 68-69, 77                           |
| Initial Margin           | ISDA SIMM and IM Schedule, Dynamic Initial Margin via Regression and Dynamic Delta VaR                                   | 13, 44                                                            |
| Exposure                 | Uncollateralised exposure simulation, product by product, mainly vanilla, demo various simulation features               | 1-9, 11-12, 16-17, 23-25, 32-38, 64                               |
| Exposure with Collateral | Impact of Variation Margin and CSA details, Impact of Initial Margin                                                     | 10, 31, 72                                                        |
| Scripted Trade           | Introducing the Scripted Trade framework                                                                                 | 52                                                                |
| American Monte Carlo     | Fast and accurate Exposures using AMC, selected vanilla and complex products                                             | 39, 54, 55, 60, 73, 75                                            |
| XVA Risk                 | Sensitivity, Stress Testing, P&L Explain, CVA Capital (SA-CVA and BA-CVA)                                                | 67, 68, 70                                                        |
| Credit Risk              | Credit Portfolio Model, Derivatives Credit Risk Capital (SA-CCR)                                                         | 43, 68                                                            |
| Performance              | NPV and CVA Sensitivities using AAD and using bump & reval with GPU parallelization                                      | 41, 56, 61                                                        |
| ORE-Python               | Python Wrapper covering ORE libraries and QuantLib                                                                       | 42, and the Python examples previously in the ORE-SWIG repository |
| ORE-API                  | ORE Web Service prototype using ORE-Python                                                                               | 0                                                                 |

ORE example topics.

</div>

</div>

All example results can be produced with the Python scripts `run.py` in
the ORE Example subdirectories which work on both Windows and Unix
platforms. In a nutshell, all scripts call ORE’s command line
application with a single input XML file

`ore[.exe] ore.xml`

They produce a number of standard reports and exposure graphs in PDF
format. The structure of the input file and of the portfolio, market and
other configuration files referred to therein will be explained in
section <a href="#sec:configuration" data-reference-type="ref"
data-reference="sec:configuration">[sec:configuration]</a>.

ORE is driven by a number of input files, listed in table
<a href="#tab_1" data-reference-type="ref" data-reference="tab_1">2</a>
and explained in detail in sections
<a href="#sec:configuration" data-reference-type="ref"
data-reference="sec:configuration">[sec:configuration]</a> to
<a href="#sec:fixings" data-reference-type="ref"
data-reference="sec:fixings">[sec:fixings]</a>. In all examples, these
input files are either located in the example’s sub directory
`Examples/Example_#/Input` or the main input directory `Examples/Input`
if used across several examples. The particular selection of input files
is determined by the ’master’ input file `ore.xml`.

<div class="center">

<div id="tab_1">

| File Name            | Description                                                                                                                                            |
|:---------------------|:-------------------------------------------------------------------------------------------------------------------------------------------------------|
| `ore.xml`            | Master input file, selection of further inputs below and selection of analytics                                                                        |
| `portfolio.xml`      | Trade data                                                                                                                                             |
| `netting.xml`        | Collateral (CSA) data                                                                                                                                  |
| `simulation.xml`     | Configuration of simulation model and market                                                                                                           |
| `market.txt`         | Market data snapshot                                                                                                                                   |
| `fixings.txt`        | Index fixing history                                                                                                                                   |
| `dividends.txt`      | Dividends history                                                                                                                                      |
| `curveconfig.xml`    | Curve and term structure composition from individual market instruments                                                                                |
| `conventions.xml`    | Market conventions for all market data points                                                                                                          |
| `todaysmarket.xml`   | Configuration of the market composition, relevant for the pricing of the given portfolio as of today (yield curves, FX rates, volatility surfaces etc) |
| `pricingengines.xml` | Configuration of pricing methods by product                                                                                                            |

ORE input files

</div>

</div>

The typical list of output files and reports is shown in table
<a href="#tab_2" data-reference-type="ref" data-reference="tab_2">3</a>.
The names of output files can be configured through the master input
file `ore.xml`. Whether these reports are generated also depends on the
setting in ` ore.xml`. For the examples, all output will be written to
the directory `Examples/Example_#/Output`.

<div class="center">

<div id="tab_2">

| File Name                   | Description                                                                  |
|:----------------------------|:-----------------------------------------------------------------------------|
| `npv.csv`                   | NPV report                                                                   |
| `flows.csv`                 | Cashflow report                                                              |
| `curves.csv`                | Generated yield (discount) curves report                                     |
| `xva.csv`                   | XVA report, value adjustments at netting set and trade level                 |
| `exposure_trade_*.csv`      | Trade exposure evolution reports                                             |
| `exposure_nettingset_*.csv` | Netting set exposure evolution reports                                       |
| `rawcube.csv`               | NPV cube in readable text format                                             |
| `netcube.csv`               | NPV cube after netting and collateral, in readable text format               |
| `.csv.gz`                   | Intermediate storage of NPV cube and scenario data                           |
| `.pdf`                      | Exposure graphics produced by the python script `run.py` after ORE completed |

ORE output files

</div>

</div>

Note: When building ORE from sources on Windows platforms, make sure
that you copy your `ore.exe` to the binary directory `App/bin/win32/`
respectively `App/bin/x64/`. Otherwise the examples may be run using the
pre-compiled executables which come with the ORE release.

## Testsuites

The build includes a set of testsuites for each of QuantLib, QuantExt,
OREData, and OREAnalytics libraries. You can run all tests by navigating
into the Build folder and running the following command:
`ctest -C Release -j4 –timeout 3600`

## Python

Running any of the examples described in the following sections needs a
python3 installation.

## Academy

This section contains a few examples with minimal configuration for demo
cases shown in ORE Academy videos on youtube:
<https://www.youtube.com/channel/UCrCpkb1-s3pxKd7U-YgJulA>

## Minimal Setup

The example in folder `MinimalSetup` demonstrates using a minimal market
data setup in order to run the “opening” vanilla Swap exposure
simulation in section
<a href="#example:exposure" data-reference-type="ref"
data-reference="example:exposure">1.8</a>. The minimal market data uses
single points per curve where possible.

Run with: `python run.py`

## Products

This example contains 150+ sample trades in ORE XML across six asset
classes, vanilla and complex, see subfolder `Example_Trades`. The sample
trades have also been concatenated into a single portfolio in
`Input/portfolio.xml`.

The Input folder contains the necessary configuration and market data to
support a valuation batch. Run it with: `python run.py`

See the **ORE Product Catalogue** in `Docs/UserGuide/products.tex|pdf`
for payoff descriptions, input guide and pricing methods.

In addition to the `npv` and `cashflow` analytic we have selected the
`portfolioDetails` analytic in `Products/Input/ore.xml`:

``` xml
  <Setup>
     ...
  </Setup>
  <Analytics>
    <Analytic type="npv">
      <Parameter name="active">Y</Parameter>
      <Parameter name="baseCurrency">USD</Parameter>
      <Parameter name="outputFileName">npv.csv</Parameter>
      <Parameter name="additionalResults">Y</Parameter>
      <Parameter name="additionalResultsReportPrecision">12</Parameter>
    </Analytic>
    <Analytic type="cashflow">
      <Parameter name="active">Y</Parameter>
      <Parameter name="outputFileName">flows.csv</Parameter>
    </Analytic>
    <Analytic type="portfolioDetails">
      <Parameter name="active">Y</Parameter>
      <Parameter name="riskFactorFileName">riskFactors.csv</Parameter>
      <Parameter name="marketObjectFileName">marketObjects.csv</Parameter>
      </Analytic>
  </Analytics>
```

This leads to the reporting of portfolio composition in a series of
extra files in folder `Products/Output`:

- counterparties.csv

- marketObjects.csv

- netting_sets.csv

- riskFactors.csv

- swap_indices.csv

- trade_types.csv

- underlying_indices.csv

## Curve Building

This directory demonstrates several curve building cases

- Bootstrap Consistency: `python run_consistency.py`

- Discount Ratio Curves: `python run_discountratio.py`

- Fixed vs Float Cross Currency Helpers: `python run_fixedfloatccs.py`

- USD-Prime Curve Building via Prime-LIBOR Basis Swaps:
  `python run_prime.py`

- Bond Yield Shifted Curves: `python run_bondyieldshifted.py`

- Central Bank Meeting Dates: `python run_dentralbank.py`

- SABR Swaption and Cap/Floor Volatilities: `python run_sabr.py`

Run all with: `python run.py`.

### Bootstrap Consistency

This example confirms that bootstrapped curves correctly reprice the
bootstrap instruments (FRAs, Interest Rate Swaps, FX Forwards, Cross
Currency Basis Swaps) using three pricing setups with

- EUR collateral discounting (configuration xois_eur)

- USD collateral discounting (configuration xois_usd)

- in-currency OIS discounting (configuration collateral_inccy)

The required portfolio files need to be generated from market data and
conventions in `Examples/Input` and trade templates in
`Examples/CurveBuilding/Helpers`, calling

`python TradeGenerator.py`

at the `Examples/CurveBuilding` level.

This will place three portfolio files `_portfolio.xml` in the input
folder. Thereafter, the three consistency checks can be run calling

`python run_consistency.py`

at the `Examples/CurveBuilding` level.

Results are in three files `_npv.csv` in
`Examples/CurveBuilding/Output/consistency` and should show zero NPVs
for all benchmark instruments.

### Discount Ratio Curves

This example shows how to use a yield curve built from a DiscountRatio
segment. In particular, it builds a GBP collateralized in EUR discount
curve by referencing three other discount curves:

- a GBP collateralised in USD curve

- a EUR collateralised in USD curve

- a EUR OIS curve i.e. a EUR collateralised in EUR curve

The implicit assumption in building the curve this way is that EUR/GBP
FX forwards collateralised in EUR have the same fair market rate as
EUR/GBP FX forwards collateralised in USD. This assumption is
illustrated in the example by the NPV of the two forward instruments in
the portfolio returning exactly 0 under both discounting regimes i.e.
under USD collateralization with direct curve building and under EUR
collateralization with the discount ratio modified “GBP-IN-EUR” curve.

Also, in this example, an assumption is made that there are no direct
GBP/EUR FX forward or cross currency quotes available which in general
is false. The example s merely for illustration.

Both collateralization scenarios can be run calling `python run.py`.

### Fixed vs Float Cross Currency Helpers

This example demonstrates using fixed vs. float cross currency swap
helpers. In particular, it builds a TRY collateralised in USD discount
curve using TRY annual fixed vs USD 3M Libor swap quotes.

The portfolio contains an at-market fixed vs. float cross currency swap
that is included in the curve building. The NPV of this swap should be
zero when the example is run, using `python run_fixedfloatccs.py` at the
`Examples/CurveBuilding` level or “directly” calling
`ore[.exe] ore.xml`.

### USD-Prime Curve Building

This example demonstrates the implementation of the USD-Prime index in
the ORE. The USD-Prime yield curve is built from USD-Prime vs USD 3M
Libor basis swap quotes. The portfolio consists of two fair basis swaps
(NPVs equal to 0):

- US Dollar Prime Rate vs 3 Month LIBOR

- US Dollar 3 Month LIBOR vs Fed Funds + 0.027

In particular, it is confirmed that the bootstrapped curves USD-FedFunds
and USD-Prime follow the 3% rule observed on the market:
`U.S. Prime Rate = (The Fed Funds Target Rate + 3%)`. (See
<http://www.fedprimerate.com/>.)

Running ORE in directory `Examples/CurveBuilding` with
`python run_prime.py ` yields the USD-Prime curve in
`Examples/CurveBuilding/Output/prime/curves.csv.`

### Bond Yield Shifted Curves

This example shows how to use a yield curve built from a
BondYieldShifted segment, as described in section
<a href="#sec:bond_yield_shifted" data-reference-type="ref"
data-reference="sec:bond_yield_shifted">[sec:bond_yield_shifted]</a>.

In particular, it builds the curve `USD.BMK.GVN.CURVE_SHIFTED` shifted
by three liquid Bonds:

- Fixed rate USD Bond maturing in August 2023 with id `EJ7706660`.

- Fixed rate USD Bond maturing in September 2049 with id `ZR5330686`.

- Floating Rate Bond maturing in May 2025 with id `AS064441`.

The resulting curve is exhibited in the `curves.csv` output file.
Moreover, the results can be cross checked against the NPVs, i.e.
prices, of the ZeroBonds comprised in the portfolio.

- `ZeroBond_long`, maturing 2052-03-01 shows a price of 0.2080 akin to
  the 0.2080 in the curves output at the same date.

- `ZeroBond_short`, maturing 2032-06-01 shows a price of 0.5808 aktin to
  the 0.808 in the curves output at the same date.

The example can be run calling `python run_bondyieldshifted.py` at the
`Examples/CurveBuilding` level.

### Central Bank Meeting Dates

This example demonstrates the build of a GBP OIS curve using MPC Swaps
at the short end, i.e. using OIS Swaps with concrete forward start and
end date.

### SABR Volatility Surfaces

This example demonstrates the pricing of a Swaption and a Cap on
volatility surfaces that are interpolated in smile direction using a
SABR model flavour. As usual the example is run by calling
`python run.py`

The essential configuration is in `curveconfig.xml` where the
Interpolation (Swaption) resp. StrikeInterpolation (Caps/Floors) allows
the following new SABR types

- Hagan2002Lognormal

- Hagan2002Normal

- Hagan2002NormalZeroBeta

- Antonov2015FreeBoundaryNormal

- KienitzLawsonSwaynePde

- FlochKennedy

SABR parameters can be calibrated or have fixed externally provided
values per option tenor and Swap tenor (Swaptions) resp. optionlet
(Caps/Floors).

## Market Risk

This directory demonstrates the following collection of market risk
analytics:

- Sensitivity analysis in the “raw” and “par” domain:
  `python run_sensi.py`

- Sensitivity analysis when pricing with smile:
  `python run_sensismile.py`

- parametric VaR: `run_parametricvar.py`

- Stress testing in the “raw” domain: `run_stress.py`

- Stress testing in the “par” domain: `run_parstress.py`

- Stressed Sensitivity analysis: `python run_sensistress.py`

- Historical Simulation VaR: `run_histsimvar.py`

- Simple Market Risk Capital (SMRC): `run_smrc.py`

- P&L and P&L Explanation: `run_pnlexplain.py`

- Par conversion utility: `run_parconversion.py`

- Base scenario utility: `run_basescenario.py`

- Zero to par shift utility: r͡un_zerotoparshift.py

Run all with: `python run.py`.

### Sensitivity Analysis

This example (`python run_sensi.py`) demonstrates the calculation of
sensitivities for a portfolio consisting of

- a vanilla swap in EUR

- a cross currency swap EUR-USD

- a resettable cross currency swap EUR-USD

- a FX forward EUR-USD

- a FX call option on USD/GBP

- a FX put option on USD/EUR

- an European swaption

- a Bermudan swaption

- a cap and a floor in USD

- a cap and a floor in EUR

- a fixed rate bond

- a floating rate bond with floor

- an Equity call option, put option and forward on S&P500

- an Equity call option, put option and forward on Lufthansa

- a CPI Swap referencing UKRPI

- a Year-on-Year inflation swap referencing EUHICPXT

- a USD CDS.

The sensitivity configuration in `sensitivity.xml` aims at computing the
following sensitivities

- discount curve sensitivities in EUR, USD; GBP, CHF, JPY, on pillars
  6M, 1Y, 2Y, 3Y, 5Y, 7Y, 10Y, 15Y, 20Y (absolute shift of 0.0001)

- forward curve sensitivities for EUR-EURIBOR 6M and 3M indices,
  EUR-EONIA, USD-LIBOR 3M and 6M, GBP-LIBOR 3M and 6M, CHF-LIBOR-6M and
  JPY-LIBOR-6M indices (absolute shift of 0.0001)

- yield curve shifts for a bond benchmark curve in EUR (absolute shift
  of 0.0001)

- FX spot sensitivities for USD, GBP, CHF, JPY against EUR as the base
  currency (relative shift of 0.01)

- FX vegas for USDEUR, GBPEUR, JPYEUR volatility surfaces (relative
  shift of 0.01)

- swaption vegas for the EUR surface on expiries 1Y, 5Y, 7Y, 10Y and
  underlying terms 1Y, 5Y, 10Y (relative shift of 0.01)

- caplet vegas for EUR and USD on an expiry grid 1Y, 2Y, 3Y, 5Y, 7Y, 10Y
  and strikes 0.01, 0.02, 0.03, 0.04, 0.05. (absolute shift of 0.0001)

- credit curve sensitivities on tenors 6M, 1Y, 2Y, 5Y, 10Y (absolute
  shift of 0.0001).

- Equity spots for S&P500 and Lufthansa

- Equity vegas for S&P500 and Lufthansa at expiries 6M, 1Y, 2Y, 3Y, 5Y

- Zero inflation curve deltas for UKRPI and EUHICPXT at tenors 6M, 1Y,
  2Y, 3Y, 5Y, 7Y, 10Y, 15Y, 20Y

- Year on year inflation curve deltas for EUHICPXT at tenors 6M, 1Y, 2Y,
  3Y, 5Y, 7Y, 10Y, 15Y, 20Y

Furthermore, mixed second order derivatives (“cross gammas”) are
computed for discount-discount, discount-forward and forward-forward
curves in EUR.

The sensitivities are first computed in the “raw” (e.g. zero rate and
optionlet) domain. The “raw” sensitivity analysis produces three output
files.

The first, `scenario.csv`, contains the shift direction (`UP`, `DOWN`,
`CROSS`), the base NPV, the scenario NPV and the difference of these two
for each trade and sensitivity key. For an overview over the possible
scenario keys see <a href="#sec:sensitivity" data-reference-type="ref"
data-reference="sec:sensitivity">[sec:sensitivity]</a>.

The second file, `sensitivity.csv`, contains the shift size (in absolute
terms always) and first (“Delta”) and second (“Gamma”) order finite
differences computed from the scenario results. Note that the Delta and
Gamma results are pure differences, i.e. they are not divided by the
shift size.

The second file also contains second order mixed differences according
to the specified cross gamma filter, along with the shift sizes for the
two factors involved.

Raw sensitivities are then converted into the “par” domain (e.g. Swap
rates, CDS spreads) via a Jacobi transformation. See a sketch of the
methodology in and section
<a href="#sec:sensitivity" data-reference-type="ref"
data-reference="sec:sensitivity">[sec:sensitivity]</a> for configuration
details.

To perform a par sensitivity analysis, the following extension in
`ore.xml` is required

``` xml
    <Analytic type="sensitivity">
      <Parameter name="active">Y</Parameter>
      <Parameter name="marketConfigFile">simulation.xml</Parameter>
      <Parameter name="sensitivityConfigFile">sensitivity.xml</Parameter>
      <Parameter name="pricingEnginesFile">../../Input/pricingengine.xml</Parameter>
      <Parameter name="scenarioOutputFile">sensi_scenarios.csv</Parameter>
      <Parameter name="sensitivityOutputFile">sensitivity.csv</Parameter>
      <Parameter name="outputSensitivityThreshold">0.000001</Parameter>
      <!-- Additional parametrisation for par sensitivity analysis -->
      <Parameter name="parSensitivity">Y</Parameter>
      <Parameter name="parSensitivityOutputFile">parsensitivity.csv</Parameter>
      <Parameter name="outputJacobi">Y</Parameter>
      <Parameter name="jacobiOutputFile">jacobi.csv</Parameter>
      <Parameter name="jacobiInverseOutputFile">jacobi_inverse.csv</Parameter>
    </Analytic>
```

The usual “raw” sensitivity analysis is performed by bumping the “raw”
rates (zero rates, hazard rates, inflation zero rates, optionlet vols).
This is followed by the Jacobi transformation that turns “raw”
sensitivities into sensitivities in the par domain (Deposit/FRA/Swap
rates, FX Forwards, CC Basis Swap spreads, CDS spreads, ZC and YOY
Inflation Swap rates, flat Cap/Floor vols). The conversion is controlled
by the additional `ParConversion` data blocks in `sensitivity.xml` where
the assumed par instruments and corresponding conventions are coded, as
shown below for three types of discount curves.

``` xml
  <DiscountCurves>

    <DiscountCurve ccy="EUR">
      <ShiftType>Absolute</ShiftType>
      <ShiftSize>0.0001</ShiftSize>
      <ShiftTenors>2W,1M,3M,6M,9M,1Y,2Y,3Y,4Y,5Y,7Y,10Y,15Y,20Y,25Y,30Y</ShiftTenors>
      <ParConversion>
        <!--DEP, FRA, IRS, OIS, FXF, XBS -->
    <Instruments>OIS,OIS,OIS,OIS,OIS,OIS,OIS,OIS,OIS,OIS,OIS,OIS,OIS,OIS,OIS,OIS</Instruments>
    <SingleCurve>true</SingleCurve>
    <Conventions>
      <Convention id="OIS">EUR-OIS-CONVENTIONS</Convention>
    </Conventions>
      </ParConversion>
    </DiscountCurve>

    <DiscountCurve ccy="USD">
      <ShiftType>Absolute</ShiftType>
      <ShiftSize>0.0001</ShiftSize>
      <ShiftTenors>2W,1M,3M,6M,9M,1Y,2Y,3Y,4Y,5Y,7Y,10Y,15Y,20Y,25Y,30Y</ShiftTenors>
      <ParConversion>
    <Instruments>FXF,FXF,FXF,FXF,FXF,XBS,XBS,XBS,XBS,XBS,XBS,XBS,XBS,XBS,XBS,XBS</Instruments>
    <SingleCurve>true</SingleCurve>
    <Conventions>
      <Convention id="XBS">EUR-USD-XCCY-BASIS-CONVENTIONS</Convention>
      <Convention id="FXF">EUR-USD-FX-CONVENTIONS</Convention>
    </Conventions>
      </ParConversion>

    <DiscountCurve ccy="GBP">
      <ShiftType>Absolute</ShiftType>
      <ShiftSize>0.0001</ShiftSize>
      <ShiftTenors>2W,1M,3M,6M,9M,1Y,2Y,3Y,4Y,5Y,7Y,10Y,15Y,20Y,25Y,30Y</ShiftTenors>
      <ParConversion>
    <Instruments>DEP,DEP,DEP,DEP,DEP,IRS,IRS,IRS,IRS,IRS,IRS,IRS,IRS,IRS,IRS,IRS</Instruments>
    <SingleCurve>true</SingleCurve>
    <Conventions>
      <Convention id="DEP">GBP-DEPOSIT</Convention>
      <Convention id="IRS">GBP-6M-SWAP-CONVENTIONS</Convention>
    </Conventions>
      </ParConversion>
    </DiscountCurve>

  </DiscountCurves>
```

Finally note that par sensitivity analysis requires that the shift tenor
grid in the sensitivity data above matches the corresponding grid in the
simulation (market) configuration. See also section
<a href="#sec:sensitivity" data-reference-type="ref"
data-reference="sec:sensitivity">[sec:sensitivity]</a>.

### Sensitivity Analysis and Pricing with Smile

This example (`python run_sensismile.py`) demonstrates the current state
of sensitivity calculation in ORE for European options where the
volatility surface has a smile.

The portfolio used in this example consists of

- an equity call option denominated in USD (“SP5”)

- an equity put option denominated in USD (“SP5”)

- a receiver swaption in EUR

- an FX call option on EUR/USD

Refer to for the current status of sensitivity implementation with
smile. In this example the setup is as follows

- today’s market is configured with volatility smile for all three
  products above

- simulation market has two configurations, to simulate “ATM only” or
  the “full surface”; “ATM only” means that only ATM volatilities are to
  be simulated and shifts to ATM vols are propagated to the respective
  smile section;

- the sensitivity analysis has two corresponding configurations as well,
  “ATM only” and “full surface”; note that the “full surface”
  configuration leads to explicit sensitivities by strike only in the
  case of Swaption volatilities, for FX and Equity volatilities only ATM
  sensitivity can be specified at the moment and sensitivity output is
  currently aggregated to the ATM bucket (to be extended in subsequent
  releases).

The respective output files end with “`_fullSurface.csv`” respectively
“`_atmOnly.csv`”.

### Parametric VaR

This example (`python run_parametricvar.py`) demonstrates a parametric
VaR calculation based on the sensitivity and cross gamma output from the
sensitivity analysis (deltas, vegas, gammas, cross gammas) and an
external covariance matrix input. The result in `var.csv` shows a
breakdown by portfolio, risk class (All, Interest Rate, FX, Inflation,
Equity, Credit) and risk type (All, Delta & Gamma, Vega). The results
shown are Delta Gamma Normal VaRs for the 95% and 99% quantile, the
holding period is incorporated into the input covariances.
Alternatively, one can choose a Monte Carlo VaR which means that the
sensitivity based P&L distribution is evaluated with MC simulation
assuming normal respectively log-normal risk factor distribution.

### Correlation

This example (`python run_correlation.py`) demonstrates a correlation
calculation based on an external scenario matrix input. The result in
`correlation.csv` shows a breakdown of the correlation between risk
factor keys.

### Stress Testing

This example (`python run_stress`) uses the same portfolio as the
sensitivity analysis in
<a href="#example:marketrisk_sensi" data-reference-type="ref"
data-reference="example:marketrisk_sensi">1.6.1</a>. The stress scenario
definition in `stresstest.xml` defines two stress tests:

- `parallel_rates`: Rates are shifted in parallel by 0.01 (absolute).
  The EUR bond benchmark curve is shifted by increasing amounts 0.001,
  ..., 0.009 on the pillars 6M, ..., 20Y. FX Spots are shifted by 0.01
  (relative), FX vols by 0.1 (relative), swaption and cap floor vols by
  0.0010 (absolute). Credit curves are not yet shifted.

- `twist`: The EUR bond benchmark curve is shifted by amounts -0.0050,
  -0.0040, -0.0030, -0.0020, 0.0020, 0.0040, 0.0060, 0.0080, 0.0100 on
  pillars 6M, 1Y, 2Y, 3Y, 5Y, 7Y, 10Y, 15Y, 20Y.

The corresponding output file `stresstest.csv` contains the base NPV,
the NPV under the scenario shifts and the difference of the two for each
trade and scenario label.

### Stress Testing in the Par Domain

The stress test in
<a href="#example:marketrisk_stress" data-reference-type="ref"
data-reference="example:marketrisk_stress">1.6.5</a> is performed in the
“raw” domain of zero rate shifts, hazard rate shifts, optionlet
volatility shifts etc. To analyse the impact of market rate shifts (Swap
rates, CDS spreads, flat vols), one would have to manipulate the market
data input into ORE and re-run the entire ORE process multiple times.

This example (`python run_parstress.py`) demonstrates the extended
stress testing framework that operates in the “par” rate domain in a
configurable way i.e without the user’s manipulation of the input market
data.

### Stressed Sensitivity Analysis

This example (`python run_sensistress.py`) demonstrates the stressed
sensitivity analysis. The new analytic type *SENSITIVITY_STRESS*
utilizes the existing stresstest framework, applies stress scenarios to
T0 market and runs sensitivity analysis. The Stresstest scenarios are
given in the same input format as for the regular stresstest. Dependent
sensitivity analysis is currently supported only in zero domain for all
asset classes.

The stressed sensitivity analytic replaces the todaysMarket with a
SimulationMarket during the sensitivity calculation. For some risk
factors the simulationMarket behaves different as the todaysMarket.
Depending on the simulation and stress scenario settings it could use
different tenors when building curves or use only the ATM volatilities.
It is recommended to activate UseSpreadedTermStructures and simulate
SwaptionVolatilities for the stressed sensitivity run.

### Historical Simulation VaR

This example (`python run_histsimvar.py`) demonstrates a historical
simulation VaR calculation given a portfolio and externally provided
“market scenarios” covering one or several historical observation
period(s). The analytic is specified as usual in `ore.xml` with the
following parameters:

- outputFile: csv file name of the resulting VaR report

- tradePnl: boolean, if true the VaR report will contain a breakdown by
  tradeID, risk class and risk type, otherwise the report shows the
  portfolio-level VaR only.

- riskFactorBreakdown: boolean, if true the VaR report will contain a
  breakdown by risk factor.

- quantiles: comma separated list of quantiles to be reported

- portfolioFilter (optional): Only trades with `portfolioId` equal to
  the provided filter name are processed, see `portfolio.xml`; the
  entire portfolio is processed, if omitted

- historicalPeriod: comma-separated date list, an even number of ordered
  dates is required (d1, d2, d3, d4, ...), where each pair (d1-d2,
  d3-d4, ...) defines the start and end of historical observation
  periods used

- mporDays: Number of calendar days between historical scenarios taken
  from the observation periods in order to compute P&L effects
  (typically 1 or 10)

- mporCalendar: Calendar applied in the scenario date calculation

- mporOverlappingPeriods: Boolean, if true we use overlapping periods of
  length mporDays (t to t + 10 calendar days, t+1 to t+11, t+2 to t+12,
  ...), otherwise consecutive periods (t to t+10, t+10 to t+20, ...)

- simulationConfigFile: defines the structure of the simulation market
  applied in the P&L calculation, e.g. discount and index curves, yield
  curve tenor points used, FX pairs etc.

- historicalScenarioFile: csv file containing the market scenarios for
  each date in the observation periods defined below; the granularity of
  the scenarios (e.g. discount and index curves, number of yield curve
  tenors) needs to match the simulation market definition above; each
  yield curve tenor scenario is represented as a discount factor

### SMRC - Basic Market Risk Capital

Rn with: `run_smrc.py`

### P&L and P&L Explain

This example (`run_pnlexplain.py`) demonstrates the P&L and P&L explain
analytics on a very simple test portfolio that consists of two
single-leg swaps. Main output is the P&L report in `Output/Pnl/pnl.csv`
with the following columns

- TradeId

- Maturity and MaturityTime

- StartDate and EndDate of the P&L period, referred to as t0 and t1
  below

- NPV(t0)

- NPV(asof=t0; mkt=t1)

- NPV(asof=t1; mkt=t0)

- NPV(t1)

- PeriodCashFlow: Aggregate of trade flows in the period, converted into
  the P&L currency below

- Theta: NPV(asof=t1; mkt=t0) - NPV(t0) + PeriodCashFLow

- HypotheticalCleanPnL: NPV(asof=t0; mkt=t1) - NPV(t0)

- CleanPnL: NPV(t1) - NPV(t0) + PeriodCashFlow

- DirtyPnL: NPV(t1) - NPV(t0)

- Currency

Moreover we write

- Four “flavours” of NPV reports used here

- Four related additional results reports

- Two reports for the market scenarios used in the two “lagged” NPV
  calculations

The second batch included in this example explains the P&L above in
terms of portfolio sensitivities and changes in related market moves.
The main output of this is in `Output/PnlExplain/pnl_explain.csv`. The
PnlExplain analytic contains the Pnl analytic as dependent analytic,
i.e. the PnlExplain analytic is self-sufficient kicking off Pnl
calculation internally. The only additional piece of input for the
explainer run is `sensitivity.xml`.

### Stand-alone Par Conversion Utility

This example (`python run_parconversion.py`) demonstrates ORE’s
capability to convert external computed zero sensitivities (e.g Zero
rates) to par sensitivities (e.g. to Swap rates) that is implemented by
means of a Jacobi transformation of the “raw” sensitivities (e.g. to
zero rates), see a sketch of the methodology in and section
<a href="#sec:sensitivity" data-reference-type="ref"
data-reference="sec:sensitivity">[sec:sensitivity]</a> for configuration
details.

To perform a par sensitivity analysis, the following required change in
`ore.xml` is required

``` xml
    <Analytic type="zeroToParSensiConversion">
      <Parameter name="active">Y</Parameter>
      <Parameter name="marketConfigFile">simulation.xml</Parameter>
      <Parameter name="sensitivityConfigFile">sensitivity.xml</Parameter>
      <Parameter name="pricingEnginesFile">../../Input/pricingengine.xml</Parameter>
      <!-- Input file with the raw sensitivities -->
      <Parameter name="sensitivityInputFile">sensitivity.csv</Parameter>
      <Parameter name="idColumn">TradeId</Parameter>
      <Parameter name="riskFactorColumn">Factor_1</Parameter>
      <Parameter name="deltaColumn">Delta</Parameter>
      <Parameter name="currencyColumn">Currency</Parameter>
      <Parameter name="baseNpvColumn">Base NPV</Parameter>
      <Parameter name="shiftSizeColumn">ShiftSize_1</Parameter>
      <Parameter name="outputThreshold">0.000001</Parameter>
      <Parameter name="outputFile">parconversion_sensitivity.csv</Parameter>
      <Parameter name="outputJacobi">Y</Parameter>
      <Parameter name="jacobiOutputFile">jacobi.csv</Parameter>
      <Parameter name="jacobiInverseOutputFile">jacobi_inverse.csv</Parameter>
    </Analytic>
```

The portfolio used in this example includes zero sensitivities of

- Discount and index curves

- Credit curves

- Inflation curves

- CapFloor volatilities

ORE reads the raw sensitivities from the csv input file
\*sensitivityInputFile\*. The input file needs to have six columns, the
column names can be user configured. Here is a description of each of
the columns:

1.  idColumn : Column with a unique identifier for the trade /
    nettingset / portfolio.

2.  riskFactorColumn: Column with the identifier of the zero/raw
    sensitivity. The risk factor name needs to follow the ORE naming
    convention, e.g. DiscountCurve/EUR/5/1Y (the 6th bucket in EUR
    discount curve as specified in the sensitivity.xml) 

3.  deltaColumn: The raw sensitivity of the trade/nettingset / portfolio
    with respect to the risk factor

4.  currencyColumn: The currency in which the raw sensitivity is
    expressed, need to be the same as the BaseCurrency in the simulation
    settings.

5.  shiftSizeColumn: The shift size applied to compute the raw
    sensitivity, need to be consistent to the sensitivity configuration.

6.  baseNpvColumn: The base npv of the trade / nettingset / portfolio in
    currency.

This is followed by the Jacobi transformation that turns “raw”
sensitivities into sensitivities in the par domain (Deposit/FRA/Swap
rates, FX Forwards, CC Basis Swap spreads, CDS spreads, ZC and YOY
Inflation Swap rates, flat Cap/Floor vols). The conversion is controlled
by the additional `ParConversion` data blocks in `sensitivity.xml` where
the assumed par instruments and corresponding conventions are coded, as
shown below for three types of discount curves.

``` xml
  <DiscountCurves>

    <DiscountCurve ccy="EUR">
      <ShiftType>Absolute</ShiftType>
      <ShiftSize>0.0001</ShiftSize>
      <ShiftTenors>2W,1M,3M,6M,9M,1Y,2Y,3Y,4Y,5Y,7Y,10Y,15Y,20Y,25Y,30Y</ShiftTenors>
      <ParConversion>
        <!--DEP, FRA, IRS, OIS, FXF, XBS -->
    <Instruments>OIS,OIS,OIS,OIS,OIS,OIS,OIS,OIS,OIS,OIS,OIS,OIS,OIS,OIS,OIS,OIS</Instruments>
    <SingleCurve>true</SingleCurve>
    <Conventions>
      <Convention id="OIS">EUR-OIS-CONVENTIONS</Convention>
    </Conventions>
      </ParConversion>
    </DiscountCurve>

    <DiscountCurve ccy="USD">
      <ShiftType>Absolute</ShiftType>
      <ShiftSize>0.0001</ShiftSize>
      <ShiftTenors>2W,1M,3M,6M,9M,1Y,2Y,3Y,4Y,5Y,7Y,10Y,15Y,20Y,25Y,30Y</ShiftTenors>
      <ParConversion>
    <Instruments>FXF,FXF,FXF,FXF,FXF,XBS,XBS,XBS,XBS,XBS,XBS,XBS,XBS,XBS,XBS,XBS</Instruments>
    <SingleCurve>true</SingleCurve>
    <Conventions>
      <Convention id="XBS">EUR-USD-XCCY-BASIS-CONVENTIONS</Convention>
      <Convention id="FXF">EUR-USD-FX-CONVENTIONS</Convention>
    </Conventions>
      </ParConversion>

    <DiscountCurve ccy="GBP">
      <ShiftType>Absolute</ShiftType>
      <ShiftSize>0.0001</ShiftSize>
      <ShiftTenors>2W,1M,3M,6M,9M,1Y,2Y,3Y,4Y,5Y,7Y,10Y,15Y,20Y,25Y,30Y</ShiftTenors>
      <ParConversion>
    <Instruments>DEP,DEP,DEP,DEP,DEP,IRS,IRS,IRS,IRS,IRS,IRS,IRS,IRS,IRS,IRS,IRS</Instruments>
    <SingleCurve>true</SingleCurve>
    <Conventions>
      <Convention id="DEP">GBP-DEPOSIT</Convention>
      <Convention id="IRS">GBP-6M-SWAP-CONVENTIONS</Convention>
    </Conventions>
      </ParConversion>
    </DiscountCurve>

  </DiscountCurves>
```

Finally note that par sensitivity analysis requires that the shift tenor
grid in the sensitivity data above matches the corresponding grid in the
simulation (market) configuration. See also section
<a href="#sec:sensitivity" data-reference-type="ref"
data-reference="sec:sensitivity">[sec:sensitivity]</a>.

### Base Scenario Utility

This example (`python run_basescenario.py`) demonstrates the `Scenario`
analytic which has been added to export the simulation market’s base
scenario as a file. This analytic is e.g. used internally in P&L
analytics <a href="#example:marketrisk_pnl" data-reference-type="ref"
data-reference="example:marketrisk_pnl">1.6.10</a>, and it can be used
to extract historical scenarios for the HistSim Var
<a href="#example:marketrisk_histsim" data-reference-type="ref"
data-reference="example:marketrisk_histsim">1.6.8</a>.

### Zero Shift to Par Shift Conversion Utility

This example (`python run_zerotoparshift.py`) demonstrates the
conversion of zero shifts to par rate shifts. ORE applies the zero rate
shifts to the zero curves and computes the resulting shifts in the
implied fair rate of a given set of par instruments. The zero rate
shifts are defined as stresstests and the par instruments are defined in
the usual sensitivity configuration. This analytic is used internally in
the par-sensitivity-based P&L explainer.

## Initial Margin

This section covers two groups of batches

- ISDA SIMM and IM Schedule

- a Dynamic Initial Margin case study

discussed in the following subsection.

### ISDA SIMM and IM Schedule

This example (`python run_simm.py`) demonstrates the calculation of
initial margin using ISDA’s Standard Initial Margin Model (SIMM) based
on a provided sensitivity file in ISDA’s Common Risk Interchange Format
(CRIF). In addition, we show how to use the standard "IM Schedule"
method to compute initial margin.

ORE covers all SIMM versions since inception to date, i.e. 1.0, 1.1,
1.2, 1.3, 1.3.38, 2.0, 2.1, 2.2, 2.3, 2.4 (=2.3.8), 2.5, 2.5A, 2.6
(=2.5.6). All versions have been tested against the respective ISDA SIMM
model unit test suites and pass these tests. Any new SIMM versions will
be added with each ORE release.

For SIMM versions \>= 2.2 we support SIMM calculation for both MPoR
horizons, 1d and 10d.

Note that you need to purchase a SIMM model license from ISDA if you
want to use the model in production, and the unit test suites mentioned
above are provided to licensed vendors only. Therefore we unfortunately
cannot share our ORE SIMM model test suite here either.

By running  

`python run_simm.py`

ORE will pick up the small example CRIF file in `Input/crif.csv`
(i.e. par sensitivities rebucketed and reformatted to match the ISDA
CRIF template) and generate the resulting SIMM report in a `simm.csv`
file. This report shows ISDA SIMM results with the usual breakdown by
product class, risk class, margin type, bucket and SIMM “side” (IM to
call or post). The SIMM calculation in this example is done for SIMM
version 2.4 and 2.6, with MPoR 1d and 10d:

- SIMM 2.4, 1-day MPoR

- SIMM 2.4, 10-day MPoR

- SIMM 2.6, 1-day MPoR

- SIMM 2.6, 10-day MPoR

There are four SIMM-related input files – `ore_SIMM2.4_1D.xml`,
`ore_SIMM2.4_10D.xml`, `ore_SIMM2.6_1D.xml`, `ore_SIMM2.6_10D.xml` –
with corresponding folders in the `Output/` directory. The relevant
inputs in the files are:

- SIMM version

- name of the CRIF file to be loaded

- calculation currency - this determines which Risk_FX entries of the
  CRIF will be ignored in the SIMM calculation

- result currency (optional) - currency of the resulting SIMM amounts in
  the report, by default equal to the calculation currency

- MPoR horizon, in terms of days

The market data input and todays’s market configuration required here is
minimal - limited to FX rates for conversions from base/calculation
currency into USD and into the result currency.

### IM Schedule

As an additional case in this example we demonstrate how to use the IM
Schedule method to compute initial margin. The related input file is
`Input/ore_schedule.xml`. It is also run when calling `python run.py`,
and results are written to folder `Output/IM_SCHEDULE`. The basic input
is provided in CRIF file format where ORE expects two lines per trade,
one with RiskClass = PV and one with RiskClass = Notional, so that the
amounts in these CRIF lines are interpreted as NPV respectively
notional. Further required columns are product class and end date, as
shown in the example `Input/crif_schedule.csv`. Note that the product
class has to be in

- Rates

- FX

- Equity

- Credit

- Commodity

in contrast to SIMM where we use the combined RatesFX.

To run the IM Schedule analytic, the following minimal addition to
`Input/ore_schedule.xml` is required.

``` xml
  <Analytics>
    <Analytic type="imschedule">
      <Parameter name="active">Y</Parameter>
      <Parameter name="crif">crif_schedule.csv</Parameter>
      <Parameter name="calculationCurrency">USD</Parameter>
    </Analytic>
  </Analytics>
```

### Dynamic Initial Margin and MVA

This example (`python run_dim.py`) demonstrates Dynamic Initial Margin
calculations (see also ) for a number of basic products:

- A single currency Swap in EUR (case A),

- a European Swaption in EUR with physical delivery (case B),

- a single currency Swap in USD (case C),

- a EUR/USD cross currency Swap (case D),

- a EUR/USD FX Option (case E).

The essential results of each run are visualised in the form of

- evolution of expected DIM which feeds into the MVA calculation

- regression plots at selected future times

illustrated for cases A, B and E in figures
<a href="#fig_ex13a_evolution" data-reference-type="ref"
data-reference="fig_ex13a_evolution">1</a> -
<a href="#fig_ex13c_evolution" data-reference-type="ref"
data-reference="fig_ex13c_evolution">5</a>.

<figure id="fig_ex13a_evolution">
<div class="center">
<embed src="examples/mpl_dim_evolution_A_swap_eur.pdf" />
</div>
<figcaption>Evolution of expected Dynamic Initial Margin (DIM) for the
EUR Swap of Example 13 A. Regression DIM is evaluated using regression
of NPV change variances versus the simulated 3M Euribor fixing;
regression polynomials are zero, first and second order (first and
second order curves are not noticebly different in this case). The
simulation uses 1000 samples and a time grid with bi-weekly steps in
line with the Margin Period of Risk.</figcaption>
</figure>

<figure id="fig_ex13a_regression">
<div class="center">
<embed src="examples/mpl_dim_regression_A_swap_eur.pdf" />
</div>
<figcaption>Regression snapshot at time step 100 for the EUR Swap of
Example 13 A.</figcaption>
</figure>

The DIM evolution graphs compare a subset of the following Initial
Margin projection methods in ORE

- Simple: 99% quantile of NPV changes ($\Delta$) over the Margin Period
  of Risk across all paths, i.e. same IM applied across paths

- Zero Order “Regression”: Standard deviation of $\Delta$s scaled to the
  99% quantile with factor 2.33 (normal distribution assumption); same
  IM applied across paths

- First/Second Order Regression: Conditional standard deviation of
  $\Delta$ computed by polynomial first/second order regression of
  $\Delta$ variances, scaled to the 99% quantile as avove; different IM
  amounts applied across paths, graphs show the expected DIM i.e.
  avergae across paths

- Dynamic Delta VaR: 99% quantile VaR based on analytic deltas and vegas
  computed under scenarios; different IM amounts applied across paths,
  graphs show the expected DIM i.e. average across paths

For a discussion of the regression model performance see . The cases A–E
are associated with various ORE master input files `Input/ore_A*.xml`,
`Input/ore_B*.xml`, ..., which demonstrate the required simulation and
xva analytic configurations.

<figure id="fig_ex13b_evolution">
<div class="center">
<embed src="examples/mpl_dim_evolution_B_swaption_eur.pdf" />
</div>
<figcaption>Evolution of expected Dynamic Initial Margin (DIM) for the
EUR Swaption of Example 13 B with expiry in 10Y around time step
100.</figcaption>
</figure>

<figure id="fig_ex13b_regression">
<div class="center">
<embed src="examples/mpl_dim_regression_B_swaption_eur_t100.pdf" />
</div>
<figcaption>Regression snapshot at time step 100 (before expiry) for the
EUR Swaption of Example 13 B.</figcaption>
</figure>

<figure id="fig_ex13c_evolution">
<div class="center">
<embed src="examples/mpl_dim_evolution_E_fxopt.pdf" />
</div>
<figcaption>Evolution of expected Dynamic Initial Margin (DIM) for the
EUR/USD FX Option of Example 13 (case E) with expiry in 10Y around time
step 100.</figcaption>
</figure>

### Dynamic SIMM

The batch kicked off with (`python run_dim2.py`) demonstrates a
prototype “Dynamic SIMM” implementation, see Input/Dim2/ore_amccg.xml
with

<div class="listing">

``` xml
    <Analytic type="xva">
      ...
      <Parameter name="dimModel">DynamicIM</Parameter>
      ...
    </Analytic>
```

</div>

and several related new parameters in the `simulation` section. The new
method is embedded into AMC simulation and uses Algorithmic
Differentiation to generate sensitivities along paths which feed into
the dynamic SIMM calculation. Results are – among others – a
`dim_evolution.csv` report and a new `dim_distribution.csv` report in
Output/Dim2/AmcCg.

To validate the new method we apply the “conventional” SIMM calculator
in ORE that we have enhanced with a CRIF generator limited to IR/FX
risks for this purpose. The `run_dim2.py` script simulates a few paths,
picks one of the paths and extracts the simulated market data (discount
and index curves, FX rates, swaption volatilities) and writes them to
`Input/DimValidation/marketdata.csv`, a market data file in ORE format,
and likewise simulated fixings to `Input/DimValidation/fixings.csv`. The
script then loops over simulation dates of that single path and performs
a conventional SIMM run for each date (see
`Input/DimValidation/ore_simm.xml`). This is used to check the new
method’s output on individual paths: When switching off model
calibration and setting model vols close to zero in
`Input/Dim2/simulation.xml` and `Input/Dim2/simulation_amccg.xml`, then
we basically “roll down the forward curve”, and both calculations should
yield the same result. Figure
<a href="#fig_dim2_comparison_1" data-reference-type="ref"
data-reference="fig_dim2_comparison_1">6</a> shows the comparison and
expected outcome.

<figure id="fig_dim2_comparison_1">
<div class="center">
<embed src="examples/mpl_dim_comparison_1.pdf" />
</div>
<figcaption>Evolution of SIMM vs Expected Dynamic Initial Margin (DIM)
for a Euribor and SOFR-3M Swap, simulation with zero volatility, single
path in case of the SIMM benchmark, 10k paths in case of
DIM.</figcaption>
</figure>

Next, we use a model with non-zero vols, i.e. re-activate calibration in
`Input/Dim2/simulation.xml` and `Input/Dim2/simulation_amccg.xml`.
Running another script (`python run_dim2_cube.py`) we now generate a few
SIMM benchmark paths and compare to the expected DIM from 10k paths, see
Figure <a href="#fig_dim2_comparison_3" data-reference-type="ref"
data-reference="fig_dim2_comparison_3">7</a>

<figure id="fig_dim2_comparison_3">
<div class="center">
<embed src="examples/mpl_dim_comparison_3.pdf" />
</div>
<figcaption>Evolution of SIMM vs Expected Dynamic Initial Margin (DIM)
for a Euribor and SOFR-3M Swap; simulation with non-zero volatility,
three paths in case of the SIMM benchmark, 10k paths in case of
DIM.</figcaption>
</figure>

Preliminary note on performance:

- The script takes about one minute to generate the benchmark SIMM
  evolution on a single path with 120 time steps for the example above

- Dynamic SIMM takes about 2 minutes for the expectation across 10k
  paths, on the same hardware (single core, Macbook Pro M2 Max), a
  speedup factor of 5000 compared to the pedestrian benchmark

We now zoom in on four future time points (1M, 1Y, 4Y, 8Y) and
illustrate the SIMM distribution from the new report
`dim_distribution.csv`. To benchmark the distributions we re-run
`python run_dim2_cube.py` again, but with number of paths increased to
1000 and time steps reduced to the four dates we want to analyse, i.e.
changing Input/Dim2/simulation.xml accordingly. This generates an
updated output in Output/DimValidation/simm_cube.csv. Running the script
`python plot_dim_distribution.py` then generates the comparison in
Figure <a href="#fig_dim2_distributions" data-reference-type="ref"
data-reference="fig_dim2_distributions">8</a>. Note that the Dynamic
SIMM calculation takes a few seconds with 10k paths and a handful of
time points, while the brute force benchmark calculation crunches 1k
paths on four dates in about half an hour.

<figure id="fig_dim2_distributions">
<div class="center">
<embed src="examples/mpl_simm_distribution.pdf" />
</div>
<figcaption>SIMM distribution from Dynamic SIMM (lines) vs benchmark
(histograms) at time points 1M, 1Y, 4Y, 8Y from as of date.</figcaption>
</figure>

Further investigation of this new Dynamic SIMM method is work in
progress:

- path-wise benchmarking

- more products - FX Options, Swaptions, FX TaRF as a complex scripted
  example

- investigation of alternative regression methods in AMC and their
  impact on quality of AAD sensitivities

- comparison to the simple regression DIM model of section
  <a href="#example:initialmargin_dim" data-reference-type="ref"
  data-reference="example:initialmargin_dim">1.7.2</a>

## Exposure

This section demonstrates exposure simulation and CVA for
uncollateralised single trades across ORE’s product range, mostly
vanilla products.

The examples can be run individually (see below) or all together with
`python run.py`.

- Swap with flat yield curve: `python run_swapflat.py`

- Swap with normal yield curves: `python run_swap.py`

- Swap with normal yield curves in HW2F: `python run_swap_hw2f.py`

- FRA: `python run_fra.py`

- European/American/Bermudan Swation and CallableSwap:
  `python run_swaption.py`

- Caps/Floors: `python run_capfloor.py`

- FX Forward and FX Option: `python run_fx.py`

- Resetting and Non-Resetting Cross Currency Swaps: `python run_ccs.py`

- Equity Forwards and Option: `python run_equity.py`

- Commodity Forward, Option, Swaption, APO: `python run_commodity.py`

- Inflation CPI and YOY Swap, the simulation is run twice using a
  Dodgson-Kainth and Jarrow-Yildirim model: `python run_inflation.py`

- Credit Default Swap: `python run_credit.py`

Somewhat more complex single-trade examples:

- Capped/Floored CMS Spread, Digital CMS Spread: `python run_cmsspread`

- Capped CMS Spread and Digital CMS Spread with formula-based payoff
  (slow): `python run_fbc.py`

Further exposure simulation features:

- Long-term simulation with and without horizon shift in the Linear
  Gauss Markov model: `python run_longterm.py`

- Simulation in different measures: `python run_measures.py`

- Simulation in the two-factor Hull-White model, calibrated to
  historical and risk neutral volatilities: `python run_hw2f.py`

- Wrong-Way-Risk: `python run_wwr.py`

- Flip View, switch perspectives easily for XVA:
  `python run_flipview.py`

Parameter calibration for exposure simulation model:

- HW n-factor historical calibration:
  `python run_hwhistoricalcalibration.py`

All cases are discussed in the following subsections.

### Swap with flat yield curve

We start with a vanilla single currency Swap (currency EUR, maturity
20y, notional 10m, receive fixed 2% annual, pay 6M-Euribor flat). The
market yield curves (for both discounting and forward projection) are
set to be flat at 2% for all maturities, i.e. the Swap is at the money
initially and remains at the money on average throughout its life.
Running ORE in directory `Examples/Exposure` with

`python run_swapflat.py `

yields the exposure evolution in

`Examples/swapflat/Output/*.pdf `

and shown in figure
<a href="#fig_1" data-reference-type="ref" data-reference="fig_1">9</a>.

<figure id="fig_1">
<div class="center">
<embed src="examples/mpl_swap_1_1m_sbb_10k_flat.pdf" />
</div>
<figcaption>Vanilla ATM Swap expected exposure in a flat market
environment from both parties’ perspectives. The symbols are European
Swaption prices. The simulation was run with monthly time steps and
10,000 Monte Carlo samples to demonstrate the convergence of EPE and ENE
profiles. A similar outcome can be obtained more quickly with 5,000
samples on a quarterly time grid which is the default setting of
Example_1. </figcaption>
</figure>

Both Swap simulation and Swaption pricing are run with calls to the ORE
executable, essentially

`ore[.exe] ore.xml`

`ore[.exe] ore_swaption.xml`

which are wrapped into the script `Examples/Exposure/run_swapflat.py`
provided with the ORE release. It is instructive to look into the input
folder in Examples/Exposure/Output/swapflat, the content of the main
input file ` ore.xml`, together with the explanations in section
<a href="#sec:configuration" data-reference-type="ref"
data-reference="sec:configuration">[sec:configuration]</a>.  
This simple example is an important test case which is also run
similarly in one of the unit test suites of ORE. The expected exposure
can be seen as a European option on the underlying netting set, see also
. In this example, the expected exposure at some future point in time,
say 10 years, is equal to the European Swaption price for an option with
expiry in 10 years, underlying Swap start in 10 years and underlying
Swap maturity in 20 years. We can easily compute such standard European
Swaption prices for all future points in time where both Swap legs
reset, i.e. annually in this case[^1]. And if the simulation model has
been calibrated to the points on the Swaption surface which are used for
European Swaption pricing, then we can expect to see that the simulated
exposure matches Swaption prices at these annual points, as in figure
<a href="#fig_1" data-reference-type="ref" data-reference="fig_1">9</a>.
In Example_1 we used co-terminal ATM Swaptions for both model
calibration and Swaption pricing. Moreover, as the yield curve is flat
in this example, the exposures from both parties’ perspectives (EPE and
ENE) match not only at the annual resets, but also for the period
between annual reset of both legs to the point in time when the floating
leg resets. Thereafter, between floating leg (only) reset and next joint
fixed/floating leg reset, we see and expect a deviation of the two
exposure profiles.

### Swap with normal yield curves

Moving to the next case we see what changes when using a realistic
(non-flat) market environment. Running the example with

`python run_swap.py `

yields the exposure evolution in

`Examples/Exposure/Output/swap/*.pdf `

shown in figure
<a href="#fig_2" data-reference-type="ref" data-reference="fig_2">10</a>.

<figure id="fig_2">
<div class="center">
<embed src="examples/mpl_swap_3.pdf" />
</div>
<figcaption>Vanilla ATM Swap expected exposure in a realistic market
environment as of 05/02/2016 from both parties’ perspectives. The Swap
is the same as in figure <a href="#fig_1" data-reference-type="ref"
data-reference="fig_1">9</a> but receiving fixed 1%, roughly at the
money. The symbols are the prices of European payer and receiver
Swaptions. Simulation with 5000 paths and monthly time
steps.</figcaption>
</figure>

In this case, where the curves (discount and forward) are upward
sloping, the receiver Swap is at the money at inception only and moves
(on average) out of the money during its life. Similarly, the Swap moves
into the money from the counterparty’s perspective. Hence the expected
exposure evolutions from our perspective (EPE) and the counterparty’s
perspective (ENE) ’detach’ here, while both can still be be reconciled
with payer or respectively receiver Swaption prices.

### Forward Rate Agreement

The example in `run_fra.py` demonstrates pricing, cash flow projection
and exposure simulation for two additional products

- Forward Rate Agreements

- Averaging Overnight Index Swaps

using a minimal portfolio of four trades, one FRA and three OIS. The
essential results are in `npv.csv`, `flows.csv` and four
`exposure_trade_*.csv` files in folder `Examples/Exposure/Output/fra`.

### Swaptions

The batch in `python run_swaption.py` covers three cases

- European Swaptions with cash and physical settlement, compared to the
  underlying Forward Swap, see figure
  <a href="#fig_3" data-reference-type="ref" data-reference="fig_3">11</a>:  
  The delivery type (cash vs physical) yields significantly different
  valuations as of today due to the steepness of the relevant yield
  curves (EUR). The cash settled Swaption’s exposure graph is truncated
  at the exercise date, whereas the physically settled Swaption exposure
  turns into a Swap-like exposure after expiry. For comparison, the
  example also provides the exposure evolution of the underlying forward
  starting Swap which yields a somewhat higher exposure after the
  forward start date than the physically settled Swaption. This is due
  to scenarios with negative Swap NPV at expiry (hence not exercised)
  and positive NPVs thereafter. Note the reduced EPE in case of a
  Swaption with settlement of the option premium on exercise date.

- Bermudan and American Swaption, see figure
  <a href="#fig_3b" data-reference-type="ref"
  data-reference="fig_3b">12</a>:  
  The underlying Swap is the same as in the European Swaption example
  above. Note in particular the difference between the Bermudan and
  European Swaption exposures with cash settlement: The Bermudan shows
  the typical step-wise decrease due to the series of exercise dates.
  Also note that we are using the same Bermudan option pricing engines
  for both settlement types, in contrast to the European case, so that
  the Bermudan option cash and physical exposures are identical up to
  the first exercise date. When running this example, you will notice
  the significant difference in computation time compared to the
  European case (ballpark 30 minutes here for 2 Swaptions, 1000 samples,
  90 time steps). The Bermudan example takes significantly more
  computation time because we use an LGM grid engine for pricing under
  scenarios in this case. In a realistic context one would more likely
  resort to American Monte Carlo simulation, feasible in ORE, but not
  provided in the current release. However, this implementation can be
  used to benchmark any faster / more sophisticated approach to Bermudan
  Swaption exposure simulation.

- European Callable Swap, represented as two trades – the non-callable
  Swap and a Swaption with physical delivery. We have sold the call
  option, i.e. the Swaption is a right for the counterparty to enter
  into an offsetting Swap which economically terminates all future flows
  if exercised. The resulting exposure evolutions for the individual
  components (Swap, Swaption), as well as the callable Swap are shown in
  figure
  <a href="#fig_4" data-reference-type="ref" data-reference="fig_4">13</a>.
  The example is an extreme case where the underlying Swap is deeply in
  the money (receiving fixed 5%), and hence the call exercise
  probability is close to one. Modify the Swap and Swaption fixed rates
  closer to the money ($\approx$ 1%) to see the deviation between net
  exposure of the callable Swap and the exposure of a ’short’ Swap with
  maturity on exercise. We have added more recently the combined
  CallableSwap instrument representation, check `portfolio.xml` and
  compare the CallableSwap NPV in `npv.csv` to the package NPV of Swap
  and Swaption.

<figure id="fig_3">
<div class="center">
<embed src="examples/mpl_swaption.pdf" />
</div>
<figcaption>European Swaption exposure evolution, expiry in 10 years,
final maturity in 20 years, for cash and physical delivery. Simulation
with 1000 paths and quarterly time steps. </figcaption>
</figure>

<figure id="fig_3b">
<div class="center">
<embed src="examples/mpl_bermudan_swaption.pdf" />
</div>
<figcaption>Bermudan Swaption exposure evolution, 5 annual exercise
dates starting in 10 years, final maturity in 20 years, for cash and
physical delivery. Simulation with 1000 paths and quarterly time
steps.</figcaption>
</figure>

<figure id="fig_4">
<div class="center">
<embed src="examples/mpl_callable_swap.pdf" />
</div>
<figcaption>European callable Swap represented as a package consisting
of non-callable Swap and Swaption. The Swaption has physical delivery
and offsets all future Swap cash flows if exercised. The exposure
evolution of the package is shown here as ’EPE Netting Set’ (green
line). This is covered by the pink line, the exposure evolution of the
same Swap but with maturity on the exercise date. The graphs match
perfectly here, because the example Swap is deep in the money and
exercise probability is close to one. Simulation with 5000 paths and
quarterly time steps.</figcaption>
</figure>

### Cap/Floor

The example `python run_capfloor.py` generates exposure evolutions of
several Swaps, Caps and Floors. The example shown in figure
<a href="#fig_capfloor_1" data-reference-type="ref"
data-reference="fig_capfloor_1">14</a> (’portfolio 1’) consists of a 20y
Swap receiving 3% fixed and paying Euribor 6M plus a long 20y Collar
with both cap and floor at 4% so that the net exposure corresponds to a
Swap paying 1% fixed.  

<figure id="fig_capfloor_1">
<div class="center">
<embed src="examples/mpl_capfloor_1.pdf" />
</div>
<figcaption>Swap+Collar, portfolio 1. The Collar has identical cap and
floor rates at 4% so that it corresponds to a fixed leg which reduces
the exposure of the Swap, which receives 3% fixed. Simulation with 1000
paths and quarterly time steps.</figcaption>
</figure>

The second example in this folder shown in figure
<a href="#fig_capfloor_2" data-reference-type="ref"
data-reference="fig_capfloor_2">15</a> (’portfolio 2’) consists of a
short Cap, long Floor and a long Collar that exactly offsets the netted
Cap and Floor.

<figure id="fig_capfloor_2">
<div class="center">
<embed src="examples/mpl_capfloor_2.pdf" />
</div>
<figcaption>Short Cap and long Floor vs long Collar, portfolio 2.
Simulation with 1000 paths and quarterly time steps.</figcaption>
</figure>

Further three test portfolios are provided as part of this example. Run
the example and inspect the respective output directories
`Examples/Exposure/Output/capfloor/portfolio_#`.

### FX Forward and FX Option

Example `python run_fx.py` generates the exposure evolution for a EUR /
USD FX Forward transaction with value date in 10Y. This is a
particularly simple show case because of the single cash flow in 10Y. On
the other hand it checks the cross currency model implementation by
means of comparison to analytic limits - EPE and ENE at the trade’s
value date must match corresponding Vanilla FX Option prices, as shown
in figure
<a href="#fig_5" data-reference-type="ref" data-reference="fig_5">16</a>.

<figure id="fig_5">
<div class="center">
<embed src="examples/mpl_fxforward.pdf" />
</div>
<figcaption>EUR/USD FX Forward expected exposure in a realistic market
environment as of 26/02/2016 from both parties’ perspectives. Value date
is obviously in 10Y. The flat lines are FX Option prices which coincide
with EPE and ENE, respectively, on the value date. Simulation with 5000
paths and quarterly time steps.</figcaption>
</figure>

The same batch illustrates the exposure evolution for an FX Option, see
figure
<a href="#fig_7" data-reference-type="ref" data-reference="fig_7">17</a>.

<figure id="fig_7">
<div class="center">
<embed src="examples/mpl_fxoption.pdf" />
</div>
<figcaption>EUR/USD FX Call and Put Option exposure evolution, same
underlying and market data as above, compared to the call and put option
price as of today (flat line). Simulation with 5000 paths and quarterly
time steps.</figcaption>
</figure>

Recall that the FX Option value $NPV(t)$ as of time $0 \leq t \leq T$
satisfies $$\begin{aligned}
\frac{NPV(t)}{N(t)} &= \mbox{Nominal}\times\E_t\left[\frac{(X(T) - K)^+}{N(T)}\right]\\
NPV(0) &= \E\left[\frac{NPV(t)}{N(t)}\right] = \E\left[\frac{NPV^+(t)}{N(t)} \right]= \EPE(t)
\end{aligned}$$ where $N(t)$ denotes the numeraire asset. One would
therefore expect a flat exposure evolution up to option expiry. The
deviation from this in ORE’s simulation is due to the pricing approach
chosen here under scenarios. A Black FX option pricer is used with
deterministic Black volatility derived from today’s volatility structure
(pushed or rolled forward, see section
<a href="#sec:sim_market" data-reference-type="ref"
data-reference="sec:sim_market">[sec:sim_market]</a>). The deviation can
be removed by extending the volatility modelling, e.g. implying model
consistent Black volatilities in each simulation step on each path.

### Non-Resetting and Resetting Cross Currency Swaps

Batch `run_ccs.py` demonstrates a vanilla non-resetting cross currency
Swap exposure. It shows the typical blend of an Interest Rate Swap’s saw
tooth exposure evolution with an FX Forward’s exposure which increases
monotonically to final maturity, see figure
<a href="#fig_6" data-reference-type="ref" data-reference="fig_6">18</a>.

<figure id="fig_6">
<div class="center">
<embed src="examples/mpl_ccswap.pdf" />
</div>
<figcaption>Cross Currency Swap exposure evolution without
mark-to-market notional reset. Simulation with 1000 paths and quarterly
time steps.</figcaption>
</figure>

This run also demonstrates the “serialization” of the calibrated
simulation model, see `Output/swaption/calibration.xml` and
`Output/swaption/calibration.csv`, as well as the brief documentation of
the `calibration` analytic in section
<a href="#sec:analytics" data-reference-type="ref"
data-reference="sec:analytics">[sec:analytics]</a>.

Finally, the effect of the FX resetting feature, common in Cross
Currency Swaps nowadays, is also demonstrated here using a separate
instrument (see `portfolio_ccs.xml`). The example shows the exposure
evolution of a EUR/USD cross currency basis Swap with FX reset at each
interest period start, see figure
<a href="#fig_6b" data-reference-type="ref"
data-reference="fig_6b">19</a>. As expected, the notional reset causes
an exposure collapse at each period start when the EUR leg’s notional is
reset to match the USD notional.

<figure id="fig_6b">
<div class="center">
<embed src="examples/mpl_xccy_reset.pdf" />
</div>
<figcaption>Cross Currency Basis Swap exposure evolution with and
without mark-to-market notional reset. Simulation with 1000 paths and
quarterly time steps.</figcaption>
</figure>

### Equity Derivatives

This example in `python run_equity.py` demonstrates the computation of
NPV, sensitivities, exposures and XVA for a portfolio of OTC equity
derivatives. The portfolio used in this example consists of:

- an equity call option denominated in EUR (“Luft”)

- an equity put option denominated in EUR (“Luft”)

- an equity forward denominated in EUR (“Luft”)

- an equity call option denominated in USD (“SP5”)

- an equity put option denominated in USD (“SP5”)

- an equity forward denominated in USD (“SP5”)

- an equity Swap in USD with return type “price” (“SP5”)

- an equity Swap in USD with return type “total” (“SP5”)

The step-by-step procedure for running ORE is identical for equities as
for other asset classes; the same market and portfolio data files are
used to store the equity market data and trade details, respectively.
For the exposure simulation, the calibration parameters for the equity
risk factors can be set in the usual `simulation.xml` file.

Looking at the MtM results in the output file `npv.csv` we observe that
put-call parity ($V_{Fwd} = V_{Call} -
V_{Put}$) is observed as expected. Looking at Figure
<a href="#fig_eq_call" data-reference-type="ref"
data-reference="fig_eq_call">20</a> we observe that the Expected
Exposure profile of the equity call option trade is relatively smooth
over time, while for the equity forward trade the Expected Exposure
tends to increase as we approach maturity. This behaviour is similar to
what we observe in section
<a href="#example:exposure_fx" data-reference-type="ref"
data-reference="example:exposure_fx">1.8.6</a>.

<figure id="fig_eq_call">
<div class="center">
<embed src="examples/mpl_eq_call.pdf" />
</div>
<figcaption>Equity (“Luft”) call option and OTC forward exposure
evolution, maturity in approximately 2.5 years. Simulation with 10000
paths and quarterly time steps.</figcaption>
</figure>

### Commodity Derivatives

Calling

`python run_commodity.py`

demonstrates pricing and exposure simulation for a portfolio including a

- Commodity Forward

- Commodity Swap

- European Commodity Option

- Commodity Average Price Option

- Commodity Swaption

with the usual results, exposure reports and graphs.

### Inflation CPI and YOY Swap - TODO

The example called with `python run_inflation.py` runs two exposure
simulation batches for CPI and YOY Inflation Swaps

- using the Dodgson-Kainth (DK) inflation model

- using the Jarrow-Yildirim (JY) inflation model

We use the same portfolio in both batches that comprises four trades

- EU and UK CPI Swaps

- EU and UK YOY Swaps

Figures <a href="#fig_inflation_dk" data-reference-type="ref"
data-reference="fig_inflation_dk">21</a> and
<a href="#fig_inflation_jy" data-reference-type="ref"
data-reference="fig_inflation_jy">22</a> show the exposure (EPE) graphs
for all trades.

<figure id="fig_inflation_dk">
<div class="center">
<embed src="examples/mpl_exposure_inflation_dk.pdf" />
</div>
<figcaption>CPI and YOY exposure evolution using the Dodgson-Kainth
model.</figcaption>
</figure>

<figure id="fig_inflation_jy">
<div class="center">
<embed src="examples/mpl_exposure_inflation_jy.pdf" />
</div>
<figcaption>CPI and YOY exposure evolution using the Jarrow-Yildirim
model.</figcaption>
</figure>

TODO: Discuss differences, check model calibrations

### Credit Default Swap

Calling

`python run_credit.py `

runs the credit variant of the Swap exposure in
<a href="#example:exposure_swapflat" data-reference-type="ref"
data-reference="example:exposure_swapflat">1.8.1</a>. Running ORE here
yields the exposure evolution shown in figure
<a href="#fig_33" data-reference-type="ref"
data-reference="fig_33">23</a>.

<figure id="fig_33">
<div class="center">
<embed src="examples/mpl_cds_33_2w_10k.pdf" />
</div>
<figcaption>Credit Default Swap expected exposure in a flat market
environment from both parties’ perspectives. The symbols are CDS Option
prices. The simulation was run with bi-weekly time steps and 10,000
Monte Carlo samples to demonstrate the convergence of EPE and ENE
profiles. A similar outcome can be obtained more quickly with 5,000
samples on a monthly time grid which is the default setting here.
</figcaption>
</figure>

Both CDS simulation and CDS Option pricing are run with calls to the ORE
executable, essentially

`ore[.exe] ore_credit.xml`

`ore[.exe] ore_creditoptions.xml`

which are wrapped into the script `Examples/Eposure/run_credit.py`
provided with the ORE release.

This example demonstrates credit simulation using the LGM model and the
calculation of Wrong Way Risk due to credit correlation between the
underlying entity of the CDS and the counterparty of the CDS trade via
dynamic credit. Positive correlation between the two names weakens the
protection of the CDS whilst negative correlation strengthens the
protection.

The following table lists the XVA result from the example at different
levels of correlation.

<div class="center">

| Correlation | NettingSetId |    CVA |   DVA | FBA |    FCA |
|------------:|:-------------|-------:|------:|----:|-------:|
|       -100% | CPTY_B       | -2,638 | 2,906 | 486 | -1,057 |
|        -90% | CPTY_B       | -2,204 | 2,906 | 488 | -1,053 |
|        -50% | CPTY_B       |   -485 | 2,906 | 493 | -1,040 |
|        -40% | CPTY_B       |    -60 | 2,906 | 495 | -1,037 |
|        -30% | CPTY_B       |    363 | 2,906 | 496 | -1,033 |
|        -20% | CPTY_B       |    784 | 2,906 | 498 | -1,030 |
|        -10% | CPTY_B       |  1,204 | 2,906 | 500 | -1,027 |
|          0% | CPTY_B       |  1,621 | 2,906 | 501 | -1,023 |
|         10% | CPTY_B       |  2,036 | 2,906 | 503 | -1,020 |
|         20% | CPTY_B       |  2,450 | 2,906 | 504 | -1,017 |
|         30% | CPTY_B       |  2,861 | 2,906 | 506 | -1,013 |
|         40% | CPTY_B       |  3,271 | 2,906 | 507 | -1,010 |
|         50% | CPTY_B       |  3,679 | 2,906 | 509 | -1,017 |
|         90% | CPTY_B       |  5,290 | 2,906 | 515 |   -994 |
|        100% | CPTY_B       |  5,689 | 2,906 | 517 |   -991 |

CDS XVA results with LGM model

</div>

### Capped/Floored (Digital) CMS Spread

Calling

`python run_cmsspread.py `

runs pricing and exosure simulation for

- Capped/Floored CMS Spreads

- CMS Spreads with Digital Caps/Floors

Results are found in folder `Examples/Exposure/Output/cmsspread/*` and
exposure graphs in `Examples/Exposure/Output/mpl_cmsspread.pdf`.

### Capped (Digital) CMS Spread with Formula-based Payoff

Calling

`python run_fbc.py `

runs pricing, exosure simulation and XVA for Swaps with CMS Spread and
Digital CMS Spread legs using both formula-based payoff and “classic”
ORE XML. The example portfolio also includes a Bond with formula-based
payoff. Results are found in folder `Examples/Exposure/Output/fbc/*`

The formula-based leg can be seen as a predecessor of the more versatile
scripted trade framework. However, the formula leg may be used to apply
a multi-factor Log-normal Swap Rate model instead of the Gaussian
interest rate models currently applied in the scripted trade framework.

### Long-term simulation

Calling

`python run_longterm.py `

demonstrates an effect that, at first glance, seems to cause a serious
issue with long term simulations. Fortunately this can be avoided quite
easily in the Linear Gauss Markov model setting that is used here.  
In the example we consider a Swap with maturity in 50 years in a flat
yield curve environment. If we simulate this naively as in all previous
cases, we obtain a particularly noisy EPE profile that does not nearly
reconcile with the known exposure (analytical Swaption prices). This is
shown in figure <a href="#fig_15" data-reference-type="ref"
data-reference="fig_15">24</a> (‘no horizon shift’). The origin of this
issue is the width of the risk-neutral NPV distribution at long time
horizons which can turn out to be quite small so that the Monte Carlo
simulation with finite number of samples does not reach far enough into
the positive or negative NPV range to adequately sample the
distribution, and estimate both EPE and ENE in a single run. Increasing
the number of samples may not solve the problem, and may not even be
feasible in a realistic setting.  
The way out is applying a ‘shift transformation’ to the Linear Gauss
Markov model, see ` Exposure/Input/simulation_longterm_2.xml` in lines
92-95:

<div class="listing">

``` xml
        <ParameterTransformation>
          <ShiftHorizon>30.0</ShiftHorizon>
          <Scaling>1.0</Scaling>
        </ParameterTransformation>
```

</div>

The effect of the ’ShiftHorizon’ parameter $T$ is to apply a shift to
the Linear Gauss Markov model’s $H(t)$ parameter (see ) *after* the
model has been calibrated, i.e. to replace:
$$H(t) \rightarrow H(t) - H(T)$$ It can be shown that this leaves all
expectations computed in the model (such as EPE and ENE) invariant. As
explained in , subtracting an $H$ shift effectively means performing a
change of measure from the ‘native’ LGM measure to a T-Forward measure
with horizon $T$, here 30 years. Both negative and positive shifts are
permissible, but only negative shifts are connected with a T-Forward
measure and improve numerical stability.  
In our experience it is helpful to place the horizon in the middle of
the portfolio duration to significantly improve the quality of long term
expectations. The effect of this change (only) is shown in the same
figure <a href="#fig_15" data-reference-type="ref"
data-reference="fig_15">24</a> (‘shifted horizon’).

<figure id="fig_15">
<div class="center">
<embed src="examples/mpl_longterm.pdf" />
</div>
<figcaption>Long term Swap exposure simulation with and without horizon
shift.</figcaption>
</figure>

Figure <a href="#fig_15b" data-reference-type="ref"
data-reference="fig_15b">25</a> further illustrates the origin of the
problem and its resolution: The rate distribution’s mean (without
horizon shift or change of measure) drifts upwards due to convexity
effects (note that the yield curve is flat in this example), and the
distribution’s width is then too narrow at long horizons to yield a
sufficient number of low rate scenarios with contributions to the Swap’s
$\EPE$ (it is a floating rate payer). With the horizon shift (change of
measure), the distribution’s mean is pulled ’back’ at long horizons,
because the convexity effect is effectively wiped out at the chosen
horizon, and the expected rate matches the forward rate.

<figure id="fig_15b">
<div class="center">
<embed src="examples/mpl_rates.pdf" />
</div>
<figcaption>Evolution of rate distributions with and without horizon
shift (change of measure). Thick lines indicate mean values, thin lines
are contours of the rate distribution at <span
class="math inline">±</span> one standard deviation.</figcaption>
</figure>

### Choice of Measure

Calling

`python run_measures.py `

illustrates the effect of measure changes on simulated expected and peak
exposures. For that purpose we reuse the example in section
<a href="#example:exposure_swapflat" data-reference-type="ref"
data-reference="example:exposure_swapflat">1.8.1</a> (un-collateralized
vanilla swap exposure) and run the simulation three times with different
risk-neutral measures,

- in the LGM measure as in Example 1 (note `<Measure>LGM</Measure>` in
  `simulation_lgm.xml`, this is the default also if the Measure tag is
  omitted)

- in the more common Bank Account measure (note `<Measure>BA</Measure>`
  in `simulation_ba.xml`)

- in the T-Forward measure with horizon T=20 at the Swap maturity (note
  `<Measure>LGM</Measure>` and `<ShiftHorizon>20.0</ShiftHorizon>` in
  `simulation_fwd.xml`)

The results are summarized in the exposure evolution graphs in figure
<a href="#fig:36" data-reference-type="ref"
data-reference="fig:36">26</a>. As expected, the expected exposures
evolutions match across measures, as these are expected discounted NPVs
and hence measure independent. However, peak exposures are dependent on
the measure choice as confirmed graphically here. Many more measures are
accessible with ORE, by way of varying the T-Forward horizon which was
chosen arbitrarily here to match the Swap’s maturity.

<figure id="fig:36">
<div class="center">
<embed src="examples/mpl_exposures_measures.pdf" />
</div>
<figcaption>Evolution of expected exposures (EPE) and peak exposures
(PFE at the 95% quantile) in three measures, LGM, Bank Account,
T-Forward with T=20, with 10k Monte Carlo samples.</figcaption>
</figure>

### Simulation in the two-factor Hull-White model

Calling

`python run_hw2f.py `

kicks off two batches, a first model calibration batch and a second
exposure simulation batch.

The first batch illustrates the model calibration and scenario
generation under a Hull-White multifactor model with output in folder
`Examples/Exposure/Output/hw2f_calibration`. The model is driven by two
independent Brownian motions and has four states. The diffusion matrix
sigma is therefore 2 x 4. The reversion matrix is a 4 x 4 diagonal
matrix and entered as an array. Both diffusion and reversion are
constant in time. Their values are not calibrated to the option market,
but hardcoded in simulation.xml.

The values for the diffusion and reversion matrices were fitted to the
first two principal components of a (hypothetical) analysis of absolute
rate curve movements. These input principal components can be found in
inputeigenvectors.csv in the input folder. The tenor is given in years,
and the two components are given as column vectors, see table
<a href="#tab:ex37_1" data-reference-type="ref"
data-reference="tab:ex37_1">4</a>.

<div class="center">

<div id="tab:ex37_1">

| tenor |  eigenvector 1 |   eigenvector 2 |
|------:|---------------:|----------------:|
|     1 | 0.353553390593 | -0.537955502871 |
|     2 | 0.353553390593 | -0.374924478795 |
|     3 | 0.353553390593 | -0.252916811525 |
|     5 | 0.353553390593 | -0.087587539893 |
|    10 | 0.353553390593 |   0.12267800393 |
|    15 | 0.353553390593 |  0.240659435416 |
|    20 | 0.353553390593 |  0.339148675322 |
|    30 | 0.353553390593 |  0.552478951238 |

Input principal components

</div>

</div>

The first eigenvector represent perfectly parallel movements. The second
eigenvector represent a rotation around the 7y point of the curve.
Furthermore we prescribe an annual volatility of 0.0070 for the first
components and 0.0030 for the second one. The values can be compared to
normal (bp) volatilities.

We follow chapter 12.1.5 “Multi-Factor Statistical Gaussian Model” to
calibrate the diffusion and reversion matrices to the prescribed
components and volatilities. We do not detail the procedure here and
refer the interested reader to the given reference.

The example generates a single monte carlo path with 5000 daily steps
and outputs the generated scenarios in scenariodump.csv. The python
script pca.py performs a principal component analysis on this output.
The model implied eigenvalues are given in table
<a href="#tab:ex37_2" data-reference-type="ref"
data-reference="tab:ex37_2">5</a>.

<div class="center">

<div id="tab:ex37_2">

| number |                  value |
|-------:|-----------------------:|
|      1 | 4.9144936649319346e-05 |
|      2 |  8.846877641067412e-06 |
|      3 |   5.82566039467854e-10 |
|      4 | 2.1298948225571415e-10 |
|      5 |  9.254913949332787e-11 |
|      6 | 1.0861256211767673e-11 |
|      7 |  8.478795662698618e-14 |
|      8 |   9.74468069377584e-13 |

Input principal components

</div>

</div>

Only the first two values are relevant, the following are all close to
zero. The square root of the first two eigenvalues is given in table
<a href="#tab:ex37_3" data-reference-type="ref"
data-reference="tab:ex37_3">6</a>.

<div class="center">

<div id="tab:ex37_3">

| number |           sqrt(value) |
|-------:|----------------------:|
|      1 |  0.007010344973631422 |
|      2 | 0.0029743701250966414 |

Input principal components

</div>

</div>

matching the prescribed input values of 0.0070 and 0.0030 quite well.
The corresponding eigenvectors are given in etable
<a href="#tab:ex37_4" data-reference-type="ref"
data-reference="tab:ex37_4">7</a>.

<div class="center">

<div id="tab:ex37_4">

| tenor |       eigenvector 1 |        eigenvector 2 |
|------:|--------------------:|---------------------:|
|     1 | 0.34688826736335926 |   0.5441204725042812 |
|     2 |  0.3489303472083185 |    0.380259707350115 |
|     3 |   0.350362134519783 |   0.2581408080614405 |
|     5 |  0.3523983915961889 |  0.09230899007104967 |
|    10 |  0.3550169593982022 | -0.11856777284904292 |
|    15 | 0.35647835947136625 | -0.23676104168229614 |
|    20 |  0.3577146190751303 |  -0.3354486339442275 |
|    30 | 0.36042236352102563 |   -0.549124709243042 |

Input principal components

</div>

</div>

again matching the input principal components quite well. The second
eigenvector is the negative of the input vector here (the principal
component analysis can not distinguish these of course).

The example also produces a plot comparing the input eigenvectors and
the model implied eigenvectors as shown in figure
<a href="#fig:ex37" data-reference-type="ref"
data-reference="fig:ex37">27</a>.

<figure id="fig:ex37">
<div class="center">
<embed src="examples/mpl_eigenvectors_ex37.pdf" />
</div>
<figcaption>Input and model implied eigenvectors for a Hull-White
4-factor model calibrated to 2 principal components of rate curve
movements (parallel + rotation). Notice that the model implied 2nd
eigenvector is the negative of the input vector.</figcaption>
</figure>

The second batch is similar to the Example in section
<a href="#example:exposure_ccs" data-reference-type="ref"
data-reference="example:exposure_ccs">1.8.7</a> (EPE, ENE for a xccy
swap), but uses a multifactor HW model for EUR and USD to generate
scenarios. The parametrization of the HW models is taken from the
previous run, resukts are found in folder
`Examples/Exposure/Output/hw2f`.

Each of the two factors of each HW model is correlated with each of the
two factors of the other currency’s HW model and with the FX factors.
Remember that the factors represent principal components of interest
rate movements and so the correlations can be interpreted as
correlations of these principal components with each other and the fx
rate processes.

### Wrong-Way-Risk

Calling

`python run_wwr.py `

runs an extension of the example in section
<a href="#example:exposure_swapflat" data-reference-type="ref"
data-reference="example:exposure_swapflat">1.8.1</a> (single
uncollateralised Swap) with dynamic credit and non-zero IR-CR
correlation. Results are found in folder `Exposure/Output/wwr`. As we
are paying float, negative correlation implies that we pay more when the
counterparty’s credit worsens, leading to a surge of CVA.

The following table lists the XVA result from the example at different
levels of correlation.

<div class="center">

| Correlation | NettingSetId |     CVA |    DVA |    FBA |    FCA |
|------------:|:-------------|--------:|-------:|-------:|-------:|
|        -30% | CPTY_A       | 105,146 | 68,061 | 31,519 | -4,127 |
|        -20% | CPTY_A       |  88,442 | 68,061 | 30,976 | -4,219 |
|        -10% | CPTY_A       |  71,059 | 68,061 | 30,439 | -4,314 |
|          0% | CPTY_A       |  52,983 | 68,061 | 29,909 | -4,411 |
|         10% | CPTY_A       |  34,199 | 68,061 | 29,386 | -4,511 |
|         20% | CPTY_A       |  14,691 | 68,061 | 28,869 | -4,614 |
|         30% | CPTY_A       |  -5,554 | 68,061 | 28,360 | -4,719 |

IR Swap XVA results with LGM model

</div>

### Flip View

Calling

`python run_flipview.py `

demonstrates how ORE can be used to quickly switch perspectives in XVA
calculations with minimal changes in the `ore.xml` file only. In
particular it avoids manipulating the portfolio input or the netting
set.

### HW n-Factor Historical Calibration

Calling

`python run_hwhistoricalcalibration.py `

demonstrates how ORE provides functionality to calibrate the mean
reversion speed($\kappa$) and volatility($\sigma$) parameters for the
Hull-White $n$-factor model using historical market data. Two approaches
are available:

1.  Full Calibration Using Historical Data

    - ORE performs Principal Component Analysis (PCA) on historical
      interest rate curves and FX spot data.

    - Based on PCA results, ORE will use eigenvalues and eigenvectors to
      calibrate constant parameters for the HW $n$-factor model,
      including $\kappa$ and $\sigma$.

2.  Mean Reversion Calibration Only

    - Users can provide their own eigenvalues and eigenvectors for each
      curve.

    - ORE will then perform mean reversion calibration using these
      inputs without recalculating PCA.

## Netting Set Exposure and Collateral

In this section we demonstrate exposure calculation and XVA at the level
of a small netting set consisting of three Swaps in different
currencies. We ilustrate the effect of several collateral choices on the
resulting exposure.

### MPoR (Biweekly) Grid

Move to folder `Examples/ExposureWithCollateral`. Calling

`python run_biweekly.py `

performs several calculations on a bi-weekly date grid with grid spacing
that matches the Margin Period of Risk (MPoR). The results of the
related ORE runs are found in sub-directories of
`ExposureWithCollateral/Output/` (iah_0, iah_1, nocollateral,
vm_threshold\_\*, vm_mta, vm_mpor)

The effect of the various collateral choices is illustrated in three
plots

- no collateral - figure
  <a href="#fig_8" data-reference-type="ref" data-reference="fig_8">28</a>,

- collateral with threshold (THR) 1m EUR, minimum transfer amount (MTA)
  100k EUR, margin period of risk (MPOR) 2 weeks - figure
  <a href="#fig_9" data-reference-type="ref" data-reference="fig_9">29</a>

- collateral with zero THR and MTA, and MPOR 2w - figure
  <a href="#fig_10" data-reference-type="ref"
  data-reference="fig_10">30</a>

The exposure graphs with collateral and positive margin period of risk
show typical spikes. What is causing these? As sketched in , ORE uses a
*classical collateral model* that applies collateral amounts to offset
exposure with a time delay that corresponds to the margin period of
risk. The spikes are then caused by instrument cash flows falling
between exposure measurement dates $d_1$ and $d_2$ (an MPOR apart), so
that a collateral delivery amount determined at $d_1$ but settled at
$d_2$ differs significantly from the closeout amount at $d_2$ causing a
significant residual exposure for a short period of time. See for
example for a recent detailed discussion of collateral modelling. The
approach currently implemented in ORE corresponds to *Classical+* in ,
the more conservative approach of the classical methods. The less
conservative alternative, *Classical-*, would assume that both parties
stop paying trade flows at the beginning of the MPOR, so that the P&L
over the MPOR does not contain the cash flow effect, and exposure spikes
are avoided. Note that the size and position of the largest spike in
figure
<a href="#fig_9" data-reference-type="ref" data-reference="fig_9">29</a>
is consistent with a cash flow of the 40 million GBP Swap in the
example’s portfolio that rolls over the 3rd of March and has a cash flow
on 3 March 2020, a bit more than four years from the evaluation date.

<figure id="fig_8">
<div class="center">
<embed src="examples/mpl_nocollateral_epe.pdf" />
</div>
<figcaption>Three Swaps netting set, no collateral. Simulation with 5000
paths and bi-weekly time steps.</figcaption>
</figure>

<figure id="fig_9">
<div class="center">
<embed src="examples/mpl_threshold_break_epe.pdf" />
</div>
<figcaption>Three Swaps netting set, THR=1m EUR, MTA=100k EUR, MPOR=2w.
The red evolution assumes that the each trade is terminated at the next
break date. The blue evolution ignores break dates. Simulation with 5000
paths and bi-weekly time steps.</figcaption>
</figure>

<figure id="fig_10">
<div class="center">
<embed src="examples/mpl_mpor_epe.pdf" />
</div>
<figcaption>Three Swaps, THR=MTA=0, MPOR=2w. Simulation with 5000 paths
and bi-weekly time steps.</figcaption>
</figure>

### CVA, DVA, FVA, COLVA, MVA, Collateral Floor

We use one of the cases to demonstrate the XVA outputs, see folder
`Examples/ExposureWithCollateral/Output/vm_threshold_dim`.

The summary of all value adjustments (CVA, DVA, FVA, COLVA, MVA, as well
as the Collateral Floor) is provided in file `xva.csv`. The file
includes the allocated CVA and DVA numbers to individual trades as
introduced in the next section. The following table illustrates the
file’s layout, omitting the three columns containing allocated data.

<div class="center">

</div>

The line(s) with empty TradeId column contain values at netting set
level, the others contain uncollateralised single-trade VAs. Note that
COLVA, MVA and Collateral Floor are only available at netting set level
at which collateral is posted.

Detailed output is written for COLVA and Collateral Floor to file
`colva_nettingset_*.csv` which shows the incremental contributions to
these two VAs through time.

### Exposure Reports & XVA Allocation to Trades

We also illustrate here the layout of an exposure report produced by
ORE. The report shows the exposure evolution of Swap_1 without
collateral which is found in folder  
`Examples/ExposureWithCollateral/Output/nocollateral/exposure_trade_Swap_1.csv`:

<div class="center">

</div>

The exposure measures EPE, ENE and PFE, the Basel exposure measures
$EE_B$ and $EEE_B$, as well as allocated exposures are defined in . The
PFE quantile and allocation method are chosen as described in section
<a href="#sec:analytics" data-reference-type="ref"
data-reference="sec:analytics">[sec:analytics]</a>.  
In addition to single trade exposure files, ORE produces an exposure
file per netting set. The example from the same folder as above is:

<div class="center">

</div>

Allocated exposures are missing here, as they make sense at the trade
level only, and the expected collateral balance is added for information
(in this case zero as collateralisation is deactivated in this example).

The allocation of netting set exposure and XVA to the trade level is
frequently required by finance departments. This allocation is also
featured here. We start again with the uncollateralised case in figure
<a href="#fig_12" data-reference-type="ref"
data-reference="fig_12">31</a>, followed by the case with threshold 1m
EUR in figure <a href="#fig_13" data-reference-type="ref"
data-reference="fig_13">32</a>.

<figure id="fig_12">
<div class="center">
<embed src="examples/mpl_nocollateral_allocated_epe.pdf" />
</div>
<figcaption>Exposure allocation without collateral. Simulation with 5000
paths and bi-weekly time steps.</figcaption>
</figure>

In both cases we apply the *marginal* (Euler) allocation method as
published by Pykhtin and Rosen in 2010, hence we see the typical
negative EPE for one of the trades at times when it reduces the netting
set exposure. The case with collateral moreover shows the typical spikes
in the allocated exposures.

<figure id="fig_13">
<div class="center">
<embed src="examples/mpl_threshold_allocated_epe.pdf" />
</div>
<figcaption>Exposure allocation with collateral and threshold 1m EUR.
Simulation with 5000 paths and bi-weekly time steps.</figcaption>
</figure>

The analytics results also feature allocated XVAs in file `xva.csv`
which are derived from the allocated exposure profiles. Note that ORE
also offers alternative allocation methods to the marginal method by
Pykhtin/Rosen, which can be explored by modifying this Example.

### Close-out Grid

So far we have used a “lagged” collateral approach, described at the end
of the collateral section in , to take the Margin Period of Risk into
account in exposure modelling. This used to have the disadvantage in ORE
that we need to use equally-spaced time grids with time steps that match
the MPoR, e.g. 2W, out to final portfolio maturity.

Calling

`python run_closeout.py `

we demonstrate an alternative approach supported by ORE since release 6,
with results in folders `ExposureWithCollateral/Output/closeout_*`. In
this approach we use two nested grids: The (almost) arbitrary main
simulation grid is used to compute “default values” which feed into the
collateral balance $C(t)$ filtered by MTA and Threshold etc; an
auxiliary “close-out” grid, offset from the main grid by the MPoR, is
used to compute the delayed close-out values $V(t)$ associated with time
default time $t$. The difference between $V(t)$ and $C(t)$ causes a
residual exposure $[V(t)-C(t)]^+$ even if minimum transfer amounts and
thresholds are zero.

The close-out date value can be computed in two ways in ORE

- as of default date, by just evolving the market from default date to
  close-out date (“sticky date”), or

- as of close-out date, by evolving both valuation date and market over
  the close-out period (“actual date”), i.e., the portfolio ages and
  cash flows might occur in the close-out period causing spikes in the
  evolution of exposures.

We are reusing one case from Example 10 here, perfect CSA with zero
threshold and minimum transfer amount, so that the remaining exposure is
solely due to the MPoR effect. The portfolio consists of a single
at-the-money Swap in GBP. The relevant configuration changes that
trigger this modelling are in the Parameters section of `simulation.xml`
as shown in Listing
<a href="#lst:close_out_grid" data-reference-type="ref"
data-reference="lst:close_out_grid">[lst:close_out_grid]</a>

<div class="listing">

``` xml
  <Parameters>
    <Grid> ... </Grid>
    <Calendar> ... </Calendar>
    <Sequence> ... </Sequence>
    <Scenario> ... </Scenario>
    <Seed> ... </Seed>
    <Samples> ... </Samples>
    <CloseOutLag> 2W </CloseOutLag>
    <MporMode> StickyDate </MporMode><!-- Alternative: ActualDate -->
  </Parameters>
```

</div>

and moreover in the XVA analytics section of `ore_mpor.xml` as shown in
Listing <a href="#lst:calctype_nolag" data-reference-type="ref"
data-reference="lst:calctype_nolag">[lst:calctype_nolag]</a>.

<div class="listing">

``` xml
  <Analytic type="xva">
    ...
    <Parameter name="calculationType"> NoLag </Parameter>
    ...
  </Parameters>
```

</div>

<figure id="fig_31_a">
<div class="center">
<embed src="examples/mpl_closeout_mpor_epe.pdf" />
</div>
<figcaption>Uncollateralized Swap exposure vs exposure with Variation
Margin, zero threshold and MTA. The simulation uses a variable grid with
an auxiliary grid for closeout value calculation which is offset by the
MPOR.</figcaption>
</figure>

<figure id="fig_31_b">
<div class="center">
<embed src="examples/mpl_closeout_dim_epe.pdf" />
</div>
<figcaption>Comparison of Swap exposure with VM only as above vs VM+IM
using first-order regression.</figcaption>
</figure>

<figure id="fig_31_c">
<div class="center">
<embed src="examples/mpl_closeout_dim_evolution.pdf" />
</div>
<figcaption>Evolution of expected IM from the regression model vs Delta
VaR benchmark.</figcaption>
</figure>

The resulting exposure graphs, with comparison of the uncollateralised
to the collateralised case (with Variation Margin only) is shown in
figure <a href="#fig_31_a" data-reference-type="ref"
data-reference="fig_31_a">33</a>.

In figure <a href="#fig_31_b" data-reference-type="ref"
data-reference="fig_31_b">34</a> we have added Initial Margin based on
ORE’s regression model, and we compare the exposure with VM only to the
exposure with both VM and IM. Figure
<a href="#fig_31_c" data-reference-type="ref"
data-reference="fig_31_c">35</a> shows the related evolution of expected
DIM, benchmarked against the Delta VaR DIM model, used in section
<a href="#example:initialmargin_dim" data-reference-type="ref"
data-reference="example:initialmargin_dim">1.7.2</a> and described in .

### First MPoR Adjustment

Calling

`python run_firstmpor.py`

demonstrates a simple XVA calculation for a Receiver Swap (in netting
set CPTY_A) and a Payer Swap (in netting set CPTY_B) with two initial VM
balances each such that the netting set is fully collateralised resp.
over/under-collateralised.

The new flag firstMporCollateralAdjustment in ore.xml’s XVA section
affects the first MPoR, 2 weeks in the example. If set to true, the
difference between initial collateral balance and mtm is carried over
during the first MPoRr period, if the difference increases our
exposure - a conservative measure.

## Scripted Trade

The scripted trade was added to ORE to gain more flexibility in
representing exotic products, with hybrid payoffs across asset classes,
path-dependence, multiple kinds of early termination options. The
scripted trade module uses Monte Carlo and Finite Difference pricing
approaches, it is an evolving interface to implement parallel processing
with GPUs and a central interface to implement AD methods in ORE. See
the separate documentation in folder Docs/ScriptedTrade for an
introduction to trade representation, scripting language, model and
pricing engine configuration.

The example in this folder `Examples/ScriptedTrade` is a basic
demonstration of ORE’s scripted trade functionality. In this example we
provide a self-contained case that can be run as usual calling

`python run.py`

This generates an NPV and cash flow report for the following portfolio

- Trade 1: Vanilla European Equity Option, represented as standard ORE
  XML with analytical pricing

- Trade 2: Same Option as above, represented as “generic” scripted trade
  with scripted payoff embedded into the trade XML, pricing via Monte
  Carlo

- Trade 3: Same Option as above, same representation, pricing via Finite
  Differences triggered by a `ProductTag` assigned to the script and
  used in `pricingengine.xml`

- Trade 4: Same Option as above, the scripted trade now refers to an
  “external” script in `scriptlibrary.xml`, MC pricing

- Trade 4b: Same as trade 4, but “compact” scripted trade representation
  (uncomment trade 4b in `portfolio.xml`)

- Trade 5: Barrier Option with single continuously observed Up & Out
  barrier, represented as standard ORE XML with analytical pricing

- Trade 6: Same Barrier Option as above, approximated as generic
  scripted trade with daily barrier observation

- Trade 6b: Same Barrier Option as above, approximated as “compact”
  scripted trade with daily barrier observation (uncomment trade 6b in
  `portfolio.xml`)

- Trade 7: Same Barrier Option as above, represented as generic scripted
  trade with continuously observed barrier, i.e. adjusting for the
  probability of knock-out between daily observations

- Trade 7b: Same Barrier Option as of above, represented as “compact”
  scripted trade (uncomment trade 7b in `portfolio.xml`)

- Trade 8: Equity Accumulator, represented as generic scripted trade
  with external payoff script

- Trade 8b: Same Equity Accumulator as above, represented as compact
  scripted trade with external payoff script (uncomment trade 8b in
  `portfolio.xml`)

Note:

- In all cases we use the Black-Scholes model to drive the Equity
  process.

- The Barrier Option pricing using the scripted trade deviates
  noticeably from the analytical pricing when we use daily observations
  (trade 6 and 6b), but matches quite closely when we adjust for the
  probability of knock-out between observation dates (trade 7 and 7b)

- We are not aware of analytical pricing for the Accumulator product in
  trade 8 to benchmark against; trade 8 is priced with MC, FD pricing of
  the Accumulator is possible as well but requires a separate payoff
  script, only in the vanilla European option case we can utilize the
  same script for both MC and FD pricing

Though this initial example shows only single-asset Equity cases, the
scripted trade in its current version is significantly more versatile,
more examples and scripts to follow.

## American Monte Carlo

The cases in this section, folder `AmericanMonteCarlo`, demonstrate how
to use American Monte Carlo Simulation (AMC) to generate exposures in
ORE.

- We start with benchmarking against “classic” exposure simulation, i.e.
  we run both AMC and classic simulation on a small IR/FX portfolio,
  almost vanilla, that consists of a Bermudan Swaption, Single and Cross
  Currency Swaps, FX Swap and FX Option, and we compare the resulting
  AMC vs. classic exposures.  
  Run with `python run_benchmark.py`

- Scripted Bermudan Swaption and LPI Swap: This case shows that the
  scripted trade framework works with AMC too, demonstrated here with a
  scripted Bermudan Swaption and an LPI Swap.  
  Run with: `python run_scriptedberm.py`

- FX TaRF: FxTaRF product is implemented using the scripted trade
  framework “under the hood” with the payoff script embedded into C++,
  so that it is neither explicit in the trade XML nor in the script
  library.  
  Run with: `python run_fxtarf.py`

- Forward Bond with AMC, run with: `python run_forwardbond.py`

- Overlapping Close-Out Grid, run with: `python run_overlapping.py`

- Scenario Statistics, run with: `python run_scenariostatistics.py`

### Benchmarking AMC vs Classic Simulation

This example demonstrates how to use American Monte Carlo simulation
(AMC) to generate exposures in ORE. For a sketch of the methodology and
comments on its implementation in ORE see . Moreover we discuss the
essential configuration changes for applying AMC.

Calling

`python run_benchmark.py`

performs two ORE runs, a ’classical’ exposure simulation and an American
Monte Carlo simulation, both on a quarterly simulation grid and for the
same portfolio consisting of four trades:

- Bermudan swaption

- Single Currency Swap

- Cross Currency Swap

- FX Option

We use a ’flat’ market here (yield curve and Swaption volatility
surface). The number of simulation paths is 2k in the classic
simulations. If not stated otherwise below, the number of training paths
and simulation paths is 10k in the AMC simulations.

In the following we compare the AMC exposure profiles to those produced
by the ’classic’ valuation engine for each trade and the netting set.

Figure <a href="#epe_swaption" data-reference-type="ref"
data-reference="epe_swaption">36</a> shows the EPE and ENE for a
Bermudan Swaption 10y into 10y in (base ccy) EUR with physical
settlement. The classic run uses the LGM grid engine for valuation. We
observe close agreement between the two runs. To achieve the observed
agreement, it is essential to set the LGM model’s mean reversion speed
to zero in both

- the Bermudan Swaption LGM pricing model (see Input/pricingengine.xml),
  and

- the Cross Asset Model’s IR model components (see Input/simulation.xml
  and Input/simulation_amc.xml)

and to use a high order 6 of the regression polynomials (see
Input/pricingengine_amc.xml).

<figure id="epe_swaption">
<embed src="examples/mpl_amc_bermudanswaption.pdf"
style="width:80.0%" />
<figcaption>EPE of a EUR Bermudan Swaption computed with the classic and
AMC valuation engines, using 50k training paths for the AMC
simulation.</figcaption>
</figure>

Figure <a href="#epe_swap" data-reference-type="ref"
data-reference="epe_swap">37</a> shows the EPE and ENE for a 20y vanilla
Swap in USD. The currency of the amc calculator is USD in this case,
i.e. it is different from the base ccy of the simulation (EUR). The
consistency of the classic and amc runs in particular demonstrates the
correct application of the currency conversion factor (see methodology
guide). To get a better accuracy for purposes of the plot in this
document we increased the number of training paths for this example to
50k and the order of the basis functions to 6.

<figure id="epe_swap">
<embed src="examples/mpl_amc_vanillaswap_usd.pdf" style="width:80.0%" />
<figcaption>EPE of a USD swap computed with the classic and AMC
valuation engines</figcaption>
</figure>

Figure <a href="#epe_ccyswap" data-reference-type="ref"
data-reference="epe_ccyswap">38</a> shows the EPE and ENE for a 20y
cross currency Swap EUR-USD.

<figure id="epe_ccyswap">
<embed src="examples/mpl_amc_xccyswap.pdf" style="width:80.0%" />
<figcaption>EPE of a EUR-USD cross currency swap computed with the
classic and AMC valuation engines</figcaption>
</figure>

Figure <a href="#epe_fxoption" data-reference-type="ref"
data-reference="epe_fxoption">39</a> shows the EPE and ENE for a vanilla
FX Option EUR-USD with 10y1m expiry. For the classic run the FX
volatility surface is not implied by the cross asset model but kept
flat, which yields a slight hump in the profile. The AMC profile is flat
on the other hand which demonstrates the consistency of the FX Option
pricing with the risk factor evolution model.

<figure id="epe_fxoption">
<embed src="examples/mpl_amc_fxoption.pdf" style="width:80.0%" />
<figcaption>EPE of a EUR-USD FX option computed with the classic and AMC
valuation engines</figcaption>
</figure>

### Analytic Configuration

To use the AMC engine for an XVA simulation the following needs to be
added to the `simulation` analytic in `ore.xml`:

``` xml
<Analytic type="simulation">
  ...
  <Parameter name="amc">Y</Parameter>
  <Parameter name="amcPricingEnginesFile">pricingengine_amc.xml</Parameter>
  <Parameter name="amcTradeTypes">Swaption</Parameter>
  ...
</Analytic>
```

The trades which have a trade type matching one of the types in the
`amcTradeTypes` list, will be built against the pricing engine config
provided and processed in the AMC engine. As a naming convention,
pricing engines with engine type AMC provide the required functionality
to be processed by the AMC engine, for technical details cf. .

All other trades are processed by the classic simulation engine in ORE.
The resulting cubes from the classic and AMC simulation are joined and
passed to the post processor in the usual way.

Note that since sometimes the AMC pricing engines have a different base
ccy than the risk factor evolution model (see below), a horizon shift
parameter in the simulation set up should be set for all currencies, so
that the shift also applies to these reduced models.

### Pricing Engine Configuration

At this point we assume that the reader is generally familiar with the
configuration section
<a href="#sec:configuration" data-reference-type="ref"
data-reference="sec:configuration">[sec:configuration]</a>, in
particular pricing engine configuration in section in .

The pricing engine configuration is similar for all AMC enabled
products, e.g. for Bermudan Swaptions:

``` xml
<Product type="BermudanSwaption">
  <Model>LGM</Model>
  <ModelParameters/>
  <Engine>AMC</Engine>
  <EngineParameters>
    <Parameter name="Training.Sequence">MersenneTwisterAntithetic</Parameter>
    <Parameter name="Training.Seed">42</Parameter>
    <Parameter name="Training.Samples">50000</Parameter>
    <Parameter name="Training.BasisFunction">Monomial</Parameter>
    <Parameter name="Training.BasisFunctionOrder">6</Parameter>
    <Parameter name="Pricing.Sequence">SobolBrownianBridge</Parameter>
    <Parameter name="Pricing.Seed">17</Parameter>
    <Parameter name="Pricing.Samples">0</Parameter>
    <Parameter name="BrownianBridgeOrdering">Steps</Parameter>
    <Parameter name="SobolDirectionIntegers">JoeKuoD7</Parameter>
    <Parameter name="MinObsDate">true</Parameter>
    <Parameter name="RegressionOnExerciseOnly">false</Parameter>
  </EngineParameters>
</Product>
```

The `Model` differs by product type, table
<a href="#tbl:amcconfig" data-reference-type="ref"
data-reference="tbl:amcconfig">8</a> summarises the supported product
types and model and engine types. The engine parameters are the same for
all products:

1.  `Training.Sequence`: The sequence type for the training phase, can
    be `MersenneTwister`, `MersenneTwisterAntithetc`, `Sobol`,
    `Burley2020Sobol`, `SobolBrownianBridge`,
    `Burley2020SobolBrownianBridge`

2.  `Training.Seed`: The seed for the random number generation in the
    training phase

3.  `Training.Samples`: The number of samples to be used for the
    training phase

4.  `Pricing.Sequence`: The sequence type for the pricing phase, same
    values allowed as for training

5.  `Training.BasisFunction`: The type of basis function system to be
    used for the regression analysis, can be `Monomial`, `Laguerre`,
    `Hermite`, `Hyperbolic`, `Legendre`, `Chbyshev`, `Chebyshev2nd`

6.  `BasisFunctionOrder`: The order of the basis function system to be
    used

7.  `Pricing.Seed`: The seed for the random number generation in the
    pricing

8.  `Pricing.Samples`: The number of samples to be used for the pricing
    phase. If this number is zero, no pricing run is performed, instead
    the (T0) NPV is estimated from the training phase (this result is
    used to fill the T0 slice of the NPV cube)

9.  `BrownianBridgeOrdering`: variate ordering for Brownian bridges, can
    be `Steps`, `Factors`, `Diagonal`

10. `SobolDirectionIntegers`: direction integers for Sobol generator,
    can be `Unit`, `Jaeckel`, `SobolLevitan`, `SobolLevitanLemieux`,
    `JoeKuoD5`, `JoeKuoD6`, `JoeKuoD7`, `Kuo`, `Kuo2`, `Kuo3`

11. `MinObsDate`: if true the conditional expectation of each cashflow
    is taken from the minimum possible observation date (i.e. the latest
    exercise or simulation date before the cashflow’s event date);
    recommended setting is `true`

12. `RegressionOnExerciseOnly`: if true, regression coefficients are
    computed only on exercise dates and extrapolated (flat) to earlier
    exercise dates; only for backwards compatibility to older versions
    of the AMC module, recommended setting is `false`

<div id="tbl:amcconfig">

| Product Type      | Model           | Engine |
|:------------------|:----------------|:-------|
| Swap              | CrossAssetModel | AMC    |
| CrossCurrencySwap | CrossAssetModel | AMC    |
| FxOption          | CrossAssetModel | AMC    |
| BermudanSwaption  | LGM             | AMC    |
| MultiLegOption    | CrossAssetModel | AMC    |

AMC enabled products with engine and model types

</div>

### Additional Features

As a side product the AMC module provides plain MC pricing engines for
Bermudan Swaptions and a new trade type `MultiLegOption` with a
corresponding MC pricing engine.

### MC pricing engine for Bermudan swaptions

The following listing shows a sample configuration for the MC Bermudan
Swaption engine. The model parameters are identical to the LGM Grid
engine configuration. The engine parameters on the other hand are the
same as for the AMC engine, see
<a href="#sec:amc_pricingengineconfig" data-reference-type="ref"
data-reference="sec:amc_pricingengineconfig">[sec:amc_pricingengineconfig]</a>.

``` xml
<Product type="BermudanSwaption">
  <Model>LGM</Model>
  <ModelParameters>
    <Parameter name="Calibration">Bootstrap</Parameter>
    <Parameter name="CalibrationStrategy">CoterminalDealStrike</Parameter>
    <Parameter name="Reversion_EUR">0.0050</Parameter>
    <Parameter name="Reversion_USD">0.0030</Parameter>
    <Parameter name="ReversionType">HullWhite</Parameter>
    <Parameter name="VolatilityType">HullWhite</Parameter>
    <Parameter name="Volatility">0.01</Parameter>
    <Parameter name="ShiftHorizon">0.5</Parameter>
    <Parameter name="Tolerance">1.0</Parameter>
  </ModelParameters>
  <Engine>MC</Engine>
  <EngineParameters>
    <Parameter name="Training.Sequence">MersenneTwisterAntithetic</Parameter>
    <Parameter name="Training.Seed">42</Parameter>
    <Parameter name="Training.Samples">10000</Parameter>
    <Parameter name="Training.BasisFunction">Monomial</Parameter>
    <Parameter name="Training.BasisFunctionOrder">6</Parameter>
    <Parameter name="Pricing.Sequence">SobolBrownianBridge</Parameter>
    <Parameter name="Pricing.Seed">17</Parameter>
    <Parameter name="Pricing.Samples">25000</Parameter>
    <Parameter name="BrownianBridgeOrdering">Steps</Parameter>
    <Parameter name="SobolDirectionIntegers">JoeKuoD7</Parameter>
  </EngineParameters>
</Product>
```

### Multi Leg Options / MC pricing engine

The following listing shows a sample MultiLegOption trade. It consists
of

1.  an option data block; this is optional, see below

2.  a number of legs; in principle all leg types are supported, the
    number of legs is arbitrary and they can be in different currencies;
    if the payment currency of a leg is different from a floating index
    currency, this is interpreted as a quanto payoff

If the option block is given, the trade represents a Bermudan swaption
on the underlying legs. If the option block is missing, the legs
themselves represent the trade.

See for limitations of the multileg option pricing engine.

``` xml
<Trade id="Sample_MultiLegOption">
  <TradeType>MultiLegOption</TradeType>
  <Envelope>...</Envelope>
  <MultiLegOptionData>
    <OptionData>
      <LongShort>Long</LongShort>
      <OptionType>Call</OptionType>
      <Style>Bermudan</Style>
      <Settlement>Physical</Settlement>
      <PayOffAtExpiry>false</PayOffAtExpiry>
      <ExerciseDates>
        <ExerciseDate>2026-02-25</ExerciseDate>
        <ExerciseDate>2027-02-25</ExerciseDate>
        <ExerciseDate>2028-02-25</ExerciseDate>
      </ExerciseDates>
    </OptionData>
    <LegData>
      <LegType>Floating</LegType>
      <Payer>false</Payer>
      <Currency>USD</Currency>
      <Notionals>
        <Notional>100000000</Notional>
      </Notionals>
      ...
    </LegData>
    <LegData>
      <LegType>Floating</LegType>
      <Payer>true</Payer>
      <Currency>EUR</Currency>
      <Notionals>
        <Notional>100000000</Notional>
      </Notionals>
      ...
    </LegData>
  </MultiLegOptionData>
</Trade>
```

The pricing engine configuration is similar to that of the MC Bermudan
swaption engine, cf.
<a href="#sec:mc_bermudan_engine" data-reference-type="ref"
data-reference="sec:mc_bermudan_engine">[sec:mc_bermudan_engine]</a>,
also see the following listing.

``` xml
  <Product type="MultiLegOption">
  <Model>CrossAssetModel</Model>
  <ModelParameters>
    <Parameter name="Tolerance">0.0001</Parameter>
    <!-- IR -->
    <Parameter name="IrCalibration">Bootstrap</Parameter>
    <Parameter name="IrCalibrationStrategy">CoterminalATM</Parameter>
    <Parameter name="ShiftHorizon">1.0</Parameter>
    <Parameter name="IrReversion_EUR">0.0050</Parameter>
    <Parameter name="IrReversion_GBP">0.0070</Parameter>
    <Parameter name="IrReversion_USD">0.0080</Parameter>
    <Parameter name="IrReversion">0.0030</Parameter>
    <Parameter name="IrReversionType">HullWhite</Parameter>
    <Parameter name="IrVolatilityType">HullWhite</Parameter>
    <Parameter name="IrVolatility">0.0050</Parameter>
    <!-- FX -->
    <Parameter name="FxCalibration">Bootstrap</Parameter>
    <Parameter name="FxVolatility_EURUSD">0.10</Parameter>
    <Parameter name="FxVolatility">0.08</Parameter>
    <Parameter name="ExtrapolateFxVolatility_EURUSD">false</Parameter>
    <Parameter name="ExtrapolateFxVolatility">true</Parameter>
    <!-- Correlations IR-IR, IR-FX, FX-FX -->
    <Parameter name="Corr_IR:EUR_IR:GBP">0.80</Parameter>
    <Parameter name="Corr_IR:EUR_FX:GBPEUR">-0.50</Parameter>
    <Parameter name="Corr_IR:GBP_FX:GBPEUR">-0.15</Parameter>
  </ModelParameters>
  <Engine>MC</Engine>
  <EngineParameters>
    <Parameter name="Training.Sequence">MersenneTwisterAntithetic</Parameter>
    <Parameter name="Training.Seed">42</Parameter>
    <Parameter name="Training.Samples">10000</Parameter>
    <Parameter name="Pricing.Sequence">SobolBrownianBridge</Parameter>
    <Parameter name="Pricing.Seed">17</Parameter>
    <Parameter name="Pricing.Samples">25000</Parameter>
    <Parameter name="Training.BasisFunction">Monomial</Parameter>
    <Parameter name="Training.BasisFunctionOrder">4</Parameter>
    <Parameter name="BrownianBridgeOrdering">Steps</Parameter>
    <Parameter name="SobolDirectionIntegers">JoeKuoD7</Parameter>
  </EngineParameters>
</Product>
```

Model Parameters special to that product are

1.  `IrCalibrationStrategy` can be `None`, `CoterminalATM`,
    `UnderlyingATM`

2.  `FXCalibration` can be `None` or `Bootstrap`

3.  `ExtrapolateFxVolatility` can be `true` or `false`; if false, no
    calibration instruments are used that require extrapolation of the
    market fx volatility surface in option expiry direction

4.  `Corr_Key1_Key2`: These entries describe the cross asset model
    correlations to be used; the syntax for `Key1` and `Key2` is the
    same as in the simulation configuration for the cross asset model

### Scripted Bermudan

Calling

`python run_scriptedberm.py`

demonstrates exposure simulation using AMC for selected scripted trade
types

- Bermudan Swaption

- LPI Swap

Both payoffs are defined in the `scriptlibrary.xml` which are referenced
in `portfolio_scriptedberm.xml` by the `ScriptName` tag.  
To enable the AMC processing requires the following highlighted settings
in `ore.xml`.

``` xml
    <Analytic type="simulation">
      <Parameter name="active">Y</Parameter>
      <!-- Set to Y to trigger AMC processing -->
      <Parameter name="amc">Y</Parameter>
      <Parameter name="simulationConfigFile">simulation.xml</Parameter>
      <Parameter name="pricingEnginesFile">pricingengine.xml</Parameter>
      <!-- Specify a separate pricing engine file for AMC engines -->
      <Parameter name="amcPricingEnginesFile">pricingengine\_amc.xml</Parameter>
      <!-- Specify trade types to be covered by the AMC processing -->
      <Parameter name="amcTradeTypes">ScriptedTrade</Parameter>
      <Parameter name="baseCurrency">EUR</Parameter>
      <Parameter name="cubeFile">cube.csv.gz</Parameter>
      <Parameter name="aggregationScenarioDataFileName">scenariodata.csv.gz</Parameter>
      <Parameter name="aggregationScenarioDataDump">scenariodata.csv</Parameter>
    </Analytic>
```

Note that ORE can handle a mix of trades covered by AMC simulation and
covered by “classic” simulation. The respective NPV cubes are combined
before generating results such as exposures or XVAs.

### Scripted TaRF

Calling

`python run_scriptedtarf.py`

demonstrates exposure simulation and XVA for another scripted product,
an FX Target Redemption Forward (TaRF). In contrast to the cases
presented above, you won’t see the payoff script library in the Input
folder, nor is the script embedded into the trade XML file. The trade
type in this case is `FxTARF` which has its own implementation in
`OREData/ored/portfolio/tarf.xpp` and a separate trade schema. However,
the scripted trade framework is used under the hood, and the payoff
script is embedded into the C++ code in OREData/ored/portfolio/tarf.cpp.

### Forward Bond

Calling

`python run_forwardbond.py`

demonstrates AMC exposure simulation and XVA for a forward and a plain
vanilla bond. The results can be compared to a classical exposure
simulation by switchting the parameter *amc* in the main configuration
file *ore.xml*, section analytic type *Simulation* to *N*.

For both cases, forward and plain vanilla bond, the security spread is
implied from given bond prices. This requires a proper security
specification in the curve configuration. Compare *Securities* node
within *curveconfig.xml*. Both fields, PriceQuote and SpreadQuote, are
mandatory. In the market data file, if the price quote is given in the
absence of a spread quote, the spread is implied. Otherwise the spread
quote is used or none.

In case of a forward bond, the convention for security specification
requires the format *securityId_FWDEXP_expiryDate*.

### Overlapping Close-out Grids in AMC

Calling

`python run_overlapping.py`

demonstrates the case where the primary and close-out grid overlap,
using a daily simulation grid up to 15 days. This was not possible in
releases earlier than ORE v13.

### Extract Scenario Statistics

Calling

`python run_scenariostatistics.py`

demonstrates a basic statistical anylsis of the simulated raw scenario
data (simulated yield curve discount factors, FX spot rates etc),
generating a report with min, mean, max, standard deviation, skewness
and kurtosis for each factor and at each simulated future date.

## XVA Risk

The following XVA Risk-related examples can be found in folder
`Examples/XvaRisk`. They can be run individually as discussed below, or
all together with: `python run.py`

### XVA Stress Testing

Calling

`python run_stress.py`

demonstrates the XVA stress testing analytic using both classical and
AMC XVA engine, with output in `Examples/XvaRisk/Output/stress`.

The new analytic type *XVA_STRESS* utilizes the existing stresstest
framework and supports stress tests in both zero and par domain. The
stress test scenarios are given in the same input format as for the
regular stresstest.

To analyse the impact of market rate shifts (Swap rates, CDS spreads,
flat vols), one had to manipulate the market data input into ORE and
re-run the entire ORE process multiple times.

The generated outputs are the xva and exposure reports under each
scenario.

The XVA stress analytic replaces the todays market with a simulation
market during the XVA calculation. For some risk factors the simulation
market behaves different from todays market. Depending on the simulation
and stress scenario settings it could use different tenors when building
curves or use only ATM volatilities. It is recommended to activate
`UseSpreadedTermStructures` in the `stresstest.xml` and to simulate
SwaptionVolatilities for the XVA stress run.

### XVA P&L Explain

Calling

`python run_xvaexplain.py`

demonstrates the XVA Explain Analytic with results in
`XvaRisk/Output/explain`.

ORE can compute the market implied XVA change between two evaluation
dates. For each risk factor defined in the sensitivity config ORE
computes the par rate change between t0 and t0 + mporDays. ORE derives
for each risk factor a shift scenario ($ParRate(t_1) - ParRate(t_0)$)
and computes the CVA change implied by those risk factor shifts at t0.

Like the XVA Stress analytic, the XVA Explain analytic replaces the
todays market with a simulation market during the XVA calculation. For
some risk factors the simulation market behaves different from todays
market. Depending on the simulation and stress scenario settings it
could use different tenors when building curves or use only ATM
volatilities. It is recommended to activate `UseSpreadedTermStructures`
in `sensitivity_explain.xml` and to simulate SwaptionVolatilities for
the XVA Explain run in `xvaexplainmarket.xml`

### XVA Sensitivities

Calling

`python run_sensi.py`

demonstrates the XVA Sensitivity analytic with results in
`XvaRisk/Output/sensi`, in particular `sacva.csv` and `sacvadetail.csv`.

The analytic computes XVA sensitivities by bump & revalue and generates
the sensitivity scenarios from a sensitivity configuration similar to
the one used in NPV sensitivity calculation. It utilises the existing
XVA machinery “under the hood”, supports XVA calculation using “classic”
and AMC simulation. Sensitivities are generated in both the “raw” (e.g.
zero rate) domain as well as in the par domain.

This analysis is run twice here, with “classic” and AMC simulation, for
a small proof-of-concept “portfolio” consisting of two swaps. We are
running an (unusual) uncollateralised case here. The user can activate
both VM and IM as shown in previous examples.

For methodology summaries and the current scope of the implementations
see .

Note:

- The XVA sensitivity analytic replaces the TodaysMarket with a
  SimulationMarket during the XVA calculation. This is a template for
  extending other ORE analytics (such as VaR) for exposing their
  evaluation under stressed markets.

- Realistic portfolios may require large numbers of sensitivity
  scenarios and hence XVA simulations which makes SA-CVA computationally
  challenging in practice. AMC simulation for XVA instead of “classic”
  simulation helps performance here. As a further performance
  enhancement we are working on a computation graph framework for XVA
  which supports GPU parallelization and AAD for XVA sensitivity, see
  example section
  <a href="#example:performance" data-reference-type="ref"
  data-reference="example:performance">1.14</a>.

### CVA Capital: SA-CVA and BA-CVA

Calling

`python run_sacva.py`

demonstrates CVA Capital calculation using the Standard Approach
(**SA-CVA**) with results in `XvaRisk/Output/sacva`. This analytic
utilises the former XVA sensitivity analytic, in particular its CVA par
sensitivity output. Alternatively, CVA sensitivity can passed as an
input. The demonstration here picks up the sensitivities computed before
by the XVA Sesnitivity analytic and written to
`Output/sensi/amc/xva_par_sensitivity_cva.csv`, see
`Input/ore_sacva.xml`.

Similarly, calling

`python run_bacva.py`

demonstrates CVA Capital calculation using the Basic Approach
(**BA-CVA**) with results in `XvaRisk/Output/bacva`. BA-CVA is based on
the SA-CCR Exposure At Default implementation, hence calls the SA-CCR
analytic “under the hood”. SA-CCR is covered in section
<a href="#example:creditrisk" data-reference-type="ref"
data-reference="example:creditrisk">1.13</a>.

## Credit Risk

### SA-CCR

Calling

`python run_saccr.py`

demonstrates the “Standard Approach Counterparty Credit Risk (SA-CCR)”
Capital calculation for derivatives in ORE with results in
`CreditRisk/Output/SA-CCR`, in particular `saccr.csv` and
`saccr_detail.csv`. See for the current implementaion’s scope.

### Credit Portfolio Model

The purpose of the credit portfolio model in ORE is to generate an
integrated portfolio gain/loss distribution at a given future horizon
which is driven by

- credit defaults and rating migrations in Bonds and CDS, and

- the PnL of a portfolio of derivatives over the specified time horizon.

The model integrates Credit and Market Risk by jointly evolving systemic
credit risk drivers alongside the usual risk factors in ORE’s Cross
Asset Model. See also the separate documentation in
`Docs/UserGuide/creditmodel.tex|pdf`. As mentioned there, this example
will only run if the Eigen installation has been done before building
ORE as described in section
<a href="#sec:build" data-reference-type="ref"
data-reference="sec:build">[sec:build]</a>.

By running  

`python run_cpm.py`

this example demonstrates the model’s outcome for seven demo portfolios

<div class="center">

| Case          | Credit Mode | Exposure Mode | Evaluation          |
|:--------------|:------------|:--------------|:--------------------|
| Single Bond   | Migration   | Value         | Analytic            |
| Bond and Swap | Migration   | Value         | Analytic            |
| 3 Bonds       | Migration   | Value         | Analytic            |
| 10 Bonds      | Migration   | Value         | Analytic            |
| 10 Bonds      | Migration   | Value         | Terminal Simulation |
| Bonds and CDS | Migration   | Notional      | Analytic            |
| 100 Bonds     | Default     | Notional      | Analytic            |

</div>

The last demo case in this table can be activated by uncommenting the
corresponding section at the end of the `run_cpm.py` script.

## Performance

### Multi-threading

Calling

`python run_multithreading.py`

demonstrates the parallelisation of exposure simulation for a portfolio
of eight Vanilla Swap copies, results in folder
`Performance/Output/multi`. The multi-threaded valuation engine in ORE
splits the portfolio into $n$ parts where $n$ is the number of threads
`nThreads` specified in `ore_multi.xml`.

### NPV Sensitivities with AAD and GPUs

Calling

`python run_sensi.py`

demonstrates alternative ways of speeding up sensitivity calculations -
using AAD or an external compute device. The test portfolio consists of

- Vanilla Equity Option

- Equity Barrier Option

- Equity Accumulator

- Asian Basket Option

- FX TaRFs

The sensitivity analysis is then run in four ways, see `run_sensi.py`,

- with “classic” bump and revalue ((19 sec on Apple M2 Max))

- as above but using the Computation Graph, see `UseCG=true` in
  `pricingengine_cg.xml`, which is the basis for the following two
  approaches ((14 sec on Apple M2 Max))

- using AAD, see `pricingengine_ad.xml` ((2.2 sec on Apple M2 Max))

- using the external device if available, see `pricingengine_gpu.xml`
  (2.3 sec on Apple M2 Max with “OpenCL/Apple/Apple M2 Max” device)

to compare sensitivities and performance. In the latter case we have set
the external device in `pricingengine_gpu.xml` to
“BasicCpu/Default/Default” which mimics an external device on the CPU.
On a macbook pro (2023) with M2 Max processor, we can also choose
“OpenCL/Apple/Apple M2 Max” here (a 38 core GPU). The Jupyter notebook
`ore_aadsensi.ipynb` in this `Examples/Performance` folder also kicks
off these four runs, but adds further commentary and visualises results.
To run this notebook you need to build the Python bindings for release
12 (or later) or “pip install” ORE as discussed in section
<a href="#example:orepython" data-reference-type="ref"
data-reference="example:orepython">1.15</a>.

### CVA Sensitivities with AAD

Calling

`python run_cvasensi.py`

demonstrates a prototype CVA sensitivity calculation applying AAD to a
single Swap instrument with results in folder
`Performance/Output/cvasensi`.

This script executes four batches

- a “base” CVA calculation using AMC for reference (about 9 sec on Apple
  M2 Max)

- a bump & revalue CVA sensitivity calculation (about 48 sec on Apple M2
  Max)

- CVA sensitivity using AAD (about 2 sec on Apple M2 Max)

- CVA sensitivities with GPU parallelisation, porting the conditional
  expectation calculations to the external device is work in progress,
  hence no noticeable speedup to be reported yet

Run the corresponding Juypter notebook with:
`python -m jupyterlab ore_cvasensi.ipynb &`

## ORE-Python

Since release 9 (March 2023) we provide easy access to ORE via a
pre-compiled Python module. Some example scripts using this ORE module
are provided in this example, so change to this directory first

`cd Examples/ORE-Python`

The examples require Python 3. The ORE Python module is then installed
with a one-liner, see step 3 below. However, to separate ORE from any
other Python environments on your machine, we recommend creating a
virtual environment first. In that case the steps are as follows.

1.  To create a virtual environment: `python -m venv env1`

2.  To activate this environment on Windows:
    `.env1Scriptsactivate.bat`  
    or on macOS/Linux: `source env1/bin/activate `

3.  Then install the latest release of ORE:  
    `pip install open-source-risk-engine `

4.  Try examples:  

    - `python ore.py`  
      This demonstrates the Python-wrapped version of the ORE
      application that is also used in the command line application
      `ore.exe`. We use it here to re-run the Swap exposure of
      `Example_1`.

    - `python ore2.py`  
      This extends the previous example and shows how to access and
      post-process ORE in-memory results in the Python framework without
      reading files.

    - `python commodityforward.py`  
      The ORE Python module also allows lower-level access to the
      QuantLib and QuantExt libraries, demonstrated here for a
      CommodityForward instrument defined in QuantExt. Note that the ORE
      Python module contains the entire QuantLib Python functionality.

    More use cases of the ORE Python module including Jupyter notebooks
    can be found in the ORE SWIG repository, in particular in folder
    OREAnalytics-SWIG/Python/Examples.

5.  You can deactivate the environment with `deactivate`  
    or even fully remove the environment again by removing the `env1`
    folder.

Finally, you can build the Python module and installable packages
yourself following the instructions in sections
<a href="#sec:oreswig" data-reference-type="ref"
data-reference="sec:oreswig">[sec:oreswig]</a> based on your local ORE
code.

### Jupyter Notebook Examples

With ORE release 13 we have merged the ORE-SWIG source code into the ORE
repository and moved a range of related Jupyter notebook examples into
this ORE-Python folder, see folders Notebooks/Example_1 to
Notebooks/Example_9.

To try, change e.g. to Notebooks/Example_1 and launch the notebook there
by calling

`python3 -m jupyterlab ore.ipynb & `

If not installed yet, this might require a

`python3 -m pip install jupyterlab `

and some of the Jupyter notebooks require additional packages to be
installed with pip:

- matplotlib

- pandas

- numpy

- scipy

- ipywidgets

## ORE-API

Since release 12, ORE comes with a proof-of-concept implementation of a
web service around ORE that is written in Python, see folder
`Examples/ORE-API`.

The service is based on

- the flask web framework <https://flask.palletsprojects.com>, and

- the ORE Python module which can be installed using  
  `pip install open-source-risk-engine`  
  or built from sources following the instructions in section
  <a href="#sec:installation" data-reference-type="ref"
  data-reference="sec:installation">[sec:installation]</a>

Main files in the `Examples/API` directory:

- **restapi.py** runs a flask api as analytics service that takes a post
  request (e.g. from a server like postman, or from a python script):
  The request contains a json body which corresponds to the data usually
  contained in the master input file ore.xml. restapi.py calls the
  oreApi.py class (see below) to do the work. By default, the analytics
  service listens for requests on port 5001.

- **oreApi.py** reads the json body, compiles all ORE input parameters,
  calls into a data service (see below) to retrieve additional data.
  Then it kicks off an ORE run to process the request. Finally it posts
  resulting reports through the data service.

- **simplefileserver.py** runs a flask api as a data service. It takes
  requests from the analytics service above in the form of urls of xml
  files that contain additional data required by ORE (market data,
  portfolio, configuration). By default, the data service listens on
  port 5000, reads from the Input directory in Examples/API and writes
  reports to the Output directory in Examples/API.

Run a local example:

- start the data service:  
  `python3 simplefileserver.py &`

- start the analytics service:  
  `python3 restapi.py &`

- send a request to run the equivalent of Example 1:  
  `python3 request.py`  
  Note that the json equivalent of the usual `ore.xml` is contained in
  request.py, and all other inputs are retrieved from folder
  Examples/API/Input via the data service.

[^1]: Using closed form expressions for standard European Swaption
    prices.
