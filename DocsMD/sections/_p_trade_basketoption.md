### Basket Options

Basket Options are represented as traditional trades or *scripted
trades*, refer to ore/Docs/ScriptedTrade for an introduction of the
latter. Each of the supported variations is represented by a separate
payoff script as shown in Table
<a href="#tab:basketoptions" data-reference-type="ref"
data-reference="tab:basketoptions">1</a>.

<div class="center">

<div id="tab:basketoptions">

| Basket Option Type | Payoff Script Name        |
|:-------------------|:--------------------------|
| Vanilla            | VanillaBasketOption       |
| Asian              | AsianBasketOption         |
| Average strike     | AverageStrikeBasketOption |
| Lookback call      | LookbackCallBasketOption  |
| Lookback put       | LookbackPutBasketOption   |

Basket option types and associated script names.

</div>

</div>

The supported underlying types are Equity, Fx or Commodity resulting in
corresponding trade types and trade data container names

- EquityBasketOption / EquityBasketOptionData

- FxBasketOption / FxBasketOptionData

- CommodityBasketOption / CommodityBasketOptionData

Trade input and the associated payoff script are described in the
following for all supported Basket Option variations.

### Vanilla Basket Option

The traditional trade representation is as follows, using an equity
underlying in this example:

``` xml
<Trade id="VanillaBasketOption#1">
  <TradeType>EquityBasketOption</TradeType>
  <Envelope>
    <CounterParty>CPTY_A</CounterParty>
    <NettingSetId>CPTY_A</NettingSetId>
    <AdditionalFields/>
  </Envelope>
  <EquityBasketOptionData>
    <Currency>USD</Currency>
    <Notional>1</Notional>
    <Strike>5000</Strike>
    <Underlyings>
      <Underlying>
        <Type>Equity</Type>
        <Name>RIC:.SPX</Name>
        <Weight>1.0</Weight>
      </Underlying>
      <Underlying>
        <Type>Equity</Type>
        <Name>RIC:.STOXX50E</Name>
        <Currency>EUR</Currency>
        <Weight>1.0</Weight>
      </Underlying>
    </Underlyings>
    <OptionData>
      <LongShort>Long</LongShort>
      <OptionType>Call</OptionType>
      <PayoffType>Vanilla</PayoffType>
      <ExerciseDates>
        <ExerciseDate>2020-02-15</ExerciseDate>
      </ExerciseDates>
      <Premiums> ... </Premiums>
    </OptionData>
    <Settlement>2020-02-20</Settlement>
  </EquityBasketOptionData>
</Trade>
```

with the following elements:

- Currency: The pay currency. Notice section “Payment Currency” in
  ore/Docs/ScriptedTrade.  
  Allowable values: all supported currency codes, see Table
  <a href="#tab:currency" data-reference-type="ref"
  data-reference="tab:currency">[tab:currency]</a> `Currency`.

- Notional: The quantity (for equity, commodity underlyings) / foreign
  amount (fx underlying)  
  Allowable values: all positive real numbers

- Strike: The strike of the option  
  Allowable values: all positive real numbers

- Underlyings: The basket of underlyings.  
  Allowable values: for each underlying see
  <a href="#ss:underlying" data-reference-type="ref"
  data-reference="ss:underlying">[ss:underlying]</a>

- OptionData: relevant are the long/short flag, the call/put flag, the
  payoff type (must be set to Vanilla to identify the payoff), and the
  exercise date (exactly one date must be given). A *Premiums* node can
  be added to represent deterministic option premia to be paid by the
  option holder.  
  Allowable values: see
  <a href="#ss:option_data" data-reference-type="ref"
  data-reference="ss:option_data">[ss:option_data]</a> for the general
  structure of the option data node

- Settlement: the settlement date (optional, if not given defaults to
  the exercise date)  
  Allowable values: each valid date.

The representation as a scripted trade is as follows:

``` xml
<Trade id="VanillaBasketOption#1">
  <TradeType>ScriptedTrade</TradeType>
  <Envelope/>
  <VanillaBasketOptionData>
    <Expiry type="event">2020-02-15</Expiry>
    <Settlement type="event">2020-02-20</Settlement>
    <PutCall type="optionType">Call</PutCall>
    <LongShort type="longShort">Long</LongShort>
    <Notional type="number">1</Notional>
    <Strike type="number">5000</Strike>
    <Underlyings type="index">
      <Value>EQ-RIC:.SPX</Value>
      <Value>EQ-RIC:.STOXX50E</Value>
    </Underlyings>
    <Weights type="number">
      <Value>1.0</Value>
      <Value>1.0</Value>
    </Weights>
    <PayCcy type = "currency">USD</PayCcy>
  </VanillaBasketOptionData>
</Trade>
```

The VanillaBasketOption script referenced in the trade above is shown in
Listing <a href="#lst:vanillabasketoption" data-reference-type="ref"
data-reference="lst:vanillabasketoption">[lst:vanillabasketoption]</a>.

<div class="listing">

