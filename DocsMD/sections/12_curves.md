## Curves: `curveconfig.xml`

The configuration of various term structures required to price a
portfolio is covered in a single configuration file which we will label
`curveconfig.xml` in the following though the file name can be chosen by
the user. This configuration determines the composition of

- Yield curves

- Default curves

- Inflation curves

- Equity forward price curves

- Swaption volatility structures

- Cap/Floor volatility structures

- FX Option volatility structures

- CDS volatility structures

- Inflation Cap/Floor price surfaces

- Equity volatility structures

- Security spreads and recovery rates

- Base correlation curves

- Correlation termstructures

This file also contains other market objects such as FXSpots, Security
Spreads and Security Rates which are necessary for the construction of a
market.

### Yield Curves

The top level XML elements for each `YieldCurve` node are shown in
Listing <a href="#lst:top_level_yc" data-reference-type="ref"
data-reference="lst:top_level_yc">[lst:top_level_yc]</a>.

<div class="listing">

``` xml
<YieldCurve>
  <CurveId> </CurveId>
  <CurveDescription> </CurveDescription>
  <Currency> </Currency>
  <DiscountCurve> </DiscountCurve>
  <Segments> </Segments>
  <InterpolationVariable> </InterpolationVariable>
  <InterpolationMethod> </InterpolationMethod>
  <MixedInterpolationCutoff> </MixedInterpolationCutoff>
  <YieldCurveDayCounter> </YieldCurveDayCounter>
  <Tolerance> </Tolerance>
  <Extrapolation> </Extrapolation>
  <ExcludeT0FromInterpolation> </ExcludeT0FromInterpolation>
  <BootstrapConfig>
    ...
  </BootstrapConfig>
</YieldCurve>
```

</div>

The meaning of each of the top level elements in Listing
<a href="#lst:top_level_yc" data-reference-type="ref"
data-reference="lst:top_level_yc">[lst:top_level_yc]</a> is given below.
If an element is labelled as ‘Optional’, then it may be excluded or
included and left blank.

- CurveId: Unique identifier for the yield curve.

- CurveDescription: A description of the yield curve. This field may be
  left blank.

- Currency: The yield curve currency.

- DiscountCurve: If the yield curve is being bootstrapped from market
  instruments, this gives the CurveId of the yield curve used to
  discount cash flows during the bootstrap procedure. If this field is
  left blank or set equal to the current CurveId, then this yield curve
  itself is used to discount cash flows during the bootstrap procedure.

- Segments: This element contains child elements and is described in the
  following subsection.

- InterpolationVariable \[Optional\]: The variable on which the
  interpolation is performed. The allowable values are given in Table
  <a href="#tab:allow_interp_variables" data-reference-type="ref"
  data-reference="tab:allow_interp_variables">1</a>. If the element is
  omitted or left blank, then it defaults to *Discount*.

- InterpolationMethod \[Optional\]: The interpolation method to use. The
  allowable values are given in Table
  <a href="#tab:allow_interp_methods" data-reference-type="ref"
  data-reference="tab:allow_interp_methods">2</a>. If the element is
  omitted or left blank, then it defaults to *LogLinear*.

- MixedInterpolationCutoff \[Optional\]: If a mixed interpolation method
  is used, the number of segments to which the first interpolation
  method is applied. Defaults to 1.

- YieldCurveDayCounter \[Optional\]: The day count basis used internally
  by the yield curve to calculate the time between dates. In particular,
  if the curve is queried for a zero rate without specifying the day
  count basis, the zero rate that is returned has this basis. If the
  element is omitted or left blank, then it defaults to *A365*.

- `Tolerance` \[Optional\]: The tolerance used by the root finding
  procedure in the bootstrapping algorithm. If the element is omitted or
  left blank, then it defaults to 1.0 × 10<sup>−12</sup>. It is
  preferable to use the `Accuracy` node in the `BootstrapConfig` node
  below for specifying this value. However, if this node is explicitly
  supplied, it takes precedence for backwards compatibility purposes.

- Extrapolation \[Optional\]: Set to *True* or *False* to enable or
  disable extrapolation respectively. If the element is omitted or left
  blank, then it defaults to *True*.

- ExtrapolationMethod \[Optional\]: Only applies to bootstrapped curves
  and interpolated zero / discount curves. Controls how the curve is
  extrapolated:

  - *ContinuousForward*: The instantaneous forward rate at the last
    curve pillar date $T$ is kept constant

  - *DiscreteForward*: The discrete forward rate between $T-1$ and $T$
    is kept constant, where $T$ is the last curve pillar date and $T-1$
    lies one calendar day before $T$.

- ExcludeT0FromInterpolation \[Optional\]: Only applies to bootstrapped
  curves and interpolated zero / discount curves. Set to *True* to
  exclude the synthetic time-zero (t0) point from yield curve
  interpolation. When enabled, the curve interpolates only on actual
  market pillar dates, while still ensuring proper behavior at the
  reference date (e.g., $DF(t_0) = 1.0$ for discount curves). This is
  useful when the first market pillar date does not coincide with the
  as-of date and you want to avoid including a synthetic point in the
  interpolation.

  This feature is supported for all three interpolation variables:

  - `InterpolationVariable=Discount`: Interpolates discount factors on
    pillar dates. At $t=0$, returns $DF(t_0) = 1.0$ by definition. For
    $0 < t < t_1$ (between reference date and first pillar), uses flat
    forward extrapolation from the first pillar to ensure continuity at
    $t=0$.

  - `InterpolationVariable=Zero`: Interpolates continuously compounded
    zero rates on pillar dates. For $t < t_1$, uses flat extrapolation
    with the first pillar’s zero rate.

  - `InterpolationVariable=Forward`: Interpolates instantaneous forward
    rates on pillar dates. For $t < t_1$, uses flat forward rate from
    the first pillar.

  All standard interpolation methods are supported (e.g., Linear,
  LogLinear, NaturalCubic, etc.,).

  If the element is omitted or left blank, then it defaults to *False*,
  which preserves the traditional behavior of including a t0 point (with
  $DF = 1.0$ for discount curves, or extrapolated rate for zero/forward
  curves) in the interpolation input.

- `BootstrapConfig` \[Optional\]: this node holds configuration details
  for the iterative bootstrap that are described in section
  <a href="#sec:bootstrap_config" data-reference-type="ref"
  data-reference="sec:bootstrap_config">0.1.21</a>. If omitted, this
  node’s default values described in section
  <a href="#sec:bootstrap_config" data-reference-type="ref"
  data-reference="sec:bootstrap_config">0.1.21</a> are used.

<div id="tab:allow_interp_variables">

| **Variable** | **Description**                       |
|:-------------|:--------------------------------------|
| Zero         | The continuously compounded zero rate |
| Discount     | The discount factor                   |
| Forward      | The instantaneous forward rate        |

Allowable interpolation variables.

</div>

<div id="tab:allow_interp_methods">

| **Method**                       | **Description**                                                                                             |
|:---------------------------------|:------------------------------------------------------------------------------------------------------------|
| Linear                           | Linear interpolation                                                                                        |
| LogLinear                        | Linear interpolation on the natural log of the interpolation variable                                       |
| NaturalCubic                     | Monotonic Kruger cubic interpolation with zero second derivative at left and right                          |
| FinancialCubic                   | Monotonic Kruger cubic interpolation with zero second derivative at left and zero first derivative at right |
| ConvexMonotone                   | Convex Monotone Interpolation (Hagan, West)                                                                 |
| Quadratic                        | Quadratic interpolation                                                                                     |
| LogQuadratic                     | Quadratic interpolation on the natural log of the interpolation variable                                    |
| LogNaturalCubic                  | Monotonic Kruger cubic interpolation with zero second derivative at left and right                          |
| LogFinancialCubic                | Monotonic Kruger cubic interpolation with zero second derivative at left and zero first derivative at right |
| LogCubicSpline                   | Non-monotonic cubic spline interpolation with zero second derivative at left and right                      |
| MonotnicLogCubicSpline           | Monotonic cubic spline interpolation with zero second derivative at left and right                          |
| Hermite                          | Hermite cubic spline interpolation                                                                          |
| CubicSpline                      | Non-monotonic cubic spline interpolation with zero second derivative at left and right                      |
| DefaultLogMixedLinearCubic       | Mixed interpolation, first linear, then monotonic Kruger cubic spline                                       |
| MonotonicLogMixedLinearCubic     | Mixed interpolation, first linear, then monotonic natural cubic spline                                      |
| KrugerLogMixedLinearCubic        | Mixed interpolation, first linear, then non-monotonic Kruger cubic spline                                   |
| LogMixedLinearCubicNaturalSpline | Mixed interpolation, first linear, then non-monotonic natural cubic spline                                  |
| BackwardFlat                     | Backward-flat interpolation (piecewise constant, right-continuous)                                          |
| ExponentialSplines               | Exponential Spline curve fitting, for Fitted Bond Curves only                                               |
| NelsonSiegel                     | Nelson-Siegel curve fitting, for Fitted Bond Curves only                                                    |
| Svensson                         | Svensson curve fitting, for Fitted Bond Curves only                                                         |

Allowable interpolation methods.

</div>

### Segments Node

The `Segments` node gives the zero rates, discount factors and
instruments that comprise the yield curve. This node consists of a
number of child nodes where the node name depends on the segment being
described. Each node has a `Type` that determines its structure. The
following sections describe the type of child nodes that are available.
Note that for all segment types below, with the exception of
`DiscountRatio` and `AverageOIS`, the `Quote` elements within the
`Quotes` node may have an `optional` attribute indicating whether or not
the quote is optional. Example:

``` xml
<Quotes>
  <Quote optional="true"></Quote>
</Quotes>
```

### Direct Segment

When the node name is `Direct`, the `Type` node has the value *Zero* or
*Discount* and the node has the structure shown in Listing
<a href="#lst:direct_segment" data-reference-type="ref"
data-reference="lst:direct_segment">[lst:direct_segment]</a>. We refer
to this segment here as a direct segment because the discount factors,
or equivalently the zero rates, are given explicitly and do not need to
be bootstrapped. The `Quotes` node contains a list of `Quote` elements.
Each `Quote` element contains an ID pointing to a line in the
`market.txt` file, i.e. in this case, pointing to a particular zero rate
or discount factor. The `Conventions` node contains the ID of a node in
the `conventions.xml` file described in section
<a href="#sec:conventions" data-reference-type="ref"
data-reference="sec:conventions">[sec:conventions]</a>. The
`Conventions` node associates conventions with the quotes.

For both *Zero* and *Discount* type segments, the quotes can be given
using a wildcard. Any valid and matching quotes will then be loaded from
the provided market data. Example wildcards are:

- ZERO/RATE/EUR/\* - matches all EUR zero rate quotes

- DISCOUNT/RATE/EUR/EUR3M/\* - matches all EUR discount factor quotes
  for the EUR3M curve

<div class="listing">

``` xml
<Direct>
  <Type> </Type>
  <Quotes>
    <Quote> </Quote>
    <Quote> </Quote>
     <!--...-->
  </Quotes>
  <Conventions> </Conventions>
</Direct>
```

</div>

### Simple Segment

When the node name is `Simple`, the `Type` node has the value *Deposit*,
*FRA*, *Future*, *OIS*, *Swap* or *BMA Basis Swap* and the node has the
structure shown in Listing
<a href="#lst:simple_segment" data-reference-type="ref"
data-reference="lst:simple_segment">[lst:simple_segment]</a>. This
segment holds quotes for a set of deposit, FRA, Future, OIS or swap
instruments corresponding to the value in the `Type` node. These quotes
will be used by the bootstrap algorithm to imply a discount factor, or
equivalently a zero rate, curve. The only difference between this
segment and the direct segment is that there is a `ProjectionCurve`
node. This node allows us to specify the CurveId of another curve to
project floating rates on the instruments underlying the quotes listed
in the `Quote` nodes during the bootstrap procedure. This is an optional
node. If it is left blank or omitted, then the projection curve is
assumed to equal the curve being bootstrapped i.e. the current CurveId.
The `PillarChoice` node determines the bootstrap pillars that are used
(MaturityDate, LastRelevantDate, NoPillar, StartDate,
StartDateAndMaturityDate, StartDateAndLastRelevantDate; if not given
’LastRelevantDate’ is the default value). The `DuplicatePillarPolcicy`
node determined how curve instruments within the same segment with
identical pillar dates are handled (Keep Last, KeepFirst, KeepAll,
ThrowError; if not given ’KeepLast’ is used).

The `Priority` node determines the priority of the segment, this has to
be a non-negative integer. A lower number means a higher priority (more
“important”) segment. If two adjacent segments overlap w.r.t. the pillar
dates of their instruments, instruments from the segment with lower
priority are removed until the overlap is resolved. In addition, a
minimum distance (measured in calendar days) between the segments is
preserved. This distance is given in the `MinDistance` node for the
instruments of the current and following segment. If not given, the
priority of a segment defaults to 0 (highest possible priority), the
minimum distance defaults to $1$. Consider the example given in
<a href="#lst:priorities_min_distances" data-reference-type="ref"
data-reference="lst:priorities_min_distances">[lst:priorities_min_distances]</a>.
In this case:

- instruments from the start of the second segment with pillar date
  strictly earlier than $d_1 + 5$, where $d_1$ is the maximum pillar
  date of instruments in the first segment, will be removed

- instruments from the end of the second segment with pillar date
  strictly later than $d_3 - 10$, where $d_3$ is the minimum pillar date
  of instruments in the third segment, will be removed

<div class="listing">

``` xml
<Simple>
  <Type> </Type>
  <Quotes>
    <Quote> </Quote>
    <Quote> </Quote>
    <!--...-->
  </Quotes>
  <Conventions> </Conventions>
  <PillarChoice> </PillarChoice>
  <DuplicatePillarPolicy> </DuplicatePillarPolicy>
  <Priority> </Priority>
  <MinDistance> </MinDistance>
  <ProjectionCurve> </ProjectionCurve>
</Simple>
```

</div>

<div class="listing">

``` xml
<Simple>
  ...
  <Priority>0</Priority>
  <MinDistance>5</MinDistance>
</Simple>
<Simple>
  ...
  <Priority>2</Priority>
  <MinDistance>10</MinDistance>
</Simple>
<Simple>
  ...
  <Priority>1</Priority>
</Simple>
```

</div>

### Average OIS Segment

When the node name is `AverageOIS`, the `Type` node has the value
*Average OIS* and the node has the structure shown in Listing
<a href="#lst:average_ois_segment" data-reference-type="ref"
data-reference="lst:average_ois_segment">[lst:average_ois_segment]</a>.
This segment is used to hold quotes for Average OIS swap instruments.
The `Quotes` node has the structure shown in Listing
<a href="#lst:average_ois_quotes" data-reference-type="ref"
data-reference="lst:average_ois_quotes">[lst:average_ois_quotes]</a>.
Each quote for an Average OIS instrument (a typical example in a USD
Overnight Index Swap) consists of two quotes, a vanilla IRS quote and an
OIS-LIBOR basis swap spread quote. The IDs of these two quotes are
stored in the `CompositeQuote` node. The `RateQuote` node holds the ID
of the vanilla IRS quote and the `SpreadQuote` node holds the ID of the
OIS-LIBOR basis swap spread quote.

For the `PillarChoice`, `DuplicatePillarPolicy`, `Priority` and
`MinDistance` nodes see the explanation under “Simple Segment”.

<div class="listing">

``` xml
<AverageOIS>
  <Type> </Type>
  <Quotes>
    <CompositeQuote> </CompositeQuote>
    <CompositeQuote> </CompositeQuote>
    <!--...-->
  </Quotes>
  <Conventions> </Conventions>
  <PillarChoice> </PillarChoice>
  <DuplicatePillarPolicy> </DuplicatePillarPolicy>
  <Priority> </Priority>
  <MinDistance> </MinDistance>
  <ProjectionCurve> </ProjectionCurve>
</AverageOIS>
```

</div>

<div class="listing">

``` xml
<Quotes>
  <CompositeQuote>
    <SpreadQuote> </SpreadQuote>
    <RateQuote> </RateQuote>
  </CompositeQuote>
  <!--...-->
</Quotes>
```

</div>

### Tenor Basis Segment

When the node name is `TenorBasis`, the `Type` node has the value *Tenor
Basis Swap* or *Tenor Basis Two Swaps* and the node has the structure
shown in Listing
<a href="#lst:tenor_basis_segment" data-reference-type="ref"
data-reference="lst:tenor_basis_segment">[lst:tenor_basis_segment]</a>.
This segment is used to hold quotes for tenor basis swap instruments.
The quotes may be for a conventional tenor basis swap where Ibor of one
tenor is swapped for Ibor of another tenor plus a spread. In this case,
the `Type` node has the value *Tenor Basis Swap*. The quotes may also be
for the difference in fixed rates on two fair swaps where one swap is
against Ibor of one tenor and the other swap is against Ibor of another
tenor. In this case, the `Type` node has the value *Tenor Basis Two
Swaps*. Again, the structure is similar to the simple segment in Listing
<a href="#lst:simple_segment" data-reference-type="ref"
data-reference="lst:simple_segment">[lst:simple_segment]</a> except that
there are two projection curve nodes. There is a
`ProjectionCurveReceive` node for the index with the shorter tenor. This
node holds the CurveId of a curve for projecting the floating rates on
the receiving side. Similarly, there is a `ProjectionCurvePay` node for
the index of the pay side. The deprecated values are short for receive,
and long for pay. These are optional nodes. If they are left blank or
omitted, then the projection curve is assumed to equal the curve being
bootstrapped i.e. the current CurveId. However, at least one of the
nodes needs to be populated to allow the bootstrap to proceed.

For the `PillarChoice`, `DuplicatePillarPolicy`, `Priority` and
`MinDistance` nodes see the explanation under “Simple Segment”.

<div class="listing">

``` xml
<TenorBasis>
  <Type> </Type>
  <Quotes>
    <Quote> </Quote>
    <Quote> </Quote>
    <!--...-->
  </Quotes>
  <Conventions> </Conventions>
  <PillarChoice> </PillarChoice>
  <DuplicatePillarPolicy> </DuplicatePillarPolicy>
  <Priority> </Priority>
  <MinDistance> </MinDistance>
  <ProjectionCurvePay> </ProjectionCurvePay>
  <ProjectionCurveReceive> </ProjectionCurveReceive>
</TenorBasis>
```

</div>

### Cross Currency Segment

When the node name is `CrossCurrency`, the `Type` node has the value *FX
Forward*, *Cross Currency Basis Swap* or *Cross Currency Fix Float
Swap*. When the `Type` node has the value *FX Forward*, the node has the
structure shown in Listing
<a href="#lst:fx_forward_segment" data-reference-type="ref"
data-reference="lst:fx_forward_segment">[lst:fx_forward_segment]</a>.
This segment is used to hold quotes for FX forward instruments. The
`DiscountCurve` node holds the CurveId of a curve used to discount cash
flows in the other currency i.e. the currency in the currency pair that
is not equal to the currency in Listing
<a href="#lst:top_level_yc" data-reference-type="ref"
data-reference="lst:top_level_yc">[lst:top_level_yc]</a>. The `SpotRate`
node holds the ID of a spot FX quote for the currency pair that is
looked up in the `market.txt` file.

<div class="listing">

``` xml
<CrossCurrency>
  <Type> </Type>
  <Quotes>
    <Quote> </Quote>
    <Quote> </Quote>
          ...
  </Quotes>
  <Conventions> </Conventions>
  <PillarChoice> </PillarChoice>
  <DuplicatePillarPolicy> </DuplicatePillarPolicy>
  <Priority> </Priority>
  <MinDistance> </MinDistance>
  <DiscountCurve> </DiscountCurve>
  <SpotRate> </SpotRate>
</CrossCurrency>
```

</div>

When the `Type` node has the value *Cross Currency Basis Swap* then the
node has the structure shown in Listing
<a href="#lst:xccy_basis_segment" data-reference-type="ref"
data-reference="lst:xccy_basis_segment">[lst:xccy_basis_segment]</a>.
This segment is used to hold quotes for cross currency basis swap
instruments. The `DiscountCurve` node holds the CurveId of a curve used
to discount cash flows in the other currency i.e. the currency in the
currency pair that is not equal to the currency in Listing
<a href="#lst:top_level_yc" data-reference-type="ref"
data-reference="lst:top_level_yc">[lst:top_level_yc]</a>. The `SpotRate`
node holds the ID of a spot FX quote for the currency pair that is
looked up in the ` market.txt` file. The `ProjectionCurveDomestic` node
holds the CurveId of a curve for projecting the floating rates on the
index in this currency i.e. the currency in the currency pair that is
equal to the currency in Listing
<a href="#lst:top_level_yc" data-reference-type="ref"
data-reference="lst:top_level_yc">[lst:top_level_yc]</a>. It is an
optional node and if it is left blank or omitted, then the projection
curve is assumed to equal the curve being bootstrapped i.e. the current
CurveId. Similarly, the `ProjectionCurveForeign` node holds the CurveId
of a curve for projecting the floating rates on the index in the other
currency. If it is left blank or omitted, then it is assumed to equal
the CurveId provided in the `DiscountCurve` node in this segment.

For the `PillarChoice`, `DuplicatePillarPolicy`, `Priority` and
`MinDistance` nodes see the explanation under “Simple Segment”.

<div class="listing">

``` xml
<CrossCurrency>
  <Type> </Type>
  <Quotes>
    <Quote> </Quote>
    <Quote> </Quote>
          ...
  </Quotes>
  <Conventions> </Conventions>
  <PillarChoice> </PillarChoice>
  <DuplicatePillarPolicy> </DuplicatePillarPolicy>
  <Priority> </Priority>
  <MinDistance> </MinDistance>
  <DiscountCurve> </DiscountCurve>
  <SpotRate> </SpotRate>
  <ProjectionCurveDomestic> </ProjectionCurveDomestic>
  <ProjectionCurveForeign> </ProjectionCurveForeign>
</CrossCurrency>
```

</div>

### Zero Spread Segment

When the node name is `ZeroSpread`, the `Type` node has the only
allowable value *Zero Spread*, and the node has the structure shown in
Listing <a href="#lst:zero_spread_segment" data-reference-type="ref"
data-reference="lst:zero_spread_segment">[lst:zero_spread_segment]</a>.
This segment is used to build yield curves which are expressed as a
spread over some reference yield curve.

<div class="listing">

``` xml
    <ZeroSpread>
          <Type>Zero Spread</Type>
          <Quotes>
            <Quote>ZERO/YIELD_SPREAD/EUR/BANK_EUR_LEND/A365/2Y</Quote>
            <Quote>ZERO/YIELD_SPREAD/EUR/BANK_EUR_LEND/A365/5Y</Quote>
            <Quote>ZERO/YIELD_SPREAD/EUR/BANK_EUR_LEND/A365/10Y</Quote>
            <Quote>ZERO/YIELD_SPREAD/EUR/BANK_EUR_LEND/A365/20Y</Quote>
          </Quotes>
          <Conventions>EUR-ZERO-CONVENTIONS-TENOR-BASED</Conventions>
          <ReferenceCurve>EUR1D</ReferenceCurve>
    </ZeroSpread>
```

</div>

### Fitted Bond Segment

When the node name is `FittedBond`, the `Type` node has the only
allowable value *FittedBond*, and the node has the structure shown in
Listing <a href="#lst:fitted_bond_segment" data-reference-type="ref"
data-reference="lst:fitted_bond_segment">[lst:fitted_bond_segment]</a>.
This segment is used to build yield curves which are fitted to liquid
bond prices. The segment has the following elements:

- Quotes: a list of bond price quotes, for each security in the list,
  reference data must be available

- IborIndexCurves: for each Ibor index that is required by one of the
  bonds to which the curve is fitted, a mapping to an estimation curve
  for that index must be provided

- ExtrapolateFlat: if true, the parametric curve is extrapolated flat in
  the instantaneous forward rate before the first and after the last
  maturity of the bonds in the calibration basket. This avoids
  unrealistic rates at the short end or for long maturities in the
  resulting curve.

The `BootstrapConfig` has the following interpretation for a fitted bond
curve:

- Accuracy \[Optional, defaults to 1E-12\]: the desired accuracy
  expressed as a weighted rmse in the implied quote, where 0.01 = 1 bp.
  Once this accuracy is reached in a calibration trial, the fit is
  accepted, no further calibration trials re run. In general, this
  parameter should be set to a higher than the default value for fitted
  bond curves.

- GlobalAccuracy \[Optional\]: the acceptable accuracy. If the Accuracy
  is not reached in any calibration trial, but the GlobalAccuracy is
  met, the best fit among the calibration trials is selected as a result
  of the calibration. If not given, the best calibration trial is
  compared to the Accuracy parameter instead.

- DontThrow \[Optional, defaults to false\]: If true, the best
  calibration is always accepted as a result, i.e. no error is thrown
  even if the GlobalAccuracy is breached.

- MaxAttempts \[Optional, defaults to 5\]: The maximum number of
  calibration trials. Each calibration trial is run with a random
  calibration seed. Random calibration seeds are currently only
  supported for the NelsonSiegel interpolation method.

<div class="listing">

``` xml
    <YieldCurve>
      ...
      <Segments>
        <FittedBond>
          <Type>FittedBond</Type>
          <Quotes>
            <Quote>BOND/PRICE/SECURITY_1</Quote>
            <Quote>BOND/PRICE/SECURITY_2</Quote>
            <Quote>BOND/PRICE/SECURITY_3</Quote>
            <Quote>BOND/PRICE/SECURITY_4</Quote>
            <Quote>BOND/PRICE/SECURITY_5</Quote>
          </Quotes>
          <!-- mapping of Ibor curves used in the bonds from which the curve is built -->
          <IborIndexCurves>
            <IborIndexCurve iborIndex="EUR-EURIBOR-6M">EUR6M</IborIndexCurve>
          </IborIndexCurves>
          <!-- flat extrapolation before first and after last bond maturity -->
          <ExtrapolateFlat>true</ExtrapolateFlat>
        </FittedBond>
      </Segments>
      <!-- NelsonSiegel, Svensson, ExponentialSplines -->
      <InterpolationMethod>NelsonSiegel</InterpolationMethod>
      <YieldCurveDayCounter>A365</YieldCurveDayCounter>
      <Extrapolation>true</Extrapolation>
      <BootstrapConfig>
        <!-- desired accuracy (in implied quote) -->
        <Accuracy>0.1</Accuracy>
        <!-- tolerable accuracy -->
        <GlobalAccuracy>0.5</GlobalAccuracy>
        <!-- do not throw even if tolerable accuracy is breached -->
        <DontThrow>false</DontThrow>
        <!-- max calibration trials to reach desired accuracy -->
        <MaxAttempts>20</MaxAttempts>
      </BootstrapConfig>
    </YieldCurve>
```

</div>

### Bond Yield Shifted

When the node name is `BondYieldShifted`, the `Type` node has the only
allowable value *Bond Yield Shifted*, and the node has the structure
shown in Listing
<a href="#lst:bond_yield_shifted" data-reference-type="ref"
data-reference="lst:bond_yield_shifted">[lst:bond_yield_shifted]</a>.
This segment is used to build yield curves which are adjusted by liquid
bond yields. The adjustment is derived as an average of the spreads
between the bond’s yields-to-maturity and the reference curve level at
the tenor points corresponding the bond durations.

Compared to the fitted bond segment the shifted curve can be built with
only one liquid bond. This approach is useful in cases of limited number
of liquid comparable bonds and hence unstable fitting of Nelson Siegel.
The average spread at the average duration point may be considered as a
sensitivity point of a corresponding zero coupon bond.

The segment has the following elements:

- Quotes: a list of bond price quotes, for each security in the list,
  reference data must be available

- ReferenceCurve: the curve which will be used to calculate the bond
  spread. This curve will also be shifted by the resulting spread

- IborIndexCurves: for each Ibor index that is required by one of the
  bonds to which the curve is fitted, a mapping to an estimation curve
  for that index must be provided

- ExtrapolateFlat: if true, the parametric curve is extrapolated flat in
  the instantaneous forward rate before the first and after the last
  maturity of the bonds in the calibration basket. This avoids
  unrealistic rates at the short end or for long maturities in the
  resulting curve.

<div class="listing">

``` xml
        <YieldCurve>
        <CurveId>USD.Benchmark.Curve_Shifted</CurveId>
        <CurveDescription>Curve shifted with a bond's spreads at the bond duration tenors</CurveDescription>
        <Currency>USD</Currency>
        <DiscountCurve/>
        <Segments>
          <BondYieldShifted>
            <Type>Bond Yield Shifted</Type>
            <ReferenceCurve>USD1D</ReferenceCurve>
            <Quotes>
              <Quote>BOND/PRICE/EJ7706660</Quote>
              <Quote>BOND/PRICE/ZR5330686</Quote>
              <Quote>BOND/PRICE/AS0644417</Quote>
            </Quotes>
            <Conventions>BOND_CONVENTIONS</Conventions>
            <ExtrapolateFlat>true</ExtrapolateFlat>
            <IborIndexCurves>
              <IborIndexCurve iborIndex="USD-LIBOR-3M">USD3M</IborIndexCurve>
            </IborIndexCurves>
          </BondYieldShifted>
        </Segments>
        <InterpolationVariable>Discount</InterpolationVariable>
        <InterpolationMethod>Linear</InterpolationMethod>
        <YieldCurveDayCounter>A365</YieldCurveDayCounter>
        <Tolerance> </Tolerance>
        <Extrapolation>true</Extrapolation>
        <BootstrapConfig> </BootstrapConfig>
    </YieldCurve>
```

</div>

### Yield plus Default Segment

When the node name is `YieldPlusDefault`, the `Type` node has the only
allowable value *Yield Plus Default*, and the node has the structure
shown in Listing
<a href="#lst:yield_plus_default_segment" data-reference-type="ref"
data-reference="lst:yield_plus_default_segment">[lst:yield_plus_default_segment]</a>.
This segment is used to build all-in discounting yield curves from a
benchmark curve and (a weighted sum of) default curves. The construction
is in some sense inverse to the benchmark default curve construction,
see <a href="#ss:benchmark_default_curve" data-reference-type="ref"
data-reference="ss:benchmark_default_curve">0.1.3</a>.

- ReferenceCurve: the benchmark yield curve serving as the basis of the
  resulting yield curve

- DefaultCurves: a list of default curves whose weighted sum is added to
  the benchmark yield curve

- Weights: a list of weights for the default curves, the number of
  weights must match the number of default curves

Notice that it is explicitly allowed to use default curves in different
currencies than the benchmark yield curve. In the construction, the
hazard rate is reinterpreted as an instantaneous forward rate, and the
sum of the curves is being built in the instantaneous forward rate.

The definition takes into account the recovery rates associated to each
default curve. The resulting discount factor is computed as

