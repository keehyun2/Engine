### Bond Position

A bond position represents a position in a weighted basket of underlying
bonds.

A bond position can be used both as a stand alone trade type (TradeType:
*BondPosition*) or as a trade component (`BondBasketData`) used within
the *TotalReturnSwap* (Generic TRS) trade type.

It is set up using an `BondBasketData` block as shown in listing
<a href="#lst:bondbasketdata" data-reference-type="ref"
data-reference="lst:bondbasketdata">[lst:bondbasketdata]</a>. The
meanings and allowable values of the elements in the block are as
follows:

- Quantity: The number of units of the weighted basket held.  
  Allowable values: Any positive real number

- Identifier\[Optional\]: The identifier of the weighted basket. The
  Underlying data can be retrieved from the reference data via this
  identifier, if not given in the trade itself. If the bond basket data
  is set up in the trade itself in Underlying blocks as in listing
  <a href="#lst:bondbasketdata" data-reference-type="ref"
  data-reference="lst:bondbasketdata">[lst:bondbasketdata]</a>, no
  Identifier is required.  
  Allowable values: A string that matches the reference data.

- Underlying\[Optional\]: One or more underlying descriptions. If bond
  basket data is set up in the reference data for the given identifier,
  the underlying data will be populated from there and does not need to
  be provided in the trade. The weighted basket price is then given by  
  $$\text{Basket-Price} = \text{Quantity} \times \sum_i \text{Weight}_i \times B_i \times \text{FX}_i$$
  where

  - $B_i$ is the price of the ith Bond in the basket

  - $FX_i$ is the FX Spot converting from the currency of the ith Bond
    to the return currency if the BondPosition is in a TotalReturnSwap,
    otherwise to the currency of the first Bond in the basket.

  Allowable values: See
  <a href="#ss:underlying" data-reference-type="ref"
  data-reference="ss:underlying">[ss:underlying]</a> for the definition
  of an underlying. Only underlyings of Type *Bond* are allowed.

<div class="listing">

``` xml
  <Trade id="BondPosition">
    <TradeType>BondPosition</TradeType>
    <Envelope>...</Envelope>
    <BondBasketData>
      <Quantity>1000</Quantity>
      <Identifier>ISIN:GB00B4KT9Q30</Identifier>
      <Underlying>
        <Type>Bond</Type>
        <Name>US69007TAB08</Name>
        <IdentifierType>ISIN</IdentifierType>
        <Weight>0.5</Weight>
        <BidAskAdjustment>-0.0025</BidAskAdjustment>
      </Underlying>
      <Underlying>
        <Type>Bond</Type>
        <Name>US750236AW16</Name>
        <IdentifierType>ISIN</IdentifierType>
        <Weight>0.5</Weight>
        <BidAskAdjustment>-0.005</BidAskAdjustment>
      </Underlying>
    </BondBasketData>
  </Trade>
```

</div>
