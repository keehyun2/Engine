### Cap/Floor

The `CapFloorData` node is the trade data container for the *CapFloor*
trade type. It’s a cap, floor or collar (i.e. a portfolio of a long cap
and a short floor for a long position in the collar) on a series of
Ibor, SIFMA, OIS, CMS, Duration-adjusted CMS, CMS Spread, CPI, YY
coupons.

The `CapFloorData` node contains a `LongShort` sub-node which indicates
whether the cap (floor, collar) is long or short, and a `LegData`
sub-node where the LegType can be set to *Floating*, *CMS*, *CMSSpread*,
*DurationAdjustedCMS*, *CPI* or *YY*, plus elements for the Cap and
Floor rates. An example structure with Cap rates is shown in Listing
<a href="#lst:capfloor_data" data-reference-type="ref"
data-reference="lst:capfloor_data">[lst:capfloor_data]</a>. The optional
node *PaymentDates* in the `LegData` subnode is currently only used for
OIS and IBOR indices (see
<a href="#ss:leg_data" data-reference-type="ref"
data-reference="ss:leg_data">[ss:leg_data]</a>).

A `CapFloorData` node must have either `Caps` or `Floors` elements, or
both. In the case of both (I.e. a collar with long cap and short floor)
the sequence is that `Caps` elements must be above the `Floors`
elements. Note that the `Caps` and `Floors` elements must be outside the
`LegData` sub-node, i.e. a *CapFloor* can’t have a capped or floored
*Floating* or *CMS* leg. The *Payer* flag in the LegData subnode is
ignored for this instrument. Notice that the signs in the definition of
a collar (long cap, short floor) for the CapFloor instruments is exactly
opposite to <a href="#ss:floatingleg_data" data-reference-type="ref"
data-reference="ss:floatingleg_data">[ss:floatingleg_data]</a>.

<div class="listing">

``` xml
<CapFloorData>
  <LongShort>Long</LongShort>
  <LegData>
    <Payer>false</Payer>
    <LegType>Floating</LegType>
     ...
  </LegData>
  <Caps>
    <Cap>0.05</Cap>
  </Caps>
  <Premiums>
    <Premium>
      <Amount>1000</Amount>
      <Currency>EUR</Currency>
      <PayDate>2021-01-27</PayDate>
    </Premium>
  </Premiums>
</CapFloorData>
```

</div>

The meanings and allowable values of the elements in the `CapFloorData`
node follow below.

- LongShort: This node defines the position in the cap (floor, collar)
  and can take values *Long* or *Short*.

- LegData: This is a trade component sub-node outlined in section
  <a href="#ss:leg_data" data-reference-type="ref"
  data-reference="ss:leg_data">[ss:leg_data]</a>. Exactly one `LegData`
  node is allowed, and the LegType element must be set to *Floating*
  (Ibor and OIS), *CMS*, *CMSSpread*, *DurationAdjustedCMS*, *CPI* or
  *YY*.

- Caps: This node has child elements of type `Cap` capping the floating
  leg (after applying spread if any). The first rate value corresponds
  to the first coupon, the second rate value corresponds to the second
  coupon, etc. If the number of coupons exceeds the number of rate
  values, the rate will be kept flat at the value of last entered rate
  for the remaining coupons. For a fixed cap rate over all coupons, one
  single rate value is sufficient. The number of entered rate values
  cannot exceed the number of coupons.

  Allowable values for each `Cap` element: Any real number. The rate is
  expressed in decimal form, eg 0.05 is a rate of 5%

- Floors: This node has child elements of type `Floor` flooring the
  floating leg (after applying spread if any). The first rate value
  corresponds to the first coupon, the second rate value corresponds to
  the second coupon, etc. If the number of coupons exceeds the number of
  rate values, the rate will be kept flat at the value of last entered
  rate for the remaining coupons. For a fixed floor rate over all
  coupons, one single rate value is sufficient. The number of entered
  rate values cannot exceed the number of coupons.

  Allowable values for each `Floor` element: Any real number. The rate
  is expressed in decimal form, eg 0.05 is a rate of 5%

- Premiums \[Optional\]: Option premium amounts paid by the option buyer
  to the option seller.

  Allowable values: See section
  <a href="#ss:premiums" data-reference-type="ref"
  data-reference="ss:premiums">[ss:premiums]</a>
