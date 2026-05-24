### Floating Leg Data, Spreads, Gearings, Caps and Floors

The `FloatingLegData` trade component node is used within the `LegData`
trade component when the `LegType` element is set to *Floating*. It is
also used directly within the `CapFloor` trade data container. The
`FloatingLegData` node includes elements specific to a floating leg.

An example of a `FloatingLegData` node is shown in Listing
<a href="#lst:floatingleg_data" data-reference-type="ref"
data-reference="lst:floatingleg_data">[lst:floatingleg_data]</a>.

<div class="listing">

``` xml
                <FloatingLegData>
                    <Index>USD-LIBOR-3M</Index>
                    <IsInArrears>false</IsInArrears>
                    <IsAveraged>false</IsAveraged>
                    <HasSubPeriods>false</HasSubPeriods>
                    <IncludeSpread>false</IncludeSpread>
                    <FixingDays>2</FixingDays>
                    <Spreads>
                        <Spread>0.005</Spread>
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
                    <LocalCapFloor>false</LocalCapFloor>
                    <HistoricalFixings>
                        <Fixing fixingDate="2016-02-01">0.2</Fixing>
                    </HistoricalFixings>
                    <BackStubInterpolation>
                        <ShortIndex>USD-LIBOR-1M</ShortIndex>
                        <LongIndex>USD-LIBOR-3M</LongIndex>
                    </BackStubInterpolation>
                </FloatingLegData>
```

</div>

The meanings and allowable values of the elements in the
`FloatingLegData` node follow below.

- Index: The combination of currency, index and term that identifies the
  relevant fixings and yield curve of the floating leg.

  Allowable values: An alphanumeric string of the form CCY-INDEX-TENOR.
  CCY, INDEX and TENOR must be separated by dashes (-). CCY and INDEX
  must be among the supported currency and index combinations. TENOR
  must be an integer followed by D, W, M or Y. See Table
  <a href="#tab:indices" data-reference-type="ref"
  data-reference="tab:indices">[tab:indices]</a>. TENOR is not required
  for Overnight indices, but can be set to *1D*.

- IsAveraged \[Optional\]: For cases where there are multiple index
  fixings over a period *true* indicates that the average of the fixings
  is used to calculate the coupon. *false* indicates that the coupon is
  calculated by compounding the fixings. IsAveraged only applies to
  Overnight indices and Sub Periods Coupons.

  Allowable values: *true, false*. Defaults to *false* if left blank or
  omitted.

- HasSubPeriods \[Optional\]: For cases where several Ibor fixings
  result in a single payment for a period, e.g. if the Ibor tenor is 3M
  and the schedule tenor is 6M, two fixings are used to compute the
  amount of the semiannual coupon payments. *true* indicates that an
  average (IsAveraged = true) or a compounded (IsAveraged=false) value
  of the fixings is used to determine the payment rate. *false*
  indicates that the initial index period fixing determines the payment
  rate for the full tenor, i.e. no further fixings, no averaging and no
  compounding. IsAveraged is ignored for Ibor legs when HasSubPeriods is
  set to *false*. HasSubPeriods does not apply to Overnight indices.

  Allowable values: *true, false*. Defaults to *false* if left blank or
  omitted.

