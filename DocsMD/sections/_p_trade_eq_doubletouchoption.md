### Equity Double Touch Option

An Equity Double Touch Option pays a given cash amount (PayoffAmount) at
expiry or at hit if the underlying equity price or index has hit either
of the barriers (KnockIn) resp. has not hit any of barriers (KnockOut)
using continuous monitoring between start and expiry date. No rebates
are supported.

The `EquityDoubleTouchOptionData` node is the trade data container for
the *EquityDoubleTouchOption* trade type. The
`EquityDoubleTouchOptionData` node includes one `OptionData` trade
component sub-node and one `BarrierData` trade component sub-node plus
elements specific to the Equity Double Touch Option.

The structure of an example `EquityDoubleTouchOptionData` node for an
Equity Double Touch Option is shown in Listing
<a href="#lst:eqdoubletouchoption_data" data-reference-type="ref"
data-reference="lst:eqdoubletouchoption_data">[lst:eqdoubletouchoption_data]</a>.

<div class="listing">

``` xml
        <EquityDoubleTouchOptionData>
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
                <Type>KnockIn</Type> <!-- KnockOut or KnockIn -->
                <Levels>
                    <Level>3000</Level>
                    <Level>4500</Level>
                </Levels>
                ...
            </BarrierData>
            <PayoffCurrency>USD</PayoffCurrency>
        <PayoffAmount>1000000</PayoffAmount>
        <Name>RIC:.SPX</Name>
        <StartDate>2021-03-01</StartDate>
        <Calendar>USD</Calendar>
        <EQIndex>EQ-RIC:.SPX</EQIndex>
        </EquityDoubleTouchOptionData>
```

</div>

The meanings and allowable values of the elements in the
`EquityDoubleTouchOptionData` node follow below.

- OptionData: This is a trade component sub-node outlined in section
  <a href="#ss:option_data" data-reference-type="ref"
  data-reference="ss:option_data">[ss:option_data]</a>. The relevant
  fields in the `OptionData` node for an EquityDoubleTouchOption are as
  below. Note that the `OptionType` can be omitted.

  - `LongShort` The allowable values are *Long* or *Short*.

  - `PayOffAtExpiry` \[Optional\] *true* for payoff at expiry and
    *false* for payoff at hit. Currently, for both *KnockOut* and
    *KnockIn* barriers, only payoff at expiry (i.e. *true*) is
    supported. Defaults to *true* if left blank or omitted.

  - An `ExerciseDates` node where exactly one ExerciseDate date element
    must be given.

  - Premiums \[Optional\]: Option premium amounts paid by the option
    buyer to the option seller.

    Allowable values: See section
    <a href="#ss:premiums" data-reference-type="ref"
    data-reference="ss:premiums">[ss:premiums]</a>

- BarrierData: This is a trade component sub-node outlined in section
  <a href="#ss:barrier_data" data-reference-type="ref"
  data-reference="ss:barrier_data">[ss:barrier_data]</a>. Two levels in
  ascending order should be defined in *Levels*. *Type* should be
  *KnockOut* or *KnockIn*. Levels specified in BarrierData should be
  quoted in the same currency as the underlying Equity spot prices.
  StrictComparison \[Optional\]: Define whether we apply $<=$, $>=$ or
  $<$, $>$ for the barrier check. Defaults to *0* and $<=$, $>=$, *1*
  for $<$, $>$.

- PayoffCurrency: The payoff currency of the Equity Double Touch Option
  is the currency of the payoff amount. Must be consistent with the
  currency of the underlying Equity spot prices.

  Allowable values: See Table
  <a href="#tab:currency" data-reference-type="ref"
  data-reference="tab:currency">[tab:currency]</a> `Currency`.

- PayoffAmount: The fixed payoff amount expressed in payoff currency. It
  is cash-or-nothing payoff that depends on the option being in or out
  of the money, and whether the barrier has been touched.

  Allowable values: Any positive real number.

- Underlying: This node may be used as an alternative to the `Name` node
  to specify the underlying equity. This in turn defines the equity
  curve used for pricing. The `Underlying` node is described in further
  detail in Section <a href="#ss:underlying" data-reference-type="ref"
  data-reference="ss:underlying">[ss:underlying]</a>.

- StartDate\[Optional\]: The start date for checking if a barrier has
  been breached prior to today’s date. If omitted or left blank no check
  is made and it is assumed no barrier has been breached in the past.
  Has no impact if set to today’s date or a date in the future.

  Allowable values: See `Date` in Table
  <a href="#tab:allow_stand_data" data-reference-type="ref"
  data-reference="tab:allow_stand_data">[tab:allow_stand_data]</a>.

- Calendar\[Optional\]: The calendar associated with the Equity Index.
  Required if StartDate is set to a date prior to today’s date,
  otherwise optional.

  Allowable values: See Table
  <a href="#tab:calendar" data-reference-type="ref"
  data-reference="tab:calendar">[tab:calendar]</a> Calendar.

- EQIndex\[Optional\]: A reference to an Equity Index source to check if
  the barrier has been breached. Required if StartDate is set to a date
  prior to today’s date, otherwise optional and can be omitted but not
  left blank.

  Allowable values: The format of the Equity Index is“EQ-RICCode”.
