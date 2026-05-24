### Equity Leg Data

Listing <a href="#lst:equitylegdata" data-reference-type="ref"
data-reference="lst:equitylegdata">[lst:equitylegdata]</a> shows an
example of a leg of type Equity. Note that a resetting Equity Leg
(NotionalReset set to *true*) must have either:  
a) a Quantity, or  
b) an InitialPrice and a Notional in the leg

The EquityLegData block contains the following elements:

- Quantity\[Optional with one exception\]: The number of shares. Either
  a Notional or the Quantity must be given for the leg, but not both at
  the same time.

  Quantity is optional with the exception that when FXTerms is used and
  NotionalReset is set to *true*, and the InitialPriceCurrency differs
  from the leg currency, Quantity must be given, and Notional cannot be
  used.

  Allowable values: Any positive real number

- ReturnType: *Price* indicates that the coupons on the equity leg are
  determined by the price movement of the underlying equity, i.e.:
  $Notional \cdot \frac{FinalPrice - InitialPrice} {InitialPrice}$,  
  *Total* indicates that coupons are determined by the total return of
  the underlying equity including dividends, i.e.:  
  $Notional \cdot \frac{(FinalPrice + dividends * DividendFactor) - InitialPrice} {InitialPrice}$,  
  *Dividend* indicates that the coupons are determined by the dividened
  paid on the underlying equity.

  Allowable values: *Price, PRICE*, *Total, TOTAL*, *Dividend, DIVIDEND*

- Name: The identifier of the underlying equity or equity index.

  Allowable values: See `Name` for equity trades in Table
  <a href="#tab:equity_name" data-reference-type="ref"
  data-reference="tab:equity_name">[tab:equity_name]</a>.  

- Underlying: This node may be used as an alternative to the `Name` node
  to specify the underlying equity. This in turn defines the equity
  curve used for pricing. The `Underlying` node is described in further
  detail in Section <a href="#ss:underlying" data-reference-type="ref"
  data-reference="ss:underlying">[ss:underlying]</a>.  

- InitialPrice \[Optional\]: Initial Price of the equity, if not
  present, the first valuation date is used to determine the initial
  price. If InitialPrice is zero then each coupon’s price is just the
  discounted fixing from the coupon’s FixingEndDate. For any divisions
  we assume the value is one, i.e. when NotionalReset = true we have
  instead Quantity = Notional. The Initial price can be either given in
  the currency of the equity or in the leg currency, see
  InitialPriceCurrency.

  Allowable values: Any positive real number. If omitted or left blank
  it defaults to the equity price of the fixing at the valuation date
  associated with the start date. Note that when this valuation date is
  in the future the forward equity price is used.

- InitialPriceCurrency \[Optional\]: If an initial price is given, it
  can be either given in the original equity ccy or the leg currency (if
  these are different). This field determines in which currency the
  initial price is given. If omitted, it is assumed that the initial
  price is given in equity currency.

  Allowable values: A valid currency code, See Fiat Currencies and Minor
  Currencies in Table <a href="#tab:currency" data-reference-type="ref"
  data-reference="tab:currency">[tab:currency]</a>.

- NotionalReset \[Optional\]: Defaults to *true*. Notional resets only
  affect the equity leg. If NotionalReset is set to *true* the quantity
  or number of shares of the underlying equity is fixed for all the
  coupons on the equity leg and the Notional for a period is computed as

  Notional = Quantity x (share price at valuation date for period) x (FX
  conversion rate at valuation date for period)

  Notice that either a) the Quantity or b) a Notional and an explicit
  InitialPrice must be given in the leg data for a resettable leg. In
  the latter case the Quantity is computed as

  Quantity = Notional / InitialPrice

  No FX conversion is allowed if the Quantity has to be derived from the
  Notional and the InitialPrice.

  If NotionalReset is set to *false* the quantity of the underlying
  equity varies per period, as per:

  Quantity = Notional / (Equity Price at valuation date for the period)

  For the first period, the InitialPrice is the Equity Price at
  valuation date. Here, the Notional is taken to be the Notional
  specified in the leg or - if the Quantity is given - to be

  Notional = Quantity x InitialPrice

  where again the InitialPrice must be explicitly given in the leg data
  and no FX conversion is allowed in this case.

  Allowable values: *true* or *false*

