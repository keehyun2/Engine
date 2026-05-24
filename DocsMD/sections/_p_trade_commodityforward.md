### Commodity Forward

A Commodity Forward contract is an agreement between two counterparties
to buy/sell a set amount of a commodity, at a predetermined price (the
strike), at the end of the contract. A commodity forward does not
involve any upfront payment.

The `CommodityForwardData` node is the trade data container for the
`CommodityForward` trade type. The structure of an example
`CommodityForwardData` node is shown in Listings
<a href="#lst:comfwd_data" data-reference-type="ref"
data-reference="lst:comfwd_data">[lst:comfwd_data]</a> and
<a href="#lst:comm_fwd_lme_3M" data-reference-type="ref"
data-reference="lst:comm_fwd_lme_3M">[lst:comm_fwd_lme_3M]</a>.

<div class="listing">

``` xml
<CommodityForwardData>
  <Position>Long</Position>
  <Maturity>2029-06-30</Maturity>
  <Name>XCEC:GC</Name>
  <Currency>USD</Currency>
  <Strike>1355</Strike>
  <Quantity>1000</Quantity>
  <IsFuturePrice>...</IsFuturePrice>
  <FutureExpiryDate>...</FutureExpiryDate>
  <FutureExpiryOffset>...</FutureExpiryOffset>
  <FutureExpiryOffsetCalendar>...</FutureExpiryOffsetCalendar>
  <PhysicallySettled>...</PhysicallySettled>
  <PaymentDate>...</PaymentDate>
</CommodityForwardData>
```

</div>

<div class="listing">

``` xml
<CommodityForwardData>
  <Position>Long</Position>
  <Maturity>2029-08-16</Maturity>
  <Name>XLME:AH</Name>
  <Currency>USD</Currency>
  <Strike>2160</Strike>
  <Quantity>1000</Quantity>
  <IsFuturePrice>true</IsFuturePrice>
  <FutureExpiryDate>2021-11-16</FutureExpiryDate>
  <PhysicallySettled>true</PhysicallySettled>
</CommodityForwardData>
```

</div>

The meanings and allowable values of the elements in the
`CommodityForwardData` node follow below.

- Position: Defines whether the underlying commodity will be bought
  (long) or sold (short).  
  Allowable values: *Long, Short*

- Maturity: The maturity date of the forward contract, i.e. the date
  when the underlying commodity will be bought/sold.  
  Allowable values: Any date string, see `Date` in Table
  <a href="#tab:allow_stand_data" data-reference-type="ref"
  data-reference="tab:allow_stand_data">[tab:allow_stand_data]</a>.

- Name: The name of the underlying commodity.  
  Allowable values: See `Name` for commodity trades in Table
  <a href="#tab:commodity_data" data-reference-type="ref"
  data-reference="tab:commodity_data">[tab:commodity_data]</a>.  

- Currency: The currency the underlying commodity is quoted in. The
  Strike and the Forward price (or Future price) of the underlying
  commodity are both considered to be in this currency.  
  Allowable values: See `Currency` in Table
  <a href="#tab:allow_stand_data" data-reference-type="ref"
  data-reference="tab:allow_stand_data">[tab:allow_stand_data]</a>.

- Strike: The agreed buy/sell price of the commodity forward.  
  Allowable values: Any real number.

- Quantity: The number of units of the underlying commodity to be
  bought/sold.  
  Allowable values: Any real number.

- `IsFuturePrice` \[Optional\]: This should be set to `true` if the
  forward contract underlying is the settlement price of a commodity
  future contract. If omitted, it defaults to `false`.  
  Allowable values: Any string that evaluates to true or false as
  outlined in Table
  <a href="#tab:boolean_allowable" data-reference-type="ref"
  data-reference="tab:boolean_allowable">[tab:boolean_allowable]</a>.

- `FutureExpiryDate` \[Optional\]: If `IsFuturePrice` is set to `true`,
  this gives the expiration date of the underlying commodity future
  contract. If omitted, the expiration date of the underlying commodity
  future contract is set equal to the value in the `Maturity` node. If
  `FutureExpiryDate` is provided, it takes precedence over any value
  provided in the `Maturity`, `FutureExpiryOffset` or
  `FutureExpiryOffsetCalendar` fields.  
  Allowable values: Any date string, see `Date` in Table
  <a href="#tab:allow_stand_data" data-reference-type="ref"
  data-reference="tab:allow_stand_data">[tab:allow_stand_data]</a>.

