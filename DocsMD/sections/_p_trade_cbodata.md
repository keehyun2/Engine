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
