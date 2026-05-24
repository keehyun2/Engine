### FX Swap

The `FXSwapData` node is the trade data container for the *FxSwap* trade
type. The structure - including example values - of the `FXSwapData`
node is shown in Listing
<a href="#lst:fxswap_data" data-reference-type="ref"
data-reference="lst:fxswap_data">[lst:fxswap_data]</a>. It contains no
sub-nodes.

<div class="listing">

``` xml
        <FxSwapData>
            <NearDate>2018-09-01</NearDate>
            <NearBoughtCurrency>EUR</NearBoughtCurrency>
            <NearBoughtAmount>1000000</NearBoughtAmount>
            <NearSoldCurrency>USD</NearSoldCurrency>
            <NearSoldAmount>1140000</NearSoldAmount>
            <FarDate>2028-09-01</FarDate>
            <FarBoughtAmount>1300000</FarBoughtAmount>
            <FarSoldAmount>1000000</FarSoldAmount>
            <Settlement>Cash</Settlement>
        </FxSwapData>
```

</div>

The meanings and allowable values of the various elements in the
`FXSwapData` node follow below. All elements are required.

- NearDate: The date of the initial fx exchange of the FX Swap.  
  Allowable values: See `Date` in Table
  <a href="#tab:allow_stand_data" data-reference-type="ref"
  data-reference="tab:allow_stand_data">[tab:allow_stand_data]</a>.

- NearBoughtCurrency: The currency to be bought in the initial exchange
  at near date, and sold in the final exchange at far date.  
  Allowable values: See Table
  <a href="#tab:currency" data-reference-type="ref"
  data-reference="tab:currency">[tab:currency]</a> `Currency`.

- NearBoughtAmount: The amount to be bought on near date.  
  Allowable values: Any positive real number.

- NearSoldCurrency: The currency to be sold in the initial fx exchange
  at near date, and bought in the final exchange at far date.  
  Allowable values: See Table
  <a href="#tab:currency" data-reference-type="ref"
  data-reference="tab:currency">[tab:currency]</a> `Currency`.

- NearSoldAmount: The amount to be sold on near date.  
  Allowable values: Any positive real number.

- FarDate: The date of the final fx exchange of the FX Swap.  
  Allowable values: Any date further into the future than NearDate. See
  `Date` in Table
  <a href="#tab:allow_stand_data" data-reference-type="ref"
  data-reference="tab:allow_stand_data">[tab:allow_stand_data]</a>.

- FarBoughtAmount: The amount to be bought on far date.  
  Allowable values: Any positive real number.

- FarSoldAmount: The amount to be sold on far date.  
  Allowable values: Any positive real number.

- Settlement \[Optional\]: Delivery type. Note that Non-Deliverable FX
  Swaps can be represented by *Cash* settlement, and that deliverable FX
  Swaps will be excluded from the CRIF output. Delivery type does not
  impact pricing in ORE.

  Allowable values: *Cash* or *Physical*. Defaults to *Physical* if left
  blank or omitted.

Note that FX Swaps also cover Precious Metals swaps, i.e. with
currencies XAU, XAG, XPT, XPD, and Cryptocurrency swaps, see supported
Cryptocurrencies in Table
<a href="#tab:currency" data-reference-type="ref"
data-reference="tab:currency">[tab:currency]</a>.
