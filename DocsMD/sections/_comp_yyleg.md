### YY Leg Data

A YY (Year-on-Year) leg has coupons that pay the inflation rate over the
preceding year rather than the inflation index ratio relative to a base
CPI. The inflation linked coupon payments are based on the year-on-year
inflation rate defined as $( \frac{I(t_i)}{I(t_{i-1})} - 1 )$, where
$(t_i)$ and $(t_{i-1})$ are coupon dates spaced one year apart, or if
IrregularYoY is set to *true*, an actual coupon period apart.

Listing <a href="#lst:yylegdata" data-reference-type="ref"
data-reference="lst:yylegdata">[lst:yylegdata]</a> shows an example for
a leg of type YY. The YYLegData block contains the following elements:

- Index: The underlying zero inflation index.

  Allowable values: Any string (provided it is the ID of an inflation
  index in the market configuration).

- FixingDays: The number of fixing days.

  Allowable values: An integer followed by *D*,

- ObservationLag \[Optional\]: The observation lag to be applied.
  Fallback to the index observation lag as specified in the inflation
  swap conventions of the underlying index, if not specified.

  Allowable values: An integer followed by *D*, *W*, *M* or *Y*.
  Interpolation lags are typically expressed in *M*, months.

- Interpolation \[Optional\]: The type of interpolation that is applied
  to inflation fixings. *Linear* interpolation means that the inflation
  fixing for a given date is interpolated linearly between the
  surrounding - usually monthly - actual fixings, whereas with *Flat*
  interpoltion the inflation fixings are constant for each day at the
  value of the previous/latest actual fixing (flat forward
  interpolation).

  Allowable values: *Linear, Flat*  
  Defaults to the Interpolation as specified in the inflation swap
  conventions of the underlying index, if left blank or omitted.

- Spreads \[Optional\]: The spreads applied to the inflation index
  fixings. This node contains child elements of type `Spread`. As usual,
  the child element(s) can be a single value, a vector of values or a
  dated vector of values.

- Gearings \[Optional\]: This node contains child elements of type
  `Gearing` indicating that the coupon rate is multiplied by the given
  factors. The mode of specification is analogous to spreads, see above.

- Caps \[Optional\]: This node contains child elements of type `Cap`
  indicating that the coupon rate is capped at the given rate (after
  applying gearing and spread, if any).

- Floors \[Optional\]: This node contains child elements of type `Floor`
  indicating that the coupon rate is floored at the given rate (after
  applying gearing and spread, if any).

- NakedOption \[Optional\]: If *true* the leg represents only the
  embedded floor, cap or collar. By convention these embedded options
  are considered long if the leg is a receiver leg, otherwise short.

  Allowable values: Boolean node, allowing *Y, N, 1, 0, true, false*
  etc. The full set of allowable values is given in Table
  <a href="#tab:boolean_allowable" data-reference-type="ref"
  data-reference="tab:boolean_allowable">[tab:boolean_allowable]</a>.
  Defaults to *false* if omitted or left blank.

- AddInflationNotional \[Optional\]: If *true*, the payoff will include
  the notional of the coupon $N \, \tau \, \frac{I_t}{I_{t-1Y}}$.

  Allowable values: Boolean node, allowing *Y, N, 1, 0, true, false*
  etc. The full set of allowable values is given in Table
  <a href="#tab:boolean_allowable" data-reference-type="ref"
  data-reference="tab:boolean_allowable">[tab:boolean_allowable]</a>.
  Defaults to *false* if omitted or left blank.

- IrregularYoY \[Optional\]: If *true*, instead of using a YoY inflation
  rate the coupon is based on the inflation rate during the actual
  coupon period, e.g. for a 6M coupon the inflation rate will be
  computed as $\frac{I_t}{I_{t-6m}}-1$.

  Allowable values: Boolean node, allowing *Y, N, 1, 0, true, false*
  etc. The full set of allowable values is given in Table
  <a href="#tab:boolean_allowable" data-reference-type="ref"
  data-reference="tab:boolean_allowable">[tab:boolean_allowable]</a>.
  Defaults to *false* if omitted or left blank.

<div class="listing">

``` xml
      <LegData>
        <LegType>YY</LegType>
        <Payer>false</Payer>
        <Currency>EUR</Currency>
        <Notionals>
          <Notional>10000000</Notional>
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
        <YYLegData>
          <Index>EUHICPXT</Index>
          <FixingDays>2</FixingDays>
          <ObservationLag>2M</ObservationLag>
          <Interpolation>Linear</Interpolation>
          <Spreads>
            <Spread>0.0010</Spread>
          </Spreads>
          <Gearings>
            <Gearing>2.0</Gearing>
          </Gearings>
          <Caps>
            <Cap>0.05</Cap>
          </Caps>
          <Floors>
            <Floor>0.01</Floor>
          </Floors>
          <NakedOption>false</NakedOption>
          <AddInflationNotional>false</AddInflationNotional>
          <IrregularYoY>false</IrregularYoY>
        </YYLegData>
      </LegData>
```

</div>
