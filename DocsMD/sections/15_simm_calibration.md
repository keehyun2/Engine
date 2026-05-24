## SIMM Calibration: `simmcalibration.xml`

The SIMM Calibration can be used to add or override SIMM versions by
specifying the risk weights, correlations, concentration thresholds
along with associated buckets/labels and currency groups (for risk class
FX and IR).

See Example_44 for a full SIMM calibration file for SIMM 2.5A . The
official configuration files for each version (SIMM 2.2 and greater) can
be found in folder `Configurations/SIMM/`

The file consists of a `<SIMMCalibrationData>` node, with
`<SIMMCalibration>` subnodes that each define a given SIMM version, as
in Listing <a href="#lst:simmcalibration_data" data-reference-type="ref"
data-reference="lst:simmcalibration_data">[lst:simmcalibration_data]</a>
below.

<div class="listing">

``` xml
<SIMMCalibrationData>
  <SIMMCalibration id="official">
    <VersionNames>
      <Name>2.6</Name>
      <Name>2.5.6</Name>
    </VersionNames>
    <AdditionalFields>
      <SIMM_EffectiveDate>2023-12-02</SIMM_EffectiveDate>
    </AdditionalFields>
    <InterestRate>
      <RiskWeights>
        ......
      </RiskWeights>
      <Correlations>
        ......
      </Correlations>
      <ConcentrationThresholds>
        ......
      </ConcentrationThresholds>
    </InterestRate>
    <CreditQualifying>
      ......
    </CreditQualifying>
    <CreditNonQualifying>
      ......
    </CreditNonQualifying>
    <Equity>
      ......
    </Equity>
    <Commodity>
      ......
    </Commodity>
    <FX>
      ......
    </FX>
    <RiskClassCorrelations>
      ......
    </RiskClassCorrelations>
  </SIMMCalibration>
  <SIMMCalibration id="next">
    ......
  </SIMMCalibration>
</SIMMCalibrationData>
```

</div>

### SIMM Calibration

A SIMM Calibration is defined by a `<SIMMCalibration>` node that defines
a particular SIMM version, i.e. it defines a single set of risk weights,
correlations, concentration thresholds and currency groups. The
`<SIMMCalibration>` has the following components:

1.  Version names - `<VersionNames>`  
    This may contain any number of `<Name>` sub-nodes, where each value
    will be associated with the given SIMM calibration. In order to use
    a given calibration, one of its names must be specified in the
    “version” parameter of the SIMM analytic (see Listing
    <a href="#lst:ore_simm" data-reference-type="ref"
    data-reference="lst:ore_simm">[lst:ore_simm]</a>). In the example
    listing
    <a href="#lst:simmcalibration_data" data-reference-type="ref"
    data-reference="lst:simmcalibration_data">[lst:simmcalibration_data]</a>
    above, the SIMM calibration will override the original SIMM
    2.5.6/2.6 defined in the source code.

2.  Additional fields - `<AdditionalFields>`  
    This node is used for purely descriptive purposes and can contain
    any subnode.

3.  Risk-class-specific sub-nodes:

    - `<InterestRate>`

    - `<CreditQualifying>`

    - `<CreditNonQualifying>`

    - `<Equity>`

    - `<Commodity>`

    - `<FX>`

4.  Risk class correlations - `<RiskClassCorrelations>`

The risk class correlations and its subcomponents are given in Listing
<a href="#lst:simmcalibration_risk_class_correlations"
data-reference-type="ref"
data-reference="lst:simmcalibration_risk_class_correlations">[lst:simmcalibration_risk_class_correlations]</a>:

<div class="listing">

``` xml
<RiskClassCorrelations>
  <Correlation label1="InterestRate" label2="FX">0.14</Correlation>
  <Correlation label1="InterestRate" label2="Equity">0.29</Correlation>
  <Correlation label1="InterestRate" label2="CreditQualifying">0.27</Correlation>
  <Correlation label1="InterestRate" label2="CreditNonQualifying">0.26</Correlation>
  <Correlation label1="InterestRate" label2="Commodity">0.31</Correlation>
  <Correlation label1="FX" label2="InterestRate">0.14</Correlation>
  <Correlation label1="FX" label2="Equity">0.25</Correlation>
  <Correlation label1="FX" label2="CreditQualifying">0.25</Correlation>
  <Correlation label1="FX" label2="CreditNonQualifying">0.14</Correlation>
  <Correlation label1="FX" label2="Commodity">0.3</Correlation>
  <Correlation label1="Equity" label2="InterestRate">0.29</Correlation>
    .......
</RiskClassCorrelations>
```

