### Equity Asian Option

An Equity Asian Option is a path-dependent option whose payoff depends
upon the averaged price of an Equity underlying over a pre-set period of
time.

The `EquityAsianOptionData` node is the trade data container for the
*EquityAsianOption* trade type. The `EquityAsianOptionData` node
includes one `OptionData` trade component sub-node plus elements
specific to the Equity Asian Option.

The structure of an example `EquityAsianOptionData` node for an Equity
Asian Option is shown in Listing
<a href="#lst:eqasianoption_data" data-reference-type="ref"
data-reference="lst:eqasianoption_data">[lst:eqasianoption_data]</a>.

<div class="listing">

``` xml
<Trade id="EquityAsianOption">
    <TradeType>EquityAsianOption</TradeType>
    <Envelope>
        <CounterParty>CPTY_A</CounterParty>
        <NettingSetId>CPTY_A</NettingSetId>
        <AdditionalFields />
    </Envelope>
    <EquityAsianOptionData>
        <Quantity>100</Quantity>
        <Currency>USD</Currency>
        <StrikeData>
            <Value>3100</Value>
            <Currency>USD</Currency>
        </StrikeData>
        <Underlying>
            <Type>Equity</Type>
            <Name>RIC:.SPX</Name>
            <Currency>USD</Currency>
        </Underlying>
        <OptionData>
            <LongShort>Long</LongShort>
            <OptionType>Call</OptionType>
            <PayoffType>Asian</PayoffType>
                        <PayoffType2>Arithmetic</PayoffType2>
            <ExerciseDates>
                <ExerciseDate>2020-07-15</ExerciseDate>
             </ExerciseDates>
                         <Premiums> ... </Premiums>       
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
    </EquityAsianOptionData>
</Trade>
```

</div>

In the above example, the holder of the EquityAsianOption has a call
option that gives the right but not obligation to pay 310,000 USD
(Strike\*Quantity) and receive \[the averaged equity spot price during
the Asian period\] USD multiplied by the `Quantity`.

If OptionType would be changed to Put, the holder of the option would
have the right to receive 310,000 USD (Strike\*Quantity) and pay \[the
averaged equity spot price during the Asian period\] USD multiplied by
the `Quantity`.

The payoff is: $$Payoff = Quantity\cdot MAX(\omega\cdot(A(0,T) - K),0)$$
where:

- $A(0,T)$: the arithmetic average of underlying euqity spot price over
  the Asian observation period from start 0 to end T, quoted in
  `Currency`

- $K$: equity strike price, quoted in `Currency`

- $\omega$: 1 for a call option (ie receiving averaged equity spot price
  and paying strike), -1 for a put option

The meanings and allowable values of the elements in the
`EquityAsianOptionData` node follow below.

- StrikeData: A node containing the strike in `Value` and the currency
  in which both the underlying and the strike are quoted in `Currency`.
  Allowable values: See `Currency` in Table
  <a href="#tab:allow_stand_data" data-reference-type="ref"
  data-reference="tab:allow_stand_data">[tab:allow_stand_data]</a>. The
  strike may be any positive real number. The currency provided in this
  node may be quoted as corresponding minor currency to the underlying
  major currency.

- Quantity: The quantity of the underlying equities. See payoff formula
  above.  
  Allowable values: all positive real numbers

- Underlying: One (and only one) `Underlying` node where `Type` must be
  set to *Equity*.  
  Allowable values: See
  <a href="#ss:underlying" data-reference-type="ref"
  data-reference="ss:underlying">[ss:underlying]</a>. Note that the
  equity must be quoted in the `Currency` above.

- OptionData: The relevant fields in the `OptionData` node for an
  EquityAsianOption are the `LongShort` flag, the `OptionType`
  (*call/put*), the `PayoffType` which must be set to *Asian* or
  *AverageStrike* to identify a fixed or floating strike asian payoff,
  and the `ExerciseDates` node where exactly one ExerciseDate date
  element must be given. `PayoffType2` can be optionally set to
  *Arithmetic* or *Geometric* and defaults to *Arithmetic* if not given.
  Furthermore, a *Premiums* node can be added to represent deterministic
  option premia to be paid by the option holder.  
  Allowable values: See
  <a href="#ss:option_data" data-reference-type="ref"
  data-reference="ss:option_data">[ss:option_data]</a> for the general
  structure of the option data node

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
