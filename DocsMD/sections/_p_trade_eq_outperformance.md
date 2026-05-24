### Equity Outperformance Option

An Equity Outperformance option has a payoff that depends on the
‘outperformance’ of two equity indices (i.e. the difference between
their returns) against a strike return. The buyer has the right but not
the obligation to receive the outperformance in exchange for the strike
rate at a predetermined time in the future.

The trade may optionally have a knockIn or knockOut price (or both).
Only if the price of Underlying2 is above the knockIn value or below the
knockOut value is the payoff paid.

The `EquityOutperformanceOptionData` node is the trade data container
for the *EquityOutperformanceOption* trade type. The
`EquityOutperformanceOptionData` node includes one `OptionData` trade
component sub-node plus elements specific to the Equity Outperformance
Option.

The structure of an example `EquityOutperformanceOptionData` node for an
Equity Outperformace Option is shown in Listing
<a href="#lst:eqoutperformaceoption_data" data-reference-type="ref"
data-reference="lst:eqoutperformaceoption_data">[lst:eqoutperformaceoption_data]</a>.

<div class="listing">

``` xml
        <EquityOutperformanceOptionData>
            <OptionData>
              <LongShort>Long</LongShort>
              <OptionType>Call</OptionType>
              <Style>European</Style>
              <Settlement>Cash</Settlement>
              <ExerciseDates>
                <ExerciseDate>2022-09-21</ExerciseDate>
              </ExerciseDates>
              ...
            </OptionData>
          <Currency>USD</Currency>
          <Notional>500000</Notional>
          <Underlying1>
            <Type>Equity</Type>
            <Name>RIC:.SPX</Name>
          </Underlying1>
          <Underlying2>
            <Type>Equity</Type>
            <Name>RIC:.NDX</Name>
          </Underlying2>
          <InitialPrice1>2140</InitialPrice1>
          <InitialPrice2>13000</InitialPrice2>
          <StrikeReturn>0.01</StrikeReturn>
          <KnockInPrice>12500</KnockInPrice>
          <KnockOutPrice>14000</KnockOutPrice>
        </EquityOutperformanceOptionData>
```

</div>

The Payoff is: $$N\cdot \max(0,R_1-R_2 - K)$$ where:

- $N$ is the notional amount

- $R_1$ is the return of `Underlying1`

- $R_2$ is the return of `Underlying2`

- $K$ is the `StrikeReturn`.

The meanings and allowable values of the elements in the
`EquityOutperformaceOptionData` node follow below.

- OptionData: This is a trade component sub-node outlined in section
  <a href="#ss:option_data" data-reference-type="ref"
  data-reference="ss:option_data">[ss:option_data]</a>. The relevant
  fields in the `OptionData` node for an EquityOutperformanceOption are:

  - `LongShort` The allowable values are *Long* or *Short*.

  - `OptionType` The allowable values are *Call* or *Put*. *Call* means
    that the holder has the right but not obligation to receive the
    Outperformance and pay the StrikeReturn. *Put* means that the holder
    has the right but not obligation to pay the Outperformance and
    receive the StrikeReturn.

  - `Style` The allowable value is *European*. Note that the Equity
    Outperformance Option type allows for *European* option style only.

  - `Settlement` The allowable values are *Cash* or *Physical*.

  - An `ExerciseDates` node where exactly one ExerciseDate date element
    must be given.

  - Premiums \[Optional\]: Option premium amounts paid by the option
    buyer to the option seller.

    Allowable values: See section
    <a href="#ss:premiums" data-reference-type="ref"
    data-reference="ss:premiums">[ss:premiums]</a>

- Currency: The currency of the equity outperformance option.

  Allowable values: See Table
  <a href="#tab:currency" data-reference-type="ref"
  data-reference="tab:currency">[tab:currency]</a> `Currency`.

- Underlying1: Specifies the first underlying equity. This in turn
  defines the equity curve used for pricing. The `Underlying` node is
  described in further detail in Section
  <a href="#ss:underlying" data-reference-type="ref"
  data-reference="ss:underlying">[ss:underlying]</a>. Note that the node
  name is `Underlying1`.

- Underlying2: Specifies the second underlying equity. This in turn
  defines the equity curve used for pricing. The `Underlying` node is
  described in further detail in Section
  <a href="#ss:underlying" data-reference-type="ref"
  data-reference="ss:underlying">[ss:underlying]</a>. Note that the node
  name is `Underlying2`.

  Also note that the equities in Underlying1 and Underlying2 must be
  quoted in the same currency.

- InitialPrice1: Specifies the initial price for first underlying
  equity.

  Allowable values: Any positive real number.

- InitialPrice2: Specifies the initial price for second underlying
  equity.

  Allowable values: Any positive real number.

- StrikeReturn: The option strike return.

  Allowable values: Any positive real number.

- Notional: The notional amount for the trade.

  Allowable values: Any positive real number.

- KnockInPrice\[Optional\]: The payoff is only paid if on the settlement
  date the price of underlying2 is above this value.

  Allowable values: Any positive real number.

- KnockOutPrice\[Optional\]: The payoff is only paid if on the
  settlement date the price of underlying2 is below this value.

  Allowable values: Any positive real number.

- InitialPriceCurrency1 \[Optional\]: Only relevant if InitialPrice1 is
  given in a currency other than Underlying1’s currency.

  Allowable values: See Table
  <a href="#tab:currency" data-reference-type="ref"
  data-reference="tab:currency">[tab:currency]</a> `Currency`.

- InitialPriceCurrency2 \[Optional\]: Only relevant if InitialPrice1 is
  given in a currency other than Underlying2’s currency.

  Allowable values: See Table
  <a href="#tab:currency" data-reference-type="ref"
  data-reference="tab:currency">[tab:currency]</a> `Currency`.

- InitialPriceFXTerms1 \[Mandatory when InitialPriceCurrency1 is
  provided\]: The node must be given if and only if the underlying
  currency is different from the initialPrice currency. The node
  contains the following sub nodes:

  - FXIndex: The fx index to use for the conversion, this must contain
    the underlying asset currency and the funding leg currency (in the
    order defined in table
    <a href="#tab:fxindex_data" data-reference-type="ref"
    data-reference="tab:fxindex_data">[tab:fxindex_data]</a>, i.e. it
    does not matter which one is the asset currency and which is the
    funding currency)

    Allowable values: see
    <a href="#tab:fxindex_data" data-reference-type="ref"
    data-reference="tab:fxindex_data">[tab:fxindex_data]</a>

  - InitialPriceFXTerms2 \[Mandatory when InitialPriceCurrency2 is
    provided\]: The node must be given if and only if the underlying
    currency is different from the initialPrice currency. Contains the
    same subnodes as InitialPriceFXTerms1.

    Allowable values: Any valid calendar, see Table
    <a href="#tab:calendar" data-reference-type="ref"
    data-reference="tab:calendar">[tab:calendar]</a> Calendar. Defaults
    to the *NullCalendar* (no holidays) if left blank or omitted.