</div>

Each correlation value is given by a `<Correlation>` node with
attributes `label1` and `label2` to specify the risk classes to which it
applies.

Since the risk-class-specific components have many sub-nodes in common,
the following section will be a description of the general ‘base’
structure, and then a section will be given for each risk class to
explain its specific XML structure along with any components unique to
that risk class. We will also make reference to the corresponding
sections in the ISDA SIMM Methodology .

### General Structure

All risk class subnodes (i.e. `InterestRate`, `CreditQualifying`, etc.)
in the SIMM calibration will contain the following three components:

1.  `<RiskWeights>`

2.  `<Correlations>`

3.  `<ConcentrationThresholds>`

The general structure is given by Listing
<a href="#lst:simmcalibration_general_structure"
data-reference-type="ref"
data-reference="lst:simmcalibration_general_structure">[lst:simmcalibration_general_structure]</a>.
Note that `<HistoricalVolatilityRatio>` only applies to InterestRate,
Equity, Commodity and FX, and `<CurrencyLists>` only applies to
InterestRate and FX.

<div class="listing">

``` xml
<RiskWeights>
  <Delta mporDays="10">
      ....
  </Delta>
  <Vega mporDays="10">
      ....
  </Vega>
  <HistoricalVolatilityRatio mporDays="10">...</HistoricalVolatilityRatio>
</RiskWeights>
<Correlations>
  <IntraBucketCorrelation>
      ....
  </IntraBucketCorrelation>
  <InterBucketCorrelation>
      ....
  </InterBucketCorrelation>
</Correlations>
<ConcentrationThresholds>
  <Delta>
      ....
  </Delta>
  <Vega>
      ....
  </Vega>
  <CurrencyLists>
      ....
  </CurrencyLists>
</ConcentrationThresholds>
```

</div>

The structure of the `<RiskWeights>` node is given by Listing
<a href="#lst:simmcalibration_risk_weights" data-reference-type="ref"
data-reference="lst:simmcalibration_risk_weights">[lst:simmcalibration_risk_weights]</a>.
Every top-level node in `<RiskWeights>` should have an `<mporDays>`
attribute (which defaults to *“10”* when omitted).

<div class="listing">

``` xml
<RiskWeights>
  <Delta mporDays="10">
    <!-- e.g. for IR -->
    <Weight bucket="1" label1="2w">109</Weight>
    <Weight bucket="1" label1="1m">105</Weight>

    <!-- e.g. for CreditQualifying/CreditNonQualifying/Equity/Commodity -->
    <Weight bucket="1">75</Weight>
    <Weight bucket="2">90</Weight>

    <!-- e.g. for FX -->
    <Weight label1="2" label2="2">7.4</Weight>
    <Weight label1="2" label2="1">14.7</Weight>
  </Delta>
  <HistoricalVolatilityRatio mporDays="10">0.47</HistoricalVolatilityRatio>
  <Vega mporDays="10">
    <!-- e.g. for IR/CreditQualifying/Commodity/FX -->
    <Weight>0.76</Weight>

    <!-- e.g. for CreditNonQualifying/Equity -->
    <Weight bucket="1">280</Weight>
    <Weight bucket="2">1300</Weight>
  </Vega>
</RiskWeights>
```

</div>

The structure of the `<Correlations>` node is given by Listing
<a href="#lst:simmcalibration_correlations" data-reference-type="ref"
data-reference="lst:simmcalibration_correlations">[lst:simmcalibration_correlations]</a>.

<div class="listing">

