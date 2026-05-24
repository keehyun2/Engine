## Conventions: `conventions.xml`

The conventions to associate with a set market quotes in the
construction of termstructures are specified in another xml file which
we will refer to as `conventions.xml` in the following though the file
name can be chosen by the user. Each separate set of conventions is
stored in an XML node. The type of conventions that a node holds is
determined by the node name. Every node has an `Id` node that gives a
unique identifier for the convention set. The following sections
describe the type of conventions that can be created and the allowed
values.

### Zero Conventions

A node with name *Zero* is used to store conventions for direct zero
rate quotes. Direct zero rate quotes can be given with an explicit
maturity date or with a tenor and a set of conventions from which the
maturity date is deduced. The node for a zero rate quote with an
explicit maturity date is shown in Listing
<a href="#lst:zero_conventions_date" data-reference-type="ref"
data-reference="lst:zero_conventions_date">[lst:zero_conventions_date]</a>.
The node for a tenor based zero rate is shown in Listing
<a href="#lst:zero_conventions_tenor" data-reference-type="ref"
data-reference="lst:zero_conventions_tenor">[lst:zero_conventions_tenor]</a>.

<div class="listing">

``` xml
<Zero>
  <Id> </Id>
  <TenorBased>False</TenorBased>
  <DayCounter> </DayCounter>
  <CompoundingFrequency> </CompoundingFrequency>
  <Compounding> </Compounding>
</Zero>
```

</div>

<div class="listing">

``` xml
<Zero>
  <Id> </Id>
  <TenorBased>True</TenorBased>
  <DayCounter> </DayCounter>
  <CompoundingFrequency> </CompoundingFrequency>
  <Compounding> </Compounding>
  <TenorCalendar> </TenorCalendar>
  <SpotLag> </SpotLag>
  <SpotCalendar> </SpotCalendar>
  <RollConvention> </RollConvention>
  <EOM> </EOM>
</Zero>
```

</div>

The meanings of the various elements in this node are as follows:

- TenorBased: True if the conventions are for a tenor based zero quote
  and False if they are for a zero quote with an explicit maturity date.

- DayCounter: The day count basis associated with the zero rate quote
  (for choices see section
  <a href="#sec:allowable_values" data-reference-type="ref"
  data-reference="sec:allowable_values">[sec:allowable_values]</a>)

- CompoundingFrequency: The frequency of compounding (Choices are *Once,
  Annual, Semiannual, Quarterly, Bimonthly, Monthly, Weekly, Daily*).

- Compounding: The type of compounding for the zero rate (Choices are
  *Simple, Compounded, Continuous, SimpleThenCompounded*).

- TenorCalendar: The calendar used to advance from the spot date to the
  maturity date by the zero rate tenor (for choices see section
  <a href="#sec:allowable_values" data-reference-type="ref"
  data-reference="sec:allowable_values">[sec:allowable_values]</a>).

- SpotLag \[Optional\]: The number of business days to advance from the
  valuation date before applying the zero rate tenor. If not provided,
  this defaults to 0.

- SpotCalendar \[Optional\]: The calendar to use for business days when
  applying the `SpotLag`. If not provided, it defaults to a calendar
  with no holidays.

- RollConvention \[Optional\]: The roll convention to use when applying
  the zero rate tenor. If not provided, it defaults to Following
  (Choices are *Backward, Forward, Zero, ThirdWednesday, Twentieth,
  TwentiethIMM, CDS, ThirdThursday, ThirdFriday, MondayAfterThirdFriday,
  TuesdayAfterThirdFriday, LastWednesday*).

- EOM \[Optional\]: Whether or not to use the end of month convention
  when applying the zero rate tenor. If not provided, it defaults to
  false.

### Deposit Conventions

A node with name *Deposit* is used to store conventions for deposit or
index fixing quotes. The conventions can be index based, in which case
all necessary conventions are deduced from a given index family. The
structure of the index based node is shown in Listing
<a href="#lst:deposit_conventions_index" data-reference-type="ref"
data-reference="lst:deposit_conventions_index">[lst:deposit_conventions_index]</a>.
Alternatively, all the necessary conventions can be given explicitly
without reference to an index family. The structure of this node is
shown in Listing
<a href="#lst:deposit_conventions_explicit" data-reference-type="ref"
data-reference="lst:deposit_conventions_explicit">[lst:deposit_conventions_explicit]</a>.

<div class="listing">

``` xml
<Deposit>
  <Id> </Id>
  <IndexBased>True</IndexBased>
  <Index> </Index>
</Deposit>
```

</div>

<div class="listing">

``` xml
<Deposit>
  <Id> </Id>
  <IndexBased>False</IndexBased>
  <Calendar> </Calendar>
  <Convention> </Convention>
  <EOM> </EOM>
  <DayCounter> </DayCounter>
</Deposit>
```

</div>

The meanings of the various elements in this node are as follows:

- IndexBased: *True* if the deposit conventions are index based and
  *False* if the conventions are given explicitly.

- Index: The index family from which to imply the conventions for the
  deposit quote. For example, this could be EUR-EURIBOR, USD-LIBOR etc.

- Calendar: The business day calendar for the deposit quote.

- Convention: The roll convention for the deposit quote.

- EOM: *True* if the end of month roll convention is to be used for the
  deposit quote and *False* if not.

- DayCounter: The day count basis associated with the deposit quote.

### Future Conventions

A node with name *Future* is used to store conventions for money market
(MM) or overnight index (OI) interest rate future quotes, for example
futures on Euribor 3M or SOFR 3M underlyings. The structure of this node
is shown in Listing
<a href="#lst:future_conventions" data-reference-type="ref"
data-reference="lst:future_conventions">[lst:future_conventions]</a>.
The fields have the following meaning:

- Id: The name of the convention.

- Index: The underlying index of the futures, this is either a MM (i.e.
  Ibor) index like e.g. EUR-EURIBOR-3M or an overnight index like e.g.
  USD-SOFR.

- DateGenerationRule \[Optional\]: This should be set to ‘IMM’ when the
  start and end dates of the future are following the IMM date logic,
  ‘FirstDayOfMonth’ when the start and end date are the first day of a
  month, or ‘SecondThursday’ when the expiry date is the second Thursday
  of the month. If not given this field defaults to ‘IMM’.

  - For MM futures ‘IMM’ or ‘SecondThursday’ are allowed. The expiry
    date for ‘IMM’ is determined as the next 3rd Wednesday of the expiry
    month of a future. The expiry date for ‘SecondThursday’ is
    determined as the 2nd Thursday of the expiry month (e.g. used for
    AUD-BBSW-3M futures).

  - For an overnight index future ‘IMM’ means that the end date of the
    future is set to the 3rd Wednesday of the expiry month and the start
    date is set to the 3rd Wednesday of the expiry month minus the
    future tenor. The setting ‘IMM’ applies to SOFR-3M futures for
    example. ‘FirstDayOfMonth’ on the other hand means that the end date
    of the future is set to the first day in the month following the
    future’s expiry month and the start date is set to the first day of
    the month lying $n$ months before the end date’s month where $n$ is
    the number of months of the future’s underlying tenor. The setting
    ‘FirstDayOfMonth’ applies to SOFR-1M futures for example. For
    ‘FirstDayOfMonth’ the start and end date are adjusted to the next
    business day w.r.t. roll convention ‘following’ and the overnight
    index calendar - or if given the calendar given in the field
    ‘Calendar’. This tenor is derived from the market quote, see
    <a href="#ss:market_data_oi_index_future_prices"
    data-reference-type="ref"
    data-reference="ss:market_data_oi_index_future_prices">[ss:market_data_oi_index_future_prices]</a>.

- Calendar: Only applicable to overnight index futures with date
  generation rule ‘FirstDayOfMonth’. Overwrites the calendar used to
  adjust the start and end date of the future. Optional, if not given,
  the overnight index publishing calendar will be used to adjust the
  future start and end date.

- OvernightIndexFutureNettingType \[Optional\]: Only relevant for OI
  futures. Can be ‘Compounding’ (which is also the default value if no
  value is given) or ‘Averaging’. For example, SOFR 3M futures are
  compounding while SOFR 1M futures are averaging the daily overnight
  fixings over the calculation period of the future.

Listings
<a href="#lst:future_conventions_euribor_3m" data-reference-type="ref"
data-reference="lst:future_conventions_euribor_3m">[lst:future_conventions_euribor_3m]</a>,
<a href="#lst:future_conventions_aud_bbsw_3m" data-reference-type="ref"
data-reference="lst:future_conventions_aud_bbsw_3m">[lst:future_conventions_aud_bbsw_3m]</a>,
<a href="#lst:future_conventions_sofr_3m" data-reference-type="ref"
data-reference="lst:future_conventions_sofr_3m">[lst:future_conventions_sofr_3m]</a>,
<a href="#lst:future_conventions_sofr_1m" data-reference-type="ref"
data-reference="lst:future_conventions_sofr_1m">[lst:future_conventions_sofr_1m]</a>
show examples for Euribor-3M, AUD-BBSW-3M, SOFR-3M and SOFR-1M future
conventions.

<div class="listing">

``` xml
<Future>
  <Id> </Id>
  <Index> </Index>
  <DateGenerationRule> </DateGenerationRule>
  <OvernightIndexFutureNettingType> </OvernightIndexFutureNettingType>
</Future>
```

</div>

<div class="listing">

``` xml
<Future>
  <Id>EURIBOR-3M-FUTURES</Id>
  <Index>EUR-EURIBOR-3M</Index>
</Future>
```

</div>

<div class="listing">

