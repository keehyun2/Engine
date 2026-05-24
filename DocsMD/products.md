# ORE Product Catalogue

This document contains the complete product catalogue for ORE (Open Source Risk Engine).

---

## Table of Contents

1. [Trade Data](#trade-data)
2. [Pricing](#pricing)
3. [Trade Components](#trade-components)

---

# Trade Data

The trades that make up the portfolio are specified in an XML file where
the portfolio data is specified in a hierarchy of nodes and sub-nodes.
The nodes containing individual trade data are referred to as elements
or XML elements. These are generally the lowest level nodes.

The top level portfolio node is delimited by an opening `<Portfolio>`
and a closing `</Portfolio>` tag. Within the portfolio node, each trade
is defined by a starting `<Trade id="[Tradeid]">` and a closing
`</Trade>` tag. Further, the trade type is set by the TradeType XML
element. Each trade has an Envelope node that includes the same XML
elements for all trade types (Id, Type, Counterparty, Rating,
NettingSetId) plus the Additional fields node, and after that, a node
containing trade specific data.

An example of a `portfolio.xml` file with one Swap trade including the
full envelope node is shown in Listing
<a href="#lst:portfolio" data-reference-type="ref"
data-reference="lst:portfolio">[lst:portfolio]</a>.

<div class="listing">

``` xml
<Portfolio>
  <Trade id="Swap#1">
    <TradeType> Swap </TradeType>
    <Envelope>
      <CounterParty> Counterparty#1 </CounterParty>
      <NettingSetId> NettingSet#2 </NettingSetId>
      <PortfolioIds>
          <PortfoliodId> PF#1 </PortfolioId>
          <PortfoliodId> PF#2 </PortfolioId>
      </PortfolioIds>
      <AdditionalFields>
        <Sector> SectorA </Sector>
        <Book> BookB </Book>
        <Rating> A1 </Rating>
      </AdditionalFields>
    </Envelope>
    <SwapData>
        ...
        [Trade specific data for a Swap]
        ...
    </SwapData>
  </Trade>
</Portfolio>
```

</div>

A description of all portfolio data, i.e. of each node and XML element
in the portfolio file, with examples and allowable values follows below.
There is only one XML elements directly under the top level `Portfolio`
node:

- `TradeType`: ORE currently supports 14 trade types.

  Allowable values: *ForwardRateAgreement, Swap, CapFloor, Swaption,
  FxForward, FxSwap, FxOption, EquityForward, EquityOption,
  VarianceSwap, CommodityForward, CommodityOption, CreditDefaultSwap,
  Bond*

---

## Envelope

The envelope node contains basic identifying details of a trade (` Id`,
`Type`, `Counterparty`, `NettingSetId`), a `PortfolioIds` node
containing a list of portfolio assignments, plus an `AdditionalFields`
node where custom elements can be added for informational purposes such
as `Book` or `Sector`. Beside the custom elements within the
` AdditionalFields` node, the envelope contains the same elements for
all Trade types. The `Id`, `Type`, `Counterparty` and `NettingSetId`
elements must have non-blank entries for ORE to run. The meanings and
allowable values of the various elements in the `Envelope` node follow
below.

- `Id`: The `Id` element in the envelope is used to identify trades
  within a portfolio. It should be set to identical values as the
  `Trade id=" "` element.

  Allowable values: Any alphanumeric string. The underscore (\_) sign
  may be used as well.

- `Counterparty`: Specifies the name of the counterparty of the trade.
  It is used to show exposure analytics by counterparty.

  Allowable values: Any alphanumeric string. Underscores (\_) and blank
  spaces may be used as well.

- `NettingSetId` \[Optional\]: The `NettingSetId` element specifies the
  identifier for a netting set. If a `NettingSetId` is specified, the
  trade is eligible for close-out netting under the terms of an
  associated ISDA agreement. The specified `NettingSetId` must be
  defined within the netting set definitions file (see section
  <a href="#sec:nettingsetinput" data-reference-type="ref"
  data-reference="sec:nettingsetinput">[sec:nettingsetinput]</a>). If
  left blank or omitted the trade will not belong to any netting set,
  and thus not be eligible for netting.

  Allowable values: Any alphanumeric string. Underscores (\_) and blank
  spaces may be used as well.

- `PortfolioIds` \[Optional\]: The PortfolioIds node allows the
  assignment of a given trade to several portfolios, each enclosed in
  its own pair of tags `<PortfolioId>` and ` </PortfolioId>` . Note that
  ORE does not assume a hierarchical organisation of such portfolios. If
  present, the portfolio IDs will be used in the generation of some ORE
  reports such as the VaR report which provides breakdown by any
  portfolio id that occurs in the trades’ envelopes.

  Allowable values for each PortfolioId: Any string.

- `AdditionalFields` \[Optional\]: The AdditionalFields node allows the
  insertion of additional trade information using custom XML elements.
  For example, elements such as Sector, Desk or Folder can be used. The
  elements within the `AdditionalFields` node are used for informational
  purposes only, and do not affect any analytics in ORE.

  Allowable values: Any custom element.

---

## Trade Data\n
### Accumulators and Decumulators

The `FxAccumulatorData`, `EquityAccumulatorData`,
`CommodityAccumulatorData` is the trade data container for the
FxAccumulator, EquityAccumulator, CommodityAccumulator trade type. The
following listings and show the structure of example trades for an FX
and Equity underlying. Here the FX accumulator is of “type 01” meaning
that a settlement takes place on each observation date while the equity
accumulator is of “type 02” meaning that a settlement takes place on
specific period end dates for all observation dates in that period.

``` xml
<Trade id="FX_ACCUMULATOR">
  <TradeType>FxAccumulator</TradeType>
  <Envelope>
   ...
  </Envelope>
  <FxAccumulatorData>
    <Currency>USD</Currency>
    <FixingAmount>1000000</FixingAmount>
    <Strike>1.1</Strike>
    <Underlying>
      <Type>FX</Type>
      <Name>ECB-EUR-USD</Name>
    </Underlying>
    <OptionData>
      <LongShort>Long</LongShort>
      <PayoffType>Accumulator</PayoffType>
    </OptionData>
    <StartDate>2016-03-01</StartDate>
    <ObservationDates>
      <Dates>
        <Dates>
          <Date>2017-03-01</Date>
          <Date>2020-03-01</Date>
          <Date>2025-03-01</Date>
          <Date>2029-03-01</Date>
        </Dates>
      </Dates>
    </ObservationDates>
    <SettlementDates>
      <Dates>
        <Dates>
          <Date>2017-03-03</Date>
          <Date>2020-03-03</Date>
          <Date>2025-03-03</Date>
          <Date>2029-03-03</Date>
        </Dates>
     </Dates>
    </SettlementDates>
    <RangeBounds>
      <RangeBound>
        <RangeTo>1.14</RangeTo>
        <Leverage>1</Leverage>
      </RangeBound>
      <RangeBound>
        <RangeFrom>1.14</RangeFrom>
        <Leverage>1</Leverage>
      </RangeBound>
    </RangeBounds>
    <Barriers>
      <BarrierData>
        <Type>UpAndOut</Type>
        <Style>American</Style>
        <Levels>
          <Level>1.5</Level>
        </Levels>
      </BarrierData>
      <BarrierData>
        <Type>FixingFloor</Type>
        <Levels>
          <Level>2</Level>
        </Levels>
      </BarrierData>
    </Barriers>
  </FxAccumulatorData>
</Trade>
```

``` xml
<Trade id="Equity_Decumulator">
  <TradeType>EquityAccumulator</TradeType>
  <Envelope>
   ...
  </Envelope>
  <EquityAccumulatorData>
    <FixingAmount>30</FixingAmount>
    <StrikeData>
      <Value>4000</Value>
      <Currency>EUR</Currency>
    </StrikeData>
    <Underlying>
        <Type>Equity</Type>
        <Name>.STOXX50</Name>
        <IdentifierType>RIC</IdentifierType>
    </Underlying>
    <OptionData>
      <LongShort>Long</LongShort>
      <PayoffType>Decumulator</PayoffType>
    </OptionData>
    <StartDate>20190925</StartDate>
    <ObservationDates>
      <Rules>
        <StartDate>20190925</StartDate>
        <EndDate>20200925</EndDate>
        <Tenor>1D</Tenor>
        <Calendar>TARGET</Calendar>
        <Convention>F</Convention>
        <TermConvention>F</TermConvention>
        <Rule>Forward</Rule>
      </Rules>
    </ObservationDates>
    <PricingDates>
      <Dates>
        <Dates>
          <Date>20211025</Date>
          <Date>20211125</Date>
          ...
        </Dates>
      </Dates>
    </PricingDates>
    <SettlementLag>2D</SettlementLag>
    <SettlementCalendar>TARGET</SettlementCalendar>
    <SettlementConvention>F</SettlementConvention>
    <RangeBounds>
      <RangeBound>
        <RangeTo>4000</RangeTo>
        <Leverage>1</Leverage>
      </RangeBound>
      <RangeBound>
        <RangeFrom>4000</RangeFrom>
        <Leverage>2</Leverage>
      </RangeBound>
    </RangeBounds>
    <Barriers>
      <BarrierData>
        <Type>DownAndOut</Type>
        <LevelData>
          <Level>
            <Value>3500</Value>
            <Currency>EUR</Currency>
          </Level>
        </LevelData>
      </BarrierData>
      <BarrierData>
        <Type>FixingFloor</Type>
        <Levels>
          <Level>1</Level>
        </Levels>
      </BarrierData>
    </Barriers>
    <KnockOutSettlementAtPeriodEnd>false<KnockOutSettlementAtPeriodEnd>
  </EquityAccumulatorData>
</Trade>
```

`Accumulator Payout Formula`

The payout formula, from the perspective of the party that is long, for
each observation date of an Accumulator is:

$$Payout = RangeBound(Leverage) \cdot FixingAmount \cdot (fix - Strike),$$

i.e. for an Accumulator the holder pays \[`Strike` \* `FixingAmount` \*
`RangeBound`(Leverage)\] expressed in `Currency` and receives/buys \[fix
\* `FixingAmount` \* `RangeBound`(Leverage)\]’s worth of
equity/CCY1/commodity in `Currency` on each observation date.

If `NakedOption` is *true*, the payout formula for an Accumulator (long
perspective) is:

$$Payout = |RangeBound(Leverage)| \cdot FixingAmount \cdot \max(0, \phi \cdot (fix - Strike)),$$

where $\phi = \pm 1$ is the option type (+1 for Call, -1 for Put)
inferred from the sign of the values of `RangeBound`(Leverage), which
are all required to be the same.

`Decumulator Payout Formula`

The payout formula, from the perspective of the party that is long, for
each observation date of a Decumulator is:

$$Payout = RangeBound(Leverage) \cdot FixingAmount \cdot (Strike - fix),$$

For a Decumulator the holder pays/sells \[fix \* `FixingAmount` \*
`RangeBound`(Leverage)\]’s worth of equity/CCY1/commodity in `Currency`,
and receives \[`Strike` \* `FixingAmount` \* `RangeBound`(Leverage)\]
expressed in `Currency` on each observation date.

If `NakedOption` is *true*, the payout formula for a Decumulator (long
perspective) is:

$$Payout = |RangeBound(Leverage)| \cdot FixingAmount \cdot \max(0, \phi \cdot (Strike - fix),$$

where $\phi = \pm 1$ is the option type (+1 for Call, -1 for Put)
inferred from the sign of the values of `RangeBound`(Leverage), which
are all required to be the same.

The meanings and allowable values of the elements in the data node
follow below.

- StrikeData \[Optional\]: A node containing the global strike in
  `Value` and the currency in which both the underlying and the strike
  are quoted in `Currency`. Only supported for EquityAccumulators.

  Allowable values: See `Currency` in Table
  <a href="#tab:allow_stand_data" data-reference-type="ref"
  data-reference="tab:allow_stand_data">[tab:allow_stand_data]</a>. The
  strike may be any positive real number. The currency provided in this
  node may be quoted as corresponding minor currency to the underlying
  major currency. If omitted, local strikes should be used in each
  `RangeBound` node.

- Currency: The payout currency. The result of the payout formula above
  is treated to be in this currency. Note that for (non-quanto)
  FxAccumulators this should be the domestic (`CCY2`) currency. For
  non-quanto Equity- and CommodityAccumulators this should be the
  currency the equity or commodity is quoted in. Notice section “Payment
  Currency” in ore/Docs/ScriptedTrade.  
  Allowable values: See Table
  <a href="#tab:currency" data-reference-type="ref"
  data-reference="tab:currency">[tab:currency]</a> `Currency`.

- FixingAmount: The unleveraged notional amount accumulated at each
  fixing date.

  For FxAccumulators: The FixingAmount is expressed in the foreign
  currency (`CCY1`).

  For EquityAccumulators: The FixingAmount is expressed as number of
  shares/units of the underlying equity or equity index.

  For CommodityAccumulators: The FixingAmount is expressed as number of
  units of the underlying commodity.

  Allowable values: Any real number. Note that a negative amount causes
  an Accumulator to become a Decumulator, and vice-versa.

- DailyFixingAmount \[Optional\]: For accumulator type “01” only: If
  *true*, the fixing amount for a period is calculated as the given
  FixingAmount times the number of calendar days in the period. The
  periods are given by \[StartDate, ObservationDate(1)\],
  \[ObservationDate(1), ObservationDate(2)\], ... etc. i.e. if *true*, a
  StartDate is required to determine the calendar days in the first
  period. If *false*, the fixing amount is used directly without any
  weighting.

  Allowable values: *true* or *false*. Defaults to *false* if left blank
  or omitted.

- Strike \[Optional\]: Global strike associated to the ranges. Is
  overwritten by local strikes defined in `RangeBounds` or modified by
  range strike adjustments. Note that each RangeBound needs a strike,
  either the global strike defined here, or a local one in the
  `RangeBounds` nodes which then overwrites the global one.

  For FxAccumulators: The fx strike rate (global and local) is defined
  as amount in domestic currency (`CCY2`) for one unit of foreign
  currency (`CCY1`).

  For Equity- and CommodityAccumulators: The strike value (global and
  local) for one unit/share/contract of the underlying equity or
  commodity, expressed in the currency the equity or commodity is quoted
  or in any other pay currency. In case of a composite option style a
  FxIndex is required (see below). For EquityAccumulators, the
  `StrikeData` node (see above) should be used.

  The logic for global and local strikes is as follows:

  \- if a local Strike for an interval is given, this local Strike will
  be used for the interval (a global Strike will be ignored if given)  
  - otherwise if a global Strike and a local StrikeAdjustment are given,
  the strike used for the interval will be global Strike + local
  StrikeAdjustment  
  - otherwise if a global Strike, but no local StrikeAdjustment is
  given, the strike used for the interval will be the global Strike  
  - if no global strike and no local strike is given for an interval, an
  error is thrown, since the strike information is not sufficient

  Allowable values: Any positive real number.

- Underlying: A node with the underlying of the Accumulator instrument.

  For FxAccumulators: `Type` is set to *FX* and `Name` is a string of
  the form *SOURCE-CCY1-CCY2* where `CCY1` is the foreign currency,
  `CCY2` is the domestic currency, and *SOURCE* is the fixing source,
  see Table <a href="#tab:fxindex_data" data-reference-type="ref"
  data-reference="tab:fxindex_data">[tab:fxindex_data]</a> and
  <a href="#ss:underlying" data-reference-type="ref"
  data-reference="ss:underlying">[ss:underlying]</a>.

  For EquityAccumulators: `Type` is set to *Equity* and `Name` and other
  fields are as outlined in
  <a href="#ss:underlying" data-reference-type="ref"
  data-reference="ss:underlying">[ss:underlying]</a>

  For CommodityAccumulators: `Type` is set to *Commodity* and `Name` is
  an identifier of the commodity as outlined in
  <a href="#ss:underlying" data-reference-type="ref"
  data-reference="ss:underlying">[ss:underlying]</a> and in Table
  <a href="#tab:commodity_data" data-reference-type="ref"
  data-reference="tab:commodity_data">[tab:commodity_data]</a>.

  Allowable values: Any FX, Equity or Commodity underlying as specified
  in <a href="#ss:underlying" data-reference-type="ref"
  data-reference="ss:underlying">[ss:underlying]</a>

- OptionData: See <a href="#ss:option_data" data-reference-type="ref"
  data-reference="ss:option_data">[ss:option_data]</a>. A node that
  describes whether the instrument is *Long* or *Short*, whether the
  payoff type is *Accumulator* or *Decumulator*,

  The relevant fields in the `OptionData` node for an Accumulator are:

  - `LongShort` The allowable values are *Long* or *Short*. Note that a
    *Long* *Accumulator* is equivalent to a *Short* *Decumulator* except
    when there are guaranteed fixings, i.e. when a Barrier node of Type
    *FixingFloor* is present. The *FixingFloor* causes asymmetry in the
    payoff.

    `PayoffType` The allowable values are *Accumulator* or
    *Decumulator*. For a long accumulator the strike is paid and the
    underlying received, for a long decumulator it is the other way
    around.

- StartDate \[Mandatory for American Style Barrier or if a daily fixing
  amount is used, Optional for European Style or no Barrier and no daily
  fixing amount is used\]: Used to set the start of the knock out
  monitoring - American knock out events are monitored from this date
  on. This field is only relevant for accumulators of type American
  Knock-Out, and not used otherwise. Can be omitted for European knock
  outs, or if there is no barrier.  
  Allowable values: See `Date` in Table
  <a href="#tab:allow_stand_data" data-reference-type="ref"
  data-reference="tab:allow_stand_data">[tab:allow_stand_data]</a>.

- ObservationDates: The observation dates given as schedule data.  
  Allowable values: See the ScheduleData definition
  <a href="#ss:schedule_data" data-reference-type="ref"
  data-reference="ss:schedule_data">[ss:schedule_data]</a>.

- PricingDates\[Optional\]: The dates defining observation period end
  dates on which the settlement for all dates in the period takes place.
  Note that the inclusion or not of PricingDates determines the
  Accumulator type. If included the Accumulator is of “type 02”, and
  otherwise, if PricingDates are not included it is of “type 01”.  
  Allowable values: See the ScheduleData definition
  <a href="#ss:schedule_data" data-reference-type="ref"
  data-reference="ss:schedule_data">[ss:schedule_data]</a>. Note that
  the final pricing period end date (defining the final observation
  period end date) must be on or after the final observation date.

- SettlementLag \[Optional\]: The settlement delay. Optional, if not
  given it is defaulted to 0D.  
  Allowable values: Any period definition (e.g. *2D*, *1W*, *1M*, *1Y*)

- SettlementCalendar \[Optional\]: The calendar used to compute the
  settlement date from the corresponding observation date.  
  Allowable values: Any valid calendar, see Table
  <a href="#tab:calendar" data-reference-type="ref"
  data-reference="tab:calendar">[tab:calendar]</a> Calendar.. Optional,
  defaults to the null calendar (no holidays).

- SettlementConvention \[Optional\]: The convention used to compute the
  settlement date from the corresponding observation date. Optional,
  defaults to F (following).  
  Allowable values: Any valid roll convention (*U,F,P,MF,MP*), see Table
  <a href="#tab:convention" data-reference-type="ref"
  data-reference="tab:convention">[tab:convention]</a> Roll Convention.

- SettlementDates \[Optional\]: The settlement dates can also be given
  as an explicit list of dates, see the FX accumulator listing above for
  an example. For a “type 01” accumulator the number of dates must be
  equal to the number of observation dates. For a “type 02” accumulator
  the number of dates must be equal to the number of pricing dates. If
  an explicit list of settlement dates is given, no settlement lag,
  calendar, conventions should be given.

- NakedOption \[Optional\]: If *true*, the payoff represents that of an
  option, and only positive values are accumulated in the instrument.
  The option type (Call or Put) is inferred from the sign of the
  `Leverage` values in `RangeBound`, which are all required to be the
  same.  
  Allowable values: Boolean node, allowing *Y*, *N*, *1*, *0*, *true*,
  *false*, etc. The full set of allowable values is given in Table
  <a href="#tab:boolean_allowable" data-reference-type="ref"
  data-reference="tab:boolean_allowable">[tab:boolean_allowable]</a>.
  Defaults to *false* if left blank or omitted.

- RangeBounds: Nodes for the specification of ranges and associated
  leverages. A leverage can be specified to apply for all values the
  underlying can take, or for specific ranges using `RangeFrom` and
  `RangeTo`. Multiple `RangeBound` sub-nodes can be included within the
  `RangeBounds` node. If no leverage is specified for a range, it
  defaults to 1 for this range. In addition a range bound specific
  strike can be specified for Accumulators of “type 01” (and only this
  type!) which overwrites the global Strike field. If all range bounds
  have a specific strike defined, the global Strike field might be
  omitted.  
  Allowable values: For each range, see
  <a href="#ss:rangebound" data-reference-type="ref"
  data-reference="ss:rangebound">[ss:rangebound]</a>. Only the
  `Leverage` is relevant for a given range. All `Leverage` parameters in
  one instrument must have the same sign. For “type 01” Accumulators,
  the Strike is relevant too and overwrites the global strike if given.
  Finally, for “type 01” Accumulators a range bound specific strike can
  be specified by specifying a range bound specific strike adjustment to
  the global strike (see the range bound spec for details).

- Barriers \[Optional\]: Specification of barriers and fixing floors
  (guaranteed fixings). Multiple `BarrierData` sub-nodes can be included
  within the `Barriers` node. Relevant fields for each `BarrierData`
  sub-node are `Type`, `Style`, and `Level`. The barrier is monitored on
  the

  - the observation dates (type 02 accumulator, i.e. PricingDates are
    given)

  - the observation dates (type 01 accumulator, i.e. no PricingDates are
    given), if barrier style is European

  - from the start date to the first observation date and between the
    observation dates on a continuous basis (type 01 accumulator), if
    barrier style is American.

  - StrictComparison \[Optional\]: *0*, *1*. Defaults to *0*. Determines
    how the barrier is checked as per:

    *0*: the barrier checks use $<=$, $>=$.

    *1*: the barrier checks use strict comparison $<$ and $>$.

  For *type 01 accumulators* (no pricing dates are given), the
  FixingFloor guarantees a specific number of fixings to be settled even
  in case of a knock out. On a guaranteed fixing date, Only positive
  payouts (from the buyer/long perspective) are realised. Where payout =
  fix - strike for accumulators and strike - fix for decumulators.

  For *type 02 accumulators* (pricing dates are given), the FixingFloor
  specifies the number of *periods* (rather than observation dates) that
  are guaranteed to settle. If a knock out event occurs within a
  settlement period the fixings after the knock event within this period
  are assumed to fall into the first defined range and the settlement
  takes place on the knock out day plus the defined settlement delay.

  The barrier `Level` for `Type` *UpAndOut* and *DownAndOut* is
  expressed in the same way as `Strike` outlined above. For
  EquityAccumulators, each `Level` node should be provided a `Value` and
  a `Currency` and contained in a `LevelData` node (see example trade
  above). This `Currency` supports minor currencies.  
  The barrier `Level` for `Type` *FixingFloor* is a non-negative
  integer.

  Allowable values: For each `BarrierData` node, see
  <a href="#ss:barrier_data" data-reference-type="ref"
  data-reference="ss:barrier_data">[ss:barrier_data]</a>. For
  Accumulators/Decumulators, the following values for `Type` are
  relevant: *UpAndOut*, *DownAndOut* and *FixingFloor*. The barrier
  `Style` can be *European* (monitored on observation dates) or
  *American* (continuously monitored).

- KnockOutSettlementAtPeriodEnd \[Optional\]: Only relevant for *type 02
  accumulator*. Controls the settlement behavior in case of an knock out
  events. If *true* the settlement of a knock out event takes place at
  the end of the observation period, otherwise on the knock out event
  date plus the defined settlement delay. Defaults to *false*.

- KnockOutFixingAtKOSettlement \[Optional\]: Only relevant for *type 02
  accumulator*. Controls the settlement behavior in case of an knock out
  events. If *true* the fixing at knockout settlement date is used to
  compute the knockout flow, otherwise the fixing at knockout date.
  Defaults to *false*.

- FxIndex \[Optional\]: Required for composite accumulators of type 2,
  where the strike, knockout barrier and pay currency are different from
  the underlying quote currency. Intended for Commodity and Equity
  Accumulators. A node with the underlying of the FX conversion from
  quote currency to pay currency. `Type` is set to *FX* and `Name` is a
  string of the form *SOURCE-CCY1-CCY2* where `CCY1` is the foreign
  (quote) currency, `CCY2` is the domestic (pay) currency, and *SOURCE*
  is the fixing source, see Table
  <a href="#tab:fxindex_data" data-reference-type="ref"
  data-reference="tab:fxindex_data">[tab:fxindex_data]</a> and
  <a href="#ss:underlying" data-reference-type="ref"
  data-reference="ss:underlying">[ss:underlying]</a>.

Accumulators can also be represented as scripted trades, refer to the
separate documentation in ore/Docs/ScriptedTrade for an introduction.
Listing <a href="#lst:fxaccumulator01" data-reference-type="ref"
data-reference="lst:fxaccumulator01">[lst:fxaccumulator01]</a> shows the
structure of an Accumulator (type 01) example, here on a FX underlying
(EQ or COMM underlyings are possible as well).

<div class="listing">

``` xml
<Trade id="SCRIPTED_FX_ACCUMULATOR">
  <TradeType>ScriptedTrade</TradeType>
  <Envelope>
    <CounterParty>CPTY_A</CounterParty>
    <NettingSetId>CPTY_A</NettingSetId>
    <AdditionalFields/>
  </Envelope>
  <Accumulator01Data>
    <Strike type="number">1.1</Strike>
    <FixingAmount type="number">1000000</FixingAmount>
    <LongShort type="longShort">Long</LongShort>
    <Underlying type="index">FX-ECB-EUR-USD</Underlying>
    <PayCcy type="currency">USD</PayCcy>
    <StartDate type="event">2016-03-01</StartDate>
    <FixingDates type="event">
      <ScheduleData>
        <Dates>
          <Dates>
            <Date>2017-03-01</Date>
            <Date>2020-03-01</Date>
            <Date>2025-03-01</Date>
            <Date>2029-03-01</Date>
          </Dates>
        </Dates>
      </ScheduleData>
    </FixingDates>
    <SettlementDates type="event">
      <DerivedSchedule>
        <BaseSchedule>FixingDates</BaseSchedule>
        <Shift>2D</Shift>
        <Calendar>TARGET</Calendar>
        <Convention>F</Convention>
      </DerivedSchedule>
    </SettlementDates>
    <RangeUpperBounds type="number">
      <Value>1.14</Value>
      <Value>10000</Value>
    </RangeUpperBounds>
    <RangeLowerBounds type="number">
      <Value>0</Value>
      <Value>1.14</Value>
    </RangeLowerBounds>
    <RangeLeverages type="number">
      <Value>1</Value>
      <Value>2</Value>
    </RangeLeverages>
    <KnockOutLevel type="number">1.5</KnockOutLevel>
    <KnockOutType type="barrierType">UpOut</KnockOutType>
    <AmericanKO type="bool">true</AmericanKO>
    <GuaranteedFixings type="number">2</GuaranteedFixings>
  </Accumulator01Data>
</Trade>
```

</div>

The meanings and allowable values of the elements in the
`Accumulator01Data` representation follow below.

- Strike: The strike value the bought currency is purchased at.

- FixedAmount: The unleveraged notional amount accumulated at each
  fixing date

- LongShort: 1 for a long, -1 for a short position

- Underlying: See ore/Docs/ScriptedTrade’s Index section for allowable
  values.

- PayCcy: The payment currency of the trade. Notice section Notice
  section “Payment Currency” in ore/Docs/ScriptedTrade.

- StartDate: The start date. American knock out events are monitored
  from this date on. Notice that the start date must be given in the
  scripted trade representation for European knock outs, although it is
  not used for this variant.

- FixingDates: The fixing dates, given as a ScheduleData, or
  DerivedSchedule (see ore/Docs/ScriptedTrade).

- SettlementDates: The fixing dates, given as a ScheduleData, or
  DerivedSchedule (see ore/Docs/ScriptedTrade).

- RangeUpperBound: Values of upperbounds for the leverage ranges. If a
  given range has no upperbound add 100000

- RangeLowerBound: Values of lowerbounds for the leverage ranges. If a
  given range has no lowerbound add 0

- RangeLeverages: Values of leverages for the leverage ranges.

- KnockOutLevel: The KnockOut Barrier level

- KnockOutType: The KnockOut Barrier type, can be UpOut or DownOut

- AmericanKO: If true, knock out events are monitored on a continuous
  basis, otherwise they are monitored on the fixing dates only.

- GuaranteedFixings: Number of the first n Fixings that are guaranteed,
  regardless of whether or not the trade has been knocked out.

The script ‘Accumulator01’ referenced in the trade above is shown in
Listing <a href="#lst:accumulator01_script" data-reference-type="ref"
data-reference="lst:accumulator01_script">[lst:accumulator01_script]</a>.

<div class="listing">

``` Basic
REQUIRE KnockOutType == 3 OR KnockOutType == 4;
NUMBER Payoff, fix, d, r, Alive, currentNotional, Factor, ThisPayout, Fixing[SIZE(FixingDates)];
Alive = 1;
FOR d IN (1, SIZE(FixingDates), 1) DO
    fix = Underlying(FixingDates[d]);
    Fixing[d] = fix;

    IF AmericanKO == 1 THEN
      IF KnockOutType == 4 THEN
        IF FixingDates[d] >= StartDate THEN
           IF d == 1 OR FixingDates[d-1] <= StartDate THEN
              Alive = Alive * (1 - ABOVEPROB(Underlying, StartDate, FixingDates[d], KnockOutLevel));
           ELSE
              Alive = Alive * (1 - ABOVEPROB(Underlying, FixingDates[d-1], FixingDates[d], KnockOutLevel));
           END;
        END;
      ELSE
        IF FixingDates[d] >= StartDate THEN
           IF d == 1 OR FixingDates[d-1] <= StartDate THEN
              Alive = Alive * (1 - BELOWPROB(Underlying, StartDate, FixingDates[d], KnockOutLevel));
           ELSE
              Alive = Alive * (1 - BELOWPROB(Underlying, FixingDates[d-1], FixingDates[d], KnockOutLevel));
           END;
        END;
      END;
    ELSE
      IF {KnockOutType == 4 AND fix >= KnockOutLevel} OR
         {KnockOutType == 3 AND fix <= KnockOutLevel} THEN
        Alive = 0;
      END;
    END;

    IF d <= GuaranteedFixings THEN
      Factor = 1;
    ELSE
      Factor = Alive;
    END;

    FOR r IN (1, SIZE(RangeUpperBounds), 1) DO
      IF fix > RangeLowerBounds[r] AND fix <= RangeUpperBounds[r] THEN
        ThisPayout = RangeLeverages[r] * FixingAmount * (fix - Strike) * Factor;
        IF d > GuaranteedFixings OR ThisPayout >= 0 THEN
          Payoff = Payoff + LOGPAY(RangeLeverages[r] * FixingAmount * (fix - Strike) * Factor,
                                   FixingDates[d], SettlementDates[d], PayCcy);
        END;
      END;
    END;
END;
value = LongShort * Payoff;
currentNotional = FixingAmount * Strike;
```

</div>

Accumulators of Type 02 can also be represented as scripted trades, see
ore/Docs/ScriptedTrade for an introduction. Listing
<a href="#lst:eqaccumulator02" data-reference-type="ref"
data-reference="lst:eqaccumulator02">[lst:eqaccumulator02]</a> shows the
structure of an Accumulator (Type 02) example, here on an equity
underlying. FX and COMM underlyings are possible as well.

<div class="listing">

``` xml
<Trade id="EqDecumulator">
  <TradeType>ScriptedTrade</TradeType>
  <Envelope>
    <CounterParty>CPTY_A</CounterParty>
    <NettingSetId>CPTY_A</NettingSetId>
    <AdditionalFields/>
  </Envelope>
  <Accumulator02Data>
    <Strike type="number">59.9842</Strike>
    <FixingAmount type="number">11</FixingAmount>
    <LongShort type="longShort">Long</LongShort>
    <Underlying type="index">EQ-RIC:.SPX</Underlying>
    <PayCcy type="currency">EUR</PayCcy>
    <ObservationDates type="event">
      <ScheduleData>
        <Rules>
          <StartDate>20190925</StartDate>
          <EndDate>20200925</EndDate>
          <Tenor>1D</Tenor>
          ...
        </Rules>
      </ScheduleData>
    </ObservationDates>
    <KnockOutSettlementDates type="event">
      <DerivedSchedule>
        <BaseSchedule>ObservationDates</BaseSchedule>
        <Shift>2D</Shift>
        <Calendar>TARGET</Calendar>
        <Convention>F</Convention>
      </DerivedSchedule>
    </KnockOutSettlementDates>
    <ObservationPeriodEndDates type="event">
      <ScheduleData>
        <Dates>
          <Dates>
            <Date>20191025</Date>
            <Date>20191125</Date>
            ...
            <Date>20200925</Date>
          </Dates>
        </Dates>
      </ScheduleData>
    </ObservationPeriodEndDates>
    <SettlementDates type="event">
      <ScheduleData>
        <Dates>
          <Dates>
            <Date>20191027</Date>
            <Date>20191127</Date>
            ...
            <Date>20200927</Date>
          </Dates>
        </Dates>
      </ScheduleData>
    </SettlementDates>
    <RangeUpperBounds type="number">
      <Value>59.9842</Value>
      <Value>10000000.0</Value>
    </RangeUpperBounds>
    <RangeLowerBounds type="number">
      <Value>-10000000.0</Value>
      <Value>59.9842</Value>
    </RangeLowerBounds>
    <RangeLeverages type="number">
      <Value>1</Value>
      <Value>2</Value>
    </RangeLeverages>
    <DefaultRange type="number">1</DefaultRange>
    <KnockOutLevel type="number">50.825</KnockOutLevel>
    <KnockOutType type="barrierType">DownOut</KnockOutType>
    <GuaranteedPeriodEndDate type="event">20191025</GuaranteedPeriodEndDate>
  </Accumulator02Data>
</Trade>
```

</div>

The script ‘Accumulator02’ referenced in the trade above is shown in
Listing <a href="#lst:accumulator02_script" data-reference-type="ref"
data-reference="lst:accumulator02_script">[lst:accumulator02_script]</a>.

The meanings and allowable values of the elements in the
`DecumulatorData` node folllow below.

- Strike: The forward price. For an FX underlying `FX-SOURCE-CCY1-CCY2`
  this is the number of units of `CCY2` per units of `CCY1`. For an EQ
  underlying this is the equity price expressed in the equity ccy.
  Allowable values are non-negative numbers.

- FixingAmount: The number of shares per day (EQ Undlerinyg) resp. the
  foreign amount (FX Undderlying). Allowable values are non-negative
  values.

- LongShort: The position, allowable values are “Long” and “Short”

- Underlying: The underlying index  
  See ore/Docs/ScriptedTrade’s Index section for allowable values.

- PayCcy: The payment currency. See the appendix for allowable currency
  codes. Notice section Notice section “Payment Currency” in
  ore/Docs/ScriptedTrade.

- ObservationDates: The observation date schedule. See
  ore/Docs/ScriptedTrade on how this is set up.

- KnowOutSettlementDates: The settlement dates associated to the
  observation dates in case of a knock out event, the number of
  observation and knock out settlement dates must be equal. See
  ore/Docs/ScriptedTrade on how this is set up.

- ObservationPeriodEndDates: The last date for each observation period.
  See ore/Docs/ScriptedTrade on how this is set up.

- SettlementDates: The settlement dates for each observation period, the
  number of settlement dates and the number of observation period end
  dates must be equal. See ore/Docs/ScriptedTrade on how this is set up.

- RangeUpperBounds: The multiplier for the “number of days below” in the
  payoff. Allowable values are non-negative numbers.

- RangeLowerBounds: The multiplier for the “number of days above” in the
  payoff. Allowable values are non-negative numbers.

- RangeLeverages: The multiplier for the defined ranges. Allowable
  values are non-negative numbers.

- DefaultRange: The default range used in case of a knock-out event to
  classify the remaining days until the GuaranteedPeriodEndDate.
  Allowable values are $1,2,\ldots,r$ where $r$ is the number of defined
  ranges.

- KnockOutLevel: The knock out price. See Strike for more details and
  allowable values.

- KnockOutType: The KnockOut Barrier type, can be UpOut or DownOut

- GuaranteedPeriodEndDate: The last date of the guaranteed period.
  Allowable values are any valid dates.

<div class="listing">

``` Basic
REQUIRE SIZE(ObservationDates) == SIZE(KnockOutSettlementDates);
REQUIRE SIZE(ObservationPeriodEndDates) == SIZE(SettlementDates);
REQUIRE SIZE(RangeUpperBounds) == SIZE(RangeLowerBounds);
REQUIRE SIZE(RangeUpperBounds) == SIZE(RangeLeverages);
NUMBER Payoff, fix, d, dd, KnockedOut, currentNotional, Days[SIZE(RangeUpperBounds)];
NUMBER currentPeriod, r;
currentPeriod = 1;
FOR d IN (1, SIZE(ObservationDates)) DO
  fix = Underlying(ObservationDates[d]);
  IF KnockedOut == 0 THEN
    IF {KnockOutType == 4 AND fix >= KnockOutLevel} OR
       {KnockOutType == 3 AND fix <= KnockOutLevel} THEN
       KnockedOut = 1;
       FOR dd IN (d + 1, SIZE(ObservationDates)) DO
         IF ObservationDates[d] <= GuaranteedPeriodEndDate THEN
            Days[DefaultRange] = Days[DefaultRange] + 1;
         END;
       END;
       FOR r IN (1, SIZE(RangeUpperBounds)) DO
         value = value + PAY( LongShort * FixingAmount * RangeLeverages[r] * Days[r]
                              * ( fix - Strike ),
                              ObservationDates[d], KnockOutSettlementDates[d], PayCcy );
       END;
    END;
  END;
  IF KnockedOut == 0 THEN
    FOR r IN (1, SIZE(RangeUpperBounds)) DO
      IF fix > RangeLowerBounds[r] AND fix <= RangeUpperBounds[r] THEN
        Days[r] = Days[r] + 1;
      END;
    END;
    IF ObservationDates[d] >= ObservationPeriodEndDates[currentPeriod] THEN
      FOR r IN (1, SIZE(RangeUpperBounds)) DO
        value = value + PAY( LongShort * FixingAmount * RangeLeverages[r] * Days[r]
                             * ( fix - Strike ),
                             ObservationDates[d], SettlementDates[currentPeriod], PayCcy );
      END;
    END;
  END;
  IF ObservationDates[d] >= ObservationPeriodEndDates[currentPeriod] THEN
    currentPeriod = currentPeriod + 1;
    IF currentNotional == 0 THEN
      FOR r IN (1, SIZE(RangeUpperBounds)) DO
        currentNotional = currentNotional + FixingAmount * RangeLeverages[r] * Days[r] * Strike;
      END;
    END;
    FOR r IN (1, SIZE(RangeUpperBounds)) DO
      Days[r] = 0;
    END;
  END;
END;
```

</div>

---

### Ascot

**Payoff**

An Ascot or a Convertible Bond Option is an American style option to buy
back a convertible bond. The buyer of a Call Ascot can exercise the deal
and get the underlying bond in exchange for paying the strike.

The payout formula for a Call Ascot is:

$$Payout = \max(0, convertiblePrice - Strike)$$

And for a Put Ascot:

$$Payout = \max(0, Strike - convertiblePrice)$$

where:
$$Strike = bondQuantity \cdot (upfrontPayment + assetLeg - redemptionLeg) - fundingLeg$$

**Input**

An Ascot is set up using an `AscotData` block as shown in listing
<a href="#lst:ascotdata" data-reference-type="ref"
data-reference="lst:ascotdata">[lst:ascotdata]</a>. The bond details are
read from reference data in this case.

<div class="listing">

``` xml
  <Trade id="Ascot">
    <TradeType>Ascot</TradeType>
    <Envelope>...</Envelope>
    <AscotData>
      <ConvertibleBondData>
        <BondData>
          <SecurityId>ISIN:XY1000000000</SecurityId>
          <BondNotional>1000000.00</BondNotional>
        </BondData>
      </ConvertibleBondData>
      <OptionData>
       <LongShort>Long</LongShort>
       <OptionType>Call</OptionType>
       <Style>American</Style>
       <Settlement>Physical</Settlement>
       <ExerciseDates>
         <ExerciseDate>2029-02-03</ExerciseDate>
       </ExerciseDates>  
      </OptionData>
      <ReferenceSwapData>
        <LegData>
          <LegType>Floating</LegType>
          <Payer>false</Payer>
          ...
        </LegData>
      </ReferenceSwapData>
    <AscotData>
  </Trade>
```

</div>

The meanings and allowable values of the elements in the block are as
follows:

- ConvertibleBondData: This describes the underlying convertible bond,
  see <a href="#ss:convertible_bond" data-reference-type="ref"
  data-reference="ss:convertible_bond">[ss:convertible_bond]</a>.

- OptionData: This is a trade component sub-node outlined in section
  <a href="#ss:option_data" data-reference-type="ref"
  data-reference="ss:option_data">[ss:option_data]</a> Option Data. The
  relevant fields in the `OptionData` node for an Ascot are:

  - `LongShort` The allowable values are *Long* or *Short*. The
    LongShort flag multiplies the option price with +1 / -1. Call and
    Put payout formulas above are from the long perspective

  - `OptionType` The allowable values are *Call* or *Put*. See payout
    formulas above.

  - `Style` The Ascot type allows for *American* option exercise style
    only.

  - `Settlement` The allowable values are *Cash* or *Physical*.

  - An `ExerciseDates` node where exactly one `ExerciseDate` date
    element must be given.

  - `Premiums` \[Optional\]: Option premium amounts paid by the option
    buyer to the option seller.

    Allowable values: See section
    <a href="#ss:premiums" data-reference-type="ref"
    data-reference="ss:premiums">[ss:premiums]</a>

- ReferenceSwapData: Contains a single `LegData` node that describes the
  trade’s reference swap funding leg. The asset leg is implied from the
  bond data. Payer should always be *false* i.e. the swap is entered
  from the viewpoint of the asset swap buyer.

---

### Autocallable Type 01

The `Autocallable_01` node is the trade data container for the
Autocallable_01 trade type, listing
<a href="#lst:autocallable01_data" data-reference-type="ref"
data-reference="lst:autocallable01_data">[lst:autocallable01_data]</a>
shows the structure of an example.

<div class="listing">

``` xml
    <Autocallable01Data>
      <NotionalAmount>12000000</NotionalAmount>
      <DeterminationLevel>11.0</DeterminationLevel>
      <TriggerLevel>9.8</TriggerLevel>
      <Underlying>
        <Type>FX</Type>
        <Name>ECB-EUR-NOK</Name>
      </Underlying>
      <Position>Long</Position>
      <PayCcy>EUR</PayCcy>
      <FixingDates>
        <ScheduleData>
          <Dates>
            <Dates>
              <Date>2018-09-27</Date>
              <Date>2019-09-27</Date>
              <Date>2020-09-27</Date>
              <Date>2021-09-29</Date>
              <Date>2022-09-28</Date>
            </Dates>
          </Dates>
        </ScheduleData>
      </FixingDates>
      <SettlementDates>
        <ScheduleData>
          <Dates>
            <Dates>
              <Date>2018-10-07</Date>
              <Date>2019-10-09</Date>
              <Date>2020-10-07</Date>
              <Date>2021-10-07</Date>
              <Date>2022-10-07</Date>
            </Dates>
          </Dates>
        </ScheduleData>
      </SettlementDates>
      <AccumulationFactors>
        <Factor>0.344</Factor>
        <Factor>0.733</Factor>
        <Factor>0.911</Factor>
        <Factor>1.123</Factor>
        <Factor>1.544</Factor>
      </AccumulationFactors>
      <Cap>1.0</Cap>
    </Autocallable01Data>
```

</div>

If a trigger event occurs on the $i$-th fixing date, the option holder
receives the following:

$$Payout = \text{\lstinline!NotionalAmount!} * AccumulationFactor_i.$$

If a trigger event never occurs and the underlying spot at the fixing
date $f_n$ is above the `DeterminationLevel`, the option holder pays the
following:

$$Payout = \min (\text{\lstinline!Cap!}, \text{\lstinline!Underlying!}(f_n) - \text{\lstinline!DeterminationLevel!}).$$

The meanings and allowable values of the elements in the
`Autocallable01Data` node follow below.

- NotionalAmount: The notional amount of the option. Allowable values
  are non-negative numbers.

- DeterminationLevel: The determination level. For an FX underlying
  FX-SOURCE-CCY1-CCY2 this is the number of units of CCY2 per units of
  CCY1. For an EQ underlying this is the equity price expressed in the
  equity ccy. Allowable values are non-negative numbers.

- TriggerLevel: The trigger level. For an FX underlying
  FX-SOURCE-CCY1-CCY2 this is the number of units of CCY2 per units of
  CCY1. For an EQ underlying this is the equity price expressed in the
  equity ccy. Allowable values are non-negative numbers.

- Underlying: The option underlying, see
  <a href="#ss:underlying" data-reference-type="ref"
  data-reference="ss:underlying">[ss:underlying]</a>.

- Position: The option position type. Allowable values: *Long* or
  *Short*.

- PayCcy: The pay currency of the option. See the appendix for allowable
  currency codes.

- FixingDates: The fixing date schedule given as a `ScheduleData`
  subnode, see <a href="#ss:schedule_data" data-reference-type="ref"
  data-reference="ss:schedule_data">[ss:schedule_data]</a>

- SettlementDates: The settlement date schedule given as a
  `ScheduleData` subnode, see
  <a href="#ss:schedule_data" data-reference-type="ref"
  data-reference="ss:schedule_data">[ss:schedule_data]</a>

- AccumulationFactors: The accumulation factors given as a list of
  values corresponding to the fixing dates. Allowable values are
  non-negative numbers.

- Cap: The maximum amount, per unit of notional, payable by the option
  holder if a trigger event never occurred (i.e. underlying value was
  never below the `TriggerLevel` on any of the fixing dates) and if the
  underlying value is greater than the `DeterminationLevel` at the last
  fixing date. Allowable values are non-negative numbers.

---

### Balance Guaranteed Swap (BGS)

BGS are priced in ORE using an auxiliary Flexi Swap as a proxy. The
amortization schedule of the Flexi Swap is set up as the notional
schedule of the BGS assuming a zero CPR (Conditional Prepayment Rate).
The lower notional bound of the Flexi Swap is constructed assuming a
MaxCPR (Maximum Conditional Prepayment Rate) which is dependent on the
Reference Security. The MaxCPR is estimated on the basis of the current
CPR, historical CPRs and / or expert judgement as to provide a
(hypothetical) sufficiently realistic hedge for the BGS. The option
holder in the Flexi Swap is the payer of the structured leg (i.e. the
leg replicating the payments of the reference security) in the BGS.

The `BalanceGuaranteedSwapData` node is the trade data container for
trade type *BalanceGuaranteedSwap*. A BGS must have two legs, one fixed
and one floating. Each leg typically has an amortising notional and is
represented by a `LegData` trade component sub-node, described in
section <a href="#ss:leg_data" data-reference-type="ref"
data-reference="ss:leg_data">[ss:leg_data]</a>. The
`BalanceGuaranteedSwapData` node also contains a `ReferenceSecurity`
sub-node specifying the Asset Backed Security to which the notional
schedule of the BGS is linked. An example structure of a
`BalanceGuaranteedSwapData` node is shown in Listing
<a href="#lst:bgs_data" data-reference-type="ref"
data-reference="lst:bgs_data">[lst:bgs_data]</a>.

<div class="listing">

``` xml
<BalanceGuaranteedSwapData>
  <ReferenceSecurity>ISIN:XS0983610930</ReferenceSecurity>
  <Tranches>
    <Tranche>
      <Description>Class A</Description>
      <SecurityId>ISIN:XS0983610930</SecurityId>
      <Seniority>1</Seniority>
      <Notionals>
      ...
      </Notionals>
    </Tranche>
    <Tranche>
      <Description>Class B</Description>
      <SecurityId>ISIN:XS0983610931</SecurityId>
      <Seniority>2</Seniority>
      <Notionals>
      ...
      </Notionals>
    </Tranche>
    <ScheduleData>
    ...
    </ScheduleData>
  </Tranches>
  <LegData>
    <LegType>Fixed</LegType>
     ...
  </LegData>
  <LegData>
    <LegType>Floating</LegType>
     ...
  </LegData>
<BalanceGuaranteedSwapData>
```

</div>

The meanings and allowable values of the elements in the
`BalanceGuaranteedSwapData` node follow below.

- ReferenceSecurity: The ISIN of the Asset Backed Security tranche to
  which the BGS is linked.

  Allowable values: The prefix `ISIN:` followed by an ISIN code for the
  Reference Security.

- Tranches: A description of the Asset Backed Security tranche
  notionals. Each Tranche is identified by a ` SecurityId` and an
  optional `Description`. Each Tranche has a `Seniority` given as a
  positive integer value where lower values mean higher seniority, i.e.
  $1$ is the most senior tranche (e.g. “class A”) followed by $2$ (e.g.
  “class B”) etc. The notionals are given in a sub-node `Notionals` as
  described in section <a href="#ss:leg_data" data-reference-type="ref"
  data-reference="ss:leg_data">[ss:leg_data]</a> w.r.t. a schedule given
  in `ScheduleData` which is shared across all tranches. There must be
  exactly one tranche with a security id matching the reference
  security.

- LegData: This is a trade component sub-node outlined in section
  <a href="#ss:leg_data" data-reference-type="ref"
  data-reference="ss:leg_data">[ss:leg_data]</a>. A BGS must have two
  `LegData` nodes and the LegType element must be set to *Floating* on
  one leg and *Fixed* on the other. The two legs must have the same
  `Currency`.

The notionals of the swap and the referenced tranche must be consistent.
Furthermore, notionals for periods with a start date in the past must be
given with their actual value, i.e. including actual prepayments that
were made in the previous periods. Notionals for periods with a start
dats in the future on the other hand must be given assuming a zero
conditional prepayment rate. For the latter periods a prepayment model
is used to generate suitable notional schedules when pricing the swap.
The prepayment model assumes that tranches with higher seniority are
amortised first, i.e. in the example here the class A tranche is
amortised before the class B tranche.

---

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

---

### Best Entry Option

Best Entry Options are defined using one of the trade types
*FxBestEntryOption*, *EquityBestEntryOption*, *CommodityBestEntryOption*
depending on the underlying asset class and an associated node
FxBestEntryOptionData, EquityBestEntryOptionData,
CommodityBestEntryOptionData. Listing
<a href="#lst:bestentryoption_data" data-reference-type="ref"
data-reference="lst:bestentryoption_data">[lst:bestentryoption_data]</a>
shows an example for an Equity Underlying. For a more detailed
description of the computation of the payoff of this option, please see
the product description. The nodes have the following meaning:

- Underlying: The underlying definition. Note that for FX underlyings
  the order of the currencies defines the observed underlying value,
  i.e. for EUR-USD the domestic currency is USD (the observed value is
  e.g. $1.2$ USD per EUR) while for USD-EUR the domestic currency is EUR
  (the observed value is e.g. $0.8$ EUR per USD).

  Allowable Values: See
  <a href="#ss:underlying" data-reference-type="ref"
  data-reference="ss:underlying">[ss:underlying]</a>

- Currency: The payment currency.

  Allowable Values: See `Currency` in Table
  <a href="#tab:allow_stand_data" data-reference-type="ref"
  data-reference="tab:allow_stand_data">[tab:allow_stand_data]</a>.

- SettlementDate: The date on which the option payoff is settled. The
  SettlementDate is used unadjusted as given.

  Allowable Values: any valid date greater or equal to the exercise
  date.

- Notional: The notional amount.

  Allowable Values: any real number

- Strike: The strike value used to compute the payoff of the option.
  This value should be provided as a decimal, representing a percentage
  of the value of $Index_{Initial}$, e.g. a value of
  $K = 0.6 \implies 0.6 \times Index_{Initial}$ in the computation of
  the payoff. Allowable Values: any real number

- Multiplier: The payoff multiplier used in the case that the underlying
  index is greater than the strike on the settlement date. If omitted
  defaults to $1$.

  Allowable Values: any real number

- TriggerLevel: The value that is compared to the underlying index on
  each strike observation date to determine if a Trigger Event has
  occurred. This should be provided as a decimal, representing a
  percentage of the value of Strike Index Level, ie the value of the
  underlying on the `StrikeDate`.

  Allowable Values: any real number

- LongShort: Denotes whether the payoff is computed relative to the
  holder or seller of the option.

  Allowable Values: *Long*, *Short*.

- Cap: The maximum value of the payoff (before the notional and
  multiplier are applied). This value should be interpreted as a
  percentage and should be in decimal format in the trade XML, e.g.
  $0.06 = 6\%$.

  Allowable Values: any real number

- ResetMinimum: The minimum value of $Index_{Initial}$ in the case that
  a Trigger Event has occurred at least once during the option’s
  lifetime. This should be provided as a decimal, representing a
  percentage of the value of Strike Index Level used in the computation
  of $Index_{Initial}$.

  Allowable Value: any real number

- StrikeDate: The date on which the level on the underlying index is
  used to compute the payoff, in the case that there has not been a
  Trigger Event during the option’s lifetime.

  Allowable Value: any valid date before the option expiry date.

- ExpiryDate: The date on which the option expires and the payoff is
  computed.

  Allowable Values: any valid date before the SettlementDate

- Premium: The option premium. Defaults to $0$.

  Allowable Values: any real number.

- PremiumDate: The date on which the option premium is paid.

  Allowable Values: any valid date.

- StrikeObservationDates: The set of dates on which the underlying index
  level is observed - the lowest of which is used to compute the option
  payoff if the underlying index is greater than the strike on the
  expiry date.

  Allowable Values: any valid dates schedule (see
  <a href="#ss:schedule_data" data-reference-type="ref"
  data-reference="ss:schedule_data">[ss:schedule_data]</a>).

<div class="listing">

``` xml
    <EquityBestEntryOptionData>
      <LongShort>Long</LongShort>
      <Strike>0.85</Strike>
      <Cap>0.06</Cap>
      <ResetMinimum>0.85</ResetMinimum>
      <Notional>1000000</Notional>
      <Multiplier>1</Multiplier>
      <TriggerLevel>0.95</TriggerLevel>
      <SettlementDate>2021-11-20</SettlementDate>
      <PremiumDate>2021-11-22</PremiumDate>
      <StrikeDate>2020-12-15</StrikeDate>
      <Underlying>
        <Type>Equity</Type>
        <Name>RIC:.SPX</Name>
      </Underlying>
      <StrikeObservationDates>
        <Dates>
          <Dates>
            <Date>2021-03-01</Date>
            <Date>2021-06-01</Date>
            <Date>2021-09-01</Date>
          </Dates>
        </Dates>
      </StrikeObservationDates>
      <Currency>USD</Currency>
      <Premium>100</Premium>
      <ExpiryDate>2021-11-20</ExpiryDate>
    </EquityBestEntryOptionData>
```

</div>

---

### Bond Forward / T-Lock / J-Lock (using ref. data)

A Forward Bond (or Bond Forward) is a contract that establishes an
agreement to buy or sell (determined by `LongInForward`) an underlying
bond at a future point in time (the `ForwardMaturityDate`) at an agreed
price (the settlement `Amount`).

A T-Lock is a Forward Bond with a US Treasury Bond as underlying,
whereas a J-Lock is a Forward Bond with a Japanese Government Bond as
underlying. T-Locks can be specified in terms of a lock-in yield rather
then a settlement amount. The cash settlement amount is given by (bond
yield at maturity - lock rate) x DV01 in this case.

Listing <a href="#lst:forward_bond_refdata" data-reference-type="ref"
data-reference="lst:forward_bond_refdata">[lst:forward_bond_refdata]</a>
shows an example for a physically settled forward bond. Listing
<a href="#lst:forward_bond_refdata_tlock" data-reference-type="ref"
data-reference="lst:forward_bond_refdata_tlock">[lst:forward_bond_refdata_tlock]</a>
shows an example for a cash settled T-Lock transaction specified by a
lock-in yield.

A Forward Bond is set up using a `ForwardBondData` block as shown below
and the trade type is *ForwardBond*. The specific elements are

- The `BondData` block specifies the underlying bond, see below for more
  details.

  - SecurityId: The underlying security identifier  
    Allowable values: Typically the ISIN of the underlying bond, with
    the ISIN: prefix.

  - BondNotional: The notional of the underlying bond on which the
    forward is written expressed in the currency of the bond  
    Allowable values: Any positive real number.

  - CreditRisk \[Optional\] Boolean flag indicating whether to show
    Credit Risk on the Bond product. If set to *false*, the product
    class will be set to *RatesFX* instead of *Credit*, and there will
    be no credit sensitivities. Note that if the underlying bond
    reference is set up without a CreditCurveId - typically for some
    highly rated government bonds - the CreditRisk flag will have no
    impact on the product class and no credit sensitivities will be
    shown even if CreditRisk is set to *true*.  
    Allowable Values: *true* or *false* Defaults to *true* if left blank
    or omitted.

- SettlementData: The entity defining the terms of settlement:

  - ForwardMaturityDate: The date of maturity of the forward contract.  
    Allowable values: See `Date` in Table
    <a href="#tab:allow_stand_data" data-reference-type="ref"
    data-reference="tab:allow_stand_data">[tab:allow_stand_data]</a>.

  - ForwardSettlementDate \[Optional\]: Settlement date for forward bond
    or cash settlement payment date.  
    Allowable values: See `Date` in Table
    <a href="#tab:allow_stand_data" data-reference-type="ref"
    data-reference="tab:allow_stand_data">[tab:allow_stand_data]</a>.

  - Settlement \[Optional\]: Cash or Physical. Option, defaults to
    Physcial, except in case the settlement is defined by LockRate, in
    which case it defaults to Cash.  
    Allowable values: Cash, Physical

  - Amount \[Optional\]: The settlement amount (also called strike)
    transferred at forward maturity in return for either:  

    \(a\) the bond (physical delivery) or  

    \(b\) a cash amount equal to the dirty price of the bond (cash
    settlement).  

    This is transferred from the party that is long to the party that is
    short (determined by `LongInForward`) and cannot be a negative
    amount. It is assumed to be in the same currency as the underlying
    bond. Exactly one of the fields Amount, LockRate must be given.  
    Allowable values: Any non-negative real number.

  - LockRate \[Optional\]: The payoff is given by (yield at forward
    maturity - LockRate) x DV01 (LongInForward = true). Exactly one of
    the fields Amount, LockRate must be given. In case the LockRate is
    given, the Settlement must be set to Cash. If Settlement is not
    given, it defaults to Cash in this case.  
    Allowable values: Any non-negative real number. The LockRate is
    expressed in decimal form, eg 0.05 is a rate of 5%

  - dv01 \[Optional\]: When the LockRate is given, it is possible to
    implement a contractual DV01 instead of deriving it from the bond
    price.  
    Allowable values: Any positive real number. E.G If the dPdY is given
    then dv01=10000\*dPdY/N.

  - LockRateDayCounter \[Optional\]: The day counter w.r.t. which the
    lock rate is expressed. Optional, defaults to A360.  
    Allowable values: see table
    <a href="#tab:daycount" data-reference-type="ref"
    data-reference="tab:daycount">[tab:daycount]</a>

  - SettlementDirty \[Optional\]: A flag that determines whether the
    settlement amount (`Amount`) reflects a clean (*false*) or dirty
    (*true*) price. In either case, the dirty amount is actually paid on
    the forward maturity date, i.e. if SettlementDirty = *false*, the
    (forward) accruals are computed internally and added to the given
    amount to get the actual settlement amount. Optional, defaults to
    true.  
    Allowable values: *true*, *false*

- PremiumData: The entity defining the terms of a potential premium
  payment. This node is optional. If left out it is assumed that no
  premium is paid.

  - Date: The date when a premium is paid.  
    Allowable values: See `Date` in Table
    <a href="#tab:allow_stand_data" data-reference-type="ref"
    data-reference="tab:allow_stand_data">[tab:allow_stand_data]</a>.

  - Amount: The amount transferred as a premium. This is transferred
    from the party that is long to the party that is short (determined
    by `LongInForward`) and cannot be a negative amount. It is assumed
    to be in the same currency as the underlying bond.  
    Allowable values: Any non-negative real number.

- LongInForward: A flag that determines whether the forward contract is
  entered in long (*true*) or short (*false*) position.  
  Allowable values: *true*, *false*

<div class="listing">

``` xml
   <ForwardBondData>
     <BondData>
       <SecurityId>ISIN:XS1234567890</SecurityId>
       <BondNotional>100000</BondNotional>
     <BondData>
     <SettlementData>
       <ForwardMaturityDate>20160808</ForwardMaturityDate>
       <Settlement>Physcial</Settlement>
       <ForwardSettlementDate>20160810</ForwardSettlementDate>
       <Amount>1000000.00</Amount>
       <SettlementDirty>true</SettlementDirty>
     </SettlementData>
     <PremiumData>
       <Amount>1000.00</Amount>
       <Date>20160808</Date>
     </PremiumData>
     <LongInForward>true</LongInForward>
   </ForwardBondData>
```

</div>

<div class="listing">

``` xml
   <ForwardBondData>
     <BondData>
       <SecurityId>ISIN:XS1234567890</SecurityId>
       <BondNotional>100000</BondNotional>
     </BondData>
     <SettlementData>
       <ForwardMaturityDate>20160808</ForwardMaturityDate>
       <ForwardSettlementDate>20160810</ForwardSettlementDate>
       <LockRate>0.02365</LockRate>
     </SettlementData>
     <LongInForward>true</LongInForward>
   </ForwardBondData>
```

</div>

<div class="listing">

``` xml
        <ForwardBondData>
        <BondData>
          <SecurityId>ISIN:XS1234567890</SecurityId>
          <BondNotional>100000</BondNotional>
        </BondData>
        <SettlementData>
          <ForwardMaturityDate>20160808</ForwardMaturityDate>
          <ForwardSettlementDate>20160810</ForwardSettlementDate>
          <LockRate>0.02365</LockRate>
          <dv01>0.8</dv01>
        </SettlementData>
        <LongInForward>true</LongInForward>
        </ForwardBondData>
```

</div>

---

### Bond Future

A BondFuture can be used both as a stand alone trade (TradeType:
*BondFuture*) or as a trade component (`BondFutureData`) used within the
*TotalReturnSwap* (Generic TRS) trade type. See listing
<a href="#lst:bondfuturetradedata" data-reference-type="ref"
data-reference="lst:bondfuturetradedata">[lst:bondfuturetradedata]</a>,
and listing <a href="#lst:trsdata35" data-reference-type="ref"
data-reference="lst:trsdata35">[lst:trsdata35]</a> for a BondFuture used
within a TRS.

- ContractName: This ID defines both: which bond future reference datum
  to take and security specific spread to be used for pricing.

  Allowable values: A string identifying the contract name, supported in
  the market data configuration.

- ContractNotional: The notional of the position, expressed in the
  currency of the bond.

  Allowable values: A non-negative real number.

- LongShort: A flag that determines whether the forward contract is
  entered in long (*L*) or short (*S*) position.

  Allowable values: *Long*, *L*, or *Short*, *S*

Although it is not part of the trade representation, we also explain the
corresponding reference data, which is shown in listing
<a href="#lst:bondfuturerefdata" data-reference-type="ref"
data-reference="lst:bondfuturerefdata">[lst:bondfuturerefdata]</a>. The
following fields should always be specified:

- Currency: The currency in which the future is denominated.

  Allowable values: See Table
  <a href="#tab:currency" data-reference-type="ref"
  data-reference="tab:currency">[tab:currency]</a>.

- DeliveryBasket: A list of eligible securities/bond identifiers.

  Allowable Values: A valid bond identifier, typically the ISIN of the
  reference bond with the ISIN: prefix

- Settlement \[Optional\]: *Cash* or *Physical*. Optional, defaults to
  *Physical*.

- DirtyQuotation \[Optional\]: Whether the market quote of the future
  price is dirty (*true*) or clean (*false*, default if not specified).

The last trading (expiry) and last delivery (settlement) date of the
future can be given explicitly:

- LastTradingDate: The expiry date of the future

- LastDeliveryDate: The settlement date of the future

Alternatively, these dates can be derived from the following set of
fields:

- ContractMonth: specifies the delivery month.

  Allowable values are written English calendar month or its three
  letter abbreviation, e.g. *January* or *Jan*.

- RootDate: used to calculate the day of the month.

  Allowable values are *first* for the beginning of the month, *end* for
  month end or nth weekday (e.g. *Monday,3* for third Monday of the
  month).

- ExpiryBasis: used to set the basis for the expiry derivation.

  Allowable values are *ROOT* for the above root date as start date,
  *SETTLEMENT* for the settlement date as a start date

- SettlementBasis: used to set the basis for the settlement date
  derivation.

  Allowable values are *ROOT* for the above root date as start date,
  *EXPIRY* for the expiry date as a start date

- ExpiryLag: Period (positive/negative) which will be added/subtracted
  from the ExpiryBasis, to arrive at the expiry date.

  Allowable values are any combination of integers and *D* for days, *M*
  for months or *Y* for years, e.g. *3D* means a 3-day period.

- SettlementLag: Period (positive/negative) which will be
  added/subtracted from the SettlementBasis, to arrive at the settlement
  date.

  Allowable values are any combination of integers and *D* for days, *M*
  for months or *Y* for years, e.g. *3D* means a 3-day period.

Finally, the conversion factor can be given in the market data or it can
be deduced internally, which requires the following field to be filled:

- DeliverableGrade: The deliverable graded restricting the deliverable
  underlyings. This is used for calculation of the conversion factor.
  Allowable values are: *ZT, Z3N, ZF, ZN, TN, TWE, ZB, UB* (CME) or the
  equivalent *TU, 3Y, FV, TY, UXY, US, TWE, WN* (Bloomberg)

<div class="listing">

``` xml
    <BondFutureData>
      <ContractName>with_ref</ContractName>
      <ContractNotional>1000000</ContractNotional>
      <LongShort>L</LongShort>
    </BondFutureData>
```

</div>

<div class="listing">

``` xml
    <BondFutureReferenceData id="TYU25">
      <!-- should always be specified -->
      <Currency>USD</Currency>
      <DeliveryBasket>
        <SecurityId>ISIN:US91282CDJ71</SecurityId>
        <SecurityId>ISIN:US91282CEP23</SecurityId>
        <SecurityId>ISIN:US91282CLM19</SecurityId>
        <SecurityId>ISIN:US91282CLU35</SecurityId>
        <SecurityId>ISIN:US91282CMC28</SecurityId>
        <SecurityId>ISIN:US91282CMK44</SecurityId>
        <SecurityId>ISIN:US91282CMM00</SecurityId>
        <SecurityId>ISIN:US91282CMR96</SecurityId>
      </DeliveryBasket>
      <Settlement>Physical</Settlement>
      <DirtyQuotation>false</DirtyQuotation>
      <!-- LastTradingDate, LastDeliveryDate can be specified explicitly -->
      <LastTradingDate>2025-09-19</LastTradingDate>
      <LastDeliveryDate>2025-09-30</LastDeliveryDate>
      <!-- only required if LastTradingDate, LastDeliveryDate is not given -->
      <ContractMonth>Mar</ContractMonth>
      <RootDate>End</RootDate>
      <ExpiryBasis>Settlement</ExpiryBasis>
      <SettlementBasis>Root</SettlementBasis>
      <ExpiryLag>-7D</ExpiryLag>
      <SettlementLag>0D</SettlementLag>
      <!-- only required if conversion factor is not given as market data -->
      <DeliverableGrade>ZN</DeliverableGrade>
    </BondFutureReferenceData>
```

</div>

### Derivation of the LastTradingDate and LastDeliveryDate

The example with the reference data block above, i.e. listing
<a href="#lst:bondfuturerefdata" data-reference-type="ref"
data-reference="lst:bondfuturerefdata">[lst:bondfuturerefdata]</a>,
shows how to set up a future referencing an USD 10-Year-T-Note. The
rules to derive last trading and last delivery date are taken from the
CME Group primer “Understanding Treasury Futures”. These are:

- Last Delivery Day: Last business day of the delivery month

- Last Trading Day: Seventh business day preceding the last business day
  of the delivery month

The year is derived from the as-of date. Being the following year or the
same depending whether the contract month has been passed this year or
not. Our starting point, i.e. the root date, is the ’Last business day
of the delivery month’. We achieved this by setting `ContractMonth` =
*March* and `RootDate` = *End*. From this root we can define the
settlement date (last delivery) by `SettlementBasis` = *Root* in
combination with `SettlementLag` = *0D*. From the settlement, we can
define the expiry date (last trading) by `ExpiryBasis` = *Settlement*
and `ExpiryLag` = *-7D*. From this we are getting the Last Trading Date
to be the 20th of March and the Last Delivery Date to be the 31st of
March.

### CTD Selection

The selection of the CTD bond is implemented in ORE as described in
Hull’s “Options, Futures and Other Derivatives”: Be *sp* the quoted
future settlement price, *ai* accrued interest, *cf* the bond specific
conversion factor and *bp* the bond price. The party with the short
position receives

$$(sp \cdot cf) + ai$$

and the cost of purchasing a bond is

$$bp + ai$$

The cheapest-to-deliver bond is the one for which

$$bp - (sp \cdot cf)$$

is least. The decision is taking place at future expiry.

---

### Bond

A Bond is set up using a `BondData` block, and can be both a stand-alone
instrument with trade type *Bond*, or a trade component used by multiple
bond derivative instruments.

A Bond can be set up in a short version referencing an underlying bond
static, or in a long version where the underlying bond details are
specified explicitly, including a full LegData block. The short version
is shown in listing
<a href="#lst:bonddata_refdata" data-reference-type="ref"
data-reference="lst:bonddata_refdata">[lst:bonddata_refdata]</a>. The
details of the bond are read from the reference data in this case using
the SecurityId as a key. The bond trade is fully specified by

- SecurityId: The id identifying the bond.

  Allowable Values: A valid bond identifier, typically the ISIN of the
  reference bond with the ISIN: prefix, e.g.: `ISIN:XXNNNNNNNNNN`

- BondNotional: The notional of the position in the reference bond,
  expressed in the currency of the bond.

  Allowable Values: Any non-negative real number

- CreditRisk \[Optional\] Boolean flag indicating whether to show Credit
  Risk on the Bond product. If set to *false*, the product class will
  not be set to *Credit*, and there will be no credit sensitivities.
  However, if the underlying bond reference is set up without a
  CreditCurveId - typically for some highly rated government bonds - the
  CreditRisk flag will have no impact on the product class and no credit
  sensitivities will be shown even if CreditRisk is set to *true*.

  Allowable Values: *true* or *false* Defaults to *true* if left blank
  or omitted.

in this case.

<div class="listing">

``` xml
    <BondData>
      <SecurityId>ISIN:XS0982710740</SecurityId>
      <BondNotional>100000000.0</BondNotional>
      <CreditRisk>true</CreditRisk>
    </BondData>
```

</div>

For the long version, the bond details are inlined in the trade as shown
in listing <a href="#lst:bonddata" data-reference-type="ref"
data-reference="lst:bonddata">[lst:bonddata]</a>. The bond specific
elements are

- IssuerId \[Optional\]: A text description of the issuer of the bond.
  This is for informational purposes and not used for pricing.

  Allowable values: Any string. If left blank or omitted, the bond will
  not have any issuer description.

- CreditCurveId \[Optional\]: The unique identifier of the bond. This is
  used for pricing, and is required for bonds for which a credit -
  related margin component should be generated, and otherwise left
  blank. If left blank, the bond (and any bond derivatives using the
  bond as a trade component) will be plain IR rather than a IR/CR.

  Allowable values: A valid bond identifier, typically the ISIN of the
  reference bond with the ISIN: prefix, e.g.: `ISIN:XXNNNNNNNNNN`

- SecurityId: The unique identifier of the bond. This defines the
  security specific spread to be used for pricing.

  Allowable values: A valid bond identifier, typically the ISIN of the
  reference bond with the ISIN: prefix, e.g.: `ISIN:XXNNNNNNNNNN`

- ReferenceCurveId: The benchmark curve to be used for pricing. This is
  typically the main ibor index for the currency of the bond, and if no
  ibor index is available for the currency in question, a
  currency-specific benchmark curve can be used.

  Allowable values: For currencies with available ibor indices:  
  An alphanumeric string of the form \[CCY\]-\[INDEX\]-\[TERM\]. CCY,
  INDEX and TERM must be separated by dashes (-). CCY and INDEX must be
  among the supported currency and index combinations. TERM must be an
  integer followed by D, W, M or Y. See Table
  <a href="#tab:indices" data-reference-type="ref"
  data-reference="tab:indices">[tab:indices]</a>.

  For currencies without available ibor indices:  
  An alphanumeric string, matching a benchmark curve set up in the
  market data configuration in `todaysmarket.xml` Yield curves section.

  Examples: IDRBENCHMARK-IDR-3M, EGPBENCHMARK-EGP-3M,
  UAHBENCHMARK-UAH-3M, NGNBENCHMARK-NGN-3M

- SettlementDays: The settlement lag in number of business days
  applicable to the security.

  Allowable values: A non-negative integer.

- Calendar: The calendar associated to the settlement lag.

  Allowable values: See Table
  <a href="#tab:calendar" data-reference-type="ref"
  data-reference="tab:calendar">[tab:calendar]</a> Calendar.

- IssueDate: The issue date of the security.

  See `Date` in Table
  <a href="#tab:allow_stand_data" data-reference-type="ref"
  data-reference="tab:allow_stand_data">[tab:allow_stand_data]</a>.

- PriceQuoteMethod \[Optional\]: The quote method of the bond. Bond
  price quotes and historical bond prices (stored as “fixings”) follow
  this method. Also, the initial price for bond total return swaps
  follows this method. Defaults to PerentageOfPar.

  Allowable values: PercentageOfPar or CurrencyPerUnit

- PriceQuoteBaseValue \[Optional\]: The base value for quote method =
  CurrencyPerUnit. Bond price quotes, historical bond prices stored as
  fixings and initial prices in bond total return swaps are divided by
  this value. Defaults to 1.0.

  Allowable values: Any real number.

A LegData block then defines the cashflow structure of the bond, this
can be of type fixed, floating etc. Note that a LegData block should
only be included in the long version.

<div class="listing">

``` xml
    <BondData>
        <IssuerId>Ineos Group Holdings SA</IssuerId>
        <CreditCurveId>ISIN:XS0982710740</CreditCurveId>
        <SecurityId>ISIN:XS0982710740</SecurityId>
        <ReferenceCurveId>EUR-EURIBOR-6M</ReferenceCurveId>
        <SettlementDays>2</SettlementDays>
        <Calendar>TARGET</Calendar>
        <IssueDate>20160203</IssueDate>
        <PriceQuoteMethod>PercentageOfPar</PriceQuoteMethod>
        <PriceQuoteBaseValue>1.0</PriceQuoteBaseValue>
        <LegData>
            <LegType>Fixed</LegType>
            <Payer>false</Payer>
            ...
        </LegData>
    </BondData>
```

</div>

The bond trade type supports perpetual schedules, i.e. perpetual bonds
can be represented by omitting the EndDate in the leg data schedule
definition. Only rule based schedules can be used to indicate perpetual
schedules.

---

### Bond Option

A bond option provides the buyer with the right, but not the obligation,
to buy or sell a given bond at a fixed price either at or before a
specific date. Options are written on government bonds and are traded on
an OTC basis.

The structure of a trade node representing a *BondOption* is shown in
listing <a href="#lst:bondoption_data" data-reference-type="ref"
data-reference="lst:bondoption_data">[lst:bondoption_data]</a>:

- The `BondOptionData` node is the trade data container for the option
  part of a bond option trade type. Vanilla bond options are supported,
  the exercise style must be *European*. The `BondOptionData` node
  includes one and only one `OptionData` trade component sub-node plus
  elements specific to the bond option.

- The latter also includes the underlying Bond description in the
  `BondData` node, see section
  <a href="#ss:bond" data-reference-type="ref"
  data-reference="ss:bond">[ss:bond]</a>, listing
  <a href="#lst:bonddata" data-reference-type="ref"
  data-reference="lst:bonddata">[lst:bonddata]</a> for details

<div class="listing">

``` xml
  <Trade id="...">
    <TradeType>BondOption</TradeType>
    <Envelope>
        ...
    </Envelope>
    <BondOptionData>
      <OptionData>
          ...
      </OptionData>
      <StrikeData>
        <StrikePrice>
          <Value>11809123.56</Value>
          <Currency>EUR</Currency>
        </StrikePrice>
      </StrikeData>
      <Redemption>100.00</Redemption>
      <PriceType>Dirty</PriceType>
      <KnocksOut>false</KnocksOut>
      <BondData>
         <VolatilityCurveId>YieldVols-EUR</VolatilityCurveId>
          ...
      <BondData>
    </BondOptionData>
  </Trade>
```

</div>

The meanings and allowable values of the elements in the
`BondOptionData` node follow below.

- OptionData: This is a trade component sub-node outlined in section
  <a href="#ss:option_data" data-reference-type="ref"
  data-reference="ss:option_data">[ss:option_data]</a> Option Data. Note
  that the bond option type allows for *European* option style only.

- StrikeData: A node containing the strike information. Allowable
  values: Supports `StrikePrice` and `StrikeYield` as described in
  Section <a href="#ss:strikedata" data-reference-type="ref"
  data-reference="ss:strikedata">[ss:strikedata]</a>.

- Redemption: Redemption ratio in percent

- PriceType: This node defines which strike should be used for the
  pricing. If the node takes the value Dirty, the strike price should be
  set equal to the value of the Strike node. If the node takes the value
  Clean, the strike price should be set equal to the value of the Strike
  node plus accrued interest at the expiration date of the option.  
  Allowable values: Dirty or Clean.

- KnocksOut: If true the option knocks out if the underlying defaults
  before the option expiry, if false the option is written on the
  recovery value in case of a default of the bond before the option
  expiry

The meanings and allowable values of the elements in the `BondData` are:

- VolatilityCurveId: The yield volatility curve to use for the valuation
  of this bond option.

---

### Bond Option (using bond reference data)

The structure of a trade node representing a *BondOption* is shown in
listing <a href="#lst:bondoption_data_refdata" data-reference-type="ref"
data-reference="lst:bondoption_data_refdata">[lst:bondoption_data_refdata]</a>:

- The `BondOptionData` node is the trade data container for the option
  part of a bond option trade type. Vanilla bond options are supported,
  the exercise style must be *European*. The `BondOptionData` node
  includes one and only one `OptionData` trade component sub-node plus
  elements specific to the bond option.

- The latter also includes the underlying Bond description in the
  `BondData` node, see below for details

Note that only par redemption vanilla bonds are supported.

<div class="listing">

``` xml
  <Trade id="...">
    <TradeType>BondOption</TradeType>
    <Envelope>
        ...
    </Envelope>
    <BondOptionData>
      <OptionData>
       <LongShort>Long</LongShort>
       <OptionType>Call</OptionType>
       <Style>European</Style>
       <ExerciseDates>
        <ExerciseDate>20210203</ExerciseDate>
       </ExerciseDates>
          ...
      </OptionData>
      <StrikeData>
        <StrikePrice>
      <Value>1.23</Value>
    </StrikePrice>
      </StrikeData>
      <PriceType>Dirty</PriceType>
      <KnocksOut>false</KnocksOut>
      <BondData>
         <SecurityId>ISIN:XS1234567890</SecurityId>
         <BondNotional>100000</BondNotional>
      <BondData>
    </BondOptionData>
  </Trade>
```

</div>

The meanings and allowable values of the elements in the
`BondOptionData` node follow below.

- OptionData: This is a trade component sub-node outlined in section
  <a href="#ss:option_data" data-reference-type="ref"
  data-reference="ss:option_data">[ss:option_data]</a> Option Data.

  The relevant fields in the `OptionData` node for a BondOption are:

  - `LongShort` The allowable values are *Long* or *Short*.

  - `OptionType` The allowable values are *Call* or *Put*. For option
    type *Call*, the Bond Option holder has the right to buy the
    underlying Bond at the strike price. For option type *Put*, the Bond
    Option holder has the right to sell the underlying Bond at the
    strike price.

  - `Style` The allowable value is *European* only.

  - `Settlement` \[Optional\] The allowable values are *Cash* or
    *Physical*, but this field is currently ignored.

  - An `ExerciseDates` node where exactly one ExerciseDate date element
    must be given.  

  - Premiums \[Optional\]: Option premium amounts paid by the option
    buyer to the option seller.

    Allowable values: See section
    <a href="#ss:premiums" data-reference-type="ref"
    data-reference="ss:premiums">[ss:premiums]</a>

- `StrikeData`: A `StrikeData` node is used as described in Section
  <a href="#ss:strikedata" data-reference-type="ref"
  data-reference="ss:strikedata">[ss:strikedata]</a> to represent the
  Bond Option strike price or strike yield. If StrikePrice is used, the
  strike price (`Value` field) is expressed per unit notional, i.e. a
  strike of 101% of the bond notional is expressed as 1.01. If
  StrikeYield is used, the `Yield` is quoted in decimal form, e.g. 5%
  should be entered as 0.05.

- PriceType \[Mandatory for StrikePrice, no impact for StrikeYield\]:  
  The payoff for a bond option is

  max(B - X, 0)

  where B is always the dirty NPV of the underlying bond on the exercise
  settlement date.  
  If `PriceType` is *Clean*, X is (Strike + Underlying Bond Accruals) x
  BondNotional If `PriceType` is *Dirty*, X is Strike x BondNotional

  Allowable values: *Dirty* or *Clean*. If the `StrikeData` node uses
  StrikeYield, `PriceType` can be omitted as it is not relevant in the
  yield case.

- KnocksOut: If *true* the option knocks out if the underlying defaults
  before the option expiry, if *false* the option is written on the
  recovery value in case of a default of the bond before the option
  expiry.

  Allowable values: Boolean node, allowing *Y, N, 1, 0, true, false*
  etc. The full set of allowable values is given in Table
  <a href="#tab:boolean_allowable" data-reference-type="ref"
  data-reference="tab:boolean_allowable">[tab:boolean_allowable]</a>.

The meanings and allowable values of the elements in the `BondData` are:

- SecurityId: The underlying security identifier

  Allowable values: Typically the ISIN of the underlying bond, with the
  ISIN: prefix.

- BondNotional: The notional of the underlying bond on which the option
  is written expressed in the currency of the bond.

  Allowable values: Any positive real number.

- CreditRisk \[Optional\] Boolean flag indicating whether to show Credit
  Risk on the Bond product.

  Allowable Values: *true* or *false* Defaults to *true* if left blank
  or omitted.

---

### Bond Position

A bond position represents a position in a weighted basket of underlying
bonds.

A bond position can be used both as a stand alone trade type (TradeType:
*BondPosition*) or as a trade component (`BondBasketData`) used within
the *TotalReturnSwap* (Generic TRS) trade type.

It is set up using an `BondBasketData` block as shown in listing
<a href="#lst:bondbasketdata" data-reference-type="ref"
data-reference="lst:bondbasketdata">[lst:bondbasketdata]</a>. The
meanings and allowable values of the elements in the block are as
follows:

- Quantity: The number of units of the weighted basket held.  
  Allowable values: Any positive real number

- Identifier\[Optional\]: The identifier of the weighted basket. The
  Underlying data can be retrieved from the reference data via this
  identifier, if not given in the trade itself. If the bond basket data
  is set up in the trade itself in Underlying blocks as in listing
  <a href="#lst:bondbasketdata" data-reference-type="ref"
  data-reference="lst:bondbasketdata">[lst:bondbasketdata]</a>, no
  Identifier is required.  
  Allowable values: A string that matches the reference data.

- Underlying\[Optional\]: One or more underlying descriptions. If bond
  basket data is set up in the reference data for the given identifier,
  the underlying data will be populated from there and does not need to
  be provided in the trade. The weighted basket price is then given by  
  $$\text{Basket-Price} = \text{Quantity} \times \sum_i \text{Weight}_i \times B_i \times \text{FX}_i$$
  where

  - $B_i$ is the price of the ith Bond in the basket

  - $FX_i$ is the FX Spot converting from the currency of the ith Bond
    to the return currency if the BondPosition is in a TotalReturnSwap,
    otherwise to the currency of the first Bond in the basket.

  Allowable values: See
  <a href="#ss:underlying" data-reference-type="ref"
  data-reference="ss:underlying">[ss:underlying]</a> for the definition
  of an underlying. Only underlyings of Type *Bond* are allowed.

<div class="listing">

``` xml
  <Trade id="BondPosition">
    <TradeType>BondPosition</TradeType>
    <Envelope>...</Envelope>
    <BondBasketData>
      <Quantity>1000</Quantity>
      <Identifier>ISIN:GB00B4KT9Q30</Identifier>
      <Underlying>
        <Type>Bond</Type>
        <Name>US69007TAB08</Name>
        <IdentifierType>ISIN</IdentifierType>
        <Weight>0.5</Weight>
        <BidAskAdjustment>-0.0025</BidAskAdjustment>
      </Underlying>
      <Underlying>
        <Type>Bond</Type>
        <Name>US750236AW16</Name>
        <IdentifierType>ISIN</IdentifierType>
        <Weight>0.5</Weight>
        <BidAskAdjustment>-0.005</BidAskAdjustment>
      </Underlying>
    </BondBasketData>
  </Trade>
```

</div>

---

### Bond Repo

In a bond repo transaction one party A receives a cash amount from a
party B for a specified period. At the maturity of the trade party A
pays back the cash amount plus accrued interest to party B. Intermediate
interest payments are also possible. Party A delivers a bond to party B
as a collateral for the received cash amount for the duration of the
trade. In exchange the interest to be paid by party A will be lower than
for an uncollateralised borrowing transaction.

A bond repo trade is set up using the trade type `BondRepo` and a
`BondRepoData` block as shown in listing
<a href="#lst:bondrepodata" data-reference-type="ref"
data-reference="lst:bondrepodata">[lst:bondrepodata]</a>. The block
contains two nodes

- `BondData`, which specifies the underlying bond and its quantity, and

- `RepoData`, which specifies the cash leg of the repo

The `BondData` block contains the following fields

- SecurityId: The identified of the underlying security.  
  Allowable values: A valid key, usually of the form “ISIN::XY012345679”

- BondNotional: The notional of the underlying bond. This is the
  effective notional used as collateral, i.e. it should include hair
  cuts. Usually the number Bond Notional x Bond Dirty Price x (1 -
  Haircut) will correspond to the nominal on the cash leg at trade
  inception.  
  Allowable values: Any positive real number.

- CreditRisk \[Optional\] Boolean flag indicating whether to show Credit
  Risk on the Bond product.  
  Allowable Values: *true* or *false* Defaults to *true* if left blank
  or omitted.

In this case the details of the underlying bond is read from the
reference data. It is also possible to inline the details in the trade,
see <a href="#ss:bond" data-reference-type="ref"
data-reference="ss:bond">[ss:bond]</a> for more details on this.

The `RepoData` block contains exactly one `LegData` subnode that
describes the payments on the cash leg of the repo, see
<a href="#ss:leg_data" data-reference-type="ref"
data-reference="ss:leg_data">[ss:leg_data]</a> for details on how to set
this up. The `Payer` leg determines whether interest is paid (regular
repo) or received (reversed repo).

<div class="listing">

``` xml
<BondRepoData>
  <BondData>
    <SecurityId>ISIN:US912828X703</SecurityId>
    <BondNotional>27807597.777444</BondNotional>
  </BondData>
  <RepoData>
    <LegData>
      <LegType>Fixed</LegType>
      <Payer>true</Payer>
      <Currency>USD</Currency>
      <Notionals>
        <Notional>28371510.00</Notional>
      </Notionals>
      <ScheduleData>
        <Rules>
          <StartDate>2020-01-06</StartDate>
          <EndDate>2020-04-07</EndDate>
          <Tenor>1Y</Tenor>
          <Calendar>US</Calendar>
          <Convention>MF</Convention>
          <TermConvention>MF</TermConvention>
          <Rule>Forward</Rule>
          <EndOfMonth/>
          <FirstDate/>
          <LastDate/>
        </Rules>
      </ScheduleData>
      <DayCounter>A360</DayCounter>
      <PaymentConvention>F</PaymentConvention>
      <FixedLegData>
        <Rates>
          <Rate>0.0178</Rate>
        </Rates>
      </FixedLegData>
    </LegData>
  </RepoData>
</BondRepoData>
```

</div>

---

### Bond Total Return Swap

A vanilla Bond Total Return Swap (Trade type: *BondTRS*) is set up using
a `BondTRSData` block as shown in listing
<a href="#lst:bondtrsdata" data-reference-type="ref"
data-reference="lst:bondtrsdata">[lst:bondtrsdata]</a>. The block is
comprised of three sub-blocks, which are `BondData`, `TotalReturnData`
and `FundingData`.

- The `BondData` block specifies the underlying bond, usually by
  specifying the security id and the quantity / bond notional and
  relying on reference data:

  - SecurityId: The underlying security identifier  
    Allowable values: Typically the ISIN of the underlying bond, with
    the ISIN: prefix. Note that Convertible Bonds are not supported as
    underlyings for BondTRS. For Convertible Bonds, trade type
    *TotalReturnSwap* should be used instead.

  - BondNotional: The quantity or number of bonds that is relevant for
    the TRS, with the convention that 1 bond always corresponds to a
    face value of 1 unit of bond currency.  
    Allowable values: Any positive real number.

  - CreditRisk \[Optional\] Boolean flag indicating whether to show
    Credit Risk on the Bond product. If set to *true*, the product class
    will be set to *Credit* instead of *RatesFX*, and there will be
    credit sensitivities. Note that if the underlying bond reference is
    set up without a CreditCurveId - typically for some highly rated
    government bonds - the CreditRisk flag will have no impact on the
    product class and no credit sensitivities will be shown even if
    CreditRisk is set to *true*.  
    Allowable Values: *true* or *false* Defaults to *true* if left blank
    or omitted.

  Alternatively, the BondData block can be specified fully explicit, as
  outlined in <a href="#ss:bond" data-reference-type="ref"
  data-reference="ss:bond">[ss:bond]</a>

- The `TotalReturnData` block specifies

  - Payer: Indicates whether the total return leg is paid.  
    Allowable values: *true* or *false*

  - InitialPrice \[Optional\]: Should be filled if the bond price on the
    first date of the total return schedule is contractually given, in
    which case the price must correspond to the price type of the total
    return leg, i.e. if the price type is *Dirty* then the InitialPrice
    must also be a dirty price (as it is usually given in the term sheet
    in this case). The price must given in percent, e.g. $101.20$.[^1]
    If not given, the bond price for the first date of the total return
    schedule is read from the price history. Notice that if a bond is
    quoted in Currency per Unit the initial price should be given in
    this format too: If e.g. one unit is $50.0$ USD an initial price of
    $51.0$ would correspond a dirty amount of $51.0$ USD for one unit of
    the bond.  
    Allowable values: Any positive real number.

  - PriceType: The price type on which these payments are based  
    Allowable values: *Dirty* or *Clean*

  - ObservationLag \[Optional\]: The lag between the valuation date and
    the reference schedule period start date.

    Allowable values: Any valid period, i.e. a non-negative whole
    number, followed by *D* (days), *W* (weeks), *M* (months), *Y*
    (years). Defaults to *0D* if left blank or omitted.

  - ObservationConvention \[Optional\]: The roll convention to be used
    when applying the observation lag.

    Allowable values: A valid roll convention (*F, MF, P, MP, U,
    NEAREST*), see Table
    <a href="#tab:convention" data-reference-type="ref"
    data-reference="tab:convention">[tab:convention]</a> Roll
    Convention. Defaults to *U* if left blank or omitted.

  - ObservationCalendar \[Optional\]: The calendar to be used when
    applying the observation lag.

    Allowable values: Any valid calendar, see Table
    <a href="#tab:calendar" data-reference-type="ref"
    data-reference="tab:calendar">[tab:calendar]</a> Calendar. Defaults
    to the *NullCalendar* (no holidays) if left blank or omitted.

  - PaymentLag \[Optional\]: The lag between the reference schedule
    period end date and the payment date.

    Allowable values: Any valid period, i.e. a non-negative whole
    number, optionally followed by *D* (days), *W* (weeks), *M*
    (months), *Y* (years). Defaults to *0D* if left blank or omitted. If
    a whole number is given and no letter, it is assumed that it is a
    number of *D* (days).

  - PaymentConvention \[Optional\]: The business day convention to be
    used when applying the payment lag.

    Allowable values: A valid roll convention (*F, MF, P, MP, U,
    NEAREST*), see Table
    <a href="#tab:convention" data-reference-type="ref"
    data-reference="tab:convention">[tab:convention]</a> Roll
    Convention. Defaults to *U* if left blank or omitted.

  - PaymentCalendar \[Optional\]: The calendar to be used when applying
    the payment lag.

    Allowable values: Any valid calendar, see Table
    <a href="#tab:calendar" data-reference-type="ref"
    data-reference="tab:calendar">[tab:calendar]</a> Calendar. Defaults
    to the *NullCalendar* (no holidays) if left blank or omitted.

  - PaymentDates \[Optional\]: This node allows for the specification of
    a list of explicit payment dates, using `PaymentDate` elements. The
    list must contain exactly $n-1$ dates where $n$ is the number of
    dates in the reference schedule given in the ScheduleData node. See
    Listing <a href="#lst:paymentdatesbondtrs" data-reference-type="ref"
    data-reference="lst:paymentdatesbondtrs">[lst:paymentdatesbondtrs]</a>
    for an example with an assumed ScheduleData with 4 dates.

    <div class="listing">

    ``` xml
                        <PaymentDates>
                              <PaymentDate>2020-01-15</PaymentDate>
                              <PaymentDate>2021-01-15</PaymentDate>
                              <PaymentDate>2022-01-17</PaymentDate>
                        </PaymentDates>
    ```

    </div>

  - FXTerms \[Mandatory when underlying bond and BondTRS currencies
    differ\]: Required if the bond currency is different from the return
    currency, which is always assumed to be equal to the funding leg
    currency. This kind of trade is also known as a “composite trs”. The
    subnode for the FXTerms node is:

    - FXIndex: The fx index to use for the conversion, this must contain
      the bond currency and the funding leg currency (in the order
      defined in table
      <a href="#tab:fxindex_data" data-reference-type="ref"
      data-reference="tab:fxindex_data">[tab:fxindex_data]</a>, i.e. it
      does not matter which one is the bond currency and which is the
      funding currency)

      Allowable values: See Table
      <a href="#tab:fxindex_data" data-reference-type="ref"
      data-reference="tab:fxindex_data">[tab:fxindex_data]</a>

    - ApplyFXIndexFixingDays \[Optional\]: If set to *true*, the FX
      fixing date is moved back by the usual number of fixing days (for
      example, 2 days before the valuation date), using the FX index
      calendar to skip holidays. If *false*, the FX fixing date is the
      same as the valuation date.

      Allowable values: *true* (use fixing lag) or *false* (use
      valuation date). Defaults to *false* if left blank or omitted.

  - ScheduleData: The reference schedule for the return leg, where the
    valuation dates are derived from this schedule using the
    ObservationLag, ObservationConvention and ObservationCalendar
    fields. The payment dates are derived from this schedule using the
    PaymentLag, PaymentConvention and PaymentCalendar fields. The
    payment dates can also be given as an explicit list in the
    PaymentDates node. Allowable values: A `ScheduleData` block as
    defined in section
    <a href="#ss:schedule_data" data-reference-type="ref"
    data-reference="ss:schedule_data">[ss:schedule_data]</a>

  - PayBondCashFlowsImmediately \[Optional\]: If true, bond cashflows
    like coupon or amortisation payments are paid when they occur. If
    false, these cashflows are paid together with the next return
    payment. If omitted, the default value is false.

    Allowable values: *true* (immediate payment of bond cashflows) or
    *false* (bond cashflows are paid on the next return payment date)

- The `FundingData` block specifies the funding leg, which can be of any
  leg type. The `FundingData` contains exactly one `Leg`. The currency
  of this leg also defines the currency in which the return is paid.
  Usually the funding leg’s notional will be aligned with the return
  leg’s notional. To achieve this, indexings on the floating leg can be
  used, see <a href="#ss:indexings" data-reference-type="ref"
  data-reference="ss:indexings">[ss:indexings]</a>. In the context of
  bond total return swaps, the indexings can be defined in a simplified
  way by adding an Indexings node with a subnode FromAssetLeg set to
  true to the funding leg’s LegData node. The notionals node is not
  required either in the funding leg’s LegData in this case. An example
  for this setup is shown in
  <a href="#lst:bondtrsdata" data-reference-type="ref"
  data-reference="lst:bondtrsdata">[lst:bondtrsdata]</a>.

<div class="listing">

``` xml
<BondTRSData>
  <BondData>
    <SecurityId>ISIN:NZIIBDT005C5</SecurityId>
    <BondNotional>100000</BondNotional>
  </BondData>
  <TotalReturnData>
    <Payer>false</Payer>
    <InitialPrice>102.0</InitialPrice>
    <PriceType>Clean</PriceType>
    <ObservationLag>0D</ObservationLag>
    <ObservationConvention>P</ObservationConvention>
    <ObservationCalendar>USD</ObservationCalendar>
    <PaymentLag>2D</PaymentLag>
    <PaymentConvention>F</PaymentConvention>
    <PaymentCalendar>TARGET</PaymentCalendar>
    <!-- <PaymentDates> -->
    <!--   <PaymentDate> ... </PaymentDate> -->
    <!--   <PaymentDate> ... </PaymentDate> -->
    <!-- </PaymentDates> -->
    <FXTerms>
      <FXIndex>FX-TR20H-NZD-USD</FXIndex>
    </FXTerms>
    <ScheduleData>
    ...
    </ScheduleData>
    <PayBondCashFlowsImmediately>false</PayBondCashFlowsImmediately>
  </TotalReturnData>
  <FundingData>
    <LegData>
      <Payer>true</Payer>
      <LegType>Floating</LegType>
      <Currency>USD</Currency>
      ...
      <!-- Notionals node is not required, set to 1 internally -->
      ...
      <Indexings>
      <!-- derive the indexing information (bond price, FX) from the total return leg -->
      <FromAssetLeg>true</FromAssetLeg>
      </Indexings>
      ...
    </LegData>
  </FundingData>
</BondTRSData>
```

</div>

[^1]: as opposed to the bond price in the fixing history, where it must
    be given as $1.0120$ and is always a clean quotation

---

### Callable Bond

A callable bond is a bond with issuer call and / or investor put rights.
Typically, the call style is American while the put is Bermudan, but we
support any combination of styles. Listing
<a href="#lst:callablebonddata1" data-reference-type="ref"
data-reference="lst:callablebonddata1">[lst:callablebonddata1]</a> shows
an example trade xml. The meanings and allowable values of the elements
in the `CallableBondData` block are as follows:

- SecurityId: The underlying security identifier  
  Allowable values: Typically the ISIN of the underlying bond, with the
  ISIN: prefix.

- BondNotional: The notional of the underlying bond expressed in the
  currency of the bond.  
  Allowable values: Any positive real number.

- CreditRisk \[Optional\] Boolean flag indicating whether to show Credit
  Risk on the Bond product.  
  Allowable Values: *true* or *false* Defaults to *true* if left blank
  or omitted.

<div class="listing">

``` xml
  <Trade id="CallableBond">
    <TradeType>CallableBond</TradeType>
    <Envelope>...</Envelope>
    <CallableBondData>
      <BondData>
        <SecurityId>ISIN:XS0123456789</SecurityId>
        <BondNotional>1000000.00</BondNotional>
      </BondData>
    </CallableBondData>
  </Trade>
```

</div>

The bond terms of the trade in
<a href="#lst:callablebonddata1" data-reference-type="ref"
data-reference="lst:callablebonddata1">[lst:callablebonddata1]</a> is
set up in reference data, see
<a href="#lst:callablebonddata2" data-reference-type="ref"
data-reference="lst:callablebonddata2">[lst:callablebonddata2]</a> for
an example. The fields in the reference data have the following meaning:

- BondData: The vanilla part of the bond, see
  <a href="#ss:bond" data-reference-type="ref"
  data-reference="ss:bond">[ss:bond]</a>.

- CallData: The call terms of the bond, as described below. Optional, if
  not given, no calls are present.

- PutData: The put terms of the bond, as described below. Optional, if
  not given, no puts are present.

<div class="listing">

``` xml
  <ReferenceDatum id="ISIN:XS0123456789">
    <Type>CallableBond</Type>
    <CallableBondReferenceData>
      <BondData> ... </BondData>
      <CallData> ... </CallData>
      <PutData> ... </PutData>
    </CallableBondReferenceData>
  </ReferenceDatum>
```

</div>

<u>Specification of CallData / PutData:</u>

All lists specified in subnodes (except the date list itself of course)
can be specified as either an explicit list of values corresponding to
the schedule dates list or using the attribute `startDate`. An explicit
value list can be shorter than the list of dates, in which case the last
value from the list is associated to the remaining dates.

See listings
<a href="#lst:callablebonddata_callputdata_1" data-reference-type="ref"
data-reference="lst:callablebonddata_callputdata_1">[lst:callablebonddata_callputdata_1]</a>,<a href="#lst:callablebonddata_callputdata_2" data-reference-type="ref"
data-reference="lst:callablebonddata_callputdata_2">[lst:callablebonddata_callputdata_2]</a>,<a href="#lst:callablebonddata_callputdata_3" data-reference-type="ref"
data-reference="lst:callablebonddata_callputdata_3">[lst:callablebonddata_callputdata_3]</a>
for examples of exercise schedules.

- Styles: A list of the exercise styles. Notice that Bermudan is used to
  define European exercises as well, namely as a Bermudan exercise with
  a single exercise date. The attribute `startDate` can be used to
  specify the list.  
  Allowable values: American, Bermudan

- ScheduleData: A schedule of exercise dates (for Bermudan exercises) or
  start / end dates (for American exercises)  
  Allowable values: see
  <a href="#ss:schedule_data" data-reference-type="ref"
  data-reference="ss:schedule_data">[ss:schedule_data]</a>.

- Prices: A list of exercise prices in relative terms, i.e. if the price
  is $1.02$ then the amount paid on the exercise is this price times the
  current notional of the bond (plus accrued interest, if the price type
  is clean, see below). The attribute `startDate` can be used to specify
  the list.  
  Allowable values: Any positive real number.

- PriceType: A list of the flavour in which the exercise prices are
  given. The attribute `startDate` can be used to specify the list.  
  Allowable values: Clean, Dirty.

- IncludeAccrual: A list of flags specifying whether accruals have to be
  paid on exercise. This is independent of the quoting style of the
  exercise prices (PriceType).  
  Allowable values: true, false

<div class="listing">

``` xml
  <!-- Bermudan issuer call on three dates at a clean price of 100, 100, 102
       accruals are paid on exercise -->
  <CallData>
    <Styles>
      <Style>Bermudan</Style>
    </Styles>
    <ScheduleData>
      <Dates>
        <Dates>
          <Date>2016-08-03</Date>
          <Date>2017-08-03</Date>
          <Date>2018-08-03</Date>
        </Dates>
      </Dates>
    </ScheduleData>
    <Prices>
      <Price>1.00</Price>
      <Price>1.00</Price>
      <Price>1.02</Price>
    </Prices>
    <PriceTypes>
      <PriceType>Clean</PriceType>
    </PriceTypes>
    <IncludeAccruals>
      <IncludeAccrual>true</IncludeAccrual>
    </IncludeAccruals>
    <TriggerRatios/>
  </CallData>
```

</div>

<div class="listing">

``` xml
  <!-- American issuer call between 2016-08-03 and 2018-08-03
       at a clean price of 100 -->
  <CallData>
    <Styles>
      <Style>American</Style>
    </Styles>
    <ScheduleData>
      <Dates>
        <Dates>
          <Date>2016-08-03</Date>
          <Date>2018-08-03</Date>
        </Dates>
      </Dates>
    </ScheduleData>
    <Prices>
      <Price>1.00</Price>
    </Prices>
    <PriceTypes>
      <PriceType>Clean</PriceType>
    </PriceTypes>
    <IncludeAccruals>
      <IncludeAccrual>true</IncludeAccrual>
    </IncludeAccruals>
  </CallData>
```

</div>

<div class="listing">

``` xml
  <!-- Bermudan puts calls at 100, 101, 102 at 3 dates from 2016 to 2018 -->
  <PutData>
    <Styles>
      <Style>Bermudan</Style>
    </Styles>
    <ScheduleData>
      <Dates>
        <Dates>
          <Date>2016-08-03</Date>
          <Date>2017-08-03</Date>
          <Date>2018-08-03</Date>
        </Dates>
      </Dates>
    </ScheduleData>
    <Prices>
      <Price>1.00</Price>
      <Price>1.01</Price>
      <Price>1.02</Price>
    </Prices>
    <PriceTypes>
      <PriceType>Clean</PriceType>
    </PriceTypes>
    <IncludeAccruals>
      <IncludeAccrual>true</IncludeAccrual>
    </IncludeAccruals>
  </PutData>
```

</div>

---

### Callable Swap

The `CallableSwapData` node is the trade data container for the
*CallableSwap* trade type. A Callable Swap is a swap that can be
cancelled at predefined dates by one of the counterparties. A Callable
Swap must have at least one leg, each leg described by a `LegData` trade
component sub-node as described in section
<a href="#ss:leg_data" data-reference-type="ref"
data-reference="ss:leg_data">[ss:leg_data]</a>.

Unless MidCouponExercise is *true*, there must be at least one full
coupon period after the exercise date for European Callable Swaps, and
after the last exercise date for Bermudan and American Callable Swaps.

The `CallableSwapData` node also contains an `OptionData` node which
describes the exercise dates and specifies which party holds the call
right, see <a href="#ss:option_data" data-reference-type="ref"
data-reference="ss:option_data">[ss:option_data]</a>. An example
structure of a `CallableSwapData` node is shown in Listing
<a href="#lst:callableswap_data" data-reference-type="ref"
data-reference="lst:callableswap_data">[lst:callableswap_data]</a>.

<div class="listing">

``` xml
<CallableSwapData>
    <OptionData>
      <LongShort>Short</LongShort>
      <Style>Bermudan</Style>
      <Settlement>Physical</Settlement>
      <MidCouponExercise>true<MidCouponExercise>
      <ExerciseDates>
        <ExerciseDate>2031-10-01</ExerciseDate>
        <ExerciseDate>2032-10-01</ExerciseDate>
        <ExerciseDate>2033-10-01</ExerciseDate>
      </ExerciseDates>
      ...
    </OptionData>
  <LegData>
    <LegType>Fixed</LegType>
        <Payer>false</Payer>    
        <Currency>USD</Currency>    
    ...
  </LegData>
  <LegData>
    <LegType>Floating</LegType>
        <Payer>true</Payer>     
        <Currency>USD</Currency>    
    ...
  </LegData>
</CallableSwapData>
```

</div>

The meanings and allowable values of the elements in the
`CallableSwapData` node follow below.

- OptionData: This is a trade component sub-node outlined in section
  <a href="#ss:option_data" data-reference-type="ref"
  data-reference="ss:option_data">[ss:option_data]</a>. The exercise
  dates specify the dates on which one of the counterparties may
  terminate the swap. The counterpart holding the call right is
  specified by the `LongShort` flag. The Settlement should be set to
  *Physical* always. See also the OptionData node outlined for a
  Swaption - see <a href="#ss:swaption" data-reference-type="ref"
  data-reference="ss:swaption">[ss:swaption]</a>, which is identical for
  a CallableSwap with the exception of the requirement that Settlement
  must be *Physical*, and that the leg directions on a CallableSwap are
  from the perspective of the client, whereas they are from the
  perspective of the party that is long on a Swaption. A callable swap
  can be marked as exercised as explained in
  <a href="#ss:swaption" data-reference-type="ref"
  data-reference="ss:swaption">[ss:swaption]</a> using the
  `ExerciseData` node within OptionData.

- LegData: This is a trade component sub-node described in section
  <a href="#ss:leg_data" data-reference-type="ref"
  data-reference="ss:leg_data">[ss:leg_data]</a> outlining each leg of
  the underlying Swap. A Callable Swap must have at least one leg on the
  underlying Swap, but can have multiple legs, i.e. multiple `LegData`
  nodes. The LegType elements must be of types *Floating*, *Fixed* or
  *Cashflow*. All legs must have the same `Currency`.

  Note that the direction of the legs, determined by the `Payer` tag, is
  like for a Swap, from the perspective of the party to the trade. I.e.
  unlike for a Swaption where the direction of the legs is from the
  perspective of the party that is long.

---

### Cap/Floor

The `CapFloorData` node is the trade data container for the *CapFloor*
trade type. It’s a cap, floor or collar (i.e. a portfolio of a long cap
and a short floor for a long position in the collar) on a series of
Ibor, SIFMA, OIS, CMS, Duration-adjusted CMS, CMS Spread, CPI, YY
coupons.

The `CapFloorData` node contains a `LongShort` sub-node which indicates
whether the cap (floor, collar) is long or short, and a `LegData`
sub-node where the LegType can be set to *Floating*, *CMS*, *CMSSpread*,
*DurationAdjustedCMS*, *CPI* or *YY*, plus elements for the Cap and
Floor rates. An example structure with Cap rates is shown in Listing
<a href="#lst:capfloor_data" data-reference-type="ref"
data-reference="lst:capfloor_data">[lst:capfloor_data]</a>. The optional
node *PaymentDates* in the `LegData` subnode is currently only used for
OIS and IBOR indices (see
<a href="#ss:leg_data" data-reference-type="ref"
data-reference="ss:leg_data">[ss:leg_data]</a>).

A `CapFloorData` node must have either `Caps` or `Floors` elements, or
both. In the case of both (I.e. a collar with long cap and short floor)
the sequence is that `Caps` elements must be above the `Floors`
elements. Note that the `Caps` and `Floors` elements must be outside the
`LegData` sub-node, i.e. a *CapFloor* can’t have a capped or floored
*Floating* or *CMS* leg. The *Payer* flag in the LegData subnode is
ignored for this instrument. Notice that the signs in the definition of
a collar (long cap, short floor) for the CapFloor instruments is exactly
opposite to <a href="#ss:floatingleg_data" data-reference-type="ref"
data-reference="ss:floatingleg_data">[ss:floatingleg_data]</a>.

<div class="listing">

``` xml
<CapFloorData>
  <LongShort>Long</LongShort>
  <LegData>
    <Payer>false</Payer>
    <LegType>Floating</LegType>
     ...
  </LegData>
  <Caps>
    <Cap>0.05</Cap>
  </Caps>
  <Premiums>
    <Premium>
      <Amount>1000</Amount>
      <Currency>EUR</Currency>
      <PayDate>2021-01-27</PayDate>
    </Premium>
  </Premiums>
</CapFloorData>
```

</div>

The meanings and allowable values of the elements in the `CapFloorData`
node follow below.

- LongShort: This node defines the position in the cap (floor, collar)
  and can take values *Long* or *Short*.

- LegData: This is a trade component sub-node outlined in section
  <a href="#ss:leg_data" data-reference-type="ref"
  data-reference="ss:leg_data">[ss:leg_data]</a>. Exactly one `LegData`
  node is allowed, and the LegType element must be set to *Floating*
  (Ibor and OIS), *CMS*, *CMSSpread*, *DurationAdjustedCMS*, *CPI* or
  *YY*.

- Caps: This node has child elements of type `Cap` capping the floating
  leg (after applying spread if any). The first rate value corresponds
  to the first coupon, the second rate value corresponds to the second
  coupon, etc. If the number of coupons exceeds the number of rate
  values, the rate will be kept flat at the value of last entered rate
  for the remaining coupons. For a fixed cap rate over all coupons, one
  single rate value is sufficient. The number of entered rate values
  cannot exceed the number of coupons.

  Allowable values for each `Cap` element: Any real number. The rate is
  expressed in decimal form, eg 0.05 is a rate of 5%

- Floors: This node has child elements of type `Floor` flooring the
  floating leg (after applying spread if any). The first rate value
  corresponds to the first coupon, the second rate value corresponds to
  the second coupon, etc. If the number of coupons exceeds the number of
  rate values, the rate will be kept flat at the value of last entered
  rate for the remaining coupons. For a fixed floor rate over all
  coupons, one single rate value is sufficient. The number of entered
  rate values cannot exceed the number of coupons.

  Allowable values for each `Floor` element: Any real number. The rate
  is expressed in decimal form, eg 0.05 is a rate of 5%

- Premiums \[Optional\]: Option premium amounts paid by the option buyer
  to the option seller.

  Allowable values: See section
  <a href="#ss:premiums" data-reference-type="ref"
  data-reference="ss:premiums">[ss:premiums]</a>

---

### Cash Position

The `CashPositionData` node is the trade data container for the
*CashPosition* trade type. The structure - including example values - of
the `CashPositionData` node is shown in Listing
<a href="#lst:cashposition_data" data-reference-type="ref"
data-reference="lst:cashposition_data">[lst:cashposition_data]</a>.

A cash position can be used both as a stand alone trade type (TradeType:
*CashPosition*) or as a trade component within the *TotalReturnSwap*
(Generic TRS) trade type.

<div class="listing">

``` xml
        <CashPositionData>
            <Currency>EUR</Currency>
            <Amount>1000000</Amount>
        </CashPositionData>
```

</div>

The meanings and allowable values of the various elements in the
`CashPositionData` node follow below.

- Currency: The currency of cash position.  
  Allowable values: See Table
  <a href="#tab:currency" data-reference-type="ref"
  data-reference="tab:currency">[tab:currency]</a> `Currency`.

- Amount: The amount of cash position.  
  Allowable values: Any real number.

---

### Collateral Bond Obligation CBO

A Cashflow CDO or Collateral Bond Obligation CBO (trade type *CBO*) can
be set up in a short version referencing the underlying CBO structure in
a static CBO reference datum or a long version, where the CBO structure
is specified explicitly.

The main building block is the `CBOData` block as shown in listing
<a href="#lst:cbodata" data-reference-type="ref"
data-reference="lst:cbodata">[lst:cbodata]</a>. The `CBOData` requires
the two components `CBOInvestment` and `CBOStructure`. Where the latter
represents the general structure, the former specfies the actual
investment. For the short version, the CBO is fully specified using the
component `CBOInvestment` only, the component `CBOStructure` can be
omitted.

Listing <a href="#lst:cbodata" data-reference-type="ref"
data-reference="lst:cbodata">[lst:cbodata]</a> exhibits the long
version:

<div class="listing">

``` xml
    <CBOData>
      <CBOInvestment>
        <TrancheName>JuniorNote</TrancheName>
        <Notional>4000000.00</Notional>
        <StructureId>Constellation</StructureId>
      </CBOInvestment>
      <CBOStructure>
        <DayCounter>ACT/ACT</DayCounter>
        <PaymentConvention>F</PaymentConvention>
        <Currency>EUR</Currency>
        <ReinvestmentEndDate>2019-12-31</ReinvestmentEndDate>
        <SeniorFee>0.01</SeniorFee>
        <FeeDayCounter>A365</FeeDayCounter>
        <SubordinatedFee>0.02</SubordinatedFee>
        <EquityKicker>0.25</EquityKicker>
        <BondBasketData>
          ...
        </BondBasketData>
        <CBOTranches>
          ...
        </CBOTranches>
        <ScheduleData>
          ...
        </ScheduleData>
      </CBOStructure>
    </CBOData>
```

</div>

The meanings of the elements of the `CBOData` node follow below:

- TrancheName: Specifies of which tranche, results are shown in the
  report files (NPV, Sensitivity, ...). The name needs to match one the
  names specified in `CBOTranches`.

- Notional: Is the invested amount into the tranche specified above. The
  value is used to scale the NPV from the general tranche NPV, so it may
  be different to the face amount specified in `CBOTranches`.

- StructureId: if details of the cbo are read from the reference data,
  StructureId is used as a key.

- DayCounter: The day count convention of the tranches. Allowable
  values: See table <a href="#tab:daycount" data-reference-type="ref"
  data-reference="tab:daycount">[tab:daycount]</a>.

- PaymentConvention: The payment convention of the tranches. Allowable
  values: See Table <a href="#tab:convention" data-reference-type="ref"
  data-reference="tab:convention">[tab:convention]</a> Roll Convention.

- Currency: Defines the currency of the trade, i.e. the currency of the
  tranches. Allowable values: See Table
  <a href="#tab:currency" data-reference-type="ref"
  data-reference="tab:currency">[tab:currency]</a> `Currency`.

- ReinvestmentEndDate: Defines the end of the reinvestment period.
  During the reinvestment period, principal proceeds are used to
  reinvest in eliglible assets rather than to redeem CBO notes.
  Currently the model cannot handle underlying bonds with full
  amortisation within the reinvestment period. In case the underlying
  bonds amortise only parts of their full notional (during that period),
  the model will leave outstanding balance constant until the end of the
  reinvestment period. Therafter the underlying bonds amortises at a
  higher speed.

- SeniorFee: The fee, expressed as rate, paid before all other
  obligations, top of the waterfall.

- FeeDayCounter: The day count convention for the fees. Allowable
  values: See table <a href="#tab:daycount" data-reference-type="ref"
  data-reference="tab:daycount">[tab:daycount]</a>.

- SubordinatedFee: The fee, expressed as rate, paid after all other
  obligations.

- EquityKicker: Fraction x of the residual payment, that will be split
  among the senior fee receiver (x) and the equity piece (1-x).

- BondBasketData: All specifications of the underlying bond basket. Uses
  the sub node BondBasketData as described in section
  <a href="#ss:bondbasketdata" data-reference-type="ref"
  data-reference="ss:bondbasketdata">[ss:bondbasketdata]</a>.

- CBOTranches: All required instrument data for the tranches of the CBO.
  Uses the sub node CBOTranches as described in section
  <a href="#ss:cbotranches" data-reference-type="ref"
  data-reference="ss:cbotranches">[ss:cbotranches]</a>.

- ScheduleData: This is a trade component sub-node outlined in section
  <a href="#ss:schedule_data" data-reference-type="ref"
  data-reference="ss:schedule_data">[ss:schedule_data]</a> Schedule Data
  and Dates.

Listing <a href="#lst:cboReferenceData" data-reference-type="ref"
data-reference="lst:cboReferenceData">[lst:cboReferenceData]</a>
exhibits the reference data in conjunction with short version of the
`CBOData` in listing
<a href="#lst:cboInvestment" data-reference-type="ref"
data-reference="lst:cboInvestment">[lst:cboInvestment]</a>. The element
meanings are the same as in the long version.

<div class="listing">

``` xml
    <ReferenceDatum id="Constellation">
        <Type>CBO</Type>
        <CboReferenceData>
            <Currency>USD</Currency>
            <DayCounter>A365</DayCounter>
            <PaymentConvention>F</PaymentConvention>
            <SeniorFee>0.001</SeniorFee>
            <FeeDayCounter>A365</FeeDayCounter>
            <SubordinatedFee>0.005</SubordinatedFee>
            <EquityKicker>0.01</EquityKicker>
            <CBOTranches>
                ...
            </CBOTranches>
            <ScheduleData>
                ...
            </ScheduleData>
            <BondBasketData>
                ...
            </BondBasketData>
        </CboReferenceData>
    </ReferenceDatum>
```

</div>

<div class="listing">

``` xml
    <CBOData>
      <CBOInvestment>
        <TrancheName>JuniorNote</TrancheName>
        <Notional>4000000.00</Notional>
        <StructureId>Constellation</StructureId>
      </CBOInvestment>
    </CBOData>
```

</div>

---

### Commodity Forward

A Commodity Forward contract is an agreement between two counterparties
to buy/sell a set amount of a commodity, at a predetermined price (the
strike), at the end of the contract. A commodity forward does not
involve any upfront payment.

The `CommodityForwardData` node is the trade data container for the
`CommodityForward` trade type. The structure of an example
`CommodityForwardData` node is shown in Listings
<a href="#lst:comfwd_data" data-reference-type="ref"
data-reference="lst:comfwd_data">[lst:comfwd_data]</a> and
<a href="#lst:comm_fwd_lme_3M" data-reference-type="ref"
data-reference="lst:comm_fwd_lme_3M">[lst:comm_fwd_lme_3M]</a>.

<div class="listing">

``` xml
<CommodityForwardData>
  <Position>Long</Position>
  <Maturity>2029-06-30</Maturity>
  <Name>XCEC:GC</Name>
  <Currency>USD</Currency>
  <Strike>1355</Strike>
  <Quantity>1000</Quantity>
  <IsFuturePrice>...</IsFuturePrice>
  <FutureExpiryDate>...</FutureExpiryDate>
  <FutureExpiryOffset>...</FutureExpiryOffset>
  <FutureExpiryOffsetCalendar>...</FutureExpiryOffsetCalendar>
  <PhysicallySettled>...</PhysicallySettled>
  <PaymentDate>...</PaymentDate>
</CommodityForwardData>
```

</div>

<div class="listing">

``` xml
<CommodityForwardData>
  <Position>Long</Position>
  <Maturity>2029-08-16</Maturity>
  <Name>XLME:AH</Name>
  <Currency>USD</Currency>
  <Strike>2160</Strike>
  <Quantity>1000</Quantity>
  <IsFuturePrice>true</IsFuturePrice>
  <FutureExpiryDate>2021-11-16</FutureExpiryDate>
  <PhysicallySettled>true</PhysicallySettled>
</CommodityForwardData>
```

</div>

The meanings and allowable values of the elements in the
`CommodityForwardData` node follow below.

- Position: Defines whether the underlying commodity will be bought
  (long) or sold (short).  
  Allowable values: *Long, Short*

- Maturity: The maturity date of the forward contract, i.e. the date
  when the underlying commodity will be bought/sold.  
  Allowable values: Any date string, see `Date` in Table
  <a href="#tab:allow_stand_data" data-reference-type="ref"
  data-reference="tab:allow_stand_data">[tab:allow_stand_data]</a>.

- Name: The name of the underlying commodity.  
  Allowable values: See `Name` for commodity trades in Table
  <a href="#tab:commodity_data" data-reference-type="ref"
  data-reference="tab:commodity_data">[tab:commodity_data]</a>.  

- Currency: The currency the underlying commodity is quoted in. The
  Strike and the Forward price (or Future price) of the underlying
  commodity are both considered to be in this currency.  
  Allowable values: See `Currency` in Table
  <a href="#tab:allow_stand_data" data-reference-type="ref"
  data-reference="tab:allow_stand_data">[tab:allow_stand_data]</a>.

- Strike: The agreed buy/sell price of the commodity forward.  
  Allowable values: Any real number.

- Quantity: The number of units of the underlying commodity to be
  bought/sold.  
  Allowable values: Any real number.

- `IsFuturePrice` \[Optional\]: This should be set to `true` if the
  forward contract underlying is the settlement price of a commodity
  future contract. If omitted, it defaults to `false`.  
  Allowable values: Any string that evaluates to true or false as
  outlined in Table
  <a href="#tab:boolean_allowable" data-reference-type="ref"
  data-reference="tab:boolean_allowable">[tab:boolean_allowable]</a>.

- `FutureExpiryDate` \[Optional\]: If `IsFuturePrice` is set to `true`,
  this gives the expiration date of the underlying commodity future
  contract. If omitted, the expiration date of the underlying commodity
  future contract is set equal to the value in the `Maturity` node. If
  `FutureExpiryDate` is provided, it takes precedence over any value
  provided in the `Maturity`, `FutureExpiryOffset` or
  `FutureExpiryOffsetCalendar` fields.  
  Allowable values: Any date string, see `Date` in Table
  <a href="#tab:allow_stand_data" data-reference-type="ref"
  data-reference="tab:allow_stand_data">[tab:allow_stand_data]</a>.

- `FutureExpiryOffset` \[Optional\]: If `IsFuturePrice` is set to `true`
  and `FutureExpiryDate` is not explicitly specified, this gives the
  offset period that should be applied to the `Maturity` date to
  generate the underlying commodity future contract expiration date. If
  omitted, the expiration date of the underlying commodity future
  contract is set equal to the value in the `Maturity` node.  
  Allowable values: Any string that can be parsed as a period e.g. `2D`,
  `3M`, etc.

- `FutureExpiryOffsetCalendar` \[Optional\]: If `FutureExpiryOffset` is
  provided and is being used, this gives the calendar that should be
  used when generating the underlying commodity future contract
  expiration date from the `Maturity` date. If omitted, all days are
  considered good business days when generating the commodity future
  contract expiration date which is generally not what is desired.  
  Allowable values: Any calendar string, see `Calendar` in Table
  <a href="#tab:calendar" data-reference-type="ref"
  data-reference="tab:calendar">[tab:calendar]</a>.

- `PhysicallySettled` \[Optional\]: A value of `true` indicates that the
  forward contract is physically settled e.g. if the underlying is a
  future contract, that future contract is entered into on the
  `Maturity` date. A value of `false` indicates that the forward
  contract is cash settled e.g. if the underlying is a future contract,
  that future contract settlement price is observed on the `Maturity`
  date (or the `FutureExpiryDate`, when given) and the net amount due is
  exchanged on the cash settlement date. If omitted, it defaults to
  *true*.  
  Allowable values: Any string that evaluates to true or false as
  outlined in Table
  <a href="#tab:boolean_allowable" data-reference-type="ref"
  data-reference="tab:boolean_allowable">[tab:boolean_allowable]</a>.

- `PaymentDate` \[Optional\]: If `PhysicallySettled` is set to *false*,
  this gives the cash settlement date. It must be greater than or equal
  to the `Maturity` date. If omitted and the forward is cash settled,
  the `Maturity` date is used.  
  Allowable values: Any date string, see `Date` in Table
  <a href="#tab:allow_stand_data" data-reference-type="ref"
  data-reference="tab:allow_stand_data">[tab:allow_stand_data]</a>.

- `SettlementData` \[Optional\]: This node is used to specify the
  settlement of the cash flows for cash settled forwards, and the
  payment flow for physically settled ones.

A `SettlementData` node is shown in Listing
<a href="#lst:comm_ndf_settlement_data_node" data-reference-type="ref"
data-reference="lst:comm_ndf_settlement_data_node">[lst:comm_ndf_settlement_data_node]</a>,
and the meanings and allowable values of its elements follow below.

- `PayCurrency`: The settlement currency for the payment cashflow.  
  Allowable values: See `Currency` in Table
  <a href="#tab:allow_stand_data" data-reference-type="ref"
  data-reference="tab:allow_stand_data">[tab:allow_stand_data]</a>.

- `FXIndex`: The FX reference index for determining the FX fixing at the
  value date. The Forward Price will be observed at maturity date (or
  future expiry date if it’s a future), the NPV is converted to
  `PayCurrency` with the `FXIndex` using an FX fixing on `FixingDate`
  (settlement date) discounted from `PaymentDate`.  
  Allowable values: The format of the `FXIndex` is
  “FX-FixingSource-CCY1-CCY2” as described in Table
  <a href="#tab:fxindex_data" data-reference-type="ref"
  data-reference="tab:fxindex_data">[tab:fxindex_data]</a>.

- `FixingDate`: The date on which the *FXIndex* is observed. Allowable
  values: See `Date` in Table
  <a href="#tab:allow_stand_data" data-reference-type="ref"
  data-reference="tab:allow_stand_data">[tab:allow_stand_data]</a>.

<div class="listing">

``` xml
    <SettlementData>
      <PayCurrency>EUR</PayCurrency>
      <FXIndex>FX-ECB-EUR-USD</FXIndex>
      <FixingDate>2025-05-28</FixingDate>
    </SettlementData>
```

</div>

Note that a Precious Metal Forward should be represented as an FX
Forward using the appropriate commodity “currency” (XAU, XAG, XPT, XPD).

---

### Commodity Option

A European Commodity Option gives the buyer the right, but not the
obligation, to buy a set amount of a commodity, at a predetermined price
(the strike), at the end of the contract. For this right the buyer pays
a premium to the seller. Settlement can be either cash or physical
delivery.

The `CommodityOptionData` node is the trade data container for the
*CommodityOption* trade type. Vanilla commodity options are supported.
The exercise style may be *European* or *American*. The
`CommodityOptionData` node includes exactly one `OptionData` trade
component sub-node plus elements specific to the commodity option. The
structure of a `CommodityOptionData` node for a commodity option is
shown in Listing <a href="#lst:comoption_data" data-reference-type="ref"
data-reference="lst:comoption_data">[lst:comoption_data]</a>.

<div class="listing">

``` xml
<CommodityOptionData>
  <OptionData>
   <LongShort>Short</LongShort>
   <OptionType>Put</OptionType>
   <Style>European</Style>
   <Settlement>Cash</Settlement>
   <PayOffAtExpiry>false</PayOffAtExpiry>
    <ExerciseDates>
      <ExerciseDate>2029-04-28</ExerciseDate>
     </ExerciseDates>
  </OptionData>
  <Name>NYMEX:CL</Name>
  <Currency>USD</Currency>
  <StrikeData>
    <StrikePrice>
      <Value>100</Value>
      <Currency>USD</Currency>
    </StrikePrice>
  </StrikeData>
  <Quantity>500000</Quantity>
  <IsFuturePrice>true<IsFuturePrice>
  <FutureExpiryDate>2029-04-28<FutureExpiryDate>
</CommodityOptionData>
```

</div>

The meanings and allowable values of the elements in the
`CommodityOptionData` node follow below.

- The `CommodityOptionData` node contains an `OptionData` node described
  in <a href="#ss:option_data" data-reference-type="ref"
  data-reference="ss:option_data">[ss:option_data]</a>. The relevant
  fields in the `OptionData` node for a CommodityOption are:

  - `LongShort`: The allowable values are *Long* or *Short*.

  - `OptionType`: The allowable values are *Call* or *Put*.

  - `Style`: The exercise style of the CommodityOption. The allowable
    values are *European* or *American*.

  - `PayOffAtExpiry`: This must be set to *false* as payoff at expiry is
    not currently supported.

  - An `ExerciseDates` node where exactly one `ExerciseDate` date
    element must be given for. Allowable values: See Date in Table
    <a href="#tab:allow_stand_data" data-reference-type="ref"
    data-reference="tab:allow_stand_data">[tab:allow_stand_data]</a>.

  - `Premiums` \[Optional\]: Option premium node with amounts paid by
    the option buyer to the option seller. Allowable values: See section
    <a href="#ss:premiums" data-reference-type="ref"
    data-reference="ss:premiums">[ss:premiums]</a>

- Name: The name of the underlying commodity.  
  Allowable values: See `Name` for commodity trades in Table
  <a href="#tab:commodity_data" data-reference-type="ref"
  data-reference="tab:commodity_data">[tab:commodity_data]</a>.

- Currency: The currency of the commodity option.  
  Allowable values: See `Currency` in Table
  <a href="#tab:allow_stand_data" data-reference-type="ref"
  data-reference="tab:allow_stand_data">[tab:allow_stand_data]</a>.

- StrikeData: The option strike price. It uses the price quotation
  outlined in the underlying contract specs for the commodity name in
  question.  
  Allowable values: Only supports `StrikePrice` as described in Section
  <a href="#ss:strikedata" data-reference-type="ref"
  data-reference="ss:strikedata">[ss:strikedata]</a>.

- Quantity: The number of units of the underlying commodity covered by
  the transaction. The unit type is defined in the underlying contract
  specs for the commodity name in question. For avoidance of doubt, the
  Quantity is the number of units of the underlying commodity, not the
  number of contracts.  
  Allowable values: Any positive real number.

- IsFuturePrice \[Optional\]: A boolean indicating if the underlying is
  a future contract settlement price, `true`, or a spot price, `false`.

  Allowable values: A boolean value given in Table
  <a href="#tab:boolean_allowable" data-reference-type="ref"
  data-reference="tab:boolean_allowable">[tab:boolean_allowable]</a>. If
  not provided, the default value is `true`.

- FutureExpiryDate \[Optional\]: If `IsFuturePrice` is `true` and the
  underlying is a future contract settlement price, this node allows the
  user to specify the expiry date of the underlying future contract.

  Allowable values: This should be a valid date as outlined in Table
  <a href="#tab:allow_stand_data" data-reference-type="ref"
  data-reference="tab:allow_stand_data">[tab:allow_stand_data]</a>. If
  not provided, it is assumed that the future contract’s expiry date is
  equal to the option expiry date provided in the `OptionData` node.

### Commodity Digital Option

A commodity digital option is represented with trade type
*CommodityDigitalOption* and a corresponding
`CommodityDigitalOptionData` node. The latter differs from the
`CommodityOptionData` node in section
<a href="#ss:input_commodity_option" data-reference-type="ref"
data-reference="ss:input_commodity_option">0.0.1</a> by replacing tag
*Quantity* with tag *Payoff* which is the cash amount paid in the
Currency of the option from the party that is short to the party that is
long, when the underlying price exceeds the strike at expiry in case of
a Call (or falls below the strike in case of a Put). The digital option
is priced in ORE as a spread of vanilla Commodity options at two
slightly different strikes. For option type *Call* and *Put*,
respectively, the digital call/put is constructed as $$\begin{aligned}
\mbox{Digital Call} =  \frac{\mbox{Payoff}}{\Delta}  \times  \left( \mbox{Call}(K- \Delta/2) - \mbox{Call}(K+ \Delta/2) \right) \\
\mbox{Digital Put} = \frac{\mbox{Payoff}}{\Delta}  \times \left( \mbox{Put}(K+ \Delta/2) - \mbox{Put}(K- \Delta/2)  \right)
\end{aligned}$$ so that the long digital option has positive value in
both cases. The strike spread $\Delta$ used here is set to 1% of strike
$K$. However, the default 1% can be overridden by setting the
’StrikeSpread’ parameter in the pricing engine global parameters.

### Commodity Spread Option

A commodity Spread Option is represented with trade type
*CommoditySpreadOption* and a corresponding `CommoditySpreadOptionData`
node.

The `CommoditySpreadOptionData` node is the trade data container for the
*CommoditySpreadOption* trade type. The structure of a
`CommoditySpreadOptionData` node for a commodity option is shown in
Listing <a href="#lst:com_s_option_data" data-reference-type="ref"
data-reference="lst:com_s_option_data">[lst:com_s_option_data]</a>.

The `CommoditySpreadOptionData` include exactly two `LegData` nodes of
type *CommodityFloating*. Details on these are described in
<a href="#ss:commodityfloatingleg" data-reference-type="ref"
data-reference="ss:commodityfloatingleg">[ss:commodityfloatingleg]</a>.
The resulting Legs must produce the same amount of cashflows (i.e. the
number of *calculation period*s must be the same for the long and short
positions). If the number of cashflows per leg is 1, this trade
represents a single commodity spread option. If is greater than 1, it
represents a multi-period commodity spread option. Exactly one payer and
one receiver leg are required, the leg with `isPayer` setto *true* is
the long (positive) position in the spread payoff.

Within the two `LegData`, the `Quantity` node has must be equal. If the
underlying contracts are quoted using different units (e.g. barrels vs
liters), the `Gearing` node must be used to account for this difference.
The gearing could also be used for the heat rate factor in spark / heat
rate options.

Other than the two legs, the following nodes complete the
`CommoditySpreadOptionData` container:

- `SpreadStrike`: The strike value for the spread. Allowable values: Any
  real number.

- `OptionData`: This is a trade component sub-node outlined in section
  <a href="#ss:option_data" data-reference-type="ref"
  data-reference="ss:option_data">[ss:option_data]</a>. The relevant
  fields in the `OptionData` node for an CommoditySpreadOption are

  - `LongShort` The allowable values are *Long* or *Short*.

  - `OptionType` The allowable values are *Call* or *Put*.

  - `Premiums` \[Optional\]: Option premium amounts paid by the option
    buyer to the option seller. See section
    <a href="#ss:premiums" data-reference-type="ref"
    data-reference="ss:premiums">[ss:premiums]</a>

  - `ExerciseDates` \[Optional\]: If given, there must be one exercise
    date for each option period. If omitted, the option expiry is
    derived from the cashflows and falls on the last pricing period of
    the commodity cashflow.

  - `PaymentData` \[Optional\]: This node is used to supply the date on
    which the option is cash settled if it is exercised. If omitted the
    settlement date is derived from the cashflow payment dates.

- `OptionStripPaymentDates` \[Optional\]: If the number of cashflows per
  leg is greater than 1, we can group options by their expiry date into
  strips. All option in a strip will have the same payment date as
  defined in this node. The payment date will be *lag* business days
  after the latest expiry date in the strip. The node has following
  sub-nodes:

  - `OptionStripDefinition` A schedule node
    <a href="#ss:schedule_data" data-reference-type="ref"
    data-reference="ss:schedule_data">[ss:schedule_data]</a> defining
    the option strips. The $n$ dates in the schedule defining $n-1$
    strips, each strip include the period’s start date and excludes
    period’s end date. All options with expiry within start and end of a
    period are falling in the same strip. The schedule has to cover all
    option expiries. The first date in the schedule has to be before or
    on the first expiry date of the options and the last date in the
    schedule has to be after last expiry date of the options.

  - `PaymentCalendar` Calendar defining valid business days for the
    payment date.

  - `PaymentLag` number of business days.

  - `PaymentConvention` business day convention for the option strip
    payment date.

<div class="listing">

``` xml
<CommoditySpreadOptionData>
  <LegData>
   <LegType>CommodityFloating</LegType>
   <IsPayer>true<IsPayer>
   ...
  </LegData>
  <LegData>
   <LegType>CommodityFloating</LegType>
   <IsPayer>false<IsPayer>
   ...
  </LegData>
  <OptionData>
    <LongShort>Long</LongShort>
    <OptionType>Call</OptionType>
     <Premiums>
       <Premium>
         <Amount>10900</Amount>
         <Currency>EUR</Currency>
         <PayDate>2020-03-01</PayDate>
       </Premium>
     </Premiums>
  </OptionData>
  <SpreadStrike>2.3</SpreadStrike>
  <OptionStripPaymentDates>
    <OptionStripDefinition>
          <Rules>
        <StartDate>2023-07-01</StartDate>
            <EndDate>2023-10-01</EndDate>
            <Tenor>1M</Tenor>
            <Calendar>NullCalendar</Calendar>
            <Convention>Unadjusted</Convention>
            <TermConvention>Unadjusted</TermConvention>
            <Rule>Backward</Rule>
          </Rules>
    </OptionStripDefinition>
    <PaymentCalendar>ICE_FuturesUS,US-NERC</PaymentCalendar>
    <PaymentLag>5</PaymentLag>
    <PaymentConvention>MF</PaymentConvention>
  </OptionStripPaymentDates>
</CommoditySpreadOptionData>
```

</div>

---

### Commodity Option Strip

The structure of a trade node representing a commodity option strip is
shown in listing
<a href="#lst:commodity_option_strip" data-reference-type="ref"
data-reference="lst:commodity_option_strip">[lst:commodity_option_strip]</a>.
This node can be used to represent a strip of commodity average price
options as described in section
<a href="#ss:input_commodityapo" data-reference-type="ref"
data-reference="ss:input_commodityapo">[ss:input_commodityapo]</a> or a
strip of European commodity options as described in section
<a href="#ss:input_commodity_option" data-reference-type="ref"
data-reference="ss:input_commodity_option">[ss:input_commodity_option]</a>.
It consists of the generic `Envelope` and the specific
`CommodityOptionStripData` node.

The `CommodityOptionStripData` node has a `LegData` node with `LegType`
set to `CommodityFloating`. This `LegData` node is described in detail
in sections <a href="#ss:commodityfloatingleg" data-reference-type="ref"
data-reference="ss:commodityfloatingleg">[ss:commodityfloatingleg]</a>
and <a href="#ss:commodity_floating_leg_data" data-reference-type="ref"
data-reference="ss:commodity_floating_leg_data">[ss:commodity_floating_leg_data]</a>.
Note that the `Payer` field in `CommodityFloatingLegData`, while
mandatory, has no impact on flows. The node `IsAveraged` in
`CommodityFloatingLegData` determines whether a strip of European
commodity options or a strip of APOs are created:

- If `IsAveraged` is `false`, a strip of European commodity options is
  created. There is a European put and or European call option created
  for each calculation period. The exercise date of the option in the
  calculation period is given by the *Pricing Date* in the calculation
  period using the rules outlined in section
  <a href="#ss:commodity_floating_leg_data" data-reference-type="ref"
  data-reference="ss:commodity_floating_leg_data">[ss:commodity_floating_leg_data]</a>.
  The quantity is given by the quantity in the calculation period using
  the rules outlined in section
  <a href="#ss:commodity_floating_leg_data" data-reference-type="ref"
  data-reference="ss:commodity_floating_leg_data">[ss:commodity_floating_leg_data]</a>.
  If cash settled, the cash settlement date is given by the payment date
  for the calculation period using the rules outlined in section
  <a href="#ss:commodity_floating_leg_data" data-reference-type="ref"
  data-reference="ss:commodity_floating_leg_data">[ss:commodity_floating_leg_data]</a>.

- If `IsAveraged` is `true`, a strip of commodity average price options
  is created. There is a put and or call option created for each
  calculation period. The exercise date of the option in the calculation
  period is given by the calculation period end date. The quantity is
  given by the quantity in the calculation period using the rules
  outlined in section
  <a href="#ss:commodity_floating_leg_data" data-reference-type="ref"
  data-reference="ss:commodity_floating_leg_data">[ss:commodity_floating_leg_data]</a>.

Each calculation period may contain a put and a call that may be either
bought or sold. The type of option, whether they are bought or sold and
the strike price is determined by the `Calls` and `Puts` nodes. We
describe here the settings for the `Calls` node with the understanding
that analogous descriptions apply to the `Puts` node. If the `Calls`
node is omitted, it is assumed that there are no call options in the
strip.

The `LongShorts` node may contain one `LongShort` node or the same
number of `LongShort` nodes as calculation periods. Each `LongShort`
node has the allowable values `Long` or `Short`. If `LongShort` is
`Long`, then the call option is bought and if `LongShort` is `Short`
then the call option is sold. If a single `LongShort` node is provided,
it is applied to all options in the strip. If the same number of
`LongShort` nodes as calculation periods are provided, a `LongShort`
node is applied to the option in the corresponding period. The optional
`BarrierData` node specifies the barrier terms of the options. See
section <a href="#ss:input_commodityapo" data-reference-type="ref"
data-reference="ss:input_commodityapo">[ss:input_commodityapo]</a> for
details on this. Call and put options can have different barrier terms,
but all call (resp. put) options share the same terms. In listing
<a href="#lst:commodity_option_strip" data-reference-type="ref"
data-reference="lst:commodity_option_strip">[lst:commodity_option_strip]</a>
only the call options have a barrier feature.

Similar to the `LongShorts` node, the `Strikes` node may contain one
`Strike` node or the same number of `Strike` nodes as calculation
periods. If only one is provided, this strike applies to all options in
the strip. If the same number of `Strike` nodes as calculation periods
are provided, a `Strike` node is applied to the option in the
corresponding period. In this way, we support varying strikes across
options in the strip. At least one of `Calls` or `Puts` needs to be
provided for a valid option strip to be created.

The `Premiums` node allows for the addition of premiums. If the
`PremiumAmount` is negative, it is paid and if it is positive, it is
received. See <a href="#ss:premiums" data-reference-type="ref"
data-reference="ss:premiums">[ss:premiums]</a>.

The optional `Style` node can be set to `European` or `American` to
change the exercise style for the strip of options. If not set,
`European` is assumed. If the strip is a strip of APOs, `European` is
assumed and a warning is issued if `Style` is not `European`.

The optional `Settlement` node can be set to `Cash` or `Physical` to
change the settlement method for the strip of options. If not set,
`Cash` is assumed. If the strip is a strip of APOs, `Cash` is assumed
and a warning is issued if `Settlement` is not `Cash`.

The optional `IsDigital` node allows the creation of a strip of
`CommodityDigitalOption`s (see
<a href="#ss:input_commodity_digital_option" data-reference-type="ref"
data-reference="ss:input_commodity_digital_option">[ss:input_commodity_digital_option]</a>).
If set to `true` the node `PayoffPerUnit` needs to be set.

Node `PayoffPerUnit` \[Optional\] specifies the payoff per commodity
unit, expressed in leg currency, in case a digital option is exercised.
If the trade is a strip of digital options, this node must be set. It
accepts real numbers as input.

<div class="listing">

``` xml
<Trade id="...">
  <TradeType>CommodityOptionStrip</TradeType>
  <Envelope>
    ...
  </Envelope>
  <CommodityOptionStripData>
    <LegData>
      <LegType>CommodityFloating</LegType>
      ...
    </LegData>
    <Calls>
      <LongShorts>
        <LongShort>Short</LongShort>
      </LongShorts>
      <Strikes>
        <Strike>5.3</Strike>
      </Strikes>
      <BarrierData>
        <Type>UpAndIn</Type>
        <Style>American</Style>
        <LevelData>
          <Level>
            <Value>70.0</Value>
          </Level>
        </LevelData>
      </BarrierData>
    </Calls>
    <Puts>
      <LongShorts>
        <LongShort>Long</LongShort>
      </LongShorts>
      <Strikes>
        <Strike>8.17</Strike>
      </Strikes>
    </Puts>
    <Premiums> ... </Premiums>
    <Style>European</Style>
    <Settlement>Cash</Settlement>
  </CommodityOptionStripData>
</Trade>
```

</div>

---

### Commodity Position

An commodity position represents a position in a single commodity -
using a single `Underlying` node, or in a weighted basket of underlying
commodities - using multiple `Underlying` nodes.

An commodity Position can be used both as a stand alone trade type
(TradeType: *CommodityPosition*) or as a trade component
(`CommodityPositionData`) used within the *TotalReturnSwap* (Generic
TRS) trade type, to set up for example Commodity Basket trades.

If the *PriceType* is set to *FutureSettlement* it will refer by default
to today’s prompt (lead) future. At the moment a generic TRS doesn’t
support rolling of the future contracts. Today’s prompt future could be
different from the prompt future at inception. If the initial price for
the basket is not set, it will use the price of today’s prompt future at
trade inception as initial price and the TRS will also ignore the roll
yield caused by rolling from one prompt future to the next contract.

It is set up using an `CommodityPositionData` block as shown in listing
<a href="#lst:commoditypositiondata" data-reference-type="ref"
data-reference="lst:commoditypositiondata">[lst:commoditypositiondata]</a>.
The meanings and allowable values of the elements in the block are as
follows:

- Quantity: The number of shares or units of the weighted basket held.  
  Allowable values: Any positive real number

- Underlying: One or more underlying descriptions. If a basket of
  commodities is defined, the `Weight` field should be populated for
  each underlyings. The weighted basket price is then given by  
  $$\text{Basket-Price} = \text{Quantity} \times \sum_i \text{Weight}_i \times S_i \times \text{FX}_i$$
  where

  - $S_i$ is the i-th commodity prompt future or spot price in the
    basket

  - $FX_i$ is the FX Spot converting from the ith commodity currency to
    the first commodity currency which is by definition the currency in
    which the npv of the basket is expressed.

  Allowable values: See
  <a href="#ss:underlying" data-reference-type="ref"
  data-reference="ss:underlying">[ss:underlying]</a> for the definition
  of an underlying. Only commodity underlyings are allowed.

<div class="listing">

``` xml
  <Trade id="CommodityPosition">
    <TradeType>CommodityPosition</TradeType>
    <Envelope>...</Envelope>
    <CommodityPositionData>
      <Quantity>1000</Quantity>
      <Underlying>
        <Type>Commodity</Type>
        <Name>NYMEX:CL</Name>
        <Weight>0.5</Weight>
        <PriceType>FutureSettlement</PriceType>
        <FutureMonthOffset>0</FutureMonthOffset>
        <DeliveryRollDays>0</DeliveryRollDays>
        <DeliveryRollCalendar>TARGET</DeliveryRollCalendar>
      </Underlying>
      <Underlying>
        <Type>Commodity</Type>
        <Name>ICE:B</Name>
        <Weight>0.5</Weight>
        <PriceType>FutureSettlement</PriceType>
        <FutureMonthOffset>0</FutureMonthOffset>
        <DeliveryRollDays>0</DeliveryRollDays>
        <DeliveryRollCalendar>TARGET</DeliveryRollCalendar>
      </Underlying>
    </CommodityPositionData>
  </Trade>
```

</div>

---

### Commodity Swap and Basis Swap

The structure of a `CommoditySwap` trade node is shown in listing
<a href="#lst:commodityswap_data" data-reference-type="ref"
data-reference="lst:commodityswap_data">[lst:commodityswap_data]</a>.
This trade node can be used to represent commodity swaps and commodity
basis swaps. It consists of the generic `Envelope` and the specific
`SwapData` section.

The `SwapData` node may contain two or more `LegData` nodes. There must
be at least one `LegData` node of a commodity `LegType`, i.e.
`CommodityFixed` or `CommodityFloating`, but non-commodity leg types are
also allowed. The commodity leg types are described in sections
<a href="#ss:commodityfixedleg" data-reference-type="ref"
data-reference="ss:commodityfixedleg">[ss:commodityfixedleg]</a> and
<a href="#ss:commodityfloatingleg" data-reference-type="ref"
data-reference="ss:commodityfloatingleg">[ss:commodityfloatingleg]</a>
respectively.

The `SwapData` node also supports optional netting functionality for
floating legs through the `RoundNettedFloatingLegs` and
`NettingPrecision` elements. When `RoundNettedFloatingLegs` is set to
`true`, all floating leg cashflows are netted by payment date, while
fixed legs are processed normally. The netting calculation sums the
effective fixings of all floating legs for each payment period and
multiplies by the common quantity. If `NettingPrecision` is specified,
the summed fixing is rounded to the specified number of decimal places
before multiplying by the quantity.

<div class="listing">

``` xml
<Trade id="...">
  <TradeType>CommoditySwap</TradeType>
  <Envelope>
  </Envelope>
  <SwapData>
    <LegData>
      <LegType>CommodityFixed</LegType>
      ...
    </LegData>
    <LegData>
      <LegType>CommodityFloating</LegType>
      ...
    </LegData>
    <RoundNettedFloatingLegs>true</RoundNettedFloatingLegs>
    <NettingPrecision>2</NettingPrecision>
  </SwapData>
</Trade>
```

</div>

The optional netting parameters are:

- `RoundNettedFloatingLegs` \[Optional\]: Boolean flag to enable
  floating leg netting. When set to `true`, all floating leg cashflows
  with the same payment date are netted into a single cashflow. Fixed
  legs are processed normally and are not affected by netting. Defaults
  to `false`.

- `NettingPrecision` \[Optional\]: Number of decimal places to round the
  total average fixing before multiplying by the quantity. Only applies
  when `RoundNettedFloatingLegs` is `true`. If not specified, no
  rounding is applied to the netted fixing.

The netting calculation works as follows:

1.  All floating leg cashflows are grouped by their payment date

2.  For each payment date, the system verifies that all participating
    cashflows have the same `periodQuantity()`

3.  The effective fixings are summed:
    $\sum (\text{isPayer} ? -1 : 1) \times \text{fixing()}$

4.  If `NettingPrecision` is specified, the sum is rounded to the
    specified decimal places

5.  The final netted amount is calculated as: rounded_sum $\times$
    common_quantity

---

### Commodity Swaption

The structure of a trade node representing a commodity swaption is shown
in listing <a href="#lst:commodity_swaption" data-reference-type="ref"
data-reference="lst:commodity_swaption">[lst:commodity_swaption]</a>. It
consists of the generic `Envelope` and the specific
`CommoditySwaptionData` node.

The `CommoditySwaptionData` node contains an `OptionData` node described
in <a href="#ss:option_data" data-reference-type="ref"
data-reference="ss:option_data">[ss:option_data]</a>. The relevant
fields in the `OptionData` node for a CommoditySwaption are:

- `LongShort`: The allowable values are *Long* or *Short*. Note that the
  payer and receiver legs in the underlying swap are always from the
  perspective of the party that is *Long*. E.g. for a *Short*
  CommoditySwaption with a fixed leg where the Payer flag is set to
  *false*, it means that the counterparty receives the fixed flows.

- `OptionType`\[Optional\]: This flag is optional for
  CommoditySwaptions, and even if set, has no impact. The direction of
  flows is determined entirely by the Payer flags on the underlying legs
  (and the `LongShort` flag above).

- `Style`: The exercise style of the CommoditySwaption. Only exercise
  style *European* is supported.

- `NoticePeriod`\[Optional\]: The notice period defining the date
  (relative to the exercise date) on which the exercise decision has to
  be taken. If not given the notice period defaults to *0D*, i.e. the
  notice date is identical to the exercise date. Allowable values: A
  number followed by *D, W, M, or Y*

- `NoticeCalendar`\[Optional\]: The calendar used to compute the notice
  date from the exercise date. If not given defaults to the
  *NullCalendar* (no holidays, weekends are no holidays either).
  Allowable values: See Table
  <a href="#tab:calendar" data-reference-type="ref"
  data-reference="tab:calendar">[tab:calendar]</a> `Calendar`.

- `NoticeConvention`\[Optional\]: The roll convention used to compute
  the notice date from the exercise date. Defaults to *Unadjusted* if
  not given. Allowable values: See Table
  <a href="#tab:convention" data-reference-type="ref"
  data-reference="tab:convention">[tab:convention]</a> Roll Convention.

- `Settlement`: Delivery Type. The allowable values are *Cash* or
  *Physical*.

- `ExerciseFees`\[Optional\]: This node contains child elements of type
  `ExerciseFee`. Similar to a list of notionals (see
  <a href="#ss:leg_data" data-reference-type="ref"
  data-reference="ss:leg_data">[ss:leg_data]</a>) the fees can be given
  either

  - as a list where each entry corresponds to an exercise date and the
    last entry is used for all remaining exercise dates if there are
    more exercise dates than exercise fee entries, or

  - using the `startDate` attribute to specify a change in a fee from a
    certain day on (w.r.t. the exercise date schedule)

  Fees can either be given as an absolute amount or relative to the
  current notional of the period immediately following the exercise date
  using the `type` attribute together with specifiers `Absolute` resp.
  `Percentage`. If not given, the type defaults to `Absolute`.
  `Percentage` fees are expressed in decimal form, e.g. 0.05 is a fee of
  5% of notional.

  If a fee is given as a positive number the option holder has to pay a
  corresponding amount if they exercise the option. If the fee is
  negative on the other hand, the option holder receives an amount on
  the option exercise.

- `ExerciseFeeSettlementPeriod`\[Optional\]: The settlement lag for
  exercise fee payments. Defaults to 0D if not given. This lag is
  relative to the exercise date (as opposed to the notice date).
  Allowable values: A number followed by *D, W, M, or Y*

- `ExerciseFeeSettlementCalendar`\[Optional\]: The calendar used to
  compute the exercise fee settlement date from the exercise date. If
  not given defaults to the *NullCalendar* (no holidays, weekends are no
  holidays either). Allowable values: See Table
  <a href="#tab:calendar" data-reference-type="ref"
  data-reference="tab:calendar">[tab:calendar]</a> Calendar.

- `ExerciseFeeSettlementConvention`\[Optional\]: The roll convention
  used to compute the exercise fee settlement date from the exercise
  date. Defaults to *Unadjusted* if not given. Allowable values: See
  Table <a href="#tab:convention" data-reference-type="ref"
  data-reference="tab:convention">[tab:convention]</a> Roll Convention.

- An `ExerciseDates` node where exactly one `ExerciseDate` date element
  must be given for *European* style CommoditySwaptions. Allowable
  values: The `ExerciseDate` must be on or before the StartDate of the
  underlying legs, and be on or after the valuation date. For the
  format, see Date in Table
  <a href="#tab:allow_stand_data" data-reference-type="ref"
  data-reference="tab:allow_stand_data">[tab:allow_stand_data]</a>.  

- `Premiums` \[Optional\]: Option premium node with amounts paid by the
  option buyer to the option seller.

  Allowable values: See section
  <a href="#ss:premiums" data-reference-type="ref"
  data-reference="ss:premiums">[ss:premiums]</a>

The `CommoditySwaptionData` node should contain exactly two `LegData`
nodes. One `LegData` node should be of type `CommodityFixed` described
in section <a href="#ss:commodityfixedleg" data-reference-type="ref"
data-reference="ss:commodityfixedleg">[ss:commodityfixedleg]</a> and one
should be of type `CommodityFloating` described in section
<a href="#ss:commodityfloatingleg" data-reference-type="ref"
data-reference="ss:commodityfloatingleg">[ss:commodityfloatingleg]</a>.
Note that on the `CommodityFloating` leg, the Spread must be omitted or
set to *0*, and the Gearing must be omitted or set to *1*.

<div class="listing">

``` xml
<Trade id="...">
  <TradeType>CommoditySwaption</TradeType>
  <Envelope>
    ...
  </Envelope>
  <CommoditySwaptionData>
    <OptionData>
      <LongShort>Long</LongShort>
      <Style>European</Style>
      <Settlement>Cash</Settlement>
      <ExerciseDates>
        <ExerciseDate>2023-01-05</ExerciseDate>
      </ExerciseDates>
    </OptionData>
    <LegData>
      <LegType>CommodityFixed</LegType>
      ...
    </LegData>
    <LegData>
      <LegType>CommodityFloating</LegType>
      ...
    </LegData>
  </CommoditySwaptionData>
</Trade>
```

</div>

---

### Commodity Variance and Volatility Swap

A Commodity Variance or Volatility Swap has a payoff that depends on the
volatility/variance of an underlying commodity instrument. See section
<a href="#SubSectionEqVarianceSwap" data-reference-type="ref"
data-reference="SubSectionEqVarianceSwap">[SubSectionEqVarianceSwap]</a>
for the equivalent Equity product.

The `CommodityVarianceSwapData` node is the trade data container for the
*CommodityVarianceSwap* trade type. The structure of an example
`CommodityVarianceSwapData` node for a Commodity Variance Swap is the
same as for an Equity Variance Swap in section
<a href="#SubSectionEqVarianceSwap" data-reference-type="ref"
data-reference="SubSectionEqVarianceSwap">[SubSectionEqVarianceSwap]</a>,
with the exception of the underlying node which is of type ’Commodity’
here. See section <a href="#ss:underlying" data-reference-type="ref"
data-reference="ss:underlying">[ss:underlying]</a> for additional
optional elements of the underlying node and allowable values.

---

### Composite Trade

A composite trade is a hybrid position consisting of multiple component
trades. As such it inherits the characteristics of the trades defined
within it. Examples of Composite Trades include combinations of vanilla
options like straddles.

The `CompositeTradeData` node is the trade data container for the
*CompositeTrade* trade type. A composite trade is a hybrid position
consisting of multiple component trades. The structure of an example
`CompositeTradeData` node for a commodity option is shown in Listing
<a href="#lst:compositetrade_data" data-reference-type="ref"
data-reference="lst:compositetrade_data">[lst:compositetrade_data]</a>.

<div class="listing">

``` xml
        <CompositeTradeData>
          <Currency>USD</Currency>
          <NotionalCalculation>Sum</NotionalCalculation>
          <Components>
            <Trade id="">
              <!-- A valid trade xml -->
            </Trade>
            <Trade id="">
              <!-- A valid trade xml -->
            </Trade>
          </Components>
        </CompositeTradeData>
```

</div>

<div class="listing">

``` xml
        <CompositeTradeData>
          <Currency>USD</Currency>
          <NotionalCalculation>Sum</NotionalCalculation>
          <PortfolioBasket>true</PortfolioBasket>
          <BasketName>NAME</BasketName>
          <IndexQuantity>100</IndexQuantity>
        </CompositeTradeData>
```

</div>

The meanings and allowable values of the elements in the
`CompositeTradeData` node follow below.

- Currency: Defines the currency the NPV of the composite trade will be
  represented in.  
  Allowable values: See Table
  <a href="#tab:currency" data-reference-type="ref"
  data-reference="tab:currency">[tab:currency]</a> `Currency`.

- NotionalCalculation \[Optional\]: The method by which the notional of
  the composite trade will be calculated.  
  Allowable values:

  - *Sum*: The notional will be calculated as the sum of the notionals
    of the constituent trades. This is the default behaviour if the
    field is omitted (unless an override is provided).

  - *Mean* or *Average*: The notional will be calculated as the mean of
    the notionals of the constituent trades.

  - *First*: The notional of the first constituent trade will be used.

  - *Last*: The notional of the first constituent trade will be used.

  - *Min*: The notional will be calculated as the minimum of the
    notionals of the constituent trades.

  - *Max*: The notional will be calculated as the minimum of the
    notionals of the constituent trades.

  - *Override*: the notional will be read directly from the notional
    override field.

- NotionalOverride \[Optional\]: The notional which will be used for the
  trade, overriding any calculation method specified.  
  Allowable values: Any non-negative real number.

- Components: The portfolio of trades that make up the composite
  trade.  
  Allowable values: These trades should be valid xmls that could
  otherwise be entered into the portfolio, with the exception that they
  can have empty ids.

- PortfolioBasket \[Optional\]: Indicate if the Component represent a
  portfolio basket.  
  Allowable values: Boolean true or false.

- BasketName \[Optional\]: The portfolio Id.  
  Allowable values: Any string. Note that if PortfolioBasket is True
  then there must be a BasketName. We look up the Basket within the
  reference data.

- IndexQuantity \[Optional\]: Number of shares of the index.

---

### Convertible Bond

A convertible bond is set up in ORE using a `ConvertibleBondData` block
as shown in listing
<a href="#lst:convertiblebonddata1" data-reference-type="ref"
data-reference="lst:convertiblebonddata1">[lst:convertiblebonddata1]</a>.
The bond details are read from reference data in this case.

A convertible bond is a bond, that can be converted into a prespecified
number of shares, given by:
$$NumberOfShares = \frac{BondNotional}{ConversionRatio}$$

Where the Conversion Ratio is specified in the underlying bond reference
data.

The shares are usually from the bond issuer, but it is also possible
that the shares are from a different issuer (exchangeables). In
addition, the share currency can be different from the bond currency in
both cases (cross-currency convertibles).

The bond might be callable by the issuer (typically in American style)
and / or puttable by the investor (typically in Bermudan style). The
issuer calls can be “hard calls”, which are call rights in the
traditional sense, as opposed to “soft calls” which can only the
exercised if the equity price observed on the exercise date is above a
prespecified threshold given by TriggerRatios. If a soft call is
exercised, the investor has the right to convert the bond into shares
instead of accepting the payment from the issuer call (“forced
conversion”).

The meanings and allowable values of the elements in the
`ConvertibleBondData` block are as follows:

- SecurityId: The underlying security identifier  
  Allowable values: Typically the ISIN of the underlying bond, with the
  ISIN: prefix.

- BondNotional: The notional of the underlying bond expressed in the
  currency of the bond.  
  Allowable values: Any positive real number.

- CreditRisk \[Optional\] Boolean flag indicating whether to show Credit
  Risk on the Bond product.  
  Allowable Values: *true* or *false* Defaults to *true* if left blank
  or omitted.

<div class="listing">

``` xml
  <Trade id="ConvertibleBond">
    <TradeType>ConvertibleBond</TradeType>
    <Envelope>...</Envelope>
    <ConvertibleBondData>
      <BondData>
        <SecurityId>ISIN:XS0451905367</SecurityId>
        <BondNotional>1000000.00</BondNotional>
      </BondData>
    </ConvertibleBondData>
  </Trade>
```

</div>

Alternatively the bond can be set up with further explicit details using
the blocks as shown in listing
<a href="#lst:convertiblebonddata2" data-reference-type="ref"
data-reference="lst:convertiblebonddata2">[lst:convertiblebonddata2]</a>.
All fields that are not given in the trade XML are filled up with the
information from the reference data if available in the reference data.
In other words, if reference data is given, the trade xml can still be
used to overwrite the information partially, if this seems appropriate.
The meanings and allowable values of the elements in the block are as
follows:

- BondData: The vanilla part of the bond, see
  <a href="#ss:bond" data-reference-type="ref"
  data-reference="ss:bond">[ss:bond]</a>.

- CallData: The call terms of the bond, as described below. Optional, if
  not given, no calls are present.

- PutData: The put terms of the bond, as described below. Optional, if
  not given, no puts are present.

- ConversionData: The conversion terms of the bond, as described below.
  This node must always be given, even if no conversion rights are
  present (in which case an empty conversion date list can be used).

- DividendProtectionData: The dividend protection terms of the bond, as
  described below. Optional, if not given, no dividend prtection is
  present.

- Detachable: If true, the trade represents the embedded optionality,
  i.e. the difference between the full convertible bond and the bond
  floor. Optional, defaults to false.  
  Allowable values: true, false

The convertible bond trade type supports perpetual schedules, i.e.
perpetual convertible bonds can be represented by omitting the EndDate
in the following schedules to indicate perpetual schedules. Only rule
based schedules can be used to indicate perpetual schedules.

- BondData / LegData: Omitting the EndDate in this schedule indicates
  that the underlying bond runs perpetually.

- CallData: Omitting the EndDate in this schedule indicates perpetual
  call dates. For American call dates, where only two dates have to be
  specified (start and end date of the american call window), a rule
  based schedule with Tenor = 0D, Rule = Zero and without EndDate can be
  used to indicate an end date infinitely far away in the future.

- PutData: Same as CallData.

- ConversionData: Omitting the EndDate in this schedule indicates
  perpetual conversion rights. For American rights, the same comment as
  under CallData applies.

- ConversionData / ConversionResets: Omitting the EndDate in this
  schedule indicates perpetual conversion resets.

- DividendProtectionData: Omitting the EndDate in this schedule
  indicates a perpetual dividend protection schedule.

<div class="listing">

``` xml
  <Trade id="ConvertibleBond">
    <TradeType>ConvertibleBond</TradeType>
    <Envelope>...</Envelope>
    <ConvertibleBondData>
      <BondData> ... </BondData>
      <CallData> ... </CallData>
      <PutData> ... </PutData>
      <ConversionData> ... </ConversionData>
      <DividendProtectionData> ... </DividendProtectionData>
      <Detachable>false</Detachable>
    </ConvertibleBondData>
  </Trade>
```

</div>

<u>Specification of CallData / PutData:</u>

All lists specified in subnodes (except the date list itself of course)
can be specified as either an explicit list of values corresponding to
the schedule dates list or using the attribute `startDate`. An explicit
value list can be shorter than the list of dates, in which case the last
value from the list is associated to the remaining dates.

See listings <a href="#lst:convertiblebonddata_callputdata_1"
data-reference-type="ref"
data-reference="lst:convertiblebonddata_callputdata_1">[lst:convertiblebonddata_callputdata_1]</a>,<a href="#lst:convertiblebonddata_callputdata_2"
data-reference-type="ref"
data-reference="lst:convertiblebonddata_callputdata_2">[lst:convertiblebonddata_callputdata_2]</a>,<a href="#lst:convertiblebonddata_callputdata_3"
data-reference-type="ref"
data-reference="lst:convertiblebonddata_callputdata_3">[lst:convertiblebonddata_callputdata_3]</a>,<a href="#lst:convertiblebonddata_callputdata_4"
data-reference-type="ref"
data-reference="lst:convertiblebonddata_callputdata_4">[lst:convertiblebonddata_callputdata_4]</a>,<a href="#lst:convertiblebonddata_callputdata_5"
data-reference-type="ref"
data-reference="lst:convertiblebonddata_callputdata_5">[lst:convertiblebonddata_callputdata_5]</a>,<a href="#lst:convertiblebonddata_callputdata_6"
data-reference-type="ref"
data-reference="lst:convertiblebonddata_callputdata_6">[lst:convertiblebonddata_callputdata_6]</a>,<a href="#lst:convertiblebonddata_callputdata_7"
data-reference-type="ref"
data-reference="lst:convertiblebonddata_callputdata_7">[lst:convertiblebonddata_callputdata_7]</a>
for examples of exercise schedules.

- Styles: A list of the exercise styles. Notice that Bermudan is used to
  define European exercises as well, namely as a Bermudan exercise with
  a single exercise date. The attribute `startDate` can be used to
  specify the list.  
  Allowable values: American, Bermudan

- ScheduleData: A schedule of exercise dates (for Bermudan exercises) or
  start / end dates (for American exercises)  
  Allowable values: see
  <a href="#ss:schedule_data" data-reference-type="ref"
  data-reference="ss:schedule_data">[ss:schedule_data]</a>.

- Prices: A list of exercise prices in relative terms, i.e. if the price
  is $1.02$ then the amount paid on the exercise is this price times the
  current notional of the bond (plus accrued interest, if the price type
  is clean, see below). The attribute `startDate` can be used to specify
  the list.  
  Allowable values: Any positive real number.

- PriceType: A list of the flavour in which the exercise prices are
  given. The attribute `startDate` can be used to specify the list.  
  Allowable values: Clean, Dirty.

- IncludeAccrual: A list of flags specifying whether accruals have to be
  paid on exercise. This is independent of the quoting style of the
  exercise prices (PriceType).  
  Allowable values: true, false

- Soft: A list of flags specifying whether the call is soft (true) or
  hard (false). The attribute `startDate` can be used to specify the
  list. Optional, defaults to false. Only applicable to Calls, not to
  Puts. Optional, if not given, false is assumed, i.e. hard calls. If
  soft calls are specified, at least one conversion exercise date with
  corresponding conversion rate must be defined under ConversionData.  
  Allowable values: true, false

- TriggerRatios: A list of trigger ratios $T$ for soft calls. A soft
  call can be executed only if the equity price on the exercise date is
  above the Conversion Price (defined below) times the trigger ratio,
  i.e. $S_t > C^P_tT$. Only applicable to Calls, not to Puts. Required
  for soft calls, can be omitted otherwise.  
  $$Conversion Price, C^P_t = \frac{1}{ConversionRatio}$$

  For cross-currency trades the conversion price is usually quoted in
  equity ccy, i.e.

  $$Conversion Price, C^P_t = \frac{1}{ConversionRatio \cdot X_t}$$

  where $X_t$ converts one equity ccy unit to bond ccy

  Allowable values: Any positive real number.

- NOfMTriggers: A list of n-of-m trigger specifications for calls, i.e.
  the soft-call trigger defined by TriggerRatios must be observed on n
  of the m calendar days in the period before (and including) a call
  date. Only applicable to Calls, not to Puts. Optional, defaults to
  “1-of-1”  
  Allowable values: x-of-y with x, y non-negative integers, “1-of-1”
  corresponds to a vanilla call specification

- MakeWhole: A list of make whole conditions. Optional. Possible
  subnodes are:

  - ConversionRatioIncrease: In case of a call exercise, the conversion
    ratio (applicable in case of a forced conversion) is adjusted
    upwards. The adjustment is additive, i.e. if the current conversion
    ratio is $CR$ the conversion ratio applicable in case of a forced
    conversion will be $CR+d$ where $d$ is interpolated from a matrix of
    effective dates (rows) and stock prices (columns). The conversion
    rate adjustment might be capped by a prespecified rate. If the
    exercise date / stock price lies outside the matrix, $d$ is zero,
    i.e. no adjustment is made. Notice that a soft call trigger is
    checked w.r.t. $CR$, i.e. the unadjusted conversion ratio.

    - Cap: An upper bound for the adjusted conversion ratio. Optional,
      if not given, no cap will be applied.  
      Allowable values: Any non-negative real number.

    - StockPrices: A comma separated list of stock prices defining the
      interpolation grid’s x values. At least two stock prices must be
      given.  
      Allowable values: A list of non-negative real numbers.

    - CrIncreases: A node that contains at least two subnodes
      CrIncrease. Each subnode must have an attribute startDate defining
      the effective date of the adjustment and a list of conversion
      ratio adjustments $d$. The number of adjustments must match the
      number of prices given in the StockPrices node.  
      Allowable values: A list of non-negative real numbers.

<div class="listing">

``` xml
  <!-- Bermudan issuer call on three dates at a clean price of 100 (hard calls),
       accruals are paid on exercise -->
  <CallData>
    <Styles>
      <Style>Bermudan</Style>
    </Styles>
    <ScheduleData>
      <Dates>
        <Dates>
          <Date>2016-08-03</Date>
          <Date>2017-08-03</Date>
          <Date>2018-08-03</Date>
        </Dates>
      </Dates>
    </ScheduleData>
    <Prices>
      <Price>1.00</Price>
    </Prices>
    <PriceTypes>
      <PriceType>Clean</PriceType>
    </PriceTypes>
    <IncludeAccruals>
      <IncludeAccrual>true</IncludeAccrual>
    </IncludeAccruals>
    <Soft>
      <Soft>false</Soft>
    </Soft>
    <TriggerRatios/>
    <NOfMTriggers>
      <NOfMTrigger>20-of-30</NOfMTrigger>
    </NOfMTriggers>
  </CallData>
```

</div>

<div class="listing">

``` xml
  <!-- Bermudan issuer call on three dates at a clean price of 101, 102 and 103,
       soft calls with trigger ratio of 0.8, 0.85, 0.9,
       accrual are _not_ paid on exercise -->
  <CallData>
    <Styles>
      <Style>Bermudan</Style>
    </Styles>
    <ScheduleData>
      <Dates>
        <Dates>
          <Date>2016-08-03</Date>
          <Date>2017-08-03</Date>
          <Date>2018-08-03</Date>
        </Dates>
      </Dates>
    </ScheduleData>
    <Prices>
      <Price>1.01</Price>
      <Price>1.02</Price>
      <Price>1.03</Price>
    </Prices>
    <PriceTypes>
      <PriceType>Clean</PriceType>
    </PriceTypes>
    <IncludeAccruals>
      <IncludeAccrual>false</IncludeAccrual>
    </IncludeAccruals>
    <Soft>
      <Soft>true</Soft>
    </Soft>
    <TriggerRatios>
      <TriggerRatio>0.8</TriggerRatio>
      <TriggerRatio>0.85</TriggerRatio>
      <TriggerRatio>0.9</TriggerRatio>
    </TriggerRatios>
  </CallData>
```

</div>

<div class="listing">

``` xml
  <!-- American issuer call between 2016-08-03 and 2018-08-03
       at a clean price of 100 (hard calls) -->
  <CallData>
    <Styles>
      <Style>American</Style>
    </Styles>
    <ScheduleData>
      <Dates>
        <Dates>
          <Date>2016-08-03</Date>
          <Date>2018-08-03</Date>
        </Dates>
      </Dates>
    </ScheduleData>
    <Prices>
      <Price>1.00</Price>
    </Prices>
    <PriceTypes>
      <PriceType>Clean</PriceType>
    </PriceTypes>
    <IncludeAccruals>
      <IncludeAccrual>true</IncludeAccrual>
    </IncludeAccruals>
    <Soft>
      <Soft>false</Soft>
    </Soft>
    <TriggerRatios/>
  </CallData>
```

</div>

<div class="listing">

``` xml
  <!-- American issuer call between 2016-08-03 and 2020-08-03 (excl),
       hard calls at 100 between 2016-08-03 and 2018-08-03 (excl),
       soft calls at 102 between 2018-08-03 and 2019-08-03 (excl),
       soft calls at 103 between 2019-08-03 and 2020-08-03 -->
  <CallData>
    <Styles>
      <Style>American</Style>
    </Styles>
    <ScheduleData>
      <Dates>
        <Dates>
          <Date>2016-08-03</Date>
          <Date>2018-08-03</Date>
          <Date>2019-08-03</Date>
          <Date>2020-08-03</Date>
        </Dates>
      </Dates>
    </ScheduleData>
    <Prices>
      <Price>1.00</Price>
      <Price startDate="2018-08-03">1.02</Price>
      <Price startDate="2019-08-03">1.03</Price>
    </Prices>
    <PriceTypes>
      <PriceType>Clean</PriceType>
    </PriceTypes>
    <IncludeAccruals>
      <IncludeAccrual>true</IncludeAccrual>
    </IncludeAccruals>
    <Soft>
      <Soft>false</Soft>
      <Soft startDate="2018-03-03">true</Soft>
    </Soft>
    <TriggerRatios>
      <TriggerRatio>0.8</TriggerRatio>
      <TriggerRatio startDate="2019-08-03">0.9</TriggerRatio>
    </TriggerRatios>
  </CallData>
```

</div>

<div class="listing">

``` xml
  <!-- Bermudan (hard) calls at 100 at 3 dates from 2016 to 2018,
       followed by American (soft) calls at 102 between 2018 and 2020 -->
  <CallData>
    <Styles>
      <Style>Bermudan</Style>
      <Style startDate="2018-08-03">American</Style>
    </Styles>
    <ScheduleData>
      <Dates>
        <Dates>
          <Date>2016-08-03</Date>
          <Date>2017-08-03</Date>
          <Date>2018-08-03</Date>
          <Date>2020-08-03</Date>
        </Dates>
      </Dates>
    </ScheduleData>
    <Prices>
      <Price>1.00</Price>
      <Price startDate="2018-08-03">1.02</Price>
    </Prices>
    <PriceTypes>
      <PriceType>Clean</PriceType>
    </PriceTypes>
    <IncludeAccruals>
      <IncludeAccrual>true</IncludeAccrual>
    </IncludeAccruals>
    <Soft>
      <Soft>false</Soft>
      <Soft startDate="2018-08-03">true</Soft>
    </Soft>
    <TriggerRatios>
      <TriggerRatio>0.8</TriggerRatio>
    </TriggerRatios>
  </CallData>
```

</div>

<div class="listing">

``` xml
  <!-- Bermudan puts calls at 100, 101, 102 at 3 dates from 2016 to 2018 -->
  <PutData>
    <Styles>
      <Style>Bermudan</Style>
    </Styles>
    <ScheduleData>
      <Dates>
        <Dates>
          <Date>2016-08-03</Date>
          <Date>2017-08-03</Date>
          <Date>2018-08-03</Date>
        </Dates>
      </Dates>
    </ScheduleData>
    <Prices>
      <Price>1.00</Price>
      <Price>1.01</Price>
      <Price>1.02</Price>
    </Prices>
    <PriceTypes>
      <PriceType>Clean</PriceType>
    </PriceTypes>
    <IncludeAccruals>
      <IncludeAccrual>true</IncludeAccrual>
    </IncludeAccruals>
  </PutData>
```

</div>

<div class="listing">

``` xml
<CallData>
...
   <MakeWhole>
     <ConversionRatioIncrease>
       <Cap>0.0740740</Cap>
       <StockPrices>13.50,15.00,16.20,18.00</StockPrices>
       <CrIncreases>
         <CrIncrease startDate="2020-06-25">0.0123456,0.0107487,0.0097173,0.0084567</CrIncrease>
         <CrIncrease startDate="2021-07-01">0.0123456,0.0096880,0.0086963,0.0075294</CrIncrease>
         <CrIncrease startDate="2022-07-01">0.0123456,0.0083927,0.0074222,0.0063383</CrIncrease>
         <CrIncrease startDate="2023-07-01">0.0123456,0.0069360,0.0058790,0.0048322</CrIncrease>
         <CrIncrease startDate="2024-07-01">0.0123456,0.0054453,0.0040025,0.0028833</CrIncrease>
         <CrIncrease startDate="2025-07-01">0.0123456,0.0049380,0.0000000,0.0000000</CrIncrease>
       </CrIncreases>
     </ConversionRatioIncrease>
   </MakeWhole>
</CallData>
```

</div>

<u>Specification of ConversionData:</u>

As in the case of the CallData, all lists can be specified as either an
explicit list of values corresponding to the schedule dates list or
using the attribute `startDate`. The ConversionRatios element is an
expcetion, the given start dates are interpreted independently of these
schedule dates.

See listings <a href="#lst:convertiblebonddata_conversion_1"
data-reference-type="ref"
data-reference="lst:convertiblebonddata_conversion_1">[lst:convertiblebonddata_conversion_1]</a>,
<a href="#lst:convertiblebonddata_conversion_2"
data-reference-type="ref"
data-reference="lst:convertiblebonddata_conversion_2">[lst:convertiblebonddata_conversion_2]</a>,<a href="#lst:convertiblebonddata_conversion_3"
data-reference-type="ref"
data-reference="lst:convertiblebonddata_conversion_3">[lst:convertiblebonddata_conversion_3]</a>,<a href="#lst:convertiblebonddata_conversion_4"
data-reference-type="ref"
data-reference="lst:convertiblebonddata_conversion_4">[lst:convertiblebonddata_conversion_4]</a>,
<a href="#lst:convertiblebonddata_conversion_5"
data-reference-type="ref"
data-reference="lst:convertiblebonddata_conversion_5">[lst:convertiblebonddata_conversion_5]</a>,<a href="#lst:convertiblebonddata_conversion_6"
data-reference-type="ref"
data-reference="lst:convertiblebonddata_conversion_6">[lst:convertiblebonddata_conversion_6]</a>
for examples of conversion schedules.

- Styles: The styles of the conversion rights. Notice that Bermudan is
  used to define European conversion rights as well, namely as a
  Bermudan conversion right with a single date. The attribute
  `startDate` can be used to specify the list. Can be omitted, if no
  conversion dates are given.  
  Allwoable values: American, Bermudan

- ScheduleData: The dates defining when the bond is convertible. For
  Bermudan exercises, the conversion can be executed on the single dates
  given in the list. For American exercises, the conversion can be
  executed between a given start and end date. Can be omitted, if no
  conversion rights are present.  
  Allowable values: see
  <a href="#ss:schedule_data" data-reference-type="ref"
  data-reference="ss:schedule_data">[ss:schedule_data]</a>.

- ConversionRatios: A list of conversion ratios $C^R$. The attribute
  `startDate` can be used to specify a date from which the ratio is
  valid. Notice that this date is always interpreted “as is”, i.e. it is
  not mapped onto the next date in the defined schedule. If no startDate
  is given for a ratio, this ratio is interpreted as the initial
  ratio.  
  Allowable values: Any non-negative real number.

- FixedConversionAmounts: If this node is given, the conversion is
  specified to be conversion to fixed cash amounts instead of equity. If
  the cash amount currency is different from the bond currency, the
  FXIndex node must be given. See
  <a href="#lst:convertiblebonddata_conversion_6"
  data-reference-type="ref"
  data-reference="lst:convertiblebonddata_conversion_6">[lst:convertiblebonddata_conversion_6]</a>
  for an example. As for ConversionRatios the attribute `startDate` can
  be used to specify a date from which the amount is valid and this date
  is interpreted “as is”, i.e. not mapped onto the next date in the
  defined schedule. The nodes

  - ConversionRatios

  - ContingentConversion

  - MandatoryConversion

  - ConversionResets

  - Underlying

  - Exchangeable

  must *not* be given, if this node is present. Furthermore, the
  following nodes from other sections are not applicable if the
  conversion is specified to be fixed cash amounts, and must therefore
  not be given:

  - CallData/Soft

  - CallData/TriggerRatios

  - CallData/NoMTriggers

  - CallData/MakeWhole

  - DividendProtectionData (including all subnodes)

- ContingentConversion: This adds a condition $C^R_t S_t > B$ on the
  convertibility for the periods defined by the conversion dates.
  Optional.

  - Observations: A list of observation modes.  
    Allowable values: Spot (trigger is checked on the conversion date),
    StartOfPeriod (trigger is checked on the start of the conversion
    period defined by the dates list, for American style conversion
    only)

  - Barriers: A list of barriers $B$ associated to the conversion
    dates.  
    Allowable values: Positive real number or zero (conversion is not
    made contingent for this date).

- MandatoryConversion: This adds a mandatory conversion obligation at a
  date greater than all other conversion dates (if any). Optional.

  - Date: The mandatory conversion date.  
    Allowable values: Any date not earlier than the last otherwise
    specified conversion date.

  - Type: The type of the mandatory conversion.  
    Allowable values: PEPS

  - PepsData: Details of mandatory conversion type PEPS.

    - UpperBarrier: upper barrier for PEPS payoff.  
      Allowable values: A real number.

    - LowerBarrier: lower barrier for PEPS payoff.  
      Allowable values: A real number.

    - UpperConversionRatio: conversion ratio for upper barrier in PEPS
      payoff.  
      Allowable values: A real number.

    - LowerConversionRatio: conversion ratio for lower barrier in PEPS
      payoff.  
      Allowable values: A real number.

- ConversionResets: This adds a reset schedule for the conversion rate.
  If a reset feature is defined, ConversionRatio values can only be
  defined up to the valuation date, but changes later than valuation
  date are not allowed: From the valuation date onwards, the future
  conversion ratios are determined by the resets. The startDate
  attribute can be used to define references, thresholds, gearings,
  floors, global floors. Optional.

  - ScheduleData: The conversion reset dates.  
    Allowable values: see
    <a href="#ss:schedule_data" data-reference-type="ref"
    data-reference="ss:schedule_data">[ss:schedule_data]</a>.

  - References: Whether the initial conversion price $C^P_0$ or the
    current conversion price $C^P_t$ is the reference for the reset.  
    Allowable values: InitialConversionPrice, CurrentConversionPrice

  - Thresholds: The threshold $T$ that triggers a reset ($S_t < TC^P_0$
    or $S_t < TC^P_t$, depending on Reference)  
    Allowable values: positive number or zero (disables the reset on
    this date effectively)

  - Gearings: The gearings $g$ for the conversion rate adjustment.
    Option, defaults to $0$ (= no gearing applicable)  
    Allowable values: positive number or zero (no gearing applicable on
    this date).

  - Floors: The floors $f$ for the conversion rate adjustment. Optional,
    defaults to $0$ (= no floor applicable)  
    Allowable values: positive number or zero (no floor applicable on
    this date)

  - GlobalFloors: The global floors for the conversion rate adjustment.
    Option, defaults to $0$ (= no global floor applicable)  
    Allowable values: positive number or zero (no global floor
    applicable on this date)

- Underlying: The equity underlying.  
  Allwoable values: See
  <a href="#ss:underlying" data-reference-type="ref"
  data-reference="ss:underlying">[ss:underlying]</a>, the underlying
  type must be equity.

- FXIndex: If equity ccy is different from bond ccy, an fx index for the
  two involved ccy is required.  
  Allowable values: The format of the FX Index is“FX-SOURCE-CCY1-CCY2”
  as described in table
  <a href="#tab:fxindex_data" data-reference-type="ref"
  data-reference="tab:fxindex_data">[tab:fxindex_data]</a>.

- Exchangeable: Node with data for exchangeables. Option, if omitted,
  the structure is considered non-exchangeable. Subnodes are:  

  - IsExchangeable: indicates whether the convertible bond is
    exchangeable  
    Allowable values: true, false

  - EquityCreditCurve: the credit curve modeling the equity issuer
    default, required if IsExchangeable is true.  
    Allowable values: A valid credit curve identifier, e.g the ISIN of a
    reference bond with the ISIN: prefix: `ISIN:XXNNNNNNNNNN`

  - Secured: Indicates whether the convertible is secured with pledged
    shares or not. Optional, defaults to false.  
    Allowable values: true, false.

<div class="listing">

``` xml
  <!-- Three conversion dates (Bermudan), conversion ratio is 0.5 -->
    <ConversionData>
      <Styles>
        <Style>Bermudan</Style>
      </Styles>
      <ScheduleData>
        <Dates>
          <Dates>
            <Date>2016-08-03</Date>
            <Date>2017-08-03</Date>
            <Date>2018-08-03</Date>
          </Dates>
        </Dates>
      </ScheduleData>
      <ConversionRatios>
        <ConversionRatio>0.05</ConversionRatio>
      </ConversionRatios>
      <Underlying>
        <Type>Equity</Type>
        <Name>RIC:.ABCD</Name>
      </Underlying>
      <FXIndex>FX-ECB-EUR-USD</FXIndex>
      <Exchangeable>
        <IsExchangeable>true</IsExchangeable>
        <EquityCreditCurve>ISIN:XS0982710740</EquityCreditCurve>
        <Secured>true</Secured>
      </Exchangeable>
    </ConversionData>
```

</div>

<div class="listing">

``` xml
  <!-- American conversion between 2016-08-03 and 2020-08-03, with
       conversion ratio 0.5 for 2016-08-03 through 2018-08-03 (excl) and
       conversion ratio 0.6 for 2018-08-03 through 2020-08-03 -->
    <ConversionData>
      <Styles>
        <Style>American</Style>
      </Styles>
      <ScheduleData>
        <Dates>
          <Dates>
            <Date>2016-08-03</Date>
            <Date>2018-08-03</Date>
            <Date>2020-08-03</Date>
          </Dates>
        </Dates>
      </ScheduleData>
      <ConversionRatios>
        <ConversionRatio>0.05</ConversionRatio>
        <ConversionRatio startDate="2018-08-03">0.06</ConversionRatio>
      </ConversionRatios>
      <Underlying>
        <Type>Equity</Type>
        <Name>RIC:.ABCD</Name>
      </Underlying>
    </ConversionData>
```

</div>

<div class="listing">

``` xml
  <!-- American conversion between 2016-08-03 and 2018-08-03, with conversion
       ratio 0.5, the conversion is contingent on the parity being above 1.3
       on 2016-08-03 for the conversion between 2016-08-03 and 2017-08-03 (excl)
       on 2017-08-03 for the conversion between 2017-08-03 and 2018-08-03 -->
    <ConversionData>
      <Styles>
        <Style>American</Style>
      </Styles>
      <ScheduleData>
        <Dates>
          <Dates>
            <Date>2016-08-03</Date>
            <Date>2017-08-03</Date>
            <Date>2018-08-03</Date>
          </Dates>
        </Dates>
      </ScheduleData>
      <ConversionRatios>
        <ConversionRatio>0.05</ConversionRatio>
      </ConversionRatios>
      <ContingentConversion>
        <Observations>
          <Observation>StartOfPeriod</Observation>
        </Observations>
        <Barriers>
          <Barrier>1.3</Barrier>
        </Barriers>
      </ContingentConversion>
      <Underlying>
        <Type>Equity</Type>
        <Name>RIC:.ABCD</Name>
      </Underlying>
    </ConversionData>
```

</div>

<div class="listing">

``` xml
  <!-- American converion between 2016-08-03 and 2018-08-03 with CR 0.5.
       Mandatory conversion on 2020-08-03:
       LowerConversionRatio applies if stock price < LowerBarrier,
       UpperConversionRatio applies if stock price > UpperBarrier -->
    <ConversionData>
      <Styles>
        <Style>American</Style>
      </Styles>
      <ScheduleData>
        <Dates>
          <Dates>
            <Date>2016-08-03</Date>
            <Date>2018-08-03</Date>
          </Dates>
        </Dates>
      </ScheduleData>
      <ConversionRatios>
        <ConversionRatio>0.05</ConversionRatio>
      </ConversionRatios>
      <MandatoryConversion>
        <Date>2020-08-03</Date>
        <Type>PEPS</Type>
        <PepsData>
          <UpperBarrier>32.5</UpperBarrier>
          <LowerBarrier>20.5</LowerBarrier>
          <UpperConversionRatio>0.08</UpperConversionRatio>
          <LowerConversionRatio>0.03</LowerConversionRatio>
        </PepsData>
      </MandatoryConversion>
      <Underlying>
        <Type>Equity</Type>
        <Name>RIC:.ABCD</Name>
      </Underlying>
    </ConversionData>
```

</div>

<div class="listing">

``` xml
  <!-- American conversion between 2016-08-03 and 2018-08-03 with CR 0.5.
       The conversion ratio is reset on 2016-11-03, 2017-02-03, 2018-05-03
       using T = 0.9, g = 0.8, f = 0.6, F = 0.6. -->
    <ConversionData>
      <Styles>
        <Style>American</Style>
      </Styles>
      <ScheduleData>
        <Dates>
          <Dates>
            <Date>2016-08-03</Date>
            <Date>2018-08-03</Date>
          </Dates>
        </Dates>
      </ScheduleData>
      <ConversionRatios>
        <ConversionRatio>0.05</ConversionRatio>
      </ConversionRatios>
      <ConversionResets>
        <ScheduleData>
          <Dates>
            <Dates>
              <Date>2016-11-03</Date>
              <Date>2017-02-03</Date>
              <Date>2018-05-03</Date>
            </Dates>
          </Dates>
        </ScheduleData>
        <References>
          <Reference>InitialConversionPrice</Reference>
        </References>
        <Thresholds>
          <Threshold>0.9</Threshold>
        </Thresholds>
        <Gearings>
          <Gearing>0.8</Gearing>
        </Gearings>
        <Floors>
          <Floor>0.7</Floor>
        </Floors>
        <GlobalFloors>
          <GlobalFloor>15</GlobalFloor>
        </GlobalFloors>
      </ConversionResets>
      <Underlying>
        <Type>Equity</Type>
        <Name>RIC:.ABCD</Name>
      </Underlying>
    </ConversionData>
```

</div>

<div class="listing">

``` xml
  <!-- American conversion between 2024-08-24 and 2027-05-13, with
       conversion to 0.87 GBP cash for 2024-08-24 through 2024-11-23 (excl) and
       conversion to 0.75 GBP cash for 2024-11-23 through 2027-05-13 -->
    <ConversionData>
      <Styles>
        <Style>American</Style>
      </Styles>
      <ScheduleData>
        <Dates>
          <Dates>
            <Date>2024-08-24</Date>
            <Date>2024-11-23</Date>
            <Date>2027-05-13</Date>
          </Dates>
        </Dates>
      </ScheduleData>
      <FixedAmountConversion>
        <Currency>GBP</Currency>
        <Amounts>
          <Amount>0.87</Amount>
          <Amount startDate="2024-11-24">0.75</Amount>
        </Amounts>
      </FixedAmountConversion>
    </ConversionData>
```

</div>

<u>Specification of DividendProtectionData:</u>

As for the CallData, all lists can be specified as either an explicit
list of values corresponding to the schedule dates list or using the
attribute `startDate`.

See listings
<a href="#lst:convertiblebonddata_divprot_1" data-reference-type="ref"
data-reference="lst:convertiblebonddata_divprot_1">[lst:convertiblebonddata_divprot_1]</a>,
<a href="#lst:convertiblebonddata_divprot_2" data-reference-type="ref"
data-reference="lst:convertiblebonddata_divprot_2">[lst:convertiblebonddata_divprot_2]</a>
for examples of dividend protection schedules.

- ScheduleData: The dates of the dividend protection schedule. The first
  date marks the date when the dividend protection becomes effective,
  i.e. dividend payments from this date on are taken into account in
  conversion ratio adjustments or passthroughs. The second date is then
  the first date on which the accumulated dividends between the first
  and second date trigger a conversion ratio reset or passthrough, and
  similar for all subsequent dates. The last given date is the last date
  with a conversion ratio reset or passthrough.  
  Allowable values: see
  <a href="#ss:schedule_data" data-reference-type="ref"
  data-reference="ss:schedule_data">[ss:schedule_data]</a>.

- AdjustmentStyles: Whether the dividend excessing the threshold is
  passed through or the conversion ratio is adjusted. In both cases, the
  adjustment can be upwards only or up and down.  
  Allwoable values: CrUpOnly, CrUpDown, CrUpOnly2, CrUpDown2,
  PassThroughUpOnly, PassThroughUpDown

- DividendTypes: Whether the conversion ratio adjustment is calculated
  in terms of absolute or relative dividends. Does not have an effect
  for pass through dividends (should be set to Absolute in this case).  
  Allwoable values: Absolute, Relative

- Thresholds: The threshold $H$. Notice that the threshold applies to
  each single period of the dividend protection schedule. If the
  threshold is e.g. provided on an annual basis in the terms of the
  convertible bond, but the dividend protection schedule is quarterly,
  then the threshold in the trade xml should be the annual threshold
  divided by $4$.  
  Allwoable values: Any non-negativee number.

<div class="listing">

``` xml
  <!-- Dividend protection based on absolute dividend amounts via adjustment
       of the conversion rate, up-only adjustment. -->
    <DividendProtectionData>
      <ScheduleData>
        <Dates>
          <Dates>
            <Date>2016-08-03</Date>
            <Date>2017-08-03</Date>
            <Date>2018-08-03</Date>
            <Date>2019-08-03</Date>
          </Dates>
        </Dates>
      </ScheduleData>
      <AdjustmentStyles>
        <AdjustmentStyle>CrUpOnly</AdjustmentStyle>
      </AdjustmentStyles>
      <DividendTypes>
        <DividendType>Absolute</DividendType>
      </DividendTypes>
      <Thresholds>
        <Threshold>1.2</Threshold>
      </Thresholds>
    </DividendProtectionData>
```

</div>

<div class="listing">

``` xml
  <!-- Dividend protection based on relative dividend amounts via adjustment
       of the conversion rate, up-only adjustment. -->
    <DividendProtectionData>
      <ScheduleData>
        <Dates>
          <Dates>
            <Date>2016-08-03</Date>
            <Date>2017-08-03</Date>
            <Date>2018-08-03</Date>
            <Date>2019-08-03</Date>
          </Dates>
        </Dates>
      </ScheduleData>
      <AdjustmentStyles>
        <AdjustmentStyle>CrUpOnly</AdjustmentStyle>
      </AdjustmentStyles>
      <DividendTypes>
        <DividendType>Relative</DividendType>
      </DividendTypes>
      <Thresholds>
        <Threshold>0.01</Threshold>
      </Thresholds>
    </DividendProtectionData>
```

</div>

---

### CPI Swap

A CPI inflation swap can be set up using the *InflationSwap* trade type,
with one leg of type `CPI`. and the other leg(s) can be of any leg type.
Listing <a href="#lst:cpiinflationswap" data-reference-type="ref"
data-reference="lst:cpiinflationswap">[lst:cpiinflationswap]</a> shows
an example. The CPI leg contains an additional `CPILegData` block. See
<a href="#ss:cpilegdata" data-reference-type="ref"
data-reference="ss:cpilegdata">[ss:cpilegdata]</a> for details on the
CPI leg specification.

Note that Cross Currency Inflation Swaps are supported, as the
currencies on the legs of an *InflationSwap* do not need to be the same.

<div class="listing">

``` xml
    <InflationSwapData>
      <LegData>
        <LegType>Floating</LegType>
        <Payer>true</Payer>
        ...
      </LegData>
      <LegData>
        <LegType>CPI</LegType>
        <Payer>false</Payer>
        ...
        <CPILegData>
        ...
        </CPILegData>
      </LegData>
    </InflationSwapData>
```

</div>

Alternatively, a CPI swap can be set up as a swap with trade type
*Swap*, with one leg of type `CPI`, see listing
<a href="#lst:cpiswap" data-reference-type="ref"
data-reference="lst:cpiswap">[lst:cpiswap]</a>.

<div class="listing">

``` xml
    <SwapData>
      <LegData>
        <LegType>Floating</LegType>
        <Payer>true</Payer>
        ...
      </LegData>
      <LegData>
        <LegType>CPI</LegType>
        <Payer>false</Payer>
        ...
        <CPILegData>
        ...
        </CPILegData>
      </LegData>
    </SwapData>
```

</div>

---

### Credit Default Swap / Quanto Credit Default Swap

A credit default swap, trade type `CreditDefaultSwap`, is set up using a
`CreditDefaultSwapData` block as shown in listing
<a href="#lst:cdsdata" data-reference-type="ref"
data-reference="lst:cdsdata">[lst:cdsdata]</a> or
<a href="#lst:cdsdata_with_ref_info" data-reference-type="ref"
data-reference="lst:cdsdata_with_ref_info">[lst:cdsdata_with_ref_info]</a>.
The `CreditDefaultSwapData` block must include either a `CreditCurveId`
element or a `ReferenceInformation` node.

The `LegData` sub-node must be a fixed leg, and represents the recurring
premium payments. The direction of the fixed leg payments define if the
CDS is for bought (`Payer`: *true*) or sold (`Payer`: *false*)
protection.

The elements have the following meaning:

- IssuerId \[Optional\]: An identifier for the reference entity of the
  CDS. For informational purposes and not used for pricing.

- CreditCurveId: The identifier of the reference entity defining the
  default curve used for pricing. For the allowable values, see
  `CreditCurveId` for credit trades - single name in Table
  <a href="#tab:equity_credit_data" data-reference-type="ref"
  data-reference="tab:equity_credit_data">[tab:equity_credit_data]</a>.
  A `ReferenceInformation` node may be used in place of this
  `CreditCurveId` node.

- ReferenceInformation: This node may be used as an alternative to the
  `CreditCurveId` node to specify the reference entity, tier, currency
  and documentation clause for the CDS. This in turn defines the credit
  curve used for pricing. The `ReferenceInformation` node is described
  in further detail in Section
  <a href="#ss:cds_reference_information" data-reference-type="ref"
  data-reference="ss:cds_reference_information">[ss:cds_reference_information]</a>.

- SettlesAccrual \[Optional\]: Whether or not the accrued coupon is due
  in the event of a default. This defaults to `true` if not provided.

  Allowable values: Boolean node, allowing *Y, N, 1, 0, true, false*
  etc. The full set of allowable values is given in Table
  <a href="#tab:boolean_allowable" data-reference-type="ref"
  data-reference="tab:boolean_allowable">[tab:boolean_allowable]</a>.

- ProtectionPaymentTime \[Optional\]: Controls the payment time of
  protection and premium accrual payments in case of a default event.
  Defaults to `atDefault`.

  Allowable values: `atDefault`, `atPeriodEnd`, `atMaturity`. Overrides
  the `PaysAtDefaultTime` node

- PaysAtDefaultTime \[Deprecated\]: *true* is equivalent to
  ProtectionPaymentTime = atDefault, *false* to ProtectionPaymentTime =
  atPeriodEnd. Overridden by the `ProtectionPaymentTime` node if set

  Allowable values: Boolean node, allowing *Y, N, 1, 0, true, false*
  etc. The full set of allowable values is given in Table
  <a href="#tab:boolean_allowable" data-reference-type="ref"
  data-reference="tab:boolean_allowable">[tab:boolean_allowable]</a>.

- ProtectionStart \[Optional\]: The first date where a credit event will
  trigger the contract. This defaults to the first date in the schedule
  if it is not provided. Must be set to a date before or on the first
  date in the schedule if the `LegData` has a rule that is not one of
  `CDS` or `CDS2015`. In general, for standard CDS traded after the CDS
  Big Bang in 2009, the protection start date is equal to the trade
  date. Therefore, typically the `ProtectionStart` should be set to the
  trade date of the CDS.

- UpfrontDate \[Optional\]: Settlement date for the UpfrontFee if an
  UpfrontFee is provided. If an UpfrontFee is provided and it is
  non-zero, `UpfrontDate` is required. The `UpfrontDate`, if provided,
  must be on or after the ProtectionStart date. Typically, it is 3
  business days after the CDS contract trade date.

- UpfrontFee \[Optional\]: The upfront payment, expressed as a
  percentage in decimal form, to be multiplied by notional amount. If an
  UpfrontDate is provided, an UpfrontFee must also be provided. The
  UpfrontFee can be omitted but cannot be left blank. The UpfrontFee can
  be negative. The UpfrontFee is treated as an amount payable by the
  protection buyer to the protection seller. A negative value for the
  UpfrontFee indicates that the UpfrontFee is being paid by the
  protection seller to the protection buyer.

  Allowable values: Any real number, expressed in decimal form as a
  percentage of the notional. E.g. an UpfrontFee of *0.045* and a
  notional of 10M, would imply an upfront fee amount of 450K.

- FixedRecoveryRate \[Optional\]: This node holds the fixed recovery
  rate if the CDS is a fixed recovery CDS. For a standard CDS, this
  field should be omitted.

- TradeDate \[Optional\]: The CDS trade date. If omitted, the trade date
  is deduced from the protection start date. If the schedule provided in
  the `LegData` has a rule that is either `CDS` or `CDS2015`, the trade
  date is set equal to the protection start date. This is the standard
  for CDS traded after the CDS Big Bang in 2009. Otherwise, the trade
  date is set equal to the protection start date minus 1 day as it was
  standard before the CDS Big Bang to have protection starting on the
  day after the trade date.

- CashSettlementDays \[Optional\]: The number of business days between
  the trade date and the cash settlement date. For standard CDS, this is
  3 business days. If omitted, this defaults to 3.

- RebatesAccrual \[Optional\]: The protection seller pays the accrued
  scheduled current coupon at the start of the contract. The rebate date
  is not provided but computed to be two days after protection start.
  This defaults to `true` if not provided.

  Allowable values: Boolean node, allowing *Y, N, 1, 0, true, false*
  etc. The full set of allowable values is given in Table
  <a href="#tab:boolean_allowable" data-reference-type="ref"
  data-reference="tab:boolean_allowable">[tab:boolean_allowable]</a>.

The `LegData` block then defines the CDS premium leg structure. This
premium leg must be be of type `Fixed` as described in Section
<a href="#ss:fixedleg_data" data-reference-type="ref"
data-reference="ss:fixedleg_data">[ss:fixedleg_data]</a>.

<div class="listing">

``` xml
    <CreditDefaultSwapData>
      <IssuerId>CPTY_A</IssuerId>
      <CreditCurveId>RED:008CA0|SNRFOR|USD|MR14</CreditCurveId>
      <SettlesAccrual>Y</SettlesAccrual>
      <ProtectionPaymentTime>atDefault</ProtectionPaymentTime>
      <ProtectionStart>20160206</ProtectionStart>
      <UpfrontDate>20160208</UpfrontDate>
      <UpfrontFee>0.0</UpfrontFee>
      <LegData>
            <LegType>Fixed</LegType>
            <Payer>false</Payer>
            ...
      </LegData>
    </CreditDefaultSwapData>
```

</div>

<div class="listing">

``` xml
<CreditDefaultSwapData>
  <ReferenceInformation>
    <ReferenceEntityId>RED:008CA0</ReferenceEntityId>
    <Tier>SNRFOR</Tier>
    <Currency>USD</Currency>
    <DocClause>MR14</DocClause>
  </ReferenceInformation>
  <LegData>
    ...
  </LegData>
</CreditDefaultSwapData>
```

</div>

A quanto credit default swap is a credit default swap with different
denomination and settlement currencies. Listing
<a href="#lst:quanto_cds" data-reference-type="ref"
data-reference="lst:quanto_cds">[lst:quanto_cds]</a> shows an Example:
The trade has a notional of 50 million BRL and pays a $6\%$ premium. The
premuim amounts are converted using the FX-TR20H-USD-BRL fixing two days
before they are settled in USD. The hypothetical protection amounts
computed for pricing purposes are converted to USD in a similar fashion.

<div class="listing">

``` xml
    <LegData>
      <LegType>Fixed</LegType>
      <Payer>true</Payer>
      <!-- This is the settlement currency -->
      <Currency>USD</Currency>
      <!-- This is the BRL notional -->
      <Notionals>
        <Notional>50000000</Notional>
      </Notionals>
      <!-- The FX index used to convert BRL amounts to the settlement ccy USD -->
      <Indexings>
        <Indexing>
          <Index>FX-TR20H-USD-BRL</Index>
          <FixingDays>2</FixingDays>
          <FixingCalendar>USD,BRL</FixingCalendar>
          <IsInArrears>true</IsInArrears>
        </Indexing>
      </Indexings>
      ...
      <FixedLegData>
        <Rates>
          <Rate>0.06</Rate>
        </Rates>
      </FixedLegData>
     ...
    </LegData>
```

</div>

---

### Credit Linked Swap

A credit linked swap, trade type `CreditLinkedSwap`, is set up using a
`CreditLinkedSwapData` block as shown in listing
<a href="#lst:creditlinkedswap" data-reference-type="ref"
data-reference="lst:creditlinkedswap">[lst:creditlinkedswap]</a>. The
elements have the following meaning:

- CreditCurveId: The referenced CDS credit curve.  
  Allowable values: See `CreditCurveId` for credit trades - single name
  in Table <a href="#tab:equity_credit_data" data-reference-type="ref"
  data-reference="tab:equity_credit_data">[tab:equity_credit_data]</a>.
  A `ReferenceInformation` node may be used in place of this
  `CreditCurveId` node.

- SettlesAccrual \[Optional\]: A flag indicating whether accrued coupon
  amounts are paid in case of a credit event. Optional, defaults to
  `true`. Applies to the payments specified under ContingentPayments.  
  Allowable values: true, false

- FixedRecoveryRate \[Optional\]: A fixed (digital) recovery rate to
  apply. If not given, the market recovery rate is used. Applies to the
  payments specified under DefaultPayments and RecoveryPayments.  
  Allowable values: Any non-negative real number.

- DefaultPaymentTime \[Optional\]: Controls the timing of the payments
  specified under DefaultPayments and RecoveryPayments. Defaults to
  `atDefault`.  
  Allowable values: `atDefault`, `atPeriodEnd`, `atMaturity`.

- IndependentPayments \[Optional\]: The legs for which payments are made
  independent from credit events. The node contains one or more
  `LegData` subnodes representing these legs. Optional, can be omitted
  if no such payments are made.  
  Allowable values: See <a href="#ss:leg_data" data-reference-type="ref"
  data-reference="ss:leg_data">[ss:leg_data]</a> for the `LegData`
  subnode structure.

- ContingentPayments \[Optional\]: The legs for which payments are
  contingent on no credit event having occurred until the payment date.
  If no such payments are made, the node can be omitted.  
  Allowable values: See <a href="#ss:leg_data" data-reference-type="ref"
  data-reference="ss:leg_data">[ss:leg_data]</a> for the `LegData`
  subnode structure.

- DefaultPayments \[Optional\]: The legs for which payments are
  contingent on a credit event having occurred. If no such payments are
  made, the node can be omitted. If a default happens at a date d, the
  associated payment is the earliest payment with date greater or equal
  to d.  
  Allowable values: See <a href="#ss:leg_data" data-reference-type="ref"
  data-reference="ss:leg_data">[ss:leg_data]</a> for the `LegData`
  subnode structure.

- RecoveryPayments \[Optional\]: The legs for which payments are
  contingent on a credit event having occurred. The node works
  analogously to the DefaultPayments node, the only difference is that
  payment amounts are weighted by $RR$ instead of $1-RR$.  
  Allowable values: See <a href="#ss:leg_data" data-reference-type="ref"
  data-reference="ss:leg_data">[ss:leg_data]</a> for the `LegData`
  subnode structure.

All legs must be given in the same currency.

<div class="listing">

``` xml
  <CreditLinkedSwapData>
    <CreditCurveId>RED:46A844|SNRFOR|USD|XR14</CreditCurveId>
    <SettlesAccrual>false</SettlesAccrual>
    <FixedRecoveryRate>0.4</FixedRecoveryRate>
    <DefaultPaymentTime>atDefault</DefaultPaymentTime>
    <IndependentPayments>
      <LegData> ... </LegData>
      <LegData> ... </LegData>
      ...
    </IndependentPayments>
    <ContingentPayments>
      <LegData> ... </LegData>
      <LegData> ... </LegData>
      ...
    </ContingentPayments>
    <DefaultPayments>
      <LegData> ... </LegData>
      <LegData> ... </LegData>
      ...
    </DefaultPayments>
    <RecoveryPayments>
      <LegData> ... </LegData>
      <LegData> ... </LegData>
      ...
    </RecoveryPayments>
  </CreditLinkedSwapData>
```

</div>

---

### Cross Currency Swap

A Cross Currency Swap can be represented with either trade type *Swap*
or *CrossCurrencySwap*. In the case of *Swap*, it is set up using a
`SwapData` container. For *CrossCurrencySwap*, we use
`CrossCurrencySwapData` with the same `LegData` sub-nodes within the
container, and it is required for this trade type to have:

- Two legs, each of type *Fixed* or *Floating*, i.e. *Fixed*-*Fixed*,
  *Floating*-*Floating*, *Fixed*-*Floating*, or *Floating*-*Fixed*
  combinations are allowed.

- Optionally additional legs of type *Cashflow*.

**Rebalancing**  
A Cross Currency Swap can be rebalancing, meaning the notional amount on
one leg resets to the equivalent of a fixed amount in another currency
(called ForeignCurrency, and is typically the currency of the other leg)
at each period. This is represented using an `FXReset` node on the
resetting/rebalancing leg, within the `Notionals` node.

Note that for rebalancing Cross Currency Swaps, the Notional in leg
currency on the rebalancing leg is optional. If set, it is used as
starting notional, and causes the first period (if forward starting) to
be considered as "on-the-run" for purposes of SIMM exemptions as the fx
rate for the notional is considered to have been fixed from the
inception of the trade. If no notional on the rebalancing leg is set,
the starting notional will be based on a projected fx rate (i.e. not
"on-the-run") until the actual fixing date.

Also on rebalancing Cross Currency Swaps, the NotionalInitialExchange
and NotionalFinalExchange flags must be set the same way on both legs.

The optional `FXReset` node includes the following elements:

- ForeignCurrency: The foreign currency the notional of the leg resets
  to.

  Allowable values: See Table
  <a href="#tab:currency" data-reference-type="ref"
  data-reference="tab:currency">[tab:currency]</a> Currency.

- ForeignAmount: The notional amount in the foreign currency that the
  notional of the leg resets to.

  Allowable values: Any positive real number.

- FXIndex: A reference to an FX Index source for the FX reset fixing.

  Allowable values: A string of the form FX-SOURCE-CCY1-CCY2. Note that
  the FX- part of the string stays constant for all currency pairs.

  See Table <a href="#tab:fxindex_data" data-reference-type="ref"
  data-reference="tab:fxindex_data">[tab:fxindex_data]</a> for further
  details, including supported FX-pairs for each fixing source.

Listing
<a href="#lst:crosscurrencyswapnonreset" data-reference-type="ref"
data-reference="lst:crosscurrencyswapnonreset">[lst:crosscurrencyswapnonreset]</a>
shows an example of a non-rebalancing *CrossCurrencySwapData* node. Note
that for non-rebalancing Cross Currency Swaps the structure is the same
as for the *Swap* trade type with the only difference being the top node
name as described, i.e. *SwapData*. Rebalancing Cross Currency Swaps,
see example in listing
<a href="#lst:crosscurrencyswapreset" data-reference-type="ref"
data-reference="lst:crosscurrencyswapreset">[lst:crosscurrencyswapreset]</a>,
also include the `FXReset` node, but otherwise also use the same
structure as the *Swap* trade type.

<div class="listing">

``` xml
    <CrossCurrencySwapData>
      <LegData>
        <LegType>Floating</LegType>
        <Payer>true</Payer>
        <Currency>USD</Currency>
        <Notionals>
           <Notional>30000000</Notional>
           <Exchanges>
              <NotionalInitialExchange>true</NotionalInitialExchange>
              <NotionalFinalExchange>true</NotionalFinalExchange>
            </Exchanges>
        </Notionals>
        <DayCounter>ACT/365</DayCounter>
        ...
        <FloatingLegData>
        ...
        </FloatingLegData>
      </LegData>
      <LegData>
        <LegType>Fixed</LegType>
        <Payer>false</Payer>
        <Currency>EUR</Currency>
        <Notionals>
           <Notional>29000000</Notional>
           <Exchanges>
              <NotionalInitialExchange>true</NotionalInitialExchange>
              <NotionalFinalExchange>true</NotionalFinalExchange>
            </Exchanges>
        </Notionals>
        <DayCounter>ACT/365</DayCounter>
        ...
        <FixedLegData>
        ...
        </FixedLegData>
      </LegData>
    </CrossCurrencySwapData>
```

</div>

<div class="listing">

``` xml
    <CrossCurrencySwapData>
      <LegData>
        <LegType>Floating</LegType>
        <Payer>true</Payer>
        <Currency>USD</Currency>
        <Notionals>
           <Notional>30000000</Notional>
           <Exchanges>
              <NotionalInitialExchange>true</NotionalInitialExchange>
              <NotionalFinalExchange>true</NotionalFinalExchange>
            </Exchanges>
        </Notionals>
        <DayCounter>ACT/365</DayCounter>
        ...
        <FloatingLegData>
        ...
        </FloatingLegData>
      </LegData>
      <LegData>
        <LegType>Floating</LegType>
        <Payer>false</Payer>
        <Currency>JPY</Currency>
        <Notionals>
           <Notional>4381340000</Notional> (in JPY)
           <FXReset>
              <ForeignCurrency>USD</ForeignCurrency>
              <ForeignAmount>30000000</ForeignAmount> (in USD)
              <FXIndex>FX-TR20H-USD-JPY</FXIndex>
           </FXReset>
           <Exchanges>
              <NotionalInitialExchange>true</NotionalInitialExchange>
              <NotionalFinalExchange>true</NotionalFinalExchange>
            </Exchanges>
        </Notionals>
        <DayCounter>ACT/365</DayCounter>
        ...
        <FloatingLegData>
        ...
        </FloatingLegData>
      </LegData>
    </CrossCurrencySwapData>
```

</div>

**Non-Deliverable**  
Note that Cross Currency Swaps having legs in non-deliverable currencies
with payment in a deliverable currency are supported by using the
Indexings node (<a href="#ss:indexings" data-reference-type="ref"
data-reference="ss:indexings">[ss:indexings]</a>), setting Settlement to
*Cash* and setting the Currency to the deliverable currency, while
keeping the Notional expressed in the non-deliverable currency amount.

The Indexings node includes a mandatory fx Index field defining the
deliverable and non-deliverable currency pair, and an optional
InitialNotionalFixing field for the contractual fx rate to be applied to
the initial notional exchange. Notice that the InitialNotionalFixing
rate has to be expressed as amount in deliverable or payment currency
per unit of non-deliverable currency, and if omitted defaults to a
projected (if in the future) or an fx fixing from market data (if in the
past). The Indexing node can also include optional FixingCalendar,
IsInArrears and FixingDays fields to determine the date(s) of the fx
fixing(s).

Listing <a href="#lst:ndir_xccy_swap" data-reference-type="ref"
data-reference="lst:ndir_xccy_swap">[lst:ndir_xccy_swap]</a> includes an
example USD-CLP non-deliverable cross currency swap where one leg is in
CLP which is a non-deliverable currency, and the other is in USD which
is deliverable. Note that it is possible for both legs to be in
different non-deliverable currencies.

<div class="listing">

``` xml
<SwapData>
  <Settlement>Cash</Settlement>
  <LegData>
   <LegType>Floating</LegType>
   <Payer>false</Payer>
   <Currency>USD</Currency>
    <Notionals>
     <Notional>1000000</Notional>
      <Exchanges>
       <NotionalInitialExchange>true</NotionalInitialExchange>
       <NotionalFinalExchange>true</NotionalFinalExchange>
      </Exchanges>
    </Notionals>
    ...
  </LegData>
  <LegData>
   <LegType>Floating</LegType>
   <Payer>false</Payer>
   <Currency>USD</Currency><!-- Payment currency is USD rather than CLP -->
    <Notionals>
     <Notional>850000000</Notional><!-- in CLP -->
      <Exchanges>
       <NotionalInitialExchange>true</NotionalInitialExchange>
       <NotionalFinalExchange>true</NotionalFinalExchange>
      </Exchanges>
     </Notionals>
     <Indexings>
      <Indexing>
    <Index>FX-TR20H-CLP-USD</Index><!-- to convert CLP flows into USD -->
    <FixingCalendar>CLP,USD</FixingCalendar>
        <IsInArrears>true</IsInArrears>
        <FixingDays>2</FixingDays>
        <InitialNotionalFixing>0.15</InitialNotionalFixing><!-- applied to initial ntl exchange -->
      </Indexing>
     </Indexings>
    ...
  </LegData>
</SwapData>
```

</div>

---

### Double Digital Option

The `DoubleDigitalOptionData` node is the trade data container for the
DoubleDigitalOption trade type, listing
<a href="#lst:doubledigitaloption_data" data-reference-type="ref"
data-reference="lst:doubledigitaloption_data">[lst:doubledigitaloption_data]</a>
shows the structure of an example with two underlying FX rates. Equity,
Commodity and IR underlyings are also supported in arbitrary
combinations. A double digital option is a binary option that pays out a
fixed amount if the two underlyings (FX spots, Equity or Commodity
prices, interest rates) are simultaneously in the money w.r.t. given
strikes and option types at the option expiry.

<div class="listing">

``` xml
    <DoubleDigitalOptionData>
      <Expiry>2021-09-01</Expiry>
      <Settlement>2021-09-03</Settlement>
      <BinaryPayout>12000000</BinaryPayout>
      <BinaryLevel1>1.1</BinaryLevel1>
      <BinaryLevel2>0.006</BinaryLevel2>
      <BinaryLevelUpper2>0.008</BinaryLevelUpper2>
      <Type1>Call</Type1>
      <Type2>Collar</Type2>
      <Position>Long</Position>
      <Underlying1>
        <Type>FX</Type>
        <Name>ECB-EUR-USD</Name>
      </Underlying1>
      <Underlying2>
        <Type>FX</Type>
        <Name>ECB-JPY-USD</Name>
      </Underlying2>
      <PayCcy>USD</PayCcy>
    </DoubleDigitalOptionData>
```

</div>

The meanings and allowable values of the elements in the
`DoubleDigitalOptionData` node follow below.

- Expiry: The expiry date of the option. Allowable values are valid
  dates.

- Settlement: The payout settlement date. Allowable values are valid
  dates.

- BinaryPayout: The amount that is paid if the option is in the money.
  Allowable values are all non-negative numbers.

- BinaryLevel1: The strike for underlying 1 for *Call* or *Put* option
  and the lower bound for a *Collar* option. For an FX underlying
  (SOURCE-CCY1-CCY2) this is the number of units of CCY2 per units of
  CCY1. For an Equity underlying this is the equity price expressed in
  the equity ccy. For a Commodity underlying this is the commodity price
  expressed in the commodity ccy. For an IR underlying this is the rate
  expressed in decimal form. Allowable values are non-negative numbers.

- BinaryLevel2: The strike for underlying 2 for *Call* or *Put* option
  and the lower bound for a *Collar*. For an FX underlying
  (SOURCE-CCY1-CCY2) this is the number of units of CCY2 per units of
  CCY1. For an Equity underlying this is the equity price expressed in
  the equity ccy. For a Commodity underlying this is the commodity price
  expressed in the commodity ccy. For an IR underlying this is the rate
  expressed in decimal form. Allowable values are non-negative numbers.

- Type1: The option type that applies to underlying 1. Allowable values:
  *Call*, *Put* or *Collar*. Underlying 1 is considered to be in the
  money if the spot is above (Call) / below (Put) the BinaryLevel1 resp.
  between (Collar) the BinaryLevel1 and BinaryLevelUpper1 at the expiry.

- Type2: The option type that applies to underlying 2. Allowable values:
  *Call*, *Put* or *Collar*. Underlying 2 is considered to be in the
  money if the spot is above (Call) / below (Put) the BinaryLevel1 resp.
  between (Collar) the BinaryLevel2 andthe BinaryLevelUpper2 at the
  expiry.

- Position: The option position type. Allowable values: *Long* or
  *Short*.

- Underlying1: The first underlying, see
  <a href="#ss:underlying" data-reference-type="ref"
  data-reference="ss:underlying">[ss:underlying]</a>.

- Underlying2: The second underlying, see
  <a href="#ss:underlying" data-reference-type="ref"
  data-reference="ss:underlying">[ss:underlying]</a>. Note that Type for
  both underlyings has allowable values *Equity*, *Commodity*, *FX*, and
  *IR*.

- Underlying3 \[Optional\]: If defined, the first underlying in this
  transaction is treated as a spread between Underlying1 and Underlying3
  (i.e. Underlying1 fixing minus Underlying3 fixing), see
  <a href="#ss:underlying" data-reference-type="ref"
  data-reference="ss:underlying">[ss:underlying]</a>. Underlying3 Type
  must be the same as Underlying1 Type.

- Underlying4 \[Optional\]: If defined, the second underlying in this
  transaction is treated as a spread between Underlying2 and Underlying4
  (i.e. Underlying2 fixing minus Underlying4 fixing), see
  <a href="#ss:underlying" data-reference-type="ref"
  data-reference="ss:underlying">[ss:underlying]</a>. Underlying4 Type
  must be the same as Underlying2 Type.

- PayCcy: The currency in which the `BinaryPayout` is paid. See Table
  <a href="#tab:currency" data-reference-type="ref"
  data-reference="tab:currency">[tab:currency]</a> for allowable
  currency codes.

- BinaryLevelUpper1 \[Optional\]: This is field is used only for Collar
  option. The upper bound for underlying 1. For an FX underlying
  (SOURCE-CCY1-CCY2) this is the number of units of CCY2 per units of
  CCY1. For an Equity underlying this is the equity price expressed in
  the equity ccy. For a Commodity underlying this is the commodity price
  expressed in the commodity ccy. For an IR underlying this is the rate
  expressed in decimal form. Allowable values are non-negative numbers.

- BinaryLevelUpper2 \[Optional\]: This field is used only for Collar
  option. The upper bound for underlying 2. For an FX underlying
  (SOURCE-CCY1-CCY2) this is the number of units of CCY2 per units of
  CCY1. For an Equity underlying this is the equity price expressed in
  the equity ccy. For a Commodity underlying this is the commodity price
  expressed in the commodity ccy. For an IR underlying this is the rate
  expressed in decimal form. Allowable values are non-negative numbers.

---

### EQ Accumulator

EQ Accumulators are represented as scripted trades, refer to appendix A
for an introduction. Listing
<a href="#lst:eqaccumulator" data-reference-type="ref"
data-reference="lst:eqaccumulator">[lst:eqaccumulator]</a> shows the
structure of an example. The `PerformanceOption_01` node is the trade
data container for the PerformanceOption_01 trade type, listing
<a href="#lst:eqaccumulator" data-reference-type="ref"
data-reference="lst:eqaccumulator">[lst:eqaccumulator]</a> shows the
structure of an example.

<div class="listing">

``` xml
<Trade id="SCRIPTED_EQ_ACCUMULATOR">
  <TradeType>ScriptedTrade</TradeType>
  <Envelope>
    <CounterParty>CPTY_A</CounterParty>
    <NettingSetId>CPTY_A</NettingSetId>
    <AdditionalFields/>
  </Envelope>
  <AccumulatorData>
    <Strike type="number">12.24</Strike>
    <FixingAmount type="number">775</FixingAmount>
    <LongShort type="longShort">Long</LongShort>
    <Underlying type="index">EQ-Lufthansa</Underlying>
    <PayCcy type="currency">EUR</PayCcy>
    <FixingDates type="event">
      <ScheduleData>
        <Dates>
          <Dates>
            <Date>2021-01-29</Date>
          </Dates>
        </Dates>
      </ScheduleData>
      <ApplyCoarsening>true</ApplyCoarsening>
    </FixingDates>
    <RangeUpperBounds type="number">
      <Value>10000</Value>
    </RangeUpperBounds>
    <RangeLowerBounds type="number">
      <Value>0</Value>
    </RangeLowerBounds>
    <RangeLeverages type="number">
      <Value>1</Value>
    </RangeLeverages>
    <KnockOutLevel type="number">1000</KnockOutLevel>
    <GuaranteedFixings type="number">1</GuaranteedFixings> 
  </AccumulatorData>
</Trade>
```

</div>

The meanings and allowable values of the elements in the
`EQ Accumulator` representation follow below.

- Strike: The strike value the equity is purchased at.

- FixedAmount: The unleveraged quantity accumulated at each fixing date

- LongShort: 1 for a long, -1 for a short position

- Underlying: The underlying EQ Index. This must be of the form
  "EQ-NAME"

- PayCcy: The payment currency of the trade

- FixingDates: The fixing dates, given as a ScheduleData node

- RangeUpperBound: Values of upperbounds for the leverage ranges. If a
  given range has no upperbound add 100000

- RangeLowerBound: Values of lowerbounds for the leverage ranges. If a
  given range has no lowerbound add 0

- RangeLeverages: Values of leverages for the leverage ranges.

- KnockOutLevel: The KnockOut Barrier level

- GuaranteedFixings: Number of the first n Fixings that are guaranteed,
  regardless of whether or not the trade has been knocked out.

The script ‘Accumulator’ referenced in the trade above is shown in
Listing <a href="#lst:accumulator_script" data-reference-type="ref"
data-reference="lst:accumulator_script">[lst:accumulator_script]</a>.

<div class="listing">

``` xml

NUMBER Payoff, fix, d, r, Triggered;
Payoff = 0;
Triggered = -1;
FOR d IN (1, SIZE(FixingDates)) DO
    fix = Underlying(FixingDates[d]);
    
    IF fix >= KnockOutLevel THEN
      Triggered = 1;
    END;
    IF Triggered != 1 OR d <= GuaranteedFixings THEN
        FOR r IN (1, SIZE(RangeUpperBounds)) DO
            IF fix > RangeLowerBounds[r] AND fix <= RangeUpperBounds[r] THEN
                Payoff = Payoff + PAY(RangeLeverages[r] * FixingAmount * (fix - Strike), FixingDates[d], FixingDates[d], PayCcy);
            END;
        END;
    END;
END;
value = LongShort * Payoff;
```

</div>

---

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

---

### Equity Barrier Option

European exercise, American barrier.

An Equity Barrier Option is a path-dependent option whose existence
depends upon an Equity underlying spot price reaching a pre-set barrier
level. Exercise is European.

This product has a continuously monitored single barrier (American
Barrier style) with a Vanilla European Equity Option Underlying.

The `EquityBarrierOptionData` node is the trade data container for the
*EquityBarrierOption* trade type. The barrier level of an Equity Barrier
Option should be quoted in the currency of the underlying Equity spot
price. The `EquityBarrierOptionData` node includes one `OptionData`
trade component sub-node and one `BarrierData` trade component sub-node
plus elements specific to the Equity Barrier Option.

The structure of an example `EquityBarrierOptionData` node for an Equity
Barrier Option is shown in Listing
<a href="#lst:eqbarrieroption_data" data-reference-type="ref"
data-reference="lst:eqbarrieroption_data">[lst:eqbarrieroption_data]</a>.

<div class="listing">

``` xml
        <EquityBarrierOptionData>
            <OptionData>
                ...
            </OptionData>
            <BarrierData>
                ...
            </BarrierData>
            <StartDate>2025-01-25</StartDate>
            <Calendar>TARGET</Calendar>
            <EQIndex>EQ-RIC:.SPX</EQIndex>            
            <Name>RIC:.SPX</Name>
            <StrikeData>
            <StrikePrice>
             <Value>3200.00</Value>
             <Currency>USD</Currency>
            </StrikePrice>
            </StrikeData>
            <Quantity>1000</Quantity>
            <Currency>USD</Currency>
        </EquityBarrierOptionData>
```

</div>

The meanings and allowable values of the elements in the
`EquityBarrierOptionData` node follow below.

- OptionData: This is a trade component sub-node outlined in section
  <a href="#ss:option_data" data-reference-type="ref"
  data-reference="ss:option_data">[ss:option_data]</a>. Note that the
  Equity Barrier Option type allows for *European* option style only.

- BarrierData: This is a trade component sub-node outlined in section
  <a href="#ss:barrier_data" data-reference-type="ref"
  data-reference="ss:barrier_data">[ss:barrier_data]</a>. Level
  specified in BarrierData should be quoted in the same currency with
  the underlying Equity spot price. Changing the option from Call to Put
  or vice versa does not require switching the barrier level.

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

  Allowable values: The format of the Equity Index is“EQ-RIC:Code”.

- Underlying: This node may be used as an alternative to the `Name` node
  to specify the underlying equity. This in turn defines the equity
  curve used for pricing. The `Underlying` node is described in further
  detail in Section <a href="#ss:underlying" data-reference-type="ref"
  data-reference="ss:underlying">[ss:underlying]</a>.

- StrikeData: A node containing the strike in `Value` and the currency
  in which both the underlying and the strike are quoted in `Currency`.
  I.e. compo options with strike currency not equal to underlying equity
  currency are not supported for this trade type.

  Allowable values: Only supports `StrikePrice` as described in Section
  <a href="#ss:strikedata" data-reference-type="ref"
  data-reference="ss:strikedata">[ss:strikedata]</a>.

- Quantity: The number of units of the underlying covered by the
  transaction.

  Allowable values: Any positive real number.

- Currency: The payment currency of the trade.

  Allowable values: See `Currency` and `Minor Currencies` in Table
  <a href="#tab:allow_stand_data" data-reference-type="ref"
  data-reference="tab:allow_stand_data">[tab:allow_stand_data]</a>. This
  should be equal to the underlying equity except for the major / minor
  distinction. I.e. quanto payoffs that are usually identified by
  setting the payment currency to a different currency than the
  underlying equity currency, are not allowed for this trade type.

---

### Equity Digital Option

The `EquityDigitalOptionData` node is the trade data container for the
*EquityDigitalOption* trade type. The `EquityDigitalOptionData` node
includes one `OptionData` trade component sub-node plus elements
specific to the Equity Digital Option. The structure of an example
`EquityDigitalOptionData` node for an Equity Digital Option is shown in
Listing <a href="#lst:eqdigitaloption_data" data-reference-type="ref"
data-reference="lst:eqdigitaloption_data">[lst:eqdigitaloption_data]</a>.

<div class="listing">

``` xml
        <EquityDigitalOptionData>
            <OptionData>
                <LongShort>Long</LongShort>
                <OptionType>Call</OptionType>
                <Style>European</Style>
                <ExerciseDates>
                    <ExerciseDate>2027-02-26</ExerciseDate>
                </ExerciseDates>
                ...
            </OptionData>
            <Strike>3300</Strike>
            <PayoffCurrency>USD</PayoffCurrency>
            <PayoffAmount>1000</PayoffAmount>
            <Name>RIC:.SPX</Name>
            <Quantity>1000</Quantity>
        </EquityDigitalOptionData>
```

</div>

The meanings and allowable values of the elements in the
`EquityDigitalOptionData` node follow below.

- OptionData: This is a trade component sub-node outlined in section
  <a href="#ss:option_data" data-reference-type="ref"
  data-reference="ss:option_data">[ss:option_data]</a>. The relevant
  fields in the `OptionData` node for an EquityDigitalOption are:

  - `LongShort` The allowable values are *Long* or *Short*.

  - `OptionType` The allowable values are *Call* or *Put*. *Call* means
    that the option is in the money when the underlying equity price is
    above the strike, and *Put* means that the option is in the money
    when the underlying equity price is below the strike.

  - `Style` The allowable value is *European*. Note that the Equity
    Digital Option type allows for *European* option style only.

  - An `ExerciseDates` node where exactly one ExerciseDate date element
    must be given.

  - Premiums \[Optional\]: Option premium amounts paid by the option
    buyer to the option seller.

    Allowable values: See section
    <a href="#ss:premiums" data-reference-type="ref"
    data-reference="ss:premiums">[ss:premiums]</a>

- Strike: The option strike price per one unit of the underlying,
  expressed in the currency of the underlying equity .

  Allowable values: Any positive real number.

- PayoffCurrency: The payoff currency of the Equity Digital Option is
  the currency of the payoff amount. Must be consistent with the
  currency of the underlying Equity spot price.

  Allowable values: See Table
  <a href="#tab:currency" data-reference-type="ref"
  data-reference="tab:currency">[tab:currency]</a> `Currency`.

- PayoffAmount: The fixed payoff amount per unit of underlying expressed
  in payoff currency. It is cash-or-nothing payoff that depends on the
  option being in or out of the money.

  Allowable values: Any positive real number.

- Underlying: This node may be used as an alternative to the `Name` node
  to specify the underlying equity. This in turn defines the equity
  curve used for pricing. The `Underlying` node is described in further
  detail in Section <a href="#ss:underlying" data-reference-type="ref"
  data-reference="ss:underlying">[ss:underlying]</a>.

- Quantity: The number of units of the underlying covered by the
  transaction.

  Allowable values: Any positive real number.

---

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

---

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

---

### Equity European Barrier Option

European exercise, European barrier.

An Equity European Barrier Option gives the buyer the right, but not the
obligation, to buy a set number of shares of a single name equity or an
equity index, at a predetermined strike price, at one predetermined time
in the future. This right may be withdrawn depending upon an Eqity spot
price or index reaching a predetermined barrier level at the
predetermined time, the underlying is monitored only at expiry with a
single barrier (European Barrier style).

The `EquityEuropeanBarrierOptionData` node is the trade data container
for the *EquityEuropeanBarrierOption* trade type. The barrier level of
an Equity European Barrier Option is quoted in the currency of the
underlying Equity spot price. The `EquityEuropeanBarrierOptionData` node
includes one `OptionData` trade component sub-node and one `BarrierData`
trade component sub-node plus elements specific to the Equity European
Barrier Option.

The structure of an example `EquityEuropeanBarrierOptionData` node for
an Equity European Barrier Option is shown in Listing
<a href="#lst:eqeuropeanbarrieroption_data" data-reference-type="ref"
data-reference="lst:eqeuropeanbarrieroption_data">[lst:eqeuropeanbarrieroption_data]</a>.

<div class="listing">

``` xml
        <EquityEuropeanBarrierOptionData>
            <OptionData>
                ...
            </OptionData>
            <BarrierData>
                ...
            </BarrierData>
            <Name>RIC:.SPX</Name>
            <StrikeData>
                <StrikePrice>
                    <Value>3200.00</Value>
                    <Currency>USD</Currency>
                </StrikePrice>
            </StrikeData>
            <Quantity>1000</Quantity>>
        </EquityEuropeanBarrierOptionData>
```

</div>

The meanings and allowable values of the elements in the
`EquityEuropeanBarrierOptionData` node follow below.

- OptionData: This is a trade component sub-node outlined in section
  <a href="#ss:option_data" data-reference-type="ref"
  data-reference="ss:option_data">[ss:option_data]</a>. Note that the
  Equity European Barrier Option type allows for *European* option style
  only.

- BarrierData: This is a trade component sub-node outlined in section
  <a href="#ss:barrier_data" data-reference-type="ref"
  data-reference="ss:barrier_data">[ss:barrier_data]</a>. Level
  specified in BarrierData should be quoted in the same currency with
  the underlying Equity spot price. Changing the option from Call to Put
  or vice versa does not require switching the barrier level.

- Underlying: This node may be used as an alternative to the `Name` node
  to specify the underlying equity. This in turn defines the equity
  curve used for pricing. The `Underlying` node is described in further
  detail in Section <a href="#ss:underlying" data-reference-type="ref"
  data-reference="ss:underlying">[ss:underlying]</a>.

- StrikeData: A node containing the strike in `Value` and the currency
  in which both the underlying and the strike are quoted in `Currency`.
  Allowable values: Only supports `StrikePrice` as described in Section
  <a href="#ss:strikedata" data-reference-type="ref"
  data-reference="ss:strikedata">[ss:strikedata]</a>.

- Quantity: The number of units of the underlying covered by the
  transaction.

  Allowable values: Any positive real number.

---

### Equity Outperformance Option

An Equity Outperformance option has a payoff that depends on the
‘outperformance’ of two equity indices (i.e. the difference between
their returns) against a strike return. The buyer has the right but not
the obligation to receive the outperformance in exchange for the strike
rate at a predetermined time in the future.

The trade may optionally have a knockIn or knockOut price (or both).
Only if the price of Underlying2 is above the knockIn value or below the
knockOut value is the payoff paid.

The `EquityOutperformanceOptionData` node is the trade data container
for the *EquityOutperformanceOption* trade type. The
`EquityOutperformanceOptionData` node includes one `OptionData` trade
component sub-node plus elements specific to the Equity Outperformance
Option.

The structure of an example `EquityOutperformanceOptionData` node for an
Equity Outperformace Option is shown in Listing
<a href="#lst:eqoutperformaceoption_data" data-reference-type="ref"
data-reference="lst:eqoutperformaceoption_data">[lst:eqoutperformaceoption_data]</a>.

<div class="listing">

``` xml
        <EquityOutperformanceOptionData>
            <OptionData>
              <LongShort>Long</LongShort>
              <OptionType>Call</OptionType>
              <Style>European</Style>
              <Settlement>Cash</Settlement>
              <ExerciseDates>
                <ExerciseDate>2022-09-21</ExerciseDate>
              </ExerciseDates>
              ...
            </OptionData>
          <Currency>USD</Currency>
          <Notional>500000</Notional>
          <Underlying1>
            <Type>Equity</Type>
            <Name>RIC:.SPX</Name>
          </Underlying1>
          <Underlying2>
            <Type>Equity</Type>
            <Name>RIC:.NDX</Name>
          </Underlying2>
          <InitialPrice1>2140</InitialPrice1>
          <InitialPrice2>13000</InitialPrice2>
          <StrikeReturn>0.01</StrikeReturn>
          <KnockInPrice>12500</KnockInPrice>
          <KnockOutPrice>14000</KnockOutPrice>
        </EquityOutperformanceOptionData>
```

</div>

The Payoff is: $$N\cdot \max(0,R_1-R_2 - K)$$ where:

- $N$ is the notional amount

- $R_1$ is the return of `Underlying1`

- $R_2$ is the return of `Underlying2`

- $K$ is the `StrikeReturn`.

The meanings and allowable values of the elements in the
`EquityOutperformaceOptionData` node follow below.

- OptionData: This is a trade component sub-node outlined in section
  <a href="#ss:option_data" data-reference-type="ref"
  data-reference="ss:option_data">[ss:option_data]</a>. The relevant
  fields in the `OptionData` node for an EquityOutperformanceOption are:

  - `LongShort` The allowable values are *Long* or *Short*.

  - `OptionType` The allowable values are *Call* or *Put*. *Call* means
    that the holder has the right but not obligation to receive the
    Outperformance and pay the StrikeReturn. *Put* means that the holder
    has the right but not obligation to pay the Outperformance and
    receive the StrikeReturn.

  - `Style` The allowable value is *European*. Note that the Equity
    Outperformance Option type allows for *European* option style only.

  - `Settlement` The allowable values are *Cash* or *Physical*.

  - An `ExerciseDates` node where exactly one ExerciseDate date element
    must be given.

  - Premiums \[Optional\]: Option premium amounts paid by the option
    buyer to the option seller.

    Allowable values: See section
    <a href="#ss:premiums" data-reference-type="ref"
    data-reference="ss:premiums">[ss:premiums]</a>

- Currency: The currency of the equity outperformance option.

  Allowable values: See Table
  <a href="#tab:currency" data-reference-type="ref"
  data-reference="tab:currency">[tab:currency]</a> `Currency`.

- Underlying1: Specifies the first underlying equity. This in turn
  defines the equity curve used for pricing. The `Underlying` node is
  described in further detail in Section
  <a href="#ss:underlying" data-reference-type="ref"
  data-reference="ss:underlying">[ss:underlying]</a>. Note that the node
  name is `Underlying1`.

- Underlying2: Specifies the second underlying equity. This in turn
  defines the equity curve used for pricing. The `Underlying` node is
  described in further detail in Section
  <a href="#ss:underlying" data-reference-type="ref"
  data-reference="ss:underlying">[ss:underlying]</a>. Note that the node
  name is `Underlying2`.

  Also note that the equities in Underlying1 and Underlying2 must be
  quoted in the same currency.

- InitialPrice1: Specifies the initial price for first underlying
  equity.

  Allowable values: Any positive real number.

- InitialPrice2: Specifies the initial price for second underlying
  equity.

  Allowable values: Any positive real number.

- StrikeReturn: The option strike return.

  Allowable values: Any positive real number.

- Notional: The notional amount for the trade.

  Allowable values: Any positive real number.

- KnockInPrice\[Optional\]: The payoff is only paid if on the settlement
  date the price of underlying2 is above this value.

  Allowable values: Any positive real number.

- KnockOutPrice\[Optional\]: The payoff is only paid if on the
  settlement date the price of underlying2 is below this value.

  Allowable values: Any positive real number.

- InitialPriceCurrency1 \[Optional\]: Only relevant if InitialPrice1 is
  given in a currency other than Underlying1’s currency.

  Allowable values: See Table
  <a href="#tab:currency" data-reference-type="ref"
  data-reference="tab:currency">[tab:currency]</a> `Currency`.

- InitialPriceCurrency2 \[Optional\]: Only relevant if InitialPrice1 is
  given in a currency other than Underlying2’s currency.

  Allowable values: See Table
  <a href="#tab:currency" data-reference-type="ref"
  data-reference="tab:currency">[tab:currency]</a> `Currency`.

- InitialPriceFXTerms1 \[Mandatory when InitialPriceCurrency1 is
  provided\]: The node must be given if and only if the underlying
  currency is different from the initialPrice currency. The node
  contains the following sub nodes:

  - FXIndex: The fx index to use for the conversion, this must contain
    the underlying asset currency and the funding leg currency (in the
    order defined in table
    <a href="#tab:fxindex_data" data-reference-type="ref"
    data-reference="tab:fxindex_data">[tab:fxindex_data]</a>, i.e. it
    does not matter which one is the asset currency and which is the
    funding currency)

    Allowable values: see
    <a href="#tab:fxindex_data" data-reference-type="ref"
    data-reference="tab:fxindex_data">[tab:fxindex_data]</a>

  - InitialPriceFXTerms2 \[Mandatory when InitialPriceCurrency2 is
    provided\]: The node must be given if and only if the underlying
    currency is different from the initialPrice currency. Contains the
    same subnodes as InitialPriceFXTerms1.

    Allowable values: Any valid calendar, see Table
    <a href="#tab:calendar" data-reference-type="ref"
    data-reference="tab:calendar">[tab:calendar]</a> Calendar. Defaults
    to the *NullCalendar* (no holidays) if left blank or omitted.

---

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

---

### Equity Cliquet Option

The `EquityCliquetOptionData` node is the trade data container for the
*EquityCliquetOption* trade type. A cliquet option consists of a series
of consecutive forward starting equity options, with each option being
struck at a given moneyness (commonly at-the-money) when it becomes
active.

The structure of an example `EquityCliquetOptionData` node for an equity
cliquet option is shown in Listing
<a href="#lst:cliquetoption_data" data-reference-type="ref"
data-reference="lst:cliquetoption_data">[lst:cliquetoption_data]</a>.

<div class="listing">

``` xml
<EquityCliquetOptionData>
    <Underlying>
      <Type>Equity</Type>
      <Name>.SPX</Name>
      <IdentifierType>RIC</IdentifierType>
    </Underlying>
    <Currency>USD</Currency>
    <Notional>1000000.0</Notional>
    <LongShort>Short</LongShort>
    <OptionType>Call</OptionType>
    <Moneyness>1.0</Moneyness>
    <LocalCap>0.07</LocalCap>
    <LocalFloor>-0.06</LocalFloor>
    <GlobalCap>0.07</GlobalCap>
    <GlobalFloor>-0.07</GlobalFloor>
    <ScheduleData>
        <Dates>
            <Dates>
                <Date>20171231</Date>
                <Date>20181231</Date>
                <Date>20191231</Date>
                <Date>20201231</Date>
                <Date>20211231</Date>
                <Date>20221231</Date>
            </Dates>
            <Calendar>USD</Calendar>
            <Convention>F</Convention>
        </Dates>    
    </ScheduleData>
    <SettlementDays>5</SettlementDays>
    <Premium>0.027</Premium>
    <PremiumPaymentDate>31-12-2017</PremiumPaymentDate>
    <PremiumCurrency>USD</PremiumCurrency>
</EquityCliquetOptionData>
```

</div>

The meanings and allowable values of the elements in the
`CliquetOptionData` node below.

- Name: The identifier of the underlying equity or equity index.  
  Allowable values: See `Name` for equity trades in Table
  <a href="#tab:equity_credit_data" data-reference-type="ref"
  data-reference="tab:equity_credit_data">[tab:equity_credit_data]</a>.

- Underlying: This node may be used as an alternative to the `Name` node
  to specify the underlying equity. This in turn defines the equity
  curve used for pricing. The `Underlying` node is described in further
  detail in Section <a href="#ss:underlying" data-reference-type="ref"
  data-reference="ss:underlying">[ss:underlying]</a>.  

- Currency: The currency of the notional, and thus of the option.  
  Allowable values: See `Currency` in Table
  <a href="#tab:allow_stand_data" data-reference-type="ref"
  data-reference="tab:allow_stand_data">[tab:allow_stand_data]</a>. The
  Currency must be the same as the currency of the underlying equity.

- Notional: The notional of the cliquet option.  
  Allowable values: Any positive real number.

- LongShort: Defines whether the trade is long or short the option.  
  Allowable values: *Long, Short*

- OptionType: The type of the option.  
  Allowable values: *Call, Put*

- Moneyness: Adjustment of option return. The moneyness M each forward
  starting option is being struck at.  
  Allowable values: Any real number. Expressed in decimal form where 1.0
  is at-the-money, 1.1 is 110% of the at-the-money strike, 0.9 is 90% of
  the at-the-money strike, etc.

- LocalCap\[Optional\]: The local cap, $cap_{l}$, in each of the option
  return.  
  Allowable values: Any real number. If omitted, no local cap is
  applied. Can’t be left blank.

- LocalFloor\[Optional\]: The local floor, $floor_{l}$, in each of the
  option return.  
  Allowable values: Any real number. If omitted, no local floor is
  applied. Can’t be left blank.

- GlobalCap\[Optional\]: The global cap, $cap_{g}$, for the option
  return.  
  Allowable values: Any real number. If omitted, no global cap is
  applied. Can’t be left blank.

- GlobalFloor\[Optional\]: The global floor,$floor_{g}$, for the option
  return.  
  Allowable values: Any real number. If omitted, no global floor is
  applied. Can’t be left blank.

- ScheduleData: A schedule of dates that define the valuation dates of
  the consecutive forward starting options forming the Equity Cliquet
  Option. The first date in the schedule is the start date of the first
  consecutive option, the second date in the schedule is the
  end/valuation date of the first consecutive option, and also the start
  date of the second consecutive option, etc. The last date is the final
  valuation date, with payoff of the whole Cliquet option at this date
  plus `SettlementDays`.  
  Allowable values: A node on the same form as `ScheduleData`, (see
  <a href="#ss:schedule_data" data-reference-type="ref"
  data-reference="ss:schedule_data">[ss:schedule_data]</a>).

- SettlementDays\[Optional\]: Number of days from the last valuation
  date to the payoff being paid or received. The payoff date is
  determined with regards to calendar and term date convention of the
  schedule’s calendar.  
  Allowable values: Any positive integer. Defaults to zero if left blank
  or omitted.

- Premium\[Optional\]: The premium paid for the option.  
  Allowable values: Any real number. Expressed in decimal form relative
  to notional.

- PremiumPaymentDate\[Optional\]: The date the premium is the paid.  
  Allowable values: See `Date` in Table
  <a href="#tab:allow_stand_data" data-reference-type="ref"
  data-reference="tab:allow_stand_data">[tab:allow_stand_data]</a>. Note
  that if a Premium is specified, a PremiumPaymentDate must also be
  specified.

- PremiumCurrency\[Optional\]: The currency the premium is to paid in.  
  Allowable values: See `Currency` in Table
  <a href="#tab:allow_stand_data" data-reference-type="ref"
  data-reference="tab:allow_stand_data">[tab:allow_stand_data]</a>.
  Defaults to the currency of the notional.

---

### Equity Forward

The `EquityForwardData` node is the trade data container for the
*EquityForward* trade type. Vanilla equity forwards are supported. The
structure of an example `EquityForwardData` node for an equity forward
is shown in Listing <a href="#lst:eqfwd_data" data-reference-type="ref"
data-reference="lst:eqfwd_data">[lst:eqfwd_data]</a>.

<div class="listing">

``` xml
<EquityForwardData>
  <LongShort>Long</LongShort>
  <Maturity>2018-06-30</Maturity>
  <Name>RIC:.SPX</Name>
  <Currency>USD</Currency>
  <Strike>2147.56</Strike>
  <StrikeCurrency>USD</StrikeCurrency>
  <Quantity>17000</Quantity>
</EquityForwardData>
```

</div>

The meanings and allowable values of the elements in the
`EquityForwardData` node follow below.

- LongShort: Defines whether the underlying equity will be bought (long)
  or sold (short).  
  Allowable values: *Long*, *Short*.

- Maturity: The maturity date of the forward contract, i.e. the date
  when the underlying equity will be bought/sold.  
  Allowable values: Any date string, see `Date` in Table
  <a href="#tab:allow_stand_data" data-reference-type="ref"
  data-reference="tab:allow_stand_data">[tab:allow_stand_data]</a>.

- Name: The identifier of the underlying equity or equity index.
  Allowable values: See `Name` for equity trades in Table
  <a href="#tab:equity_credit_data" data-reference-type="ref"
  data-reference="tab:equity_credit_data">[tab:equity_credit_data]</a>.  

- Underlying: This node may be used as an alternative to the `Name` node
  to specify the underlying equity. This in turn defines the equity
  curve used for pricing. The `Underlying` node is described in further
  detail in Section <a href="#ss:underlying" data-reference-type="ref"
  data-reference="ss:underlying">[ss:underlying]</a>.  

- Currency: The payment currency of the equity forward. If the equity
  underlying is quoted in a different currency, a `FXIndex` in the
  `SettlementData` sub-node is required to convert the payoff into the
  payment currency.  
  Allowable values: See Fiat Currencies and Minor Currencies in Table
  <a href="#tab:currency" data-reference-type="ref"
  data-reference="tab:currency">[tab:currency]</a>.

- Strike: The agreed buy/sell price of the equity forward.  
  Allowable values: Any positive real number.

- StrikeCurrency: \[Optional\] The currency of the strike value. The
  strike value has to be in underlying quotation currency. If the strike
  currency is quoted in the minor currency, the strike value will be
  converted to the major currency. Defaults to the payment currency if
  omitted or blank.  
  Allowable values: See Fiat Currencies and Minor Currencies in Table
  <a href="#tab:currency" data-reference-type="ref"
  data-reference="tab:currency">[tab:currency]</a>.

- Quantity: The number of units of the underlying equity to be
  bought/sold.  
  Allowable values: Any positive real number.

- SettlementData \[Optional\]: This node is used to specify the
  settlement of the cash flows.

The strike value must be quoted in the same currency as the underlying.
The underlying prices are always converted to the major underlying
currency during curve building. If the strike is quoted in the minor
underlying currency, it will be also converted to the major underlying
currency. If the strike currency is blank or omitted, it defaults to
payment currency, in this case the payment currency needs to be the same
as the underlying currency and same logic applies for minor to major
currency conversion.

A `SettlementData` node is shown in Listing
<a href="#lst:eq_settlement_data_node" data-reference-type="ref"
data-reference="lst:eq_settlement_data_node">[lst:eq_settlement_data_node]</a>,
and the meanings and allowable values of its elements follow below.

- FXIndex: The FX reference index for determining the FX fixing used to
  convert the amount from the underlying equity quotation currency to
  the payment currency. This field is required if the underlying
  currency doesn’t match the deal currency. Otherwise, it is ignored.  
  Allowable values: The format of the `FXIndex` is
  “FX-FixingSource-CCY1-CCY2” as described in Table
  <a href="#tab:fxindex_data" data-reference-type="ref"
  data-reference="tab:fxindex_data">[tab:fxindex_data]</a>.

- Date \[Optional\]: If specified, this will be the payment date.  
  Allowable values: See `Date` in Table
  <a href="#tab:allow_stand_data" data-reference-type="ref"
  data-reference="tab:allow_stand_data">[tab:allow_stand_data]</a>. If
  left blank or omitted, the payment date will be derived from the
  maturity date applying the `PaymentLag`, `PaymentCalendar` and the
  `PaymentConvention` as defined in the `Rules` sub-node.

- Rules \[Optional\]: If `Date` is left blank or omitted, this node will
  be used to derive the payment date from the maturity date. The `Rules`
  sub-node is shown in Listing
  <a href="#lst:eq_settlement_data_node" data-reference-type="ref"
  data-reference="lst:eq_settlement_data_node">[lst:eq_settlement_data_node]</a>,
  and the meanings and allowable values of its elements follow below.

  - PaymentLag \[Optional\]: The lag between the maturity date and the
    payment date.  
    Allowable values: Any valid period, i.e. a non-negative whole
    number, optionally followed by *D* (days), *W* (weeks), *M*
    (months), *Y* (years). Defaults to 0. If a whole number is given and
    no letter, it is assumed that it is a number of *D* (days).

  - PaymentCalendar \[Optional\]: The calendar to be used when applying
    the payment lag.  
    Allowable values: See Table
    <a href="#tab:calendar" data-reference-type="ref"
    data-reference="tab:calendar">[tab:calendar]</a> `Calendar`.
    Defaults to NullCalendar (no holidays) if left blank or omitted.

  - PaymentConvention \[Optional\]: The roll convention to be used when
    applying the payment lag.  
    Allowable values: See Table
    <a href="#tab:convention" data-reference-type="ref"
    data-reference="tab:convention">[tab:convention]</a> Roll
    Convention. Defaults to Unadjusted if left blank or omitted.

<div class="listing">

``` xml
<SettlementData>
  <FXIndex>FX-ECB-EUR-USD</FXIndex>
  <Date>2020-09-03</Date>
  <Rules>
    <PaymentLag>2D</PaymentLag>
    <PaymentCalendar>USD</PaymentCalendar>
    <PaymentConvention>Following</PaymentConvention>
  </Rules>
</SettlementData>
```

</div>

---

### Equity Futures Option

The `EquityFutureOptionData` node is the trade data container for the
*EquityFutureOption* trade type. Equity options with exercise styles
*European* and *American* are supported. The `EquityFutureOptionData`
node includes one and only one `OptionData` trade component sub-node
plus elements specific to the equity future option. The structure of an
example `EquityFutureOptionData` node for an equity option is shown in
Listing <a href="#lst:eqfutureoption_data" data-reference-type="ref"
data-reference="lst:eqfutureoption_data">[lst:eqfutureoption_data]</a>.

<div class="listing">

``` xml
<EquityFutureOptionData>
    <OptionData>
         <LongShort>Long</LongShort>
         <OptionType>Call</OptionType>
         <Style>American</Style>
         <Settlement>Cash</Settlement>
         <PayOffAtExpiry>true</PayOffAtExpiry>
         <ExerciseDates>
             <ExerciseDate>2022-03-01</ExerciseDate>
         </ExerciseDates>
         ...
    </OptionData>
    <Name>RIC:.SPX</Name>
    <Currency>USD</Currency>
    <StrikeData>
        <StrikePrice>
            <Value>2147.56</Value>
            <Currency>USD</Currency>
        </StrikePrice>
    </StrikeData>
    <Quantity>17000</Quantity>
    <FutureExpiryDate>2021-01-29</FutureExpiryDate>
</EquityFutureOptionData>
```

</div>

The meanings and allowable values of the elements in the
`EquityFutureOptionData` node follow below.

- OptionData: This is a trade component sub-node outlined in section
  <a href="#ss:option_data" data-reference-type="ref"
  data-reference="ss:option_data">[ss:option_data]</a> Option Data. The
  relevant fields in the `OptionData` node for an EquityOption are:

  - `LongShort` The allowable values are *Long* or *Short*.

  - `OptionType` The allowable values are *Call* or *Put*. *Call* means
    that the option holder has the right to buy the given quantity of
    the underlying equity at the strike price. *Put* means that the
    option holder has the right to sell the given quantity of the
    underlying equity at the strike price.

  - `Style` The allowable value is *European*.

  - `Settlement` The allowable values are *Cash* or *Physical*.

  - `PayOffAtExpiry` \[Optional\] The allowable values are *true* for
    payoff at expiry, or *false* for payoff at exercise. This field is
    relevant for *American* style EquityOptions, and defaults to *true*
    if left blank or omitted.

  - An `ExerciseDates` node where exactly one ExerciseDate date element
    must be given.

  - Premiums \[Optional\]: Option premium amounts paid by the option
    buyer to the option seller.

    Allowable values: See section
    <a href="#ss:premiums" data-reference-type="ref"
    data-reference="ss:premiums">[ss:premiums]</a>

- Name: The identifier of the underlying equity or equity index.  
  Allowable values: See `Name` for equity trades in Table
  <a href="#tab:equity_credit_data" data-reference-type="ref"
  data-reference="tab:equity_credit_data">[tab:equity_credit_data]</a>.  

- Underlying: This node may be used as an alternative to the `Name` node
  to specify the underlying equity. This in turn defines the equity
  curve used for pricing. The `Underlying` node is described in further
  detail in Section <a href="#ss:underlying" data-reference-type="ref"
  data-reference="ss:underlying">[ss:underlying]</a>.  

- Currency: The currency of the equity option.  
  Allowable values: See Table
  <a href="#tab:currency" data-reference-type="ref"
  data-reference="tab:currency">[tab:currency]</a>.

- StrikeData: The option strike price.  
  Allowable values: Only supports `StrikePrice` as described in Section
  <a href="#ss:strikedata" data-reference-type="ref"
  data-reference="ss:strikedata">[ss:strikedata]</a>.

- Quantity: The number of units of the underlying covered by the
  transaction.  
  Allowable values: Any positive real number.

- FutureExpiryDate \[Optional\]: If `IsFuturePrice` is `true` and the
  underlying is a future contract settlement price, this node allows the
  user to specify the expiry date of the underlying future contract.

  Allowable values: This should be a valid date as outlined in Table
  <a href="#tab:allow_stand_data" data-reference-type="ref"
  data-reference="tab:allow_stand_data">[tab:allow_stand_data]</a>. If
  not provided, it is assumed that the future contract’s expiry date is
  equal to the option expiry date provided in the `OptionData` node.

---

### Equity Option

Quanto payoff means that the payoff `Currency` is different than
currency the underlying equity is quoted in.  
Composite or “compo” equity options have a `StrikeCurrency` that is
different than currency the underlying equity is quoted in. (This is
unrelated to the *CompositeTrade* trade type.)

The `EquityOptionData` node is the trade data container for the
*EquityOption* trade type. Equity options with exercise styles
*European* and *American* are supported.

The `EquityOptionData` node includes one and only one `OptionData` trade
component sub-node plus elements specific to the equity option. The
structure of an example `EquityOptionData` node for an equity option is
shown in Listing <a href="#lst:eqoption_data" data-reference-type="ref"
data-reference="lst:eqoption_data">[lst:eqoption_data]</a>.

<div class="listing">

``` xml
<EquityOptionData>
    <OptionData>
         <LongShort>Long</LongShort>
         <OptionType>Call</OptionType>
         <Style>American</Style>
         <Settlement>Cash</Settlement>
         <PayOffAtExpiry>true</PayOffAtExpiry>
         <ExerciseDates>
             <ExerciseDate>2022-03-01</ExerciseDate>
         </ExerciseDates>
         ...
    </OptionData>
    <Name>RIC:.SPX</Name>
    <Currency>USD</Currency>
    <Strike>2147.56</Strike>
    <StrikeCurrency>USD</StrikeCurrency>
    <Quantity>17000</Quantity>
</EquityOptionData>
```

</div>

The meanings and allowable values of the elements in the
`EquityOptionData` node follow below.

- OptionData: This is a trade component sub-node outlined in section
  <a href="#ss:option_data" data-reference-type="ref"
  data-reference="ss:option_data">[ss:option_data]</a> Option Data. The
  relevant fields in the `OptionData` node for an EquityOption are:

  - `LongShort`: The allowable values are *Long* or *Short*.

  - `OptionType`: The allowable values are *Call* or *Put*. *Call* means
    that the option holder has the right to buy the given quantity of
    the underlying equity at the strike price. *Put* means that the
    option holder has the right to sell the given quantity of the
    underlying equity at the strike price.

  - `Style`: The allowable values are *European* and *American*.

  - `Settlement`: The allowable values are *Cash* or *Physical*. If
    `Currency` and underlying equity currency are different, i.e. Quanto
    payoff, this must be set to *Cash*.

  - `PayOffAtExpiry` \[Optional\]: The allowable values are *true* for
    payoff at expiry, or *false* for payoff at exercise. This field is
    relevant for *American* style EquityOptions, and defaults to *true*
    if left blank or omitted.

  - An `ExerciseDates` node where exactly one ExerciseDate date element
    must be given.

  - `PaymentData` \[Optional\]: Node used to set the payment date if it
    differs from the exercise date. Note that for quanto and compo
    EquityOptions the payment date cannot differ from the exercise date.

  - `Premiums` \[Optional\]: Node for Option premium amounts paid by the
    option buyer to the option seller.

    Allowable values: See section
    <a href="#ss:premiums" data-reference-type="ref"
    data-reference="ss:premiums">[ss:premiums]</a>

- Name: The identifier of the underlying equity or equity index.

  Allowable values: See `Name` for equity trades in Table
  <a href="#tab:equity_name" data-reference-type="ref"
  data-reference="tab:equity_name">[tab:equity_name]</a>.

- Underlying: This node may be used as an alternative to the `Name` node
  to specify the underlying equity. This in turn defines the equity
  curve used for pricing. The `Underlying` node is described in further
  detail in Section <a href="#ss:underlying" data-reference-type="ref"
  data-reference="ss:underlying">[ss:underlying]</a>.  

- Currency: The payment currency of the equity option.

  Allowable values: See `Currency` and `Minor Currencies` in Table
  <a href="#tab:allow_stand_data" data-reference-type="ref"
  data-reference="tab:allow_stand_data">[tab:allow_stand_data]</a>. If
  this is different to the currency that the underlying equity is quoted
  in, then a Quanto payoff will be applied. Using the corresponding
  major currency for an equity quoted in the minor currency will not
  correspond to a Quanto payoff.

- Strike\[Mandatory except if StrikeData node is used\]: The option
  strike price.

  Allowable values: Any positive real number.

- StrikeCurrency \[Mandatory for Quanto/Compo, Optional otherwise\]: The
  currency that the `Strike` is quoted in. If the option is Quanto, then
  this field must not be left blank, and must equal the currency that
  the underlying equity is quoted in, up to the minor/major currency.
  For example, if the underlying equity is quoted in GBP,
  then`StrikeCurrency` must be either *GBP* or *GBp*. If the option is a
  Compo option, then this field must not be left blank, and it must
  equal the payment currency of the option and different to the
  underlying currency.

  Note:  
  Quanto: Payment currency and the currency the underlying equity is
  quoted in differ. StrikeCurrency is in the currency the equity is
  quoted in.  
  Compo (Composite): Payment currency and the currency the underlying
  equity is quoted in differ. StrikeCurrency is in the payment currency.

  Allowable values: See Fiat Currencies and Minor Currencies in Table
  <a href="#tab:currency" data-reference-type="ref"
  data-reference="tab:currency">[tab:currency]</a>. Must be the major or
  minor currency of the `Currency` field above, or in the Quanto case it
  must be the major or minor currency the underlying is quoted in. If
  left blank or omitted, and payment currency is the same as the equity
  currency, it defaults to the `Currency` field (payment currency)
  above.

- StrikeData\[Optional\]: Alternatively, instead of the `Strike` and the
  `StrikeCurrency` fields above a `StrikeData` node can be used as
  described in Section
  <a href="#ss:strikedata" data-reference-type="ref"
  data-reference="ss:strikedata">[ss:strikedata]</a>. Note that for
  EquityOptions only `StrikePrice` is supported within the `StrikeData`
  node, and not `StrikeYield`.

- Quantity: The number of units of the underlying covered by the
  transaction.

  Allowable values: Any positive real number.

---

### Equity Option Position

An equity option position represents a position in a single equity
option - using a single `Underlying` node, or in a weighted basket of
underlying equity options - using multiple `Underlying` nodes.

An Equity Option Position can be used both as a stand alone trade type
(TradeType: *EquityOptionPosition*) or as a trade component
(`EquityOptionPositionData`) used within the *TotalReturnSwap* (Generic
TRS) trade type, to set up for example Equity Option Basket trades.

It is set up using an `EquityOptionPositionData` block as shown in
listing
<a href="#lst:equityoptionpositiondata" data-reference-type="ref"
data-reference="lst:equityoptionpositiondata">[lst:equityoptionpositiondata]</a>.
The meanings and allowable values of the elements in the block are as
follows:

- Quantity: The number of options written on one underlying share resp.
  the number of units of the option basket held.  
  Allowable values: Any positive real number

- Underlying: One or more underlying descriptions, each comprising an
  `Underlying` block, an `Optiondata` block and a `Strike` element, in
  that order:

  - Underlying: an underlying description, see
    <a href="#ss:underlying" data-reference-type="ref"
    data-reference="ss:underlying">[ss:underlying]</a>, only equity
    underlying are allowed

  - OptionData: the option description, see
    <a href="#ss:option_data" data-reference-type="ref"
    data-reference="ss:option_data">[ss:option_data]</a>, the relevant /
    allowed data is

    - LongShort: the type of the position,*long* and *Short* positions
      are allowed. Note that negative weights are allowed. A *long*
      position with a negative weight results in a *short* position, and
      a *short* position with a negative weight results in a *long*
      position.

    - OptionType: *Call* or *Put*

    - Style: *European* or *American*

    - Settlement: *Cash* or *Physical*

    - ExerciseDates: exactly one exercise must be given representing the
      European exercise date or the last American exercise date

  - Strike: the strike of the option. Allowable values are non-negative
    real numbers.

If a basket of equities is defined, the `Weight` field should be
populated for each underlying. The weighted basket price is then given
by
$$\text{Basket-Price} = \text{Quantity} \times \sum_i \text{Weight}_i \times p_i \times \text{FX}_i$$
where

- $p_i$ is the price of the ith option in the basket, written on one
  underlying share

- $FX_i$ is the FX Spot converting from the ith equity currency to the
  first equity currency which is by definition the currency in which the
  npv of the basket is expressed.

<div class="listing">

``` xml
<Trade id="EquityOptionPositionTrade">
  <TradeType>EquityOptionPosition</TradeType>
  <EquityOptionPositionData>
    <!-- basket price = quantity x sum_i ( weight_i x equityOptionPrice_i x fx_i ) -->
    <Quantity>1000</Quantity>
    <!-- option #1 -->
    <Underlying>
      <Underlying>
        <Type>Equity</Type>
        <Name>.SPX</Name>
        <Weight>0.5</Weight>
        <IdentifierType>RIC</IdentifierType>
      </Underlying>
      <OptionData>
        <LongShort>Long</LongShort>
        <OptionType>Call</OptionType>
        <Style>European</Style>
        <Settlement>Cash</Settlement>
        <ExerciseDates>
          <ExerciseDate>2021-01-29</ExerciseDate>
        </ExerciseDates>
      </OptionData>
      <Strike>3300</Strike>
    </Underlying>
    <!-- option #2 -->
    <Underlying>
      <Underlying>
        <Type>Equity</Type>
        <Name>.SPX</Name>
        <Weight>0.5</Weight>
        <IdentifierType>RIC</IdentifierType>
      </Underlying>
      <OptionData>
        <LongShort>Long</LongShort>
        <OptionType>Call</OptionType>
        <Style>European</Style>
        <Settlement>Cash</Settlement>
        <ExerciseDates>
          <ExerciseDate>2021-01-29</ExerciseDate>
        </ExerciseDates>
      </OptionData>
      <Strike>3400</Strike>
    </Underlying>
    <!-- option #3 -->
    <!-- ... -->
  </EquityOptionPositionData>
</Trade>
```

</div>

---

### Equity Position

An equity position represents a position in a single equity - using a
single `Underlying` node, or in a weighted basket of underlying
equities - using multiple `Underlying` nodes.

An Equity Position can be used both as a stand alone trade type
(TradeType: *EquityPosition*) or as a trade component
(`EquityPositionData`) used within the *TotalReturnSwap* (Generic TRS)
trade type, to set up for example Equity Basket trades.

It is set up using an `EquityPositionData` block as shown in listing
<a href="#lst:equitypositiondata" data-reference-type="ref"
data-reference="lst:equitypositiondata">[lst:equitypositiondata]</a>.
The meanings and allowable values of the elements in the block are as
follows:

- Quantity: The number of shares or units of the weighted basket held.  
  Allowable values: Any positive real number

- Underlying: One or more underlying descriptions. If a basket of
  equities is defined, the `Weight` field should be populated for each
  underlyings. The weighted basket price is then given by  
  $$\text{Basket-Price} = \text{Quantity} \times \sum_i \text{Weight}_i \times S_i \times \text{FX}_i$$
  where

  - $S_i$ is the price of the ith share in the basket

  - $FX_i$ is the FX Spot converting from the ith equity currency to the
    first equity currency which is by definition the currency in which
    the npv of the basket is expressed.

  Allowable values: See
  <a href="#ss:underlying" data-reference-type="ref"
  data-reference="ss:underlying">[ss:underlying]</a> for the definition
  of an underlying. Only equity underlyings are allowed.

<div class="listing">

``` xml
  <Trade id="EquityPosition">
    <TradeType>EquityPosition</TradeType>
    <Envelope>...</Envelope>
    <EquityPositionData>
      <Quantity>1000</Quantity>
        <Underlying>
          <Type>Equity</Type>
          <Name>BE0003565737</Name>
          <Weight>0.5</Weight>
          <IdentifierType>ISIN</IdentifierType>
          <Currency>EUR</Currency>
          <Exchange>XFRA</Exchange>
        </Underlying>
        <Underlying>
          <Type>Equity</Type>
          <Name>GB00BH4HKS39</Name>
          <Weight>0.5</Weight>
          <IdentifierType>ISIN</IdentifierType>
          <Currency>GBP</Currency>
          <Exchange>XLON</Exchange>
        </Underlying>
    </EquityPositionData>
  </Trade>
```

</div>

---

### Equity Swap

An Equity Swap uses its own trade type *EquitySwap*, and is set up using
a `EquitySwapData` node with one leg of type *Equity* and one more leg -
called Funding leg - that can be either *Fixed* or *Floating*. Listing
<a href="#lst:equityswap" data-reference-type="ref"
data-reference="lst:equityswap">[lst:equityswap]</a> shows an example.
The Equity leg contains an additional `EquityLegData` block. See
<a href="#ss:equitylegdata" data-reference-type="ref"
data-reference="ss:equitylegdata">[ss:equitylegdata]</a> for details on
the Equity leg specification.

Note that the *Equity* leg of an *EquitySwap* can only include one
single underlying equity name (that can be an equity index name). For
instruments with more than one underlying equity name, TradeType
*TotalReturnSwap* (GenericTRS) should be used instead.

Cross currency *EquitySwaps* are supported, i.e. the Equity and the
Funding legs do not need to have the same currency. However, if the
Funding leg uses `Indexings` with `FromAssetLeg` set to *true* to derive
the notionals from the Equity leg, then the Funding leg must use the
same currency as the Equity leg.

Note that pricing for an *EquitySwap* is based on discounted cashflows,
whereas pricing for a *TotalReturnSwap* (GenericTRS) on an equity
underlying uses the accrual method. The accrual method is common
practice when daily unwind rights are present in the trade terms.

Also note that, unlike other leg types, the `DayCounter` field is
optional for an *Equity* leg, and defaults to *ACT/365* if left blank or
omitted. The daycount convention for the equity leg of an equity swap
does not impact pricing, only the accrued amount (displayed in
cashflows).

<div class="listing">

``` xml
    <EquitySwapData>
      <LegData>
        <LegType>Floating</LegType>
        <Payer>true</Payer>
        <DayCounter>ACT/365</DayCounter>
        ...
      </LegData>
      <LegData>
        <LegType>Equity</LegType>
        <Payer>false</Payer>
        <DayCounter>ACT/365</DayCounter>
        ...
        <EquityLegData>
        ...
        </EquityLegData>
      </LegData>
    </EquitySwapData>
```

</div>

If the equity swap has a resetting notional, typically the Funding leg’s
notional will be aligned with the equity leg’s notional. To achieve
this, `Indexings` on the floating leg can be used, see
<a href="#ss:indexings" data-reference-type="ref"
data-reference="ss:indexings">[ss:indexings]</a>. In the context of
equity swaps the indexings can be defined in a simplified way by adding
an `Indexings` node with a subnode `FromAssetLeg` set to *true* to the
Funding leg’s `LegData` node. The `Notionals` node is not required in
the Funding leg’s LegData in this case. An example is shown in listing
<a href="#lst:equityswap_reset" data-reference-type="ref"
data-reference="lst:equityswap_reset">[lst:equityswap_reset]</a>.

<div class="listing">

``` xml
    <EquitySwapData>
      <LegData>
        <LegType>Floating</LegType>
        <Currency>USD</Currency>
        ...
        <!-- Notionals node is not required, set to 1 internally -->
        ...
        <Indexings>
          <!-- derive the indexing information (equity price, FX) from the Equity leg -->
          <FromAssetLeg>true</FromAssetLeg>
        </Indexings>
      </LegData>
      <LegData>
        <LegType>Equity</LegType>
          <Currency>USD</Currency>
          ...
          <EquityLegData>
            <Quantity>1000</Quantity>
        <Underlying>
         <Type>Equity</Type>
         <Name>.STOXX50E</Name>
         <IdentifierType>RIC</IdentifierType>
        </Underlying>
            <InitialPrice>2937.36</InitialPrice>
            <NotionalReset>true</NotionalReset>
            <FXTerms>
              <EquityCurrency>EUR</EquityCurrency>
              <FXIndex>FX-ECB-EUR-USD</FXIndex>
            </FXTerms>
          </EquityLegData>
          ...
      </LegData>
    </EquitySwapData>
```

</div>

### Dividend Swap

An Dividend Swap uses its the trade type *EquitySwap*, shown above
<a href="#ss:equity_swap" data-reference-type="ref"
data-reference="ss:equity_swap">0.0.1</a>, and is set up using a
`EquitySwapData` node with one leg of type *Equity*, with *ReturnType*
equal to *Dividend* and one more leg that can be either *Fixed* or
*Floating*. Listing
<a href="#lst:dividendswap" data-reference-type="ref"
data-reference="lst:dividendswap">[lst:dividendswap]</a> shows an
example.

An example is shown in listing
<a href="#lst:equityswap_reset" data-reference-type="ref"
data-reference="lst:equityswap_reset">[lst:equityswap_reset]</a>.

<div class="listing">

``` xml
    <EquitySwapData>
        <LegData>
            ...
        </LegData>
        <LegData>
            <Payer>false</Payer>
            <LegType>Equity</LegType>
            <Currency>EUR</Currency>
            <PaymentConvention>Following</PaymentConvention>
            <DayCounter>A360</DayCounter>
            <EquityLegData>
                <ReturnType>Dividend</ReturnType>
                <Underlying>
         <Type>Equity</Type>
         <Name>.STOXX50E</Name>
         <IdentifierType>RIC</IdentifierType>
        </Underlying>
            <Quantity>10000</Quantity>
            </EquityLegData>
            <ScheduleData>
                <Rules>
                    <StartDate>2018-12-31</StartDate>
                    <EndDate>2020-12-31</EndDate>
                    <Tenor>6M</Tenor>
                    <Calendar>EUR</Calendar>
                    <Convention>ModifiedFollowing</Convention>
                    <Rule>Forward</Rule>
                </Rules>
            </ScheduleData>
        </LegData>
    </EquitySwapData>
```

</div>

---

### Equity Variance Swap

The `EqutiyVarianceSwapData` node is the trade data container for the
*EquityVarianceSwap* trade type. Only vanilla variance swaps are
supported. The structure of an example `EqutiyVarianceSwapData` node for
an equity variance swap is shown in Listing
<a href="#lst:varswap_data" data-reference-type="ref"
data-reference="lst:varswap_data">[lst:varswap_data]</a>.

<div class="listing">

``` xml
<EquityVarianceSwapData>
    <StartDate>2016-01-29</StartDate>
    <EndDate>2016-05-05</EndDate>
    <Currency>USD</Currency>
    <Underlying>
      <Type>Equity</Type>
      <Name>.SPX</Name>
      <IdentifierType>RIC</IdentifierType>
    </Underlying>
    <LongShort>Long</LongShort>
    <Strike>0.20</Strike>
    <Notional>50000</Notional>
    <Calendar>US</Calendar>
    <MomentType>Variance</MomentType>
    <AddPastDividends>true</AddPastDividends>
</EqutiyVarianceSwapData>
```

</div>

The meanings and allowable values of the elements in the
`EquityVarianceSwapData` node below.

- StartDate: The variance swap start date.  
  Allowable values: See `Date` in Table
  <a href="#tab:allow_stand_data" data-reference-type="ref"
  data-reference="tab:allow_stand_data">[tab:allow_stand_data]</a>.

- EndDate: The variance swap end date.  
  Allowable values: See `Date` in Table
  <a href="#tab:allow_stand_data" data-reference-type="ref"
  data-reference="tab:allow_stand_data">[tab:allow_stand_data]</a>.

- Currency: The bought currency of the variance swap.  
  Allowable values: See `Currency` in Table
  <a href="#tab:allow_stand_data" data-reference-type="ref"
  data-reference="tab:allow_stand_data">[tab:allow_stand_data]</a>.

- Name: The identifier of the underlying equity or equity index.  
  Allowable values: See `Name` for equity trades in Table
  <a href="#tab:equity_credit_data" data-reference-type="ref"
  data-reference="tab:equity_credit_data">[tab:equity_credit_data]</a>.  

- Underlying: This node may be used as an alternative to the `Name` node
  to specify the underlying equity. This in turn defines the equity
  curve used for pricing. The `Underlying` node is described in further
  detail in Section <a href="#ss:underlying" data-reference-type="ref"
  data-reference="ss:underlying">[ss:underlying]</a>.  

- LongShort: Defines whether the trade is long in the equity variance.
  For the avoidance of doubt, a long variance swap has positive value if
  the realised variance exceeds the variance strike.  
  Allowable values: *Long, Short*

- Strike: The volatility strike $K_{vol}$ of the variance swap quoted
  absolutely (i.e. not as a percent). If the swap was struck in terms of
  variance, the square root of that variance should be used here.  
  Allowable values: Any positive real number.

- Notional: The vega notional of the variance swap. This is the notional
  in terms of volatility units (like the strike). If the swap was struck
  in terms of a variance notional $N_{var}$, the corresponding vega
  notional is given by $N_{vol} = N_{var} * 2 * 100 * K_{vol}$ (where
  $K_{vol}$ is in absolute terms).  
  Allowable values: Any non-negative real number.

- Calendar: The calendar determining the observation/fixing dates
  according to which variance is accrued is the combination of the
  calendar(s) given here plus the calendar associated with the equity in
  the equity curve configuration. If no such calendar is given in the
  equity curve configuration the standard calendar for the equity
  currency (also defined in the curve config) is used instead.  
  Allowable values: See Table
  <a href="#tab:calendar" data-reference-type="ref"
  data-reference="tab:calendar">[tab:calendar]</a>.

- MomentType\[Optional\]: A flag to distinguish if the swap is struck in
  terms of volatility or variance. The MomentType should be set to
  *Volatility* or *Variance* depending on the payoff. Note that
  MomentType does not necessarily need to be equivalent to the way the
  Strike is quoted which is always as a Volatility.  
  Allowable values: *Volatility* or *Variance*. Defaults to *Variance*
  if left blank or omitted.

- AddPastDividends\[Optional\]: A flag to distinguish if past dividend
  payments should be added to the fixings when calculating accrued
  variance.  
  Allowable values: *true* or *false*. Defaults to *false* if left blank
  or omitted.

---

### European Option Contingent on a Barrier

European exercise, American or European barrier, multi-asset

This is a plain vanilla European option on a given underlying, whose
final payoff is contingent on the price level of another underlying
(forming the barrier). Both underlyings can be of multiple asset
classes.

The trade container for this product is the `EuropeanOptionBarrierData`
node, and the corresponding trade type is EuropeanOptionBarrier. The
barrier can be continuously monitored (American) or only be monitored on
the option expiry date (European). Currently, we support Equity, FX,
Commodity and InterestRate for the option underlying. For the barrier
underlying, we support Equity, FX, Commodity and InterestRate for
European-style barriers, but not InterestRate for an American-style
barrier.

Listing <a href="#lst:european_option_american_barrier"
data-reference-type="ref"
data-reference="lst:european_option_american_barrier">[lst:european_option_american_barrier]</a>
shows the structure of an Equity European option with an American-style
FX barrier. For a European-style barrier, the `BarrierType` must be set
to *European* and the `BarrierSchedule` can be omitted.

<div class="listing">

``` xml
<Trade id="Equity_EuropeanOptionWithAmericanFxBarrier">
  <TradeType>EuropeanOptionBarrier</TradeType>
  <Envelope>
    .....
  </Envelope>
  <EuropeanOptionBarrierData>
    <Quantity>8523</Quantity>
    <PutCall>Call</PutCall>
    <LongShort>Short</LongShort>
    <Strike>3520</Strike>
    <PremiumAmount>114.40</PremiumAmount>
    <PremiumCurrency>EUR</PremiumCurrency>
    <PremiumDate>2019-12-13</PremiumDate>
    <OptionExpiry>2020-06-19</OptionExpiry>
    <OptionUnderlying>
      <Type>Equity</Type>
      <Name>RIC:.STOXX50E</Name>
    </OptionUnderlying>
    <BarrierUnderlying>
      <Type>FX</Type>
      <Name>ECB-EUR-USD</Name>
    </BarrierUnderlying>
    <BarrierLevel>1.09335</BarrierLevel>
    <BarrierType>DownAndIn</BarrierType>
    <BarrierStyle>American</BarrierStyle>
    <BarrierSchedule>
      <Rules>
        <StartDate>2019-12-11</StartDate>
        <EndDate>2020-06-19</EndDate>
        <Tenor>1D</Tenor>
        <Calendar>USA</Calendar>
        <Convention>Following</Convention>
        <TermConvention>Following</TermConvention>
        <Rule>Forward</Rule>
      </Rules>
    </BarrierSchedule>
    <SettlementDate>2020-06-24</SettlementDate>
    <PayCcy>USD</PayCcy>
  </EuropeanOptionBarrierData>
</Trade>
```

</div>

The meanings and allowable values of the elements in the
`EuropeanOptionBarrierData` node follow below.

- Quantity: Number of option contracts.  
  Allowable values: Any non-negative number.

- PutCall: Option type.  
  Allowable values: *Call, Put*

- LongShort: Own party position.  
  Allowable values: *Long, Short*

- Strike: Option strike price.  
  Allowable values: Any positive number.

- PremiumAmount: Premium amount per option.  
  Allowable values: Any number.

- PremiumCurrency: Currency of the option premium.  
  Allowable values: See `Currency` in Table
  <a href="#tab:allow_stand_data" data-reference-type="ref"
  data-reference="tab:allow_stand_data">[tab:allow_stand_data]</a>.

- PremiumDate: The option premium payment date.  
  Allowable values: See `Date` in Table
  <a href="#tab:allow_stand_data" data-reference-type="ref"
  data-reference="tab:allow_stand_data">[tab:allow_stand_data]</a>.

- OptionExpiry: Option expiry date.  
  Allowable values: See `Date` in Table
  <a href="#tab:allow_stand_data" data-reference-type="ref"
  data-reference="tab:allow_stand_data">[tab:allow_stand_data]</a>.

- OptionUnderlying: The option underlying.  
  Allowable values: A node of the same form as `Underlying`, (see
  <a href="#ss:underlying" data-reference-type="ref"
  data-reference="ss:underlying">[ss:underlying]</a>). The supported
  types are *Equity*, *FX*, *Commodity* and *InterestRate*.  

- BarrierUnderlying: The underlying monitored against the barrier
  level.  
  Allowable values: A node of the same form as `Underlying`, (see
  <a href="#ss:underlying" data-reference-type="ref"
  data-reference="ss:underlying">[ss:underlying]</a>). The supported
  types are *Equity*, *FX*, *Commodity* and *InterestRate* if
  `BarrierStyle` is *European*. For `BarrierStyle` *American*, we only
  support *Equity*, *FX* and *Commodity*.

- BarrierLevel: Knock-in/knock-out barrier level.  
  Allowable values: Any number.

- BarrierType: The type of knock-in or knock-out barrier.  
  Allowable values: *DownIn, UpIn, DownOut, UpOut*

- BarrierStyle: Whether the barrier is continuously monitored or only at
  the option expiry date.  
  Allowable values: *American, European*

- BarrierSchedule \[Optional\]: The schedule specifying the schedule of
  trading days over which the continuous barrier will be monitored. This
  is required only when `BarrierStyle` is *American*.  
  Allowable values: A node of the same form as `ScheduleData`, (see
  <a href="#ss:schedule_data" data-reference-type="ref"
  data-reference="ss:schedule_data">[ss:schedule_data]</a>).

- SettlementDate: Settlement date of the option exercise payoff.  
  Allowable values: See `Date` in Table
  <a href="#tab:allow_stand_data" data-reference-type="ref"
  data-reference="tab:allow_stand_data">[tab:allow_stand_data]</a>. The
  Settlement date must be on or after the Option expiry date.

- PayCcy: Settlement currency.  
  Allowable values: See Table
  <a href="#tab:currency" data-reference-type="ref"
  data-reference="tab:currency">[tab:currency]</a> `Currency`.

---

### Extended Accumulator

Extended Accumulator are represented as scripted trades, refer to
appendix A for an introduction. Below shows the structure of an example.

An Extended Accumulator is like an Accumulator with regular and
conditional observation and settlement dates. After the regular
observation dates a European barrier is applied on the Extension
Decision Date. If the barrier is hit the trade terminates, otherwise the
trade continues with cashflows generated on the conditional observation
dates.

``` xml
<Trade id="FxExtendedAccumulatorLong">
   <TradeType>ScriptedTrade</TradeType>
   <Envelope>
      <CounterParty>CPTY_A</CounterParty>
      <NettingSetId>CRIF_20191230</NettingSetId>
      <AdditionalFields/>
   </Envelope>
   <ExtendedAccumulatorData>
      <LongShort type="longShort">Long</LongShort>
      <FixingAmount type="number">840336</FixingAmount>
      <Strike type="number">1.19</Strike>
      <PayCurrency type="currency">USD</PayCurrency>
      <Underlying type="index">FX-ECB-EUR-USD</Underlying>
      <ObservationDates type="event">
         <ScheduleData>
            <Dates>
               <Dates>
                  <Date>2019-09-30</Date>
                  <Date>2019-10-31</Date>
                  <Date>2019-11-28</Date>
                  <Date>2019-12-31</Date>
                  <Date>2020-01-30</Date>
                  <Date>2020-02-27</Date>
               </Dates>
            </Dates>
         </ScheduleData>
      </ObservationDates>
      <ObservationSettlementDates type="event">
         <ScheduleData>
            <Dates>
               <Dates>
                  <Date>2019-10-02</Date>
                  <Date>2019-11-02</Date>
                  <Date>2019-12-30</Date>
                  <Date>2020-01-02</Date>
                  <Date>2020-02-03</Date>
                  <Date>2020-03-30</Date>
               </Dates>
            </Dates>
         </ScheduleData>
      </ObservationSettlementDates>
      <ExtensionDecisionDate type="event">2020-02-25</ExtensionDecisionDate>
      <ExtensionTrigger type="number">1.19</ExtensionTrigger>
      <ConditionalObservationDates type="event">
         <ScheduleData>
            <Dates>
               <Dates>
                  <Date>2020-03-31</Date>
                  <Date>2020-04-30</Date>
                  <Date>2020-05-29</Date>
                  <Date>2020-06-30</Date>
                  <Date>2020-07-31</Date>
                  <Date>2020-08-31</Date>
               </Dates>
            </Dates>
         </ScheduleData>
      </ConditionalObservationDates>
      <ConditionalSettlementDates type="event">
         <ScheduleData>
            <Dates>
               <Dates>
                  <Date>2020-03-31</Date>
                  <Date>2020-04-30</Date>
                  <Date>2020-05-29</Date>
                  <Date>2020-06-30</Date>
                  <Date>2020-07-31</Date>
                  <Date>2020-08-31</Date>
               </Dates>
            </Dates>
         </ScheduleData>
      </ConditionalSettlementDates>
   </ExtendedAccumulatorData>
</Trade>
```

The meanings and allowable values of the elements in the
`Extended Accumulator` representation follow below.

- LongShort: Defines whether the trade is long or short, i.e long means
  one buys the underlying asset and short sells the underlying asset at
  each observation date.  
  Allowable values: *Long, Short*

- Strike: For Fx, the Fx strike rate is defined as amount in domestic
  currency (CCY2) for one unit of foreign currency (CCY1). For Equity
  and Commodity: The strike value for one unit/share/contract of the
  underlying equity or commodity, expressed in the domestic currency
  (CCY2).

- Underlying: Underlying index. For Fx: Value is a string of the form
  FX-SOURCE-CCY1-CCY2 where CCY1 is the foreign currency, CCY2 is the
  domestic currency, and SOURCE is the fixing source.  
  Allowable values: See Section
  <a href="#data_index" data-reference-type="ref"
  data-reference="data_index">[data_index]</a> for allowable values.

- FixingAmount: The unleveraged notional amount accumulated at each
  fixing date. - For Fx: The FixingAmount is expressed in the foreign
  currency (CCY1). Note that the underlying is provided in the form
  `FX-SOURCE-CCY1-CCY2` (see Table
  <a href="#tab:fxindex_data" data-reference-type="ref"
  data-reference="tab:fxindex_data">[tab:fxindex_data]</a>). For Equity:
  The FixingAmount is expressed as number of shares/units of the
  underlying equity or equity index. For Commodity: The FixingAmount is
  expressed as number of units of the underlying commodity.  
  Allowable values: Any real number. Note that a negative amount causes
  a Long ExtendedAccumulator to be a Short, and vice-versa

- PayCurrency: The payout currency. The result of the payout formula is
  treated to be in this currency. Note that for (non-quanto)
  ExtendedAccumulators this should be the domestic (CCY2) currency.

- ExtensionDecisionDate: the date on which the Extension Condition is
  decided on

- ExtensionTrigger: the value of the index below which a Trigger Event
  occurs on Extension Decision Date. It is expressed in the same way as
  Strike outlined above. If the underlying on the extension decision
  date is above the barrier level, it triggers the extension on
  conditional observation dates. Else, the trade terminate at last
  observation date.

- SettlementDate: the settlement date of the option payoff

- ObservationDates: the dates on which the underlying index value is
  observed, define the exchange of notionals

- ObservationSettlementDates: observation settlement dates

- ConditionalObservationDates: the dates on which the underlying index
  value is observed, define the exchange of notionals

- ConditionalSettlementDates: conditional observation settlement dates

The script ‘ExtendedAccumulator’ referenced in the trade above is shown
in Listing
<a href="#lst:extendedaccumulator_script" data-reference-type="ref"
data-reference="lst:extendedaccumulator_script">[lst:extendedaccumulator_script]</a>.  
PayOff Formula:

$$PayOff = \sum \omega \cdot FixingAmount \cdot (K - X_A(T))$$

Where:

- $\omega \in \{-1,1\}$ is $1$ for a long and $-1$ for a short position

- $FixingAmount$: the fixing amount in currency/unit of A

- $K$: the strike. For Fx, the Fx strike rate is defined as amount in
  domestic currency (CCY2) for one unit of foreign currency (CCY1). For
  Equity and Commodity: The strike value for one unit/share/contract of
  the underlying equity or commodity, expressed in the domestic currency
  (CCY2).

- $X_A(T)$: the fixing value of the asset A at each observation date T

<div class="listing">

``` Basic
REQUIRE {FixingAmount >= 0} AND {Strike >= 0};
REQUIRE {SIZE(ConditionalObservationDates) == SIZE(ConditionalSettlementDates)};
NUMBER d, Fixing;

FOR d IN (1, SIZE(ObservationDates), 1) DO
   Fixing = Underlying(ObservationDates[d]);
   Value = Value + PAY(LongShort * FixingAmount * (Strike-Fixing), ObservationDates[d], ObservationSettlementDates[d], PayCurrency);
END;

IF Underlying(ExtensionDecisionDate)>ExtensionTrigger THEN
   FOR d IN (1, SIZE(ConditionalObservationDates), 1) DO
      Fixing = Underlying(ConditionalObservationDates[d]);
      Value = Value + PAY(LongShort * FixingAmount * (Strike-Fixing), ConditionalObservationDates[d], ConditionalSettlementDates[d], PayCurrency);
   END;
END;
currentNotional = FixingAmount * Strike; 
```

</div>

---

### Flexi Swap

The `FlexiSwapData` node is the trade data container for trade type
Flexi Swap. A Flexi Swap is a two-legged swap with optional and
customisable pre-payments. Flexi Swaps are typically used for
representing swaps linked to Asset Backed Securities with flexible
amortisation. A Flexi Swap must have two legs, one fixed and one
floating. The floating leg must have a pay frequency that is a multiple
of the fixed leg frequency and corresponding floating and fixed leg
periods must have the same notional. The legs typically have an
amortising notional and are represented by `LegData` trade component
sub-nodes, described in section
<a href="#ss:leg_data" data-reference-type="ref"
data-reference="ss:leg_data">[ss:leg_data]</a>. The `FlexiSwapData` node
also contains a `OptionLongShort` node indicating the holder of the
prepayment option and a node describing the optional prepayments, see
below.

An example structure of a `FlexiSwapData` node is shown in Listing
<a href="#lst:flexiswap_data" data-reference-type="ref"
data-reference="lst:flexiswap_data">[lst:flexiswap_data]</a>. In this
case the optional pre-payments are given by a subnode
`LowerNotionalBounds` meaning that the notional of the swap can be
reduced to any value between the given lower bound and the original
notional in each fixed leg period.

<div class="listing">

``` xml
<FlexiSwapData>
  <LowerNotionalBounds>
        <Notional>451389557.145667</Notional>
        <Notional>427876791.621303</Notional>
        <Notional>404435982.369285</Notional>
        <Notional>379353200.32956</Notional>
        ...
  </LowerNotionalBounds>
  <OptionLongShort>Short</OptionLongShort>
  <LegData>
    <LegType>Fixed</LegType>
    ...
  </LegData>
  <LegData>
    <LegType>Floating</LegType>
    ...
  </LegData>
</FlexiSwapData>
```

</div>

Alternatively the optional pre-payments can be described by a subnode
`NotionalDecreases` which is more general than the description via
LowerNotionalBounds (using the reduction type RedutionToLowerBound, see
below for more details on this), see Listing
<a href="#lst:flexiswap_data2" data-reference-type="ref"
data-reference="lst:flexiswap_data2">[lst:flexiswap_data2]</a> for an
example.

<div class="listing">

``` xml
<FlexiSwapData>
  <Prepayment>
    <NoticePeriod>5D</NoticePeriod>
    <NoticeCalendar>TARGET</NoticeCalendar>
    <NoticeConvention>F</NoticePeriod>
    <PrepaymentOptions>
      <PrepaymentOption>
        <ExerciseDate>2015-02-01</ExerciseDate>
        <Type>ReductionUpToLowerBound</Type>
        <Value>404435982.369285</Value>
      </PrepaymentOption>
      <PrepaymentOption>
        <ExerciseDate>2016-02-01</ExerciseDate>
        <Type>ReductionByAbsoluteAmount</Type>
        <Value>100000.0</Value>
      </PrepaymentOption>
      <PrepaymentOption>
        <ExerciseDate>2017-02-01</ExerciseDate>
        <Type>ReductionUpToAbsoluteAmount</Type>
        <Value>50000.0</Value>
      </PrepaymentOption>
    <PrepaymentOptions>
  </Prepayment>
  <OptionLongShort>Short</OptionLongShort>
  <LegData>
    <LegType>Fixed</LegType>
    ...
  </LegData>
  <LegData>
    <LegType>Floating</LegType>
    ...
  </LegData>
</FlexiSwapData>
```

</div>

The meanings and allowable values of the elements in the `FlexiSwapData`
node follow below.

- OptionLongShort: Specifies which party has the right to pre-pay the
  notional down to the lower notional bound. *Short* means that for
  pricing purposes pre-payments are assumed to be done in such a way to
  maximise the value of the Flexi Swap for the “other” counterparty,
  *Long* means that the Flexi Swap value is maximised from “our” point
  of view.

  Allowable values: *Long* or *Short*

- LegData: This is a trade component sub-node outlined in section
  <a href="#ss:leg_data" data-reference-type="ref"
  data-reference="ss:leg_data">[ss:leg_data]</a>. A Flexi Swap must have
  two `LegData` nodes and the LegType element must be set to *Floating*
  on one leg and *Fixed* on the other. The two legs must have the same
  `Currency`. The float leg pay frequency must be a multiple of the
  fixed leg frequency.

The optional prepayments are described by either a `LowerNotionalBounds`
node or a `Prepyment` node.

In case the optional prepayments are described by a
`LowerNotionalBounds` node, the minimum level to which the notional can
be amortised down to must be given as a notional schedule. The schedule
can be specified as described in
<a href="#ss:leg_data" data-reference-type="ref"
data-reference="ss:leg_data">[ss:leg_data]</a>, i.e. using a sequence of
`Notional` subnodes or using the `startDate` attribute to specify
notional changes. The given schedule must be given for the fixed leg
periods since the notional can be decreased for each whole fixed leg
period and the corresponding floating leg periods (remember that the
floating leg frequency must be a multiple of the fixed leg frequency).
Each lower notional bound child element can take a positive real number
that cannot exceed the notional amount of the corresponding coupon
period on either leg and (from the second fixed coupon period on) the
lower notional bound of the previous coupon period.

In case the optional prepayments are described by a `Prepayment` node,
the single exercise opportunities are described by a `PrepaymentOptions`
subnode that contains one or several `PerpaymentOption` subnodes, each
of which comprises the following elements:

- ExerciseDate: The date on which the notional can be decreased.

- Type: The type of the allowed notional reduction. The allowable types
  are

  - ReductionUpTpLowerBound: The notional can be reduced to any value
    between the current notional and the lower bound given in the Value
    node.

  - ReductionByAbsoluteAmount: The notional can be reduced by an
    absolute amount given in the Value node. If this value is greater
    than the current notional, the reduction amount is equal to the
    current notional.

  - ReductionUpToAbsoluteAmount: The notional can be reduced by any
    value between zero and a given absolute amount (given in the Value
    node).

- Value: The value that together with the type describes the amount by
  which the notional can be decreased.

In addition the `Prepayment` node contains the following optional
subnodes describing the conventions for deriving the option notice date
from the exercise date:

- NoticePeriod \[Optional\]: The notice period defining the date
  (relative to the exercise date) on which the exercise decision has to
  be taken. If not given the notice period defaults to 0D, i.e. the
  notice date is identical to the exercise date.

- NoticeCalendar \[Optional\]: The calendar used to compute the notice
  date from the exercise date. If not given defaults to the null
  calendar (no holidays, weekends are no holidays either).

- NoticeConvention \[Optional\]: The convention used to compute the
  notice date from the exercise date. Defaults to Unadjusted if not
  given.

---

### Forward Bond

A Forward Bond (or Bond Forward) is a contract that establishes an
agreement to buy or sell (determined by `LongInForward`) an underlying
bond at a future point in time (the `ForwardMaturityDate`) at an agreed
price (the settlement `Amount`).

A T-Lock is a Forward Bond with a US Treasury Bond as underlying,
whereas a J-Lock is a Forward Bond with a Japanese Government Bond as
underlying. T-Locks can be specified in terms of a lock-in yield rather
then a settlement amount. The cash settlement amount is given by (bond
yield at maturity - lock rate) x DV01 in this case.

Listing <a href="#lst:forward_bond" data-reference-type="ref"
data-reference="lst:forward_bond">[lst:forward_bond]</a> shows an
example for a physically settled forward bond. Listing
<a href="#lst:forward_bond_tlock" data-reference-type="ref"
data-reference="lst:forward_bond_tlock">[lst:forward_bond_tlock]</a>
shows an example for a cash settled T-Lock transaction specified by a
lock-in yield.

A Forward Bond is set up using a `ForwardBondData` block as shown below
and the trade type is *ForwardBond*. The specific elements are

- BondData: A `BondData` block specifying the underlying bond as
  described in section <a href="#ss:bond" data-reference-type="ref"
  data-reference="ss:bond">[ss:bond]</a>. A long position must be taken
  in the bond, i.e. (`Payer`) flag must be set to (`true`). The bond
  data block contains additional fields for forward bonds

  - IncomeCurveId: The benchmark curve to be used for compounding, this
    must match a name of a curve in the yield curves or index curve
    block in `todaysmarket.xml`. It is optional to provide this curve.
    If left out the market reference yield curve from `todaysmarket.xml`
    is used for compounding.

- SettlementData: The entity defining the terms of settlement:

  - ForwardMaturityDate: The date of maturity of the forward contract.  
    Allowable values: See `Date` in Table
    <a href="#tab:allow_stand_data" data-reference-type="ref"
    data-reference="tab:allow_stand_data">[tab:allow_stand_data]</a>.

  - Settlement \[Optional\]: Cash or Physical. Option, defaults to
    Physcial, except in case the settlement is defined by LockRate, in
    which case it defaults to Cash.  
    Allowable values: Cash, Physical

  - Amount \[Optional\]: The settlement amount (also called strike)
    transferred at forward maturity in return for the bond (physical
    delivery) or a cash amount equal to the dirty price of the bond
    (cash settlement). This is transferred from the party that is long
    to the party that is short (determined by `LongInForward`) and
    cannot be a negative amount. It is assumed to be in the same
    currency as the underlying bond. Exactly one of the fields Amount,
    LockRate must be given.  
    Allowable values: Any non-negative real number.

  - LockRate \[Optional\]: The payoff is given by (yield at forward
    maturity - LockRate) x DV01 (LongInForward = true). Exactly one of
    the fields Amount, LockRate must be given. In case the LockRate is
    given, the Settlement must be set to Cash. If Settlement is not
    given, it defaults to Cash in this case.  
    Allowable values: Any non-negative real number.

  - LockRateDayCounter \[Optional\]: The day counter w.r.t. which the
    lock rate is expressed. Optional, defaults to A360.  
    Allowable values: see table
    <a href="#tab:daycount" data-reference-type="ref"
    data-reference="tab:daycount">[tab:daycount]</a>

  - SettlementDirty \[Optional\]: A flag that determines whether the
    settlement amount (`Amount`) reflects a clean (*false*) or dirty
    (*true*) price. In either case, the dirty amount is actually paid on
    the forward maturity date, i.e. if SettlementDirty = *false*, the
    (forward) accruals are computed internally and added to the given
    amount to get the actual settlement amount. Optional, defaults to
    true.  
    Allowable values: *true*, *false*

- PremiumData: The entity defining the terms of a potential premium
  payment. This node is optional. If left out it is assumed that no
  premium is paid.

  - Date: The date when a premium is paid.  
    Allowable values: See `Date` in Table
    <a href="#tab:allow_stand_data" data-reference-type="ref"
    data-reference="tab:allow_stand_data">[tab:allow_stand_data]</a>.

  - Amount: The amount transferred as a premium. This is transferred
    from the party that is long to the party that is short (determined
    by `LongInForward`) and cannot be a negative amount. It is assumed
    to be in the same currency as the underlying bond.  
    Allowable values: Any non-negative real number.

- LongInForward: A flag that determines whether the forward contract is
  entered in long (*true*) or short (*false*) position.  
  Allowable values: *true*, *false*

- KnockOut \[Optional\]: If true the contract terminates without payout
  if the underlying bond defaults before the forward maturity date. If
  not given, defaults to false for a vanilla payoff and true for a lock
  rate payoff.  
  Allowable values: *true*, *false*

<div class="listing">

``` xml
   <ForwardBondData>
     <BondData>
      ...
      <IncomeCurveId>BENCHMARKINCOME-EUR<IncomeCurveId>
     </BondData>
     <SettlementData>
       <ForwardMaturityDate>20160808</ForwardMaturityDate>
       <Settlement>Physcial</Settlement>
       <ForwardSettlementDate>20160810</ForwardSettlementDate>
       <Amount>1000000.00</Amount>
       <SettlementDirty>true</SettlementDirty>
     </SettlementData>
     <PremiumData>
       <Amount>1000.00</Amount>
       <Date>20160808</Date>
     </PremiumData>
     <LongInForward>true</LongInForward>
   </ForwardBondData>
```

</div>

<div class="listing">

``` xml
   <ForwardBondData>
     <BondData>
      ...
     </BondData>
     <SettlementData>
       <ForwardMaturityDate>20160808</ForwardMaturityDate>
       <ForwardSettlementDate>20160810</ForwardSettlementDate>
       <LockRate>0.02365</LockRate>
     </SettlementData>
     <LongInForward>true</LongInForward>
   </ForwardBondData>
```

</div>

As for the ordinary bond the forward bond pricing requires a recovery
rate that can be specified in ORE per SecurityId.

### Forward Bond - Pricing Engine configuration

The configuration for the pricing engine of the forward bond is
identical to the ordinary bond. The pricing engine called by forward
bond products is the `DiscountingForwardBondEngine`, see below for a
configuration example.

``` xml
   <Product type="ForwardBond">
   <Model>DiscountedCashflows</Model>
   <ModelParameters></ModelParameters>
   <Engine>DiscountingForwardBondEngine</Engine>
   <EngineParameters>
    <Parameter name="TimestepPeriod">3M</Parameter>
   </EngineParameters>
   </Product>
```

---

### Forward Rate Agreement

A forward rate agreement (trade type *ForwardRateAgreement* is set up
using a  
`ForwardRateAgreementData` block as shown in listing
<a href="#lst:ForwardRateAgreementdata" data-reference-type="ref"
data-reference="lst:ForwardRateAgreementdata">[lst:ForwardRateAgreementdata]</a>.
The forward rate agreement specific elements are:

- StartDate: A FRA expires/settles on the startDate.  
  Allowable values: See `Date` in Table
  <a href="#tab:allow_stand_data" data-reference-type="ref"
  data-reference="tab:allow_stand_data">[tab:allow_stand_data]</a>.

- EndDate: EndDate is the date when the forward loan or deposit ends. It
  follows that (EndDate - StartDate) is the tenor/term of the underlying
  loan or deposit.

  Allowable values: See `Date` in Table
  <a href="#tab:allow_stand_data" data-reference-type="ref"
  data-reference="tab:allow_stand_data">[tab:allow_stand_data]</a>.

- Currency: The currency of the FRA notional.  
  Allowable values: See Table
  <a href="#tab:currency" data-reference-type="ref"
  data-reference="tab:currency">[tab:currency]</a> `Currency`.

- Index: The name of the interest rate index the FRA is benchmarked
  against.

  Allowable values: An alphanumeric string of the form CCY-INDEX-TENOR.
  CCY, INDEX and TENOR must be separated by dashes (-). CCY and INDEX
  must be among the supported currency and index combinations. TENOR
  must be an integer followed by D, W, M or Y, except for Overnight
  indices which do not require a TENOR. See Table
  <a href="#tab:indices" data-reference-type="ref"
  data-reference="tab:indices">[tab:indices]</a>.

- LongShort: Specifies whether the FRA position is long (one receives
  the agreed rate) or short (one pays the agreed rate).

  Allowable values: *Long*, *Short*.

- Strike: The agreed forward interest rate.

  Allowable values: Any real number. The strike rate is expressed in
  decimal form, e.g. 0.05 is a rate of 5%.

- Notional: No accretion or amortisation, just a constant notional.  
  Allowable values: Any positive real number.

<div class="listing">

``` xml
    <ForwardRateAgreementData>
        <StartDate>20161028</StartDate>
        <EndDate>20351028</EndDate>
        <Currency>EUR</Currency>
        <Index>EUR-EURIBOR-6M</Index>
        <LongShort>Long</LongShort>
        <Strike>0.001</Strike>
        <Notional>1000000000</Notional>
    </ForwardRateAgreementData>
```

</div>

---

### FX Accumulator

FX Accumulators are represented as scripted trades, refer to appendix A
for an introduction. Listing
<a href="#lst:fxaccumulator" data-reference-type="ref"
data-reference="lst:fxaccumulator">[lst:fxaccumulator]</a> shows the
structure of an example. The `PerformanceOption_01` node is the trade
data container for the PerformanceOption_01 trade type, listing
<a href="#lst:fxaccumulator" data-reference-type="ref"
data-reference="lst:fxaccumulator">[lst:fxaccumulator]</a> shows the
structure of an example.

<div class="listing">

``` xml
<Trade id="SCRIPTED_FX_ACCUMULATOR">
  <TradeType>ScriptedTrade</TradeType>
  <Envelope>
    <CounterParty>CPTY_A</CounterParty>
    <NettingSetId>CPTY_A</NettingSetId>
    <AdditionalFields/>
  </Envelope>
  <ScriptedTradeData>
    <ScriptName>Accumulator</ScriptName>
    <Data>
      <Number>
        <Name>Strike</Name>
        <Value>1.1</Value>
      </Number>
      <Number>
        <Name>Quantity</Name>
        <Value>1000000</Value>
      </Number>
      <Number>
        <Name>LongShort</Name>
        <Value>1</Value>
      </Number>
      <Index>
        <Name>Underlying</Name>
        <Value>FX-ECB-EUR-USD</Value>
      </Index>
      <Currency>
        <Name>PayCcy</Name>
        <Value>USD</Value>
      </Currency>
      <Event>
        <Name>FixingDates</Name>
        <ScheduleData>
          <Dates>
            <Dates>
                <Date>2029-03-01</Date>
            </Dates>
          </Dates>
        </ScheduleData>
        <ApplyCoarsening>true</ApplyCoarsening>
      </Event>
      <Number>
        <Name>RangeUpperBounds</Name>
        <Values>
            <Value>100000</Value>
        </Values>
      </Number>
      <Number>
        <Name>RangeLowerBounds</Name>
        <Values>
            <Value>0</Value>
        </Values>
      </Number>
      <Number>
        <Name>RangeLeverages</Name>
        <Values>
            <Value>1</Value>
        </Values>
      </Number>
      <Number>
        <Name>KnockOutLevel</Name>
        <Value>10</Value>
      </Number>
      <Number>
        <Name>GuaranteedFixings</Name>
        <Value>2</Value>
      </Number>
    </Data>
  </ScriptedTradeData>
</Trade>
```

</div>

The meanings and allowable values of the elements in the
`FX Accumulator` representation follow below.

- Strike: The strike value the bought currency is purchased at.

- FixedAmount: The unleveraged notional amount accumulated at each
  fixing date

- LongShort: 1 for a long, -1 for a short position

- Underlying: The underlying FX Index.

- PayCcy: The payment currency of the trade

- FixingDates: The fixing dates, given as a ScheduleData node

- RangeUpperBound: Values of upperbounds for the leverage ranges. If a
  given range has no upperbound add 100000

- RangeLowerBound: Values of lowerbounds for the leverage ranges. If a
  given range has no lowerbound add 0

- RangeLeverages: Values of leverages for the leverage ranges.

- KnockOutLevel: The KnockOut Barrier level

- GuaranteedFixings: Number of the first n Fixings that are guaranteed,
  regardless of whether or not the trade has been knocked out.

The script ‘Accumulator’ referenced in the trade above is shown in
Listing <a href="#lst:accumulator_script" data-reference-type="ref"
data-reference="lst:accumulator_script">[lst:accumulator_script]</a>.

<div class="listing">

``` xml

NUMBER Payoff, fix, d, r, Triggered;
Payoff = 0;
Triggered = -1;
FOR d IN (1, SIZE(FixingDates)) DO
    fix = Underlying(FixingDates[d]);
    
    IF fix >= KnockOutLevel THEN
      Triggered = 1;
    END;
    IF Triggered != 1 OR d <= GuaranteedFixings THEN
        FOR r IN (1, SIZE(RangeUpperBounds)) DO
            IF fix > RangeLowerBounds[r] AND fix <= RangeUpperBounds[r] THEN
                Payoff = Payoff + PAY(RangeLeverages[r] * FixingAmount * (fix - Strike), FixingDates[d], FixingDates[d], PayCcy);
            END;
        END;
    END;
END;
value = LongShort * Payoff;
```

</div>

---

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

---

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

---

### FX Digital Barrier Option

An FX Digital Barrier Option pays a given cash amount in domestic
currency at expiry, if the underlying fx rate has hit (or not hit) a
continuously monitored barrier (as for the FxTouchOption) and the fx
rate at the expiry date is above (call) or below (put) a given strike.

The `FxDigitalBarrierOptionData` node is the trade data container for
the *FxDigitalBarrierOption* trade type. The
`FxDigitalBarrierOptionData` node includes one `OptionData` trade
component sub-node and one `BarrierData` trade component sub-node plus
elements specific to the FX Digital Barrier Option.

The structure of an example `FxDigitalBarrierOptionData` node for a FX
Digital Barrier Option is shown in Listing
<a href="#lst:fxdigitalbarrieroption_data" data-reference-type="ref"
data-reference="lst:fxdigitalbarrieroption_data">[lst:fxdigitalbarrieroption_data]</a>.

<div class="listing">

``` xml
        <FxDigitalBarrierOptionData>
            <OptionData>
                <LongShort>Long</LongShort>
                <OptionType>Call</OptionType>
                <Style>European</Style>
                <ExerciseDates>
                 <ExerciseDate>2021-12-14</ExerciseDate>
                </ExerciseDates>
                ...
            </OptionData>
            <BarrierData>
                <Type>DownAndIn</Type>
                <Levels>
                    <Level>1.18</Level>
                </Levels>
            </BarrierData>
            <StartDate>2019-01-25</StartDate>
            <Calendar>TARGET</Calendar>
            <FXIndex>FX-ECB-EUR-USD</FXIndex>
            <Strike>1.1</Strike>
            <PayoffAmount>100000</PayoffAmount>
            <PayoffCurrency>USD</PayoffCurrency>
            <ForeignCurrency>EUR</ForeignCurrency>
            <DomesticCurrency>USD</DomesticCurrency>
        </FxDigitalBarrierOptionData>
```

</div>

The meanings and allowable values of the elements in the
`FxDigitalBarrierOptionData` node follow below.

- OptionData: This is a trade component sub-node outlined in section
  <a href="#ss:option_data" data-reference-type="ref"
  data-reference="ss:option_data">[ss:option_data]</a>. The relevant
  fields in the `OptionData` node for an FxDigitalBarrierOption are:

  - `LongShort` The allowable values are *Long* or *Short*.

  - `OptionType` The allowable values are *Call* or *Put*. Given
    knock-in or no knock-out, *Call* means that the digital payout will
    occur if the fx rate at the expiry date is above the given strike,
    and *Put* means that the digital payout will occur if the fx rate at
    the expiry date is below the given strike.

  - `Style` The FX Digital Barrier Option type allows for *European*
    option exercise style only.

  - An `ExerciseDates` node where exactly one ExerciseDate date element
    must be given.

  - `Premiums` \[Optional\]: Option premium amounts paid by the option
    buyer to the option seller.

    Allowable values: See section
    <a href="#ss:premiums" data-reference-type="ref"
    data-reference="ss:premiums">[ss:premiums]</a>

- BarrierData: This is a trade component sub-node outlined in section
  <a href="#ss:barrier_data" data-reference-type="ref"
  data-reference="ss:barrier_data">[ss:barrier_data]</a>.

  Note that the *FxDigitalBarrierOption* is a single barrier instrument,
  and can have only one BarrierData node with one barrier level.

  Level specified in BarrierData should be quoted as the amount in
  DomesticCurrency per one unit of ForeignCurrency, with both currencies
  as defined in FxDigitalBarrierOptionData node.

  Type specified in BarrierData can be one of: *UpAndIn, DownAndIn,
  UpAndOut, DownAndOut*

  StrictComparison \[Optional\]: Define whether we apply $<=$, $>=$ or
  $<$, $>$ for the barrier check. Defaults to *0* and $<=$, $>=$, *1*
  for $<$, $>$.

- StartDate\[Optional\]: The start date for checking if a barrier has
  been breached prior to today’s date. If omitted or left blank no check
  is made and it is assumed no barrier has been breached in the past.
  Has no impact if set to today’s date or a date in the future.
  If‘StartDate’ is provided then the fixings for dates between this date
  and the asof date are checked to see if the option was triggered. If
  no fixing is available then we skip that date. This is to allow for
  backwards compatibility.

  Allowable values: See `Date` in Table
  <a href="#tab:allow_stand_data" data-reference-type="ref"
  data-reference="tab:allow_stand_data">[tab:allow_stand_data]</a>.

- Calendar\[Optional\]: The calendar associated with the FX Index.
  Required if StartDate is set to a date prior to today’s date,
  otherwise optional.

  Allowable values: See Table
  <a href="#tab:calendar" data-reference-type="ref"
  data-reference="tab:calendar">[tab:calendar]</a> Calendar.

- FXIndex\[Optional\]: A reference to an FX Index source to check if the
  barrier has been breached. Required if StartDate is set to a date
  prior to today’s date, otherwise optional, and can be omitted but not
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

- Strike: The FX strike price, expressed as the amount in
  DomesticCurrency per one unit of ForeignCurrency.

  Allowable values: Any positive real number.

- PayoffAmount: The fixed payoff amount expressed in the PayoffCurrency.
  It is cash-or-nothing payoff that depends on the option being in or
  out of the money, and whether the barrier has been breached.

  Allowable values: Any positive real number.

- PayoffCurrency\[Optional\]: The payoff currency of the FX digital
  option is the currency of the payoff amount. Must be either the
  Domestic or Foreign currency for this trade, If omitted this defaults
  to DomesticCurrency as defined in FxDigitalBarrierOptionData node.

  Allowable values: See Table
  <a href="#tab:currency" data-reference-type="ref"
  data-reference="tab:currency">[tab:currency]</a> `Currency`.

- ForeignCurrency: The foreign currency of the FX digital barrier option
  is equivalent to the bought currency.

  Allowable values: See Table
  <a href="#tab:currency" data-reference-type="ref"
  data-reference="tab:currency">[tab:currency]</a> `Currency`.

- DomesticCurrency: The domestic currency of the FX digital barrier
  option is equivalent to the sold currency.

  Allowable values: See Table
  <a href="#tab:currency" data-reference-type="ref"
  data-reference="tab:currency">[tab:currency]</a> `Currency`.

Note that FX Digital Barrier Options also cover Precious Metals, i.e.
with currencies XAU, XAG, XPT, XPD, and Cryptocurrencies, see supported
Cryptocurrencies in Table
<a href="#tab:currency" data-reference-type="ref"
data-reference="tab:currency">[tab:currency]</a>.

---

### FX Digital Option

The `FxDigitalOptionData` node is the trade data container for the
*FxDigitalOption* trade type. The `FxDigitalOptionData` node includes
one `OptionData` trade component sub-node plus elements specific to the
FX Digital Option. The structure of an example `FxDigitalOptionData`
node for a FX Digital Option is shown in Listing
<a href="#lst:fxdigitaloption_data" data-reference-type="ref"
data-reference="lst:fxdigitaloption_data">[lst:fxdigitaloption_data]</a>.

<div class="listing">

``` xml
        <FxDigitalOptionData>
            <OptionData>
                <LongShort>Long</LongShort>
                <OptionType>Call</OptionType>
                <Style>European</Style>              
                <ExerciseDates>
                 <ExerciseDate>2021-12-14</ExerciseDate>
                </ExerciseDates> 
                ...
            </OptionData>
            <Strike>1.1</Strike>
            <PayoffCurrency>USD</PayoffCurrency>            
            <PayoffAmount>100000</PayoffAmount>            
            <ForeignCurrency>EUR</ForeignCurrency>
            <DomesticCurrency>USD</DomesticCurrency>
        </FxDigitalOptionData>
```

</div>

The meanings and allowable values of the elements in the
`FxDigitalOptionData` node follow below.

- OptionData: This is a trade component sub-node outlined in section
  <a href="#ss:option_data" data-reference-type="ref"
  data-reference="ss:option_data">[ss:option_data]</a>. The relevant
  fields in the `OptionData` node for an FxDigitalOption are:

  - `LongShort` The allowable values are *Long* or *Short*.

  - `OptionType` The allowable values are *Call* or *Put*. *Call* means
    that the digital payout will occur if the fx rate at the expiry date
    is above the given strike, and *Put* means that the digital payout
    will occur if the fx rate at the expiry date is below the given
    strike.

  - `Style` The FX Digital Option type allows for *European* option
    exercise style only.

  - An `ExerciseDates` node where exactly one ExerciseDate date element
    must be given.

  - `Premiums` \[Optional\]: Option premium amounts paid by the option
    buyer to the option seller.

    Allowable values: See section
    <a href="#ss:premiums" data-reference-type="ref"
    data-reference="ss:premiums">[ss:premiums]</a>

- Strike: The FX strike price, expressed as the amount in
  DomesticCurrency per one unit of ForeignCurrency.

  Allowable values: Any positive real number.

- PayoffCurrency\[Optional\]: The payoff currency of the FX digital
  option is the currency of the payoff amount. Must be either the
  Domestic or Foreign currency for this trade, If omitted this defaults
  to the domestic currency.

  Allowable values: See Table
  <a href="#tab:currency" data-reference-type="ref"
  data-reference="tab:currency">[tab:currency]</a> `Currency`.

- PayoffAmount: The fixed payoff amount expressed in payoff currency. It
  is cash-or-nothing payoff that depends on the option being in or out
  of the money.

  Allowable values: Any positive real number.

- ForeignCurrency: The foreign currency of the FX digital option is
  equivalent to the bought currency.

  Allowable values: See Table
  <a href="#tab:currency" data-reference-type="ref"
  data-reference="tab:currency">[tab:currency]</a> `Currency`.

- DomesticCurrency: The domestic currency of the FX digital option is
  equivalent to the sold currency.

  Allowable values: See Table
  <a href="#tab:currency" data-reference-type="ref"
  data-reference="tab:currency">[tab:currency]</a> `Currency`.

Note that FX Digital Options also cover Precious Metals, i.e. with
currencies XAU, XAG, XPT, XPD, and Cryptocurrencies, see supported
Cryptocurrencies in Table
<a href="#tab:currency" data-reference-type="ref"
data-reference="tab:currency">[tab:currency]</a>.

---

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

---

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

---

### FX European Barrier Option

European exercise, European barrier.

An FX European Barrier option gives the buyer the right, but not the
obligation, to exchange a set amount of one currency for another, at a
predetermined exchange rate, at one predetermined time in the future.
This right may be withdrawn depending upon an FX spot rate reaching a
predetermined barrier level at the predetermined time, the underlying is
monitored only at expiry with a single barrier (European Barrier style).

The `FxEuropeanBarrierOptionData` node is the trade data container for
the *FxEuropeanBarrierOption* trade type. The barrier level of an FX
European Barrier Option is quoted as the amount in SoldCurrency per unit
BoughtCurrency. The `FxEuropeanBarrierOptionData` node includes one
`OptionData` trade component sub-node and one `BarrierData` trade
component sub-node plus elements specific to the FX Barrier Option.

The structure of an example `FxEuropeanBarrierOptionData` node for a FX
European Barrier Option is shown in Listing
<a href="#lst:fxeuropeanbarrieroption_data" data-reference-type="ref"
data-reference="lst:fxeuropeanbarrieroption_data">[lst:fxeuropeanbarrieroption_data]</a>.

<div class="listing">

``` xml
        <FxEuropeanBarrierOptionData>
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
             <Rebate>100000</Rebate>            
            </BarrierData>
            <BoughtCurrency>EUR</BoughtCurrency>
            <BoughtAmount>1000000</BoughtAmount>
            <SoldCurrency>USD</SoldCurrency>
            <SoldAmount>1100000</SoldAmount>
        </FxEuropeanBarrierOptionData>
```

</div>

The meanings and allowable values of the elements in the
`FxEuropeanBarrierOptionData` node follow below.

- OptionData: This is a trade component sub-node outlined in section
  <a href="#ss:option_data" data-reference-type="ref"
  data-reference="ss:option_data">[ss:option_data]</a>. The relevant
  fields in the `OptionData` node for an FxEuropeanBarrierOption are:

  - `LongShort` The allowable values are *Long* or *Short*.

  - `OptionType` The allowable values are *Call* or *Put*.  
    *Call* means that the holder of the option, upon expiry - assuming
    knock-in or no knock-out - has the right to receive the BoughtAmount
    and pay the SoldAmount.  
    *Put* means that the Bought and Sold currencies/amounts are switched
    compared to the trade data node. For example, holder of
    BoughtCurrency EUR SoldCurrency JPY FX European Barrier Call Option
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

  - `Style` The FX European Barrier Option type allows for *European*
    option exercise style only.

  - `Settlement` The allowable values are *Cash* or *Physical*.

  - An `ExerciseDates` node where exactly one ExerciseDate date element
    must be given.

  - A `PaymentData` \[Optional\] node can be added which defines the
    settlement date of the option payoff.

  - `Premiums` \[Optional\]: Option premium amounts paid by the option
    buyer to the option seller. See section
    <a href="#ss:premiums" data-reference-type="ref"
    data-reference="ss:premiums">[ss:premiums]</a>

- BarrierData: This is a trade component sub-node outlined in section
  <a href="#ss:barrier_data" data-reference-type="ref"
  data-reference="ss:barrier_data">[ss:barrier_data]</a>. Level
  specified in BarrierData should be quoted as the amount in
  SoldCurrency per unit BoughtCurrency, with both currencies as defined
  in FxEuropeanBarrierOptionData node. Changing the option from Call to
  Put or vice versa does not require switching the barrier level, i.e.
  the level stays quoted as SoldCurrency per unit BoughtCurrency,
  regardless of Put/Call.

- BoughtCurrency: The bought currency of the FX barrier option. See
  OptionData above for more details.

  Allowable values: See Table
  <a href="#tab:currency" data-reference-type="ref"
  data-reference="tab:currency">[tab:currency]</a> `Currency`.

- BoughtAmount: The amount in the BoughtCurrency.

  Allowable values: Any positive real number.

- SoldCurrency: The sold currency of the FX barrier option. See
  OptionData above for more details.

  Allowable values: See Table
  <a href="#tab:currency" data-reference-type="ref"
  data-reference="tab:currency">[tab:currency]</a> `Currency`.

- SoldAmount: The amount in the SoldCurrency.

  Allowable values: Any positive real number.

Note that FX European Barrier Options also cover Precious Metals, i.e.
with currencies XAU, XAG, XPT, XPD, and Cryptocurrencies, see supported
Cryptocurrencies in Table
<a href="#tab:currency" data-reference-type="ref"
data-reference="tab:currency">[tab:currency]</a>.

---

### FX Forward

The `FXForwardData` node is the trade data container for the *FxForward*
trade type. The structure - including example values - of the
`FXForwardData` node is shown in Listing
<a href="#lst:fxforward_data" data-reference-type="ref"
data-reference="lst:fxforward_data">[lst:fxforward_data]</a>.

<div class="listing">

``` xml
        <FxForwardData>
            <ValueDate>2023-04-09</ValueDate>
            <BoughtCurrency>EUR</BoughtCurrency>
            <BoughtAmount>1000000</BoughtAmount>
            <SoldCurrency>USD</SoldCurrency>
            <SoldAmount>1500000</SoldAmount>
            <Settlement>Physical</Settlement>
            <SettlementData>
              ...
            </SettlementData>
        </FxForwardData>
```

</div>

The meanings and allowable values of the various elements in the
`FXForwardData` node follow below.

- ValueDate: The value date of the FX Forward.  
  Allowable values: See `Date` in Table
  <a href="#tab:allow_stand_data" data-reference-type="ref"
  data-reference="tab:allow_stand_data">[tab:allow_stand_data]</a>.

- BoughtCurrency: The currency to be bought on value date.  
  Allowable values: See Table
  <a href="#tab:currency" data-reference-type="ref"
  data-reference="tab:currency">[tab:currency]</a> `Currency`.

- BoughtAmount: The amount to be bought on value date.  
  Allowable values: Any positive real number.

- SoldCurrency: The currency to be sold on value date.  
  Allowable values: See Table
  <a href="#tab:currency" data-reference-type="ref"
  data-reference="tab:currency">[tab:currency]</a> `Currency`.

- SoldAmount: The amount to be sold on value date.  
  Allowable values: Any positive real number.

- Settlement \[Optional\]: Delivery type. Note that Non-Deliverable
  Forwards can be represented by *Cash* settlement.  
  Allowable values: *Cash* or *Physical*. Defaults to *Physical* if left
  blank or omitted.

- SettlementData \[Optional\]: This node is used to specify the
  settlement of the cash flows on the value date.

A `SettlementData` node is shown in Listing
<a href="#lst:settlement_data_node" data-reference-type="ref"
data-reference="lst:settlement_data_node">[lst:settlement_data_node]</a>,
and the meanings and allowable values of its elements follow below.

- Currency: The currency in which the FX Forward is settled. This field
  is only used if settlement is *Cash*.  
  Allowable values: See Table
  <a href="#tab:currency" data-reference-type="ref"
  data-reference="tab:currency">[tab:currency]</a> `Currency`. Defaults
  to the sold currency if left blank or omitted.

- FXIndex: The FX reference index for determining the FX fixing at the
  value date. This field is required if settlement is *Cash* and the
  payment date is greater than the value date. Otherwise, it is
  ignored.  
  Allowable values: The format of the `FXIndex` is
  “FX-FixingSource-CCY1-CCY2” as described in Table
  <a href="#tab:fxindex_data" data-reference-type="ref"
  data-reference="tab:fxindex_data">[tab:fxindex_data]</a>.

- Date \[Optional\]: If specified, this will be the payment date.  
  Allowable values: See `Date` in Table
  <a href="#tab:allow_stand_data" data-reference-type="ref"
  data-reference="tab:allow_stand_data">[tab:allow_stand_data]</a>. If
  left blank or omitted, defaults to the value date with some
  adjustments applied from the `Rules` sub-node.

- Rules \[Optional\]: If `Date` is left blank or omitted, this node will
  be used to derive the payment date from the value date. The `Rules`
  sub-node is shown in Listing
  <a href="#lst:settlement_data_node" data-reference-type="ref"
  data-reference="lst:settlement_data_node">[lst:settlement_data_node]</a>,
  and the meanings and allowable values of its elements follow below.

  - PaymentLag \[Optional\]: The lag between the value date and the
    payment date.  
    Allowable values: Any valid period, i.e. a non-negative whole
    number, optionally followed by *D* (days), *W* (weeks), *M*
    (months), *Y* (years). For cash settlement and if a FXIndex is
    specified defaults to the fx convention (field “SpotDays”) if blank
    or omitted, otherwise to 0. If a whole number is given and no
    letter, it is assumed that it is a number of *D* (days).

  - PaymentCalendar \[Optional\]: The calendar to be used when applying
    the payment lag.  
    Allowable values: See Table
    <a href="#tab:calendar" data-reference-type="ref"
    data-reference="tab:calendar">[tab:calendar]</a> `Calendar`. For
    cash settlement and if a FXIndex is specified defaults to the fx
    convention (field “AdvanceCalendar”) if left blank or omitted,
    otherwise to NullCalendar (no holidays).

  - PaymentConvention \[Optional\]: The roll convention to be used when
    applying the payment lag.  
    Allowable values: See Table
    <a href="#tab:convention" data-reference-type="ref"
    data-reference="tab:convention">[tab:convention]</a> Roll
    Convention. For cash settlement and if a FXIndex is specified
    defaults to the fx convention ((field “Convention”) if left blank or
    omitted, otherwise to Unadjusted.

Note that FX Forwards also cover Precious Metals forwards, i.e. with
currencies XAU, XAG, XPT, XPD, and Cryptocurrency forwards, see
supported Cryptocurrencies in Table
<a href="#tab:currency" data-reference-type="ref"
data-reference="tab:currency">[tab:currency]</a>.

<div class="listing">

``` xml
<SettlementData>
  <Currency>USD</Currency>
  <FXIndex>FX-ECB-EUR-USD</FXIndex>
  <Date>2020-09-03</Date>
  <Rules>
    <PaymentLag>2D</PaymentLag>
    <PaymentCalendar>USD</PaymentCalendar>
    <PaymentConvention>Following</PaymentConvention>
  </Rules>
</SettlementData>
```

</div>

### FX Average Forward

The `FXAverageForwardData` node is the trade data container for the
*FxAverageForward* trade type. The structure with example values node is
shown in Listing
<a href="#lst:fxaverageforward_data" data-reference-type="ref"
data-reference="lst:fxaverageforward_data">[lst:fxaverageforward_data]</a>.

<div class="listing">

``` xml
        <FxAverageForwardData>
            <PaymentDate>2023-04-09</PaymentDate>
            <!-- Schedule block that determines observation dates for FX averaging -->
            <ObservationDates>
               ...
            </ObservationDates>
            <FixedPayer>true</FixedPayer>
            <ReferenceNotional>8614</ReferenceNotional>
            <ReferenceCurrency>EUR</ReferenceCurrency>
            <SettlementNotional>10000</SettlementNotional>
            <SettlementCurrency>USD</SettlementCurrency>
            <FXIndex>FX-ECB-EUR-USD</FXIndex>
            <Settlement>Cash</Settlement>
        </FxAverageForwardData>
```

</div>

The instrument’s payoff is driven by an arithmetic average of observed
FX rates, expressed in terms of the node names:
$$\omega \times \left( \mbox{ReferenceNotional} \times \mbox{AverageFX} - \mbox{SettlementNotional}\right)$$

The meanings and allowable values of the various elements in the
`FXAverageForwardData` node follow below.

- PaymentDate: The date of the settlement cash flow.  
  Allowable values: See `Date` in Table
  <a href="#tab:allow_stand_data" data-reference-type="ref"
  data-reference="tab:allow_stand_data">[tab:allow_stand_data]</a>.

- ObservationDates: Schedule data that determine the observation dates
  that are taken into account in the FX rate averaging. See section
  <a href="#ss:schedule_data" data-reference-type="ref"
  data-reference="ss:schedule_data">[ss:schedule_data]</a>

- FixedPayer: If *true*, the payoff multiplier $\omega$ is set to 1,
  otherwise -1.  
  Allowable values: *true*, *false*

- ReferenceNotional: The amount to be converted into settlement currency
  at the average FX rate  
  Allowable values: Any positive real number.

- ReferenceCurrency: The currency of the reference notional above.  
  Allowable values: See Table
  <a href="#tab:currency" data-reference-type="ref"
  data-reference="tab:currency">[tab:currency]</a> `Currency`.

- SettlementNotional: The fixed amount to be paid or received depending
  on the fixed payer flag above  
  Allowable values: Any positive real number.

- SettlementCurrency: The currency of the settlement notional above.  
  Allowable values: See Table
  <a href="#tab:currency" data-reference-type="ref"
  data-reference="tab:currency">[tab:currency]</a> `Currency`.

- FXIndex: The FX reference index for determining the FX fixing for
  averaging.  
  Allowable values: The format of the `FXIndex` is
  “FX-FixingSource-CCY1-CCY2” as described in Table
  <a href="#tab:fxindex_data" data-reference-type="ref"
  data-reference="tab:fxindex_data">[tab:fxindex_data]</a>. Notice that
  since the payoff is based on an arithmetic average, the order of the
  currencies in the FX index matters: The averaging will be done on fx
  rates quoted as CCY1-CCY2 (foreign-domestic).

---

### FX KIKO Barrier Option

European exercise, American barriers.

An FX KIKO Barrier option is an option with both a knock-out and a
knock-in barrier. The knock-out barrier can happen at any time (American
barrier), and once the knock-in barrier is hit the trade becomes a
single (American) barrier knock-out trade. The KIKO option can only be
exercised (one time, European style) if the knock-out barrier is never
touched and the knock-in barrier is touched at least once.

The strike rate and barrier levels of an FX KIKO Barrier Option are
expressed as amount in SoldCurrency per unit BoughtCurrency.

The `FXKIKOBarrierOptionData` node is the trade data container for the
*FxKIKOBarrierOption* trade type.

The `FXKIKOBarrierOptionData` node includes one `OptionData` trade
component sub-node and two `BarrierData` trade component sub-nodes plus
elements specific to the FX KIKO Barrier Option. The structure of an
example `FXKIKOBarrierOptionData` node for a FX KIKO Barrier Option is
shown in Listing
<a href="#lst:fxkikobarrieroption_data" data-reference-type="ref"
data-reference="lst:fxkikobarrieroption_data">[lst:fxkikobarrieroption_data]</a>.

<div class="listing">

``` xml
        <FxKIKOBarrierOptionData>
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
            <Barriers>
                <BarrierData>
                    <Type>UpAndIn</Type>
                    <Levels>
                        <Level>1.2</Level>
                    </Levels>
                </BarrierData>
                <BarrierData>
                    <Type>DownAndOut</Type>
                    <Levels>
                        <Level>1.2</Level>
                    </Levels>
                </BarrierData>
            </Barriers>
            <StartDate>2019-01-25</StartDate>
            <Calendar>TARGET</Calendar>
            <FXIndex>FX-ECB-EUR-USD</FXIndex>
            <BoughtCurrency>EUR</BoughtCurrency>
            <BoughtAmount>1000000</BoughtAmount>
            <SoldCurrency>USD</SoldCurrency>
            <SoldAmount>1100000</SoldAmount>
        </FxKIKOBarrierOptionData>
```

</div>

The meanings and allowable values of the elements in the
`FXKIKOBarrierOptionData` node follow below.

- OptionData: This is a trade component sub-node outlined in section
  <a href="#ss:option_data" data-reference-type="ref"
  data-reference="ss:option_data">[ss:option_data]</a>. The relevant
  fields in the `OptionData` node for an FxKIKOBarrierOption are:

  - `LongShort` The allowable values are *Long* or *Short*.

  - `OptionType` The allowable values are *Call* or *Put*.  
    *Call* means that the holder of the option, upon expiry - assuming
    knock-in or no knock-out - has the right to receive the BoughtAmount
    and pay the SoldAmount.  
    *Put* means that the Bought and Sold currencies/amounts are switched
    compared to the trade data node. For example, holder of
    BoughtCurrency EUR SoldCurrency JPY FX KIKO Barrier Call Option has
    the right to buy EUR using JPY, while holder of the Put counterpart
    has the right to buy JPY using EUR, or equivalently sell EUR for
    JPY. An alternative to define the latter option is to copy the Call
    option with following changes:  
    a) swapping BoughtCurrency with SoldCurrency, b) swapping
    BoughtAmount with SoldAmount and c) inverting the barrier level (for
    example changing 110 to 0.0090909). Here barrier level is quoted as
    amount of EUR per unit JPY, which is not commonly seen on market and
    inconsistent with the format in Call options. For these reasons,
    using Put/Call flag instead is recommended.

  - `Style` The FX KIKO Barrier Option type allows for *European* option
    exercise style only.

  - `Settlement` The allowable values are *Cash* or *Physical*.

  - An `ExerciseDates` node where exactly one ExerciseDate date element
    must be given.

  - Premiums \[Optional\]: Option premium amounts paid by the option
    buyer to the option seller.

    Allowable values: See section
    <a href="#ss:premiums" data-reference-type="ref"
    data-reference="ss:premiums">[ss:premiums]</a>

- Barriers: This node contains two barrierData nodes, one must be a
  KnockIn barrier (*UpAndIn* or *DownAndIn*) and the other must be a
  KnockOut barrier (*UpAndOut* or *DownAndOut*).

- BarrierData: This is a trade component sub-node outlined in section
  <a href="#ss:barrier_data" data-reference-type="ref"
  data-reference="ss:barrier_data">[ss:barrier_data]</a>.
  FxKIKOBarrierOptions do not currently support rebates. Level specified
  in BarrierData should be quoted as the amount in SoldCurrency per unit
  BoughtCurrency, with both currencies as defined in
  FxKIKOBarrierOptionData node. Changing the option from Call to Put or
  vice versa does not require switching the barrier level, i.e. the
  level stays quoted as SoldCurrency per unit BoughtCurrency, regardless
  of Put/Call. The node StrictComparison forces the barrier to be strict
  if *1*, default is *0*.

  - StrictComparison \[Optional\]: *0*, *1*. Defaults to *0*. If *1* in
    one of the two barriers, it will apply the StrictComparison.
    Determines how the barrier is checked as per:

    *0*: the barrier checks use $<=$, $>=$ for Out-barriers.

    *1*: the barrier checks use strict comparison $<$ and $>$ for
    Out-barriers.

- StartDate\[Optional\]: The start date for checking if a barrier has
  been breached prior to today’s date. If omitted or left blank no check
  is made and it is assumed no barrier has been breached in the past.
  Has no impact if set to today’s date or a date in the future.

  Allowable values: See `Date` in Table
  <a href="#tab:allow_stand_data" data-reference-type="ref"
  data-reference="tab:allow_stand_data">[tab:allow_stand_data]</a>.

- Calendar\[Optional\]: The calendar associated with the FX Index.
  Required if StartDate is set to a date prior to today’s date,
  otherwise optional.

  Allowable values: See Table
  <a href="#tab:calendar" data-reference-type="ref"
  data-reference="tab:calendar">[tab:calendar]</a> Calendar.

- FXIndex\[Optional\]: A reference to an FX Index source to check if the
  barrier has been breached. Required if StartDate is set to a date
  prior to today’s date, otherwise optional and can be omitted but not
  left blank.

  Allowable values: The format of the FX Index is“FX-SOURCE-CCY1-CCY2”
  as described in table
  <a href="#tab:fxindex_data" data-reference-type="ref"
  data-reference="tab:fxindex_data">[tab:fxindex_data]</a>.

- BoughtCurrency: The bought currency of the FX barrier option. See
  OptionData above for more details.

  Allowable values: See Table
  <a href="#tab:currency" data-reference-type="ref"
  data-reference="tab:currency">[tab:currency]</a> `Currency`.

- BoughtAmount: The amount in the BoughtCurrency.

  Allowable values: Any positive real number.

- SoldCurrency: The sold currency of the FX barrier option. See
  OptionData above for more details.

  Allowable values: See Table
  <a href="#tab:currency" data-reference-type="ref"
  data-reference="tab:currency">[tab:currency]</a> `Currency`.

- SoldAmount: The amount in the SoldCurrency.

  Allowable values: Any positive real number.

Note that FX KIKO Options also cover Precious Metals, i.e. with
currencies XAU, XAG, XPT, XPD, and Cryptocurrencies, see supported
Cryptocurrencies in Table
<a href="#tab:currency" data-reference-type="ref"
data-reference="tab:currency">[tab:currency]</a>.

---

### FX Option

The `FXOptionData` node is the trade data container for the *FxOption*
trade type. FX options with exercise styles *European* or *American* are
supported. The `FXOptionData` node includes one and only one
`OptionData` trade component sub-node plus elements specific to the FX
Option. The structure of an `FXOptionData` node for an FX Option is
shown in Listing <a href="#lst:fxoption_data" data-reference-type="ref"
data-reference="lst:fxoption_data">[lst:fxoption_data]</a>.

<div class="listing">

``` xml
<FxOptionData>
  <OptionData>
    <LongShort>Long</LongShort>
    <OptionType>Call</OptionType>
    <Style>European</Style>
    <Settlement>Cash</Settlement>
    <PayOffAtExpiry>false</PayOffAtExpiry>
    <ExerciseDates>
       <ExerciseDate>2026-03-01</ExerciseDate>
     </ExerciseDates>
     <Premiums>
       <Premium>
         <Amount>10900</Amount>
         <Currency>EUR</Currency>
         <PayDate>2020-03-01</PayDate>
       </Premium>
     </Premiums>
  </OptionData>
  <BoughtCurrency>EUR</BoughtCurrency>
  <BoughtAmount>1000000</BoughtAmount>
  <SoldCurrency>USD</SoldCurrency>
  <SoldAmount>1700000</SoldAmount>
</FxOptionData>
```

</div>

The meanings and allowable values of the elements in the `FXOptionData`
node follow below.

- OptionData: This is a trade component sub-node outlined in section
  <a href="#ss:option_data" data-reference-type="ref"
  data-reference="ss:option_data">[ss:option_data]</a>. The relevant
  fields in the `OptionData` node for an FxOption are:

  - `LongShort` The allowable values are *Long* or *Short*.

  - `OptionType` The allowable values are *Call* or *Put*. For option
    type *Put*, Bought and Sold currencies/amounts are switched compared
    to the trade data node. For example, a holder of BoughtCurrency EUR
    SoldCurrency USD FX Call Option has the right to buy EUR using USD,
    while holder of the Put counterpart has the right to buy USD using
    EUR, or equivalently sell EUR for USD.

  - `Style` The allowable values are *European* or *American*.

  - `Settlement` The allowable values are *Cash* or *Physical*.

  - `PayOffAtExpiry` \[Optional\] The allowable values are *true* for
    payoff at expiry, or *false* for payoff at exercise (relevant for
    *American* style FxOptions). Defaults to *true* if left blank or
    omitted.

  - `AutomaticExercise` \[Optional\] The allowable values are *true*
    indicating Automatic Exercise is applicable and *false* indicates
    that it is not. Used if the FXOption expiry date is on the current
    date or in the past, and the payment date is in the future - so that
    there still is an outstanding cashflow if the FXOption was in the
    money on the expiry date. In this case, if AutomaticExercise is
    applied, the FX fixing on the expiry date is used to automatically
    determine the payoff and thus whether the option was exercised or
    not. Defaults to *false* if left blank or omitted.

  - An `ExerciseDates` node where exactly one ExerciseDate date element
    must be given. For *American* style FxOptions the ExerciseDate
    represents the Expiry date, i.e. they can be exercised up until this
    date.  

  - A `PaymentData` \[Optional\] node can be added which defines the
    settlement date of the option payoff. See `PaymentData` in
    <a href="#ss:option_data" data-reference-type="ref"
    data-reference="ss:option_data">[ss:option_data]</a>

  - `Premiums` \[Optional\]: Option premium amounts paid by the option
    buyer to the option seller. See section
    <a href="#ss:premiums" data-reference-type="ref"
    data-reference="ss:premiums">[ss:premiums]</a>

  See <a href="#ss:option_data" data-reference-type="ref"
  data-reference="ss:option_data">[ss:option_data]</a> for further
  specifications of the `OptionData` node.

- BoughtCurrency: The bought currency of the FX option. See OptionData
  above for more details.

  Allowable values: See Table
  <a href="#tab:currency" data-reference-type="ref"
  data-reference="tab:currency">[tab:currency]</a>.

- BoughtAmount: The amount in the BoughtCurrency.

  Allowable values: Any positive real number.

- SoldCurrency: The sold currency of the FX option. See OptionData above
  for more details.

  Allowable values: See Table
  <a href="#tab:currency" data-reference-type="ref"
  data-reference="tab:currency">[tab:currency]</a>.

- SoldAmount \[Optional\]: The amount in the SoldCurrency. Note that if
  Delta is omitted, the SoldAmount field is mandatory.

  Allowable values: Any positive real number.

- Delta \[Optional\]: The FX option delta. When a delta value is given
  the FX Option strike is derived from the delta, and the SoldAmount is
  ignored.

  Allowable values: Any non null real number. A SoldAmount or a Delta
  field is required, as the strike is derived from one or the other.
  Note: The delta to strike conversion is based on the valuation date.
  Therefore the strike will change day to day based on the market data
  variation. It is not possible to enter a seasoned trade with a Delta
  such that the trade strike (SoldAmount) is derived from the Delta on
  the trade date and then kept constant throughout the life of the
  trade.

- FXIndex \[Optional\]: If the option *European*, has cash settlement
  and is subject to *Automatic Exercise*, as indicated by the
  `AutomaticExercise` node under `OptionData`, this node must be
  populated with a valid FX index. The FX index is used to retrieve an
  FX rate on the expiry date that is in turn used to determine the
  payoff on the cash settlement date. The payoff is in the
  `SoldCurrency` i.e. the domestic currency.

  Allowable values: A valid FX index from the Table
  <a href="#tab:fxindex_data" data-reference-type="ref"
  data-reference="tab:fxindex_data">[tab:fxindex_data]</a>.

Note that FX Options also cover Precious Metals Options, i.e. with
currencies XAU, XAG, XPT, XPD, and Cryptocurrency options, see supported
Cryptocurrencies in Table
<a href="#tab:currency" data-reference-type="ref"
data-reference="tab:currency">[tab:currency]</a>.

---

### FX Swap

The `FXSwapData` node is the trade data container for the *FxSwap* trade
type. The structure - including example values - of the `FXSwapData`
node is shown in Listing
<a href="#lst:fxswap_data" data-reference-type="ref"
data-reference="lst:fxswap_data">[lst:fxswap_data]</a>. It contains no
sub-nodes.

<div class="listing">

``` xml
        <FxSwapData>
            <NearDate>2018-09-01</NearDate>
            <NearBoughtCurrency>EUR</NearBoughtCurrency>
            <NearBoughtAmount>1000000</NearBoughtAmount>
            <NearSoldCurrency>USD</NearSoldCurrency>
            <NearSoldAmount>1140000</NearSoldAmount>
            <FarDate>2028-09-01</FarDate>
            <FarBoughtAmount>1300000</FarBoughtAmount>
            <FarSoldAmount>1000000</FarSoldAmount>
            <Settlement>Cash</Settlement>
        </FxSwapData>
```

</div>

The meanings and allowable values of the various elements in the
`FXSwapData` node follow below. All elements are required.

- NearDate: The date of the initial fx exchange of the FX Swap.  
  Allowable values: See `Date` in Table
  <a href="#tab:allow_stand_data" data-reference-type="ref"
  data-reference="tab:allow_stand_data">[tab:allow_stand_data]</a>.

- NearBoughtCurrency: The currency to be bought in the initial exchange
  at near date, and sold in the final exchange at far date.  
  Allowable values: See Table
  <a href="#tab:currency" data-reference-type="ref"
  data-reference="tab:currency">[tab:currency]</a> `Currency`.

- NearBoughtAmount: The amount to be bought on near date.  
  Allowable values: Any positive real number.

- NearSoldCurrency: The currency to be sold in the initial fx exchange
  at near date, and bought in the final exchange at far date.  
  Allowable values: See Table
  <a href="#tab:currency" data-reference-type="ref"
  data-reference="tab:currency">[tab:currency]</a> `Currency`.

- NearSoldAmount: The amount to be sold on near date.  
  Allowable values: Any positive real number.

- FarDate: The date of the final fx exchange of the FX Swap.  
  Allowable values: Any date further into the future than NearDate. See
  `Date` in Table
  <a href="#tab:allow_stand_data" data-reference-type="ref"
  data-reference="tab:allow_stand_data">[tab:allow_stand_data]</a>.

- FarBoughtAmount: The amount to be bought on far date.  
  Allowable values: Any positive real number.

- FarSoldAmount: The amount to be sold on far date.  
  Allowable values: Any positive real number.

- Settlement \[Optional\]: Delivery type. Note that Non-Deliverable FX
  Swaps can be represented by *Cash* settlement, and that deliverable FX
  Swaps will be excluded from the CRIF output. Delivery type does not
  impact pricing in ORE.

  Allowable values: *Cash* or *Physical*. Defaults to *Physical* if left
  blank or omitted.

Note that FX Swaps also cover Precious Metals swaps, i.e. with
currencies XAU, XAG, XPT, XPD, and Cryptocurrency swaps, see supported
Cryptocurrencies in Table
<a href="#tab:currency" data-reference-type="ref"
data-reference="tab:currency">[tab:currency]</a>.

---

### FX Touch Option

An FX Touch Option pays a given cash amount (PayoffAmount) at expiry or
at hit if the underlying fx rate has hit a barrier (UpAndIn, DownAndIn -
called One Touch) resp. has not hit a barrier (UpAndOut, DownAndOut -
called No Touch) using continuous monitoring between start and expiry
date. No rebates are supported.

The `FxTouchOptionData` node is the trade data container for the
*FxTouchOption* trade type. The `FxTouchOptionData` node includes one
`OptionData` trade component sub-node and one `BarrierData` trade
component sub-node plus elements specific to the FX Touch Option.

The structure of an example `FxTouchOptionData` node for an FX Touch
Option is shown in Listing
<a href="#lst:fxtouchoption_data" data-reference-type="ref"
data-reference="lst:fxtouchoption_data">[lst:fxtouchoption_data]</a>.

<div class="listing">

``` xml
        <FxTouchOptionData>
            <OptionData>
                <LongShort>Long</LongShort>
                <PayOffAtExpiry>true</PayOffAtExpiry>
                <ExerciseDates>
                 <ExerciseDate>2021-12-14</ExerciseDate>
                </ExerciseDates>
                ...
            </OptionData>
            <BarrierData>
             <Type>DownAndOut</Type>
             <Levels>
              <Level>0.009</Level>
             </Levels>
            </BarrierData>
            <ForeignCurrency>JPY</ForeignCurrency>
            <DomesticCurrency>USD</DomesticCurrency>
            <PayoffCurrency>USD</PayoffCurrency>
            <PayoffAmount>100000</PayoffAmount>
            <StartDate>2019-01-25</StartDate>
            <FXIndex>FX-TR20H-USD-JPY</FXIndex>
            <Calendar>NYB,TKB</Calendar>
        </FxTouchOptionData>
```

</div>

The meanings and allowable values of the elements in the
`FxTouchOptionData` node follow below.

- OptionData: This is a trade component sub-node outlined in section
  <a href="#ss:option_data" data-reference-type="ref"
  data-reference="ss:option_data">[ss:option_data]</a>. The `OptionType`
  sub-node is not required and is inferred from the `BarrierData` type
  (i.e. *Call* for an Up barrier, and *Put* for a Down barrier). The
  relevant fields in the `OptionData` node for an FxTouchOption are:

  - `LongShort` The allowable values are *Long* or *Short*.

  - `PayOffAtExpiry` \[Optional\] *true* for payoff at expiry and
    *false* for payoff at hit. For UpAndOut and DownAndOut barrier, only
    payoff at expiry ( *true*) is supported. Defaults to *true* if left
    blank or omitted. This field is ignored in pricing, and the option
    payoff will be calculated at expiry. This field only has an impact
    on the description of the trade economics. The
    *GenericBarrierOption* can also be used to ‘replicate’ the
    *FXTouchOption* with payoff at hit if required.

  - An `ExerciseDates` node where exactly one `ExerciseDate` date
    element must be given.

  - A `PaymentData` \[Optional\] node can be added which defines the
    settlement of the option payoff. If the option is payoff at hit,
    (i.e. `PayoffAtExpiry` is *false*), the option payment data must be
    rules-based, and the `RelativeTo` sub-node of (`Rules`) must be set
    to *Exercise*.

  - `Premiums` \[Optional\]: Option premium amounts paid by the option
    buyer to the option seller.

    Allowable values: See section
    <a href="#ss:premiums" data-reference-type="ref"
    data-reference="ss:premiums">[ss:premiums]</a>

- `BarrierData`: This is a trade component sub-node outlined in section
  <a href="#ss:barrier_data" data-reference-type="ref"
  data-reference="ss:barrier_data">[ss:barrier_data]</a>. Level
  specified in BarrierData should be quoted as the amount in
  DomesticCurrency (sold currency) per unit ForeignCurrency (bought
  currency). Note that the level stays quoted as DomesticCurrency per
  unit ForeignCurrency, regardless of barrier type. StrictComparison
  \[Optional\]: Define whether we apply $<=$, $>=$ or $<$, $>$ for the
  barrier check. Defaults to *0* and $<=$, $>=$, *1* for $<$, $>$.

- `ForeignCurrency`: The foreign (bought) currency of the FX touch
  option.

  Allowable values: See Table
  <a href="#tab:currency" data-reference-type="ref"
  data-reference="tab:currency">[tab:currency]</a> `Currency`.

- `DomesticCurrency`: The domestic (sold) currency of the FX touch
  option.

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

- `Calendar` \[Optional\]: The calendar associated with the FX Index.
  Required if StartDate is set to a date prior to today’s date,
  otherwise optional.

  Allowable values: See Table
  <a href="#tab:calendar" data-reference-type="ref"
  data-reference="tab:calendar">[tab:calendar]</a> Calendar.

Note that FX Touch Options also cover Precious Metals, i.e. with
currencies XAU, XAG, XPT, XPD, and Cryptocurrencies, see supported
Cryptocurrencies in Table
<a href="#tab:currency" data-reference-type="ref"
data-reference="tab:currency">[tab:currency]</a>.

---

### FX Variance and Volatility Swap

The `FxVarianceSwapData` node is the trade data container for the
*FxVarianceSwap* trade type. Only vanilla variance swaps are supported
by this trade type - exotic variance swaps are supported by
ScriptedTrade, see
<a href="#SubSectionExoticVarianceSwap" data-reference-type="ref"
data-reference="SubSectionExoticVarianceSwap">[SubSectionExoticVarianceSwap]</a>.
. The structure of an example `VarianceSwapData` node for an FX variance
swap is shown in Listing
<a href="#lst:fxvarswap_data" data-reference-type="ref"
data-reference="lst:fxvarswap_data">[lst:fxvarswap_data]</a>.

<div class="listing">

``` xml
<FxVarianceSwapData>
        <StartDate>2018-05-10</StartDate>
        <EndDate>2018-11-12</EndDate>
        <Currency>EUR</Currency>
        <Underlying>
          <Type>FX</Type>
          <Name>ECB-EUR-JPY</Name>
        </Underlying>
        <LongShort>Long</LongShort>
        <Strike>0.05</Strike>
        <Notional>200000</Notional>
        <Calendar>EUR</Calendar>
        <MomentType>Variance</MomentType>
</FxVarianceSwapData>
```

</div>

The meanings and allowable values of the elements in the
`FxVarianceSwapData` node below.

- StartDate: The variance swap start date.  
  Allowable values: See `Date` in Table
  <a href="#tab:allow_stand_data" data-reference-type="ref"
  data-reference="tab:allow_stand_data">[tab:allow_stand_data]</a>.

- EndDate: The variance swap end date.  
  Allowable values: See `Date` in Table
  <a href="#tab:allow_stand_data" data-reference-type="ref"
  data-reference="tab:allow_stand_data">[tab:allow_stand_data]</a>.

- Currency: The bought currency of the variance swap.  
  Allowable values: See Table
  <a href="#tab:currency" data-reference-type="ref"
  data-reference="tab:currency">[tab:currency]</a> `Currency`.

- Name: The identifier of the underlying currency pair.  
  Allowable values: A string of the form SOURCE-CCY1-CCY2, where SOURCE
  is the fixing source and the fixing is expressed as amount in CCY2 per
  one unit of CCY1.  
  See Table <a href="#tab:fxindex_data" data-reference-type="ref"
  data-reference="tab:fxindex_data">[tab:fxindex_data]</a>. Note that
  FxVarianceSwap is an exception in that the ordering of CCY1 and CCY2
  must be set up as for `FxIndex`.

- Underlying: This node may be used as an alternative to the `Name` node
  to specify the underlying FX. The `Underlying` node is described in
  further detail in Section
  <a href="#ss:underlying" data-reference-type="ref"
  data-reference="ss:underlying">[ss:underlying]</a>.  

- LongShort: Defines whether the trade is long in the FX variance. For
  the avoidance of doubt, a long FX swap has positive value if the
  realised variance exceeds the variance strike.  
  Allowable values: *Long, Short*

- Strike: The volatility strike $K_{vol}$ of the variance swap quoted
  absolutely (i.e. not as a percent). If the swap was struck in terms of
  variance, the square root of that variance should be used here.  
  Allowable values: Any positive real number.

- Notional: The vega notional of the variance swap. This is the notional
  in terms of volatility units (like the strike). If the swap was struck
  in terms of a variance notional $N_{var}$, the corresponding vega
  notional is given by $N_{vol} = N_{var} * 2 * 100 * K_{vol}$ (where
  $K_{vol}$ is in absolute terms).  
  Allowable values: Any non-negative real number.

- Calendar: The calendar determining the observation/fixing dates
  according to which variance is accrued is the combination of the
  calendar(s) given here plus the combined calendars of the two involved
  currencies.  
  Allowable values: See Table
  <a href="#tab:calendar" data-reference-type="ref"
  data-reference="tab:calendar">[tab:calendar]</a>.

- MomentType\[Optional\]: A flag to distinguish if the swap is struck in
  terms of volatility or variance. The MomentType should be set to
  *Volatility* or *Variance* depending on the payoff. Note that
  MomentType does not necessarily need to be equivalent to the way the
  Strike is quoted which is always as a Volatility.  
  Allowable values: *Volatility* or *Variance*. Defaults to *Variance*
  if left blank or omitted.

Note that FX Variance and Volatility Swaps also cover Precious Metals,
i.e. with currencies XAU, XAG, XPT, XPD, and Cryptocurrencies, see
supported Cryptocurrencies in Table
<a href="#tab:currency" data-reference-type="ref"
data-reference="tab:currency">[tab:currency]</a>.

---

### Generic Barrier Option

Generic Barrier Options are defined using one of the trade types
*FxGenericBarrierOption*, *EquityGenericBarrierOption*,
*CommodityGenericBarrierOption* depending on the underlying asset class
and an associated node FxGenericBarrierOptionData,
EquityGenericBarrierOptionData, CommodityGenericBarrierOptionData.
Listing
<a href="#lst:generic_barrieroption_data" data-reference-type="ref"
data-reference="lst:generic_barrieroption_data">[lst:generic_barrieroption_data]</a>
shows an example for an FX Underlying. Generic Barrier Option can have
one or multiple underlyings. In the case of multiple underlyings, there
must be one level per underlying provided in each barrier, see
<a href="#lst:multiasset_generic_barrieroption_data"
data-reference-type="ref"
data-reference="lst:multiasset_generic_barrieroption_data">[lst:multiasset_generic_barrieroption_data]</a>.
The nodes have the following meaning:

- Underlying: The underlying definition. Note that for FX underlyings
  the order of the currencies defines the observed underlying value,
  i.e. for EUR-USD the domestic currency is USD (the observed value is
  e.g. $1.2$ USD per EUR) while for USD-EUR the domestic currency is EUR
  (the observed value is e.g. $0.8$ EUR per USD).

  Allowable Values: See
  <a href="#ss:underlying" data-reference-type="ref"
  data-reference="ss:underlying">[ss:underlying]</a>

- Underlyings: An alternative to *Underlying* - only one can be present.
  Can contain multiple *Underlying* nodes. Allowable Values: A list of
  *Underlying* nodes, with each node given by
  <a href="#ss:underlying" data-reference-type="ref"
  data-reference="ss:underlying">[ss:underlying]</a>

- PayCurrency: The payment currency. This is required for all Payoff
  Types and is usually

  - the domestic currency if underlying = FX

  - the eq / comm currency if underlying = Equity, Commodity

  But we allow for quanto payoffs as well, i.e.

  - the foreign currency if underlying = FX or also

  - a third currency if underlying = FX and

  - a currency not equal to the equity, commodity currency for these
    underlying types.

  See payoff description which amount is paid in which currency
  dependent on the type.

  Allowable Values: See `Currency` in Table
  <a href="#tab:allow_stand_data" data-reference-type="ref"
  data-reference="tab:allow_stand_data">[tab:allow_stand_data]</a>.

- OptionData: The option descripting, see
  <a href="#ss:option_data" data-reference-type="ref"
  data-reference="ss:option_data">[ss:option_data]</a> Relevant sub
  nodes are:

  - LongShort (allowable values: *Long* or *Short*)

  - PayoffType, with S = Underlying Value and K = Strike this is:

    - *Vanilla*: $\max(0, S-K)$ for a call or $\max(0, K-S)$ for a put,
      this is paid in PayCurrency

    - *AssetOrNothing*: $S$ paid in PayCurrency

    - *CashOrNothing*: Amount paid in PayCurrency

  - OptionType: Required for PayoffType = *Vanilla*, *Call* or *Put*.

  - ExerciseDate: The exercise date

  - Premiums \[Optional\]: Option premiums to be paid unconditionally.
    See section <a href="#ss:premiums" data-reference-type="ref"
    data-reference="ss:premiums">[ss:premiums]</a>

- SettlementDate \[Optional\]: The date on which the option payoff is
  settled. The SettlementDate is used unadjusted as given. Instead of
  the SettlementDate, a settlement lag, convention and calendar relative
  to the ExerciseDate can be specified, see below. If the SettlementDate
  is given on the other hand, SettlementLag, SettlementCalendar and
  SettlementConvention must *not* be given.

  Allowable Values: any valid date greater or equal to the exercise date

- SettlementLag \[Optional\]: Alternative specification of the option
  settlement date via a lag, see the explanation under SettlementDate.
  Defaults to 0D if not given.

  Allowable Values: any valid period (1D, 2W, 3M, ...)

- SettlementCalendar \[Optional\]: Alternative specification of the
  option settlement date via a lag, see the explanation under
  SettlementDate. Defaults to the underlying calendar, if not given.

  Allowable values: See Table
  <a href="#tab:calendar" data-reference-type="ref"
  data-reference="tab:calendar">[tab:calendar]</a> Calendar.

- SettlementConvention \[Optional\]: Alternative specification of the
  option settlement date via a lag, see the explanation under
  SettlementDate. Defaults to Following if not given.

  Allowable values: See Table
  <a href="#tab:convention" data-reference-type="ref"
  data-reference="tab:convention">[tab:convention]</a> Roll Convention.

- Quantity: The option quantity. Required for PayoffType =
  *AssetOrNothing*, *Vanilla*. For FX this is the amount in foreign
  currency. For Equity, Commodity this is the number of equities,
  commodities.

  Allowable Values: any real number

- Strike: Required for PayoffType = *Vanilla*.

  Allowable Values: any real number

- Amount: Required for PayoffType = *CashOrNothing*.

  Allowable Values: any real number

- Barriers. The barrier definition. Subnodes are:

  - ScheduleData \[Optional\]: the observation schedule for the barrier
    (see <a href="#ss:schedule_data" data-reference-type="ref"
    data-reference="ss:schedule_data">[ss:schedule_data]</a>. Instead of
    the ScheduleData, a daily schedule w.r.t. the underlying calendar
    can be specified by populating the StartDate and EndDate nodes.

  - StartDate \[Optional\]: Start date of the observation schedule, see
    the explanation under ScheduleData.

  - EndDate \[Optional\]: End date of the observation schedule, see the
    explanation under ScheduleData.

  - BarrierData \[Optional\]: a sequence of barrier definitions. See
    <a href="#ss:barrier_data" data-reference-type="ref"
    data-reference="ss:barrier_data">[ss:barrier_data]</a>. Relevant
    fields are:

    - Type: The barrier type (allowed values are *UpAndIn*, *UpAndOut*,
      *DownAndIn*, *DownAndOut*)

    - Levels: Exactly one barrier level per BarrierData block must be
      given.

    - Rebate \[Optional\]: The rebate amount. Defaults to zero. Rebate
      amounts and currencies can be different across barriers if only
      “out” barriers are defined, but must be identical as soon as at
      least one “in” barrier is defined.

    - RebateCurrency \[Optional\]: The currency in which the rebate is
      paid. Defaults to PayCurrency.

    - RebatePayTime \[Optional\]: *atExpiry* or *atHit*. For “in”
      barriers only *atExpiry* is allowed.

    - StrictComparison \[Optional\]: *0*, *1*, or *2*. Defaults to *0*.
      Determines how the barrier is checked as per:

      *0*: the barrier checks use $<=$, $>=$ to check In-barriers and
      $<$, $>$ to check Out-barriers.

      *1*: the barrier checks use strict comparison $<$ and $>$ for both
      In- and Out-barriers.

      *2*: the barrier checks use strict or equal comparison $<=$ and
      $>=$ for both In- and Out-barriers.

  - KikoType: Required if both a KI and KO barriers are defined.
    Allowable values are *KoAlways*, *KoBeforeKi*, *KoAfterKi*.

- TransatlanticBarrier \[Optional\]: An additional barrier to be checked
  on option expiry. May contain exactly one BarrierData block with
  number of levels equal to the number of underlyings or contain same
  amount of BarrierData blocks with the number of underlyings, exactly
  one level is allowed in each block for each underlying. The Type
  (*UpAndIn, UpAndOut, DownAndIn, DownAndOut*), the (unique) Level,
  StrictComparison and the Rebate are relevant fields.  
  The rebate is paid if there is no knock-out from the American barriers
  and no payoff from the Transatlantic barrier.

<div class="listing">

``` xml
  <FxGenericBarrierOptionData>
    <Underlying>
      <Type>FX</Type>
      <Name>ECB-EUR-USD</Name>
    </Underlying>
    <PayCurrency>USD</PayCurrency>
    <OptionData>
      <LongShort>Long</LongShort>
      <PayoffType>Vanilla</PayoffType>
      <OptionType>Call</OptionType>
      <ExerciseDates>
        <ExerciseDate>2023-06-06</ExerciseDate>
      </ExerciseDates>
    </OptionData>
    <SettlementDate>2023-06-08</SettlementDate>
    <Quantity>100000000</Quantity>
    <Strike>1.2</Strike>
    <Barriers>
      <ScheduleData>
        <Rules>
          <StartDate>2021-07-10</StartDate>
          <EndDate>2023-06-06</EndDate>
          <Tenor>1D</Tenor>
          <Calendar>TGT,US</Calendar>
          <Convention>F</Convention>
          <TermConvention>F</TermConvention>
          <Rule>Forward</Rule>
        </Rules>
      </ScheduleData>
      <BarrierData>
        <Type>DownAndOut</Type>
        <Levels>
          <Level>1.1</Level>
        </Levels>
        <Rebate>1000000</Rebate>
        <RebateCurrency>USD</RebateCurrency>
        <RebatePayTime>atExpiry</RebatePayTime>
        <StrictComparison>1</StrictComparison>
      </BarrierData>
      <BarrierData>
        <Type>UpAndIn</Type>
        <Levels>
          <Level>1.3</Level>
        </Levels>
        <Rebate>1000000</Rebate>
        <RebateCurrency>USD</RebateCurrency>
        <RebatePayTime>atExpiry</RebatePayTime>
      </BarrierData>
      <KikoType>KoAfterKi</KikoType>
    </Barriers>
    <TransatlanticBarrier>
      <BarrierData>
        <Type>UpAndOut</Type>
        <Levels>
          <Level>1.3</Level>
        </Levels>
        <Rebate>2000000</Rebate>
        <RebateCurrency>USD</RebateCurrency>
        <StrictComparison>1</StrictComparison>
      </BarrierData>
    </TransatlanticBarrier>
  </FxGenericBarrierOptionData>
```

</div>

<div class="listing">

``` xml
  <FxGenericBarrierOptionData>
    <Underlyings>
      <Underlying>
        <Type>FX</Type>
        <Name>ECB-EUR-USD</Name>
      </Underlying>
      <Underlying>
        <Type>FX</Type>
        <Name>ECB-USD-JPY</Name>
      </Underlying>
    </Underlyings>
    <PayCurrency>USD</PayCurrency>
    <OptionData>
      <LongShort>Long</LongShort>
      <PayoffType>Vanilla</PayoffType>
      <OptionType>Call</OptionType>
      <ExerciseDates>
        <ExerciseDate>2023-06-06</ExerciseDate>
      </ExerciseDates>
    </OptionData>
    <Amount>1500000</Amount>
    <SettlementDate>2023-06-08</SettlementDate>
    <Barriers>
      <ScheduleData>
        <Rules>
          <StartDate>2021-07-10</StartDate>
          <EndDate>2023-06-06</EndDate>
          <Tenor>1D</Tenor>
          <Calendar>TGT,US</Calendar>
          <Convention>F</Convention>
          <TermConvention>F</TermConvention>
          <Rule>Forward</Rule>
        </Rules>
      </ScheduleData>
      <BarrierData>
        <Type>DownAndOut</Type>
        <Levels>
          <Level>1.1</Level>
          <Level>125</Level>
        </Levels>
        <Rebate>1000000</Rebate>
        <RebateCurrency>USD</RebateCurrency>
        <RebatePayTime>atExpiry</RebatePayTime>
      </BarrierData>
      <BarrierData>
        <Type>UpAndIn</Type>
        <Levels>
          <Level>1.3</Level>
          <Level>135</Level>
        </Levels>
        <Rebate>1000000</Rebate>
        <RebateCurrency>USD</RebateCurrency>
        <RebatePayTime>atExpiry</RebatePayTime>
      </BarrierData>
      <KikoType>KoAfterKi</KikoType>
    </Barriers>
    <TransatlanticBarrier>
      <BarrierData>
        <Type>UpAndOut</Type>
        <Levels>
          <Level>1.3</Level>
          <Level>135</Level>
        </Levels>
        <Rebate>2000000</Rebate>
        <RebateCurrency>USD</RebateCurrency>
      </BarrierData>
    </TransatlanticBarrier>
  </FxGenericBarrierOptionData>
```

</div>

---

### Generic Scripted Products

The products in sections
<a href="#sec:doubledigitaloption" data-reference-type="ref"
data-reference="sec:doubledigitaloption">[sec:doubledigitaloption]</a>
to <a href="#sec:tarf" data-reference-type="ref"
data-reference="sec:tarf">[sec:tarf]</a> are internally represented as
*Scripted Trades*, but “wrapped” such that their input XML format still
looks like “classic” ORE XML.

With <a href="#sec:rainbowoption" data-reference-type="ref"
data-reference="sec:rainbowoption">[sec:rainbowoption]</a> and
<a href="#SubSectionExoticVarianceSwap" data-reference-type="ref"
data-reference="SubSectionExoticVarianceSwap">[SubSectionExoticVarianceSwap]</a>
we have seen two examples of the generic Scripted Trade input format.

The Scripted Trade module allows flexible definition of new payoffs
across five of the six asset classes covered in ORE, just by way of
defining the payoff script. The payoff script can be embedded into the
trade XML or can be placed into a separate script library.

Refer to the stand-alone Scripted Trade documentation in
ore/Docs/ScriptedTrade or section
<a href="#app:scriptedtrade" data-reference-type="ref"
data-reference="app:scriptedtrade">[app:scriptedtrade]</a> for an
introduction.

---

### Index Credit Default Swap

An index credit default swap (trade type *IndexCreditDefaultSwap*) is
set up using an `IndexCreditDefaultSwapData` block as shown in listing
<a href="#lst:indexcdsdata" data-reference-type="ref"
data-reference="lst:indexcdsdata">[lst:indexcdsdata]</a> and includes
`LegData` and `BasketData` trade component sub-nodes.

The `LegData` sub-node must be a fixed leg, and represents the recurring
premium payments. The direction of the fixed leg payments define if the
Index CDS is for bought (`Payer`: *true*) or sold (`Payer`: *false*)
protection. The notional on the fixed leg is the “unfactored notional”,
i.e. the notional excluding any defaults. This is opposed to the “trade
date notional” which is reduced by defaults since the series inception
until the trade date and the “current notional” or “factored notional”
which is reduced by defaults between the series inception and the
current evaluation date of the trade.

The `BasketData` sub-node (see section
<a href="#ss:basket_data" data-reference-type="ref"
data-reference="ss:basket_data">[ss:basket_data]</a>) is optional and
specifies the constituent reference entities of the index. This sub-node
is intended for non-standard indices, that require a bespoke basket.
When `BasketData` is omitted, the index constituents are derived from
the `CreditCurveId` element in the `IndexCreditDefaultSwapData` block.

<div class="listing">

``` xml
    <IndexCreditDefaultSwapData>
      <CreditCurveId>RED:2I65BRHH6</CreditCurveId>
      <SettlesAccrual>Y</SettlesAccrual>
      <ProtectionPaymentTime>atDefault</ProtectionPaymentTime>
      <ProtectionStart>20160206</ProtectionStart>
      <UpfrontDate>20160208</UpfrontDate>
      <UpfrontFee>0.0</UpfrontFee>
      <LegData>
            <LegType>Fixed</LegType>
            <Payer>false</Payer>
            ...
      </LegData>
       <BasketData>
        <Name>
          <IssuerId>CPTY_1</IssuerId>
          <CreditCurveId>RED:</CreditCurveId>
          <Notional>100000.0</Notional>
          <Currency>USD</Currency>
        </Name>
        <Name>
          <IssuerId>CPTY_2</IssuerId>
          <CreditCurveId>RED:</CreditCurveId>
          <Notional>100000.0</Notional>
          <Currency>USD</Currency>
        </Name>
        <Name>
          <IssuerId>CPTY_3</IssuerId>
          <CreditCurveId>RED:</CreditCurveId>
          <Notional>100000.0</Notional>
          <Currency>USD</Currency>
        </Name>
        <!-- ... -->
      </BasketData>
    </IndexCreditDefaultSwapData>
```

</div>

The meanings of the elements of the `IndexCreditDefaultSwapData` node
follow below:

- CreditCurveId: The identifier of the index defining the default curve
  used for pricing. The pricing can be set up to either use the index
  curve id, or use the curve id:s of the individual index components
  defined in `BasketData`.

  Allowable values: See `CreditCurveId` for credit trades - index in
  Table <a href="#tab:equity_credit_data" data-reference-type="ref"
  data-reference="tab:equity_credit_data">[tab:equity_credit_data]</a>.
  Note that the `CreditCurveId` cannot be a redcode or other identifier
  for an ABX or CMBX. For these underlyings, trade type
  *AssetBackedCreditDefaultSwap* is used instead.  

- SettlesAccrual \[Optional\]: Whether or not the accrued coupon is due
  in the event of a default. This defaults to `true` if not provided.

  Allowable values: Boolean node, allowing *Y, N, 1, 0, true, false*
  etc. The full set of allowable values is given in Table
  <a href="#tab:boolean_allowable" data-reference-type="ref"
  data-reference="tab:boolean_allowable">[tab:boolean_allowable]</a>.

- ProtectionPaymentTime \[Optional\]: Controls the payment time of
  protection and premium accrual payments in case of a default event.
  Defaults to `atDefault`.

  Allowable values: `atDefault`, `atPeriodEnd`, `atMaturity`. Overrides
  the `PaysAtDefaultTime` node

- PaysAtDefaultTime \[Deprecated\]: `true` is equivalent to
  ProtectionPaymentTime = atDefault, `false` to ProtectionPaymentTime =
  atPeriodEnd. Overridden by the `ProtectionPaymentTime` node if set

  Allowable values: Boolean node, allowing *Y, N, 1, 0, true, false*
  etc. The full set of allowable values is given in Table
  <a href="#tab:boolean_allowable" data-reference-type="ref"
  data-reference="tab:boolean_allowable">[tab:boolean_allowable]</a>.

- ProtectionStart \[Optional\]: The first date where a credit event will
  trigger the contract. This defaults to the first date in the schedule
  if it is not provided. Must be set to a date before or on the first
  date in the schedule if the `LegData` has a rule that is not one of
  `CDS` or `CDS2015`. In general, for standard index CDS, the protection
  start date is equal to the trade date. Therefore, typically the
  `ProtectionStart` should be set to the trade date of the index CDS.

  Allowable values: See `Date` in Table
  <a href="#tab:allow_stand_data" data-reference-type="ref"
  data-reference="tab:allow_stand_data">[tab:allow_stand_data]</a>.

- UpfrontDate \[Optional\]: Settlement date for the UpfrontFee if an
  UpfrontFee is provided. If an UpfrontFee is provided and it is
  non-zero, UpfrontDate is required.

  Allowable values: See `Date` in Table
  <a href="#tab:allow_stand_data" data-reference-type="ref"
  data-reference="tab:allow_stand_data">[tab:allow_stand_data]</a>. The
  UpfrontDate, if provided, must be on or after the ProtectionStart
  date.

- UpfrontFee \[Optional\]: The upfront payment, expressed in decimal
  form as a percentage of the notional. If an UpfrontDate is provided,
  an UpfrontFee must also be provided. The UpfrontFee can be omitted but
  cannot be left blank. The UpfrontFee can be negative. The UpfrontFee
  is treated as an amount payable by the protection buyer to the
  protection seller. A negative value for the UpfrontFee indicates that
  the UpfrontFee is being paid by the protection seller to the
  protection buyer.

  Allowable values: Any real number, expressed in decimal form as a
  percentage of the notional. E.g. an UpfrontFee of *0.045* and a
  notional of 10M, would imply an upfront fee amount of 450K.

- TradeDate \[Optional\]: The index CDS trade date. If omitted, the
  trade date is deduced from the protection start date. If the schedule
  provided in the `LegData` has a rule that is either `CDS` or
  `CDS2015`, the trade date is set equal to the protection start date.
  Otherwise, the trade date is set equal to the protection start date
  minus 1 day.

  Allowable values: See `Date` in Table
  <a href="#tab:allow_stand_data" data-reference-type="ref"
  data-reference="tab:allow_stand_data">[tab:allow_stand_data]</a>.

- CashSettlementDays \[Optional\]: The number of business days between
  the trade date and the cash settlement date. For standard index CDS,
  this is generally 3 business days. If omitted, this defaults to 3.

  Allowable values: Any non-negative integer.

- RebatesAccrual \[Optional\]: The protection seller pays the accrued
  scheduled current coupon at the start of the contract. The rebate date
  is not provided but computed to be two days after protection start.
  This defaults to `true` if not provided.

  Allowable values: Boolean node, allowing *Y, N, 1, 0, true, false*
  etc. The full set of allowable values is given in Table
  <a href="#tab:boolean_allowable" data-reference-type="ref"
  data-reference="tab:boolean_allowable">[tab:boolean_allowable]</a>.

The `LegData` block then defines the Index CDS premium leg structure.
This premium leg must be be of type `Fixed` as described in Section
<a href="#ss:fixedleg_data" data-reference-type="ref"
data-reference="ss:fixedleg_data">[ss:fixedleg_data]</a>.

---

### Index Credit Default Swap Option

An index CDS option has trade type `IndexCreditDefaultSwapOption` in
ORE. The Index CDS Option is set up using an
`IndexCreditDefaultSwapOptionData` node as shown in Listing
<a href="#lst:indexcdsoptiondata" data-reference-type="ref"
data-reference="lst:indexcdsoptiondata">[lst:indexcdsoptiondata]</a>.
Its child nodes have the following meanings:

An index CDS option, trade type `IndexCreditDefaultSwapOption`, is an
option to enter into an index CDS at a specified strike spread or strike
price. The Index CDS Option is set up using an
`IndexCreditDefaultSwapOptionData` node as shown in Listing
<a href="#lst:indexcdsoptiondata" data-reference-type="ref"
data-reference="lst:indexcdsoptiondata">[lst:indexcdsoptiondata]</a>.
Its child nodes have the following meanings:

- `IndexTerm` \[Optional\]: An optional node giving the term of the
  underlying index CDS e.g. 3Y, 5Y, 7Y, 10Y etc. The main function of
  this node is to allow for different index CDS option volatility
  structures for different terms of the same index series e.g. a CDX HY
  Series 34 5Y volatility structure and a CDX HY Series 34 10Y
  volatility structure. If this node is omitted, the market is searched
  for a CDS volatility surface with ID equal to the value of the
  `CreditCurveId` node under `IndexCreditDefaultSwapData`. There will
  generally be one `CreditCurveId` for each index CDS series
  e.g. `CDXHYS34V1` for CDX HY Series 34 Version 1. Consequently, there
  can only be one CDS volatility surface for this index CDS series. When
  `IndexTerm` is populated with the underlying index term, the market is
  searched for a CDS volatility surface with ID equal to the value of
  the `CreditCurveId` node with suffix `-[IndexTerm]`. For example, if
  the `CreditCurveId` node on an index CDS option trade is `CDXHYS34V1`
  and the `IndexTerm` node is populated with `5Y`, the market will be
  searched for a CDS volatility surface with ID `CDXHYS34V1-5Y` and this
  will be used in the trade valuation. In this way, different volatility
  surfaces can be used to value different terms of the same CDS index
  series.

  Allowable values: A string that can be parsed as a term that is a
  valid term for the underlying CDS index e.g. *5Y*, *10Y*, etc.  
  If omitted, the `IndexTerm` is derived from the given StartDate and
  EndDate of the underlying IndexCDS. Note that, with `IndexTerm`
  omitted, these dates have to match the start / end dates of the actual
  underlying IndexCDS, otherwise the trade will fail.

- `OptionData`: A node defining the option details as described in
  Section <a href="#ss:option_data" data-reference-type="ref"
  data-reference="ss:option_data">[ss:option_data]</a>. The relevant
  fields in the `OptionData` node for an IndexCDSOption are:

  - `LongShort` The allowable values are *Long* or *Short*. *Long*
    meaning that the holder has the option to enter into the underlying
    index CDS.

  - `OptionType` \[Optional\] *Put/Call* is optional and not used. The
    `Payer` field in the underlying Index CDS leg determines if the
    option is to buy or sell protection. The `Payer` field is from the
    perspective of the party that is long.

  - `Style` Must be set to *European* as this is the only supported
    exercise for `IndexCreditDefaultSwapOption`.

  - `Settlement` The allowable values are *Cash* or *Physical*.

  - `PayOffAtExpiry` Must be set to *false* as only payoff at exercise
    is supported.

  - An `ExerciseDates` node where exactly one ExerciseDate date element
    must be given.

  - `Premiums` \[Optional\]: Option premium amounts paid by the option
    buyer (*Long*) to the option seller (*Short*). See section
    <a href="#ss:premiums" data-reference-type="ref"
    data-reference="ss:premiums">[ss:premiums]</a>

- `IndexCreditDefaultSwapData`: A node defining the underlying index CDS
  as described in Section
  <a href="#ss:indexcds" data-reference-type="ref"
  data-reference="ss:indexcds">[ss:indexcds]</a>. Note that the
  `StartDate` in the `Scheduledata` in the premium leg in the
  `IndexCreditDefaultSwapData` should be the date on which the
  underlying CDS is entered into if the option is exercised (as opposed
  to the inception date of the underlying index CDS series). Under
  standard terms, the `StartDate` would be equal to the `ExerciseDate`
  plus one day, but it can also be on a later date, but not on a date
  before or on the `ExerciseDate`, unless Rule is *CDS2015* or *CDS* and
  `StartDate` is set at the start of the full IMM period that the
  `ExerciseDate` falls into.

  The `TradeDate` and `ProtectionStart` on the underlying CDS do not
  need to be populated. If omitted, which is recommended, the
  `TradeDate` and `ProtectionStart` on the underlying CDS default as
  follows:

  `TradeDate` = max (option `ExerciseDate`, underlying schedule
  `StartDate` - 1)  
  `ProtectionStart` = max (option `ExerciseDate` + 1, underl. schedule
  `StartDate`)

  Note that the cash settlement date for the underlying swap upfront
  premium is set to the underlying `TradeDate` with defaults as above,
  plus 3 business days.

  Also note that for schedules with IMM rules (e.g. *CDS2015*), if the
  underlying schedule `StartDate` is not falling on an IMM date, it is
  adjusted to the previous quarterly IMM date.

  Finally, the notional is - as in the case of an Index Credit Default
  Swap - the “unfactored notional”, i.e. the notional excluding any
  defaults between the series inception and the trade or evaluation date
  of the trade.

- `Strike` \[Optional\]: A real number defining the option strike level.
  If this is an empty string or omitted the strike will be determined
  according to table
  <a href="#tab:indexcdsoption_strike_deduction" data-reference-type="ref"
  data-reference="tab:indexcdsoption_strike_deduction">1</a>.

  Note that if a strike is given, the UpfrontFee on the underlying
  IndexCDS must be zero or omitted. The UpfrontFee is interpreted as a
  price strike.

  Allowable values: Any real number. Note that the `Strike` is expressed
  in decimal form when `StrikeType` is *Spread*, and in decimal form as
  percentage of notional when `StrikeType` is *Price*. I.e. a `Strike`
  of 1.05 is 105% of the notional when `StrikeType` is *Price*.

- `StrikeType` \[Optional\]: Determines the strike type. If *Spread* is
  given, the `Strike` is interpreted as a strike *spread*. If *Price* is
  given, the `Strike` is interpreted as a strike *price*. If omitted or
  left blank, it will be determined according to table
  <a href="#tab:indexcdsoption_strike_deduction" data-reference-type="ref"
  data-reference="tab:indexcdsoption_strike_deduction">1</a>.

  Allowable values: *Spread* or *Price*. Note that *Spread* is only
  supported when the underlying market data is set up with spread
  strikes, and *Price* is only supported when the market data is set up
  with price strikes. Typically the market data convention for Index CDS
  Options is spread strikes, with the exception of CDX North America
  High Yield (CDX NA HY) names, where the convention is to use price
  strikes.

- `TradeDate` \[Optional\]: The trade date. If not given defaults to the
  valuation date. In case of an underlying default the trade date is
  used to determine whether the underlying notional before default
  should be considered part of the outstanding notional (TradeDate $<$
  AuctionDate) or not (TradeDate $\geq$ AuctionDate). Since the trade
  date is also used as the start date of the front end protection (if
  the field FrontEndProtectionStartDate is not populated), it impacts
  the realized front end protection value. It is therefore essential to
  populate the TradeDate with the correct value if defaults occured in
  the underlying index. If the trade date is not given and there were
  defaults a warning is emitted stating that the valuation might not be
  accruate.

  Allowable values: See `Date` in Table
  <a href="#tab:allow_stand_data" data-reference-type="ref"
  data-reference="tab:allow_stand_data">[tab:allow_stand_data]</a>. Can
  not be later than the valuation date.

- `FrontEndProtectionStartDate` \[Optional\]: The date on which the
  front end protection kicks in. If not given, it defaults to the
  TradeDate. In case of an underlying default this date is used to
  determine whether the underlying contributes to the realised front end
  protection amount (FrontEndProtectionStartDate $<$ AuctionDate) or not
  (FrontEndProtectionStartDate $\geq$ AcutionDate).

  Allowable values: See `Date` in Table
  <a href="#tab:allow_stand_data" data-reference-type="ref"
  data-reference="tab:allow_stand_data">[tab:allow_stand_data]</a>. Can
  not be later than the trade date.

- `FixedRecoveryRate` \[Optional\]: If provided, this recovery rate will
  be used in place of the market quoted recovery rate of the underlying.

  Allowable values: Any real number in the range \[0,1\]. If omitted,
  the market quoted recovery rate of the underlying is used.

<div class="listing">

``` xml
<IndexCreditDefaultSwapOptionData>
  <IndexTerm>5Y</IndexTerm>
  <OptionData>
      <LongShort>Long</LongShort>
      <Style>European</Style>
      <Settlement>Cash</Settlement>
      <PayOffAtExpiry>false</PayOffAtExpiry>
      <ExerciseDates>
        <ExerciseDate>2023-05-09</ExerciseDate>
      </ExerciseDates>
  </OptionData>
  <IndexCreditDefaultSwapData>
    ... 
  </IndexCreditDefaultSwapData>
  <Strike>1.063</Strike>
  <StrikeType>Price</StrikeType>
</IndexCreditDefaultSwapOptionData>
```

</div>

<div id="tab:indexcdsoption_strike_deduction">

| Strike | StrikeType | UpfrontFee   | Effective Strike | Effective StrikeType |
|:-------|:-----------|:-------------|:-----------------|:---------------------|
| na     | na         | na           | RunningCoupon    | Spread               |
| na     | Spread     | na           | RunningCoupon    | Spread               |
| na     | Price      | na           | 1.0              | Price                |
| K      | na         | na           | K                | Spread               |
| K      | Spread     | na           | K                | Spread               |
| K      | Price      | na           | K                | Price                |
| na     | na         | U            | 1.0 - U          | Price                |
| na     | Spread     | U ($= 0$)    | RunningCoupon    | Spread               |
| na     | Spread     | U ($\neq 0$) | (not allowed)    | (not allowed)        |
| na     | Price      | U            | 1.0 - U          | Price                |
| K      | na         | U ($= 0$)    | K                | Spread               |
| K      | na         | U ($\neq 0$) | (not allowed)    | (not allowed)        |
| K      | Spread     | U ($= 0$)    | K                | Spread               |
| K      | Spread     | U ($\neq 0$) | (not allowed)    | (not allowed)        |
| K      | Price      | U ($= 0$)    | K                | Price                |
| K      | Price      | U ($\neq 0$) | (not allowed)    | (not allowed)        |

Effective strike and strike type to be used in an Index CDS Option
dependent on the Strike, StrikeType and UpfrontFee in the underlying
Index CDS

</div>

---

### Synthetic CDO

A Synthetic CDO is set up using a `CdoData` block as shown in listing
<a href="#lst:cdodata" data-reference-type="ref"
data-reference="lst:cdodata">[lst:cdodata]</a>.

<div class="listing">

``` xml
    <CdoData>
      <Qualifier> ItraxxEuropeS9V1 </Qualifier>
      <ProtectionStart> 20140425 </ProtectionStart>
      <UpfrontDate/>
      <UpfrontFee/>
      <AttachmentPoint>0.12</AttachmentPoint>
      <DetachmentPoint>0.22</DetachmentPoint>
      <SettlesAccrual>Y</SettlesAccrual>
      <ProtectionPaymentTime>atDefault</ProtectionPaymentTime>
      <!-- Premium leg -->
      <LegData>
          ...
      </LegData>
      <!-- Basket -->
      <BasketData>
        ...
      </BasketData>
    </CdoData>
```

</div>

The meanings of the elements of the `CdoData` node follow below:

- Qualifier: Used to reference the relevant base correlation curve

- ProtectionStart: The first date where a default event will trigger the
  contract

- UpfrontDate\[Optional\]: Settlement date for the upfront payment.

- UpfrontFee\[Optional\]: The upfront payment, expressed as a rate, to
  be multiplied by notional amount.

- LegData: Premium leg description as in an Index CDS (see section
  <a href="#ss:indexcds" data-reference-type="ref"
  data-reference="ss:indexcds">[ss:indexcds]</a>) with notional
  correspondig to the initial tranche notional

- BasketData: Underlying basket description as in an Index CDS (see
  section <a href="#ss:indexcds" data-reference-type="ref"
  data-reference="ss:indexcds">[ss:indexcds]</a>)

- AttachmentPoint: Losses where protection starts, expressed as a
  fraction of the basket notional

- DetachmentPoint: Losses where protection end, expressed as a fraction
  of the basket notional

---

### Knock Out Swap

A Knock Out Swap refers to a vanilla fixed vs. float Interest Rate Swap
that terminates when the float index fixing is above (“up and out”) or
below (“down and out”) a given barrier level.

A Knock Out Swap is represented using the TradeType *KnockOutSwap* and a
KnockOutSwapData block as shown in listing
<a href="#lst:knock_out_swap" data-reference-type="ref"
data-reference="lst:knock_out_swap">[lst:knock_out_swap]</a>. It must
have one `BarrierData` node, and two legs, one fixed and one floating,
each represented by a `LegData` trade component.

A Knock Out Swap is a Swap with one Fixed and one Floating leg, where
the Swap is terminated if the Floating leg Index hits a barrier. The
barrier is monitored on all floating leg fixing dates after the
BarrierStartDate.

The meanings and allowable values in this block are as follows:

- BarrierData: This node specifies the barrier components. All other
  values of the barrier data block are not relevant.  
  See <a href="#ss:barrier_data" data-reference-type="ref"
  data-reference="ss:barrier_data">[ss:barrier_data]</a>.

  - Type: The barrier type (allowed values are *UpAndOut*, *DownAndOut*)

  - Levels: Exactly one barrier level must be given.

  - StrictComparison \[Optional\]: *0*, *1*. Defaults to *0*. Determines
    how the barrier is checked as per:

    *0*: the barrier checks use $<=$, $>=$ to check Out-barriers.

    *1*: the barrier checks use strict comparison $<$ and $>$ for
    Out-barriers.

- BarrierStartDate: The barrier is monitored on all floating leg fixing
  dates that are on or after the barrier start date.  
  Allowable values: See `Date` in Table
  <a href="#tab:allow_stand_data" data-reference-type="ref"
  data-reference="tab:allow_stand_data">[tab:allow_stand_data]</a>.

- LegData: This specifies the swap terms. Exactly two LegData nodes must
  be given, one of type Fixed and one of type Floating.  
  Allowable values: See <a href="#ss:leg_data" data-reference-type="ref"
  data-reference="ss:leg_data">[ss:leg_data]</a>.

<div class="listing">

``` xml
<Trade id="194837232">
  <TradeType>KnockOutSwap</TradeType>
  <Envelope>...</Envelope>
  <KnockOutSwapData>
    <!-- BarrierData and BarrierStartDate specify the knock out terms -->
    <BarrierData>
      <Type>UpAndOut</Type>
      <Levels>
        <Level>0.05</Level>
      </Levels>
    </BarrierData>
    <BarrierStartDate>2024-10-01</BarrierStartDate>
    <!-- we require exactly one Floating and one Fixed Leg -->
    <LegData>
      <LegType>Floating</LegType>
      ...
    </LegData>
    <LegData>
      <LegType>Fixed</LegType>
      ...
    </LegData>
  </KnockOutSwapData>
</Trade>
```

</div>

---

# Netting Set Details

Instead of a single netting set ID, defined by a `NettingSetId` node, an
alternative `NettingSetDetails` node can be provided, which itself
contains a `NettingSetId` sub-node, and four other optional sub-nodes,
which altogether allow for extending the uniqueness of netting sets
beyond the netting set ID. The allowable values for each sub-node are
any alphanumeric string. The underscore (‘\_’) sign may be used as well.

The `NettingSetDetails` node is given in the following XML format:

<div class="listing">

``` xml
    <NettingSetDetails>
        <NettingSetId> </NettingSetId>
        <AgreementType> </AgreementType>
        <CallType> </CallType>
        <InitialMarginType> </InitialMarginType>
        <LegalEntityId> </LegalEntityId>
    </NettingSetDetails>
```

</div>

---

### Performance Option Type 01

**Payoff**

The performance option of type “01” is characterized by the following
data

- a notional amount $N$

- a participation rate $q$

- a valuation date $V$ and a settlement date $S$

- a number of underlyings $U_i$ for $i=1,\ldots,n$

- weights for the underlyings $w_i$ for $i=1,\ldots,n$

- initial strike prices for the underlyings $s_i$ for $i=1,\ldots,n$

- an option strike $K$

On the valuation date the average performance of the underlying basket
is computed as

$$P = \max\left( \sum_{i=1}^n w_i \left( \frac{U_i(V)}{s_i} - K \right), 0 \right)$$

The option holder receives an amount $N\cdot q\cdot P$ on the settlement
date $S$. The underlyings can be Equity, FX or Commodity underlyings.

The above payoff includes the strike in the performance calculation.
There is another variant with excluded strike and payoff:

$$P = \max\left( \left[ \sum_{i=1}^n w_i \frac{U_i(V)}{s_i} \right] - K, 0 \right)$$

**Input**

The `PerformanceOption_01` node is the trade data container for the
PerformanceOption_01 trade type, listing
<a href="#lst:performanceoption01_data" data-reference-type="ref"
data-reference="lst:performanceoption01_data">[lst:performanceoption01_data]</a>
shows the structure of an example.

<div class="listing">

``` xml
    <PerformanceOption01Data>
      <NotionalAmount>12500000</NotionalAmount>
      <ParticipationRate>0.9</ParticipationRate>
      <ValuationDate>2022-05-03</ValuationDate>
      <SettlementDate>2022-05-05</SettlementDate>
      <Underlyings>
        <Underlying>
          <Type>FX</Type>
          <Name>ECB-CHF-EUR</Name>
          <Weight>0.34</Weight>
        </Underlying>
        <Underlying>
          <Type>FX</Type>
          <Name>ECB-NOK-EUR</Name>
          <Weight>0.32</Weight>
        </Underlying>
        <Underlying>
          <Type>FX</Type>
          <Name>ECB-SEK-EUR</Name>
          <Weight>0.24</Weight>
        </Underlying>
        <Underlying>
          <Type>FX</Type>
          <Name>ECB-SEK-EUR</Name>
          <Weight>0.10</Weight>
        </Underlying>
      </Underlyings>
      <StrikePrices>
        <StrikePrice>0.910002</StrikePrice>
        <StrikePrice>0.097192</StrikePrice>
        <StrikePrice>0.096085</StrikePrice>
        <StrikePrice>0.035032</StrikePrice>
      </StrikePrices>
      <Strike>1.15</Strike>
      <StrikeIncluded>true</StrikeIncluded>
      <Position>Long</Position>
      <PayCcy>EUR</PayCcy>
    </PerformanceOption01Data>
```

</div>

The meanings and allowable values of the elements in the
`PerformanceOption01Data` node follow below.

- NotionalAmount: The notional amount of the option. Allowable valus are
  non-negative numbers.

- ParticipationRate: The participation rate. Allowable values are
  non-negative numbers. Usually the value will be between 0 and 1.

- ValuationDate: The valuation date. Allowable values are valid dates.

- SettlementDate: The settlement date. Allowable values are valid dates.

- Underlyings: The underlyings of the option. See
  <a href="#ss:underlying" data-reference-type="ref"
  data-reference="ss:underlying">[ss:underlying]</a> for each
  underlying.

- StrikePrices: The initial strike prices of the underlyings. For an FX
  underlying FX-SOURCE-CCY1-CCY2 this is the number of units of CCY2 per
  units of CCY1. For an EQ underlying this is the equity price expressed
  in the equity ccy. For a Commodity underlying this is the commodity
  price quoted as per the underlying commodity. Allowable values are
  non-negative numbers.

- Strike: The option strike. This is expressed in terms of the
  performance of the underlying basket (see the product description for
  more details). Allowable values are numbers.

- StrikeIncluded \[optional\]: If true the strike is included in the
  performance calculation, this is also the default if the flag not
  given. If false the strike is excluded.

- Position: The option position. Allowable values are *Long* or *Short*.

- PayCcy: The payment currency of the option. See the appendix for
  allowable currency codes.

---

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

---

### Risk Participation Agreement (RPA)

A risk participation agreement is set up using the trade type
`RiskParticipationAgreement` and a ` RiskParticipationAgreementData`
block as shown in listing
<a href="#lst:rpadata" data-reference-type="ref"
data-reference="lst:rpadata">[lst:rpadata]</a>. The block contains a
`ProtectionFee` block that can include one or more legs representing the
fees paid by the protection buyer and an `Underlying` block containing
either the legs of the underlying swap or the Treasury-Lock data that
the contract references.

If the underlying reference entity defaults, the protection buyer
receives the PV of the underlying if this is positive. Here, the
underlying PV is computed using the payer / receiver flags as set up for
the legs under the underlying node. Whether the trade represents a
protection buyer or seller position is indicated by the payer flag in
the protection fee leg data: If true protection is bought (and the
protection fee is paid), if false the protection is sold (and the
protection fee is received).

<div class="listing">

``` xml
  <RiskParticipationAgreementData>
    <ParticipationRate>0.8</ParticipationRate>
    <ProtectionStart>2018-10-01</ProtectionStart>
    <ProtectionEnd>2038-10-01</ProtectionEnd>
    <CreditCurveId>RED:008CA0|SNRFOR|USD|MR14</CreditCurveId>
    <IssuerId>CompanyXZY</IssuerId>
    <SettlesAccrual>true</SettlesAccrual>
    <FixedRecoveryRate>0.6</FixedRecoveryRate>
    <ProtectionFee>
      <LegData>
        <LegType>Cashflow</LegType>
        <Payer>true</Payer>
        <Currency>EUR</Currency>
        <CashflowData>
          <Cashflow>
            <Amount date="2018-10-03">91171.72</Amount>
          </Cashflow>
        </CashflowData>
      </LegData>
    </ProtectionFee>
    <Underlying>
      <!-- Alternatives:
           - Sequence of LegData, possibly with OptionData to represent callability
           - A single block of TreasuryLockData -->
      <OptionData> ... </OptionData>
      <NakedOption> ... </NakedOption>
      <LegData>
        <LegType>Floating</LegType>
        ...
      </LegData>
      <LegData>
        <LegType>Fixed</LegType>
        <Payer>false</Payer>
        ...
      </LegData>
    </Underlying>
  </RiskParticipationAgreementData>
```

</div>

- ParticipationRate: The rate reflecting the participation amount
  relative to the swap volume.

  Allowable values: Any number between $0$ and $1$.

- ProtectionStart: The date on which the protection starts (inclusive).

  Allowable values: Any valid date, see See `Date` in Table
  <a href="#tab:allow_stand_data" data-reference-type="ref"
  data-reference="tab:allow_stand_data">[tab:allow_stand_data]</a>.

- ProtectionEnd: The date on which the protection ends (exclusive).

  Allowable values. Any valid date greater than the protection start
  date.

- CreditCurveId: Typically the RED-code of the underlying swap reference
  entity defining the default curve used for pricing. Other identifiers
  may be used as well, provided they are supported in the market data
  configuration.

  Allowable values: Any valid credit curve identifier.

- IssuerId \[Optional\]: An identifier for the underlying swap reference
  entity. For informational purposes and not used for pricing. Defaults
  to an empty string.

  Allowable values: Any string.

- SettlesAccrual \[Optional\]: Whether or not the accrued coupon of the
  protection fee is due in the event of a default. This defaults to
  `true` if not provided. Only applies to coupon legs (i.e. not simple
  cashflows) within the protection fee block, otherwise it is ignored.

  Allowable values: `true` or `false`

- FixedRecoveryRate \[Optional\]: This node holds the fixed recovery
  rate if the RPA assumes a fixed recovery to calculate the settlement
  amount in case of a default event. If the field is omitted the
  recovery rate associated to the credit curve is used instead.

  Allowable values: Any number between $0$ and $1$.

- ProtectionFee: The fees that are paid (if protection is bought) or
  received (if protection is sold). The fees are given by one or more
  legs as described under
  <a href="#ss:leg_data" data-reference-type="ref"
  data-reference="ss:leg_data">[ss:leg_data]</a> with identical Payer
  flags, typically this will be a single `Cashflow` leg holding zero or
  more fixed fee amounts or a `Fixed` leg representing a series of
  periodic fee payments. Fees are paid up to (but excluding) the default
  event. If the fees are given as coupons the accrued amount between the
  accrual start date and the default date is paid if and only if
  `SettlesAccrual` is set to ` true`. The protection fees can be given
  in any arbitrary currency.

- Underlying: The reference underlying. There are several subtypes to
  distinguish, all of which have separate pricing engines attached.
  There is no need to specify the subtype in the trade xml, this is
  deduced automatically during the trade building:

  - Vanilla Swap: This is a vanilla swap given by two legs in the same
    currency, one receiver, one payer and one Fixed (or Cashflow), one
    Floating. For the floating part only Ibor coupons (no averaging) or
    (compounded, averaging) OIS coupons are allowed. Spreads and
    gearings are allowed, but no embedded caps/floors, no in arrears
    fixings for Ibor coupons. This type allows an analytic Black engine
    where the RPA Options are found via a representative swaption
    matching.

  - Structured Swap: As vanilla, but an arbitrary number of legs of type
    Fixed, Floating, Cashflow is allowed. Embedded caps/floors/collars
    and in arrears fixing are allowed. For floating legs, Ibor (no
    averaging) and OIS (compounded, averaging) coupons are allowed. All
    legs must be in the same currency. Standalone caps, floors, collars
    are allowed as an underlying of the RPA, if specified by a floating
    leg with NakedOption set to true. See
    <a href="#ss:floatingleg_data" data-reference-type="ref"
    data-reference="ss:floatingleg_data">[ss:floatingleg_data]</a> for
    details on the floating leg specification, amd likewise
    <a href="#ss:fixedleg_data" data-reference-type="ref"
    data-reference="ss:fixedleg_data">[ss:fixedleg_data]</a> for the
    fixed leg and <a href="#ss:leg_data" data-reference-type="ref"
    data-reference="ss:leg_data">[ss:leg_data]</a> for the cashflow leg.
    This type requires a numeric grid engine.

  - Callable Swap / Swaption: As structured swap, but an additional
    OptionData block allows to specify callability of the swap. The
    relevant fields in OptionData are the same as for callable swaps,
    see <a href="#ss:callable_swap" data-reference-type="ref"
    data-reference="ss:callable_swap">[ss:callable_swap]</a>. This type
    requires a numeric grid engine as the structured swap. If
    NakedOption is set to true, an option to exercise into the
    underlying swap is represented, i.e. a swaption.

  - Cross Currency Swap: Underlying legs as in structured swap, but the
    legs can be in two different currencies. No optionality is allowed
    though. At most two different currencies are allowed. This type can
    be priced using an analytic Black engine which models the FX Risk
    and assumes deterministic interest rates.

  - T-Lock. The underlying is a T-Lock, represented as shown in listing
    <a href="#lst:tlock_data" data-reference-type="ref"
    data-reference="lst:tlock_data">[lst:tlock_data]</a> and explained
    in more detail below. This type requires a numeric grid engine.

<u>Treasury Lock Underlying Specification</u>

Listing <a href="#lst:tlock_data" data-reference-type="ref"
data-reference="lst:tlock_data">[lst:tlock_data]</a> shows the
specification of a T-Lock underlying. The fields have the following
meaning:

- Payer: Boolean, true if the fixed reference rate is paid, false
  otherwise. I.e. if the payer flag is true and the yield is lower than
  the reference rate, then the underlying T-Lock trade pays the amount
  $(r-y) \cdot d$ where $r$ is the reference rate, $y$ is the yield,
  both expressed in basis points, and $d>0$ is the (absolute) price
  change of the treasury bond when the yield moves by $1$ basis point.
  Likewise, if the yield is higher than the reference rate, the
  underlying T-Lock trade receives $(y-r) \cdot d$.  
  Allowable values: *true* or *false*

- BondData: Reference to the underlying security, given in the BondData
  sub node, minimum required data are notional and security ID  
  Allowable values: See <a href="#ss:bond" data-reference-type="ref"
  data-reference="ss:bond">[ss:bond]</a>

- ReferenceRate: Fixed rate paid or received on the T-Lock underlying  
  Allowable values: Any real number. The rate is expressed in decimal
  form, eg 0.05 is a rate of 5%

- DayCounter \[Optional\]: Reference rate day counter. Optional,
  defaults to the coupon day counter of the underlying bond.  
  Allowable values: See Table
  <a href="#tab:daycount" data-reference-type="ref"
  data-reference="tab:daycount">[tab:daycount]</a>

- TerminationDate: Date for the cash settlement amount calculation  
  Allowable values: See `Date` in Table
  <a href="#tab:allow_stand_data" data-reference-type="ref"
  data-reference="tab:allow_stand_data">[tab:allow_stand_data]</a>.

- PaymentGap \[Optional\]: Business day gap between termination and
  payment date. Optional, defaults to zero.  
  Allowable values: Any non-negative integer

- PaymentCalendar: Calendar to determine the payment date.  
  Allowable values: See Table
  <a href="#tab:calendar" data-reference-type="ref"
  data-reference="tab:calendar">[tab:calendar]</a>.

<div class="listing">

``` xml
    <Underlying>
      <TreasuryLockData>
      <Payer>true</Payer>
      <BondData>
      ...
      </BondData>
      <ReferenceRate>0.05</ReferenceRate>
      <DayCounter>A360</DayCounter>
      <TerminationDate>2022-01-05</TerminationDate>
      <PaymentGap>5</PaymentGap>
      <PaymentCalendar>US</PaymentCalendar>
      </TreasuryLockData>
    </Underlying>
```

</div>

---

## Pricing\n
## Trade Components\n