``` Basic
REQUIRE SIZE(Underlyings) == SIZE(Weights);

NUMBER u, basketPrice, ExerciseProbability, Payoff, currentNotional;

FOR u IN (1, SIZE(Underlyings)) DO
    basketPrice = basketPrice + Underlyings[u](Expiry) * Weights[u];
END;

Payoff = max(PutCall * (basketPrice - Strike), 0);

Option = LongShort * Notional * PAY(Payoff, Expiry, Settlement, PayCcy);

IF Payoff > 0 THEN
    ExerciseProbability = 1;
END;
currentNotional = Notional * Strike;
```

</div>

The meanings and allowable values of the elements in the
`VanillaBasketOptionData` node are given below, with data type indicated
in square brackets.

- \[event\] `Expiry`: Option expiry date.  
  Allowable values: See `Date` in Table
  <a href="#tab:allow_stand_data" data-reference-type="ref"
  data-reference="tab:allow_stand_data">[tab:allow_stand_data]</a>.

- \[event\] `Settlement`: Option settlement date.  
  Allowable values: See `Date` in Table
  <a href="#tab:allow_stand_data" data-reference-type="ref"
  data-reference="tab:allow_stand_data">[tab:allow_stand_data]</a>.

- \[optionType\] `PutCall`: Option type with  
  Allowable values *Call, Put*.

- \[longShort\] `LongShort`: Position type, *Long* if we buy, *Short* if
  we sell.  
  Allowable values: *Long, Short*.

- \[number\] `Notional`: Quantity multiplier applied to the basket
  price  
  Allowable values: Any positive real number.

- \[number\] `Strike`: Strike basket price in PayCcy (see below)  
  Allowable values: Any positive real number.

- \[index\] `Underlyings`: List of underlying indices enclosed by
  `<Value>` and `</Value>` tags.  
  Allowable values: See ore/Docs/ScriptedTrade’s Index Section for
  allowable values.

- \[number\] `Weights`: List of weights applied to the underlying prices
  in the basket, given in the same order as the Underlyings above, each
  weight enclosed by `<Value>` and `</Value>` tags.  
  Allowable values: Any positive real number.

- \[currency\] `PayCcy`: The payment currency. For FX, where the
  underlying is provided in the form `FX-SOURCE-CCY1-CCY2` (see Table
  <a href="#tab:fxindex_data" data-reference-type="ref"
  data-reference="tab:fxindex_data">[tab:fxindex_data]</a>) this should
  be `CCY2`. If `CCY1` or the currency of the underlying (for EQ and
  COMM underlyings), this will result in a quanto payoff. Notice section
  “Payment Currency” in ore/Docs/ScriptedTrade. Allowable values: See
  Table <a href="#tab:currency" data-reference-type="ref"
  data-reference="tab:currency">[tab:currency]</a> `Currency` for
  allowable currency codes.

### Asian Basket Option

The traditional trade representation is as follows, using an equity
underlying in this example:

``` xml
<Trade id="AsianBasketOption#1">
  <TradeType>EquityBasketOption</TradeType>
  <Envelope>
    <CounterParty>CPTY_A</CounterParty>
    <NettingSetId>CPTY_A</NettingSetId>
    <AdditionalFields/>
  </Envelope>
  <EquityBasketOptionData>
    <Currency>USD</Currency>
    <Notional>1</Notional>
    <Strike>5000</Strike>
    <Underlyings>
      <Underlying>
        <Type>Equity</Type>
        <Name>RIC:.SPX</Name>
        <Currency>USD</Currency>
        <Weight>1.0</Weight>
      </Underlying>
      <Underlying>
        <Type>Equity</Type>
        <Name>RIC:.STOXX50E</Name>
        <Weight>1.0</Weight>
      </Underlying>
    </Underlyings>
    <OptionData>
      <LongShort>Long</LongShort>
      <OptionType>Call</OptionType>
      <PayoffType>Asian</PayoffType>
      <ExerciseDates>
        <ExerciseDate>2020-02-15</ExerciseDate>
      </ExerciseDates>
      <Premiums> ... </Premiums>  
    </OptionData>
    <Settlement>2020-02-20</Settlement>
    <ObservationDates>
        <Rules>
          <StartDate>2019-02-06</StartDate>
          <EndDate>2020-02-06</EndDate>
          <Tenor>1D</Tenor>
          <Calendar>US</Calendar>
          <Convention>F</Convention>
          <TermConvention>F</TermConvention>
          <Rule>Forward</Rule>
        </Rules>
    </ObservationDates>
  </EquityBasketOptionData>
</Trade>
```

with the following elements:

- Currency: The pay currency. Notice section “Payment Currency” in
  ore/Docs/ScriptedTrade.  
  Allowable values: all supported currency codes, see Table
  <a href="#tab:currency" data-reference-type="ref"
  data-reference="tab:currency">[tab:currency]</a> `Currency`.

- Notional: The quantity (for equity, commodity underlyings) / foreign
  amount (fx underlying)  
  Allowable values: all positive real numbers

- Strike: The strike of the option  
  Allowable values: all positive real numbers

- Underlyings: The basket of underlyings.  
  Allowable values: for each underlying see
  <a href="#ss:underlying" data-reference-type="ref"
  data-reference="ss:underlying">[ss:underlying]</a>

