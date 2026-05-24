### FX Asian Option

The `FxAsianOptionData` node is the trade data container for the
*FxAsianOption* trade type. The `FxAsianOptionData` node includes one
`OptionData` trade component sub-node plus elements specific to the FX
Asian Option.

A FX Asian Option is a path-dependent option whose payoff depends upon
the averaged foreign exchange rate over a pre-set period of time.

The structure of an example `FxAsianOptionData` node for a FX Asian
Option is shown in Listing
<a href="#lst:fxasianoption_data" data-reference-type="ref"
data-reference="lst:fxasianoption_data">[lst:fxasianoption_data]</a>.

<div class="listing">

``` xml
<Trade id="FxAsianOption">
    <TradeType>FxAsianOption</TradeType>
    <Envelope>
        <CounterParty>CPTY_A</CounterParty>
        <NettingSetId>CPTY_A</NettingSetId>
        <AdditionalFields />
    </Envelope>
    <FxAsianOptionData>
        <Currency>USD</Currency>
        <Quantity>100</Quantity>
        <Strike>1.05</Strike>
        <Underlying>
            <Type>FX</Type>
            <Name>ECB-EUR-USD</Name>
        </Underlying>
        <OptionData>
            <LongShort>Long</LongShort>
            <OptionType>Call</OptionType>
            <PayoffType>Asian</PayoffType>
                        <PayoffType2>Arithmetic</PayoffType2>
            <ExerciseDates>
                <ExerciseDate>2020-07-15</ExerciseDate>
            </ExerciseDates>
        </OptionData>
                <Settlement>2020-07-20</Settlement>
        <ObservationDates>
            <Rules>
                <StartDate>2019-12-27</StartDate>
                <EndDate>2020-07-06</EndDate>
                <Tenor>1D</Tenor>
                <Calendar>US</Calendar>
                <Convention>F</Convention>
                <TermConvention>F</TermConvention>
                <Rule>Forward</Rule>
            </Rules>
        </ObservationDates>
    </FxAsianOptionData>
</Trade>
```

</div>

The meanings and allowable values of the elements in the
`FxAsianOptionData` node follow below.

- Currency: The payoff currency.  
  Allowable values: See Table
  <a href="#tab:currency" data-reference-type="ref"
  data-reference="tab:currency">[tab:currency]</a> `Currency`.

- Quantity: The quantity of the underlying currency (CCY1). See payoff
  formula above.  
  Allowable values: all positive real numbers

- Strike: The strike of the option, expressed as amount of CCY2 per one
  unit of CCY1.  
  Allowable values: all positive real numbers

- Underlying: An `Underlying` node where `Type` must be set to *FX* and
  `Name` is the foreign exchange currency pair (on the form
  SOURCE-CCY1-CCY2) including the `Currency` above typically as CCY2 and
  another currency defined as the underlying currency as CCY1.  
  Allowable values: See
  <a href="#ss:underlying" data-reference-type="ref"
  data-reference="ss:underlying">[ss:underlying]</a>

- OptionData: This is a trade component sub-node outlined in section
  <a href="#ss:option_data" data-reference-type="ref"
  data-reference="ss:option_data">[ss:option_data]</a>. The relevant
  fields in the `OptionData` node for an FxAsianOption are:

  - `LongShort` The allowable values are *Long* or *Short*.

  - `OptionType` The allowable values are *Call* or *Put*.

  - `PayoffType` which must be set to *Asian* or *AverageStrike* to
    identify a fixed or floating strike asian payoff,

  - `PayoffType2` \[Optional\] can be optionally set to *Arithmetic* or
    *Geometric* and defaults to *Arithmetic* if not given.

  - An `ExerciseDates` node where exactly one ExerciseDate date element
    must be given.

  - A `PaymentData` \[Optional\] node can be added which defines the
    settlement of the option payoff.

  - A `Premiums` \[Optional\] node can be added to represent
    deterministic option premia to be paid by the option holder. See
    section <a href="#ss:premiums" data-reference-type="ref"
    data-reference="ss:premiums">[ss:premiums]</a>

- Settlement\[Optional\]: The settlement date.  
  Allowable values: See `Date` in Table
  <a href="#tab:allow_stand_data" data-reference-type="ref"
  data-reference="tab:allow_stand_data">[tab:allow_stand_data]</a>.
  Defaults to the ExerciseDate if left blank or omitted.

- ObservationDates: The observation dates for the asian period, given as
  a rules-based or dates-based schedule, analogous to a `ScheduleData`
  node but called `ObservationDates`.  
  Allowable values: See the definition in
  <a href="#ss:schedule_data" data-reference-type="ref"
  data-reference="ss:schedule_data">[ss:schedule_data]</a>
