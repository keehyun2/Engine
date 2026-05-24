### FX Touch Option

An FX Touch Option pays a given cash amount (PayoffAmount) at expiry or
at hit if the underlying fx rate has hit a barrier (UpAndIn, DownAndIn -
called One Touch) resp. has not hit a barrier (UpAndOut, DownAndOut -
called No Touch) using continuous monitoring between start and expiry
date. No rebates are supported.

The `FxTouchOptionData` node is the trade data container for the
*FxTouchOption* trade type. The `FxTouchOptionData` node includes one
`OptionData` trade component sub-node and one `BarrierData` trade
component sub-node plus elements specific to the FX Touch Option.

The structure of an example `FxTouchOptionData` node for an FX Touch
Option is shown in Listing
<a href="#lst:fxtouchoption_data" data-reference-type="ref"
data-reference="lst:fxtouchoption_data">[lst:fxtouchoption_data]</a>.

<div class="listing">

``` xml
        <FxTouchOptionData>
            <OptionData>
                <LongShort>Long</LongShort>
                <PayOffAtExpiry>true</PayOffAtExpiry>
                <ExerciseDates>
                 <ExerciseDate>2021-12-14</ExerciseDate>
                </ExerciseDates>
                ...
            </OptionData>
            <BarrierData>
             <Type>DownAndOut</Type>
             <Levels>
              <Level>0.009</Level>
             </Levels>
            </BarrierData>
            <ForeignCurrency>JPY</ForeignCurrency>
            <DomesticCurrency>USD</DomesticCurrency>
            <PayoffCurrency>USD</PayoffCurrency>
            <PayoffAmount>100000</PayoffAmount>
            <StartDate>2019-01-25</StartDate>
            <FXIndex>FX-TR20H-USD-JPY</FXIndex>
            <Calendar>NYB,TKB</Calendar>
        </FxTouchOptionData>
```

</div>

The meanings and allowable values of the elements in the
`FxTouchOptionData` node follow below.

- OptionData: This is a trade component sub-node outlined in section
  <a href="#ss:option_data" data-reference-type="ref"
  data-reference="ss:option_data">[ss:option_data]</a>. The `OptionType`
  sub-node is not required and is inferred from the `BarrierData` type
  (i.e. *Call* for an Up barrier, and *Put* for a Down barrier). The
  relevant fields in the `OptionData` node for an FxTouchOption are:

  - `LongShort` The allowable values are *Long* or *Short*.

  - `PayOffAtExpiry` \[Optional\] *true* for payoff at expiry and
    *false* for payoff at hit. For UpAndOut and DownAndOut barrier, only
    payoff at expiry ( *true*) is supported. Defaults to *true* if left
    blank or omitted. This field is ignored in pricing, and the option
    payoff will be calculated at expiry. This field only has an impact
    on the description of the trade economics. The
    *GenericBarrierOption* can also be used to ‘replicate’ the
    *FXTouchOption* with payoff at hit if required.

  - An `ExerciseDates` node where exactly one `ExerciseDate` date
    element must be given.

  - A `PaymentData` \[Optional\] node can be added which defines the
    settlement of the option payoff. If the option is payoff at hit,
    (i.e. `PayoffAtExpiry` is *false*), the option payment data must be
    rules-based, and the `RelativeTo` sub-node of (`Rules`) must be set
    to *Exercise*.

  - `Premiums` \[Optional\]: Option premium amounts paid by the option
    buyer to the option seller.

    Allowable values: See section
    <a href="#ss:premiums" data-reference-type="ref"
    data-reference="ss:premiums">[ss:premiums]</a>

- `BarrierData`: This is a trade component sub-node outlined in section
  <a href="#ss:barrier_data" data-reference-type="ref"
  data-reference="ss:barrier_data">[ss:barrier_data]</a>. Level
  specified in BarrierData should be quoted as the amount in
  DomesticCurrency (sold currency) per unit ForeignCurrency (bought
  currency). Note that the level stays quoted as DomesticCurrency per
  unit ForeignCurrency, regardless of barrier type. StrictComparison
  \[Optional\]: Define whether we apply $<=$, $>=$ or $<$, $>$ for the
  barrier check. Defaults to *0* and $<=$, $>=$, *1* for $<$, $>$.

