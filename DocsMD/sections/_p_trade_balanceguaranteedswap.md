### Balance Guaranteed Swap (BGS)

BGS are priced in ORE using an auxiliary Flexi Swap as a proxy. The
amortization schedule of the Flexi Swap is set up as the notional
schedule of the BGS assuming a zero CPR (Conditional Prepayment Rate).
The lower notional bound of the Flexi Swap is constructed assuming a
MaxCPR (Maximum Conditional Prepayment Rate) which is dependent on the
Reference Security. The MaxCPR is estimated on the basis of the current
CPR, historical CPRs and / or expert judgement as to provide a
(hypothetical) sufficiently realistic hedge for the BGS. The option
holder in the Flexi Swap is the payer of the structured leg (i.e. the
leg replicating the payments of the reference security) in the BGS.

The `BalanceGuaranteedSwapData` node is the trade data container for
trade type *BalanceGuaranteedSwap*. A BGS must have two legs, one fixed
and one floating. Each leg typically has an amortising notional and is
represented by a `LegData` trade component sub-node, described in
section <a href="#ss:leg_data" data-reference-type="ref"
data-reference="ss:leg_data">[ss:leg_data]</a>. The
`BalanceGuaranteedSwapData` node also contains a `ReferenceSecurity`
sub-node specifying the Asset Backed Security to which the notional
schedule of the BGS is linked. An example structure of a
`BalanceGuaranteedSwapData` node is shown in Listing
<a href="#lst:bgs_data" data-reference-type="ref"
data-reference="lst:bgs_data">[lst:bgs_data]</a>.

<div class="listing">

``` xml
<BalanceGuaranteedSwapData>
  <ReferenceSecurity>ISIN:XS0983610930</ReferenceSecurity>
  <Tranches>
    <Tranche>
      <Description>Class A</Description>
      <SecurityId>ISIN:XS0983610930</SecurityId>
      <Seniority>1</Seniority>
      <Notionals>
      ...
      </Notionals>
    </Tranche>
    <Tranche>
      <Description>Class B</Description>
      <SecurityId>ISIN:XS0983610931</SecurityId>
      <Seniority>2</Seniority>
      <Notionals>
      ...
      </Notionals>
    </Tranche>
    <ScheduleData>
    ...
    </ScheduleData>
  </Tranches>
  <LegData>
    <LegType>Fixed</LegType>
     ...
  </LegData>
  <LegData>
    <LegType>Floating</LegType>
     ...
  </LegData>
<BalanceGuaranteedSwapData>
```

</div>

The meanings and allowable values of the elements in the
`BalanceGuaranteedSwapData` node follow below.

- ReferenceSecurity: The ISIN of the Asset Backed Security tranche to
  which the BGS is linked.

  Allowable values: The prefix `ISIN:` followed by an ISIN code for the
  Reference Security.

- Tranches: A description of the Asset Backed Security tranche
  notionals. Each Tranche is identified by a ` SecurityId` and an
  optional `Description`. Each Tranche has a `Seniority` given as a
  positive integer value where lower values mean higher seniority, i.e.
  $1$ is the most senior tranche (e.g. “class A”) followed by $2$ (e.g.
  “class B”) etc. The notionals are given in a sub-node `Notionals` as
  described in section <a href="#ss:leg_data" data-reference-type="ref"
  data-reference="ss:leg_data">[ss:leg_data]</a> w.r.t. a schedule given
  in `ScheduleData` which is shared across all tranches. There must be
  exactly one tranche with a security id matching the reference
  security.

- LegData: This is a trade component sub-node outlined in section
  <a href="#ss:leg_data" data-reference-type="ref"
  data-reference="ss:leg_data">[ss:leg_data]</a>. A BGS must have two
  `LegData` nodes and the LegType element must be set to *Floating* on
  one leg and *Fixed* on the other. The two legs must have the same
  `Currency`.

The notionals of the swap and the referenced tranche must be consistent.
Furthermore, notionals for periods with a start date in the past must be
given with their actual value, i.e. including actual prepayments that
were made in the previous periods. Notionals for periods with a start
dats in the future on the other hand must be given assuming a zero
conditional prepayment rate. For the latter periods a prepayment model
is used to generate suitable notional schedules when pricing the swap.
The prepayment model assumes that tranches with higher seniority are
amortised first, i.e. in the example here the class A tranche is
amortised before the class B tranche.
