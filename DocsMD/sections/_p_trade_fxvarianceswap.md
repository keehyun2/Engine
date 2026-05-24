### FX Variance and Volatility Swap

The `FxVarianceSwapData` node is the trade data container for the
*FxVarianceSwap* trade type. Only vanilla variance swaps are supported
by this trade type - exotic variance swaps are supported by
ScriptedTrade, see
<a href="#SubSectionExoticVarianceSwap" data-reference-type="ref"
data-reference="SubSectionExoticVarianceSwap">[SubSectionExoticVarianceSwap]</a>.
. The structure of an example `VarianceSwapData` node for an FX variance
swap is shown in Listing
<a href="#lst:fxvarswap_data" data-reference-type="ref"
data-reference="lst:fxvarswap_data">[lst:fxvarswap_data]</a>.

<div class="listing">

``` xml
<FxVarianceSwapData>
        <StartDate>2018-05-10</StartDate>
        <EndDate>2018-11-12</EndDate>
        <Currency>EUR</Currency>
        <Underlying>
          <Type>FX</Type>
          <Name>ECB-EUR-JPY</Name>
        </Underlying>
        <LongShort>Long</LongShort>
        <Strike>0.05</Strike>
        <Notional>200000</Notional>
        <Calendar>EUR</Calendar>
        <MomentType>Variance</MomentType>
</FxVarianceSwapData>
```

</div>

The meanings and allowable values of the elements in the
`FxVarianceSwapData` node below.

- StartDate: The variance swap start date.  
  Allowable values: See `Date` in Table
  <a href="#tab:allow_stand_data" data-reference-type="ref"
  data-reference="tab:allow_stand_data">[tab:allow_stand_data]</a>.

- EndDate: The variance swap end date.  
  Allowable values: See `Date` in Table
  <a href="#tab:allow_stand_data" data-reference-type="ref"
  data-reference="tab:allow_stand_data">[tab:allow_stand_data]</a>.

- Currency: The bought currency of the variance swap.  
  Allowable values: See Table
  <a href="#tab:currency" data-reference-type="ref"
  data-reference="tab:currency">[tab:currency]</a> `Currency`.

- Name: The identifier of the underlying currency pair.  
  Allowable values: A string of the form SOURCE-CCY1-CCY2, where SOURCE
  is the fixing source and the fixing is expressed as amount in CCY2 per
  one unit of CCY1.  
  See Table <a href="#tab:fxindex_data" data-reference-type="ref"
  data-reference="tab:fxindex_data">[tab:fxindex_data]</a>. Note that
  FxVarianceSwap is an exception in that the ordering of CCY1 and CCY2
  must be set up as for `FxIndex`.

- Underlying: This node may be used as an alternative to the `Name` node
  to specify the underlying FX. The `Underlying` node is described in
  further detail in Section
  <a href="#ss:underlying" data-reference-type="ref"
  data-reference="ss:underlying">[ss:underlying]</a>.  

- LongShort: Defines whether the trade is long in the FX variance. For
  the avoidance of doubt, a long FX swap has positive value if the
  realised variance exceeds the variance strike.  
  Allowable values: *Long, Short*

- Strike: The volatility strike $K_{vol}$ of the variance swap quoted
  absolutely (i.e. not as a percent). If the swap was struck in terms of
  variance, the square root of that variance should be used here.  
  Allowable values: Any positive real number.

- Notional: The vega notional of the variance swap. This is the notional
  in terms of volatility units (like the strike). If the swap was struck
  in terms of a variance notional $N_{var}$, the corresponding vega
  notional is given by $N_{vol} = N_{var} * 2 * 100 * K_{vol}$ (where
  $K_{vol}$ is in absolute terms).  
  Allowable values: Any non-negative real number.

- Calendar: The calendar determining the observation/fixing dates
  according to which variance is accrued is the combination of the
  calendar(s) given here plus the combined calendars of the two involved
  currencies.  
  Allowable values: See Table
  <a href="#tab:calendar" data-reference-type="ref"
  data-reference="tab:calendar">[tab:calendar]</a>.

- MomentType\[Optional\]: A flag to distinguish if the swap is struck in
  terms of volatility or variance. The MomentType should be set to
  *Volatility* or *Variance* depending on the payoff. Note that
  MomentType does not necessarily need to be equivalent to the way the
  Strike is quoted which is always as a Volatility.  
  Allowable values: *Volatility* or *Variance*. Defaults to *Variance*
  if left blank or omitted.

Note that FX Variance and Volatility Swaps also cover Precious Metals,
i.e. with currencies XAU, XAG, XPT, XPD, and Cryptocurrencies, see
supported Cryptocurrencies in Table
<a href="#tab:currency" data-reference-type="ref"
data-reference="tab:currency">[tab:currency]</a>.