``` xml
<Correlations>
  <IntraBucketCorrelation>
    <!-- e.g. for IR -->
    <Correlation label1="2w" label2="1m">0.77</Correlation>
    <Correlation label1="2w" label2="3m">0.67</Correlation>

    <!-- e.g. for CreditQualifying/CreditNonQualifying -->
    <Correlation label1="aggregate" label2="same">0.93</Correlation>
    <Correlation label1="aggregate" label2="different">0.46</Correlation>

    <!-- e.g. for Equity/Commodity -->
    <Correlation bucket="1">0.18</Correlation>
    <Correlation bucket="2">0.2</Correlation>

    <!-- e.g. for FX -->
    <Correlation bucket="2" label1="2" label2="2">0.5</Correlation>
    <Correlation bucket="2" label1="2" label2="1">0.25</Correlation>
  </IntraBucketCorrelation>
  <InterBucketCorrelation>
    <!-- e.g. for CreditQualifying/CreditNonQualifying/Equity/Commodity -->
    <Correlation label1="1" label2="2">0.38</Correlation>
    <Correlation label1="1" label2="3">0.38</Correlation>
  </InterBucketCorrelation>
</Correlations>
```

</div>

The structure of the `<ConcentrationThresholds>` node is given by
Listing <a href="#lst:simmcalibration_concentration_thresholds"
data-reference-type="ref"
data-reference="lst:simmcalibration_concentration_thresholds">[lst:simmcalibration_concentration_thresholds]</a>.

<div class="listing">

``` xml
<ConcentrationThresholds>
  <Delta>
    <!-- e.g. for IR/CreditQualifying/CreditNonQualifying/Equity/Commodity/FX -->
    <Threshold bucket="1">30</Threshold>
    <Threshold bucket="2">330</Threshold>
  </Delta>
  <Vega>
    <!-- e.g. for IR -->
    <Threshold bucket="1">74</Threshold>
    <Threshold bucket="2">4900</Threshold>

    <!-- e.g. for CreditQualifying/CreditNonQualifying/Equity/Commodity/FX -->
    <Threshold>360</Threshold>
  </Vega>
</ConcentrationThresholds>
```

</div>

### Interest Rate

The structure for the `<InterestRate>` node is given by Listing
<a href="#lst:simmcalibration_ir" data-reference-type="ref"
data-reference="lst:simmcalibration_ir">[lst:simmcalibration_ir]</a>.

<div class="listing">

``` xml
<InterestRate>
  <RiskWeights>
    <Delta mporDays="10">...</Delta>
    <Vega mporDays="10">...</Vega>
    <HistoricalVolatilityRatio mporDays="10">0.47</HistoricalVolatilityRatio>
    <Inflation mporDays="10">61</Inflation>
    <XCcyBasis mporDays="10">21</XCcyBasis>
    <CurrencyLists>
      <Currency bucket="1">USD</Currency>
        ....
      <Currency bucket="3">Other</Currency>
    </CurrencyLists>
  </RiskWeights>
  <Correlations>
    <IntraBucket>...</IntraBucket>
    <SubCurves>0.993</SubCurves>
    <Inflation>0.24</Inflation>
    <XCcyBasis>0.04</XCcyBasis>
    <Outer>0.32</Outer>
  </Correlations>
  <ConcentrationThresholds>
    <Delta>...</Delta>
    <Vega>...</Vega>
    <CurrencyLists>
      <Currency bucket="1">Other</Currency>
      <Currency bucket="2">USD</Currency>
        ....
    </CurrencyLists>
  </ConcentrationThresholds>
</InterestRate>
```

</div>

The above values are found in the following sections of the ISDA SIMM
Methodology :

- Delta risk weights: Section D.1, 33.  
  Each `<Weight>` node must have a `bucket` (defining the currency
  group) and `label1` (defining the tenor) attribute.  
  Allowable `bucket` values: *“1”* for regular volatility currencies,
  *“2”* for low-volatility currencies, and *“3”* for high-volatility
  currencies.  
  Allowable `label1` values: *“2w”, “1m”, “3m”, “6m”, “1y”, “2y”, “3y”,
  “5y”, “10y”, “15y”, “20y”, “30y"*.

- Vega risk weight: Section D.1, 35.  
  There should only be one `<Weight>` node, and no attributes are
  required.

- Historical volatility ratio (HVR): Section D.1 34.  
  There should only be one `<HistoricalVolatilityRatio>` node, and the
  only attributed needed is `mporDays` (which defaults to *“10”* if
  omitted).

- Inflation risk weight: Section D.1, 33.  
  There should only be one `<Weight>` node, and the only attributed
  needed is `mporDays` (which defaults to *“10”* if omitted).

