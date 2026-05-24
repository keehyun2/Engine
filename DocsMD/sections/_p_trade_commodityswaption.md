### Commodity Swaption

The structure of a trade node representing a commodity swaption is shown
in listing <a href="#lst:commodity_swaption" data-reference-type="ref"
data-reference="lst:commodity_swaption">[lst:commodity_swaption]</a>. It
consists of the generic `Envelope` and the specific
`CommoditySwaptionData` node.

The `CommoditySwaptionData` node contains an `OptionData` node described
in <a href="#ss:option_data" data-reference-type="ref"
data-reference="ss:option_data">[ss:option_data]</a>. The relevant
fields in the `OptionData` node for a CommoditySwaption are:

- `LongShort`: The allowable values are *Long* or *Short*. Note that the
  payer and receiver legs in the underlying swap are always from the
  perspective of the party that is *Long*. E.g. for a *Short*
  CommoditySwaption with a fixed leg where the Payer flag is set to
  *false*, it means that the counterparty receives the fixed flows.

- `OptionType`\[Optional\]: This flag is optional for
  CommoditySwaptions, and even if set, has no impact. The direction of
  flows is determined entirely by the Payer flags on the underlying legs
  (and the `LongShort` flag above).

- `Style`: The exercise style of the CommoditySwaption. Only exercise
  style *European* is supported.

- `NoticePeriod`\[Optional\]: The notice period defining the date
  (relative to the exercise date) on which the exercise decision has to
  be taken. If not given the notice period defaults to *0D*, i.e. the
  notice date is identical to the exercise date. Allowable values: A
  number followed by *D, W, M, or Y*

- `NoticeCalendar`\[Optional\]: The calendar used to compute the notice
  date from the exercise date. If not given defaults to the
  *NullCalendar* (no holidays, weekends are no holidays either).
  Allowable values: See Table
  <a href="#tab:calendar" data-reference-type="ref"
  data-reference="tab:calendar">[tab:calendar]</a> `Calendar`.

- `NoticeConvention`\[Optional\]: The roll convention used to compute
  the notice date from the exercise date. Defaults to *Unadjusted* if
  not given. Allowable values: See Table
  <a href="#tab:convention" data-reference-type="ref"
  data-reference="tab:convention">[tab:convention]</a> Roll Convention.

- `Settlement`: Delivery Type. The allowable values are *Cash* or
  *Physical*.

- `ExerciseFees`\[Optional\]: This node contains child elements of type
  `ExerciseFee`. Similar to a list of notionals (see
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
  `Percentage` fees are expressed in decimal form, e.g. 0.05 is a fee of
  5% of notional.

  If a fee is given as a positive number the option holder has to pay a
  corresponding amount if they exercise the option. If the fee is
  negative on the other hand, the option holder receives an amount on
  the option exercise.

- `ExerciseFeeSettlementPeriod`\[Optional\]: The settlement lag for
  exercise fee payments. Defaults to 0D if not given. This lag is
  relative to the exercise date (as opposed to the notice date).
  Allowable values: A number followed by *D, W, M, or Y*

- `ExerciseFeeSettlementCalendar`\[Optional\]: The calendar used to
  compute the exercise fee settlement date from the exercise date. If
  not given defaults to the *NullCalendar* (no holidays, weekends are no
  holidays either). Allowable values: See Table
  <a href="#tab:calendar" data-reference-type="ref"
  data-reference="tab:calendar">[tab:calendar]</a> Calendar.

- `ExerciseFeeSettlementConvention`\[Optional\]: The roll convention
  used to compute the exercise fee settlement date from the exercise
  date. Defaults to *Unadjusted* if not given. Allowable values: See
  Table <a href="#tab:convention" data-reference-type="ref"
  data-reference="tab:convention">[tab:convention]</a> Roll Convention.

- An `ExerciseDates` node where exactly one `ExerciseDate` date element
  must be given for *European* style CommoditySwaptions. Allowable
  values: The `ExerciseDate` must be on or before the StartDate of the
  underlying legs, and be on or after the valuation date. For the
  format, see Date in Table
  <a href="#tab:allow_stand_data" data-reference-type="ref"
  data-reference="tab:allow_stand_data">[tab:allow_stand_data]</a>.  

- `Premiums` \[Optional\]: Option premium node with amounts paid by the
  option buyer to the option seller.

  Allowable values: See section
  <a href="#ss:premiums" data-reference-type="ref"
  data-reference="ss:premiums">[ss:premiums]</a>

The `CommoditySwaptionData` node should contain exactly two `LegData`
nodes. One `LegData` node should be of type `CommodityFixed` described
in section <a href="#ss:commodityfixedleg" data-reference-type="ref"
data-reference="ss:commodityfixedleg">[ss:commodityfixedleg]</a> and one
should be of type `CommodityFloating` described in section
<a href="#ss:commodityfloatingleg" data-reference-type="ref"
data-reference="ss:commodityfloatingleg">[ss:commodityfloatingleg]</a>.
Note that on the `CommodityFloating` leg, the Spread must be omitted or
set to *0*, and the Gearing must be omitted or set to *1*.

<div class="listing">

``` xml
<Trade id="...">
  <TradeType>CommoditySwaption</TradeType>
  <Envelope>
    ...
  </Envelope>
  <CommoditySwaptionData>
    <OptionData>
      <LongShort>Long</LongShort>
      <Style>European</Style>
      <Settlement>Cash</Settlement>
      <ExerciseDates>
        <ExerciseDate>2023-01-05</ExerciseDate>
      </ExerciseDates>
    </OptionData>
    <LegData>
      <LegType>CommodityFixed</LegType>
      ...
    </LegData>
    <LegData>
      <LegType>CommodityFloating</LegType>
      ...
    </LegData>
  </CommoditySwaptionData>
</Trade>
```

</div>
