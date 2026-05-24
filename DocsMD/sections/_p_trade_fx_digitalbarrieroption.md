### FX Digital Barrier Option

An FX Digital Barrier Option pays a given cash amount in domestic
currency at expiry, if the underlying fx rate has hit (or not hit) a
continuously monitored barrier (as for the FxTouchOption) and the fx
rate at the expiry date is above (call) or below (put) a given strike.

The `FxDigitalBarrierOptionData` node is the trade data container for
the *FxDigitalBarrierOption* trade type. The
`FxDigitalBarrierOptionData` node includes one `OptionData` trade
component sub-node and one `BarrierData` trade component sub-node plus
elements specific to the FX Digital Barrier Option.

The structure of an example `FxDigitalBarrierOptionData` node for a FX
Digital Barrier Option is shown in Listing
<a href="#lst:fxdigitalbarrieroption_data" data-reference-type="ref"
data-reference="lst:fxdigitalbarrieroption_data">[lst:fxdigitalbarrieroption_data]</a>.

<div class="listing">

``` xml
        <FxDigitalBarrierOptionData>
            <OptionData>
                <LongShort>Long</LongShort>
                <OptionType>Call</OptionType>
                <Style>European</Style>
                <ExerciseDates>
                 <ExerciseDate>2021-12-14</ExerciseDate>
                </ExerciseDates>
                ...
            </OptionData>
            <BarrierData>
                <Type>DownAndIn</Type>
                <Levels>
                    <Level>1.18</Level>
                </Levels>
            </BarrierData>
            <StartDate>2019-01-25</StartDate>
            <Calendar>TARGET</Calendar>
            <FXIndex>FX-ECB-EUR-USD</FXIndex>
            <Strike>1.1</Strike>
            <PayoffAmount>100000</PayoffAmount>
            <PayoffCurrency>USD</PayoffCurrency>
            <ForeignCurrency>EUR</ForeignCurrency>
            <DomesticCurrency>USD</DomesticCurrency>
        </FxDigitalBarrierOptionData>
```

</div>

The meanings and allowable values of the elements in the
`FxDigitalBarrierOptionData` node follow below.

- OptionData: This is a trade component sub-node outlined in section
  <a href="#ss:option_data" data-reference-type="ref"
  data-reference="ss:option_data">[ss:option_data]</a>. The relevant
  fields in the `OptionData` node for an FxDigitalBarrierOption are:

  - `LongShort` The allowable values are *Long* or *Short*.

  - `OptionType` The allowable values are *Call* or *Put*. Given
    knock-in or no knock-out, *Call* means that the digital payout will
    occur if the fx rate at the expiry date is above the given strike,
    and *Put* means that the digital payout will occur if the fx rate at
    the expiry date is below the given strike.

  - `Style` The FX Digital Barrier Option type allows for *European*
    option exercise style only.

  - An `ExerciseDates` node where exactly one ExerciseDate date element
    must be given.

  - `Premiums` \[Optional\]: Option premium amounts paid by the option
    buyer to the option seller.

    Allowable values: See section
    <a href="#ss:premiums" data-reference-type="ref"
    data-reference="ss:premiums">[ss:premiums]</a>

- BarrierData: This is a trade component sub-node outlined in section
  <a href="#ss:barrier_data" data-reference-type="ref"
  data-reference="ss:barrier_data">[ss:barrier_data]</a>.

  Note that the *FxDigitalBarrierOption* is a single barrier instrument,
  and can have only one BarrierData node with one barrier level.

  Level specified in BarrierData should be quoted as the amount in
  DomesticCurrency per one unit of ForeignCurrency, with both currencies
  as defined in FxDigitalBarrierOptionData node.

  Type specified in BarrierData can be one of: *UpAndIn, DownAndIn,
  UpAndOut, DownAndOut*

  StrictComparison \[Optional\]: Define whether we apply $<=$, $>=$ or
  $<$, $>$ for the barrier check. Defaults to *0* and $<=$, $>=$, *1*
  for $<$, $>$.

- StartDate\[Optional\]: The start date for checking if a barrier has
  been breached prior to today’s date. If omitted or left blank no check
  is made and it is assumed no barrier has been breached in the past.
  Has no impact if set to today’s date or a date in the future.
  If‘StartDate’ is provided then the fixings for dates between this date
  and the asof date are checked to see if the option was triggered. If
  no fixing is available then we skip that date. This is to allow for
  backwards compatibility.

  Allowable values: See `Date` in Table
  <a href="#tab:allow_stand_data" data-reference-type="ref"
  data-reference="tab:allow_stand_data">[tab:allow_stand_data]</a>.

- Calendar\[Optional\]: The calendar associated with the FX Index.
  Required if StartDate is set to a date prior to today’s date,
  otherwise optional.

  Allowable values: See Table
  <a href="#tab:calendar" data-reference-type="ref"
  data-reference="tab:calendar">[tab:calendar]</a> Calendar.

- FXIndex\[Optional\]: A reference to an FX Index source to check if the
  barrier has been breached. Required if StartDate is set to a date
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

- Strike: The FX strike price, expressed as the amount in
  DomesticCurrency per one unit of ForeignCurrency.

  Allowable values: Any positive real number.

- PayoffAmount: The fixed payoff amount expressed in the PayoffCurrency.
  It is cash-or-nothing payoff that depends on the option being in or
  out of the money, and whether the barrier has been breached.

  Allowable values: Any positive real number.

- PayoffCurrency\[Optional\]: The payoff currency of the FX digital
  option is the currency of the payoff amount. Must be either the
  Domestic or Foreign currency for this trade, If omitted this defaults
  to DomesticCurrency as defined in FxDigitalBarrierOptionData node.

  Allowable values: See Table
  <a href="#tab:currency" data-reference-type="ref"
  data-reference="tab:currency">[tab:currency]</a> `Currency`.

- ForeignCurrency: The foreign currency of the FX digital barrier option
  is equivalent to the bought currency.

  Allowable values: See Table
  <a href="#tab:currency" data-reference-type="ref"
  data-reference="tab:currency">[tab:currency]</a> `Currency`.

- DomesticCurrency: The domestic currency of the FX digital barrier
  option is equivalent to the sold currency.

  Allowable values: See Table
  <a href="#tab:currency" data-reference-type="ref"
  data-reference="tab:currency">[tab:currency]</a> `Currency`.

Note that FX Digital Barrier Options also cover Precious Metals, i.e.
with currencies XAU, XAG, XPT, XPD, and Cryptocurrencies, see supported
Cryptocurrencies in Table
<a href="#tab:currency" data-reference-type="ref"
data-reference="tab:currency">[tab:currency]</a>.