``` xml
<Future>
  <Id>AUD-BBSW-3M-FUTURES-CONVENTIONS</Id>
  <Index>AUD-BBSW-3M</Index>
  <DateGenerationRule>SecondThursday</DateGenerationRule>
</Future>
```

</div>

<div class="listing">

``` xml
  <Future>
    <Id>USD-SOFR-3M-FUTURES</Id>
    <Index>USD-SOFR</Index>
    <DateGenerationRule>IMM</DateGenerationRule>
    <OvernightIndexFutureNettingType>Compounding</OvernightIndexFutureNettingType>
  </Future>
```

</div>

<div class="listing">

``` xml
  <Future>
    <Id>USD-SOFR-1M-FUTURES</Id>
    <Index>USD-SOFR</Index>
    <DateGenerationRule>FirstDayOfMonth</DateGenerationRule>
    <Calendar>CME</Calendar>
    <OvernightIndexFutureNettingType>Averaging</OvernightIndexFutureNettingType>
  </Future>
```

</div>

### FRA Conventions

A node with name *FRA* is used to store conventions for FRA quotes. The
structure of this node is shown in Listing
<a href="#lst:fra_conventions" data-reference-type="ref"
data-reference="lst:fra_conventions">[lst:fra_conventions]</a>. The only
piece of information needed is the underlying index name and this is
given in the `Index` node. For example, this could be EUR-EURIBOR-6M,
CHF-LIBOR-6M etc.

<div class="listing">

``` xml
<FRA>
  <Id> </Id>
  <Index> </Index>
</FRA>
```

</div>

### OIS Conventions

A node with name *OIS* is used to store conventions for Overnight
Indexed Swap (OIS) quotes. The structure of this node is shown in
Listing <a href="#lst:ois_conventions" data-reference-type="ref"
data-reference="lst:ois_conventions">[lst:ois_conventions]</a>.

<div class="listing">

``` xml
<OIS>
  <Id> </Id>
  <SpotLag> </SpotLag>
  <Index> </Index>
  <FixedDayCounter> </FixedDayCounter>
  <FixedCalendar> </FixedCalendar>
  <PaymentLag> </PaymentLag>
  <EOM> </EOM>
  <FixedFrequency> </FixedFrequency>
  <FixedConvention> </FixedConvention>
  <FixedPaymentConvention> </FixedPaymentConvention>
  <Rule> </Rule>
  <PaymentCalendar> </PaymentCalendar>
  <RateCutoff> </RateCutoff>
</OIS>
```

</div>

The meanings of the various elements in this node are as follows:

- SpotLag: The number of business days until the start of the OIS.

- Index: The name of the overnight index. For example, this could be
  EUR-EONIA, USD-FedFunds etc.

- FixedDayCounter: The day count basis on the fixed leg of the OIS.

- FixedCalendar \[Optional\]: The business day calendar on the fixed
  leg. Optional to retain backwards compatibility with older versions,
  if not given defaults to index fixing calendar.

- PaymentLag \[Optional\]: The payment lag, as a number of business
  days, on both legs. If not provided, this defaults to 0.

- EOM \[Optional\]: *True* if the end of month roll convention is to be
  used when generating the OIS schedule and *False* if not. If not
  provided, this defaults to *False*.

- FixedFrequency \[Optional\]: The frequency of payments on the fixed
  leg. If not provided, this defaults to *Annual*.

- FixedConvention \[Optional\]: The roll convention for accruals on the
  fixed leg. If not provided, this defaults to *Following*.

- FixedPaymentConvention \[Optional\]: The roll convention for payments
  on the fixed leg. If not provided, this defaults to *Following*.

- Rule \[Optional\]: The rule used for generating the OIS dates schedule
  i.e. *Backward* or *Forward*. If not provided, this defaults to
  *Backward*.

- PaymentCalendar \[Optional\]: The business day calendar used for
  determining coupon payment dates. If not specified, this defaults to
  the fixing calendar defined on the overnight index.

- RateCutoff: The rate cut-off on the overnight leg. Generally, the
  overnight fixing is only observed up to a certain number of days
  before the end of the interest period date. The last observed rate is
  applied for the remaining days in the period. This rate cut-off gives
  the number of days e.g. 1 for ESTR or SOFR. If not specified, this
  defaults to 0 days.

### Swap Conventions

A node with name *Swap* is used to store conventions for vanilla
interest rate swap (IRS) quotes. The structure of this node is shown in
Listing <a href="#lst:swap_conventions" data-reference-type="ref"
data-reference="lst:swap_conventions">[lst:swap_conventions]</a>.

<div class="listing">

``` xml
<Swap>
  <Id> </Id>
  <FixedCalendar> </FixedCalendar>
  <FixedFrequency> </FixedFrequency>
  <FixedConvention> </FixedConvention>
  <FixedDayCounter> </FixedDayCounter>
  <Index> </Index>
  <FloatFrequency> </FloatFrequency>
  <SubPeriodsCouponType> </SubPeriodsCouponType>
</Swap>
```

</div>

The meanings of the various elements in this node are as follows:

- FixedCalendar: The business day calendar on the fixed leg.

- FixedFrequency: The frequency of payments on the fixed leg.

- FixedConvention: The roll convention on the fixed leg.

- FixedDayCounter: The day count basis on the fixed leg.

- Index: The Ibor index on the floating leg.

- FloatFrequency \[Optional\]: The frequency of payments on the floating
  leg, to be used if the frequency is different to the tenor of the
  index (e.g. CAD swaps for BA-3M have a 6M or 1Y payment frequency with
  a Compounding coupon)

- SubPeriodsCouponType \[Optional\]: Defines how coupon rates should be
  calculated when the float frequency is different to that of the index.
  Possible values are “Compounding” and “Averaging”.

### Average OIS Conventions

A node with name *AverageOIS* is used to store conventions for average
OIS quotes. An average OIS is a swap where a fixed rate is swapped
against a daily averaged overnight index plus a spread. The structure of
this node is shown in Listing
<a href="#lst:average_ois_conventions" data-reference-type="ref"
data-reference="lst:average_ois_conventions">[lst:average_ois_conventions]</a>.

<div class="listing">

``` xml
<AverageOIS>
  <Id> </Id>
  <SpotLag> </SpotLag>
  <FixedTenor> </FixedTenor>
  <FixedDayCounter> </FixedDayCounter>
  <FixedCalendar> </FixedCalendar>
  <FixedConvention> </FixedConvention>
  <FixedPaymentConvention> </FixedPaymentConvention>
  <FixedFrequency> </FixedFrequency>
  <Index> </Index>
  <OnTenor> </OnTenor>
  <RateCutoff> </RateCutoff>
</AverageOIS>
```

</div>

The meanings of the various elements in this node are as follows:

- SpotLag: Number of business days until the start of the average OIS.

- FixedTenor: The frequency of payments on the fixed leg.

- FixedDayCounter: The day count basis on the fixed leg.

- FixedCalendar: The business day calendar on the fixed leg.

- FixedFrequency: The frequency of payments on the fixed leg.

- FixedConvention: The roll convention for accruals on the fixed leg.

- FixedPaymentConvention: The roll convention for payments on the fixed
  leg.

- FixedFrequency \[Optional\]: The frequency of payments on the fixed
  leg. If not provided, this defaults to *Annual*.

- Index: The name of the overnight index.

- OnTenor: The frequency of payments on the overnight leg.

- RateCutoff: The rate cut-off on the overnight leg. Generally, the
  overnight fixing is only observed up to a certain number of days
  before the payment date and the last observed rate is applied for the
  remaining days in the period. This rate cut-off gives the number of
  days e.g. 2 for Fed Funds average OIS.

### Tenor Basis Swap Conventions

A node with name *TenorBasisSwap* is used to store conventions for tenor
basis swap quotes. The structure of this node is shown in Listing
<a href="#lst:tenor_basis_conventions" data-reference-type="ref"
data-reference="lst:tenor_basis_conventions">[lst:tenor_basis_conventions]</a>.

<div class="listing">

``` xml
<TenorBasisSwap>
  <Id> </Id>
  <PayIndex> </PayIndex>
  <PayFrequency> </PayFrequency>
  <ReceiveIndex> </ReceiveIndex>
  <ReceiveFrequency> </ReceiveFrequency>
  <SpreadOnRec> </SpreadOnRec>
  <IncludeSpread> </IncludeSpread>
  <SubPeriodsCouponType> </SubPeriodsCouponType>
</TenorBasisSwap>
```

</div>

The meanings of the various elements in this node are as follows:

- PayIndex: The name of Ibor/Overnight Index of the pay leg.

- PayFrequency \[Optional\]: The frequency of payments on the PayIndex
  leg. This is usually the same as the PayIndex’s tenor. However, it can
  also be longer, e.g. overnight indexed vs overnight indexed basis
  swaps that may be quarterly on both legs. If not provided, this
  defaults to the PayIndex’s tenor.

- ReceiveIndex: The name of Ibor/Overnight Index of the receive leg.

- ReceiveFrequency \[Optional\]: The frequency of payments on the
  ReceiveIndex leg. This is usually the same as the ReceiveIndex’s
  tenor. However, it can also be longer, e.g. overnight indexed vs
  overnight indexed basis swaps that may be quarterly on both legs. If
  not provided, this defaults to the ReceiveIndex’s tenor.

- SpreadOnRec \[Optional\]: *True* if the tenor basis swap quote has the
  spread on the pay index leg and *False* if not. If not provided, this
  defaults to *True*.

- IncludeSpread \[Optional\]: *True* if the tenor basis swap spread is
  to be included when compounding is performed on the spread leg and
  *False* if not. If not provided, this defaults to *False*.

