### Index Credit Default Swap

An index credit default swap (trade type *IndexCreditDefaultSwap*) is
set up using an `IndexCreditDefaultSwapData` block as shown in listing
<a href="#lst:indexcdsdata" data-reference-type="ref"
data-reference="lst:indexcdsdata">[lst:indexcdsdata]</a> and includes
`LegData` and `BasketData` trade component sub-nodes.

The `LegData` sub-node must be a fixed leg, and represents the recurring
premium payments. The direction of the fixed leg payments define if the
Index CDS is for bought (`Payer`: *true*) or sold (`Payer`: *false*)
protection. The notional on the fixed leg is the “unfactored notional”,
i.e. the notional excluding any defaults. This is opposed to the “trade
date notional” which is reduced by defaults since the series inception
until the trade date and the “current notional” or “factored notional”
which is reduced by defaults between the series inception and the
current evaluation date of the trade.

The `BasketData` sub-node (see section
<a href="#ss:basket_data" data-reference-type="ref"
data-reference="ss:basket_data">[ss:basket_data]</a>) is optional and
specifies the constituent reference entities of the index. This sub-node
is intended for non-standard indices, that require a bespoke basket.
When `BasketData` is omitted, the index constituents are derived from
the `CreditCurveId` element in the `IndexCreditDefaultSwapData` block.

<div class="listing">

``` xml
    <IndexCreditDefaultSwapData>
      <CreditCurveId>RED:2I65BRHH6</CreditCurveId>
      <SettlesAccrual>Y</SettlesAccrual>
      <ProtectionPaymentTime>atDefault</ProtectionPaymentTime>
      <ProtectionStart>20160206</ProtectionStart>
      <UpfrontDate>20160208</UpfrontDate>
      <UpfrontFee>0.0</UpfrontFee>
      <LegData>
            <LegType>Fixed</LegType>
            <Payer>false</Payer>
            ...
      </LegData>
       <BasketData>
        <Name>
          <IssuerId>CPTY_1</IssuerId>
          <CreditCurveId>RED:</CreditCurveId>
          <Notional>100000.0</Notional>
          <Currency>USD</Currency>
        </Name>
        <Name>
          <IssuerId>CPTY_2</IssuerId>
          <CreditCurveId>RED:</CreditCurveId>
          <Notional>100000.0</Notional>
          <Currency>USD</Currency>
        </Name>
        <Name>
          <IssuerId>CPTY_3</IssuerId>
          <CreditCurveId>RED:</CreditCurveId>
          <Notional>100000.0</Notional>
          <Currency>USD</Currency>
        </Name>
        <!-- ... -->
      </BasketData>
    </IndexCreditDefaultSwapData>
```

</div>

The meanings of the elements of the `IndexCreditDefaultSwapData` node
follow below:

- CreditCurveId: The identifier of the index defining the default curve
  used for pricing. The pricing can be set up to either use the index
  curve id, or use the curve id:s of the individual index components
  defined in `BasketData`.

  Allowable values: See `CreditCurveId` for credit trades - index in
  Table <a href="#tab:equity_credit_data" data-reference-type="ref"
  data-reference="tab:equity_credit_data">[tab:equity_credit_data]</a>.
  Note that the `CreditCurveId` cannot be a redcode or other identifier
  for an ABX or CMBX. For these underlyings, trade type
  *AssetBackedCreditDefaultSwap* is used instead.  

- SettlesAccrual \[Optional\]: Whether or not the accrued coupon is due
  in the event of a default. This defaults to `true` if not provided.

  Allowable values: Boolean node, allowing *Y, N, 1, 0, true, false*
  etc. The full set of allowable values is given in Table
  <a href="#tab:boolean_allowable" data-reference-type="ref"
  data-reference="tab:boolean_allowable">[tab:boolean_allowable]</a>.

- ProtectionPaymentTime \[Optional\]: Controls the payment time of
  protection and premium accrual payments in case of a default event.
  Defaults to `atDefault`.

  Allowable values: `atDefault`, `atPeriodEnd`, `atMaturity`. Overrides
  the `PaysAtDefaultTime` node

