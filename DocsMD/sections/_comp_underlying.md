### Underlying

This trade component can be used to define the underlying entity for an
Equity, Commodity or FX trade, but it can also define an underlying
interest rate, inflation index, credit name or an underlying bond. It
can be used for a single underlying, or within a basket with associated
weight. For an equity underlying a string representation is used to
match `Underlying` node to required configuration and reference data.
The string representation is of the form
IdentifierType:Name:Currency:Exchange, with all entries optional except
for Name.

<div class="listing">

``` xml
<Underlying>
  <Type>...</Type>
  <Name>...</Name>
  <Weight>...</Weight>
  <Currency>...</Currency>
  <IdentifierType>...</IdentifierType>
  <Exchange>...</Exchange>
  <PriceType>...</PriceType>
  <FutureMonthOffset>...</FutureMonthOffset>
  <DeliveryRollDays>...</DeliveryRollDays>
  <DeliveryRollCalendar>...</DeliveryRollCalendar>
</Underlying>
```

</div>

Example structures of the `Underlying` trade component node are shown in
Listings <a href="#lst:equnderlyingric" data-reference-type="ref"
data-reference="lst:equnderlyingric">[lst:equnderlyingric]</a> and
<a href="#lst:equnderlyingisin" data-reference-type="ref"
data-reference="lst:equnderlyingisin">[lst:equnderlyingisin]</a> for an
equity underlying, in Listing
<a href="#lst:fxunderlying" data-reference-type="ref"
data-reference="lst:fxunderlying">[lst:fxunderlying]</a> for an fx
underlying, in Listing
<a href="#lst:communderlying" data-reference-type="ref"
data-reference="lst:communderlying">[lst:communderlying]</a> for a
commodity underlying, in Listing
<a href="#lst:irunderlying" data-reference-type="ref"
data-reference="lst:irunderlying">[lst:irunderlying]</a> for an
underlying interest rate index, in Listing
<a href="#lst:infunderlying" data-reference-type="ref"
data-reference="lst:infunderlying">[lst:infunderlying]</a> for an
underlying inflation index, in Listing
<a href="#lst:crunderlying" data-reference-type="ref"
data-reference="lst:crunderlying">[lst:crunderlying]</a> for an
underlying credit name, in listing
<a href="#lst:bondunderlying" data-reference-type="ref"
data-reference="lst:bondunderlying">[lst:bondunderlying]</a> for an
underlying bond.

<div class="listing">

``` xml
        <Underlying>
            <Type>Equity</Type>
            <Name>.SPX</Name>
            <Weight>1.0</Weight>
            <IdentifierType>RIC</IdentifierType>
        </Underlying>
```

</div>

<div class="listing">

``` xml
        <Underlying>
            <Type>Equity</Type>
            <Name>NL0000852580</Name>
            <Weight>1.0</Weight>
            <IdentifierType>ISIN</IdentifierType>
            <Currency>EUR</Currency>
            <Exchange>XAMS</Exchange>
        </Underlying>
```

</div>

<div class="listing">

``` xml
        <Underlying>
            <Type>Equity</Type>
            <Name>BBG000BLNNV0</Name>
            <IdentifierType>FIGI</IdentifierType>
        </Underlying>
```

</div>

<div class="listing">

``` xml
        <Underlying>
            <Type>Equity</Type>
            <Name>BARC LN Equity</Name>
            <IdentifierType>BBG</IdentifierType>
        </Underlying>
```

</div>

<div class="listing">

``` xml
        <Underlying>
          <Type>FX</Type>
          <Name>ECB-EUR-USD</Name>
          <Weight>1.0</Weight>
        </Underlying>
```

</div>

<div class="listing">

``` xml
        <Underlying>
          <Type>Commodity</Type>
          <Name>NYMEX:CL</Name>
          <Weight>1.0</Weight>
          <PriceType>FutureSettlement</PriceType>
          <FutureMonthOffset>0</FutureMonthOffset>
          <DeliveryRollDays>0</DeliveryRollDays>
          <DeliveryRollCalendar>TARGET</DeliveryRollCalendar>
          <FutureContractMonth>Nov2023</FutureContractMonth>
        </Underlying>
```

