### Leg Data and Notionals

The `LegData` trade component node is used within the `CapFloorData`,
`SwapData` , `SwaptionData` and `EquitySwapData` trade data containers.
It contains a `ScheduleData` trade component sub-node, and a sub-node
that depends on the value of the `LegType` element, e.g.: `FixedLegData`
for `LegType` *Fixed* or `FloatingLegData` for `LegType` *Floating*. The
`LegData` node also includes a `Notionals` sub-node with `Notional`
child elements described below. An example structure of a `LegData` node
of `LegType` *Floating* is shown in Listing
<a href="#lst:leg_data" data-reference-type="ref"
data-reference="lst:leg_data">[lst:leg_data]</a>.

<div class="listing">

``` xml
            <LegData>
                <Payer>false</Payer>
                <LegType>Floating</LegType>
                <Currency>EUR</Currency>
                <PaymentConvention>Following</PaymentConvention>
                <DayCounter>30/360</DayCounter>
                <Notionals>
                    <Notional>1000000</Notional>
                </Notionals>
                <ScheduleData>
                    ...
                </ScheduleData>
                <FloatingLegData>
                    ...
                </FloatingLegData>
            </LegData>
```

</div>

The meanings and allowable values of the elements in the `LegData` node
follow below.

- LegType: Determines which of the available sub-nodes must be used.

  Allowable values: *Fixed, Floating, Cashflow, CMS, CMB, DigitalCMS,
  DurationAdjustedCMS, CMSSpread, DigitalCMSSpread, Equity, CPI, YY,
  ZeroCouponFixed, FormulaBased, CommodityFloating, CommodityFixed,
  EquityMargin*

- Payer: The flows of the leg are paid to the counterparty if *true*,
  and received if *false*.

  Allowable values: *true, false*

- Currency: The currency of the leg.

  Allowable values: See Table
  <a href="#tab:currency" data-reference-type="ref"
  data-reference="tab:currency">[tab:currency]</a> `Currency`. When
  `LegType` is *Equity*, Minor Currencies in Table
  <a href="#tab:currency" data-reference-type="ref"
  data-reference="tab:currency">[tab:currency]</a> are also allowable.

- PaymentCalendar \[Optional\]: The payment calendar of the leg coupons.
  The `PaymentCalendar` is used in conjunction with the
  `PaymentConvention`, `PaymentLag` and `NotionalPaymentLag` to
  determine the payments dates, unless the `PaymentDates` node is used
  which defines the payment dates explicitly.

  Allowable values: See Table
  <a href="#tab:calendar" data-reference-type="ref"
  data-reference="tab:calendar">[tab:calendar]</a> `Calendar`. If left
  blank or omitted, defaults to the calendar in the `ScheduleData` node,
  unless `LegType` is *Floating* and `Index` is OIS, in which case this
  defaults to the index calendar.

  The `PaymentCalendar` calendar field is currently only supported for
  `LegType` *Floating* (with an IBOR, BMA or OIS underlying index),
  *CMS*, *CMSSpread*, *DigitalCMSSpread*, *Equity*, *YY*, *CPI*,
  *Fixed*, *ZeroCouponFixed*, *DigitalCMS*. For unsupported legs it
  defaults to the schedule calendar, and if no calendar is set in the
  `ScheduleData` node (for dates-based schedules the calendar field is
  optional), the *NullCalendar* is used.

- PaymentConvention: The payment convention of the leg coupons.

  Allowable values: See Table
  <a href="#tab:convention" data-reference-type="ref"
  data-reference="tab:convention">[tab:convention]</a>.

- PaymentLag \[optional\]: The payment lag applies to the coupons on
  Fixed legs, Equity legs, and Floating legs with Ibor and OIS indices
  (including BMA/SIFMA indices), as well as CMS legs, CMSSpread legs,
  CPI legs and Zero Coupon Fixed legs.  
  PaymentLag is also not supported for CapFloor Floating legs that have
  Ibor coupons with sub periods (HasSubPeriods = *true*), nor for
  CapFloor Floating legs with averaged ON coupons (IsAveraged = *true*).

  Allowable values: Any valid period, i.e. a non-negative whole number,
  optionally followed by *D* (days), *W* (weeks), *M* (months), *Y*
  (years). Defaults to *0D* if left blank or omitted. If a whole number
  is given and no letter, it is assumed that it is a number of *D*
  (days).