- IncludeSpread \[Optional\]: Only applies to Sub Periods and
  (compounded) OIS Coupons. If *true* the spread is included in the
  compounding, otherwise it is excluded.

  Allowable values: *true, false*. Defaults to *false* if left blank or
  omitted.

  A Zero Coupon Floating leg with compounding that includes spread can
  be set up using a rules-based schedule as shown in Listing
  <a href="#lst:float_zero_coupon_leg_rules" data-reference-type="ref"
  data-reference="lst:float_zero_coupon_leg_rules">[lst:float_zero_coupon_leg_rules]</a>.
  Note that the `Tenor` in the rules-based schedule is not used when
  `Rule` is set to *Zero*.

  <div class="listing">

  ``` xml
              <LegData>
                  <LegType>Floating</LegType>
                  <Payer>false</Payer>
                  <Currency>USD</Currency>
                  <Notionals>
                      <Notional>200000.0000</Notional>
                  </Notionals>
                  <DayCounter>A360</DayCounter>
                  <PaymentConvention>MF</PaymentConvention>
                  <ScheduleData>
                      <Rules>
                          <StartDate>2020-01-14</StartDate>
                          <EndDate>2020-07-14</EndDate>
                          <Tenor>3M</Tenor>
                          <Calendar>USD</Calendar>
                          <Convention>MF</Convention>
                          <TermConvention>MF</TermConvention>
                          <Rule>Zero</Rule>
                      </Rules>
                  </ScheduleData>
                  <FloatingLegData>
                      <Index>USD-LIBOR-3M</Index>
                      <IsAveraged>false</IsAveraged>
                      <HasSubPeriods>true</HasSubPeriods>
                      <IncludeSpread>true</IncludeSpread>
                      <Spreads>
                          <Spread>0.006500</Spread>
                      </Spreads>
                      <IsInArrears>false</IsInArrears>
                      <FixingDays>2</FixingDays>
                  </FloatingLegData>
              </LegData>
  ```

  </div>

  A Zero Coupon Floating leg with compounding that includes spread can
  also be set up using a dates-based schedule with two dates (start and
  end) as shown in Listing
  <a href="#lst:float_zero_coupon_leg_dates" data-reference-type="ref"
  data-reference="lst:float_zero_coupon_leg_dates">[lst:float_zero_coupon_leg_dates]</a>.

  <div class="listing">

  ``` xml
              <LegData>
                  <LegType>Floating</LegType>
                  <Payer>false</Payer>
                  <Currency>USD</Currency>
                  <Notionals>
                      <Notional>200000.0000</Notional>
                  </Notionals>
                  <DayCounter>A360</DayCounter>
                  <PaymentConvention>MF</PaymentConvention>
                  <ScheduleData>
                      <Dates>
                          <Calendar>USD</Calendar>
                          <Convention>MF</Convention>
                          <Dates>
                              <Date>2020-01-14</Date>
                              <Date>2020-07-14</Date>
                          </Dates>
                      </Dates>
                  </ScheduleData>
                  <FloatingLegData>
                      <Index>USD-LIBOR-3M</Index>
                      <IsAveraged>false</IsAveraged>
                      <HasSubPeriods>true</HasSubPeriods>
                      <IncludeSpread>true</IncludeSpread>
                      <Spreads>
                          <Spread>0.006500</Spread>
                      </Spreads>
                      <IsInArrears>false</IsInArrears>
                      <FixingDays>2</FixingDays>
                  </FloatingLegData>
              </LegData>
  ```

  </div>

- IsInArrears \[Optional\]: *true* indicates that fixing is in arrears,
  *false* indicates that fixing is in advance.

  - For Ibor coupons, “in arrears” means that the fixing gap is
    calculated in relation to the current period end date, while “in
    advance” means that the fixing gap is calculated in relation to the
    period start date.

  - For OIS coupons, “in arrears” means that the compounding (or
    averaging) of ON rates is done over the current period (with period
    as defined in ScheduleData), while “in advance” means that the
    compounding (averaging) is done over the previous period. For the
    first period, a virtual previous period will be constructed based on
    the schedule construction rules. In the context of RFRs there are
    two common “in advance” variants:

    - “Last Recent” which means the length of the period used for
      compounding / averaging is independent of the original period.
      This former period is specified in the LastRecentPeriod field.

    - “Last Reset” which means the original period will be used for
      compounding / averaging. This variant is indicated by omitting the
      LastRecentPeriod field.

    Notice that the use of the LastRecentPeriod field is not restricted
    to “in advance” OIS coupons, i.e. it can also be used in combination
    with “in arrears”.

  Allowable values: *true, false*. Defaults to *false* for Ibor and to
  *true* for OIS coupons, if left blank or omitted.

- LastRecentPeriod \[Optional\]: Only applies to OIS coupons. If given,
  the compounding / averaging of ON rates will not be done over the
  usual reference period derived from the accrual period and the
  Lookback, FixingDays and IsInArrears parameters, but instead over a
  period determined by the end date of this usual period and the
  LastRecentPeriod parameter as \[ EndDate - LastRecentPeriod, EndDate
  \]. The calendar used to compute EndDate - LastRecentPeriod is the
  schedule calendar unless a specific LastRecentPeriodCalendar is
  specified. To represent SOFR 30D, 90D, 180D average indices, the
  LastRecentPeriodCalendar should be set to NullCalendar, since these
  averages refer to rolling averages over 30, 90, 180 calendar days.  
  Allowable values: any valid period, e.g. 30D, 90D, 180D, 1M, 2M, 6M

- LastRecentPeriodCalendar \[Optional\]: The calendar used to compute
  the LastRecentPeriod, see this field for more details. If not given,
  defaults to the schedule calendar.  
  Allowable values: See Table
  <a href="#tab:calendar" data-reference-type="ref"
  data-reference="tab:calendar">[tab:calendar]</a> Calendar.

