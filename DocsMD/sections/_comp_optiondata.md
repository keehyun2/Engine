### Option Data

This trade component node is used within the `SwaptionData` and
`FXOptionData` trade data containers. It contains the `ExerciseDates`
sub-node which includes `ExerciseDate` child elements. An example
structure of the `OptionData` trade component node is shown in Listing
<a href="#lst:option_data" data-reference-type="ref"
data-reference="lst:option_data">[lst:option_data]</a>.

<div class="listing">

``` xml
<OptionData>
  <LongShort>Long</LongShort>
  <OptionType>Call</OptionType>
  <Style>Bermudan</Style>
  <NoticePeriod>5D</NoticePeriod>
  <NoticeCalendar>TARGET</NoticeCalendar>
  <NoticeConvention>F</NoticePeriod>
  <Settlement>Cash</Settlement>
  <SettlementMethod>CollateralizedCashPrice</SettlementMethod>
  <MidCouponExercise>false</MidCouponExercise>
  <PayOffAtExpiry>true</PayOffAtExpiry>
  <ExerciseFees>
    <ExerciseFee type="Percentage">0.0020</ExerciseFee>
    <ExerciseFee type="Absolute" startDate="2020-04-20">25000</ExerciseFee>
  </ExerciseFees>
  <ExerciseFeeSettlementPeriod>2D</ExerciseFeeSettlementPeriod>
  <ExerciseFeeSettlementConvention>F</ExerciseFeeSettlementConvention>
  <ExerciseFeeSettlementCalendar>TARGET</ExerciseFeeSettlementCalendar>
  <ExerciseDates>
    <ExerciseDate>2019-04-20</ExerciseDate>
    <ExerciseDate>2020-04-20</ExerciseDate>
  </ExerciseDates>
  <!-- Alternative format for exercise dates using Schedule format -->
  <ExerciseSchedule>
    <Rules>
      <StartDate>2019-04-20</StartDate>
      <EndDate>2024-04-20</EndDate>
      <Convention>F</Convention>
      <Tenor>3M</Tenor>
    </Rules>
  </ExerciseSchedule>
  <Premiums>
    <Premium>
      <Amount>100000</Amount>
      <Currency>EUR</Currency>
      <PayDate>2018-05-07</PayDate>
    </Premium>
  </Premiums>
  <AutomaticExercise>...</AutomaticExercise>
  <ExerciseData>
    <Date>...</Date>
    <Price>...</Price>
  </ExerciseData>
  <PaymentData>...</PaymentData>
  <SettlementData>...</SettlementData>
</OptionData>
```

</div>

The meanings and allowable values of the elements in the `OptionData`
node follow below.

- LongShort: Specifies whether the option position is *long* or *short*.
  Note that for Swaptions, Callable Swaps, and Index CDS Options setting
  `LongShort` to *short* makes the `Payer` indicator on the underlying
  Swap / Index CDS to be set from the perspective of the Counterparty.

  Allowable values: *Long, L* or *Short, S*

- OptionType: Specifies whether it is a call or a put option. Optional
  for trade types Swaption and CallableSwap.

  Allowable values: *Call* or *Put*

  The meaning of Call and Put values depend on the trade type and asset
  class of the option, see Table
  <a href="#tab:callput_specs" data-reference-type="ref"
  data-reference="tab:callput_specs">1</a>.

  <div id="tab:callput_specs">

  | **Asset Class and Trade Type**                          | **Call / Put Specifications**                                                                                                                                                                                                   |
  |:--------------------------------------------------------|:--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
  | Equity/ Commodity/Bond Option                           | *Call*: The right to buy the underlying equity/commodity/bond at the strike price. *Put*: The right to sell the underlying equity/commodity/bond at the strike price.                                                           |
  | IR Swaption, CallableSwap, Commodity Swaption           | *Call/Put* values are ignored, and the OptionType field is optional. Payer/Receiver swaption is determined by the `Payer` fields in the Leg Data nodes of the underlying swap.                                                  |
  | FX Options (all variants, except Touch, Digital, Asian) | *Call*: Bought and Sold currencies/amounts stay as determined in the trade data node. *Put*: Bought and Sold currencies/amounts are switched compared to the trade data node. Note that barriers are not switched / unaffected. |
  | Index CDS Option                                        | *Call/Put* values are ignored, and the OptionType field is optional. The `Payer` field in the underlying Index CDS leg determines if the option is to buy or sell protection.                                                   |
  | Asian FX Options                                        | *Call*: The right to buy/receive the underlying currency at the strike price. *Put*: The right to sell/pay the underlying currency at the strike price.                                                                         |
  | Digital FX Options                                      | *Call*: The digital payout will occur if the fx rate at the expiry date is above the given strike, *Put*: The digital payout will occur if the fx rate at the expiry date is below the given strike.                            |
  | FX Single Touch Options                                 | *Call/Put* values are ignored, and are instead inferred from the BarrierData type, and the OptionType field is optional.                                                                                                        |
  | FX Double Touch Options                                 | *Call/Put* values are ignored, and the OptionType field is optional.                                                                                                                                                            |
  | Ascot                                                   | *Call* has payout: $$\max(0, convertiblePrice - Strike)$$ *Put* has payout: $$\max(0, Strike - convertiblePrice)$$                                                                                                              |

  Specification of Option Type Call / Put

  </div>