</div>

<div class="listing">

``` xml
        <Underlying>
          <Type>InterestRate</Type>
          <Name>USD-CMS-10Y</Name>
          <Weight>1.0</Weight>
        </Underlying>
```

</div>

<div class="listing">

``` xml
        <Underlying>
          <Type>Inflation</Type>
          <Name>USCPI</Name>
          <Weight>1.0</Weight>
          <!-- optional -->
          <Interpolation>Linear</Interpolation>
</Underlying>
```

</div>

<div class="listing">

``` xml
        <Underlying>
          <Type>Credit</Type>
          <Name>ISSUER_A</Name>
          <Weight>1.0</Weight>
        </Underlying>
```

</div>

<div class="listing">

``` xml
      <Underlying>
        <Type>Bond</Type>
        <Name>US69007TAB08</Name>
        <IdentifierType>ISIN</IdentifierType>
        <Weight>0.5</Weight>
        <BidAskAdjustment>-0.0025</BidAskAdjustment>
      </Underlying>
```

</div>

The meanings and allowable values of the elements in the `Underlying`
node are as follows:

- `Type`: The type of the Underlying asset.

  Allowable values: *Equity*, *FX*, *Commodity*, *InterestRate*,
  *Inflation*, *Credit*, *Bond*

- `Name`: The name of the Underlying asset.

  Allowable values:

  *Equity*: See `Name` for equity trades in Table
  <a href="#tab:equity_name" data-reference-type="ref"
  data-reference="tab:equity_name">[tab:equity_name]</a>

  *FX*: A string on the form SOURCE-CCY1-CCY2, where SOURCE is the FX
  fixing source, and the fixing is expressed as amount in CCY2 per one
  unit of CCY1. See Table
  <a href="#tab:fxindex_data" data-reference-type="ref"
  data-reference="tab:fxindex_data">[tab:fxindex_data]</a>, and note
  that the FX- prefix is not included in `Name` as it is already
  included in `Type`.

  *InterestRate*: Any valid interest rate index name, see Table
  <a href="#tab:indices" data-reference-type="ref"
  data-reference="tab:indices">[tab:indices]</a>

  *Inflation*: Any valid zero coupon inflation index (CPI) name, See
  Table <a href="#tab:cpiindex_data" data-reference-type="ref"
  data-reference="tab:cpiindex_data">[tab:cpiindex_data]</a>

  *Credit*: Any valid credit name with a configured default curve, see
  Table <a href="#tab:equity_credit_data" data-reference-type="ref"
  data-reference="tab:equity_credit_data">[tab:equity_credit_data]</a>

  *Bond*: Any valid bond identifier, the bond must be set up in the
  reference data.

  *Commodity*: An identifier specifying the commodity being referenced
  in the leg. Table
  <a href="#tab:commodity_data" data-reference-type="ref"
  data-reference="tab:commodity_data">[tab:commodity_data]</a> lists the
  allowable values for `Name` and gives a description.  

- `Weight` \[Optional\]: The relative weight of the underlying if part
  of a basket. For a single underlying this can be omitted or set to 1.

  Allowable values: A real number. Defaults to 1 if left blank or
  omitted. A value of zero means that the underlying is excluded from
  the basket.

  Notes on negative weights in the *TotalReturnSwap* trade type:

  Negative weights for EquityOptionPositions are allowed, but not
  recommended. A negative weight for an EquityOptionPosition is
  equivalent to inverting the LongShort flag in the respective
  OptionData node.

  For EquityPositions a negative weight means that flows are in the
  opposite direction of the Payer flag on the return leg. A use case for
  negative weights is for a basket of EquityPositions that include both
  long and short positions.

