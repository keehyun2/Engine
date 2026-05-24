### Barrier Data

This trade component node is used within the trade data containers
listed in table <a href="#tab:barrierstyles" data-reference-type="ref"
data-reference="tab:barrierstyles">1</a>. Note that not every trade type
allows for all barrier styles, the allowable combinations are listed in
table <a href="#tab:barrierstyles" data-reference-type="ref"
data-reference="tab:barrierstyles">1</a>.

<div id="tab:barrierstyles">

| Trade Data Container          | Supported Barrier Styles |
|:------------------------------|:-------------------------|
| FxBarrierOptionData           | *American*               |
| FxDigitalBarrierOptionData    | *American*               |
| FxEuropeanBarrierOptionData   | *European*               |
| FxTouchOptionData             | *American*               |
| FxDoubleTouchOptionData       | *American*               |
| FxDoubleBarrierOptionData     | *American*               |
| FxKIKOBarrierOptionData       | *American*               |
| FxTaRFData                    | *European*               |
| FxAccumulatorData             | *European, American*     |
| EquityTaRFData                | *European*               |
| EquityAccumulatorData         | *European, American*     |
| CommodityAccumulatorData      | *European, American*     |
| FxGenericBarrierOption        | *American*               |
| EquityGenericBarrierOption    | *American*               |
| CommodityGenericBarrierOption | *American*               |

Supported barrier styles per trade data container

</div>

The barrier data element is specified as in listing
<a href="#lst:barrier_data" data-reference-type="ref"
data-reference="lst:barrier_data">[lst:barrier_data]</a>

<div class="listing">

``` xml
            <BarrierData>
                <Type>UpAndIn</Type>
                <Style>American</Style>
                <Levels>
                    <Level>1.2</Level>
                </Levels>
                <Rebate>100000</Rebate>
                <RebateCurrency>USD</RebateCurrency>
                <RebatePayTime>atExpiry</RebatePayTime>
                <OverrideTriggered>true</OverrideTriggered>
            </BarrierData>
```

</div>

The meanings and allowable values of the elements in the `BarrierData`
node follow below.

- Type: Specifies barrier type. The allowable values are given in Table
  <a href="#tab:barriertype" data-reference-type="ref"
  data-reference="tab:barriertype">2</a>.

  <div id="tab:barriertype">

  | **Type**                   | **Description**                                                                                                                                                   |
  |:---------------------------|:------------------------------------------------------------------------------------------------------------------------------------------------------------------|
  | *UpAndOut*                 | The underlying price starts below the barrier level and has to move up for the option to be knocked out.                                                          |
  | *DownAndOut*               | The underlying price starts above the barrier level and has to move down for the option to become knocked out.                                                    |
  | *UpAndIn*                  | The underlying price starts below the barrier level and has to move up for the option to become activated.                                                        |
  | *DownAndIn*                | The underlying price starts above the barrier level and has to move down for the option to become activated.                                                      |
  | *KnockOut*                 | For double level only. The underlying price starts between the barrier levels and has to move up or down for the option to be knocked out.                        |
  | *KnockIn*                  | For double level only. The underlying price starts between the barrier levels and has to move up or down for the option to become activated.                      |
  | *CumulatedProfitCap*       | For TaRFs only. The instrument terminates once the generated profit reaches the CumulatedProfitCap.                                                               |
  | *CumulatedProfitCapPoints* | For TaRFs only. The instrument terminates once the generated profit divided by fixing amount and absolute value of leverage reaches the CumulatedProfitCapPoints. |
  | *FixingCap*                | For TaRFs only. The instrument terminates once the number of observations where a profit is generated reaches the FixingCap.                                      |
  | *FixingFloor*              | For Accumulators only. The first $n$ fixings are guaranteed regardless of whether the trade has been knocked out already.                                         |

  Allowable Type Values.

  </div>

- Style\[Optional\]: Specifies the monitoring style of the barrier.
  Optional, if not given, defaults to the supported barrier style (see
  table <a href="#tab:barrierstyles" data-reference-type="ref"
  data-reference="tab:barrierstyles">1</a> and if both *American* and
  *European* barriers are supported, defaults to *American*.  
  Allowable values: *American, European*.

- Level: The barrier level, defined as the amount in sold (domestic)
  currency per unit bought (foreign) currency. Double barrier
  instruments can have two `Level` elements, and these must be in
  ascending order.  
  Allowable values: Any positive real number.

- Rebate\[Optional\]: The barrier rebate is a fixed amount, expressed in
  domestic / sold currency paid out to the option holder if a barrier
  option expires inactive, i.e. it is not knocked in/out. Note that
  `Rebate` is supported for

  - FxBarrierOptionData

  - FxDigitalBarrierOptionData

  - FxDoubleBarrierOptionData

  - FxEuropeanBarrierOptionData

  - FxGenericBarrierOptionData

  - EquityGenericBarrierOptionData

  - CommodityGenericBarrierOptionData

  only. If defined for several “in” barriers, the amounts must be
  identical across all barrier definitions (because the rebate amount is
  paid if none of the “in” barrier is touched and can therefore not
  depend on the particular barrier). Also, the RebatePayTime must be
  *atExpiry* for “in” barriers obviously.  
  Allowable values: Any positive real number. Defaults to zero if
  omitted. Cannot be left blank.

- RebateCurrency \[Optional\]: The currency in which the rebate amount
  is paid. Defaults to the natural pay currency of the trade. Deviating
  currencies are supported by the following trade types only:

  - FxGenericBarrierOptionData

  - EquityGenericBarrierOptionData

  - CommodityGenericBarrierOptionData

  Allowable Values: See Table
  <a href="#tab:currency" data-reference-type="ref"
  data-reference="tab:currency">[tab:currency]</a> `Currency`.

- RebatePayTime \[Optional\]: For “in” barriers only atExpiry is
  allowed. For “out” barriers, both atExpiry and atHit is possible. If
  not given, defaults to “atExpiry”. This field is only supported by the
  following trade types:

  - FxGenericBarrierOptionData

  - EquityGenericBarrierOptionData

  - CommodityGenericBarrierOptionData

  Allowable Values: *atExpiry*, *atHit*

- StrictComparison \[Optional\]: Determines how the barrier is checked,
  as per:

  *0*: the barrier checks use $<=$, $>=$ to check In-barriers and $<$,
  $>$ to check Out-barriers.

  *1*: the barrier checks use strict comparison $<$ and $>$ for both In-
  and Out-barriers.

  *2*: the barrier checks use strict or equal comparison $<=$ and $>=$
  for both In- and Out-barriers.

  Allowable Values: *0*, *1*, or *2*. Defaults to *0* if omitted.

- OverrideTriggered \[Optional\]: Specifies whether a barrier was
  triggered before the valuation date. If given, this overrides the
  automatic check using fixing data.

  Allowable Values: *true*, *false*