- DividendFactor \[Optional\]: Factor of dividend to be included in
  return. Note that the DividendFactor is only relevant when the
  ReturnType is set to *Total*. It is not used if the ReturnType is set
  to *Price*.

  Allowable values: 0 $<$ DividendFactor $\leq$ 1. Defaults to *1* if
  left blank or omitted.

- ValuationSchedule \[Optional\]: Schedule of dates for equity
  valuation. If used, fixing dates for equity valuation will come from
  the `ValuationSchedule` instead of the `ScheduleData`.

  Allowable values: A node of the same form as `ScheduleData`, (see
  <a href="#ss:schedule_data" data-reference-type="ref"
  data-reference="ss:schedule_data">[ss:schedule_data]</a>). Note that
  the number of dates (and periods) in the `ValuationSchedule` must be
  the same as in the `ScheduleData`. If omitted, equity valuation dates
  follow the schedule of the equity leg adjusted for FixingDays.

- FixingDays \[Optional\]: The number of days before payment date for
  equity valuation. *N.B.* Only used when no valuation schedule present.
  The calendar used when applying the fixing days is the equity curve
  calendar (defined in the equity reference data for the underlying
  equity) combined with the FxIndex calendar (if applicable).

  Allowable values: Any non-negative integer. Defaults to *0* if left
  blank or omitted.

- FXTerms \[Mandatory when leg and equity currencies differ\]: For the
  case when the currency the underlying equity is quoted in, is
  different from the leg currency. The `FXTerm` node contains the
  following elements:

  - EquityCurrency \[Mandatory within `FXTerms`\]: Currency underlying
    equity is quoted in. Required if FXTerms is present.

    Allowable values: See Fiat Currencies and Minor Currencies in Table
    <a href="#tab:currency" data-reference-type="ref"
    data-reference="tab:currency">[tab:currency]</a>.

  - FXIndex \[Mandatory within `FXTerms`\]: Name of the index for FX
    fixings for the leg vs equity currency pair, e.g. FX-TR20H-EUR-USD
    for Thomson Reuters 20:00 EURUSD FX fixing. Required if FXTerms
    present.

    Allowable values: See Table
    <a href="#tab:fxindex_data" data-reference-type="ref"
    data-reference="tab:fxindex_data">[tab:fxindex_data]</a>

<div class="listing">

``` xml
      <LegData>
        <LegType>Equity</LegType>
        <Payer>false</Payer>
        <Currency>EUR</Currency>
        <DayCounter>ACT/ACT</DayCounter>
        <PaymentConvention>Following</PaymentConvention>
        <ScheduleData>
          <Rules>
            <StartDate>2026-03-01</StartDate>
            <EndDate>2028-03-01</EndDate>
            <Tenor>3M</Tenor>
            <Calendar>TARGET</Calendar>
            <Convention>ModifiedFollowing</Convention>
            <Rule>Forward</Rule>
          </Rules>
        </ScheduleData>
        <EquityLegData>
          <Quantity>1000.0</Quantity>
          <ReturnType>Price</ReturnType>
          <Underlying>
            <Type>Equity</Type>
            <Name>.SPX</Name>
            <IdentifierType>RIC</IdentifierType>
          </Underlying>
          <InitialPrice>100</InitialPrice>
          <NotionalReset>true</NotionalReset>
          <DividendFactor>1</DividendFactor>
          <ValuationSchedule>
            <Dates>
              <Calendar>USD</Calendar>
              <Convention>ModifiedFollowing</Convention>
              <Dates>
                <Date>2026-03-01</Date>
                <Date>2026-06-01</Date>
                <Date>2026-09-01</Date>
                <Date>2026-12-01</Date>
                <Date>2027-03-01</Date>
                <Date>2027-06-01</Date>
                <Date>2027-09-01</Date>
                <Date>2027-12-01</Date>
                <Date>2028-03-01</Date>
              </Dates>
            </Dates>
           </ValuationSchedule>
           <FixingDays>0</FixingDays>
           <FXTerms>
             <EquityCurrency>USD</EquityCurrency>
             <FXIndex>FX-TR20H-EUR-USD</FXIndex>
           <FXTerms>
        </EquityLegData>
      </LegData>
```

</div>
