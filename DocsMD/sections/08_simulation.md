## Simulation: `simulation.xml`

This file determines the behaviour of the risk factor simulation
(scenario generation) module. It is structured in three blocks of data.

<div class="listing">

``` xml
<Simulation>
  <Parameters> ... </Parameters>
  <CrossAssetModel> ... </CrossAssetModel>
  <Market> ... </Market>
</Simulation>
```

</div>

Each of the three blocks is sketched in the following.

### Parameters

Let us discuss this section using the following example

<div class="listing">

``` xml
<Parameters>
  <Grid>80,3M</Grid>
  <TimeStepsPerYear>24</TimeStepsPerYear>
  <Calendar>EUR,USD,GBP,CHF</Calendar>
  <DayCounter>ACT/ACT</DayCounter>
  <Sequence>SobolBrownianBridge</Sequence>
  <Seed>42</Seed>
  <Samples>1000</Samples>
  <Ordering>Steps</Ordering>
  <DirectionIntegers>JoeKuoD7</DirectionIntegers>
  <!-- The following two nodes are optional -->
  <CloseOutLag>2W</CloseOutLag>
  <MporMode>StickyDate</MporMode>
</Parameters>
```

</div>

- `Grid:` Specifies the simulation time grid, here 80 quarterly
  steps.[^1]

- `TimeStepsPerYear`: Minimum number of time steps per year to be used
  to evolve the stochastic process. This is useful if Euler
  discretization with a coarse Grid is used. Optional, defaults to null
  which means only the points specified under Grid are used to evolve
  the stochastic process.

- `Calendar:` Calendar or combination of calendars used to adjust the
  dates of the grid. Date adjustment is required because the simulation
  must step over ‘good’ dates on which index fixings can be stored.

- `DayCounter:` Day count convention used to translate dates to times.
  Optional, defaults to ActualActual ISDA. item `Sequence:` Choose
  random sequence generator (*MersenneTwister,
  MersenneTwisterAntithetic, Sobol, Burley2020Sobol,
  SobolBrownianBridge, Burley2020SobolBrownianBridge*).

- `Seed:` Random number generator seed

- `Samples:` Number of Monte Carlo paths to be produced use (*Backward,
  Forward, BestOfForwardBackward, InterpolatedForwardBackward*), which
  number of forward horizon days to use if one of the *Forward* related
  methods is chosen.

- `Ordering:` If the sequence type *SobolBrownianBridge* or
  *Burley2020SobolBrownianBridge* is used, ordering of variates
  (*Factors, Steps, Diagonal*)

- `DirectionIntegers:` If the sequence type *SobolBrownianBridge*,
  *Burley2020SobolBrownianBridge*, *Sobol* or *Burley2020Sobol* is used,
  type of direction integers in Sobol generator (*Unit, Jaeckel,
  SobolLevitan, SobolLevitanLemieux, JoeKuoD5, JoeKuoD6, JoeKuoD7, Kuo,
  Kuo2, Kuo3*)

- `CloseOutLag`: If this tag is present, this specifies the close-out
  period length (e.g. 2W) used; otherwise no close-out grid is built.
  The close-out grid is an auxiliary time grid that is offset from the
  main default date grid by the close-out period, typically set to the
  applicable margin period of risk. If present, it is used to evolve the
  portfolio value and determine close-out values associated with the
  preceding default date valuation.

- `MporMode`: This tag is expected if the previous one is present,
  permissible values are then `StickyDate` and `ActualDate`.
  `StickyDate` means that only market data is evolved from the default
  date to close-out date for close-out date valuation, the valuation as
  of date remains unchanged and trades do not “age” over the period. As
  a consequence, exposure evolutions will not show spikes caused by cash
  flows within the close-out period. `ActualDate` means that trades will
  also age over the close-out period so that one can experience exposure
  evolution spikes due to cash flows.

### Model

The `CrossAssetModel` section determines the cross asset model’s number
of currencies covered, composition, and each component’s calibration. It
is currently made of

- a sequence of LGM models for each currency (say $n_c$ currencies),

- $n_c-1$ FX models for each exchange rate to the base currency,

- $n_e$ equity models,

- $n_i$ inflation models,

- $n_{cr}$ credit models,

- $n_{com}$ commodity models,

- a specification of the correlation structure between all components.

The simulated currencies are specified as follows, with clearly
identifying the domestic currency which is also the target currency for
all FX models listed subsequently. If the portfolio requires more
currencies to be simulated, this will lead to an exception at run time,
so that it is the user’s responsibility to make sure that the list of
currencies here is sufficient. The list can be larger than actually
required by the portfolio. This will not lead to any exceptions, but add
to the run time of ORE.

When defining the currencies in the cross asset model, the domestic
currency always has to be given as the first currency.

<div class="listing">

``` xml
<CrossAssetModel>
  <DomesticCcy>EUR</DomesticCcy>
  <Currencies>
    <Currency>EUR</Currency>
    <Currency>USD</Currency>
    <Currency>GBP</Currency>
    <Currency>CHF</Currency>
    <Currency>JPY</Currency>
  </Currencies>
  <Equities>
    <!-- ... -->
  </Equities>
  <InflationIndices>
    <!-- ... -->
  </InflationIndices>
  <CreditNames>
    <!-- ... -->
  </CreditNames>
  <Commodities>
    <!-- ... -->
  </Commodities>
  <BootstrapTolerance>0.0001</BootstrapTolerance>
  <Measure>LGM</Measure><!-- Choices: LGM, BA -->
  <Discretization>Exact</Discretization>
  <SalvagingAlgorithm>Spectral</SalvagingAlgorithm>
  <!-- ... -->
</CrossAssetModel>
```

