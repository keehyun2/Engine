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
