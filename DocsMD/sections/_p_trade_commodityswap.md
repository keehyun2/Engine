### Commodity Swap and Basis Swap

The structure of a `CommoditySwap` trade node is shown in listing
<a href="#lst:commodityswap_data" data-reference-type="ref"
data-reference="lst:commodityswap_data">[lst:commodityswap_data]</a>.
This trade node can be used to represent commodity swaps and commodity
basis swaps. It consists of the generic `Envelope` and the specific
`SwapData` section.

The `SwapData` node may contain two or more `LegData` nodes. There must
be at least one `LegData` node of a commodity `LegType`, i.e.
`CommodityFixed` or `CommodityFloating`, but non-commodity leg types are
also allowed. The commodity leg types are described in sections
<a href="#ss:commodityfixedleg" data-reference-type="ref"
data-reference="ss:commodityfixedleg">[ss:commodityfixedleg]</a> and
<a href="#ss:commodityfloatingleg" data-reference-type="ref"
data-reference="ss:commodityfloatingleg">[ss:commodityfloatingleg]</a>
respectively.

The `SwapData` node also supports optional netting functionality for
floating legs through the `RoundNettedFloatingLegs` and
`NettingPrecision` elements. When `RoundNettedFloatingLegs` is set to
`true`, all floating leg cashflows are netted by payment date, while
fixed legs are processed normally. The netting calculation sums the
effective fixings of all floating legs for each payment period and
multiplies by the common quantity. If `NettingPrecision` is specified,
the summed fixing is rounded to the specified number of decimal places
before multiplying by the quantity.

<div class="listing">

``` xml
<Trade id="...">
  <TradeType>CommoditySwap</TradeType>
  <Envelope>
  </Envelope>
  <SwapData>
    <LegData>
      <LegType>CommodityFixed</LegType>
      ...
    </LegData>
    <LegData>
      <LegType>CommodityFloating</LegType>
      ...
    </LegData>
    <RoundNettedFloatingLegs>true</RoundNettedFloatingLegs>
    <NettingPrecision>2</NettingPrecision>
  </SwapData>
</Trade>
```

</div>

The optional netting parameters are:

- `RoundNettedFloatingLegs` \[Optional\]: Boolean flag to enable
  floating leg netting. When set to `true`, all floating leg cashflows
  with the same payment date are netted into a single cashflow. Fixed
  legs are processed normally and are not affected by netting. Defaults
  to `false`.

- `NettingPrecision` \[Optional\]: Number of decimal places to round the
  total average fixing before multiplying by the quantity. Only applies
  when `RoundNettedFloatingLegs` is `true`. If not specified, no
  rounding is applied to the netted fixing.

The netting calculation works as follows:

1.  All floating leg cashflows are grouped by their payment date

2.  For each payment date, the system verifies that all participating
    cashflows have the same `periodQuantity()`

3.  The effective fixings are summed:
    $\sum (\text{isPayer} ? -1 : 1) \times \text{fixing()}$

4.  If `NettingPrecision` is specified, the sum is rounded to the
    specified decimal places

5.  The final netted amount is calculated as: rounded_sum $\times$
    common_quantity
