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
