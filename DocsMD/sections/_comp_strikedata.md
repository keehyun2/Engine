### StrikeData

This trade component that can be used to define the strike entity for
commodity, equity and bond options. It can be used to define either a
Price or Yield strike, with examples below in
<a href="#lst:strikeprice" data-reference-type="ref"
data-reference="lst:strikeprice">[lst:strikeprice]</a> and
<a href="#lst:strikeyield" data-reference-type="ref"
data-reference="lst:strikeyield">[lst:strikeyield]</a> respectively.

<div class="listing">

``` xml
        <StrikeData>
        <StrikePrice>
            <Value>1</Value>
            <Currency>EUR</Currency>
        </StrikePrice>
    </StrikeData>
```

</div>

The meanings and allowable values of the elements in the `StrikePrice`
node are as follows:

- `Value`: The strike price.

  Allowable values: Any positive real number.

- `Currency` \[Mandatory for Quanto/Compo, Optional otherwise\]: The
  currency of the amount given in `Value`, i.e. the strike currency.

  Note:  
  Quanto: The payment/leg currency and the currency the underlying asset
  is quoted in differ. The strike currency is in the currency the asset
  is quoted in.  
  Compo (Composite): The payment/leg currency and the currency the
  underlying asset is quoted in differ. The strike currency is in the
  payment/leg currency.

  Allowable values: See Table
  <a href="#tab:currency" data-reference-type="ref"
  data-reference="tab:currency">[tab:currency]</a> `Currency`. Minor
  Currencies in Table <a href="#tab:currency" data-reference-type="ref"
  data-reference="tab:currency">[tab:currency]</a> are also allowable.
  In non-quanto/compo cases, if left blank or omitted, it defaults to
  the currency of the leg for equity and commodity options, and to the
  currency the underlying bond is quoted in for BondOptions using
  reference data.

<div class="listing">

``` xml
    <StrikeData>
        <StrikeYield>
            <Yield>0.055</Yield>
            <Compounding>SimpleThenCompounded</Compounding>
        </StrikeYield>
    </StrikeData>
```

</div>

The meanings and allowable values of the elements in the `StrikeYield`
node are as follows:

- `Yield`: A Yield quoted in decimal form, e.g. 10% should be entered as
  0.1.

  Allowable values: Any real number.

- `Compounding` \[Optional\]: The compounding or the yield given in
  `Yield`.

  Allowable values: *Simple, Compounded, Continuous,
  SimpleThenCompounded*. Defaults to *SimpleThenCompounded* if left
  blank or omitted.
