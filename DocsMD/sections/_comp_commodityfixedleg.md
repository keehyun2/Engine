### Commodity Fixed Leg

A commodity fixed leg is specified in a `LegData` node with `LegType`
set to `CommodityFixed`. It is used to define a sequence of cashflows
that are linked to a fixed price in a commodity derivative contract.
Each cashflow has an associated *Calculation Period*. The outline of a
commodity fixed leg is given in listing
<a href="#lst:commodityfixedleg" data-reference-type="ref"
data-reference="lst:commodityfixedleg">[lst:commodityfixedleg]</a>. It
has the usual `LegData` elements described in section
<a href="#ss:leg_data" data-reference-type="ref"
data-reference="ss:leg_data">[ss:leg_data]</a> and a
`CommodityFixedLegData` node that is described in section
<a href="#ss:commodity_fixed_leg_data" data-reference-type="ref"
data-reference="ss:commodity_fixed_leg_data">0.0.2</a> below. The
section <a href="#ss:commodity_schedules" data-reference-type="ref"
data-reference="ss:commodity_schedules">[ss:commodity_schedules]</a>
describes some aspects of the `ScheduleData` node in the context of
commodity derivatives.

<div class="listing">

``` xml
<LegData>
  <LegType>CommodityFixed</LegType>
  <Payer>...</Payer>
  <Currency>...</Currency>
  <PaymentConvention>...</PaymentConvention>
  <PaymentLag>...</PaymentLag>
  <PaymentCalendar>...</PaymentCalendar>
  <ScheduleData>
    ...
  </ScheduleData>
  <PaymentDates>
    <PaymentDate>...</PaymentDate>
  </PaymentDates>
  <CommodityFixedLegData>
    ...
  </CommodityFixedLegData>
</LegData>
```

</div>

### Commodity Fixed Leg Data

The `CommodityFixedLegData` node outline is shown in listing
<a href="#lst:commodity_fixed_leg_data" data-reference-type="ref"
data-reference="lst:commodity_fixed_leg_data">[lst:commodity_fixed_leg_data]</a>.
The meaning and allowable values for each node are as follows:

- `Quantities` \[Optional\]: this node is used to specify a constant
  quantity or a quantity that varies over the calculation periods. The
  usage of this node is analagous to the usage of the `Notionals` node
  as outlined in section
  <a href="#ss:leg_data" data-reference-type="ref"
  data-reference="ss:leg_data">[ss:leg_data]</a>. For convenience, this
  node can be omitted if the quantities are identical to those on a
  commodity floating leg, outlined in Section
  <a href="#ss:commodityfloatingleg" data-reference-type="ref"
  data-reference="ss:commodityfloatingleg">[ss:commodityfloatingleg]</a>,
  on the same trade. In this case, the quantities from the floating leg
  are used. If there is only a single commodity floating leg, as is the
  case in a standard swap, the quantities are taken from that leg. If
  there are multiple commodity floating legs on the trade, a specific
  commodity floating leg can be picked using the `Tag` node specified
  below. In other words, a `Tag` can be specified on the fixed leg and
  the same `Tag` specified on the floating leg from which the quantities
  should be taken.

- `Prices`: this node is used to specify a constant price or a price
  that varies over the calculation periods. The usage of this node is
  analagous to the usage of the `Notionals` node as outlined in section
  <a href="#ss:leg_data" data-reference-type="ref"
  data-reference="ss:leg_data">[ss:leg_data]</a>.

- `CommodityPayRelativeTo` \[Optional\]: the allowable values for this
  node are  
  `CalculationPeriodStartDate`, `CalculationPeriodEndDate`,
  `TerminationDate`, `FutureExpiryDate`. They specify whether payment is
  relative to the calculation period start date, calculation period end
  date, leg maturity date or the future expiry date (of the
  corresponding cashflow on the floating leg with the same Tag as the
  fixed leg) respectively. The default is `CalculationPeriodEndDate`.
  The payment date is then further adjusted by the payment conventions
  outlined in section <a href="#ss:leg_data" data-reference-type="ref"
  data-reference="ss:leg_data">[ss:leg_data]</a> i.e.
  `PaymentConvention` and `PaymentLag`. If explicit payment dates are
  given via the `PaymentDates` node described in section
  <a href="#ss:leg_data" data-reference-type="ref"
  data-reference="ss:leg_data">[ss:leg_data]</a>, then those explicit
  payment dates are used instead and adjusted by the `PaymentCalendar`
  and `PaymentConvention`.

- `Tag` \[Optional\]: The use of this node is explained in the
  `Quantities` resp. `CommodityPayRelativeTo` piece above.

<div class="listing">

``` xml
<CommodityFixedLegData>
  <Quantities>
    <Quantity>...</Quantity>
  </Quantities>
  <Prices>
    <Price>...</Price>
  </Prices>
  <CommodityPayRelativeTo>...</CommodityPayRelativeTo>
  <Tag>...</Tag>
</CommodityFixedLegData>
```

</div>
