### Risk Participation Agreement (RPA)

A risk participation agreement is set up using the trade type
`RiskParticipationAgreement` and a ` RiskParticipationAgreementData`
block as shown in listing
<a href="#lst:rpadata" data-reference-type="ref"
data-reference="lst:rpadata">[lst:rpadata]</a>. The block contains a
`ProtectionFee` block that can include one or more legs representing the
fees paid by the protection buyer and an `Underlying` block containing
either the legs of the underlying swap or the Treasury-Lock data that
the contract references.

If the underlying reference entity defaults, the protection buyer
receives the PV of the underlying if this is positive. Here, the
underlying PV is computed using the payer / receiver flags as set up for
the legs under the underlying node. Whether the trade represents a
protection buyer or seller position is indicated by the payer flag in
the protection fee leg data: If true protection is bought (and the
protection fee is paid), if false the protection is sold (and the
protection fee is received).

<div class="listing">

``` xml
  <RiskParticipationAgreementData>
    <ParticipationRate>0.8</ParticipationRate>
    <ProtectionStart>2018-10-01</ProtectionStart>
    <ProtectionEnd>2038-10-01</ProtectionEnd>
    <CreditCurveId>RED:008CA0|SNRFOR|USD|MR14</CreditCurveId>
    <IssuerId>CompanyXZY</IssuerId>
    <SettlesAccrual>true</SettlesAccrual>
    <FixedRecoveryRate>0.6</FixedRecoveryRate>
    <ProtectionFee>
      <LegData>
        <LegType>Cashflow</LegType>
        <Payer>true</Payer>
        <Currency>EUR</Currency>
        <CashflowData>
          <Cashflow>
            <Amount date="2018-10-03">91171.72</Amount>
          </Cashflow>
        </CashflowData>
      </LegData>
    </ProtectionFee>
    <Underlying>
      <!-- Alternatives:
           - Sequence of LegData, possibly with OptionData to represent callability
           - A single block of TreasuryLockData -->
      <OptionData> ... </OptionData>
      <NakedOption> ... </NakedOption>
      <LegData>
        <LegType>Floating</LegType>
        ...
      </LegData>
      <LegData>
        <LegType>Fixed</LegType>
        <Payer>false</Payer>
        ...
      </LegData>
    </Underlying>
  </RiskParticipationAgreementData>
```

</div>

- ParticipationRate: The rate reflecting the participation amount
  relative to the swap volume.

  Allowable values: Any number between $0$ and $1$.

- ProtectionStart: The date on which the protection starts (inclusive).

  Allowable values: Any valid date, see See `Date` in Table
  <a href="#tab:allow_stand_data" data-reference-type="ref"
  data-reference="tab:allow_stand_data">[tab:allow_stand_data]</a>.

- ProtectionEnd: The date on which the protection ends (exclusive).

  Allowable values. Any valid date greater than the protection start
  date.

- CreditCurveId: Typically the RED-code of the underlying swap reference
  entity defining the default curve used for pricing. Other identifiers
  may be used as well, provided they are supported in the market data
  configuration.

  Allowable values: Any valid credit curve identifier.

- IssuerId \[Optional\]: An identifier for the underlying swap reference
  entity. For informational purposes and not used for pricing. Defaults
  to an empty string.

  Allowable values: Any string.

- SettlesAccrual \[Optional\]: Whether or not the accrued coupon of the
  protection fee is due in the event of a default. This defaults to
  `true` if not provided. Only applies to coupon legs (i.e. not simple
  cashflows) within the protection fee block, otherwise it is ignored.

  Allowable values: `true` or `false`

- FixedRecoveryRate \[Optional\]: This node holds the fixed recovery
  rate if the RPA assumes a fixed recovery to calculate the settlement
  amount in case of a default event. If the field is omitted the
  recovery rate associated to the credit curve is used instead.

  Allowable values: Any number between $0$ and $1$.

- ProtectionFee: The fees that are paid (if protection is bought) or
  received (if protection is sold). The fees are given by one or more
  legs as described under
  <a href="#ss:leg_data" data-reference-type="ref"
  data-reference="ss:leg_data">[ss:leg_data]</a> with identical Payer
  flags, typically this will be a single `Cashflow` leg holding zero or
  more fixed fee amounts or a `Fixed` leg representing a series of
  periodic fee payments. Fees are paid up to (but excluding) the default
  event. If the fees are given as coupons the accrued amount between the
  accrual start date and the default date is paid if and only if
  `SettlesAccrual` is set to ` true`. The protection fees can be given
  in any arbitrary currency.

