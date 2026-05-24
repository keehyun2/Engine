## Analytics: `ore.xml`

The master input file contains general setup information (paths to
configuration, trade data and market data), as well as the selection and
configuration of analytics. The file has an opening and closing root
element `<ORE>`, ` </ORE>` with three sections

- Setup

- Logging

- Markets

- Analytics

which we will explain in the following.

### Setup

This subset of data is easiest explained using an example, see listing
<a href="#lst:ore_setup" data-reference-type="ref"
data-reference="lst:ore_setup">[lst:ore_setup]</a>.

<div class="listing">

``` xml
<Setup>
  <Parameter name="asofDate">2016-02-05</Parameter>
  <Parameter name="inputPath">Input</Parameter>
  <Parameter name="outputPath">Output</Parameter>
  <Parameter name="logFile">log.txt</Parameter>
  <Parameter name="logMask">255</Parameter>
  <Parameter name="marketDataFile">../../Input/market_20160205.txt</Parameter>
  <Parameter name="fixingDataFile">../../Input/fixings_20160205.txt</Parameter>
  <Parameter name="dividendDataFile">../../Input/dividends_20160205.txt</Parameter> <!-- Optional -->
  <Parameter name="implyTodaysFixings">Y</Parameter>
  <Parameter name="useAtParCouponsCurves">Y</Parameter>
  <Parameter name="useAtParCouponsTrades">Y</Parameter>
  <Parameter name="curveConfigFile">../../Input/curveconfig.xml</Parameter>
  <Parameter name="conventionsFile">../../Input/conventions.xml</Parameter>
  <Parameter name="marketConfigFile">../../Input/todaysmarket.xml</Parameter>
  <Parameter name="pricingEnginesFile">../../Input/pricingengine.xml</Parameter>
  <Parameter name="portfolioFile">portfolio.xml</Parameter>
  <Parameter name="counterpartyFile">counterparty.xml</Parameter>
  <Parameter name="calendarAdjustment">../../Input/calendaradjustment.xml</Parameter>
  <Parameter name="currencyConfiguration">../../Input/currencies.xml</Parameter>
  <Parameter name="referenceDataFile">../../Input/referencedata.xml</Parameter>
  <Parameter name="iborFallbackConfig">../../Input/iborFallbackConfig.xml</Parameter>
  <!-- None, Unregister, Defer or Disable -->
  <Parameter name="observationModel">Disable</Parameter>
  <Parameter name="lazyMarketBuilding">false</Parameter>
  <Parameter name="continueOnError">false</Parameter>
  <Parameter name="buildFailedTrades">true</Parameter>
  <Parameter name="nThreads">4</Parameter>
  <Parameter name="enrichIndexFixings">false</Parameter>
  <Parameter name="ignoreFixingLead">0</Parameter>
  <Parameter name="ignoreFixingLag">0</Parameter>
</Setup>
```

</div>

Parameter names are self explanatory: Input and output path are
interpreted relative from the directory where the ORE executable is
executed, but can also be specified using absolute paths. All file names
are then interpreted relative to the ‘inputPath’ and ‘outputPath’,
respectively. The files starting with `../../Input/` then point to files
in the global Example input directory `Example/Input/*`, whereas files
such as `portfolio.xml` are local inputs in ` Example/Example_#/Input/`.

Parameter `logMask` determines the verbosity of log file output. Log
messages are internally labelled as Alert, Critical, Error, Warning,
Notice, Debug, associated with logMask values 1, 2, 4, 8, ..., 64. The
logMask allows filtering subsets of these categories and controlling the
verbosity of log file output[^1]. LogMask 255 ensures maximum
verbosity.  
When ORE starts, it will initialise today’s market, i.e. load market
data, fixings and dividends, and build all term structures as specified
in `todaysmarket.xml`. Moreover, ORE will load the trades in
`portfolio.xml` and link them with pricing engines as specified in
`pricingengine.xml`. The counterparty information in `counterparty.xml`
covers minimal counterparty-level information needed in a few capital
analytics as shown in example sections
<a href="#example:marketrisk" data-reference-type="ref"
data-reference="example:marketrisk">[example:marketrisk]</a> and
<a href="#example:creditrisk" data-reference-type="ref"
data-reference="example:creditrisk">[example:creditrisk]</a>. When
parameter `implyTodaysFixings` is set to Y, today’s fixings would not be
loaded but implied, relevant when pricing/bootstrapping off hypothetical
market data as e.g. in scenario analysis and stress testing. The
curveConfigFile `curveconfig.xml`, the conventionsFile
` conventions.xml`, the referenceDataFile `referencedata.xml`, the
iborFallbackConfig, the marketDataFile and the fixingDataFile are
explained in the sections below.

The parameters `useAtParCouponsCurves` and `useAtParCouponsTrades`
control whether to use par approximation or indexed ibor coupons when
building curves or building ore trades, respectively. This goes back to
the QuantLib flag `QL_USE_INDEXED_COUPON` and the associated runtime
setting. The default is `true` for both flags which is also the default
setting when building QuantLib.

Parameter `calendarAdjustment` includes the `calendarAdjustment.xml`
which lists out additional holidays and business days to be added to
specified calendars.

The optional parameter `currencyConfiguration` points to a configuration
file that contains additional currencies to be added to ORE’s setup, see
`Examples/Input/currencies.xml` for a full list of ISO currencies and a
few unofficial currency codes that can thus be made available in ORE.
Note that the external configuration does not override any currencies
that are hard-coded in the QuantLib/QuantExt libraries, only currencies
not present already are added from the external configuration file.

The last parameter `observationModel` can be used to control ORE
performance during simulation. The choices *Disable* and *Unregister*
yield similarly improved performance relative to choice *None*. For
users familiar with the QuantLib design - the parameter controls to
which extent *QuantLib observer notifications* are used when market and
fixing data is updated and the evaluation date is shifted:

- The ‘Unregister’ option limits the amount of notifications by
  unregistering floating rate coupons from indices;

- Option ‘Defer’ disables all notifications during market data and
  fixing updates with
  `ObservableSettings::instance().disableUpdates(true)` and kicks off
  updates afterwards when enabled again

- The ‘Disable’ option goes one step further and disables all
  notifications during market data and fixing updates, and in particular
  when the evaluation date is changed along a path, with  
  `ObservableSettings::instance().disableUpdates(false)`  
  Updates are not deferred here. Required term structure and instrument
  recalculations are triggered explicitly.

If the parameter `lazyMarketBuilding` is set to true, the build of the
curves in the TodaysMarket is delayed until they are actually requested.
This can speed up the processing when some curves configured in
TodaysMarket are not used. If not given, the parameter defaults to
`true`.

If the parameter `continueOnError` is set to true, the application will
not exit on an error, but try to continue the processing. If not given,
the parameter defaults to `false`.

If the parameter `buildFailedTrades` is set to true, the application
will build a dummy trade if loading or building the original trade
fails. The dummy trade has trade type “Failed”, zero notional and NPV.
If not given, the parameter defaults to `false`.

If the parameter `nThreads` is given, multiple threads will be used for
valuation engine runs where applicable (Sensitivity, Exposure Classic,
Exposure AMC). If not given, the parameter defaults to $1$.

If the parameter `enrichIndexFixings` is set to true, the application
will fill the gaps in index fixings, by fallback fixings, which are the
previous fixings (priority) or the next fixings. If not given, the
parameter defaults to `false`.

If the next fixing date leads by more than Parameter `ignoreFixingLead`,
the fixing would not be used as the fallback. A `0` `ignoreFixingLead`
disables the check. If not given, the parameter defaults to `0`.

If the previous fixing date lags by more than Parameter
`ignoreFixingLag`, the fixing would not be used as the fallback. A `0`
`ignoreFixingLag` disables the check. If not given, the parameter
defaults to `0`.

### Logging

The `Logging` section (see listing
<a href="#lst:ore_logging" data-reference-type="ref"
data-reference="lst:ore_logging">[lst:ore_logging]</a>) is used to
configure some ORE logging options.

<div class="listing">

``` xml
<Logging>
  <Parameter name="logFile">log.txt</Parameter>
  <Parameter name="logMask">31</Parameter>
  <Parameter name="progressLogFile">my_log_progress_%N.json</Parameter>
  <Parameter name="progressLogRotationSize">102400</Parameter>
  <Parameter name="progressLogToConsole">false</Parameter>
  <Parameter name="structuredLogFile">my_structured_logs_%N.txt</Parameter>
  <Parameter name="structuredLogRotationSize">102400</Parameter>
</Logging>
```

</div>

Parameter `logFile` and `logMask` will override the same parameters in
the `Setup` section. Parameters `progressLogFile` and
`structuredLogFile` are the filename where progress log messages and
structured log messages are written out to, respectively, which supports
Boost string patterns.This defaults to “log_progress\_%N.json” and
“log_structured\_%N.json”, respectively, where `N` will be an integer
(beginning at 0) used for log file rotation. Parameters
`progressLogRotationSize` and `structuredLogRotationSize` are the size
limit (in bytes) of each log file before applying log file rotation to
the progress log file and structured log message file, respectively..
For example, $10 * 1024 * 1024 = 10 \text{MiB}$. Defaults to 100 MiB. If
the parameter `progressLogToConsole` is set to true, then progress logs
will be written to std::cout. This can be used simultaneously with
`progressLogFile`, i.e. progress logs can be written out to both file
and std::cout.

### Markets

The `Markets` section (see listing
<a href="#lst:ore_markets" data-reference-type="ref"
data-reference="lst:ore_markets">[lst:ore_markets]</a>) is used to
choose market configurations for calibrating the IR, FX and EQ
simulation model components, pricing and simulation, respectively. These
configurations have to be defined in `todaysmarket.xml` (see section
<a href="#sec:market" data-reference-type="ref"
data-reference="sec:market">[sec:market]</a>).

<div class="listing">

``` xml
<Markets>
  <Parameter name="lgmcalibration">collateral_inccy</Parameter>
  <Parameter name="fxcalibration">collateral_eur</Parameter>
  <Parameter name="eqcalibration">collateral_inccy</Parameter>
  <Parameter name="pricing">collateral_eur</Parameter>
  <Parameter name="simulation">collateral_eur</Parameter>
</Markets>
```

</div>

For example, the calibration of the simulation model’s interest rate
components requires local OIS discounting whereas the simulation phase
requires cross currency adjusted discount curves to get FX product
pricing right. So far, the market configurations are used only to
distinguish discount curve sets, but the market configuration concept in
ORE applies to all term structure types.

### Analytics

The `Analytics` section lists all permissible analytics using tags
`<Analytic type="..."> ... </Analytic>` where type can be (so far) in

- NPV, Cashflows, Curves

- Exposure Simulation, Model Calibration, Scenario Generation

- Value Adjustments (xVA)

- Sensitivity, Stress

- Value at Risk

- P&L, P&L Explain, Scenario

- ISDA SIMM, IM Schedule, IR/FX CRIF generation for ISDA SIMM

- Par Conversion, Par Stress Conversion, Par Scenario, Zero Shift to Par
  Shift

