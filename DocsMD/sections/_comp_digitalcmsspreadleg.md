### Digital CMS Spread Leg Data

Listing <a href="#lst:digitalcmsspreadlegdata" data-reference-type="ref"
data-reference="lst:digitalcmsspreadlegdata">[lst:digitalcmsspreadlegdata]</a>
shows an example for a leg of type *DigitalCMSSpread*.

<div class="listing">

``` xml
      <LegData>
        <LegType>DigitalCMSSpread</LegType>
        <Payer>false</Payer>
        <Currency>GBP</Currency>
        <Notionals>
          <Notional>10000000</Notional>
        </Notionals>
        <DayCounter>ACT/ACT</DayCounter>
        <PaymentConvention>Following</PaymentConvention>
        <ScheduleData>
          ...
        </ScheduleData>
        <DigitalCMSSpreadLegData>
            <CMSSpreadLegData>
              <Index1>EUR-CMS-10Y</Index1>
              <Index2>EUR-CMS-2Y</Index2>
              <Spreads>
                <Spread>0.0010</Spread>
              </Spreads>
              <Gearings>
                <Gearing>8.0</Gearing>
              </Gearings>
              <NakedOption>false</NakedOption>
            </CMSSpreadLegData>
            <CallPosition>Long</CallPosition>
            <IsCallATMIncluded>false</IsCallATMIncluded>
            <CallStrikes>
                <Strike>0.0001</Strike>
            </CallStrikes>
            <CallPayoffs>
                <Payoff>0.0001</Payoff>
            </CallPayoffs>
            <PutPosition>Long</PutPosition>
            <IsPutATMIncluded>false</IsPutATMIncluded>
            <PutStrikes>
                <Strike>0.001</Strike>
            </PutStrikes>
            <PutPayoffs>
                <Payoff>0.001</Payoff>
            </PutPayoffs>
        </DigitalCMSSpreadLegData>
      </LegData>
```

</div>

The `DigitalCMSSpreadLegData` block contains the following elements:

- CMSSpreadLegData: a `CMSSpreadLegData` block describing the underlying
  Digital CMS Spread leg (see
  <a href="#ss:cmsspreadlegdata" data-reference-type="ref"
  data-reference="ss:cmsspreadlegdata">[ss:cmsspreadlegdata]</a>). Caps
  and floors in the underlying CMS Spread leg are not supported for
  Digital CMS Spread Options. The `NakedOption` flag in the
  `CMSSpreadLegData` block is supported and can be used to separate the
  digital option payoff from the underlying CMS Spread coupon.

- CallPosition: Specifies whether the call option position is long or
  short.

- IsCallATMIncluded: inclusion flag on the call payoff if the call
  option ends at-the-money

- CallStrikes: strike rate for the call option

- CallPayoffs: digital call option payoff rate. If included the option
  is cash-or-nothing, if excluded the option is asset-or-nothing

- PutPosition: Specifies whether the put option position is long or
  short.

- IsPutATMIncluded: inclusion flag on the put payoff if the put option
  ends at-the-money

- PutStrikes: strike rate for the put option

- PutPayoffs: digital put option payoff rate. If included the option is
  cash-or-nothing, if excluded the option is asset-or-nothing
