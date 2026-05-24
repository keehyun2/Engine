### Callable Swap

The `CallableSwapData` node is the trade data container for the
*CallableSwap* trade type. A Callable Swap is a swap that can be
cancelled at predefined dates by one of the counterparties. A Callable
Swap must have at least one leg, each leg described by a `LegData` trade
component sub-node as described in section
<a href="#ss:leg_data" data-reference-type="ref"
data-reference="ss:leg_data">[ss:leg_data]</a>.

Unless MidCouponExercise is *true*, there must be at least one full
coupon period after the exercise date for European Callable Swaps, and
after the last exercise date for Bermudan and American Callable Swaps.

The `CallableSwapData` node also contains an `OptionData` node which
describes the exercise dates and specifies which party holds the call
right, see <a href="#ss:option_data" data-reference-type="ref"
data-reference="ss:option_data">[ss:option_data]</a>. An example
structure of a `CallableSwapData` node is shown in Listing
<a href="#lst:callableswap_data" data-reference-type="ref"
data-reference="lst:callableswap_data">[lst:callableswap_data]</a>.

<div class="listing">

``` xml
<CallableSwapData>
    <OptionData>
      <LongShort>Short</LongShort>
      <Style>Bermudan</Style>
      <Settlement>Physical</Settlement>
      <MidCouponExercise>true<MidCouponExercise>
      <ExerciseDates>
        <ExerciseDate>2031-10-01</ExerciseDate>
        <ExerciseDate>2032-10-01</ExerciseDate>
        <ExerciseDate>2033-10-01</ExerciseDate>
      </ExerciseDates>
      ...
    </OptionData>
  <LegData>
    <LegType>Fixed</LegType>
        <Payer>false</Payer>    
        <Currency>USD</Currency>    
    ...
  </LegData>
  <LegData>
    <LegType>Floating</LegType>
        <Payer>true</Payer>     
        <Currency>USD</Currency>    
    ...
  </LegData>
</CallableSwapData>
```

</div>

The meanings and allowable values of the elements in the
`CallableSwapData` node follow below.

- OptionData: This is a trade component sub-node outlined in section
  <a href="#ss:option_data" data-reference-type="ref"
  data-reference="ss:option_data">[ss:option_data]</a>. The exercise
  dates specify the dates on which one of the counterparties may
  terminate the swap. The counterpart holding the call right is
  specified by the `LongShort` flag. The Settlement should be set to
  *Physical* always. See also the OptionData node outlined for a
  Swaption - see <a href="#ss:swaption" data-reference-type="ref"
  data-reference="ss:swaption">[ss:swaption]</a>, which is identical for
  a CallableSwap with the exception of the requirement that Settlement
  must be *Physical*, and that the leg directions on a CallableSwap are
  from the perspective of the client, whereas they are from the
  perspective of the party that is long on a Swaption. A callable swap
  can be marked as exercised as explained in
  <a href="#ss:swaption" data-reference-type="ref"
  data-reference="ss:swaption">[ss:swaption]</a> using the
  `ExerciseData` node within OptionData.

- LegData: This is a trade component sub-node described in section
  <a href="#ss:leg_data" data-reference-type="ref"
  data-reference="ss:leg_data">[ss:leg_data]</a> outlining each leg of
  the underlying Swap. A Callable Swap must have at least one leg on the
  underlying Swap, but can have multiple legs, i.e. multiple `LegData`
  nodes. The LegType elements must be of types *Floating*, *Fixed* or
  *Cashflow*. All legs must have the same `Currency`.

  Note that the direction of the legs, determined by the `Payer` tag, is
  like for a Swap, from the perspective of the party to the trade. I.e.
  unlike for a Swaption where the direction of the legs is from the
  perspective of the party that is long.