- NotionalPaymentLag \[optional\]: The notional payment lag (in days)
  applied to any notional exchanges.

  Allowable values: Any non-negative integer. Defaults to zero if left
  blank or omitted.

- DayCounter: The day count convention of the leg coupons. Note that
  `DayCounter` is mandatory for all leg types except *Equity*.

  Allowable values: See `DayCount Convention` in Table
  <a href="#tab:daycount" data-reference-type="ref"
  data-reference="tab:daycount">[tab:daycount]</a>. For *Equity* legs,
  if left blank or omitted, it defaults to *ACT/365*.

- Notionals: This node contains child elements of type `Notional`. If
  the notional is fixed over the life of the leg only one notional value
  should be entered. If the notional is amortising or accreting, this is
  represented by entering multiple notional values, each represented by
  a `Notional` child element. The first notional value corresponds to
  the first coupon, the second notional value corresponds to the second
  coupon, etc. If the number of coupons exceeds the number of notional
  values, the notional will be kept flat at the value of last entered
  notional for the remaining coupons. The number of entered notional
  values cannot exceed the number of coupons.

  Allowable values: Each child element can take any positive real
  number.

  An example of a `Notionals` element for an amortising leg with four
  coupons is shown in Listing
  <a href="#lst:notionals" data-reference-type="ref"
  data-reference="lst:notionals">[lst:notionals]</a>.

  <div class="listing">

  ``` xml
                  <Notionals>
                      <Notional>65000000</Notional>
                      <Notional>65000000</Notional>
                      <Notional>55000000</Notional>
                      <Notional>45000000</Notional>
                  </Notionals>
  ```

  </div>

  Another allowable specification of the notional schedule is shown in
  Listing <a href="#lst:notionals_dates" data-reference-type="ref"
  data-reference="lst:notionals_dates">[lst:notionals_dates]</a>.

  <div class="listing">

  ``` xml
                  <Notionals>
                      <Notional>65000000</Notional>
                      <Notional startDate='2016-01-02'>65000000</Notional>
                      <Notional startDate='2017-01-02'>55000000</Notional>
                      <Notional startDate='2021-01-02'>45000000</Notional>
                  </Notionals>
  ```

  </div>

  The first notional must not have a start date, it will be associated
  with the schedule’s start, The subsequent notionals must either all or
  none have a start date specified from which date onwards the new
  notional is applied. This allows specifying notionals only for dates
  where the notional changes.

  An initial exchange, a final exchange and an amortising exchange can
  be specified using an `Exchanges` child element with
  `NotionalInitialExchange`, `NotionalFinalExchange` and
  `NotionalAmortizingExchange` as subelements, see Listing
  <a href="#lst:notional_exchange" data-reference-type="ref"
  data-reference="lst:notional_exchange">[lst:notional_exchange]</a>.
  The `Exchanges` element is typically used in cross-currency swaps and
  inflation swaps, but can also be used in other trade and leg types.
  Note that for cross-currency swaps, the `NotionalInitialExchange` must
  be set to the same value on both legs. The `NotionalFinalExchange`
  must also be set to the same value on both legs, i.e. *true* on both,
  or *false* on both.

  Allowable values for `NotionalInitialExchange`,
  `NotionalFinalExchange` and `NotionalAmortizingExchange`: *true,
  false*. Defaults to *false* if omitted, or if the entire `Exchanges`
  block is omitted.

  <div class="listing">

  ``` xml
                  <Notionals>
                      <Notional>65000000</Notional>
                      <Exchanges>
                        <NotionalInitialExchange>true</NotionalInitialExchange>
                        <NotionalFinalExchange>true</NotionalFinalExchange>
                        <NotionalAmortizingExchange>true</NotionalAmortizingExchange>
                      </Exchanges>
                  </Notionals>
  ```

  </div>

  FX Resets, used for Rebalancing Cross-currency swaps, can be specified
  using an `FXReset` child element with the following subelements: See
  Listing <a href="#lst:notional_fxreset" data-reference-type="ref"
  data-reference="lst:notional_fxreset">[lst:notional_fxreset]</a> for
  an example.