- SubPeriodsCouponType \[Optional\]: This field can have the value
  *Compounding* or *Averaging*. It applies to Ibor vs OI and Ibor vs
  Ibor basis swaps when the frequency of payments on the spread leg does
  not equal the spread leg index’s tenor. If *Compounding* is specified,
  then the spread tenor Ibor index is compounded and paid on the
  frequency specified in the corresponding node. If *Averaging* is
  specified, then the short tenor Ibor index is averaged and paid on the
  frequency specified in the corresponding node.

### Tenor Basis Two Swap Conventions

A node with name *TenorBasisTwoSwap* is used to store conventions for
tenor basis swap quotes where the quote is the spread between the fair
fixed rate on two swaps against Ibor indices of different tenors. We
call the swap against the Ibor index of longer tenor the long swap and
the remaining swap the short swap. The structure of the tenor basis two
swap conventions node is shown in Listing
<a href="#lst:tenor_basis_two_conventions" data-reference-type="ref"
data-reference="lst:tenor_basis_two_conventions">[lst:tenor_basis_two_conventions]</a>.

<div class="listing">

``` xml
<TenorBasisTwoSwap>
  <Id> </Id>
  <Calendar> </Calendar>
  <LongFixedFrequency> </LongFixedFrequency>
  <LongFixedConvention> </LongFixedConvention>
  <LongFixedDayCounter> </LongFixedDayCounter>
  <LongIndex> </LongIndex>
  <ShortFixedFrequency> </ShortFixedFrequency>
  <ShortFixedConvention> </ShortFixedConvention>
  <ShortFixedDayCounter> </ShortFixedDayCounter>
  <ShortIndex> </ShortIndex>
  <LongMinusShort> </LongMinusShort>
</TenorBasisTwoSwap>
```

</div>

The meanings of the various elements in this node are as follows:

- Calendar: The business day calendar on both swaps.

- LongFixedFrequency: The frequency of payments on the fixed leg of the
  long swap.

- LongFixedConvention: The roll convention on the fixed leg of the long
  swap.

- LongFixedDayCounter: The day count basis on the fixed leg of the long
  swap.

- LongIndex: The Ibor index on the floating leg of the long swap.

- ShortFixedFrequency: The frequency of payments on the fixed leg of the
  short swap.

- ShortFixedConvention: The roll convention on the fixed leg of the
  short swap.

- ShortFixedDayCounter: The day count basis on the fixed leg of the
  short swap.

- ShortIndex: The Ibor index on the floating leg of the short swap.

- LongMinusShort \[Optional\]: *True* if the basis swap spread is to be
  interpreted as the fair rate on the long swap minus the fair rate on
  the short swap and *False* if the basis swap spread is to be
  interpreted as the fair rate on the short swap minus the fair rate on
  the long swap. If not provided, it defaults to *True*.

### BMA / SIFMA Basis Swap Conventions

A node with name *BMABasisSwap* is used to store conventions for BMA /
SIFMA Basis Swap quotes. The structure of this node is shown in Listing
<a href="#lst:ois_conventions" data-reference-type="ref"
data-reference="lst:ois_conventions">[lst:ois_conventions]</a>.

<div class="listing">

``` xml
<BMABasisSwap>
  <Id> </Id>
  <Index> </Index>
  <BMAIndex> </BMAIndex>
  <BMAPaymentCalendar> </BMAPaymentCalendar>
  <BMAPaymentConvention> </BMAPaymentConvention>
  <BMAPaymentLag> </BMAPaymentLag>
  <IndexPaymentCalendar> </IndexPaymentCalendar>
  <IndexPaymentConvention> </IndexPaymentConvention>
  <IndexPaymentLag> </IndexPaymentLag>
  <IndexSettlementDays> </IndexSettlementDays>
  <IndexPaymentPeriod> </IndexPaymentPeriod>
  <OvernightLockoutDays> </OvernightLockoutDays>
</BMABasisSwap>
```

</div>

The meanings of the various elements in this node are as follows:

- Index: The name of an ibor, term rate or overnight index, e.g.
  USD-LIBOR-3M, USD-SOFR-3M, USD-SOFR

- BMAIndex: The name of a BMA / SIFMA index, e.g. USD-SIFMA

- BmaPaymentCalendar \[Optional\]: The payment calendar of the BMA /
  SIFMA leg. If not specified, defaults to BMA index fixing calendar.

- BmaPaymentConvention \[Optional\]: The payment convention of the BMA /
  SIFMA leg. If not specified, defaults to Following.

- BmaPaymentLag \[Optional\]: The payment lag of the BMA / SIFMA leg. If
  not specified, defaults to $0$.

- IndexPaymentCalendar \[Optional\]: The payment calendar of the
  reference leg. If not specified, defaults to index fixing calendar.

- IndexPaymentConvention \[Optional\]: The payment convention of the
  reference leg. If not specified, defaults to Following.

- IndexPaymentLag \[Optional\]: The payment lag of the reference leg. If
  not specified, defaults to $0$.

- IndexSettlementDays \[Optional\]: The settlement days of the reference
  leg. If not specified, defaults to bma index fixing days.

- IndexPaymentPeriod \[Optional\]: The payment period of the reference
  leg. If not specified, defaults to bma index tenor if reference index
  is overnight, otherwise to reference index tenor.

- OvernightLockoutDays \[Optional\]: Lockout days (rate cutoff) for the
  reference leg, if index is overnight.

### FX Conventions

A node with name *FX* is used to store conventions for FX spot and
forward quotes for a given currency pair. The structure of this node is
shown in Listing <a href="#lst:fx_conventions" data-reference-type="ref"
data-reference="lst:fx_conventions">[lst:fx_conventions]</a>.

<div class="listing">

``` xml
<FX>
  <Id> </Id>
  <SpotDays> </SpotDays>
  <SourceCurrency> </SourceCurrency>
  <TargetCurrency> </TargetCurrency>
  <PointsFactor> </PointsFactor>
  <AdvanceCalendar> </AdvanceCalendar>
  <SpotRelative> </SpotRelative>
  <EOM> </EOM>
  <Convention> </Convention>
</FX>
```

</div>

The meanings of the various elements in this node are as follows:

- SpotDays: The number of business days to spot for the currency pair.

- SourceCurrency: The source currency of the currency pair. The FX quote
  is assumed to give the number of units of target currency per unit of
  source currency.

- TargetCurrency: The target currency of the currency pair.

- PointsFactor: The number by which a points quote for the currency pair
  should be divided before adding it to the spot quote to obtain the
  forward rate.

- AdvanceCalendar \[Optional\]: The business day calendar(s) used for
  advancing dates for both spot and forwards. If not provided, it
  defaults to a calendar with no holidays.

- SpotRelative \[Optional\]: *True* if the forward tenor is to be
  interpreted as being relative to the spot date. *False* if the forward
  tenor is to be interpreted as being relative to the valuation date. If
  not provided, it defaults to *True*.

- EOM \[Optional\]: A flag indicating whether the end of month roll
  convention is to be used for FX forward quotes. If not provided, it
  defaults to *False*.

- Convention \[Optional\]: The business day convention used when
  advancing dates. If not provided, it defaults to *Following*.

### Cross Currency Basis Swap Conventions

A node with name *CrossCurrencyBasis* is used to store conventions for
cross currency basis swap quotes. The structure of this node is shown in
Listing <a href="#lst:xccy_basis_conventions" data-reference-type="ref"
data-reference="lst:xccy_basis_conventions">[lst:xccy_basis_conventions]</a>.

<div class="listing">

``` xml
<CrossCurrencyBasis>
  <Id> </Id>
  <SettlementDays> </SettlementDays>
  <SettlementCalendar> </SettlementCalendar>
  <RollConvention> </RollConvention>
  <FlatIndex> </FlatIndex>
  <SpreadIndex> </SpreadIndex>
  <EOM> </EOM>
  <IsResettable> </IsResettable>
  <FlatIndexIsResettable> </FlatIndexIsResettable>>
  <PaymentLag> </PaymentLag>
  <FlatPaymentLag> </FlatPaymentLag>
  <!-- for OIS only -->
  <IncludeSpread> </IncludeSpread>
  <Lookback> </Lookback>
  <FixingDays> </FixingDays>
  <RateCutoff> </RateCutoff>
  <IsAveraged> </IsAveraged>
  <FlatIncludeSpread> </FlatIncludeSpread>
  <FlatLookback> </FlatLookback>
  <FlatFixingDays> </FlatFixingDays>
  <FlatRateCutoff> </FlatRateCutoff>
  <FlatIsAveraged> </FlatIsAveraged>
</CrossCurrencyBasis>
```

</div>

The meanings of the various elements in this node are as follows:

- SettlementDays: The number of business days to the start of the cross
  currency basis swap.

- SettlementCalendar: The business day calendar(s) for both legs and to
  arrive at the settlement date using the SettlementDays above.

- RollConvention: The roll convention for both legs.

- FlatIndex: The name of the index on the leg that does not have the
  cross currency basis spread.

- SpreadIndex: The name of the index on the leg that has the cross
  currency basis spread.

- EOM \[Optional\]: *True* if the end of month convention is to be used
  when generating the schedule on both legs, and *False* if not. If not
  provided, it defaults to *False*.

- IsResettable \[Optional\]: *True* if the swap is mark-to-market
  resetting, and *False* otherwise. If not provided, it defaults to
  *False*.

- FlatIndexIsResettable \[Optional\]: *True* if it is the notional on
  the leg paying the flat index that resets, and *False* otherwise. If
  not provided, it defaults to *True*.

- FlatTenor \[Optional\]: the flat leg period length (typical value is
  3M), defaults to index tenor except for ON indices for which it
  defaults to 3M

