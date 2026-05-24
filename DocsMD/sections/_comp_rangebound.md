### RangeBound

This trade component node is used within the following trade data
containers

- FxTaRFfData, EquityTaRFData, CommodityTaRFData

- FxAccumulatorData, EquityAccumulatorData, CommodityAccumulatorData

An example structure of the `RangeBound` trade component node is shown
in Listing <a href="#lst:rangebound" data-reference-type="ref"
data-reference="lst:rangebound">[lst:rangebound]</a>.

<div class="listing">

``` xml
        <RangeBound>
          <RangeFrom>0</RangeFrom>
          <RangeTo>155.00</RangeTo>
          <Leverage>2</Leverage>
          <Strike>150.54</Strike>
        </RangeBound>
```

</div>

The meanings and allowable values of the elements in the `RangeBound`
node follow below.

- RangeFrom \[Optional\]: The lower bound of the range.

  Allowable values: Any real number. If omitted, no lower bound applies.
  Cannot be left blank.

- RangeTo \[Optional\]: The upper bound of the range.

  Allowable values: Any real number. If omitted, no lower bound applies.
  Cannot be left blank.

- Leverage \[Optional\]: The leverage that applies to the range. For
  TaRFs, negative leverage can be mixed with positive leverage to
  reflect a TaRF with switching buyer/seller. However, for Accumulators
  all given Leverage parameters within the same instrument (in multiple
  `RangeBound` nodes) must have the same sign.

  Allowable values: Any real number. Defaults to 1 if omitted. Cannot be
  left blank.

- Strike \[Optional\]: The strike specific to the range. If given
  overwrites a strike given on the trade level.

  Allowable values: Any real number. Defaults to the trade level strike
  if omitted. Cannot be left blank.

- StrikeAdjustment \[Optional\]: A strike adjustment relative to the
  strike given on the trade level. If given the strike for the defined
  range is computed as $K+A$ where $K$ is the strike on the trade level
  and $A$ is the strike adjustment. Notice that Strike and
  StrikeAdjustment can not be given both at the same time.

  Allowable values: Any real number.
