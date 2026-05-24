### Equity Variance Swap

The `EqutiyVarianceSwapData` node is the trade data container for the
*EquityVarianceSwap* trade type. Only vanilla variance swaps are
supported. The structure of an example `EqutiyVarianceSwapData` node for
an equity variance swap is shown in Listing
<a href="#lst:varswap_data" data-reference-type="ref"
data-reference="lst:varswap_data">[lst:varswap_data]</a>.

<div class="listing">

``` xml
<EquityVarianceSwapData>
    <StartDate>2016-01-29</StartDate>
    <EndDate>2016-05-05</EndDate>
    <Currency>USD</Currency>
    <Underlying>
      <Type>Equity</Type>
      <Name>.SPX</Name>
      <IdentifierType>RIC</IdentifierType>
    </Underlying>
    <LongShort>Long</LongShort>
    <Strike>0.20</Strike>
    <Notional>50000</Notional>
    <Calendar>US</Calendar>
    <MomentType>Variance</MomentType>
    <AddPastDividends>true</AddPastDividends>
</EqutiyVarianceSwapData>
```

</div>

The meanings and allowable values of the elements in the
`EquityVarianceSwapData` node below.

- StartDate: The variance swap start date.  
  Allowable values: See `Date` in Table
  <a href="#tab:allow_stand_data" data-reference-type="ref"
  data-reference="tab:allow_stand_data">[tab:allow_stand_data]</a>.

- EndDate: The variance swap end date.  
  Allowable values: See `Date` in Table
  <a href="#tab:allow_stand_data" data-reference-type="ref"
  data-reference="tab:allow_stand_data">[tab:allow_stand_data]</a>.

- Currency: The bought currency of the variance swap.  
  Allowable values: See `Currency` in Table
  <a href="#tab:allow_stand_data" data-reference-type="ref"
  data-reference="tab:allow_stand_data">[tab:allow_stand_data]</a>.

- Name: The identifier of the underlying equity or equity index.  
  Allowable values: See `Name` for equity trades in Table
  <a href="#tab:equity_credit_data" data-reference-type="ref"
  data-reference="tab:equity_credit_data">[tab:equity_credit_data]</a>.  

- Underlying: This node may be used as an alternative to the `Name` node
  to specify the underlying equity. This in turn defines the equity
  curve used for pricing. The `Underlying` node is described in further
  detail in Section <a href="#ss:underlying" data-reference-type="ref"
  data-reference="ss:underlying">[ss:underlying]</a>.  

- LongShort: Defines whether the trade is long in the equity variance.
  For the avoidance of doubt, a long variance swap has positive value if
  the realised variance exceeds the variance strike.  
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
  calendar(s) given here plus the calendar associated with the equity in
  the equity curve configuration. If no such calendar is given in the
  equity curve configuration the standard calendar for the equity
  currency (also defined in the curve config) is used instead.  
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

- AddPastDividends\[Optional\]: A flag to distinguish if past dividend
  payments should be added to the fixings when calculating accrued
  variance.  
  Allowable values: *true* or *false*. Defaults to *false* if left blank
  or omitted.
