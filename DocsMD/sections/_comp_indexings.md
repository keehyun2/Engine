### Indexings

This trade component can be used as an optional node within the
`LegData` component to scale the notional of the coupons of a leg by one
or several index prices. This feature is typically used within equity
swaps with notional reset to align the notional of the funding leg with
the one from the equity leg for all return periods. See
<a href="#ss:equity_swap" data-reference-type="ref"
data-reference="ss:equity_swap">[ss:equity_swap]</a> for the specific
usage in equity swaps. Notice that typically it is sufficient to set the
`FromAssetLeg` flag to *true* in the `Indexings` node definition, i.e.

``` xml
<LegData>
    <LegType>Floating</LegType>
    <!-- no notionals node required -->
    <ScheduleData> ... </ScheduleData>
    <Indexings>
        <FromAssetLeg>true</FromAssetLeg>
    </Indexings>
    <FloatingLegData> ... </FloatingLegData>
</LegData>
```

which will cause the trade builder to pull all the indexing details from
the asset leg (the equity leg in an equity swap) and populate the
indexing data on the funding leg accordingly. Notice that no definition
of a `Notionals` node is required in this case, this will also generated
automatically.

In what follows we will describe the full syntax of the Indexings node
below for reference. The Indexing component can be used in combination
with the following leg types:

- Fixed

- Floating

- CMS

- DigitalCMS

- CMSSpread

- DigitalCMSSpread

If specified the notional of the single coupons in the leg is scaled by
one or several index prices and a quantity. The indices can be equity or
FX indices. Notice that if notional exchanges are enabled on a leg with
the `FromAssetLeg` flag set to *true*, the notional exchanges are *not*
influenced by the indexing definitions. In general we assume that
notional exchanges are not enabled in combination with `FromAssetLeg`
*true*, but it is not forbidden technically. Listing
<a href="#lst:indexings" data-reference-type="ref"
data-reference="lst:indexings">[lst:indexings]</a> shows an example of a
Floating leg indexed by both an equity price and a FX rate.

Another use case for Indexings is for non-deliverable IR and Cross
Currency Swaps. A non-deliverable IR Swap has Currency set to the
deliverable currency on both legs, Notional in the non-deliverable
currency on both legs, and Indexings with an FX Index between the
deliverable and non-deliverable currency on both legs. See the Swap
section for an example non-deliverable IR swap where USD is the payment
currency and CLP is the non-deliverable currency.

A non-deliverable Cross Currency Swap has Settlement set to *Cash*, and
one leg is a regular leg in the deliverable currency without Indexings.
The other leg has Currency set to the deliverable currency, Notional in
the non-deliverable currency and Indexings with an FX Index between the
deliverable and non-deliverable currency. See the Swap section for an
example USD-CLP non-deliverable cross currency swap where CLP is the
non-deliverable currency.

<div class="listing">

``` xml
<LegData>
    <LegType>Floating</LegType>
    <Notionals> ... </Notionals>
    <ScheduleData> ... </ScheduleData>
    <Indexings>
        <FromAssetLeg>false</FromAssetLeg>
        <Indexing>
            <Quantity>1000</Quantity>
            <Index>EQ-RIC:.STOXX50E</Index>
            <InitialFixing>2937.36</InitialFixing>
            <ValuationSchedule>
              <Dates>...</Dates>
              <Rules>...</Rules>
            </ValuationSchedule>
            <FixingDays>0</FixingDays>
            <FixingCalendar/>
            <FixingConvention>U</FixingConvention>
            <IsInArrears>false</IsInArrears>
        </Indexing>
        <Indexing>
            <Index>FX-ECB-EUR-USD</Index>
            <InitialFixing>1.1469</InitialFixing>
            <ValuationSchedule> ... </ValuationSchedule>
            <FixingDays>0</FixingDays>
            <FixingCalendar/>
            <FixingConvention>U</FixingConvention>
            <IsInArrears>false</IsInArrears>
        </Indexing>
    </Indexings>
    <FloatingLegData> ... </FloatingLegData>
</LegData>
```

</div>

The Indexings node contains the following elements:

- `FromAssetLeg` \[Optional\]: If *true*, and the trade type supports
  this, the notionals on the funding leg (i.e. the leg with the
  `FromAssetLeg` field) will be derived from the respective asset leg.
  Internally, the trade builder will add `Indexing` blocks automatically
  reflecting the necessary indexings (equity price and FX in the case of
  an equity swap) from the notional reset feature of the asset leg.
  Also, the Notionals node of the funding leg will internally be set to
  a single notional $1$. The actual Notionals node in the XML on the
  funding leg is not required and can be omitted.

  `FromAssetLeg` is supported for the following trade types:

  - `EquitySwap`: Setting `FromAssetLeg` to *true*, aligns the notionals
    for all return periods on the non-equity funding leg, to the equity
    leg by deriving equity price, quantity and FX from the equity leg.  
    Note that `FromAssetLeg` is only supported if `NotionalReset` is
    *true* on the equity leg - `FromAssetLeg` is ignored otherwise. Also
    `FromAssetLeg` is only supported when Quantity is given on the
    equity leg, not InitialPrice and Notional.

  - `BondTRS`: Setting `FromAssetLeg` to *true*, aligns the notionals
    for all return periods on the funding leg (in the `FundingData`
    block), to the total return leg (in the `TotalReturnData` block) by
    deriving bond price, bond notional and FX from the total return leg,
    bond data and the reference bond.

  Allowable values: *true*, *false*. Defaults to *false* if left blank
  or omitted.

