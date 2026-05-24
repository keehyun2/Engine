### Forward Rate Agreement

A forward rate agreement (trade type *ForwardRateAgreement* is set up
using a  
`ForwardRateAgreementData` block as shown in listing
<a href="#lst:ForwardRateAgreementdata" data-reference-type="ref"
data-reference="lst:ForwardRateAgreementdata">[lst:ForwardRateAgreementdata]</a>.
The forward rate agreement specific elements are:

- StartDate: A FRA expires/settles on the startDate.  
  Allowable values: See `Date` in Table
  <a href="#tab:allow_stand_data" data-reference-type="ref"
  data-reference="tab:allow_stand_data">[tab:allow_stand_data]</a>.

- EndDate: EndDate is the date when the forward loan or deposit ends. It
  follows that (EndDate - StartDate) is the tenor/term of the underlying
  loan or deposit.

  Allowable values: See `Date` in Table
  <a href="#tab:allow_stand_data" data-reference-type="ref"
  data-reference="tab:allow_stand_data">[tab:allow_stand_data]</a>.

- Currency: The currency of the FRA notional.  
  Allowable values: See Table
  <a href="#tab:currency" data-reference-type="ref"
  data-reference="tab:currency">[tab:currency]</a> `Currency`.

- Index: The name of the interest rate index the FRA is benchmarked
  against.

  Allowable values: An alphanumeric string of the form CCY-INDEX-TENOR.
  CCY, INDEX and TENOR must be separated by dashes (-). CCY and INDEX
  must be among the supported currency and index combinations. TENOR
  must be an integer followed by D, W, M or Y, except for Overnight
  indices which do not require a TENOR. See Table
  <a href="#tab:indices" data-reference-type="ref"
  data-reference="tab:indices">[tab:indices]</a>.

- LongShort: Specifies whether the FRA position is long (one receives
  the agreed rate) or short (one pays the agreed rate).

  Allowable values: *Long*, *Short*.

- Strike: The agreed forward interest rate.

  Allowable values: Any real number. The strike rate is expressed in
  decimal form, e.g. 0.05 is a rate of 5%.

- Notional: No accretion or amortisation, just a constant notional.  
  Allowable values: Any positive real number.

<div class="listing">

``` xml
    <ForwardRateAgreementData>
        <StartDate>20161028</StartDate>
        <EndDate>20351028</EndDate>
        <Currency>EUR</Currency>
        <Index>EUR-EURIBOR-6M</Index>
        <LongShort>Long</LongShort>
        <Strike>0.001</Strike>
        <Notional>1000000000</Notional>
    </ForwardRateAgreementData>
```

</div>
