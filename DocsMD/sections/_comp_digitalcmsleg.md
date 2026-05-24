### Digital CMS Leg Data

Listing <a href="#lst:digitalcmslegdata" data-reference-type="ref"
data-reference="lst:digitalcmslegdata">[lst:digitalcmslegdata]</a> shows
an example for a leg of type *DigitalCMS*.

<div class="listing">

``` xml
      <LegData>
        <LegType>DigitalCMS</LegType>
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
        <DigitalCMSLegData>
          <CMSLegData>
            <Index>EUR-CMS-10Y</Index>
            <FixingDays>2</FixingDays>
            <Gearings>
              <Gearing>3.0</Gearing>
            </Gearings>
            <Spreads>
              <Spread>0.0010</Spread>
            </Spreads>
            <NakedOption>false</NakedOption>
          </CMSLegData>
          <CallPosition>Long</CallPosition>
          <IsCallATMIncluded>false</IsCallATMIncluded>
          <CallStrikes>
            <Strike>0.003</Strike>
          </CallStrikes>
          <CallPayoffs>
            <Payoff>0.003</Payoff>
          </CallPayoffs>
          <PutPosition>Short</PutPosition>
          <IsPutATMIncluded>false</IsPutATMIncluded>
          <PutStrikes>
            <Strike>0.05</Strike>
          </PutStrikes>
          <PutPayoffs>
            <Payoff>0.05</Payoff>
          </PutPayoffs>
        </DigitalCMSLegData>
      </LegData>
```

</div>

The `DigitalCMSLegData` block contains the following elements:

- CMSLegData: a `CMSLegData` block describing the underlying Digital CMS
  leg (see <a href="#ss:cmslegdata" data-reference-type="ref"
  data-reference="ss:cmslegdata">[ss:cmslegdata]</a>). Caps and floors
  in the underlying CMS leg are not supported for Digital CMS Options.
  The `NakedOption` flag in the `CMSLegData` block is supported and can
  be used to separate the digital option payoff from the underlying CMS
  coupon.

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
