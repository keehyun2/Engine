### Bond

A Bond is set up using a `BondData` block, and can be both a stand-alone
instrument with trade type *Bond*, or a trade component used by multiple
bond derivative instruments.

A Bond can be set up in a short version referencing an underlying bond
static, or in a long version where the underlying bond details are
specified explicitly, including a full LegData block. The short version
is shown in listing
<a href="#lst:bonddata_refdata" data-reference-type="ref"
data-reference="lst:bonddata_refdata">[lst:bonddata_refdata]</a>. The
details of the bond are read from the reference data in this case using
the SecurityId as a key. The bond trade is fully specified by

- SecurityId: The id identifying the bond.

  Allowable Values: A valid bond identifier, typically the ISIN of the
  reference bond with the ISIN: prefix, e.g.: `ISIN:XXNNNNNNNNNN`

- BondNotional: The notional of the position in the reference bond,
  expressed in the currency of the bond.

  Allowable Values: Any non-negative real number

- CreditRisk \[Optional\] Boolean flag indicating whether to show Credit
  Risk on the Bond product. If set to *false*, the product class will
  not be set to *Credit*, and there will be no credit sensitivities.
  However, if the underlying bond reference is set up without a
  CreditCurveId - typically for some highly rated government bonds - the
  CreditRisk flag will have no impact on the product class and no credit
  sensitivities will be shown even if CreditRisk is set to *true*.

  Allowable Values: *true* or *false* Defaults to *true* if left blank
  or omitted.

in this case.

<div class="listing">

``` xml
    <BondData>
      <SecurityId>ISIN:XS0982710740</SecurityId>
      <BondNotional>100000000.0</BondNotional>
      <CreditRisk>true</CreditRisk>
    </BondData>
```

</div>

For the long version, the bond details are inlined in the trade as shown
in listing <a href="#lst:bonddata" data-reference-type="ref"
data-reference="lst:bonddata">[lst:bonddata]</a>. The bond specific
elements are

- IssuerId \[Optional\]: A text description of the issuer of the bond.
  This is for informational purposes and not used for pricing.

  Allowable values: Any string. If left blank or omitted, the bond will
  not have any issuer description.

- CreditCurveId \[Optional\]: The unique identifier of the bond. This is
  used for pricing, and is required for bonds for which a credit -
  related margin component should be generated, and otherwise left
  blank. If left blank, the bond (and any bond derivatives using the
  bond as a trade component) will be plain IR rather than a IR/CR.

  Allowable values: A valid bond identifier, typically the ISIN of the
  reference bond with the ISIN: prefix, e.g.: `ISIN:XXNNNNNNNNNN`

- SecurityId: The unique identifier of the bond. This defines the
  security specific spread to be used for pricing.

  Allowable values: A valid bond identifier, typically the ISIN of the
  reference bond with the ISIN: prefix, e.g.: `ISIN:XXNNNNNNNNNN`

- ReferenceCurveId: The benchmark curve to be used for pricing. This is
  typically the main ibor index for the currency of the bond, and if no
  ibor index is available for the currency in question, a
  currency-specific benchmark curve can be used.

  Allowable values: For currencies with available ibor indices:  
  An alphanumeric string of the form \[CCY\]-\[INDEX\]-\[TERM\]. CCY,
  INDEX and TERM must be separated by dashes (-). CCY and INDEX must be
  among the supported currency and index combinations. TERM must be an
  integer followed by D, W, M or Y. See Table
  <a href="#tab:indices" data-reference-type="ref"
  data-reference="tab:indices">[tab:indices]</a>.

  For currencies without available ibor indices:  
  An alphanumeric string, matching a benchmark curve set up in the
  market data configuration in `todaysmarket.xml` Yield curves section.

  Examples: IDRBENCHMARK-IDR-3M, EGPBENCHMARK-EGP-3M,
  UAHBENCHMARK-UAH-3M, NGNBENCHMARK-NGN-3M

- SettlementDays: The settlement lag in number of business days
  applicable to the security.

  Allowable values: A non-negative integer.

- Calendar: The calendar associated to the settlement lag.

  Allowable values: See Table
  <a href="#tab:calendar" data-reference-type="ref"
  data-reference="tab:calendar">[tab:calendar]</a> Calendar.

- IssueDate: The issue date of the security.

  See `Date` in Table
  <a href="#tab:allow_stand_data" data-reference-type="ref"
  data-reference="tab:allow_stand_data">[tab:allow_stand_data]</a>.

- PriceQuoteMethod \[Optional\]: The quote method of the bond. Bond
  price quotes and historical bond prices (stored as “fixings”) follow
  this method. Also, the initial price for bond total return swaps
  follows this method. Defaults to PerentageOfPar.

  Allowable values: PercentageOfPar or CurrencyPerUnit

- PriceQuoteBaseValue \[Optional\]: The base value for quote method =
  CurrencyPerUnit. Bond price quotes, historical bond prices stored as
  fixings and initial prices in bond total return swaps are divided by
  this value. Defaults to 1.0.

  Allowable values: Any real number.

A LegData block then defines the cashflow structure of the bond, this
can be of type fixed, floating etc. Note that a LegData block should
only be included in the long version.

<div class="listing">

``` xml
    <BondData>
        <IssuerId>Ineos Group Holdings SA</IssuerId>
        <CreditCurveId>ISIN:XS0982710740</CreditCurveId>
        <SecurityId>ISIN:XS0982710740</SecurityId>
        <ReferenceCurveId>EUR-EURIBOR-6M</ReferenceCurveId>
        <SettlementDays>2</SettlementDays>
        <Calendar>TARGET</Calendar>
        <IssueDate>20160203</IssueDate>
        <PriceQuoteMethod>PercentageOfPar</PriceQuoteMethod>
        <PriceQuoteBaseValue>1.0</PriceQuoteBaseValue>
        <LegData>
            <LegType>Fixed</LegType>
            <Payer>false</Payer>
            ...
        </LegData>
    </BondData>
```

</div>

The bond trade type supports perpetual schedules, i.e. perpetual bonds
can be represented by omitting the EndDate in the leg data schedule
definition. Only rule based schedules can be used to indicate perpetual
schedules.