- SpreadTenor \[Optional\]: the spread leg period length (typical value
  is 3M), defaults to index tenor except for ON indices for which it
  defaults to 3M

- SpreadPaymentLag \[Optional\]: the payment lag for the spread leg,
  allowable values are 0, 1, 2, ..., defaults to 0 if not given

- FlatPaymentLag \[Optional\]: the payment lag for the flat leg,
  allowable values are 0, 1, 2, ..., defaults to 0 if nove given

- SpreadIncludeSpread \[Optional\]: Only relevant if spread leg is OIS,
  allowable values are true, false, defaults to false if not given

- SpreadLookback \[Optional\]: Only relevant if spread leg is OIS,
  allowable values are 0D, 1D, ..., defaults to 0D if not given

- SpreadFixingDays \[Optional\]: Only relevant if spread leg is OIS,
  allowable values are 0, 1, 2, ..., defaults to 0 if not given

- SpreadRateCutoff \[Optional\]: Only relevant if spread leg is OIS,
  allowable values are 0, 1, 2, ..., defaults to 0 if not given

- SpreadIsAveraged \[Optional\]: Only relevant if spread leg is OIS,
  allowable values are true, false, defaults to false if not given

- FlatIncludeSpread \[Optional\]: Only relevant if spread leg is OIS,
  allowable values are true, false, defaults to false if not given

- FlatLookback \[Optional\]: Only relevant if spread leg is OIS,
  allowable values are 0D, 1D, ..., defaults to 0D if not given

- FlatFixingDays \[Optional\]: Only relevant if spread leg is OIS,
  allowable values are 0, 1, 2, ..., defaults to 0 if not given

- FlatRateCutoff \[Optional\]: Only relevant if spread leg is OIS,
  allowable values are 0, 1, 2, ..., defaults to 0 if not given

- FlatIsAveraged \[Optional\]: Only relevant if spread leg is OIS,
  allowable values are true, false, defaults to false if not given

### Inflation Swap Conventions

A node with name `InflationSwap` is used to store conventions for zero
or year on year inflation swap quotes. The structure of this node is
shown in Listing
<a href="#lst:inflation_conventions" data-reference-type="ref"
data-reference="lst:inflation_conventions">[lst:inflation_conventions]</a>

<div class="listing">

``` xml
<InflationSwap>
  <Id>EUHICPXT_INFLATIONSWAP</Id>
  <FixCalendar>TARGET</FixCalendar>
  <FixConvention>MF</FixConvention>
  <DayCounter>30/360</DayCounter>
  <Index>EUHICPXT</Index>
  <Interpolated>false</Interpolated>
  <ObservationLag>3M</ObservationLag>
  <AdjustInflationObservationDates>false</AdjustInflationObservationDates>
  <InflationCalendar>TARGET</InflationCalendar>
  <InflationConvention>MF</InflationConvention>
  <StartDelay>2</StartDelay>
  <StartDelayConvention>Following</StartDelayConvention>
</InflationSwap>
```

</div>

The meaning of the elements is as follows:

- `FixCalendar`: The calendar for the fixed rate leg of the swap.

- `FixConvention`: The rolling convention for the fixed rate leg of the
  swap.

- `DayCounter`: The payoff or coupon day counter, applied to both legs.

- `Index`: The underlying inflation index.

- `Interpolated`: Flag indicating interpolation of the index in the
  swap’s payoff calculation.

- `ObservationLag`: The index observation lag to be applied.

- `AdjustInflationObservationDates`: Flag indicating whether index
  observation dates should be adjusted or not.

- `InflationCalendar`: The calendar for the inflation leg of the swap.

- `InflationConvention`: The rolling convention for the inflation leg of
  the swap.

- `StartDelay`: \[Optional\] The inflation swap starts n business days
  after today, defaults to zero if omitted.

- `StartDelayConvention`: \[Optional\] BusinessDayConvention to adjust
  the start day, defaults to Following if omitted.

- `PublicationRoll`: This is an optional node taking the values `None`,
  `OnPublicationDate` or `AfterPublicationDate`. If omitted, the value
  `None` is used. Currently, our only known use case for a value other
  than `None` is for Australian zero coupon inflation indexed swaps
  (ZCIIS). Here, the index is published quarterly on the last Wednesday
  of the month following the end of the reference quarter. The start
  date and maturity date of the market quoted ZCIIS roll to the next
  quarterly date after the publication date of the index. For example,
  the AU CPI value for Q3 2020, i.e. 1 Jul 2020 to 30 Sep 2020 was
  released on 28 Oct 2020. On 27 Oct 2020, before the index publication
  date, the market 5Y ZCIIS would start on 15 Sep 2020 and end on 15 Sep
  2025 and reference the Q2 inflation index value. On 29 Oct 2020, after
  the index publication date, the market 5Y ZCIIS would start on 15 Dec
  2020 and end on 15 Dec 2025 and reference the Q3 inflation index
  value. On the release date, i.e. 28 Oct 2020, the market ZCIIS that is
  set up is determined by whether the `PublicationRoll` value is
  `OnPublicationDate` or `AfterPublicationDate`. If it is set to
  `OnPublicationDate`, the swap rolls on this date and hence the market
  5Y ZCIIS would start on 15 Dec 2020 and end on 15 Dec 2025 and
  reference the Q3 inflation index value. If it is set to
  `AfterPublicationDate`, the swap does not roll on the publication date
  and instead rolls on the next day, and hence the market 5Y ZCIIS would
  start on 15 Sep 2020 and end on 15 Sep 2025 and reference the Q2
  inflation index value. The publication schedule for the index must be
  provided in the `PublicationSchedule` node if `PublicationRoll` is not
  `None`. An example of the AU CPI conventions set up is given in
  Listing
  <a href="#lst:aucpi_inflation_conventions" data-reference-type="ref"
  data-reference="lst:aucpi_inflation_conventions">[lst:aucpi_inflation_conventions]</a>.

- `PublicationSchedule`: This is an optional node and is not used if
  `PublicationRoll` is `None`. If `PublicationRoll` is not `None`, it
  must be provided and gives the publication dates for the inflation
  index. The node fields are the same fields that are described in the
  Section <a href="#ss:schedule_data" data-reference-type="ref"
  data-reference="ss:schedule_data">[ss:schedule_data]</a>, i.e. they
  are `ScheduleData` elements. An example of the AU CPI conventions set
  up is given in Listing
  <a href="#lst:aucpi_inflation_conventions" data-reference-type="ref"
  data-reference="lst:aucpi_inflation_conventions">[lst:aucpi_inflation_conventions]</a>.
  The `PublicationSchedule` must cover the dates on which you intend to
  perform valuations, i.e. the first publication schedule date must be
  less than the smallest valuation date that you intend to use and the
  last publication schedule date must be greater than the largest
  valuation date that you intend to use.

<div class="listing">

``` xml
<InflationSwap>
  <Id>AUCPI_INFLATIONSWAP</Id>
  <FixCalendar>AUD</FixCalendar>
  <FixConvention>F</FixConvention>
  <DayCounter>30/360</DayCounter>
  <Index>AUCPI</Index>
  <Interpolated>false</Interpolated>
  <ObservationLag>3M</ObservationLag>
  <AdjustInflationObservationDates>false</AdjustInflationObservationDates>
  <InflationCalendar>AUD</InflationCalendar>
  <InflationConvention>F</InflationConvention>
  <PublicationRoll>AfterPublicationDate</PublicationRoll>
  <PublicationSchedule>
    <Rules>
      <StartDate>2001-01-24</StartDate>
      <EndDate>2030-01-30</EndDate>
      <Tenor>3M</Tenor>
      <Calendar>AUD</Calendar>
      <Convention>Preceding</Convention>
      <TermConvention>Unadjusted</TermConvention>
      <Rule>LastWednesday</Rule>
    </Rules>
  </PublicationSchedule>
</InflationSwap>
```

</div>

### CMS Spread Option Conventions

A node with name *CmsSpreadOption* is used to store the conventions.

<div class="listing">

``` xml
  <CmsSpreadOption>
    <Id>EUR-CMS-10Y-2Y-CONVENTION</Id>
    <ForwardStart>0M</ForwardStart>
    <SpotDays>2D</SpotDays>
    <SwapTenor>3M</SwapTenor>
    <FixingDays>2</FixingDays>
    <Calendar>TARGET</Calendar>
    <DayCounter>A360</DayCounter>
    <RollConvention>MF</RollConvention>
  </CmsSpreadOption>
```

</div>

The meaning of the elements is as follows:

- ForwardStart: The calendar for the fixed rate leg of the swap.

- SpotDays: The number of business days to spot for the CMS Spread
  Index.

- SwapTenor: The frequency of payments on the CMS Spread leg.

- FixingDays: The number of fixing days.

- Calendar: The calendar for the CMS Spread leg.

- DayCounter: The day counter for the CMS Spread leg.

- RollConvention: The rolling convention for the CMS Spread Leg.

### Ibor Index Conventions

A node with name *IborIndex* is used to store conventions for Ibor
indices. This can be used to define new Ibor indices without the need of
adding them to the C++ code, or also to override the conventions of
existing Ibor indices.

<div class="listing">

``` xml
  <IborIndex>
    <Id>EUR-EURIBOR_ACT365-3M</Id>
    <FixingCalendar>TARGET</FixingCalendar>
    <DayCounter>A365F</DayCounter>
    <SettlementDays>2</SettlementDays>
    <BusinessDayConvention>MF</BusinessDayConvention>
    <EndOfMonth>true</EndOfMonth>
  </IborIndex>
```

</div>

