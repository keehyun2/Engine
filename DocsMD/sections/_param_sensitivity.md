## Sensitivity Analysis: `sensitivity.xml`

ORE currently supports sensitivity analysis with respect to

- Discount curves (in the zero rate domain)

- Index curves (in the zero rate domain)

- Yield curves including e.g. equity forecast yield curves (in the zero
  rate domain)

- FX Spots

- FX volatilities

- Swaption volatilities, ATM matrix or cube

- Cap/Floor volatility matrices (in the caplet/floorlet domain)

- Default probability curves (in the “zero rate” domain, expressing
  survival probabilities $S(t)$ in term of zero rates $z(t)$ via
  $S(t)=\exp(-z(t)\times t)$ with Actual/365 day counter)

- Equity spot prices

- Equity volatilities, ATM or including strike dimension

- Zero inflation curves

- Year-on-Year inflation curves

- CDS volatilities

- Bond credit spreads

- Base correlation curves

- Correlation termstructures

The `sensitivity.xml` file specifies how sensitivities are computed for
each market component. The general structure is shown in listing
<a href="#lst:sensitivity_config" data-reference-type="ref"
data-reference="lst:sensitivity_config">[lst:sensitivity_config]</a>,
for a more comprehensive case see `Examples/Example_15`. A subset of the
following parameters is used in each market component to specify the
sensitivity analysis:

- `ShiftType:` Both absolute or relative shifts can be used to compute a
  sensitivity, specified by the key words `Absolute` resp. `Relative`.

- `ShiftSize:` The size of the shift to apply.

- `ShiftScheme:` The finite difference scheme to use (`Forward`,
  `Backward`, `Central`), if not given, this parameter defaults to
  `Forward`

- `ShiftTenors:` For curves, the tenor buckets to apply shifts to, given
  as a comma separated list of periods.

- `ShiftExpiries:` For volatility surfaces, the option expiry buckets to
  apply shifts to, given as a comma separated list of periods.

- `ShiftStrikes:` For cap/floor, FX option and equity option volatility
  surfaces, the strikes to apply shifts to, given as a comma separated
  list of absolute strikes

- `ShiftTerms:` For swaption volatility surfaces, the underlying terms
  to apply shifts to, given as a comma separated list of periods.

- `Index:` For cap / floor volatility surfaces, the index which together
  with the currency defines the surface. list of absolute strikes

- `CurveType:` In the context of Yield Curves used to identify an equity
  “risk free” rate forecasting curve; set to `EquityForecast` in this
  case

The ShiftType, ShiftSize, ShiftScheme nodes take an optional attribute
key that allows to configure different values for different sensitivity
templates. The sensitivity templates are defined in the pricing engine
configuration. This is best explained by an example: In Example 15 the
product type BermudanSwaption has a sensitivity template `IR_FD`
attached, see <a href="#lst:sensi_template" data-reference-type="ref"
data-reference="lst:sensi_template">[lst:sensi_template]</a>. This can
be used to specify different shifts for trades that were built against
this engine configuration, see
<a href="#lst:sensi_config_template" data-reference-type="ref"
data-reference="lst:sensi_config_template">[lst:sensi_config_template]</a>:
For Bermudan swaptions a larger shift size of 10bp and a central
difference scheme is used to compute discount curve sensitivities in
EUR. Since no separate shift type is specified, the default shift type
`Absolute` is used. Note regarding the reports:

- the sensi scenario report contains scenario NPVs related to the
  possibly product specific configured shift sizes

- the sensi report contains renormalized sensitivities, i.e.
  sensitivities are always expressed w.r.t. the default shift sizes

- the sensi config report only contains the default configuration

<div class="longlisting">

``` xml
  <Product type="BermudanSwaption">
    <Model>LGM</Model>
    <ModelParameters>
      ...
    </ModelParameters>
    <Engine>Grid</Engine>
    <EngineParameters>
      ...
      <Parameter name="SensitivityTemplate">IR_FD</Parameter>
    </EngineParameters>
  </Product>
```

</div>

<div class="longlisting">

``` xml
    <DiscountCurve ccy="EUR">
      <ShiftType>Absolute</ShiftType>
      <ShiftSize>0.0001</ShiftSize>
      <ShiftScheme>Forward</ShiftScheme>
      <ShiftSize key="IR_FD">0.001</ShiftSize>
      <ShiftScheme key="IR_FD">Central</ShiftScheme>
      <ShiftTenors>6M,1Y,2Y,3Y,5Y,7Y,10Y,15Y,20Y</ShiftTenors>
    </DiscountCurve>
```

