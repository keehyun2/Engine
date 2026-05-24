### Cash Position

The `CashPositionData` node is the trade data container for the
*CashPosition* trade type. The structure - including example values - of
the `CashPositionData` node is shown in Listing
<a href="#lst:cashposition_data" data-reference-type="ref"
data-reference="lst:cashposition_data">[lst:cashposition_data]</a>.

A cash position can be used both as a stand alone trade type (TradeType:
*CashPosition*) or as a trade component within the *TotalReturnSwap*
(Generic TRS) trade type.

<div class="listing">

``` xml
        <CashPositionData>
            <Currency>EUR</Currency>
            <Amount>1000000</Amount>
        </CashPositionData>
```

</div>

The meanings and allowable values of the various elements in the
`CashPositionData` node follow below.

- Currency: The currency of cash position.  
  Allowable values: See Table
  <a href="#tab:currency" data-reference-type="ref"
  data-reference="tab:currency">[tab:currency]</a> `Currency`.

- Amount: The amount of cash position.  
  Allowable values: Any real number.
