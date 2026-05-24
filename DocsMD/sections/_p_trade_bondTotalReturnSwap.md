### Bond Total Return Swap

A vanilla Bond Total Return Swap (Trade type: *BondTRS*) is set up using
a `BondTRSData` block as shown in listing
<a href="#lst:bondtrsdata" data-reference-type="ref"
data-reference="lst:bondtrsdata">[lst:bondtrsdata]</a>. The block is
comprised of three sub-blocks, which are `BondData`, `TotalReturnData`
and `FundingData`.

- The `BondData` block specifies the underlying bond, usually by
  specifying the security id and the quantity / bond notional and
  relying on reference data:

  - SecurityId: The underlying security identifier  
    Allowable values: Typically the ISIN of the underlying bond, with
    the ISIN: prefix. Note that Convertible Bonds are not supported as
    underlyings for BondTRS. For Convertible Bonds, trade type
    *TotalReturnSwap* should be used instead.

  - BondNotional: The quantity or number of bonds that is relevant for
    the TRS, with the convention that 1 bond always corresponds to a
    face value of 1 unit of bond currency.  
    Allowable values: Any positive real number.

  - CreditRisk \[Optional\] Boolean flag indicating whether to show
    Credit Risk on the Bond product. If set to *true*, the product class
    will be set to *Credit* instead of *RatesFX*, and there will be
    credit sensitivities. Note that if the underlying bond reference is
    set up without a CreditCurveId - typically for some highly rated
    government bonds - the CreditRisk flag will have no impact on the
    product class and no credit sensitivities will be shown even if
    CreditRisk is set to *true*.  
    Allowable Values: *true* or *false* Defaults to *true* if left blank
    or omitted.

  Alternatively, the BondData block can be specified fully explicit, as
  outlined in <a href="#ss:bond" data-reference-type="ref"
  data-reference="ss:bond">[ss:bond]</a>

- The `TotalReturnData` block specifies

  - Payer: Indicates whether the total return leg is paid.  
    Allowable values: *true* or *false*

  - InitialPrice \[Optional\]: Should be filled if the bond price on the
    first date of the total return schedule is contractually given, in
    which case the price must correspond to the price type of the total
    return leg, i.e. if the price type is *Dirty* then the InitialPrice
    must also be a dirty price (as it is usually given in the term sheet
    in this case). The price must given in percent, e.g. $101.20$.[^1]
    If not given, the bond price for the first date of the total return
    schedule is read from the price history. Notice that if a bond is
    quoted in Currency per Unit the initial price should be given in
    this format too: If e.g. one unit is $50.0$ USD an initial price of
    $51.0$ would correspond a dirty amount of $51.0$ USD for one unit of
    the bond.  
    Allowable values: Any positive real number.

  - PriceType: The price type on which these payments are based  
    Allowable values: *Dirty* or *Clean*

  - ObservationLag \[Optional\]: The lag between the valuation date and
    the reference schedule period start date.

    Allowable values: Any valid period, i.e. a non-negative whole
    number, followed by *D* (days), *W* (weeks), *M* (months), *Y*
    (years). Defaults to *0D* if left blank or omitted.

  - ObservationConvention \[Optional\]: The roll convention to be used
    when applying the observation lag.

    Allowable values: A valid roll convention (*F, MF, P, MP, U,
    NEAREST*), see Table
    <a href="#tab:convention" data-reference-type="ref"
    data-reference="tab:convention">[tab:convention]</a> Roll
    Convention. Defaults to *U* if left blank or omitted.

  - ObservationCalendar \[Optional\]: The calendar to be used when
    applying the observation lag.

    Allowable values: Any valid calendar, see Table
    <a href="#tab:calendar" data-reference-type="ref"
    data-reference="tab:calendar">[tab:calendar]</a> Calendar. Defaults
    to the *NullCalendar* (no holidays) if left blank or omitted.

  - PaymentLag \[Optional\]: The lag between the reference schedule
    period end date and the payment date.

    Allowable values: Any valid period, i.e. a non-negative whole
    number, optionally followed by *D* (days), *W* (weeks), *M*
    (months), *Y* (years). Defaults to *0D* if left blank or omitted. If
    a whole number is given and no letter, it is assumed that it is a
    number of *D* (days).

  - PaymentConvention \[Optional\]: The business day convention to be
    used when applying the payment lag.

    Allowable values: A valid roll convention (*F, MF, P, MP, U,
    NEAREST*), see Table
    <a href="#tab:convention" data-reference-type="ref"
    data-reference="tab:convention">[tab:convention]</a> Roll
    Convention. Defaults to *U* if left blank or omitted.

  - PaymentCalendar \[Optional\]: The calendar to be used when applying
    the payment lag.

    Allowable values: Any valid calendar, see Table
    <a href="#tab:calendar" data-reference-type="ref"
    data-reference="tab:calendar">[tab:calendar]</a> Calendar. Defaults
    to the *NullCalendar* (no holidays) if left blank or omitted.

  - PaymentDates \[Optional\]: This node allows for the specification of
    a list of explicit payment dates, using `PaymentDate` elements. The
    list must contain exactly $n-1$ dates where $n$ is the number of
    dates in the reference schedule given in the ScheduleData node. See
    Listing <a href="#lst:paymentdatesbondtrs" data-reference-type="ref"
    data-reference="lst:paymentdatesbondtrs">[lst:paymentdatesbondtrs]</a>
    for an example with an assumed ScheduleData with 4 dates.

    <div class="listing">

    ``` xml
                        <PaymentDates>
                              <PaymentDate>2020-01-15</PaymentDate>
                              <PaymentDate>2021-01-15</PaymentDate>
                              <PaymentDate>2022-01-17</PaymentDate>
                        </PaymentDates>
    ```

    </div>

  - FXTerms \[Mandatory when underlying bond and BondTRS currencies
    differ\]: Required if the bond currency is different from the return
    currency, which is always assumed to be equal to the funding leg
    currency. This kind of trade is also known as a “composite trs”. The
    subnode for the FXTerms node is:

    - FXIndex: The fx index to use for the conversion, this must contain
      the bond currency and the funding leg currency (in the order
      defined in table
      <a href="#tab:fxindex_data" data-reference-type="ref"
      data-reference="tab:fxindex_data">[tab:fxindex_data]</a>, i.e. it
      does not matter which one is the bond currency and which is the
      funding currency)

      Allowable values: See Table
      <a href="#tab:fxindex_data" data-reference-type="ref"
      data-reference="tab:fxindex_data">[tab:fxindex_data]</a>

    - ApplyFXIndexFixingDays \[Optional\]: If set to *true*, the FX
      fixing date is moved back by the usual number of fixing days (for
      example, 2 days before the valuation date), using the FX index
      calendar to skip holidays. If *false*, the FX fixing date is the
      same as the valuation date.

      Allowable values: *true* (use fixing lag) or *false* (use
      valuation date). Defaults to *false* if left blank or omitted.

  - ScheduleData: The reference schedule for the return leg, where the
    valuation dates are derived from this schedule using the
    ObservationLag, ObservationConvention and ObservationCalendar
    fields. The payment dates are derived from this schedule using the
    PaymentLag, PaymentConvention and PaymentCalendar fields. The
    payment dates can also be given as an explicit list in the
    PaymentDates node. Allowable values: A `ScheduleData` block as
    defined in section
    <a href="#ss:schedule_data" data-reference-type="ref"
    data-reference="ss:schedule_data">[ss:schedule_data]</a>

  - PayBondCashFlowsImmediately \[Optional\]: If true, bond cashflows
    like coupon or amortisation payments are paid when they occur. If
    false, these cashflows are paid together with the next return
    payment. If omitted, the default value is false.

    Allowable values: *true* (immediate payment of bond cashflows) or
    *false* (bond cashflows are paid on the next return payment date)

