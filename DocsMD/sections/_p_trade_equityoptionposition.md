### Equity Option Position

An equity option position represents a position in a single equity
option - using a single `Underlying` node, or in a weighted basket of
underlying equity options - using multiple `Underlying` nodes.

An Equity Option Position can be used both as a stand alone trade type
(TradeType: *EquityOptionPosition*) or as a trade component
(`EquityOptionPositionData`) used within the *TotalReturnSwap* (Generic
TRS) trade type, to set up for example Equity Option Basket trades.

It is set up using an `EquityOptionPositionData` block as shown in
listing
<a href="#lst:equityoptionpositiondata" data-reference-type="ref"
data-reference="lst:equityoptionpositiondata">[lst:equityoptionpositiondata]</a>.
The meanings and allowable values of the elements in the block are as
follows:

- Quantity: The number of options written on one underlying share resp.
  the number of units of the option basket held.  
  Allowable values: Any positive real number

- Underlying: One or more underlying descriptions, each comprising an
  `Underlying` block, an `Optiondata` block and a `Strike` element, in
  that order:

  - Underlying: an underlying description, see
    <a href="#ss:underlying" data-reference-type="ref"
    data-reference="ss:underlying">[ss:underlying]</a>, only equity
    underlying are allowed

  - OptionData: the option description, see
    <a href="#ss:option_data" data-reference-type="ref"
    data-reference="ss:option_data">[ss:option_data]</a>, the relevant /
    allowed data is

    - LongShort: the type of the position,*long* and *Short* positions
      are allowed. Note that negative weights are allowed. A *long*
      position with a negative weight results in a *short* position, and
      a *short* position with a negative weight results in a *long*
      position.

    - OptionType: *Call* or *Put*

    - Style: *European* or *American*

    - Settlement: *Cash* or *Physical*

    - ExerciseDates: exactly one exercise must be given representing the
      European exercise date or the last American exercise date

  - Strike: the strike of the option. Allowable values are non-negative
    real numbers.

If a basket of equities is defined, the `Weight` field should be
populated for each underlying. The weighted basket price is then given
by
$$\text{Basket-Price} = \text{Quantity} \times \sum_i \text{Weight}_i \times p_i \times \text{FX}_i$$
where

- $p_i$ is the price of the ith option in the basket, written on one
  underlying share

- $FX_i$ is the FX Spot converting from the ith equity currency to the
  first equity currency which is by definition the currency in which the
  npv of the basket is expressed.

<div class="listing">

``` xml
<Trade id="EquityOptionPositionTrade">
  <TradeType>EquityOptionPosition</TradeType>
  <EquityOptionPositionData>
    <!-- basket price = quantity x sum_i ( weight_i x equityOptionPrice_i x fx_i ) -->
    <Quantity>1000</Quantity>
    <!-- option #1 -->
    <Underlying>
      <Underlying>
        <Type>Equity</Type>
        <Name>.SPX</Name>
        <Weight>0.5</Weight>
        <IdentifierType>RIC</IdentifierType>
      </Underlying>
      <OptionData>
        <LongShort>Long</LongShort>
        <OptionType>Call</OptionType>
        <Style>European</Style>
        <Settlement>Cash</Settlement>
        <ExerciseDates>
          <ExerciseDate>2021-01-29</ExerciseDate>
        </ExerciseDates>
      </OptionData>
      <Strike>3300</Strike>
    </Underlying>
    <!-- option #2 -->
    <Underlying>
      <Underlying>
        <Type>Equity</Type>
        <Name>.SPX</Name>
        <Weight>0.5</Weight>
        <IdentifierType>RIC</IdentifierType>
      </Underlying>
      <OptionData>
        <LongShort>Long</LongShort>
        <OptionType>Call</OptionType>
        <Style>European</Style>
        <Settlement>Cash</Settlement>
        <ExerciseDates>
          <ExerciseDate>2021-01-29</ExerciseDate>
        </ExerciseDates>
      </OptionData>
      <Strike>3400</Strike>
    </Underlying>
    <!-- option #3 -->
    <!-- ... -->
  </EquityOptionPositionData>
</Trade>
```

</div>