- FixingDays \[Optional\]: The fixing gap. For Ibor coupons this is the
  number of business days before the accrual period’s *reference* date
  to observe the index fixing. Here, the accrual period reference date
  is the accrual start date for an in advanced fixed coupon and the
  accrual end date for in arrears fixed coupon.  
  For overnight coupons this is the number of business days by which the
  value dates are shifted into the past to get the fixing observation
  dates. In the context of RFRs the FixingDays parameter is sometimes
  also called “obervation lag”.

  The calendar used for the fixing gap, is the calendar associated with
  the floating index, as defined in the conventions for the index.

  Allowable values: A non-negative whole number. Defaults to the index’s
  fixing days if blank or omitted. See defaults per index in Table
  <a href="#tab:fixingdaysdefaults" data-reference-type="ref"
  data-reference="tab:fixingdaysdefaults">[tab:fixingdaysdefaults]</a>.

- Lookback \[Optional\]: Only applicable to OIS legs. A period by which
  the value dates schedule of (averaged, compounded) OIS legs is shifted
  into the past. On top of this the gap defined by the FixingDays is
  applied to get the final fixing date for an original date in the OIS
  value dates schedule. In the context of RFRs the Lookback parameter is
  sometimes also called “shift”. With this terminology, first the shift
  and then the observation lag is applied to get the fixing date for an
  original value date of an overnight coupon.

  Allowable values: any valid period, e.g. 2D, 3M, 1Y

- RateCutoff \[Optional\]: Only applicable to OIS legs. The number of
  fixing dates at the end of the fixing period for which the fixing
  value is held constant and set to the previous value. Defaults to $0$.

  Allowable values: any non-negative whole number

- Spreads \[Optional\]: This node contains child elements of type
  `Spread`. If the spread is constant over the life of the floating leg,
  only one spread value should be entered. If two or more coupons have
  different spreads, multiple spread values are required, each
  represented by a `Spread` child element. The first spread value
  corresponds to the first coupon, the second spread value corresponds
  to the second coupon, etc. If the number of coupons exceeds the number
  of spread values, the spread will be kept flat at the value of last
  entered spread for the remaining coupons. The number of entered spread
  values cannot exceed the number of coupons.

  Allowable values: Each child element can take any real number. The
  spread is expressed in decimal form, e.g. 0.005 is a spread of 0.5% or
  50 bp.

  For the `<Spreads>` section, the same applies as for notionals and
  rates - a list of changing spreads can be specified without or with
  individual start dates as shown in Listing
  <a href="#lst:spreads_dates" data-reference-type="ref"
  data-reference="lst:spreads_dates">[lst:spreads_dates]</a>.

  <div class="listing">

  ``` xml
                      <Spreads>
                          <Spread>0.005</Spread>
                          <Spread startDate='2017-03-05'>0.007</Spread>
                          <Spread startDate='2019-03-05'>0.009</Spread>
                      </Spreads>
  ```

  </div>

  If the entire `<Spreads>` section is omitted, it defaults to a spread
  of *0%*.

- Gearings \[Optional\]: This node contains child elements of type
  `Gearing` indicating that the coupon rate is multiplied by the given
  factors. The mode of specification is analogous to spreads, see above.

  If the entire `<Gearings>` section is omitted, it defaults to a
  gearing of *1*.

- Caps \[Optional\]: This node contains child elements of type `Cap`
  indicating that the coupon rate is capped at the given rate (after
  applying gearing and spread, if any). The mode of specification is
  analogous to spreads, see above. Caps / Floors are supported for Ibor,
  SIFMA, compounded / averaged OIS coupons, but not for coupons with
  subperiods.

  For OIS coupons notice how the gearing $g$ and spread $s$ enter the
  calculation of the coupon amount $A$ dependent on the IncludeSpread
  and LocalCapFloor flags and the cap rate $C$, floor rate $F$, daily
  rates $f_i$, daily accrual fractions $\tau_i$ and the coupon accrual
  fraction $\tau$. Notice that the gearing must be $1$ if include spread
  is set to true for capped / floored coupons. The cases for compounded
  coupons are:

  - IncludeSpread = false, LocalCapFloor = false:  
    $$A = \min \left( \max \left( g \cdot \frac{\prod (1 + \tau_i f_i) - 1}{\tau} + s, F \right), C \right)$$

  - IncludeSpread = true, LocalCapFloor = false:  
    $$A = \min \left( \max \left( g \cdot \frac{\prod (1 + \tau_i(f_i + s)) - 1}{\tau}, F \right), C \right)$$

  - IncludeSpread = false, LocalCapFloor = true:  
    $$A = g \cdot \frac{\prod (1 + \tau_i \min ( \max ( f_i , F), C)) - 1}{\tau} + s$$

  - IncludeSpread = true, LocalCapFloor = true:  
    $$A = g \cdot \frac{\prod (1 + \tau_i \min ( \max ( f_i + s , F), C)) - 1}{\tau}$$

  The cases for Averaged coupons are:

  - IncludeSpread = false, LocalCapFloor = false:  
    $$A = \min \left( \max \left( g \cdot \frac{\sum (\tau_i f_i)}{\tau} + s, F \right), C \right)$$

  - IncludeSpread = true, LocalCapFloor = false:  
    $$A = \min \left( \max \left( g \cdot \frac{\sum (\tau_i f_i)}{\tau} + s, F \right), C \right)$$

  - IncludeSpread = false, LocalCapFloor = true:  
    $$A = g \cdot \frac{\sum (\tau_i \min ( \max ( f_i , F), C))}{\tau} + s$$

  - IncludeSpread = true, LocalCapFloor = true:  
    $$A = g \cdot \frac{\sum (\tau_i \min ( \max ( f_i + s , F), C))}{\tau}$$