- XVA Stress, XVA Sensitivities, XVA Explain

- SA-CCR, SA-CVA, BA-CVA, SMRC

- Portfolio Details

- Correlation

Each `Analytic` section contains a list of key/value pairs to
parameterise the analysis of the form
`<Parameter name="key">value</Parameter>`. Each analysis must have one
key `active` set to Y or N to activate/deactivate this analysis.

### Pricing, Cashflows, Curves

The following listing
<a href="#lst:ore_analytics" data-reference-type="ref"
data-reference="lst:ore_analytics">[lst:ore_analytics]</a> shows the
parametrisation of the first three basic analytics in the list above.

<div class="listing">

``` xml
<Analytics>
  <Analytic type="npv">
    <Parameter name="active">Y</Parameter>
    <Parameter name="baseCurrency">EUR</Parameter>
    <Parameter name="outputFileName">npv.csv</Parameter>
    <Parameter name="additionalResults">Y</Parameter>
    <Parameter name="additionalResultsReportPrecision">12</Parameter>
  </Analytic>
  <Analytic type="cashflow">
    <Parameter name="active">Y</Parameter>
    <Parameter name="outputFileName">flows.csv</Parameter>
    <Parameter name="includePastCashflows">N</Parameter>
  </Analytic>
  <Analytic type="curves">
    <Parameter name="active">Y</Parameter>
    <Parameter name="configuration">default</Parameter>
    <Parameter name="grid">240,1M</Parameter>
    <Parameter name="calendar">TARGET</Parameter>
    <Parameter name="outputFileName">curves.csv</Parameter>
    <Parameter name="outputTodaysMarketCalibration">Y</Parameter>
    <Parameter name="todaysMarketCalibrationPrecision">8</Parameter>
  </Analytic>
  <Analytic type="...">
    <!-- ... -->
  </Analytic>
</Analytics>
```

</div>

The cashflow analytic writes a report containing all future (and
optionally past) cashflows of the portfolio. Table
<a href="#cashflowreport" data-reference-type="ref"
data-reference="cashflowreport">1</a> shows a typical output for a
vanilla swap.

<div class="center">

<div id="cashflowreport">

| \#ID  | Type | LegNo | PayDate  |     Amount | Currency |    Coupon | Accrual | fixingDate | fixingValue |      Notional |
|:------|:-----|:------|:---------|-----------:|:---------|----------:|--------:|:-----------|------------:|--------------:|
| tr123 | Swap | 0     | 13/03/17 | -111273.76 | EUR      |  -0.00201 | 0.50556 | 08/09/16   |    -0.00201 | 100000000\.00 |
| tr123 | Swap | 0     | 12/09/17 | -120931.71 | EUR      | -0.002379 | 0.50833 | 09/03/17   |   -0.002381 | 100000000\.00 |
| …     |      |       |          |            |          |           |         |            |             |               |

Cashflow Report

</div>

</div>

The amount column contains the projected amount including embedded caps
and floors and convexity (if applicable), the coupon column displays the
corresponding rate estimation. The fixing value on the other hand is the
plain fixing projection as given by the forward value, i.e. without
embedded caps and floors or convexity.

Note that the fixing value might deviate from the coupon value even for
a vanilla coupon, if the QuantLib library was compiled *without* the
flag `QL_USE_INDEXED_COUPON` (which is the default case). In this case
the coupon value uses a par approximation for the forward rate assuming
the index estimation period to be identical to the accrual period, while
the fixing value is the actual forward rate for the index estimation
period, i.e. whenever the index estimation period differs from the
accrual period the values will be slightly different.

The Notional column contains the underlying notional used to compute the
amount of each coupon. It contains `#NA` if a payment is not a coupon
payment.

The curves analytic exports all yield curves that have been built
according to the specification in ` todaysmarket.xml`. Key
`configuration` selects the curve set to be used (see explanation in the
previous Markets section). Key `grid` defines the time grid on which the
yield curves are evaluated, in the example above a grid of 240 monthly
time steps from today. The optional key `calendar` defines the calendar
that is used to roll out the grid, it defaults to TARGET. The discount
factors for all curves with configuration default will be exported on
this monthly grid into the csv file specified by key `outputFileName`.
The grid can also be specified explicitly by a comma separated list of
tenor points such as `1W, 1M, 2M, 3M, …`.

The `outputTodaysMarketCalibration` parameter controls whether
calibration information for the built market objects is written to a
report. When set to Y, a detailed calibration report is generated. The
`todaysMarketCalibrationPrecision` parameter specifies the number of
decimal places to use when formatting floating-point values in the
market calibration report (default: 8). This allows users to control the
precision of numerical output in the calibration report, similar to the
`additionalResultsReportPrecision` parameter for the NPV analytic.

The additionalResults analytic writes a report containing any additional
results generated for the portfolio. The results are pricing engine
specific but Table <a href="#additionalreport" data-reference-type="ref"
data-reference="additionalreport">2</a> shows the output for a vanilla
swaption.

<div class="center">

<div id="additionalreport">

|                  |                  |            |              |
|:-----------------|:-----------------|:-----------|:-------------|
| \#TradeId        | ResultId         | ResultType | ResultValue  |
| example_swaption | annuity          | double     | 2123720984   |
| example_swaption | atmForward       | double     | 0.01664135   |
| example_swaption | spreadCorrection | double     | 0            |
| example_swaption | stdDev           | double     | 0.00546015   |
| example_swaption | strike           | double     | 0.024        |
| example_swaption | swapLength       | double     | 4            |
| example_swaption | vega             | double     | 309237709\.5 |
| …                |                  |            |              |

AdditionalResults Report

</div>

</div>

The todaysMarketCalibration analytic writes a report containing
information on the build of the t0 market.

### Simulation and Model Calibration

The purpose of the `simulation` ‘analytics’ is to run a Monte Carlo
simulation which evolves the market as specified in the simulation
config file. The primary result is an NPV cube file, i.e. valuations of
all trades in the portfolio file (see section Setup), for all future
points in time on the simulation grid and for all paths. Apart from the
NPV cube, additional scenario data (such as simulated overnight rates
etc) are stored in this process which are needed for subsequent Exposure
and XVA analytics.

ORE supports NPV cube generation using both a “classic” Monte Carlo
simulation as sketched above, as well as American Monte Carlo (AMC), see
below. The setup in
<a href="#lst:ore_simulation" data-reference-type="ref"
data-reference="lst:ore_simulation">[lst:ore_simulation]</a> refers to a
classic run.

<div class="listing">

``` xml
<Analytics>
  <Analytic type="simulation">
    <Parameter name="simulationConfigFile">simulation.xml</Parameter>
    <Parameter name="pricingEnginesFile">../../Input/pricingengine.xml</Parameter>
    <Parameter name="baseCurrency">EUR</Parameter>
    <Parameter name="cubeFile">cube.csv.gz</Parameter>
    <Parameter name="nettingSetCubeFile">nettingSetCube.csv.gz</Parameter>
    <Parameter name="scenariodump">scenariodump.csv</Parameter>
    <Parameter name="aggregationScenarioDataFileName">scenariodata.csv.gz</Parameter>
    <Parameter name="storeFlows">Y</Parameter>
    <Parameter name="cptyCubeFile">cptyCube.csv.gz</Parameter>
    <Parameter name="storeSurvivalProbabilities">Y</Parameter>
    <Parameter name="storeCreditStateNPVs">8</Parameter>
    <Parameter name="cubeNpvOverlay">true</Parameter>
  </Analytic>
</Analytics>
```

</div>

The pricing engines file specifies how trades are priced under future
scenarios which can differ from pricing as of today (specified in
section Setup). Key base currency determines into which currency all
NPVs will be converted for writing the (trade-level) cube and
nettingSetCube files. The scenario dump file name, if provided here,
causes ORE to export full “raw” market scenarios for later
inspection/use, i.e. discount factors for yield curves. The
aggregationScenarioData file name, if provided here, causes ORE to write
furthermore selected market data (simulated FX rates and index fixings,
which might be needed in the XVA postprocessor for Variation Margin
calculations) to a zipped csv. The selection is specified in the
simulation config file, see AggregationScenarioDataCurrencies,
AggregationScenarioDataIndices), see also section
<a href="#sec:sim_market" data-reference-type="ref"
data-reference="sec:sim_market">[sec:sim_market]</a>. Key ‘store flows’
(Y or N) controls whether cumulative cash flows between simulation dates
are stored in the (hyper-) cube for post processing in the context of
some Dynamic Initial Margin and Variation Margin models. And finally,
the key ‘store survival probabilities’ (Y or N) controls whether
survival probabilities on simulation dates are stored in the cube for
post processing in the context of Dynamic Credit XVA calculation. Key
’cubeNpvOverlay’ is optional and defaults to false. If true, all raw npv
cube entries are corrected by the difference of the T0 npv from the
pricing analytic and the T0 npv from the simulation npv.

To use AMC simulation the simulation setup needs the additional elements
shown in <a href="#lst:ore_amc_simulation" data-reference-type="ref"
data-reference="lst:ore_amc_simulation">[lst:ore_amc_simulation]</a>

<div class="listing">

``` xml
<Analytics>
  <Analytic type="simulation">
    ...
    <Parameter name="amc">Y</Parameter>
    <Parameter name="amcTradeTypes">Swap</Parameter>
    <Parameter name="amcPricingEnginesFile">pricingengine_amc.xml</Parameter>
    ...
  </Analytic>
</Analytics>
```

</div>

The amcTradeTypes element is a comma-separated list of ORE trade types
to be covered by AMC in this run. Permissible types are

- Swap

- Swaption

- FxForward

- FxOption

- ForwardBond

- FxTaRF

- ScriptedTrade

- CompositeTrade

The remaining products in the portfolio (if any) are covered using
classic Monte Carlo. ORE then combines the classic and AMC cubes.

Further extensions to the simulation setup are available and
demonstrated in related example sections (AmericanMonteCarlo,
InitialMargin, Performance), e.g. for

- using the Computation Graph based implementation of AMC

- utilising an external compute device to boost ORE performance

- storing analytical sensitivities for selected products along paths
  (e.g. for a version of Dynamic Initial Margin)

- generating path-wise sensitivities using AAD (e.g. for a version of
  Dynamic Initial Margin)

- computing XVA $t_0$ sensitivities using AAD

The purpose of the `calibration` ‘analytics’ is to run a subset of the
simulation analytic’s functionality, i.e. to calibrate the simulation
model and output the calibrated model data such that it can be used to
initialize a subsequent simulation without recalibration.

Both CAM and HW model are supported for `calibration` ‘analytics’. When
setting model to CAM, ORE use the following inputs.

<div class="listing">

``` xml
<Analytics>
    <Analytic type="calibration">
      <Parameter name="active">Y</Parameter>
      <Parameter name="model">CAM</Parameter>
      <Parameter name="configFile">simulation.xml</Parameter>
      <Parameter name="outputFileName">calibration.csv</Parameter>
    </Analytic>
</Analytics>
```

</div>

See `Example_8` for a demonstration.

When setting model to HW, ORE use the following inputs.

<div class="listing">

