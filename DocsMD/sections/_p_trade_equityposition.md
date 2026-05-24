### Equity Position

An equity position represents a position in a single equity - using a
single `Underlying` node, or in a weighted basket of underlying
equities - using multiple `Underlying` nodes.

An Equity Position can be used both as a stand alone trade type
(TradeType: *EquityPosition*) or as a trade component
(`EquityPositionData`) used within the *TotalReturnSwap* (Generic TRS)
trade type, to set up for example Equity Basket trades.

It is set up using an `EquityPositionData` block as shown in listing
<a href="#lst:equitypositiondata" data-reference-type="ref"
data-reference="lst:equitypositiondata">[lst:equitypositiondata]</a>.
The meanings and allowable values of the elements in the block are as
follows:

- Quantity: The number of shares or units of the weighted basket held.  
  Allowable values: Any positive real number

- Underlying: One or more underlying descriptions. If a basket of
  equities is defined, the `Weight` field should be populated for each
  underlyings. The weighted basket price is then given by  
  $$\text{Basket-Price} = \text{Quantity} \times \sum_i \text{Weight}_i \times S_i \times \text{FX}_i$$
  where

  - $S_i$ is the price of the ith share in the basket

  - $FX_i$ is the FX Spot converting from the ith equity currency to the
    first equity currency which is by definition the currency in which
    the npv of the basket is expressed.

  Allowable values: See
  <a href="#ss:underlying" data-reference-type="ref"
  data-reference="ss:underlying">[ss:underlying]</a> for the definition
  of an underlying. Only equity underlyings are allowed.

<div class="listing">

``` xml
  <Trade id="EquityPosition">
    <TradeType>EquityPosition</TradeType>
    <Envelope>...</Envelope>
    <EquityPositionData>
      <Quantity>1000</Quantity>
        <Underlying>
          <Type>Equity</Type>
          <Name>BE0003565737</Name>
          <Weight>0.5</Weight>
          <IdentifierType>ISIN</IdentifierType>
          <Currency>EUR</Currency>
          <Exchange>XFRA</Exchange>
        </Underlying>
        <Underlying>
          <Type>Equity</Type>
          <Name>GB00BH4HKS39</Name>
          <Weight>0.5</Weight>
          <IdentifierType>ISIN</IdentifierType>
          <Currency>GBP</Currency>
          <Exchange>XLON</Exchange>
        </Underlying>
    </EquityPositionData>
  </Trade>
```

</div>
