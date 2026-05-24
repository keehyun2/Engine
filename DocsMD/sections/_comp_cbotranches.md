### CBO Tranches

This trade component node is used in a CBO trade as explained in
<a href="#ss:CBOData" data-reference-type="ref"
data-reference="ss:CBOData">[ss:CBOData]</a>. An example structure of
the `CBOTranches` trade component node is shown in Listing
<a href="#lst:cbotranches" data-reference-type="ref"
data-reference="lst:cbotranches">[lst:cbotranches]</a>.

<div class="listing">

``` xml
<CBOTranches>
  <Tranche>
    <Name>JuniorNote</Name>
    <ICRatio>0.0</ICRatio>
    <OCRatio>0.0</OCRatio>
    <Notional>4000000.00</Notional>
    <FixedLegData>
      <Rates>
        <Rate>0.03</Rate>
      </Rates>
    </FixedLegData>
  </Tranche>
  ...
</CBOTranches>
```

</div>

The meanings of the elements of the `CBO tranches` node follow below:

- Tranche: Multiple tranches are allowed and are indicated by the
  tranche node within the embracing CBOTranches node.

- Name: This string is the name of the tranche, possibly reflecting the
  position in the capital structure.

- ICRatio: The interest coverage ratio is a number, defined as
  BasketInterest over TrancheInterest (incl. all senior tranches).

- OCRatio: The overcollateralisation ratio is a number, defined as
  BasketNotional over TrancheNotional (incl. all senior tranches).

- Notional: The face amount of the tranche.

Depending on the tranche, one can specify a floating or fixed return via
the nodes:

- FixedLegData, which is outlined in section
  <a href="#ss:fixedleg_data" data-reference-type="ref"
  data-reference="ss:fixedleg_data">[ss:fixedleg_data]</a>.

- FloatingLegData, which is outlined in section
  <a href="#ss:floatingleg_data" data-reference-type="ref"
  data-reference="ss:floatingleg_data">[ss:floatingleg_data]</a>.
