### Commodity Variance and Volatility Swap

A Commodity Variance or Volatility Swap has a payoff that depends on the
volatility/variance of an underlying commodity instrument. See section
<a href="#SubSectionEqVarianceSwap" data-reference-type="ref"
data-reference="SubSectionEqVarianceSwap">[SubSectionEqVarianceSwap]</a>
for the equivalent Equity product.

The `CommodityVarianceSwapData` node is the trade data container for the
*CommodityVarianceSwap* trade type. The structure of an example
`CommodityVarianceSwapData` node for a Commodity Variance Swap is the
same as for an Equity Variance Swap in section
<a href="#SubSectionEqVarianceSwap" data-reference-type="ref"
data-reference="SubSectionEqVarianceSwap">[SubSectionEqVarianceSwap]</a>,
with the exception of the underlying node which is of type ’Commodity’
here. See section <a href="#ss:underlying" data-reference-type="ref"
data-reference="ss:underlying">[ss:underlying]</a> for additional
optional elements of the underlying node and allowable values.