- OptionData: relevant are the long/short flag, the call/put flag, the
  payoff type (must be set to Asian to identify the payoff), and the
  exercise date (exactly one date must be given). `PayoffType2` can be
  optionally set to *Arithmetic* or *Geometric* and defaults to
  *Arithmetic* if not given. Furthermore, a *Premiums* node can be added
  to represent deterministic option premia to be paid by the option
  holder.  
  Allowable values: see
  <a href="#ss:option_data" data-reference-type="ref"
  data-reference="ss:option_data">[ss:option_data]</a> for the general
  structure of the option data node

- Settlement: the settlement date (optional, if not given defaults to
  the exercise date)  
  Allowable values: each valid date.

- ObservationDates: the observation dates for the asian  
  Allowable values: See the definition in
  <a href="#ss:schedule_data" data-reference-type="ref"
  data-reference="ss:schedule_data">[ss:schedule_data]</a>

The representation as a scripted trade is as follows:

``` xml
<Trade id="AsianBasketOption#1">
  <TradeType>ScriptedTrade</TradeType>
  <Envelope/>
   <AsianBasketOptionData>
    <Expiry type="event">2020-02-15</Expiry>
    <Settlement type="event">2020-02-20</Settlement>
    <ObservationDates type="event">
      <ScheduleData>
        <Rules>
          <StartDate>2019-02-06</StartDate>
          <EndDate>2020-02-06</EndDate>
          <Tenor>1D</Tenor>
          <Calendar>US</Calendar>
          <Convention>F</Convention>
          <Rule>Forward</Rule>
        </Rules>
      </ScheduleData>
    </ObservationDates>
    <PutCall type="optionType">Call</PutCall>
    <LongShort type="longShort">Long</LongShort>
    <Notional type="number">1</Notional>
    <Strike type="number">5000</Strike>
    <Underlyings type="index">
      <Value>EQ-RIC:.SPX</Value>
      <Value>EQ-RIC:.STOXX50E</Value>
    </Underlyings>
    <Weights type="number">
      <Value>1.0</Value>
      <Value>1.0</Value>
    </Weights>
    <PayCcy type="currency">USD</PayCcy>
  </AsianBasketOptionData>
</Trade>
```

The AsianBasketOption script referenced in the trade above is shown in
Listing <a href="#lst:asianbasketoption" data-reference-type="ref"
data-reference="lst:asianbasketoption">[lst:asianbasketoption]</a>.

<div class="listing">

``` Basic
REQUIRE SIZE(Underlyings) == SIZE(Weights);

NUMBER d, u, basketPrice, ExerciseProbability, Payoff;
NUMBER currentNotional;

FOR d IN (1, SIZE(ObservationDates)) DO
    FOR u IN (1, SIZE(Underlyings)) DO
        basketPrice = basketPrice + Underlyings[u](ObservationDates[d]) * Weights[u];
    END;
END;

basketPrice = basketPrice / SIZE(ObservationDates);

Payoff = max(PutCall * (basketPrice - Strike), 0);

Option = LongShort * Notional * PAY(Payoff, Expiry, Settlement, PayCcy);

IF Payoff > 0 THEN
    ExerciseProbability = 1;
END;

currentNotional = Notional * Strike;
```

</div>

The meanings and allowable values of the elements in the
`AsianBasketOptionData` node are given below, with data type indicated
in square brackets.

- \[event\] `Expiry`: Option expiry date.  
  Allowable values: See `Date` in Table
  <a href="#tab:allow_stand_data" data-reference-type="ref"
  data-reference="tab:allow_stand_data">[tab:allow_stand_data]</a>.

- \[event\] `Settlement`: Option settlement date.  
  Allowable values: See `Date` in Table
  <a href="#tab:allow_stand_data" data-reference-type="ref"
  data-reference="tab:allow_stand_data">[tab:allow_stand_data]</a>.

- \[event\] `ObservationDates`: Price monitoring schedule.  
  Allowable values: See section
  <a href="#ss:schedule_data" data-reference-type="ref"
  data-reference="ss:schedule_data">[ss:schedule_data]</a> Schedule Data
  and Dates, or DerivedSchedule (see ore/Docs/ScriptedTrade).

- \[optionType\] `PutCall`: Option type with  
  Allowable values *Call, Put*.

- \[longShort\] `LongShort`: Position type, *Long* if we buy, *Short* if
  we sell.  
  Allowable values: *Long, Short*.

- \[number\] `Notional`: Quantity multiplier applied to the basket
  price  
  Allowable values: Any positive real number.

- \[number\] `Strike`: Strike basket price in PayCcy (see below)  
  Allowable values: Any positive real number.

- \[index\] `Underlyings`: List of underlying indices enclosed by
  `<Value>` and `</Value>` tags.  
  See ore/Docs/ScriptedTrade’s Index Section for allowable values.

- \[number\] `Weights`: List of weights applied to the underlying prices
  in the basket, given in the same order as the Underlyings above, each
  weight enclosed by `<Value>` and `</Value>` tags.  
  Allowable values: Any positive real number.