$$P(0,t) = \prod_i  S_i(t)^{(1-R)w_i}$$

where $S_i$ and $R_i$ are the survival probabilities and recovery rates
of the source default curves, and $w_i$ are the weights.

<div class="listing">

``` xml
  <YieldCurve>
    <CurveId>BenchmarkPlusDefault</CurveId>
    <CurveDescription>USD Libor 3M + 0.5 x CDX.NA.HY + 0.5 x EUR.10BP</CurveDescription>
    <Currency>USD</Currency>
    <DiscountCurve/>
    <Segments>
      <YieldPlusDefault>
        <Type>Yield Plus Default</Type>
        <ReferenceCurve>USD3M</ReferenceCurve>
        <DefaultCurves>
          <DefaultCurve>Default/USD/CDX.NA.HY</DefaultCurve>
          <DefaultCurve>Default/EUR/EUR.10BP</DefaultCurve>
        </DefaultCurves>
        <Weights>
          <Weight>0.5</Weight>
          <Weight>0.5</Weight>
        </Weights>
      </YieldPlusDefault>
    </Segments>
  </YieldCurve>
</YieldCurves>
```

</div>

### Weighted Average Segment

When the node name is `WeightedAverage`, the `Type` node has the only
allowable value *Weighted Average*, and the node has the structure shown
in Listing
<a href="#lst:weighted_average_segment" data-reference-type="ref"
data-reference="lst:weighted_average_segment">[lst:weighted_average_segment]</a>.
This segment is used to build a curve with instantaneous forward rates
that are the weighted sum of instantaneous forward rates of reference
curves. This way a projection curve for non-standard Ibor curves can be
build, e.g. to project a Euribor2M index using the curves for 1M and 3M.

- ReferenceCurve1: the first source curve

- ReferenceCurve2: the second source curve

- Weight1: the weight of the first curve

- Weights: the weight of the second curve

If $P_1(0,t)$ and $P_2(0,t)$ denote the discount factors of the two
reference curves, the discount factor $P(0,t)$ of the resulting curve is
defined as

$$P(0,t) = P_1(0,t)^{w_1}P_2(0,t)^{w_2}$$

<div class="listing">

``` xml
<YieldCurve>
  <CurveId>EUR2M</CurveId>
  <CurveDescription>Euribor2M forwarding curve, interpolated from 1M and 3M</CurveDescription>
  <Currency>EUR</Currency>
  <DiscountCurve>EUR1D</DiscountCurve>
  <Segments>
    <WeightedAverage>
      <Type>Weighted Average</Type>
      <ReferenceCurve1>EUR1M</ReferenceCurve1>
      <ReferenceCurve2>EUR3M</ReferenceCurve2>
      <Weight1>0.5</Weight1>
      <Weight2>0.5</Weight2>
    </WeightedAverage>
  </Segments>
</YieldCurve>
```

</div>

### Ibor Fallback Segment

When the node name is `IborFallback`, the `Type` node has the only
allowable value *Ibor Fallback*, and the node has the structure shown in
Listing <a href="#lst:ibor_fallback_segment" data-reference-type="ref"
data-reference="lst:ibor_fallback_segment">[lst:ibor_fallback_segment]</a>.
This segment is used to build a projection curve for an Ibor index based
on a risk free rate and a spread.

<div class="listing">

``` xml
<YieldCurve>
  <CurveId>USD-LIBOR-3M</CurveId>
  <CurveDescription>USD-Libor-3M built from USD-SOFR plus spread</CurveDescription>
  <Currency>USD</Currency>
  <DiscountCurve/>
  <Segments>
    <IborFallback>
      <Type>Ibor Fallback</Type>
      <IborIndex>USD-LIBOR-3M</IborIndex>
      <RfrCurve>Yield/USD/USD-SOFR</RfrCurve>
      <!-- optional, if not given the rfr index and spread are read from the ibor
           fallback configuration -->
      <RfrIndex>USD-SOFR</RfrIndex>
      <Spread>0.0026161</Spread>
    </IborFallback>
  </Segments>
</YieldCurve>
```

</div>

### Discount Ratio Segment

When the node name is `DiscountRatio`, the `Type` node has the only
allowable value *Discount Ratio* and the node has the structure shown in
Listing <a href="#lst:discount_ratio_segment" data-reference-type="ref"
data-reference="lst:discount_ratio_segment">[lst:discount_ratio_segment]</a>.
This segment is used to build a curve with discount factors $P(0,t)$
from three input curves with discount factors $P_b(0,t)$, $P_n(0,t)$ and
$P_d(0,t)$ (“base”, “numerator”, “denominator” curves) following the
equation

$$\label{discount_ratio_df}
  P(0,t) = P_b(0,t) \frac{P_n(0,t)}{P_d(0,t)}$$

The main use case of this segment is to build a discount curve
“CCY1-IN-CCY2” for cashflows in CCY1 collateralized in CCY2 when curves
“CCY1-IN-BASE” and “CCY2-IN-BASE” are known for a common base currency
BASE:

For a maturity $t$ denote the zero rate on a curve “X” by $r_X(t)$ and
the correpsonding discount factor by $P_X(0,t)$. Furthermore, write
“CCY” as shorthand for “CCY-IN-CCY”, i.e. for the discount curve for
cashflows in the same currency as the collateral currency “CCY”. We
write the desired zero rate as

$$\label{discount_ratio_rates}
  \begin{split}
    r_{\text{CCY1-IN-CCY2}} = r_{\text{CCY2}} + & ( r_{\text{BASE-IN-CCY2}} - r_{\text{CCY2}} ) + \\
                               & (r_{\text{CCY1-IN-CCY2}} - r_{\text{BASE-IN-CCY2}})
  \end{split}$$

We now assume that these two rate differentials stay the same when we
switch from collateral currency “CCY2” to “BASE”, i.e.

$$\begin{aligned}
r_{\text{BASE-IN-CCY2}} - r_{\text{CCY2}} &\approx& r_{\text{BASE}} - r_{\text{CCY2-IN-BASE}} \label{discount_ratio_rate1} \\
r_{\text{CCY1-IN-CCY2}} - r_{\text{BASE-IN-CCY2}} &\approx& r_{\text{CCY1-IN-BASE}} - r_{\text{BASE}}  \label{discount_ratio_rate2}
\end{aligned}$$

In less technical terms we assume that FX Forward Quotes CCY2 / BASE and
CCY1 / BASE stay constant when the collateral currency changes, which
seems reasonable, if no further market information is available.

The discount factors associated to the RHS of
<a href="#discount_ratio_rate1" data-reference-type="ref"
data-reference="discount_ratio_rate1">[discount_ratio_rate1]</a> and
<a href="#discount_ratio_rate2" data-reference-type="ref"
data-reference="discount_ratio_rate2">[discount_ratio_rate2]</a> can be
written

$$\begin{aligned}
  P_{\text{BASE}}(0,t) / P_{\text{CCY2-IN-BASE}}(0,t) \\
  P_{\text{CCY1-IN-BASE}}(0,t) / P_{\text{BASE}}(0,t)
\end{aligned}$$

and so <a href="#discount_ratio_df" data-reference-type="ref"
data-reference="discount_ratio_df">[discount_ratio_df]</a> can be
written

$$\label{discount_ratio_df2}
  P_{\text{CCY1-IN-CCY2}}(0,t) = \frac{P_{\text{CCY2}}(0,t) P_{\text{CCY1-IN-BASE}}(0,t)}{P_{\text{CCY2-IN-BASE}}(0,t)}$$

so the following choice of curves will result in the desired
“CCY1-IN-CCY2” curve:

- base curve = “CCY2-IN-CCY2”

- numerator curve = “CCY1-IN-BASE”

- denominator curve = “CCY2-IN-BASE”

<div class="listing">

``` xml
<YieldCurve>
  <CurveId>GBP-IN-EUR</CurveId>
  <CurveDescription>GBP collateralized in EUR discount curve</CurveDescription>
  <Currency>GBP</Currency>
  <DiscountCurve/>
  <Segments>
    <DiscountRatio>
      <Type>Discount Ratio</Type>
      <BaseCurve currency="EUR">EUR1D</BaseCurve>
      <NumeratorCurve currency="GBP">GBP-IN-USD</NumeratorCurve>
      <DenominatorCurve currency="EUR">EUR-IN-USD</DenominatorCurve>
    </DiscountRatio>
  </Segments>
</YieldCurve>
```

</div>

### Default Curves from CDS

Default curves can be bootstrapped from credit default swap (CDS) market
instruments. The CDS market quotes may be given as a par spread or as an
upfront price. These market quotes are documented in Sections
<a href="#md:cds_spread_quote" data-reference-type="ref"
data-reference="md:cds_spread_quote">[md:cds_spread_quote]</a> and
<a href="#md:cds_price_quote" data-reference-type="ref"
data-reference="md:cds_price_quote">[md:cds_price_quote]</a>
respectively. The bootstrap also requires a market recovery rate quote
and this is documented in Section
<a href="#md:cds_recovery_rate_quote" data-reference-type="ref"
data-reference="md:cds_recovery_rate_quote">[md:cds_recovery_rate_quote]</a>.

Listing
<a href="#lst:defaultcurve_cds_configuration" data-reference-type="ref"
data-reference="lst:defaultcurve_cds_configuration">[lst:defaultcurve_cds_configuration]</a>
outlines the configuration required to build a default curve from CDS
quotes. The meaning of each of the nodes is as follows:

- `CurveId`: Unique identifier for the bootstrapped default curve. For
  index term curves a suffix `_5Y` should be appended to the name
  indicating the index term, since this is the preferred name looked up
  by index cds and index cds option pricers. If such a curve is not
  found, the pricers will fall back to the specified credit curve id
  without suffix, i.e. following this naming convention is not
  mandatory, but recommended.

- `CurveDescription` \[Optional\]: A description of the default curve.
  It is for information only and may be left blank.

- `Currency`: The default curve’s currency.

- `Type`: For a default curve built from CDS, the `Type` should be set
  to `SpreadCDS` if the `Quotes` reference CDS spread quotes or `Price`
  if the `Quotes` reference upfront price quotes or `ConvSpreadCDS` if
  the `Quotes` reference Conventional CDS spread quotes. Note that if
  ConvSpreadCDS or Price is used, the model will be IsdaCdsEngine. Else,
  MidPointCdsEngine.

- `DiscountCurve`: A reference to a valid discount curve specification
  that will be used to discount cashflows during the bootstrap process.
  It should be of the form `Yield/Currency/curve_name` where
  `curve_name` is the name of a yield curve defined in the yield curve
  configurations.

- `DayCounter`: The day counter used to convert from dates to times in
  the underlying structure. Allowable values are given in the Table
  <a href="#tab:daycount" data-reference-type="ref"
  data-reference="tab:daycount">[tab:daycount]</a>.

- `RecoveryRate`: A valid recovery rate quote name as documented in
  Section
  <a href="#md:cds_recovery_rate_quote" data-reference-type="ref"
  data-reference="md:cds_recovery_rate_quote">[md:cds_recovery_rate_quote]</a>.

- `StartDate` \[Optional\]: The `StartDate` is optional and is used for
  index CDS to specify the start date of the index CDS. This is then
  used to determine the maturity associated with the index CDS spread
  quotes which are quoted with a tenor. For single name CDS, this should
  be omitted.

- `RunningSpread` \[Optional\]: The `RunningSpread` is optional and is
  used for

  - stripping cds curves from upfront quotes. Alternatively the upfront
    quote labels can contain the running spread.

  - the calculation of the ATM level in cds and index cds volatility
    surfaces that are strike dependent

  The value should be set whenever one of these use cases applies.

- `IndexTerm` \[Optional\]: The `IndexTerm` is optional and is used to
  set up index cds curves for a specific term. If several quotes are
  specified explicitly or via wildcards, the quote matching the
  specified term is used to build a flat curve. If no quote is available
  for the specified term, an interpolated term quote will be built using
  the adjacent terms of the provided quotes.

- `Quotes`: The `Quotes` element should be populated with a list of
  valid `Quote` elements. If the `Type` is `SpreadCDS`, the quotes
  should be CDS spread quote strings as documented in Section
  <a href="#md:cds_spread_quote" data-reference-type="ref"
  data-reference="md:cds_spread_quote">[md:cds_spread_quote]</a> and if
  `Type` is `Price`, the quotes should be CDS upfront price quote
  strings as documented in Section
  <a href="#md:cds_price_quote" data-reference-type="ref"
  data-reference="md:cds_price_quote">[md:cds_price_quote]</a> and If
  the `Type` is `ConvSpreadCDS`, the quotes should be Conv CDS spread
  quote strings as documented in Section
  <a href="#md:cds_spread_quote" data-reference-type="ref"
  data-reference="md:cds_spread_quote">[md:cds_spread_quote]</a>. The
  attribute `optional` in the `Quote` element should be set to `true` if
  the associated quote is optional and set to `false` if the associated
  quote is mandatory. If a quote is mandatory and not found in the
  market, the default curve building will fail. The attribute `optional`
  may be omitted from the quote element. In this case, it defaults to
  `false` and the quote is mandatory. Note also that instead of a list
  of explicit quotes, a single quote may be provided with the wildcard
  character `*`. In this case, the market is searched for quotes
  matching the pattern. For example,
  `CDS/CREDIT_SPREAD/JPM/SNRFOR/USD/XR14/*` would return all quotes in
  the market that start with `CDS/CREDIT_SPREAD/JPM/SNRFOR/USD/XR14`.

- `Conventions`: The name of a valid set of CDS conventions, as
  documented in Section
  <a href="#sss:cds_conventions" data-reference-type="ref"
  data-reference="sss:cds_conventions">[sss:cds_conventions]</a>, to use
  in the bootstrap.

- `Extrapolation` \[Optional\]: A boolean value indicating if the
  bootstrapped default curve allows for extrapolation past the last
  pillar date. Allowable boolean values are given in the Table
  <a href="#tab:boolean_allowable" data-reference-type="ref"
  data-reference="tab:boolean_allowable">[tab:boolean_allowable]</a>. If
  omitted, it defaults to `true`.

- `ImplyDefaultFromMarket` \[Optional\]: A boolean value indicating if a
  reference entity’s default should be implied from the market data.
  Allowable boolean values are given in the Table
  <a href="#tab:boolean_allowable" data-reference-type="ref"
  data-reference="tab:boolean_allowable">[tab:boolean_allowable]</a>. If
  omitted, it defaults to `false`. When a default credit event has been
  determined for an entity, certain market data providers continue to
  supply a recovery rate from the credit event determination date up to
  the credit event auction settlement date. In this period, no CDS
  spreads or upfront prices are provided. When this flag is `true`, we
  assume an entity is in default and awaiting a credit event auction if
  we find a recovery rate in the market but no CDS spreads or upfront
  prices. In this case, we build a survival probability curve with a
  value of close to but greater than 0.0 for one day after the valuation
  date. This will give an approximation to the correct price for CDS and
  index CDS in these cases. When this flag is `false`, we make no such
  assumption and the default curve building will fail.

- `BootstrapConfig` \[Optional\]: This node holds configuration details
  for the iterative bootstrap that are described in section
  <a href="#sec:bootstrap_config" data-reference-type="ref"
  data-reference="sec:bootstrap_config">0.1.21</a>. If omitted, this
  node’s default values described in section
  <a href="#sec:bootstrap_config" data-reference-type="ref"
  data-reference="sec:bootstrap_config">0.1.21</a> are used.

- AllowNegativeRates \[Optional\]: If set to false (default) negative
  instantaneous hazard rates implied by the CDS quotes lead to an
  exception or - if the DontThrow flag in the BootstrapConfig is set to
  true - to a zero instantaneous hazard rate in the relevant segment of
  the curve. In the latter case the market CDS instrument associated to
  the critical curve segment will not match the market quote exactly. If
  set to true, negative instantaneous hazard rates will be allowed
  during the bootstrap (in a range that is technically defined by the
  MaxFactor and MaxAttempts parameters for the survival probability in
  the bootstrap config).

<div class="longlisting">

``` xml
<DefaultCurve>
  <CurveId>...</CurveId>
  <CurveDescription>...</CurveDescription>
  <Currency>USD</Currency>
  <Type>...</Type>
  <DiscountCurve>...</DiscountCurve>
  <DayCounter>...</DayCounter>
  <RecoveryRate>...</RecoveryRate>
  <StartDate>...</StartDate>
  <RunningSpread>...</RunningSpread>
  <IndexTerm>...</IndexTerm>
  <Quotes>
    <Quote optional="true">...</Quote>
    ...
  </Quotes>
  <Conventions>...</Conventions>
  <Extrapolation>...</Extrapolation>
  <ImplyDefaultFromMarket>...</ImplyDefaultFromMarket>
  <BootstrapConfig>
    ...
  </BootstrapConfig>
  <AllowNegativeRates>...</AllowNegativeRates>
</DefaultCurve>
```

</div>

### Benchmark Default Curve

Default curves can be set up as a difference curve of two yield curves
as shown in listing
<a href="#lst:defaultcurve_benchmark" data-reference-type="ref"
data-reference="lst:defaultcurve_benchmark">[lst:defaultcurve_benchmark]</a>.
A typical use case is to back out a default curve from an all-in
discounting curve fitted to a series of liquid bond prices (the “source
curve”) and a benchmark curve representing a benchmark funding level.
The default curve can then be used in models consuming a benchmark curve
and a default curve.

If $P_B(0,t)$ and $P_S(0,t)$ denote the discount factors of the given
benchmark and source curve respectively the resulting default term
structures has survival probabilities

$$S(t) = \left( P_S(0,t) / P_B(0,t) \right) ^ { 1/(1-R) }$$

on the given pillar times. Her, $R$ is the specified recovery rate. If
the recovery rate is zero, which is the usual case, the formula
simplifies to

$$S(0,t) = P_S(0,t) / P_B(0,t)$$

The interpolation is backward flat in the hazard rate. The meaning of
each node is as follows:

- CurveId: The curve id.

- CurveDescription: The curve description.

- Currency: The currency of the curve.

- Type: Must be set to Benchmark.

- DayCounter: The day counter used to convert dates to times.

- RecoveryRate \[optional\]: The recovery rate for the resulting default
  curve. Defaults to zero. The recovery rate can be a market quote as
  usual or also a fixed numeric value for this curve type.

- BenchmarkCurve: The benchmark yield curve, typically this is the
  standard Ibor curve in the currency (e.g. EUR-EURIBOR-6M,
  USD-Libor-3M, ...)

- SourceCurve: The all-in discounting curve.

- Pillars: The pillars on which to match the source curve

- SpotLag: The pillar dates are derived using the spot lag and the
  tenors as specified in the Pillars node using the specified calendar.

- Calendar: The calendar used to derive the pillar dates.

- Extrapolation \[Optional\]: If set to true, the curve is extrapoalted
  beyond the last pillar. Defaults to true.

- AllowNegativeRates \[Optional\]: If set to true, the check for
  non-negative instantaneous hazard rate in the result curve is
  disabled, i.e. the relation $P_S(0,t) \leq P_B(0,t)$ is not enforced.
  This flag should be enabled with care, i.e. a model consuming the
  resulting default curve must be able to handle negative hazard rates
  appropriately. On the other hand in some situations it is natural that
  the source curve rates are below the benchmark rates. Defaults to
  false.

<div class="longlisting">

``` xml
    <DefaultCurve>
      <CurveId>BOND_YIELD_EUR_OVER_OIS</CurveId>
      <CurveDescription>Default curve derived as bond yield curve over Eonia</CurveDescription>
      <Currency>EUR</Currency>
      <Type>Benchmark</Type>
      <DayCounter>A365</DayCounter>
      <RecoveryRate>RECOVERY_RATE/RATE//SNR/USD</RecoveryRate>
      <BenchmarkCurve>Yield/EUR/EUR6M</BenchmarkCurve>
      <SourceCurve>Yield/EUR/BOND_YIELD_EUR</SourceCurve>
      <Pillars>1Y,2Y,3Y,4Y,5Y,7Y,10Y</Pillars>
      <SpotLag>0</SpotLag>
      <Calendar>TARGET</Calendar>
      <Extrapolation>true</Extrapolation>
      <AllowNegativeRates>false</AllowNegativeRates>
    </DefaultCurve>
  </DefaultCurves>
```

</div>

### Multi-Section Default Curve

Default curves can be build by stitching together instantaneous hazard
rates from multiple source curves for multiple date ranges as shown in
listing
<a href="#lst:defaultcurve_multisection" data-reference-type="ref"
data-reference="lst:defaultcurve_multisection">[lst:defaultcurve_multisection]</a>.

The hazard rate of the resulting curve is taken from the $i$th input
curve ($i=0,1,2,\ldots$) for dates before the $i$th switch date and (if
$i>0$) on or after the $i-1$th switch date. The day counter of all input
curves should be equal to the day counter of the result curve. The
interpolation is hardcoded as backward flat in the hazard rate.

If not given, the recovery rate $R$ is assumed to be zero. The result
default curve’s survival probabiltiies are computed as

$$S(t) = \left[ \left(\frac{P_{S,n}(t)}{P_{S,n}(t_{n})}\right)^{(1-R_n)} \Pi_{i=0}^{n-1} \left(\frac{P_{S,i}(t_{i+1})}{P_{S,i}(t_{i})}\right)^{(1-R_i)} \right] ^ { \frac{1}{1-R} }$$

where $P_{S,i}$ is the survival probability of the $i$th source curve,
$R_i$ is the associated recovery rate for the $i$th source curve, $n$ is
chosen such that $P_{S,n}$ is the relevant source curve for time $t$
according to the given switch dates and curve $i$ is relevant for times
in $[t_i,t_{i+1}]$.

The meaning of each node is as follows:

- CurveId: The curve id.

- CurveDescription: The curve description.

- Currency: The currency of the curve.

- Type: Must be set to MutliSection.

- SourceCurves: The list of input default curves.

- SwitchDates: The list of dates where we switch from one input curve to
  the next. The number of switch dates must be one less than the number
  of source curves.

- DayCounter: The day counter used to convert dates to times.

- RecoveryRate \[optional\]: The recovery rate for the resulting default
  curve. Defaults to zero. The recovery rate can be a market quote as
  usual or also a fixed numeric value for this curve type.

- Extrapolation \[Optional\]: If set to true, the curve is extrapoalted
  beyond the last pillar. Defaults to true.

<div class="longlisting">

``` xml
<DefaultCurve>
   <CurveId>MyMultiSectionDefaultCurve</CurveId>
   <CurveDescription>Default curve with multiple sections</CurveDescription>
   <Currency>USD</Currency>
   <Type>MultiSection</Type>
   <SourceCurves>
     <SourceCurve>Default/USD/Generic_AA_Curve</SourceCurve>
     <SourceCurve>Default/USD/Generic_B_Curve</SourceCurve>
     <SourceCurve>Default/USD/Generic_C_Curve</SourceCurve>
   </SourceCurves>
   <SwitchDates>
     <SwitchDate>2020-10-01</SwitchDate>
     <SwitchDate>2021-12-01</SwitchDate>
   <SwitchDates>
   <Extrapolation>true</Extrapolation>
   <DayCounter>A365</DayCounter>
   <RecoveryRate>RECOVERY_RATE/RATE/NAME/SR/USD</RecoveryRate>
</DefaultCurve>
```

</div>

### Default Curve from YieldCurve

Default curves can be set up as a wrapper around a yield curve as shown
in listing
<a href="#lst:defaultcurve_from_yield" data-reference-type="ref"
data-reference="lst:defaultcurve_from_yield">[lst:defaultcurve_from_yield]</a>.
A typical use case is reinterpret a funding spread curve as default
curve for use in appropriate pricers. If $P(0,t)$ denotes the discount
factor of the given yield curve the resulting default term structures
has survival probabilities

$$S(t) = \left( P(0,t)\right) ^ { 1/(1-R) }$$

on the given pillar times, where $R$ is the specified recovery rate.

The meaning of each node is as follows:

- CurveId: The curve id.

- CurveDescription: The curve description.

- Currency: The currency of the curve.

- Type: Must be set to YieldCurve.

- DayCounter: The day counter used to convert dates to times.

- RecoveryRate \[optional\]: The recovery rate for the resulting default
  curve. Defaults to zero. The recovery rate can be a market quote as
  usual or also a fixed numeric value for this curve type.

- ReinterpretedYieldCurve: The yield curve to wrap.

- Extrapolation \[Optional\]: If set to true, the curve is extrapolated
  beyond the last pillar. Defaults to true.

<div class="longlisting">

``` xml
    <DefaultCurve>
			<CurveId>FundingCurveAsCrediCurve</CurveId>
			<Currency>EUR</Currency>
			<CurveDescription>Issuer funding spread curve as credit curve</CurveDescription>
			<Configurations>
				<Configuration priority="0">
					<Type>YieldCurve</Type>
					<DayCounter>Actual/360</DayCounter>
					<RecoveryRate>RECOVERY_RATE/RATE/CPTY_C/SR/EUR</RecoveryRate>
					<ReinterpretedYieldCurve>Yield/EUR/FundingCurve</ReinterpretedYieldCurve>
					<Extrapolation>true</Extrapolation>
				</Configuration>
			</Configurations>
		</DefaultCurve>
```

</div>

### Swaption Volatility Structures

Listing
<a href="#lst:swaptionvol_configuration" data-reference-type="ref"
data-reference="lst:swaptionvol_configuration">[lst:swaptionvol_configuration]</a>
shows an example of a Swaption volatility structure configuration.

<div class="longlisting">

``` xml
<SwaptionVolatilities>
  <SwaptionVolatility>
    <CurveId>EUR_SW_N</CurveId>
    <CurveDescription>EUR normal swaption volatilities</CurveDescription>
    <Dimension>ATM</Dimension>
    <VolatilityType>Normal</VolatilityType>
    <Interpolation>Hagan2002NormalZeroBeta</Interpolation>
    <ParametricSmileConfiguration>
      <Parameters>
        <Parameter>
          <Name>alpha</Name>
          <InitialValue>0.0050</InitialValue>
          <Calibration>Implied</Calibration>
        </Parameter>
        <Parameter>
          <Name>beta</Name>
          <InitialValue>0.0</InitialValue>
          <Calibration>Fixed</Calibration>
        </Parameter>
        <Parameter>
          <Name>nu</Name>
          <InitialValue>0.30</InitialValue>
          <Calibration>Calibrated</Calibration>
        </Parameter>
        <Parameter>
          <Name>rho</Name>
          <InitialValue>0.0</InitialValue>
          <Calibration>Calibrated</Calibration>
        </Parameter>
      </Parameters>
      <Calibration>
        <MaxCalibrationAttempts>10</MaxCalibrationAttempts>
        <ExitEarlyErrorThreshold>0.005</ExitEarlyErrorThreshold>
        <MaxAcceptableError>0.05</MaxAcceptableError>
      </Calibration>
    </ParametricSmileConfiguration>
    <Extrapolation>Flat</Extrapolation>
    <OutputVolatilityType>Normal</OutputVolatilityType>
    <OutputShift>0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0</OutputShift>
    <ModelShift>0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0</ModelShift>
    <DayCounter>Actual/365 (Fixed)</DayCounter>
    <Calendar>TARGET</Calendar>
    <BusinessDayConvention>Following</BusinessDayConvention>
    <!-- ATM matrix specification -->
    <OptionTenors>1M,3M,6M,1Y,2Y,3Y,4Y,5Y,7Y,10Y,15Y,20Y,25Y,30Y</OptionTenors>
    <SwapTenors>1Y,2Y,3Y,4Y,5Y,7Y,10Y,15Y,20Y,25Y,30Y</SwapTenors>
    <ShortSwapIndexBase>EUR-CMS-1Y</ShortSwapIndexBase>
    <SwapIndexBase>EUR-CMS-30Y</SwapIndexBase>
    <!-- Smile section specification -->
    <SmileOptionTenors>6M,1Y,10Y</SmileOptionTenors>
    <SmileSwapTenors>2Y,5Y</SmileSwapTenors>
    <SmileSpreads>-0.02,-0.01,0.01,0.02</SmileSpreads>
    <QuoteTag/>
  </SwaptionVolatility>
  ...
</SwaptionVolatilities>
```

</div>

The meaning of each of the elements in Listing
<a href="#lst:swaptionvol_configuration" data-reference-type="ref"
data-reference="lst:swaptionvol_configuration">[lst:swaptionvol_configuration]</a>
is given below.

- CurveId: Unique identifier of the swaption volatility structure

- CurveDescription \[Optional\]: A description of the volatility
  structure, may be left blank.

- Dimension: Distinguishes at-the-money matrices and full volatility
  cubes.  
  Allowable values: `ATM, Smile`

- VolatilityType: Specifies the type of market volatility inputs.  
  Allowable values: `Normal, Lognormal, ShiftedLognormal`  
  In the case of `ShiftedLognormal`, a matrix of shifts (by option and
  swap tenor) has to be provided in the market data input.

- Interpolation: Optional. Possible values: Linear, Hagan2002Lognormal,
  Hagan2002Normal, Hagan2002NormalZeroBeta,
  Antonov2015FreeBoundaryNormal, KienitzLawsonSwaynePde,
  FlochKennedy[^1]. If not given, defaults to Linear.

- ParametricSmileConfiguration: Optional. Applies to SABR only. If not
  given, default values are used. Allows to specify initial values for
  calibrated parameters, to exclude single parameters from calibration
  and to set calibration parameters. See Example 59 for how to configure
  single value and termstructures of sabr parameters for swaption and
  cap curve configs.

- Extrapolation: Specifies the extrapolation behaviour in all
  dimensions.  
  Allowable values: `Linear, Flat, None`

