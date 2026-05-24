### Equity European Barrier Option

European exercise, European barrier.

An Equity European Barrier Option gives the buyer the right, but not the
obligation, to buy a set number of shares of a single name equity or an
equity index, at a predetermined strike price, at one predetermined time
in the future. This right may be withdrawn depending upon an Eqity spot
price or index reaching a predetermined barrier level at the
predetermined time, the underlying is monitored only at expiry with a
single barrier (European Barrier style).

The `EquityEuropeanBarrierOptionData` node is the trade data container
for the *EquityEuropeanBarrierOption* trade type. The barrier level of
an Equity European Barrier Option is quoted in the currency of the
underlying Equity spot price. The `EquityEuropeanBarrierOptionData` node
includes one `OptionData` trade component sub-node and one `BarrierData`
trade component sub-node plus elements specific to the Equity European
Barrier Option.

The structure of an example `EquityEuropeanBarrierOptionData` node for
an Equity European Barrier Option is shown in Listing
<a href="#lst:eqeuropeanbarrieroption_data" data-reference-type="ref"
data-reference="lst:eqeuropeanbarrieroption_data">[lst:eqeuropeanbarrieroption_data]</a>.

<div class="listing">

``` xml
        <EquityEuropeanBarrierOptionData>
            <OptionData>
                ...
            </OptionData>
            <BarrierData>
                ...
            </BarrierData>
            <Name>RIC:.SPX</Name>
            <StrikeData>
                <StrikePrice>
                    <Value>3200.00</Value>
                    <Currency>USD</Currency>
                </StrikePrice>
            </StrikeData>
            <Quantity>1000</Quantity>>
        </EquityEuropeanBarrierOptionData>
```

</div>

The meanings and allowable values of the elements in the
`EquityEuropeanBarrierOptionData` node follow below.

- OptionData: This is a trade component sub-node outlined in section
  <a href="#ss:option_data" data-reference-type="ref"
  data-reference="ss:option_data">[ss:option_data]</a>. Note that the
  Equity European Barrier Option type allows for *European* option style
  only.

- BarrierData: This is a trade component sub-node outlined in section
  <a href="#ss:barrier_data" data-reference-type="ref"
  data-reference="ss:barrier_data">[ss:barrier_data]</a>. Level
  specified in BarrierData should be quoted in the same currency with
  the underlying Equity spot price. Changing the option from Call to Put
  or vice versa does not require switching the barrier level.

- Underlying: This node may be used as an alternative to the `Name` node
  to specify the underlying equity. This in turn defines the equity
  curve used for pricing. The `Underlying` node is described in further
  detail in Section <a href="#ss:underlying" data-reference-type="ref"
  data-reference="ss:underlying">[ss:underlying]</a>.

- StrikeData: A node containing the strike in `Value` and the currency
  in which both the underlying and the strike are quoted in `Currency`.
  Allowable values: Only supports `StrikePrice` as described in Section
  <a href="#ss:strikedata" data-reference-type="ref"
  data-reference="ss:strikedata">[ss:strikedata]</a>.

- Quantity: The number of units of the underlying covered by the
  transaction.

  Allowable values: Any positive real number.