``` xml
<Analytics>
    <Analytic type="calibration">
      <Parameter name="active">Y</Parameter>
      <Parameter name="model">HW</Parameter>
      <Parameter name="mode">historical</Parameter>
      <Parameter name="foreignCurrencies">EUR,GBP</Parameter>
      <Parameter name="curveTenors">1Y,2Y,3Y,5Y,10Y,15Y,20Y,30Y</Parameter>
      <Parameter name="useForwardOrZeroRate">zero</Parameter>
      <Parameter name="pcaCalibration">Y</Parameter>
      <Parameter name="scenarioInputFile">scenario.csv</Parameter>
      <Parameter name="startDate">2019-09-29</Parameter>
      <Parameter name="endDate">2022-09-27</Parameter>
      <Parameter name="lambda">1</Parameter>
      <Parameter name="varianceRetained">0.90</Parameter>
      <Parameter name="pcaOutputFileName">pca.csv</Parameter>
      <Parameter name="pcaInputFileName">pca_USD.csv,pca_EUR.csv,pca_GBP.csv</Parameter>
      <Parameter name="meanReversionCalibration">Y</Parameter>
      <Parameter name="basisFunctionNumber">2</Parameter>
      <Parameter name="kappaUpperBound">5.0</Parameter>
      <Parameter name="haltonMaxGuess">500</Parameter>
      <Parameter name="meanReversionOutputFileName">meanReversion.csv</Parameter>
    </Analytic>
</Analytics>
```

</div>

The parameters have the following interpretation:

- `model:` The model for Calibration, can be either `CAM` or `HW`,
  default to `CAM` when left blank or omitted.

- `mode:` The calibration mode, must be `historical` for now. Will be
  ignored if `model` node set to `CAM`.

- `foreignCurrencies:` The list of foreign currencies that need the
  calibration. Will be ignored if `model` node set to `CAM`.

- `curveTenors:` The list of tenors for each IR curve when providing
  historical discount factors or the tenor list of each value in
  eigenvectors. Will be ignored if `model` node set to `CAM`.

- `useForwardOrZeroRate:` When `pcaCalibration` set to `true`, this
  means whether zero rate or forward rate will be used to calculate the
  covariance matrix for PCA calibration. When `pcaCalibration` set to
  `false`, this means whether zero rate or forward rate should be used
  to parse the provided PCA eigenvectors for mean reversion calibration.

- `pcaCalibration:` When set to `true`, ORE will read the historical
  discount factors and perform PCA calibration. Will be ignored if
  `model` node set to `CAM`.

- `scenarioInputFile:` The path to the file which contains the
  historical discount factors and historical FX spot rates. Must be in
  the scenario.csv ORE format. Only needed when `pcaCalibration` set to
  `true`.

- `startDate:` Start date of the historical data that will be used in
  calibration. Only needed when `pcaCalibration` set to `true`.

- `endDate:` End date of the historical data that will be used in
  calibration. Only needed when `pcaCalibration` set to `true`.

- `lambda:` The lambda used on exponentially-weighted historical rates
  diffs when computing the covariance matrix. The covariance matrix will
  be equally weighted when `lambda` is set to `1`. Only needed when
  `pcaCalibration` set to `true`.

- `varianceRetained:` The ratio between the combined variance of
  retained principal components and total variance. This decides how
  many principal components will be retained. Only needed when
  `pcaCalibration` set to `true`.

- `pcaOutputFileName:` The output file name of eigenvalues and
  eigenvectors retained for each currency.

- `pcaInputFileName:` The list of file names where eigenvalues and
  eigenvectors are provided for mean reversion calibration. The files
  should be one curve per file. Only needed when `pcaCalibration` is set
  to `false` and `meanReversionCalibration` is set to `true`.

- `meanReversionCalibration:` When set to `true`, ORE will perform mean
  reversion calibration on principal components retained either from
  previous pca calibration step or from input files.

- `basisFunctionNumber:` Number of basis functions used in mean
  reversion calibration.

- `kappaUpperBound:` The upper bound of kappa during mean reversion
  calibration.

- `haltonMaxGuess:` Number of max guess in optimization in mean
  reversion calibration.

- `meanReversionOutputFileName:` The output file name for kappa and v
  for each curve.

For both CAM and HW model calibration, output is the Cross Asset Model
data written to `calibration.xml` in the usual output directory, which
contains the calibration results in place of the initial values for all
parametrizations covered so far (IR, FX, EQ, INF, COM). In a subsequent
run one could replace the `CrossAssetModel` section in `simulation.xml`
with the output in `calibration.xml` to re-run without re-calibration.
Note that the `Calibrate` flags in the output Cross Asset Model data are
set to `false`.

Additionally, the Cross Asset Model XML is written as a single XML
string to the calibration report `calibration.csv`, also held in memory
for further processing e.g. via ORE’s Python interface.

For HW model, there is an additional output
`calibration_StatisticalWithRiskNeutralVolatility.xml` which is used for
multi-factor sigma risk neutral calibration. Similarly,
`calibration_StatisticalWithRiskNeutralVolatility.csv` is also
outputted.

### Scenario Generation

The `scenarioGeneration` ‘analytics’ generates scenarios and provides
the statistics and distribution of the scenarios generated. Listing
<a href="#lst:ore_scenarioGneration" data-reference-type="ref"
data-reference="lst:ore_scenarioGneration">[lst:ore_scenarioGneration]</a>
shows a typical configuration for sensitivity calculation.

<div class="listing">

``` xml
<Analytics>
  <Analytic type="scenarioGeneration">
    <Parameter name="active">Y</Parameter>
    <Parameter name="simulationConfigFile">simulation.xml</Parameter>
    <Parameter name="distributionBuckets">20</Parameter>
    <Parameter name="outputZeroRate">Y</Parameter>
    <Parameter name="scenariodump">scenariodump.csv</Parameter>
  </Analytic>
</Analytics>
```

</div>

The parameters have the following interpretation:

- `simulationConfigFile:` Configuration file defining the simulation
  market under which sensitivities are computed, see
  <a href="#sec:simulation" data-reference-type="ref"
  data-reference="sec:simulation">[sec:simulation]</a>.

- `distributionBuckets:` Number of buckets used for the distribution
  histogram.

- `outputZeroRate:` Determine whether the statistics report and
  distribution report will use zero rate or discount factors. If set to
  Y, the reports will use zero rates. If set to N, they will use
  discount factors.

- `scenariodump:` File containing all the scenarios generated through
  simulation market. If the node is not given, this file will not be
  outputted.

### Value Adjustments

The XVA analytic section offers CVA, DVA, FVA and COLVA calculations
which can be selected/deselected here individually. All XVA calculations
depend on a previously generated NPV cube (see above) which is
referenced here via the `cubeFile` parameter. This means one can re-run
the XVA analytics without regenerating the cube each time. The XVA
reports depend in particular on the settings in the `csaFile` which
determines CSA details such as margining frequency, collateral
thresholds, minimum transfer amounts, margin period of risk. By
splitting the processing into pre-processing (cube generation) and
post-processing (aggregation and XVA analysis) it is possible to vary
these CSA details and analyse their impact on XVAs quickly without
re-generating the NPV cube. The cube file is usually a compressed csv
file (using gzip compression, with file ending .csv.gz), except when the
file extension is set explicitly to txt or csv in which case an
uncompressed version of the file is written to disk.

<div class="listing">

``` xml
<Analytics>
  <Analytic type="xva">
    <Parameter name="active">Y</Parameter>
    <Parameter name="csaFile">netting.xml</Parameter>
    <Parameter name="cubeFile">cube.csv.gz</Parameter>
    <Parameter name="useDoublePrecisionCubes">false</Parameter>
    <Parameter name="nettingSetCubeFile">nettingSetCube.csv.gz</Parameter>
    <Parameter name="cptyCubeFile">cptyCube.csv.gz</Parameter>
    <Parameter name="scenarioFile">scenariodata.csv.gz</Parameter>
    <Parameter name="collateralBalancesFile">collateralbalances.xml</Parameter>
    <Parameter name="baseCurrency">EUR</Parameter>
    <Parameter name="exposureProfiles">Y</Parameter>
    <Parameter name="exposureProfilesByTrade">Y</Parameter>
    <Parameter name="quantile">0.95</Parameter>
    <Parameter name="calculationType">NoLag</Parameter>
    <Parameter name="allocationMethod">None</Parameter>
    <Parameter name="marginalAllocationLimit">1.0</Parameter>
    <Parameter name="exerciseNextBreak">N</Parameter>
    <Parameter name="cva">Y</Parameter>
    <Parameter name="dva">N</Parameter>
    <Parameter name="dvaName">BANK</Parameter>
    <Parameter name="fva">N</Parameter>
    <Parameter name="fvaBorrowingCurve">BANK_EUR_BORROW</Parameter>
    <Parameter name="fvaLendingCurve">BANK_EUR_LEND</Parameter>
    <Parameter name="colva">Y</Parameter>
    <Parameter name="collateralFloor">Y</Parameter>
    <Parameter name="dynamicCredit">N</Parameter>
    <Parameter name="kva">Y</Parameter>
    <Parameter name="kvaCapitalDiscountRate">0.10</Parameter>
    <Parameter name="kvaAlpha">1.4</Parameter>
    <Parameter name="kvaRegAdjustment">12.5</Parameter>
    <Parameter name="kvaCapitalHurdle">0.012</Parameter>
    <Parameter name="kvaOurPdFloor">0.03</Parameter>
    <Parameter name="kvaTheirPdFloor">0.03</Parameter>
    <Parameter name="kvaOurCvaRiskWeight">0.005</Parameter>
    <Parameter name="kvaTheirCvaRiskWeight">0.05</Parameter>
    <Parameter name="dim">Y</Parameter>
    <Parameter name="dimModel">Regression</Parameter>
    <Parameter name="mva">Y</Parameter>
    <Parameter name="dimQuantile">0.99</Parameter>
    <Parameter name="dimHorizonCalendarDays">14</Parameter>
    <Parameter name="dimRegressionOrder">1</Parameter>
    <Parameter name="dimRegressors">EUR-EURIBOR-3M,USD-LIBOR-3M,USD</Parameter>
    <Parameter name="dimLocalRegressionEvaluations">100</Parameter>
    <Parameter name="dimLocalRegressionBandwidth">0.25</Parameter>
    <Parameter name="dimScaling">1.0</Parameter>
    <Parameter name="dimEvolutionFile">dim_evolution.txt</Parameter>
    <Parameter name="dimRegressionFiles">dim_regression.txt</Parameter>
    <Parameter name="dimOutputNettingSet">CPTY_A</Parameter>
    <Parameter name="dimOutputGridPoints">0</Parameter>
    <Parameter name="rawCubeOutputFile">rawcube.csv</Parameter>
    <Parameter name="netCubeOutputFile">netcube.csv</Parameter>
    <Parameter name="fullInitialCollateralisation">true</Parameter>
    <Parameter name="flipViewXVA">N</Parameter>
    <Parameter name="flipViewBorrowingCurvePostfix">_BORROW</Parameter>
    <Parameter name="flipViewLendingCurvePostfix">_LEND</Parameter>
    <Parameter name="mporCashFlowMode">NonePay</Parameter>
    <Parameter name="generateCorrelations">N</Parameter>
  </Analytic>
</Analytics>
```

