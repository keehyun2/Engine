### CPI Swap

A CPI inflation swap can be set up using the *InflationSwap* trade type,
with one leg of type `CPI`. and the other leg(s) can be of any leg type.
Listing <a href="#lst:cpiinflationswap" data-reference-type="ref"
data-reference="lst:cpiinflationswap">[lst:cpiinflationswap]</a> shows
an example. The CPI leg contains an additional `CPILegData` block. See
<a href="#ss:cpilegdata" data-reference-type="ref"
data-reference="ss:cpilegdata">[ss:cpilegdata]</a> for details on the
CPI leg specification.

Note that Cross Currency Inflation Swaps are supported, as the
currencies on the legs of an *InflationSwap* do not need to be the same.

<div class="listing">

``` xml
    <InflationSwapData>
      <LegData>
        <LegType>Floating</LegType>
        <Payer>true</Payer>
        ...
      </LegData>
      <LegData>
        <LegType>CPI</LegType>
        <Payer>false</Payer>
        ...
        <CPILegData>
        ...
        </CPILegData>
      </LegData>
    </InflationSwapData>
```

</div>

Alternatively, a CPI swap can be set up as a swap with trade type
*Swap*, with one leg of type `CPI`, see listing
<a href="#lst:cpiswap" data-reference-type="ref"
data-reference="lst:cpiswap">[lst:cpiswap]</a>.

<div class="listing">

``` xml
    <SwapData>
      <LegData>
        <LegType>Floating</LegType>
        <Payer>true</Payer>
        ...
      </LegData>
      <LegData>
        <LegType>CPI</LegType>
        <Payer>false</Payer>
        ...
        <CPILegData>
        ...
        </CPILegData>
      </LegData>
    </SwapData>
```

</div>