- \[currency\] `PayCcy`: The payment currency. For FX, where the
  underlying is provided in the form `FX-SOURCE-CCY1-CCY2` (see Table
  <a href="#tab:fxindex_data" data-reference-type="ref"
  data-reference="tab:fxindex_data">[tab:fxindex_data]</a>) this should
  be `CCY2`. If `CCY1` or the currency of the underlying (for EQ and
  COMM underlyings), this will result in a quanto payoff. Notice section
  “Payment Currency” in ore/Docs/ScriptedTrade.  
  Allowable values: See Table
  <a href="#tab:currency" data-reference-type="ref"
  data-reference="tab:currency">[tab:currency]</a> `Currency` for
  allowable currency codes.

### Average Strike Basket Option

The traditional trade representation is as follows, using an equity
underlying in this example:

``` xml
<Trade id="AverageStrikeBasketOption#1">
  <TradeType>EquityBasketOption</TradeType>
  <Envelope>
    <CounterParty>CPTY_A</CounterParty>
    <NettingSetId>CPTY_A</NettingSetId>
    <AdditionalFields/>
  </Envelope>
  <EquityBasketOptionData>
    <Currency>USD</Currency>
    <Notional>1</Notional>
    <Underlyings>
      <Underlying>
        <Type>Equity</Type>
        <Name>RIC:.SPX</Name>
        <Currency>USD</Currency>
        <Weight>1.0</Weight>
      </Underlying>
      <Underlying>
        <Type>Equity</Type>
        <Name>RIC:.STOXX50E</Name>
        <Weight>1.0</Weight>
      </Underlying>
    </Underlyings>
    <OptionData>
      <LongShort>Long</LongShort>
      <OptionType>Call</OptionType>
      <PayoffType>AverageStrike</PayoffType>
      <ExerciseDates>
        <ExerciseDate>2020-02-15</ExerciseDate>
      </ExerciseDates>
      <Premiums> ... </Premiums>  
    </OptionData>
    <Settlement>2020-02-20</Settlement>
    <ObservationDates>
      <Rules>
        <StartDate>2019-02-06</StartDate>
        <EndDate>2020-02-06</EndDate>
        <Tenor>1D</Tenor>
        <Calendar>US</Calendar>
        <Convention>F</Convention>
        <TermConvention>F</TermConvention>
        <Rule>Forward</Rule>
      </Rules>
    </ObservationDates>
  </EquityBasketOptionData>
</Trade>
```

with the following elements:

- Currency: The pay currency. Notice section “Payment Currency” in
  ore/Docs/ScriptedTrade.  
  Allowable values: all supported currency codes, see Table
  <a href="#tab:currency" data-reference-type="ref"
  data-reference="tab:currency">[tab:currency]</a> `Currency`.

- Notional: The quantity (for equity, commodity underlyings) / foreign
  amount (fx underlying)  
  Allowable values: all positive real numbers

- Underlyings: The basket of underlyings.  
  Allowable values: for each underlying see
  <a href="#ss:underlying" data-reference-type="ref"
  data-reference="ss:underlying">[ss:underlying]</a>

- OptionData: relevant are the long/short flag, the call/put flag, the
  payoff type (must be set to AverageStrike to identify the payoff), and
  the exercise date (exactly one date must be given). `PayoffType2` can
  be optionally set to *Arithmetic* or *Geometric* and defaults to
  *Arithmetic* if not given. Furthermore, a *Premiums* node can be added
  to represent deterministic option premia to be paid by the option
  holder.  
  Allowable values: see
  <a href="#ss:option_data" data-reference-type="ref"
  data-reference="ss:option_data">[ss:option_data]</a> for the general
  structure of the option data node

- Settlement: the settlement date (optional, if not given defaults to
  the exercise date)  
  Allowable values: each valid date.

- ObservationDates: the observation dates for the average strike  
  Allowable values: See the definition in
  <a href="#ss:schedule_data" data-reference-type="ref"
  data-reference="ss:schedule_data">[ss:schedule_data]</a>

The representation as a scripted trade is as follows:

``` xml
<Trade id="AverageStrikeBasketOption#1">
  <TradeType>ScriptedTrade</TradeType>
  <Envelope/>
  <AverageStrikeBasketOptionData>
    <Expiry type="event">2020-02-15</Expiry>
    <Settlement type="event">2020-02-20</Settlement>
    <ObservationDates type="event">
      <ScheduleData>
        <Rules>
          <StartDate>2019-02-06</StartDate>
          <EndDate>2020-02-06</EndDate>
          <Tenor>1D</Tenor>
          <Calendar>US</Calendar>
          <Convention>F</Convention>
          <Rule>Forward</Rule>
        </Rules>
      </ScheduleData>
    </ObservationDates>
    <PutCall type="optionType">Call</PutCall>
    <LongShort type="longShort">Long</LongShort>
    <Notional type="number">1</Notional>
    <Underlyings type="index">
      <Value>EQ-RIC:.SPX</Value>
      <Value>EQ-RIC:.STOXX50E</Value>
    </Underlyings>
    <Weights type="number">
      <Value>1.0</Value>
      <Value>1.0</Value>
    </Weights>
    <PayCcy type="currency">USD</PayCcy>
  </AverageStrikeBasketOptionData>
</Trade>
```