</div>

The PFE analytic type is the same as the XVA analytic, however it only
returns results specific to PFE and only requires a subset of the XVA
parameters.

<div class="listing">

``` xml
<Analytics>
  <Analytic type="pfe">
    <Parameter name="active">Y</Parameter>
    <Parameter name="csaFile">netting.xml</Parameter>
    <Parameter name="cubeFile">cube.csv.gz</Parameter>
    <Parameter name="useDoublePrecisionCubes">false</Parameter>
    <Parameter name="scenarioFile">scenariodata.csv.gz</Parameter>
    <Parameter name="baseCurrency">EUR</Parameter>
    <Parameter name="exposureProfiles">Y</Parameter>
    <Parameter name="exposureProfilesByTrade">Y</Parameter>
    <Parameter name="quantile">0.95</Parameter>
    <Parameter name="calculationType">Symmetric</Parameter>
    <Parameter name="allocationMethod">None</Parameter>
    <Parameter name="marginalAllocationLimit">1.0</Parameter>
    <Parameter name="exerciseNextBreak">N</Parameter>
    <Parameter name="rawCubeOutputFile">rawcube.csv</Parameter>
    <Parameter name="netCubeOutputFile">netcube.csv</Parameter>
  </Analytic>
</Analytics>
```

</div>

Parameters:

- `csaFile:` Netting set definitions file covering CSA details such as
  margining frequency, thresholds, minimum transfer amounts, margin
  period of risk

- `cubeFile:` NPV cube file previously generated and to be
  post-processed here

- `useDoublePrecisionCubes:` whether NPV cubes are constructed wit
  double precision, optional, defaults to false (single precision)

- `scenarioFile:` Scenario data previously generated and used in the
  post-processor (simulated index fixings and FX rates)

- `collateralBalancesFile:` References an xml file that contains current
  VM and IM balances by netting set

- `baseCurrency:` Expression currency for all NPVs, value adjustments,
  exposures

- `exposureProfiles:` Flag to enable/disable exposure output for each
  netting set

- `exposureProfilesByTrade:` Flag to enable/disable stand-alone exposure
  output for each trade

- `quantile:` Confidence level for Potential Future Exposure (PFE)
  reporting

- `calculationType:` Determines the settlement of margin calls. The
  admissible choices depend on having a close-out grid, see table
  <a href="#tab:calcTypes" data-reference-type="ref"
  data-reference="tab:calcTypes">[tab:calcTypes]</a>;  

  - *Symmetric* - margin for both counterparties settled after the
    margin period of risk;

  - *AsymmetricCVA* - margin requested from the counterparty settles
    with delay, margin requested from us settles immediately;

  - *AsymmetricDVA* - vice versa

  - *NoLag* - used to disable any delayed settlement of the margin; this
    option is applied in combination with a “close-out” grid, see
    section <a href="#sec:simulation" data-reference-type="ref"
    data-reference="sec:simulation">[sec:simulation]</a>.

  - if there isn’t any “close-out” grid -see section
    <a href="#sec:simulation" data-reference-type="ref"
    data-reference="sec:simulation">[sec:simulation]</a>-, the choices
    are:

    - *Symmetric* - margin for both counterparties settled after the
      margin period of risk;

    - *AsymmetricCVA* - margin requested from the counterparty settles
      with delay, margin requested from us settles immediately;

    - *AsymmetricDVA* - vice versa.

  - If there is a “close-out” grid -see section
    <a href="#sec:simulation" data-reference-type="ref"
    data-reference="sec:simulation">[sec:simulation]</a>-, only choice
    is:

    - *NoLag* - used to disable any delayed settlement of the margin.

  NoLag is the default configuration.

  <div class="tabular">

  !c!c!l! & & Comment  
  & *NoLag* & Not Supported  
  & *Symmetric* & Supported  
  & *AsymmetricCVA* & Supported  
  & *AsymmetricDVA* & Supported  
  & *NoLag* & Supported  
  & *Symmetric* & Not Supported  
  & *AsymmetricCVA* & Not Supported  
  & *AsymmetricDVA* & Not Supported  

  </div>

- `allocationMethod:` XVA allocation method, choices are *None,
  Marginal, RelativeXVA, RelativeFairValueGross, RelativeFairValueNet*

- `marginalAllocationLimit:` The marginal allocation method a la
  Pykhtin/Rosen breaks down when the netting set value vanishes while
  the exposure does not. This parameter acts as a cutoff for the
  marginal allocation when the absolute netting set value falls below
  this limit and switches to equal distribution of the exposure in this
  case.

- `exerciseNextBreak:` Flag to terminate all trades at their next break
  date before aggregation and the subsequent analytics

- `cva, dva, fva, colva, collateralFloor, dim, mva:` Flags to
  enable/disable these analytics.

- `dimModel:` Type of dynamic initial margin model to be applied –
  *Regression* or *Flat*. *Regression* is applied by default when the
  dimModel node is omitted (see appendix and further settings related to
  the regression DIM model below); *Flat* means a simple flat projection
  of todays’s IM amount on each path (this requires providing today’s IM
  using the `collateralBalancesFile` parameter, see above)

- `dvaName:` Credit name to look up the own default probability curve
  and recovery rate for DVA calculation

- `fvaBorrowingCurve:` Identifier of the borrowing yield curve

- `fvaLendingCurve:` Identifier of the lending yield curve

- `dynamicCredit:` Flag to enable using pathwise survival probabilities
  when calculating CVA, DVA, FVA and MVA increments from exposures. If
  set to N the survival probabilities are extracted from T0 curves.

- `kva:` Flag to enable setting the kva ccr parameters.

- `kvaCapitalDiscountRate, kvaAlpha, kvaRegAdjustment, kvaCapitalHurdle, kvaOurPdFloor, kvaTheirPdFloor kvaOurCvaRiskWeight, kvaTheirCvaRiskWeight:`
  the kva CCR parameters (see ).

- `dimQuantile:` Quantile for Dynamic Initial Margin (DIM) calculation

- `dimHorizonCalendarDays:` Horizon for DIM calculation, 14 calendar
  days for 2 weeks, etc.

- `dimRegressionOrder:` Order of the regression polynomial (netting set
  clean NPV move over the simulation period versus netting set NPV at
  period start)

- `dimRegressors:` Variables used as regressors in a single- or
  multi-dimensional regression; these variable names need to match
  entries in the `simulation.xml`’s AggregationScenarioDataCurrencies
  and AggregationScenarioDataIndices sections (only these scenario data
  are passed on to the post processor); if the list is empty, the NPV
  will be used as a single regressor

- `dimLocalRegressionEvaluations:` Nadaraya-Watson local regression
  evaluated at the given number of points to validate polynomial
  regression. Note that Nadaraya-Watson needs a large number of samples
  for meaningful results. Evaluating the local regression at many points
  (samples) has a significant performance impact, hence the option here
  to limit the number of evaluations.

- `dimLocalRegressionBandwidth:` Nadaraya-Watson local regression
  bandwidth in standard deviations of the independent variable (NPV)

- `dimScaling:` Scaling factor applied to all DIM values used, e.g. to
  reconcile simulated DIM with actual IM at $t_0$

- `dimEvolutionFile:` Output file name to store the evolution of zero
  order DIM and average of nth order DIM through time

- `dimRegressionFiles:` Output file name(s) for a DIM regression
  snapshot, comma separated list

- `dimOutputNettingSet:` Netting set for the DIM regression snapshot

- `dimOutputGridPoints:` Grid point(s) (in time) for the DIM regression
  snapshot, comma separated list

- `rawCubeOutputFile:` File name for the trade NPV cube in human
  readable csv file format (per trade, date, sample), leave empty to
  skip generation of this file.

- `netCubeOutputFile:` File name for the aggregated NPV cube in human
  readable csv file format (per netting set, date, sample) *after*
  taking collateral into account. Leave empty to skip generation of this
  file.

- `fullInitialCollateralisation:` If set to `true`, then for every
  netting set, the collateral balance at $t=0$ will be set to the NPV of
  the setting set. The resulting effect is that EPE, ENE and PFE are all
  zero at $t=0$. If set to `false` (default value), then the collateral
  balance at $t=0$ will be set to zero.

- `flipViewXVA:` If set to `Y`, the perspective in XVA calculations is
  switched to the cpty view, the npvs and the netting sets being
  reverted during calculation. In order to get the lending/borrowing
  curve, the calculation assumes these curves being set up with the
  cptyname + the postfix given in the next two settings.

- `flipViewBorrowingCurvePostfix:` postfix for the borrowing curve, the
  calculation assumes this is curves being set up with cptyname +
  postfix given.

- `flipViewLendingCurvePostfix:` postfix for the lending curve, the
  calculation assumes this is curve being set up with cptyname + postfix
  given.

- `mporCashFlowMode:` Assumption about payment of cashflows within mpor
  period. One of NonePay, BothPay, WePay, TheyPay, Unspecified. Defaults
  to Unspecified, in this case PP will assume NonePay if mpor sticky
  date is used, otherwise to BothPay.

The two cube file outputs `rawCubeOutputFile` and `netCubeOutputFile`
are provided for further analysis.

### Sensitivity and Stress Testing

The `sensitivity` and `stress` ‘analytics’ provide computation of bump
and revalue sensitivities and NPV changes under user defined stress
scenarios. Listing
<a href="#lst:ore_sensitivity" data-reference-type="ref"
data-reference="lst:ore_sensitivity">[lst:ore_sensitivity]</a> shows a
typical configuration for sensitivity calculation.

<div class="listing">

``` xml
<Analytics>
 <Analytic type="sensitivity">
   <Parameter name="active">Y</Parameter>
   <Parameter name="marketConfigFile">simulation.xml</Parameter>
   <Parameter name="sensitivityConfigFile">sensitivity.xml</Parameter>
   <Parameter name="pricingEnginesFile">../../Input/pricingengine.xml</Parameter>
   <Parameter name="scenarioOutputFile">scenario.csv</Parameter>
   <Parameter name="sensitivityOutputFile">sensitivity.csv</Parameter>
   <Parameter name="crossGammaOutputFile">crossgamma.csv</Parameter>
   <Parameter name="outputSensitivityThreshold">0.000001</Parameter>
   <Parameter name="recalibrateModels">Y</Parameter>
   <!-- Additional parametrisation for par sensitivity analysis -->
   <Parameter name="parSensitivity">Y</Parameter>
   <Parameter name="parSensitivityOutputFile">parsensitivity.csv</Parameter>
   <Parameter name="outputJacobi">Y</Parameter>
   <Parameter name="jacobiOutputFile">jacobi.csv</Parameter>
   <Parameter name="jacobiInverseOutputFile">jacobi_inverse.csv</Parameter>
   <Parameter name="decomposeIndexSensitivities">Y</Parameter>
 </Analytic>
</Analytics>
```

</div>

The parameters have the following interpretation:

- `marketConfigFile:` Configuration file defining the simulation market
  under which sensitivities are computed, see
  <a href="#sec:simulation" data-reference-type="ref"
  data-reference="sec:simulation">[sec:simulation]</a>. Only a subset of
  the specification is needed (the one given under `Market`, see
  <a href="#sec:sim_market" data-reference-type="ref"
  data-reference="sec:sim_market">[sec:sim_market]</a> for a detailed
  description).

- `sensitivityConfigFile:` Configuration file for the sensitivity
  calculation, see section
  <a href="#sec:sensitivity" data-reference-type="ref"
  data-reference="sec:sensitivity">[sec:sensitivity]</a>.

- `pricingEnginesFile:` Configuration file for the pricing engines to be
  used for sensitivity calculation.

- `scenarioOutputFile:` File containing the results of the sensitivity
  calculation in terms of the base scenario NPV, the scenario NPV and
  their difference.

- `sensitivityOutputFile:` File containing the results of the
  sensitivity calculation in terms of the base scenario NPV, the shift
  size together with the risk-factor and the resulting first and (pure)
  second order finite differences. Also included is a second set of
  shift sizes together with the risk-factor with a (mixed) second order
  finite difference associated to a cross gamma calculation

- `outputSensitivityThreshold:` Only finite differences with absolute
  value greater than this number are written to the output files.

- `recalibrateModels:` If set to Y, then recalibrate pricing models
  after each shift of relevant term structures; otherwise do not
  recalibrate

- `parSensitivity`: If set to Y, par sensitivity analysis is performed
  following the “raw” sensitivity analysis; note that in this case the
  `sensitivityConfigFile` needs to contain `ParConversion` sections, see
  `Example_40`

- `parSensitivityOutputFile`: Output file name for the par sensitivity
  report

- `outputJacobi`: If set to Y, then the relevant Jacobi and inverse
  Jacobi matrix is written to a file, see below

- `jacobiOutputFile`: Output file name for the Jacobi matrix

- `jacobiInverseOutputFile`: Output file name for the inverse Jacobi
  matrix

- `decomposeIndexSensitivities`: Decompose Credit index and Equity and
  Commodity index sensitivities into constituent sensitivities

The decomposition of index sensitivities is controlled as follows:

- **Credit Index Decomposition:** Enabled via the
  `SensitivityDecomposition` flag in the pricing engine settings for
  `IndexCreditDefaultSwap`, `IndexCreditDefaultSwapOption`, and
  `SyntheticCDO` (see pricing engine parameterisation,
  Section <a href="#sec:configuration_pricingengines" data-reference-type="ref"
  data-reference="sec:configuration_pricingengines">[sec:configuration_pricingengines]</a>).

- **Equity and Commodity Index Decomposition:** Controlled at the trade
  level by adding the field `index_decomposition` to the trade
  envelope’s `AdditionalFields` section, as shown in
  Listing <a href="#lst:eq_index_decomposition" data-reference-type="ref"
  data-reference="lst:eq_index_decomposition">[lst:eq_index_decomposition]</a>.

<div class="listing">

``` xml
<Envelope>
  ...
  <AdditionalFields>
    <index_decomposition>true</index_decomposition>
  </AdditionalFields>
</Envelope>
```

</div>

Equity index decomposition is supported for `EquitySwap` and
`GenericTRS` trades, while commodity index decomposition is available
for `GenericTRS` trades.

To enable index decomposition, appropriate reference data for credit,
equity, or commodity indices must be provided.

The conversion of “raw” to “par” sensitivities, embedded above, can also
be performed as a separate step by calling the
`zeroToParSensiConversion` analytic as shown in Listing
<a href="#lst:ore_zerotoparsensi" data-reference-type="ref"
data-reference="lst:ore_zerotoparsensi">[lst:ore_zerotoparsensi]</a>.
The raw sensitivities are passed in (parameter sensitivityInputFile),
all other parameters as above.

<div class="listing">

``` xml
  <Analytics>
    <Analytic type="zeroToParSensiConversion">
      <Parameter name="active">Y</Parameter>
      <Parameter name="marketConfigFile">simulation.xml</Parameter>
      <Parameter name="sensitivityConfigFile">sensitivity.xml</Parameter>
      <Parameter name="pricingEnginesFile">../../Input/pricingengine.xml</Parameter>
      <Parameter name="sensitivityInputFile">sensitivity.csv</Parameter>
      <Parameter name="outputThreshold">0.000001</Parameter>
      <Parameter name="outputFile">parconversion_sensitivity.csv</Parameter>
      <Parameter name="outputJacobi">Y</Parameter>
      <Parameter name="jacobiOutputFile">jacobi.csv</Parameter>
      <Parameter name="jacobiInverseOutputFile">jacobi_inverse.csv</Parameter>
    </Analytic>
  </Analytics>
```

</div>

The parameters have the same interpretation as for the sensitivity
analytic. There is one new parameter \*sensitivityInputFile\* which
points to a csv file with the raw (zero)sensitivities. Those raw
sensitivities will be converted into par sensitivities, using the same
methodology as in the embedded approach above, and the configuration is
described in <a href="#sec:sensitivity" data-reference-type="ref"
data-reference="sec:sensitivity">[sec:sensitivity]</a>. The raw
sensitivities csv input file \*sensitivityInputFile\* needs to have at
least six columns, the column names can be user configured in the master
input file. Here is a description of each of the columns:

1.  idColumn: Column with a unique identifier for the trade / nettingset
    / portfolio.

2.  riskFactorColumn: Column with the identifier of the zero/raw
    sensitiviy. The risk factor name needs to follow the ORE naming
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

Here is an example for an input file:

<div class="center">

|     | \#TradeId | Factor_1               | ShiftSize_1 | Currency | Base NPV | Delta |
|:----|:----------|:-----------------------|------------:|:---------|---------:|------:|
| 0   | Swap      | DiscountCurve/EUR/3/6M |      0.0001 | EUR      |  1335.27 |  5.05 |
| 1   | Swap      | DiscountCurve/EUR/4/9M |      0.0001 | EUR      |  1335.27 |  0.35 |
| 2   | Swap      | DiscountCurve/EUR/5/1Y |      0.0001 | EUR      |  1335.27 | -5.41 |
| 3   | Swap      | DiscountCurve/EUR/6/2Y |      0.0001 | EUR      |  1335.27 | -0.22 |
| 4   | Swap      | DiscountCurve/EUR/7/3Y |      0.0001 | EUR      |  1335.27 | -0.32 |

</div>

The `stress` analytics configuration is similar to the one of the
sensitivity calculation. Listing
<a href="#lst:ore_stress" data-reference-type="ref"
data-reference="lst:ore_stress">[lst:ore_stress]</a> shows a
configuration example.

<div class="listing">

``` xml
<Analytics>
 <Analytic type="stress">
   <Parameter name="active">Y</Parameter>
   <Parameter name="marketConfigFile">simulation.xml</Parameter>
   <Parameter name="stressConfigFile">stresstest.xml</Parameter>
   <Parameter name="pricingEnginesFile">../../Input/pricingengine.xml</Parameter>
   <Parameter name="scenarioOutputFile">stresstest.csv</Parameter>
   <Parameter name="precision">6</Parameter>
   <Parameter name="outputThreshold">0.000001</Parameter>
   <Parameter name="stressZeroScenarioDataFile">zeroStressScenarioData.xml</Parameter>
   <Parameter name="generateCashflows">true</Parameter>
 </Analytic>
</Analytics>
```

</div>

The parameters have the same interpretation as for the sensitivity
analytic. The configuration file for the stress scenarios is described
in more detail in section
<a href="#sec:stress" data-reference-type="ref"
data-reference="sec:stress">[sec:stress]</a>. That file will also
determine whether the stress test is performed in the “raw” or “par”
domain. In the latter par stress case, the last parameter
(stressZeroScenarioDataFile) causes exporting equivalent stress test
definitions in the “raw” domain. The `precision` parameter defines the
number of digits for the sensitivities in the stress output file.

Finally, the `parStressConversion` analytic carves out the generation of
a stress test configuration in the “raw” domain from a stress test
configuration in the par domain, see Listing
<a href="#lst:ore_parstressconversion" data-reference-type="ref"
data-reference="lst:ore_parstressconversion">[lst:ore_parstressconversion]</a>,
with same parameters as in Listing
<a href="#lst:ore_stress" data-reference-type="ref"
data-reference="lst:ore_stress">[lst:ore_stress]</a> above. This
analytic does not perform a stress test, just generates the raw domain
stress configuration so that it can be applied repeatedly .

<div class="listing">

``` xml
  <Analytics>
    <Analytic type="parStressConversion">
       <Parameter name="active">Y</Parameter>
       <Parameter name="marketConfigFile">simulation.xml</Parameter>
       <Parameter name="stressConfigFile">stresstest.xml</Parameter>
       <Parameter name="sensitivityConfigFile">sensitivity.xml</Parameter>
       <Parameter name="pricingEnginesFile">pricingengine.xml</Parameter>
       <Parameter name="scenarioOutputFile">stresstest.csv</Parameter>
       <Parameter name="outputThreshold">0.000001</Parameter>
       <Parameter name="stressZeroScenarioDataFile">results.xml</Parameter>
     </Analytic>
  </Analytics>
```

</div>

The new analytic type *SENSITIVITY_STRESS* combines the existing
stresstest and sensitivity analysis frameworks. During the sensitivity
calculation it replaces todaysMarket with a SimulationMarket in
accordance with the stresstest scenario and runs sensitivity analytic
afterwards. The analytic loops over all provided stresstest scenarios.

<div class="listing">

``` xml
    <Analytics>
      <Analytic type="sensitivityStress">
        <Parameter name="active">Y</Parameter>
        <Parameter name="marketConfigFile">simulation.xml</Parameter>
        <Parameter name="stressConfigFile">stresstest.xml</Parameter>
        <Parameter name="sensitivityConfigFile">sensitivity.xml</Parameter>
        <Parameter name="calcBaseScenario">N</Parameter>
      </Analytic>
    </Analytics>
```

</div>

The parameters have the following interpretation:

- `marketConfigFile:` Configuration file defining the simulation market
  under which sensitivities are computed, see
  <a href="#sec:simulation" data-reference-type="ref"
  data-reference="sec:simulation">[sec:simulation]</a>. Only a subset of
  the specification is needed (the one given under `Market`, see
  <a href="#sec:sim_market" data-reference-type="ref"
  data-reference="sec:sim_market">[sec:sim_market]</a> for a detailed
  description).

- `stressConfigFile:` Stress Scenario definition, see section
  <a href="#sec:stress" data-reference-type="ref"
  data-reference="sec:stress">[sec:stress]</a>

- `sensitivityConfigFile:` Configuration file for the sensitivity
  calculation, see section
  <a href="#sec:sensitivity" data-reference-type="ref"
  data-reference="sec:sensitivity">[sec:sensitivity]</a>.

- `calcBaseScenario`: If set to true, unshifted BASE scenario will also
  be calculated. Defaults to false.