- PayoffType \[Optional, except for trade types detailed below\]:
  Specifies a detailed payoff type for exotic options. Only applicable
  to specific trade types as indicated in parentheses:

  Allowable values:

  - *Accumulator, Decumulator* (applies to trade types
    EquityAccumulator, FxAccumulator, CommodityAccumulator only)

  - *TargetFull, TargetExact, TargetTruncated* (applies to trade types
    EquityTaRF, FxTaRF, CommodityTaRF only)

  - *BestOfAssetOrCash, WorstOfAssetOrCash, MaxRainbow, MinRainbow*
    (applies to trade types EquityRainbowOption, FxRainbowOption,
    CommodityRainbowOption only)

  - *Vanilla, Asian, AverageStrike, LookbackCall, LookbackPut* (applies
    to trade types EquityBasketOption, FxBasketOption,
    CommodityBasketOption only)

  - *Asian* (applies to trade types EquityAsianOption, FxAsianOption
    only)

  - *Vanilla, AssetOrNothing, CashOrNothing* (applies to trade type
    FxGenericBarrierOption, EquityGenericBarrierOption,
    CommodityGenericBarrierOption)

- Style: The exercise style of the option.

  Allowable values: *European* or *American* or *Bermudan*.

  Note that trade types IR Swaption and CallableSwap can have all three
  styles: *European*, *Bermudan*, or *American*.

  FX, Equity and Commodity vanilla options can have styles *European* or
  *American*, but not *Bermudan*.

  Exotic FX, Equity and Commodity options can generally only have style
  *European*, see each trade type for details.

  Commodity Swaption and Commodity Average Price Options must have style
  *European*.

  Index CDS Options must have style *European*.

  Ascots must have style *American*.

- PayoffType2 \[Optional\]: Subtype for payoff of exotic options. Only
  applicable to specific trade types as indicated in parantheses:

  Allowable values:

  - *Arithmetic, Geometric* (applies to trade types EquityAsianOption,
    FxAsianOption only, if not given it defaults to Arithmetic)

- NoticePeriod \[Optional\]: The notice period defining the date
  (relative to the exercise date) on which the exercise decision has to
  be taken. If not given the notice period defaults to 0D, i.e. the
  notice date is identical to the exercise date. Only supported for
  Swaptions and Callable Swaps currently.

- NoticeCalendar \[Optional\]: The calendar used to compute the notice
  date from the exercise date. If not given defaults to the null
  calendar (no holidays, weekends are no holidays either).

- NoticeConvention \[Optional\]: The convention used to compute the
  notice date from the exercise date. Defaults to Unadjusted if not
  given.

- Settlement: Delivery type. Note that Settlement is not required for
  Asian options.

  Allowable values: *Cash* or *Physical*

- SettlementMethod \[Optional\]: Specifies the method to calculate the
  settlement amount for Swaptions and CallableSwaps.

  Allowable values: *PhysicalOTC*, *PhysicalCleared*,
  *CollateralizedCashPrice*,  
  *ParYieldCurve*.

  Defaults to *ParYieldCurve* if Settlement is *Cash* and defaults to
  *PhysicalOTC* if Settlement is *Physical*.

  *PhysicalOTC* = OTC traded swaptions with physical settlement  
  *PhysicalCleared* = Cleared swaptions with physical settlement  
  *CollateralizedCashPrice* = Cash settled swaptions with settlement
  price calculation using zero coupon curve discounting  
  *ParYieldCurve* = Cash settled swaptions with settlement price
  calculation using par yield discounting [^1] [^2]  

- MidCouponExercise \[Optional\]: Relevant for Swaptions and
  CallableSwaps. If *false*, the exercise-into underlying comprises all
  coupons with accrual start date greater or equal to notification date.
  I.e. one exercises into the next coupon, not the current one.  
  If *true*, the exercise-into underlying comprises all coupons with
  accrual end date greater than the effective exercise date which is
  computed from the notification date by adding the notice period. The
  accrual paid for such coupons on exercise is calculated from the
  effective exercise date to the accrual end date (short coupon).

  Allowable values: *true*, *false*. If omitted, defaults to *false* for
  European and Bermudan swaptions/callableswaps and *true* for American
  swaptions/callableswaps.

