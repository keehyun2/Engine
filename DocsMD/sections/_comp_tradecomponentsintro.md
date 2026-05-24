## Trade Components

Trade components are XML sub-nodes used within the trade data containers
to define sets of trade data that more than one trade type can have in
common, such as a leg or a schedule. A trade data container can include
multiple trade components such as a swap with multiple legs, and a trade
component can itself contain further trade components in a nested way.

An example of a `SwapData` trade data container, including two `LegData`
trade components which in turn include further trade components such as
`FixedLegData`, `ScheduleData` and `FloatingLegData` is shown in Listing
<a href="#lst:trade_component" data-reference-type="ref"
data-reference="lst:trade_component">[lst:trade_component]</a>.

<div class="listing">

``` xml
        <SwapData>
            <LegData>
                <Payer>true</Payer>
                <LegType>Fixed</LegType>
                <Currency>EUR</Currency>
                <PaymentConvention>Following</PaymentConvention>
                <DayCounter>30/360</DayCounter>
                <Notionals>
                    <Notional>1000000</Notional>
                </Notionals>
                <ScheduleData>
                ...
                </ScheduleData>
                <FixedLegData>
                    <Rates>
                        <Rate>0.035</Rate>
                    </Rates>
                </FixedLegData>
            </LegData>
            <LegData>
                ...
                <ScheduleData>
                    ...
                </ScheduleData>
                <FloatingLegData>
                    ...
                </FloatingLegData>
            </LegData>
        </SwapData>
```

</div>

Descriptions of all trade components supported in ORE follow below.