- OutputVolatilityType: Optional, defaults to input volatility type.
  Possible values: Normal, Lognormal (alias for ShiftedLognormal, shift
  is taken from OutputShift if given, or input market data shift. Input
  market quotes will be converted to output volatility type and shift
  before building the vol surfaces, except for parametric models (SABR),
  where the model is calibrated to the input market data directly
  (without conversion) and the output volatility type and shift is
  handled by the calibrated parametric model. An early conversion of the
  input market data would not be an advantage in this case, we could
  only loose information.

- OutputShift: Optional, defaults to input market data shift. Specifies
  the shift if OutputVolatilityType is Lognormal / ShiftedLognormal

- ModelShift: Optional, defaults to input market data shift. Specifies
  the shift used for SABR model if applicable

- DayCounter: The term structure’s day counter used in date to time
  conversions

- Calendar: The term structure’s calendar used in option tenor to date
  conversions

- BusinessDayConvention: The term structure’s business day convention
  used in option tenor to date conversion

- ATM Matrix specification, required for both Dimension choices:

  - OptionTenors: Option expiry in period form

  - SwapTenors: Underlying Swap term in period form

  - ShortSwapIndexBase: Swap index (ORE naming convention, e.g.
    EUR-CMS-1Y) used to compute ATM strikes for tenors up to and
    including the tenor given in the index (1Y in this example)

  - SwapIndexBase: Swap index used to compute ATM strikes for tenors
    longer than the one defined by the short index

- Smile section specification, this part is required when Dimension is
  set to `Smile`, otherwise it can be omitted:

  - SmileOptionTenors: Option expiries, in period form, where smile
    section data is to be taken into account

  - SmileSwapTenors: Underlying Swap term, in period form, where smile
    section data is to be taken into account

  - SmileSpreads: Strikes in smile direction expressed as strike
    spreads, relative to the ATM strike at the expiry/term point of the
    ATM matrix. Note that trailing 0s are not ignored.

- QuoteTag \[Optional\]: If non-empty, a tag will be included in the
  market datum labels. This can be used to set up underlying specific
  volatility date. For example, if the quote tag is set to
  EUR-EURIBOR-3M, the market datum labels will be
  `SWAPTION/RATE_LNVOL/EUR/EUR-EURIBOR-3M/5Y/10Y/ATM` instead of
  `SWAPTION/RATE_LNVOL/EUR/5Y/10Y/ATM`. See section
  <a href="#ss:swaptionvolatilitydata" data-reference-type="ref"
  data-reference="ss:swaptionvolatilitydata">[ss:swaptionvolatilitydata]</a>.

### Cap Floor Volatility Structures

The cap volatility structure parameterisation allows the user to pick
out term cap volatilities or optionlet volatilities in the market data.

If term cap volatilities are given, users can define how they should be
stripped to create an optionlet volatility structure. The
parameterisation allows for three separate types of input term cap
volatility structures:

1.  A strip of at-the-money (ATM) cap volatilities.

2.  A cap maturity tenor by absolute cap strike grid of cap
    volatilities.

3.  A combined structure containing both the ATM cap volatilities and
    the maturity by strike grid of cap volatilities.

If optionlet volatilities are given, no bootstrapping will be performed
on the input market data. The curve or surface will be constructed using
the interpolation method defined by user. The parameterisation allows
for three separate types of input optionlet volatilities structures:

1.  A strip of at-the-money (ATM) optionlet volatilities.

2.  A optionlet maturity tenor by absolute optionlet strike grid of
    optionlet volatilities.

3.  A combined structure containing both the ATM optionlet volatilities
    and the maturity by strike grid of optionlet volatilities.

The input volatilities may be normal, lognormal or shifted lognormal.
The structure of the market quotes is provided in Table
<a href="#tab:capfloor_implvol_quote" data-reference-type="ref"
data-reference="tab:capfloor_implvol_quote">[tab:capfloor_implvol_quote]</a>.

Whether the input market data are term cap volatilities or optionlet
volatilities depends on the value of the `InputType` node. This node may
be set to `TermVolatilities` for term cap volatilities or
`OptionletVolatilities` for optionlet volatilities.

For term cap volatilities, the structure of the XML, i.e. the nodes that
are necessary, used and ignored, and the way that the optionlet
volatilities are stripped hinges on the value of the `InterpolateOn`
node. This node may be set to `TermVolatilities` or
`OptionletVolatilities`. This node will be ignored if the inputs are
optionlet volatilities.

When set to `TermVolatilities`, a column of sequential caps or floors,
are created for each strike level out to the maximum cap maturity
configured. In other words, if the index tenor is 6M, the first cap
created would have a maturity of 1Y, the second cap 18M, the third cap
2Y and so on until we have a cap with maturity equal to the maximum
maturity tenor in the configuration. The volatility for each of these
caps or floors is then interpolated from the term cap volatility surface
using the configured interpolation. Finally, the optionlet volatility at
each cap or floor maturity, starting from the first, is derived in turn
such that the column of cap or floor volatilities are matched.

When set to `OptionletVolatilities`, the optionlet volatility structure
pillar dates are set to the fixing dates on the last caplet on each of
the configured caps or floors i.e. caps or floors with the maturities in
the configured `Tenors` or `AtmTenors`. The optionlet volatilities on
these pillar dates are then solved for such that the configured cap or
floor volatilities are matched.

In the following sections, we describe six XML configurations separately
for clarity:

1.  Term volatility ATM curve with interpolation on term volatilities.

2.  Term volatility ATM curve with interpolation on optionlet
    volatilities.

3.  Term volatility surface, possibly including an ATM column, with
    interpolation on term volatilities.

4.  Term volatility surface, possibly including an ATM column, with
    interpolation on optionlet volatilities.

5.  Optionlet volatility ATM curve.

6.  Optionlet volatility surface.

Before describing the different configurations we summarize the usage of
the various interpolation fields:

1.  If `InterpolateOn` is set to `TermVolatilities`,
    `InterpolationMethod` is used to interpolate the term volatilities
    during the bootstrap and to interpolate the optionlet volatilities
    of the final optionlet surface. The fields `TimeInterpolation` and
    `StrikeInterpolation` are ignored in this case.

2.  If `InterpolateOn` is set to `OptionletVolatilities`,
    `TimeInterpolation` and `StrikeInterpolation` are used to
    interpolate optionlet volatilities both during the bootstrap and on
    the final optionlet surface. `InterpolationMethod` is ignored in
    this case.

Listing <a href="#lst:capfloorvol_atm_configuration_term"
data-reference-type="ref"
data-reference="lst:capfloorvol_atm_configuration_term">[lst:capfloorvol_atm_configuration_term]</a>
shows the layout for parameterising an ATM cap volatility curve with
interpolation on term volatilities. Nodes that have no effect for this
parameterisation but that are allowed by the schema are not referenced.
The meaning of each of the nodes is as follows:

- `CurveId`: Unique identifier for the cap floor volatility structure.

- `CurveDescription` \[Optional\]: A description of the volatility
  structure. It is for information only and may be left blank.

- `VolatilityType`: Indicates the cap floor volatility type. It may be
  `Normal`, `Lognormal` or `ShiftedLognormal`. Note that this then
  determines which market data points are looked up in the market when
  creating the ATM cap floor curve and how they are interpreted when
  stripping the optionlets. In particular, the market will be searched
  for market data points of the form
  `CAPFLOOR/RATE_NVOL/Currency/Tenor/IndexTenor/1/1/0`,
  `CAPFLOOR/RATE_LNVOL/Currency/Tenor/IndexTenor/1/1/0` or
  `CAPFLOOR/RATE_SLNVOL/Currency/Tenor/IndexTenor/1/1/0` respectively.

- `OutputVolatilityType`: Specifies the vol used for caplet bootstrap
  and result surface, one of `Normal`, `Lognormal` or
  `ShiftedLognormal`, defaults to  Normal for backwards compatibility
  before release 1.83.0

- `OutputShift`: Specifies the vol shift used for caplet bootstrap and
  result surface (if OutputVolatilityType is `Lognormal` or
  `ShiftedLognormal`), defaults to input market data shift.

- `ModelShift`: Specifies the vol shift used for SABR model (if
  applicable). Defaults to input market data shift.

- `Extrapolation`: Indicates the extrapolation in the time direction
  before the first optionlet volatility and after the last optionlet
  volatility. The extrapolation occurs on the stripped optionlet
  volatilities. The allowable values are `None`, `Flat` and `Linear`. If
  set to `None`, extrapolation is turned off and an exception is thrown
  if the optionlet surface is queried outside the allowable times. If
  set to `Flat`, the first optionlet volatility is used before the first
  time and the last optionlet volatility is used after the last time. If
  set to `Linear`, the interpolation method configured in
  `InterpolationMethod` is used to extrapolate.

- `InterpolationMethod` \[Optional\]: Indicates the interpolation in the
  time direction. As `InterpolateOn` is set to `TermVolatilities` here,
  the interpolation is used in the stripping process to interpolate the
  term cap floor volatility curve as explained above. It is also used to
  interpolate the optionlet volatilities when an optionlet volatility is
  queried from the stripped optionlet structure. The allowable values
  are `Bilinear` and `BicubicSpline`. If not set, `BicubicSpline` is
  assumed. Obviously, as we are describing an ATM curve here, there is
  no interpolation in the strike direction so when `Bilinear` is set the
  time interpolation is linear and when `BicubicSpline` is set the time
  interpolation is cubic spline.

- `IncludeAtm`: A boolean value indicating if an ATM curve should be
  used. Allowable boolean values are given in the Table
  <a href="#tab:boolean_allowable" data-reference-type="ref"
  data-reference="tab:boolean_allowable">[tab:boolean_allowable]</a>. As
  we are describing an ATM curve here, this node should be set to `true`
  as shown in <a href="#lst:capfloorvol_atm_configuration_term"
  data-reference-type="ref"
  data-reference="lst:capfloorvol_atm_configuration_term">[lst:capfloorvol_atm_configuration_term]</a>.

- `DayCounter`: The day counter used to convert from dates to times in
  the underlying structure. Allowable values are given in the Table
  <a href="#tab:daycount" data-reference-type="ref"
  data-reference="tab:daycount">[tab:daycount]</a>.

- `Calendar`: The calendar used to advance dates by periods in the
  underlying structure. In particular, it is used in deriving the cap
  maturity dates from the configured cap tenors. Allowable values are
  given in the Table <a href="#tab:calendar" data-reference-type="ref"
  data-reference="tab:calendar">[tab:calendar]</a>.

- `BusinessDayConvention`: The business day convention used to advance
  dates by periods in the underlying structure. In particular, it is
  used in deriving the cap maturity dates from the configured cap
  tenors. Allowable values are given in the Table
  <a href="#tab:allow_stand_data" data-reference-type="ref"
  data-reference="tab:allow_stand_data">[tab:allow_stand_data]</a> under
  `Roll Convention`.

- `Tenors` \[Optional\]: A comma separated list of valid tenor strings
  giving the cap floor maturity tenors to be used in the ATM curve. If
  omitted, the tenors for the ATM curve must be provided in the
  `AtmTenors` node instead. If the tenors are provided here, the
  `AtmTenors` node may be omitted.

- `OptionalQuotes` \[Optional\]: A boolean flag to indicate whether
  market data quotes for all tenors are required. If true, we attempt to
  build the curve from whatever quotes are provided. If false, the curve
  will fail to build if any quotes are missing. This also applies to
  quotes for the `AtmTenors`. Default value is false.

- `IborIndex`: A valid interest rate index name giving the index
  underlying the cap floor quotes. Allowable values are given in the
  Table <a href="#tab:indices" data-reference-type="ref"
  data-reference="tab:indices">[tab:indices]</a>.

- `DiscountCurve`: A reference to a valid discount curve specification
  that will be used to discount cashflows during the stripping process.
  It should be of the form `Yield/Currency/curve_name` where
  `curve_name` is the name of a yield curve defined in the yield curve
  configurations.

- `AtmTenors` \[Optional\]: A comma separated list of valid tenor
  strings giving the cap floor maturities to be used in the ATM curve.
  If omitted, the tenors for the ATM curve must be provided in the
  `Tenors` node instead. If the tenors are provided here, the `Tenors`
  node may be omitted.

- `SettlementDays` \[Optional\]: Any non-negative integer is allowed
  here. If omitted, it is assumed to be 0. If provided the reference
  date of the term volatility curve and the stripped optionlet
  volatility structure will be calculated by advancing the valuation
  date by this number of days using the configured calendar and business
  day convention. In general, this should be omitted or set to 0.

- `InterpolateOn`: As referenced above, the allowable values are
  `TermVolatilities` or `OptionletVolatilities`. As we are describing
  here an ATM curve with interpolation on term volatilities, this should
  be set to `TermVolatilities` as shown in Listing
  <a href="#lst:capfloorvol_atm_configuration_term"
  data-reference-type="ref"
  data-reference="lst:capfloorvol_atm_configuration_term">[lst:capfloorvol_atm_configuration_term]</a>.

- `BootstrapConfig` \[Optional\]: This node holds configuration details
  for the iterative bootstrap that are described in section
  <a href="#sec:bootstrap_config" data-reference-type="ref"
  data-reference="sec:bootstrap_config">0.1.21</a>. If omitted, this
  node’s default values described in section
  <a href="#sec:bootstrap_config" data-reference-type="ref"
  data-reference="sec:bootstrap_config">0.1.21</a> are used.

- `InputType` \[Optional\]: The type of the marketdata input. Allowable
  values are `TermVolatilities` or `OptionletVolatilities`. As we are
  describing term cap volatilities input, this should be set to
  `TermVolatilities` or omitted as shown in Listing
  <a href="#lst:capfloorvol_atm_configuration_term"
  data-reference-type="ref"
  data-reference="lst:capfloorvol_atm_configuration_term">[lst:capfloorvol_atm_configuration_term]</a>.
  If omitted, the default value is `TermVolatilities`.

<div class="longlisting">

``` xml
<CapFloorVolatility>
  <CurveId>...</CurveId>
  <CurveDescription>...</CurveDescription>
  <VolatilityType>...</VolatilityType>
  <OutputVolatilityType>...</OutputVolatilityType>
  <OutputShift>...</OutputShift>
  <ModelShift>...</ModelShift>
  <Extrapolation>...</Extrapolation>
  <InterpolationMethod>...</InterpolationMethod>
  <IncludeAtm>true</IncludeAtm>
  <DayCounter>...</DayCounter>
  <Calendar>...</Calendar>
  <BusinessDayConvention>...</BusinessDayConvention>
  <Tenors>...</Tenors>
  <OptionalQuotes>...</OptionalQuotes>
  <IborIndex>...</IborIndex>
  <DiscountCurve>...</DiscountCurve>
  <AtmTenors>...</AtmTenors>
  <SettlementDays>...</SettlementDays>
  <InterpolateOn>TermVolatilities</InterpolateOn>
  <BootstrapConfig>...</BootstrapConfig>
  <InputType>TermVolatilities</InputType>
</CapFloorVolatility>
```

</div>

Listing <a href="#lst:capfloorvol_atm_configuration_opt"
data-reference-type="ref"
data-reference="lst:capfloorvol_atm_configuration_opt">[lst:capfloorvol_atm_configuration_opt]</a>
shows the layout for parameterising an ATM cap volatility curve with
interpolation on optionlet volatilities. Nodes that have no effect for
this parameterisation but that are allowed by the schema are not
referenced. The meaning of each of the nodes is as follows:

- `CurveId`: Unique identifier for the cap floor volatility structure.

- `CurveDescription` \[Optional\]: A description of the volatility
  structure. It is for information only and may be left blank.

- `VolatilityType`: Indicates the cap floor volatility type. It may be
  `Normal`, `Lognormal` or `ShiftedLognormal`. Note that this then
  determines which market data points are looked up in the market when
  creating the ATM cap floor curve and how they are interpreted when
  stripping the optionlets. In particular, the market will be searched
  for market data points of the form
  `CAPFLOOR/RATE_NVOL/Currency/Tenor/IndexTenor/1/1/0`,
  `CAPFLOOR/RATE_LNVOL/Currency/Tenor/IndexTenor/1/1/0` or
  `CAPFLOOR/RATE_SLNVOL/Currency/Tenor/IndexTenor/1/1/0` respectively.

- `OutputVolatilityType`: Specified the vol used for caplet bootstrap
  and result surface, one of `Normal`, `Lognormal` or
  `ShiftedLognormal`, defaults to  Normal for backwards compatibility
  before release 1.83.0

- `OutputShift`: Specifies the vol shift used for caplet bootstrap and
  result surface (if OutputVolatilityType is `Lognormal` or
  `ShiftedLognormal`), defaults to input market data shift.

- `ModelShift`: Specifies the vol shift used for SABR model (if
  applicable). Defaults to input market data shift.

- `Extrapolation`: The allowable values are `None`, `Flat` and `Linear`.
  If set to `None`, extrapolation is turned off and an exception is
  thrown if the optionlet surface is queried outside the allowable
  times. Otherwise, extrapolation is allowed and the type of
  extrapolation is determined by the `TimeInterpolation` node value
  described below.

- `IncludeAtm`: A boolean value indicating if an ATM curve should be
  used. Allowable boolean values are given in the Table
  <a href="#tab:boolean_allowable" data-reference-type="ref"
  data-reference="tab:boolean_allowable">[tab:boolean_allowable]</a>. As
  we are describing an ATM curve here, this node should be set to `true`
  as shown in <a href="#lst:capfloorvol_atm_configuration_opt"
  data-reference-type="ref"
  data-reference="lst:capfloorvol_atm_configuration_opt">[lst:capfloorvol_atm_configuration_opt]</a>.

- `DayCounter`: The day counter used to convert from dates to times in
  the underlying structure. Allowable values are given in the Table
  <a href="#tab:daycount" data-reference-type="ref"
  data-reference="tab:daycount">[tab:daycount]</a>.

- `Calendar`: The calendar used to advance dates by periods in the
  underlying structure. In particular, it is used in deriving the cap
  maturity dates from the configured cap tenors. Allowable values are
  given in the Table <a href="#tab:calendar" data-reference-type="ref"
  data-reference="tab:calendar">[tab:calendar]</a>.

- `BusinessDayConvention`: The business day convention used to advance
  dates by periods in the underlying structure. In particular, it is
  used in deriving the cap maturity dates from the configured cap
  tenors. Allowable values are given in the Table
  <a href="#tab:allow_stand_data" data-reference-type="ref"
  data-reference="tab:allow_stand_data">[tab:allow_stand_data]</a> under
  `Roll Convention`.

- `Tenors` \[Optional\]: A comma separated list of valid tenor strings
  giving the cap floor maturity tenors to be used in the ATM curve. If
  omitted, the tenors for the ATM curve must be provided in the
  `AtmTenors` node instead. If the tenors are provided here, the
  `AtmTenors` node may be omitted.

- `OptionalQuotes` \[Optional\]: A boolean flag to indicate whether
  market data quotes for all tenors are required. If true, we attempt to
  build the curve from whatever quotes are provided. If false, the curve
  will fail to build if any quotes are missing. This also applies to
  quotes for the `AtmTenors`. Default value is false.

- `IborIndex`: A valid interest rate index name giving the index
  underlying the cap floor quotes. Allowable values are given in the
  Table <a href="#tab:indices" data-reference-type="ref"
  data-reference="tab:indices">[tab:indices]</a>.

- `DiscountCurve`: A reference to a valid discount curve specification
  that will be used to discount cashflows during the stripping process.
  It should be of the form `Yield/Currency/curve_name` where
  `curve_name` is the name of a yield curve defined in the yield curve
  configurations.

- `AtmTenors` \[Optional\]: A comma separated list of valid tenor
  strings giving the cap floor maturities to be used in the ATM curve.
  If omitted, the tenors for the ATM curve must be provided in the
  `Tenors` node instead. If the tenors are provided here, the `Tenors`
  node may be omitted.

- `SettlementDays` \[Optional\]: Any non-negative integer is allowed
  here. If omitted, it is assumed to be 0. If provided the reference
  date of the term volatility curve and the stripped optionlet
  volatility structure will be calculated by advancing the valuation
  date by this number of days using the configured calendar and business
  day convention. In general, this should be omitted or set to 0.

- `InterpolateOn`: As referenced above, the allowable values are
  `TermVolatilities` or `OptionletVolatilities`. As we are describing
  here an ATM curve with interpolation on optionlet volatilities, this
  should be set to `OptionletVolatilities` as shown in Listing
  <a href="#lst:capfloorvol_atm_configuration_opt"
  data-reference-type="ref"
  data-reference="lst:capfloorvol_atm_configuration_opt">[lst:capfloorvol_atm_configuration_opt]</a>.

- `TimeInterpolation` \[Optional\]: Indicates the interpolation and
  extrapolation, if allowed by the `Extrapolation` node, in the time
  direction. As `InterpolateOn` is set to `OptionletVolatilities` here,
  the interpolation is used to interpolate the optionlet volatilities
  only i.e. there is no interpolation on the term cap floor volatility
  curve. The allowable values are `Linear`, `LinearFlat`,
  `BackwardFlat`, `Cubic` and `CubicFlat`. If not set, `LinearFlat` is
  assumed. Note that `Linear` indicates linear interpolation and linear
  extrapolation. `LinearFlat` indicates linear interpolation and flat
  extrapolation. Analogous meanings apply for `Cubic` and `CubicFlat`.

- `BootstrapConfig` \[Optional\]: This node holds configuration details
  for the iterative bootstrap that are described in section
  <a href="#sec:bootstrap_config" data-reference-type="ref"
  data-reference="sec:bootstrap_config">0.1.21</a>. If omitted, this
  node’s default values described in section
  <a href="#sec:bootstrap_config" data-reference-type="ref"
  data-reference="sec:bootstrap_config">0.1.21</a> are used.

- `InputType` \[Optional\]: The type of the marketdata input. Allowable
  values are `TermVolatilities` or `OptionletVolatilities`. As we are
  describing term cap volatilities input, this should be set to
  `TermVolatilities` or omitted as shown in Listing
  <a href="#lst:capfloorvol_atm_configuration_opt"
  data-reference-type="ref"
  data-reference="lst:capfloorvol_atm_configuration_opt">[lst:capfloorvol_atm_configuration_opt]</a>.
  If omitted, the default value is `TermVolatilities`.

<div class="longlisting">

``` xml
<CapFloorVolatility>
  <CurveId>...</CurveId>
  <CurveDescription>...</CurveDescription>
  <VolatilityType>...</VolatilityType>
  <OutputVolatilityType>...</OutputVolatilityType>
  <OutputShift>...</OutputShift>
  <ModelShift>...</ModelShift>
  <Extrapolation>...</Extrapolation>
  <IncludeAtm>true</IncludeAtm>
  <DayCounter>...</DayCounter>
  <Calendar>...</Calendar>
  <BusinessDayConvention>...</BusinessDayConvention>
  <Tenors>...</Tenors>
  <OptionalQuotes>...</OptionalQuotes>
  <IborIndex>...</IborIndex>
  <DiscountCurve>...</DiscountCurve>
  <AtmTenors>...</AtmTenors>
  <SettlementDays>...</SettlementDays>
  <InterpolateOn>OptionletVolatilities</InterpolateOn>
  <TimeInterpolation>...</TimeInterpolation>
  <BootstrapConfig>...</BootstrapConfig>
  <InputType>TermVolatilities</InputType>
</CapFloorVolatility>
```

</div>

Listing <a href="#lst:capfloorvol_surface_configuration_term"
data-reference-type="ref"
data-reference="lst:capfloorvol_surface_configuration_term">[lst:capfloorvol_surface_configuration_term]</a>
shows the layout for parameterising a cap tenor by absolute cap strike
volatility surface with interpolation on term volatilities. This
parameterisation also allows for the inclusion of a cap floor ATM curve
in combination with the surface. Nodes that have no effect for this
parameterisation but that are allowed by the schema are not referenced.
The meaning of each of the nodes is as follows:

- `CurveId`: Unique identifier for the cap floor volatility structure.

- `CurveDescription` \[Optional\]: A description of the volatility
  structure. It is for information only and may be left blank.

- `VolatilityType`: Indicates the cap floor volatility type. It may be
  `Normal`, `Lognormal` or `ShiftedLognormal`. Note that this then
  determines which market data points are looked up in the market when
  creating the cap floor surface and how they are interpreted when
  stripping the optionlets. In particular, the market will be searched
  for market data points of the form
  `CAPFLOOR/RATE_NVOL/Currency/Tenor/IndexTenor/0/0/Strike`,
  `CAPFLOOR/RATE_LNVOL/Currency/Tenor/IndexTenor/0/0/Strike` or
  `CAPFLOOR/RATE_SLNVOL/Currency/Tenor/IndexTenor/0/0/Strike`
  respectively.

- `OutputVolatilityType`: Specified the vol used for caplet bootstrap
  and result surface, one of `Normal`, `Lognormal` or
  `ShiftedLognormal`, defaults to  Normal for backwards compatibility
  before release 1.83.0

- `OutputShift`: Specifies the vol shift used for caplet bootstrap and
  result surface (if OutputVolatilityType is `Lognormal` or
  `ShiftedLognormal`), defaults to input market data shift.

- `ModelShift`: Specifies the vol shift used for SABR model (if
  applicable). Defaults to input market data shift.

- `Extrapolation`: Indicates the extrapolation in the time and strike
  direction. The extrapolation occurs on the stripped optionlet
  volatilities. The allowable values are `None`, `Flat` and `Linear`. If
  set to `None`, extrapolation is turned off and an exception is thrown
  if the optionlet surface is queried outside the allowable times or
  strikes. If set to `Flat`, the optionlet volatility on the time strike
  boundary is used if the optionlet surface is queried outside the
  allowable times or strikes. If set to `Linear`, the interpolation
  method configured in `InterpolationMethod` is used to extrapolate
  either time or strike direction.

- `InterpolationMethod` \[Optional\]: Indicates the interpolation in the
  time and strike direction. As `InterpolateOn` is set to
  `TermVolatilities` here, the interpolation is used in the stripping
  process to interpolate the term cap floor volatility surface as
  explained above. It is also used to interpolate the optionlet
  volatilities when an optionlet volatility is queried from the stripped
  optionlet structure. The allowable values are `Bilinear` and
  `BicubicSpline`. If not set, `BicubicSpline` is assumed.

- `IncludeAtm`: A boolean value indicating if an ATM curve should be
  used in combination with the surface. Allowable boolean values are
  given in the Table
  <a href="#tab:boolean_allowable" data-reference-type="ref"
  data-reference="tab:boolean_allowable">[tab:boolean_allowable]</a>. If
  set to `true`, the `AtmTenors` node needs to be populated with the ATM
  tenors to use. The ATM quotes that are searched for are as outlined in
  the previous two ATM sections above. The original stripped optionlet
  surface is amended by inserting the optionlet volatilities at the
  successive ATM strikes that reproduce the sequence of ATM cap
  volatilities.

- `DayCounter`: The day counter used to convert from dates to times in
  the underlying structure. Allowable values are given in the Table
  <a href="#tab:daycount" data-reference-type="ref"
  data-reference="tab:daycount">[tab:daycount]</a>.

- `Calendar`: The calendar used to advance dates by periods in the
  underlying structure. In particular, it is used in deriving the cap
  maturity dates from the configured cap tenors. Allowable values are
  given in the Table <a href="#tab:calendar" data-reference-type="ref"
  data-reference="tab:calendar">[tab:calendar]</a>.

- `BusinessDayConvention`: The business day convention used to advance
  dates by periods in the underlying structure. In particular, it is
  used in deriving the cap maturity dates from the configured cap
  tenors. Allowable values are given in the Table
  <a href="#tab:allow_stand_data" data-reference-type="ref"
  data-reference="tab:allow_stand_data">[tab:allow_stand_data]</a> under
  `Roll Convention`.

- `Tenors`: A comma separated list of valid tenor strings giving the cap
  floor maturity tenors to be used in the tenor by strike surface. In
  this case, i.e. configuring a surface, they must be provided.

- `OptionalQuotes` \[Optional\]: A boolean flag to indicate whether
  market data quotes for all tenors are required. If true, we attempt to
  build the curve from whatever quotes are provided. If false, the curve
  will fail to build if any quotes are missing. This also applies to
  quotes for the `AtmTenors`. Default value is false.

- `IborIndex`: A valid interest rate index name giving the index
  underlying the cap floor quotes. Allowable values are given in the
  Table <a href="#tab:indices" data-reference-type="ref"
  data-reference="tab:indices">[tab:indices]</a>.

- `DiscountCurve`: A reference to a valid discount curve specification
  that will be used to discount cashflows during the stripping process.
  It should be of the form `Yield/Currency/curve_name` where
  `curve_name` is the name of a yield curve defined in the yield curve
  configurations.

- `AtmTenors` \[Optional\]: A comma separated list of valid tenor
  strings giving the cap floor maturity tenors to be used in the ATM
  curve. It must be provided when `IncludeAtm` is `true` and omitted
  when `IncludeAtm` is `false`.

- `SettlementDays` \[Optional\]: Any non-negative integer is allowed
  here. If omitted, it is assumed to be 0. If provided the reference
  date of the term volatility curve and the stripped optionlet
  volatility structure will be calculated by advancing the valuation
  date by this number of days using the configured calendar and business
  day convention. In general, this should be omitted or set to 0.

- `InterpolateOn`: As referenced above, the allowable values are
  `TermVolatilities` or `OptionletVolatilities`. As we are describing
  here a surface with interpolation on term volatilities, this should be
  set to `TermVolatilities` as shown in Listing
  <a href="#lst:capfloorvol_surface_configuration_term"
  data-reference-type="ref"
  data-reference="lst:capfloorvol_surface_configuration_term">[lst:capfloorvol_surface_configuration_term]</a>.

- `BootstrapConfig` \[Optional\]: This node holds configuration details
  for the iterative bootstrap that are described in section
  <a href="#sec:bootstrap_config" data-reference-type="ref"
  data-reference="sec:bootstrap_config">0.1.21</a>. If omitted, this
  node’s default values described in section
  <a href="#sec:bootstrap_config" data-reference-type="ref"
  data-reference="sec:bootstrap_config">0.1.21</a> are used.

- `InputType` \[Optional\]: The type of the marketdata input. Allowable
  values are `TermVolatilities` or `OptionletVolatilities`. As we are
  describing term cap volatilities input, this should be set to
  `TermVolatilities` or omitted as shown in Listing
  <a href="#lst:capfloorvol_surface_configuration_term"
  data-reference-type="ref"
  data-reference="lst:capfloorvol_surface_configuration_term">[lst:capfloorvol_surface_configuration_term]</a>.
  If omitted, the default value is `TermVolatilities`.

<div class="longlisting">

``` xml
<CapFloorVolatility>
  <CurveId>...</CurveId>
  <CurveDescription>...</CurveDescription>
  <VolatilityType>...</VolatilityType>
  <OutputVolatilityType>...</OutputVolatilityType>
  <OutputShift>...</OutputShift>
  <ModelShift>...</ModelShift>
  <Extrapolation>...</Extrapolation>
  <InterpolationMethod>...</InterpolationMethod>
  <IncludeAtm>...</IncludeAtm>
  <DayCounter>...</DayCounter>
  <Calendar>...</Calendar>
  <BusinessDayConvention>...</BusinessDayConvention>
  <Tenors>...</Tenors>
  <OptionalQuotes>...</OptionalQuotes>
  <IborIndex>...</IborIndex>
  <DiscountCurve>...</DiscountCurve>
  <AtmTenors>...</AtmTenors>
  <SettlementDays>...</SettlementDays>
  <InterpolateOn>TermVolatilities</InterpolateOn>
  <BootstrapConfig>...</BootstrapConfig>
  <InputType>TermVolatilities</InputType>
</CapFloorVolatility>
```

</div>

Listing <a href="#lst:capfloorvol_surface_configuration_opt"
data-reference-type="ref"
data-reference="lst:capfloorvol_surface_configuration_opt">[lst:capfloorvol_surface_configuration_opt]</a>
shows the layout for parameterising a cap tenor by absolute cap strike
volatility surface with interpolation on optionlet volatilities. This
parameterisation also allows for the inclusion of a cap floor ATM curve
in combination with the surface. Nodes that have no effect for this
parameterisation but that are allowed by the schema are not referenced.
The meaning of each of the nodes is as follows:

- `CurveId`: Unique identifier for the cap floor volatility structure.

- `CurveDescription` \[Optional\]: A description of the volatility
  structure. It is for information only and may be left blank.

- `VolatilityType`: Indicates the cap floor volatility type. It may be
  `Normal`, `Lognormal` or `ShiftedLognormal`. Note that this then
  determines which market data points are looked up in the market when
  creating the cap floor surface and how they are interpreted when
  stripping the optionlets. In particular, the market will be searched
  for market data points of the form
  `CAPFLOOR/RATE_NVOL/Currency/Tenor/IndexTenor/0/0/Strike`,
  `CAPFLOOR/RATE_LNVOL/Currency/Tenor/IndexTenor/0/0/Strike` or
  `CAPFLOOR/RATE_SLNVOL/Currency/Tenor/IndexTenor/0/0/Strike`
  respectively.

- `OutputVolatilityType`: Specified the vol used for caplet bootstrap
  and result surface, one of `Normal`, `Lognormal` or
  `ShiftedLognormal`, defaults to  Normal for backwards compatibility
  before release 1.83.0

- `OutputShift`: Specifies the vol shift used for caplet bootstrap and
  result surface (if OutputVolatilityType is `Lognormal` or
  `ShiftedLognormal`), defaults to input market data shift.

- `ModelShift`: Specifies the vol shift used for SABR model (if
  applicable). Defaults to input market data shift.

- `Extrapolation`: The allowable values are `None`, `Flat` and `Linear`.
  If set to `None`, extrapolation is turned off and an exception is
  thrown if the optionlet surface is queried outside the allowable times
  or strikes. Otherwise, extrapolation is allowed and the type of
  extrapolation is determined by the `TimeInterpolation` and
  `StrikeInterpolation` node values described below.

- `IncludeAtm`: A boolean value indicating if an ATM curve should be
  used in combination with the surface. Allowable boolean values are
  given in the Table
  <a href="#tab:boolean_allowable" data-reference-type="ref"
  data-reference="tab:boolean_allowable">[tab:boolean_allowable]</a>. If
  set to `true`, the `AtmTenors` node needs to be populated with the ATM
  tenors to use. The ATM quotes that are searched for are as outlined in
  the previous two ATM sections above. The original stripped optionlet
  surface is amended by inserting the optionlet volatilities at the
  configured ATM strikes that reproduce the configured ATM cap
  volatilities.

- `DayCounter`: The day counter used to convert from dates to times in
  the underlying structure. Allowable values are given in the Table
  <a href="#tab:daycount" data-reference-type="ref"
  data-reference="tab:daycount">[tab:daycount]</a>.

- `Calendar`: The calendar used to advance dates by periods in the
  underlying structure. In particular, it is used in deriving the cap
  maturity dates from the configured cap tenors. Allowable values are
  given in the Table <a href="#tab:calendar" data-reference-type="ref"
  data-reference="tab:calendar">[tab:calendar]</a>.

- `BusinessDayConvention`: The business day convention used to advance
  dates by periods in the underlying structure. In particular, it is
  used in deriving the cap maturity dates from the configured cap
  tenors. Allowable values are given in the Table
  <a href="#tab:allow_stand_data" data-reference-type="ref"
  data-reference="tab:allow_stand_data">[tab:allow_stand_data]</a> under
  `Roll Convention`.

- `Tenors`: A comma separated list of valid tenor strings giving the cap
  floor maturity tenors to be used in the tenor by strike surface. In
  this case, i.e. configuring a surface, they must be provided.

- `OptionalQuotes` \[Optional\]: A boolean flag to indicate whether
  market data quotes for all tenors and strikes are required. If true,
  we attempt to build the curve from whatever quotes are provided. If
  false, the curve will fail to build if any quotes are missing. This
  also applies to quotes for the `AtmTenors`. Default value is false.

- `IborIndex`: A valid interest rate index name giving the index
  underlying the cap floor quotes. Allowable values are given in the
  Table <a href="#tab:indices" data-reference-type="ref"
  data-reference="tab:indices">[tab:indices]</a>.

- `DiscountCurve`: A reference to a valid discount curve specification
  that will be used to discount cashflows during the stripping process.
  It should be of the form `Yield/Currency/curve_name` where
  `curve_name` is the name of a yield curve defined in the yield curve
  configurations.

- `AtmTenors` \[Optional\]: A comma separated list of valid tenor
  strings giving the cap floor maturity tenors to be used in the ATM
  curve. It must be provided when `IncludeAtm` is `true` and omitted
  when `IncludeAtm` is `false`.

- `SettlementDays` \[Optional\]: Any non-negative integer is allowed
  here. If omitted, it is assumed to be 0. If provided the reference
  date of the term volatility curve and the stripped optionlet
  volatility structure will be calculated by advancing the valuation
  date by this number of days using the configured calendar and business
  day convention. In general, this should be omitted or set to 0.

- `InterpolateOn`: As referenced above, the allowable values are
  `TermVolatilities` or `OptionletVolatilities`. As we are describing
  here a surface with interpolation on optionlet volatilities, this
  should be set to `OptionletVolatilities` as shown in Listing
  <a href="#lst:capfloorvol_surface_configuration_opt"
  data-reference-type="ref"
  data-reference="lst:capfloorvol_surface_configuration_opt">[lst:capfloorvol_surface_configuration_opt]</a>.

- `TimeInterpolation`: Indicates the interpolation and extrapolation, if
  allowed by the `Extrapolation` node, in the time direction. As
  `InterpolateOn` is set to `OptionletVolatilities` here, the
  interpolation is used to interpolate the optionlet volatilities only
  i.e. there is no interpolation on the term cap floor volatility curve.
  The allowable values are `Linear`, `LinearFlat`, `BackwardFlat`,
  `Cubic` and `CubicFlat`. If not set, `LinearFlat` is assumed. Note
  that `Linear` indicates linear interpolation and linear extrapolation.
  `LinearFlat` indicates linear interpolation and flat extrapolation.
  Analogous meanings apply for `Cubic` and `CubicFlat`.

- `StrikeInterpolation`: Indicates the interpolation and extrapolation,
  if allowed by the `Extrapolation` node, in the strike direction.
  Again, as `InterpolateOn` is set to `OptionletVolatilities` here, the
  interpolation is used to interpolate the optionlet volatilities in the
  strike direction. The allowable values are `Linear`, `LinearFlat`,
  `Cubic` and `CubicFlat` or one of the SABR variants
  Hagan2002Lognormal, Hagan2002Normal, Hagan2002NormalZeroBeta,
  Antonov2015FreeBoundaryNormal, KienitzLawsonSwaynePde, FlochKennedy.
  The SABR variants are only supported for InterpolateOn =
  OptionVolatilities (or if InputType = OptionletVolatilities). If not
  set, `LinearFlat` is assumed.

- ParametricSmileConfiguration: Optional. Applies to SABR only. If not
  given, default values are used. Allows to specify initial values for
  calibrated parameters, to exclude single parameters from calibration
  and to set calibration parameters. See listing
  <a href="#lst:capfloorvol_parametric_smile_config"
  data-reference-type="ref"
  data-reference="lst:capfloorvol_parametric_smile_config">[lst:capfloorvol_parametric_smile_config]</a>.
  See Example 59 for how to configure single value and termstructures of
  sabr parameters for swaption and cap curve configs.

- `QuoteIncludesIndexName` \[Optional\]: If true, the quote labels that
  are looked up in the market data to build the surface include the
  index name as e.g. in
  `CAPFLOOR/RATE_NVOL/USD/USD-LIBOR-3M/1Y/3M/0/0/0.01`. If false, the
  index name is not include as in
  `CAPFLOOR/RATE_NVOL/USD/1Y/3M/0/0/0.01`. If the flag is not given, it
  defaults to false. Including the index name in the market quotes
  allows to build cap surfaces on different underlying indices with the
  same tenor. The flag also affects shift quotes as e.g.
  `CAPFLOOR/SHIFT/USD/USD-LIBOR-3M/5Y` (index included in quote) vs.
  `CAPFLOOR/SHIFT/USD/5Y` (index not included in quote).

- `BootstrapConfig` \[Optional\]: This node holds configuration details
  for the iterative bootstrap that are described in section
  <a href="#sec:bootstrap_config" data-reference-type="ref"
  data-reference="sec:bootstrap_config">0.1.21</a>. If omitted, this
  node’s default values described in section
  <a href="#sec:bootstrap_config" data-reference-type="ref"
  data-reference="sec:bootstrap_config">0.1.21</a> are used.

- `InputType` \[Optional\]: The type of the marketdata input. Allowable
  values are `TermVolatilities` or `OptionletVolatilities`. As we are
  describing term cap volatilities input, this should be set to
  `TermVolatilities` or omitted as shown in Listing
  <a href="#lst:capfloorvol_surface_configuration_opt"
  data-reference-type="ref"
  data-reference="lst:capfloorvol_surface_configuration_opt">[lst:capfloorvol_surface_configuration_opt]</a>.
  If omitted, the default value is `TermVolatilities`.

<div class="longlisting">

``` xml
<CapFloorVolatility>
  <CurveId>...</CurveId>
  <CurveDescription>...</CurveDescription>
  <VolatilityType>...</VolatilityType>
  <OutputVolatilityType>...</OutputVolatilityType>
  <OutputShift>...</OutputShift>
  <ModelShift>...</ModelShift>
  <Extrapolation>...</Extrapolation>
  <InterpolationMethod>...</InterpolationMethod>
  <IncludeAtm>...</IncludeAtm>
  <DayCounter>...</DayCounter>
  <Calendar>...</Calendar>
  <BusinessDayConvention>...</BusinessDayConvention>
  <Tenors>...</Tenors>
  <OptionalQuotes>...</OptionalQuotes>
  <IborIndex>...</IborIndex>
  <DiscountCurve>...</DiscountCurve>
  <AtmTenors>...</AtmTenors>
  <SettlementDays>...</SettlementDays>
  <InterpolateOn>OptionletVolatilities</InterpolateOn>
  <TimeInterpolation>...</TimeInterpolation>
  <StrikeInterpolation>...</StrikeInterpolation>
  <QuoteIncludesIndexName>...</QuoteIncludesIndexName>
  <BootstrapConfig>...</BootstrapConfig>
  <InputType>TermVolatilities</InputType>
</CapFloorVolatility>
```

</div>

Listing <a href="#lst:capfloorvol_optionlet_atm_configuration"
data-reference-type="ref"
data-reference="lst:capfloorvol_optionlet_atm_configuration">[lst:capfloorvol_optionlet_atm_configuration]</a>
shows the layout for parameterising an ATM optionlet volatility curve.
Nodes that have no effect for this parameterisation but that are allowed
by the schema are not referenced. The meaning of each of the nodes is as
follows:

- `CurveId`: Unique identifier for the cap floor volatility structure.

- `CurveDescription` \[Optional\]: A description of the volatility
  structure. It is for information only and may be left blank.

- `VolatilityType`: Indicates the cap floor volatility type. It may be
  `Normal`, `Lognormal` or `ShiftedLognormal`. Note that this then
  determines which market data points are looked up in the market when
  creating the ATM optionlet curve. In particular, the market will be
  searched for market data points of the form
  `CAPFLOOR/RATE_NVOL/Currency/Tenor/IndexTenor/1/1/0`,
  `CAPFLOOR/RATE_LNVOL/Currency/Tenor/IndexTenor/1/1/0` or
  `CAPFLOOR/RATE_SLNVOL/Currency/Tenor/IndexTenor/1/1/0` respectively.

- `OutputVolatilityType`: Specified the vol used for caplet bootstrap
  and result surface, one of `Normal`, `Lognormal` or
  `ShiftedLognormal`, defaults to  Normal for backwards compatibility
  before release 1.83.0

- `OutputShift`: Specifies the vol shift used for caplet bootstrap and
  result surface (if OutputVolatilityType is `Lognormal` or
  `ShiftedLognormal`), defaults to input market data shift.

- `ModelShift`: Specifies the vol shift used for SABR model (if
  applicable). Defaults to input market data shift.

- `Extrapolation`: The allowable values are `None`, `Flat` and `Linear`.
  If set to `None`, extrapolation is turned off and an exception is
  thrown if the optionlet surface is queried outside the allowable
  times. Otherwise, extrapolation is allowed and the type of
  extrapolation is determined by the `TimeInterpolation` node value
  described below.

- `IncludeAtm`: A boolean value indicating if an ATM curve should be
  used. Allowable boolean values are given in the Table
  <a href="#tab:boolean_allowable" data-reference-type="ref"
  data-reference="tab:boolean_allowable">[tab:boolean_allowable]</a>. As
  we are describing an ATM curve here, this node should be set to `true`
  as shown in <a href="#lst:capfloorvol_optionlet_atm_configuration"
  data-reference-type="ref"
  data-reference="lst:capfloorvol_optionlet_atm_configuration">[lst:capfloorvol_optionlet_atm_configuration]</a>.

- `DayCounter`: The day counter used to convert from dates to times in
  the underlying structure. Allowable values are given in the Table
  <a href="#tab:daycount" data-reference-type="ref"
  data-reference="tab:daycount">[tab:daycount]</a>.

- `Calendar`: The calendar used to advance dates by periods in the
  underlying structure. In particular, it is used in deriving the cap
  maturity dates from the configured cap tenors. Allowable values are
  given in the Table <a href="#tab:calendar" data-reference-type="ref"
  data-reference="tab:calendar">[tab:calendar]</a>.

- `BusinessDayConvention`: The business day convention used to advance
  dates by periods in the underlying structure. In particular, it is
  used in deriving the cap maturity dates from the configured cap
  tenors. Allowable values are given in the Table
  <a href="#tab:allow_stand_data" data-reference-type="ref"
  data-reference="tab:allow_stand_data">[tab:allow_stand_data]</a> under
  `Roll Convention`.

- `Tenors` \[Optional\]: A comma separated list of valid tenor strings
  giving the cap floor maturity tenors to be used in the tenor by strike
  surface. A single wildcard character, `*`, can also be used for
  wildcard tenor. In this case, i.e. configuring a surface, they must be
  provided.

- `OptionalQuotes` \[Optional\]: A boolean flag to indicate whether
  market data quotes for all tenors are required. Optionlet volatilities
  do not support optional quotes, so this node should be false or
  omitted. Default value is false.

- `IborIndex`: A valid interest rate index name giving the index
  underlying the cap floor quotes. Allowable values are given in the
  Table <a href="#tab:indices" data-reference-type="ref"
  data-reference="tab:indices">[tab:indices]</a>.

- `DiscountCurve`: A reference to a valid discount curve specification
  that will be used to discount cashflows. It should be of the form
  `Yield/Currency/curve_name` where `curve_name` is the name of a yield
  curve defined in the yield curve configurations.

- `AtmTenors` \[Optional\]: A comma separated list of valid tenor
  strings giving the cap floor maturities to be used in the ATM curve. A
  single wildcard character, `*`, can also be used for wildcard tenor.
  In this case, all the tenors found in the market data input will be
  used to construct the ATM curve. If omitted, the tenors for the ATM
  curve must be provided in the `Tenors` node instead. If the tenors are
  provided here, the `Tenors` node may be omitted.

- `SettlementDays` \[Optional\]: Any non-negative integer is allowed
  here. If omitted, it is assumed to be 0. If provided the reference
  date of the term volatility curve and the stripped optionlet
  volatility structure will be calculated by advancing the valuation
  date by this number of days using the configured calendar and business
  day convention. In general, this should be omitted or set to 0.

- `TimeInterpolation` \[Optional\]: Indicates the interpolation and
  extrapolation, if allowed by the `Extrapolation` node, in the time
  direction. The allowable values are `Linear`, `LinearFlat`,
  `BackwardFlat`, `Cubic` and `CubicFlat`. If not set, `LinearFlat` is
  assumed. Note that `Linear` indicates linear interpolation and linear
  extrapolation. `LinearFlat` indicates linear interpolation and flat
  extrapolation. Analogous meanings apply for `Cubic` and `CubicFlat`.

- `InputType`: The type of the marketdata input. Allowable values are
  `TermVolatilities` or `OptionletVolatilities`. As we are describing
  ATM curve on optionlet volatilities, this should be set to
  `OptionletVolatilities` as shown in Listing
  <a href="#lst:capfloorvol_optionlet_atm_configuration"
  data-reference-type="ref"
  data-reference="lst:capfloorvol_optionlet_atm_configuration">[lst:capfloorvol_optionlet_atm_configuration]</a>.

<div class="longlisting">

``` xml
<CapFloorVolatility>
  <CurveId>...</CurveId>
  <CurveDescription>...</CurveDescription>
  <VolatilityType>...</VolatilityType>
  <OutputVolatilityType>...</OutputVolatilityType>
  <OutputShift>...</OutputShift>
  <ModelShift>...</ModelShift>
  <Extrapolation>...</Extrapolation>
  <IncludeAtm>true</IncludeAtm>
  <DayCounter>...</DayCounter>
  <Calendar>...</Calendar>
  <BusinessDayConvention>...</BusinessDayConvention>
  <Tenors>...</Tenors>
  <OptionalQuotes>false</OptionalQuotes>
  <IborIndex>...</IborIndex>
  <DiscountCurve>...</DiscountCurve>
  <AtmTenors>...</AtmTenors>
  <SettlementDays>...</SettlementDays>
  <TimeInterpolation>...</TimeInterpolation>
  <BootstrapConfig>...</BootstrapConfig>
  <InputType>OptionletVolatilities</InputType>
</CapFloorVolatility>
```

</div>

Listing <a href="#lst:capfloorvol_optionlet_surface_configuration"
data-reference-type="ref"
data-reference="lst:capfloorvol_optionlet_surface_configuration">[lst:capfloorvol_optionlet_surface_configuration]</a>
shows the layout for parameterising an optionlet tenor by absolute
optionlet strike volatility surface. This parameterisation also allows
for the inclusion of an optionlet ATM curve in combination with the
surface. Nodes that have no effect for this parameterisation but that
are allowed by the schema are not referenced. The meaning of each of the
nodes is as follows:

- `CurveId`: Unique identifier for the cap floor volatility structure.

- `CurveDescription` \[Optional\]: A description of the volatility
  structure. It is for information only and may be left blank.

- `VolatilityType`: Indicates the cap floor volatility type. It may be
  `Normal`, `Lognormal` or `ShiftedLognormal`. Note that this then
  determines which market data points are looked up in the market when
  creating the ATM optionlet curve. In particular, the market will be
  searched for market data points of the form
  `CAPFLOOR/RATE_NVOL/Currency/Tenor/IndexTenor/1/1/0`,
  `CAPFLOOR/RATE_LNVOL/Currency/Tenor/IndexTenor/1/1/0` or
  `CAPFLOOR/RATE_SLNVOL/Currency/Tenor/IndexTenor/1/1/0` respectively.

- `OutputVolatilityType`: Specified the vol used for caplet bootstrap
  and result surface, one of `Normal`, `Lognormal` or
  `ShiftedLognormal`, defaults to  Normal for backwards compatibility
  before release 1.83.0. Only available for SABR interpolation if input
  type is set to optionlet vols.

- `OutputShift`: Specifies the vol shift used for caplet bootstrap and
  result surface (if OutputVolatilityType is `Lognormal` or
  `ShiftedLognormal`), defaults to input market data shift.

- `ModelShift`: Specifies the vol shift used for SABR model (if
  applicable). Defaults to input market data shift.

- `Extrapolation`: The allowable values are `None`, `Flat` and `Linear`.
  If set to `None`, extrapolation is turned off and an exception is
  thrown if the optionlet surface is queried outside the allowable
  times. Otherwise, extrapolation is allowed and the type of
  extrapolation is determined by the `TimeInterpolation` node value
  described below.

- `IncludeAtm`: A boolean value indicating if an ATM curve should be
  used in combination with the surface. Allowable boolean values are
  given in the Table
  <a href="#tab:boolean_allowable" data-reference-type="ref"
  data-reference="tab:boolean_allowable">[tab:boolean_allowable]</a>. If
  set to `true`, the `AtmTenors` node needs to be populated with the ATM
  tenors to use. The ATM quotes that are searched for are as outlined in
  the previous sections above. The optionlet surface is amended by
  inserting the optionlet volatilities at the forecast fixings.

- `DayCounter`: The day counter used to convert from dates to times in
  the underlying structure. Allowable values are given in the Table
  <a href="#tab:daycount" data-reference-type="ref"
  data-reference="tab:daycount">[tab:daycount]</a>.

- `Calendar`: The calendar used to advance dates by periods in the
  underlying structure. In particular, it is used in deriving the cap
  maturity dates from the configured cap tenors. Allowable values are
  given in the Table <a href="#tab:calendar" data-reference-type="ref"
  data-reference="tab:calendar">[tab:calendar]</a>.

- `BusinessDayConvention`: The business day convention used to advance
  dates by periods in the underlying structure. In particular, it is
  used in deriving the cap maturity dates from the configured cap
  tenors. Allowable values are given in the Table
  <a href="#tab:allow_stand_data" data-reference-type="ref"
  data-reference="tab:allow_stand_data">[tab:allow_stand_data]</a> under
  `Roll Convention`.

- `Tenors` \[Optional\]: A comma separated list of valid tenor strings
  giving the cap floor maturity tenors to be used in the surface. A
  single wildcard character, `*`, can also be used for wildcard tenor.
  In this case, all the tenors found in the market data input will be
  used to construct the ATM curve. If omitted, the tenors for the ATM
  curve must be provided in the `AtmTenors` node instead. If the tenors
  are provided here, the `AtmTenors` node may be omitted.

- `OptionalQuotes` \[Optional\]: A boolean flag to indicate whether
  market data quotes for all tenors are required. Optionlet volatilities
  do not support optional quotes, so this node should be false or
  omitted. Default value is false.

- `IborIndex`: A valid interest rate index name giving the index
  underlying the cap floor quotes. Allowable values are given in the
  Table <a href="#tab:indices" data-reference-type="ref"
  data-reference="tab:indices">[tab:indices]</a>.

- `DiscountCurve`: A reference to a valid discount curve specification
  that will be used to discount cashflows. It should be of the form
  `Yield/Currency/curve_name` where `curve_name` is the name of a yield
  curve defined in the yield curve configurations.

- `AtmTenors` \[Optional\]: A comma separated list of valid tenor
  strings giving the cap floor maturities to be used in the ATM curve. A
  single wildcard character, `*`, can also be used for wildcard tenor.
  It must be provided when `IncludeAtm` is `true` and omitted when
  `IncludeAtm` is `false`.

- `SettlementDays` \[Optional\]: Any non-negative integer is allowed
  here. If omitted, it is assumed to be 0. If provided the reference
  date of the term volatility curve and the stripped optionlet
  volatility structure will be calculated by advancing the valuation
  date by this number of days using the configured calendar and business
  day convention. In general, this should be omitted or set to 0.

- `TimeInterpolation` \[Optional\]: Indicates the interpolation and
  extrapolation, if allowed by the `Extrapolation` node, in the time
  direction. The allowable values are `Linear`, `LinearFlat`,
  `BackwardFlat`, `Cubic` and `CubicFlat`. If not set, `LinearFlat` is
  assumed. Note that `Linear` indicates linear interpolation and linear
  extrapolation. `LinearFlat` indicates linear interpolation and flat
  extrapolation. Analogous meanings apply for `Cubic` and `CubicFlat`.

- `StrikeInterpolation` \[Optional\]: Indicates the interpolation and
  extrapolation, if allowed by the `Extrapolation` node, in the strike
  direction. Again, as `InterpolateOn` is set to `OptionletVolatilities`
  here, the interpolation is used to interpolate the optionlet
  volatilities in the strike direction. The allowable values are
  `Linear`, `LinearFlat`, `Cubic` and `CubicFlat`. If not set,
  `LinearFlat` is assumed.

- `QuoteIncludesIndexName` \[Optional\]: If true, the quote labels that
  are looked up in the market data to build the surface include the
  index name as e.g. in
  `CAPFLOOR/RATE_NVOL/USD/USD-LIBOR-3M/1Y/3M/0/0/0.01`. If false, the
  index name is not include as in
  `CAPFLOOR/RATE_NVOL/USD/1Y/3M/0/0/0.01`. If the flag is not given, it
  defaults to false. Including the index name in the market quotes
  allows to build cap surfaces on different underlying indices with the
  same tenor. The flag also affects shift quotes as e.g.
  `CAPFLOOR/SHIFT/USD/USD-LIBOR-3M/5Y` (index included in quote) vs.
  `CAPFLOOR/SHIFT/USD/5Y` (index not included in quote).

- `InputType`: The type of the marketdata input. Allowable values are
  `TermVolatilities` or `OptionletVolatilities`. As we are describing
  ATM curve on optionlet volatilities, this should be set to
  `OptionletVolatilities` as shown in Listing
  <a href="#lst:capfloorvol_optionlet_surface_configuration"
  data-reference-type="ref"
  data-reference="lst:capfloorvol_optionlet_surface_configuration">[lst:capfloorvol_optionlet_surface_configuration]</a>.

<div class="longlisting">

``` xml
<CapFloorVolatility>
  <CurveId>...</CurveId>
  <CurveDescription>...</CurveDescription>
  <VolatilityType>...</VolatilityType>
  <OutputVolatilityType>...</OutputVolatilityType>
  <OutputShift>...</OutputShift>
  <ModelShift>...</ModelShift>
  <Extrapolation>...</Extrapolation>
  <IncludeAtm>...</IncludeAtm>
  <DayCounter>...</DayCounter>
  <Calendar>...</Calendar>
  <BusinessDayConvention>...</BusinessDayConvention>
  <Tenors>...</Tenors>
  <OptionalQuotes>false</OptionalQuotes>
  <IborIndex>...</IborIndex>
  <DiscountCurve>...</DiscountCurve>
  <AtmTenors>...</AtmTenors>
  <SettlementDays>...</SettlementDays>
  <TimeInterpolation>...</TimeInterpolation>
  <StrikeInterpolation>...</StrikeInterpolation>
  <QuoteIncludesIndexName>...</QuoteIncludesIndexName>
  <InputType>OptionletVolatilities</InputType>
</CapFloorVolatility>
```

</div>

<div class="longlisting">

``` xml
<ParametricSmileConfiguration>
  <Parameters>
    <Parameter>
      <Name>alpha</Name>
      <InitialValue>0.0050</InitialValue>
      <Calibration>Implied</Calibration>
    </Parameter>
    <Parameter>
      <Name>beta</Name>
      <InitialValue>0.0</InitialValue>
      <Calibration>Fixed</Calibration>
    </Parameter>
    <Parameter>
      <Name>nu</Name>
      <InitialValue>0.30</InitialValue>
      <Calibration>Calibrated</Calibration>
    </Parameter>
    <Parameter>
      <Name>rho</Name>
      <InitialValue>0.0</InitialValue>
      <Calibration>Calibrated</Calibration>
    </Parameter>
  </Parameters>
  <Calibration>
    <MaxCalibrationAttempts>10</MaxCalibrationAttempts>
    <ExitEarlyErrorThreshold>0.005</ExitEarlyErrorThreshold>
    <MaxAcceptableError>0.05</MaxAcceptableError>
  </Calibration>
</ParametricSmileConfiguration>
```

</div>

### Proxy Cap Floor Volatility Configuration

In addition to the standard cap floor volatility configurations
described above, ORE supports proxy cap floor volatility surfaces. A
proxy configuration allows you to create a cap floor volatility surface
by referencing an existing cap floor volatility surface and adjusting it
for different underlying indices and optionally applying a scaling
factor.

Listing
<a href="#lst:capfloorvol_proxy_configuration" data-reference-type="ref"
data-reference="lst:capfloorvol_proxy_configuration">[lst:capfloorvol_proxy_configuration]</a>
shows the layout for parameterising a proxy cap floor volatility
surface. The meaning of each of the nodes is as follows:

- `CurveId`: Unique identifier for the cap floor volatility structure.

- `CurveDescription` \[Optional\]: A description of the volatility
  structure. It is for information only and may be left blank.

- `ProxyConfig`: Contains the proxy configuration settings. This node is
  required for proxy configurations and should be omitted for direct cap
  floor volatility configurations.

- `Source` (within ProxyConfig): Specifies the source cap floor
  volatility surface to use as the base for the proxy.

- `CurveId` (within Source): The curve identifier of the source cap
  floor volatility surface that will be used as the base. This must
  reference an existing cap floor volatility curve configuration.

- `Index` (within Source): The interest rate index associated with the
  source cap floor volatility surface.

- `RateComputationPeriod` \[Optional\] (within Source): The rate
  computation period for the source index. This is only required for OIS
  or BMA/SIFMA indices and should be omitted for standard IBOR indices.

- `Target` (within ProxyConfig): Specifies the target configuration for
  the proxy surface.

- `Index` (within Target): The target interest rate index for which the
  proxy surface will provide volatilities. This allows you to create a
  volatility surface for one index based on the volatility surface of
  another similar index.

- `RateComputationPeriod` \[Optional\] (within Target): The rate
  computation period for the target index. This is only required for OIS
  or BMA/SIFMA indices and should be omitted for standard IBOR indices.

- `ONCapSettlementDays` \[Optional\] (within Target): Settlement days
  for overnight index cap structures. Only relevant when the target
  index is an overnight index.

- `ScalingFactor` \[Optional\] (within ProxyConfig): An optional scaling
  factor to multiply the proxied volatility surface. If omitted,
  defaults to 1.0 (no scaling). This allows you to scale the entire
  volatility surface up or down by a constant factor. For example, a
  value of 1.1 would increase all volatilities by 10%, while 0.9 would
  decrease them by 10%. The scaling factor must be positive.

The proxy mechanism works by:

1.  Taking the base volatility surface from the specified source curve

2.  Adjusting the volatilities for differences in forward rate levels
    between the source and target indices

3.  Optionally applying the scaling factor to all volatilities

4.  Producing an optionlet volatility structure suitable for pricing
    instruments on the target index

This feature is particularly useful when you have a well-calibrated
volatility surface for one index (e.g., USD-LIBOR-3M) and want to create
a similar surface for a related index (e.g., USD-SOFR) by applying
appropriate adjustments and scaling.

<div class="longlisting">

``` xml
<CapFloorVolatility>
  <CurveId>USD-SOFR</CurveId>
  <CurveDescription>USD SOFR Cap Floor Volatility via USD LIBOR Proxy</CurveDescription>
  <ProxyConfig>
    <Source>
      <CurveId>USD-LIBOR-3M</CurveId>
      <Index>USD-LIBOR-3M</Index>
    </Source>
    <Target>
      <Index>USD-SOFR</Index>
      <RateComputationPeriod>3M</RateComputationPeriod>
      <ONCapSettlementDays>2</ONCapSettlementDays>
    </Target>
    <ScalingFactor>0.95</ScalingFactor>
  </ProxyConfig>
</CapFloorVolatility>
```

</div>

### FX Volatility Structures

Listings
<a href="#lst:fxoptionvol_configuration_atm" data-reference-type="ref"
data-reference="lst:fxoptionvol_configuration_atm">[lst:fxoptionvol_configuration_atm]</a>,
<a href="#lst:fxoptionvol_configuration_smile_vv"
data-reference-type="ref"
data-reference="lst:fxoptionvol_configuration_smile_vv">[lst:fxoptionvol_configuration_smile_vv]</a>,
<a href="#lst:fxoptionvol_configuration_smile_delta"
data-reference-type="ref"
data-reference="lst:fxoptionvol_configuration_smile_delta">[lst:fxoptionvol_configuration_smile_delta]</a>,
<a href="#lst:fxoptionvol_configuration_smile_bfrr"
data-reference-type="ref"
data-reference="lst:fxoptionvol_configuration_smile_bfrr">[lst:fxoptionvol_configuration_smile_bfrr]</a>,
<a href="#lst:fxoptionvol_configuration_smile_absolute"
data-reference-type="ref"
data-reference="lst:fxoptionvol_configuration_smile_absolute">[lst:fxoptionvol_configuration_smile_absolute]</a>,
<a href="#lst:fxoptionvol_configuration_atm_triangulated"
data-reference-type="ref"
data-reference="lst:fxoptionvol_configuration_atm_triangulated">[lst:fxoptionvol_configuration_atm_triangulated]</a>
shows examples of FX volatility structure configurations.

<div class="longlisting">

``` xml
  <FXVolatility>
    <CurveId>EURUSD</CurveId>
    <CurveDescription />
    <Dimension>ATM</Dimension>
    <Expiries>1M,3M,6M,1Y,2Y,3Y,10Y</Expiries>
    <FXSpotID>FX/EUR/USD</FXSpotID>
    <FXForeignCurveID>Yield/EUR/EUR-IN-USD</FXForeignCurveID>
    <FXDomesticCurveID>Yield/USD/USD1D</FXDomesticCurveID>
    <DayCounter>A365</DayCounter>
    <Calendar>US,TARGET</Calendar>
    <Conventions>EUR-USD-FXOPTION</Conventions>
  </FXVolatility>
```

</div>

<div class="longlisting">

``` xml
  <FXVolatility>
    <CurveId>USDJPY</CurveId>
    <CurveDescription />
    <Dimension>Smile</Dimension>
    <SmileType>VannaVolga</SmileType>
    <SmileInterpolation>VannaVolga2</SmileInterpolation>
    <Expiries>1M,3M,6M,1Y,2Y,3Y,10Y</Expiries>
    <SmileDelta>25</SmileDelta>
    <FXSpotID>FX/USD/JPY</FXSpotID>
    <FXForeignCurveID>Yield/USD/USD1D</FXForeignCurveID>
    <FXDomesticCurveID>Yield/JPY/JPY-IN-USD</FXDomesticCurveID>
    <DayCounter>A365</DayCounter>
    <Calendar>US,JP</Calendar>
    <Conventions>USD-JPY-FXOPTION</Conventions>
  </FXVolatility>
```

</div>

<div class="longlisting">

``` xml
  <FXVolatility>
    <CurveId>USDJPY</CurveId>
    <CurveDescription />
    <Dimension>Smile</Dimension>
    <SmileType>Delta</SmileType>
    <SmileInterpolation>Linear</SmileInterpolation>
    <Expiries>1M,3M,6M,1Y,2Y,3Y,10Y</Expiries>
    <Deltas>10P,20P,30P,40P,ATM,40C,30C,20C,10C</Deltas>
    <FXSpotID>FX/USD/JPY</FXSpotID>
    <FXForeignCurveID>Yield/USD/USD1D</FXForeignCurveID>
    <FXDomesticCurveID>Yield/JPY/JPY-IN-USD</FXDomesticCurveID>
    <DayCounter>A365</DayCounter>
    <Calendar>US,JP</Calendar>
    <Conventions>USD-JPY-FXOPTION</Conventions>
    <SmileExtrapolation>UseInterpolator</SmileExtrapolation>
  </FXVolatility>
```

</div>

<div class="longlisting">

``` xml
  <FXVolatility>
    <CurveId>USDJPY</CurveId>
    <CurveDescription />
    <Dimension>Smile</Dimension>
    <SmileType>BFRR</SmileType>
    <SmileInterpolation>Cubic</SmileInterpolation>
    <TimeInterpolation>V2T</TimeInterpolation>
    <TimeWeighting>USD-JPY-FXOPTION-TIMEWEIGHTING</TimeWeighting>
    <Expiries>1M,3M,6M,1Y,2Y,3Y,10Y</Expiries>
    <SmileDelta>10,25</SmileDelta>
    <FXSpotID>FX/USD/JPY</FXSpotID>
    <FXForeignCurveID>Yield/USD/USD1D</FXForeignCurveID>
    <FXDomesticCurveID>Yield/JPY/JPY-IN-USD</FXDomesticCurveID>
    <DayCounter>A365</DayCounter>
    <Calendar>US,JP</Calendar>
    <Conventions>USD-JPY-FXOPTION</Conventions>
    <ButterflyErrorTolerance>0.01</ButterflyErrorTolerance>
  </FXVolatility>
```

</div>

<div class="longlisting">

``` xml
  <FXVolatility>
    <CurveId>USDJPY</CurveId>
    <CurveDescription />
    <Dimension>Smile</Dimension>
    <SmileType>Absolute</SmileType>
    <SmileInterpolation>Cubic</SmileInterpolation>
    <Expiries>1M,3M,6M,1Y,2Y,3Y,10Y</Expiries>
    <FXSpotID>FX/USD/JPY</FXSpotID>
    <FXForeignCurveID>Yield/USD/USD1D</FXForeignCurveID>
    <FXDomesticCurveID>Yield/JPY/JPY-IN-USD</FXDomesticCurveID>
    <DayCounter>A365</DayCounter>
    <Calendar>US,JP</Calendar>
    <Conventions>USD-JPY-FXOPTION</Conventions>
  </FXVolatility>
```

</div>

<div class="longlisting">

``` xml
  <FXVolatility>
    <CurveId>EURJPY</CurveId>
    <CurveDescription />
    <Dimension>ATMTriangulated</Dimension>
    <FXSpotID>FX/EUR/JPY</FXSpotID>
    <DayCounter>A365</DayCounter>
    <Calendar>US,JP</Calendar>
    <BaseVolatility1>EURUSD</BaseVolatility1>
    <BaseVolatility2>USDJPY</BaseVolatility2>
  </FXVolatility>
```

</div>

The meaning of each of the elements in Listings
<a href="#lst:fxoptionvol_configuration_atm" data-reference-type="ref"
data-reference="lst:fxoptionvol_configuration_atm">[lst:fxoptionvol_configuration_atm]</a>,
<a href="#lst:fxoptionvol_configuration_smile_vv"
data-reference-type="ref"
data-reference="lst:fxoptionvol_configuration_smile_vv">[lst:fxoptionvol_configuration_smile_vv]</a>,
<a href="#lst:fxoptionvol_configuration_smile_delta"
data-reference-type="ref"
data-reference="lst:fxoptionvol_configuration_smile_delta">[lst:fxoptionvol_configuration_smile_delta]</a>,
<a href="#lst:fxoptionvol_configuration_smile_bfrr"
data-reference-type="ref"
data-reference="lst:fxoptionvol_configuration_smile_bfrr">[lst:fxoptionvol_configuration_smile_bfrr]</a>,
<a href="#lst:fxoptionvol_configuration_smile_absolute"
data-reference-type="ref"
data-reference="lst:fxoptionvol_configuration_smile_absolute">[lst:fxoptionvol_configuration_smile_absolute]</a>,
<a href="#lst:fxoptionvol_configuration_atm_triangulated"
data-reference-type="ref"
data-reference="lst:fxoptionvol_configuration_atm_triangulated">[lst:fxoptionvol_configuration_atm_triangulated]</a>
is given below.

- CurveId: Unique identifier of the FX volatility structure

- CurveDescription \[Optional\]: A description of the volatility
  structure, may be left blank.

- Dimension: Distinguishes at-the-money volatility curves from
  volatility surfaces. An ‘ATMTriangulated’ value denotes a curve
  triangulated from two other surfaces.  
  Allowable values: `ATM, Smile, ATMTriangulated`

- SmileType \[Optional\]: Required field in case of Dimension `Smile`,
  otherwise it can be omitted.  
  Allowable values: `VannaVolga` as per (Castagna & Mercurio - 2006),
  `Delta`, `BFRR`, `Absolute`, with default value ` VannaVolga` if left
  blank.

- SmileInterpolation \[Optional\]: Smile interpolation method applied,
  required field in case of Dimension ` Smile`, otherwise it can be
  omitted.  
  Allowable values:

  - `VannaVolga1` or `VannaVolga2` in case of SmileType `VannaVolga`
    with default VannaVolga2 if left blank. VannaVolga1/VannaVolga2
    refer to the first/second approximation in (eq. 13) and (eq. 14) of
    the reference above.

  - `Linear` or `Cubic` in case of SmileType `Delta` or `BFRR` with
    default `Linear` for SmileType Delta and `Cubic` for SmileType BFRR
    and Absolute if left blank

- TimeInterpolation \[Optional\]: specifies whether time interpolation
  is done in volatility (`V`, default) or variance (`V2T`)

- ButterflyErrorTolerance \[Optional\]: max allowed error for broker
  butterfly match, defaults to 0.01 relative rmse of broker butterfly
  market premiums vs theoretical premiums

- TimeWeighting \[Optional\]: if given, a time weighting scheme is
  applied for time interpolation, see the documentation of
  FxOptionTimeWeighting convention for more details

- Expiries: Option expiries in period form. A wildcard may also be used.
  In the wildcard case, it will look for any matching quotes provided in
  the loader, and construct the curve from these. This is currently only
  supported for ` ATM` or `Delta` or `BFRR` or `Absolute` curves.

- Deltas \[Optional\]: Strike grid, required in case of SmileType
  `Delta`  
  Allowable values: `ATM, *P, *C`, see example in Listing
  <a href="#lst:fxoptionvol_configuration_smile_delta"
  data-reference-type="ref"
  data-reference="lst:fxoptionvol_configuration_smile_delta">[lst:fxoptionvol_configuration_smile_delta]</a>

- SmileDelta \[Optional\]: Strike grid for SmileType `VannaVolga` and
  `BFRR`, defaults to 25 for VannaVolga resp. 10,25 for BFRR  
  Allowable values: a list of integers, see example in Listing
  <a href="#lst:fxoptionvol_configuration_smile_bfrr"
  data-reference-type="ref"
  data-reference="lst:fxoptionvol_configuration_smile_bfrr">[lst:fxoptionvol_configuration_smile_bfrr]</a>

- FXSpotID: ORE representation of the relevant FX spot quote in the form
  FX/CCY1/CCY2

- FXForeignCurveID \[Optional\]: Yield curve, in ORE format
  Yield/CCY/ID, used as foreign yield curve in smile curves, may be
  omitted for ATM curves.

- FXDomesticCurveID \[Optional\]: Yield curve, in ORE format
  Yield/CCY/ID, used as domestic yield curve in smile curves, may be
  omitted for ATM curves.

- DayCounter: The term structure’s day counter used in date to time
  conversions. Optional, defaults to A365.

- Calendar: The term structure’s calendar used in option tenor to date
  conversions. Optional, defaults to source ccy + target ccy default
  calendars.

- Conventions \[Optional\]: FX conventions object ID that is used to
  determine the at-the-money type and delta type of the volatility
  quotes, these default to `AtmDeltaNeutral` and `Spot` for option
  tenors \<= 2Y and ` AtmDeltaNeutral` and `Fwd` for option tenors \> 2Y
  if the conventions ID is omitted or left blank. Furthermore, the
  conventions hold information on the side of risk reversals
  (RiskReversalInFavorOf, defaults to `Call`) and the quote style of
  butterflies (ButterflyStyle, defaults to `Broker`), these latter two
  are relevant for BF, RR market data input. See
  <a href="#sss:fx_option_conv" data-reference-type="ref"
  data-reference="sss:fx_option_conv">[sss:fx_option_conv]</a> for more
  details.

- BaseVolatility1: For ‘ATMTriangulated’ this denotes one of the
  surfaces we want to triangulate from

- BaseVolatility2: For ‘ATMTriangulated’ this denotes one of the
  surfaces we want to triangulate from

- SmileExtrapolation \[Optional\]: Applicable only in case of SmileType
  Delta. Indicates the extrapolation in the smile direction. The
  allowable values are None, UseInterpolator (or Linear) and Flat. Both
  Flat and None give flat extrapolation. UseInterpolator indicates that
  the configured interpolation should be continued in the strike
  direction in order to extrapolate. Default if not provided value is
  Flat.

### Equity Curve Structures

Listing <a href="#lst:eqcurve_configuration" data-reference-type="ref"
data-reference="lst:eqcurve_configuration">[lst:eqcurve_configuration]</a>
shows the configuration of equity forward price curves.

<div class="longlisting">

``` xml
<EquityCurves>
  <EquityCurve>
    <CurveId>SP5</CurveId>
    <CurveDescription>SP 500 equity price projection curve</CurveDescription>
    <Currency>USD</Currency>
    <ForecastingCurve>EUR1D</ForecastingCurve>
    <!-- DividendYield, ForwardPrice, OptionPremium, NoDividends, ForwardDividendPrice -->
    <Type>DividendYield</Type>
    <!-- Optional node, only used when Type is OptionPremium -->
    <ExerciseStyle>American</ExerciseStyle>
    <!-- Spot quote from the market data file -->
    <SpotQuote>EQUITY/PRICE/SP5/USD</SpotQuote>
    <!-- Note: do not provide Quotes if Type is NoDividends -->
    <Quotes>
      <Quote>EQUITY_DIVIDEND/RATE/SP5/USD/3M</Quote>
      <Quote>EQUITY_DIVIDEND/RATE/SP5/USD/20160915</Quote>
      <Quote>EQUITY_DIVIDEND/RATE/SP5/USD/1Y</Quote>
      <Quote>EQUITY_DIVIDEND/RATE/SP5/USD/20170915</Quote>
    </Quotes>
    <!-- Optional interpolation options, default Zero and Linear -->
    <!-- Note: do not provide DividendInterpolation if Type is NoDividends -->
    <DividendInterpolation>
      <!-- Zero, Discount -->
      <InterpolationVariable>Zero</InterpolationVariable>
      <!-- See Table \ref{tab:allow_interp_methods} for allowed interpolation methods -->
      <InterpolationMethod>Linear</InterpolationMethod>
    </DividendInterpolation>
    <DividendExtrapolation>False</DividendExtrapolation>
    <!-- Optional node, defaults to false -->
    <Extrapolation>False</Extrapolation>
    <DayCounter>A365</DayCounter>
  </EquityCurve>
  <EquityCurve>
    ...
  </EquityCurve>
  </EquityCurves>
```

</div>

The meaning of each of the elements is given below.

- CurveId: Unique identifier of the equity curve structure.

- CurveDescription \[Optional\]: A description of the equity curve
  structure, may be left blank.

- Currency: Currency of the equity.

- Calendar \[Optional\]: The term structure’s calendar used in tenor to
  date conversions. Defaults to the calendar corresponding to
  `Currency`.

- ForecastingCurve: CurveId of the curve used for discounting equity
  fixing forecasts.

- Type: The quote types in `Quote` (e.g. option premium, forward equity
  price) and whether dividends are taken into account. Allowable values:
  `DividendYield, ForwardPrice, ForwardDividendPrice, OptionPremium, NoDividends`

- ExerciseStyle \[Optional\]: Exercise type of the underlying option
  quotes. Only required if `Type` is *OptionPremium*. Allowable values:
  `American, European`

- SpotQuote: Market datum ID/name of the current spot rate for the
  equity underlying.

- Quotes \[Optional\]: Market datum IDs/names to be used in building the
  curve structure.

- DayCounter \[Optional\]: The term structure’s day counter used in date
  to time conversions. Defaults to `A365F`.

- DividendInterpolation \[Optional\]: This node contains an
  `InterpolationVariable` and `InterpolationMethod` sub-node, which
  define the variable on which the interpolation is performed and the
  interpolation method for the dividend curve, respectively. The
  allowable values are found in Table
  <a href="#tab:allow_interp_variables" data-reference-type="ref"
  data-reference="tab:allow_interp_variables">1</a> and Table
  <a href="#tab:allow_interp_methods" data-reference-type="ref"
  data-reference="tab:allow_interp_methods">2</a>, respectively. This
  should not be provided if `Type` is `NoDividends`.

- DividendExtrapolation \[Optional\]: Boolean flag indicating whether
  extrapolation in the dividend curve is allowed. If True the dividend
  curve is extrapolated forward at the risk free rate beyond the last
  date of the curve - this is only considered when `Extrapolation` is
  False. Defaults to `False`.

- Extrapolation \[Optional\]: Boolean flag indicating whether
  extrapolation in the forward price is allowed. Defaults to `False`.

The equity curves here consists of a spot equity price, as well as a set
of either forward prices or else dividend yields. If the index is a
dividend futures index then curve type should be entered as
ForwardDividendPrice. In this case the curve will be built from forward
prices as normal, but excluded from the SIMM calculations as required by
the SIMM methodology. Upon construction, ORE stores internally an equity
spot price quote, a forecasting curve and a dividend yield term
structure, which are then used together for projection of forward
prices.

### Equity Volatility Structures

When configuring volatility structures for equities, there are four
options:

1.  a constant volatility for all expiries and strikes.

2.  a volatility curve with a dependency on expiry but no strike
    dimension.

3.  a volatility surface with an expiry and strike dimension.

4.  a proxy surface - point to another surface as a proxy.

There are a number of fields common to all configurations:

- CurveId: Unique identifier for the curve.

- CurveDescription \[Optional\]: A description of the curve. This field
  may be left blank.

- EquityId: \[Optional\] Identifies the underlying equity name, this is
  used in the construction of the `Quote` strings. If omitted the
  `CurveId` is used instead.

- Currency: Currency of the equity.

- Calendar \[Optional\]: allowable value is any valid calendar. Defaults
  to `NullCalendar`.

- DayCounter \[Optional\]: allowable value is any valid day counter.
  Defaults to `A365`.

- OneDimSolverConfig \[Optional\]: A configuration for the one
  dimensional solver used in deriving volatilities from prices. This
  node is described in detail in Section
  <a href="#sec:one_dim_solver_config" data-reference-type="ref"
  data-reference="sec:one_dim_solver_config">0.1.22</a>. If not
  provided, a default step based configuration is used. This is only
  used when volatilities are stripped from prices.

- PreferOutOfTheMoney \[Optional\]: allowable value is any boolean
  value. Defaults to `false` for backwards compatibility. It is used,
  when building the volatility surface, to choose between a call and put
  option price or volatility when both are provided. When set to `true`,
  the out of the money option is chosen by comparing the quote’s strike
  with the forward price at the associated expiry. Conversely, when set
  to `false`, the in the money option is chosen.

Listing <a href="#lst:eqoptionvol_constant" data-reference-type="ref"
data-reference="lst:eqoptionvol_constant">[lst:eqoptionvol_constant]</a>
shows the configuration of equity volatility structures with constant
volatility. A node `Constant` takes one `Quote`, as described in Section
<a href="#md:equity_option_iv" data-reference-type="ref"
data-reference="md:equity_option_iv">[md:equity_option_iv]</a>, which is
held constant for all strikes and expiries.

<div class="longlisting">

``` xml
<EquityVolatilities>
  <EquityVolatility>
    <CurveId>SP5</CurveId>
    <CurveDescription>Lognormal option implied vols for SP 500</CurveDescription>
    <EquityId>RIC:.SP5</EquityId>
    <Currency>USD</Currency>
    <DayCounter>Actual/365 (Fixed)</DayCounter>
    <Constant>
      <Quote>EQUITY_OPTION/RATE_LNVOL/RIC:.SP5/USD/5Y/ATMF</Quote>
    </Constant>
  </EquityVolatility>
  <EquityVolatility>
    ...
  </EquityVolatility>
</EquityVolatilities>
```

</div>

Secondly, the volatility curve configuration layout is given in Listing
<a href="#lst:eqoptionvol_curve" data-reference-type="ref"
data-reference="lst:eqoptionvol_curve">[lst:eqoptionvol_curve]</a>. With
this curve construction the volatility is held constant in the strike
direction, and quotes of varying expiry can be provided, for examlple if
only ATM volatility quotes are available. The volatility quote IDs in
the `Quotes` node should be Equity option volatility quotes as described
in Section <a href="#md:equity_option_iv" data-reference-type="ref"
data-reference="md:equity_option_iv">[md:equity_option_iv]</a>. An
explicit list of quotes can be provided, or a single quote with a
wildcard replacing the expiry/strike. In the wildcard case, it will look
for any matching quotes provided in the loader, and construct the curve
from these. The `Interpolation` node supports `Linear`, `Cubic` and
`LogLinear` interpolation. The `Extrapolation` node supports either
`None` for no extrapolation or `Flat` for flat extrapolation in the
volatility.

<div class="longlisting">

``` xml
<EquityVolatilities>
  <EquityVolatility>
    <CurveId>SP5</CurveId>
    <CurveDescription>Lognormal option implied vols for SP 500</CurveDescription>
    <EquityId>RIC:.SP5</EquityId>
    <Currency>USD</Currency>
    <DayCounter>Actual/365 (Fixed)</DayCounter>
    <Curve>
      <QuoteType>ImpliedVolatility</QuoteType>
      <VolatilityType>Lognormal</VolatilityType>
      <Quotes>
        <Quote>EQUITY_OPTION/RATE_LNVOL/RIC:.SP5/USD/*</Quote>
      </Quotes>
      <Interpolation>LinearFlat</Interpolation>
      <Extrapolation>Flat</Extrapolation>
    </Curve>
  </EquityVolatility>
  <EquityVolatility>
    ...
  </EquityVolatility>
</EquityVolatilities>
```

</div>

The volatility strike surface configuration layout is given in Listing
<a href="#lst:eqoptionvol_surface" data-reference-type="ref"
data-reference="lst:eqoptionvol_surface">[lst:eqoptionvol_surface]</a>.
This allows a full surface of `Strikes` and `Expiries` to be defined.
The following are the valid nodes:

- `QuoteType`: either `ImpliedVolatility` of `Premium`, indicating the
  type of quotes provided in the market.

- `ExerciseType` \[Optional\]: only valid when `QuoteType` is `Premium`.
  Valid types are `European` and `American`.

- `VolatilityType` \[Optional\]: only valid when `QuoteType` is
  `ImpliedVolatility`. Valid types are `Lognormal`, `ShiftedLognormal`
  and `Normal`.

- `Strikes`: comma separated list of strikes, representing the absolute
  strike values for the option. In other words, A single wildcard
  character, `*`, can be used here also to indicate that all strikes
  found in the market data for this equity volatility configuration
  should be used when building the equity volatility surface.

- `Expiries`: comma separated list of expiry tenors and or expiry dates.
  A single wildcard character, `*`, can be used here also to indicate
  that all expiries found in the market data for this equity volatility
  configuration should be used when building the equity volatility
  surface.

- `TimeInterpolation`: interpolation in the option expiry direction. If
  either `Strikes` or `Expiries` are configured with a wildcard
  character, `Linear` is used. If both `Strikes` and `Expiries` are
  configured explicitly, `Linear` or `Cubic` is allowed here but the
  value must agree with the value for `StrikeInterpolation`.

- `StrikeInterpolation`: interpolation in the strike direction. If
  either `Strikes` or `Expiries` are configured with a wildcard
  character, `Linear` is used. If both `Strikes` and `Expiries` are
  configured explicitly, `Linear` or `Cubic` is allowed here but the
  value must agree with the value for `TimeInterpolation`.

- `Extrapolation`: boolean value. If `true`, extrapolation is allowed.
  If `false`, extrapolation is not allowed.

- `TimeExtrapolation`: extrapolation in the option expiry direction. If
  both `Strikes` and `Expiries` are configured explicitly, the
  extrapolation in the time direction is flat in volatility regardless
  of the setting here. If either `Strikes` or `Expiries` are configured
  with a wildcard character, `Linear`, `UseInterpolator`, `Flat` or
  `None` are allowed. If `Linear` or `UseInterpolator` is specified, the
  extrapolation is linear. If `Flat` is specified, the extrapolation is
  flat. If `None` is specified, it is ignored and the extrapolation is
  flat since extrapolation in the time direction cannot be turned off in
  isolation i.e. extrapolation can only be turned off for the surface as
  a whole using the `Extrapolation` flag.

- `StrikeExtrapolation`: extrapolation in the strike direction. The
  allowable values are `Linear`, `UseInterpolator`, `Flat` or `None`. If
  `Linear` or `UseInterpolator` is specified, the extrapolation uses the
  strike interpolation setting for extrapolation i.e. linear or cubic in
  this case. If `Flat` is specified, the extrapolation is flat. If
  `None` is specified, it is ignored and the extrapolation is flat since
  extrapolation in the strike direction cannot be turned off in
  isolation i.e. extrapolation can only be turned off for the surface as
  a whole using the `Extrapolation` flag.

When this configuration is used, the market is searched for quote
strings of the form
`EQUITY_OPTION/PRICE/[NAME]/[CURRENCY]/[EXPIRY]/[STRIKE]` or
`EQUITY_OPTION/RATE_LNVOL/[NAME]/[CURRENCY]/[EXPIRY]/[STRIKE]`,
depending on the `QuoteType`. When both the `Strikes` and `Expiries` are
configured explicitly, it is clear that the `[EXPIRY]` field is
populated from the list of expiries in turn and the `[STRIKE]` field is
populated from the list of strikes in turn. If there are $m$ expiries in
the `Expiries` list and $n$ strikes in the `Strikes` list, there will be
$m \times n$ quotes created and searched for in the market data. If
`Expiries` are configured via the wildcard character, `*`, all quotes in
the market data matching the pattern
`EQUITY_OPTION/RATE_LNVOL/[NAME]/[CURRENCY]/*/[STRIKE]`. Similarly for
`Strikes` configured via the wildcard character, `*`.

<div class="longlisting">

``` xml
<EquityVolatilities>
  <EquityVolatility>
    <CurveId>SP5</CurveId>
    <CurveDescription>Lognormal option implied vols for SP 500</CurveDescription>
    <EquityId>RIC:.SP5</EquityId>
    <Currency>USD</Currency>
    <DayCounter>Actual/365 (Fixed)</DayCounter>
    <StrikeSurface>
      <QuoteType>Premium</QuoteType>
      <ExerciseType>European</ExerciseType>
      <Strikes>*</Strikes>
      <Expiries>*</Expiries>
      <TimeInterpolation>Linear</TimeInterpolation>
      <StrikeInterpolation>Linear</StrikeInterpolation>
      <Extrapolation>true</Extrapolation>
      <TimeExtrapolation>UseInterpolator</TimeExtrapolation>
      <StrikeExtrapolation>Flat</StrikeExtrapolation>
    </StrikeSurface>
  </EquityVolatility>
  <EquityVolatility>
    ...
  </EquityVolatility>
</EquityVolatilities>
```

</div>

A volatility surface can also be given in terms of moneyness levels as
shown in listing
<a href="#lst:eqoptionvol_mny_surface" data-reference-type="ref"
data-reference="lst:eqoptionvol_mny_surface">[lst:eqoptionvol_mny_surface]</a>.
The nodes have the same meaning as in the case of a strike surface with
the following exceptions:

- `QuoteType`: only `ImpliedVolatility` is allowed

- `VolatilityType` \[Optional\]: only `Lognormal` is allowed

- `MoneynessType`: `Spot` or `Fwd`, indicating the type of moneyness.
  See <a href="#md:equity_option_iv" data-reference-type="ref"
  data-reference="md:equity_option_iv">[md:equity_option_iv]</a> for the
  definition of moneyness types.

- `MoneynessLevels`: comma separated list of moneyness levels, no wild
  cards are allowed.

- `Expiries`: comma separated list of expiry tenors and or expiry dates.
  A single wildcard character, `*`, can be used here also to indicate
  that all expiries found in the market data for this equity volatility
  configuration should be used when building the equity volatility
  surface.

Notice that the market data for the moneyness level $1.0$ must be given
as a moneyness quote, not an ATM or ATMF quote, see
<a href="#md:equity_option_iv" data-reference-type="ref"
data-reference="md:equity_option_iv">[md:equity_option_iv]</a> for
details of the market data.

<div class="longlisting">

``` xml
<EquityVolatilities>
  <EquityVolatility>
    <CurveId>SP5</CurveId>
    <CurveDescription>Lognormal option implied vols for SP 500</CurveDescription>
    <EquityId>RIC:.SP5</EquityId>
    <Currency>USD</Currency>
    <DayCounter>Actual/365 (Fixed)</DayCounter>
    <MoneynessSurface>
      <QuoteType>ImpliedVolatility</QuoteType>
      <VolatilityType>Lognormal</VolatilityType>
      <MoneynessType>Fwd</MoneynessType>
      <MoneynessLevels>0.5,0.6,0.7,0.8,0.9,1.0,1.1,1.2,1.3,1.4,1.5</MoneynessLevels>
      <Expiries>*</Expiries>
      <TimeInterpolation>Linear</TimeInterpolation>
      <StrikeInterpolation>Linear</StrikeInterpolation>
      <Extrapolation>true</Extrapolation>
      <TimeExtrapolation>UseInterpolator</TimeExtrapolation>
      <StrikeExtrapolation>Flat</StrikeExtrapolation>
    </MoneynessSurface>
  </EquityVolatility>
  <EquityVolatility>
    ...
  </EquityVolatility>
</EquityVolatilities>
```

</div>

Finally, the volatility proxy surface configuration layout is given in
Listing <a href="#lst:eqoptionvol_proxy" data-reference-type="ref"
data-reference="lst:eqoptionvol_proxy">[lst:eqoptionvol_proxy]</a>. This
allows us to use any other surface as a proxy, in cases where there is
no option data for a given equity. We provide a name in the
`EquityVolatilityCurve` field, which must match the `CurveId` of another
configuration. `FXVolatilityCurve` and `CorrelationCurve` must be
provided if the currency of the proxy surface is different to that of
current surface, that can be omitted otherwise. The proxy surface looks
up the volatility in the reference surface based on moneyness.

<div class="longlisting">

``` xml
<EquityVolatilities>
  <EquityVolatility>
    <CurveId>ABC</CurveId>
    <CurveDescription>Lognormal option implied vols for APC - proxied from SP5</CurveDescription>
    <EquityId>RIC:.SP5</EquityId>
    <Currency>USD</Currency>
    <DayCounter>Actual/365 (Fixed)</DayCounter>
    <ProxySurface>
      <EquityVolatilityCurve>RIC:.SPX</EquityVolatilityCurve>
      <FXVolatilityCurve>GBPUSD</FXVolatilityCurve>
      <CorrelationCurve>FX-GENERIC-GBP-USD&amp;EQ-RIC:VOD.L</CorrelationCurve>
    </ProxySurface>
  </EquityVolatility>
  <EquityVolatility>
    ...
  </EquityVolatility>
</EquityVolatilities>
```

</div>

### Inflation Curves

Listing
<a href="#lst:inflationcurve_configuration" data-reference-type="ref"
data-reference="lst:inflationcurve_configuration">[lst:inflationcurve_configuration]</a>
shows the configuration of an inflation curve. The inflation curve
specific elements are the following:

<div class="longlisting">

``` xml
<InflationCurves>
    <InflationCurve>
        <CurveId>USCPI_ZC_Swaps</CurveId>
        <CurveDescription>Estimation Curve for USCPI</CurveDescription>
        <NominalTermStructure>Yield/USD/USD1D</NominalTermStructure>
        <Type>ZC</Type>
        <Segments>
            <Segment>
                <Conventions>USCPI_INFLATIONSWAP_2M</Conventions>
                <Quotes>
                    <Quote>ZC_INFLATIONSWAP/RATE/USCPI/3M</Quote>
                    <Quote>ZC_INFLATIONSWAP/RATE/USCPI/4M</Quote>
                    <!-- ...more quotes... -->
                    <Quote>ZC_INFLATIONSWAP/RATE/USCPI/24M</Quote>
                </Quotes>
            </Segment>
            <Segment>
                <Conventions>USCPI_INFLATIONSWAP</Conventions>
                <Quotes>
                    <Quote>ZC_INFLATIONSWAP/RATE/USCPI/3Y</Quote>
                    <Quote>ZC_INFLATIONSWAP/RATE/USCPI/4Y</Quote>
                    <!-- ...more quotes... -->
                    <Quote>ZC_INFLATIONSWAP/RATE/USCPI/30Y</Quote>
                </Quotes>
            </Segment>
        </Segments>
        <Extrapolation>true</Extrapolation>
        <Calendar>US</Calendar>
        <DayCounter>A365</DayCounter>
        <Lag>3M</Lag>
        <Frequency>Monthly</Frequency>
        <BaseRate/>
        <Tolerance>0.000000000001</Tolerance>
        <InterpolationVariable>ZeroRate</InterpolationVariable>
        <InterpolationMethod>Linear</InterpolationMethod>
        <UseLastFixingDate>false</UseLastFixingDate>
        <Seasonality>
            <BaseDate>20160101</BaseDate>
            <Frequency>Monthly</Frequency>
            <Factors>
                <Factor>SEASONALITY/RATE/MULT/USCPI/JAN</Factor>
                <Factor>SEASONALITY/RATE/MULT/USCPI/FEB</Factor>
                <!-- ...more quotes... -->
                <Factor>SEASONALITY/RATE/MULT/USCPI/DEC</Factor>
            </Factors>
        </Seasonality>
    </InflationCurve>
</InflationCurves>
```

</div>

#### Legacy Schema

The legacy schema (still supported) uses a single block for quotes and
conventions:

``` xml
<InflationCurve>
    <CurveId>USCPI_ZC_Swaps</CurveId>
    <CurveDescription>Estimation Curve for USCPI</CurveDescription>
    <NominalTermStructure>Yield/USD/USD1D</NominalTermStructure>
    <Type>ZC</Type>
    <Quotes>
        <Quote>ZC_INFLATIONSWAP/RATE/USCPI/1Y</Quote>
        <!-- ...more quotes... -->
        <Quote>ZC_INFLATIONSWAP/RATE/USCPI/40Y</Quote>
    </Quotes>
    <Conventions>USCPI_INFLATIONSWAP</Conventions>
    <!-- ... -->
</InflationCurve>
```

- `NominalTermStructure`: The interest rate curve to be used to strip
  the inflation curve.

- `Type`: The type of the curve, `ZC` for zero coupon, `YY` for year on
  year.

- `Segments`: Allows multiple instrument/convention blocks.

- `Quotes`: Legacy (use instead segments). The instruments’ market
  quotes from which to bootstrap the curve.

- `Conventions`: Legacy (use instead segments). The conventions
  applicable to the curve instruments.

- `Lag`: The observation lag used in the term structure.

- `Frequency`: The frequency of index fixings.

- `BaseRate`: The rate at $t=0$, this introduces an additional degree of
  freedom to get a smoother curve. If not given, it is defaulted to the
  first market rate.

- `InterpolationVariable`: Optional, the variable on which the
  interpolation of the zero inflation curve is performed. The allowable
  values *ZeroRate* and *PriceIndex*. If not provided, the default value
  is *ZeroRate*. Ignored for year on year inflation curves.

- `InterpolationMethod`: Only relevant if InterpolationVariable is
  PriceIndex, allowed is *Linear* and *LogLinear*. Defaults to *Linear*.

The segment block defines instruments to use for curve building, with
their quotes and swap conventions.

#### Segment Schema

- `Conventions`: The conventions applicable to the segment’s
  instruments.

- `Quotes`: The instruments’ market quotes for the segment.

The optional seasonality block defines a multiplicative seasonality and
contains the following elements:

- `BaseDate`: Defines the first inflation period to which to apply the
  seasonality correction, only day and month matters, the year is
  ignored.

- `Frequency:` Defines the frequency of the factors (usually identical
  to the index’s fixing frequency).

- `Factors:` Multiplicative seasonality correction factors, must be part
  of the market data.

- `OverrideFactors:` A numeric list of seasonality correction factors,
  replacing the Factors. This allows to specify a static seasonality
  correction that does not require market data quotes. If both Factors
  and OverrideFactors are given, the OverrideFactors are used. Otherwise
  only one of Factors, OverrideFactors is required in a seasonality
  block.

#### Notes

- All swaps used in segments must reference the same inflation index
  name for curve building, but can differ in their swap conventions
  (e.g., lag, interpolation).

- If zero coupon swap market quotes are given, but the type is set to
  YY, the zero coupon swap quotes will be converted to year on year swap
  quotes on the fly, using the plain forward rates, i.e. no convexity
  adjustment is applied.

### Inflation Cap/Floor Volatility Surfaces

Listing <a href="#lst:inflationcapfloorvolsurface_configuration"
data-reference-type="ref"
data-reference="lst:inflationcapfloorvolsurface_configuration">[lst:inflationcapfloorvolsurface_configuration]</a>
shows the configuration of an zero coupon inflation cap floor price
surface.

<div class="longlisting">

``` xml
      <InflationCapFloorVolatility>
          <CurveId>EUHICPXT_ZC_CF</CurveId>
          <CurveDescription>
              EUHICPXT CPI Cap/Floor vol surface derived from price quotes
          </CurveDescription>
          <Type>ZC</Type>
          <QuoteType>Price</QuoteType>
          <VolatilityType>Normal</VolatilityType>
          <Extrapolation>Y</Extrapolation>
          <DayCounter>ACT</DayCounter>
          <Calendar>TARGET</Calendar>
          <BusinessDayConvention>MF</BusinessDayConvention>
          <Tenors>1Y,2Y,3Y,4Y,5Y,6Y,7Y,8Y,9Y,10Y,12Y,15Y,20Y,30Y</Tenors>
          <!-- QuoteType 'Volatility' requires <Strikes>: -->
          <!-- <Strikes>-0.02,-0.01,-0.005,0.00,0.01,0.015,0.02,0.025,0.03</Strikes> -->
          <!-- QuoteType 'Price' requires <CapStrikes> and/or <FloorStrikes>: -->
          <CapStrikes/>
          <FloorStrikes>-0.02,-0.01,-0.005,0.00,0.01,0.015,0.02,0.025,0.03</FloorStrikes>
          <Index>EUHICPXT</Index>
          <IndexCurve>Inflation/EUHICPXT/EUHICPXT_ZC_Swaps</IndexCurve>
          <IndexInterpolated>false</IndexInterpolated>
          <ObservationLag>3M</ObservationLag>
          <YieldTermStructure>Yield/EUR/EUR1D</YieldTermStructure>
          <QuoteIndex>...</QuoteIndex>
      </InflationCapFloorVolatility>
```

</div>

- `Type`: The type of the surface, `ZC` for zero coupon, `YY` for year
  on year.

- `QuoteType`: The type of the quotes used to build the surface,
  `Volatility` for volatility quotes, `Price` for bootstrap from option
  premia.

- `VolatilityType`: If QuoteType is `Volatility`, this specifies whether
  the input is `Normal`, `Lognormal` or `ShiftedLognormal`.

- `Extrapolation`: Boolean to indicate whether the surface should allow
  extrapolation.

- `DayCounter`: The term structure’s day counter

- `Calendar`: The term structure’s calendar

- `BusinessDayConvention`: The term structure’s business day convention

- `Tenors:` The maturities for which cap and floor prices are quoted

- `Strikes`: In the case of QuoteType `Volatility`, the strikes for
  which floor prices are quoted (may, and will usually, overlap with the
  cap strike region); neither CapStrikes nor FloorStrikes are expected
  in this case.

- `CapStrikes`: The strikes for which cap prices are quoted (may, and
  will usually, overlap with the floor strike region); if the QuoteType
  above is `Price`, either CapStrikes or FloorStrikes or both are
  required.

- `FloorStrikes`: The strikes for which floor prices are quoted (may and
  will usually) overlap with the cap strike region); if the QuoteType
  above is `Price`, either CapStrikes or FloorStrikes or both are
  required.

