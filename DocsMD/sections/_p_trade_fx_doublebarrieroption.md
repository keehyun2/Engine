### FX Double Barrier Option

An FX Double Barrier Option is a path-dependent option whose existence
depends upon an FX spot rate reaching one of the two pre-set barrier
levels. Exercise is European, and barriers are American (continuously
monitored).

FX Double Barrier options can be knock-in or knock-out:

- A knock-in option is a barrier option that only comes into
  existence/becomes active when the FX spot rate reaches the one of the
  barrier level at any point in the option’s life. Once a barrier is
  knocked-in, the option will not cease to exist until the option
  expires and effectively it becomes a Vanilla FX Option.

- A knock-out option starts its life active, but ceases to exist/becomes
  inactive, if the one of the barriers is reached during the life of the
  option.

The `FxDoubleBarrierOptionData` node is the trade data container for the
*FxDoubleBarrierOption* trade type.

The barrier levels of an FX Double Barrier Option are quoted as the
amount in SoldCurrency per unit BoughtCurrency. The
`FxDoubleBarrierOptionData` node includes one `OptionData` trade
component sub-node and one `BarrierData` trade component sub-node plus
elements specific to the FX Double Barrier Option. The structure of an
example `FxDoubleBarrierOptionData` node for a FX Double Barrier Option
is shown in Listing
<a href="#lst:FxDoubleBarrieroption_data" data-reference-type="ref"
data-reference="lst:FxDoubleBarrieroption_data">[lst:FxDoubleBarrieroption_data]</a>.

<div class="listing">

``` xml
        <FxDoubleBarrierOptionData>
            <OptionData>
                <LongShort>Long</LongShort>
                <!-- Bought and Sold currencies/amounts are switched for Put -->
                <OptionType>Call</OptionType>
                <Style>European</Style>
                <ExerciseDates>
                 <ExerciseDate>2021-12-14</ExerciseDate>
                </ExerciseDates>
                ...
            </OptionData>
            <BarrierData>
                <Type>KnockOut</Type> <!-- KnockOut or KnockIn -->
                <Levels>
                    <Level>1.1</Level>
                    <Level>1.2</Level>
                </Levels>
                <Rebate>0.0</Rebate>
            </BarrierData>
            <StartDate>2019-01-25</StartDate>
            <Calendar>TARGET</Calendar>
            <FXIndex>FX-ECB-EUR-USD</FXIndex>
            <BoughtCurrency>EUR</BoughtCurrency>
            <BoughtAmount>1000000</BoughtAmount>
            <SoldCurrency>USD</SoldCurrency>
            <SoldAmount>1100000</SoldAmount>
        </FxDoubleBarrierOptionData>
```

</div>

The meanings and allowable values of the elements in the
`FxDoubleBarrierOptionData` node follow below.

- OptionData: This is a trade component sub-node outlined in section
  <a href="#ss:option_data" data-reference-type="ref"
  data-reference="ss:option_data">[ss:option_data]</a>. The relevant
  fields in the `OptionData` node for an FxDoubleBarrierOption are:

  - `LongShort` The allowable values are *Long* or *Short*.

  - `OptionType` The allowable values are *Call* or *Put*.  
    *Call* means that the holder of the option, upon expiry - assuming
    knock-in or no knock-out - has the right to receive the BoughtAmount
    and pay the SoldAmount.  
    *Put* means that the Bought and Sold currencies/amounts are switched
    compared to the trade data node. For example, holder of
    BoughtCurrency EUR SoldCurrency JPY FX Double Barrier Call Option
    has the right to buy EUR using JPY, while holder of the Put
    counterpart has the right to buy JPY using EUR, or equivalently sell
    EUR for JPY. An alternative to define the latter option is to copy
    the Call option with following changes:  
    a) swapping BoughtCurrency with SoldCurrency, b) swapping
    BoughtAmount with SoldAmount and c) inverting the barrier level (for
    example changing 110 to 0.0090909). Here barrier level is quoted as
    amount of EUR per unit JPY, which is not commonly seen on market and
    inconsistent with the format in Call options. For these reasons,
    using Put/Call flag instead is recommended.

  - `Style` The FX Double Barrier Option type allows for *European*
    option exercise style only.

  - `Settlement` The allowable values are *Cash* or *Physical*.

  - A `PaymentData` \[Optional\] node can be added which defines the
    settlement of the option payoff.

  - An `ExerciseDates` node where exactly one ExerciseDate date element
    must be given.

  - `Premiums` \[Optional\]: Option premium amounts paid by the option
    buyer to the option seller.

    Allowable values: See section
    <a href="#ss:premiums" data-reference-type="ref"
    data-reference="ss:premiums">[ss:premiums]</a>

- `BarrierData`: This is a trade component sub-node outlined in section
  <a href="#ss:barrier_data" data-reference-type="ref"
  data-reference="ss:barrier_data">[ss:barrier_data]</a>. Levels
  specified in BarrierData should be quoted as the amount in
  SoldCurrnecy per unit BoughtCurrency, with both currencies as defined
  in FxDoubleBarrierOptionData node. Changing the option from Call to
  Put or vice versa does not require switching the barrier levels. Two
  levels in ascending order should be defined in `Levels`. `Type` should
  be *KnockOut* or *KnockIn*. StrictComparison \[Optional\]: Define
  whether we apply $<=$, $>=$ or $<$, $>$ for the barrier check.
  Defaults to *0* and $<=$, $>=$, *1* for $<$, $>$.

- `StartDate` \[Optional\]: The start date for checking if a barrier has
  been breached prior to today’s date. If omitted or left blank no check
  is made and it is assumed no barrier has been breached in the past.
  Has no impact if set to today’s date or a date in the future.

  Allowable values: See `Date` in Table
  <a href="#tab:allow_stand_data" data-reference-type="ref"
  data-reference="tab:allow_stand_data">[tab:allow_stand_data]</a>.

- `Calendar` \[Optional\]: The calendar associated with the FX Index.
  Required if StartDate is set to a date prior to today’s date,
  otherwise optional.

  Allowable values: See Table
  <a href="#tab:calendar" data-reference-type="ref"
  data-reference="tab:calendar">[tab:calendar]</a> Calendar.

- `FXIndex` \[Optional\]: A reference to an FX Index source to check if
  the barrier has been breached. Required if StartDate is set to a date
  prior to today’s date, otherwise optional and can be omitted but not
  left blank.

  Allowable values: The format of the FX Index is“FX-SOURCE-CCY1-CCY2”
  as described in table
  <a href="#tab:fxindex_data" data-reference-type="ref"
  data-reference="tab:fxindex_data">[tab:fxindex_data]</a>.

- `BoughtCurrency`: The bought currency of the FX barrier option. See
  OptionData above for more details.

  Allowable values: See Table
  <a href="#tab:currency" data-reference-type="ref"
  data-reference="tab:currency">[tab:currency]</a> `Currency`.

- `BoughtAmount`: The amount in the BoughtCurrency.

  Allowable values: Any positive real number.

- `SoldCurrency`: The sold currency of the FX barrier option. See
  OptionData above for more details.

  Allowable values: See Table
  <a href="#tab:currency" data-reference-type="ref"
  data-reference="tab:currency">[tab:currency]</a> `Currency`.

- `SoldAmount`: The amount in the SoldCurrency.

  Allowable values: Any positive real number.