</div>

Bootstrap tolerance is a global parameter that applies to the
calibration of all model components. If the calibration error of any
component exceeds this tolerance, this will trigger an exception at
runtime, early in the ORE process.

The Measure tag allows switching between the LGM and the Bank Account
(BA) measure for the risk-neutral market simulations using the Cross
Asset Model. Note that within LGM one can shift the horizon (see
ParameterTransformation below) to effectively switch to a T-Forward
measure.

The Discretization tag chooses between time discretization schemes for
the risk factor evolution. *Exact* means exploiting the analytical
tractability of the model to avoid any time discretization error.
*Euler* uses a naive time discretization scheme which has numerical
error and requires small time steps for accurate results (useful for
testing purposes or if more sophisticated component models are used). If
*Euler* is used, you should consider setting TimeStepsPerYear (see
above) to a large enough value.

The SalvagingAlgorithm tag specifies the preprocessing of the input
correlation matrix (None, Spectral, Hypersphere, LowerDiagonal, Higham).
Optional, defaults to None.

Each interest rate model is specified by a block as follows

<div class="listing">

``` xml
<CrossAssetModel>
  <!-- ... -->
  <InterestRateModels>
    <LGM ccy="default">
      <CalibrationType>Bootstrap</CalibrationType>
      <Volatility>
        <Calibrate>Y</Calibrate>
        <VolatilityType>Hagan</VolatilityType>
        <ParamType>Piecewise</ParamType>
        <TimeGrid>1.0,2.0,3.0,4.0,5.0,7.0,10.0</TimeGrid>
        <InitialValue>0.01,0.01,0.01,0.01,0.01,0.01,0.01,0.01<InitialValue>
      </Volatility>
      <Reversion>
        <Calibrate>N</Calibrate>
        <ReversionType>HullWhite</ReversionType>
        <ParamType>Constant</ParamType>
        <TimeGrid/>
        <InitialValue>0.03</InitialValue>
      </Reversion>
      <CalibrationSwaptions>
        <Expiries>1Y,2Y,4Y,6Y,8Y,10Y,12Y,14Y,16Y,18Y,19Y</Expiries>
        <Terms>19Y,18Y,16Y,14Y,12Y,10Y,8Y,6Y,4Y,2Y,1Y</Terms>
        <Strikes/>
      </CalibrationSwaptions>
      <ParameterTransformation>
        <ShiftHorizon>0.0</ShiftHorizon>
        <Scaling>1.0</Scaling>
      </ParameterTransformation>
      <FloatSpreadMapping>proRata</FloatSpreadMapping>
    </LGM>
    <LGM ccy="EUR">
      <!-- ... -->
    </LGM>
    <LGM ccy="USD">
      <!-- ... -->
    </LGM>
  </InterestRateModels>
  <!-- ... -->
</CrossAssetModel>
```

</div>

We have LGM sections by currency, but starting with a section for
currency ’default’. As the name implies, this is used as default
configuration for any currency in the currency list for which we do not
provide an explicit parametrisation. Within each LGM section, the
interpretation of elements is as follows:

- `CalibrationType: ` Choose between *Bootstrap* and *BestFit*, where
  Bootstrap is chosen when we expect to be able to achieve a perfect fit
  (as with calibration of piecewise volatility to a series of
  co-terminal Swaptions)

- `Volatility/Calibrate: ` Flag to enable/disable calibration of this
  particular parameter

- `Volatility/VolatilityType: ` Choose volatility parametrisation a la
  *HullWhite* or *Hagan*

- `Volatility/ParamType: ` Choose between *Constant* and *Piecewise*

- `Volatility/TimeGrid: ` Initial time grid for this parameter, can be
  left empty if ParamType is Constant

- `Volatility/InitialValue: ` Vector of initial values, matching number
  of entries in time (for CalibrationType *BestFit* this should be one
  more entry than the `Volatility/TimeGrid` entries, for *Bootstrap*
  this is ignored), or single value if the time grid is empty

- `Reversion/Calibrate: ` Flag to enable/disable calibration of this
  particular parameter

- `Reversion/VolatilityType: ` Choose reversion parametrisation a la
  *HullWhite* or *Hagan*

- `Reversion/ParamType: ` Choose between *Constant* and *Piecewise*

- `Reversion/TimeGrid: ` Initial time grid for this parameter, can be
  left empty if ParamType is Constant

- `Reversion/InitialValue: ` Vector of initial values, matching number
  of entries in time, or single value if the time grid is empty

- `CalibrationSwaptions: ` Choice of calibration instruments by expiry,
  underlying Swap term and strike. There have to be at least one more
  calibration options configured than `Volatility/TimeGrid` entries were
  given.

- `ParameterTransformation: ` LGM model prices are invariant under
  scaling and shift transformations with advantages for numerical
  convergence of results in long term simulations. These transformations
  can be chosen here. Default settings are shiftHorizon 0 (time in
  years) and scaling factor 1.

