### FX Option

The `FXOptionData` node is the trade data container for the *FxOption*
trade type. FX options with exercise styles *European* or *American* are
supported. The `FXOptionData` node includes one and only one
`OptionData` trade component sub-node plus elements specific to the FX
Option. The structure of an `FXOptionData` node for an FX Option is
shown in Listing <a href="#lst:fxoption_data" data-reference-type="ref"
data-reference="lst:fxoption_data">[lst:fxoption_data]</a>.

<div class="listing">

``` xml
<FxOptionData>
  <OptionData>
    <LongShort>Long</LongShort>
    <OptionType>Call</OptionType>
    <Style>European</Style>
    <Settlement>Cash</Settlement>
    <PayOffAtExpiry>false</PayOffAtExpiry>
    <ExerciseDates>
       <ExerciseDate>2026-03-01</ExerciseDate>
     </ExerciseDates>
     <Premiums>
       <Premium>
         <Amount>10900</Amount>
         <Currency>EUR</Currency>
         <PayDate>2020-03-01</PayDate>
       </Premium>
     </Premiums>
  </OptionData>
  <BoughtCurrency>EUR</BoughtCurrency>
  <BoughtAmount>1000000</BoughtAmount>
  <SoldCurrency>USD</SoldCurrency>
  <SoldAmount>1700000</SoldAmount>
</FxOptionData>
```

</div>

The meanings and allowable values of the elements in the `FXOptionData`
node follow below.

- OptionData: This is a trade component sub-node outlined in section
  <a href="#ss:option_data" data-reference-type="ref"
  data-reference="ss:option_data">[ss:option_data]</a>. The relevant
  fields in the `OptionData` node for an FxOption are:

  - `LongShort` The allowable values are *Long* or *Short*.

  - `OptionType` The allowable values are *Call* or *Put*. For option
    type *Put*, Bought and Sold currencies/amounts are switched compared
    to the trade data node. For example, a holder of BoughtCurrency EUR
    SoldCurrency USD FX Call Option has the right to buy EUR using USD,
    while holder of the Put counterpart has the right to buy USD using
    EUR, or equivalently sell EUR for USD.

  - `Style` The allowable values are *European* or *American*.

  - `Settlement` The allowable values are *Cash* or *Physical*.

  - `PayOffAtExpiry` \[Optional\] The allowable values are *true* for
    payoff at expiry, or *false* for payoff at exercise (relevant for
    *American* style FxOptions). Defaults to *true* if left blank or
    omitted.

  - `AutomaticExercise` \[Optional\] The allowable values are *true*
    indicating Automatic Exercise is applicable and *false* indicates
    that it is not. Used if the FXOption expiry date is on the current
    date or in the past, and the payment date is in the future - so that
    there still is an outstanding cashflow if the FXOption was in the
    money on the expiry date. In this case, if AutomaticExercise is
    applied, the FX fixing on the expiry date is used to automatically
    determine the payoff and thus whether the option was exercised or
    not. Defaults to *false* if left blank or omitted.

  - An `ExerciseDates` node where exactly one ExerciseDate date element
    must be given. For *American* style FxOptions the ExerciseDate
    represents the Expiry date, i.e. they can be exercised up until this
    date.  

  - A `PaymentData` \[Optional\] node can be added which defines the
    settlement date of the option payoff. See `PaymentData` in
    <a href="#ss:option_data" data-reference-type="ref"
    data-reference="ss:option_data">[ss:option_data]</a>

  - `Premiums` \[Optional\]: Option premium amounts paid by the option
    buyer to the option seller. See section
    <a href="#ss:premiums" data-reference-type="ref"
    data-reference="ss:premiums">[ss:premiums]</a>

  See <a href="#ss:option_data" data-reference-type="ref"
  data-reference="ss:option_data">[ss:option_data]</a> for further
  specifications of the `OptionData` node.

- BoughtCurrency: The bought currency of the FX option. See OptionData
  above for more details.

  Allowable values: See Table
  <a href="#tab:currency" data-reference-type="ref"
  data-reference="tab:currency">[tab:currency]</a>.

- BoughtAmount: The amount in the BoughtCurrency.

  Allowable values: Any positive real number.

- SoldCurrency: The sold currency of the FX option. See OptionData above
  for more details.

  Allowable values: See Table
  <a href="#tab:currency" data-reference-type="ref"
  data-reference="tab:currency">[tab:currency]</a>.

- SoldAmount \[Optional\]: The amount in the SoldCurrency. Note that if
  Delta is omitted, the SoldAmount field is mandatory.

  Allowable values: Any positive real number.

- Delta \[Optional\]: The FX option delta. When a delta value is given
  the FX Option strike is derived from the delta, and the SoldAmount is
  ignored.

  Allowable values: Any non null real number. A SoldAmount or a Delta
  field is required, as the strike is derived from one or the other.
  Note: The delta to strike conversion is based on the valuation date.
  Therefore the strike will change day to day based on the market data
  variation. It is not possible to enter a seasoned trade with a Delta
  such that the trade strike (SoldAmount) is derived from the Delta on
  the trade date and then kept constant throughout the life of the
  trade.

- FXIndex \[Optional\]: If the option *European*, has cash settlement
  and is subject to *Automatic Exercise*, as indicated by the
  `AutomaticExercise` node under `OptionData`, this node must be
  populated with a valid FX index. The FX index is used to retrieve an
  FX rate on the expiry date that is in turn used to determine the
  payoff on the cash settlement date. The payoff is in the
  `SoldCurrency` i.e. the domestic currency.

  Allowable values: A valid FX index from the Table
  <a href="#tab:fxindex_data" data-reference-type="ref"
  data-reference="tab:fxindex_data">[tab:fxindex_data]</a>.

Note that FX Options also cover Precious Metals Options, i.e. with
currencies XAU, XAG, XPT, XPD, and Cryptocurrency options, see supported
Cryptocurrencies in Table
<a href="#tab:currency" data-reference-type="ref"
data-reference="tab:currency">[tab:currency]</a>.
