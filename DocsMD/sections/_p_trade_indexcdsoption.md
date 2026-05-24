### Index Credit Default Swap Option

An index CDS option has trade type `IndexCreditDefaultSwapOption` in
ORE. The Index CDS Option is set up using an
`IndexCreditDefaultSwapOptionData` node as shown in Listing
<a href="#lst:indexcdsoptiondata" data-reference-type="ref"
data-reference="lst:indexcdsoptiondata">[lst:indexcdsoptiondata]</a>.
Its child nodes have the following meanings:

An index CDS option, trade type `IndexCreditDefaultSwapOption`, is an
option to enter into an index CDS at a specified strike spread or strike
price. The Index CDS Option is set up using an
`IndexCreditDefaultSwapOptionData` node as shown in Listing
<a href="#lst:indexcdsoptiondata" data-reference-type="ref"
data-reference="lst:indexcdsoptiondata">[lst:indexcdsoptiondata]</a>.
Its child nodes have the following meanings:

- `IndexTerm` \[Optional\]: An optional node giving the term of the
  underlying index CDS e.g. 3Y, 5Y, 7Y, 10Y etc. The main function of
  this node is to allow for different index CDS option volatility
  structures for different terms of the same index series e.g. a CDX HY
  Series 34 5Y volatility structure and a CDX HY Series 34 10Y
  volatility structure. If this node is omitted, the market is searched
  for a CDS volatility surface with ID equal to the value of the
  `CreditCurveId` node under `IndexCreditDefaultSwapData`. There will
  generally be one `CreditCurveId` for each index CDS series
  e.g. `CDXHYS34V1` for CDX HY Series 34 Version 1. Consequently, there
  can only be one CDS volatility surface for this index CDS series. When
  `IndexTerm` is populated with the underlying index term, the market is
  searched for a CDS volatility surface with ID equal to the value of
  the `CreditCurveId` node with suffix `-[IndexTerm]`. For example, if
  the `CreditCurveId` node on an index CDS option trade is `CDXHYS34V1`
  and the `IndexTerm` node is populated with `5Y`, the market will be
  searched for a CDS volatility surface with ID `CDXHYS34V1-5Y` and this
  will be used in the trade valuation. In this way, different volatility
  surfaces can be used to value different terms of the same CDS index
  series.

  Allowable values: A string that can be parsed as a term that is a
  valid term for the underlying CDS index e.g. *5Y*, *10Y*, etc.  
  If omitted, the `IndexTerm` is derived from the given StartDate and
  EndDate of the underlying IndexCDS. Note that, with `IndexTerm`
  omitted, these dates have to match the start / end dates of the actual
  underlying IndexCDS, otherwise the trade will fail.

- `OptionData`: A node defining the option details as described in
  Section <a href="#ss:option_data" data-reference-type="ref"
  data-reference="ss:option_data">[ss:option_data]</a>. The relevant
  fields in the `OptionData` node for an IndexCDSOption are:

  - `LongShort` The allowable values are *Long* or *Short*. *Long*
    meaning that the holder has the option to enter into the underlying
    index CDS.

  - `OptionType` \[Optional\] *Put/Call* is optional and not used. The
    `Payer` field in the underlying Index CDS leg determines if the
    option is to buy or sell protection. The `Payer` field is from the
    perspective of the party that is long.

  - `Style` Must be set to *European* as this is the only supported
    exercise for `IndexCreditDefaultSwapOption`.

  - `Settlement` The allowable values are *Cash* or *Physical*.

  - `PayOffAtExpiry` Must be set to *false* as only payoff at exercise
    is supported.

  - An `ExerciseDates` node where exactly one ExerciseDate date element
    must be given.

  - `Premiums` \[Optional\]: Option premium amounts paid by the option
    buyer (*Long*) to the option seller (*Short*). See section
    <a href="#ss:premiums" data-reference-type="ref"
    data-reference="ss:premiums">[ss:premiums]</a>

- `IndexCreditDefaultSwapData`: A node defining the underlying index CDS
  as described in Section
  <a href="#ss:indexcds" data-reference-type="ref"
  data-reference="ss:indexcds">[ss:indexcds]</a>. Note that the
  `StartDate` in the `Scheduledata` in the premium leg in the
  `IndexCreditDefaultSwapData` should be the date on which the
  underlying CDS is entered into if the option is exercised (as opposed
  to the inception date of the underlying index CDS series). Under
  standard terms, the `StartDate` would be equal to the `ExerciseDate`
  plus one day, but it can also be on a later date, but not on a date
  before or on the `ExerciseDate`, unless Rule is *CDS2015* or *CDS* and
  `StartDate` is set at the start of the full IMM period that the
  `ExerciseDate` falls into.

  The `TradeDate` and `ProtectionStart` on the underlying CDS do not
  need to be populated. If omitted, which is recommended, the
  `TradeDate` and `ProtectionStart` on the underlying CDS default as
  follows:

  `TradeDate` = max (option `ExerciseDate`, underlying schedule
  `StartDate` - 1)  
  `ProtectionStart` = max (option `ExerciseDate` + 1, underl. schedule
  `StartDate`)

  Note that the cash settlement date for the underlying swap upfront
  premium is set to the underlying `TradeDate` with defaults as above,
  plus 3 business days.

  Also note that for schedules with IMM rules (e.g. *CDS2015*), if the
  underlying schedule `StartDate` is not falling on an IMM date, it is
  adjusted to the previous quarterly IMM date.

  Finally, the notional is - as in the case of an Index Credit Default
  Swap - the “unfactored notional”, i.e. the notional excluding any
  defaults between the series inception and the trade or evaluation date
  of the trade.