The AverageStrikeBasketOption script referenced in the trade above is
shown in Listing
<a href="#lst:averagestrikebasketoption" data-reference-type="ref"
data-reference="lst:averagestrikebasketoption">[lst:averagestrikebasketoption]</a>.

<div class="listing">

``` Basic
REQUIRE SIZE(Underlyings) == SIZE(Weights);

NUMBER d, u, timeAverageBasketPrice, currentNotional;
FOR d IN (1, SIZE(ObservationDates)) DO
    FOR u IN (1, SIZE(Underlyings)) DO
        timeAverageBasketPrice = timeAverageBasketPrice
          + Underlyings[u](ObservationDates[d]) * Weights[u];
    END;
END;
timeAverageBasketPrice = timeAverageBasketPrice / SIZE(ObservationDates);

NUMBER expiryBasketPrice;
FOR u IN (1, SIZE(Underlyings)) DO
   expiryBasketPrice = expiryBasketPrice + Underlyings[u](Expiry) * Weights[u];
END;

NUMBER Payoff;
Payoff = max(PutCall * (expiryBasketPrice - timeAverageBasketPrice), 0);

Option = LongShort * Notional * PAY(Payoff, Expiry, Settlement, PayCcy);

NUMBER ExerciseProbability;
IF Payoff > 0 THEN
    ExerciseProbability = 1;
END;
FOR u IN (1, SIZE(Underlyings)) DO
  currentNotional = currentNotional + Notional * Underlyings[u](ObservationDates[1])
                                               * Weights[u];
END;
```

</div>

The meanings and allowable values of the elements in the
`AverageStrikeBasketOptionData` node are given below, with data type
indicated in square brackets.

- \[event\] `Expiry`: Option expiry date.  
  Allowable values: See `Date` in Table
  <a href="#tab:allow_stand_data" data-reference-type="ref"
  data-reference="tab:allow_stand_data">[tab:allow_stand_data]</a>.

- \[event\] `Settlement`: Option settlement date.  
  Allowable values: See `Date` in Table
  <a href="#tab:allow_stand_data" data-reference-type="ref"
  data-reference="tab:allow_stand_data">[tab:allow_stand_data]</a>.

- \[event\] `ObservationDates`: Price monitoring schedule.  
  Allowable values: See section
  <a href="#ss:schedule_data" data-reference-type="ref"
  data-reference="ss:schedule_data">[ss:schedule_data]</a> Schedule Data
  and Dates, or DerivedSchedule (see ore/Docs/ScriptedTrade).

- \[optionType\] `PutCall`: Option type with  
  Allowable values *Call, Put*.

- \[longShort\] `LongShort`: Position type, *Long* if we buy, *Short* if
  we sell.  
  Allowable values: *Long, Short*.

- \[number\] `Notional`: Quantity multiplier applied to the basket
  price  
  Allowable values: Any positive real number.

- \[index\] `Underlyings`: List of underlying indices enclosed by
  `<Value>` and `</Value>` tags.  
  Allowable values: See ore/Docs/ScriptedTrade’s Index Section for
  allowable values.

- \[number\] `Weights`: List of weights applied to the underlying prices
  in the basket, given in the same order as the Underlyings above, each
  weight enclosed by `<Value>` and `</Value>` tags.  
  Allowable values: Any positive real number.

- \[currency\] `PayCcy`: The payment currency. For FX, where the
  underlying is provided in the form `FX-SOURCE-CCY1-CCY2` (see Table
  <a href="#tab:fxindex_data" data-reference-type="ref"
  data-reference="tab:fxindex_data">[tab:fxindex_data]</a>) this should
  be `CCY2`. If `CCY1` or the currency of the underlying (for EQ and
  COMM underlyings), this will result in a quanto payoff. Notice section
  “Payment Currency” in ore/Docs/ScriptedTrade.  
  Allowable values: See Table
  <a href="#tab:currency" data-reference-type="ref"
  data-reference="tab:currency">[tab:currency]</a> `Currency` for
  allowable currency codes.

### Lookback Call Basket Option

The traditional trade representation is as follows, using an equity
underlying in this example:

``` xml
<Trade id="LookbackCallBasketOption#1">
  <TradeType>EquityBasketOption</TradeType>
  <Envelope>
    <CounterParty>CPTY_A</CounterParty>
    <NettingSetId>CPTY_A</NettingSetId>
    <AdditionalFields/>
  </Envelope>
  <EquityBasketOptionData>
    <Currency>USD</Currency>
    <Notional>1</Notional>
    <Underlyings>
      <Underlying>
        <Type>Equity</Type>
        <Name>RIC:.SPX</Name>
        <Currency>USD</Currency>
        <Weight>1.0</Weight>
      </Underlying>
      <Underlying>
        <Type>Equity</Type>
        <Name>RIC:.STOXX50E</Name>
        <Weight>1.0</Weight>
      </Underlying>
    </Underlyings>
    <OptionData>
      <LongShort>Long</LongShort>
      <PayoffType>LookbackCall</PayoffType>
      <ExerciseDates>
        <ExerciseDate>2020-02-15</ExerciseDate>
      </ExerciseDates>
      <Premiums> ... </Premiums>  
    </OptionData>
    <Settlement>2020-02-20</Settlement>
    <ObservationDates>
      <Rules>
        <StartDate>2019-02-06</StartDate>
        <EndDate>2020-02-06</EndDate>
        <Tenor>1D</Tenor>
        <Calendar>US</Calendar>
        <Convention>F</Convention>
        <TermConvention>F</TermConvention>
        <Rule>Forward</Rule>
      </Rules>
    </ObservationDates>
  </EquityBasketOptionData>
</Trade>
```

