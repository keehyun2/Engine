### FX Forward

The `FXForwardData` node is the trade data container for the *FxForward*
trade type. The structure - including example values - of the
`FXForwardData` node is shown in Listing
<a href="#lst:fxforward_data" data-reference-type="ref"
data-reference="lst:fxforward_data">[lst:fxforward_data]</a>.

<div class="listing">

``` xml
        <FxForwardData>
            <ValueDate>2023-04-09</ValueDate>
            <BoughtCurrency>EUR</BoughtCurrency>
            <BoughtAmount>1000000</BoughtAmount>
            <SoldCurrency>USD</SoldCurrency>
            <SoldAmount>1500000</SoldAmount>
            <Settlement>Physical</Settlement>
            <SettlementData>
              ...
            </SettlementData>
        </FxForwardData>
```

</div>

The meanings and allowable values of the various elements in the
`FXForwardData` node follow below.

- ValueDate: The value date of the FX Forward.  
  Allowable values: See `Date` in Table
  <a href="#tab:allow_stand_data" data-reference-type="ref"
  data-reference="tab:allow_stand_data">[tab:allow_stand_data]</a>.

- BoughtCurrency: The currency to be bought on value date.  
  Allowable values: See Table
  <a href="#tab:currency" data-reference-type="ref"
  data-reference="tab:currency">[tab:currency]</a> `Currency`.

- BoughtAmount: The amount to be bought on value date.  
  Allowable values: Any positive real number.

- SoldCurrency: The currency to be sold on value date.  
  Allowable values: See Table
  <a href="#tab:currency" data-reference-type="ref"
  data-reference="tab:currency">[tab:currency]</a> `Currency`.

- SoldAmount: The amount to be sold on value date.  
  Allowable values: Any positive real number.

- Settlement \[Optional\]: Delivery type. Note that Non-Deliverable
  Forwards can be represented by *Cash* settlement.  
  Allowable values: *Cash* or *Physical*. Defaults to *Physical* if left
  blank or omitted.

- SettlementData \[Optional\]: This node is used to specify the
  settlement of the cash flows on the value date.

A `SettlementData` node is shown in Listing
<a href="#lst:settlement_data_node" data-reference-type="ref"
data-reference="lst:settlement_data_node">[lst:settlement_data_node]</a>,
and the meanings and allowable values of its elements follow below.

- Currency: The currency in which the FX Forward is settled. This field
  is only used if settlement is *Cash*.  
  Allowable values: See Table
  <a href="#tab:currency" data-reference-type="ref"
  data-reference="tab:currency">[tab:currency]</a> `Currency`. Defaults
  to the sold currency if left blank or omitted.

- FXIndex: The FX reference index for determining the FX fixing at the
  value date. This field is required if settlement is *Cash* and the
  payment date is greater than the value date. Otherwise, it is
  ignored.  
  Allowable values: The format of the `FXIndex` is
  “FX-FixingSource-CCY1-CCY2” as described in Table
  <a href="#tab:fxindex_data" data-reference-type="ref"
  data-reference="tab:fxindex_data">[tab:fxindex_data]</a>.

- Date \[Optional\]: If specified, this will be the payment date.  
  Allowable values: See `Date` in Table
  <a href="#tab:allow_stand_data" data-reference-type="ref"
  data-reference="tab:allow_stand_data">[tab:allow_stand_data]</a>. If
  left blank or omitted, defaults to the value date with some
  adjustments applied from the `Rules` sub-node.