- `FloatSpreadMapping: ` mapping of float spreads in analytic swaption
  pricing for model calibration: proRata, nextCoupon, simple, optional,
  defaults to proRata.

The reason for having to specify one more `Volatility/InitialValue`
entries than `Volatility/TimeGrid` entries (and at least one more
calibration option than `Volatility/TimeGrid` entries) is the fact that
the intervals defined by the `Volatility/TimeGrid` entries are spanning
from $[0,t_1],[t_1,t_2]\ldots[t_n,\infty]$, which results in $n+1$
intervals.

Each FX model is specified by a block as follows

<div class="listing">

``` xml
<CrossAssetModel>
  <!-- ... -->
  <ForeignExchangeModels>
    <CrossCcyLGM foreignCcy="default">
      <DomesticCcy>EUR</DomesticCcy>
      <CalibrationType>Bootstrap</CalibrationType>
      <Sigma>
        <Calibrate>Y</Calibrate>
        <ParamType>Piecewise</ParamType>
        <TimeGrid>1.0,2.0,3.0,4.0,5.0,7.0,10.0</TimeGrid>
        <InitialValue>0.1,0.1,0.1,0.1,0.1,0.1,0.1,0.1</InitialValue>
      </Sigma>
      <CalibrationOptions>
        <Expiries>1Y,2Y,3Y,4Y,5Y,10Y</Expiries>
        <Strikes/>
      </CalibrationOptions>
    </CrossCcyLGM>
    <CrossCcyLGM foreignCcy="USD">
      <!-- ... -->
    </CrossCcyLGM>
    <CrossCcyLGM foreignCcy="GBP">
      <!-- ... -->
    </CrossCcyLGM>
    <!-- ... -->
  </ForeignExchangeModels>
  <!-- ... -->
<CrossAssetModel>
```

</div>

CrossCcyLGM sections are defined by foreign currency, but we also
support a default configuration as above for the IR model
parametrisations. Within each CrossCcyLGM section, the interpretation of
elements is as follows:

- `DomesticCcy: ` Domestic currency completing the FX pair

- `CalibrationType: ` Choose between *Bootstrap* and *BestFit* as in the
  IR section

- `Sigma/Calibrate: ` Flag to enable/disable calibration of this
  particular parameter

- `Sigma/ParamType: ` Choose between *Constant* and *Piecewise*

- `Sigma/TimeGrid: ` Initial time grid for this parameter, can be left
  empty if ParamType is Constant

- `Sigma/InitialValue: ` Vector of initial values, matching number of
  entries in time (for CalibrationType *BestFit* this should be one more
  entry than the `Sigma/TimeGrid` entries, for *Bootstrap* this is
  ignored), or single value if the time grid is empty

- `CalibrationOptions: ` Choice of calibration instruments by expiry and
  strike, strikes can be empty (implying the default, ATMF options), or
  explicitly specified (in terms of FX rates as absolute strike values,
  in delta notation such as $\pm 25D$, $ATMF$ for at the money). There
  have to be at least one more calibration options configured than
  `Sigma/TimeGrid` entries were given

Each equity model is specified by a block as follows

<div class="listing">

``` xml
<CrossAssetModel>
  <!-- ... -->
  <EquityModels>
    <CrossAssetLGM name="default">
      <Currency>EUR</Currency>
      <CalibrationType>Bootstrap</CalibrationType>
      <Sigma>
        <Calibrate>Y</Calibrate>
        <ParamType>Piecewise</ParamType>
        <TimeGrid>1.0,2.0,3.0,4.0,5.0,7.0,10.0</TimeGrid>
        <InitialValue>0.1,0.1,0.1,0.1,0.1,0.1,0.1,0.1</InitialValue>
      </Sigma>
      <CalibrationOptions>
        <Expiries>1Y,2Y,3Y,4Y,5Y,10Y</Expiries>
        <Strikes/>
      </CalibrationOptions>
    </CrossAssetLGM>
    <CrossAssetLGM name="SP5">
      <!-- ... -->
    </CrossAssetLGM>
    <CrossAssetLGM name="Lufthansa">
      <!-- ... -->
    </CrossAssetLGM>
      <!-- ... -->
  </EquityModels>
  <!-- ... -->
<CrossAssetModel>
```

</div>

CrossAssetLGM sections are defined by equity name, but we also support a
default configuration as above for the IR and FX model
parameterisations. Within each CrossAssetLGM section, the interpretation
of elements is as follows:

- `Currency: ` Currency of denomination

- `CalibrationType: ` Choose between *Bootstrap* and *BestFit* as in the
  IR section

- `Sigma/Calibrate: ` Flag to enable/disable calibration of this
  particular parameter

- `Sigma/ParamType: ` Choose between *Constant* and *Piecewise*

- `Sigma/TimeGrid: ` Initial time grid for this parameter, can be left
  empty if ParamType is Constant

- `Sigma/InitialValue: ` Vector of initial values, matching number of
  entries in time (for CalibrationType *BestFit* this should be one more
  entry than the `Sigma/TimeGrid` entries, for *Bootstrap* this is
  ignored), or single value if the time grid is empty

- `CalibrationOptions: ` Choice of calibration instruments by expiry and
  strike, strikes can be empty (implying the default, ATMF options), or
  explicitly specified (in terms of equity prices as absolute strike
  values). There have to be at least one more calibration options
  configured than `Sigma/TimeGrid` entries were given