with the following elements:

- Currency: The pay currency. Notice section “Payment Currency” in
  ore/Docs/ScriptedTrade.  
  Allowable values: all supported currency codes, see Table
  <a href="#tab:currency" data-reference-type="ref"
  data-reference="tab:currency">[tab:currency]</a> `Currency`.

- Notional: The quantity (for equity, commodity underlyings) / foreign
  amount (fx underlying)  
  Allowable values: all positive real numbers

- Underlyings: The basket of underlyings.  
  Allowable values: for each underlying see
  <a href="#ss:underlying" data-reference-type="ref"
  data-reference="ss:underlying">[ss:underlying]</a>

- OptionData: relevant are the long/short flag, the payoff type (must be
  set to LookbackCall to identify the payoff), and the exercise date
  (exactly one date must be given). Furthermore, a *Premiums* node can
  be added to represent deterministic option premia to be paid by the
  option holder.  
  Allowable values: see
  <a href="#ss:option_data" data-reference-type="ref"
  data-reference="ss:option_data">[ss:option_data]</a> for the general
  structure of the option data node

- Settlement: the settlement date (optional, if not given defaults to
  the exercise date)  
  Allowable values: each valid date.

- ObservationDates: the observation dates for the lookback call  
  Allowable values: See the definition in
  <a href="#ss:schedule_data" data-reference-type="ref"
  data-reference="ss:schedule_data">[ss:schedule_data]</a>

The representation as a scripted trade is as follows:

``` xml
<Trade id="LookbackCallBasketOption#1">
  <TradeType>ScriptedTrade</TradeType>
  <Envelope/>
  <LookbackCallBasketOptionData>
    <Expiry type="event">2020-02-15</Expiry>
    <Settlement type="event">2020-02-20</Settlement>
    <ObservationDates type="event">
      <ScheduleData>
        <Rules>
          <StartDate>2019-02-06</StartDate>
          <EndDate>2020-02-06</EndDate>
          <Tenor>1D</Tenor>
          <Calendar>US</Calendar>
          <Convention>F</Convention>
          <Rule>Forward</Rule>
        </Rules>
      </ScheduleData>
    </ObservationDates>
    <LongShort type="longShort">Long</LongShort>
    <Notional type="number">1</Notional>
    <Underlyings type="index">
      <Value>EQ-RIC:.SPX</Value>
      <Value>EQ-RIC:.STOXX50E</Value>
    </Underlyings>
    <Weights type="number">
      <Value>1.0</Value>
      <Value>1.0</Value>
    </Weights>
    <PayCcy type="currency">USD</PayCcy>
  </LookbackCallBasketOptionData>
</Trade>
```

The LookbackCallBasketOption script referenced in the trade above is
shown in Listing
<a href="#lst:lookbackcallbasketoption" data-reference-type="ref"
data-reference="lst:lookbackcallbasketoption">[lst:lookbackcallbasketoption]</a>.

<div class="listing">

``` Basic
REQUIRE SIZE(Underlyings) == SIZE(Weights);

NUMBER d, u, basketPrice, minBasketPrice, currentNotional;
FOR d IN (1, SIZE(ObservationDates)) DO
    basketPrice = 0;
    FOR u IN (1, SIZE(Underlyings)) DO
        basketPrice = basketPrice + Underlyings[u](ObservationDates[d]) * Weights[u];
    END;
    IF d == 1 THEN
        minBasketPrice = basketPrice;
    END;
    IF basketPrice < minBasketPrice THEN
        minBasketPrice = basketPrice;
    END;
END;

NUMBER expiryBasketPrice;
FOR u IN (1, SIZE(Underlyings)) DO
   expiryBasketPrice = expiryBasketPrice + Underlyings[u](Expiry) * Weights[u];
END;

NUMBER Payoff;
Payoff = max(expiryBasketPrice - minBasketPrice, 0);

Option = LongShort * Notional * PAY(Payoff, Expiry, Settlement, PayCcy);

NUMBER ExerciseProbability;
IF Payoff > 0 THEN
    ExerciseProbability = 1;
END;
FOR u IN (1, SIZE(Underlyings)) DO
  currentNotional = currentNotional + Notional * Underlyings[u](ObservationDates[1])
                                               * Weights[u];
END;
```

</div>

The meanings and allowable values of the elements in the
`LookbackCallBasketOptionData` node are given below, with data type
indicated in square brackets.