- Rules \[Optional\]: If `Date` is left blank or omitted, this node will
  be used to derive the payment date from the value date. The `Rules`
  sub-node is shown in Listing
  <a href="#lst:settlement_data_node" data-reference-type="ref"
  data-reference="lst:settlement_data_node">[lst:settlement_data_node]</a>,
  and the meanings and allowable values of its elements follow below.

  - PaymentLag \[Optional\]: The lag between the value date and the
    payment date.  
    Allowable values: Any valid period, i.e. a non-negative whole
    number, optionally followed by *D* (days), *W* (weeks), *M*
    (months), *Y* (years). For cash settlement and if a FXIndex is
    specified defaults to the fx convention (field “SpotDays”) if blank
    or omitted, otherwise to 0. If a whole number is given and no
    letter, it is assumed that it is a number of *D* (days).

  - PaymentCalendar \[Optional\]: The calendar to be used when applying
    the payment lag.  
    Allowable values: See Table
    <a href="#tab:calendar" data-reference-type="ref"
    data-reference="tab:calendar">[tab:calendar]</a> `Calendar`. For
    cash settlement and if a FXIndex is specified defaults to the fx
    convention (field “AdvanceCalendar”) if left blank or omitted,
    otherwise to NullCalendar (no holidays).

  - PaymentConvention \[Optional\]: The roll convention to be used when
    applying the payment lag.  
    Allowable values: See Table
    <a href="#tab:convention" data-reference-type="ref"
    data-reference="tab:convention">[tab:convention]</a> Roll
    Convention. For cash settlement and if a FXIndex is specified
    defaults to the fx convention ((field “Convention”) if left blank or
    omitted, otherwise to Unadjusted.

Note that FX Forwards also cover Precious Metals forwards, i.e. with
currencies XAU, XAG, XPT, XPD, and Cryptocurrency forwards, see
supported Cryptocurrencies in Table
<a href="#tab:currency" data-reference-type="ref"
data-reference="tab:currency">[tab:currency]</a>.

<div class="listing">

``` xml
<SettlementData>
  <Currency>USD</Currency>
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

### FX Average Forward

The `FXAverageForwardData` node is the trade data container for the
*FxAverageForward* trade type. The structure with example values node is
shown in Listing
<a href="#lst:fxaverageforward_data" data-reference-type="ref"
data-reference="lst:fxaverageforward_data">[lst:fxaverageforward_data]</a>.

<div class="listing">

``` xml
        <FxAverageForwardData>
            <PaymentDate>2023-04-09</PaymentDate>
            <!-- Schedule block that determines observation dates for FX averaging -->
            <ObservationDates>
               ...
            </ObservationDates>
            <FixedPayer>true</FixedPayer>
            <ReferenceNotional>8614</ReferenceNotional>
            <ReferenceCurrency>EUR</ReferenceCurrency>
            <SettlementNotional>10000</SettlementNotional>
            <SettlementCurrency>USD</SettlementCurrency>
            <FXIndex>FX-ECB-EUR-USD</FXIndex>
            <Settlement>Cash</Settlement>
        </FxAverageForwardData>
```

</div>

The instrument’s payoff is driven by an arithmetic average of observed
FX rates, expressed in terms of the node names:
$$\omega \times \left( \mbox{ReferenceNotional} \times \mbox{AverageFX} - \mbox{SettlementNotional}\right)$$

The meanings and allowable values of the various elements in the
`FXAverageForwardData` node follow below.

- PaymentDate: The date of the settlement cash flow.  
  Allowable values: See `Date` in Table
  <a href="#tab:allow_stand_data" data-reference-type="ref"
  data-reference="tab:allow_stand_data">[tab:allow_stand_data]</a>.

- ObservationDates: Schedule data that determine the observation dates
  that are taken into account in the FX rate averaging. See section
  <a href="#ss:schedule_data" data-reference-type="ref"
  data-reference="ss:schedule_data">[ss:schedule_data]</a>

- FixedPayer: If *true*, the payoff multiplier $\omega$ is set to 1,
  otherwise -1.  
  Allowable values: *true*, *false*

- ReferenceNotional: The amount to be converted into settlement currency
  at the average FX rate  
  Allowable values: Any positive real number.

- ReferenceCurrency: The currency of the reference notional above.  
  Allowable values: See Table
  <a href="#tab:currency" data-reference-type="ref"
  data-reference="tab:currency">[tab:currency]</a> `Currency`.

- SettlementNotional: The fixed amount to be paid or received depending
  on the fixed payer flag above  
  Allowable values: Any positive real number.

- SettlementCurrency: The currency of the settlement notional above.  
  Allowable values: See Table
  <a href="#tab:currency" data-reference-type="ref"
  data-reference="tab:currency">[tab:currency]</a> `Currency`.

- FXIndex: The FX reference index for determining the FX fixing for
  averaging.  
  Allowable values: The format of the `FXIndex` is
  “FX-FixingSource-CCY1-CCY2” as described in Table
  <a href="#tab:fxindex_data" data-reference-type="ref"
  data-reference="tab:fxindex_data">[tab:fxindex_data]</a>. Notice that
  since the payoff is based on an arithmetic average, the order of the
  currencies in the FX index matters: The averaging will be done on fx
  rates quoted as CCY1-CCY2 (foreign-domestic).
