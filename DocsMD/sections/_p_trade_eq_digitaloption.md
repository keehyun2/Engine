### Equity Digital Option

The `EquityDigitalOptionData` node is the trade data container for the
*EquityDigitalOption* trade type. The `EquityDigitalOptionData` node
includes one `OptionData` trade component sub-node plus elements
specific to the Equity Digital Option. The structure of an example
`EquityDigitalOptionData` node for an Equity Digital Option is shown in
Listing <a href="#lst:eqdigitaloption_data" data-reference-type="ref"
data-reference="lst:eqdigitaloption_data">[lst:eqdigitaloption_data]</a>.

<div class="listing">

``` xml
        <EquityDigitalOptionData>
            <OptionData>
                <LongShort>Long</LongShort>
                <OptionType>Call</OptionType>
                <Style>European</Style>
                <ExerciseDates>
                    <ExerciseDate>2027-02-26</ExerciseDate>
                </ExerciseDates>
                ...
            </OptionData>
            <Strike>3300</Strike>
            <PayoffCurrency>USD</PayoffCurrency>
            <PayoffAmount>1000</PayoffAmount>
            <Name>RIC:.SPX</Name>
            <Quantity>1000</Quantity>
        </EquityDigitalOptionData>
```

</div>

The meanings and allowable values of the elements in the
`EquityDigitalOptionData` node follow below.

- OptionData: This is a trade component sub-node outlined in section
  <a href="#ss:option_data" data-reference-type="ref"
  data-reference="ss:option_data">[ss:option_data]</a>. The relevant
  fields in the `OptionData` node for an EquityDigitalOption are:

  - `LongShort` The allowable values are *Long* or *Short*.

  - `OptionType` The allowable values are *Call* or *Put*. *Call* means
    that the option is in the money when the underlying equity price is
    above the strike, and *Put* means that the option is in the money
    when the underlying equity price is below the strike.

  - `Style` The allowable value is *European*. Note that the Equity
    Digital Option type allows for *European* option style only.

  - An `ExerciseDates` node where exactly one ExerciseDate date element
    must be given.

  - Premiums \[Optional\]: Option premium amounts paid by the option
    buyer to the option seller.

    Allowable values: See section
    <a href="#ss:premiums" data-reference-type="ref"
    data-reference="ss:premiums">[ss:premiums]</a>

- Strike: The option strike price per one unit of the underlying,
  expressed in the currency of the underlying equity .

  Allowable values: Any positive real number.

- PayoffCurrency: The payoff currency of the Equity Digital Option is
  the currency of the payoff amount. Must be consistent with the
  currency of the underlying Equity spot price.

  Allowable values: See Table
  <a href="#tab:currency" data-reference-type="ref"
  data-reference="tab:currency">[tab:currency]</a> `Currency`.

- PayoffAmount: The fixed payoff amount per unit of underlying expressed
  in payoff currency. It is cash-or-nothing payoff that depends on the
  option being in or out of the money.

  Allowable values: Any positive real number.

- Underlying: This node may be used as an alternative to the `Name` node
  to specify the underlying equity. This in turn defines the equity
  curve used for pricing. The `Underlying` node is described in further
  detail in Section <a href="#ss:underlying" data-reference-type="ref"
  data-reference="ss:underlying">[ss:underlying]</a>.

- Quantity: The number of units of the underlying covered by the
  transaction.

  Allowable values: Any positive real number.
