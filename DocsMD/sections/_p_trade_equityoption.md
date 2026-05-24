### Equity Option

Quanto payoff means that the payoff `Currency` is different than
currency the underlying equity is quoted in.  
Composite or “compo” equity options have a `StrikeCurrency` that is
different than currency the underlying equity is quoted in. (This is
unrelated to the *CompositeTrade* trade type.)

The `EquityOptionData` node is the trade data container for the
*EquityOption* trade type. Equity options with exercise styles
*European* and *American* are supported.

The `EquityOptionData` node includes one and only one `OptionData` trade
component sub-node plus elements specific to the equity option. The
structure of an example `EquityOptionData` node for an equity option is
shown in Listing <a href="#lst:eqoption_data" data-reference-type="ref"
data-reference="lst:eqoption_data">[lst:eqoption_data]</a>.

<div class="listing">

``` xml
<EquityOptionData>
    <OptionData>
         <LongShort>Long</LongShort>
         <OptionType>Call</OptionType>
         <Style>American</Style>
         <Settlement>Cash</Settlement>
         <PayOffAtExpiry>true</PayOffAtExpiry>
         <ExerciseDates>
             <ExerciseDate>2022-03-01</ExerciseDate>
         </ExerciseDates>
         ...
    </OptionData>
    <Name>RIC:.SPX</Name>
    <Currency>USD</Currency>
    <Strike>2147.56</Strike>
    <StrikeCurrency>USD</StrikeCurrency>
    <Quantity>17000</Quantity>
</EquityOptionData>
```

</div>

The meanings and allowable values of the elements in the
`EquityOptionData` node follow below.

- OptionData: This is a trade component sub-node outlined in section
  <a href="#ss:option_data" data-reference-type="ref"
  data-reference="ss:option_data">[ss:option_data]</a> Option Data. The
  relevant fields in the `OptionData` node for an EquityOption are:

  - `LongShort`: The allowable values are *Long* or *Short*.

  - `OptionType`: The allowable values are *Call* or *Put*. *Call* means
    that the option holder has the right to buy the given quantity of
    the underlying equity at the strike price. *Put* means that the
    option holder has the right to sell the given quantity of the
    underlying equity at the strike price.

  - `Style`: The allowable values are *European* and *American*.

  - `Settlement`: The allowable values are *Cash* or *Physical*. If
    `Currency` and underlying equity currency are different, i.e. Quanto
    payoff, this must be set to *Cash*.

  - `PayOffAtExpiry` \[Optional\]: The allowable values are *true* for
    payoff at expiry, or *false* for payoff at exercise. This field is
    relevant for *American* style EquityOptions, and defaults to *true*
    if left blank or omitted.

  - An `ExerciseDates` node where exactly one ExerciseDate date element
    must be given.

  - `PaymentData` \[Optional\]: Node used to set the payment date if it
    differs from the exercise date. Note that for quanto and compo
    EquityOptions the payment date cannot differ from the exercise date.

  - `Premiums` \[Optional\]: Node for Option premium amounts paid by the
    option buyer to the option seller.

    Allowable values: See section
    <a href="#ss:premiums" data-reference-type="ref"
    data-reference="ss:premiums">[ss:premiums]</a>

- Name: The identifier of the underlying equity or equity index.

  Allowable values: See `Name` for equity trades in Table
  <a href="#tab:equity_name" data-reference-type="ref"
  data-reference="tab:equity_name">[tab:equity_name]</a>.

- Underlying: This node may be used as an alternative to the `Name` node
  to specify the underlying equity. This in turn defines the equity
  curve used for pricing. The `Underlying` node is described in further
  detail in Section <a href="#ss:underlying" data-reference-type="ref"
  data-reference="ss:underlying">[ss:underlying]</a>.  

- Currency: The payment currency of the equity option.

  Allowable values: See `Currency` and `Minor Currencies` in Table
  <a href="#tab:allow_stand_data" data-reference-type="ref"
  data-reference="tab:allow_stand_data">[tab:allow_stand_data]</a>. If
  this is different to the currency that the underlying equity is quoted
  in, then a Quanto payoff will be applied. Using the corresponding
  major currency for an equity quoted in the minor currency will not
  correspond to a Quanto payoff.

- Strike\[Mandatory except if StrikeData node is used\]: The option
  strike price.

  Allowable values: Any positive real number.

- StrikeCurrency \[Mandatory for Quanto/Compo, Optional otherwise\]: The
  currency that the `Strike` is quoted in. If the option is Quanto, then
  this field must not be left blank, and must equal the currency that
  the underlying equity is quoted in, up to the minor/major currency.
  For example, if the underlying equity is quoted in GBP,
  then`StrikeCurrency` must be either *GBP* or *GBp*. If the option is a
  Compo option, then this field must not be left blank, and it must
  equal the payment currency of the option and different to the
  underlying currency.

  Note:  
  Quanto: Payment currency and the currency the underlying equity is
  quoted in differ. StrikeCurrency is in the currency the equity is
  quoted in.  
  Compo (Composite): Payment currency and the currency the underlying
  equity is quoted in differ. StrikeCurrency is in the payment currency.

  Allowable values: See Fiat Currencies and Minor Currencies in Table
  <a href="#tab:currency" data-reference-type="ref"
  data-reference="tab:currency">[tab:currency]</a>. Must be the major or
  minor currency of the `Currency` field above, or in the Quanto case it
  must be the major or minor currency the underlying is quoted in. If
  left blank or omitted, and payment currency is the same as the equity
  currency, it defaults to the `Currency` field (payment currency)
  above.

- StrikeData\[Optional\]: Alternatively, instead of the `Strike` and the
  `StrikeCurrency` fields above a `StrikeData` node can be used as
  described in Section
  <a href="#ss:strikedata" data-reference-type="ref"
  data-reference="ss:strikedata">[ss:strikedata]</a>. Note that for
  EquityOptions only `StrikePrice` is supported within the `StrikeData`
  node, and not `StrikeYield`.

- Quantity: The number of units of the underlying covered by the
  transaction.

  Allowable values: Any positive real number.
