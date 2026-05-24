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