- Underlying: The reference underlying. There are several subtypes to
  distinguish, all of which have separate pricing engines attached.
  There is no need to specify the subtype in the trade xml, this is
  deduced automatically during the trade building:

  - Vanilla Swap: This is a vanilla swap given by two legs in the same
    currency, one receiver, one payer and one Fixed (or Cashflow), one
    Floating. For the floating part only Ibor coupons (no averaging) or
    (compounded, averaging) OIS coupons are allowed. Spreads and
    gearings are allowed, but no embedded caps/floors, no in arrears
    fixings for Ibor coupons. This type allows an analytic Black engine
    where the RPA Options are found via a representative swaption
    matching.

  - Structured Swap: As vanilla, but an arbitrary number of legs of type
    Fixed, Floating, Cashflow is allowed. Embedded caps/floors/collars
    and in arrears fixing are allowed. For floating legs, Ibor (no
    averaging) and OIS (compounded, averaging) coupons are allowed. All
    legs must be in the same currency. Standalone caps, floors, collars
    are allowed as an underlying of the RPA, if specified by a floating
    leg with NakedOption set to true. See
    <a href="#ss:floatingleg_data" data-reference-type="ref"
    data-reference="ss:floatingleg_data">[ss:floatingleg_data]</a> for
    details on the floating leg specification, amd likewise
    <a href="#ss:fixedleg_data" data-reference-type="ref"
    data-reference="ss:fixedleg_data">[ss:fixedleg_data]</a> for the
    fixed leg and <a href="#ss:leg_data" data-reference-type="ref"
    data-reference="ss:leg_data">[ss:leg_data]</a> for the cashflow leg.
    This type requires a numeric grid engine.

  - Callable Swap / Swaption: As structured swap, but an additional
    OptionData block allows to specify callability of the swap. The
    relevant fields in OptionData are the same as for callable swaps,
    see <a href="#ss:callable_swap" data-reference-type="ref"
    data-reference="ss:callable_swap">[ss:callable_swap]</a>. This type
    requires a numeric grid engine as the structured swap. If
    NakedOption is set to true, an option to exercise into the
    underlying swap is represented, i.e. a swaption.

  - Cross Currency Swap: Underlying legs as in structured swap, but the
    legs can be in two different currencies. No optionality is allowed
    though. At most two different currencies are allowed. This type can
    be priced using an analytic Black engine which models the FX Risk
    and assumes deterministic interest rates.

  - T-Lock. The underlying is a T-Lock, represented as shown in listing
    <a href="#lst:tlock_data" data-reference-type="ref"
    data-reference="lst:tlock_data">[lst:tlock_data]</a> and explained
    in more detail below. This type requires a numeric grid engine.

<u>Treasury Lock Underlying Specification</u>

Listing <a href="#lst:tlock_data" data-reference-type="ref"
data-reference="lst:tlock_data">[lst:tlock_data]</a> shows the
specification of a T-Lock underlying. The fields have the following
meaning:

- Payer: Boolean, true if the fixed reference rate is paid, false
  otherwise. I.e. if the payer flag is true and the yield is lower than
  the reference rate, then the underlying T-Lock trade pays the amount
  $(r-y) \cdot d$ where $r$ is the reference rate, $y$ is the yield,
  both expressed in basis points, and $d>0$ is the (absolute) price
  change of the treasury bond when the yield moves by $1$ basis point.
  Likewise, if the yield is higher than the reference rate, the
  underlying T-Lock trade receives $(y-r) \cdot d$.  
  Allowable values: *true* or *false*

- BondData: Reference to the underlying security, given in the BondData
  sub node, minimum required data are notional and security ID  
  Allowable values: See <a href="#ss:bond" data-reference-type="ref"
  data-reference="ss:bond">[ss:bond]</a>

- ReferenceRate: Fixed rate paid or received on the T-Lock underlying  
  Allowable values: Any real number. The rate is expressed in decimal
  form, eg 0.05 is a rate of 5%

- DayCounter \[Optional\]: Reference rate day counter. Optional,
  defaults to the coupon day counter of the underlying bond.  
  Allowable values: See Table
  <a href="#tab:daycount" data-reference-type="ref"
  data-reference="tab:daycount">[tab:daycount]</a>

- TerminationDate: Date for the cash settlement amount calculation  
  Allowable values: See `Date` in Table
  <a href="#tab:allow_stand_data" data-reference-type="ref"
  data-reference="tab:allow_stand_data">[tab:allow_stand_data]</a>.

- PaymentGap \[Optional\]: Business day gap between termination and
  payment date. Optional, defaults to zero.  
  Allowable values: Any non-negative integer

- PaymentCalendar: Calendar to determine the payment date.  
  Allowable values: See Table
  <a href="#tab:calendar" data-reference-type="ref"
  data-reference="tab:calendar">[tab:calendar]</a>.

<div class="listing">

``` xml
    <Underlying>
      <TreasuryLockData>
      <Payer>true</Payer>
      <BondData>
      ...
      </BondData>
      <ReferenceRate>0.05</ReferenceRate>
      <DayCounter>A360</DayCounter>
      <TerminationDate>2022-01-05</TerminationDate>
      <PaymentGap>5</PaymentGap>
      <PaymentCalendar>US</PaymentCalendar>
      </TreasuryLockData>
    </Underlying>
```

</div>
