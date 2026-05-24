### Commodity Option

A European Commodity Option gives the buyer the right, but not the
obligation, to buy a set amount of a commodity, at a predetermined price
(the strike), at the end of the contract. For this right the buyer pays
a premium to the seller. Settlement can be either cash or physical
delivery.

The `CommodityOptionData` node is the trade data container for the
*CommodityOption* trade type. Vanilla commodity options are supported.
The exercise style may be *European* or *American*. The
`CommodityOptionData` node includes exactly one `OptionData` trade
component sub-node plus elements specific to the commodity option. The
structure of a `CommodityOptionData` node for a commodity option is
shown in Listing <a href="#lst:comoption_data" data-reference-type="ref"
data-reference="lst:comoption_data">[lst:comoption_data]</a>.

<div class="listing">

``` xml
<CommodityOptionData>
  <OptionData>
   <LongShort>Short</LongShort>
   <OptionType>Put</OptionType>
   <Style>European</Style>
   <Settlement>Cash</Settlement>
   <PayOffAtExpiry>false</PayOffAtExpiry>
    <ExerciseDates>
      <ExerciseDate>2029-04-28</ExerciseDate>
     </ExerciseDates>
  </OptionData>
  <Name>NYMEX:CL</Name>
  <Currency>USD</Currency>
  <StrikeData>
    <StrikePrice>
      <Value>100</Value>
      <Currency>USD</Currency>
    </StrikePrice>
  </StrikeData>
  <Quantity>500000</Quantity>
  <IsFuturePrice>true<IsFuturePrice>
  <FutureExpiryDate>2029-04-28<FutureExpiryDate>
</CommodityOptionData>
```

</div>

The meanings and allowable values of the elements in the
`CommodityOptionData` node follow below.

- The `CommodityOptionData` node contains an `OptionData` node described
  in <a href="#ss:option_data" data-reference-type="ref"
  data-reference="ss:option_data">[ss:option_data]</a>. The relevant
  fields in the `OptionData` node for a CommodityOption are:

  - `LongShort`: The allowable values are *Long* or *Short*.

  - `OptionType`: The allowable values are *Call* or *Put*.

  - `Style`: The exercise style of the CommodityOption. The allowable
    values are *European* or *American*.

  - `PayOffAtExpiry`: This must be set to *false* as payoff at expiry is
    not currently supported.

  - An `ExerciseDates` node where exactly one `ExerciseDate` date
    element must be given for. Allowable values: See Date in Table
    <a href="#tab:allow_stand_data" data-reference-type="ref"
    data-reference="tab:allow_stand_data">[tab:allow_stand_data]</a>.

  - `Premiums` \[Optional\]: Option premium node with amounts paid by
    the option buyer to the option seller. Allowable values: See section
    <a href="#ss:premiums" data-reference-type="ref"
    data-reference="ss:premiums">[ss:premiums]</a>

- Name: The name of the underlying commodity.  
  Allowable values: See `Name` for commodity trades in Table
  <a href="#tab:commodity_data" data-reference-type="ref"
  data-reference="tab:commodity_data">[tab:commodity_data]</a>.

- Currency: The currency of the commodity option.  
  Allowable values: See `Currency` in Table
  <a href="#tab:allow_stand_data" data-reference-type="ref"
  data-reference="tab:allow_stand_data">[tab:allow_stand_data]</a>.

- StrikeData: The option strike price. It uses the price quotation
  outlined in the underlying contract specs for the commodity name in
  question.  
  Allowable values: Only supports `StrikePrice` as described in Section
  <a href="#ss:strikedata" data-reference-type="ref"
  data-reference="ss:strikedata">[ss:strikedata]</a>.

- Quantity: The number of units of the underlying commodity covered by
  the transaction. The unit type is defined in the underlying contract
  specs for the commodity name in question. For avoidance of doubt, the
  Quantity is the number of units of the underlying commodity, not the
  number of contracts.  
  Allowable values: Any positive real number.

- IsFuturePrice \[Optional\]: A boolean indicating if the underlying is
  a future contract settlement price, `true`, or a spot price, `false`.

  Allowable values: A boolean value given in Table
  <a href="#tab:boolean_allowable" data-reference-type="ref"
  data-reference="tab:boolean_allowable">[tab:boolean_allowable]</a>. If
  not provided, the default value is `true`.

- FutureExpiryDate \[Optional\]: If `IsFuturePrice` is `true` and the
  underlying is a future contract settlement price, this node allows the
  user to specify the expiry date of the underlying future contract.

  Allowable values: This should be a valid date as outlined in Table
  <a href="#tab:allow_stand_data" data-reference-type="ref"
  data-reference="tab:allow_stand_data">[tab:allow_stand_data]</a>. If
  not provided, it is assumed that the future contract’s expiry date is
  equal to the option expiry date provided in the `OptionData` node.

### Commodity Digital Option

A commodity digital option is represented with trade type
*CommodityDigitalOption* and a corresponding
`CommodityDigitalOptionData` node. The latter differs from the
`CommodityOptionData` node in section
<a href="#ss:input_commodity_option" data-reference-type="ref"
data-reference="ss:input_commodity_option">0.0.1</a> by replacing tag
*Quantity* with tag *Payoff* which is the cash amount paid in the
Currency of the option from the party that is short to the party that is
long, when the underlying price exceeds the strike at expiry in case of
a Call (or falls below the strike in case of a Put). The digital option
is priced in ORE as a spread of vanilla Commodity options at two
slightly different strikes. For option type *Call* and *Put*,
respectively, the digital call/put is constructed as $$\begin{aligned}
\mbox{Digital Call} =  \frac{\mbox{Payoff}}{\Delta}  \times  \left( \mbox{Call}(K- \Delta/2) - \mbox{Call}(K+ \Delta/2) \right) \\
\mbox{Digital Put} = \frac{\mbox{Payoff}}{\Delta}  \times \left( \mbox{Put}(K+ \Delta/2) - \mbox{Put}(K- \Delta/2)  \right)
\end{aligned}$$ so that the long digital option has positive value in
both cases. The strike spread $\Delta$ used here is set to 1% of strike
$K$. However, the default 1% can be overridden by setting the
’StrikeSpread’ parameter in the pricing engine global parameters.