- \[event\] `Expiry`: Option expiry date.  
  Allowable values: See `Date` in Table
  <a href="#tab:allow_stand_data" data-reference-type="ref"
  data-reference="tab:allow_stand_data">[tab:allow_stand_data]</a>.

- \[event\] `Settlement`: Option settlement date.  
  Allowable values: See `Date` in Table
  <a href="#tab:allow_stand_data" data-reference-type="ref"
  data-reference="tab:allow_stand_data">[tab:allow_stand_data]</a>.

- \[event\] `ObservationDates`: Price monitoring schedule.  
  Allowable values: See section
  <a href="#ss:schedule_data" data-reference-type="ref"
  data-reference="ss:schedule_data">[ss:schedule_data]</a> Schedule Data
  and Dates, or DerivedSchedule (see ore/Docs/ScriptedTrade).

- \[longShort\] `LongShort`: Position type, *Long* if we buy, *Short* if
  we sell.  
  Allowable values: *Long, Short*.

- \[number\] `Notional`: Quantity multiplier applied to the basket
  price  
  Allowable values: Any positive real number.

- \[index\] `Underlyings`: List of underlying indices enclosed by
  `<Value>` and `</Value>` tags.  
  Allowable values: See ore/Docs/ScriptedTrade’s Index Section for
  allowable values.

- \[number\] `Weights`: List of weights applied to the underlying prices
  in the basket, given in the same order as the Underlyings above, each
  weight enclosed by `<Value>` and `</Value>` tags.  
  Allowable values: Any positive real number.

- \[currency\] `PayCcy`: The payment currency. For FX, where the
  underlying is provided in the form `FX-SOURCE-CCY1-CCY2` (see Table
  <a href="#tab:fxindex_data" data-reference-type="ref"
  data-reference="tab:fxindex_data">[tab:fxindex_data]</a>) this should
  be `CCY2`. If `CCY1` or the currency of the underlying (for EQ and
  COMM underlyings), this will result in a quanto payoff. Notice section
  “Payment Currency” in ore/Docs/ScriptedTrade.  
  Allowable values: See Table
  <a href="#tab:currency" data-reference-type="ref"
  data-reference="tab:currency">[tab:currency]</a> `Currency` for
  allowable currency codes.

### Lookback Put Basket Option

The traditional trade representation is as follows, using an equity
underlying in this example:

``` xml
<Trade id="LookbackPutBasketOption#1">
  <TradeType>EquityBasketOption</TradeType>
  <Envelope>
    <CounterParty>CPTY_A</CounterParty>
    <NettingSetId>CPTY_A</NettingSetId>
    <AdditionalFields/>
  </Envelope>
  <EquityBasketOptionData>
    <Currency>USD</Currency>
    <Notional>1</Notional>
    <Underlyings>
      <Underlying>
        <Type>Equity</Type>
        <Name>RIC:.SPX</Name>
        <Currency>USD</Currency>
        <Weight>1.0</Weight>
      </Underlying>
      <Underlying>
        <Type>Equity</Type>
        <Name>RIC:.STOXX50E</Name>
        <Weight>1.0</Weight>
      </Underlying>
    </Underlyings>
    <OptionData>
      <LongShort>Long</LongShort>
      <PayoffType>LookbackPut</PayoffType>
      <ExerciseDates>
        <ExerciseDate>2020-02-15</ExerciseDate>
      </ExerciseDates>
      <Premiums> ... </Premiums>  
    </OptionData>
    <Settlement>2020-02-20</Settlement>
    <ObservationDates>
      <Rules>
        <StartDate>2019-02-06</StartDate>
        <EndDate>2020-02-06</EndDate>
        <Tenor>1D</Tenor>
        <Calendar>US</Calendar>
        <Convention>F</Convention>
        <TermConvention>F</TermConvention>
        <Rule>Forward</Rule>
      </Rules>
    </ObservationDates>
  </EquityBasketOptionData>
</Trade>
```

with the following elements:

- Currency: The pay currency. Notice section “Payment Currency” in
  ore/Docs/ScriptedTrade.  
  Allowable values: all supported currency codes, see Table
  <a href="#tab:currency" data-reference-type="ref"
  data-reference="tab:currency">[tab:currency]</a> `Currency`.

- Notional: The quantity (for equity, commodity underlyings) / foreign
  amount (fx underlying)  
  Allowable values: all positive real numbers

- Underlyings: The basket of underlyings.  
  Allowable values: for each underlying see
  <a href="#ss:underlying" data-reference-type="ref"
  data-reference="ss:underlying">[ss:underlying]</a>

- OptionData: relevant are the long/short flag, the payoff type (must be
  set to LookbackPut to identify the payoff), and the exercise date
  (exactly one date must be given). Furthermore, a *Premiums* node can
  be added to represent deterministic option premia to be paid by the
  option holder.  
  Allowable values: see
  <a href="#ss:option_data" data-reference-type="ref"
  data-reference="ss:option_data">[ss:option_data]</a> for the general
  structure of the option data node

- Settlement: the settlement date (optional, if not given defaults to
  the exercise date)  
  Allowable values: each valid date.

