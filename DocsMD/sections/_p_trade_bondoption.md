### Bond Option

A bond option provides the buyer with the right, but not the obligation,
to buy or sell a given bond at a fixed price either at or before a
specific date. Options are written on government bonds and are traded on
an OTC basis.

The structure of a trade node representing a *BondOption* is shown in
listing <a href="#lst:bondoption_data" data-reference-type="ref"
data-reference="lst:bondoption_data">[lst:bondoption_data]</a>:

- The `BondOptionData` node is the trade data container for the option
  part of a bond option trade type. Vanilla bond options are supported,
  the exercise style must be *European*. The `BondOptionData` node
  includes one and only one `OptionData` trade component sub-node plus
  elements specific to the bond option.

- The latter also includes the underlying Bond description in the
  `BondData` node, see section
  <a href="#ss:bond" data-reference-type="ref"
  data-reference="ss:bond">[ss:bond]</a>, listing
  <a href="#lst:bonddata" data-reference-type="ref"
  data-reference="lst:bonddata">[lst:bonddata]</a> for details

<div class="listing">

``` xml
  <Trade id="...">
    <TradeType>BondOption</TradeType>
    <Envelope>
        ...
    </Envelope>
    <BondOptionData>
      <OptionData>
          ...
      </OptionData>
      <StrikeData>
        <StrikePrice>
          <Value>11809123.56</Value>
          <Currency>EUR</Currency>
        </StrikePrice>
      </StrikeData>
      <Redemption>100.00</Redemption>
      <PriceType>Dirty</PriceType>
      <KnocksOut>false</KnocksOut>
      <BondData>
         <VolatilityCurveId>YieldVols-EUR</VolatilityCurveId>
          ...
      <BondData>
    </BondOptionData>
  </Trade>
```

</div>

The meanings and allowable values of the elements in the
`BondOptionData` node follow below.

- OptionData: This is a trade component sub-node outlined in section
  <a href="#ss:option_data" data-reference-type="ref"
  data-reference="ss:option_data">[ss:option_data]</a> Option Data. Note
  that the bond option type allows for *European* option style only.

- StrikeData: A node containing the strike information. Allowable
  values: Supports `StrikePrice` and `StrikeYield` as described in
  Section <a href="#ss:strikedata" data-reference-type="ref"
  data-reference="ss:strikedata">[ss:strikedata]</a>.

- Redemption: Redemption ratio in percent

- PriceType: This node defines which strike should be used for the
  pricing. If the node takes the value Dirty, the strike price should be
  set equal to the value of the Strike node. If the node takes the value
  Clean, the strike price should be set equal to the value of the Strike
  node plus accrued interest at the expiration date of the option.  
  Allowable values: Dirty or Clean.

- KnocksOut: If true the option knocks out if the underlying defaults
  before the option expiry, if false the option is written on the
  recovery value in case of a default of the bond before the option
  expiry

The meanings and allowable values of the elements in the `BondData` are:

- VolatilityCurveId: The yield volatility curve to use for the valuation
  of this bond option.