- `Indexing` \[Optional, an arbitrary number can be given\]: Each
  Indexing node describes one indexing as follows:

  - Quantity \[Optional\]: The quantity that applies. For equity that
    should be the number of shares, for FX it should be 1, i.e. for FX
    this field can be omitted. The notional of each coupon is in general
    determined as  
    Original Coupon Notional x Quantity x Equity Price x FX Rate  
    depending on which indexing types are given. Typically, the original
    coupon notional will be set to 1.

    Allowable values: Any number. Defaults to *1* if left blank or
    omitted.

  - Index: The relevant index. This is either an equity or FX index. For
    an FX index, one of the currencies of the index must match the leg
    currency. It is then ensured that the FX conversion is applied using
    the correct direction, i.e. if the foreign currency of the index
    matches the leg currency, the reciprocals of the index fixings are
    used as a multiplier.

    Allowable values: This is “FX-SOURCE-CCY1-CCY” for FX, see
    <a href="#ss:underlying" data-reference-type="ref"
    data-reference="ss:underlying">[ss:underlying]</a> and
    <a href="#tab:fxindex_data" data-reference-type="ref"
    data-reference="tab:fxindex_data">[tab:fxindex_data]</a> for
    details, or “EQ-NAME” for Equity with “Name” being the general
    string representation for equity underlyings
    IdentifierType:Name:Currency:Exchange, see
    <a href="#ss:underlying" data-reference-type="ref"
    data-reference="ss:underlying">[ss:underlying]</a>.

  - Dirty \[Optional\]: Only used for bond indices. Indicates whether to
    use dirty (*true*) or clean (*false*) prices.

    Allowable values: *true*, *false*. Defaults to *true* if left blank
    or omitted.

  - Relative \[Optional\]: Only used for bond indices. Indicates whether
    to use relative (*true*) or absolute prices (*false*). The absolute
    price is the dirty or clean npv as of the settlement date of the
    bond in absolute “dollar” terms using the bond details (in
    particular the notional) from the reference data. The relative price
    is the absolute price divided by the current notional as of the
    settlement date.

    Allowable values: *true*, *false*. Defaults to *true* if left blank
    or omitted.

  - ConditionalOnSurvival \[Optional\]: Only used for bond indices.
    Indicates whether to forecast bond prices conditional on survival
    (*true*) or including the default probability from today until the
    fixing date (*false*).

    Allowable values: *true*, *false*. Defaults to *true* if left blank
    or omitted.

  - InitialFixing \[Optional\]: If given the index fixing value to apply
    on the fixing date of the first coupon. If not given the value is
    read from the relevant fixing history.

    Allowable values: any number

  - InitialNotionalFixing \[Optional\]: If given the index fixing value
    to apply on the fixing date of the first notional exchange flow.
    This is used in non-deliverable XCCY swaps. If not given the value
    is read from the relevant fixing history.

    Allowable values: any number

  - ValuationSchedule \[Optional\]: If given the schedule from which the
    fixing dates are deduced. If not given, it defaults to the original
    leg’s schedule.

    If the valuation schedule has the same size as the original leg’s
    schedule, it is assumed that the periods correspond one to one, i.e.
    the $i$th fixing date is derived from the $i$th (inArrears = false)
    or $i+1$th (inArrears = true) date in the valuation schedule using
    the FixingDays, FixingCalendar and FixingConvention.

    If the valuation schedule has a different size than the original
    leg’s schedule, the relevant valuation date for the $i$th original
    leg’s coupon is determined as the latest valuation date that is less
    or equal to accrual start date (inArrears = false) resp. accrual end
    date (inArrears = true) of that coupon. The fixing date is derived
    from the relevant valuation date as above, i.e. using the
    FixingDays, FixingCalendar and FixingConvention.

    Allowable values: a valid schedule definition, see
    <a href="#ss:schedule_data" data-reference-type="ref"
    data-reference="ss:schedule_data">[ss:schedule_data]</a>

  - FixingDays \[Optional\]: If given defines the number of fixing days
    to apply when deriving the fixing dates from the valuation schedule
    (see above).

    Allowable values: Any non-negative whole number. Defaults to *0* if
    left blank or omitted.

  - FixingCalendar \[Optional, defaults to NullCalendar (no holidays):
    If given defines the fixing calendar to use when deriving the fixing
    dates from the valuation schedule (see above).

    Allowable values: Allowable values: See Table
    <a href="#tab:calendar" data-reference-type="ref"
    data-reference="tab:calendar">[tab:calendar]</a> Calendar. Defaults
    to the *NullCalendar* (no holidays) if left blank or omitted.

  - FixingConvention \[Optional\]: If given defines the business day
    convention to use when deriving the fixing dates from the valuation
    schedule (see above). Defaults to *Preceding* if left blank or
    omitted.

    Allowable values: Any valid roll convention, e.g. (*F, MF, P, MP,
    U*). See Table <a href="#tab:convention" data-reference-type="ref"
    data-reference="tab:convention">[tab:convention]</a>.

  - IsInArrears \[Optional\]: If *true*, the fixing dates are derived
    from the period end dates, otherwise from the period start dates as
    described for `ValuationSchedule` above.

    Allowable values: *true*, *false*. Defaults to *false* if left blank
    or omitted.