The meaning of the elements is as follows:

- Id: The index name. This must be of the form “CCY-NAME-TENOR” with a
  currency “CCY”, an index name “NAME” and a string “TENOR” representing
  a period. The name should not be “GENERIC”, since this is reserved.

- FixingCalendar: The fixing calendar of the index.

- DayCounter: The day count convention used by the index.

- SettlementDays: The settlement days for the index. This must be a
  non-negative whole number.

- BusinessDayConvention: The business day convention used by the index.

- EndOfMonth: A flag indicating whether the index employs the end of
  month convention.

Notice that if another convention depends on an Ibor index convention
(because it contains the Ibor index name defined in the latter
convention), the Ibor index convention must appear before the convention
that depends on it in the convention input file.

Also notice that customised indices can not be used in cap / floor
volatility surface configurations.

### Overnight Index Conventions

A node with name *OvernightIndex* is used to store conventions for
Overnight indices. This can be used to define new Overnight indices
without the need of adding them to the C++ code, or also to override the
conventions of existing Overnight indices.

<div class="listing">

``` xml
  <OvernightIndex>
    <Id>EUR-ESTER</Id>
    <FixingCalendar>TARGET</FixingCalendar>
    <DayCounter>A360</DayCounter>
    <SettlementDays>0</SettlementDays>
  </OvernightIndex>
```

</div>

The meaning of the elements is as follows:

- Id: The index name. This must be of the form “CCY-NAME” with a
  currency “CCY” and an index name “NAME”. The name should not be
  “GENERIC”, since this is reserved.

- FixingCalendar: The fixing calendar of the index.

- DayCounter: The day count convention used by the index.

- SettlementDays: The settlement days for the index. This must be a
  non-negative whole number.

Notice that if another convention depends on an Overnight index
convention (because it contains the Overnight index name defined in the
latter convention), the Overnight index convention must appear before
the convention that depends on it in the convention input file.

Also notice that customised indices can not be used in cap / floor
volatility surface configurations.

### Inflation Index Conventions

A node with the name `ZeroInflationIndex` is used to store data for the
creation of a new inflation index. This avoids having to add the index
definition to the C++ code and recompile. Note that the
`ZeroInflationIndex` node should be placed before its use in any other
convention, e.g. in an `InflationSwap` convention, to avoid an error due
to the new index itself not being created. If the `Id` node matches an
existing inflation index, the newly created index will take precedence
and its definition will be used in the code for the given `Id`.

<div class="listing">

``` xml
<ZeroInflationIndex>
  <Id>...</Id>
  <RegionName>...</RegionName>
  <RegionCode>...</RegionCode>
  <Revised>...</Revised>
  <Frequency>...</Frequency>
  <AvailabilityLag>...</AvailabilityLag>
  <Currency>...</Currency>
</ZeroInflationIndex>
```

</div>

The meaning of each element is as follows:

- `Id`: The new inflation index name.

- `RegionName`: The name of the region with which the inflation index is
  associated.

- `RegionCode`: A code for the region with which the inflation index is
  associated.

- `Revised`: A boolean flag indicating whether the index is a revised
  index or not. This is generally set to `false` but is left as an
  option to align with the C++ `InflationIndex` class definition.

- `Frequency`: A valid frequency indicating the publication frequency of
  the inflation index, generally `Monthly`, `Quarterly` or `Annual`.

- `AvailabilityLag`: A valid period indicating the lag between the
  inflation index publication for a given period and the period itself.
  For example, if March’s inflation index value is published in April,
  the `AvailabilityLag` would be `1M`.

- `Currency`: The ISO currency code of the currency associated with the
  inflation index, generally the currency of the region.

### Swap Index Conventions

A node with name *SwapIndex* is used to store conventions for Swap
indices (also known as “CMS” indices).

<div class="listing">

``` xml
  <SwapIndex>
    <Id>EUR-CMS-2Y</Id>
    <Conventions>EUR-EURIBOR-6M-SWAP</Conventions>
    <FixingCalendar>TARGET</FixingCalendar>
  </SwapIndex>
```

</div>

The meaning of the elements is as follows:

- Id: The index name. This must be of the form “CCY-CMS-TENOR” with a
  currency “CCY” and a string “TENOR” representing a period. The index
  name can contain an optional tag “CCY-CMS-TAG-TENOR” which is an
  arbitrary label that allows to define more than one swap index per
  currency.

- Conventions: A swap convention defining the index conventions.

- FixingCalendar \[Optional\]: The fixing calendar for the swap index
  fixings publication. If not given, the fixed leg calendar from the
  swap conventions will be used as a fall back.

### FX Option Conventions

A node with name *FxOption* is used to store conventions for FX option
quotes for a given currency pair. The structure of this node is shown in
Listing <a href="#lst:fx_option_conventions" data-reference-type="ref"
data-reference="lst:fx_option_conventions">[lst:fx_option_conventions]</a>.

<div class="listing">

``` xml
<FxOption>
  <Id>EUR-USD-FXOPTION</Id>
  <FXConventionID>EUR-USD-FX</FXConventionID>
  <AtmType>AtmDeltaNeutral</AtmType>
  <DeltaType>Spot</DeltaType>
  <SwitchTenor>2Y</SwitchTenor>
  <LongTermAtmType>AtmDeltaNeutral</LongTermAtmType>
  <LongTermDeltaType>Fwd</LongTermDeltaType>
  <RiskReversalInFavorOf>Call</RiskReversalInFavorOf>
  <ButterflyStyle>Broker</ButterflyStyle>
</FxOption>
```

</div>

The meanings of the various elements in this node are as follows:

- FXConventionID: The FX convention for the currency pair (see
  <a href="#sss:fx_convention" data-reference-type="ref"
  data-reference="sss:fx_convention">0.1.11</a>). Optional, if not
  given, the FX spot days default to $2$ and the advance calendar
  defaults to source ccy + target ccy default calendars.

- AtmType: Convention of ATM option quote (Choices are *AtmNull,
  AtmSpot, AtmFwd, AtmDeltaNeutral, AtmVegaMax, AtmGammaMax,
  AtmPutCall50*).

- DeltaType: Convention of Delta option quote (Choices are *Spot, Fwd,
  PaSpot, PaFwd*).

- SwitchTenor \[Optional\]: If given, different ATM and Delta
  conventions will be used if the option tenor is greater or equal the
  switch tenor (“long term” atm and delta type)

- LongTermAtmType \[Mandatory if and only if SwitchTenor is given\]: ATM
  type to use for options with tenor \> switch point, if SwitchTenor is
  given

- LongTermDeltaType \[Mandatory if and only if SwitchTenor is given\]:
  Delta type to use for options with tenor \> switch point, if
  SwitchTenor is given

- RiskReversalInFavorOf \[Optional\]: Call (default), Put. Only relevant
  for BF, RR market data input.

- ButterflyStyle \[Optional\]: Broker (default), Smile. Only relevant
  for BF, RR market data input.

### FX Option Time Weighting Scheme

A node with name *FxOption* is used to store conventions for FX option
quotes for a given currency pair. The structure of this node is shown in
Listing <a href="#lst:fx_option_conventions" data-reference-type="ref"
data-reference="lst:fx_option_conventions">[lst:fx_option_conventions]</a>.

<div class="listing">

``` xml
<FxOptionTimeWeighting>
  <Id>USD-JPY-FXOPTION-TIMEWEIGHTING</Id>
  <!-- Priorities:
             1 Weekend (Saturday, Sunday)
             2 Event
             3 Trading Center (product of weights if several apply)
             4 Weekday (Monday to Friday) -->
  <WeekdayWeights>
    <Monday>1.0</Monday>
    <Tuesday>1.0</Tuesday>
    <Wednesday>1.0</Wednesday>
    <Thursday>1.0</Thursday>
    <Friday>1.0</Friday>
    <Saturday>0.3</Saturday>
    <Sunday>0.3</Sunday>
  </WeekdayWeights>
  <TradingCenters>
    <TradingCenter>
      <Name>JP,US</Name>
      <Calendar>NY,JPY</Calendar>
      <Weight>0.5</Weight>
    </TradingCenter>
  </TradingCenters>
  <Events>
    <Event>
      <Description>US Election</Description>
      <Date>2024-11-06</Date>
      <Weight>8.0</Weight>
    </Event>
  </Events>
</FxOptionTimeWeighting>
```

</div>

The meanings of the various elements in this node are as follows:

- WeekdayWeights: Specifies weights to be applied to weekdays

- TradingCenters: Zero, one or more trading centers specified by a
  calendar and a weight per trading center

- Events: Zero, one or more dates, on which special weights apply

To determine a weight for a given day exactly one of the following rules
is applied, with priority from top to bottom:

- If a day falls on a weekend, the weight for Saturday, Sunday from
  WeekdayWeights is applied to the day.

- If a day is in the event list, the weight for that date is applied.

- If a day is a holiday in one or more trading centers, the product of
  the weights of these trading centers is applied.

- Otherwise, the weight for the weekday (Monday to Friday) is applied.

### Commodity Forward Conventions

A node with name `CommodityForward` is used to store conventions for
commodity forward price quotes. The structure of this node is shown in
Listing
<a href="#lst:commodity_forward_conventions" data-reference-type="ref"
data-reference="lst:commodity_forward_conventions">[lst:commodity_forward_conventions]</a>.

<div class="listing">

``` xml
<CommodityForward>
  <Id>...</Id>
  <SpotDays>...</SpotDays>
  <PointsFactor>...</PointsFactor>
  <AdvanceCalendar>...</AdvanceCalendar>
  <SpotRelative>...</SpotRelative>
  <BusinessDayConvention>...</BusinessDayConvention>
  <Outright>...</Outright>
</CommodityForward>
```