See the examples in sections
<a href="#example:marketrisk" data-reference-type="ref"
data-reference="example:marketrisk">[example:marketrisk]</a> for a
demonstrations of these analytics.

### Value at Risk

The `VaR` analytics provide computation of Value-at-Risk measures based
on the sensitivity (delta, gamma, cross gamma) data above. Listing
<a href="#lst:ore_var" data-reference-type="ref"
data-reference="lst:ore_var">[lst:ore_var]</a> shows a configuration
example.

<div class="listing">

``` xml
<Analytics>
    <Analytic type="parametricVar">
      <Parameter name="active">Y</Parameter>
      <Parameter name="portfolioFilter">PF1|PF2</Parameter>
      <Parameter name="sensitivityInputFile">
         ../Output/sensitivity.csv,../Output/crossgamma.csv
      </Parameter>
      <Parameter name="covarianceInputFile">covariance.csv</Parameter>
      <Parameter name="SalvagingAlgorithm">None</Parameter>
      <Parameter name="quantiles">0.01,0.05,0.95,0.99</Parameter>
      <Parameter name="breakdown">Y</Parameter>
      <!-- Delta, DeltaGammaNormal, Cornish-Fisher, Saddlepoint, MonteCarlo -->
      <Parameter name="method">DeltaGammaNormal</Parameter>
      <Parameter name="mcSamples">100000</Parameter>
      <Parameter name="mcSeed">42</Parameter>
      <Parameter name="outputFile">var.csv</Parameter>
    </Analytic>
</Analytics>
```

</div>

The parameters have the following interpretation:

- p͡ortfolioFilter: Regular expression used to filter the portfolio for
  which VaR is computed; if the filter is not provided, then the full
  portfolio is processed

- `sensitivityInputFile:` Reference to the sensitivity (deltas, vegas,
  gammas) and cross gamma input as generated by ORE in a comma separated
  list

- `covarianceFile:` Reference to the covariances input data; these are
  currently not calculated in ORE and need to be provided externally, in
  a blank/tab/comma separated file with three columns (factor1, factor2,
  covariance), where factor1 and factor2 follow the naming convention
  used in ORE’s sensitivity and cross gamma output files. Covariances
  need to be consistent with the sensitivity data provided. For example,
  if sensitivity to factor1 is computed by absolute shifts and expressed
  in basis points, then the covariances with factor1 need to be based on
  absolute basis point shifts of factor1; if sensitivity is due to a
  relative factor1 shift of 1%, then covariances with factor1 need to be
  based on relative shifts expressed in percentages to, etc. Also note
  that covariances are expected to include the desired holding period,
  i.e. no scaling with square root of time etc is performed in ORE;

- `SalvagingAlgorithm:` Allowable values are: *None*, *Spectral*,
  *Hypersphere*, *LowerDiagonal* or *Highham*. If omitted, it defaults
  to None. Compare .

- `quantiles:` Several desired quantiles can be specified here in a
  comma separated list; these lead to several columns of results in the
  output file, see below. Note that e.g. the 1% quantile corresponds to
  the lower tail of the P&L distribution (VaR), 99% to the upper tail.

- `breakdown:` If yes, VaR is computed by portfolio, risk class (All,
  Interest Rate, FX, Inflation, Equity, Credit) and risk type (All,
  Delta & Gamma, Vega)

- `method:` Choices are *Delta, DeltaGammaNormal, MonteCarlo*, see

- `mcSamples:` Number of Monte Carlo samples used when the *MonteCarlo*
  method is chosen

- `mcSeed:` Random number generator seed when the *MonteCarlo* method is
  chosen

- `outputFile:` Output file name

See the example in section
<a href="#example:marketrisk_parametricvar" data-reference-type="ref"
data-reference="example:marketrisk_parametricvar">[example:marketrisk_parametricvar]</a>
for a demonstration.

### Correlation

The `Correlation` analytic provide computation of the correlation matrix
based on the generated historical scenarios. Listing
<a href="#lst:ore_corr" data-reference-type="ref"
data-reference="lst:ore_corr">[lst:ore_corr]</a> shows a configuration
example.

<div class="listing">

``` xml
<Analytics>
  <Analytic type="correlation">
      <Parameter name="active">Y</Parameter>
      <Parameter name="correlation_method">Pearson</Parameter>
      <Parameter name="marketConfigFile">simulation.xml</Parameter>
      <Parameter name="historicalScenarioFile">scenarios.csv</Parameter>
      <Parameter name="sensitivityConfigFile">sensitivity.xml</Parameter>
      <Parameter name="historicalPeriod">2016-12-30,2019-12-30</Parameter>
      <Parameter name="mporDays">10</Parameter>
      <Parameter name="mporCalendar">USD</Parameter>
      <Parameter name="outputFile">correlation.csv</Parameter>
    </Analytic>
</Analytics>
```

</div>

The parameters have the following interpretation:

- `correlation_method`: Regular expression used to filter the portfolio
  for which VaR is computed; if the filter is not provided, then the
  full portfolio is processed

- `marketConfigFile`: Configuration file defining the simulation market
  under which sensitivities are computed, see
  <a href="#sec:simulation" data-reference-type="ref"
  data-reference="sec:simulation">[sec:simulation]</a>. Only a subset of
  the specification is needed (the one given under `Market`, see
  <a href="#sec:sim_market" data-reference-type="ref"
  data-reference="sec:sim_market">[sec:sim_market]</a> for a detailed
  description).

- `historicalScenarioFile`: csv file containing the market scenarios for
  each date in the observation periods defined below; the granularity of
  the scenarios (e.g. discount and index curves, number of yield curve
  tenors) needs to match the simulation market definition above; each
  yield curve tenor scenario is represented as a discount factor.

- `sensitivityConfigFile`: Sensitivity parameterisation for the
  sensitivity analysis on asofDate.

- `historicalPeriod`: comma-separated date list, an even number of
  ordered dates is required (d1, d2, d3, d4, ...), where each pair
  (d1-d2, d3-d4, ...) defines the start and end of historical
  observation periods used.

- `mporDays`: Alternatively, the second date can be specified in terms
  of calendar days from asofDate.

- `mporCalendar`: Calendar for computing the mporDate from asofDate and
  mporDays.

- `outputFile`: Output file name

See the example in section
<a href="#example:marketrisk_correlation" data-reference-type="ref"
data-reference="example:marketrisk_correlation">[example:marketrisk_correlation]</a>
for a demonstration.

### P&L, P&L Explain, ZeroToParShift, Scenario

The `pnl` and `pnlExplain` analytics provide computation of a
single-period P&L and its “explanation” in terms of “raw” or “par”
sensitivities. Listings <a href="#lst:ore_pnl" data-reference-type="ref"
data-reference="lst:ore_pnl">[lst:ore_pnl]</a> and
<a href="#lst:ore_pnlexplain" data-reference-type="ref"
data-reference="lst:ore_pnlexplain">[lst:ore_pnlexplain]</a> show
configuration examples.

<div class="listing">

``` xml
  <Setup>
    <Parameter name="asofDate">2023-01-31</Parameter>
    ...
  </Setup>

  <Analytics>
    <Analytic type="pnl">
      <Parameter name="active">Y</Parameter>
      <!--<Parameter name="mporDate">2023-02-14</Parameter>-->
      <Parameter name="mporDays">10</Parameter>
      <Parameter name="mporCalendar">US</Parameter>
      <Parameter name="simulationConfigFile">simulation.xml</Parameter>
      <Parameter name="curveConfigMporFile">curveconfig.xml</Parameter>
      <Parameter name="conventionsMporFile">conventions.xml</Parameter>
      <Parameter name="portfolioMporFile">mporportfolio.xml</Parameter>
      <Parameter name="outputFileName">pnl.csv</Parameter>
      <Parameter name="dateAdjustedRiskFactors">CommodityCurve</Parameter>
    </Analytic>
  </Analytics>
```

</div>

The parameters in Listing
<a href="#lst:ore_pnl" data-reference-type="ref"
data-reference="lst:ore_pnl">[lst:ore_pnl]</a> have the following
interpretation:

- `mporDate`: The second (later) of the two valuation dates for the P&L
  calculation. The first date is given by the asofDate in the Setup
  section. Note that market data needs to be provided for both dates.

- `mporDays`: Alternatively, the second date can be specified in terms
  of calendar days from asofDate.

- `mporCalendar`: Calendar for computing the mporDate from asofDate and
  mporDays.

- `simulationFile`: Parameterisation of the simulation market which
  determines which market factors are evolved from asofDate to mporDate
  to compute the P&L.

- `curveConfigMporFile`, `conventionsMporFile`: Parametrisation to be
  applied at the mporDate; this may be different from the configuration
  on asofDate which is provided in the Setup section.

- `conventionsMporFile`: Conventions applied at the mporDate

- `portfolioMporFile` \[Optional\]: The portfolio on mporDate which is
  usually different from the portfolio on asofDate.

- `dateAdjustedRiskFactors` \[Optional\]: List of risk factor types
  (e.g., CommodityCurve) for which scenario dates at the mporDate are
  adjusted relative to the asofDate when computing P&L Explain. This
  adjustment is particularly important for commodity curves, so that
  scenario dates reference the same future contracts at both mporDate
  and asofDate.

<div class="listing">

``` xml
  <Analytics>
    <Analytic type="pnlExplain">
      <Parameter name="active">Y</Parameter>
      <Parameter name="mporDate">2023-02-14</Parameter>
      <Parameter name="simulationConfigFile">simulation.xml</Parameter>
      <Parameter name="curveConfigMporFile">curveconfig.xml</Parameter>
      <Parameter name="conventionsMporFile">conventions.xml</Parameter>
      <Parameter name="portfolioMporFile">mporportfolio.xml</Parameter>
      <Parameter name="outputFileName">pnl_explain.csv</Parameter>
      <Parameter name="dateAdjustedRiskFactors">CommodityCurve</Parameter>
      <Parameter name="sensitivityConfigFile">sensitivity.xml</Parameter>
      <Parameter name="parSensitivity">Y</Parameter>
      <Parameter name="riskFactorLevelReporting">Y</Parameter>
    </Analytic>
  </Analytics>
```

</div>

The additional parameters in Listing
<a href="#lst:ore_pnlexplain" data-reference-type="ref"
data-reference="lst:ore_pnlexplain">[lst:ore_pnlexplain]</a> have the
following interpretation:

- `sensitivityConfigFile`: Sensitivity parameterisation for the
  sensitivity analysis on asofDate

- `parSensitivity`: Boolean to specify whether par sesnitivities should
  be used in the P&L explanation; “raw” sensitivities will be used by
  default.

- `riskFactorLevelReporting`: Enables P&L explanation with decomposition
  by risk factor.

See the example in section
<a href="#example:marketrisk_pnl" data-reference-type="ref"
data-reference="example:marketrisk_pnl">[example:marketrisk_pnl]</a> for
a demonstration of the P&L and P&L Explain analytics.