</div>

The cross gamma filter section contains a list of pairs of sensitivity
keys. For each possible pair of sensitivity keys matching the given
strings, a cross gamma sensitivity is computed. The given pair of keys
can be (and usually are) shorter than the actual sensitivity keys. In
this case only the prefix of the actual key is matched. For example, the
pair `DiscountCurve/EUR,DiscountCurve/EUR` matches all actual
sensitivity pairs belonging to a cross sensitivity by one pillar of the
EUR discount curve and another (different) pillar of the same curve. We
list the possible keys by giving an example in each category:

- `DiscountCurve/EUR/5/7Y`: 7y pillar of discounting curve in EUR, the
  pillar is at position 5 in the list of all pillars (counting starts
  with zero)

- `YieldCurve/BENCHMARK_EUR/0/6M`: 6M pillar of yield curve
  “BENCHMARK_EUR”, the index of the 6M pillar is zero (i.e. it is the
  first pillar)

- `IndexCurve/EUR-EURIBOR-6M/2/2Y`: 2Y pillar of index forwarding curve
  for the Ibor index “EUR-EURIBOR-6M”, the pillar index is 2 in this
  case

- `OptionletVolatility/EUR/18/5Y/0.04`: EUR caplet volatility surface,
  at 5Y option expiry and $4\%$ strike, the running index for this
  expiry - strike pair is 18; the index counts the points in the surface
  in lexical order w.r.t. the dimensions option expiry, strike

- `FXSpot/USDEUR/0/spot`: FX spot USD vs EUR (with EUR as base ccy), the
  index is always zero for FX spots, the pillar is labelled as “spot”
  always

- `SwaptionVolatility/EUR/11/10Y/10Y/ATM`: EUR Swaption volatility
  surface at 10Y option expiry and 10Y underlying term, ATM level, the
  running index for this expiry, term, strike triple has running index
  11; the index counts the points in the surface in lexical order w.r.t.
  the dimensions option expiry, underlying term and strike

Additional flags:

- ComputeGamma: If set to false, second order sensitivity computation is
  suppressed

- UseSpreadedTermStructures: If set to true, spreaded termstructures
  over t0 will be used for sensitivity calculation (where supported), to
  improve the alignment of the scenario sim market and t0 curves

<div class="longlisting">

``` xml
<SensitivityAnalysis>
  <DiscountCurves>
    <DiscountCurve ccy="EUR">
      <ShiftType>Absolute</ShiftType>
      <ShiftSize>0.0001</ShiftSize>
      <ShiftTenors>6M,1Y,2Y,3Y,5Y,7Y,10Y,15Y,20Y</ShiftTenors>
    </DiscountCurve>
    ...
  </DiscountCurves>
  ...
  <IndexCurves>
    <IndexCurve index="EUR-EURIBOR-6M">
      <ShiftType>Absolute</ShiftType>
      <ShiftSize>0.0001</ShiftSize>
      <ShiftTenors>6M,1Y,2Y,3Y,5Y,7Y,10Y,15Y,20Y</ShiftTenors>
    </IndexCurve>
  </IndexCurves>
  ...
  <YieldCurves>
    <YieldCurve name="BENCHMARK_EUR">
      <ShiftType>Absolute</ShiftType>
      <ShiftSize>0.0001</ShiftSize>
      <ShiftTenors>6M,1Y,2Y,3Y,5Y,7Y,10Y,15Y,20Y</ShiftTenors>
    </YieldCurve>
  </YieldCurves>
  ...
  <FxSpots>
    <FxSpot ccypair="USDEUR">
      <ShiftType>Relative</ShiftType>
      <ShiftSize>0.01</ShiftSize>
    </FxSpot>
  </FxSpots>
  ...
  <FxVolatilities>
    <FxVolatility ccypair="USDEUR">
      <ShiftType>Relative</ShiftType>
      <ShiftSize>0.01</ShiftSize>
      <ShiftExpiries>1Y,2Y,3Y,5Y</ShiftExpiries>
      <ShiftStrikes/>
    </FxVolatility>
  </FxVolatilities>
  ...
  <SwaptionVolatilities>
    <SwaptionVolatility ccy="EUR">
      <ShiftType>Relative</ShiftType>
      <ShiftSize>0.01</ShiftSize>
      <ShiftExpiries>1Y,5Y,7Y,10Y</ShiftExpiries>
      <ShiftStrikes/>
      <ShiftTerms>1Y,5Y,10Y</ShiftTerms>
    </SwaptionVolatility>
  </SwaptionVolatilities>
  ...
  <CapFloorVolatilities>
    <CapFloorVolatility ccy="EUR">
      <ShiftType>Absolute</ShiftType>
      <ShiftSize>0.0001</ShiftSize>
      <ShiftExpiries>1Y,2Y,3Y,5Y,7Y,10Y</ShiftExpiries>
      <ShiftStrikes>0.01,0.02,0.03,0.04,0.05</ShiftStrikes>
      <Index>EUR-EURIBOR-6M</Index>
    </CapFloorVolatility>
  </CapFloorVolatilities>
  ...
  <SecuritySpreads>
    <SecuritySpread security="SECURITY_1">
      <ShiftType>Absolute</ShiftType>
      <ShiftSize>0.0001</ShiftSize>
    </SecuritySpread>
  </SecuritySpreads>
  ...
  <Correlations>
    <Correlation index1="EUR-CMS-10Y" index2="EUR-CMS-2Y">
      <ShiftType>Absolute</ShiftType>
      <ShiftSize>0.01</ShiftSize>
      <ShiftExpiries>1Y,2Y</ShiftExpiries>
      <ShiftStrikes>0</ShiftStrikes>
    </Correlation>
  </Correlations>
  ...
  <CrossGammaFilter>
    <Pair>DiscountCurve/EUR,DiscountCurve/EUR</Pair>
    <Pair>IndexCurve/EUR,IndexCurve/EUR</Pair>
    <Pair>DiscountCurve/EUR,IndexCurve/EUR</Pair>
  </CrossGammaFilter>
  ...
  <ComputeGamma>true</ComputeGamma>
  <UseSpreadedTermStructures>false</UseSpreadedTermStructures>
</SensitivityAnalysis>
```

