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
