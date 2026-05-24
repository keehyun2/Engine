### Commodity Position

An commodity position represents a position in a single commodity -
using a single `Underlying` node, or in a weighted basket of underlying
commodities - using multiple `Underlying` nodes.

An commodity Position can be used both as a stand alone trade type
(TradeType: *CommodityPosition*) or as a trade component
(`CommodityPositionData`) used within the *TotalReturnSwap* (Generic
TRS) trade type, to set up for example Commodity Basket trades.

If the *PriceType* is set to *FutureSettlement* it will refer by default
to today’s prompt (lead) future. At the moment a generic TRS doesn’t
support rolling of the future contracts. Today’s prompt future could be
different from the prompt future at inception. If the initial price for
the basket is not set, it will use the price of today’s prompt future at
trade inception as initial price and the TRS will also ignore the roll
yield caused by rolling from one prompt future to the next contract.

It is set up using an `CommodityPositionData` block as shown in listing
<a href="#lst:commoditypositiondata" data-reference-type="ref"
data-reference="lst:commoditypositiondata">[lst:commoditypositiondata]</a>.
The meanings and allowable values of the elements in the block are as
follows:

- Quantity: The number of shares or units of the weighted basket held.  
  Allowable values: Any positive real number

- Underlying: One or more underlying descriptions. If a basket of
  commodities is defined, the `Weight` field should be populated for
  each underlyings. The weighted basket price is then given by  
  $$\text{Basket-Price} = \text{Quantity} \times \sum_i \text{Weight}_i \times S_i \times \text{FX}_i$$
  where

  - $S_i$ is the i-th commodity prompt future or spot price in the
    basket

  - $FX_i$ is the FX Spot converting from the ith commodity currency to
    the first commodity currency which is by definition the currency in
    which the npv of the basket is expressed.

  Allowable values: See
  <a href="#ss:underlying" data-reference-type="ref"
  data-reference="ss:underlying">[ss:underlying]</a> for the definition
  of an underlying. Only commodity underlyings are allowed.

<div class="listing">

``` xml
  <Trade id="CommodityPosition">
    <TradeType>CommodityPosition</TradeType>
    <Envelope>...</Envelope>
    <CommodityPositionData>
      <Quantity>1000</Quantity>
      <Underlying>
        <Type>Commodity</Type>
        <Name>NYMEX:CL</Name>
        <Weight>0.5</Weight>
        <PriceType>FutureSettlement</PriceType>
        <FutureMonthOffset>0</FutureMonthOffset>
        <DeliveryRollDays>0</DeliveryRollDays>
        <DeliveryRollCalendar>TARGET</DeliveryRollCalendar>
      </Underlying>
      <Underlying>
        <Type>Commodity</Type>
        <Name>ICE:B</Name>
        <Weight>0.5</Weight>
        <PriceType>FutureSettlement</PriceType>
        <FutureMonthOffset>0</FutureMonthOffset>
        <DeliveryRollDays>0</DeliveryRollDays>
        <DeliveryRollCalendar>TARGET</DeliveryRollCalendar>
      </Underlying>
    </CommodityPositionData>
  </Trade>
```

</div>
