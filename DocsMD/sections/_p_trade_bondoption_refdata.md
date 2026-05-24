### Bond Option (using bond reference data)

The structure of a trade node representing a *BondOption* is shown in
listing <a href="#lst:bondoption_data_refdata" data-reference-type="ref"
data-reference="lst:bondoption_data_refdata">[lst:bondoption_data_refdata]</a>:

- The `BondOptionData` node is the trade data container for the option
  part of a bond option trade type. Vanilla bond options are supported,
  the exercise style must be *European*. The `BondOptionData` node
  includes one and only one `OptionData` trade component sub-node plus
  elements specific to the bond option.

- The latter also includes the underlying Bond description in the
  `BondData` node, see below for details

Note that only par redemption vanilla bonds are supported.

<div class="listing">

``` xml
  <Trade id="...">
    <TradeType>BondOption</TradeType>
    <Envelope>
        ...
    </Envelope>
    <BondOptionData>
      <OptionData>
       <LongShort>Long</LongShort>
       <OptionType>Call</OptionType>
       <Style>European</Style>
       <ExerciseDates>
        <ExerciseDate>20210203</ExerciseDate>
       </ExerciseDates>
          ...
      </OptionData>
      <StrikeData>
        <StrikePrice>
      <Value>1.23</Value>
    </StrikePrice>
      </StrikeData>
      <PriceType>Dirty</PriceType>
      <KnocksOut>false</KnocksOut>
      <BondData>
         <SecurityId>ISIN:XS1234567890</SecurityId>
         <BondNotional>100000</BondNotional>
      <BondData>
    </BondOptionData>
  </Trade>
```

</div>

The meanings and allowable values of the elements in the
`BondOptionData` node follow below.

- OptionData: This is a trade component sub-node outlined in section
  <a href="#ss:option_data" data-reference-type="ref"
  data-reference="ss:option_data">[ss:option_data]</a> Option Data.

  The relevant fields in the `OptionData` node for a BondOption are:

  - `LongShort` The allowable values are *Long* or *Short*.

  - `OptionType` The allowable values are *Call* or *Put*. For option
    type *Call*, the Bond Option holder has the right to buy the
    underlying Bond at the strike price. For option type *Put*, the Bond
    Option holder has the right to sell the underlying Bond at the
    strike price.

  - `Style` The allowable value is *European* only.

  - `Settlement` \[Optional\] The allowable values are *Cash* or
    *Physical*, but this field is currently ignored.

  - An `ExerciseDates` node where exactly one ExerciseDate date element
    must be given.  

  - Premiums \[Optional\]: Option premium amounts paid by the option
    buyer to the option seller.

    Allowable values: See section
    <a href="#ss:premiums" data-reference-type="ref"
    data-reference="ss:premiums">[ss:premiums]</a>

- `StrikeData`: A `StrikeData` node is used as described in Section
  <a href="#ss:strikedata" data-reference-type="ref"
  data-reference="ss:strikedata">[ss:strikedata]</a> to represent the
  Bond Option strike price or strike yield. If StrikePrice is used, the
  strike price (`Value` field) is expressed per unit notional, i.e. a
  strike of 101% of the bond notional is expressed as 1.01. If
  StrikeYield is used, the `Yield` is quoted in decimal form, e.g. 5%
  should be entered as 0.05.

- PriceType \[Mandatory for StrikePrice, no impact for StrikeYield\]:  
  The payoff for a bond option is

  max(B - X, 0)

  where B is always the dirty NPV of the underlying bond on the exercise
  settlement date.  
  If `PriceType` is *Clean*, X is (Strike + Underlying Bond Accruals) x
  BondNotional If `PriceType` is *Dirty*, X is Strike x BondNotional

  Allowable values: *Dirty* or *Clean*. If the `StrikeData` node uses
  StrikeYield, `PriceType` can be omitted as it is not relevant in the
  yield case.

- KnocksOut: If *true* the option knocks out if the underlying defaults
  before the option expiry, if *false* the option is written on the
  recovery value in case of a default of the bond before the option
  expiry.

  Allowable values: Boolean node, allowing *Y, N, 1, 0, true, false*
  etc. The full set of allowable values is given in Table
  <a href="#tab:boolean_allowable" data-reference-type="ref"
  data-reference="tab:boolean_allowable">[tab:boolean_allowable]</a>.

The meanings and allowable values of the elements in the `BondData` are:

- SecurityId: The underlying security identifier

  Allowable values: Typically the ISIN of the underlying bond, with the
  ISIN: prefix.

- BondNotional: The notional of the underlying bond on which the option
  is written expressed in the currency of the bond.

  Allowable values: Any positive real number.

- CreditRisk \[Optional\] Boolean flag indicating whether to show Credit
  Risk on the Bond product.

  Allowable Values: *true* or *false* Defaults to *true* if left blank
  or omitted.
