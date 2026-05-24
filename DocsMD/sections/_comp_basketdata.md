### Basket Data

This trade component node is used in credit derivative trades
referencing more than one reference entity e.g. in the
`IndexCreditDefaultSwapData` node of an index CDS trade. It contains
`Name` sub-nodes with the details of each constituent reference entities
(names) of the basket. An example structure of the `BasketData` trade
component node is shown in Listing
<a href="#lst:basket_data" data-reference-type="ref"
data-reference="lst:basket_data">[lst:basket_data]</a>.

<div class="listing">

``` xml
<BasketData>
  <Name>
    <IssuerId>CPTY_1</IssuerId>
    <CreditCurveId>RED:...</CreditCurveId>
    <Notional>100000.0</Notional>
    <Currency>USD</Currency>
  </Name>
  <Name>
    <IssuerId>CPTY_2</IssuerId>
    <CreditCurveId>RED:...</CreditCurveId>
    <Notional>100000.0</Notional>
    <Currency>USD</Currency>
  </Name>
  <Name>
    <IssuerId>CPTY_3</IssuerId>
    <CreditCurveId>RED:...</CreditCurveId>
    <Notional>100000.0</Notional>
    <Currency>USD</Currency>
  </Name>
  ...
</BasketData>
```

</div>

The meanings and allowable values of the elements in each `Name`
sub-node of the `BasketData` node follow below.

- IssuerId: A unique identifier for the index component reference
  entity. For informational purposes and not used for pricing.

  Allowable values: Any alphanumeric string.

- CreditCurveId: The unique identifier of the index component defining
  one of the default curves used for pricing. The pricing can be set up
  to either use the curve identifiers of the index components, or one
  single index curve id defined in the trade specific data. A
  `ReferenceInformation` node may be used in place of this
  `CreditCurveId` node.

  Allowable values: See `CreditCurveId` for credit trades - single name
  in Table <a href="#tab:equity_credit_data" data-reference-type="ref"
  data-reference="tab:equity_credit_data">[tab:equity_credit_data]</a>.
  Duplicate CreditCurveId:s are not allowed.  

- `ReferenceInformation`: This node may be used as an alternative to the
  `CreditCurveId` node to specify the reference entity, tier, currency
  and documentation clause for the basket constituent. This in turn
  defines the credit curve used for this basket constituent in the
  pricing. The `ReferenceInformation` node is described in further
  detail in Section
  <a href="#ss:cds_reference_information" data-reference-type="ref"
  data-reference="ss:cds_reference_information">[ss:cds_reference_information]</a>.

- Notional: The notional of the index component reference entity. Note
  that the sum of index component notionals (all names) must match the
  fixed premium leg notional. Allowable values: Any positive real
  number.

- Weight: Can be used, instead of Notional, to specify the weight of the
  index component reference entity. Note that the sum of index component
  notionals (all names) must match 1. Allowable values: Any positive
  real number.

- Currency: Defines the currency of the component, only mandatory
  together with a given notional.