- `Index`: The underlying zero inflation index.

- `IndexCurve`: The curve id of the index’s projection curve used to
  determine the ATM levels for the surface.

- `IndexInterpolated`: Flag indicating whether the index should be
  interpolating.

- `Observation Lag`: The observation lag applicable to the term
  structure.

- `YieldTermStructure`: The nominal term structure.

- `QuoteIndex`: An optional node allowing the user to provide an
  alternative index name for forming the quotes that will be used in
  building the cap floor surface. If this node is not provided, the
  `Index` node value is used in quote construction. For example, quotes
  must be created from each strike and each tenor and these quotes are
  subsequently looked up in the market data when building the cap floor
  volatility surface. The quotes are formed by concatenating
  `[Type]_INFLATIONCAPFLOOR`, `PRICE` or `RATE_[Vol_Type]VOL`,
  `[Index_Name]`, `[Tenor]`, `C` or `F` and `[Strike]` delimited by `/`.
  If `QuoteIndex` is provided, it is used as the `[Index_Name]` token.
  If it is not provided `Index` is used as usual.

### CDS Volatilities

When configuring volatility structures for CDS and index CDS options,
there are three options:

1.  a constant volatility for all expiries, strikes and terms.

2.  a volatility curve with a dependency on expiry and term, but no
    strike dimension.

