### Equity Forward

The `EquityForwardData` node is the trade data container for the
*EquityForward* trade type. Vanilla equity forwards are supported. The
structure of an example `EquityForwardData` node for an equity forward
is shown in Listing <a href="#lst:eqfwd_data" data-reference-type="ref"
data-reference="lst:eqfwd_data">[lst:eqfwd_data]</a>.

<div class="listing">

``` xml
<EquityForwardData>
  <LongShort>Long</LongShort>
  <Maturity>2018-06-30</Maturity>
  <Name>RIC:.SPX</Name>
  <Currency>USD</Currency>
  <Strike>2147.56</Strike>
  <StrikeCurrency>USD</StrikeCurrency>
  <Quantity>17000</Quantity>
</EquityForwardData>
```

</div>

The meanings and allowable values of the elements in the
`EquityForwardData` node follow below.

- LongShort: Defines whether the underlying equity will be bought (long)
  or sold (short).  
  Allowable values: *Long*, *Short*.

- Maturity: The maturity date of the forward contract, i.e. the date
  when the underlying equity will be bought/sold.  
  Allowable values: Any date string, see `Date` in Table
  <a href="#tab:allow_stand_data" data-reference-type="ref"
  data-reference="tab:allow_stand_data">[tab:allow_stand_data]</a>.

- Name: The identifier of the underlying equity or equity index.
  Allowable values: See `Name` for equity trades in Table
  <a href="#tab:equity_credit_data" data-reference-type="ref"
  data-reference="tab:equity_credit_data">[tab:equity_credit_data]</a>.  

- Underlying: This node may be used as an alternative to the `Name` node
  to specify the underlying equity. This in turn defines the equity
  curve used for pricing. The `Underlying` node is described in further
  detail in Section <a href="#ss:underlying" data-reference-type="ref"
  data-reference="ss:underlying">[ss:underlying]</a>.  

- Currency: The payment currency of the equity forward. If the equity
  underlying is quoted in a different currency, a `FXIndex` in the
  `SettlementData` sub-node is required to convert the payoff into the
  payment currency.  
  Allowable values: See Fiat Currencies and Minor Currencies in Table
  <a href="#tab:currency" data-reference-type="ref"
  data-reference="tab:currency">[tab:currency]</a>.

- Strike: The agreed buy/sell price of the equity forward.  
  Allowable values: Any positive real number.

- StrikeCurrency: \[Optional\] The currency of the strike value. The
  strike value has to be in underlying quotation currency. If the strike
  currency is quoted in the minor currency, the strike value will be
  converted to the major currency. Defaults to the payment currency if
  omitted or blank.  
  Allowable values: See Fiat Currencies and Minor Currencies in Table
  <a href="#tab:currency" data-reference-type="ref"
  data-reference="tab:currency">[tab:currency]</a>.

- Quantity: The number of units of the underlying equity to be
  bought/sold.  
  Allowable values: Any positive real number.

- SettlementData \[Optional\]: This node is used to specify the
  settlement of the cash flows.

The strike value must be quoted in the same currency as the underlying.
The underlying prices are always converted to the major underlying
currency during curve building. If the strike is quoted in the minor
underlying currency, it will be also converted to the major underlying
currency. If the strike currency is blank or omitted, it defaults to
payment currency, in this case the payment currency needs to be the same
as the underlying currency and same logic applies for minor to major
currency conversion.

A `SettlementData` node is shown in Listing
<a href="#lst:eq_settlement_data_node" data-reference-type="ref"
data-reference="lst:eq_settlement_data_node">[lst:eq_settlement_data_node]</a>,
and the meanings and allowable values of its elements follow below.

- FXIndex: The FX reference index for determining the FX fixing used to
  convert the amount from the underlying equity quotation currency to
  the payment currency. This field is required if the underlying
  currency doesn’t match the deal currency. Otherwise, it is ignored.  
  Allowable values: The format of the `FXIndex` is
  “FX-FixingSource-CCY1-CCY2” as described in Table
  <a href="#tab:fxindex_data" data-reference-type="ref"
  data-reference="tab:fxindex_data">[tab:fxindex_data]</a>.

- Date \[Optional\]: If specified, this will be the payment date.  
  Allowable values: See `Date` in Table
  <a href="#tab:allow_stand_data" data-reference-type="ref"
  data-reference="tab:allow_stand_data">[tab:allow_stand_data]</a>. If
  left blank or omitted, the payment date will be derived from the
  maturity date applying the `PaymentLag`, `PaymentCalendar` and the
  `PaymentConvention` as defined in the `Rules` sub-node.

- Rules \[Optional\]: If `Date` is left blank or omitted, this node will
  be used to derive the payment date from the maturity date. The `Rules`
  sub-node is shown in Listing
  <a href="#lst:eq_settlement_data_node" data-reference-type="ref"
  data-reference="lst:eq_settlement_data_node">[lst:eq_settlement_data_node]</a>,
  and the meanings and allowable values of its elements follow below.

  - PaymentLag \[Optional\]: The lag between the maturity date and the
    payment date.  
    Allowable values: Any valid period, i.e. a non-negative whole
    number, optionally followed by *D* (days), *W* (weeks), *M*
    (months), *Y* (years). Defaults to 0. If a whole number is given and
    no letter, it is assumed that it is a number of *D* (days).

  - PaymentCalendar \[Optional\]: The calendar to be used when applying
    the payment lag.  
    Allowable values: See Table
    <a href="#tab:calendar" data-reference-type="ref"
    data-reference="tab:calendar">[tab:calendar]</a> `Calendar`.
    Defaults to NullCalendar (no holidays) if left blank or omitted.

  - PaymentConvention \[Optional\]: The roll convention to be used when
    applying the payment lag.  
    Allowable values: See Table
    <a href="#tab:convention" data-reference-type="ref"
    data-reference="tab:convention">[tab:convention]</a> Roll
    Convention. Defaults to Unadjusted if left blank or omitted.

<div class="listing">

``` xml
<SettlementData>
  <FXIndex>FX-ECB-EUR-USD</FXIndex>
  <Date>2020-09-03</Date>
  <Rules>
    <PaymentLag>2D</PaymentLag>
    <PaymentCalendar>USD</PaymentCalendar>
    <PaymentConvention>Following</PaymentConvention>
  </Rules>
</SettlementData>
```

</div>