</div>

The meanings of the various elements in this node are as follows:

- `Id`: The identifier for the commodity forward convention. The
  identifier here should match the `Name` that would be provided for the
  commodity in the trade XML as described in Table
  <a href="#tab:commodity_data" data-reference-type="ref"
  data-reference="tab:commodity_data">[tab:commodity_data]</a>.

- `SpotDays` \[Optional\]: The number of business days to spot for the
  commodity. Any non-negative integer is allowed here. If omitted, this
  takes a default value of 2.

- `PointsFactor` \[Optional\]: This is only used if `Outright` is
  `false`. Any positive real number is allowed here. When `Outright` is
  `false`, the commodity forward quotes are provided as points i.e. a
  number that should be added to the commodity spot to give the outright
  commodity forward rate. The `PointsFactor` is the number by which the
  points quote should be divided before adding it to the spot quote to
  obtain the forward price. If omitted, this takes a default value of 1.

- `AdvanceCalendar` \[Optional\]: The business day calendar(s) used for
  advancing dates for both spot and forwards. The allowable values are
  given in Table <a href="#tab:calendar" data-reference-type="ref"
  data-reference="tab:calendar">[tab:calendar]</a>. If omitted, it
  defaults to `NullCalendar` i.e. a calendar where all days are
  considered good business days.

- `SpotRelative` \[Optional\]: The allowable values are `true` and
  `false`. If `true`, the forward tenor is interpreted as being relative
  to the spot date. If `false`, the forward tenor is interpreted as
  being relative to the valuation date. If omitted, it defaults to
  `True`.

- `BusinessDayConvention` \[Optional\]: The business day roll convention
  used to adjust dates when getting from the valuation date to the spot
  date and the forward maturity date. The allowable values are given in
  Table <a href="#tab:allow_stand_data" data-reference-type="ref"
  data-reference="tab:allow_stand_data">[tab:allow_stand_data]</a>. If
  omitted, it defaults to `Following`.

- `Outright` \[Optional\]: The allowable values are `true` and `false`.
  If `true`, the forward quotes are interpreted as outright forward
  prices. If `false`, the forward quotes are interpreted as points i.e.
  as a number that must be added to the spot price to get the outright
  forward price. If omitted, it defaults to `true`.

### Commodity Future Conventions

A node with name `CommodityFuture` is used to store conventions for
commodity future contracts and options on them. These conventions are
used in commodity derivative trades and commodity curve construction to
calculate contract expiry dates. The structure of this node is shown in
Listing
<a href="#lst:commodity_future_conventions" data-reference-type="ref"
data-reference="lst:commodity_future_conventions">[lst:commodity_future_conventions]</a>.

<div class="listing">

``` xml
<CommodityFuture>
  <Id>...</Id>
  <AnchorDay>
    ...
  </AnchorDay>
  <ContractFrequency>...</ContractFrequency>
  <Calendar>...</Calendar>
  <ExpiryCalendar>...</ExpiryCalendar>
  <ExpiryMonthLag>...</ExpiryMonthLag>
  <OneContractMonth>...</OneContractMonth>
  <OffsetDays>...</OffsetDays>
  <BusinessDayConvention>...</BusinessDayConvention>
  <AdjustBeforeOffset>...</AdjustBeforeOffset>
  <IsAveraging>...</IsAveraging>
  <OptionExpiryOffset>...</OptionExpiryOffset>
  <ProhibitedExpiries>
    <Dates>
      <Date forFuture="true" convention="Preceding" forOption="true" optionConvention="Preceding">...</Date>
        ...
    </Dates>
  </ProhibitedExpiries>
  <OptionExpiryMonthLag>...</OptionExpiryMonthLag>
  <OptionExpiryDay>...</OptionExpiryDay>
  <OptionContractFrequency>...</OptionContractFrequency>
  <OptionNthWeekday>
    <Nth>...</Nth>
    <Weekday>...</Weekday>
  </OptionNthWeekday>
  <OptionExpiryLastWeekdayOfMonth>...</OptionExpiryLastWeekdayOfMonth>
  <OptionExpiryWeeklyDayOfTheWeek>...</OptionExpiryWeeklyDayOfTheWeek>
  <OptionBusinessDayConvention>...</OptionBusinessDayConvention>
  <FutureContinuationMappings>
    <ContinuationMapping>
      <From>...</From>
      <To>...</To>
    </ContinuationMapping>
    ...
  </FutureContinuationMappings>
  <OptionContinuationMappings>
    <ContinuationMapping>
      <From>...</From>
      <To>...</To>
    </ContinuationMapping>
    ...
  </OptionContinuationMappings>
  <AveragingData>
    ...
  </AveragingData>
  <HoursPerDay>...</HoursPerDay>
  <SavingsTime>...<SavingsTime>
  <ValidContractMonths>
    <Month>...</Month>
  </ValidContractMonths>
  <OptionUnderlyingFutureConvention>...</OptionUnderlyingFutureConvention>
</CommodityFuture>
```

</div>

The meanings of the various elements in this node are as follows:

- `Id`: The identifier for the commodity future convention. The
  identifier here should match the `Name` that would be provided for the
  commodity in the trade XML as described in Table
  <a href="#tab:commodity_data" data-reference-type="ref"
  data-reference="tab:commodity_data">[tab:commodity_data]</a>.

- `AnchorDay` \[Optional\]: This node is not applicable for daily future
  contracts and hence is optional. It is necessary for future contracts
  with a monthly cycle or greater or if the option contracts cycle is
  monthly or greater. This node is used to give a date in the future
  contract month to use as a base date for calculating the expiry date.
  It can contain a `DayOfMonth` node, a `CalendarDaysBefore` node or an
  `NthWeekday` node:

  - The `DayOfMonth` This node can contain any integer in the range
    $1,\ldots,31$ indicating the day of the month. A value of 31 will
    guarantee that the last day in the month is used a base date.

  - The `CalendarDaysBefore` This node can contain any non-negative
    integer. The contract expiry date is this number of calendar days
    before the first calendar day of the contract month.

  - The `NthWeekday` This node has the elements shown in Listing
    <a href="#lst:nth_weekday_node" data-reference-type="ref"
    data-reference="lst:nth_weekday_node">[lst:nth_weekday_node]</a>.
    This node is used to indicate a date in a given month in the form of
    the n-th named weekday of that month e.g. 3rd Wednesday. The
    allowable values for `Nth` are ${1,2,3,4}$. The `Weekday` node takes
    a weekday in the form of the first three characters of the weekday
    with the first character capitalised.

  - The `LastWeekday` \[Optional\]: This node is used to indicate a date
    in a given month in the form of the last named weekday of that month
    e.g. last Wednesday. The node takes a weekday in the form of the
    first three characters of the weekday with the first character
    capitalised.

  - The `BusinessDaysAfter` This node can contain any integer. If the
    number is positive the contract expiry is the n-th business day of
    the contract month. If the number is negative the contract expiry
    date is this number of business days before the first calendar day
    of the contract month.

  - The `WeeklyDayOfTheWeek` \[Optional\]: This node is used to indicate
    a date in a given week in the form of the named weekday, e.g.
    Wednesday. This node is mandatory for weekly contract frequencies
    and is not allowed with any other frequency. The node takes a
    weekday in the form of the first three characters of the weekday
    with the first character capitalised.

- `ContractFrequency`: This node indicates the frequency of the
  commodity future contracts. The value here is usually `Monthly` or
  `Quarterly`, but allowed values are `Daily`, `Weekly`, `Monthly`,
  `Quaterly` and `Annual`.

- `Calendar`: The business day trading calendar(s) applicable for the
  commodity future contract.

- `ExpiryCalendar` \[Optional\]: The business day expiry calendar(s)
  applicable for the commodity future contract. This calendar is used
  when deriving expiry dates. If omitted, this defaults to the trading
  day calendar specified in the `Calendar` node.

- `ExpiryMonthLag` \[Optional\]: The allowable values are any integer.
  This value indicates the number of months from the month containing
  the expiry date to the contract month. If 0, the commodity future
  contract expiry date is in the contract month. If the value of
  `ExpiryMonthLag` is $n > 0$, the commodity future contract expires in
  the $n$-th month prior to the contract month. If the value of
  `ExpiryMonthLag` is $n < 0$, the commodity future contract expires in
  the $n$-th month after the contract month. The value of
  `ExpiryMonthLag` is generally 0, 1 or 2. For example, `NYMEX:CL` has
  an `ExpiryMonthLag` of 1 and `ICE:B` has an `ExpiryMonthLag` of 2. If
  omitted, it defaults to 0.

- `OneContractMonth` \[Optional\]: This node takes a calendar month in
  the form of the first three characters of the month with the first
  character capitalised. The month provided should be an arbitrary valid
  future contract month. It is used in cases where the
  `ContractFrequency` is not `Monthly` in order to determine the valid
  contract months. If omitted, it defaults to January.

- `OffsetDays` \[Optional\]: The number of business days that the expiry
  date is before the base date where the base date is implied by the
  `AnchorDay` node above. Any non-negative integer is allowed here. If
  omitted, this takes a default value of zero.

- `BusinessDayConvention` \[Optional\]: The business day roll convention
  used to adjust the expiry date. The allowable values are given in
  Table <a href="#tab:allow_stand_data" data-reference-type="ref"
  data-reference="tab:allow_stand_data">[tab:allow_stand_data]</a>. If
  omitted, it defaults to `Preceding`.