3.  a volatility surface with an expiry, term and strike dimension.

Firstly, the constant volatility configuration layout is given in
Listing <a href="#lst:cdsvol_constant_config" data-reference-type="ref"
data-reference="lst:cdsvol_constant_config">[lst:cdsvol_constant_config]</a>.
The single volatility quote ID, `constant_quote_id`, in the `Quote` node
should be a CDS option volatility quote as described in Section
<a href="#md:cds_option_iv" data-reference-type="ref"
data-reference="md:cds_option_iv">[md:cds_option_iv]</a>. The
`DayCounter` node is optional and defaults to `A365F`. The `Calendar`
node is optional and defaults to `NullCalendar`. The `DayCounter` and
`Calendar` nodes are common to all three CDS volatility configurations.

<div class="longlisting">

``` xml
<CDSVolatility>
  <CurveId>..<CurveId>
  <CurveDescription>...</CurveDescription>
  <Constant>
    <Quote>constant_quote_id</Quote>
  </Constant>
  <DayCounter>...</DayCounter>
  <Calendar>...</Calendar>
</CDSVolatility>
```

</div>

Secondly, the volatility curve configuration layout is given in Listing
<a href="#lst:cdsvol_curve_config" data-reference-type="ref"
data-reference="lst:cdsvol_curve_config">[lst:cdsvol_curve_config]</a>.
The volatility quote IDs, `quote_id_1`, `quote_id_2`, etc., in the
`Quotes` node should be CDS option volatility quotes as described in
Section <a href="#md:cds_option_iv" data-reference-type="ref"
data-reference="md:cds_option_iv">[md:cds_option_iv]</a>. The
`Interpolation` node supports `Linear`, `Cubic` and `LogLinear`
interpolation. The `Extrapolation` node supports either `None` for no
extrapolation or `Flat` for flat extrapolation in the volatility.

