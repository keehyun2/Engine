### Bond Forward / T-Lock / J-Lock (using ref. data)

A Forward Bond (or Bond Forward) is a contract that establishes an
agreement to buy or sell (determined by `LongInForward`) an underlying
bond at a future point in time (the `ForwardMaturityDate`) at an agreed
price (the settlement `Amount`).

A T-Lock is a Forward Bond with a US Treasury Bond as underlying,
whereas a J-Lock is a Forward Bond with a Japanese Government Bond as
underlying. T-Locks can be specified in terms of a lock-in yield rather
then a settlement amount. The cash settlement amount is given by (bond
yield at maturity - lock rate) x DV01 in this case.

Listing <a href="#lst:forward_bond_refdata" data-reference-type="ref"
data-reference="lst:forward_bond_refdata">[lst:forward_bond_refdata]</a>
shows an example for a physically settled forward bond. Listing
<a href="#lst:forward_bond_refdata_tlock" data-reference-type="ref"
data-reference="lst:forward_bond_refdata_tlock">[lst:forward_bond_refdata_tlock]</a>
shows an example for a cash settled T-Lock transaction specified by a
lock-in yield.

A Forward Bond is set up using a `ForwardBondData` block as shown below
and the trade type is *ForwardBond*. The specific elements are

- The `BondData` block specifies the underlying bond, see below for more
  details.

  - SecurityId: The underlying security identifier  
    Allowable values: Typically the ISIN of the underlying bond, with
    the ISIN: prefix.

  - BondNotional: The notional of the underlying bond on which the
    forward is written expressed in the currency of the bond  
    Allowable values: Any positive real number.

  - CreditRisk \[Optional\] Boolean flag indicating whether to show
    Credit Risk on the Bond product. If set to *false*, the product
    class will be set to *RatesFX* instead of *Credit*, and there will
    be no credit sensitivities. Note that if the underlying bond
    reference is set up without a CreditCurveId - typically for some
    highly rated government bonds - the CreditRisk flag will have no
    impact on the product class and no credit sensitivities will be
    shown even if CreditRisk is set to *true*.  
    Allowable Values: *true* or *false* Defaults to *true* if left blank
    or omitted.

- SettlementData: The entity defining the terms of settlement:

  - ForwardMaturityDate: The date of maturity of the forward contract.  
    Allowable values: See `Date` in Table
    <a href="#tab:allow_stand_data" data-reference-type="ref"
    data-reference="tab:allow_stand_data">[tab:allow_stand_data]</a>.

  - ForwardSettlementDate \[Optional\]: Settlement date for forward bond
    or cash settlement payment date.  
    Allowable values: See `Date` in Table
    <a href="#tab:allow_stand_data" data-reference-type="ref"
    data-reference="tab:allow_stand_data">[tab:allow_stand_data]</a>.

  - Settlement \[Optional\]: Cash or Physical. Option, defaults to
    Physcial, except in case the settlement is defined by LockRate, in
    which case it defaults to Cash.  
    Allowable values: Cash, Physical

  - Amount \[Optional\]: The settlement amount (also called strike)
    transferred at forward maturity in return for either:  

    \(a\) the bond (physical delivery) or  

    \(b\) a cash amount equal to the dirty price of the bond (cash
    settlement).  

    This is transferred from the party that is long to the party that is
    short (determined by `LongInForward`) and cannot be a negative
    amount. It is assumed to be in the same currency as the underlying
    bond. Exactly one of the fields Amount, LockRate must be given.  
    Allowable values: Any non-negative real number.

  - LockRate \[Optional\]: The payoff is given by (yield at forward
    maturity - LockRate) x DV01 (LongInForward = true). Exactly one of
    the fields Amount, LockRate must be given. In case the LockRate is
    given, the Settlement must be set to Cash. If Settlement is not
    given, it defaults to Cash in this case.  
    Allowable values: Any non-negative real number. The LockRate is
    expressed in decimal form, eg 0.05 is a rate of 5%

  - dv01 \[Optional\]: When the LockRate is given, it is possible to
    implement a contractual DV01 instead of deriving it from the bond
    price.  
    Allowable values: Any positive real number. E.G If the dPdY is given
    then dv01=10000\*dPdY/N.

  - LockRateDayCounter \[Optional\]: The day counter w.r.t. which the
    lock rate is expressed. Optional, defaults to A360.  
    Allowable values: see table
    <a href="#tab:daycount" data-reference-type="ref"
    data-reference="tab:daycount">[tab:daycount]</a>

  - SettlementDirty \[Optional\]: A flag that determines whether the
    settlement amount (`Amount`) reflects a clean (*false*) or dirty
    (*true*) price. In either case, the dirty amount is actually paid on
    the forward maturity date, i.e. if SettlementDirty = *false*, the
    (forward) accruals are computed internally and added to the given
    amount to get the actual settlement amount. Optional, defaults to
    true.  
    Allowable values: *true*, *false*

- PremiumData: The entity defining the terms of a potential premium
  payment. This node is optional. If left out it is assumed that no
  premium is paid.

  - Date: The date when a premium is paid.  
    Allowable values: See `Date` in Table
    <a href="#tab:allow_stand_data" data-reference-type="ref"
    data-reference="tab:allow_stand_data">[tab:allow_stand_data]</a>.

  - Amount: The amount transferred as a premium. This is transferred
    from the party that is long to the party that is short (determined
    by `LongInForward`) and cannot be a negative amount. It is assumed
    to be in the same currency as the underlying bond.  
    Allowable values: Any non-negative real number.

- LongInForward: A flag that determines whether the forward contract is
  entered in long (*true*) or short (*false*) position.  
  Allowable values: *true*, *false*

<div class="listing">

``` xml
   <ForwardBondData>
     <BondData>
       <SecurityId>ISIN:XS1234567890</SecurityId>
       <BondNotional>100000</BondNotional>
     <BondData>
     <SettlementData>
       <ForwardMaturityDate>20160808</ForwardMaturityDate>
       <Settlement>Physcial</Settlement>
       <ForwardSettlementDate>20160810</ForwardSettlementDate>
       <Amount>1000000.00</Amount>
       <SettlementDirty>true</SettlementDirty>
     </SettlementData>
     <PremiumData>
       <Amount>1000.00</Amount>
       <Date>20160808</Date>
     </PremiumData>
     <LongInForward>true</LongInForward>
   </ForwardBondData>
```

</div>

<div class="listing">

``` xml
   <ForwardBondData>
     <BondData>
       <SecurityId>ISIN:XS1234567890</SecurityId>
       <BondNotional>100000</BondNotional>
     </BondData>
     <SettlementData>
       <ForwardMaturityDate>20160808</ForwardMaturityDate>
       <ForwardSettlementDate>20160810</ForwardSettlementDate>
       <LockRate>0.02365</LockRate>
     </SettlementData>
     <LongInForward>true</LongInForward>
   </ForwardBondData>
```

</div>

<div class="listing">

``` xml
        <ForwardBondData>
        <BondData>
          <SecurityId>ISIN:XS1234567890</SecurityId>
          <BondNotional>100000</BondNotional>
        </BondData>
        <SettlementData>
          <ForwardMaturityDate>20160808</ForwardMaturityDate>
          <ForwardSettlementDate>20160810</ForwardSettlementDate>
          <LockRate>0.02365</LockRate>
          <dv01>0.8</dv01>
        </SettlementData>
        <LongInForward>true</LongInForward>
        </ForwardBondData>
```

</div>