### Commodity Spread Option

A commodity Spread Option is represented with trade type
*CommoditySpreadOption* and a corresponding `CommoditySpreadOptionData`
node.

The `CommoditySpreadOptionData` node is the trade data container for the
*CommoditySpreadOption* trade type. The structure of a
`CommoditySpreadOptionData` node for a commodity option is shown in
Listing <a href="#lst:com_s_option_data" data-reference-type="ref"
data-reference="lst:com_s_option_data">[lst:com_s_option_data]</a>.

The `CommoditySpreadOptionData` include exactly two `LegData` nodes of
type *CommodityFloating*. Details on these are described in
<a href="#ss:commodityfloatingleg" data-reference-type="ref"
data-reference="ss:commodityfloatingleg">[ss:commodityfloatingleg]</a>.
The resulting Legs must produce the same amount of cashflows (i.e. the
number of *calculation period*s must be the same for the long and short
positions). If the number of cashflows per leg is 1, this trade
represents a single commodity spread option. If is greater than 1, it
represents a multi-period commodity spread option. Exactly one payer and
one receiver leg are required, the leg with `isPayer` setto *true* is
the long (positive) position in the spread payoff.

Within the two `LegData`, the `Quantity` node has must be equal. If the
underlying contracts are quoted using different units (e.g. barrels vs
liters), the `Gearing` node must be used to account for this difference.
The gearing could also be used for the heat rate factor in spark / heat
rate options.

Other than the two legs, the following nodes complete the
`CommoditySpreadOptionData` container:

- `SpreadStrike`: The strike value for the spread. Allowable values: Any
  real number.

- `OptionData`: This is a trade component sub-node outlined in section
  <a href="#ss:option_data" data-reference-type="ref"
  data-reference="ss:option_data">[ss:option_data]</a>. The relevant
  fields in the `OptionData` node for an CommoditySpreadOption are

  - `LongShort` The allowable values are *Long* or *Short*.

  - `OptionType` The allowable values are *Call* or *Put*.

  - `Premiums` \[Optional\]: Option premium amounts paid by the option
    buyer to the option seller. See section
    <a href="#ss:premiums" data-reference-type="ref"
    data-reference="ss:premiums">[ss:premiums]</a>

  - `ExerciseDates` \[Optional\]: If given, there must be one exercise
    date for each option period. If omitted, the option expiry is
    derived from the cashflows and falls on the last pricing period of
    the commodity cashflow.

  - `PaymentData` \[Optional\]: This node is used to supply the date on
    which the option is cash settled if it is exercised. If omitted the
    settlement date is derived from the cashflow payment dates.

- `OptionStripPaymentDates` \[Optional\]: If the number of cashflows per
  leg is greater than 1, we can group options by their expiry date into
  strips. All option in a strip will have the same payment date as
  defined in this node. The payment date will be *lag* business days
  after the latest expiry date in the strip. The node has following
  sub-nodes:

  - `OptionStripDefinition` A schedule node
    <a href="#ss:schedule_data" data-reference-type="ref"
    data-reference="ss:schedule_data">[ss:schedule_data]</a> defining
    the option strips. The $n$ dates in the schedule defining $n-1$
    strips, each strip include the period’s start date and excludes
    period’s end date. All options with expiry within start and end of a
    period are falling in the same strip. The schedule has to cover all
    option expiries. The first date in the schedule has to be before or
    on the first expiry date of the options and the last date in the
    schedule has to be after last expiry date of the options.

  - `PaymentCalendar` Calendar defining valid business days for the
    payment date.

  - `PaymentLag` number of business days.

  - `PaymentConvention` business day convention for the option strip
    payment date.

<div class="listing">

``` xml
<CommoditySpreadOptionData>
  <LegData>
   <LegType>CommodityFloating</LegType>
   <IsPayer>true<IsPayer>
   ...
  </LegData>
  <LegData>
   <LegType>CommodityFloating</LegType>
   <IsPayer>false<IsPayer>
   ...
  </LegData>
  <OptionData>
    <LongShort>Long</LongShort>
    <OptionType>Call</OptionType>
     <Premiums>
       <Premium>
         <Amount>10900</Amount>
         <Currency>EUR</Currency>
         <PayDate>2020-03-01</PayDate>
       </Premium>
     </Premiums>
  </OptionData>
  <SpreadStrike>2.3</SpreadStrike>
  <OptionStripPaymentDates>
    <OptionStripDefinition>
          <Rules>
        <StartDate>2023-07-01</StartDate>
            <EndDate>2023-10-01</EndDate>
            <Tenor>1M</Tenor>
            <Calendar>NullCalendar</Calendar>
            <Convention>Unadjusted</Convention>
            <TermConvention>Unadjusted</TermConvention>
            <Rule>Backward</Rule>
          </Rules>
    </OptionStripDefinition>
    <PaymentCalendar>ICE_FuturesUS,US-NERC</PaymentCalendar>
    <PaymentLag>5</PaymentLag>
    <PaymentConvention>MF</PaymentConvention>
  </OptionStripPaymentDates>
</CommoditySpreadOptionData>
```

</div>
