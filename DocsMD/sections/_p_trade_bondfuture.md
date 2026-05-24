### Bond Future

A BondFuture can be used both as a stand alone trade (TradeType:
*BondFuture*) or as a trade component (`BondFutureData`) used within the
*TotalReturnSwap* (Generic TRS) trade type. See listing
<a href="#lst:bondfuturetradedata" data-reference-type="ref"
data-reference="lst:bondfuturetradedata">[lst:bondfuturetradedata]</a>,
and listing <a href="#lst:trsdata35" data-reference-type="ref"
data-reference="lst:trsdata35">[lst:trsdata35]</a> for a BondFuture used
within a TRS.

- ContractName: This ID defines both: which bond future reference datum
  to take and security specific spread to be used for pricing.

  Allowable values: A string identifying the contract name, supported in
  the market data configuration.

- ContractNotional: The notional of the position, expressed in the
  currency of the bond.

  Allowable values: A non-negative real number.

- LongShort: A flag that determines whether the forward contract is
  entered in long (*L*) or short (*S*) position.

  Allowable values: *Long*, *L*, or *Short*, *S*

Although it is not part of the trade representation, we also explain the
corresponding reference data, which is shown in listing
<a href="#lst:bondfuturerefdata" data-reference-type="ref"
data-reference="lst:bondfuturerefdata">[lst:bondfuturerefdata]</a>. The
following fields should always be specified:

- Currency: The currency in which the future is denominated.

  Allowable values: See Table
  <a href="#tab:currency" data-reference-type="ref"
  data-reference="tab:currency">[tab:currency]</a>.

- DeliveryBasket: A list of eligible securities/bond identifiers.

  Allowable Values: A valid bond identifier, typically the ISIN of the
  reference bond with the ISIN: prefix

- Settlement \[Optional\]: *Cash* or *Physical*. Optional, defaults to
  *Physical*.

- DirtyQuotation \[Optional\]: Whether the market quote of the future
  price is dirty (*true*) or clean (*false*, default if not specified).

The last trading (expiry) and last delivery (settlement) date of the
future can be given explicitly:

- LastTradingDate: The expiry date of the future

- LastDeliveryDate: The settlement date of the future

Alternatively, these dates can be derived from the following set of
fields:

- ContractMonth: specifies the delivery month.

  Allowable values are written English calendar month or its three
  letter abbreviation, e.g. *January* or *Jan*.

- RootDate: used to calculate the day of the month.

  Allowable values are *first* for the beginning of the month, *end* for
  month end or nth weekday (e.g. *Monday,3* for third Monday of the
  month).

- ExpiryBasis: used to set the basis for the expiry derivation.

  Allowable values are *ROOT* for the above root date as start date,
  *SETTLEMENT* for the settlement date as a start date

- SettlementBasis: used to set the basis for the settlement date
  derivation.

  Allowable values are *ROOT* for the above root date as start date,
  *EXPIRY* for the expiry date as a start date

- ExpiryLag: Period (positive/negative) which will be added/subtracted
  from the ExpiryBasis, to arrive at the expiry date.

  Allowable values are any combination of integers and *D* for days, *M*
  for months or *Y* for years, e.g. *3D* means a 3-day period.

- SettlementLag: Period (positive/negative) which will be
  added/subtracted from the SettlementBasis, to arrive at the settlement
  date.

  Allowable values are any combination of integers and *D* for days, *M*
  for months or *Y* for years, e.g. *3D* means a 3-day period.

Finally, the conversion factor can be given in the market data or it can
be deduced internally, which requires the following field to be filled:

- DeliverableGrade: The deliverable graded restricting the deliverable
  underlyings. This is used for calculation of the conversion factor.
  Allowable values are: *ZT, Z3N, ZF, ZN, TN, TWE, ZB, UB* (CME) or the
  equivalent *TU, 3Y, FV, TY, UXY, US, TWE, WN* (Bloomberg)

<div class="listing">

``` xml
    <BondFutureData>
      <ContractName>with_ref</ContractName>
      <ContractNotional>1000000</ContractNotional>
      <LongShort>L</LongShort>
    </BondFutureData>
```

</div>

<div class="listing">

``` xml
    <BondFutureReferenceData id="TYU25">
      <!-- should always be specified -->
      <Currency>USD</Currency>
      <DeliveryBasket>
        <SecurityId>ISIN:US91282CDJ71</SecurityId>
        <SecurityId>ISIN:US91282CEP23</SecurityId>
        <SecurityId>ISIN:US91282CLM19</SecurityId>
        <SecurityId>ISIN:US91282CLU35</SecurityId>
        <SecurityId>ISIN:US91282CMC28</SecurityId>
        <SecurityId>ISIN:US91282CMK44</SecurityId>
        <SecurityId>ISIN:US91282CMM00</SecurityId>
        <SecurityId>ISIN:US91282CMR96</SecurityId>
      </DeliveryBasket>
      <Settlement>Physical</Settlement>
      <DirtyQuotation>false</DirtyQuotation>
      <!-- LastTradingDate, LastDeliveryDate can be specified explicitly -->
      <LastTradingDate>2025-09-19</LastTradingDate>
      <LastDeliveryDate>2025-09-30</LastDeliveryDate>
      <!-- only required if LastTradingDate, LastDeliveryDate is not given -->
      <ContractMonth>Mar</ContractMonth>
      <RootDate>End</RootDate>
      <ExpiryBasis>Settlement</ExpiryBasis>
      <SettlementBasis>Root</SettlementBasis>
      <ExpiryLag>-7D</ExpiryLag>
      <SettlementLag>0D</SettlementLag>
      <!-- only required if conversion factor is not given as market data -->
      <DeliverableGrade>ZN</DeliverableGrade>
    </BondFutureReferenceData>
```

</div>

### Derivation of the LastTradingDate and LastDeliveryDate

The example with the reference data block above, i.e. listing
<a href="#lst:bondfuturerefdata" data-reference-type="ref"
data-reference="lst:bondfuturerefdata">[lst:bondfuturerefdata]</a>,
shows how to set up a future referencing an USD 10-Year-T-Note. The
rules to derive last trading and last delivery date are taken from the
CME Group primer “Understanding Treasury Futures”. These are:

- Last Delivery Day: Last business day of the delivery month

- Last Trading Day: Seventh business day preceding the last business day
  of the delivery month

The year is derived from the as-of date. Being the following year or the
same depending whether the contract month has been passed this year or
not. Our starting point, i.e. the root date, is the ’Last business day
of the delivery month’. We achieved this by setting `ContractMonth` =
*March* and `RootDate` = *End*. From this root we can define the
settlement date (last delivery) by `SettlementBasis` = *Root* in
combination with `SettlementLag` = *0D*. From the settlement, we can
define the expiry date (last trading) by `ExpiryBasis` = *Settlement*
and `ExpiryLag` = *-7D*. From this we are getting the Last Trading Date
to be the 20th of March and the Last Delivery Date to be the 31st of
March.

### CTD Selection

The selection of the CTD bond is implemented in ORE as described in
Hull’s “Options, Futures and Other Derivatives”: Be *sp* the quoted
future settlement price, *ai* accrued interest, *cf* the bond specific
conversion factor and *bp* the bond price. The party with the short
position receives

$$(sp \cdot cf) + ai$$

and the cost of purchasing a bond is

$$bp + ai$$

The cheapest-to-deliver bond is the one for which

$$bp - (sp \cdot cf)$$

is least. The decision is taking place at future expiry.
