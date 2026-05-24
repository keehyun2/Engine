### Premiums

The `Premiums` node holds data of one or more premiums to be paid. It is
used in different trade types, notably in caps / floors (see section
<a href="#ss:capfloor" data-reference-type="ref"
data-reference="ss:capfloor">[ss:capfloor]</a>) and more generally in
the option data component (see section
<a href="#ss:option_data" data-reference-type="ref"
data-reference="ss:option_data">[ss:option_data]</a>). Listing
<a href="#lst:premiums" data-reference-type="ref"
data-reference="lst:premiums">[lst:premiums]</a> shows an example for a
Premiums data block representing two premiums.

<div class="listing">

``` xml
<Premiums>
  <Premium>
    <Amount>1000</Amount>
    <Currency>EUR</Currency>
    <PayDate>2021-01-27</PayDate>
    <SettlementData>...</SettlementData>
  </Premium>
  <Premium>
    <Amount>5000</Amount>
    <Currency>USD</Currency>
    <PayDate>2023-01-27</PayDate>
  </Premium>
</Premiums>
```

</div>

The meanings and allowable values of the elements in the `Premium` node
follow below.

- Amount: Option premium amounts paid by the option buyer to the option
  seller. A positive amount is considered to be paid by the option
  holder to the option seller and thus results in a negative
  contribution to the NPV of a long option.  
  Allowable values: arbitrary number

- Currency: Currency of the premium to be paid  
  Allowable values: See Table
  <a href="#tab:currency" data-reference-type="ref"
  data-reference="tab:currency">[tab:currency]</a> `Currency`.

- PayDate: Date of the premium payment.  
  Allowable values: See `Date` in Table
  <a href="#tab:allow_stand_data" data-reference-type="ref"
  data-reference="tab:allow_stand_data">[tab:allow_stand_data]</a>.

- SettlementData \[Optional\]: Converts the premium into a currency
  different. It specifies the payment currency, the FX index to perform
  the conversion, and the date on which the FX rate is fixed. Its XML
  form is shown in listing
  <a href="#lst:settlement_data_premiums" data-reference-type="ref"
  data-reference="lst:settlement_data_premiums">[lst:settlement_data_premiums]</a>.

  - `PayCurrency`: Currency in which the option premium will be settled.

  - `FXIndex`: FX index used to convert from the premium currency into
    the settlement currency.

  - `FixingDate` \[Optional\]: Date on which the FX rate is taken. If
    omitted, the engine will use the index convention to derive the
    fixing date from the payment date. It will subtract
    \*\*FixingDays\*\* from the payment date and adjust the resulting
    date for the holidays according to the fx index conventions.

We support a deprecated schema to represent a single premium as shown in
listing <a href="#lst:premiums_deprecated" data-reference-type="ref"
data-reference="lst:premiums_deprecated">[lst:premiums_deprecated]</a>
for backwards compatibility. The $3$ nodes PremiumAmount,
PremiumCurrency, PremiumPayDate can be used on the same level as the new
Premiums node to represent a single premium payment. The deprecated and
new schema may not be mixed.

<div class="listing">

``` xml
  <PremiumAmount>1000</PremiumAmount>
  <PremiumCurrency>EUR</PremiumCurrency>
  <PremiumPayDate>2021-01-27</PremiumPayDate>
```

</div>

<div class="listing">

``` xml
<SettlementData>
  <PayCurrency>USD</PayCurrency>
  <FXIndex>FX-ECB-EUR-USD</FXIndex>
  <FixingDate>2020-03-28</FixingDate>
</SettlementData>
```

</div>
