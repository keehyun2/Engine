### Rainbow Options

Rainbow options are European calls or puts on the maximum or minimum of
of a range of assets. We denote the prices of $n$ assets at expiry
$S_1, S_2,\ldots,
S_n$ and initial prices $S_1^0, S_2^2,\ldots,S_n^0$ with respective
constant weights $w_1$,…,$w_n$. The payoff at expiry of the rainbow
options covered here is

Rainbow Options are represented as traditional trades or *scripted
trades*, refer to the scripted trade documentation in
ore/Docs/ScriptedTrade for an introduction of the latter. Each of the
supported variations, all European style, is represented by a separate
payoff script as shown in Table
<a href="#tab:rainbowoptions" data-reference-type="ref"
data-reference="tab:rainbowoptions">1</a> (excluding Rainbow Call Spread
Options and Worst Performance Rainbow Options).

<div class="center">

<div id="tab:rainbowoptions">

| Rainbow Option Payoff                               | Payoff Script Name              |
|:----------------------------------------------------|:--------------------------------|
| $\max(w_1 S_1,\ldots, w_n S_n, K)$                  | BestOfAssetOrCashRainbowOption  |
| $\min(w_1 S_1,\ldots, w_n S_n, K)$                  | WorstOfAssetOrCashRainbowOption |
| $\max(\omega(\max(w_1 S_1,\ldots, w_n S_n) - K, 0)$ | MaxRainbowOption                |
| $\max(\omega(\min(w_1 S_1,\ldots, w_n S_n) - K, 0)$ | MinRainbowOption                |

Rainbow option types and associated script names. $\omega=\pm 1$
distinguishes call (+1) and put (-1).

</div>

</div>

The supported underlying types are Equity, Fx or Commodity resulting in
corresponding trade types and trade data container names

- EquityRainbowOption / EquityRainbowOptionData

- FxRainbowOption / FxRainbowOptionData

- CommodityRainbowOption / CommodityRainbowOptionData

Trade input and the associated payoff script are described in the
following for 12 supported Rainbow Option variations.

### Best Of Asset Or Cash Rainbow Option

The traditional trade representation is as follows, using an equity
underlying in this example:

``` xml
<Trade id="BestOfAssetOrCashRainbowOption#1">
  <TradeType>EquityRainbowOption</TradeType>
  <Envelope>
    <CounterParty>CPTY_A</CounterParty>
    <NettingSetId>CPTY_A</NettingSetId>
    <AdditionalFields/>
  </Envelope>
  <EquityRainbowOptionData>
    <Currency>USD</Currency>
    <Notional>1</Notional>
    <Strike>2000</Strike>
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
      <PayoffType>BestOfAssetOrCash</PayoffType>
      <ExerciseDates>
        <ExerciseDate>2020-02-15</ExerciseDate>
      </ExerciseDates>
    </OptionData>
    <Settlement>2020-02-20</Settlement>
  </EquityRainbowOptionData>
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

- OptionData: relevant are the long/short flag, the payoff type (must be
  set to BestOfAssetOrCash to identify the payoff), and the exercise
  date (exactly one date must be given)  
  Allowable values: see
  <a href="#ss:option_data" data-reference-type="ref"
  data-reference="ss:option_data">[ss:option_data]</a> for the general
  structure of the option data node

- Settlement: the settlement date (optional, if not given defaults to
  the exercise date)  
  Allowable values: each valid date.

The representation as a scripted trade is as follows:

``` xml
<Trade id="BestOfAssetOrCashRainbowOption#1">
  <TradeType>ScriptedTrade</TradeType>
  <Envelope/>
  <BestOfAssetOrCashRainbowOptionData>
    <Expiry type="event">2020-02-15</Expiry>
    <Settlement type="event">2020-02-20</Settlement>
    <LongShort type="longShort">Long</LongShort>
    <Notional type="number">1</Notional>
    <Strike type="number">2000</Strike>
    <Underlyings type="index">
      <Value>EQ-RIC:.SPX</Value>
      <Value>EQ-RIC:.STOXX50E</Value>
    </Underlyings>
    <Weights type="number">
      <Value>1.0</Value>
      <Value>1.0</Value>
    </Weights>
    <PayCcy type="currency">USD</PayCcy>
  </BestOfAssetOrCashRainbowOptionData>
</Trade>
```

The BestOfAssetOrCashRainbowOption script referenced in the trade above
is shown in Listing
<a href="#lst:bestofassetorcashrainbowoption" data-reference-type="ref"
data-reference="lst:bestofassetorcashrainbowoption">[lst:bestofassetorcashrainbowoption]</a>.

<div class="listing">

``` Basic
REQUIRE SIZE(Underlyings) == SIZE(Weights);
NUMBER u, thisPrice, bestPrice, Payoff, currentNotional;
bestPrice = Strike;
FOR u IN (1, SIZE(Underlyings)) DO
    thisPrice = Underlyings[u](Expiry) * Weights[u];
    IF thisPrice > bestPrice THEN
        bestPrice = thisPrice;
    END;
END;
Option = LongShort * Notional * PAY(bestPrice, Expiry, Settlement, PayCcy);
currentNotional = Notional * Strike;
```

</div>

The meanings and allowable values of the elements in the
`BestOfAssetOrCashRainbowOptionData` node are given below, with data
type indicated in square brackets.

- \[event\] `Expiry`: Option expiry date.  
  Allowable values: See `Date` in Table
  <a href="#tab:allow_stand_data" data-reference-type="ref"
  data-reference="tab:allow_stand_data">[tab:allow_stand_data]</a>.

- \[event\] `Settlement`: Option settlement date.  
  Allowable values: See `Date` in Table
  <a href="#tab:allow_stand_data" data-reference-type="ref"
  data-reference="tab:allow_stand_data">[tab:allow_stand_data]</a>.

- \[longShort\] `LongShort`: Position type, *Long* if we buy, *Short* if
  we sell.  
  Allowable values: *Long, Short*.

- \[number\] `Notional`: Quantity multiplier applied to the basket
  price  
  Allowable values: Any positive real number.

- \[number\] `Strike`: Strike price in PayCcy (see below)  
  Allowable values: Any positive real number.

- \[index\] `Underlyings`: List of underlying indices enclosed by
  `<Value>` and `</Value>` tags.  
  Allowable values: See ore/Docs/ScriptedTrade’s Index Section for
  allowable values.

- \[number\] `Weights`: List of weights applied to each of the
  underlying prices, given in the same order as the Underlyings above,
  each weighted enclosed by `<Value>` and `</Value>` tags.  
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
  data-reference="tab:currency">[tab:currency]</a> for allowable
  currency codes.

### Worst Of Asset Or Cash Rainbow Option

The traditional trade representation is as follows, using an equity
underlying in this example:

``` xml
<Trade id="WorstOfAssetOrCashRainbowOption#1">
  <TradeType>EquityRainbowOption</TradeType>
  <Envelope>
    <CounterParty>CPTY_A</CounterParty>
    <NettingSetId>CPTY_A</NettingSetId>
    <AdditionalFields/>
  </Envelope>
  <EquityRainbowOptionData>
    <Currency>USD</Currency>
    <Notional>1</Notional>
    <Strike>2000</Strike>
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
      <PayoffType>WorstOfAssetOrCash</PayoffType>
      <ExerciseDates>
        <ExerciseDate>2020-02-15</ExerciseDate>
      </ExerciseDates>
    </OptionData>
    <Settlement>2020-02-20</Settlement>
  </EquityRainbowOptionData>
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

- OptionData: relevant are the long/short flag, the payoff type (must be
  set to WorstOfAssetOrCash to identify the payoff), and the exercise
  date (exactly one date must be given)  
  Allowable values: see
  <a href="#ss:option_data" data-reference-type="ref"
  data-reference="ss:option_data">[ss:option_data]</a> for the general
  structure of the option data node

- Settlement: the settlement date (optional, if not given defaults to
  the exercise date)  
  Allowable values: each valid date.

The representation as a scripted trade is as follows:

``` xml
<Trade id="WorstOfAssetOrCashRainbowOption#1">
  <TradeType>ScriptedTrade</TradeType>
  <Envelope/>
  <WorstOfAssetOrCashRainbowOptionData>
    <Expiry type="event">2020-02-15</Expiry>
    <Settlement type="event">2020-02-20</Settlement>
    <LongShort type="longShort">Long</LongShort>
    <Notional type="number">1</Notional>
    <Strike type="number">2000</Strike>
    <Underlyings type="index">
      <Value>EQ-RIC:.SPX</Value>
      <Value>EQ-RIC:.STOXX50E</Value>
    </Underlyings>
    <Weights type="number">
      <Value>1.0</Value>
      <Value>1.0</Value>
    </Weights>
    <PayCcy type="currency">USD</PayCcy>
  </WorstOfAssetOrCashRainbowOptionData>
</Trade>
```

The WorstOfAssetOrCashRainbowOption script referenced in the trade above
is shown in Listing
<a href="#lst:worstofassetorcashrainbowoption" data-reference-type="ref"
data-reference="lst:worstofassetorcashrainbowoption">[lst:worstofassetorcashrainbowoption]</a>.

<div class="listing">

``` Basic
REQUIRE SIZE(Underlyings) == SIZE(Weights);
NUMBER u, thisPrice, worstPrice, Payoff, currentNotional;
worstPrice = Strike;
FOR u IN (1, SIZE(Underlyings)) DO
    thisPrice = Underlyings[u](Expiry) * Weights[u];
    IF thisPrice < worstPrice THEN
        worstPrice = thisPrice;
    END;
END;
Option = LongShort * Notional * PAY(worstPrice, Expiry, Settlement, PayCcy);
currentNotional = Notional * Strike;
```

</div>

The meanings and allowable values of the elements in the
`BestOfAssetOrCashRainbowOptionData` node are given below, with data
type indicated in square brackets.

- \[event\] `Expiry`: Option expiry date.  
  Allowable values: See `Date` in Table
  <a href="#tab:allow_stand_data" data-reference-type="ref"
  data-reference="tab:allow_stand_data">[tab:allow_stand_data]</a>.

- \[event\] `Settlement`: Option settlement date.  
  Allowable values: See `Date` in Table
  <a href="#tab:allow_stand_data" data-reference-type="ref"
  data-reference="tab:allow_stand_data">[tab:allow_stand_data]</a>.

- \[longShort\] `LongShort`: Position type, *Long* if we buy, *Short* if
  we sell.  
  Allowable values: *Long, Short*.

- \[number\] `Notional`: Quantity multiplier applied to the basket
  price  
  Allowable values: Any positive real number.

- \[number\] `Strike`: Strike price in PayCcy (see below)  
  Allowable values: Any positive real number.

- \[index\] `Underlyings`: List of underlying indices enclosed by
  `<Value>` and `</Value>` tags.  
  Allowable values: See ore/Docs/ScriptedTrade’s Index Section for
  allowable values.

- \[number\] `Weights`: List of weights applied to each of the
  underlying prices, given in the same order as the Underlyings above,
  each weighted enclosed by `<Value>` and `</Value>` tags.  
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
  data-reference="tab:currency">[tab:currency]</a> for allowable
  currency codes.

### Put/Call on Max Rainbow Option

The traditional trade representation is as follows, using an equity
underlying in this example:

``` xml
<Trade id="MaxRainbowOption#1">
  <TradeType>EquityRainbowOption</TradeType>
  <Envelope>
    <CounterParty>CPTY_A</CounterParty>
    <NettingSetId>CPTY_A</NettingSetId>
    <AdditionalFields/>
  </Envelope>
  <EquityRainbowOptionData>
    <Currency>USD</Currency>
    <Notional>1</Notional>
    <Strike>3000</Strike>
    <Underlyings>
      <Underlying>
        <Type>Equity</Type>
        <Name>RIC:.SPX</Name>
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
      <PayoffType>MaxRainbow</PayoffType>
      <ExerciseDates>
        <ExerciseDate>2020-02-15</ExerciseDate>
      </ExerciseDates>
    </OptionData>
    <Settlement>2020-02-20</Settlement>
  </EquityRainbowOptionData>
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

- OptionData: relevant are the long/short flag, the option type, the
  payoff type (must be set to MaxRainbow to identify the payoff), and
  the exercise date (exactly one date must be given)  
  Allowable values: see
  <a href="#ss:option_data" data-reference-type="ref"
  data-reference="ss:option_data">[ss:option_data]</a> for the general
  structure of the option data node

- Settlement: the settlement date (optional, if not given defaults to
  the exercise date)  
  Allowable values: each valid date.

The representation as a scripted trade is as follows:

``` xml
<Trade id="MaxRainbowOption#1">
  <TradeType>ScriptedTrade</TradeType>
  <Envelope/>
  <MaxRainbowOptionData>
    <Expiry type="event">2020-02-15</Expiry>
    <Settlement type="event">2020-02-20</Settlement>
    <PutCall type="optionType">Call</PutCall>
    <LongShort type="longShort">Long</LongShort>
    <Notional type="number">1</Notional>
    <Strike type="number">3000</Strike>
    <Underlyings type="index">
      <Value>EQ-RIC:.SPX</Value>
      <Value>EQ-RIC:.STOXX50E</Value>
    </Underlyings>
    <Weights type="number">
      <Value>1.0</Value>
      <Value>1.0</Value>
    </Weights>
    <PayCcy type="currency">USD</PayCcy>
  </MaxRainbowOptionData>
</Trade>
```

The MainRainbowOption script referenced in the trade above is shown in
Listing <a href="#lst:maxrainbowoption" data-reference-type="ref"
data-reference="lst:maxrainbowoption">[lst:maxrainbowoption]</a>.

<div class="listing">

``` Basic
REQUIRE SIZE(Underlyings) == SIZE(Weights);

NUMBER u, thisPrice, maxPrice, Payoff, ExerciseProbability, currentNotional;
maxPrice = 0;
FOR u IN (1, SIZE(Underlyings)) DO
    thisPrice = Underlyings[u](Expiry) * Weights[u];
    IF thisPrice > maxPrice THEN
        maxPrice = thisPrice;
    END;
END;

Payoff = max(PutCall * (maxPrice - Strike), 0);

Option = LongShort * Notional * PAY(Payoff, Expiry, Settlement, PayCcy);

IF Payoff > 0 THEN
    ExerciseProbability = 1;
END;
currentNotional = Notional * Strike;
```

</div>

The meanings and allowable values of the elements in the
`MaxRainbowOptionData` node are given below, with data type indicated in
square brackets.

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

- \[number\] `Strike`: Strike price in PayCcy (see below)  
  Allowable values: Any positive real number.

- \[index\] `Underlyings`: List of underlying indices enclosed by
  `<Value>` and `</Value>` tags.  
  Allowable values: See ore/Docs/ScriptedTrade’s Index Section for
  allowable values.

- \[number\] `Weights`: List of weights applied to each of the
  underlying prices, given in the same order as the Underlyings above,
  each weight enclosed by `<Value>` and `</Value>` tags.  
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
  data-reference="tab:currency">[tab:currency]</a> for allowable
  currency codes.

### Put/Call on Min Rainbow Option

The traditional trade representation is as follows, using an equity
underlying in this example:

``` xml
<Trade id="MinRainbowOption#1">
  <TradeType>EquityRainbowOption</TradeType>
  <Envelope>
    <CounterParty>CPTY_A</CounterParty>
    <NettingSetId>CPTY_A</NettingSetId>
    <AdditionalFields/>
  </Envelope>
  <EquityRainbowOptionData>
    <Currency>USD</Currency>
    <Notional>1</Notional>
    <Strike>2000</Strike>
    <Underlyings>
      <Underlying>
        <Type>Equity</Type>
        <Name>RIC:.SPX</Name>
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
      <PayoffType>MinRainbow</PayoffType>
      <ExerciseDates>
        <ExerciseDate>2020-02-15</ExerciseDate>
      </ExerciseDates>
    </OptionData>
    <Settlement>2020-02-20</Settlement>
  </EquityRainbowOptionData>
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

- OptionData: relevant are the long/short flag, the option type, the
  payoff type (must be set to MaxRainbow to identify the payoff), and
  the exercise date (exactly one date must be given)  
  Allowable values: see
  <a href="#ss:option_data" data-reference-type="ref"
  data-reference="ss:option_data">[ss:option_data]</a> for the general
  structure of the option data node

- Settlement: the settlement date (optional, if not given defaults to
  the exercise date)  
  Allowable values: each valid date.

The representation as a scripted trade is as follows:

``` xml
<Trade id="MinRainbowOption#1">
  <TradeType>ScriptedTrade</TradeType>
  <Envelope/>
   <MinRainbowOptionData>
    <Expiry type="event">2020-02-15</Expiry>
    <Settlement type="event">2020-02-20</Settlement>
    <PutCall type="optionType">Call</PutCall>
    <LongShort type="longShort">Long</LongShort>
    <Notional type="number">1</Notional>
    <Strike type="number">2000</Strike>
    <Underlyings type="index">
      <Value>EQ-RIC:.SPX</Value>
      <Value>EQ-RIC:.STOXX50E</Value>
    </Underlyings>
    <Weights type="number">
      <Value>1.0</Value>
      <Value>1.0</Value>
    </Weights>
    <PayCcy type="currency">USD</PayCcy>
  </MinRainbowOptionData>
</Trade>
```

The MinRainbowOption script referenced in the trade above is shown in
Listing <a href="#lst:minrainbowoption" data-reference-type="ref"
data-reference="lst:minrainbowoption">[lst:minrainbowoption]</a>.

<div class="listing">

``` Basic
REQUIRE SIZE(Underlyings) == SIZE(Weights);
REQUIRE SIZE(Underlyings) > 0;

NUMBER u, thisPrice, minPrice, Payoff, ExerciseProbability, currentNotional;
minPrice = Underlyings[1](Expiry) * Weights[1];
FOR u IN (1, SIZE(Underlyings)) DO
    thisPrice = Underlyings[u](Expiry) * Weights[u];
    IF thisPrice < minPrice THEN
        minPrice = thisPrice;
    END;
END;

Payoff = max(PutCall * (minPrice - Strike), 0);

Option = LongShort * Notional * PAY(Payoff, Expiry, Settlement, PayCcy);

IF Payoff > 0 THEN
    ExerciseProbability = 1;
END;
currentNotional = Notional * Strike;
```

</div>

The meanings and allowable values of the elements in the
`MinRainbowOptionData` node are given below, with data type indicated in
square brackets.

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

- \[number\] `Strike`: Strike price in PayCcy (see below)  
  Allowable values: Any positive real number.

- \[index\] `Underlyings`: List of underlying indices enclosed by
  `<Value>` and `</Value>` tags.  
  Allowable values: See ore/Docs/ScriptedTrade’s Index Section for
  allowable values.

- \[number\] `Weights`: List of weights applied to each of the
  underlying prices, given in the same order as the Underlyings above,
  each weight enclosed by `<Value>` and `</Value>` tags.  
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
  data-reference="tab:currency">[tab:currency]</a> for allowable
  currency codes.

### European Rainbow Call Spread Option

European rainbow call spread options are represented as *scripted
trades*, refer to the scripted trade documentation in
ore/Docs/ScriptedTrade for an introduction.

Trade input and the payoff script are described below.

``` xml
  <TradeType>ScriptedTrade</TradeType>
  <Envelope/>
  <EuropeanRainbowCallSpreadOptionData>
    <Expiry type="event">2020-02-15</Expiry>
    <Settlement type="event">2020-02-20</Settlement>
    <LongShort type="longShort">Long</LongShort>
    <Notional type="number">1000000</Notional>
    <Underlyings type="index">
      <Value>EQ-RIC:.SPX</Value>
      <Value>EQ-RIC:.STOXX50E</Value>
    </Underlyings>
    <InitialStrikes type="number">
      <Value>2100</Value>
      <Value>3000</Value>
    </InitialStrikes>
    <Weights type="number">
      <Value>0.8</Value>
      <Value>0.3</Value>
    </Weights>
    <Floor type="number">0.02</Floor>
    <Cap type="number">0.10</Cap>
    <PayCcy type="currency">USD</PayCcy>
  </EuropeanRainbowCallSpreadOptionData>
```

The EuropeanRainbowCallSpreadOption script referenced in the trade above
is shown in listing <a href="#lst:european_rainbow_call_spread_option"
data-reference-type="ref"
data-reference="lst:european_rainbow_call_spread_option">[lst:european_rainbow_call_spread_option]</a>.

<div class="listing">

``` Basic
REQUIRE SIZE(Underlyings) == SIZE(Weights);
NUMBER perf[SIZE(Underlyings)], return, u;
FOR u IN (1, SIZE(Underlyings)) DO
  perf[u] = Underlyings[u](Expiry) / InitialStrikes[u];
END;
SORT (perf);
FOR u IN (1, SIZE(Underlyings)) DO
  return = return + Weights[u] * perf[SIZE(Underlyings) + 1 - u];
END;
Option = PAY( Notional * min( max( Floor, return - 1 ), Cap ), Expiry,
                                                  Settlement, PayCcy );
```

</div>

The meanings and allowable values of the elements in the
`EuropeanRainbowCallSpreadOptionData` node below.

- \[event\] `Expiry`: Option expiry date.  
  Allowable values: See `Date` in Table
  <a href="#tab:allow_stand_data" data-reference-type="ref"
  data-reference="tab:allow_stand_data">[tab:allow_stand_data]</a>.

- \[event\] `Settlement`: Option settlement date.  
  Allowable values: See `Date` in Table
  <a href="#tab:allow_stand_data" data-reference-type="ref"
  data-reference="tab:allow_stand_data">[tab:allow_stand_data]</a>.

- \[longShort\] `LongShort`: long short flag.  
  Allowable values: Long, Short

- \[number\] `Notional`: The notional.  
  Allowable values: A real number.

- \[index\] `Underlyings`: The underlyings.  
  Allowable values: See ore/Docs/ScriptedTrade’s Index Section for
  allowable values.

- \[number\] `InitialStrikes`: The initial strikes of the underlyings.  
  Allowable values: A real number for each underlying.

- \[number\] `Weights`: The weights for the best, second best, ...,
  worst performing underlying.  
  Allowable values: A real number for each rank.

- \[number\] `Floor`: The floor. If no floor applies, use e.g. -1E10.
  Allowable values: A real number.

- \[number\] `Cap`: The floor. If no floor applies, use e.g. 1E10.
  Allowable values: A real number.

- \[currency\] `PayCcy`: The payment currency. For FX, where the
  underlying is provided in the form `FX-SOURCE-CCY1-CCY2` (see Table
  <a href="#tab:fxindex_data" data-reference-type="ref"
  data-reference="tab:fxindex_data">[tab:fxindex_data]</a>) this should
  be `CCY2`. If `CCY1` or the currency of the underlying (for EQ and
  COMM underlyings), this will result in a quanto payoff. Notice section
  “Payment Currency” in ore/Docs/ScriptedTrade.  
  Allowable values: See Table
  <a href="#tab:currency" data-reference-type="ref"
  data-reference="tab:currency">[tab:currency]</a> for allowable
  currency codes.

### Rainbow Call Spread Barrier Option

A rainbow call spread barrier option is an extension of the European
Rainbow Call Spread Option, and is represented as *scripted trades*,
refer to the scripted trade documentation in ore/Docs/ScriptedTrade for
an introduction.

Trade input and the payoff script are described below.

``` xml
  <TradeType>ScriptedTrade</TradeType>
  <Envelope>
    <CounterParty>CPTY_A</CounterParty>
    <NettingSetId>CPTY_A</NettingSetId>
    <AdditionalFields/>
  </Envelope>
  <RainbowCallSpreadBarrierOptionData>
    <Expiry type="event">2020-02-15</Expiry>
    <Settlement type="event">2020-02-20</Settlement>
    <LongShort type="longShort">Long</LongShort>
    <Notional type="number">1000000</Notional>
    <Underlyings type="index">
      <Value>EQ-RIC:.SPX</Value>
      <Value>EQ-RIC:.STOXX50E</Value>
    </Underlyings>
    <InitialPrices type="number">
      <Value>2100</Value>
      <Value>3000</Value>
    </InitialPrices>
    <Weights type="number">
      <Value>0.8</Value>
      <Value>0.3</Value>
    </Weights>
    <Strike type="number">1.0</Strike>
    <Floor type="number">0.02</Floor>
    <Cap type="number">0.10</Cap>
    <Gearing type="number">1.0</Gearing>
    <BermudanBarrier type="bool">false</BermudanBarrier>
    <BarrierLevel type="number">1000.0</BarrierLevel>
    <BarrierSchedule type="event">
      <ScheduleData>
        <Rules>
          <StartDate>2018-12-31</StartDate>
          <EndDate>2020-02-15</EndDate>
          <Tenor>1M</Tenor>
          <Calendar>USD</Calendar>
          <Convention>ModifiedFollowing</Convention>
          <TermConvention>ModifiedFollowing</TermConvention>
          <Rule>Forward</Rule>
        </Rules>
      </ScheduleData>
    </BarrierSchedule>
    <PayCcy type="currency">USD</PayCcy>
  </RainbowCallSpreadBarrierOptionData>
```

The EuropeanRainbowCallSpreadOption script referenced in the trade above
is shown in listing <a href="#lst:rainbow_call_spread_barrier_option"
data-reference-type="ref"
data-reference="lst:rainbow_call_spread_barrier_option">[lst:rainbow_call_spread_barrier_option]</a>.

<div class="listing">

``` Basic
REQUIRE SIZE(Underlyings) == SIZE(Weights);
REQUIRE Floor <= Cap;
NUMBER performance, perf[SIZE(Underlyings)], return, u, d, payoff, knockedIn;

FOR u IN (1, SIZE(Underlyings), 1) DO
  perf[u] = Underlyings[u](Expiry) / InitialPrices[u];
END;
SORT (perf);

FOR u IN (1, SIZE(Underlyings), 1) DO
  return = return + Weights[u] * perf[SIZE(Underlyings) + 1 - u];
END;

IF BermudanBarrier == 1 THEN
  FOR d IN (1, SIZE(BarrierSchedule), 1) DO
    IF knockedIn == 0 THEN
      FOR u IN (1, SIZE(Underlyings), 1) DO
        performance = Underlyings[u](BarrierSchedule[d]) / InitialPrices[u];
        IF performance <= BarrierLevel THEN
          knockedIn = 1;
        END;
      END;
    END;
  END;
ELSE
  FOR u IN (1, SIZE(perf), 1) DO
    IF perf[u] <= BarrierLevel THEN
      knockedIn = 1;
    END;
  END;
END;

payoff = min( max( Floor, return - Strike ), Cap );
Option = LongShort * PAY(Notional * Gearing * payoff * knockedIn,
                         Expiry, Settlement, PayCcy);
```

</div>

The meanings and allowable values of the elements in the
`RainbowCallSpreadBarrierOptionData` node below.

- \[event\] `Expiry`: Option expiry date.  
  Allowable values: See `Date` in Table
  <a href="#tab:allow_stand_data" data-reference-type="ref"
  data-reference="tab:allow_stand_data">[tab:allow_stand_data]</a>.

- \[event\] `Settlement`: Option settlement date.  
  Allowable values: See `Date` in Table
  <a href="#tab:allow_stand_data" data-reference-type="ref"
  data-reference="tab:allow_stand_data">[tab:allow_stand_data]</a>.

- \[longShort\] `LongShort`: long short flag.  
  Allowable values: *Long*, *Short*

- \[number\] `Notional`: The notional.  
  Allowable values: A real number.

- \[index\] `Underlyings`: The underlyings.  
  Allowable values: See ore/Docs/ScriptedTrade’s Index Section for
  allowable values.

- \[number\] `InitialPrices`: The initial prices of the underlyings.  
  Allowable values: A real number for each underlying.

- \[number\] `Weights`: The weights for the best, second best, ...,
  worst performing underlying.  
  Allowable values: A real number for each rank.

- \[number\] `Strike`: The option strike price.  
  Allowable values: Any number, as a percentage expressed in decimal
  form.

- \[number\] `Floor`: The floor. If no floor applies, use e.g. -1E10.  
  Allowable values: A real number.

- \[number\] `Cap`: The floor. If no floor applies, use e.g. 1E10.  
  Allowable values: A real number.

- \[number\] `Gearing`: The gearing/payoff multiplier, applied after the
  cap and/or floor.  
  Allowable values: A real number.

- \[bool\] `BermudanBarrier`: Whether the KI barrier observation is
  Bermudan (*True*) or European (*False*).  
  Allowable values: *True* or *False*.

- \[number\] `BarrierLevel`: The agreed knock-in barrier price level.  
  Allowable values: Any number.

- \[event\] `BarrierSchedule`: If `BermudanBarrier` is *True*, this is
  the barrier observation schedule. If *False*, this sub-node is still
  required but will not be used.  
  Allowable values: See Section
  <a href="#ss:schedule_data" data-reference-type="ref"
  data-reference="ss:schedule_data">[ss:schedule_data]</a>.

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

### Asian Rainbow Call Spread Option

Asian rainbow call spread options are represented as *scripted trades*,
refer to the scripted trade documentation in ore/Docs/ScriptedTrade for
an introduction.

Trade input and the payoff script are described below.

``` xml
  <TradeType>ScriptedTrade</TradeType>
  <Envelope/>
  <AsianRainbowCallSpreadOptionData>
    <Expiry type="event">2020-02-15</Expiry>
    <AveragingDates type="event">
      <ScheduleData>
        <Dates>
          <Dates>
            <Date>2019-01-29</Date>
                    .....
            <Date>2020-02-15</Date>
          </Dates>
          <Calendar>USD</Calendar>
          <Convention>MF</Convention>
        </Dates>
      </ScheduleData>
    </AveragingDates>
    <Settlement type="event">2020-02-20</Settlement>
    <LongShort type="longShort">Long</LongShort>
    <Notional type="number">1000000</Notional>
    <Underlyings type="index">
      <Value>EQ-RIC:.SPX</Value>
      <Value>EQ-RIC:.STOXX50E</Value>
    </Underlyings>
    <InitialStrikes type="number">
      <Value>2100</Value>
      <Value>3000</Value>
    </InitialStrikes>
    <Weights type="number">
      <Value>0.8</Value>
      <Value>0.3</Value>
    </Weights>
    <Floor type="number">0.02</Floor>
    <Cap type="number">0.10</Cap>
    <PayCcy type="currency">USD</PayCcy>
  </AsianRainbowCallSpreadOptionData>
```

The AsianRainbowCallSpreadOption script referenced in the trade above is
shown in Listing <a href="#lst:asian_rainbow_call_spread_option"
data-reference-type="ref"
data-reference="lst:asian_rainbow_call_spread_option">[lst:asian_rainbow_call_spread_option]</a>.

<div class="listing">

``` Basic
REQUIRE SIZE(Underlyings) == SIZE(Weights);
NUMBER perf[SIZE(Underlyings)], return, d, u;
FOR u IN (1, SIZE(Underlyings), 1) DO
  FOR d IN (1, SIZE(AveragingDates), 1) DO
    perf[u] = perf[u] + Underlyings[u](AveragingDates[d]);
  END;
  perf[u] = perf[u] / SIZE(AveragingDates);
END;
SORT (perf);
FOR u IN (1, SIZE(Underlyings), 1) DO
  return = return + Weights[u] * perf[SIZE(Underlyings) + 1 - u];
END;
Option = LongShort * PAY( Notional * min( max( Floor, return - 1 ), Cap ), Expiry,
                          Settlement, PayCcy );
```

</div>

The meanings and allowable values of the elements in the
`AsianRainbowCallSpreadOptionData` node below.

- \[event\] `Expiry`: Option expiry date.  
  Allowable values: See `Date` in Table
  <a href="#tab:allow_stand_data" data-reference-type="ref"
  data-reference="tab:allow_stand_data">[tab:allow_stand_data]</a>.

- \[event\] `AveragingDates`: Observation dates for calculating the
  final (average) price of each underlying. Allowable values: See
  Section <a href="#ss:schedule_data" data-reference-type="ref"
  data-reference="ss:schedule_data">[ss:schedule_data]</a>.

- \[event\] `Settlement`: Option settlement date.  
  Allowable values: See `Date` in Table
  <a href="#tab:allow_stand_data" data-reference-type="ref"
  data-reference="tab:allow_stand_data">[tab:allow_stand_data]</a>.

- \[longShort\] `LongShort`: long short flag.  
  Allowable values: Long, Short

- \[number\] `Notional`: The notional.  
  Allowable values: A real number.

- \[index\] `Underlyings`: The underlyings.  
  Allowable values: See ore/Docs/ScriptedTrade’s Index Section for
  allowable values.

- \[number\] `InitialStrikes`: The initial strikes of the underlyings.  
  Allowable values: A real number for each underlying.

- \[number\] `Weights`: The weights for the best, second best, ...,
  worst performing underlying.  
  Allowable values: A real number for each rank.

- \[number\] `Floor`: The floor. If no floor applies, use e.g. -1E10.
  Allowable values: A real number.

- \[number\] `Cap`: The floor. If no floor applies, use e.g. 1E10.
  Allowable values: A real number.

- \[currency\] `PayCcy`: The payment currency. For FX, where the
  underlying is provided in the form `FX-SOURCE-CCY1-CCY2` (see Table
  <a href="#tab:fxindex_data" data-reference-type="ref"
  data-reference="tab:fxindex_data">[tab:fxindex_data]</a>) this should
  be `CCY2`. If `CCY1` or the currency of the underlying (for EQ and
  COMM underlyings), this will result in a quanto payoff. Notice section
  “Payment Currency” in ore/Docs/ScriptedTrade.  
  Allowable values: See Table
  <a href="#tab:currency" data-reference-type="ref"
  data-reference="tab:currency">[tab:currency]</a> for allowable
  currency codes.

### Worst Performance Rainbow Option 01

A worst performance rainbow option 01 is represented as a *scripted
trade*, refer to the scripted trade documentation in
ore/Docs/ScriptedTrade for an introduction.

Trade input and the payoff script are described below.

``` xml
  <TradeType>ScriptedTrade</TradeType>
  <Envelope>
    <CounterParty>CPTY_A</CounterParty>
    <NettingSetId>CPTY_A</NettingSetId>
    <AdditionalFields/>
  </Envelope>
  <WorstPerformanceRainbowOption01Data>
    <LongShort type="longShort">Long</LongShort>
    <Underlyings type="index">
      <Value>EQ-RIC:.STOXX50E</Value>
      <Value>EQ-RIC:.SPX</Value>
    </Underlyings>
    <InitialPrices type="number">
      <Value>5455.60</Value>
      <Value>500</Value>
    </InitialPrices>
    <Premium type="number">291264</Premium>
    <PremiumDate type="event">2020-03-11</PremiumDate>
    <Quantity type="number">72816000</Quantity>
    <PayoffMultiplier type="number">0.4625</PayoffMultiplier>
    <ObservationDate type="event">2020-09-04</ObservationDate>
    <SettlementDate type="event">2020-09-11</SettlementDate>
    <PayCcy type="currency">EUR</PayCcy>
  </WorstPerformanceRainbowOption01Data>
```

The WorstPerformanceRainbowOption01 script referenced in the trade above
is shown in listing <a href="#lst:worst_performance_rainbow_option_01"
data-reference-type="ref"
data-reference="lst:worst_performance_rainbow_option_01">[lst:worst_performance_rainbow_option_01]</a>.

<div class="listing">

``` Basic
REQUIRE SIZE(Underlyings) == SIZE(InitialPrices);
REQUIRE ObservationDate <= SettlementDate;

NUMBER u, indexInitial, indexFinal, performance;
NUMBER worstPerformance, payoff, premium;

FOR u IN (1, SIZE(Underlyings), 1) DO
  indexInitial = InitialPrices[u];
  indexFinal = Underlyings[u](ObservationDate);
  performance = indexFinal / indexInitial;

  IF {u == 1} OR {performance < worstPerformance} THEN
    worstPerformance = performance;
  END;
END;

payoff = LOGPAY(Quantity * (worstPerformance - 1), ObservationDate,
                SettlementDate, PayCcy, 1, Payoff);

IF worstPerformance < 1 THEN
  payoff = payoff * PayoffMultiplier;
END;

premium = LOGPAY(Premium, PremiumDate, PremiumDate, PayCcy, 0, Premium);

Option = LongShort * (payoff - premium);
```

</div>

The payout formula from the long perspective, determined on the
`ObservationDate`, is

$$Payout = \text{\lstinline!Quantity!} * (worstPerformance - 1)$$

where $worstPerformance$ is the performance, i.e. $S_T/S_0$, of the
worst-performing asset as of the final determination date $T$.

The meanings and allowable values for the
`WorstPerformanceRainbowOption01Data` node below.

- \[longShort\] `LongShort`: Own party position in the option.  
  Allowable values: *Long, Short*.

- \[index\] `Underlyings`: The basket of underlyings.  
  Allowable values: See ore/Docs/ScriptedTrade’s Index Section for
  allowable values.

- \[number\] `InitialPrices`: The agreed initial price for each basket
  underlying.  
  Allowable values: Any positive number.

- \[number\] `Premium`: Total option premium amount in terms of the
  *PayCcy*  
  Allowable values: See Table
  <a href="#tab:currency" data-reference-type="ref"
  data-reference="tab:currency">[tab:currency]</a> `Currency`.

- \[event\] `PremiumDate`: The premium payment date.  
  Allowable values: See `Date` in Table
  <a href="#tab:allow_stand_data" data-reference-type="ref"
  data-reference="tab:allow_stand_data">[tab:allow_stand_data]</a>.

- \[number\] `Quantity`: A quantity multiplier applied to the option
  payoff.  
  Allowable values: Any number.

- \[number\] `PayoffMultiplier`: A factor that is multiplied to the
  option payoff when the option buyer incurs a negative net cash flow,
  i.e. when the performance of the worst-performing asset is less than
  1.  
  Allowable values: Any number, as a percentage expressed in decimal
  form.

- \[event\] `ObservationDate`: The date on which the final levels of the
  assets are determined.  
  Allowable values: See `Date` in Table
  <a href="#tab:allow_stand_data" data-reference-type="ref"
  data-reference="tab:allow_stand_data">[tab:allow_stand_data]</a>.

- \[event\] `SettlementDate`: The settlement date for the option
  payoff.  
  Allowable values: See `Date` in Table
  <a href="#tab:allow_stand_data" data-reference-type="ref"
  data-reference="tab:allow_stand_data">[tab:allow_stand_data]</a>.

- \[currency\] `PayCcy`: The payment currency. For FX, where the
  underlying is provided in the form `FX-SOURCE-CCY1-CCY2` (see Table
  <a href="#tab:fxindex_data" data-reference-type="ref"
  data-reference="tab:fxindex_data">[tab:fxindex_data]</a>) this should
  be `CCY2`. If `CCY1` or the currency of the underlying (for EQ and
  COMM underlyings), this will result in a quanto payoff. Notice section
  “Payment Currency” in ore/Docs/ScriptedTrade.  
  Allowable values: See Table
  <a href="#tab:currency" data-reference-type="ref"
  data-reference="tab:currency">[tab:currency]</a> for allowable
  currency codes.

### Worst Performance Rainbow Option 02

A worst performance rainbow option 02 is represented as a *scripted
trade*, refer to the scripted trade documentation in
ore/Docs/ScriptedTrade for an introduction.

Trade input and the payoff script are described below.

``` xml
  <TradeType>ScriptedTrade</TradeType>
  <Envelope>
    <CounterParty>CPTY_A</CounterParty>
    <NettingSetId>CPTY_A</NettingSetId>
    <AdditionalFields/>
  </Envelope>
  <WorstPerformanceRainbowOption02Data>
    <LongShort type="longShort">Long</LongShort>
    <Underlyings type="index">
      <Value>EQ-RIC:.STOXX50E</Value>
      <Value>EQ-RIC:.SPX</Value>
    </Underlyings>
    <InitialPrices type="number">
      <Value>4890.00</Value>
      <Value>108.84</Value>
    </InitialPrices>
    <Premium type="number">1731</Premium>
    <PremiumDate type="event">2020-02-27</PremiumDate>
    <Quantity type="number">90000000</Quantity>
    <PayoffMultiplier type="number">1.7</PayoffMultiplier>
    <Floor type="number">-0.05</Floor>
    <ObservationDate type="event">2020-11-13</ObservationDate>
    <SettlementDate type="event">2020-11-27</SettlementDate>
    <PayCcy type="currency">USD</PayCcy>
  </WorstPerformanceRainbowOption02Data>
```

The WorstPerformanceRainbowOption02 script referenced in the trade above
is shown in listing <a href="#lst:worst_performance_rainbow_option_02"
data-reference-type="ref"
data-reference="lst:worst_performance_rainbow_option_02">[lst:worst_performance_rainbow_option_02]</a>.

<div class="listing">

``` Basic
REQUIRE SIZE(Underlyings) == SIZE(InitialPrices);
REQUIRE ObservationDate <= SettlementDate;
REQUIRE Floor <= 0;

NUMBER u, initialPrice, finalPrice, performance;
NUMBER worstPerformance, payoff, premium;

FOR u IN (1, SIZE(Underlyings), 1) DO
  initialPrice = InitialPrices[u];
  finalPrice = Underlyings[u](ObservationDate);
  performance = finalPrice / initialPrice;

  IF {u == 1} OR {performance < worstPerformance} THEN
    worstPerformance = performance;
  END;
END;

IF worstPerformance > 1 THEN
  payoff = PayoffMultiplier * (worstPerformance - 1);
ELSE
  IF worstPerformance < 1 THEN
    payoff = max(Floor, worstPerformance - 1);
  ELSE
    payoff = 0;
  END;
END;

payoff = Quantity * LOGPAY(payoff, ObservationDate, SettlementDate,
                           PayCcy, 1, Payoff);
premium = LOGPAY(Premium, PremiumDate, PremiumDate, PayCcy,
                 0, Premium);

Option = LongShort * (payoff - premium);
```

</div>

The payout formula from the long perspective, determined on the
`ObservationDate`, is as follows, where $worstPerformance$ is the
performance, i.e. $S_T/S_0$, of the worst-performing asset as of the
final determination date $T$:

If $worstPerformance > 1$, receive
$$Payout = \text{\lstinline!Quantity!} * \text{\lstinline!PayoffMultiplier!} * (worstPerformance - 1).$$

If $worstPerformance \leq 1$, pay
$$Payout = \text{\lstinline!Quantity!} * \max(\text{\lstinline!Floor!}, worstPerformance - 1)$$

The meanings and allowable values for the
`WorstPerformanceRainbowOption02Data` node below.

- \[longShort\] `LongShort`: Own party position in the option.  
  Allowable values: *Long, Short*.

- \[index\] `Underlyings`: The basket of underlyings.  
  Allowable values: See ore/Docs/ScriptedTrade’s Index Section for
  allowable values.

- \[number\] `InitialPrices`: The agreed initial price for each basket
  underlying.  
  Allowable values: Any positive number.

- \[number\] `Premium`: Total option premium amount in terms of the
  *PayCcy*  
  Allowable values: See Table
  <a href="#tab:currency" data-reference-type="ref"
  data-reference="tab:currency">[tab:currency]</a> `Currency`.

- \[event\] `PremiumDate`: The premium payment date.  
  Allowable values: See `Date` in Table
  <a href="#tab:allow_stand_data" data-reference-type="ref"
  data-reference="tab:allow_stand_data">[tab:allow_stand_data]</a>.

- \[number\] `Quantity`: A quantity multiplier applied to the option
  payoff.  
  Allowable values: Any number.

- \[number\] `PayoffMultiplier`: A factor that is multiplied to the
  option payoff when the option buyer incurs a positive net cash flow,
  i.e. when the performance of the worst-performing asset is greater
  than 1.  
  Allowable values: Any number, as a percentage expressed in decimal
  form.

- \[number\] `Floor`: The maximum loss that the option buyer can
  incur.  
  Allowable values: Any non-positive number, as a percentage expressed
  in decimal form.

- \[event\] `ObservationDate`: The date on which the final levels of the
  assets are determined.  
  Allowable values: See `Date` in Table
  <a href="#tab:allow_stand_data" data-reference-type="ref"
  data-reference="tab:allow_stand_data">[tab:allow_stand_data]</a>.

- \[event\] `SettlementDate`: The settlement date for the option
  payoff.  
  Allowable values: See `Date` in Table
  <a href="#tab:allow_stand_data" data-reference-type="ref"
  data-reference="tab:allow_stand_data">[tab:allow_stand_data]</a>.

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

### Worst Performance Rainbow Option 03

A worst performance rainbow option 03 is an extension of the Worst
Performance Rainbow Option 01, and is represented as a *scripted trade*,
refer to the scripted trade documentation in ore/Docs/ScriptedTrade for
an introduction.

Trade input and the payoff script are described below.

``` xml
  <TradeType>ScriptedTrade</TradeType>
  <Envelope>
    <CounterParty>CPTY_A</CounterParty>
    <NettingSetId>CPTY_A</NettingSetId>
    <AdditionalFields/>
  </Envelope>
  <WorstPerformanceRainbowOption03Data>
    <LongShort type="longShort">Long</LongShort>
    <Underlyings type="index">
      <Value>EQ-RIC:.STOXX50E</Value>
      <Value>EQ-RIC:.SPX</Value>
    </Underlyings>
    <InitialPrices type="number">
      <Value>5455.60</Value>
      <Value>500</Value>
    </InitialPrices>
    <Premium type="number">291264</Premium>
    <PremiumDate type="event">2020-03-11</PremiumDate>
    <Strike type="number">1.0</Strike>
    <Quantity type="number">72816</Quantity>
    <PayoffMultiplier type="number">2.5</PayoffMultiplier>
    <Cap type="number">100.0</Cap>
    <Floor type="number">-100.0</Floor>
    <BermudanBarrier type="bool">false</BermudanBarrier>
    <BarrierLevel type="number">0.7</BarrierLevel>
    <BarrierSchedule type="event">
      <ScheduleData>
        <Rules>
          <StartDate>2020-03-11</StartDate>
          <EndDate>2020-09-04</EndDate>
          <Tenor>1D</Tenor>
          <Calendar>USD</Calendar>
          <Convention>ModifiedFollowing</Convention>
          <TermConvention>ModifiedFollowing</TermConvention>
          <Rule>Forward</Rule>
        </Rules>
      </ScheduleData>
    </BarrierSchedule>
    <ObservationDate type="event">2020-09-04</ObservationDate>
    <SettlementDate type="event">2020-09-11</SettlementDate>
    <PayCcy type="currency">EUR</PayCcy>
  </WorstPerformanceRainbowOption03Data>
```

The WorstPerformanceRainbowOption03 script referenced in the trade above
is shown in listing <a href="#lst:worst_performance_rainbow_option_03"
data-reference-type="ref"
data-reference="lst:worst_performance_rainbow_option_03">[lst:worst_performance_rainbow_option_03]</a>.

<div class="listing">

``` Basic
REQUIRE SIZE(Underlyings) == SIZE(InitialPrices);
REQUIRE ObservationDate <= SettlementDate;
REQUIRE Floor <= Cap;

NUMBER indexInitial, indexFinal, performance, d;
NUMBER worstPerformance, payoff, premium, knockedIn, u;

FOR u IN (1, SIZE(Underlyings), 1) DO
  indexInitial = InitialPrices[u];
  indexFinal = Underlyings[u](ObservationDate);
  performance = indexFinal / indexInitial;

  IF {u == 1} OR {performance < worstPerformance} THEN
    worstPerformance = performance;
  END;
END;

IF BermudanBarrier == 1 THEN
  FOR d IN (1, SIZE(BarrierSchedule), 1) DO
    IF knockedIn == 0 THEN
      FOR u IN (1, SIZE(Underlyings), 1) DO
        indexInitial = InitialPrices[u];
        indexFinal = Underlyings[u](BarrierSchedule[d]);
        performance = indexFinal / indexInitial;

        IF performance <= BarrierLevel THEN
          knockedIn = 1;
        END;
      END;
    END;
  END;
ELSE
  IF worstPerformance <= BarrierLevel THEN
    knockedIn = 1;
  END;
END;

payoff = min(Cap, max(Floor, worstPerformance - Strike));
payoff = LOGPAY(Quantity * payoff * knockedIn, ObservationDate,
                SettlementDate, PayCcy, 1, Payoff);

IF worstPerformance < 1 THEN
  payoff = payoff * PayoffMultiplier;
END;

premium = LOGPAY(Premium, PremiumDate, PremiumDate,
                 PayCcy, 0, Premium);

Option = LongShort * (payoff - premium);
```

</div>

The payout formula from the long perspective, determined on the
`ObservationDate`, is as follows, where $worstPerformance$ is the
performance, i.e. $S_T/S_0$, of the worst-performing asset as of the
final determination date $T$:

If $worstPerformance \geq \text{\lstinline!Strike!}$, receive
$$Payout = \text{\lstinline!Quantity!} * \min\big(\text{\lstinline!Cap!}, \max(\text{\lstinline!Floor!}, worstPerformance - \text{\lstinline!Strike!})\big).$$

If $worstPerformance < \text{\lstinline!Strike!}$, pay
$$Payout = \text{\lstinline!Quantity!} * \text{\lstinline!PayoffMultiplier!} * \min\big(\text{\lstinline!Cap!}, \max(\text{\lstinline!Floor!}, worstPerformance - \text{\lstinline!Strike!})\big).$$

The above payouts are conteningent on a knock-in event. If no knock-in
has occurred, the payout is zero.

The meanings and allowable values for the
`WorstPerformanceRainbowOption03Data` node below.

- \[longShort\] `LongShort`: Own party position in the option.  
  Allowable values: *Long, Short*.

- \[index\] `Underlyings`: The basket of underlyings.  
  Allowable values: See ore/Docs/ScriptedTrade’s Index Section for
  allowable values.

- \[number\] `InitialPrices`: The agreed initial price for each basket
  underlying.  
  Allowable values: Any positive number.

- \[number\] `Premium`: Total option premium amount in terms of the
  *PayCcy*  
  Allowable values: See Table
  <a href="#tab:currency" data-reference-type="ref"
  data-reference="tab:currency">[tab:currency]</a> `Currency`.

- \[event\] `PremiumDate`: The premium payment date.  
  Allowable values: See `Date` in Table
  <a href="#tab:allow_stand_data" data-reference-type="ref"
  data-reference="tab:allow_stand_data">[tab:allow_stand_data]</a>.

- \[number\] `Strike`: The option strike price.  
  Allowable values: Any number, as a percentage expressed in decimal
  form.

- \[number\] `Quantity`: A quantity multiplier applied to the option
  payoff.  
  Allowable values: Any number.

- \[number\] `PayoffMultiplier`: A factor that is multiplied to the
  option payoff when the option buyer incurs a positive net cash flow,
  i.e. when the performance of the worst-performing asset is greater
  than 1.  
  Allowable values: Any number, as a percentage expressed in decimal
  form.

- \[number\] `Cap`: The maximum profit that the option buyer can
  receive.  
  Allowable values: Any number, as a percentage expressed in decimal
  form.

- \[number\] `Floor`: The maximum loss that the option buyer can
  incur.  
  Allowable values: Any number, as a percentage expressed in decimal
  form.

- \[bool\] `BermudanBarrier`: Whether the KI barrier observation is
  Bermudan (*True*) or European (*False*).  
  Allowable values: *True* or *False*.

- \[number\] `BarrierLevel`: The agreed knock-in barrier price level.
  For example, in the case of a Bermudan barrier, if a knock-in is set
  to occur when one of the underlying prices falls below 70% of its
  initial price, then the appropriate value is *0.7*, as in the sample
  trade input above.  
  Allowable values: Any number, as a percentage of the `InitialPrices`
  expressed in decimal form.

- \[event\] `BarrierSchedule`: If `BermudanBarrier` is *True*, this is
  the barrier observation schedule. If *False*, this sub-node is still
  required but will not be used.  
  Allowable values: See Section
  <a href="#ss:schedule_data" data-reference-type="ref"
  data-reference="ss:schedule_data">[ss:schedule_data]</a>.

- \[event\] `ObservationDate`: The date on which the final levels of the
  assets are determined.  
  Allowable values: See `Date` in Table
  <a href="#tab:allow_stand_data" data-reference-type="ref"
  data-reference="tab:allow_stand_data">[tab:allow_stand_data]</a>.

- \[event\] `SettlementDate`: The settlement date for the option
  payoff.  
  Allowable values: See `Date` in Table
  <a href="#tab:allow_stand_data" data-reference-type="ref"
  data-reference="tab:allow_stand_data">[tab:allow_stand_data]</a>.

- \[currency\] `PayCcy`: The payment currency. For FX, where the
  underlying is provided in the form `FX-SOURCE-CCY1-CCY2` (see Table
  <a href="#tab:fxindex_data" data-reference-type="ref"
  data-reference="tab:fxindex_data">[tab:fxindex_data]</a>) this should
  be `CCY2`. If `CCY1` or the currency of the underlying (for EQ and
  COMM underlyings), this will result in a quanto payoff. Notice section
  “Payment Currency” in ore/Docs/ScriptedTrade.  
  Allowable values: See Table
  <a href="#tab:currency" data-reference-type="ref"
  data-reference="tab:currency">[tab:currency]</a> for allowable
  currency codes.

### Worst Performance Rainbow Option 04

A worst performance rainbow option 04 is represented as a *scripted
trade*, refer to the scripted trade documentation in
ore/Docs/ScriptedTrade for an introduction.

Trade input and the payoff script are described below.

``` xml
  <TradeType>ScriptedTrade</TradeType>
  <Envelope>
    <CounterParty>CPTY_A</CounterParty>
    <NettingSetId>CPTY_A</NettingSetId>
    <AdditionalFields/>
  </Envelope>
  <WorstPerformanceRainbowOption04Data>
    <LongShort type="longShort">Long</LongShort>
    <Underlyings type="index">
      <Value>EQ-RIC:.STOXX50E</Value>
      <Value>EQ-RIC:.SPX</Value>
    </Underlyings>
    <InitialPrices type="number">
      <Value>5455.60</Value>
      <Value>500</Value>
    </InitialPrices>
    <Premium type="number">291264</Premium>
    <PremiumDate type="event">2020-03-11</PremiumDate>
    <Strike type="number">1.0</Strike>
    <Quantity type="number">72816</Quantity>
    <PayoffMultiplier type="number">2.5</PayoffMultiplier>
    <Cap type="number">100.0</Cap>
    <Floor type="number">-100.0</Floor>
    <BermudanBarrier type="bool">false</BermudanBarrier>
    <BarrierLevel type="number">0.7</BarrierLevel>
    <BarrierSchedule type="event">
      <ScheduleData>
        <Rules>
          <StartDate>2020-03-11</StartDate>
          <EndDate>2020-09-04</EndDate>
          <Tenor>1D</Tenor>
          <Calendar>USD</Calendar>
          <Convention>ModifiedFollowing</Convention>
          <TermConvention>ModifiedFollowing</TermConvention>
          <Rule>Forward</Rule>
        </Rules>
      </ScheduleData>
    </BarrierSchedule>
    <ObservationDate type="event">2020-09-04</ObservationDate>
    <SettlementDate type="event">2020-09-11</SettlementDate>
    <PayCcy type="currency">EUR</PayCcy>
  </WorstPerformanceRainbowOption04Data>
```

The WorstPerformanceRainbowOption04 script referenced in the trade above
is shown in listing <a href="#lst:worst_performance_rainbow_option_04"
data-reference-type="ref"
data-reference="lst:worst_performance_rainbow_option_04">[lst:worst_performance_rainbow_option_04]</a>.

<div class="listing">

``` Basic
REQUIRE SIZE(Underlyings) == SIZE(InitialPrices);
REQUIRE ObservationDate <= SettlementDate;
REQUIRE Floor <= Cap;

NUMBER indexInitial, indexFinal, performance, d;
NUMBER worstPerformance, payoff, premium, knockedIn, u;

FOR u IN (1, SIZE(Underlyings), 1) DO
  indexInitial = InitialPrices[u];
  indexFinal = Underlyings[u](ObservationDate);
  performance = indexFinal / indexInitial;

  IF {u == 1} OR {performance < worstPerformance} THEN
    worstPerformance = performance;
  END;
END;

IF BermudanBarrier == 1 THEN
  FOR d IN (1, SIZE(BarrierSchedule), 1) DO
    IF knockedIn == 0 THEN
      FOR u IN (1, SIZE(Underlyings), 1) DO
        indexInitial = InitialPrices[u];
        indexFinal = Underlyings[u](BarrierSchedule[d]);
        performance = indexFinal / indexInitial;

        IF performance <= BarrierLevel THEN
          knockedIn = 1;
        END;
      END;
    END;
  END;
ELSE
  IF worstPerformance <= BarrierLevel THEN
    knockedIn = 1;
  END;
END;

payoff = worstPerformance - Strike;
IF knockedIn == 0 THEN
  payoff = min(Cap, max(Floor, PayoffMultiplier * payoff));
END;

payoff = LOGPAY(Quantity * payoff, ObservationDate,
                SettlementDate, PayCcy, 1, Payoff);

premium = LOGPAY(Premium, PremiumDate, PremiumDate,
                 PayCcy, 0, Premium);

Option = LongShort * (payoff - premium);
```

</div>

The payout formula, determined on the `ObservationDate`, is as follows,
where $worstPerformance$ is the performance, i.e. $S_T/S_0$, of the
worst-performing asset as of the final determination date $T$:

If a knock-in event was triggered:
$$Payout = \text{\lstinline!Quantity!} * (worstPerformance - \text{\lstinline!Strike!}).$$

If no knock-in event was triggered:
$$Payout = \text{\lstinline!Quantity!} * \min\Big(\text{\lstinline!Cap!}, \max\big(\text{\lstinline!Floor!}, \text{\lstinline!PayoffMultiplier!} * (worstPerformance - \text{\lstinline!Strike!})\big)\Big).$$

From the long perspective, the above amounts are received if they are
positive, and paid out from the short perspective.

The meanings and allowable values for the
`WorstPerformanceRainbowOption04Data` node below.

- \[longShort\] `LongShort`: Own party position in the option.  
  Allowable values: *Long, Short*.

- \[index\] `Underlyings`: The basket of underlyings.  
  Allowable values: See ore/Docs/ScriptedTrade’s Index Section for
  allowable values.

- \[number\] `InitialPrices`: The agreed initial price for each basket
  underlying.  
  Allowable values: Any positive number.

- \[number\] `Premium`: Total option premium amount in terms of the
  *PayCcy*  
  Allowable values: See Table
  <a href="#tab:currency" data-reference-type="ref"
  data-reference="tab:currency">[tab:currency]</a> `Currency`.

- \[event\] `PremiumDate`: The premium payment date.  
  Allowable values: See `Date` in Table
  <a href="#tab:allow_stand_data" data-reference-type="ref"
  data-reference="tab:allow_stand_data">[tab:allow_stand_data]</a>.

- \[number\] `Strike`: The option strike price.  
  Allowable values: Any number, as a percentage expressed in decimal
  form.

- \[number\] `Quantity`: A quantity multiplier applied to the option
  payoff.  
  Allowable values: Any number.

- \[number\] `PayoffMultiplier`: A factor that is multiplied to the
  option payoff when no knock-in event has ocurred. This multiplier is
  applied before the cap and/or floor. Allowable values: Any number, as
  a percentage expressed in decimal form.

- \[number\] `Cap`: The maximum profit that the option buyer can receive
  when a knock-in event has occurred.  
  Allowable values: Any number, as a percentage expressed in decimal
  form.

- \[number\] `Floor`: The maximum loss that the option buyer can incur
  when a knock-in event has occurred.  
  Allowable values: Any number, as a percentage expressed in decimal
  form.

- \[bool\] `BermudanBarrier`: Whether the KI barrier observation is
  Bermudan (*True*) or European (*False*).  
  Allowable values: *True* or *False*.

- \[number\] `BarrierLevel`: The agreed knock-in barrier price level.
  For example, in the case of a Bermudan barrier, if a knock-in is set
  to occur when one of the underlying prices falls below 70% of its
  initial price, then the appropriate value is *0.7*, as in the sample
  trade input above.  
  Allowable values: Any number, as a percentage of the `InitialPrices`
  expressed in decimal form.

- \[event\] `BarrierSchedule`: If `BermudanBarrier` is *True*, this is
  the barrier observation schedule. If *False*, this sub-node is still
  required but will not be used.  
  Allowable values: See Section
  <a href="#ss:schedule_data" data-reference-type="ref"
  data-reference="ss:schedule_data">[ss:schedule_data]</a>.

- \[event\] `ObservationDate`: The date on which the final levels of the
  assets are determined.  
  Allowable values: See `Date` in Table
  <a href="#tab:allow_stand_data" data-reference-type="ref"
  data-reference="tab:allow_stand_data">[tab:allow_stand_data]</a>.

- \[event\] `SettlementDate`: The settlement date for the option
  payoff.  
  Allowable values: See `Date` in Table
  <a href="#tab:allow_stand_data" data-reference-type="ref"
  data-reference="tab:allow_stand_data">[tab:allow_stand_data]</a>.

- \[currency\] `PayCcy`: The payment currency. For FX, where the
  underlying is provided in the form `FX-SOURCE-CCY1-CCY2` (see Table
  <a href="#tab:fxindex_data" data-reference-type="ref"
  data-reference="tab:fxindex_data">[tab:fxindex_data]</a>) this should
  be `CCY2`. If `CCY1` or the currency of the underlying (for EQ and
  COMM underlyings), this will result in a quanto payoff. Notice section
  “Payment Currency” in ore/Docs/ScriptedTrade.  
  Allowable values: See Table
  <a href="#tab:currency" data-reference-type="ref"
  data-reference="tab:currency">[tab:currency]</a> for allowable
  currency codes.

### Worst Performance Rainbow Option 05

A worst performance rainbow option 05 is represented as a *scripted
trade*, refer to the scripted trade documentation in
ore/Docs/ScriptedTrade for an introduction.

Trade input and the payoff script are described below.

``` xml
  <TradeType>ScriptedTrade</TradeType>
  <Envelope>
    <CounterParty>CPTY_A</CounterParty>
    <NettingSetId>CPTY_A</NettingSetId>
    <AdditionalFields/>
  </Envelope>
  <WorstPerformanceRainbowOption05Data>
    <LongShort type="longShort">Long</LongShort>
    <PutCall type="optionType">Put</PutCall>
    <Underlyings type="index">
      <Value>EQ-RIC:.STOXX50E</Value>
      <Value>EQ-RIC:.SPX</Value>
    </Underlyings>
    <InitialPrices type="number">
      <Value>5455.60</Value>
      <Value>500</Value>
    </InitialPrices>
    <Premium type="number">291264</Premium>
    <PremiumDate type="event">2020-03-11</PremiumDate>
    <Strike type="number">1.0</Strike>
    <Quantity type="number">72816</Quantity>
    <BarrierType type="barrierType">DownIn</BarrierType>
    <BarrierLevel type="number">0.6</BarrierLevel>
    <ObservationDate type="event">2020-09-04</ObservationDate>
    <SettlementDate type="event">2020-09-11</SettlementDate>
    <PayCcy type="currency">EUR</PayCcy>
  </WorstPerformanceRainbowOption05Data>
```

The WorstPerformanceRainbowOption05 script referenced in the trade above
is shown in listing <a href="#lst:worst_performance_rainbow_option_05"
data-reference-type="ref"
data-reference="lst:worst_performance_rainbow_option_05">[lst:worst_performance_rainbow_option_05]</a>.

<div class="listing">

``` Basic
REQUIRE SIZE(Underlyings) == SIZE(InitialPrices);
REQUIRE ObservationDate <= SettlementDate;
REQUIRE BarrierType == 1 OR BarrierType == 2;

NUMBER indexInitial, indexFinal, performance;
NUMBER worstPerformance, payoff, premium, knockedIn, u;

FOR u IN (1, SIZE(Underlyings), 1) DO
  indexInitial = InitialPrices[u];
  indexFinal = Underlyings[u](ObservationDate);
  performance = indexFinal / indexInitial;

  IF {u == 1} OR {performance < worstPerformance} THEN
    worstPerformance = performance;
  END;
END;

IF {{BarrierType == 1 OR BarrierType == 4}
      AND worstPerformance <= BarrierLevel}
OR {{BarrierType == 2 OR BarrierType == 3}
      AND worstPerformance >= BarrierLevel} THEN
  knockedIn = 1;
END;

IF knockedIn == 0 THEN
  payoff = 0;
ELSE
  payoff = max(0, PutCall * (worstPerformance - Strike));
END;

payoff = LOGPAY(Quantity * payoff, ObservationDate,
                SettlementDate, PayCcy, 1, Payoff);

premium = LOGPAY(Premium, PremiumDate, PremiumDate,
                 PayCcy, 0, Premium);

Option = LongShort * (payoff - premium);
```

</div>

The payout formula, determined on the `ObservationDate`, is as follows,
where $worstPerformance$ is the performance, i.e. $S_T/S_0$, of the
worst-performing asset as of the final determination date $T$. The
payout for a long put option is as follows:

If a knock-in event was triggered,
$$Payout = \text{\lstinline!Quantity!} * \max\Big( \big(\text{\lstinline!Strike!} - worstPerformance\big), 0 \Big).$$

Otherwise, the payoff is zero.

The meanings and allowable values for the
`WorstPerformanceRainbowOption05Data` node below.

- \[longShort\] `LongShort`: Own party position in the option.  
  Allowable values: *Long, Short*.

- \[optionType\] `PutCall`: Option type. For FX, this should be *Call*
  if we buy `CCY1` and sell `CCY2`, *Put* if we buy `CCY2` and sell
  `CCY1` (where the `Underlying` is in the form
  `FX-SOURCE-CCY1-CCY2`).  

- \[index\] `Underlyings`: The basket of underlyings.  
  Allowable values: See ore/Docs/ScriptedTrade’s Index Section for
  allowable values.

- \[number\] `InitialPrices`: The agreed initial price for each basket
  underlying.  
  Allowable values: Any positive number.

- \[number\] `Premium`: Total option premium amount in terms of the
  *PayCcy*  
  Allowable values: See Table
  <a href="#tab:currency" data-reference-type="ref"
  data-reference="tab:currency">[tab:currency]</a> `Currency`.

- \[event\] `PremiumDate`: The premium payment date.  
  Allowable values: See `Date` in Table
  <a href="#tab:allow_stand_data" data-reference-type="ref"
  data-reference="tab:allow_stand_data">[tab:allow_stand_data]</a>.

- \[number\] `Strike`: The option strike price.  
  Allowable values: Any number, as a percentage expressed in decimal
  form.

- \[number\] `Quantity`: A quantity multiplier applied to the option
  payoff.  
  Allowable values: Any number.

- \[barrierType\] `BarrierType`: The knock-in barrier type. For trades
  with no barrier, set `BarrierType` to *UpIn* and `BarrierLevel` to
  zero (or any negative number).  
  Allowable values: *DownIn, UpIn*.

- \[number\] `BarrierLevel`: The agreed European knock-in barrier
  level.  
  Allowable values: Any number, as a percentage of the `InitialPrices`
  expressed in decimal form.

- \[event\] `ObservationDate`: The date on which the final levels of the
  assets are determined.  
  Allowable values: See `Date` in Table
  <a href="#tab:allow_stand_data" data-reference-type="ref"
  data-reference="tab:allow_stand_data">[tab:allow_stand_data]</a>.

- \[event\] `SettlementDate`: The settlement date for the option
  payoff.  
  Allowable values: See `Date` in Table
  <a href="#tab:allow_stand_data" data-reference-type="ref"
  data-reference="tab:allow_stand_data">[tab:allow_stand_data]</a>.

- \[currency\] `PayCcy`: The payment currency. For FX, where the
  underlying is provided in the form `FX-SOURCE-CCY1-CCY2` (see Table
  <a href="#tab:fxindex_data" data-reference-type="ref"
  data-reference="tab:fxindex_data">[tab:fxindex_data]</a>) this should
  be `CCY2`. If `CCY1` or the currency of the underlying (for EQ and
  COMM underlyings), this will result in a quanto payoff. Notice section
  “Payment Currency” in ore/Docs/ScriptedTrade.  
  Allowable values: See Table
  <a href="#tab:currency" data-reference-type="ref"
  data-reference="tab:currency">[tab:currency]</a> for allowable
  currency codes.

### Worst Performance Rainbow Option 06

A worst performance rainbow option 06 is represented as a *scripted
trade*, refer to the scripted trade documentation in
ore/Docs/ScriptedTrade for an introduction.

Trade input and the payoff script are described below.

``` xml
<Trade id="EQ_WorstPerformanceRainbowOption06">
  <TradeType>ScriptedTrade</TradeType>
  <Envelope>
    <CounterParty>CPTY_A</CounterParty>
    <NettingSetId>CPTY_A</NettingSetId>
    <AdditionalFields/>
  </Envelope>
  <WorstPerformanceRainbowOption06Data>
    <LongShort type="longShort">Long</LongShort>
    <Quantity type="number">200000</Quantity>
    <Underlyings type="index">
      <Value>EQ-RIC:.STOXX50E</Value>
      <Value>EQ-RIC:.SPX</Value>
    </Underlyings>
    <InitialPrices type="number">
      <Value>5455.60</Value>
      <Value>500</Value>
    </InitialPrices>
    <StrikePrices type="number">
      <Value>5600</Value>
      <Value>550</Value>
    </StrikePrices>
    <BarrierLevels type="number">
      <Value>5600</Value>
      <Value>550</Value>
    </BarrierLevels>
    <KnockInPrices type="number">
      <Value>5600</Value>
      <Value>550</Value>
    </KnockInPrices>
    <BonusCoupon type="number">0.1430</BonusCoupon>
    <ObservationSchedule type="event">
      <ScheduleData>
        <Rules>
          <StartDate>2020-03-11</StartDate>
          <EndDate>2020-09-04</EndDate>
          <Tenor>1D</Tenor>
          <Calendar>USD</Calendar>
          <Convention>ModifiedFollowing</Convention>
          <TermConvention>ModifiedFollowing</TermConvention>
          <Rule>Forward</Rule>
        </Rules>
      </ScheduleData>
    </ObservationSchedule>
    <ObservationDate type="event">2020-09-04</ObservationDate>
    <SettlementDate type="event">2020-09-11</SettlementDate>
    <PayCcy type="currency">EUR</PayCcy>
  </WorstPerformanceRainbowOption06Data>
</Trade>
```

The WorstPerformanceRainbowOption06 script referenced in the trade above
is shown in listing <a href="#lst:worst_performance_rainbow_option_06"
data-reference-type="ref"
data-reference="lst:worst_performance_rainbow_option_06">[lst:worst_performance_rainbow_option_06]</a>.

<div class="listing">

``` Basic
REQUIRE SIZE(Underlyings) == SIZE(InitialPrices) AND SIZE(Underlyings) == SIZE(StrikePrices);
REQUIRE SIZE(Underlyings) == SIZE(BarrierLevels) AND SIZE(Underlyings) == SIZE(KnockInPrices);
REQUIRE ObservationDate <= SettlementDate;

NUMBER indexInitial, indexFinal, performance, d, spot;
NUMBER worstPerformance, payoff, premium, knockedIn, u, worstUnderlying, worstUnderlyingFinalPrice;
NUMBER deliverableAsset,fractionalAmount, fractionalCashAmount;

worstUnderlying = 1;

FOR u IN (1, SIZE(Underlyings), 1) DO
  indexInitial = InitialPrices[u];
  indexFinal = Underlyings[u](ObservationDate);
  performance = indexFinal / indexInitial;

  IF {u == 1} OR {performance < worstPerformance} THEN
    worstPerformance = performance;
    worstUnderlyingFinalPrice = indexFinal;
    worstUnderlying = u;
  END;
END;

FOR d IN (1, SIZE(ObservationSchedule), 1) DO
  IF knockedIn == 0 THEN
    FOR u IN (1, SIZE(Underlyings), 1) DO
      spot = Underlyings[u](ObservationSchedule[d]);
      IF spot < KnockInPrices[u] THEN
        knockedIn = 1;
      END;
    END;
  END;
END;

IF knockedIn == 1 AND worstUnderlyingFinalPrice < StrikePrices[worstUnderlying] THEN
  deliverableAsset = Quantity/StrikePrices[worstUnderlying];
  fractionalAmount = frac(deliverableAsset);
  fractionalAmount = round(fractionalAmount,4);
  fractionalCashAmount = worstUnderlyingFinalPrice*fractionalAmount;
  payoff = round(fractionalCashAmount,2)+round(deliverableAsset,0);
ELSE
  IF worstUnderlyingFinalPrice >= BarrierLevels[worstUnderlying] THEN
    payoff = Quantity*(1+max(BonusCoupon, worstPerformance-1));
  ELSE
    payoff = Quantity;
  END;
END;

payoff = LOGPAY(payoff, ObservationDate, SettlementDate, PayCcy, 1, Payoff);

Option = LongShort * payoff;
```

</div>

The payout formula, determined on the `ObservationDate`, is as follows,
where $worstPerformance$ is the performance, i.e. $S_T/S_0$, of the
worst-performing asset as of the final determination date $T$. The
payout for a long put option is as follows:

If a knock-in event was triggered and the Final Reference Price of the
Worst Performing Underlying is below its Strike Price,
$$Payout = \text{\lstinline!Quantity!} * S * \text{FractionalAmount} + \text{round}(\text{fractionalCashAmount})$$
with Fractional Amount being the fractional share resulting from the
calculation of the Deliverable Assets. $K$ being the strike level of the
worst underlying performing asset, $S$ that underlying final price.
$$FractionalAmount = \text{\lstinline!Quantity!} / \text{K}$$

The meanings and allowable values for the
`WorstPerformanceRainbowOption06Data` node below.

- \[longShort\] `LongShort`: Own party position in the option.  
  Allowable values: *Long, Short*.

- \[index\] `Underlyings`: The basket of underlyings.  
  Allowable values: See ore/Docs/ScriptedTrade’s Index Section for
  allowable values.

- \[number\] `InitialPrices`: The agreed initial price for each basket
  underlying.  
  Allowable values: Any positive number.

- \[number\] `StrikePrices`: The strike prices used within the
  calculation agent.  
  Allowable values: Any number.

- \[number\] `KnockInPrices`: The agreed European knock-in barrier
  level.  
  Allowable values: Any number.

- \[number\] `Quantity`: A quantity multiplier applied to the payoff.  
  Allowable values: Any number.

- \[number\] `BarrierLevels`: The agreed barrier level.  
  Allowable values: Any number.

- \[number\] `BonusCoupon`: A percentage.  
  Allowable values: Any number.

- \[event\] `ObservationDate`: The date on which the final levels of the
  assets are determined.  
  Allowable values: See `Date` in Table
  <a href="#tab:allow_stand_data" data-reference-type="ref"
  data-reference="tab:allow_stand_data">[tab:allow_stand_data]</a>.

- \[event\] `SettlementDate`: The settlement date for the payoff.  
  Allowable values: See `Date` in Table
  <a href="#tab:allow_stand_data" data-reference-type="ref"
  data-reference="tab:allow_stand_data">[tab:allow_stand_data]</a>.

- \[currency\] `PayCcy`: The payment currency. For FX, where the
  underlying is provided in the form `FX-SOURCE-CCY1-CCY2` (see Table
  <a href="#tab:fxindex_data" data-reference-type="ref"
  data-reference="tab:fxindex_data">[tab:fxindex_data]</a>) this should
  be `CCY2`. If `CCY1` or the currency of the underlying (for EQ and
  COMM underlyings), this will result in a quanto payoff. The
  `StrikePrices` and `BarrierLevels` should be expressed in as amount of
  CCY1 in CCY2.Notice section “Payment Currency” in
  ore/Docs/ScriptedTrade.  
  Allowable values: See Table
  <a href="#tab:currency" data-reference-type="ref"
  data-reference="tab:currency">[tab:currency]</a> for allowable
  currency codes.

### Worst Performance Rainbow Option 07

A worst performance rainbow option 07 is represented as a *scripted
trade*, refer to the scripted trade documentation in
ore/Docs/ScriptedTrade for an introduction.

Trade input and the payoff script are described below.

``` xml
<Trade id="EQ_WorstPerformanceRainbowOption07">
  <TradeType>ScriptedTrade</TradeType>
  <Envelope>
    <CounterParty>CPTY_A</CounterParty>
    <NettingSetId>CPTY_A</NettingSetId>
    <AdditionalFields/>
  </Envelope>
  <WorstPerformanceRainbowOption07Data>
    <LongShort type="longShort">Long</LongShort>
    <Quantity type="number">200000</Quantity>
    <Premium type="number">291264</Premium>
    <PremiumDate type="event">2020-03-11</PremiumDate>
    <Underlyings type="index">
      <Value>EQ-RIC:.STOXX50E</Value>
      <Value>EQ-RIC:.SPX</Value>
    </Underlyings>
    <InitialPrices type="number">
      <Value>5455.60</Value>
      <Value>500</Value>
    </InitialPrices>
    <FixedRateI type="number">0.015</FixedRateI>
    <FixedRateII type="number">0.004</FixedRateII>
    <DayCountFraction type="dayCounter">Actual/360</DayCountFraction>
    <StrikePrices type="number">
      <Value>5600</Value>
      <Value>550</Value>
    </StrikePrices>
    <TriggerLevels type="number">
      <Value>1</Value>
      <Value>1</Value>
      <Value>1</Value>
    </TriggerLevels>
    <DeterminationDates type="event">
      <ScheduleData>
        <Rules>
          <StartDate>2020-03-11</StartDate>
          <EndDate>2020-09-04</EndDate>
          <Tenor>3M</Tenor>
          <Calendar>USD</Calendar>
          <Convention>ModifiedFollowing</Convention>
          <TermConvention>ModifiedFollowing</TermConvention>
          <Rule>Forward</Rule>
        </Rules>
      </ScheduleData>
    </DeterminationDates>
    <ObservationSchedule type="event">
      <ScheduleData>
        <Rules>
          <StartDate>2020-03-11</StartDate>
          <EndDate>2020-09-04</EndDate>
          <Tenor>3M</Tenor>
          <Calendar>USD</Calendar>
          <Convention>ModifiedFollowing</Convention>
          <TermConvention>ModifiedFollowing</TermConvention>
          <Rule>Forward</Rule>
        </Rules>
      </ScheduleData>
    </ObservationSchedule>
    <ObservationDate type="event">2020-09-04</ObservationDate>
    <SettlementDate type="event">2020-09-11</SettlementDate>
    <PayCcy type="currency">EUR</PayCcy>
  </WorstPerformanceRainbowOption07Data>
</Trade>
```

The WorstPerformanceRainbowOption07 script referenced in the trade above
is shown in listing <a href="#lst:worst_performance_rainbow_option_07"
data-reference-type="ref"
data-reference="lst:worst_performance_rainbow_option_07">[lst:worst_performance_rainbow_option_07]</a>.

<div class="listing">

``` Basic
REQUIRE SIZE(Underlyings) == SIZE(InitialPrices) AND SIZE(Underlyings) == SIZE(StrikePrices);
REQUIRE SIZE(DeterminationDates) == SIZE(TriggerLevels);
REQUIRE SIZE(DeterminationDates) == SIZE(ObservationSchedule);
REQUIRE ObservationDate <= SettlementDate;

NUMBER indexInitial, indexFinal, performance, d, spot;
NUMBER worstPerformance, premium, knockedOut, u, worstUnderlying, worstUnderlyingFinalPrice, k, allMeet;
NUMBER deliverableAsset, fractionalAmount, fractionalShareAmount, fixedAmountII, fixedAmountI;
NUMBER payoffA, payoffB, couponA, couponB;

worstUnderlying = 1;
worstPerformance = 999999;
FOR u IN (1, SIZE(Underlyings), 1) DO
  indexInitial = InitialPrices[u];
  indexFinal = Underlyings[u](ObservationDate);
  performance = indexFinal / indexInitial;

  IF performance < worstPerformance THEN
      worstPerformance = performance;
      worstUnderlying  = u;
      worstUnderlyingFinalPrice = indexFinal;
  END;
END;

knockedOut = 0;
k = SIZE(DeterminationDates);
FOR d IN (1, SIZE(DeterminationDates), 1) DO
  IF knockedOut == 0 THEN
    allMeet = 0;
    FOR u IN (1, SIZE(Underlyings), 1) DO
      spot = Underlyings[u](DeterminationDates[d]);
      IF spot >= TriggerLevels[d] * InitialPrices[u] THEN
        allMeet = allMeet + 1;
      END;
    END;
  END;
  
  IF allMeet == SIZE(Underlyings) THEN
    knockedOut = 1;
    k = d;
  END;
  
END;

FOR d IN (1, k, 1) DO
  couponA = round(Quantity * FixedRateI, 2);
  fixedAmountI = fixedAmountI + LOGPAY(couponA, ObservationSchedule[d], ObservationSchedule[d], PayCcy, 1, PayoffA);
  
  couponB = Quantity * FixedRateII * dcf( DayCountFraction, ObservationSchedule[d], ObservationSchedule[d]);
  fixedAmountII = fixedAmountII + LOGPAY(couponB, ObservationSchedule[d], ObservationSchedule[d], PayCcy, 1, PayoffB);
END;

IF knockedOut == 0 THEN
    IF worstUnderlyingFinalPrice >= StrikePrices[worstUnderlying] THEN
      payoffA = 0;
      payoffB = 0;
    ELSE
      payoffB = LOGPAY(Quantity, ObservationDate, SettlementDate, PayCcy, 1, Payoff);
      deliverableAsset = Quantity/StrikePrices[worstUnderlying];
      fractionalAmount = round(deliverableAsset, 2);
      fractionalShareAmount = worstUnderlyingFinalPrice * fractionalAmount;
      payoffA = LOGPAY(fractionalShareAmount, ObservationDate, SettlementDate, PayCcy, 1, Payoff);
    END;
ELSE
    payoffA = fixedAmountI;
    payoffB = fixedAmountII;
END;

premium = LOGPAY(Premium, PremiumDate, PremiumDate, PayCcy, 0, Premium);

Option = LongShort * (payoffA - payoffB - premium);
```

</div>

The payout formula, determined on the `ObservationDate`, is as follows,
where $worstPerformance$ is the performance, i.e. $S_T/S_0$, of the
worst-performing asset as of the final determination date $T$. The
payout for a long put option is as follows:

If a knock-in event was triggered and the Final Reference Price of the
Worst Performing Underlying is below its Strike Price,
$$payoff = S * \text{round}(\text{fractionalAmount}) - \text{Quantity}$$
with Fractional Amount being the fractional share resulting from the
calculation of the Deliverable Assets. $K$ being the strike level of the
worst underlying performing asset, $S$ that underlying final price.
$$FractionalAmount = \text{\lstinline!Quantity!} / \text{K}$$

The meanings and allowable values for the
`WorstPerformanceRainbowOption07Data` node below.

- \[longShort\] `LongShort`: Own party position in the option.  
  Allowable values: *Long, Short*.

- \[index\] `Underlyings`: The basket of underlyings.  
  Allowable values: See ore/Docs/ScriptedTrade’s Index Section for
  allowable values.

- \[number\] `InitialPrices`: The agreed initial price for each basket
  underlying.  
  Allowable values: Any positive number.

- \[number\] `Premium`: Total option premium amount in terms of the
  *PayCcy*  
  Allowable values: See Table
  <a href="#tab:currency" data-reference-type="ref"
  data-reference="tab:currency">[tab:currency]</a> `Currency`.

- \[event\] `PremiumDate`: The premium payment date.  
  Allowable values: See `Date` in Table
  <a href="#tab:allow_stand_data" data-reference-type="ref"
  data-reference="tab:allow_stand_data">[tab:allow_stand_data]</a>.

- \[number\] `FixedRateI`: The agreed coupon rate for the first leg.  
  Allowable values: Any positive number.

- \[number\] `FixedRateII`: The agreed coupon rate for the second leg.  
  Allowable values: Any positive number.

- \[number\] `StrikePrices`: The strike prices used within the
  calculation agent.  
  Allowable values: Any number.

- \[number\] `Quantity`: A quantity multiplier applied to the payoff.  
  Allowable values: Any number.

- \[number\] `TriggerLevels`: For each fixed trigger determination date,
  the barrier level used to determine whether an event has occurred.  
  Allowable values: For each fixed trigger evaluation date, a `Value`
  sub-node with any positive number, as a percentage of the initial
  prices expressed in decimal form.

- \[event\] `DeterminationDates`: Knock-out determination dates, and
  trigger determination dates.  
  Allowable values: See Section
  <a href="#ss:schedule_data" data-reference-type="ref"
  data-reference="ss:schedule_data">[ss:schedule_data]</a> ScheduleData.

- \[event\] `ObservationSchedule`: The schedule defining the observation
  dates for determining price lock-ins.  
  Allowable values: See Section
  <a href="#ss:schedule_data" data-reference-type="ref"
  data-reference="ss:schedule_data">[ss:schedule_data]</a>.

- \[event\] `ObservationDate`: The date on which the final levels of the
  assets are determined.  
  Allowable values: See `Date` in Table
  <a href="#tab:allow_stand_data" data-reference-type="ref"
  data-reference="tab:allow_stand_data">[tab:allow_stand_data]</a>.

- \[event\] `SettlementDate`: The settlement date for the payoff.  
  Allowable values: See `Date` in Table
  <a href="#tab:allow_stand_data" data-reference-type="ref"
  data-reference="tab:allow_stand_data">[tab:allow_stand_data]</a>.

- \[currency\] `PayCcy`: The payment currency. For FX, where the
  underlying is provided in the form `FX-SOURCE-CCY1-CCY2` (see Table
  <a href="#tab:fxindex_data" data-reference-type="ref"
  data-reference="tab:fxindex_data">[tab:fxindex_data]</a>) this should
  be `CCY2`. If `CCY1` or the currency of the underlying (for EQ and
  COMM underlyings), this will result in a quanto payoff. The
  `StrikePrices` and `BarrierLevels` should be expressed in as amount of
  CCY1 in CCY2.Notice section “Payment Currency” in
  ore/Docs/ScriptedTrade.  
  Allowable values: See Table
  <a href="#tab:currency" data-reference-type="ref"
  data-reference="tab:currency">[tab:currency]</a> for allowable
  currency codes.