- ObservationDates: the observation dates for the lookback call  
  Allowable values: See the definition in
  <a href="#ss:schedule_data" data-reference-type="ref"
  data-reference="ss:schedule_data">[ss:schedule_data]</a>

The representation as a scripted trade is as follows:

``` xml
<Trade id="LookbackPutBasketOption#1">
  <TradeType>ScriptedTrade</TradeType>
  <Envelope/>
   <LookbackPutBasketOptionData>
    <Expiry type="event">2020-02-15</Expiry>
    <Settlement type="event">2020-02-20</Settlement>
    <ObservationDates type="event">
      <ScheduleData>
        <Rules>
          <StartDate>2019-02-06</StartDate>
          <EndDate>2020-02-06</EndDate>
          <Tenor>1D</Tenor>
          <Calendar>US</Calendar>
          <Convention>F</Convention>
          <Rule>Forward</Rule>
        </Rules>
      </ScheduleData>
    </ObservationDates>
    <LongShort type="longShort">Long</LongShort>
    <Notional type="number">1</Notional>
    <Underlyings type="index">
      <Value>EQ-RIC:.SPX</Value>
      <Value>EQ-RIC:.STOXX50E</Value>
    </Underlyings>
    <Weights type="number">
      <Value>1.0</Value>
      <Value>1.0</Value>
    </Weights>
    <PayCcy type="currency">USD</PayCcy>
  </LookbackPutBasketOptionData>
</Trade>
```

The LookbackCallBasketOption script referenced in the trade above is
shown in Listing
<a href="#lst:lookbackputbasketoption" data-reference-type="ref"
data-reference="lst:lookbackputbasketoption">[lst:lookbackputbasketoption]</a>.

<div class="listing">

``` Basic
REQUIRE SIZE(Underlyings) == SIZE(Weights);

NUMBER d, u, basketPrice, maxBasketPrice;
FOR d IN (1, SIZE(ObservationDates)) DO
    basketPrice = 0;
    FOR u IN (1, SIZE(Underlyings)) DO
        basketPrice = basketPrice + Underlyings[u](ObservationDates[d]) * Weights[u];
    END;
    IF d == 1 THEN
        maxBasketPrice = basketPrice;
    END;
    IF basketPrice > maxBasketPrice THEN
        maxBasketPrice = basketPrice;
    END;
END;

NUMBER expiryBasketPrice, Payoff;
FOR u IN (1, SIZE(Underlyings)) DO
   expiryBasketPrice = expiryBasketPrice + Underlyings[u](Expiry) * Weights[u];
END;

Payoff = max(maxBasketPrice - expiryBasketPrice, 0);
Option = LongShort * Notional * LOGPAY(Payoff, Expiry, Settlement, PayCcy);
```

</div>

The meanings and allowable values of the elements in the
`LookbackPutBasketOptionData` node are given below, with data type
indicated in square brackets.

- \[event\] `Expiry`: Option expiry date.  
  Allowable values: See `Date` in Table
  <a href="#tab:allow_stand_data" data-reference-type="ref"
  data-reference="tab:allow_stand_data">[tab:allow_stand_data]</a>.

- \[event\] `Settlement`: Option settlement date.  
  Allowable values: See `Date` in Table
  <a href="#tab:allow_stand_data" data-reference-type="ref"
  data-reference="tab:allow_stand_data">[tab:allow_stand_data]</a>.

- \[event\] `ObservationDates`: Price monitoring schedule.  
  Allowable values: See section
  <a href="#ss:schedule_data" data-reference-type="ref"
  data-reference="ss:schedule_data">[ss:schedule_data]</a> Schedule Data
  and Dates, or DerivedSchedule (see ore/Docs/ScriptedTrade).

- \[longShort\] `LongShort`: Position type, *Long* if we buy, *Short* if
  we sell.  
  Allowable values: *Long, Short*.

- \[number\] `Notional`: Quantity multiplier applied to the basket
  price  
  Allowable values: Any positive real number.

- \[index\] `Underlyings`: List of underlying indices enclosed by
  `<Value>` and `</Value>` tags.  
  Allowable values: See ore/Docs/ScriptedTrade’s Index Section for
  allowable values.

- \[number\] `Weights`: List of weights applied to the underlying prices
  in the basket, given in the same order as the Underlyings above, each
  weight enclosed by `<Value>` and `</Value>` tags.  
  Allowable values: Any positive real number.

- \[currency\] `PayCcy`: The payment currency. For FX, where the
  underlying is provided in the form `FX-SOURCE-CCY1-CCY2` (see Table
  <a href="#tab:fxindex_data" data-reference-type="ref"
  data-reference="tab:fxindex_data">[tab:fxindex_data]</a>) this should
  be `CCY2`. If `CCY1` or the currency of the underlying (for EQ and
  COMM underlyings), this will result in a quanto payoff. Notice section
  “Payment Currency” in ore/Docs/ScriptedTrade.  
  Allowable values: See Table
  <a href="#tab:currency" data-reference-type="ref"
  data-reference="tab:currency">[tab:currency]</a> `Currency` for
  allowable currency codes.