- Risk weight for cross-currency basis swap spread (`<XCcyBasis>`):
  Section D.1, 33  
  There should only be one `<Weight>` node, and the only attributed
  needed is `mporDays` (which defaults to *“10”* if omitted).

- Currency groups for risk weights (`<CurrencyLists>`): Section D.1
  33(1) to (3).  
  Each `<Currency>` must have a `bucket` attribute associating it with a
  currency volatility group.

- Intra-bucket correlations: Section D.2, 36.  
  Each `<Correlation>` must have a `label1` and `label2` attribute. Note
  that although the correlations are symmetric, the correlation value
  for both directions must be provided.

- Correlation between sub-curves: Section D.2, 36.

- Correlation for inflation rate: Section D.2, 36.

- Correlation for Cross-currency basis swap spread (`XCcyBasis`):
  Section D.2, 36.

- Correlation across different currencies (`<Outer>`): Section D.2, 37.

- Delta concentration thresholds: Section J.1, 74  
  Each `<Threshold>` must have a `bucket` attribute associating it with
  a currency group.  
  Allowable `bucket` values: *“1”* for high volatility, *“2”* for
  regular volatility, well-traded, *“3”* for regular volatility,
  less-traded, and *“4”* for low volatility.

- Vega concentration thresholds: Section J.6, 81.  
  Each `<Threshold>` must have a `bucket` attribute associating it with
  a currency group.  
  Allowable `bucket` values: *“1”* for high volatility, *“2”* for
  regular volatility, well-traded, *“3”* for regular volatility,
  less-traded, and *“4”* for low volatility.

- Concentration threshold currency groups (`CurrencyLists`): Section
  J.1, 75.  
  Each `<Currency>` must have a `bucket` attribute associating it with a
  currency group.  
  Allowable `bucket` values: *“1”* for high volatility, *“2”* for
  regular volatility, well-traded, *“3”* for regular volatility,
  less-traded, and *“4”* for low volatility.

### Credit Qualifying

The structure for the `<CreditQualifying>` node is given by Listing
<a href="#lst:simmcalibration_creditq" data-reference-type="ref"
data-reference="lst:simmcalibration_creditq">[lst:simmcalibration_creditq]</a>.

<div class="listing">

``` xml
<CreditQualifying>
  <RiskWeights>
    <Delta mporDays="10">...</Delta>
    <Vega mporDays="10">...</Vega>
    <BaseCorrelation mporDays="10">10</BaseCorrelation>
  </RiskWeights>
  <Correlations>
    <IntraBucket>...</IntraBucket>
    <InterBucket>...</InterBucket>
    <BaseCorrelation>...</BaseCorrelation>
  </Correlations>
  <ConcentrationThresholds>
    <Delta>...</Delta>
    <Vega>...</Vega>
  </ConcentrationThresholds>
</CreditQualifying>
```

</div>

The above values are found in the following sections of the ISDA SIMM
Methodology :

- Delta risk weights: Section E.1, 39.  
  Each `<Weight>` node must have a `bucket` attribute.  
  Allowable `bucket` values: *“1”, “2”, “3”, “4”, “5”, “6”, “7”, “8”,
  “9”, “10”, “11”, “12”, “Residual”*, as defined in Section E.1, 38.

- Vega risk weight: Section E.1, 40.  
  There should only be one `<Weight>` node, and no attributes are
  required.

- Base correlation risk: Section E.1 41.

- Intra-bucket correlations: Section E.2, 42.  
  Each `<Correlation>` must have a `label1` and `label2` attribute.  
  Allowable `label1` values: *aggregate* or *residual*.  
  Allowable `label2` values: *same* or *different*.

- Inter-bucket correlations: Section E.2, 43.  
  Each `<Correlation>` must have a `label1` and `label2` attribute. Note
  that although the correlations are symmetric, the correlation value
  for both directions must be provided.  
  Allowable `label1`/`label2` values: *“1”, “2”, “3”, “4”, “5”, “6”,
  “7”, “8”, “9”, “10”, “11”, “12”*, as defined in Section E.1, 38.

- Correlation for Base correlation risks: Section E.2, 42.

- Delta concentration thresholds: Section J.2, 76  
  Each `<Threshold>` must have a `bucket` attribute.  
  Allowable `bucket` values: *“1”, “2”, “3”, “4”, “5”, “6”, “7”, “8”,
  “9”, “10”, “11”, “12”, “Residual”*, as defined in Section E.1, 38.