- `AdjustBeforeOffset` \[Optional\]: The allowable values are `true` and
  `false`. If `true`, if the base date implied by the `AnchorDay` node
  above is not a good business day according to the calendar provided in
  the `Calendar` node, this date is adjusted before the offset specified
  in the `OffsetDays` is applied. If `false`, this adjustment does not
  happen. If omitted, it defaults to `true`.

- `IsAveraging` \[Optional\]: The allowable values are `true` and
  `false`. This node indicates if the future contract is based on the
  average commodity price of the contract period. If omitted, it
  defaults to `false`.

- `OptionExpiryOffset` \[Optional\]: The number of business days that
  the option expiry date is before the future expiry date. Any
  non-negative integer is allowed here. If omitted, this takes a default
  value of zero and the expiry date of an option on the future contract
  is assumed to equal the expiry date of the future contract.

- `ProhibitedExpiries` \[Optional\]: This node can be used to specify
  explicit dates which are not allowed as future contract expiry dates
  or as option expiry dates. A useful example of this is the ICE Brent
  contract which has the following constraint on expiry dates: *If the
  day on which trading is due to cease would be either: (i) the Business
  Day preceding Christmas Day, or (ii) the Business Day preceding New
  Year’s Day, then trading shall cease on the next preceding Business
  Day*. Each `Date` node can take optional attributes. The default
  values of these attributes is shown in Listing
  <a href="#lst:commodity_future_conventions" data-reference-type="ref"
  data-reference="lst:commodity_future_conventions">[lst:commodity_future_conventions]</a>.
  The `convention` attribute accepts a valid business day convention in
  the list `Preceding`, `ModifiedPreceding`, `Following` and
  `ModifiedFollowing`. This `convention` indicates how the future expiry
  date should be adjusted if it lands on the prohibited expiry `Date`.
  If omitted, the default is `Preceding`. Both `Preceding` and
  `ModifiedPreceding` indicate that the next available business day
  before the date is tested. `Following` and `ModifiedFollowing`
  indicate that the next available business day after the date is
  tested. The `optionConvention` attribute allows the same values and
  behaves in the same way to determine how the option expiry date should
  be adjusted if it lands on the prohibited expiry `Date`. The
  `forFuture` and `forOption` boolean attributes enable the prohibited
  expiry to apply only for the future expiry date or the option expiry
  date respectively by setting the value to `false`.

- `OptionExpiryMonthLag` \[Optional\]: The allowable values are any
  integer. This value indicates the number of months from the month
  containing the option expiry date to the month containing the expiry
  date. If 0, the commodity future option contract expiry date is
  anchored in the same month as the commodity future contract expiry
  date. If the value of `OptionExpiryMonthLag` is $n > 0$, the commodity
  option future contract expires in the $n$-th month prior to the
  commodity future contract expiry month. If the value of
  `OptionExpiryMonthLag` is $n < 0$, the commodity option future
  contract expires in the $n$-th month after the commodity future
  contract expiry month. The value of `OptionExpiryMonthLag` should be
  equal to `ExpiryMonthLag` when `OptionExpiryOffset` is used. The
  `OptionExpiryMonthLag` is rarely used. An example is the Crude Palm
  Oil contract `XKLS:FCPO` where the future contract expiry is in the
  delivery month and the option expiry is in the month that is 2 months
  prior to this. In this case, `OptionExpiryMonthLag` is 2. If omitted,
  `OptionExpiryMonthLag` defaults to 0.

- `OptionExpiryDay` \[Optional\]: This node can contain any integer in
  the range $1,\ldots,31$ indicating the day of the month on which an
  option expiry date is anchored. A value of 31 will guarantee that the
  last day in the month is used a base date. If omitted, this is not
  used. Setting this field takes precedence over `OptionExpiryOffset`.

- `OptionBusinessDayConvention` \[Optional\]: The business day
  convention used to adjust the option expiry date to a good business
  day if `OptionExpiryDay` is used.

- `OptionContractFrequency` \[Optional\]: This node indicates the
  frequency of the commodity future options if it differs from the
  frequency of the underlying future contract. The value here is usually
  `Monthly`

- `OptionNthWeekday` \[Optional\]: This node has the elements shown in
  Listing <a href="#lst:nth_weekday_node" data-reference-type="ref"
  data-reference="lst:nth_weekday_node">[lst:nth_weekday_node]</a>. This
  node is used to indicate a date in a given month in the form of the
  n-th named weekday of that month e.g. 3rd Wednesday. The allowable
  values for `Nth` are ${1,2,3,4}$. The `Weekday` node takes a weekday
  in the form of the first three characters of the weekday with the
  first character capitalised.

- `OptionBusinessDayConvention` \[Optional\]: The business day
  convention used to adjust the option expiry date to a good business
  day if `OptionExpiryDay` is used.

- `OptionExpiryLastWeekdayOfMonth` \[Optional\]: This node is used to
  indicate a date in a given month in the form of the last named weekday
  of that month e.g. last Wednesday. The node takes a weekday in the
  form of the first three characters of the weekday with the first
  character capitalised.

- `OptionExpiryWeeklyDayOfTheWeek` \[Optional\]: This node is used to
  indicate a date in a given week in the form of the named weekday, e.g.
  Wednesday. The node takes a weekday in the form of the first three
  characters of the weekday with the first character capitalised. This
  node is mandatory for weekly expiring options. The node is not allowed
  to use with any other option contract frequency.

- `OptionCalendarDaysBefore` \[Optional\]: This node can contain any
  non-negative integer. The option expiry date is this number of
  calendar days before the first calendar day of the contract month.

- `OptionMinBusinessDaysBefore` \[Optional\]: This node can contain any
  non-negative integer. The option expiry date is this at least this
  number of business days before the contract expiry. The option expiry
  date is calculated using the regular rule and if the option expiry
  date falls on a date before this minimum date, the minimum date will
  be taken instead.

- `OptionUnderlyingFutureConvention` \[Optional\]: Sometimes the next
  contract expiry, as specified in the convention, is not the correct
  option underlying. For example the base metals options expiries on the
  1st Wednesday of the contract month, and during the first 3 months
  there are daily future contracts available. The option underlying is
  not the future contract which matures on the option expiry but the one
  which matures on the 3rd Wednesday of the month. This field is
  referencing to an commodity future convention which specifies the
  correct expiry date for the underlying contract.

- `FutureContinuationMappings` \[Optional\]: When building future
  curves, we may use market data that has a continuation expiry, i.e.
  `c1`, `c2`, etc. , as opposed to an explicit expiry date or tenor. In
  some cases, the continuation expiries coming from the market data
  provider may skip serial months and therefore we use the mapping here
  to map from the market data provider index to the relevant serial
  month.

- `OptionContinuationMappings` \[Optional\]: When building option
  volatility structures, we may use market data that has a continuation
  expiry, i.e. `c1`, `c2`, etc. , as opposed to an explicit expiry date
  or tenor. In some cases, the continuation expiries coming from the
  market data provider may skip serial months and therefore we use the
  mapping here to map from the market data provider index to the
  relevant serial month. For example, for the Crude Palm Oil contract
  `XKLS:FCPO`, the option expiry months are serial up to the 9th month
  and then alternate months. So, we would add a mapping from 10 to 11,
  11 to 13 and so on so that the correct option expiry is arrived at
  when reading the market data quotes and constructing the option
  volatility structure.