For the inflation model component, there is a choice between a Dodgson
Kainth model and a Jarrow Yildrim model. The Dodgson Kainth model is
specified in a `LGM` or `DodgsonKainth` node as outlined in Listing
<a href="#lst:simulation_model_dk_inflation_configuration"
data-reference-type="ref"
data-reference="lst:simulation_model_dk_inflation_configuration">[lst:simulation_model_dk_inflation_configuration]</a>.
The inflation model parameterisation inherits from the LGM
parameterisation for interest rate components, in particular the
`CalibrationType`, `Volatility` and `Reversion` elements. The
`CalibrationCapFloors` element specify the model’s calibration to a
selection of either CPI caps or CPI floors with specified strike.

<div class="listing">

``` xml
<CrossAssetModel>
  ...
  <InflationIndexModels>
    <LGM index="EUHICPXT">
      <Currency>EUR</Currency>
      <!-- As in the LGM parameterisation for any IR components -->
      <CalibrationType> ... </CalibrationType>
      <Volatility> ... </Volatility>
      <Reversion> ... </Reversion>
      <ParameterTransformation> ... </ParameterTransformation>
      <!-- Inflation model specific -->
      <CalibrationCapFloors>
        <!-- not used yet, as there is only one strategy so far -->
        <CalibrationStrategy> ... </CalibrationStrategy>
        <CapFloor> Floor </CapFloor> <!-- Cap, Floor -->
        <Expiries> 2Y, 4Y, 6Y, 8Y, 10Y </Expiries>
        <!-- can be empty, this will yield calibration to ATM -->
        <Strikes> 0.03, 0.03, 0.03, 0.03, 0.03 </Strikes>
      </CalibrationCapFloors>
    </LGM>
    <LGM index="USCPI">
      ...
    </LGM>
    ...
  </InflationIndexModels>
  ...
<CrossAssetModel>
```

</div>

The calibration instruments may be specified in an alternative way via a
`CalibrationBaskets` node. In general, a `CalibrationBaskets` node can
contain multiple `CalibrationBasket` nodes each containing a list of
calibration instruments of the same type. For Dodgson Kainth, only a
single calibration basket is allowed and the instruments must be of type
`CpiCapFloor`. So, for example, the `CalibrationCapFloors` node in
Listing <a href="#lst:simulation_model_dk_inflation_configuration"
data-reference-type="ref"
data-reference="lst:simulation_model_dk_inflation_configuration">[lst:simulation_model_dk_inflation_configuration]</a>
could be replaced with the `CalibrationBaskets` node in
<a href="#lst:dk_inflation_calibration_basket" data-reference-type="ref"
data-reference="lst:dk_inflation_calibration_basket">[lst:dk_inflation_calibration_basket]</a>.

<div class="listing">

``` xml
<CalibrationBaskets>
  <CalibrationBasket>
    <CpiCapFloor>
      <Type>Floor</Type>
      <Maturity>2Y</Maturity>
      <Strike>0.03</Strike>
    </CpiCapFloor>
    <CpiCapFloor>
      <Type>Floor</Type>
      <Maturity>4Y</Maturity>
      <Strike>0.03</Strike>
    </CpiCapFloor>
    <CpiCapFloor>
      <Type>Floor</Type>
      <Maturity>6Y</Maturity>
      <Strike>0.03</Strike>
    </CpiCapFloor>
    <CpiCapFloor>
      <Type>Floor</Type>
      <Maturity>8Y</Maturity>
      <Strike>0.03</Strike>
    </CpiCapFloor>
    <CpiCapFloor>
      <Type>Floor</Type>
      <Maturity>10Y</Maturity>
      <Strike>0.03</Strike>
    </CpiCapFloor>
  </CalibrationBasket>
</CalibrationBaskets>
```

</div>

The Jarrow Yildrim model is specified in a `JarrowYildirim` node as
outlined in Listing
<a href="#lst:simulation_model_jy_inflation_configuration"
data-reference-type="ref"
data-reference="lst:simulation_model_jy_inflation_configuration">[lst:simulation_model_jy_inflation_configuration]</a>.
The `RealRate` node describes the JY real rate process and has
`Volatility` and `Reversion` nodes that follow those outlined in the
interest rate LGM section above. The `Index` node describes the JY index
process and has a `Volatility` component that follows the `Sigma`
component of the FX model above. The `CalibrationBaskets` node is as
outlined above for Dodgson Kainth but up to two baskets may be used and
extra inflation instruments are supported in the calibration. More
information is provided below.

The `CalibrationType` determines the calibration approach, if any, that
is used to calibrate the various parameters of the model i.e. the real
rate reversion, the real rate volatility and the index volatility. If
the `CalibrationType` is `None`, no calibration is attempted and all
parameter values must be explicitly specified. If the `CalibrationType`
is `BestFit`, the parameters that have `Calibrate` set to `Y` will be
calibrated to the instruments specified in the `CalibrationBaskets`
node. If the `CalibrationType` is `Bootstrap`, there are a number of
options:

1.  The index volatility parameter may be calibrated, indicated by
    setting `Calibrate` to `Y` for that parameter, with both of the real
    rate parameters not calibrated and set explicitly in the `RealRate`
    node. There should be exactly one `CalibrationBasket` in the
    `CalibrationBaskets` node and its `parameter` attribute may be set
    to `Index` or omitted.

