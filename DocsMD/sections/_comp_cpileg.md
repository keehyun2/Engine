### CPI Leg Data

A CPI leg contains a series of CPI-linked coupon payments
$N\,r\,({I(t)}/{I_0})\,\delta$ and, if `NotionalFinalExchange` is set to
*true*, a final inflation-linked redemption $(I(t)/I_0)\,N$. Each coupon
and the final redemption can be subtracting the (un-inflated) notional
$N$, i.e. $(I(t)/I_0-1)\,N$, see below.

Note that CPI legs with just a final redemption and no coupons, can be
set up with a dates-based Schedule containing just a single date -
representing the date of the final redemption flow. In this case
`NotionalFinalExchange` must be set to *true*, otherwise the whole leg
is empty, and the Rate is not used and can be set to any value.

Listing <a href="#lst:cpilegdata" data-reference-type="ref"
data-reference="lst:cpilegdata">[lst:cpilegdata]</a> shows an example
for a leg of type CPI with annual coupons, and
<a href="#lst:cpilegdatafinal" data-reference-type="ref"
data-reference="lst:cpilegdatafinal">[lst:cpilegdatafinal]</a> shows an
example for a leg of type CPI with just the final redemption.

The `CPILegData` block contains the following elements:

- Index: The underlying zero inflation index.

  Allowable values: See `Inflation CPI Index` in Table
  <a href="#tab:cpiindex_data" data-reference-type="ref"
  data-reference="tab:cpiindex_data">[tab:cpiindex_data]</a>.

- Rates: The contractual fixed real rate(s) of the leg, *r*. As usual,
  this can be a single value, a vector of values or a dated vector of
  values.

  Note that a CPI leg coupon payment at time $t$ is:
  $$N\,r\,\frac{I(t)}{I_0}\,\delta$$ where:

  - $N$: notional

  - $r$: the contractual fixed real rate

  - $I(t)$: the relevant CPI fixing for time $t$

  - $I_0$: the BaseCPI

  - $\delta$: the day count fraction for the accrual period up to time
    $t$

  Allowable values: Each rate element can take any real number. The rate
  is expressed in decimal form, e.g. 0.05 is a rate of 5%.

- BaseCPI \[Optional\]: The base CPI value $I_0$ used to determine the
  lifting factor for the fixed coupons. If omitted it will take the
  observed CPI fixing on startDate - observationLag.

  Allowable values: Any positive real number.

- StartDate \[Optional\]: The start date needs to be provided in case
  the schedule comprises only a single date. If the schedule has at
  least two dates and a start date is given at the same time, the first
  schedule date is taken as the start date and the supplied `StartDate`
  is ignored.

  Allowable values: See `Date` in Table
  <a href="#tab:allow_stand_data" data-reference-type="ref"
  data-reference="tab:allow_stand_data">[tab:allow_stand_data]</a>.

- ObservationLag \[Optional\]: The observation lag to be applied. It’s
  the amount of time from the fixing at the start or end of the period,
  moving backward in time, to the inflation index observation date (the
  inflation fixing). Fallback to the index observation lag as specified
  in the inflation swap conventions of the underlying index, if not
  specified.

  Allowable values: An integer followed by *D*, *W*, *M* or *Y*.
  Interpolation lags are typically expressed in a positive number of
  *M*, months. Note that negative values are allowed, but mean that the
  inflation is observed forward in time from the period start/end date,
  which is unusual.

- Interpolation \[Optional\]: The type of interpolation that is applied
  to inflation fixings. *Linear* interpolation means that the inflation
  fixing for a given date is interpolated linearly between the
  surrounding - usually monthly - actual fixings, whereas with *Flat*
  interpoltion the inflation fixings are constant for each day at the
  value of the previous/latest actual fixing (flat forward
  interpolation). Fallback to the Interpolation as specified in the
  inflation swap conventions of the underlying index, if not specified.

  Allowable values: *Linear, Flat*

- SubtractInflationNotional \[Optional\]: A flag indicating whether the
  non-inflation adjusted notional amount should be subtracted from the
  final inflation-adjusted notional exchange at maturity. Note that the
  final coupon payment is not affected by this flag.  
  Final notional payment if *true*: $N \,(I(T)/I_0-1)$.  
  Final notional payment if *false*: $N \,I(T)/I_0$

  Allowable values: Boolean node, allowing *Y, N, 1, 0, true, false*
  etc. The full set of allowable values is given in Table
  <a href="#tab:boolean_allowable" data-reference-type="ref"
  data-reference="tab:boolean_allowable">[tab:boolean_allowable]</a>.  
  Defaults to *false* if left blank or omitted.

- SubtractInflationNotionalAllCoupons \[Optional\]: A flag indicating
  whether the non-inflation adjusted notional amount should be
  subtracted from all coupons. Note that the final redemption payment is
  not affected by this flag.  
  Coupon payment if *true*: $N \,(I(T)/I_0-1)$.  
  Coupon payment if *false*: $N \,I(T)/I_0$

  Allowable values: Boolean node, allowing *Y, N, 1, 0, true, false*
  etc. The full set of allowable values is given in Table
  <a href="#tab:boolean_allowable" data-reference-type="ref"
  data-reference="tab:boolean_allowable">[tab:boolean_allowable]</a>.  
  Defaults to *false* if left blank or omitted.