- PayOffAtExpiry \[Optional\]: Relevant for options with early exercise,
  i.e. the exercise occurs before expiry; *true* indicates payoff at
  expiry, whereas *false* indicates payoff at exercise. Defaults to
  *true* if left blank or omitted.

  Allowable values: *true*, *false*.

  Note that for `IndexCreditDefaultSwapOption` PayOffAtExpiry must be
  set to *false* as only payoff at exercise is supported.

- Premiums \[Optional\]: Option premium amounts paid by the option buyer
  to the option seller.

  Allowable values: See section
  <a href="#ss:premiums" data-reference-type="ref"
  data-reference="ss:premiums">[ss:premiums]</a>

- ExerciseDates: This node contains child elements of type
  `ExerciseDate` or an `ExerciseSchedule` node.

  Options of style *European* require a single exercise date expressed
  by one single `ExerciseDate` child element.

  *American* style options must have exactly two `ExerciseDate` child
  elements representing the start and end of the American exercise
  period.

  *Bermudan* style options must have two or more `ExerciseDate` child
  elements. One can alternatively use `ExerciseSchedule` to specify the
  option exercise dates for *Bermudan* style options.

- ExerciseSchedule \[Optional\]: This node can be provided instead of
  `ExerciseDates` and should be specified in the same format as a
  Schedule (see Section
  <a href="#ss:schedule_data" data-reference-type="ref"
  data-reference="ss:schedule_data">[ss:schedule_data]</a>), e.g. for a
  list of Bermudan exercise dates.

- ExerciseFees \[Optional\]: This node contains child elements of type
  ExerciseFee. Similar to a list of notionals (see
  <a href="#ss:leg_data" data-reference-type="ref"
  data-reference="ss:leg_data">[ss:leg_data]</a>) the fees can be given
  either

  - as a list where each entry corresponds to an exercise date and the
    last entry is used for all remaining exercise dates if there are
    more exercise dates than exercise fee entries, or

  - using the `startDate` attribute to specify a change in a fee from a
    certain day on (w.r.t. the exercise date schedule)

  Fees can either be given as an absolute amount or relative to the
  current notional of the period immediately following the exercise date
  using the `type` attribute together with specifiers `Absolute` resp.
  `Percentage`. If not given, the type defaults to `Absolute`.

  If a fee is given as a positive number the option holder has to pay a
  corresponding amount if they exercise the option. If the fee is
  negative on the other hand, the option holder receives an amount on
  the option exercise.

  Only supported for Swaptions and Callable Swaps currently.

- ExerciseFeeSettlementPeriod \[Optional\]: The settlement lag for
  exercise fee payments. Defaults to *0D* if not given. This lag is
  relative to the exercise date (as opposed to the notice date).

  Allowable values: A number followed by *D, W, M, or Y*

- ExerciseFeeSettlementCalendar \[Optional\]: The calendar used to
  compute the exercise fee settlement date from the exercise date. If
  not given defaults to the *NullCalendar* (no holidays, weekends are no
  holidays either).

  Allowable values: See Table
  <a href="#tab:calendar" data-reference-type="ref"
  data-reference="tab:calendar">[tab:calendar]</a> Calendar.

- ExerciseFeeSettlementConvention \[Optional\]: The convention used to
  compute the exercise fee settlement date from the exercise date.
  Defaults to *Unadjusted* if not given.

  Allowable values: See Table
  <a href="#tab:convention" data-reference-type="ref"
  data-reference="tab:convention">[tab:convention]</a> Roll Convention.

- AutomaticExercise \[Optional\]: Used if the option expiry date is on
  the current date or in the past, and the payment date is in the
  future - so that there still is an outstanding cashflow if the option
  was in the money on the expiry date. In this case, if
  AutomaticExercise is applied, the FX / Commodity / Equity fixing on
  the expiry date is used to automatically determine the payoff and thus
  whether the option was exercised or not.  
  Currently, this field is only used for vanilla European cash settled
  FX, equity and commodity options. It is a boolean flag indicating if
  Automatic Exercise is applicable for the option trade. A value of
  *true* indicates that Automatic Exercise is applicable and a value of
  *false* indicates that it is not.

  Allowable values: A boolean value given in Table
  <a href="#tab:boolean_allowable" data-reference-type="ref"
  data-reference="tab:boolean_allowable">[tab:boolean_allowable]</a>. If
  not provided, the default value is *false*.

