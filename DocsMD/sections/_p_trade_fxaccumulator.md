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