The optional boolean parameter `EnforceMontoneVariance` should be set to
`true` to raise an exception if the curve implied variance is not
montone increasing with time and should be set to `false` if you want to
suppress such an exception. The default value for
`EnforceMontoneVariance` is `true`.

<div class="longlisting">

``` xml
<CDSVolatility>
  <CurveId>..<CurveId>
  <CurveDescription>...</CurveDescription>
  <Terms>
    <Term>
      <Label>...</Label>
      <Curve>...</Curve>
    </Term>
  </Terms>
  <Curve>
    <Quotes>
      <Quote>quote_id_1</Quote>
      <Quote>quote_id_2</Quote>
      ...
    </Quotes>
    <Interpolation>...</Interpolation>
    <Extrapolation>...</Extrapolation>
    <EnforceMontoneVariance></EnforceMontoneVariance>
  </Curve>
  <DayCounter>...</DayCounter>
  <Calendar>...</Calendar>
</CDSVolatility>
```

</div>

For backwards compatibility, the volatility curve configuration can also
be given using a single `Expiries` node as shown in Listing
<a href="#lst:cdsvol_curve_config_alt" data-reference-type="ref"
data-reference="lst:cdsvol_curve_config_alt">[lst:cdsvol_curve_config_alt]</a>.
Note that this configuration is deprecated and the configuration in
<a href="#lst:cdsvol_curve_config" data-reference-type="ref"
data-reference="lst:cdsvol_curve_config">[lst:cdsvol_curve_config]</a>
is preferred. The `Expiries` node should take a comma separated list of
tenors and or expiry dates e.g. `<Expiries>1M,3M,6M</Expiries>`. The
list of expiries are extracted and a set of quotes are created of the
form `INDEX_CDS_OPTION/RATE_LNVOL/[NAME]/[EXPIRY]` or
`INDEX_CDS_OPTION/RATE_LNVOL/[NAME]/[TERM]/[EXPIRY]`. There is one quote
for each expiry in the list where the `[EXPIRY]` field is understood to
be replaced with the expiry string extracted from the list.

The `[NAME]` field is populated with the curve id or with the
`[QuoteName]` if that is specified. The rules for including market
quotes into the volatility surface construction are as follows:

- All quotes explicitly specified with their full name are loaded
  (applies to configs of type constant or curve without wildcards)

- If a quote does not contain a term, we only load it if at most one
  term is specified in the vol curve config. The quote gets the unique
  term specified in the vol curve configs assigned or 5Y if the config
  does not specify any terms.

- If a quote contains a term if this matches one of the configured terms
  in the curve configuration or if the curve configuration does not
  specify any terms.

The `[Terms]` node specifies a list of term labels “5Y”, “7Y”, ... and
associated credit curve spec names representing the curve suitable to
estimate the ATM level for that term.

If only one expiry is provided in the list, there is only one quote and
a constant volatility structure is configured as in Listing
<a href="#lst:cdsvol_constant_config" data-reference-type="ref"
data-reference="lst:cdsvol_constant_config">[lst:cdsvol_constant_config]</a>.
If more than one expiry is provided, a curve is configured as in
<a href="#lst:cdsvol_curve_config" data-reference-type="ref"
data-reference="lst:cdsvol_curve_config">[lst:cdsvol_curve_config]</a>.
The interpolation is `Linear`, the extrapolation is `Flat` and
`EnforceMontoneVariance` is `true`.

<div class="longlisting">

``` xml
<CDSVolatility>
  <CurveId>..<CurveId>
  <CurveDescription>...</CurveDescription>
  <Terms>
    <Term>
      <Label>...</Label>
      <Curve>...</Curve>
    </Term>
  </Terms>
  <Expiries>...</Expiries>
  <DayCounter>...</DayCounter>
  <Calendar>...</Calendar>
  <QuoteName>...</QuoteName>
</CDSVolatility>
```

</div>

Thirdly, the volatility surface configuration layout is given in Listing
<a href="#lst:cdsvol_surface_config" data-reference-type="ref"
data-reference="lst:cdsvol_surface_config">[lst:cdsvol_surface_config]</a>.
The nodes have the following meanings and supported values:

- `Strikes`: comma separated list of strikes. The strikes may be in
  terms of spread or price. However, it is important to ensure that the
  trade XML for a CDS option or index CDS option provides the strike in
  the same way. In other words, if the strike is in terms of spread on
  the trade XML, the strike must be in terms of spread in the CDS
  volatility configuration here. Similarly for strikes in terms of
  price. A single wildcard character, `*`, can be used here also to
  indicate that all strikes found in the market data for this CDS
  volatility configuration should be used when building the CDS
  volatility surface.

- `Expiries`: comma separated list of expiry tenors and or expiry dates.
  A single wildcard character, `*`, can be used here also to indicate
  that all expiries found in the market data for this CDS volatility
  configuration should be used when building the CDS volatility surface.

- `TimeInterpolation`: interpolation in the option expiry direction. If
  either `Strikes` or `Expiries` are configured with a wildcard
  character, `Linear` is used. If both `Strikes` and `Expiries` are
  configured explicitly, `Linear` or `Cubic` is allowed here but the
  value must agree with the value for `StrikeInterpolation`.

- `StrikeInterpolation`: interpolation in the strike direction. If
  either `Strikes` or `Expiries` are configured with a wildcard
  character, `Linear` is used. If both `Strikes` and `Expiries` are
  configured explicitly, `Linear` or `Cubic` is allowed here but the
  value must agree with the value for `TimeInterpolation`.

- `Extrapolation`: boolean value. If `true`, extrapolation is allowed.
  If `false`, extrapolation is not allowed.

- `TimeExtrapolation`: extrapolation in the option expiry direction. If
  both `Strikes` and `Expiries` are configured explicitly, the
  extrapolation in the time direction is flat in volatility regardless
  of the setting here. If either `Strikes` or `Expiries` are configured
  with a wildcard character, `Linear`, `UseInterpolator`, `Flat` or
  `None` are allowed. If `Linear` or `UseInterpolator` is specified, the
  extrapolation is linear. If `Flat` is specified, the extrapolation is
  flat. If `None` is specified, it is ignored and the extrapolation is
  flat since extrapolation in the time direction cannot be turned off in
  isolation i.e. extrapolation can only be turned off for the surface as
  a whole using the `Extrapolation` flag.

- `StrikeExtrapolation`: extrapolation in the strike direction. The
  allowable values are `Linear`, `UseInterpolator`, `Flat` or `None`. If
  `Linear` or `UseInterpolator` is specified, the extrapolation uses the
  strike interpolation setting for extrapolation i.e. linear or cubic in
  this case. If `Flat` is specified, the extrapolation is flat. If
  `None` is specified, it is ignored and the extrapolation is flat since
  extrapolation in the strike direction cannot be turned off in
  isolation i.e. extrapolation can only be turned off for the surface as
  a whole using the `Extrapolation` flag.

- `DayCounter`: allowable value is any valid day count fraction. As
  stated above, this node is optional and defaults to `A365F`.

- `Calendar`: allowable value is any valid calendar. As stated above,
  this node is optional and defaults to `NullCalendar`.

- `StrikeType`: allowable value is either `Price` or `Spread`. This flag
  denotes if the strikes are in terms of spread or price. Currently,
  this is merely informational and as outlined in the `Strikes` section
  above, it is the responsibility of the user to ensure that the strike
  type in trades aligns with the configured strike type in the CDS
  volatility surfaces.

- `QuoteName`: this node is optional and the allowable value is any
  string. This value can be used in determining the name and term that
  appears in the quote strings that are searched for in the market data
  to feed into the CDS volatility surface construction. How it is used
  has been outlined above when describing the deprecated CDS volatility
  curve configuration.

- `StrikeFactor`: this node is optional and the allowable value is any
  positive real number. It defaults to 1. The strikes configured and
  found in the market data quote strings may not be in absolute terms.
  For example, a quote string such as
  `INDEX_CDS_OPTION/RATE_LNVOL/CDXIGS33V1/5Y/1M/115` could be given to
  indicate an index CDS option volatility quote for CDX IG Series 33
  Version 1, with underlying index term 5Y expiring in 1M with a strike
  spread of 115 bps. The strike here is in bps and needs to be divided
  by 10,000 before being used in the ORE volatility objects. The
  `StrikeFactor` would be set to `10000` here.

When the CDS volatility surface is configured as in Listing
<a href="#lst:cdsvol_surface_config" data-reference-type="ref"
data-reference="lst:cdsvol_surface_config">[lst:cdsvol_surface_config]</a>,
the market is searched for quote strings of the form
`INDEX_CDS_OPTION/RATE_LNVOL/[NAME]/[EXPIRY]/[STRIKE]` or
`INDEX_CDS_OPTION/RATE_LNVOL/[NAME]/[TERM]/[EXPIRY]/[STRIKE]`. The
population of the `[NAME]` field, and possibly the `[TERM]` field, and
how they depend on the `QuoteName` and `ParseTerm` nodes has been
discussed at length above when describing the deprecated CDS volatility
curve configuration. When both the `Strikes` and `Expiries` are
configured explicitly, it is clear that the `[EXPIRY]` field is
populated from the list of expiries in turn and the `[STRIKE]` field is
populated from the list of strikes in turn. If there are $m$ expiries in
the `Expiries` list and $n$ strikes in the `Strikes` list, there will be
$m \times n$ quotes created and searched for in the market data. If
`Expiries` are configured via the wildcard character, `*`, all quotes in
the market data matching the pattern
`INDEX_CDS_OPTION/RATE_LNVOL/[NAME]/*/[STRIKE]` will be used if `[TERM]`
has not been populated and all quotes in the market data matching the
pattern `INDEX_CDS_OPTION/RATE_LNVOL/[NAME]/[TERM]/*/[STRIKE]` will be
used if `[TERM]` has been populated. Similarly for `Strikes` configured
via the wildcard character, `*`.

<div class="longlisting">

``` xml
<CDSVolatility>
  <CurveId/>
  <CurveDescription/>
  <Terms>
    <Term>
      <Label>...</Label>
      <Curve>...</Curve>
    </Term>
  </Terms>
  <StrikeSurface>
    <Strikes>...</Strikes>
    <Expiries>...</Expiries>
    <TimeInterpolation>...</TimeInterpolation>
    <StrikeInterpolation>...</StrikeInterpolation>
    <Extrapolation>...</Extrapolation>
    <TimeExtrapolation>...</TimeExtrapolation>
    <StrikeExtrapolation>...</StrikeExtrapolation>
  </StrikeSurface>
  <DayCounter>...</DayCounter>
  <Calendar>...</Calendar>
  <StrikeType>...</StrikeType>
  <QuoteName>...</QuoteName>
  <StrikeFactor>..</StrikeFactor>
  <ParseTerm>...</ParseTerm>
</CDSVolatility>
```

</div>

### Base Correlations

Base correlations can be configured using either quoted base
correlations directly or by implying them from quoted upfront quotes.
When using quoted base correlations, the market quotes are directly used
to construct the base correlation curve. Alternatively, base
correlations can be implied from upfront quotes of tranches, which
involves a calibration process to derive the base correlation values
that best fit the observed market prices of the tranches.

Listing <a href="#lst:basecorr_configuration" data-reference-type="ref"
data-reference="lst:basecorr_configuration">[lst:basecorr_configuration]</a>
shows the configuration of a Base Correlation curve from quoted
correlations.

<div class="longlisting">

``` xml
  <BaseCorrelations>
    <BaseCorrelation>
      <CurveId>CDXIG</CurveId>
      <CurveDescription>CDX IG Base Correlations</CurveDescription>
      <Terms>1D</Terms>
      <DetachmentPoints>0.03, 0.06, 0.10, 0.20, 1.0</DetachmentPoints>
      <SettlementDays>0</SettlementDays>
      <Calendar>US</Calendar>
      <BusinessDayConvention>F</BusinessDayConvention>
      <DayCounter>A365</DayCounter>
      <Extrapolate>Y</Extrapolate>
    </BaseCorrelation>
  </BaseCorrelations>
```

</div>

The meaning of each of the elements in Listing
<a href="#lst:basecorr_configuration" data-reference-type="ref"
data-reference="lst:basecorr_configuration">[lst:basecorr_configuration]</a>
is given below.

- CurveId: Unique identifier of the base correlation structure

- CurveDescription \[Optional\]: A description of the base correlation
  structure, may be left blank.

- Terms: Comma-separated list of tenors, sorted in increasing order,
  possibly a single term to represent a flat term structure in
  time-direction

- DetachmentPoints: Comma-separated list of equity tranche detachment
  points, sorted in increasing order  
  Allowable values: Any positive number less than one

- SettlementDays: The floating term structure’s settlement days argument
  used in the reference date calculation

- DayCounter: The term structure’s day counter used in date to time
  conversions

- Calendar: The term structure’s calendar used in tenor to date
  conversions

- BusinessDayConvention: The term structure’s business day convention
  used in tenor to date conversion

- Extrapolate: Boolean to indicate whether the correlation curve shall
  be extrapolated or not

Listing
<a href="#lst:basecorr_upfront_configuration" data-reference-type="ref"
data-reference="lst:basecorr_upfront_configuration">[lst:basecorr_upfront_configuration]</a>
shows the configuration of a Base Correlation curve from upfront quotes
or base correlations if it fails to imply the base correlations.

<div class="longlisting">

``` xml
<BaseCorrelation>
  <CurveId>RED:2I666VDI3</CurveId>
  <CurveDescription />
  <Terms>*</Terms>
  <DetachmentPoints>*</DetachmentPoints>
  <SettlementDays>0</SettlementDays>
  <Calendar>weekends only</Calendar>
  <BusinessDayConvention>Following</BusinessDayConvention>
  <DayCounter>Actual/365 (Fixed)</DayCounter>
  <Extrapolate>true</Extrapolate>
  <QuoteName>2I666VDI3</QuoteName>
  <StartDate>2023-09-20</StartDate>
  <Rule>CDS2015</Rule>
  <AdjustForLosses>true</AdjustForLosses>
  <QuoteTypes>
    <QuoteType>PRICE</QuoteType>
    <QuoteType>BASE_CORRELATION</QuoteType>
  <QuoteTypes>
  <IndexSpread>0.01</IndexSpread>
  <Currency>EUR</Currency>
  <CalibrateConstituentsToIndexSpread>true</CalibrateConstituentsToIndexSpread>
  <AdjustForLosses>true</AdjustForLosses>
  <UseAssumedRecovery>true</UseAssumedRecovery>
  <RecoveryGrid>
    <Grid seniority="SECDOM">0.4</Grid>
    <Grid seniority="SNRFOR">0.7, 0.40000000000000002, 0.10000000000000001</Grid>
    <Grid seniority="SNRLAC">0.4</Grid>
    <Grid seniority="SUBLT2">0.2</Grid>
  </RecoveryGrid>
  <RecoveryProbabilities>
    <Probabilities seniority="SECDOM">1</Probabilities>
    <Probabilities seniority="SNRFOR">0.35, 0.29999999999999999, 0.34999999999999998</Probabilities>
    <Probabilities seniority="SNRLAC">1</Probabilities>
    <Probabilities seniority="SUBLT2">1</Probabilities>
  </RecoveryProbabilities>
</BaseCorrelation>
```

</div>

The meaning of each of the elements in Listing
<a href="#lst:basecorr_upfront_configuration" data-reference-type="ref"
data-reference="lst:basecorr_upfront_configuration">[lst:basecorr_upfront_configuration]</a>
is given below.

- CurveId: Unique identifier of the base correlation structure.

- CurveDescription \[Optional\]: A description of the base correlation
  structure, may be left blank.

- Terms: Comma-separated list of tenors, sorted in increasing order,
  possibly a single term to represent a flat term structure in the time
  direction. A wildcard (\*) can be used to include all terms.

- DetachmentPoints: Comma-separated list of equity tranche detachment
  points, sorted in increasing order. A wildcard (\*) can be used to
  include all detachment points.

- SettlementDays: The floating term structure’s settlement days argument
  used in the reference date calculation.

- Calendar: The term structure’s calendar used in tenor to date
  conversions.

- BusinessDayConvention: The term structure’s business day convention
  used in tenor to date conversion.

- DayCounter: The term structure’s day counter used in date to time
  conversions.

- Extrapolate: Boolean to indicate whether the correlation curve shall
  be extrapolated or not.

- QuoteName: The name of the quote used for the base correlation.

- StartDate: The start date for the base correlation curve.

- Rule: The rule used for the base correlation curve, e.g., CDS2015.

- AdjustForLosses: Boolean to indicate whether to adjust for losses.

- QuoteTypes: A priority list of quote types to use for the base
  correlation curve. If it fails to build a base correlation from the
  first quote type it will try the next one.

- IndexSpread: The spread of the index.

- Currency: The currency of the base correlation curve.

- CalibrateConstituentsToIndexSpread: Relevant only when price quotes
  are used. Indicates if the constituents should be calibrated to the
  index spread before deriving the base correlations from the tranche
  prices.

- UseAssumedRecovery: Boolean flag to indicate whether to use
  specialized default curves bootstrapped with assumed recovery rates
  (mean of the stochastic recovery rate distribution). These curves have
  following the naming convention \_\_CDO_CurveName\_&\_REC_0.30\_&\_
  and are used to derive the base correlations.

- RecoveryGrid: Specifies the recovery rates for different seniorities
  of the constituent. Use wildcard \* to apply one grid for all
  seniorities.

- RecoveryProbabilities: Specifies the probabilities of the recovery
  rates for different seniorities. Use wildcard \* to apply one grid for
  all seniorities.

### FXSpots

Listing <a href="#lst:fxspot_configuration" data-reference-type="ref"
data-reference="lst:fxspot_configuration">[lst:fxspot_configuration]</a>
shows the configuration of the fxSpots. It is assumed that each FXSpot
CurveId is of the form “Ccy1Ccy2”.

<div class="longlisting">

