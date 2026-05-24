### Knock Out Swap

A Knock Out Swap refers to a vanilla fixed vs. float Interest Rate Swap
that terminates when the float index fixing is above (“up and out”) or
below (“down and out”) a given barrier level.

A Knock Out Swap is represented using the TradeType *KnockOutSwap* and a
KnockOutSwapData block as shown in listing
<a href="#lst:knock_out_swap" data-reference-type="ref"
data-reference="lst:knock_out_swap">[lst:knock_out_swap]</a>. It must
have one `BarrierData` node, and two legs, one fixed and one floating,
each represented by a `LegData` trade component.

A Knock Out Swap is a Swap with one Fixed and one Floating leg, where
the Swap is terminated if the Floating leg Index hits a barrier. The
barrier is monitored on all floating leg fixing dates after the
BarrierStartDate.

The meanings and allowable values in this block are as follows:

- BarrierData: This node specifies the barrier components. All other
  values of the barrier data block are not relevant.  
  See <a href="#ss:barrier_data" data-reference-type="ref"
  data-reference="ss:barrier_data">[ss:barrier_data]</a>.

  - Type: The barrier type (allowed values are *UpAndOut*, *DownAndOut*)

  - Levels: Exactly one barrier level must be given.

  - StrictComparison \[Optional\]: *0*, *1*. Defaults to *0*. Determines
    how the barrier is checked as per:

    *0*: the barrier checks use $<=$, $>=$ to check Out-barriers.

    *1*: the barrier checks use strict comparison $<$ and $>$ for
    Out-barriers.

- BarrierStartDate: The barrier is monitored on all floating leg fixing
  dates that are on or after the barrier start date.  
  Allowable values: See `Date` in Table
  <a href="#tab:allow_stand_data" data-reference-type="ref"
  data-reference="tab:allow_stand_data">[tab:allow_stand_data]</a>.

- LegData: This specifies the swap terms. Exactly two LegData nodes must
  be given, one of type Fixed and one of type Floating.  
  Allowable values: See <a href="#ss:leg_data" data-reference-type="ref"
  data-reference="ss:leg_data">[ss:leg_data]</a>.

<div class="listing">

``` xml
<Trade id="194837232">
  <TradeType>KnockOutSwap</TradeType>
  <Envelope>...</Envelope>
  <KnockOutSwapData>
    <!-- BarrierData and BarrierStartDate specify the knock out terms -->
    <BarrierData>
      <Type>UpAndOut</Type>
      <Levels>
        <Level>0.05</Level>
      </Levels>
    </BarrierData>
    <BarrierStartDate>2024-10-01</BarrierStartDate>
    <!-- we require exactly one Floating and one Fixed Leg -->
    <LegData>
      <LegType>Floating</LegType>
      ...
    </LegData>
    <LegData>
      <LegType>Fixed</LegType>
      ...
    </LegData>
  </KnockOutSwapData>
</Trade>
```

</div>