- ExerciseData \[Optional\]: Currently, this node is only used for
  vanilla European cash settled FX, equity and commodity options where
  *Automatic Exercise* is not applicable. It has the structure shown in
  Listing <a href="#lst:option_data" data-reference-type="ref"
  data-reference="lst:option_data">[lst:option_data]</a> i.e. a child
  `Date` and `Price` node. It is used to supply the price at which an
  option was exercised and the date of exercise. For a European option,
  the supplied date clearly has to match the single option
  `ExerciseDate`. It is needed where the cash settlement date is after
  the `ExerciseDate`. If this node is not supplied, and the
  `ExerciseDate` is in the past relative to the valuation date, the
  option is assumed to have expired unexercised.

  Allowable values: The `Date` node should be a valid date as outlined
  in Table <a href="#tab:allow_stand_data" data-reference-type="ref"
  data-reference="tab:allow_stand_data">[tab:allow_stand_data]</a> and
  the `Price` node should be a valid price as a real number.

- PaymentData \[Optional\]: This node is used to supply the date on
  which the option is cash settled if it is exercised. There are two
  methods in which this data may be supplied:

  1.  The first method is an explicit list of dates as shown in Listing
      <a href="#lst:dates_payment_data" data-reference-type="ref"
      data-reference="lst:dates_payment_data">[lst:dates_payment_data]</a>.
      The `Date` node should be a valid date as outlined in Table
      <a href="#tab:allow_stand_data" data-reference-type="ref"
      data-reference="tab:allow_stand_data">[tab:allow_stand_data]</a>.
      Obviously, for European options, there should be exactly one date
      supplied.

  2.  The second method is a set of rules that are used to generate the
      settlement date relative to either the exercise date of the option
      or the expiry date of the option. The structure of the
      `PaymentData` node in this case is given in Listing
      <a href="#lst:rules_payment_data" data-reference-type="ref"
      data-reference="lst:rules_payment_data">[lst:rules_payment_data]</a>.
      The optional `RelativeTo` node must be either `Expiry` or
      `Exercise`. If it is `Expiry`, the expiry date is taken as the
      base date from which the rules are applied. If it is `Exercise`,
      the exercise date is taken as the base date from which the rules
      are applied. These two dates are the same in the case of a
      European option. If not provided, `Expiry` is assumed. The `Lag`
      node is a non-negative integer giving the number of days from the
      base date to the cash settlement date. The `Calendar` gives the
      business day calendar for the cash settlement date and should be a
      valid calendar code as outlined in Table
      <a href="#tab:calendar" data-reference-type="ref"
      data-reference="tab:calendar">[tab:calendar]</a>. The `Convention`
      gives the roll convention for the cash settlement date and should
      be a valid roll convention as outlined in Table
      <a href="#tab:convention" data-reference-type="ref"
      data-reference="tab:convention">[tab:convention]</a>.

- SettlementData \[Optional\]: Only relevant for cash settled options.
  Converts the payoff into a currency different from the option’s own
  currency. It specifies the payment currency, the FX index to perform
  the conversion, and the date on which the FX rate is fixed. Its XML
  form is shown in listing
  <a href="#lst:settlement_data_cash_settled_options"
  data-reference-type="ref"
  data-reference="lst:settlement_data_cash_settled_options">[lst:settlement_data_cash_settled_options]</a>.

  - `PayCurrency`: Currency in which the option payoff will be settled.

  - `FXIndex`: FX index used to convert from the option currency into
    the settlement currency.

  - `FixingDate` \[Optional\]: Date on which the FX rate is taken. If
    omitted, the engine will use the index convention to derive the
    fixing date from the payment date. It will subtract
    \*\*FixingDays\*\* from the payment date and adjust the resulting
    date for the holidays according to the fx index conventions.

<div class="listing">

``` xml
<PaymentData>
  <Dates>
    <Date>...</Date>
  </Dates>
</PaymentData>
```

</div>

<div class="listing">

``` xml
<PaymentData>
  <Rules>
    <Lag>...</Lag>
    <Calendar>...</Calendar>
    <Convention>...</Convention>
    <RelativeTo>...</RelativeTo>
  </Rules>
</PaymentData>
```

</div>

<div class="listing">

``` xml
<SettlementData>
  <PayCurrency>USD</PayCurrency>
  <FXIndex>FX-ECB-EUR-USD</FXIndex>
  <FixingDate>2020-03-28</FixingDate>
</SettlementData>
```

</div>

[^1]: https://www.isda.org/book/2006-isda-definitions/

[^2]: https://www.isda.org/a/TlAEE/Supplement-No-58-to-ISDA-2006-Definitions.pdf
