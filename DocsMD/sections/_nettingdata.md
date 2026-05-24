# Netting Set Definitions

The netting set definitions file - `netting.xml` - contains a list of
definitions for various ISDA netting agreements. The file is written in
XML format.

Each netting set is defined within its own `NettingSet` node. All of
these `NettingSet` nodes are contained as children of a
`NettingSetDefinitions` node.

There are two distinct cases to consider:

- An ISDA agreement which does not contain a *Credit Support Annex*
  (CSA).

- An ISDA agreement which does contain a CSA.

## Uncollateralised Netting Set

If an ISDA agreement does not contain a Credit Support Annex, the
portfolio exposures are not eligible for collateralisation. In such a
case the netting set can be defined within the following XML template:

<div class="listing">

``` xml
    <NettingSet>
        <NettingSetId> </NettingSetId>
        <ActiveCSAFlag> </ActiveCSAFlag>
        <CSADetails></CSADetails>
    </NettingSet>
```

</div>

The meanings of the various elements are as follows:

- `NettingSetId`: The unique identifier for the ISDA netting set.  
  Allowable values: Any string

- `ActiveCSAFlag` \[Optional\]: Boolean indicating whether the netting
  set is covered by a Credit Support Annex. Allowable values: For
  uncollateralised netting sets this flag should be *False*. If left
  blank or omitted, defaults to *True*.

- `CSADetails` \[Optional\]: Node containing as children details of the
  governing Credit Support Annex. For uncollateralised netting sets,
  this node is not needed.

## Collateralised Netting Set

If an ISDA agreement contains a Credit Support Annex, the portfolio
exposures are eligible for collateralisation. In such a case the netting
set can be defined within the following XML template:

<div class="listing">

``` xml
    <NettingSet>
        <NettingSetId> </NettingSetId>
        <ActiveCSAFlag> </ActiveCSAFlag>
        <CSADetails>
            <Bilateral> </Bilateral>
            <CSACurrency> </CSACurrency>
            <Index> </Index>
            <ThresholdPay> </ThresholdPay>
            <ThresholdReceive> </ThresholdReceive>
            <MinimumTransferAmountPay> </MinimumTransferAmountPay>
            <MinimumTransferAmountReceive> </MinimumTransferAmountReceive>
            <IndependentAmount>
                <IndependentAmountHeld> </IndependentAmountHeld>
                <IndependentAmountType> </IndependentAmountType>
            </IndependentAmount>
            <MarginingFrequency>
                <CallFrequency> </CallFrequency>
                <PostFrequency> </PostFrequency>
            </MarginingFrequency>
            <MarginPeriodOfRisk> </MarginPeriodOfRisk>
            <CollateralCompoundingSpreadReceive> 
            </CollateralCompoundingSpreadReceive>
            <CollateralCompoundingSpreadPay> </CollateralCompoundingSpreadPay>
            <EligibleCollaterals>
                <Currencies>
                    <Currency>USD</Currency>
                    <Currency>EUR</Currency>
                    <Currency>CHF</Currency>
                    <Currency>GBP</Currency>
                    <Currency>JPY</Currency>
                    <Currency>AUD</Currency>
                </Currencies>
            </EligibleCollaterals>
            <ApplyInitialMargin>Y</ApplyInitialMargin>
            <InitialMarginType>Bilateral</InitialMarginType>
            <CalculateIMAmount>true</CalculateIMAmount>
            <CalculateVMAmount>true</CalculateVMAmount>
        </CSADetails>
    </NettingSet>
```

</div>

### CSADetails

The `CSADetails` node contains details of the Credit Support Annex which
are relevant for the purposes of exposure calculation. The meanings of
the various elements are as follows:

- `Bilateral` \[Optional\]: There are three possible values here:

  - *Bilateral*: Both parties to the CSA are legally entitled to request
    collateral to cover their counterparty credit risk exposure on the
    underlying portfolio.

  - *CallOnly*: Only we are entitled to hold collateral; the
    counterparty has no such entitlement.

  - *PostOnly*: Only the counterparty is entitled to hold collateral; we
    have no such entitlement.

  Defaults to *Bilateral* if left blank or omitted.

- `CSACurrency` \[Optional\]: A three-letter ISO code specifying the
  master currency of the CSA. All monetary values specified within the
  CSA are assumed to be denominated in this currency.  
  Allowable values: Any currency. See Table
  <a href="#tab:currency" data-reference-type="ref"
  data-reference="tab:currency">[tab:currency]</a>.

