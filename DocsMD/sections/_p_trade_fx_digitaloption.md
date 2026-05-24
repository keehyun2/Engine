### FX Digital Option

The `FxDigitalOptionData` node is the trade data container for the
*FxDigitalOption* trade type. The `FxDigitalOptionData` node includes
one `OptionData` trade component sub-node plus elements specific to the
FX Digital Option. The structure of an example `FxDigitalOptionData`
node for a FX Digital Option is shown in Listing
<a href="#lst:fxdigitaloption_data" data-reference-type="ref"
data-reference="lst:fxdigitaloption_data">[lst:fxdigitaloption_data]</a>.

<div class="listing">

``` xml
        <FxDigitalOptionData>
            <OptionData>
                <LongShort>Long</LongShort>
                <OptionType>Call</OptionType>
                <Style>European</Style>              
                <ExerciseDates>
                 <ExerciseDate>2021-12-14</ExerciseDate>
                </ExerciseDates> 
                ...
            </OptionData>
            <Strike>1.1</Strike>
            <PayoffCurrency>USD</PayoffCurrency>            
            <PayoffAmount>100000</PayoffAmount>            
            <ForeignCurrency>EUR</ForeignCurrency>
            <DomesticCurrency>USD</DomesticCurrency>
        </FxDigitalOptionData>
```

</div>

The meanings and allowable values of the elements in the
`FxDigitalOptionData` node follow below.

- OptionData: This is a trade component sub-node outlined in section
  <a href="#ss:option_data" data-reference-type="ref"
  data-reference="ss:option_data">[ss:option_data]</a>. The relevant
  fields in the `OptionData` node for an FxDigitalOption are:

  - `LongShort` The allowable values are *Long* or *Short*.

  - `OptionType` The allowable values are *Call* or *Put*. *Call* means
    that the digital payout will occur if the fx rate at the expiry date
    is above the given strike, and *Put* means that the digital payout
    will occur if the fx rate at the expiry date is below the given
    strike.

  - `Style` The FX Digital Option type allows for *European* option
    exercise style only.

  - An `ExerciseDates` node where exactly one ExerciseDate date element
    must be given.

  - `Premiums` \[Optional\]: Option premium amounts paid by the option
    buyer to the option seller.

    Allowable values: See section
    <a href="#ss:premiums" data-reference-type="ref"
    data-reference="ss:premiums">[ss:premiums]</a>

- Strike: The FX strike price, expressed as the amount in
  DomesticCurrency per one unit of ForeignCurrency.

  Allowable values: Any positive real number.

- PayoffCurrency\[Optional\]: The payoff currency of the FX digital
  option is the currency of the payoff amount. Must be either the
  Domestic or Foreign currency for this trade, If omitted this defaults
  to the domestic currency.

  Allowable values: See Table
  <a href="#tab:currency" data-reference-type="ref"
  data-reference="tab:currency">[tab:currency]</a> `Currency`.

- PayoffAmount: The fixed payoff amount expressed in payoff currency. It
  is cash-or-nothing payoff that depends on the option being in or out
  of the money.

  Allowable values: Any positive real number.

- ForeignCurrency: The foreign currency of the FX digital option is
  equivalent to the bought currency.

  Allowable values: See Table
  <a href="#tab:currency" data-reference-type="ref"
  data-reference="tab:currency">[tab:currency]</a> `Currency`.

- DomesticCurrency: The domestic currency of the FX digital option is
  equivalent to the sold currency.

  Allowable values: See Table
  <a href="#tab:currency" data-reference-type="ref"
  data-reference="tab:currency">[tab:currency]</a> `Currency`.

Note that FX Digital Options also cover Precious Metals, i.e. with
currencies XAU, XAG, XPT, XPD, and Cryptocurrencies, see supported
Cryptocurrencies in Table
<a href="#tab:currency" data-reference-type="ref"
data-reference="tab:currency">[tab:currency]</a>.
