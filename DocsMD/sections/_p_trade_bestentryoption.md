### Best Entry Option

Best Entry Options are defined using one of the trade types
*FxBestEntryOption*, *EquityBestEntryOption*, *CommodityBestEntryOption*
depending on the underlying asset class and an associated node
FxBestEntryOptionData, EquityBestEntryOptionData,
CommodityBestEntryOptionData. Listing
<a href="#lst:bestentryoption_data" data-reference-type="ref"
data-reference="lst:bestentryoption_data">[lst:bestentryoption_data]</a>
shows an example for an Equity Underlying. For a more detailed
description of the computation of the payoff of this option, please see
the product description. The nodes have the following meaning:

- Underlying: The underlying definition. Note that for FX underlyings
  the order of the currencies defines the observed underlying value,
  i.e. for EUR-USD the domestic currency is USD (the observed value is
  e.g. $1.2$ USD per EUR) while for USD-EUR the domestic currency is EUR
  (the observed value is e.g. $0.8$ EUR per USD).

  Allowable Values: See
  <a href="#ss:underlying" data-reference-type="ref"
  data-reference="ss:underlying">[ss:underlying]</a>

- Currency: The payment currency.

  Allowable Values: See `Currency` in Table
  <a href="#tab:allow_stand_data" data-reference-type="ref"
  data-reference="tab:allow_stand_data">[tab:allow_stand_data]</a>.

- SettlementDate: The date on which the option payoff is settled. The
  SettlementDate is used unadjusted as given.

  Allowable Values: any valid date greater or equal to the exercise
  date.

- Notional: The notional amount.

  Allowable Values: any real number

- Strike: The strike value used to compute the payoff of the option.
  This value should be provided as a decimal, representing a percentage
  of the value of $Index_{Initial}$, e.g. a value of
  $K = 0.6 \implies 0.6 \times Index_{Initial}$ in the computation of
  the payoff. Allowable Values: any real number

- Multiplier: The payoff multiplier used in the case that the underlying
  index is greater than the strike on the settlement date. If omitted
  defaults to $1$.

  Allowable Values: any real number

- TriggerLevel: The value that is compared to the underlying index on
  each strike observation date to determine if a Trigger Event has
  occurred. This should be provided as a decimal, representing a
  percentage of the value of Strike Index Level, ie the value of the
  underlying on the `StrikeDate`.

  Allowable Values: any real number

- LongShort: Denotes whether the payoff is computed relative to the
  holder or seller of the option.

  Allowable Values: *Long*, *Short*.

- Cap: The maximum value of the payoff (before the notional and
  multiplier are applied). This value should be interpreted as a
  percentage and should be in decimal format in the trade XML, e.g.
  $0.06 = 6\%$.

  Allowable Values: any real number

- ResetMinimum: The minimum value of $Index_{Initial}$ in the case that
  a Trigger Event has occurred at least once during the option’s
  lifetime. This should be provided as a decimal, representing a
  percentage of the value of Strike Index Level used in the computation
  of $Index_{Initial}$.

  Allowable Value: any real number

- StrikeDate: The date on which the level on the underlying index is
  used to compute the payoff, in the case that there has not been a
  Trigger Event during the option’s lifetime.

  Allowable Value: any valid date before the option expiry date.

- ExpiryDate: The date on which the option expires and the payoff is
  computed.

  Allowable Values: any valid date before the SettlementDate

- Premium: The option premium. Defaults to $0$.

  Allowable Values: any real number.

- PremiumDate: The date on which the option premium is paid.

  Allowable Values: any valid date.

- StrikeObservationDates: The set of dates on which the underlying index
  level is observed - the lowest of which is used to compute the option
  payoff if the underlying index is greater than the strike on the
  expiry date.

  Allowable Values: any valid dates schedule (see
  <a href="#ss:schedule_data" data-reference-type="ref"
  data-reference="ss:schedule_data">[ss:schedule_data]</a>).

<div class="listing">

``` xml
    <EquityBestEntryOptionData>
      <LongShort>Long</LongShort>
      <Strike>0.85</Strike>
      <Cap>0.06</Cap>
      <ResetMinimum>0.85</ResetMinimum>
      <Notional>1000000</Notional>
      <Multiplier>1</Multiplier>
      <TriggerLevel>0.95</TriggerLevel>
      <SettlementDate>2021-11-20</SettlementDate>
      <PremiumDate>2021-11-22</PremiumDate>
      <StrikeDate>2020-12-15</StrikeDate>
      <Underlying>
        <Type>Equity</Type>
        <Name>RIC:.SPX</Name>
      </Underlying>
      <StrikeObservationDates>
        <Dates>
          <Dates>
            <Date>2021-03-01</Date>
            <Date>2021-06-01</Date>
            <Date>2021-09-01</Date>
          </Dates>
        </Dates>
      </StrikeObservationDates>
      <Currency>USD</Currency>
      <Premium>100</Premium>
      <ExpiryDate>2021-11-20</ExpiryDate>
    </EquityBestEntryOptionData>
```

</div>