- The `FundingData` block specifies the funding leg, which can be of any
  leg type. The `FundingData` contains exactly one `Leg`. The currency
  of this leg also defines the currency in which the return is paid.
  Usually the funding leg’s notional will be aligned with the return
  leg’s notional. To achieve this, indexings on the floating leg can be
  used, see <a href="#ss:indexings" data-reference-type="ref"
  data-reference="ss:indexings">[ss:indexings]</a>. In the context of
  bond total return swaps, the indexings can be defined in a simplified
  way by adding an Indexings node with a subnode FromAssetLeg set to
  true to the funding leg’s LegData node. The notionals node is not
  required either in the funding leg’s LegData in this case. An example
  for this setup is shown in
  <a href="#lst:bondtrsdata" data-reference-type="ref"
  data-reference="lst:bondtrsdata">[lst:bondtrsdata]</a>.

<div class="listing">

``` xml
<BondTRSData>
  <BondData>
    <SecurityId>ISIN:NZIIBDT005C5</SecurityId>
    <BondNotional>100000</BondNotional>
  </BondData>
  <TotalReturnData>
    <Payer>false</Payer>
    <InitialPrice>102.0</InitialPrice>
    <PriceType>Clean</PriceType>
    <ObservationLag>0D</ObservationLag>
    <ObservationConvention>P</ObservationConvention>
    <ObservationCalendar>USD</ObservationCalendar>
    <PaymentLag>2D</PaymentLag>
    <PaymentConvention>F</PaymentConvention>
    <PaymentCalendar>TARGET</PaymentCalendar>
    <!-- <PaymentDates> -->
    <!--   <PaymentDate> ... </PaymentDate> -->
    <!--   <PaymentDate> ... </PaymentDate> -->
    <!-- </PaymentDates> -->
    <FXTerms>
      <FXIndex>FX-TR20H-NZD-USD</FXIndex>
    </FXTerms>
    <ScheduleData>
    ...
    </ScheduleData>
    <PayBondCashFlowsImmediately>false</PayBondCashFlowsImmediately>
  </TotalReturnData>
  <FundingData>
    <LegData>
      <Payer>true</Payer>
      <LegType>Floating</LegType>
      <Currency>USD</Currency>
      ...
      <!-- Notionals node is not required, set to 1 internally -->
      ...
      <Indexings>
      <!-- derive the indexing information (bond price, FX) from the total return leg -->
      <FromAssetLeg>true</FromAssetLeg>
      </Indexings>
      ...
    </LegData>
  </FundingData>
</BondTRSData>
```

</div>

[^1]: as opposed to the bond price in the fixing history, where it must
    be given as $1.0120$ and is always a clean quotation
