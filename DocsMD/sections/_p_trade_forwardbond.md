### Forward Bond

A Forward Bond (or Bond Forward) is a contract that establishes an
agreement to buy or sell (determined by `LongInForward`) an underlying
bond at a future point in time (the `ForwardMaturityDate`) at an agreed
price (the settlement `Amount`).

A T-Lock is a Forward Bond with a US Treasury Bond as underlying,
whereas a J-Lock is a Forward Bond with a Japanese Government Bond as
underlying. T-Locks can be specified in terms of a lock-in yield rather
then a settlement amount. The cash settlement amount is given by (bond
yield at maturity - lock rate) x DV01 in this case.

Listing <a href="#lst:forward_bond" data-reference-type="ref"
data-reference="lst:forward_bond">[lst:forward_bond]</a> shows an
example for a physically settled forward bond. Listing
<a href="#lst:forward_bond_tlock" data-reference-type="ref"
data-reference="lst:forward_bond_tlock">[lst:forward_bond_tlock]</a>
shows an example for a cash settled T-Lock transaction specified by a
lock-in yield.

A Forward Bond is set up using a `ForwardBondData` block as shown below
and the trade type is *ForwardBond*. The specific elements are

- BondData: A `BondData` block specifying the underlying bond as
  described in section <a href="#ss:bond" data-reference-type="ref"
  data-reference="ss:bond">[ss:bond]</a>. A long position must be taken
  in the bond, i.e. (`Payer`) flag must be set to (`true`). The bond
  data block contains additional fields for forward bonds

  - IncomeCurveId: The benchmark curve to be used for compounding, this
    must match a name of a curve in the yield curves or index curve
    block in `todaysmarket.xml`. It is optional to provide this curve.
    If left out the market reference yield curve from `todaysmarket.xml`
    is used for compounding.

- SettlementData: The entity defining the terms of settlement:

  - ForwardMaturityDate: The date of maturity of the forward contract.  
    Allowable values: See `Date` in Table
    <a href="#tab:allow_stand_data" data-reference-type="ref"
    data-reference="tab:allow_stand_data">[tab:allow_stand_data]</a>.

  - Settlement \[Optional\]: Cash or Physical. Option, defaults to
    Physcial, except in case the settlement is defined by LockRate, in
    which case it defaults to Cash.  
    Allowable values: Cash, Physical

  - Amount \[Optional\]: The settlement amount (also called strike)
    transferred at forward maturity in return for the bond (physical
    delivery) or a cash amount equal to the dirty price of the bond
    (cash settlement). This is transferred from the party that is long
    to the party that is short (determined by `LongInForward`) and
    cannot be a negative amount. It is assumed to be in the same
    currency as the underlying bond. Exactly one of the fields Amount,
    LockRate must be given.  
    Allowable values: Any non-negative real number.

  - LockRate \[Optional\]: The payoff is given by (yield at forward
    maturity - LockRate) x DV01 (LongInForward = true). Exactly one of
    the fields Amount, LockRate must be given. In case the LockRate is
    given, the Settlement must be set to Cash. If Settlement is not
    given, it defaults to Cash in this case.  
    Allowable values: Any non-negative real number.

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

- KnockOut \[Optional\]: If true the contract terminates without payout
  if the underlying bond defaults before the forward maturity date. If
  not given, defaults to false for a vanilla payoff and true for a lock
  rate payoff.  
  Allowable values: *true*, *false*

<div class="listing">

``` xml
   <ForwardBondData>
     <BondData>
      ...
      <IncomeCurveId>BENCHMARKINCOME-EUR<IncomeCurveId>
     </BondData>
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
      ...
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

As for the ordinary bond the forward bond pricing requires a recovery
rate that can be specified in ORE per SecurityId.

### Forward Bond - Pricing Engine configuration

The configuration for the pricing engine of the forward bond is
identical to the ordinary bond. The pricing engine called by forward
bond products is the `DiscountingForwardBondEngine`, see below for a
configuration example.

``` xml
   <Product type="ForwardBond">
   <Model>DiscountedCashflows</Model>
   <ModelParameters></ModelParameters>
   <Engine>DiscountingForwardBondEngine</Engine>
   <EngineParameters>
    <Parameter name="TimestepPeriod">3M</Parameter>
   </EngineParameters>
   </Product>
```
