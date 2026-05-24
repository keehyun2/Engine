### Constant Maturity Bond Leg Data

In close analogy to the CMS leg one can create a leg that is linked to a
*Constant Maturity Bond* yield index. The associated leg type is *CMB*.

Listing <a href="#lst:cmblegdata" data-reference-type="ref"
data-reference="lst:cmblegdata">[lst:cmblegdata]</a> shows an example
for a leg of type CMB.

<div class="listing">

``` xml
      <LegData>
        <LegType>CMB</LegType>
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
        <CMBLegData>
          <Index>CMB-US-TBILL-HD-13W</Index>
          <FixingDays>2</FixingDays>
          <Spreads>
            <Spread>0.0010</Spread>
          </Spreads>
          <Gearings>
            <Gearing>2.0</Gearing>
          </Gearings>
        </CMBLegData>
      </LegData>
```

</div>

The CMBLegData block contains the following elements:

- Index: The underlying CMB index.

  Allowable values: A string of the form CMB-FAMILY-TENOR, where FAMILY
  might consist of several tokens separated by “-” as e.g. in
  CMB-US-TBILL-HD or CMB-DE-BUND, and TENOR is a valid period.

- Spreads \[Optional\]: The spreads applied to index fixings. As usual,
  this can be a single value, a vector of values or a dated vector of
  values.

  Allowable values: Each child spread element can take any real number.
  The spread is expressed in decimal form, e.g. 0.005 is a spread of
  0.5% or 50 bp. Defaults to zero if left blank or omitted.

- FixingDays: This is the fixing gap, i.e. the number of days before the
  period end date an index fixing is taken. Defaults to the index’s
  fixing gap.

  Allowable values: A non-negative whole number. Defaults to the fixing
  days of the Ibor index the swap references if blank or omitted. See
  defaults per index in Table
  <a href="#tab:fixingdaysdefaults" data-reference-type="ref"
  data-reference="tab:fixingdaysdefaults">[tab:fixingdaysdefaults]</a>.

- IsInArrears \[Optional\]: *true* indicates that fixing is in arrears,
  i.e. the fixing gap is calculated in relation to the current period
  end date.  
  *false* indicates that fixing is in advance, i.e. the fixing gap is
  calculated in relation to the previous period end date.

  Allowable values: *true, false*. Defaults to *false* if left blank or
  omitted.

- Gearings \[Optional\]: This node contains child elements of type
  `Gearing` indicating that the coupon rate is multiplied by the given
  factors. The mode of specification is analogous to spreads, see above.

  If the entire `<Gearings>` section is omitted, it defaults to a
  gearing of *1*.

Note:

- For each CMB index name one needs to maintain bond reference data with
  ID equal to the index name. This reference data is used to project the
  CMB index fixings as follows: For a future index period (from future
  date to future date + index tenor), a forward starting bond is
  constructed using the schedule frequency defined in the reference data
  and with constant maturity (future date + tenor). The forward bond is
  priced using the reference yield curve and credit curve defined in the
  reference data. And the bond price is then converted into a bond yield
  using the bond yield conventions (compounding, frequency, price type)
  maintained for that same ID. If the conventions are not set up, then
  default values are used (compounded, annual, clean).

- For periods with start dates in the past, historical index fixings
  need to be provided, as for interest rate indices.

- No convexity adjustment is applied here yet, in contrast to CMS index
  projections.

- The CMB leg does not support Caps or Floors yet, in contrast to the
  CMS leg.