- `AveragingData` \[Optional\]: This node is needed for future contracts
  that are used in a piecewise commodity curve `PriceSegment` and whose
  underlying is the average of other future prices or spot prices over a
  given period. An example is the ICE PMI power contract with contract
  specifications outlined
  [here](https://www.theice.com/products/6590369/PJM-Western-Hub-Real-Time-Peak-1-MW-Fixed-Price-Future).
  It is described in detail below.

- `HoursPerDay` \[Optional\]: For power derivatives, quantities are
  sometimes given as a quantity per hour. To deduce the quantity for the
  day which is multiplied by that day’s future price, one needs to know
  the number of hours in the day associated with the future price. For
  example ICE PDQ is the daily PJM Western Hub Real Time Peak future
  contract. The price each day for this contract is the average of the
  locational marginal prices (LMPs) for all hours ending 08:00 to 23:00
  Eastern Pacific Time. In other words, there are 16 hours in the day
  that feed in to the average yielding this settlement price. For this
  contract, `HoursPerDay` would be `16`. This field is only needed if a
  trade XML references this commodity contract, has
  `CommodityQuantityFrequency` set to `PerHour` and has no `HoursPerDay`
  value set directly in the XML.

- `SavingsTime` \[Optional\]: For some derivatives, quantities are given
  as quantity per calendar day and hour. The monthly quantity is then
  scaled by the number of calendar days times hours per day (see above)
  plus or minus a daylight savings correction. To compute the daylight
  savings correction a convention is needed that describes the dates on
  which dates one hour is gained resp. lost. Currently supported
  conventions are US, Null. Default is US if no convention is given.

- `ValidContractMonths` \[Optional\]: For some commodities the contract
  frequency is almost monthly but for some calendar months there are no
  contracts listed. For example Corn Futures are only listed for the
  expiry months March, May, July, September and December. For those
  contracts the *ContractFrequency* need to be set to *Monthly* and the
  valid months have to be added to this node. This node is ignored for
  all other frequencies and if its omitted all calendar months are
  valid.

<div class="listing">

``` xml
<NthWeekday>
  <Nth>...</Nth>
  <Weekday>...</Weekday>
</NthWeekday>
```

</div>

An example `CommodityFuture` node for the NYMEX WTI future contract,
specified
[here](https://www.cmegroup.com/trading/energy/crude-oil/light-sweet-crude_contract_specifications.html),
is provided in Listing
<a href="#lst:ex_wti_comm_future_convention" data-reference-type="ref"
data-reference="lst:ex_wti_comm_future_convention">[lst:ex_wti_comm_future_convention]</a>.

<div class="listing">

``` xml
<CommodityFuture>
  <Id>NYMEX:CL</Id>
  <AnchorDay>
    <DayOfMonth>25</DayOfMonth>
  </AnchorDay>
  <ContractFrequency>Monthly</ContractFrequency>
  <Calendar>US-NYSE</Calendar>
  <ExpiryMonthLag>1</ExpiryMonthLag>
  <OffsetDays>3</OffsetDays>
  <BusinessDayConvention>Preceding</BusinessDayConvention>
  <IsAveraging>false</IsAveraging>
</CommodityFuture>
```

</div>

The `AveragingData` node referenced above has the structure shown in
Listing
<a href="#lst:ave_data_comm_future_convention" data-reference-type="ref"
data-reference="lst:ave_data_comm_future_convention">[lst:ave_data_comm_future_convention]</a>.
The meaning of each of the fields is as follows:

- `CommodityName`: The name of the commodity being averaged.

- `Conventions`: The identifier for the conventions associated with the
  commodity being averaged.

- `Period`: This indicates the averaging period relative to the future
  expiry date. The allowable values are:

  - `PreviousMonth`: The calendar month prior to the month in which the
    (top level) future contract’s expiry date falls is used as the
    averaging period.

  - `ExpiryToExpiry`: Given a (top level) future contract’s expiry date,
    the averaging period is from and excluding the previous expiry date
    to and including the expiry date.

- `PricingCalendar`: The pricing calendar(s) used to determine the
  pricing dates in the averaging period.

- `UseBusinessDays` \[Optional\]: A boolean flag that defaults to `true`
  if omitted. When set to `true`, the pricing dates in the averaging
  period are the set of `PricingCalendar` good business days. When set
  to `false`, the pricing dates in the averaging period are the
  complement of the set of `PricingCalendar` good business days. This
  may be useful in certain situations. For example, the contract ICE PW2
  with specifications
  [here](https://www.theice.com/products/71090520/PJM-Western-Hub-Real-Time-Peak-2x16-Fixed-Price-Future)
  averages the PJM Western Hub locational marginal prices over each day
  in the averaging period that is a Saturday, Sunday or NERC holiday.
  So, in this case, `UseBusinessDays` would be `false` and
  `PricingCalendar` would be `US-NERC`.

- `DeliveryRollDays` \[Optional\]: This node allows any non-negative
  integer value. When averaging a commodity future contract price over
  the averaging period, the averaging period may include an underlying
  future contract expiry date. This node’s value indicates when we
  should begin using the next future contract’s price in the averaging.
  If the value is zero, we should include the future contract prices up
  to and including the contract expiry. If the value is one, we should
  include the contract prices up to and including the day that is one
  business day before the contract expiry and then switch to using the
  next future contract’s price thereafter. Similarly for other
  non-negative integer values. If this node is omitted, it is set to
  zero.

- `FutureMonthOffset` \[Optional\]: This node allows any non-negative
  integer value. If this node is omitted, it is set to zero. This node
  indicates which future contract is being referenced on each *Pricing
  Date* in the averaging period by acting as an offset from the next
  available expiry date. If `FutureMonthOffset` is zero, the settlement
  price of the next available monthly contract that has not expired with
  respect to the *Pricing Date* is used as the price on that *Pricing
  Date*. If `FutureMonthOffset` is one, the settlement price of the
  second available monthly contract that has not expired with respect to
  the *Pricing Date* is used as the price on that *Pricing Date*.
  Similarly for other positive values of `FutureMonthOffset`.

- `DailyExpiryOffset` \[Optional\]: This node allows any non-negative
  integer value. It should only be used where the `CommodityName` being
  averaged has a daily contract frequency. If this node is omitted, it
  is set to zero. This node indicates which future contract is being
  referenced on each *Pricing Date* in the averaging period by acting as
  a business day offset, using the `CommodityName`’s expiry calendar,
  from the *Pricing Date*. It is useful in the base metals market where
  the future contract being averaged on each *Pricing Date* is the cash
  contract on that *Pricing Date* i.e. the contract with expiry date two
  business days after the *Pricing Date*.

<div class="listing">

``` xml
<AveragingData>
  <CommodityName>...</CommodityName>
  <Conventions>...</Conventions>
  <Period>...</Period>
  <PricingCalendar>...</PricingCalendar>
  <UseBusinessDays>...</UseBusinessDays>
  <DeliveryRollDays>...</DeliveryRollDays>
  <FutureMonthOffset>...</FutureMonthOffset>
  <DailyExpiryOffset>...</DailyExpiryOffset>
</AveragingData>
```

</div>

### Credit Default Swap Conventions

A node with name `CDS` is used to store conventions for credit default
swaps. The structure of this node is shown in Listing
<a href="#lst:cds_conventions" data-reference-type="ref"
data-reference="lst:cds_conventions">[lst:cds_conventions]</a>.

<div class="listing">

``` xml
<CDS>
  <Id>...</Id>
  <SettlementDays>...</SettlementDays>
  <Calendar>...</Calendar>
  <Frequency>...</Frequency>
  <PaymentConvention>...</PaymentConvention>
  <Rule>...</Rule>
  <DayCounter>...</DayCounter>
  <LastPeriodDayCounter>...</LastPeriodDayCounter>
  <SettlesAccrual>...</SettlesAccrual>
  <PaysAtDefaultTime>...</PaysAtDefaultTime>
</CDS>
```

</div>

The meanings of the various elements in this node are as follows:

- `Id`: The identifier for the CDS convention.

- `SettlementDays`: The number of days after the CDS trade date when
  protection starts i.e. the *Protection effective date* or *step-in
  date*. Any non-negative integer is allowed here. For standard CDS
  after, this is generally set to 1.

- `Calendar`: The calendar associated with the CDS. For non-JPY
  currencies, this is generally `WeekendsOnly` to agree with the ISDA
  standard. For JPY CDS, the ISDA standard calendar is `TYO` documented
  at <https://www.cdsmodel.com/cdsmodel>. This could be set up as an
  additional calendar or `JPN` could be used as a proxy. Allowable
  calendar values are given in Table
  <a href="#tab:calendar" data-reference-type="ref"
  data-reference="tab:calendar">[tab:calendar]</a>.

- `Frequency`: The frequency of fee leg payments for the CDS. The ISDA
  standard is `Quarterly` but any valid frequency is allowed.

- `PaymentConvention`: The business day convention for payments on the
  CDS. The ISDA standard is `Following` but any valid business day
  convention from Table
  <a href="#tab:allow_stand_data" data-reference-type="ref"
  data-reference="tab:allow_stand_data">[tab:allow_stand_data]</a> is
  allowed.

- `Rule`: The date generation rule for the fee leg on the CDS. The ISDA
  standard is `CDS2015` but any valid date generation rule is allowed.

- `DayCounter`: The day counter for fee leg payments on the CDS. The
  ISDA standard is `A360` but any valid day counter from Table
  <a href="#tab:daycount" data-reference-type="ref"
  data-reference="tab:daycount">[tab:daycount]</a> is allowed.

- `LastPeriodDayCounter` \[optional\]: The day counter for the last fee
  leg payment on the CDS. The ISDA standard is `A360 (Incl Last)` but
  any valid day counter from Table
  <a href="#tab:daycount" data-reference-type="ref"
  data-reference="tab:daycount">[tab:daycount]</a> is allowed. If not
  given, the following fallback rule applies: If DayCounter is `A360`,
  LastPeriodDayCounter is set to `A360 (Incl Last)`, otherwise
  LastPeriodDayCounter is set to the same value as DayCounter.

- `SettlesAccrual`: A boolean value indicating if an accrued fee is due
  on the occurrence of a credit event. Allowable boolean values are
  given in the Table
  <a href="#tab:boolean_allowable" data-reference-type="ref"
  data-reference="tab:boolean_allowable">[tab:boolean_allowable]</a>. In
  general, this is set `true`.

- `PaysAtDefaultTime`: A boolean value indicating if the accrued fee, on
  the occurrence of a credit event, is payable at the credit event date
  or the end of the fee period. A value of `true` indicates that the
  accrued is payable at the credit event date and a value of `false`
  indicates that it is payable at the end of the fee period. In general,
  this is set `true`.

### Bond Yield Conventions

A node with name `BondYield` is used to store conventions for the
conversion of bond prices into bond yields. The structure of this node
is shown in Listing
<a href="#lst:bondyield_conventions" data-reference-type="ref"
data-reference="lst:bondyield_conventions">[lst:bondyield_conventions]</a>.

<div class="listing">

``` xml
<BondYield>
  <Id>CMB-DE-BUND-10Y</Id>
  <Compounding>Compounded</Compounding>
  <Frequency>Annual</Frequency>
  <PriceType>Clean</PriceType>
  <Accuracy>1.0e-8</Accuracy>
  <MaxEvaluations>100</MaxEvaluations>
  <Guess>0.05</Guess>
</BondYield>
```

</div>

The meaning of the elements is as follows:

- Id: The constant maturity index index name. This must be of the form
  “CMB-FAMILY-TENOR” where FAMILY can consist of any number of tags
  separated by “-”

- Compounding: Compounding of the yield - Simple, Compounded,
  Continuous, SimpleThenCompounded

- Frequency: Frequency of the cash flows - Annual, Semiannual,
  Quarterly, Monthly etc.

- PriceType: Dirty or Clean

- Accuracy/MaxEvaluations/Guess: QuantLib parameters that control the
  convergence of the numerical price to yield conversion.
