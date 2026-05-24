### Bond Basket Data for Cashflow CDO

This trade component node is used in a Cashflow CDO trade as explained
in <a href="#ss:CBOData" data-reference-type="ref"
data-reference="ss:CBOData">[ss:CBOData]</a>. An example structure of
the `BondBasketData` trade component node is shown in Listing
<a href="#lst:bondbasketdata2" data-reference-type="ref"
data-reference="lst:bondbasketdata2">[lst:bondbasketdata2]</a>.

<div class="listing">

``` xml
<BondBasketData>
    <Trade id="Bond_1">
      <TradeType>Bond</TradeType>
      <Envelope>
        ...
      </Envelope>
      <BondData>
        ...
      </BondData>
    </Trade>
    <Trade id="Bond_2">
      <TradeType>Bond</TradeType>
      <Envelope>
        ...
      </Envelope>
      <BondData>
        ...
      </BondData>
    </Trade>
</BondBasketData>
```

</div>

The usage of the BondBasketData is akin to a portfolio of bond trades,
but is embraced by the keyword `BondBasketData` as opposed to
`Portfolio`. Compare the vanilla bond section
<a href="#ss:bond" data-reference-type="ref"
data-reference="ss:bond">[ss:bond]</a> for usage and allowable values.