2.  One of the real rate parameters may be calibrated, indicated by
    setting `Calibrate` to `Y` for that parameter, with the index
    volatility not calibrated and set explicitly in the `Volatility`
    node. There should be exactly one `CalibrationBasket` in the
    `CalibrationBaskets` node and its `parameter` attribute may be set
    to `RealRate` or omitted.

3.  One of the real rate parameters and the index volatility parameter
    may be calibrated together. There should be exactly two
    `CalibrationBasket` nodes in the `CalibrationBaskets` node. The
    `parameter` attribute should be set to `RealRate` on the
    `CalibrationBasket` node that should be used for the real rate
    parameter calibration. Similarly, the `parameter` attribute should
    be set to `Index` on the `CalibrationBasket` node that should be
    used for the index volatility parameter calibration. The parameters
    are calibrated iteratively in turn until the root mean squared error
    over all calibration instruments in the two baskets is below the
    tolerance specified by the `RmseTolerance` in the
    `CalibrationConfiguration` node or until the maximum number of
    iterations as specified by the `MaxIterations` in the
    `CalibrationConfiguration` node has been reached. The
    `CalibrationConfiguration` node is optional. If it is omitted, the
    `RmseTolerance` defaults to 0.0001 and the `MaxIterations` defaults
    to 50.

Note that it is an error to attempt to calibrate both of the real rate
parameters together when `CalibrationType` is `Bootstrap`. If a
parameter is being calibrated with `CalibrationType` set to `Bootstrap`,
the `ParamType` should be `Piecewise`. The `TimeGrid` will be overridden
for that parameter by the relevant calibration instrument times and the
parameter’s initial values are set to the first element of the
`InitialValue` list. So, leaving the `TimeGrid` node empty and giving a
single value in the `InitialValue` node is the clearest XML setup in
this case.

<div class="listing">

``` xml
<JarrowYildirim index="EUHICPXT">
  <Currency>EUR</Currency>
  <CalibrationType>Bootstrap</CalibrationType>
  <RealRate>
    <Volatility>
      <Calibrate>Y</Calibrate>
      <VolatilityType>Hagan</VolatilityType>
      <ParamType>Piecewise</ParamType>
      <TimeGrid/>
      <InitialValue>0.0001</InitialValue>
    </Volatility>
    <Reversion>
      <Calibrate>N</Calibrate>
      <ReversionType>HullWhite</ReversionType>
      <ParamType>Constant</ParamType>
      <TimeGrid/>
      <InitialValue>0.5</InitialValue>
    </Reversion>
    <ParameterTransformation>
      <ShiftHorizon>0.0</ShiftHorizon>
      <Scaling>1.0</Scaling>
    </ParameterTransformation>
  </RealRate>
  <Index>
    <Volatility>
      <Calibrate>Y</Calibrate>
      <ParamType>Piecewise</ParamType>
      <TimeGrid/>
      <InitialValue>0.0001</InitialValue>
    </Volatility>
  </Index>
  <CalibrationBaskets>
    <CalibrationBasket parameter="Index">
      <CpiCapFloor>
        <Type>Floor</Type>
        <Maturity>2Y</Maturity>
        <Strike>0.0</Strike>
      </CpiCapFloor>
      ...
    </CalibrationBasket>
    <CalibrationBasket parameter="RealRate">
      <YoYSwap>
        <Tenor>2Y</Tenor>
      </YoYSwap>
      ...
    </CalibrationBasket>
  </CalibrationBaskets>
  <CalibrationConfiguration>
    <RmseTolerance>0.00000001</RmseTolerance>
    <MaxIterations>40</MaxIterations>
  </CalibrationConfiguration>
</JarrowYildirim>
```

</div>

The `CpiCapFloor` and `YoYSwap` calibration instruments can be seen in
Listing <a href="#lst:simulation_model_jy_inflation_configuration"
data-reference-type="ref"
data-reference="lst:simulation_model_jy_inflation_configuration">[lst:simulation_model_jy_inflation_configuration]</a>.
A `YoYCapFloor` is also allowed and it has the structure shown in
Listing <a href="#lst:yoy_cf_calibration_inst" data-reference-type="ref"
data-reference="lst:yoy_cf_calibration_inst">[lst:yoy_cf_calibration_inst]</a>.
The `Type` may be `Cap` or `Floor`. The `Tenor` should be a maturity
period e.g. `5Y`. The `Strike` should be an absolute strike level for
the year on year cap or floor e.g. `0.01` for 1%.

<div class="listing">

``` xml
<YoYCapFloor>
  <Type>...</Type>
  <Tenor>...</Tenor>
  <Strike>...</Strike>
</YoYCapFloor>
```

</div>

For commodity simulation we currently provide one model, as described in
the methodology appendix. Commodity model components are specified by
commodity name, by a block as follows

<div class="listing">

``` xml
<CrossAssetModel>
  <!-- ... -->
  <CommodityModels>
    <CommoditySchwartz name="default">
      <Currency>EUR</Currency>
      <CalibrationType>None</CalibrationType>
      <Sigma>
        <Calibrate>Y</Calibrate>
        <InitialValue>0.1</InitialValue>
      </Sigma>
      <Kappa>
        <Calibrate>Y</Calibrate>
        <InitialValue>0.1</InitialValue>
      </Kappa>
      <CalibrationOptions>
           ...
      </CalibrationOptions>
      <DriftFreeState>false</DriftFreeState>
    </CommoditySchwartz>
    <CommoditySchwartz name="WTI">
      <!-- ... -->
    </CommoditySchwartz>
    <CommoditySchwartz name="NG">
      <!-- ... -->
    </CommoditySchwartz>
      <!-- ... -->
  </CommodityModels>
  <!-- ... -->
<CrossAssetModel>
```