- Caps \[Optional\]: This node contains child elements of type `Cap`
  indicating that the inflation indexed payment is capped; the cap is
  applied to the inflation index and expressed as an inflation rate, see
  CPI Cap/Floor in the Product Description.  
  If the cap is constant over the life of the cpi leg, only one cap
  value should be entered. If two or more coupons have different caps,
  multiple cap values are required, each represented by a `Cap` child
  element. The first cap value corresponds to the first coupon, the
  second cap value corresponds to the second coupon, etc. If the number
  of coupons exceeds the number of cap values, the cap will be kept at
  the value of last entered spread for the remaining coupons. The number
  of entered cap values cannot exceed the number of coupons. Notice that
  the caps defined under this node only apply to the cpi coupons, but
  not a final notional flow (if present). A cap for the final notional
  flow can be defined under the FinalFlowCap node.

  Allowable values: Each child element can take any real number. The cap
  is expressed in decimal form, e.g. 0.03 is a cap of 3%.

- Floors \[Optional\]: This node contains child elements of type `Floor`
  indicating that the inflation indexed payment is floored; the floor is
  applied to the inflation index and expressed as an inflation rate. The
  mode of specification is analogous to caps, see above. Notice that the
  floors defined under this node only apply to the cpi coupons, but not
  a final notional flow (if present). A floor for the final notional
  flow can be defined under the FinalFlowFloor node.

  Allowable values: Each child element can take any real number. The
  floor is expressed in decimal form, e.g. 0.01 is a cap of 1%.

- FinalFlowCap \[Optional\]: The cap to be applied to the final notional
  flow of the cpi leg. If not given, no cap is applied.

  Note that final and non-final inflation cap/floor strikes are quoted
  as a number K and converted to a price via:

  $(1+K)^t$

  where

  K = the cap/floor rate

  t = time to expiry.

  So inflation caps/floors are caps/floors on the inflation rate and not
  the inflation index ratio. For example, to cap the final flow at the
  initial notional it should be K=0, i.e. FinalFlowCap should be 0.

  Allowable values: A real number. The FinalFlowCap is expressed in
  decimal form, e.g. 0.01 is a cap on the final flow at 1% of the
  inflation rate over the life of the trade.

- FinalFlowFloor \[Optional\]: The floor to be applied to the final
  notional flow of the cpi leg. If not given, no floor is applied.

  Allowable values: A real number. The FinalFlowFloor is expressed in
  decimal form, e.g. 0.01 is a floor on the final flow at 1% of the
  inflation rate over the life of the trade.

- NakedOption \[Optional\]: Optional node, if *true* the leg represents
  only the embedded floor, cap or collar. By convention these embedded
  options are considered long if the leg is a receiver leg, otherwise
  short.

  Allowable values: *true*, *false*. Defaults to *false* if left blank
  or omitted.

Whether the leg cotains a final redemption flow at all or not depends on
the notional exchange setting, see section
<a href="#ss:leg_data" data-reference-type="ref"
data-reference="ss:leg_data">[ss:leg_data]</a> and listing
<a href="#lst:notional_exchange" data-reference-type="ref"
data-reference="lst:notional_exchange">[lst:notional_exchange]</a>.

<div class="listing">

``` xml
      <LegData>
        <LegType>CPI</LegType>
        <Payer>false</Payer>
        <Currency>GBP</Currency>
        <Notionals>
          <Notional>10000000</Notional>
          <Exchanges>
            <NotionalInitialExchange>false</NotionalInitialExchange>
            <NotionalFinalExchange>true</NotionalFinalExchange>
          </Exchanges>
        </Notionals>
        <DayCounter>ACT/ACT</DayCounter>
        <PaymentConvention>Following</PaymentConvention>
        <ScheduleData>
          <Rules>
            <StartDate>2025-07-18</StartDate>
            <EndDate>2031-07-18</EndDate>
            <Tenor>1Y</Tenor>
            <Calendar>UK</Calendar>
            <Convention>ModifiedFollowing</Convention>
            <Rule>Forward</Rule>
          </Rules>
        </ScheduleData>
        <CPILegData>
          <Index>UKRPI</Index>
          <Rates>
            <Rate>0.02</Rate>
          </Rates>
          <BaseCPI>280</BaseCPI>
          <StartDate>2025-07-18</StartDate>
          <ObservationLag>2M</ObservationLag>
          <Interpolation>Linear</Interpolation>
          <Caps>
             <Cap>0.03</Cap>
          </Caps>
          <Floors>
            <Floor>0.0</Floor>
          <Floors>
          <FinalFlowCap>0.03</FinalFlowCap>
          <FinalFlowFloor>0.0</FinalFlowFloor>
          <NakedOption>false</NakedOption>
          <SubtractInflationNotionalAllCoupons>false</SubtractInflationNotionalAllCoupons>
        </CPILegData>
      </LegData>
```

</div>

<div class="listing">

``` xml
      <LegData>
        <Payer>false</Payer>
        <LegType>CPI</LegType>
        <Currency>GBP</Currency>
        <PaymentConvention>ModifiedFollowing</PaymentConvention>
        <DayCounter>ActActISDA</DayCounter>
        <Notionals>
          <Notional>25000000.0</Notional>
          <Exchanges>
            <NotionalInitialExchange>false</NotionalInitialExchange>
            <NotionalFinalExchange>true</NotionalFinalExchange>
          </Exchanges>
        </Notionals>
        <ScheduleData>
          <Dates>
            <Calendar>GBP</Calendar>
            <Dates>
              <Date>2020-08-17</Date>
            </Dates>
          </Dates>
        </ScheduleData>
        <CPILegData>
          <Index>UKRPI</Index>
          <Rates>
            <Rate>1.0</Rate>
          </Rates>
          <BaseCPI>280.64</BaseCPI>
          <StartDate>2018-08-19</StartDate>
          <ObservationLag>2M</ObservationLag>
          <Interpolation>Linear</Interpolation>
          <SubtractInflationNotional>true</SubtractInflationNotional>
          <SubtractInflationNotionalAllCoupons>false</SubtractInflationNotionalAllCoupons>
        </CPILegData>
      </LegData>
```

</div>
