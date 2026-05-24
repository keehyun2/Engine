## Reference Data `referencedata.xml`

Reference Data is used to ease the burden on portfolio xml
representation (see ), by taking common elements and storing them as
static data. Currently this can be used for *Bond Derivatives* that
require bond static information.

Bond reference data is also used to build yield curves fitted to liquid
bond prices, see
<a href="#sec:fitted_bond_segment" data-reference-type="ref"
data-reference="sec:fitted_bond_segment">[sec:fitted_bond_segment]</a>.

The allowable types for ReferenceData is

1.  **Bond** static data consists of the Leg data for a given bond.

2.  `SubType` has been added for reporting purposes, to feed into the
    ISDA product taxonomy, without impact on pricing.  
    Valid `SubType`s are:  

    - ABS, Corp(orate), Loans, Muni, Sovereign

    - ABX, CMBX, MBX, PrimeX, TRX, iBoxx (in case the Bond represents a
      Credit or Bond index)

    Note that the SubType field is currently optional and not covered by
    schema checks.

``` xml
  <ReferenceData>
  <!-- Bond reference datum -->
  <ReferenceDatum id="SECURITY_1">
    <Type>Bond</Type>
    <BondReferenceData>
      <SubType>Muni</SubType>
      <IssuerId>CPTY_C</IssuerId>
      <CreditCurveId>ZERO</CreditCurveId>
      <ReferenceCurveId>EURBENCHMARK-EUR-6M</ReferenceCurveId>
      <SettlementDays>2</SettlementDays>
      <Calendar>TARGET</Calendar>
      <IssueDate>20110215</IssueDate>
      <LegData>
        <LegType>Fixed</LegType>
        <Payer>false</Payer>
        <Currency>EUR</Currency>
        <Notionals>
          <Notional>1</Notional>
        </Notionals>
        <DayCounter>ActActISMA</DayCounter>
        <PaymentConvention>F</PaymentConvention>
        <FixedLegData>
          <Rates>
            <Rate>0.02</Rate>
          </Rates>
        </FixedLegData>
        <ScheduleData>
          <Rules>
            <StartDate>20190103</StartDate>
            <EndDate>20200103</EndDate>
            <Tenor>1Y</Tenor>
            <Calendar>TARGET</Calendar>
            <Convention>U</Convention>
            <TermConvention>U</TermConvention>
            <Rule>Forward</Rule>
            <EndOfMonth/>
            <FirstDate/>
            <LastDate/>
          </Rules>
        </ScheduleData>
      </LegData>
    </BondReferenceData>
  </ReferenceDatum>
</ReferenceData>
```