- Vega concentration threshold: Section J.7, 83.  
  There should only be one `<Threshold>`, and no attributes are
  required.

### Credit Non-Qualifying

The structure for the `<CreditNonQualifying>` node is given by Listing
<a href="#lst:simmcalibration_creditnonq" data-reference-type="ref"
data-reference="lst:simmcalibration_creditnonq">[lst:simmcalibration_creditnonq]</a>.

<div class="listing">

``` xml
<CreditNonQualifying>
  <RiskWeights>
    <Delta mporDays="10">...</Delta>
    <Vega mporDays="10">...</Vega>
  </RiskWeights>
  <Correlations>
    <IntraBucket>...</IntraBucket>
    <InterBucket>...</InterBucket>
  </Correlations>
  <ConcentrationThresholds>
    <Delta>...</Delta>
    <Vega>...</Vega>
  </ConcentrationThresholds>
</CreditNonQualifying>
```

</div>

The above values are found in the following sections of the ISDA SIMM
Methodology :

- Delta risk weights: Section F.1, 46.  
  Each `<Weight>` node must have a `bucket` attribute.  
  Allowable `bucket` values: *“1”, “2”, “Residual”*, as defined in
  Section F.1, 45.

- Vega risk weight: Section F.1, 47.  
  There should only be one `<Weight>` node, and no attributes are
  required.

- Intra-bucket correlations: Section F.2, 48.  
  Each `<Correlation>` must have a `label1` and `label2` attribute.  
  Allowable `label1` values: *aggregate* or *residual*.  
  Allowable `label2` values: *same* or *different*.

- Inter-bucket correlations: Section F.2, 49.  
  Each `<Correlation>` must have a `label1` and `label2` attribute. Note
  that although the correlations are symmetric, the correlation value
  for both directions must be provided.  
  Allowable `label1`/`label2` values: *“1”, “2”*, as defined in Section
  F.1, 45.

- Delta concentration thresholds: Section J.2, 76  
  Each `<Threshold>` must have a `bucket` attribute.  
  Allowable `bucket` values: *“1”, “2”, “Residual”*, as defined in
  Section F.1, 45.

- Vega concentration threshold: Section J.7, 83.  
  There should only be one `<Threshold>`, and no attributes are
  required.

### Equity

The structure for the `<Equity>` node is given by Listing
<a href="#lst:simmcalibration_equity" data-reference-type="ref"
data-reference="lst:simmcalibration_equity">[lst:simmcalibration_equity]</a>.

<div class="listing">

``` xml
<Equity>
  <RiskWeights>
    <Delta mporDays="10">...</Delta>
    <Vega mporDays="10">...</Vega>
    <HistoricalVolatilityRatio mporDays="10">0.6</HistoricalVolatilityRatio>
  </RiskWeights>
  <Correlations>
    <IntraBucket>...</IntraBucket>
    <InterBucket>...</InterBucket>
  </Correlations>
  <ConcentrationThresholds>
    <Delta>...</Delta>
    <Vega>...</Vega>
  </ConcentrationThresholds>
</Equity>
```

</div>

The above values are found in the following sections of the ISDA SIMM
Methodology :

- Delta risk weights: Section G.1, 56.  
  Each `<Weight>` node must have a `bucket` attribute.  
  Allowable `bucket` values: *“1”, “2”, “3”, “4”, “5”, “6”, “7”, “8”,
  “9”, “10”, “11”, “12”, “Residual”*, as defined in Section G.1, 50.

- Vega risk weight: Section G.1, 58.  
  Each `<Weight>` node must have a `bucket` attribute.  
  Allowable `bucket` values: *“1”, “2”, “3”, “4”, “5”, “6”, “7”, “8”,
  “9”, “10”, “11”, “12”, “Residual”*, as defined in Section G.1, 50.

- Historical volatility ratio (HVR): Section G.1 57.  
  There should only be one `<HistoricalVolatilityRatio>` node, and the
  only attributed needed is `mporDays` (which defaults to *“10”* if
  omitted).

