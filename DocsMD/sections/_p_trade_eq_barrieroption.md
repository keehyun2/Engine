### Equity Barrier Option

European exercise, American barrier.

An Equity Barrier Option is a path-dependent option whose existence
depends upon an Equity underlying spot price reaching a pre-set barrier
level. Exercise is European.

This product has a continuously monitored single barrier (American
Barrier style) with a Vanilla European Equity Option Underlying.

The `EquityBarrierOptionData` node is the trade data container for the
*EquityBarrierOption* trade type. The barrier level of an Equity Barrier
Option should be quoted in the currency of the underlying Equity spot
price. The `EquityBarrierOptionData` node includes one `OptionData`
trade component sub-node and one `BarrierData` trade component sub-node
plus elements specific to the Equity Barrier Option.

The structure of an example `EquityBarrierOptionData` node for an Equity
Barrier Option is shown in Listing
<a href="#lst:eqbarrieroption_data" data-reference-type="ref"
data-reference="lst:eqbarrieroption_data">[lst:eqbarrieroption_data]</a>.

<div class="listing">

``` xml
        <EquityBarrierOptionData>
            <OptionData>
                ...
            </OptionData>
            <BarrierData>
                ...
            </BarrierData>
            <StartDate>2025-01-25</StartDate>
            <Calendar>TARGET</Calendar>
            <EQIndex>EQ-RIC:.SPX</EQIndex>            
            <Name>RIC:.SPX</Name>
            <StrikeData>
            <StrikePrice>
             <Value>3200.00</Value>
             <Currency>USD</Currency>
            </StrikePrice>
            </StrikeData>
            <Quantity>1000</Quantity>
            <Currency>USD</Currency>
        </EquityBarrierOptionData>
```

</div>

The meanings and allowable values of the elements in the
`EquityBarrierOptionData` node follow below.

- OptionData: This is a trade component sub-node outlined in section
  <a href="#ss:option_data" data-reference-type="ref"
  data-reference="ss:option_data">[ss:option_data]</a>. Note that the
  Equity Barrier Option type allows for *European* option style only.

- BarrierData: This is a trade component sub-node outlined in section
  <a href="#ss:barrier_data" data-reference-type="ref"
  data-reference="ss:barrier_data">[ss:barrier_data]</a>. Level
  specified in BarrierData should be quoted in the same currency with
  the underlying Equity spot price. Changing the option from Call to Put
  or vice versa does not require switching the barrier level.

- StartDate\[Optional\]: The start date for checking if a barrier has
  been breached prior to today’s date. If omitted or left blank no check
  is made and it is assumed no barrier has been breached in the past.
  Has no impact if set to today’s date or a date in the future.

  Allowable values: See `Date` in Table
  <a href="#tab:allow_stand_data" data-reference-type="ref"
  data-reference="tab:allow_stand_data">[tab:allow_stand_data]</a>.

- Calendar\[Optional\]: The calendar associated with the Equity Index.
  Required if StartDate is set to a date prior to today’s date,
  otherwise optional.

  Allowable values: See Table
  <a href="#tab:calendar" data-reference-type="ref"
  data-reference="tab:calendar">[tab:calendar]</a> Calendar.

- EQIndex\[Optional\]: A reference to an Equity Index source to check if
  the barrier has been breached. Required if StartDate is set to a date
  prior to today’s date, otherwise optional and can be omitted but not
  left blank.

  Allowable values: The format of the Equity Index is“EQ-RIC:Code”.

- Underlying: This node may be used as an alternative to the `Name` node
  to specify the underlying equity. This in turn defines the equity
  curve used for pricing. The `Underlying` node is described in further
  detail in Section <a href="#ss:underlying" data-reference-type="ref"
  data-reference="ss:underlying">[ss:underlying]</a>.

- StrikeData: A node containing the strike in `Value` and the currency
  in which both the underlying and the strike are quoted in `Currency`.
  I.e. compo options with strike currency not equal to underlying equity
  currency are not supported for this trade type.

  Allowable values: Only supports `StrikePrice` as described in Section
  <a href="#ss:strikedata" data-reference-type="ref"
  data-reference="ss:strikedata">[ss:strikedata]</a>.

- Quantity: The number of units of the underlying covered by the
  transaction.

  Allowable values: Any positive real number.

- Currency: The payment currency of the trade.

  Allowable values: See `Currency` and `Minor Currencies` in Table
  <a href="#tab:allow_stand_data" data-reference-type="ref"
  data-reference="tab:allow_stand_data">[tab:allow_stand_data]</a>. This
  should be equal to the underlying equity except for the major / minor
  distinction. I.e. quanto payoffs that are usually identified by
  setting the payment currency to a different currency than the
  underlying equity currency, are not allowed for this trade type.
