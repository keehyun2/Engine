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
