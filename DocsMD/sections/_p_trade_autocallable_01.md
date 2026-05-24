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
