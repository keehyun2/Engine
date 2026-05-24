### Equity Cliquet Option

The `EquityCliquetOptionData` node is the trade data container for the
*EquityCliquetOption* trade type. A cliquet option consists of a series
of consecutive forward starting equity options, with each option being
struck at a given moneyness (commonly at-the-money) when it becomes
active.

The structure of an example `EquityCliquetOptionData` node for an equity
cliquet option is shown in Listing
<a href="#lst:cliquetoption_data" data-reference-type="ref"
data-reference="lst:cliquetoption_data">[lst:cliquetoption_data]</a>.

<div class="listing">

``` xml
<EquityCliquetOptionData>
    <Underlying>
      <Type>Equity</Type>
      <Name>.SPX</Name>
      <IdentifierType>RIC</IdentifierType>
    </Underlying>
    <Currency>USD</Currency>
    <Notional>1000000.0</Notional>
    <LongShort>Short</LongShort>
    <OptionType>Call</OptionType>
    <Moneyness>1.0</Moneyness>
    <LocalCap>0.07</LocalCap>
    <LocalFloor>-0.06</LocalFloor>
    <GlobalCap>0.07</GlobalCap>
    <GlobalFloor>-0.07</GlobalFloor>
    <ScheduleData>
        <Dates>
            <Dates>
                <Date>20171231</Date>
                <Date>20181231</Date>
                <Date>20191231</Date>
                <Date>20201231</Date>
                <Date>20211231</Date>
                <Date>20221231</Date>
            </Dates>
            <Calendar>USD</Calendar>
            <Convention>F</Convention>
        </Dates>    
    </ScheduleData>
    <SettlementDays>5</SettlementDays>
    <Premium>0.027</Premium>
    <PremiumPaymentDate>31-12-2017</PremiumPaymentDate>
    <PremiumCurrency>USD</PremiumCurrency>
</EquityCliquetOptionData>
```

</div>

The meanings and allowable values of the elements in the
`CliquetOptionData` node below.

- Name: The identifier of the underlying equity or equity index.  
  Allowable values: See `Name` for equity trades in Table
  <a href="#tab:equity_credit_data" data-reference-type="ref"
  data-reference="tab:equity_credit_data">[tab:equity_credit_data]</a>.

- Underlying: This node may be used as an alternative to the `Name` node
  to specify the underlying equity. This in turn defines the equity
  curve used for pricing. The `Underlying` node is described in further
  detail in Section <a href="#ss:underlying" data-reference-type="ref"
  data-reference="ss:underlying">[ss:underlying]</a>.  

- Currency: The currency of the notional, and thus of the option.  
  Allowable values: See `Currency` in Table
  <a href="#tab:allow_stand_data" data-reference-type="ref"
  data-reference="tab:allow_stand_data">[tab:allow_stand_data]</a>. The
  Currency must be the same as the currency of the underlying equity.

- Notional: The notional of the cliquet option.  
  Allowable values: Any positive real number.

- LongShort: Defines whether the trade is long or short the option.  
  Allowable values: *Long, Short*

- OptionType: The type of the option.  
  Allowable values: *Call, Put*

- Moneyness: Adjustment of option return. The moneyness M each forward
  starting option is being struck at.  
  Allowable values: Any real number. Expressed in decimal form where 1.0
  is at-the-money, 1.1 is 110% of the at-the-money strike, 0.9 is 90% of
  the at-the-money strike, etc.

- LocalCap\[Optional\]: The local cap, $cap_{l}$, in each of the option
  return.  
  Allowable values: Any real number. If omitted, no local cap is
  applied. Can’t be left blank.

- LocalFloor\[Optional\]: The local floor, $floor_{l}$, in each of the
  option return.  
  Allowable values: Any real number. If omitted, no local floor is
  applied. Can’t be left blank.

- GlobalCap\[Optional\]: The global cap, $cap_{g}$, for the option
  return.  
  Allowable values: Any real number. If omitted, no global cap is
  applied. Can’t be left blank.

- GlobalFloor\[Optional\]: The global floor,$floor_{g}$, for the option
  return.  
  Allowable values: Any real number. If omitted, no global floor is
  applied. Can’t be left blank.

- ScheduleData: A schedule of dates that define the valuation dates of
  the consecutive forward starting options forming the Equity Cliquet
  Option. The first date in the schedule is the start date of the first
  consecutive option, the second date in the schedule is the
  end/valuation date of the first consecutive option, and also the start
  date of the second consecutive option, etc. The last date is the final
  valuation date, with payoff of the whole Cliquet option at this date
  plus `SettlementDays`.  
  Allowable values: A node on the same form as `ScheduleData`, (see
  <a href="#ss:schedule_data" data-reference-type="ref"
  data-reference="ss:schedule_data">[ss:schedule_data]</a>).

- SettlementDays\[Optional\]: Number of days from the last valuation
  date to the payoff being paid or received. The payoff date is
  determined with regards to calendar and term date convention of the
  schedule’s calendar.  
  Allowable values: Any positive integer. Defaults to zero if left blank
  or omitted.

- Premium\[Optional\]: The premium paid for the option.  
  Allowable values: Any real number. Expressed in decimal form relative
  to notional.

- PremiumPaymentDate\[Optional\]: The date the premium is the paid.  
  Allowable values: See `Date` in Table
  <a href="#tab:allow_stand_data" data-reference-type="ref"
  data-reference="tab:allow_stand_data">[tab:allow_stand_data]</a>. Note
  that if a Premium is specified, a PremiumPaymentDate must also be
  specified.

- PremiumCurrency\[Optional\]: The currency the premium is to paid in.  
  Allowable values: See `Currency` in Table
  <a href="#tab:allow_stand_data" data-reference-type="ref"
  data-reference="tab:allow_stand_data">[tab:allow_stand_data]</a>.
  Defaults to the currency of the notional.
