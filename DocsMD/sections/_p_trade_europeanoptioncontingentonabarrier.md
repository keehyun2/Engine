### European Option Contingent on a Barrier

European exercise, American or European barrier, multi-asset

This is a plain vanilla European option on a given underlying, whose
final payoff is contingent on the price level of another underlying
(forming the barrier). Both underlyings can be of multiple asset
classes.

The trade container for this product is the `EuropeanOptionBarrierData`
node, and the corresponding trade type is EuropeanOptionBarrier. The
barrier can be continuously monitored (American) or only be monitored on
the option expiry date (European). Currently, we support Equity, FX,
Commodity and InterestRate for the option underlying. For the barrier
underlying, we support Equity, FX, Commodity and InterestRate for
European-style barriers, but not InterestRate for an American-style
barrier.

Listing <a href="#lst:european_option_american_barrier"
data-reference-type="ref"
data-reference="lst:european_option_american_barrier">[lst:european_option_american_barrier]</a>
shows the structure of an Equity European option with an American-style
FX barrier. For a European-style barrier, the `BarrierType` must be set
to *European* and the `BarrierSchedule` can be omitted.

<div class="listing">

``` xml
<Trade id="Equity_EuropeanOptionWithAmericanFxBarrier">
  <TradeType>EuropeanOptionBarrier</TradeType>
  <Envelope>
    .....
  </Envelope>
  <EuropeanOptionBarrierData>
    <Quantity>8523</Quantity>
    <PutCall>Call</PutCall>
    <LongShort>Short</LongShort>
    <Strike>3520</Strike>
    <PremiumAmount>114.40</PremiumAmount>
    <PremiumCurrency>EUR</PremiumCurrency>
    <PremiumDate>2019-12-13</PremiumDate>
    <OptionExpiry>2020-06-19</OptionExpiry>
    <OptionUnderlying>
      <Type>Equity</Type>
      <Name>RIC:.STOXX50E</Name>
    </OptionUnderlying>
    <BarrierUnderlying>
      <Type>FX</Type>
      <Name>ECB-EUR-USD</Name>
    </BarrierUnderlying>
    <BarrierLevel>1.09335</BarrierLevel>
    <BarrierType>DownAndIn</BarrierType>
    <BarrierStyle>American</BarrierStyle>
    <BarrierSchedule>
      <Rules>
        <StartDate>2019-12-11</StartDate>
        <EndDate>2020-06-19</EndDate>
        <Tenor>1D</Tenor>
        <Calendar>USA</Calendar>
        <Convention>Following</Convention>
        <TermConvention>Following</TermConvention>
        <Rule>Forward</Rule>
      </Rules>
    </BarrierSchedule>
    <SettlementDate>2020-06-24</SettlementDate>
    <PayCcy>USD</PayCcy>
  </EuropeanOptionBarrierData>
</Trade>
```

</div>

The meanings and allowable values of the elements in the
`EuropeanOptionBarrierData` node follow below.

- Quantity: Number of option contracts.  
  Allowable values: Any non-negative number.

- PutCall: Option type.  
  Allowable values: *Call, Put*

- LongShort: Own party position.  
  Allowable values: *Long, Short*

- Strike: Option strike price.  
  Allowable values: Any positive number.

- PremiumAmount: Premium amount per option.  
  Allowable values: Any number.

- PremiumCurrency: Currency of the option premium.  
  Allowable values: See `Currency` in Table
  <a href="#tab:allow_stand_data" data-reference-type="ref"
  data-reference="tab:allow_stand_data">[tab:allow_stand_data]</a>.

- PremiumDate: The option premium payment date.  
  Allowable values: See `Date` in Table
  <a href="#tab:allow_stand_data" data-reference-type="ref"
  data-reference="tab:allow_stand_data">[tab:allow_stand_data]</a>.

- OptionExpiry: Option expiry date.  
  Allowable values: See `Date` in Table
  <a href="#tab:allow_stand_data" data-reference-type="ref"
  data-reference="tab:allow_stand_data">[tab:allow_stand_data]</a>.

- OptionUnderlying: The option underlying.  
  Allowable values: A node of the same form as `Underlying`, (see
  <a href="#ss:underlying" data-reference-type="ref"
  data-reference="ss:underlying">[ss:underlying]</a>). The supported
  types are *Equity*, *FX*, *Commodity* and *InterestRate*.  

- BarrierUnderlying: The underlying monitored against the barrier
  level.  
  Allowable values: A node of the same form as `Underlying`, (see
  <a href="#ss:underlying" data-reference-type="ref"
  data-reference="ss:underlying">[ss:underlying]</a>). The supported
  types are *Equity*, *FX*, *Commodity* and *InterestRate* if
  `BarrierStyle` is *European*. For `BarrierStyle` *American*, we only
  support *Equity*, *FX* and *Commodity*.

- BarrierLevel: Knock-in/knock-out barrier level.  
  Allowable values: Any number.

- BarrierType: The type of knock-in or knock-out barrier.  
  Allowable values: *DownIn, UpIn, DownOut, UpOut*

- BarrierStyle: Whether the barrier is continuously monitored or only at
  the option expiry date.  
  Allowable values: *American, European*

- BarrierSchedule \[Optional\]: The schedule specifying the schedule of
  trading days over which the continuous barrier will be monitored. This
  is required only when `BarrierStyle` is *American*.  
  Allowable values: A node of the same form as `ScheduleData`, (see
  <a href="#ss:schedule_data" data-reference-type="ref"
  data-reference="ss:schedule_data">[ss:schedule_data]</a>).

- SettlementDate: Settlement date of the option exercise payoff.  
  Allowable values: See `Date` in Table
  <a href="#tab:allow_stand_data" data-reference-type="ref"
  data-reference="tab:allow_stand_data">[tab:allow_stand_data]</a>. The
  Settlement date must be on or after the Option expiry date.

- PayCcy: Settlement currency.  
  Allowable values: See Table
  <a href="#tab:currency" data-reference-type="ref"
  data-reference="tab:currency">[tab:currency]</a> `Currency`.