``` xml
<FXSpots>
  <FXSpot>
    <CurveId>EURUSD</CurveId>
    <CurveDescription/>
  </FXSpot>
  <FXSpot>
    <CurveId>EURGBP</CurveId>
    <CurveDescription/>
  </FXSpot>
  <FXSpot>
    <CurveId>EURCHF</CurveId>
    <CurveDescription/>
  </FXSpot>
  <FXSpot>
    <CurveId>EURJPY</CurveId>
    <CurveDescription/>
  </FXSpot>
</FXSpots>
```

</div>

### Securities

Listing <a href="#lst:security_configuration" data-reference-type="ref"
data-reference="lst:security_configuration">[lst:security_configuration]</a>
shows the configuration of the Securities. Each Security name is
associated with

- an optional SpreadQuote

- an optional RecoveryRateQuote. Usually a pricer will fall back on the
  recovery rate associated to the credit curve involved in the pricing
  if no security specific recovery rate is given. If no credit curve is
  given either, a zero recovery rate will be assumed.

- an optional ConversionFactor. In case of a bond future, a conversion
  factor might be applied. The application requires a clean price
  settlement. Otherwise the default value of 1.0 for the conversion
  factor will be used.

- an optional PriceQuote. If the bond spread imply analytics is
  available, this is used to imply a SpreadQuote to match a given bond
  price. Notice that if a SpreadQuote is given explicitly in the market
  data, this will override an implied spread.

If no configuration is given for a security, in general a pricer will
assume as zero spread and recovery rate. Notice that in this case the
spread and recovery will not be simulated and therefore also be excluded
from the sensitivity and stress analysis.

Note: in case of a forward bond, the convention for security
specification requires the format *securityId_FWDEXP_expiryDate*.

<div class="longlisting">

``` xml
<Securities>
  <Security>
    <CurveId>SECURITY_1</CurveId>
    <CurveDescription>Security</CurveDescription>
    <SpreadQuote>BOND/YIELD_SPREAD/SECURITY_1</SpreadQuote>
    <RecoveryRateQuote>RECOVERY_RATE/RATE/SECURITY_1</RecoveryRateQuote>
    <PriceQuote>BOND/PRICE/SECURITY_1</PriceQuote>
    <ConversionFactor>BOND/CONVERSION_FACTOR/SECURITY_1</ConversionFactor>
  </Security>
</Securities>
```

</div>

### Correlations

Listing
<a href="#lst:correlation_configuration" data-reference-type="ref"
data-reference="lst:correlation_configuration">[lst:correlation_configuration]</a>
shows the configuration of the Correlations. The Correlation type can be
either CMSSpread or Generic. The former one is to configure the
correlation between two CMS indexes, the latter one is to generally
configure the correlation between two indexes, e.g. between a CMS index
and a IBOR index. Currently only ATM correlation curves or Flat
correlation structures are supported. Correlation quotes may be loaded
directly (by setting QuoteType to RATE) or calibrated from prices (set
QuoteType to PRICE). Moreover a flat zero correlation curve can be
loaded (by setting QuoteType to NULL). In this case market quotes are
not needed to be provided. Currently only CMSSpread correlations can be
calibrated. This is done using CMS Spread Options, and requires a
CMSSpreadOption convention, SwaptionVolatility and DiscountCurve to be
provided. OptionTenors can be a comma separated list of periods, 1Y,2Y
etc, or a `*` to indicate a wildcard. If a wildcard is provided, all
relevant market data quotes are used.

<div class="longlisting">

``` xml
  <Correlations>
    <Correlation>
      <CurveId>EUR-CORR</CurveId>
      <CurveDescription>EUR CMS correlations</CurveDescription>
      <!--CMSSpread, Generic-->
      <CorrelationType>CMSSpread</CorrelationType>
      <Index1>EUR-CMS-10Y</Index1>
      <Index2>EUR-CMS-2Y</Index2>
      <!--Conventions, SwaptionVolatility and DiscountCurve only required when QuoteType = PRICE-->
      <Conventions>EUR-CMS-10Y-2Y-CONVENTION</Conventions>
      <SwaptionVolatility>EUR</SwaptionVolatility>
      <DiscountCurve>EUR-EONIA</DiscountCurve>
      <Currency>EUR</Currency>
      <!-- ATM, Constant -->
      <Dimension>ATM</Dimension>
      <!-- RATE, PRICE, NULL -->
      <QuoteType>PRICE</QuoteType>
      <Extrapolation>true</Extrapolation>
      <!-- Day counter for date to time conversion -->
      <DayCounter>Actual/365 (Fixed)</DayCounter>
      <!--Ccalendar and Business day convention for option tenor to date conversion -->
      <Calendar>TARGET</Calendar>
      <BusinessDayConvention>Following</BusinessDayConvention>
      <OptionTenors>1Y,2Y</OptionTenors>
    </Correlation>
  </Correlations>
```

</div>

### Commodity Curves

Commodity Curves are setup as price curves in ORE, meaning that they
return a price for a given time $t$ rather than a rate or discount
factor, these curves are common in commodities and can be populated with
futures prices directly.

Listing
<a href="#lst:commodity_curve_configuration_1" data-reference-type="ref"
data-reference="lst:commodity_curve_configuration_1">[lst:commodity_curve_configuration_1]</a>
shows the configuration of Commodity curves built from futures prices,
in this example WTI Oil prices, note there is no spot price in this
configuration, rather we have a set of futures prices only.

<div class="longlisting">

``` xml
<CommodityCurve>
  <CurveId>WTI_USD</CurveId>
  <CurveDescription>WTI USD price curve</CurveDescription>
  <Currency>USD</Currency>
  <Quotes>
    <Quote>COMMODITY_FWD/PRICE/WTI/USD/2016-06-30</Quote>
    <Quote>COMMODITY_FWD/PRICE/WTI/USD/2016-07-31</Quote>
    ...
  </Quotes>
  <DayCounter>A365</DayCounter>
  <InterpolationMethod>Linear</InterpolationMethod>
  <Extrapolation>true</Extrapolation>
</CommodityCurve>
```

</div>

Listing
<a href="#lst:commodity_curve_configuration_2" data-reference-type="ref"
data-reference="lst:commodity_curve_configuration_2">[lst:commodity_curve_configuration_2]</a>
shows the configuration for a Precious Metal curve using FX style spot
and forward point quotes, note that SpotQuote is used in this case. The
different interpretation of the forward quotes is controlled by the
conventions.

<div class="longlisting">

``` xml
<CommodityCurve>
  <CurveId>XAU</CurveId>
  <CurveDescription>Gold USD price curve</CurveDescription>
  <Currency>USD</Currency>
  <SpotQuote>COMMODITY/PRICE/XAU/USD</SpotQuote>
  <Quotes>
    <Quote>COMMODITY_FWD/PRICE/XAU/USD/ON</Quote>
    <Quote>COMMODITY_FWD/PRICE/XAU/USD/TN</Quote>
    <Quote>COMMODITY_FWD/PRICE/XAU/USD/SN</Quote>
    <Quote>COMMODITY_FWD/PRICE/XAU/USD/1W</Quote>
    ...
  </Quotes>
  <DayCounter>A365</DayCounter>
  <InterpolationMethod>Linear</InterpolationMethod>
  <Conventions>XAU</Conventions>
  <Extrapolation>true</Extrapolation>
</CommodityCurve>
```

</div>

The meaning of each of the top level elements is given below. If an
element is labelled as ’Optional’, then it may be excluded or included
and left blank.

- CurveId: Unique identifier for the curve.

- CurveDescription: A description of the curve. This field may be left
  blank.

- Currency: The commodity curve currency.

- SpotQuote \[Optional\]: The spot price quote, if omitted then the spot
  value will be interpolated.

- Quotes: forward price quotes. These can be a futures price or forward
  points.

- DayCounter: The day count basis used internally by the curve to
  calculate the time between dates.

- InterpolationMethod \[Optional\]: The variable on which the
  interpolation is performed. The allowable values are Linear,
  LogLinear, Cubic, Hermite, LinearFlat, LogLinearFlat, CubicFlat,
  HermiteFlat, BackwardFlat, ForwardFlat. This is different to yield
  curves above in that Flat versions of the standard methods are
  defined, with each of these if there is no Spot price than any
  extrapolation between $T_0$ and the first future price will be flat
  (i.e. the first future price will be copied back “Flat” to $T_0$). If
  the element is omitted or left blank, then it defaults to *Linear*.

- Conventions \[Optional\]: The conventions to use, if omited it is
  assumed that these quotes are Outright prices.

- Extrapolation \[Optional\]: Set to *True* or *False* to enable or
  disable extrapolation respectively. If the element is omitted or left
  blank, then it defaults to *True*.

Alternatively commodity curves can be set up as a commodity curve times
the ratio of two yield curves as shown in listing
<a href="#lst:commodity_curve_configuration_3" data-reference-type="ref"
data-reference="lst:commodity_curve_configuration_3">[lst:commodity_curve_configuration_3]</a>.
This can be used to setup commodity curves in different currencies, for
example Gold in EUR (XAUEUR) can be built from a Gold in USD curve and
then the ratio of the EUR and USD discount factors at each pillar. This
is akin to crossing FX forward points to get FX forward prices for any
pair.

<div class="longlisting">

``` xml
<CommodityCurve>
  <CurveId>XAUEUR</CurveId>
  <CurveDescription>Gold EUR price curve</CurveDescription>
  <Currency>EUR</Currency>
  <BasePriceCurve>XAU</BasePriceCurve>
  <BaseYieldCurve>USD-FedFunds</BaseYieldCurve>
  <YieldCurve>EUR-IN-USD</YieldCurve>
  <Extrapolation>true</Extrapolation>
</CommodityCurve>
```

</div>

Commodity curves may also be set up using a base future price curve and
a set of future basis quotes to give an outright price curve. There are
a number of options here depending on whether the base future and basis
future are averaging or not averaging. Whether or not the base future
and basis future is averaging is determined from the conventions
supplied in the `BasePriceConventions` and `BasisConventions` fields.

- The base future is not averaging and the basis future is not
  averaging. The commodity curve that is built gives the outright price
  of the non-averaging future. An example of this is the CME Henry Hub
  future contract, symbol NG, and the various locational gas basis
  future contracts, e.g. ICE Waha Basis Future, symbol WAH. Listing
  <a href="#lst:commodity_crv_config_ice_waha" data-reference-type="ref"
  data-reference="lst:commodity_crv_config_ice_waha">[lst:commodity_crv_config_ice_waha]</a>
  demonstrates an example set-up for this curve. The curve that is built
  will give the ICE Waha outright price on the basis contract’s expiry
  dates.

- The base future is not averaging and the basis future is averaging.
  The commodity curve that is built gives the outright price of the
  averaging future. In this case, if the `AverageBase` field is `true`
  the base price will be averaged from and excluding one basis future
  expiry to and including the next basis future expiry. An example of
  this is the CME Light Sweet Crude Oil future contract, symbol CL, and
  the various locational oil basis future contracts, e.g. CME WTI
  Midland (Argus) Future, symbol FF. Listing
  <a href="#lst:commodity_crv_config_cme_ff" data-reference-type="ref"
  data-reference="lst:commodity_crv_config_cme_ff">[lst:commodity_crv_config_cme_ff]</a>
  demonstrates an example set-up for this curve. The curve that is built
  will give the outright average price of WTI Midland (Argus) over the
  calendar month. If the `AverageBase` field is `false`, the base price
  is not averaged and the basis is added to the base price to give a
  curve that can be queried on an expiry date for an average price. An
  example of this is a curve built for the average of the daily prices
  published by Gas Daily using the ICE futures that reference the
  difference between the Inside FERC price and the average Gas Daily
  price.

- The base future is averaging and the basis future is averaging. The
  commodity curve that is built gives the outright price of the
  averaging future. The set-up is identical to that outlined in Listings
  <a href="#lst:commodity_crv_config_ice_waha" data-reference-type="ref"
  data-reference="lst:commodity_crv_config_ice_waha">[lst:commodity_crv_config_ice_waha]</a>
  and
  <a href="#lst:commodity_crv_config_cme_ff" data-reference-type="ref"
  data-reference="lst:commodity_crv_config_cme_ff">[lst:commodity_crv_config_cme_ff]</a>.

- The base future is averaging and the basis future is not averaging.
  This combination is not currently supported.

<div class="longlisting">

``` xml
<CommodityCurve>
  <CurveId>ICE:WAH</CurveId>
  <Currency>USD</Currency>
  <BasisConfiguration>
    <BasePriceCurve>NYMEX:NG</BasePriceCurve>
    <BasePriceConventions>NYMEX:NG</BasePriceConventions>
    <BasisQuotes>
      <Quote>COMMODITY_FWD/PRICE/ICE:WAH/*</Quote>
    </BasisQuotes>
    <BasisConventions>ICE:WAH</BasisConventions>
    <DayCounter>A365</DayCounter>
    <InterpolationMethod>LinearFlat</InterpolationMethod>
    <AddBasis>true</AddBasis>
  </BasisConfiguration>
  <Extrapolation>true</Extrapolation>
</CommodityCurve>
```

</div>

<div class="longlisting">

``` xml
<CommodityCurve>
  <CurveId>NYMEX:FF</CurveId>
  <Currency>USD</Currency>
  <BasisConfiguration>
    <BasePriceCurve>NYMEX:CL</BasePriceCurve>
    <BasePriceConventions>NYMEX:CL</BasePriceConventions>
    <BasisQuotes>
      <Quote>COMMODITY_FWD/PRICE/NYMEX:FF/*</Quote>
    </BasisQuotes>
    <BasisConventions>NYMEX:FF</BasisConventions>
    <DayCounter>A365</DayCounter>
    <InterpolationMethod>LinearFlat</InterpolationMethod>
    <AddBasis>true</AddBasis>
    <AverageBase>true</AverageBase>
    <PriceAsHistoricalFixing>true</PriceAsHistoricalFixing>
  </BasisConfiguration>
  <Extrapolation>true</Extrapolation>
</CommodityCurve>
```

</div>

The meaning of the fields in the `BasisConfiguration` node in Listings
<a href="#lst:commodity_crv_config_ice_waha" data-reference-type="ref"
data-reference="lst:commodity_crv_config_ice_waha">[lst:commodity_crv_config_ice_waha]</a>
and <a href="#lst:commodity_crv_config_cme_ff" data-reference-type="ref"
data-reference="lst:commodity_crv_config_cme_ff">[lst:commodity_crv_config_cme_ff]</a>
are as follows:

- `BasePriceCurve`: The identifier for the base future commodity price
  curve.

- `BasePriceConventions`: The identifier for the base future contract
  conventions.

- `BasisQuotes`: The set of basis quotes to look for in the market. Note
  that this can be a single wildcard string as shown in the Listings or
  a list of explicit `COMMODITY_FWD` `PRICE` quote strings.

- `BasisConventions`: The identifier for the basis future contract
  conventions.

- `DayCounter`: Has the meaning given previously in this section.

- `InterpolationMethod` \[Optional\]: Has the meaning given previously
  in this section.

- `AddBasis` \[Optional\]: This is a boolean flag where `true`, the
  default value, indicates that the basis value should be added to the
  base price to give the outright price and `false` indicates that the
  basis value should be subtracted from the base price to give the
  outright price.

- `MonthOffset` \[Optional\]: This is an optional non-negative integer
  value. In general, the basis contract period and the base contract
  period are equal, i.e. the value of the March basis contract for ICE
  Waha will be added to the value of thr March contract for CME NG. If
  for contracts with a monthly cycle or greater, the base contract month
  is $n$ months prior to the basis contract month, the `MonthOffset`
  should be set to $n$. The default value if omitted is 0.

- `PriceAsHistoricalFixing` \[Optional\]: This is a boolean flag where
  `true`, the default value, indicates that the historical fixings are
  prices of the underlying. If set to false, the fixings are basis
  spreads and ORE will convert them into prices by adding the
  corresponding base index fixings.

A commodity curve may also be set up as a piecewise price curve
involving sets of quotes e.g. direct future price quotes, future price
quotes that are the average of other future prices over a period, future
price quotes that are the average of spot price over a period etc. This
is particularly useful for cases where there are future contracts with
different cycles. For example, in the power markets, there are daily
future contracts at the short end and monthly future contracts that
average the daily prices over the month at the long end. An example of
such a set-up is shown in Listing
<a href="#lst:commodity_crv_config_ice_pdq" data-reference-type="ref"
data-reference="lst:commodity_crv_config_ice_pdq">[lst:commodity_crv_config_ice_pdq]</a>.

<div class="longlisting">

``` xml
<CommodityCurve>
  <CurveId>ICE:PDQ</CurveId>
  <Currency>USD</Currency>
  <PriceSegments>
    <PriceSegment>
      <Type>Future</Type>
      <Priority>1</Priority>
      <Conventions>ICE:PDQ</Conventions>
      <Quotes>
        <Quote>COMMODITY_FWD/PRICE/ICE:PDQ/*</Quote>
      </Quotes>
    </PriceSegment>
    <PriceSegment>
      <Type>AveragingFuture</Type>
      <Priority>2</Priority>
      <Conventions>ICE:PMI</Conventions>
      <Quotes>
        <Quote>COMMODITY_FWD/PRICE/ICE:PMI/*</Quote>
      </Quotes>
    </PriceSegment>
  </PriceSegments>
  <DayCounter>A365</DayCounter>
  <InterpolationMethod>LinearFlat</InterpolationMethod>
  <Extrapolation>true</Extrapolation>
  <BootstrapConfig>...</BootstrapConfig>
</CommodityCurve>
```

</div>

The `BootstrapConfig` node is described in Section
<a href="#sec:bootstrap_config" data-reference-type="ref"
data-reference="sec:bootstrap_config">0.1.21</a>. The remaining nodes in
Listing
<a href="#lst:commodity_crv_config_ice_pdq" data-reference-type="ref"
data-reference="lst:commodity_crv_config_ice_pdq">[lst:commodity_crv_config_ice_pdq]</a>
have been described already in this section. The meaning of each of the
fields in the `PriceSegment` node in Listing
<a href="#lst:commodity_crv_config_ice_pdq" data-reference-type="ref"
data-reference="lst:commodity_crv_config_ice_pdq">[lst:commodity_crv_config_ice_pdq]</a>
is as follows:

- `Type`: The type of the future contract for which quotes are being
  provided in the current `PriceSegment`. The allowable values are:

  - `Future`: This indicates that the quote is a straight future
    contract price quote.

  - `AveragingFuture`: This indicates that the quote is for a future
    contract price that is the average of other future contract prices
    over a given period. The averaging period for each quote and other
    conventions are given in the associated conventions determined by
    the `Conventions` node.

  - `AveragingSpot`: This indicates that the quote is for a future
    contract price that is the average of spot prices over a given
    period. The averaging period for each quote and other conventions
    are given in the associated conventions determined by the
    `Conventions` node.

- `Priority` \[Optional\]: An optional non-negative integer giving the
  priority of the current `PriceSegment` relative to the other
  `PriceSegment`s when there are quotes for contracts with the same
  expiry dates in those segments. Values closer to zero indicate higher
  priority i.e. quotes in this segment are given priority in the event
  of clashes. If omitted, the `PriceSegment`s are currently read in the
  order that they are provided in the XML so that quotes in segments
  appearing earlier in the XML will be given preference in the case of
  clashes.

- `Conventions`: The identifier for the future contract conventions
  associated with the quotes in the `PriceSegment`. Details on these
  conventions are given in Section
  <a href="#sec:commodity_future_conventions" data-reference-type="ref"
  data-reference="sec:commodity_future_conventions">[sec:commodity_future_conventions]</a>.

- `Quotes`: The set of future price quotes to look for in the market.
  Note that this can be a single wildcard string as shown in the Listing
  <a href="#lst:commodity_crv_config_ice_pdq" data-reference-type="ref"
  data-reference="lst:commodity_crv_config_ice_pdq">[lst:commodity_crv_config_ice_pdq]</a>
  or a list of explicit `COMMODITY_FWD` `PRICE` quote strings.

### Commodity Volatilities

The following types of commodity volatility structures are supported in
ORE:

- A constant volatility structure giving the same single volatility for
  all expiry times and strikes.

- A one-dimensional expiry dependent volatility structure i.e. the
  volatility returned is dependent on the time to option expiry but does
  not change with option strike.

- A two-dimensional volatility structure with a dependence on both
  expiry and strike. There is support for absolute strikes, delta
  strikes and moneyness strikes.

- An average price option (APO) volatility surface. In particular, this
  structure returns the volatility of an average price that can then be
  used directly in the Black 76 formula to give the value of the APO.

Listing <a href="#lst:comm_vol_const_config" data-reference-type="ref"
data-reference="lst:comm_vol_const_config">[lst:comm_vol_const_config]</a>
outlines the configuration for a constant volatility structure.

<div class="longlisting">

``` xml
<CommodityVolatility>
  <CurveId>...</CurveId>
  <CurveDescription>...</CurveDescription>
  <Currency>...</Currency>
  <Constant>
    <Quote>...</Quote>
  </Constant>
  <DayCounter>...</DayCounter>
  <Calendar>...</Calendar>
</CommodityVolatility>
```

</div>

The meaning of each of the elements is as follows:

- `CurveId`: Unique identifier for the curve.

- `CurveDescription`: A description of the curve. This field may be left
  blank.

- `Currency`: The commodity curve currency.

- `Quote`: The single quote giving the constant volatility.

- `DayCounter` \[Optional\]: The day count basis used internally by the
  curve to calculate the time between dates. If omitted it defaults to
  `A365`.

- `Calendar` \[Optional\]: The calendar used internally by the
  volatility structure to amend dates generated from option tenors
  i.e. if a volatility is requested from the surface using an expiry
  tenor. If omitted it defaults to `NullCalendar` meaning there is no
  adjustment to the expiry on applying the option tenor.

Listing <a href="#lst:comm_vol_curve_config" data-reference-type="ref"
data-reference="lst:comm_vol_curve_config">[lst:comm_vol_curve_config]</a>
outlines the configuration for the one-dimensional expiry dependent
volatility curve.

<div class="longlisting">

``` xml
<CommodityVolatility>
  <CurveId>...</CurveId>
  <CurveDescription>...</CurveDescription>
  <Currency>...</Currency>
  <Curve>
    <QuoteType>...</QuoteType>
    <VolatilityType>...</VolatilityType>
    <ExerciseType>...</ExerciseType>
    <Quotes>
      <Quote>...</Quote>
      <Quote>...</Quote>
      ...
    </Quotes>
    <Interpolation>...</Interpolation>
    <Extrapolation>...</Extrapolation>
    <EnforceMontoneVariance>...</EnforceMontoneVariance>
  </Curve>
  <DayCounter>...</DayCounter>
  <Calendar>...</Calendar>
  <FutureConventions>...</FutureConventions>
  <OptionExpiryRollDays>...</OptionExpiryRollDays>
</CommodityVolatility>
```

</div>

The meaning of each of the elements is given below. Elements that were
defined for the previous configuration and are common to all of the
configurations are not repeated.

- `QuoteType` \[Optional\]: The allowable values in general for
  `QuoteType` are `ImpliedVolatility` and `Premium`. Currently, only
  `ImpliedVolatility` is supported for commodity volatility curves. This
  is the default for `QuoteType` so this node may be omitted.

- `VolatilityType` \[Optional\]: The allowable values in general for
  `VolatilityType` are `Lognormal`, `ShiftedLognormal` and `Normal`.
  `Normal`, `ShiftedLognormal` and `Lognormal` are supported for
  constant and absolute strike surfaces. For all other types only
  `Lognormal` is supported. `Lognormal` is the default for
  `VolatilityType` so this node may be omitted.

- `ExerciseType` \[Optional\]: This node is described below in the
  context of surfaces. For commodity volatility curves, it is ignored
  and should be omitted.

- `Quotes`: A list of commodity option volatility quotes with different
  expiries to use in the commodity curve building. The commodity option
  volatility quotes are explained in Section
  <a href="#md:commodity_option_iv" data-reference-type="ref"
  data-reference="md:commodity_option_iv">[md:commodity_option_iv]</a>.
  As indicated above, any quote string used here much start with
  `COMMODITY_OPTION/RATE_LNVOL`. A single regular expression `Quote` is
  also supported here in place of a list of explicit `Quote` strings.
  Note that if a list of explicit `Quote` strings are provided, it is an
  error to have a duplicated option expiry date. If a regular expression
  is used, the first quote found is used and subsequent qutoes with the
  same expiry are discarded with a warning issued.

- `Interpolation`: The interpolation to use to give volatilities between
  option expiry times. The allowable values are `Linear`, `Cubic` and
  `LogLinear`. Note that the interpolation here is on the variance.

- `Extrapolation`: The extrapolation to use to give volatilities after
  the last expiry date in the variance curve. The allowable values are
  `None`, `UseInterpolator`, `Linear` and `Flat`. However, all options
  except `None` yield the same extrapolation i.e. flat extrapolation in
  the volatility. `None` disables extrapolation so that an exception is
  raised if the curve is queried after the last expiry for a volatility.
  Note that as the curve is parameterised in variance, interpolation is
  used to interpolate between time zero where the variance is zero and
  the first expiry time.

- `EnforceMontoneVariance` \[Optional\]: Boolean parameter that should
  be set to `true` to raise an exception if the implied variance curve
  is not montone increasing with time. It should be set to `false` to
  suppress such an exception. The default value if omitted is `true`.

- `FutureConventions` \[Optional\]: Depending on the quotes that are
  provided in the `Quotes` section, a `CommodityFuture` convention may
  be needed in order to derive an option expiry date from the *Expiry*
  portion of the commodity option quote. In particular, as outlined in
  Section <a href="#md:commodity_option_iv" data-reference-type="ref"
  data-reference="md:commodity_option_iv">[md:commodity_option_iv]</a>,
  the *Expiry* portion of a commodity option quote allows for
  continuation expiries of the form `cN`. The `N` is a positive integer
  meaning the `N`-th next expiry after the valuation date on which we
  are building the commodity volatility curve. When a continuation
  expiry is used in a quote, the `FutureConventions` is needed and gives
  the ID of the conventions associated with the commodity for which we
  are trying to build the volatility curve. These conventions are used
  to determine the explicit expiry date for the given option quote from
  the continuation expiry.

- `OptionExpiryRollDays` \[Optional\]: The `OptionExpiryRollDays` can be
  any non-negative integer and may be needed when deriving an option
  expiry date from the *Expiry* portion of the commodity option quote.
  If the *Expiry* portion of the commodity option quote is a
  continuation expiry, an explicit expiry date is deduced as explained
  in the previous bullet point. Additionally, in some cases, the option
  quotes for the next option expiry may stop a number of business days
  before that option expiry and the `cN` expiry in this period begins
  referring to the `N+1`-th next option expiry. As an example, assume
  $d_v$ is the valuation date and $e_1 = d_v$ is the next option expiry
  date. If `OptionExpiryRollDays` is `0` then a commodity option quote
  with an *Expiry* portion equal to `c1` on $d_v$ indicates that the
  option quote is for an option with expiry date equal to $e_1$.
  However, if `OptionExpiryRollDays` is `1`, a commodity option quote
  with an *Expiry* portion equal to `c1` on $d_v$ indicates that the
  option quote is for an option with expiry date equal to $e_2$ where
  $e_2$ is the next option expiry date after $e_1$. In other words, with
  `OptionExpiryRollDays` set to `1` the option quotes for expiry date
  $e_1$ stopped on the business day before $e_1$. If omitted,
  `OptionExpiryRollDays` defaults to `0`.

Listing
<a href="#lst:comm_vol_strike_surface_config" data-reference-type="ref"
data-reference="lst:comm_vol_strike_surface_config">[lst:comm_vol_strike_surface_config]</a>
outlines the configuration for the two-dimensional expiry and absolute
strike commodity option surface.

<div class="longlisting">

``` xml
<CommodityVolatility>
  <CurveId>...</CurveId>
  <CurveDescription>...</CurveDescription>
  <Currency>...</Currency>
  <StrikeSurface>
    <QuoteType>...</QuoteType>
    <VolatilityType>...</VolatilityType>
    <ExerciseType>...</ExerciseType>
    <Strikes>...</Strikes>
    <Expiries>...</Expiries>
    <TimeInterpolation>...</TimeInterpolation>
    <StrikeInterpolation>...</StrikeInterpolation>
    <Extrapolation>...</Extrapolation>
    <TimeExtrapolation>...</TimeExtrapolation>
    <StrikeExtrapolation>...</StrikeExtrapolation>
  </StrikeSurface>
  <DayCounter>...</DayCounter>
  <Calendar>...</Calendar>
  <FutureConventions>..</FutureConventions>
  <OptionExpiryRollDays>...</OptionExpiryRollDays>
  <PriceCurveId>...</PriceCurveId>
  <YieldCurveId>...</YieldCurveId>
  <OneDimSolverConfig>
    <MaxEvaluations>100</MaxEvaluations>
    <InitialGuess>0.35</InitialGuess>
    <Accuracy>0.0001</Accuracy>
    <MinMax>
      <Min>0.0001</Min>
      <Max>2.0</Max>
    </MinMax>
  </OneDimSolverConfig>
  <PreferOutOfTheMoney>...</PreferOutOfTheMoney>
  <QuoteSuffix>...</QuoteSuffix>
</CommodityVolatility>
```

</div>

The meaning of each of the elements is given below. Again, nodes
explained in the previous configuration are not repeated here.

- `QuoteType` \[Optional\]: As above, the allowable values for
  `QuoteType` are `ImpliedVolatility` and `Premium`. If omitted, the
  default is `ImpliedVolatility`. If the `QuoteType` is `Premium`, a
  volatility surface will be stripped from option premium quotes. Note
  that `Premium` is only allowed if one or both of `Strikes` or
  `Expiries` below is set to the single wildcard value `*`. In other
  words, if we explicitly specify all of the strikes and expiries, we
  can only build a volatility surface directly and the `QuoteType` must
  be `ImpliedVolatility`.

- `VolatilityType` \[Optional\]: As above, the allowable values for
  `VolatilityType` are `Lognormal`, `ShiftedLognormal` and `Normal`.
  This is only needed if `QuoteType` is `ImpliedVolatility`. Currently,
  only `Lognormal` is supported for commodity volatility surfaces. This
  is the default for `VolatilityType` so this node may be omitted.

- `ExerciseType` \[Optional\]: The allowable values for `ExerciseType`
  are `European` and `American`. This is only needed if `QuoteType` is
  `Premium` and indicates if the option premium quotes are American or
  European exercise. If omitted the default is `European`.

- `Strikes`: This can be a single wildcard value `*` or a comma
  separated list of explicit strike prices. We explain below how these
  strikes are combined with the other parameters in the configuration to
  give a list of commodity option quotes to search for in the market
  data.

