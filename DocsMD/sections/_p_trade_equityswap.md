### Equity Swap

An Equity Swap uses its own trade type *EquitySwap*, and is set up using
a `EquitySwapData` node with one leg of type *Equity* and one more leg -
called Funding leg - that can be either *Fixed* or *Floating*. Listing
<a href="#lst:equityswap" data-reference-type="ref"
data-reference="lst:equityswap">[lst:equityswap]</a> shows an example.
The Equity leg contains an additional `EquityLegData` block. See
<a href="#ss:equitylegdata" data-reference-type="ref"
data-reference="ss:equitylegdata">[ss:equitylegdata]</a> for details on
the Equity leg specification.

Note that the *Equity* leg of an *EquitySwap* can only include one
single underlying equity name (that can be an equity index name). For
instruments with more than one underlying equity name, TradeType
*TotalReturnSwap* (GenericTRS) should be used instead.

Cross currency *EquitySwaps* are supported, i.e. the Equity and the
Funding legs do not need to have the same currency. However, if the
Funding leg uses `Indexings` with `FromAssetLeg` set to *true* to derive
the notionals from the Equity leg, then the Funding leg must use the
same currency as the Equity leg.

Note that pricing for an *EquitySwap* is based on discounted cashflows,
whereas pricing for a *TotalReturnSwap* (GenericTRS) on an equity
underlying uses the accrual method. The accrual method is common
practice when daily unwind rights are present in the trade terms.

Also note that, unlike other leg types, the `DayCounter` field is
optional for an *Equity* leg, and defaults to *ACT/365* if left blank or
omitted. The daycount convention for the equity leg of an equity swap
does not impact pricing, only the accrued amount (displayed in
cashflows).

<div class="listing">

``` xml
    <EquitySwapData>
      <LegData>
        <LegType>Floating</LegType>
        <Payer>true</Payer>
        <DayCounter>ACT/365</DayCounter>
        ...
      </LegData>
      <LegData>
        <LegType>Equity</LegType>
        <Payer>false</Payer>
        <DayCounter>ACT/365</DayCounter>
        ...
        <EquityLegData>
        ...
        </EquityLegData>
      </LegData>
    </EquitySwapData>
```

</div>

If the equity swap has a resetting notional, typically the Funding leg’s
notional will be aligned with the equity leg’s notional. To achieve
this, `Indexings` on the floating leg can be used, see
<a href="#ss:indexings" data-reference-type="ref"
data-reference="ss:indexings">[ss:indexings]</a>. In the context of
equity swaps the indexings can be defined in a simplified way by adding
an `Indexings` node with a subnode `FromAssetLeg` set to *true* to the
Funding leg’s `LegData` node. The `Notionals` node is not required in
the Funding leg’s LegData in this case. An example is shown in listing
<a href="#lst:equityswap_reset" data-reference-type="ref"
data-reference="lst:equityswap_reset">[lst:equityswap_reset]</a>.

<div class="listing">

``` xml
    <EquitySwapData>
      <LegData>
        <LegType>Floating</LegType>
        <Currency>USD</Currency>
        ...
        <!-- Notionals node is not required, set to 1 internally -->
        ...
        <Indexings>
          <!-- derive the indexing information (equity price, FX) from the Equity leg -->
          <FromAssetLeg>true</FromAssetLeg>
        </Indexings>
      </LegData>
      <LegData>
        <LegType>Equity</LegType>
          <Currency>USD</Currency>
          ...
          <EquityLegData>
            <Quantity>1000</Quantity>
        <Underlying>
         <Type>Equity</Type>
         <Name>.STOXX50E</Name>
         <IdentifierType>RIC</IdentifierType>
        </Underlying>
            <InitialPrice>2937.36</InitialPrice>
            <NotionalReset>true</NotionalReset>
            <FXTerms>
              <EquityCurrency>EUR</EquityCurrency>
              <FXIndex>FX-ECB-EUR-USD</FXIndex>
            </FXTerms>
          </EquityLegData>
          ...
      </LegData>
    </EquitySwapData>
```

</div>

### Dividend Swap

An Dividend Swap uses its the trade type *EquitySwap*, shown above
<a href="#ss:equity_swap" data-reference-type="ref"
data-reference="ss:equity_swap">0.0.1</a>, and is set up using a
`EquitySwapData` node with one leg of type *Equity*, with *ReturnType*
equal to *Dividend* and one more leg that can be either *Fixed* or
*Floating*. Listing
<a href="#lst:dividendswap" data-reference-type="ref"
data-reference="lst:dividendswap">[lst:dividendswap]</a> shows an
example.

An example is shown in listing
<a href="#lst:equityswap_reset" data-reference-type="ref"
data-reference="lst:equityswap_reset">[lst:equityswap_reset]</a>.

<div class="listing">

``` xml
    <EquitySwapData>
        <LegData>
            ...
        </LegData>
        <LegData>
            <Payer>false</Payer>
            <LegType>Equity</LegType>
            <Currency>EUR</Currency>
            <PaymentConvention>Following</PaymentConvention>
            <DayCounter>A360</DayCounter>
            <EquityLegData>
                <ReturnType>Dividend</ReturnType>
                <Underlying>
         <Type>Equity</Type>
         <Name>.STOXX50E</Name>
         <IdentifierType>RIC</IdentifierType>
        </Underlying>
            <Quantity>10000</Quantity>
            </EquityLegData>
            <ScheduleData>
                <Rules>
                    <StartDate>2018-12-31</StartDate>
                    <EndDate>2020-12-31</EndDate>
                    <Tenor>6M</Tenor>
                    <Calendar>EUR</Calendar>
                    <Convention>ModifiedFollowing</Convention>
                    <Rule>Forward</Rule>
                </Rules>
            </ScheduleData>
        </LegData>
    </EquitySwapData>
```

</div>