- ForeignCurrency: The foreign currency the notional of the leg resets
  to.

  Allowable values: See Table
  <a href="#tab:currency" data-reference-type="ref"
  data-reference="tab:currency">[tab:currency]</a> `Currency`.

- ForeignAmount: The notional amount in the foreign currency that the
  notional of the leg resets to.

  Allowable values: Any positive real number.

- FXIndex: A reference to an FX Index source for the FX reset fixing.

  Allowable values: A string on the form FX-SOURCE-CCY1-CCY2.

  <div class="listing">

  ``` xml
                  <Currency>USD</Currency>
                  <Notionals>
                      <Notional>65000000</Notional> <!-- in USD -->
                      <FXReset>
                        <ForeignCurrency> EUR </ForeignCurrency>
                        <ForeignAmount> 60000000 </ForeignAmount>
                        <FXIndex> FX-ECB-USD-EUR </FXIndex>
                      </FXReset>
                  </Notionals>
  ```

  </div>

- StrictNotionalDates \[Optional\]: If given and set to true, notional
  changes specified by startDate will be interpreted as taking place on
  the exact given date, even if that date falls into a calculation
  (accrual) period. Otherwise the notional change is applied for the
  next calculation period. Supported only for fixed and floating legs
  with IBOR / RFR term rate coupons.

- ScheduleData: This is a trade component sub-node outlined in section
  <a href="#ss:schedule_data" data-reference-type="ref"
  data-reference="ss:schedule_data">[ss:schedule_data]</a> Schedule Data
  and Dates.

- `SettlementData` \[Optional\]: This node is used to specify the
  settlement of the cash flows in a currency other than the commodity
  underlying currency. Only used for *CommodityFixed* and
  *CommodityFloating* leg types. This node will be ignored for other leg
  types.

  A `SettlementData` node is shown in Listing
  <a href="#lst:leg_data_settlement_data_node" data-reference-type="ref"
  data-reference="lst:leg_data_settlement_data_node">[lst:leg_data_settlement_data_node]</a>,
  and the meanings and allowable values of its elements follow below.

  - `FXIndex`: The FX reference index for determining the FX fixing at
    the value date. The leg NPV will be observed in the commodity
    underlying currency, and then converted to `Currency` with the
    `FXIndex` using an FX fixing on `FixingDate`.  
    Allowable values: The format of the `FXIndex` is
    “FX-FixingSource-CCY1-CCY2” as described in Table
    <a href="#tab:fxindex_data" data-reference-type="ref"
    data-reference="tab:fxindex_data">[tab:fxindex_data]</a>.

  - `FixingDate` \[Optional\]: The date on which the `FXIndex` is
    observed. Payment date will be used if not given. Allowable values:
    See `Date` in Table
    <a href="#tab:allow_stand_data" data-reference-type="ref"
    data-reference="tab:allow_stand_data">[tab:allow_stand_data]</a>.

  <div class="listing">

  ``` xml
      <SettlementData>
        <FXIndex>FX-ECB-EUR-USD</FXIndex>
        <FixingDate>2025-05-28</FixingDate>
      </SettlementData>
  ```

  </div>

- `PaymentSchedule` \[Optional\]: This node allows for the specification
  of an explicit payment schedule, see
  <a href="#ss:schedule_data" data-reference-type="ref"
  data-reference="ss:schedule_data">[ss:schedule_data]</a>. Supported in
  commodity trades, fixed legs and floating legs with underlying OIS and
  IBOR indices.

- `PaymentDates` \[Deprecated\]: This node allows for the specification
  of a list of explicit payment dates. The usage is deprecated, use
  PaymentSchedule instead.

- FixedLegData: This trade component sub-node is required if `LegType`
  is set to *Fixed* It is outlined in section
  <a href="#ss:fixedleg_data" data-reference-type="ref"
  data-reference="ss:fixedleg_data">[ss:fixedleg_data]</a>.

- FloatingLegData: This trade component sub-node is required if
  `LegType` is set to *Floating* It is outlined in section
  <a href="#ss:floatingleg_data" data-reference-type="ref"
  data-reference="ss:floatingleg_data">[ss:floatingleg_data]</a>
  Floating Leg Data and Spreads.

- CashflowLegData: This trade component sub-node is required if
  `LegType` is set to *Cashflow*. It is outlined in section
  <a href="#ss:cashflowlegdata" data-reference-type="ref"
  data-reference="ss:cashflowlegdata">[ss:cashflowlegdata]</a>.

