### Flexi Swap

The `FlexiSwapData` node is the trade data container for trade type
Flexi Swap. A Flexi Swap is a two-legged swap with optional and
customisable pre-payments. Flexi Swaps are typically used for
representing swaps linked to Asset Backed Securities with flexible
amortisation. A Flexi Swap must have two legs, one fixed and one
floating. The floating leg must have a pay frequency that is a multiple
of the fixed leg frequency and corresponding floating and fixed leg
periods must have the same notional. The legs typically have an
amortising notional and are represented by `LegData` trade component
sub-nodes, described in section
<a href="#ss:leg_data" data-reference-type="ref"
data-reference="ss:leg_data">[ss:leg_data]</a>. The `FlexiSwapData` node
also contains a `OptionLongShort` node indicating the holder of the
prepayment option and a node describing the optional prepayments, see
below.

An example structure of a `FlexiSwapData` node is shown in Listing
<a href="#lst:flexiswap_data" data-reference-type="ref"
data-reference="lst:flexiswap_data">[lst:flexiswap_data]</a>. In this
case the optional pre-payments are given by a subnode
`LowerNotionalBounds` meaning that the notional of the swap can be
reduced to any value between the given lower bound and the original
notional in each fixed leg period.

<div class="listing">

``` xml
<FlexiSwapData>
  <LowerNotionalBounds>
        <Notional>451389557.145667</Notional>
        <Notional>427876791.621303</Notional>
        <Notional>404435982.369285</Notional>
        <Notional>379353200.32956</Notional>
        ...
  </LowerNotionalBounds>
  <OptionLongShort>Short</OptionLongShort>
  <LegData>
    <LegType>Fixed</LegType>
    ...
  </LegData>
  <LegData>
    <LegType>Floating</LegType>
    ...
  </LegData>
</FlexiSwapData>
```

</div>

Alternatively the optional pre-payments can be described by a subnode
`NotionalDecreases` which is more general than the description via
LowerNotionalBounds (using the reduction type RedutionToLowerBound, see
below for more details on this), see Listing
<a href="#lst:flexiswap_data2" data-reference-type="ref"
data-reference="lst:flexiswap_data2">[lst:flexiswap_data2]</a> for an
example.

<div class="listing">

``` xml
<FlexiSwapData>
  <Prepayment>
    <NoticePeriod>5D</NoticePeriod>
    <NoticeCalendar>TARGET</NoticeCalendar>
    <NoticeConvention>F</NoticePeriod>
    <PrepaymentOptions>
      <PrepaymentOption>
        <ExerciseDate>2015-02-01</ExerciseDate>
        <Type>ReductionUpToLowerBound</Type>
        <Value>404435982.369285</Value>
      </PrepaymentOption>
      <PrepaymentOption>
        <ExerciseDate>2016-02-01</ExerciseDate>
        <Type>ReductionByAbsoluteAmount</Type>
        <Value>100000.0</Value>
      </PrepaymentOption>
      <PrepaymentOption>
        <ExerciseDate>2017-02-01</ExerciseDate>
        <Type>ReductionUpToAbsoluteAmount</Type>
        <Value>50000.0</Value>
      </PrepaymentOption>
    <PrepaymentOptions>
  </Prepayment>
  <OptionLongShort>Short</OptionLongShort>
  <LegData>
    <LegType>Fixed</LegType>
    ...
  </LegData>
  <LegData>
    <LegType>Floating</LegType>
    ...
  </LegData>
</FlexiSwapData>
```

</div>

The meanings and allowable values of the elements in the `FlexiSwapData`
node follow below.

- OptionLongShort: Specifies which party has the right to pre-pay the
  notional down to the lower notional bound. *Short* means that for
  pricing purposes pre-payments are assumed to be done in such a way to
  maximise the value of the Flexi Swap for the “other” counterparty,
  *Long* means that the Flexi Swap value is maximised from “our” point
  of view.

  Allowable values: *Long* or *Short*

- LegData: This is a trade component sub-node outlined in section
  <a href="#ss:leg_data" data-reference-type="ref"
  data-reference="ss:leg_data">[ss:leg_data]</a>. A Flexi Swap must have
  two `LegData` nodes and the LegType element must be set to *Floating*
  on one leg and *Fixed* on the other. The two legs must have the same
  `Currency`. The float leg pay frequency must be a multiple of the
  fixed leg frequency.

The optional prepayments are described by either a `LowerNotionalBounds`
node or a `Prepyment` node.

In case the optional prepayments are described by a
`LowerNotionalBounds` node, the minimum level to which the notional can
be amortised down to must be given as a notional schedule. The schedule
can be specified as described in
<a href="#ss:leg_data" data-reference-type="ref"
data-reference="ss:leg_data">[ss:leg_data]</a>, i.e. using a sequence of
`Notional` subnodes or using the `startDate` attribute to specify
notional changes. The given schedule must be given for the fixed leg
periods since the notional can be decreased for each whole fixed leg
period and the corresponding floating leg periods (remember that the
floating leg frequency must be a multiple of the fixed leg frequency).
Each lower notional bound child element can take a positive real number
that cannot exceed the notional amount of the corresponding coupon
period on either leg and (from the second fixed coupon period on) the
lower notional bound of the previous coupon period.

In case the optional prepayments are described by a `Prepayment` node,
the single exercise opportunities are described by a `PrepaymentOptions`
subnode that contains one or several `PerpaymentOption` subnodes, each
of which comprises the following elements:

- ExerciseDate: The date on which the notional can be decreased.

- Type: The type of the allowed notional reduction. The allowable types
  are

  - ReductionUpTpLowerBound: The notional can be reduced to any value
    between the current notional and the lower bound given in the Value
    node.

  - ReductionByAbsoluteAmount: The notional can be reduced by an
    absolute amount given in the Value node. If this value is greater
    than the current notional, the reduction amount is equal to the
    current notional.

  - ReductionUpToAbsoluteAmount: The notional can be reduced by any
    value between zero and a given absolute amount (given in the Value
    node).

- Value: The value that together with the type describes the amount by
  which the notional can be decreased.

In addition the `Prepayment` node contains the following optional
subnodes describing the conventions for deriving the option notice date
from the exercise date:

- NoticePeriod \[Optional\]: The notice period defining the date
  (relative to the exercise date) on which the exercise decision has to
  be taken. If not given the notice period defaults to 0D, i.e. the
  notice date is identical to the exercise date.

- NoticeCalendar \[Optional\]: The calendar used to compute the notice
  date from the exercise date. If not given defaults to the null
  calendar (no holidays, weekends are no holidays either).

- NoticeConvention \[Optional\]: The convention used to compute the
  notice date from the exercise date. Defaults to Unadjusted if not
  given.