</div>

### Par Sensitivity Analysis

To perform a par sensitivity analysis, additional sensitivity
configuration is required that describes the assumed par instruments and
related conventions. This additional data is required for:

- DiscountCurves

- IndexCurves

- CapFloorVolatilities

- CreditCurves

- ZeroInflationIndexCurves

- YYInflationIndexCurves

- YYCapFloorVolatilities

By default, par conversion is applied to all risk factor types listed
above. However, it is possible to exclude selected risk factor types by
adding an optional block to the sensitivity configuration as shown in
listing <a href="#lst:par_conversion_excludes" data-reference-type="ref"
data-reference="lst:par_conversion_excludes">[lst:par_conversion_excludes]</a>.
Uncomment the risk factor type(s) here that should be excluded from par
conversion.

<div class="longlisting">

``` xml
<SensitivityAnalysis>

  <ParConversionExcludes>
    <!--<Type>DiscountCurve</Type>-->
    <!--<Type>YieldCurve</Type>-->
    <!--<Type>IndexCurve</Type>-->
    <!--<Type>OptionletVolatility</Type>-->
    <!--<Type>SurvivalProbability</Type>-->
    <!--<Type>ZeroInflationCurve</Type>-->
    <!--<Type>YearOnYearInflationCurve</Type>-->
    <!--<Type>YoYInflationCapFloorVolatility</Type>-->
  </ParConversionExcludes>

  ...

</SensitivityAnalysis>
```

</div>

By default, par sensitivity excludes index historical fixings on
valuation date when calculating the sensitivities of par instruments to
zero rates. However, it is possible to exclude selected indexes by
adding an optional block to the sensitivity configuration as shown in
listing
<a href="#lst:par_sensi_excludes_fixings" data-reference-type="ref"
data-reference="lst:par_sensi_excludes_fixings">[lst:par_sensi_excludes_fixings]</a>.
It handles a regex.

<div class="longlisting">

``` xml
<SensitivityAnalysis>

  <ParSensiRemoveFixing>.*</ParSensiRemoveFixing>

</SensitivityAnalysis>
```

</div>

By default, par sensitivity analysis sets small diagonal elements in the
par conversion matrix to 0.01 silently to avoid matrix inversion issues.
However, it is possible to control this behaviour by adding an optional
block to the sensitivity configuration as shown in listing
<a href="#lst:par_conversion_matrix_regularisation"
data-reference-type="ref"
data-reference="lst:par_conversion_matrix_regularisation">[lst:par_conversion_matrix_regularisation]</a>.
The available options are:

- `Silent`: Set small diagonal elements to 0.01 without warnings
  (default behaviour)

- `Warning`: Set small diagonal elements to 0.01 but issue structured
  warnings

- `Disable`: Disable regularisation, use original diagonal elements
  as-is

<div class="longlisting">

``` xml
<SensitivityAnalysis>

  <ParConversionMatrixRegularisation>Warning</ParConversionMatrixRegularisation>

</SensitivityAnalysis>
```

</div>

Using DiscountCurves as an example, the full sensitivity specification
including par conversion data is as follows:

<div class="longlisting">

``` xml
    <DiscountCurve ccy="EUR">
      <ShiftType>Absolute</ShiftType>
      <ShiftSize>0.0001</ShiftSize>
      <ShiftTenors>2W,1M,3M,6M,9M,1Y,2Y,3Y,4Y,5Y,7Y,10Y,15Y,20Y,25Y,30Y</ShiftTenors>
      <ParConversion>
        <!--DEP, FRA, IRS, OIS, FXF, XBS -->
    <Instruments>OIS,OIS,OIS,OIS,OIS,OIS,OIS,OIS,OIS,OIS,OIS,OIS,OIS,OIS,OIS,OIS</Instruments>
    <SingleCurve>true</SingleCurve>
  <Conventions>
      <Convention id="DEP">EUR-EURIBOR-CONVENTIONS</Convention>
      <Convention id="IRS">EUR-6M-SWAP-CONVENTIONS</Convention>
      <Convention id="OIS">EUR-OIS-CONVENTIONS</Convention>
    </Conventions>
      </ParConversion>
    </DiscountCurve>
```

</div>

Using CapFloors as an example:

<div class="longlisting">

``` xml
        <CapFloorVolatility key="USD-SOFR">
            <ShiftType>Absolute</ShiftType>
            <ShiftSize>0.0001</ShiftSize>
            <ShiftScheme>Forward</ShiftScheme>
            <ShiftExpiries>1Y,2Y,3Y,5Y,10Y,15Y,20Y,30Y</ShiftExpiries>
            <ShiftStrikes>-0.0075,-0.005,-0.0025,-0.0015,0.0,0.0025,0.005,0.0075,0.01,0.015,0.02,0.025</ShiftStrikes>
            <Index>USD-SOFR</Index>
            <IsRelative>false</IsRelative>
            <ParConversion>
                <Instruments>CapFloor,CapFloor,CapFloor,CapFloor,CapFloor,CapFloor,CapFloor,CapFloor</Instruments>
                <DiscountCurve>USD-SOFR</DiscountCurve>
                <RateComputationPeriod>3M</RateComputationPeriod>
            </ParConversion>
        </CapFloorVolatility>
```

</div>

ParConversion Fields:

- **Instruments** a comma separated list of par instrument types, see
  below for the possible values. The 3-letter instrument code can be
  extended by an arbitrary suffix to reference different conventions.
  For example, you can use FRA1, FRA2 in the instrument list to build
  FRA instruments with different convention ids FRA1, FRA2.

- **DiscountCurve** *optional*: discount curve used for pricing the par
  instrument.

- **RateComputationPeriod** *optional*: required for OIS CapFloors,
  sepcify the period of the optionlet.

Note

- The list of shift tenors needs to match the list of tenors matches the
  corresponding grid in the simulation (market) configuration

- The length of list of (par) instruments needs to match the length of
  the list of shift tenors

- Permissible codes for the assumed par instruments:

  - DEP, FRA, IRS, OIS, TBS, FXF, XBS in the case of DiscountCurves

  - DEP, FRA, IRS, OIS, TBS in the case of IndexCurves

  - DEP, FRA, IRS, OIS, TBS, XBS in the case of YieldCurves

  - ZIS, YYS for YYInflationIndexCurves, interpreted as Year-on-Year
    Inflation Swaps linked to Zero Inflation resp. YoY Inflation curves

  - ZIS, YYS for YYCapFloorVolatilities, interpreted as Year-on-Year
    Inflation Cap Floor linked to Zero Inflation resp. YoY Inflation
    curves

  - Any code for CreditCurves, interpreted as CDS

  - Any code for ZeroInflationIndexCurves, interpreted as CPI Swaps
    linked to Zero Inflation curves

  - Any code for CapFloorVolatilities, interpreted as flat Cap/Floor

- One convention needs to be referenced for each of the instrument codes
