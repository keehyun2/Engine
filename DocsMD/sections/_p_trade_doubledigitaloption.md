### Double Digital Option

The `DoubleDigitalOptionData` node is the trade data container for the
DoubleDigitalOption trade type, listing
<a href="#lst:doubledigitaloption_data" data-reference-type="ref"
data-reference="lst:doubledigitaloption_data">[lst:doubledigitaloption_data]</a>
shows the structure of an example with two underlying FX rates. Equity,
Commodity and IR underlyings are also supported in arbitrary
combinations. A double digital option is a binary option that pays out a
fixed amount if the two underlyings (FX spots, Equity or Commodity
prices, interest rates) are simultaneously in the money w.r.t. given
strikes and option types at the option expiry.

<div class="listing">

``` xml
    <DoubleDigitalOptionData>
      <Expiry>2021-09-01</Expiry>
      <Settlement>2021-09-03</Settlement>
      <BinaryPayout>12000000</BinaryPayout>
      <BinaryLevel1>1.1</BinaryLevel1>
      <BinaryLevel2>0.006</BinaryLevel2>
      <BinaryLevelUpper2>0.008</BinaryLevelUpper2>
      <Type1>Call</Type1>
      <Type2>Collar</Type2>
      <Position>Long</Position>
      <Underlying1>
        <Type>FX</Type>
        <Name>ECB-EUR-USD</Name>
      </Underlying1>
      <Underlying2>
        <Type>FX</Type>
        <Name>ECB-JPY-USD</Name>
      </Underlying2>
      <PayCcy>USD</PayCcy>
    </DoubleDigitalOptionData>
```

</div>

The meanings and allowable values of the elements in the
`DoubleDigitalOptionData` node follow below.

- Expiry: The expiry date of the option. Allowable values are valid
  dates.

- Settlement: The payout settlement date. Allowable values are valid
  dates.

- BinaryPayout: The amount that is paid if the option is in the money.
  Allowable values are all non-negative numbers.

- BinaryLevel1: The strike for underlying 1 for *Call* or *Put* option
  and the lower bound for a *Collar* option. For an FX underlying
  (SOURCE-CCY1-CCY2) this is the number of units of CCY2 per units of
  CCY1. For an Equity underlying this is the equity price expressed in
  the equity ccy. For a Commodity underlying this is the commodity price
  expressed in the commodity ccy. For an IR underlying this is the rate
  expressed in decimal form. Allowable values are non-negative numbers.

- BinaryLevel2: The strike for underlying 2 for *Call* or *Put* option
  and the lower bound for a *Collar*. For an FX underlying
  (SOURCE-CCY1-CCY2) this is the number of units of CCY2 per units of
  CCY1. For an Equity underlying this is the equity price expressed in
  the equity ccy. For a Commodity underlying this is the commodity price
  expressed in the commodity ccy. For an IR underlying this is the rate
  expressed in decimal form. Allowable values are non-negative numbers.

- Type1: The option type that applies to underlying 1. Allowable values:
  *Call*, *Put* or *Collar*. Underlying 1 is considered to be in the
  money if the spot is above (Call) / below (Put) the BinaryLevel1 resp.
  between (Collar) the BinaryLevel1 and BinaryLevelUpper1 at the expiry.

- Type2: The option type that applies to underlying 2. Allowable values:
  *Call*, *Put* or *Collar*. Underlying 2 is considered to be in the
  money if the spot is above (Call) / below (Put) the BinaryLevel1 resp.
  between (Collar) the BinaryLevel2 andthe BinaryLevelUpper2 at the
  expiry.

- Position: The option position type. Allowable values: *Long* or
  *Short*.

- Underlying1: The first underlying, see
  <a href="#ss:underlying" data-reference-type="ref"
  data-reference="ss:underlying">[ss:underlying]</a>.

- Underlying2: The second underlying, see
  <a href="#ss:underlying" data-reference-type="ref"
  data-reference="ss:underlying">[ss:underlying]</a>. Note that Type for
  both underlyings has allowable values *Equity*, *Commodity*, *FX*, and
  *IR*.

- Underlying3 \[Optional\]: If defined, the first underlying in this
  transaction is treated as a spread between Underlying1 and Underlying3
  (i.e. Underlying1 fixing minus Underlying3 fixing), see
  <a href="#ss:underlying" data-reference-type="ref"
  data-reference="ss:underlying">[ss:underlying]</a>. Underlying3 Type
  must be the same as Underlying1 Type.

- Underlying4 \[Optional\]: If defined, the second underlying in this
  transaction is treated as a spread between Underlying2 and Underlying4
  (i.e. Underlying2 fixing minus Underlying4 fixing), see
  <a href="#ss:underlying" data-reference-type="ref"
  data-reference="ss:underlying">[ss:underlying]</a>. Underlying4 Type
  must be the same as Underlying2 Type.

- PayCcy: The currency in which the `BinaryPayout` is paid. See Table
  <a href="#tab:currency" data-reference-type="ref"
  data-reference="tab:currency">[tab:currency]</a> for allowable
  currency codes.

- BinaryLevelUpper1 \[Optional\]: This is field is used only for Collar
  option. The upper bound for underlying 1. For an FX underlying
  (SOURCE-CCY1-CCY2) this is the number of units of CCY2 per units of
  CCY1. For an Equity underlying this is the equity price expressed in
  the equity ccy. For a Commodity underlying this is the commodity price
  expressed in the commodity ccy. For an IR underlying this is the rate
  expressed in decimal form. Allowable values are non-negative numbers.

- BinaryLevelUpper2 \[Optional\]: This field is used only for Collar
  option. The upper bound for underlying 2. For an FX underlying
  (SOURCE-CCY1-CCY2) this is the number of units of CCY2 per units of
  CCY1. For an Equity underlying this is the equity price expressed in
  the equity ccy. For a Commodity underlying this is the commodity price
  expressed in the commodity ccy. For an IR underlying this is the rate
  expressed in decimal form. Allowable values are non-negative numbers.
