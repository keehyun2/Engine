### Equity Touch Option

An Equity Touch Option pays a given cash amount (PayoffAmount) at expiry
or at hit if the underlying equity price or index has hit a barrier
(UpAndIn, DownAndIn) resp. has not hit a barrier (UpAndOut, DownAndOut)
using continuous monitoring between start and expiry date. No rebates
are supported.

The `EquityTouchOptionData` node is the trade data container for the
*EquityTouchOption* trade type. The `EquityTouchOptionData` node
includes one `OptionData` trade component sub-node and one `BarrierData`
trade component sub-node plus elements specific to the Equity Touch
Option.

The structure of an example `EquityTouchOptionData` node for an Equity
Touch Option is shown in Listing
<a href="#lst:eqtouchoption_data" data-reference-type="ref"
data-reference="lst:eqtouchoption_data">[lst:eqtouchoption_data]</a>.

<div class="listing">

``` xml
        <EquityTouchOptionData>
            <OptionData>
                <LongShort>Long</LongShort>
                <PayOffAtExpiry>true</PayOffAtExpiry>
                <Settlement>Cash</Settlement>
                <ExerciseDates>
                 <ExerciseDate>2022-03-01</ExerciseDate>
                </ExerciseDates>
                ...
            </OptionData>
            <BarrierData>
               <Type>UpAndIn</Type>
               <Levels>
                   <Level>3300</Level>
               </Levels>
            </BarrierData>
            <PayoffCurrency>USD</PayoffCurrency>
            <PayoffAmount>1000000</PayoffAmount>
            <Name>RIC:.SPX</Name>
            <StartDate>2019-12-27</StartDate>
            <Calendar>US-NYSE</Calendar>
            <EQIndex>EQ-RIC:.SPX</EQIndex>>
        </EquityTouchOptionData>
```

</div>

The meanings and allowable values of the elements in the
`EquityTouchOptionData` node follow below.

- OptionData: This is a trade component sub-node outlined in section
  <a href="#ss:option_data" data-reference-type="ref"
  data-reference="ss:option_data">[ss:option_data]</a>. The `OptionType`
  sub-node is not required and is inferred from the `BarrierData` type
  (i.e. *Call* for an Up barrier, and *Put* for a Down barrier). The
  relevant fields in the `OptionData` node for an EquityTouchOption are:

  - `LongShort` The allowable values are *Long* or *Short*.

  - `PayOffAtExpiry` \[Optional\] *true* for payoff at expiry and
    *false* for payoff at hit. For *UpAndOut* and *DownAndOut* barriers,
    only payoff at expiry (i.e. *true*) is supported. Defaults to *true*
    if left blank or omitted.

  - `Settlement` The allowable values are *Cash* or *Physical*.

  - An `ExerciseDates` node where exactly one ExerciseDate date element
    must be given.

  - Premiums \[Optional\]: Option premium amounts paid by the option
    buyer to the option seller.

    Allowable values: See section
    <a href="#ss:premiums" data-reference-type="ref"
    data-reference="ss:premiums">[ss:premiums]</a>

- BarrierData: This is a trade component sub-node outlined in section
  <a href="#ss:barrier_data" data-reference-type="ref"
  data-reference="ss:barrier_data">[ss:barrier_data]</a>. Level
  specified in BarrierData should be quoted in the same currency as the
  underlying Equity spot price. StrictComparison \[Optional\]: Define
  whether we apply $<=$, $>=$ or $<$, $>$ for the barrier check.
  Defaults to *0* and $<=$, $>=$, *1* for $<$, $>$.

- PayoffCurrency: The payoff currency of the Equity Touch Option is the
  currency of the payoff amount. Must be consistent with the currency of
  the underlying Equity spot price.

  Allowable values: See `Currency` in Table
  <a href="#tab:allow_stand_data" data-reference-type="ref"
  data-reference="tab:allow_stand_data">[tab:allow_stand_data]</a>.

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
