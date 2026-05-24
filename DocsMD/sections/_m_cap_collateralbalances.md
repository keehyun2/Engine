<span id="sec:collateralbalances" label="sec:collateralbalances"></span>

The collateral balances file - `collateralbalances.xml` - contains the
list of collateral balances (i.e. margin amounts and independent amount)
under a Credit Support Annex.

The balances of each netting set are defined within their own
`CollateralBalance` node. All of these `CollateralBalance` nodes are
contained as children of a `CollateralBalances` node.

The collateral balances are given in the following XML template:

<div class="listing">

``` xml
    <CollateralBalances>
        <CollateralBalance>
            <NettingSetId> </NettingSetId>
            <Currency>USD</Currency>
            <IndependentAmountHeld/>
            <InitialMargin> </InitialMargin>
            <VariationMargin> </VariationMargin>
        </CollateralBalance>
        <CollateralBalance>
            .......
        </CollateralBalance>
    </CollateralBalances>
```

</div>

The meanings of the various elements of the `CollateralBalance` node are
as follows (default input values for certain analytics are specified in
their own respective sections, otherwise the defaults given below, if
any, are applicable):

- `NettingSetId`: The unique identifier for the (collateralised) ISDA
  netting set.  
  Allowable values: Any string.

- `Currency`: The currency that the collateral balance amounts are
  assumed to be denominated in.  
  Allowable values: See Table
  <a href="#tab:currency" data-reference-type="ref"
  data-reference="tab:currency">[tab:currency]</a>.

- `IndependentAmountHeld` \[Optional\]: The netted sum of all
  independent amounts covered by the CSA.  
  Allowable values: Any number. A negative number implies that the
  counterparty holds the independent amount. If provided, overrides the
  specified independent amount held (if any) in the corresponding
  netting set definitions file. Otherwise (if left blank or omitted),
  the independent amount in the netting set definitions file is used.

- `InitialMargin` \[Optional\]: The initial margin amount received.  
  Allowable values: Any number. A negative number implies that the
  counterparty holds the initial margin.

- `VariationMargin` \[Optional\]: The variation margin amount
  received.  
  Allowable values: Any number. A negative number implies that the
  counterparty holds the variation margin.
