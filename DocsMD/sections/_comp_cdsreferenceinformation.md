### CDS Reference Information

This trade component can be used to define the reference entity, tier,
currency and documentation clause in credit derivative trades. For
example, it can be used in the `CreditDefaultSwapData` section in a CDS
trade and in the `BasketData` section in credit derivatives involving
more than one underlying reference entity. The value for each of these
fields is generally agreed and specified in the credit derivative
contract and they determine the credit curve that is used in pricing the
trade.

<div class="listing">

``` xml
<ReferenceInformation>
  <ReferenceEntityId>...</ReferenceEntityId>
  <Tier>...</Tier>
  <Currency>...</Currency>
  <DocClause>...</DocClause>
</ReferenceInformation>
```

</div>

The meanings and allowable values of the elements in the
`ReferenceInformation` node are as follows:

- `ReferenceEntityId`: This is typically a six digit Markit RED code
  specifying the underlying reference entity with the prefix `RED:` e.g.
  `RED:008CA0`.

- `Tier`: The debt tier that is applicable for the specified reference
  entity in the credit derivative. Table
  <a href="#tab:tier_data" data-reference-type="ref"
  data-reference="tab:tier_data">[tab:tier_data]</a> provides the
  allowable values.

- `Currency`: The currency that is applicable for the specified
  reference entity in the credit derivative. Table
  <a href="#tab:currency" data-reference-type="ref"
  data-reference="tab:currency">[tab:currency]</a> provides the
  allowable values.

- `DocClause`: The documentation clause that is applicable for the
  specified reference entity in the credit derivative. This defines what
  constitutes a credit event for the contract as well as any limitations
  on the deliverable debt in the event of a credit event. Table
  <a href="#tab:docclause_data" data-reference-type="ref"
  data-reference="tab:docclause_data">[tab:docclause_data]</a> provides
  the allowable values.
