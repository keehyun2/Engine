### FX Barrier Option

European exercise, American barrier.

An FX Barrier option is a path-dependent option whose existence depends
upon an FX spot rate reaching a pre-set barrier level. Exercise is
European.

This product has a continuously monitored single barrier (American
Barrier style) with a Vanilla European FX Option Underlying.

The `FxBarrierOptionData` node is the trade data container for the
*FxBarrierOption* trade type. The barrier level of an FX Barrier Option
is quoted as the amount in SoldCurrency per unit BoughtCurrency. The
`FxBarrierOptionData` node includes one `OptionData` trade component
sub-node and one `BarrierData` trade component sub-node plus elements
specific to the FX Barrier Option.

The structure of an example `FxBarrierOptionData` node for a FX Barrier
Option is shown in Listing
<a href="#lst:fxbarrieroption_data" data-reference-type="ref"
data-reference="lst:fxbarrieroption_data">[lst:fxbarrieroption_data]</a>.

<div class="listing">

``` xml
        <FxBarrierOptionData>
            <OptionData>
                <LongShort>Long</LongShort>
                <!-- Bought and Sold currencies/amounts are switched for Put -->
                <OptionType>Call</OptionType>
                <Style>European</Style>
                <Settlement>Cash</Settlement>                
                <ExerciseDates>
                 <ExerciseDate>2021-12-14</ExerciseDate>
                </ExerciseDates>
                ...
            </OptionData>
            <BarrierData>
             <Type>UpAndIn</Type>
             <Levels>
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
        </FxBarrierOptionData>
```

</div>

The meanings and allowable values of the elements in the
`FxBarrierOptionData` node follow below.

- `OptionData`: This is a trade component sub-node outlined in section
  <a href="#ss:option_data" data-reference-type="ref"
  data-reference="ss:option_data">[ss:option_data]</a>. The relevant
  fields in the `OptionData` node for an FxBarrierOption are:

  - `LongShort` The allowable values are *Long* or *Short*.

  - `OptionType` The allowable values are *Call* or *Put*.  
    *Call* means that the holder of the option, upon expiry - assuming
    knock-in or no knock-out - has the right to receive the BoughtAmount
    and pay the SoldAmount.  
    *Put* means that the Bought and Sold currencies/amounts are switched
    compared to the trade data node. For example, holder of
    BoughtCurrency EUR SoldCurrency JPY FX Barrier Call Option has the
    right to buy EUR using JPY, while holder of the Put counterpart has
    the right to buy JPY using EUR, or equivalently sell EUR for JPY. An
    alternative to define the latter option is to copy the Call option
    with following changes:  
    a) swapping BoughtCurrency with SoldCurrency, b) swapping
    BoughtAmount with SoldAmount and c) inverting the barrier level (for
    example changing 110 to 0.0090909). Here barrier level is quoted as
    amount of EUR per unit JPY, which is not commonly seen on market and
    inconsistent with the format in Call options. For these reasons,
    using Put/Call flag instead is recommended.

  - `Style` The FX Barrier Option type allows for *European* option
    exercise style only.

  - `Settlement` The allowable values are *Cash* or *Physical*.

  - A `PaymentData` \[Optional\] node can be added which defines the
    settlement of the option payoff.

  - An `ExerciseDates` node where exactly one ExerciseDate date element
    must be given.

  - `Premiums` \[Optional\]: Option premium amounts paid by the option
    buyer to the option seller. See section
    <a href="#ss:premiums" data-reference-type="ref"
    data-reference="ss:premiums">[ss:premiums]</a>

- `BarrierData`: This is a trade component sub-node outlined in section
  <a href="#ss:barrier_data" data-reference-type="ref"
  data-reference="ss:barrier_data">[ss:barrier_data]</a>. `Level`
  specified in BarrierData should be quoted as the amount in
  SoldCurrency per unit BoughtCurrency, with both currencies as defined
  in FxBarrierOptionData node. Note that the barrier `Level` stays
  quoted as SoldCurrency per unit BoughtCurrency, regardless of
  Put/Call.

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

Note that FX Barrier Options also cover Precious Metals, i.e. with
currencies XAU, XAG, XPT, XPD, and Cryptocurrencies, see supported
Cryptocurrencies in Table
<a href="#tab:currency" data-reference-type="ref"
data-reference="tab:currency">[tab:currency]</a>.
