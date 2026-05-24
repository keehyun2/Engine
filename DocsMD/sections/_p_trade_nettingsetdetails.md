# Netting Set Details

Instead of a single netting set ID, defined by a `NettingSetId` node, an
alternative `NettingSetDetails` node can be provided, which itself
contains a `NettingSetId` sub-node, and four other optional sub-nodes,
which altogether allow for extending the uniqueness of netting sets
beyond the netting set ID. The allowable values for each sub-node are
any alphanumeric string. The underscore (‘\_’) sign may be used as well.

The `NettingSetDetails` node is given in the following XML format:

<div class="listing">

``` xml
    <NettingSetDetails>
        <NettingSetId> </NettingSetId>
        <AgreementType> </AgreementType>
        <CallType> </CallType>
        <InitialMarginType> </InitialMarginType>
        <LegalEntityId> </LegalEntityId>
    </NettingSetDetails>
```

</div>
