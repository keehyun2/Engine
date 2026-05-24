### FX Double Touch Option

An FX Double Touch Option pays a given cash amount (PayoffAmount) at
expiry or at hit if the underlying fx rate has hit either of the
barriers (KnockIn) resp. has not hit any of barriers (KnockOut) using
continuous monitoring between start and expiry date. No rebates are
supported.

The `FxDoubleTouchOptionData` node is the trade data container for the
*FxDoubleTouchOption* trade type. The `FxDoubleTouchOptionData` node
includes one `OptionData` trade component sub-node and one `BarrierData`
trade component sub-node plus elements specific to the FX Double Touch
Option.

The structure of an example `FxDoubleTouchOptionData` node for an FX
Double Touch Option is shown in Listing
<a href="#lst:fxdoubletouchoption_data" data-reference-type="ref"
data-reference="lst:fxdoubletouchoption_data">[lst:fxdoubletouchoption_data]</a>.

<div class="listing">

``` xml
        <FxDoubleTouchOptionData>
            <OptionData>
                <LongShort>Long</LongShort>
                <PayOffAtExpiry>true</PayOffAtExpiry>
                <ExerciseDates>
                 <ExerciseDate>2021-12-14</ExerciseDate>
                </ExerciseDates>
                ...
            </OptionData>
            <BarrierData>
                ...
                <Type>KnockOut</Type> <!-- KnockOut or KnockIn -->
                <Levels>
                    <Level>1.1</Level>
                    <Level>1.2</Level>
                </Levels>
                ...
            </BarrierData>
            <ForeignCurrency>EUR</ForeignCurrency>
            <DomesticCurrency>USD</DomesticCurrency>
            <PayoffCurrency>USD</PayoffCurrency>
            <PayoffAmount>100000</PayoffAmount>
            <StartDate>2019-01-25</StartDate>
            <FXIndex>FX-ECB-EUR-USD</FXIndex>
            <Calendar>TARGET</Calendar>
        </FxDoubleTouchOptionData>
```

</div>

The meanings and allowable values of the elements in the
`FxDoubleTouchOptionData` node follow below.

- `OptionData`: This is a trade component sub-node outlined in section
  <a href="#ss:option_data" data-reference-type="ref"
  data-reference="ss:option_data">[ss:option_data]</a>. The relevant
  fields in the `OptionData` node for an FxDoubleTouchOption are as
  below. Note that the `OptionType` can be omitted.

  - `LongShort` The allowable values are *Long* or *Short*.

  - `PayOffAtExpiry` \[Optional\] *true* for payoff at expiry and
    *false* for payoff at hit. Currently, for both *KnockOut* and
    *KnockIn* barriers, only payoff at expiry (i.e. *true*) is
    supported. Defaults to *true* if left blank or omitted.

  - An `ExerciseDates` node where exactly one ExerciseDate date element
    must be given.

  - `PaymentData` \[Optional\]: This defines the settlement of the
    option payoff.

  - `Premiums` \[Optional\]: Option premium amounts paid by the option
    buyer to the option seller.

    Allowable values: See section
    <a href="#ss:premiums" data-reference-type="ref"
    data-reference="ss:premiums">[ss:premiums]</a>

- `BarrierData`: This is a trade component sub-node outlined in section
  <a href="#ss:barrier_data" data-reference-type="ref"
  data-reference="ss:barrier_data">[ss:barrier_data]</a>. Two levels in
  ascending order should be defined in *Levels*. *Type* should be
  KnockOut or KnockIn. Levels specified in BarrierData should be quoted
  as the amount in DomesticCurrency (sold currency) per unit
  ForeignCurrency (bought currency). StrictComparison \[Optional\]:
  Define whether we apply $<=$, $>=$ or $<$, $>$ for the barrier check.
  Defaults to *0* and $<=$, $>=$, *1* for $<$, $>$.

- `ForeignCurrency`: The foreign currency of the FX touch option is
  equivalent to the bought currency.

  Allowable values: See Table
  <a href="#tab:currency" data-reference-type="ref"
  data-reference="tab:currency">[tab:currency]</a> `Currency`.

- `DomesticCurrency`: The domestic currency of the FX touch option is
  equivalent to the sold currency.

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

- `Calendar` \[Optional\]: The calendar associated with the FX Index.
  Required if StartDate is set to a date prior to today’s date,
  otherwise optional.

  Allowable values: See Table
  <a href="#tab:calendar" data-reference-type="ref"
  data-reference="tab:calendar">[tab:calendar]</a> Calendar.
