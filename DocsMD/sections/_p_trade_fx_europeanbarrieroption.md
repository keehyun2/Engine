### FX European Barrier Option

European exercise, European barrier.

An FX European Barrier option gives the buyer the right, but not the
obligation, to exchange a set amount of one currency for another, at a
predetermined exchange rate, at one predetermined time in the future.
This right may be withdrawn depending upon an FX spot rate reaching a
predetermined barrier level at the predetermined time, the underlying is
monitored only at expiry with a single barrier (European Barrier style).

The `FxEuropeanBarrierOptionData` node is the trade data container for
the *FxEuropeanBarrierOption* trade type. The barrier level of an FX
European Barrier Option is quoted as the amount in SoldCurrency per unit
BoughtCurrency. The `FxEuropeanBarrierOptionData` node includes one
`OptionData` trade component sub-node and one `BarrierData` trade
component sub-node plus elements specific to the FX Barrier Option.

The structure of an example `FxEuropeanBarrierOptionData` node for a FX
European Barrier Option is shown in Listing
<a href="#lst:fxeuropeanbarrieroption_data" data-reference-type="ref"
data-reference="lst:fxeuropeanbarrieroption_data">[lst:fxeuropeanbarrieroption_data]</a>.

<div class="listing">

``` xml
        <FxEuropeanBarrierOptionData>
            <OptionData>
                <LongShort>Long</LongShort>
                <!-- Bought and Sold currencies/amounts are switched for Put -->
                <OptionType>Call</OptionType>
                <Style>European</Style>
                <Settlement>Cash</Settlement>                
                <ExerciseDates>
                 <ExerciseDate>2021-12-14</ExerciseDate>
                </ExerciseDates>
                ...
            </OptionData>
            <BarrierData>
             <Type>UpAndIn</Type>
             <Levels>
                <Level>1.2</Level>
             </Levels>
             <Rebate>100000</Rebate>            
            </BarrierData>
            <BoughtCurrency>EUR</BoughtCurrency>
            <BoughtAmount>1000000</BoughtAmount>
            <SoldCurrency>USD</SoldCurrency>
            <SoldAmount>1100000</SoldAmount>
        </FxEuropeanBarrierOptionData>
```

</div>

The meanings and allowable values of the elements in the
`FxEuropeanBarrierOptionData` node follow below.

- OptionData: This is a trade component sub-node outlined in section
  <a href="#ss:option_data" data-reference-type="ref"
  data-reference="ss:option_data">[ss:option_data]</a>. The relevant
  fields in the `OptionData` node for an FxEuropeanBarrierOption are:

  - `LongShort` The allowable values are *Long* or *Short*.

  - `OptionType` The allowable values are *Call* or *Put*.  
    *Call* means that the holder of the option, upon expiry - assuming
    knock-in or no knock-out - has the right to receive the BoughtAmount
    and pay the SoldAmount.  
    *Put* means that the Bought and Sold currencies/amounts are switched
    compared to the trade data node. For example, holder of
    BoughtCurrency EUR SoldCurrency JPY FX European Barrier Call Option
    has the right to buy EUR using JPY, while holder of the Put
    counterpart has the right to buy JPY using EUR, or equivalently sell
    EUR for JPY. An alternative to define the latter option is to copy
    the Call option with following changes:  
    a) swapping BoughtCurrency with SoldCurrency, b) swapping
    BoughtAmount with SoldAmount and c) inverting the barrier level (for
    example changing 110 to 0.0090909). Here barrier level is quoted as
    amount of EUR per unit JPY, which is not commonly seen on market and
    inconsistent with the format in Call options. For these reasons,
    using Put/Call flag instead is recommended.

  - `Style` The FX European Barrier Option type allows for *European*
    option exercise style only.

  - `Settlement` The allowable values are *Cash* or *Physical*.

  - An `ExerciseDates` node where exactly one ExerciseDate date element
    must be given.

  - A `PaymentData` \[Optional\] node can be added which defines the
    settlement date of the option payoff.

  - `Premiums` \[Optional\]: Option premium amounts paid by the option
    buyer to the option seller. See section
    <a href="#ss:premiums" data-reference-type="ref"
    data-reference="ss:premiums">[ss:premiums]</a>

- BarrierData: This is a trade component sub-node outlined in section
  <a href="#ss:barrier_data" data-reference-type="ref"
  data-reference="ss:barrier_data">[ss:barrier_data]</a>. Level
  specified in BarrierData should be quoted as the amount in
  SoldCurrency per unit BoughtCurrency, with both currencies as defined
  in FxEuropeanBarrierOptionData node. Changing the option from Call to
  Put or vice versa does not require switching the barrier level, i.e.
  the level stays quoted as SoldCurrency per unit BoughtCurrency,
  regardless of Put/Call.

- BoughtCurrency: The bought currency of the FX barrier option. See
  OptionData above for more details.

  Allowable values: See Table
  <a href="#tab:currency" data-reference-type="ref"
  data-reference="tab:currency">[tab:currency]</a> `Currency`.

- BoughtAmount: The amount in the BoughtCurrency.

  Allowable values: Any positive real number.

- SoldCurrency: The sold currency of the FX barrier option. See
  OptionData above for more details.

  Allowable values: See Table
  <a href="#tab:currency" data-reference-type="ref"
  data-reference="tab:currency">[tab:currency]</a> `Currency`.

- SoldAmount: The amount in the SoldCurrency.

  Allowable values: Any positive real number.

Note that FX European Barrier Options also cover Precious Metals, i.e.
with currencies XAU, XAG, XPT, XPD, and Cryptocurrencies, see supported
Cryptocurrencies in Table
<a href="#tab:currency" data-reference-type="ref"
data-reference="tab:currency">[tab:currency]</a>.