- `Strike` \[Optional\]: A real number defining the option strike level.
  If this is an empty string or omitted the strike will be determined
  according to table
  <a href="#tab:indexcdsoption_strike_deduction" data-reference-type="ref"
  data-reference="tab:indexcdsoption_strike_deduction">1</a>.

  Note that if a strike is given, the UpfrontFee on the underlying
  IndexCDS must be zero or omitted. The UpfrontFee is interpreted as a
  price strike.

  Allowable values: Any real number. Note that the `Strike` is expressed
  in decimal form when `StrikeType` is *Spread*, and in decimal form as
  percentage of notional when `StrikeType` is *Price*. I.e. a `Strike`
  of 1.05 is 105% of the notional when `StrikeType` is *Price*.

- `StrikeType` \[Optional\]: Determines the strike type. If *Spread* is
  given, the `Strike` is interpreted as a strike *spread*. If *Price* is
  given, the `Strike` is interpreted as a strike *price*. If omitted or
  left blank, it will be determined according to table
  <a href="#tab:indexcdsoption_strike_deduction" data-reference-type="ref"
  data-reference="tab:indexcdsoption_strike_deduction">1</a>.

  Allowable values: *Spread* or *Price*. Note that *Spread* is only
  supported when the underlying market data is set up with spread
  strikes, and *Price* is only supported when the market data is set up
  with price strikes. Typically the market data convention for Index CDS
  Options is spread strikes, with the exception of CDX North America
  High Yield (CDX NA HY) names, where the convention is to use price
  strikes.

- `TradeDate` \[Optional\]: The trade date. If not given defaults to the
  valuation date. In case of an underlying default the trade date is
  used to determine whether the underlying notional before default
  should be considered part of the outstanding notional (TradeDate $<$
  AuctionDate) or not (TradeDate $\geq$ AuctionDate). Since the trade
  date is also used as the start date of the front end protection (if
  the field FrontEndProtectionStartDate is not populated), it impacts
  the realized front end protection value. It is therefore essential to
  populate the TradeDate with the correct value if defaults occured in
  the underlying index. If the trade date is not given and there were
  defaults a warning is emitted stating that the valuation might not be
  accruate.

  Allowable values: See `Date` in Table
  <a href="#tab:allow_stand_data" data-reference-type="ref"
  data-reference="tab:allow_stand_data">[tab:allow_stand_data]</a>. Can
  not be later than the valuation date.

- `FrontEndProtectionStartDate` \[Optional\]: The date on which the
  front end protection kicks in. If not given, it defaults to the
  TradeDate. In case of an underlying default this date is used to
  determine whether the underlying contributes to the realised front end
  protection amount (FrontEndProtectionStartDate $<$ AuctionDate) or not
  (FrontEndProtectionStartDate $\geq$ AcutionDate).

  Allowable values: See `Date` in Table
  <a href="#tab:allow_stand_data" data-reference-type="ref"
  data-reference="tab:allow_stand_data">[tab:allow_stand_data]</a>. Can
  not be later than the trade date.

- `FixedRecoveryRate` \[Optional\]: If provided, this recovery rate will
  be used in place of the market quoted recovery rate of the underlying.

  Allowable values: Any real number in the range \[0,1\]. If omitted,
  the market quoted recovery rate of the underlying is used.

<div class="listing">

``` xml
<IndexCreditDefaultSwapOptionData>
  <IndexTerm>5Y</IndexTerm>
  <OptionData>
      <LongShort>Long</LongShort>
      <Style>European</Style>
      <Settlement>Cash</Settlement>
      <PayOffAtExpiry>false</PayOffAtExpiry>
      <ExerciseDates>
        <ExerciseDate>2023-05-09</ExerciseDate>
      </ExerciseDates>
  </OptionData>
  <IndexCreditDefaultSwapData>
    ... 
  </IndexCreditDefaultSwapData>
  <Strike>1.063</Strike>
  <StrikeType>Price</StrikeType>
</IndexCreditDefaultSwapOptionData>
```

</div>

<div id="tab:indexcdsoption_strike_deduction">

| Strike | StrikeType | UpfrontFee   | Effective Strike | Effective StrikeType |
|:-------|:-----------|:-------------|:-----------------|:---------------------|
| na     | na         | na           | RunningCoupon    | Spread               |
| na     | Spread     | na           | RunningCoupon    | Spread               |
| na     | Price      | na           | 1.0              | Price                |
| K      | na         | na           | K                | Spread               |
| K      | Spread     | na           | K                | Spread               |
| K      | Price      | na           | K                | Price                |
| na     | na         | U            | 1.0 - U          | Price                |
| na     | Spread     | U ($= 0$)    | RunningCoupon    | Spread               |
| na     | Spread     | U ($\neq 0$) | (not allowed)    | (not allowed)        |
| na     | Price      | U            | 1.0 - U          | Price                |
| K      | na         | U ($= 0$)    | K                | Spread               |
| K      | na         | U ($\neq 0$) | (not allowed)    | (not allowed)        |
| K      | Spread     | U ($= 0$)    | K                | Spread               |
| K      | Spread     | U ($\neq 0$) | (not allowed)    | (not allowed)        |
| K      | Price      | U ($= 0$)    | K                | Price                |
| K      | Price      | U ($\neq 0$) | (not allowed)    | (not allowed)        |

Effective strike and strike type to be used in an Index CDS Option
dependent on the Strike, StrikeType and UpfrontFee in the underlying
Index CDS

</div>