</div>

CommoditySchwartz sections are defined by commodity name, but we also
support a default configuration as above for the IR and FX model
parameterisations. Each component is parameterised in terms of two
constant, non time-dependent parameters $\sigma$ and $\kappa$ so far
(see appendix). Within each CommoditySchwartz section, the
interpretation of elements is as follows:

- `Currency: ` Currency of denomination

- `CalibrationType:` Choose between *BestFit*, *Bootstrap*,
  *FirstBestFitThanBootstrap* and *None*. The choice *None* will
  deactivate calibration as usual. *BestFit* will attempt to set the
  model parameter(s) such that the error in matching calibration
  instrument prices is minimised. The option *Bootstrap* will
  iteratively attempt to calibrate the time dependent seasonality factor
  to the calibration instrument prices. The option
  *FirstBestFitThanBootstrap* will first attempt to fit the model
  parameters (kappa and sigma) as in *BestFit* option. Then, time
  dependent seasonality parameter is bootstrapped as in *Bootstrap*
  option.

- `Sigma/Calibrate:` Flag to enable/disable calibration of this
  particular parameter

- `Sigma/InitialValue:` Initial value of the constant parameter

- `Kappa/Calibrate:` Flag to enable/disable calibration of this
  particular parameter

- `Kappa/InitialValue:` Initial value of the constant parameter

- `Seasonality/Calibrate:` Flag to enable/disable calibration of this
  particular parameter

- `Seasonality/ParamType:` Initial time grid for this parameter, can be
  left empty if ParamType is Constant

- `Seasonality/TimeGrid:` Initial time grid for this parameter. If
  ParamType is Constant, there should be a single entry

- `Seasonality/InitialValue:` Vector of initial values. Size of the
  vector should be identical to the size of TimeGrid vector. For
  *Bootstrap* this is ignored. If ParamType is Constant, there should be
  a single entry

- `CalibrationOptions:` Choice of calibration instruments by expiry and
  strike, strikes can be empty (implying the default, ATMF options), or
  explicitly specified (in terms of commodity prices as absolute strike
  values).

- `DriftFreeState[Optional]:` Boolean to switch between the two
  implementations of the state variable, see appendix. By default this
  is set to `false`.

Finally, the instantaneous correlation structure is specified as
follows.

<div class="listing">

``` xml
<CrossAssetModel>
  <!-- ... -->
  <InstantaneousCorrelations>
    <Correlation factor1="IR:EUR" factor2="IR:USD">0.3</Correlation>
    <Correlation factor1="IR:EUR" factor2="IR:GBP">0.3</Correlation>
    <Correlation factor1="IR:USD" factor2="IR:GBP">0.3</Correlation>
    <Correlation factor1="IR:EUR" factor2="FX:USDEUR">0</Correlation>
    <Correlation factor1="IR:EUR" factor2="FX:GBPEUR">0</Correlation>
    <Correlation factor1="IR:GBP" factor2="FX:USDEUR">0</Correlation>
    <Correlation factor1="IR:GBP" factor2="FX:GBPEUR">0</Correlation>
    <Correlation factor1="IR:USD" factor2="FX:USDEUR">0</Correlation>
    <Correlation factor1="IR:USD" factor2="FX:GBPEUR">0</Correlation>
    <Correlation factor1="FX:USDEUR" factor2="FX:GBPEUR">0</Correlation>
    <!-- ... -->
  </InstantaneousCorrelations>
</CrossAssetModel>
```

</div>

Any risk factor pair not specified explicitly here will be assumed to
have zero correlation. Note that the commodity components can have
non-zero correlations among each other, but correlations to all other
CAM components must remain set to zero for the time being.

### Market

The last part of the simulation configuration file covers the
specification of the simulated market. Note that the simulation model
will yield the evolution of risk factors such as short rates which need
to be translated into entire yield curves that can be ’understood’ by
the instruments which we want to price under scenarios.

The specified currencies need to contain at least the currencies both
defined above in the cross asset model and used in the portfolio, the
order however is not important.

Moreover we need to specify how volatility structures evolve even if we
do not explicitly simulate volatility. This translation happens based on
the information in the *simulation market* object, which is configured
in the section within the enclosing tags `<Market>` and `</Market>`, as
shown in the following small example.

It should be noted that equity volatilities are taken to be a curve by
default. To simulate an equity volatility surface with smile the xml
node `<Surface> ` must be supplied. There are two methods in ORE for
equity volatility simulation:

- Simulating ATM volatilities only (and shifting other strikes relative
  to this using the $T_{0}$ smile). In this case set `<SimulateATMOnly>`
  to true.

- Simulating the full volatility surface. The node `<SimulateATMOnly>`
  should be omitted or set to false, and explicit moneyness levels for
  simulation should be provided.

Commodity volatilities are taken as ATM slice by default. To simulate
commodity volatility surface with smile a set of `<Moneyness> ` must be
supplied. There are two methods in ORE for commodity volatility
simulation:

- Simulating ATM volatilities only (and shifting other strikes relative
  to this using the $T_{0}$ smile). In this case set `<SimulateATMOnly>`
  to true.

- Simulating the full volatility surface. The node `<SimulateATMOnly>`
  should be omitted or set to false, and explicit moneyness levels for
  simulation should be provided.

Swaption volatilities are taken to be a surface by default. There are
two methods in ORE for swaption volatility cube simulation:

- Simulating ATM volatilities only (and shifting other strikes relative
  to this using the $T_{0}$ smile). In this case set `<SimulateATMOnly>`
  to true and no surface node is given.

- Simulating the full volatility surface. The node `<SimulateATMOnly>`
  should be omitted or set to false, and explicit moneyness levels for
  simulation should be provided.

FX volatilities are taken to be a curve by default. To simulate an FX
volatility cube with smile the xml node `<Surface> ` must be supplied.
The surface node contains the moneyness levels to be simulated.

For Yield Curves, Swaption Volatilities, CapFloor Volatilities, Default
Curves, Base Correlations and Inflation Curves, a DayCounter may be
specified for each risk factor using the node
`<DayCounter name="EXAMPLE_CURVE">`. If no day counter is specified for
a given risk factor then the default Actual365 is used. To specify a new
default for a risk factor type then use the daycounter node without any
attribute, `<DayCounter>`.

For Yield Curves, there are several choices for the interpolation and
extrapolation:

- Interpolation: This can be LogLinear or LinearZero. If not given, the
  value defaults to LogLinear.

- Extrapolation: This can be FlatFwd or FlatZero. If not given, the
  value defaults to FlatFwd.

For Default Curve, there is a similar choice for the extrapolation:

- Extrapolation: This can be FlatFwd or FlatZero. If not given, the
  value defaults to FlatFwd.

For swaption, yield, interest rate cap-floor, yoy inflation cap-floor,
zc inflation cap-floor, cds, fx, equity, commodity volatilities the
smile dynamics can be specified as shown in listing
<a href="#lst:smile_dynamics_configuration" data-reference-type="ref"
data-reference="lst:smile_dynamics_configuration">[lst:smile_dynamics_configuration]</a>
for swaption vols. The empty key serves as a default configuration for
all keys for which no own smile dynamics node is present. The allowed
smile dynamics values are StickyStrike, StickyMoneyness and StickySABR.
If not given, the smile dynamics defaults to StickyStrike.

Note that StickySABR is only available for swaption volatilities, yield
volatilities and interest rate cap-floor volatilities, and can only be
used if the corresponding T0 surface has been calibrated using a SABR
model. The SABR volatility surface in the simulation market is
recalibrated to the expiry/term/strike grid specified in the simulation
configuration, using the initial SABR configuration from the T0 surface.
Any subsequent recalibration will keep all SABR parameters except for
$\alpha$ fixed.

<div class="listing">

``` xml
    <SmileDynamics key="">StickyStrike</SmileDynamics>
    <SmileDynamics key="EUR-ESTER">StickyMoneyness</SmileDynamics>
    <SmileDynamics key="USD-SOFR-3M">StickySABR</SmileDynamics>
```

</div>

We can specify a CurveAlgebra node as a subnode of Market to link curves
in the scenario sim market to other curves using predefined operations.
Listing
<a href="#lst:curve_algebra_configuration" data-reference-type="ref"
data-reference="lst:curve_algebra_configuration">[lst:curve_algebra_configuration]</a>
shows an example for a spread declaration, where the instantaneous
forward rate of the EUR discount curve is linked to both EURIBOR-1M and
3M index curves with multipliers $1$ and $-2$, respectively.

<div class="listing">

``` xml
    <CurveAlgebra>
      <Curve>
        <Key>DiscountCurve/EUR</Key>
        <Operation>
          <Type>Spreaded</Type>
          <Arguments>
            <Argument>IndexCurve/EUR-EURIBOR-1M,1</Argument>
            <Argument>IndexCurve/EUR-EURIBOR-3M,-2</Argument>
          </Arguments>
        </Operation>
      </Curve>
    </CurveAlgebra>
```

</div>

<div class="longlisting">