- Floors \[Optional\]: This node contains child elements of type `Floor`
  indicating that the coupon rate is floored at the given rate (after
  applying gearing and spread, if any). The mode of specification is
  analogous to spreads, see above.

- NakedOption \[Optional\]: Optional node, if *true* the leg represents
  only the embedded floor, cap or collar. By convention the embedded
  floor (or cap) are considered long if the leg is a receiver leg,
  otherwise short. For a collar the floor is long and the cap is short
  if the leg is a receiver leg. Notice that this is opposite to the
  definition of a collar in
  <a href="#ss:capfloor" data-reference-type="ref"
  data-reference="ss:capfloor">[ss:capfloor]</a>.

  Allowable values: *true*, *false* . Defaults to *false* if left blank
  or omitted.

- LocalCapFloor \[Optional\]: Optional node, if *true* a cap (floor)
  will be applied to the daily rates of a compounded / averaged
  overnight coupon. If *false* the effective period rate will be capped
  (floored). The flag is ignored for coupons other than overnight
  coupons.

  Allowable values: *true*, *false* . Defaults to *false* if left blank
  or omitted.

- `FixingSchedule` \[Optional\]: This node allows for the specification
  of an explicit fixing schedule, see
  <a href="#ss:schedule_data" data-reference-type="ref"
  data-reference="ss:schedule_data">[ss:schedule_data]</a>. Supported
  for underlying IBOR / term rate index. A given fixing will become
  effective as specified by FixingDays relative to the fixing schedule
  or by an explicit ResetSchedule.

- `ResetSchedule` \[Optional\]: This node allows for the specification
  of an explicit reset schedule, see
  <a href="#ss:schedule_data" data-reference-type="ref"
  data-reference="ss:schedule_data">[ss:schedule_data]</a>, i.e. the
  dates on which fixings become effective. Supported for underlying IBOR
  / term rate index. Can be given together with FixingSchedule or
  FixingDays. In the latter case, the fixing dates are derived from the
  reset schedule.

- `HistoricalFixings` \[Optional\]: This node allows for the
  specification of an custom trade specific fixings. Supported for
  underlying OIS / IBOR / term rate index. If a historical fixing for
  date in the provided list is needed for pricing, the custom fixings
  will be used instead of an exisiting global index fixings.

- `FrontStubInterpolation` \[Optional\]: This node allows for the
  specification of interpolation between two indices for the front stub
  period of the leg. Supported for underlying IBOR / term rate index.
  The interpolated fixing is calculated as a linear interpolation
  between the two given indices based on the accrual days of the coupon.
  The node contains the following child elements:

  - ShortIndex: The index to be used for the short side of the
    interpolation.

  - LongIndex: The index to be used for the long side of the
    interpolation.

  - RoundingType: \[Optional\] The type of rounding to be applied to the
    interpolated fixing. If omitted, no rounding is applied. Allowable
    values: *Up*, *Down*, *Closest*, *Floor*, *Ceiling*.

  - RoundingPrecision: \[Optional\] The number of decimal places to
    which the interpolated fixing percentage is rounded, e.g.
    RoundingPrecision 2 rounds 2.341% to 2.34% (Closest). If omitted, no
    rounding is applied.

  Note that rounding does not apply to interpolated fixing forecasts.

- `BackStubInterpolation` \[Optional\]: Same as `FrontStubInterpolation`
  but for the back stub period of the leg.

- `StubUseOriginalCurve` \[Optional\]: Boolean flag to indicate whether
  the original index curve should be used for stub interpolation fixing
  forecasts. Allowable values: *true*, *false* . Defaults to *false* if
  left blank or omitted.
