### Ascot

**Payoff**

An Ascot or a Convertible Bond Option is an American style option to buy
back a convertible bond. The buyer of a Call Ascot can exercise the deal
and get the underlying bond in exchange for paying the strike.

The payout formula for a Call Ascot is:

$$Payout = \max(0, convertiblePrice - Strike)$$

And for a Put Ascot:

$$Payout = \max(0, Strike - convertiblePrice)$$

where:
$$Strike = bondQuantity \cdot (upfrontPayment + assetLeg - redemptionLeg) - fundingLeg$$

**Input**

An Ascot is set up using an `AscotData` block as shown in listing
<a href="#lst:ascotdata" data-reference-type="ref"
data-reference="lst:ascotdata">[lst:ascotdata]</a>. The bond details are
read from reference data in this case.

<div class="listing">

``` xml
  <Trade id="Ascot">
    <TradeType>Ascot</TradeType>
    <Envelope>...</Envelope>
    <AscotData>
      <ConvertibleBondData>
        <BondData>
          <SecurityId>ISIN:XY1000000000</SecurityId>
          <BondNotional>1000000.00</BondNotional>
        </BondData>
      </ConvertibleBondData>
      <OptionData>
       <LongShort>Long</LongShort>
       <OptionType>Call</OptionType>
       <Style>American</Style>
       <Settlement>Physical</Settlement>
       <ExerciseDates>
         <ExerciseDate>2029-02-03</ExerciseDate>
       </ExerciseDates>  
      </OptionData>
      <ReferenceSwapData>
        <LegData>
          <LegType>Floating</LegType>
          <Payer>false</Payer>
          ...
        </LegData>
      </ReferenceSwapData>
    <AscotData>
  </Trade>
```

</div>

The meanings and allowable values of the elements in the block are as
follows:

- ConvertibleBondData: This describes the underlying convertible bond,
  see <a href="#ss:convertible_bond" data-reference-type="ref"
  data-reference="ss:convertible_bond">[ss:convertible_bond]</a>.

- OptionData: This is a trade component sub-node outlined in section
  <a href="#ss:option_data" data-reference-type="ref"
  data-reference="ss:option_data">[ss:option_data]</a> Option Data. The
  relevant fields in the `OptionData` node for an Ascot are:

  - `LongShort` The allowable values are *Long* or *Short*. The
    LongShort flag multiplies the option price with +1 / -1. Call and
    Put payout formulas above are from the long perspective

  - `OptionType` The allowable values are *Call* or *Put*. See payout
    formulas above.

  - `Style` The Ascot type allows for *American* option exercise style
    only.

  - `Settlement` The allowable values are *Cash* or *Physical*.

  - An `ExerciseDates` node where exactly one `ExerciseDate` date
    element must be given.

  - `Premiums` \[Optional\]: Option premium amounts paid by the option
    buyer to the option seller.

    Allowable values: See section
    <a href="#ss:premiums" data-reference-type="ref"
    data-reference="ss:premiums">[ss:premiums]</a>

- ReferenceSwapData: Contains a single `LegData` node that describes the
  trade’s reference swap funding leg. The asset leg is implied from the
  bond data. Payer should always be *false* i.e. the swap is entered
  from the viewpoint of the asset swap buyer.
