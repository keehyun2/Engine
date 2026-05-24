### Equity Futures Option

The `EquityFutureOptionData` node is the trade data container for the
*EquityFutureOption* trade type. Equity options with exercise styles
*European* and *American* are supported. The `EquityFutureOptionData`
node includes one and only one `OptionData` trade component sub-node
plus elements specific to the equity future option. The structure of an
example `EquityFutureOptionData` node for an equity option is shown in
Listing <a href="#lst:eqfutureoption_data" data-reference-type="ref"
data-reference="lst:eqfutureoption_data">[lst:eqfutureoption_data]</a>.

<div class="listing">

``` xml
<EquityFutureOptionData>
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
    <StrikeData>
        <StrikePrice>
            <Value>2147.56</Value>
            <Currency>USD</Currency>
        </StrikePrice>
    </StrikeData>
    <Quantity>17000</Quantity>
    <FutureExpiryDate>2021-01-29</FutureExpiryDate>
</EquityFutureOptionData>
```

</div>

The meanings and allowable values of the elements in the
`EquityFutureOptionData` node follow below.

- OptionData: This is a trade component sub-node outlined in section
  <a href="#ss:option_data" data-reference-type="ref"
  data-reference="ss:option_data">[ss:option_data]</a> Option Data. The
  relevant fields in the `OptionData` node for an EquityOption are:

  - `LongShort` The allowable values are *Long* or *Short*.

  - `OptionType` The allowable values are *Call* or *Put*. *Call* means
    that the option holder has the right to buy the given quantity of
    the underlying equity at the strike price. *Put* means that the
    option holder has the right to sell the given quantity of the
    underlying equity at the strike price.

  - `Style` The allowable value is *European*.

  - `Settlement` The allowable values are *Cash* or *Physical*.

  - `PayOffAtExpiry` \[Optional\] The allowable values are *true* for
    payoff at expiry, or *false* for payoff at exercise. This field is
    relevant for *American* style EquityOptions, and defaults to *true*
    if left blank or omitted.

  - An `ExerciseDates` node where exactly one ExerciseDate date element
    must be given.

  - Premiums \[Optional\]: Option premium amounts paid by the option
    buyer to the option seller.

    Allowable values: See section
    <a href="#ss:premiums" data-reference-type="ref"
    data-reference="ss:premiums">[ss:premiums]</a>

- Name: The identifier of the underlying equity or equity index.  
  Allowable values: See `Name` for equity trades in Table
  <a href="#tab:equity_credit_data" data-reference-type="ref"
  data-reference="tab:equity_credit_data">[tab:equity_credit_data]</a>.  

- Underlying: This node may be used as an alternative to the `Name` node
  to specify the underlying equity. This in turn defines the equity
  curve used for pricing. The `Underlying` node is described in further
  detail in Section <a href="#ss:underlying" data-reference-type="ref"
  data-reference="ss:underlying">[ss:underlying]</a>.  

- Currency: The currency of the equity option.  
  Allowable values: See Table
  <a href="#tab:currency" data-reference-type="ref"
  data-reference="tab:currency">[tab:currency]</a>.

- StrikeData: The option strike price.  
  Allowable values: Only supports `StrikePrice` as described in Section
  <a href="#ss:strikedata" data-reference-type="ref"
  data-reference="ss:strikedata">[ss:strikedata]</a>.

- Quantity: The number of units of the underlying covered by the
  transaction.  
  Allowable values: Any positive real number.

- FutureExpiryDate \[Optional\]: If `IsFuturePrice` is `true` and the
  underlying is a future contract settlement price, this node allows the
  user to specify the expiry date of the underlying future contract.

  Allowable values: This should be a valid date as outlined in Table
  <a href="#tab:allow_stand_data" data-reference-type="ref"
  data-reference="tab:allow_stand_data">[tab:allow_stand_data]</a>. If
  not provided, it is assumed that the future contract’s expiry date is
  equal to the option expiry date provided in the `OptionData` node.