- CMSLegData: This trade component sub-node is required if `LegType` is
  set to *CMS* (Constant Maturity Swap). It is outlined in section
  <a href="#ss:cmslegdata" data-reference-type="ref"
  data-reference="ss:cmslegdata">[ss:cmslegdata]</a>.

- CMBLegData: This trade component sub-node is required if `LegType` is
  set to *CMB* (Constant Maturity Bond). It is outlined in section
  <a href="#ss:cmblegdata" data-reference-type="ref"
  data-reference="ss:cmblegdata">[ss:cmblegdata]</a>.

- DigitalCMSLegData: This trade component sub-node is required if
  `LegType` is set to *DigitalCMS*. It is outlined in section
  <a href="#ss:digitalcmslegdata" data-reference-type="ref"
  data-reference="ss:digitalcmslegdata">[ss:digitalcmslegdata]</a>.

- DurationAdjustedCMSLegData: This trade component sub-node is required
  if `LegType` is set to *DurationAdjustedCMS*. It is outlined in
  section
  <a href="#ss:duration_adjusted_cmslegdata" data-reference-type="ref"
  data-reference="ss:duration_adjusted_cmslegdata">[ss:duration_adjusted_cmslegdata]</a>.

- CMSSpreadLegData: This trade component sub-node is required if
  `LegType` is set to *CMSSpread*. It is outlined in section
  <a href="#ss:cmsspreadlegdata" data-reference-type="ref"
  data-reference="ss:cmsspreadlegdata">[ss:cmsspreadlegdata]</a>.

- DigitalCMSSpreadLegData: This trade component sub-node is required if
  `LegType` is set to *DigitalCMSSpread*. It is outlined in section
  <a href="#ss:digitalcmsspreadlegdata" data-reference-type="ref"
  data-reference="ss:digitalcmsspreadlegdata">[ss:digitalcmsspreadlegdata]</a>.

- EquityLegData: This trade component sub-node is required if `LegType`
  is set to *Equity*. It is outlined in section
  <a href="#ss:equitylegdata" data-reference-type="ref"
  data-reference="ss:equitylegdata">[ss:equitylegdata]</a>.

- CPILegData: This trade component sub-node is required if `LegType` is
  set to *CPI*. It is outlined in section
  <a href="#ss:cpilegdata" data-reference-type="ref"
  data-reference="ss:cpilegdata">[ss:cpilegdata]</a>.

- YYLegData: This trade component sub-node is required if `LegType` is
  set to *YY*. It is outlined in section
  <a href="#ss:yylegdata" data-reference-type="ref"
  data-reference="ss:yylegdata">[ss:yylegdata]</a>.

- ZeroCouponFixedLegData: This trade component sub-node is required if
  `LegType` is set to *ZeroCouponFixed*. It is outlined in section
  <a href="#ss:zerolegdata" data-reference-type="ref"
  data-reference="ss:zerolegdata">[ss:zerolegdata]</a>.

- FormulaBasedLegData: This trade component sub-node is required if
  `LegType` is set to *FormulaBased*. It is outlined in section
  <a href="#ss:formulalegdata" data-reference-type="ref"
  data-reference="ss:formulalegdata">[ss:formulalegdata]</a>.

- CommodityFloatingLegData: This trade component sub-node is required if
  `LegType` is set to *CommodityFloating* It is outlined in section
  <a href="#ss:commodity_floating_leg_data" data-reference-type="ref"
  data-reference="ss:commodity_floating_leg_data">[ss:commodity_floating_leg_data]</a>.

- CommodityFixedLegData: This trade component sub-node is required if
  `LegType` is set to *CommodityFixed* It is outlined in section
  <a href="#ss:commodity_fixed_leg_data" data-reference-type="ref"
  data-reference="ss:commodity_fixed_leg_data">[ss:commodity_fixed_leg_data]</a>.

- EquityMarginLegData: This trade component sub-node is required if
  `LegType` is set to *EquityMargin* It is outlined in section
  <a href="#ss:equity_margin_leg_data" data-reference-type="ref"
  data-reference="ss:equity_margin_leg_data">[ss:equity_margin_leg_data]</a>.