- PaysAtDefaultTime \[Deprecated\]: `true` is equivalent to
  ProtectionPaymentTime = atDefault, `false` to ProtectionPaymentTime =
  atPeriodEnd. Overridden by the `ProtectionPaymentTime` node if set

  Allowable values: Boolean node, allowing *Y, N, 1, 0, true, false*
  etc. The full set of allowable values is given in Table
  <a href="#tab:boolean_allowable" data-reference-type="ref"
  data-reference="tab:boolean_allowable">[tab:boolean_allowable]</a>.

- ProtectionStart \[Optional\]: The first date where a credit event will
  trigger the contract. This defaults to the first date in the schedule
  if it is not provided. Must be set to a date before or on the first
  date in the schedule if the `LegData` has a rule that is not one of
  `CDS` or `CDS2015`. In general, for standard index CDS, the protection
  start date is equal to the trade date. Therefore, typically the
  `ProtectionStart` should be set to the trade date of the index CDS.

  Allowable values: See `Date` in Table
  <a href="#tab:allow_stand_data" data-reference-type="ref"
  data-reference="tab:allow_stand_data">[tab:allow_stand_data]</a>.

- UpfrontDate \[Optional\]: Settlement date for the UpfrontFee if an
  UpfrontFee is provided. If an UpfrontFee is provided and it is
  non-zero, UpfrontDate is required.

  Allowable values: See `Date` in Table
  <a href="#tab:allow_stand_data" data-reference-type="ref"
  data-reference="tab:allow_stand_data">[tab:allow_stand_data]</a>. The
  UpfrontDate, if provided, must be on or after the ProtectionStart
  date.

- UpfrontFee \[Optional\]: The upfront payment, expressed in decimal
  form as a percentage of the notional. If an UpfrontDate is provided,
  an UpfrontFee must also be provided. The UpfrontFee can be omitted but
  cannot be left blank. The UpfrontFee can be negative. The UpfrontFee
  is treated as an amount payable by the protection buyer to the
  protection seller. A negative value for the UpfrontFee indicates that
  the UpfrontFee is being paid by the protection seller to the
  protection buyer.

  Allowable values: Any real number, expressed in decimal form as a
  percentage of the notional. E.g. an UpfrontFee of *0.045* and a
  notional of 10M, would imply an upfront fee amount of 450K.

- TradeDate \[Optional\]: The index CDS trade date. If omitted, the
  trade date is deduced from the protection start date. If the schedule
  provided in the `LegData` has a rule that is either `CDS` or
  `CDS2015`, the trade date is set equal to the protection start date.
  Otherwise, the trade date is set equal to the protection start date
  minus 1 day.

  Allowable values: See `Date` in Table
  <a href="#tab:allow_stand_data" data-reference-type="ref"
  data-reference="tab:allow_stand_data">[tab:allow_stand_data]</a>.

- CashSettlementDays \[Optional\]: The number of business days between
  the trade date and the cash settlement date. For standard index CDS,
  this is generally 3 business days. If omitted, this defaults to 3.

  Allowable values: Any non-negative integer.

- RebatesAccrual \[Optional\]: The protection seller pays the accrued
  scheduled current coupon at the start of the contract. The rebate date
  is not provided but computed to be two days after protection start.
  This defaults to `true` if not provided.

  Allowable values: Boolean node, allowing *Y, N, 1, 0, true, false*
  etc. The full set of allowable values is given in Table
  <a href="#tab:boolean_allowable" data-reference-type="ref"
  data-reference="tab:boolean_allowable">[tab:boolean_allowable]</a>.

The `LegData` block then defines the Index CDS premium leg structure.
This premium leg must be be of type `Fixed` as described in Section
<a href="#ss:fixedleg_data" data-reference-type="ref"
data-reference="ss:fixedleg_data">[ss:fixedleg_data]</a>.
