# Counterparty Information

The counterparty information file - `counterparty.xml` - contains a list
of counterparty-level details. The file is written in XML format, with a
top-level `CounterpartyInformation` node consisting of two children
nodes: `Counterparties` and `Correlations`.

## Counterparties

The `Counterparties` node is used to define inputs for each counterparty
in the calculations. Each counterparty is then defined with its own
`Counterparty` node, with the following XML template:

<div class="listing">

``` xml
    <Counterparties>
        <Counterparty>
            <CounterpartyId> </CounterpartyId>
            <CreditQuality>IG</CreditQuality>
            <BaCvaRiskWeight> </BaCvaRiskWeight>
            <SaCcrRiskWeight> </SaCcrRiskWeight>
            <SaCvaRiskBucket> </SaCvaRiskBucket>
        </Counterparty>
        <Counterparty>
            .......
        </Counterparty>
    </Counterparties>
```

</div>

The meanings of the various elements of the `Counterparty` node are as
follows (default input values for certain analytics are specified in
their own respective sections, otherwise the defaults below are
applicable):

- `CounterpartyId`: The unique identifier for the counterparty.  
  Allowable values: Any string.

- `ClearingCounterparty` \[Optional\]: Whether the counterparty is a
  clearing counterparty.  
  Allowable values: Boolean node, allowing *Y*, *N*, *1*, *0*, *true*,
  *false*, etc. The full set of allowable values is given in Table
  <a href="#tab:boolean_allowable" data-reference-type="ref"
  data-reference="tab:boolean_allowable">[tab:boolean_allowable]</a>. If
  left blank or omitted, defaults to *False*.

- `CreditQuality` \[Optional\]: Credit quality/rating.  
  Allowable values: *HY* (high yield), *IG* (investment grade), *NR*
  (not rated). Defaults to *NR* if left blank or omitted.

- `BaCvaRiskWeight` \[Optional\]: BA-CVA supervisory risk weight based
  on sector and credit quality. This field is only used when calculating
  BA-CVA or SA-CVA.  
  Allowable values: Any number. If left blank or omitted, defaults to
  zero.

- `SaCcrRiskWeight` \[Optional\]: SA-CCR supervisory risk weight based
  on sector and credit quality. This field is only used when calculating
  SA-CCR or BA-CVA (which itself calculates SA-CCR).  
  Allowable values: Any number. If left blank or omitted, defaults to
  *1.0*.

- `SaCvaRiskBucket` \[Optional\]: SA-CVA delta risk buckets for
  counterparty credit spread.  
  Allowable values: Any integer from *1* to *8* (inclusive).

## Correlations

The `Correlations` node is used to define counterparty correlations
which are used for calculating correlations between counterparty credit
risk factor, with the following XML template:

<div class="listing">

``` xml
    <Correlations>
        <Correlation cpty1="CPTY_A" cpty2="CPTY_B">0.5</Correlation>
        <Correlation cpty1="CPTY_B" cpty2="CPTY_C">0.5</Correlation>
        ....
    </Correlations>
```

</div>