The `pnlExplain` analytic above - when based on par sensitivities -
needs market *par rate* shifts between two dates. ORE’s scenario
machinery operates in the “raw” domain primarily, so that a utility is
useful that converts raw market moves into equivalent par market moves.
The analytic in Listing
<a href="#lst:ore_zerotoparshift" data-reference-type="ref"
data-reference="lst:ore_zerotoparshift">[lst:ore_zerotoparshift]</a> can
be used for that purpose.

<div class="listing">

``` xml
  <Analytics>
     <Analytic type="zeroToParShift">
         <Parameter name="active">Y</Parameter>
         <Parameter name="marketConfigFile">simulation.xml</Parameter>
         <Parameter name="stressConfigFile">stresstest.xml</Parameter>
         <Parameter name="sensitivityConfigFile">sensitivity.xml</Parameter>
         <Parameter name="pricingEnginesFile">pricingengine.xml</Parameter>
         <Parameter name="scenarioOutputFile">stresstest.csv</Parameter>
         <Parameter name="parShiftsFile">parshifts.csv</Parameter>
     </Analytic>
  </Analytics>
```

</div>

See the example in section
<a href="#example:marketrisk_zerotoparshift" data-reference-type="ref"
data-reference="example:marketrisk_zerotoparshift">[example:marketrisk_zerotoparshift]</a>
for a demonstration.

The `scenario` analytic is a utility to export the simulation market’s
base scenario as a file. This is also used in the context of P&L
calculations. The configuration is minimal as shown n Listing
<a href="#lst:ore_scenario" data-reference-type="ref"
data-reference="lst:ore_scenario">[lst:ore_scenario]</a>.

<div class="listing">

``` xml
<Analytics>
    <Analytic type="scenario">
      <Parameter name="active">Y</Parameter>
      <Parameter name="simulationConfigFile">simulation.xml</Parameter>
      <Parameter name="scenarioOutputFile">scenario.csv</Parameter>
    </Analytic>
</Analytics>
```

</div>

See the example in section
<a href="#example:marketrisk_basescenario" data-reference-type="ref"
data-reference="example:marketrisk_basescenario">[example:marketrisk_basescenario]</a>.

### Initial Margin: ISDA SIMM and IM Schedule, CRIF Generation

The `simm` ‘analytic’ provides computation of initial margin using
ISDA’s Standard Initial Margin Model (SIMM) based on sensitivities in
the Common Risk Interchange Format (CRIF) defined by ISDA. Listing
<a href="#lst:ore_simm" data-reference-type="ref"
data-reference="lst:ore_simm">[lst:ore_simm]</a> shows a configuration
example.

<div class="listing">

``` xml
  <Analytics>
    <Analytic type="simm">
      <Parameter name="active">Y</Parameter>
      <Parameter name="version">2.6.5</Parameter>
      <Parameter name="crif">crif.csv</Parameter>
      <Parameter name="calculationCurrency">USD</Parameter>
      <Parameter name="calculationCurrencyCall">USD</Parameter>
      <Parameter name="calculationCurrencyPost">USD</Parameter>
      <Parameter name="resultCurrency">USD</Parameter>
      <Parameter name="reportingCurrency">USD</Parameter>
      <Parameter name="enforceIMRegulations">Y</Parameter>
      <Parameter name="mporDays">10</Parameter>
      <Parameter name="simmCalibration">simm_calibration.xml</Parameter>
      <Parameter name="writeIntermediateReports">N</Parameter>
    </Analytic>
  </Analytics>
```

</div>

The parameters in Listing
<a href="#lst:ore_simm" data-reference-type="ref"
data-reference="lst:ore_simm">[lst:ore_simm]</a> have the following
interpretation:

- `version`: SIMM version, ORE supports versions 1.0, 1.1, 1.2, 1.3,
  1.3.38, 2.0, 2.1, 2.2, 2.3, 2.4, 2.5, 2.5A, 2.6, 2.6.5; the latest
  version as of December 2024

- `crif`: CRIF file name.  
  If the crif.csv input is omitted, then the ORE crif analytic (see
  below) is used internally to generate the CRIF input. However, CRIF
  generation in ORE is limited to IR/FX risks, whereas the SIMM analytic
  can process a full CRIF across IR/FX/INF/EQ/CR/COM risks.

- `calculationCurrency`: Determines which `Risk_FX` entries of the CRIF
  will be ignored in the SIMM calculation

- `calculationCurrencyCall` \[Optional\]: Separate calculation currency
  for the SIMM to call

- `calculationCurrencyPost` \[Optional\]: Separate calculation currency
  for the SIMM to post

- `resultCurrency` \[Optional\]: Currency of the resulting SIMM amounts
  in the report, by default equal to the calculation currency

- `reportingCurrency` \[Optional\]: Adds extra columns to the SIMM
  report (reporting currency and converted SIMM amount)

- `enforceIMRegulations`: If true, SIMM is calculated per post/collect
  regulation (passed for each record in the CRIF), and finally the worst
  case SIMM is reported; the flag is set to false by default i.e. post
  and collect regulations in the CRIF file are ignored.

- `mporDays`: 1 or 10; ORE supports both choices for versions from 2.2
  onwards, only 10 is supported for earlier versions.

- `simmCalibration` \[Optional\]: SIMM model calibration (in a nutshell:
  risk weights and correlations) passed as a file; if provided, it
  overrides the version code above

See the example in section
<a href="#example:initialmargin" data-reference-type="ref"
data-reference="example:initialmargin">[example:initialmargin]</a>.

The `crif` analytic generates a `crif.csv`, input for the ISDA SIMM
calculation. CRIF generation in ORE is limited to IR/FX risks. Listing
<a href="#lst:ore_crif" data-reference-type="ref"
data-reference="lst:ore_crif">[lst:ore_crif]</a> shows a configuration
example.

<div class="listing">

``` xml
  <Analytics>
    <Analytic type="crif">
      <Parameter name="active">N</Parameter>
      <Parameter name="marketConfigFile">crifmarket.xml</Parameter>
      <Parameter name="sensitivityConfigFile">sensitivity.xml</Parameter>
      <Parameter name="baseCurrency">EUR</Parameter>
      <Parameter name="simmVersion">2.7</Parameter>
      <Parameter name="crifOutputFile">crif.csv</Parameter>
    </Analytic>
  </Analytics>
```

</div>

CRIF generation is based on par sensitivity analysis with a SIMM
specific sensitivity configuration and some subsequent labeleing of the
sensitivities so that the resulting output file satisfies the ISDA CRIF
format. The resulting crif.csv can be fed into the SIMM analytic in
<a href="#lst:ore_simm" data-reference-type="ref"
data-reference="lst:ore_simm">[lst:ore_simm]</a>.

The `imschedule` analytic computes the basic Initial Margin calculation
using the “IM Schedule” method based on minimal trade information (NPV,
notional, end date) provided in the CRIF file. Listing
<a href="#lst:ore_imschedule" data-reference-type="ref"
data-reference="lst:ore_imschedule">[lst:ore_imschedule]</a> shows the
analytic parameterisation.

<div class="listing">

``` xml
  <Analytics>
    <Analytic type="imschedule">
      <Parameter name="active">Y</Parameter>
      <Parameter name="crif">crif_schedule.csv</Parameter>
      <Parameter name="calculationCurrency">USD</Parameter>
    </Analytic>
  </Analytics>
```

</div>

The specific CRIF file for that case is expected to provide two lines
per trade, one with RiskClass = PV and one with RiskClass = Notional, so
that the amounts in these CRIF lines are interpeted as NPV respectively
notional. Further required columns are product class and end date.

Note that the product class has to be in

- Rates

- FX

- Equity

- Credit

- Commodity

in contrast to SIMM where we use the combined RatesFX product class.

This analytic is also demonstrated and discussed in section
<a href="#example:initialmargin" data-reference-type="ref"
data-reference="example:initialmargin">[example:initialmargin]</a>.

### XVA Stress Testing

The `XVA stress` and `XVA sensitivity` ‘analytics’ provide computation
of bump and revalue XVA sensitivities and XVA changes under user defined
stress scenarios. Listing
<a href="#lst:ore_xva_stress" data-reference-type="ref"
data-reference="lst:ore_xva_stress">[lst:ore_xva_stress]</a> shows a
typical configuration for XVA stress calculation.

<div class="listing">

``` xml
<Analytics>
 <Analytic type="xvaStress">
    <Parameter name="active">Y</Parameter>
    <Parameter name="marketConfigFile">simulation.xml</Parameter>
    <Parameter name="stressConfigFile">stresstest.xml</Parameter>
    <Parameter name="sensitivityConfigFile">sensitivity_stress.xml</Parameter>
    <Parameter name="writeCubes">N</Parameter>
  </Analytic>
</Analytics>
```

</div>

The parameters have the following interpretation:

- `marketConfigFile:` Configuration file defining the simulation market
  under which sensitivities are computed, see
  <a href="#sec:simulation" data-reference-type="ref"
  data-reference="sec:simulation">[sec:simulation]</a>. Only a subset of
  the specification is needed (the one given under `Market`, see
  <a href="#sec:sim_market" data-reference-type="ref"
  data-reference="sec:sim_market">[sec:sim_market]</a> for a detailed
  description).

- `stressConfigFile:` Stress Scenario definition, see section
  <a href="#sec:stress" data-reference-type="ref"
  data-reference="sec:stress">[sec:stress]</a>

- `sensitivityConfigFile:` Configuration file for the sensitivity
  calculation, see section
  <a href="#sec:sensitivity" data-reference-type="ref"
  data-reference="sec:sensitivity">[sec:sensitivity]</a>.

- `writeCubes:` Boolean flag, if true ORE outputs the raw and net cube
  under each scenario, defaults to false.

Stress Tests can be used to compute stressed value adjustments. The
stress tests for the XVA stress test analytic are defined in the regular
NPV stress test format (see
<a href="#sec:stress" data-reference-type="ref"
data-reference="sec:stress">[sec:stress]</a>).

The XVA stress analytic builds a stress scenario generator and a
scenario simulation market. The simulation market replaces the
todaysMarket in the XVA analytic to compute the value adjustments under
a stress scenario.

For performance reasons it is recommended to use AMC simulation if
possible.

For some risk factors the simulation market behaves a different to the
todays market. For example it could use different tenor structure for
the curves or it uses only the swaption ATM vols if the volatilities
aren’t simulated. Therefore it is recommended to activate   
t UseSpreadedTermStructures in the stress tests scenario parameerisation
and activate the swaption volatility simulation for the stress test run.

There is no dedicated parametrisations for the xva and exposure settings
for the stress test, ORE reuses the existing ones for the regular
exposure and xva analytics. But the xva and exposure analytic themselves
can be deactivated.

For an example see
<a href="#example:xvarisk_stress" data-reference-type="ref"
data-reference="example:xvarisk_stress">[example:xvarisk_stress]</a>.

### XVA Sensitivity

The XVA sensitivity analytics configuration is similar to the one of the
XVA stress calculation. Listing
<a href="#lst:ore_xva_sensi" data-reference-type="ref"
data-reference="lst:ore_xva_sensi">[lst:ore_xva_sensi]</a> shows an
example.

<div class="listing">