- `Index` \[Optional\]: The index is used to derive the fixing which is
  used for compounding cash collateral in the master currency of the
  CSA.  
  Allowable values: An alphanumeric string of the form CCY-INDEX-TENOR.
  CCY, INDEX and TENOR must be separated by dashes (-). CCY and INDEX
  must be among the supported currency and index combinations. TENOR
  must be an integer followed by *D*, *W*, *M* or *Y*, except for
  Overnight indices which do not require a TENOR. See Table
  <a href="#tab:indices" data-reference-type="ref"
  data-reference="tab:indices">[tab:indices]</a>.

- `ThresholdPay` \[Optional\]: A threshold amount above which the
  counterparty is entitled to request collateral to cover excess
  exposure.  
  Allowable values: Any number.

- `ThresholdReceive` \[Optional\]: A threshold amount above which we are
  entitled to request collateral from the counterparty to cover excess
  exposure.  
  Allowable values: Any number.

- `MinimumTransferAmountPay` \[Optional\]: Any margin calls issued by
  the counterparty must exceed this minimum transfer amount. If the
  collateral shortfall is less than this amount, the counterparty is not
  entitled to request margin.  
  Allowable values: Any number.

- `MinimumTransferAmountReceive` \[Optional\]: Any margin calls issued
  by us to the counterparty must exceed this minimum transfer amount. If
  the collateral shortfall is less than this amount, we are not entitled
  to request margin.  
  Allowable values: Any number.

- `IndependentAmount` \[Optional\]: This element contains two child
  nodes:

  - `IndependentAmountHeld`: The netted sum of all independent amounts
    covered by this ISDA agreement/CSA.  
    Allowable values: Any number. A negative number implies that the
    counterparty holds the independent amount.

  - `IndependentAmountType`: The nature of the independent amount as
    defined within the Credit Support Annex.  
    Allowable values: The only supported value here is *FIXED*.

- `MarginingFrequency`: This element contains two child nodes:

  - `CallFrequency`: The frequency with which we are entitled to request
    additional margin from the counterparty (e.g. *1D*, *2W*, *1M*).  
    Allowable values:

  - `PostFrequency`: The frequency with which the counterparty is
    entitled to request additional margin from us.  
    Allowable values: Any period definition (e.g. *2D*, *1W*, *1M*,
    *1Y*).

  This covers only the case where only one party has to post an
  independent amount. In a future release this will be extended to the
  situation prescribed by the Basel/IOSCO regulation (initial margin to
  be posted by both parties without netting).

- `MarginPeriodOfRisk`: The length of time assumed necessary for closing
  out the portfolio position after a default event.  
  Allowable values: Any period definition (e.g. *2D*, *1W*, *1M*, *1Y*).

- `CollateralCompoundingSpreadReceive`: The spread over the O/N interest
  accrual rate taken by the clearing house, when holding collateral.  
  Allowable values: Any number.

- `CollateralCompoundingSpreadPay`: The spread over the O/N interest
  accrual rate taken by the clearing house, when collateral is held by
  the counterparty.  
  Allowable values: Any number.

- `EligibleCollaterals`: For now the only supported type of collateral
  is cash. If the CSA specifies a set of currencies which are eligible
  as collateral, these can be listed using `Currency` nodes.  
  Allowable values: Any currency. See Table
  <a href="#tab:currency" data-reference-type="ref"
  data-reference="tab:currency">[tab:currency]</a>.

- `ApplyInitialMargin`: Apply (dynamic) initial Margin in addition to
  variation margin  
  Allowable values: Boolean node, the set of allowable values is given
  in Table <a href="#tab:boolean_allowable" data-reference-type="ref"
  data-reference="tab:boolean_allowable">[tab:boolean_allowable]</a>.

- `InitialMarginType` There are three possible values here:

  - *Bilateral*: Both parties to the CSA are legally entitled to request
    collateral to cover their MPOR risk exposure on the underlying
    portfolio.

  - *CallOnly*: Only we are entitled to hold collateral; the
    counterparty has no such entitlement.

  - *PostOnly*: Only the counterparty is entitled to hold collateral; we
    have no such entitlement.

- `CalculateIMAmount`: Boolean indicating whether to calculate initial
  margin from SIMM. For uncollateralised netting sets this flag will be
  ignored. This only applies to the SA-CCR calculations.  
  Allowable values: Boolean node, the set of allowable values is given
  in Table <a href="#tab:boolean_allowable" data-reference-type="ref"
  data-reference="tab:boolean_allowable">[tab:boolean_allowable]</a>.

- `CalculateVMAmount`: Boolean indicating whether to calculate variation
  margin from the netting set NPV. For uncollateralised netting sets
  this flag will be ignored. This only applies to the SA-CCR
  calculations.  
  Allowable values: Boolean node, the set of allowable values is given
  in Table <a href="#tab:boolean_allowable" data-reference-type="ref"
  data-reference="tab:boolean_allowable">[tab:boolean_allowable]</a>.