- Intra-bucket correlations: Section G.2, 59.  
  Each `<Correlation>` must have a `bucket` attribute. Allowable
  `bucket` values: *“1”, “2”, “3”, “4”, “5”, “6”, “7”, “8”, “9”, “10”,
  “11”, “12”, “Residual”*, as defined in Section G.1, 50.

- Inter-bucket correlations: Section G.2, 60.  
  Each `<Correlation>` must have a `label1` and `label2` attribute. Note
  that although the correlations are symmetric, the correlation value
  for both directions must be provided.  
  Allowable `label1`/`label2` values: *“1”, “2”, “3”, “4”, “5”, “6”,
  “7”, “8”, “9”, “10”, “11”, “12”*, as defined in Section G.1, 50.

- Delta concentration thresholds: Section J.3, 77  
  Each `<Threshold>` must have a `bucket` attribute.  
  Allowable `bucket` values: *“1”, “2”, “3”, “4”, “5”, “6”, “7”, “8”,
  “9”, “10”, “11”, “12”, “Residual”*, as defined in Section G.1, 50.

- Vega concentration thresholds: Section J.8, 84.  
  Each `<Threshold>` must have a `bucket` attribute.  
  Allowable `bucket` values: *“1”, “2”, “3”, “4”, “5”, “6”, “7”, “8”,
  “9”, “10”, “11”, “12”, “Residual”*, as defined in Section G.1, 50.

### Commodity

The structure for the `<Commodity>` node is given by Listing
<a href="#lst:simmcalibration_commodity" data-reference-type="ref"
data-reference="lst:simmcalibration_commodity">[lst:simmcalibration_commodity]</a>.

<div class="listing">

``` xml
<Commodity>
  <RiskWeights>
    <Delta mporDays="10">...</Delta>
    <Vega mporDays="10">...</Vega>
    <HistoricalVolatilityRatio mporDays="10">0.74</HistoricalVolatilityRatio>
  </RiskWeights>
  <Correlations>
    <IntraBucket>...</IntraBucket>
    <InterBucket>...</InterBucket>
  </Correlations>
  <ConcentrationThresholds>
    <Delta>...</Delta>
    <Vega>...</Vega>
  </ConcentrationThresholds>
</Commodity>
```

</div>

The above values are found in the following sections of the ISDA SIMM
Methodology :

- Delta risk weights: Section H.1, 61.  
  Each `<Weight>` node must have a `bucket` attribute.  
  Allowable `bucket` values: *“1”, “2”, “3”, “4”, “5”, “6”, “7”, “8”,
  “9”, “10”, “11”, “12”, “13”, “14”, “15”, “16”, “17”*, as defined in
  Section H.1, 61.

- Vega risk weight: Section H.1, 63.  
  There should only be one `<Weight>` node, and no attributes are
  required.

- Historical volatility ratio (HVR): Section H.1 62.  
  There should only be one `<HistoricalVolatilityRatio>` node, and the
  only attributed needed is `mporDays` (which defaults to *“10”* if
  omitted).

- Intra-bucket correlations: Section H.2, 64.  
  Each `<Correlation>` must have a `bucket` attribute.  
  Allowable `bucket` values: *“1”, “2”, “3”, “4”, “5”, “6”, “7”, “8”,
  “9”, “10”, “11”, “12”, “13”, “14”, “15”, “16”, “17”*, as defined in
  Section H.1, 61.

- Inter-bucket correlations: Section H.2, 65.  
  Each `<Correlation>` must have a `label1` and `label2` attribute. Note
  that although the correlations are symmetric, the correlation value
  for both directions must be provided.  
  Allowable `label1`/`label2` values: *“1”, “2”, “3”, “4”, “5”, “6”,
  “7”, “8”, “9”, “10”, “11”, “12”, “13”, “14”, “15”, “16”, “17”*, as
  defined in Section H.1, 61.

- Delta concentration thresholds: Section J.4, 78.  
  Each `<Threshold>` must have a `bucket` attribute.  
  Allowable `bucket` values: *“1”, “2”, “3”, “4”, “5”, “6”, “7”, “8”,
  “9”, “10”, “11”, “12”, “13”, “14”, “15”, “16”, “17”*, as defined in
  Section H.1, 61.

