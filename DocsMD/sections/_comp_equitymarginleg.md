### Equity Margin Leg

An equity margin leg is specified in a `LegData` node with `LegType` set
to `EquityMargin`. It is used to define a sequence of cashflows that are
linked to an equity price and it’s associated margin factor. Each
cashflow has an associated *Calculation Period*. This leg is typically
used to represent a part of a Total Return Swap (TRS) on an Equity Index
Future. The full TRS on the Equity Index Future uses TradeType *Swap*,
and one leg of type *Equity*, and the other leg of type *EquityMargin*.
Note that the equity identifier on both legs (the Name field) should be
for the Equity Index, and not the Future.  
The outline of a equity margin leg is given in listing
<a href="#lst:equitymarginleg" data-reference-type="ref"
data-reference="lst:equitymarginleg">[lst:equitymarginleg]</a>. It has
the usual `LegData` elements described in section
<a href="#ss:leg_data" data-reference-type="ref"
data-reference="ss:leg_data">[ss:leg_data]</a> and a
`EquityMarginLegData` node that is described in section
<a href="#ss:equity_margin_leg_data" data-reference-type="ref"
data-reference="ss:equity_margin_leg_data">0.0.2</a> below.

<div class="listing">

``` xml
<LegData>
  <LegType>EquityMargin</LegType>
  <Payer>true</Payer>
  <Currency>EUR</Currency>
  <PaymentConvention>Following</PaymentConvention>
  <PaymentLag>2D</PaymentLag>
  <PaymentCalendar>TARGET</PaymentCalendar>
  <ScheduleData>
       <Dates>
        <Dates>
         <Date>2019-12-31</Date>
         <Date>2020-03-30</Date>
         <Date>2020-06-30</Date>
         <Date>2020-09-30</Date>
         <Date>2020-12-30</Date>
         <Date>2021-03-30</Date>
       </Dates>
     </Dates>
  </ScheduleData>
  <PaymentDates>
    <PaymentDate>...</PaymentDate>
  </PaymentDates>
  <EquityMarginLegData>
    ...
  </EquityMarginLegData>
</LegData>
```

</div>

### Equity Margin Leg Data

The `EquityMarginLegData` node outline is shown in listing
<a href="#lst:equitymarginleg" data-reference-type="ref"
data-reference="lst:equitymarginleg">[lst:equitymarginleg]</a>. The
meaning and allowable values for each node are as follows:

- `Rates`: The fixed real rate(s) of the leg. While this can be a single
  value, a vector of values or a dated vector of values. Allowable
  values: Each rate element can take any real number. The rate is
  expressed in decimal form, e.g. *0.05* is a rate of 5%..

- `InitialMarginFactor`: this node is used to specify the equity margin
  factor for the first period of the trade. It’s a percentage that
  reflecting the current applicable official Exchange initial margin
  requirement. It is expressed in decimal form, e.g. *0.05* is a rate of
  5%..

- `EquityLegData`: this node is used to specify the underlying equity
  details. It’s values are as outlined in section
  <a href="#ss:equitylegdata" data-reference-type="ref"
  data-reference="ss:equitylegdata">[ss:equitylegdata]</a>.

- `Multiplier` \[Optional\]: in some cases, the cashflow amounts are
  multiplied by a fixed amount. Defaults to 1.

<div class="listing">

``` xml
<EquityMarginLegData>
  <Rates>
    <Rate>0.003</Rate>
  </Rates>
  <InitialMarginFactor>0.12</InitialMarginFactor>
  <Multiplier>10</Multiplier>
  <EquityLegData>
     <ReturnType>Total</ReturnType>
     <Name>RIC:.STOXX50E</Name>
     <InitialPrice>2946</InitialPrice>
     <NotionalReset>false</NotionalReset>
     <FixingDays>2</FixingDays>
  </EquityLegData>
</EquityMarginLegData>
```

</div>
