### Equity Double Barrier Option

The `EquityDoubleBarrierOptionData` node is the trade data container for
the *EquityDoubleBarrierOption* trade type.

An Equity Double Barrier Option is a path-dependent option whose
existence depends upon an Equity spot rate reaching one of the two
pre-set barrier levels. Exercise is European, and barriers are American
(continuously monitored).

Equity Double Barrier options can be knock-in or knock-out:

- A knock-in option is a barrier option that only comes into
  existence/becomes active when the Equity spot rate reaches the one of
  the barrier level at any point in the option’s life. Once a barrier is
  knocked-in, the option will not cease to exist until the option
  expires and effectively it becomes a Vanilla Equity Option.

- A knock-out option starts its life active, but ceases to exist/becomes
  inactive, if the one of the barriers is reached during the life of the
  option.

The barrier levels of an Equity Double Barrier Option should be quoted
in the currency of the underlying Equity spot price. The
`EquityDoubleBarrierOptionData` node includes one `OptionData` trade
component sub-node and one `BarrierData` trade component sub-node plus
elements specific to the Equity Double Barrier Option. The structure of
an example `EquityDoubleBarrierOptionData` node for a Equity Double
Barrier Option is shown in Listing
<a href="#lst:EquityDoubleBarrieroption_data" data-reference-type="ref"
data-reference="lst:EquityDoubleBarrieroption_data">[lst:EquityDoubleBarrieroption_data]</a>.

<div class="listing">

``` xml
    <EquityDoubleBarrierOptionData>
        <OptionData>
            <LongShort>Long</LongShort>
            <OptionType>Call</OptionType>
            <Style>European</Style>
            <Settlement>Cash</Settlement>
            <ExerciseDates>
                <ExerciseDate>2021-01-29</ExerciseDate>
            </ExerciseDates>
        </OptionData>
        <BarrierData>
            <Type>KnockOut</Type>
            <Levels>
                <Level>3000.00</Level>
                <Level>3500.00</Level>
            </Levels>
        </BarrierData>
        <Name>RIC:.SPX</Name>
        <Currency>USD</Currency>
        <StrikeData>
            <StrikePrice>
                <Value>3200.00</Value>
                <Currency>USD</Currency>
            </StrikePrice>
        </StrikeData>
        <Quantity>1000</Quantity>
        <StartDate>2019-12-27</StartDate>
        <Calendar>US-NYSE</Calendar>
        <EQIndex>EQ-RIC:.SPX</EQIndex>
    </EquityDoubleBarrierOptionData>
```

</div>

The meanings and allowable values of the elements in the
`EquityDoubleBarrierOptionData` node follow below.

- OptionData: This is a trade component sub-node outlined in section
  <a href="#ss:option_data" data-reference-type="ref"
  data-reference="ss:option_data">[ss:option_data]</a>. The relevant
  fields in the `OptionData` node for an EquityDoubleBarrierOption are:

  - `LongShort` The allowable values are *Long* or *Short*.

  - `OptionType` The allowable values are *Call* or *Put*.

  - `Style` The Equity Double Barrier Option type allows for *European*
    option exercise style only.

  - `Settlement` The allowable values are *Cash* or *Physical*.

  - An `ExerciseDates` node where exactly one `ExerciseDate` date
    element must be given.

  - Optional `PremiumAmount`, `PremiumCurrency`, and `PremiumPayDate`
    fields to specify the Equity Double Barrier Option premium.

- BarrierData: This is a trade component sub-node outlined in section
  <a href="#ss:barrier_data" data-reference-type="ref"
  data-reference="ss:barrier_data">[ss:barrier_data]</a>. Two levels in
  ascending order should be defined in `Levels`. `Type` should be
  *KnockOut* or *KnockIn*.

  Allowable values: See Table
  <a href="#tab:calendar" data-reference-type="ref"
  data-reference="tab:calendar">[tab:calendar]</a> Calendar.

- Underlying: This node may be used as an alternative to the `Name` node
  to specify the underlying equity. This in turn defines the equity
  curve used for pricing. The `Underlying` node is described in further
  detail in Section <a href="#ss:underlying" data-reference-type="ref"
  data-reference="ss:underlying">[ss:underlying]</a>.

- Currency: The currency of the equity option.

  Allowable values: See Table
  <a href="#tab:currency" data-reference-type="ref"
  data-reference="tab:currency">[tab:currency]</a> `Currency`.

- StrikeData: A node containing the strike in `Value` and the currency
  in which both the underlying and the strike are quoted in `Currency`.
  Allowable values: Only supports `StrikePrice` as described in Section
  <a href="#ss:strikedata" data-reference-type="ref"
  data-reference="ss:strikedata">[ss:strikedata]</a>.

- Quantity: The number of units of the underlying covered by the
  transaction.

  Allowable values: Any positive real number.

- StartDate \[Optional\]: The start date for checking if a barrier has
  been breached prior to today’s date. If omitted or left blank no check
  is made and it is assumed no barrier has been breached in the past.
  Has no impact if set to today’s date or a date in the future.

  Allowable values: See `Date` in Table
  <a href="#tab:allow_stand_data" data-reference-type="ref"
  data-reference="tab:allow_stand_data">[tab:allow_stand_data]</a>.

- Calendar \[Optional\]: The calendar associated with the Equity Index.
  Required if StartDate is set to a date prior to today’s date,
  otherwise optional.

- EQIndex \[Optional\]: A reference to an Equity Index source to check
  if the barrier has been breached. Required if StartDate is set to a
  date prior to today’s date, otherwise optional and can be omitted but
  not left blank.

  Allowable values: The format of the Equity Index is“EQ-RIC:Code”.