- `ForeignCurrency`: The foreign (bought) currency of the FX touch
  option.

  Allowable values: See Table
  <a href="#tab:currency" data-reference-type="ref"
  data-reference="tab:currency">[tab:currency]</a> `Currency`.

- `DomesticCurrency`: The domestic (sold) currency of the FX touch
  option.

  Allowable values: See Table
  <a href="#tab:currency" data-reference-type="ref"
  data-reference="tab:currency">[tab:currency]</a> `Currency`.

- `PayoffCurrency`: The payoff currency of the FX touch option is the
  currency of the payoff amount.

  Allowable values: See Table
  <a href="#tab:currency" data-reference-type="ref"
  data-reference="tab:currency">[tab:currency]</a> `Currency`.

- `PayoffAmount`: The fixed payoff amount expressed in payoff currency.
  It is cash-or-nothing payoff that depends on the option being in or
  out of the money, and whether the barrier has been touched.

  Allowable values: Any positive real number.

- `StartDate` \[Optional\]: The start date for checking if a barrier has
  been breached prior to today’s date. If omitted or left blank no check
  is made and it is assumed no barrier has been breached in the past.
  Has no impact if set to today’s date or a date in the future.

  Allowable values: See `Date` in Table
  <a href="#tab:allow_stand_data" data-reference-type="ref"
  data-reference="tab:allow_stand_data">[tab:allow_stand_data]</a>.

- `FXIndex` \[Optional\]: A reference to an FX Index source to check if
  the barrier has been breached. Required if StartDate is set to a date
  prior to today’s date, otherwise optional, and can be omitted but not
  left blank.

  Allowable values: The format of the FX Index is“FX-SOURCE-CCY1-CCY2”
  as described in table
  <a href="#tab:fxindex_data" data-reference-type="ref"
  data-reference="tab:fxindex_data">[tab:fxindex_data]</a>.

- `FXIndexDailyLows` \[Optional\]: Refers to an FX Index that tracks the
  daily low quotes. This is used to check if the barrier was breached at
  any point during the day. If not provided, ORE will automatically
  derive the index name by appending the suffix *\_LOW* to the FXIndex
  source (e.g. *FX-SOURCE_LOW-CCY1-CCY2*). If no fixings are available,
  the system will fall back to using the fixings from the FXIndex.

  Allowable values: The format of the FX Index is“FX-SOURCE-CCY1-CCY2”
  as described in table
  <a href="#tab:fxindex_data" data-reference-type="ref"
  data-reference="tab:fxindex_data">[tab:fxindex_data]</a>.

- `FXIndexDailyHighs` \[Optional\]: Refers to an FX Index that tracks
  the daily high quotes. This is used to check if the barrier was
  breached at any point during the day. If not provided, ORE will
  automatically derive the index name by appending the suffix *\_HIGH*
  to the FXIndex source (e.g. *FX-SOURCE_HIGH-CCY1-CCY2*). If no fixings
  are available, the system will fall back to using the fixings from the
  FXIndex.

  Allowable values: The format of the FX Index is“FX-SOURCE-CCY1-CCY2”
  as described in table
  <a href="#tab:fxindex_data" data-reference-type="ref"
  data-reference="tab:fxindex_data">[tab:fxindex_data]</a>.

- `Calendar` \[Optional\]: The calendar associated with the FX Index.
  Required if StartDate is set to a date prior to today’s date,
  otherwise optional.

  Allowable values: See Table
  <a href="#tab:calendar" data-reference-type="ref"
  data-reference="tab:calendar">[tab:calendar]</a> Calendar.

Note that FX Touch Options also cover Precious Metals, i.e. with
currencies XAU, XAG, XPT, XPD, and Cryptocurrencies, see supported
Cryptocurrencies in Table
<a href="#tab:currency" data-reference-type="ref"
data-reference="tab:currency">[tab:currency]</a>.
