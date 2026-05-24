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
