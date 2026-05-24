### Credit Linked Swap

A credit linked swap, trade type `CreditLinkedSwap`, is set up using a
`CreditLinkedSwapData` block as shown in listing
<a href="#lst:creditlinkedswap" data-reference-type="ref"
data-reference="lst:creditlinkedswap">[lst:creditlinkedswap]</a>. The
elements have the following meaning:

- CreditCurveId: The referenced CDS credit curve.  
  Allowable values: See `CreditCurveId` for credit trades - single name
  in Table <a href="#tab:equity_credit_data" data-reference-type="ref"
  data-reference="tab:equity_credit_data">[tab:equity_credit_data]</a>.
  A `ReferenceInformation` node may be used in place of this
  `CreditCurveId` node.

- SettlesAccrual \[Optional\]: A flag indicating whether accrued coupon
  amounts are paid in case of a credit event. Optional, defaults to
  `true`. Applies to the payments specified under ContingentPayments.  
  Allowable values: true, false

- FixedRecoveryRate \[Optional\]: A fixed (digital) recovery rate to
  apply. If not given, the market recovery rate is used. Applies to the
  payments specified under DefaultPayments and RecoveryPayments.  
  Allowable values: Any non-negative real number.

- DefaultPaymentTime \[Optional\]: Controls the timing of the payments
  specified under DefaultPayments and RecoveryPayments. Defaults to
  `atDefault`.  
  Allowable values: `atDefault`, `atPeriodEnd`, `atMaturity`.

- IndependentPayments \[Optional\]: The legs for which payments are made
  independent from credit events. The node contains one or more
  `LegData` subnodes representing these legs. Optional, can be omitted
  if no such payments are made.  
  Allowable values: See <a href="#ss:leg_data" data-reference-type="ref"
  data-reference="ss:leg_data">[ss:leg_data]</a> for the `LegData`
  subnode structure.

- ContingentPayments \[Optional\]: The legs for which payments are
  contingent on no credit event having occurred until the payment date.
  If no such payments are made, the node can be omitted.  
  Allowable values: See <a href="#ss:leg_data" data-reference-type="ref"
  data-reference="ss:leg_data">[ss:leg_data]</a> for the `LegData`
  subnode structure.

- DefaultPayments \[Optional\]: The legs for which payments are
  contingent on a credit event having occurred. If no such payments are
  made, the node can be omitted. If a default happens at a date d, the
  associated payment is the earliest payment with date greater or equal
  to d.  
  Allowable values: See <a href="#ss:leg_data" data-reference-type="ref"
  data-reference="ss:leg_data">[ss:leg_data]</a> for the `LegData`
  subnode structure.

- RecoveryPayments \[Optional\]: The legs for which payments are
  contingent on a credit event having occurred. The node works
  analogously to the DefaultPayments node, the only difference is that
  payment amounts are weighted by $RR$ instead of $1-RR$.  
  Allowable values: See <a href="#ss:leg_data" data-reference-type="ref"
  data-reference="ss:leg_data">[ss:leg_data]</a> for the `LegData`
  subnode structure.

All legs must be given in the same currency.

<div class="listing">

``` xml
  <CreditLinkedSwapData>
    <CreditCurveId>RED:46A844|SNRFOR|USD|XR14</CreditCurveId>
    <SettlesAccrual>false</SettlesAccrual>
    <FixedRecoveryRate>0.4</FixedRecoveryRate>
    <DefaultPaymentTime>atDefault</DefaultPaymentTime>
    <IndependentPayments>
      <LegData> ... </LegData>
      <LegData> ... </LegData>
      ...
    </IndependentPayments>
    <ContingentPayments>
      <LegData> ... </LegData>
      <LegData> ... </LegData>
      ...
    </ContingentPayments>
    <DefaultPayments>
      <LegData> ... </LegData>
      <LegData> ... </LegData>
      ...
    </DefaultPayments>
    <RecoveryPayments>
      <LegData> ... </LegData>
      <LegData> ... </LegData>
      ...
    </RecoveryPayments>
  </CreditLinkedSwapData>
```

</div>
