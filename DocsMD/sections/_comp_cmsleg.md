### CMS Leg Data

Listing <a href="#lst:cmslegdata" data-reference-type="ref"
data-reference="lst:cmslegdata">[lst:cmslegdata]</a> shows an example
for a leg of type CMS.

<div class="listing">

``` xml
      <LegData>
        <LegType>CMS</LegType>
        <Payer>false</Payer>
        <Currency>EUR</Currency>
        <Notionals>
          <Notional>10000000</Notional>
        </Notionals>
        <DayCounter>ACT/ACT</DayCounter>
        <PaymentConvention>Following</PaymentConvention>
        <ScheduleData>
          ...
        </ScheduleData>
        <CMSLegData>
          <Index>EUR-CMS-10Y</Index>
          <Spreads>
            <Spread>0.0010</Spread>
          </Spreads>
          <Gearings>
            <Gearing>2.0</Gearing>
          </Gearings>
          <Caps>
            <Cap>0.05</Cap>
          </Caps>
          <Floors>
            <Floor>0.01</Floor>
          </Floors>
          <NakedOption>false</NakedOption>
        </CMSLegData>
      </LegData>
```

</div>

The CMSLegData block contains the following elements:

- Index: The underlying CMS index.

  Allowable values: See <a href="#tab:indices" data-reference-type="ref"
  data-reference="tab:indices">[tab:indices]</a>, a string on the form
  CCY-CMS-TENOR, where the CMS part stays constant and TENOR is an
  integer followed by Y.

- Spreads \[Optional\]: The spreads applied to index fixings. As usual,
  this can be a single value, a vector of values or a dated vector of
  values.

  Allowable values: Each child spread element can take any real number.
  The spread is expressed in decimal form, e.g. 0.005 is a spread of
  0.5% or 50 bp.

- IsInArrears \[Optional\]: *true* indicates that fixing is in arrears,
  i.e. the fixing gap is calculated in relation to the current period
  end date.  
  *false* indicates that fixing is in advance, i.e. the fixing gap is
  calculated in relation to the previous period end date.

  Allowable values: *true, false*. Defaults to *false* if left blank or
  omitted.

- FixingDays \[Optional\]: This is the fixing gap, i.e. the number of
  days before the period end date an index fixing is taken. Defaults to
  the index’s fixing gap.

  Allowable values: A non-negative whole number. Defaults to the fixing
  days of the Ibor index the swap references if blank or omitted. See
  defaults per index in Table
  <a href="#tab:fixingdaysdefaults" data-reference-type="ref"
  data-reference="tab:fixingdaysdefaults">[tab:fixingdaysdefaults]</a>.

- Gearings \[Optional\]: This node contains child elements of type
  `Gearing` indicating that the coupon rate is multiplied by the given
  factors. The mode of specification is analogous to spreads, see above.

  If the entire `<Gearings>` section is omitted, it defaults to a
  gearing of *1*.

- Caps \[Optional\]: This node contains child elements of type `Cap`
  indicating that the coupon rate is capped at the given rate (after
  applying gearing and spread, if any). The mode of specification is
  analogous to spreads, see above.

- Floors \[Optional\]: This node contains child elements of type `Floor`
  indicating that the coupon rate is floored at the given rate (after
  applying gearing and spread, if any). The mode of specification is
  analogous to spreads, see above.

- NakedOption \[Optional\]: If *true* the leg represents only the
  embedded floor, cap or collar. By convention the embedded floor (or
  cap) are considered long if the leg is a receiver leg, otherwise
  short. For a collar the floor is long and the cap is short if the leg
  is a receiver leg.

  Allowable values: *true*, *false* . Defaults to *false* if left blank
  or omitted.