- `IdentifierType` \[Optional\]: Only valid when `Type` is *Equity* or
  *Bond*. The type of the identifier being used.

  Allowable values: *RIC*, *ISIN*, *FIGI*, *BBG*. Defaults to *RIC*, if
  left blank or omitted, and `Type`: is *Equity*.

- `Currency` \[Mandatory when `IdentifierType` is *ISIN*\]: Only valid
  when `Type` is *Equity*. The currency the underlying equity is quoted
  in. Used when `IdentifierType` is *ISIN*, to - together with the
  `Exchange` convert a given ISIN to a RIC code.

  Allowable values: See Table
  <a href="#tab:currency" data-reference-type="ref"
  data-reference="tab:currency">[tab:currency]</a> `Currency`. Mandatory
  when `IdentifierType` is *ISIN*, and should not be used for other
  `IdentifierType`:s When `Type` is *Equity*, Minor Currencies in Table
  <a href="#tab:currency" data-reference-type="ref"
  data-reference="tab:currency">[tab:currency]</a> are also allowable.

- `Exchange` \[Mandatory when `IdentifierType` is *ISIN*\]: Only valid
  when `Type` is *Equity*. A string code representing the exchange the
  equity is traded on. Used when `IdentifierType` is *ISIN*, to -
  together with the `Currency` convert a given ISIN to a RIC code.

  Allowable values: The MIC code of the exchange, see Table
  <a href="#tab:mic" data-reference-type="ref"
  data-reference="tab:mic">[tab:mic]</a>. Mandatory when
  `IdentifierType` is *ISIN*, and should not be used for other
  `IdentifierType`:s.

- `PriceType` \[Optional\]: Only valid when `Type` is *Commodity*.
  Whether the Spot or Future price is referenced.

  Allowable values: *Spot*, *FutureSettlement*. Mandatory when `Type` is
  *Commodity* .

- `FutureMonthOffset` \[Optional\]: Only valid when `Type` is
  *Commodity*. Only relevant for the *FutureSettlement* price type, in
  which case the $N+1$th future with expiry greater than ObservationDate
  for the given commodity underlying will be referenced.

  Allowable values: An integer. Mandatory for when `Type` is *Commodity*
  and `PriceType` is *FutureSettlement*.

- `DeliveryRollDays` \[Optional\]: Only valid when `Type` is
  *Commodity*. The number of days the observation date is rolled forward
  before the next future expiry is looked up.

  Allowable values: An integer. Defaults to 0 if left blank or omitted,
  and `Type`: is *Commodity*.

- `DeliveryRollCalendar` \[Optional\]: Only valid when `Type` is
  *Commodity*. The calendar used to roll forward the observation date.

  Allowable values: See Table
  <a href="#tab:calendar" data-reference-type="ref"
  data-reference="tab:calendar">[tab:calendar]</a>. Defaults to the null
  calendar if left blank or omitted, and `Type`: is *Commodity*.

- `FutureContractMonth` \[Optional\]: Only valid when `Type` is
  *Commodity*, `PriceType` is FutureSettlement and there is no
  `FutureExpiryDate` node. It specifies the underlying future contract
  month in the format *MonYYYY*, for example Nov2023.

- `FutureExpiryDate` \[Optional\]: Only valid when `Type` is
  *Commodity*, `PriceType` is FutureSettlement and there is no
  `FutureContractMonth` node. This gives the expiration date of the
  underlying commodity future contract.

  If the field `FutureExpiryDate` and `FutureContractMonth` are omitted,
  the expiration date of the underlying commodity future contract is set
  to the prompt future, adjusted for any `FutureMonthOffset`.

- `Interpolation` \[Optional\]: Only valid when `Type` is *Inflation*.
  The index observation interpolation between fixings.

  Allowable values: Flat, Linear

- `BidAskAdjustment` \[Optional\]: Only valid when `Type` is *Bond*. A
  correction applied to the price found in the market data (usually
  mid), if the bond basket price is defined on the bid or ask side
  rather than mid.

  Allowable values: Any real number.