``` xml
<Analytics>
    <Analytic type="xvaSensitivity">
      <Parameter name="active">Y</Parameter>
      <Parameter name="marketConfigFile">simulation.xml</Parameter>
      <Parameter name="sensitivityConfigFile">sensitivity.xml</Parameter>
      <Parameter name="parSensitivity">Y</Parameter>
    </Analytic>
</Analytics>
```

</div>

For both analytics ORE reuses the parameterisations of the exposure and
XVA analtyic. One needs to setup those analytics as usual but one can
deactivate them. See listings
<a href="#lst:ore_xva" data-reference-type="ref"
data-reference="lst:ore_xva">[lst:ore_xva]</a> and
<a href="#lst:ore_simulation" data-reference-type="ref"
data-reference="lst:ore_simulation">[lst:ore_simulation]</a>. If set to
active, ORE will run the regular XVA analytic and the XVA sensitivity or
XVA stress analytic, respectively.

Similar to the XVA Stress Analytic ORE can compute bump and revaluation
sensitivities for value adjustments. The XVA Sensitivitiy Analytic uses
the same sensitivity scenario input as the regular sensitivity analytic
(see <a href="#sec:sensitivity" data-reference-type="ref"
data-reference="sec:sensitivity">[sec:sensitivity]</a>).

ORE computes the XVA and exposure measures under each sensitivity
scenario. If the parSensitivity flag is set to true, an additional set
of par sensitivity outputs is generated.

The XVA Sensitivity Analytic replaces the todaysMarket in the exposure
simulation with a ScenarioSimMarket. For some risk factors the
simulation market behaves different to the todays market, e.g. uses a
different tenor structure for building the curves or uses only the
swaption ATM vols if the volatilities aren’t simulated. To minimize some
of the effects, it is recommended to activate   
t UseSpreadedTermStructures in the stress test scenarios and activate
the swaption volatility simulation for the stress test run (see also ).

As in the XVA Stress analytic, there is no dedicated parametrisation for
the xva and exposure settings for the XVA Sensitivity Analytic, ORE
reuses the existing ones for the regular exposure and xva analytics.

For an example see
<a href="#example:xvarisk_sensi" data-reference-type="ref"
data-reference="example:xvarisk_sensi">[example:xvarisk_sensi]</a>.

### XVA Explain

The `XVA explain` ‘analytic’ provide the computation of the market
implied changes of the value adjustments between to evaluation dates
$XVA(t_0, marketdata(t_1)) - XVA(t_0, marketdata(t_0))$. Listing
<a href="#lst:ore_xva_explain" data-reference-type="ref"
data-reference="lst:ore_xva_explain">[lst:ore_xva_explain]</a> shows a
typical configuration for XVA explain calculation.

<div class="listing">

``` xml
<Analytics>
 <Analytic type="xvaExplain">
      <Parameter name="active">Y</Parameter>
      <Parameter name="marketConfigFile">simulation.xml</Parameter>
      <Parameter name="stressConfigFile">stresstest.xml</Parameter>
      <Parameter name="sensitivityConfigFile">sensitivity_stress.xml</Parameter>
      <Parameter name="writeCubes">N</Parameter>
      <Parameter name="shiftThreshold">1e-4</Parameter>
      <Parameter name="mporDays">1</Parameter>
      <Parameter name="mporCalendar">EUR</Parameter>
    </Analytic>
</Analytics>
```

</div>

The parameters have the following interpretation:

- `marketConfigFile:` Configuration file defining the simulation market
  under which sensitivities are computed, see
  <a href="#sec:simulation" data-reference-type="ref"
  data-reference="sec:simulation">[sec:simulation]</a>. Only a subset of
  the specification is needed (the one given under `Market`, see
  <a href="#sec:sim_market" data-reference-type="ref"
  data-reference="sec:sim_market">[sec:sim_market]</a> for a detailed
  description).

- `stressConfigFile:` Stress Scenario definition, see section
  <a href="#sec:stress" data-reference-type="ref"
  data-reference="sec:stress">[sec:stress]</a>

- `sensitivityConfigFile:` Configuration file for the sensitivity
  calculation, see section
  <a href="#sec:sensitivity" data-reference-type="ref"
  data-reference="sec:sensitivity">[sec:sensitivity]</a>.

- `writeCubes:` Boolean flag, if true ORE outputs the raw and net cube
  under each scenario, defaults to false.

- `shiftThreshold:` Par Rate shifts below this threshold are ignored.

- `mporDays:` Derives the 2nd evaluation date $t_1$ from
  $t_0 + mporDates$.

- `mporCalendar:` Calendar used to ensure that $t_1$ is a valid business
  day.

ORE reuses the parameterisations of the exposure and XVA analtyic. One
needs to setup those analytics as usual but one can deactivate them. See
listings <a href="#lst:ore_xva" data-reference-type="ref"
data-reference="lst:ore_xva">[lst:ore_xva]</a> and
<a href="#lst:ore_simulation" data-reference-type="ref"
data-reference="lst:ore_simulation">[lst:ore_simulation]</a>. If set to
active, ORE will run the regular XVA analytic and the XVA sensitivity or
XVA stress analytic respectively.

ORE can compute the market implied XVA change between two evaluation
dates. For each risk factor defined in the sensitivity config ORE
computes the par rate change between t0 and t0 + mporDays. ORE derives
for each risk factor a shift scenario ($ParRate(t_1) - ParRate(t_0)$)
and computes the CVA change implied by those risk factors shifts at t0.

The output is a csv file with the all the value adjustments under each
scenario similar the regular XVA outputs, added with an extra column for
the scenario name (shifted risk factor). Further ORE generate the CVA
explain output, which contains the name of the shifted risk factor the
base and scenario CVA value and the change between base and scenario CVA
value (see <a href="#table:cvaexplain" data-reference-type="ref"
data-reference="table:cvaexplain">3</a>).

The XVA Explain Analytic replaces the todaysMarket in the exposure
simulation with a ScenarioSimMarket. For some risk factors the
simulation market behaves a different to the todays market, e.g. uses
different tenor structure for building the curves or uses only the
swaption ATM vols if the volatilities aren’t simulated. To minimize some
of the effects, it is recommended to activate   
t UseSpreadedTermStructures in the stress tests scenarios and activate
the swaption volatility simulation for the stress test run (see also ).

For an example see
<a href="#example:xvarisk_pnl" data-reference-type="ref"
data-reference="example:xvarisk_pnl">[example:xvarisk_pnl]</a>.

<div class="center">

<div id="table:cvaexplain">

|     | RiskFacto                    | rTradeId     | NettingSetId | CVA_Base    | CVA         | Change     |
|:----|:-----------------------------|:-------------|:-------------|:------------|:------------|:-----------|
| 0   | ALL                          |              |              | 91876.7431  | 81990.9740  | -9885.7691 |
| 1   | ALL                          | Swap_20y     | Swap_20y     | 159509.2148 | 150278.8754 | -9230.3394 |
| 2   | ALL                          | Swap_20y_USD | Swap_20y_USD | 42065.8853  | 45831.0601  | 3765.1748  |
| 3   | IndexCurve/EUR-EURIBOR-6M/19 |              |              | 91876.7431  | 92953.7582  | 1077.0151  |
| 4   | IndexCurve/EUR-EURIBOR-6M/19 | Swap_20y     | Swap_20y     | 159509.2148 | 161063.8061 | 1554.5913  |

CVA Explain results

</div>

</div>

### CCR Capital: SA-CCR

The `saccr` ‘analytic’ provides computation of SA-CCR capital
calculation, see <a href="#lst:ore_saccr" data-reference-type="ref"
data-reference="lst:ore_saccr">[lst:ore_saccr]</a>. The required input
in addition to the setup section is a `csaFile` (as in XVA analytics)
and a `collateralBalancesFile` which provides variation and initial
margin balances as of today.

<div class="listing">

``` xml
<Analytics>
    <Analytic type="saccr">
      <Parameter name="active">Y</Parameter>
      <Parameter name="csaFile">netting.xml</Parameter>
      <Parameter name="collateralBalancesFile">collateralbalances.xml</Parameter>
    </Analytic>
  </Analytic>
</Analytics>
```

</div>

For an example see
<a href="#example:creditrisk_saccr" data-reference-type="ref"
data-reference="example:creditrisk_saccr">[example:creditrisk_saccr]</a>.

### CVA Capital: SA-CVA and BA-CVA

The `sacva` ‘analytic’ provides computation of SA-CVA capital
calculation based on CVA sensitivities. These can be computed on-the-fly
or can be externally provided, see listing
<a href="#lst:ore_sacva" data-reference-type="ref"
data-reference="lst:ore_sacva">[lst:ore_sacva]</a>. In the former case,
the `xvaSensitivity` analytic needs to be specified with all reqired
inputs as shown in Listing
<a href="#lst:ore_xva_sensi" data-reference-type="ref"
data-reference="lst:ore_xva_sensi">[lst:ore_xva_sensi]</a> above,
likewise the `simulation` and `xva` analytic which are utilised under
the hood.

<div class="listing">

``` xml
<Analytics>
 <Analytic type="sacva">
    <Parameter name="active">Y</Parameter>
      <!-- If none of the following is provided, ORE builds on-the-fly sensis using
           the configuration above -->
      <!-- Load net sensitivities that can be passed into the SA-CVA calculator directly -->
      <!--<Parameter name="saCvaNetSensitivitiesFile">sacva_sensitivity.csv</Parameter>-->
      <!-- Load CVA sensitivities, output of the xva sensi analytic, that needs mapping
       and aggregation -->
      <!--<Parameter name="cvaSensitivitiesFile">xva_par_sensitivity_cva.csv</Parameter>-->
  </Analytic>
</Analytics>
```

</div>

The `bacva` ‘analytic’ provides computation of BA-CVA capital
calculation, see <a href="#lst:ore_bacva" data-reference-type="ref"
data-reference="lst:ore_bacva">[lst:ore_bacva]</a>. The required input
in addition to the setup section is a `csaFile` (as in XVA analytics)
and a `collateralBalancesFile` which provides variation and initial
margin balances as of today, the same as in the `saccr` analytic which
is used under the hood to compute exposures at default.

<div class="listing">

``` xml
<Analytics>
    <Analytic type="bacva">
      <Parameter name="active">Y</Parameter>
      <Parameter name="csaFile">netting.xml</Parameter>
      <Parameter name="collateralBalancesFile">collateralbalances.xml</Parameter>
    </Analytic>
  </Analytic>
</Analytics>
```

</div>

The `smrc` ‘analytic’ provides computation of the basic SMRC market risk
captial calculation, without additional inputs, see
<a href="#lst:ore_smrc" data-reference-type="ref"
data-reference="lst:ore_smrc">[lst:ore_smrc]</a>.

<div class="listing">

``` xml
<Analytics>
    <Analytic type="smrc">
      <Parameter name="active">Y</Parameter>
    </Analytic>
  </Analytic>
</Analytics>
```

</div>

For an example see
<a href="#example:xvarisk_capital" data-reference-type="ref"
data-reference="example:xvarisk_capital">[example:xvarisk_capital]</a>.

[^1]: by bitwise comparison of the external logMask value with each
    message’s log level
