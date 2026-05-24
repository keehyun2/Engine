### Performance Option Type 01

**Payoff**

The performance option of type “01” is characterized by the following
data

- a notional amount $N$

- a participation rate $q$

- a valuation date $V$ and a settlement date $S$

- a number of underlyings $U_i$ for $i=1,\ldots,n$

- weights for the underlyings $w_i$ for $i=1,\ldots,n$

- initial strike prices for the underlyings $s_i$ for $i=1,\ldots,n$

- an option strike $K$

On the valuation date the average performance of the underlying basket
is computed as

$$P = \max\left( \sum_{i=1}^n w_i \left( \frac{U_i(V)}{s_i} - K \right), 0 \right)$$

The option holder receives an amount $N\cdot q\cdot P$ on the settlement
date $S$. The underlyings can be Equity, FX or Commodity underlyings.

The above payoff includes the strike in the performance calculation.
There is another variant with excluded strike and payoff:

$$P = \max\left( \left[ \sum_{i=1}^n w_i \frac{U_i(V)}{s_i} \right] - K, 0 \right)$$

**Input**

The `PerformanceOption_01` node is the trade data container for the
PerformanceOption_01 trade type, listing
<a href="#lst:performanceoption01_data" data-reference-type="ref"
data-reference="lst:performanceoption01_data">[lst:performanceoption01_data]</a>
shows the structure of an example.

<div class="listing">

``` xml
    <PerformanceOption01Data>
      <NotionalAmount>12500000</NotionalAmount>
      <ParticipationRate>0.9</ParticipationRate>
      <ValuationDate>2022-05-03</ValuationDate>
      <SettlementDate>2022-05-05</SettlementDate>
      <Underlyings>
        <Underlying>
          <Type>FX</Type>
          <Name>ECB-CHF-EUR</Name>
          <Weight>0.34</Weight>
        </Underlying>
        <Underlying>
          <Type>FX</Type>
          <Name>ECB-NOK-EUR</Name>
          <Weight>0.32</Weight>
        </Underlying>
        <Underlying>
          <Type>FX</Type>
          <Name>ECB-SEK-EUR</Name>
          <Weight>0.24</Weight>
        </Underlying>
        <Underlying>
          <Type>FX</Type>
          <Name>ECB-SEK-EUR</Name>
          <Weight>0.10</Weight>
        </Underlying>
      </Underlyings>
      <StrikePrices>
        <StrikePrice>0.910002</StrikePrice>
        <StrikePrice>0.097192</StrikePrice>
        <StrikePrice>0.096085</StrikePrice>
        <StrikePrice>0.035032</StrikePrice>
      </StrikePrices>
      <Strike>1.15</Strike>
      <StrikeIncluded>true</StrikeIncluded>
      <Position>Long</Position>
      <PayCcy>EUR</PayCcy>
    </PerformanceOption01Data>
```

</div>

The meanings and allowable values of the elements in the
`PerformanceOption01Data` node follow below.

- NotionalAmount: The notional amount of the option. Allowable valus are
  non-negative numbers.

- ParticipationRate: The participation rate. Allowable values are
  non-negative numbers. Usually the value will be between 0 and 1.

- ValuationDate: The valuation date. Allowable values are valid dates.

- SettlementDate: The settlement date. Allowable values are valid dates.

- Underlyings: The underlyings of the option. See
  <a href="#ss:underlying" data-reference-type="ref"
  data-reference="ss:underlying">[ss:underlying]</a> for each
  underlying.

- StrikePrices: The initial strike prices of the underlyings. For an FX
  underlying FX-SOURCE-CCY1-CCY2 this is the number of units of CCY2 per
  units of CCY1. For an EQ underlying this is the equity price expressed
  in the equity ccy. For a Commodity underlying this is the commodity
  price quoted as per the underlying commodity. Allowable values are
  non-negative numbers.

- Strike: The option strike. This is expressed in terms of the
  performance of the underlying basket (see the product description for
  more details). Allowable values are numbers.

- StrikeIncluded \[optional\]: If true the strike is included in the
  performance calculation, this is also the default if the flag not
  given. If false the strike is excluded.

- Position: The option position. Allowable values are *Long* or *Short*.

- PayCcy: The payment currency of the option. See the appendix for
  allowable currency codes.