- `Expiries`: This can be a single wildcard value `*` or a comma
  separated list of expiry strings. We explain below how these expiries
  are combined with the other parameters in the configuration to give a
  list of commodity option quotes to search for in the market data. Note
  that as outlined in Section
  <a href="#md:commodity_option_iv" data-reference-type="ref"
  data-reference="md:commodity_option_iv">[md:commodity_option_iv]</a>,
  the *Expiry* portion of the commodity option quote may be an explicit
  expiry date, an expiry tenor or a continuation expiry of the form `cN`
  explained in the volatility curve section above.

- `TimeInterpolation`: Indicates the interpolation in the time
  direction. The allowable values for `TimeInterpolation` are `Linear`
  and `Cubic`. If neither `Strikes` nor `Expiries` use the single
  wildcard value `*`, `TimeInterpolation` and `StrikeInterpolation` must
  have the same value. If it does not, then `Linear` is used for both.
  In other words, if neither `Strikes` nor `Expiries` use the single
  wildcard value `*`, we can configure bilinear or bicubic
  interpolation. If either `Strikes` or `Expiries` use the single
  wildcard value `*`, `TimeInterpolation` and `StrikeInterpolation` can
  be different. For backward compatibility, if either `Strikes` or
  `Expiries` use the single wildcard value `*`, `TimeInterpolation` and
  `StrikeInterpolation` will use Linear as default value or when input
  values are not in allowable list. Again, in all cases, the
  interpolation is carried out on the variance.

- `StrikeInterpolation`: Indicates the interpolation in the strike
  direction. The requirements are exactly as outlined for the
  `TimeInterpolation` node.

- `Extrapolation`: A boolean value indicating if extrapolation is
  allowed.

- `TimeExtrapolation`: Defines how to extrapolate in the time direction.
  Allowed values are:

  - `None`: No extrapolation.

  - `Flat`: Keeps the volatility constant beyond the known range.

  - `UseInterpolator`: Extends the configured interpolation (linear or
    cubic) into the extrapolated range.

  - `Linear`: Legacy identifier and falls back to `UseInterpolator`, but
    only for backward compatibility. Prefer `UseInterpolator` for
    clarity.

  Notes:

  - Variance extrapolation works with linear and cubic interpolation.

  - Volatility extrapolation only works with linear interpolation.

- `TimeExtrapolationVariance`: Specifies whether to extrapolate variance
  or volatility in the time direction. Allowed values are:

  - `True`: Extrapolates variance (default if omitted).

  - `False`: Extrapolates volatility.

  Notes:

  - Ignored if `TimeExtrapolation` is set to `Flat`.

  - Volatility extrapolation in time works only with linear
    interpolation.

- `StrikeExtrapolation`: Indicates the extrapolation in the strike
  direction. The allowable values are `None`, `UseInterpolator`,
  `Linear` and `Flat`. Both `Flat` and `None` give flat extrapolation in
  the strike direction. `UseInterpolator` and `Linear` indicate that the
  configured interpolation (linear or cubic) should be continued in the
  strike direction in order to extrapolate. `Linear` is only allowable
  here for backward compatibility and `UseInterpolator` should be
  preferred for clarity.

- `PriceCurveId` \[Optional\]: The ID of a price curve for the commodity
  of the form `Commodity/{CCY}/{NAME}`. This is needed if the
  `QuoteType` is `Premium`. It is also needed when the `QuoteType` is
  `ImpliedVolatility` if either `Strikes` or `Expiries` use the single
  wildcard value `*` and both call and put quotes are found in the
  market for the same expiry and strike pair. In this case, it is needed
  to determine which quotes to use based on the value of the
  `PreferOutOfTheMoney` node.

- `YieldCurveId` \[Optional\]: The ID of a yield curve in the currency
  of the commodity of the form `Yield/{CCY}/{NAME}`. This is needed if
  the `QuoteType` is `Premium` in the stripping of the volatilities from
  premia.

- `OneDimSolverConfig` \[Optional\]: This is used if the `QuoteType` is
  `Premium`. It provides the options for the root search in the
  stripping of the volatilities from premia. If omitted, the default set
  of options shown in Listing
  <a href="#lst:comm_vol_strike_surface_config" data-reference-type="ref"
  data-reference="lst:comm_vol_strike_surface_config">[lst:comm_vol_strike_surface_config]</a>
  are used. The `MinMax` node can be replaced with a single `Step` node
  that accepts a double giving the step size to use in the root search.

- `PreferOutOfTheMoney` \[Optional\]: A node accepting a boolean value.
  If set to `true`, quotes for out of the money options are preferred
  where a call and a put quote are found for the same expiry strike
  pair. If set to `false`, quotes for in the money options are preferred
  where a call and a put quote are found for the same expiry strike
  pair. If omitted, `true` is assumed.

- `QuoteSuffix` \[Optional\]: The allowable values are `C` and `P`
  indicating `Call` and `Put` respectively. If given, they are used in
  the construction of the commodity option quote strings as explained
  below. They are useful in cases where the market data contains both
  call and put volatility quotes for the same expiry strike pair and you
  want to use only the calls (set `QuoteSuffix` to `C`) or the puts (set
  `QuoteSuffix` to `P`).

As mentioned above, a number of parameters from the two-dimensional
expiry and absolute strike configuration are used in constructing the
commodity option quote strings that are looked up in the market data.
There are two cases:

1.  Both the `Strikes` and `Expiries` node provide a comma separated
    list of values. As mentioned above, we can only use a `QuoteType` of
    `ImpliedVolatility` in this case where we have explicit expiries and
    strikes and the `VolatilityType` must be `Lognormal`. For example,
    assume the `Expiries` node has the set of values `e_1,e_2,...,e_N`
    and that the `Strikes` node has the set of values `s_1,s_2,...,s_M`.
    For each of the $N \times M$ expiry strike pairs $(e_n,s_m)$, a
    quote of the form
    `COMMODITY_OPTION/RATE_LNVOL/{N}/{C}/e_n/s_m[/{S}]` is created to be
    looked up in the market data. `{N}` is the value in the `CurveId`
    node, `{C}` is the value in the `Currency` node and `{S}` is the
    value in the `QuoteSuffix` node if given. This explicit grid of
    volatility quotes must be present in the market for the commodity
    volatility surface to be constructed.

2.  One or both of the `Strikes` and `Expiries` node use a single
    wildcard value `*`. As mentioned above, the `QuoteType` can be
    `ImpliedVolatility` or `Premium` in this case. As above, assume the
    `Expiries` node has the set of values `e_1,e_2,...,e_N` and that the
    `Strikes` node has the set of values `s_1,s_2,...,s_M`. The
    additional constraint here is that $N=1$ and `e_1` is `*` or that
    $M=1$ and `s_1` is `*`, or both. For each of the $N \times M$ expiry
    strike pairs $(e_n,s_m)$, a quote of the form
    `COMMODITY_OPTION/{T}/{N}/{C}/e_n/s_m[/{S}]` is created to be looked
    up in the market data. `{T}` is `PRICE` when `QuoteType` is
    `Premium` and is `RATE_LNVOL` when `QuoteType` is
    `ImpliedVolatility`, `{N}` is the value in the `CurveId` node, `{C}`
    is the value in the `Currency` node and `{S}` is the value in the
    `QuoteSuffix` node if given. Any quote in the market with a name
    matching any of the quote strings formed in this way are then
    included in the commodity volatility curve building. Note that the
    `QuoteSuffix` has no effect in this case and should be omitted
    i.e. it is only used in the case of an explicit grid of quotes
    above.

Listing
<a href="#lst:comm_vol_mny_surface_config" data-reference-type="ref"
data-reference="lst:comm_vol_mny_surface_config">[lst:comm_vol_mny_surface_config]</a>
outlines the configuration for the two-dimensional expiry and moneyness
strike commodity option surface. This is similar to the absolute strike
surface configuration above but currently only supports a `QuoteType` of
`ImpliedVolatility` i.e. `QuoteType` of `Premium` is not supported.
Also, the `VolatilityType` must be `Lognormal`. Both forward and spot
moneyness is supported.

<div class="longlisting">

``` xml
<CommodityVolatility>
  <CurveId>...</CurveId>
  <CurveDescription>...</CurveDescription>
  <Currency>...</Currency>
  <MoneynessSurface>
    <QuoteType>...</QuoteType>
    <VolatilityType>...</VolatilityType>
    <ExerciseType>...</ExerciseType>
    <MoneynessType>...</MoneynessType>
    <MoneynessLevels>...</MoneynessLevels>
    <Expiries>...</Expiries>
    <TimeInterpolation>...</TimeInterpolation>
    <StrikeInterpolation>...</StrikeInterpolation>
    <Extrapolation>...</Extrapolation>
    <TimeExtrapolation>...</TimeExtrapolation>
    <StrikeExtrapolation>...</StrikeExtrapolation>
    <FuturePriceCorrection>...</FuturePriceCorrection>
  </MoneynessSurface>
  <DayCounter>...</DayCounter>
  <Calendar>...</Calendar>
  <FutureConventions>..</FutureConventions>
  <OptionExpiryRollDays>...</OptionExpiryRollDays>
  <PriceCurveId>...</PriceCurveId>
  <YieldCurveId>...</YieldCurveId>
</CommodityVolatility>
```

</div>

The meaning of each of the elements is given below. Again, nodes
explained in the previous configuration are not repeated here.

- `MoneynessType`: The allowable values are `Spot` for spot moneyness
  and `Fwd` for forward moneyness.

- `MoneynessLevels`: This must be a comma separated list of moneyness
  values. A moneyness value of $1$ indicates a strike equal to spot or
  forward depending on the value given in the `MoneynessType` node.

- `TimeInterpolation`: Only `Linear` is currently supported here.

- `StrikeInterpolation`: Only `Linear` is currently supported here.

- `Extrapolation`: A boolean value indicating if extrapolation is
  allowed.

- `TimeExtrapolation`: Defines how to extrapolate in the time direction.
  Allowed values are:

  - `None`: No extrapolation.

  - `Flat`: Keeps the volatility constant beyond the known range.

  - `UseInterpolator`: Extends the configured interpolation (linear)
    into the extrapolated range.

  - `Linear`: Legacy identifier and falls back to `UseInterpolator`, but
    only for backward compatibility. Prefer `UseInterpolator` for
    clarity.

- `TimeExtrapolationVariance`: Specifies whether to extrapolate variance
  or volatility in the time direction. Allowed values are:

  - `True`: Extrapolates variance (default if omitted).

  - `False`: Extrapolates volatility.

  Notes:

  - Ignored if `TimeExtrapolation` is set to `Flat`.

  - Volatility extrapolation in time works only with linear
    interpolation.

- `StrikeExtrapolation`: Indicates the extrapolation in the strike
  direction. The allowable values are `None`, `UseInterpolator`,
  `Linear` and `Flat`. Both `Flat` and `None` give flat extrapolation in
  the strike direction. `UseInterpolator` and `Linear` indicate that the
  configured interpolation (linear) should be continued in the strike
  direction in order to extrapolate.

- `FuturePriceCorrection` \[Optional\]: This is a boolean flag that
  defaults to `true`. In most cases, for options on futures, the option
  expiry date is a short period before the future expiry. If there is an
  arbitrary interpolation applied to the future price curve, the future
  price on the option expiry date may not equal the associated future
  price. If `FuturePriceCorrection` is `true`, this is corrected
  i.e. the future price on option expiry is the associated future price
  for the future expiry date. Note that a valid `FutureConventions` is
  needed for the correction to be applied.

- `PriceCurveId`: This is required for both a spot and forward moneyness
  surface.

- `YieldCurveId`: This is required for a forward moneyness surface.

Note that, similar to the procedure outlined above for the absolute
strike surface, quote strings of the form
`COMMODITY_OPTION/RATE_LNVOL/{N}/{C}/e_n/MNY/{T}/l_m` are created from
the moneyness configuration to be looked up in the market. Here, `l_m`
are the moneyness levels for $m=1,\ldots,M$ and `{T}` is the moneyness
type i.e. either `Spot` or `Fwd`.

Listing
<a href="#lst:comm_vol_delta_surface_config" data-reference-type="ref"
data-reference="lst:comm_vol_delta_surface_config">[lst:comm_vol_delta_surface_config]</a>
outlines the configuration for the two-dimensional expiry and delta
strike commodity option surface. Similar to the moneyness strike surface
configuration above, this currently only supports a `QuoteType` of
`ImpliedVolatility` i.e. `QuoteType` of `Premium` is not supported.
Also, the `VolatilityType` must be `Lognormal`. Various delta and ATM
types are supported.

<div class="longlisting">

``` xml
<CommodityVolatility>
  <CurveId>...</CurveId>
  <CurveDescription>...</CurveDescription>
  <Currency>...</Currency>
  <DeltaSurface>
    <QuoteType>...</QuoteType>
    <VolatilityType>...</VolatilityType>
    <ExerciseType>...</ExerciseType>
    <DeltaType>...</DeltaType>
    <AtmType>...</AtmType>
    <AtmDeltaType>...</AtmDeltaType>
    <PutDeltas>...</PutDeltas>
    <CallDeltas>...</CallDeltas>
    <Expiries>...</Expiries>
    <TimeInterpolation>...</TimeInterpolation>
    <StrikeInterpolation>...</StrikeInterpolation>
    <Extrapolation>...</Extrapolation>
    <TimeExtrapolation>...</TimeExtrapolation>
    <StrikeExtrapolation>...</StrikeExtrapolation>
    <FuturePriceCorrection>...</FuturePriceCorrection>
  </DeltaSurface>
  <DayCounter>...</DayCounter>
  <Calendar>...</Calendar>
  <FutureConventions>..</FutureConventions>
  <OptionExpiryRollDays>...</OptionExpiryRollDays>
  <PriceCurveId>...</PriceCurveId>
  <YieldCurveId>...</YieldCurveId>
</CommodityVolatility>
```

</div>

The meaning of each of the elements is given below. Again, nodes
explained in the previous configuration are not repeated here.

- `DeltaType`: The allowable supported values are `Spot` for spot delta
  `Fwd` for forward delta.

- `AtmType`: The allowable supported values are `AtmSpot`, `AtmFwd` and
  `AtmDeltaNeutral`.

- `AtmDeltaType` \[Optional\]: This is only needed if the `AtmType` is
  `AtmDeltaNeutral`.

- `PutDeltas`: A comma separated list of one or more put deltas to use
  in the volatility surface. Note that the put deltas should be given
  without a sign e.g. `<PutDeltas>0.10,0.20,0.30,0.40</PutDeltas>` would
  be an example. The delta should match exactly the quote i.e 0.1 !=
  0.10

- `CallDeltas`: A comma separated list of one or more call deltas to use
  in the volatility surface. The delta should match exactly the quote
  i.e 0.1 != 0.10

- `Expiries`: A comma separated list of one or more expiries (e.g. 1W,
  1M) to load. Supports using the single wildcard value `*`.

- `TimeInterpolation`: Only `Linear` is currently supported here.

- `StrikeInterpolation`: Allowable values are `Linear`, `NaturalCubic`,
  `FinancialCubic` and `CubicSpline`.

- `Extrapolation`: A boolean value indicating if extrapolation is
  allowed.

- `TimeExtrapolation`: Defines how to extrapolate in the time direction.
  Allowed values are:

  - `None`: No extrapolation.

  - `Flat`: Keeps the volatility constant beyond the known range.

  - `UseInterpolator`: Extends the configured interpolation (linear)
    into the extrapolated range.

  - `Linear`: Legacy identifier and falls back to `UseInterpolator`, but
    only for backward compatibility. Prefer `UseInterpolator` for
    clarity.

- `TimeExtrapolationVariance`: Specifies whether to extrapolate variance
  or volatility in the time direction. Allowed values are:

  - `True`: Extrapolates variance (default if omitted).

  - `False`: Extrapolates volatility.

  Notes:

  - Ignored if `TimeExtrapolation` is set to `Flat`.

  - Volatility extrapolation in time works only with linear
    interpolation.

- `StrikeExtrapolation`: Indicates the extrapolation in the strike
  direction. The allowable values are `None`, `UseInterpolator`,
  `Linear` and `Flat`. Both `Flat` and `None` give flat extrapolation in
  the strike direction. `UseInterpolator` and `Linear` indicate that the
  configured interpolation should be continued in the strike direction
  in order to extrapolate.

- `PriceCurveId`: This is required for a delta surface.

- `YieldCurveId`: This is required for a delta surface.

Note that, similar to the procedure outlined above for the absolute
strike surface, quote strings are created from the configuration to be
looked up in the market. For the put deltas, quote strings of the form
`COMMODITY_OPTION/RATE_LNVOL/{N}/{C}/e_n/DEL/{T}/Put/d_m` are created.
Here, `d_m` are the `PutDeltas` and `{T}` is the delta type i.e. either
`Spot` or `Fwd`. Similarly for the call deltas, quote strings of the
form `COMMODITY_OPTION/RATE_LNVOL/{N}/{C}/e_n/DEL/{T}/Call/d_j` are
created where `d_j` are the `CallDeltas`. For ATM, quote strings of the
form `COMMODITY_OPTION/RATE_LNVOL/{N}/{C}/e_n/DEL/ATM/{A}[/DEL/{T}]` are
created where `{A}` is the `AtmType` i.e. `AtmSpot`, `AtmFwd` or
`AtmDeltaNeutral` and `{T}` is the optional delta type.

Also, it is worth adding a note here on the interpolation for a delta
based surface. Assume we want the volatility at time $t$ and absolute
strike $s$ i.e. at the $(t, s)$ node. For the maturity time $t$, a delta
“slice” i.e. a set of (delta, vol) pairs for that time $t$, is obtained
by interpolating, or extrapolating, the variance in the time direction
on each delta column. Then for each (delta, vol) pair at time $t$, an
absolute strike value is deduced to give a slice at time $t$ in terms of
absolute strike i.e. a set of (strike, vol) pairs at time $t$. This
strike versus volatility curve is then interpolated, or extrapolated, to
give the vol at the $(t, s)$.

Listing
<a href="#lst:comm_vol_apo_surface_config" data-reference-type="ref"
data-reference="lst:comm_vol_apo_surface_config">[lst:comm_vol_apo_surface_config]</a>
outlines the configuration for the APO volatility surface. This
currently only supports a `QuoteType` of `ImpliedVolatility` and
`VolatilityType` must be `Lognormal`. This configuration takes a base
commodity volatility surface and builds a surface that can be queried
for volatilities to price APOs directly i.e. using the volatility
directly in a Black 76 formula along with the average future price. It
uses the approach described in the Section entitled *Commodity Average
Price Option - Future Settlement Prices* in the Product Catalogue to go
from future option volatilities to APO volatilities.

We describe here briefly a motivating example encountered in practice.
We have commodity APOs where the underlying is WTI Midland Argus
averaged over the calendar month. We do not have direct volatilities for
these APO contracts. We have a price curve for the average of WTI
Midland Argus over the calendar month from the futures market. We can
use the volatility surface that we have for CME WTI to build an APO
surface for WTI Midland Argus. Listing
<a href="#lst:comm_vol_apo_surface_config" data-reference-type="ref"
data-reference="lst:comm_vol_apo_surface_config">[lst:comm_vol_apo_surface_config]</a>
shows the configuration used in this context.

<div class="longlisting">

``` xml
<CommodityVolatility>
  <CurveId>WTI_MIDLAND</CurveId>
  <CurveDescription>WTI Midland (CAL) APO surface</CurveDescription>
  <Currency>USD</Currency>
  <ApoFutureSurface>
    <QuoteType>ImpliedVolatility</QuoteType>
    <VolatilityType>Lognormal</VolatilityType>
    <MoneynessLevels>0.50,0.75,1.00,1.25,1.50</MoneynessLevels>
    <VolatilityId>CommodityVolatility/USD/WTI</VolatilityId>
    <PriceCurveId>Commodity/USD/WTI</PriceCurveId>
    <FutureConventions>WTI</FutureConventions>
    <TimeInterpolation>Linear</TimeInterpolation>
    <StrikeInterpolation>Linear</StrikeInterpolation>
    <Extrapolation>true</Extrapolation>
    <TimeExtrapolation>Flat</TimeExtrapolation>
    <StrikeExtrapolation>Flat</StrikeExtrapolation>
    <MaxTenor>2Y</MaxTenor>
    <Beta>0</Beta>
  </ApoFutureSurface>
  <DayCounter>A365</DayCounter>
  <Calendar>CME</Calendar>
  <FutureConventions>WTI_MIDLAND</FutureConventions>
  <PriceCurveId>Commodity/USD/WTI_MIDLAND</PriceCurveId>
  <YieldCurveId>Yield/USD/USD-FedFunds</YieldCurveId>
</CommodityVolatility>
```

</div>

The meaning of each of the elements is given below.

- `MoneynessLevels`: A comma separated list of the moneyness levels used
  in the APO surface construction. Forward moneyness is assumed with a
  value of $1$ indicating a strike equal to the future price.

- `VolatilityId`: The ID of an existing commodity option surface for
  options on the future settlement price referenced in the APOs used in
  the generation of the volatilities for this surface.

- `PriceCurveId`: The ID of an existing commodity price curve for the
  future settlement price referenced in the APOs used in the generation
  of the volatilities for this surface.

- `FutureConventions`: This ID of the commodity future conventions for
  the future settlement price referenced in the APOs used in the
  generation of the volatilities for this surface.

- `TimeExtrapolation`: Defines how to extrapolate in the time direction.
  Allowed values are:

  - `None`: No extrapolation.

  - `Flat`: Keeps the volatility constant beyond the known range.

  - `UseInterpolator`: Extends the configured interpolation (linear)
    into the extrapolated range.

  - `Linear`: Legacy identifier and falls back to `UseInterpolator`, but
    only for backward compatibility. Prefer `UseInterpolator` for
    clarity.

- `TimeExtrapolationVariance`: Specifies whether to extrapolate variance
  or volatility in the time direction. Allowed values are:

  - `True`: Extrapolates variance (default if omitted).

  - `False`: Extrapolates volatility.

  Notes:

  - Ignored if `TimeExtrapolation` is set to `Flat`.

  - Volatility extrapolation in time works only with linear
    interpolation.

- `StrikeInterpolation`: Only `Linear` is supported here. Note that the
  interpolation is in terms of variance.

- `Extrapolation`: A boolean value indicating if extrapolation is
  allowed.

- `TimeExtrapolation`: Only `Flat` is currently supported here. The flat
  extrapolation is in terms of the volatility.

- `StrikeExtrapolation`: Indicates the extrapolation in the strike
  direction. The allowable values are `None`, `UseInterpolator`,
  `Linear` and `Flat`. Both `Flat` and `None` give flat extrapolation in
  the strike direction. `UseInterpolator` and `Linear` indicate that the
  configured interpolation should be continued in the strike direction
  in order to extrapolate.

- `PriceCurveId`: The ID of an existing commodity price curve giving the
  average price for the APO period.

- `YieldCurveId`: This ID of a yield curve in the currency of the
  commodity used for discounting.

### Bootstrap Configuration

The `BootstrapConfig` node, outlined in listing
<a href="#lst:bootstrap_config_outline" data-reference-type="ref"
data-reference="lst:bootstrap_config_outline">[lst:bootstrap_config_outline]</a>,
can be added to curve configurations that use a bootstrap algorithm to
alter the default behaviour of the bootstrap algorithm.

<div class="longlisting">

``` xml
<BootstrapConfig>
  <Accuracy>...</Accuracy>
  <GlobalAccuracy>...</GlobalAccuracy>
  <DontThrow>...</DontThrow>
  <MaxAttempts>...</MaxAttempts>
  <MaxFactor>...</MaxFactor>
  <MinFactor>...</MinFactor>
  <DontThrowSteps>...</DontThrowSteps>
  <Global>...<Global>
</BootstrapConfig>
```

</div>

The meaning of each of the elements is:

- `Accuracy` \[Optional\]: The accuracy with which the implied quote
  must match the market quote for each instrument in the curve bootstrap
  (iterative bootstrap) or the accuracy of the global optimizer (global
  bootstrap). This node should hold a positive real number. If omitted,
  the default value is 1.0 × 10<sup>−12</sup>.

- `GlobalAccuracy` \[Optional\]: If the interpolation method in the
  bootstrap is global, e.g. cubic spline, the bootstrap routine needs to
  perform multiple iterative bootstraps of the curve to converge. After
  each such bootstrap of the full curve, the absolute value of the
  change between the current bootstrap and previous bootstrap for the
  curve value at each pillar is calculated. The global bootstrap is
  deemed to have converged if the maximum of these changes is less than
  the global accuracy or the accuracy from the `Accuracy` node. This
  node should hold a positive real number. If omitted, the global
  accuracy is set equal to the accuracy from the `Accuracy` node. This
  node is useful in some cases where a slightly less restrictive
  accuracy, than that given by the `Accuracy` node, is needed for the
  global bootstrap.

- `DontThrow` \[Optional\]: If this node is set to `true`, the curve
  bootstrap does not throw an error when the bootstrap fails at a
  pillar. Instead, a curve value is sought at the failing pillar that
  minimises the absolute value of the difference between the implied
  quote and the market quote at that pillar. The minimum is sought
  between the minimum and maximum curve value that was used in the root
  finding routine that failed at the pillar. The number of steps used in
  this search is given by the `DontThrowSteps` node below. This node
  should hold a boolean value. If omitted, the default value is `false`
  i.e. the bootstrap throws an exception at the first pillar where the
  bootstrap fails.

- `MaxAttempts` \[Optional\]: At each pillar, the bootstrap routine
  searches between a minimum curve value and a maximum curve value for a
  curve value that gives an implied quote that matches the market quote
  at that pillar. In some cases, the minimum curve value and maximum
  curve value are too restrictive and the bootstrap fails at a pillar.
  This node determines how many times the bootstrap should be attempted
  at each pillar. For example, if the node is set to 1, the bootstrap
  uses the minimum curve value and maximum curve value implied in the
  code and fails if a root is not found. If this node is set to 2 and
  the first attempt fails, the minimum curve value is reduced by a
  factor specified in the node `MinFactor`, the maximum curve value is
  increased by a factor specified in the node `MaxFactor` and a second
  attempt is made to find a root between the enlarged bounds. If no root
  is found, the bootstrap then fails at this pillar. This node should
  hold a positive integer. If omitted, the default value is 5.

- `MaxFactor` \[Optional\]: This node is used only if `MaxAttempts` is
  greater than 1. The meaning of this node is given in the description
  of the `MaxAttempts` node. This node should hold a positive real
  number. If omitted, the default value is 2.0.

- `MinFactor` \[Optional\]: This node is used only if `MaxAttempts` is
  greater than 1. The meaning of this node is given in the description
  of the `MaxAttempts` node. This node should hold a positive real
  number. If omitted, the default value is 2.0.

- `DontThrowSteps` \[Optional\]: This node is used only if `DontThrow`
  is `true`. The meaning of this node is given in the description of the
  `DontThrow` node. This node should hold a positive integer. If
  omitted, the default value is 10.

- `Global` \[Optional\]: Defaults to false. This nodes specifies whether
  the curve should use a global bootstrap over all instruments of the
  curve (true) or iterative bootstrap (false, default value). If global
  bootstrap is used, only the fields Accuracy and SmoothnessLambda of
  the BootstrapConfig are relevant. Accurcy specifies the accuracy of
  the global optimizer in this case. Global bootstrap is required to
  build curves that form a cycle in the dependency graph, in this case
  all members of the cycle must have Global set to true in their
  bootstrap configs. In this case a global optimization is run over all
  instrument of all members of the cycle simultaneously. Global
  bootstrap is also required if according to the PillarChoice
  configuration of each segment there are curve instrument without or
  with more than one associated curve pillar date. Finally, global
  bootstrap can be preferable over iterative bootstrap if the latter
  requires an outer convergence loop, i.e. if a pillar choice is not set
  to LastRelevatDate or if the interpolation is non-local.

- `SmoothnessLambda` \[Optional\]: Defaults to zero. Only applies if
  GLobal is set to true. If positive, penalty components are included in
  the global optimization used to build a curve. For each adjacent pair
  of discrete forward rates $F_i$, $F_{i+1}$ between curve interpolation
  pillars, the term $\lambda\cdot(F_{i+1} - F_i)$ is added to the target
  function vector of which the MSE is optimized.

### One Dimensional Solver Configuration

The `OneDimSolverConfig` node, outlined in Listing
<a href="#lst:one_dim_solver_config_outline" data-reference-type="ref"
data-reference="lst:one_dim_solver_config_outline">[lst:one_dim_solver_config_outline]</a>,
can be added to certain curve configurations that lead to a one
dimensional solver being used in the curve construction. For example,
the `EquityVolatility` curve configuration can lead to equity
volatilities being stripped from equity option premiums. In this case,
the `OneDimSolverConfig` node can be added to the `EquityVolatility`
curve configuration to indicate how the solver should behave
i.e. maximum number of evaluations, initial guess, accuracy etc. The
various options are outlined below.

<div class="longlisting">

``` xml
<OneDimSolverConfig>
  <MaxEvaluations>...</MaxEvaluations>
  <InitialGuess>...</InitialGuess>
  <Accuracy>...</Accuracy>
  <MinMax>
    <Min>...</Min>
    <Max>...</Max>
  </MinMax>
  <!-- Step only needed if MinMax not provided. -->
  <Step>...</Step>
  <LowerBound>...</LowerBound>
  <UpperBound>...</UpperBound>
</OneDimSolverConfig>
```

</div>

The meaning of each of the elements is:

- `MaxEvaluations`: This node should hold a positive integer. The
  maximum number of function evaluations that can be made by the solver.

- `InitialGuess`: This node should hold a real number. The initial guess
  used by the solver.

- `Accuracy`: This node should hold a positive real number. The accuracy
  used by the solver in the root find.

- `MinMax` \[Optional\]: A node that holds a `Min` and a `Max` node each
  of which should hold a real number. This indicates that the solver
  should search for a root between the value in `Min` and the value in
  `Max`. The value in `Min` should obviously be less than the value in
  `Max`. This node is optional. If not provided, the `Step` node below
  should be provided to set up a step based solver.

- `Step` \[Optional\]: This node should hold a real number. The
  validation is a choice between `MinMax` and `Step` so that `Step` can
  only be provided if `MinMax` is not and vice versa. The value in
  `Step` provides the solver with a step size to use in its search for a
  root.

- `LowerBound` \[Optional\]: This node should hold a real number. It
  provides a lower bound for the search domain. If omitted, no lower
  bound is applied to the search domain.

- `UpperBound` \[Optional\]: This node should hold a real number. It
  provides an upper bound for the search domain. If omitted, no upper
  bound is applied to the search domain. Obviously, if both `LowerBound`
  and `UpperBound` are provided, the value in `LowerBound` should be
  less than the value in `UpperBound`.

[^1]: FlochKennedy shows unstable results and is considered
    experimental. More work is needed.