``` xml
<Market>
  <BaseCurrency>EUR</BaseCurrency>
  <Currencies>
    <Currency>EUR</Currency>
    <Currency>USD</Currency>
  </Currencies>
  <YieldCurves>
    <Configuration>
      <Tenors>3M,6M,1Y,2Y,3Y,4Y,5Y,7Y,10Y,12Y,15Y,20Y</Tenors>
      <Interpolation>LogLinear</Interpolation>
      <Extrapolation>FlatFwd</Extrapolation>
      <DayCounter>ACT/ACT</DayCounter> <!-- Sets a new default for all yieldCurves -->
    </Configuration>
  </YieldCurves>
  <Indices>
    <Index>EUR-EURIBOR-6M</Index>
    <Index>EUR-EURIBOR-3M</Index>
    <Index>EUR-EONIA</Index>
    <Index>USD-LIBOR-3M</Index>
  </Indices>
  <SwapIndices>
    <SwapIndex>
      <Name>EUR-CMS-1Y</Name>
      <ForwardingIndex>EUR-EURIBOR-6M</ForwardingIndex>
      <DiscountingIndex>EUR-EONIA</DiscountingIndex>
    </SwapIndex>
  </SwapIndices>
  <DefaultCurves>
      <Names>
        <Name>CPTY1</Name>
        <Name>CPTY2</Name>
      </Names>
      <Tenors>6M,1Y,2Y</Tenors>
      <SimulateSurvivalProbabilities>true</SimulateSurvivalProbabilities>
      <DayCounter name="CPTY1">ACT/ACT</DayCounter>
      <Extrapolation>FlatFwd</Extrapolation>
  </DefaultCurves>
  <SwaptionVolatilities>
    <ReactionToTimeDecay>ForwardVariance</ReactionToTimeDecay>
    <Currencies>
      <Currency>EUR</Currency>
      <Currency>USD</Currency>
    </Currencies>
    <Expiries>6M,1Y,2Y,3Y,5Y,10Y,12Y,15Y,20Y</Expiries>
    <Terms>1Y,2Y,3Y,4Y,5Y,7Y,10Y,15Y,20Y,30Y</Terms>
    <SimulateATMOnly>false</SimulateATMOnly>
    <StrikeSpreads>-0.02,-0.01,0.0,0.01,0.02</StrikeSpreads>
    <!-- Sets a new daycounter for just the EUR swaptionVolatility surface -->
    <DayCounter ccy="EUR">ACT/ACT</DayCounter>
  </SwaptionVolatilities>
  <CapFloorVolatilities>
    <ReactionToTimeDecay>ConstantVariance</ReactionToTimeDecay>
    <Currencies>
      <Currency>EUR</Currency>
      <Currency>USD</Currency>
    </Currencies>
    <DayCounter ccy="EUR">ACT/ACT</DayCounter>
  </CapFloorVolatilities>
  <FxVolatilities>
    <ReactionToTimeDecay>ForwardVariance</ReactionToTimeDecay>
    <CurrencyPairs>
      <CurrencyPair>EURUSD</CurrencyPair>
    </CurrencyPairs>
    <Expiries>6M,1Y,2Y,3Y,4Y,5Y,7Y,10Y</Expiries>
    <Surface>
     <Moneyness>0.5,0.6,0.7,0.8,0.9</Moneyness>
    </Surface>
  </FxVolatilities>
  <EquityVolatilities>
      <Simulate>true</Simulate>
      <ReactionToTimeDecay>ForwardVariance</ReactionToTimeDecay>
      <!-- Alternative: ConstantVariance -->
      <Names>
        <Name>SP5</Name>
        <Name>Lufthansa</Name>
      </Names>
      <Expiries>6M,1Y,2Y,3Y,4Y,5Y,7Y,10Y</Expiries>
      <Surface>
        <Moneyness>0.1,0.5,1.0,1.5,2.0,3.0</Moneyness>
      </Surface>
      <TimeExtrapolation>Flat</TimeExtrapolation>
      <StrikeExtrapolation>Flat</StrikeExtrapolation>
  </EquityVolatilities>
  ...
  <BenchmarkCurves>
    <BenchmarkCurve>
      <Currency>EUR</Currency>
      <Name>BENCHMARK_EUR</Name>
  </BenchmarkCurve>
  ...
  </BenchmarkCurves>
  <Securities>
    <Simulate>true</Simulate>
    <Names>
      <Name>SECURITY_1</Name>
      ...
    </Names>
  </Securities>
  <ZeroInflationIndexCurves>
    <Names>
      <Name>EUHICP</Name>
      <Name>UKRPI</Name>
      <Name>USCPI</Name>
      ...
    </Names>
    <Tenors>6M,1Y,2Y,3Y,5Y,7Y,10Y,15Y,20Y</Tenors>
  </ZeroInflationIndexCurves>
  <YYInflationIndexCurves>
    <Names>
      <Name>EUHICPXT</Name>
      ...
    </Names>
    <Tenors>1Y,2Y,3Y,5Y,7Y,10Y,15Y,20Y</Tenors>
  </YYInflationIndexCurves>
  <DefaultCurves>
    <Names>
      <Name>ItraxxEuropeCrossoverS26V1</Name>
      ...
    </Names>
    <Tenors>1Y,2Y,3Y,5Y,10Y</Tenors>
    <SimulateSurvivalProbabilities>true</SimulateSurvivalProbabilities>
  </DefaultCurves>
  <BaseCorrelations/>
  <CDSVolatilities/>
  <Correlations>
    <Simulate>true</Simulate>
    <Pairs>
      <Pair>EUR-CMS-10Y,EUR-CMS-2Y</Pair>
    </Pairs>
    <Expiries>1Y,2Y</Expiries>
  </Correlations>
  <AggregationScenarioDataCurrencies>
    <Currency>EUR</Currency>
    <Currency>USD</Currency>
  </AggregationScenarioDataCurrencies>
  <AggregationScenarioDataIndices>
    <Index>EUR-EURIBOR-3M</Index>
    <Index>EUR-EONIA</Index>
    <Index>USD-LIBOR-3M</Index>
  </AggregationScenarioDataIndices>
</Market>
```

</div>

[^1]: For exposure calculation under DIM, the second parameter has to
    match the Margin Period of Risk, i.e. if `MarginPeriodOfRisk` is set
    to for instance `2W` in a netting set definition in `netting.xml`,
    then one has to set `Grid` to for instance `80,2W`.