- `FutureExpiryOffset` \[Optional\]: If `IsFuturePrice` is set to `true`
  and `FutureExpiryDate` is not explicitly specified, this gives the
  offset period that should be applied to the `Maturity` date to
  generate the underlying commodity future contract expiration date. If
  omitted, the expiration date of the underlying commodity future
  contract is set equal to the value in the `Maturity` node.  
  Allowable values: Any string that can be parsed as a period e.g. `2D`,
  `3M`, etc.

- `FutureExpiryOffsetCalendar` \[Optional\]: If `FutureExpiryOffset` is
  provided and is being used, this gives the calendar that should be
  used when generating the underlying commodity future contract
  expiration date from the `Maturity` date. If omitted, all days are
  considered good business days when generating the commodity future
  contract expiration date which is generally not what is desired.  
  Allowable values: Any calendar string, see `Calendar` in Table
  <a href="#tab:calendar" data-reference-type="ref"
  data-reference="tab:calendar">[tab:calendar]</a>.

- `PhysicallySettled` \[Optional\]: A value of `true` indicates that the
  forward contract is physically settled e.g. if the underlying is a
  future contract, that future contract is entered into on the
  `Maturity` date. A value of `false` indicates that the forward
  contract is cash settled e.g. if the underlying is a future contract,
  that future contract settlement price is observed on the `Maturity`
  date (or the `FutureExpiryDate`, when given) and the net amount due is
  exchanged on the cash settlement date. If omitted, it defaults to
  *true*.  
  Allowable values: Any string that evaluates to true or false as
  outlined in Table
  <a href="#tab:boolean_allowable" data-reference-type="ref"
  data-reference="tab:boolean_allowable">[tab:boolean_allowable]</a>.

- `PaymentDate` \[Optional\]: If `PhysicallySettled` is set to *false*,
  this gives the cash settlement date. It must be greater than or equal
  to the `Maturity` date. If omitted and the forward is cash settled,
  the `Maturity` date is used.  
  Allowable values: Any date string, see `Date` in Table
  <a href="#tab:allow_stand_data" data-reference-type="ref"
  data-reference="tab:allow_stand_data">[tab:allow_stand_data]</a>.

- `SettlementData` \[Optional\]: This node is used to specify the
  settlement of the cash flows for cash settled forwards, and the
  payment flow for physically settled ones.

A `SettlementData` node is shown in Listing
<a href="#lst:comm_ndf_settlement_data_node" data-reference-type="ref"
data-reference="lst:comm_ndf_settlement_data_node">[lst:comm_ndf_settlement_data_node]</a>,
and the meanings and allowable values of its elements follow below.

- `PayCurrency`: The settlement currency for the payment cashflow.  
  Allowable values: See `Currency` in Table
  <a href="#tab:allow_stand_data" data-reference-type="ref"
  data-reference="tab:allow_stand_data">[tab:allow_stand_data]</a>.

- `FXIndex`: The FX reference index for determining the FX fixing at the
  value date. The Forward Price will be observed at maturity date (or
  future expiry date if it’s a future), the NPV is converted to
  `PayCurrency` with the `FXIndex` using an FX fixing on `FixingDate`
  (settlement date) discounted from `PaymentDate`.  
  Allowable values: The format of the `FXIndex` is
  “FX-FixingSource-CCY1-CCY2” as described in Table
  <a href="#tab:fxindex_data" data-reference-type="ref"
  data-reference="tab:fxindex_data">[tab:fxindex_data]</a>.

- `FixingDate`: The date on which the *FXIndex* is observed. Allowable
  values: See `Date` in Table
  <a href="#tab:allow_stand_data" data-reference-type="ref"
  data-reference="tab:allow_stand_data">[tab:allow_stand_data]</a>.

<div class="listing">

``` xml
    <SettlementData>
      <PayCurrency>EUR</PayCurrency>
      <FXIndex>FX-ECB-EUR-USD</FXIndex>
      <FixingDate>2025-05-28</FixingDate>
    </SettlementData>
```

</div>

Note that a Precious Metal Forward should be represented as an FX
Forward using the appropriate commodity “currency” (XAU, XAG, XPT, XPD).