- Vega concentration thresholds: Section J.9, 85.  
  Each `<Threshold>` must have a `bucket` attribute.  
  Allowable `bucket` values: *“1”, “2”, “3”, “4”, “5”, “6”, “7”, “8”,
  “9”, “10”, “11”, “12”, “13”, “14”, “15”, “16”, “17”*, as defined in
  Section H.1, 61.

### FX

The structure for the `<FX>` node is given by Listing
<a href="#lst:simmcalibration_fx" data-reference-type="ref"
data-reference="lst:simmcalibration_fx">[lst:simmcalibration_fx]</a>.

<div class="listing">

``` xml
<FX>
  <RiskWeights>
    <Delta mporDays="10">...</Delta>
    <Vega mporDays="10">...</Vega>
    <HistoricalVolatilityRatio mporDays="10">0.57</HistoricalVolatilityRatio>
    <CurrencyLists>
      <Currency bucket="2">Other</Currency>
      <Currency bucket="1">BRL</Currency>
      <Currency bucket="1">TRY</Currency>
      <Currency bucket="1">RUB</Currency>
    </CurrencyLists>
  </RiskWeights>
  <Correlations>
    <IntraBucket>...</IntraBucket>
    <Volatility>0.5</Volatility>
  </Correlations>
  <ConcentrationThresholds>
    <Delta>...</Delta>
    <Vega>...</Vega>
    <CurrencyLists>
      <Currency bucket="1">USD</Currency>
      <Currency bucket="1">EUR</Currency>
        ....
      <Currency bucket="3">Other</Currency>
    </CurrencyLists>
  </ConcentrationThresholds>
</FX>
```

</div>

The above values are found in the following sections of the ISDA SIMM
Methodology :

- Delta risk weights: Section I.1, 69.  
  Each `<Weight>` node must have a `label1` (defining the first
  currency’s volatility group) and `label2` (defining the second
  currency’s volatility group) attribute.  
  Allowable `label1`/`label2` values: *“1”* for high FX volatility
  currencies and *“2”* for regular FX volatility currencies.

- Vega risk weight: Section I.1, 71.  
  There should only be one `<Weight>` node, and no attributes are
  required.

- Historical volatility ratio (HVR): Section I.1 70.  
  There should only be one `<HistoricalVolatilityRatio>` node, and the
  only attributed needed is `mporDays` (which defaults to *“10”* if
  omitted).

- Currency groups for risk weights (`<CurrencyLists>`): Section I.1 67.
  and 68.  
  Each `<Currency>` must have a `bucket` attribute associating it with a
  currency volatility group.  
  Allowable `bucket` values: Allowable `label1`/`label2` values: *“1”*
  for high FX volatility currencies and *“2”* for regular FX volatility
  currencies.

- Intra-bucket correlations: Section I.2, 72.  
  Each `<Correlation>` must have a `label1` and `label2` attribute. Note
  that although the correlations are symmetric, the correlation value
  for both directions must be provided.  
  Allowable `bucket` values: *“1”* if the SIMM calculation currency is
  in the regular FX volatility group, and *“2”* if it is in the high FX
  volatility group.  
  Allowable `label1`/`label2` values: *“1”* for high FX volatility
  currencies and *“2”* for regular FX volatility currencies.

- Correlation between FX volatility and curvature risk factors
  (`<Volatility>`): Section I.2. 73

- Delta concentration thresholds: Section J.5, 79  
  Each `<Threshold>` must have a `bucket` attribute associating it with
  a currency risk group.  
  Allowable `bucket` values: *“1”, “2”, “3”*.

- Vega concentration thresholds: Section J.10, 86.  
  Each `<Threshold>` must have a `bucket` attribute associating it with
  a currency group.  
  Allowable `bucket` values: *“1”* for “Category 1 - Category 1”, *“2”*
  for “Category 1 - Category 2”, *“3”* for “Category 1 - Category 3”,
  *“4”* for “Category 2 - Category 2”, *“5”* for “Category 2 - Category
  3”, and *“6”* for “Category 3 - Category 3”.

- Concentration threshold currency groups (`CurrencyLists`): Section
  J.5, 80.  
  Each `<Currency>` must have a `bucket` attribute associating it with a
  currency risk group.  
  Allowable `bucket` values: *“1”* for “Category 1 - Significantly
  material”, *“2”* for “Category 2 - Frequently traded”, and *“3”* for
  “Category 3 - Others”.
