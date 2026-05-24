### Cross Currency Swap

A Cross Currency Swap can be represented with either trade type *Swap*
or *CrossCurrencySwap*. In the case of *Swap*, it is set up using a
`SwapData` container. For *CrossCurrencySwap*, we use
`CrossCurrencySwapData` with the same `LegData` sub-nodes within the
container, and it is required for this trade type to have:

- Two legs, each of type *Fixed* or *Floating*, i.e. *Fixed*-*Fixed*,
  *Floating*-*Floating*, *Fixed*-*Floating*, or *Floating*-*Fixed*
  combinations are allowed.

- Optionally additional legs of type *Cashflow*.

**Rebalancing**  
A Cross Currency Swap can be rebalancing, meaning the notional amount on
one leg resets to the equivalent of a fixed amount in another currency
(called ForeignCurrency, and is typically the currency of the other leg)
at each period. This is represented using an `FXReset` node on the
resetting/rebalancing leg, within the `Notionals` node.

Note that for rebalancing Cross Currency Swaps, the Notional in leg
currency on the rebalancing leg is optional. If set, it is used as
starting notional, and causes the first period (if forward starting) to
be considered as "on-the-run" for purposes of SIMM exemptions as the fx
rate for the notional is considered to have been fixed from the
inception of the trade. If no notional on the rebalancing leg is set,
the starting notional will be based on a projected fx rate (i.e. not
"on-the-run") until the actual fixing date.

Also on rebalancing Cross Currency Swaps, the NotionalInitialExchange
and NotionalFinalExchange flags must be set the same way on both legs.

The optional `FXReset` node includes the following elements:

- ForeignCurrency: The foreign currency the notional of the leg resets
  to.

  Allowable values: See Table
  <a href="#tab:currency" data-reference-type="ref"
  data-reference="tab:currency">[tab:currency]</a> Currency.

- ForeignAmount: The notional amount in the foreign currency that the
  notional of the leg resets to.

  Allowable values: Any positive real number.

- FXIndex: A reference to an FX Index source for the FX reset fixing.

  Allowable values: A string of the form FX-SOURCE-CCY1-CCY2. Note that
  the FX- part of the string stays constant for all currency pairs.

  See Table <a href="#tab:fxindex_data" data-reference-type="ref"
  data-reference="tab:fxindex_data">[tab:fxindex_data]</a> for further
  details, including supported FX-pairs for each fixing source.

Listing
<a href="#lst:crosscurrencyswapnonreset" data-reference-type="ref"
data-reference="lst:crosscurrencyswapnonreset">[lst:crosscurrencyswapnonreset]</a>
shows an example of a non-rebalancing *CrossCurrencySwapData* node. Note
that for non-rebalancing Cross Currency Swaps the structure is the same
as for the *Swap* trade type with the only difference being the top node
name as described, i.e. *SwapData*. Rebalancing Cross Currency Swaps,
see example in listing
<a href="#lst:crosscurrencyswapreset" data-reference-type="ref"
data-reference="lst:crosscurrencyswapreset">[lst:crosscurrencyswapreset]</a>,
also include the `FXReset` node, but otherwise also use the same
structure as the *Swap* trade type.

<div class="listing">

``` xml
    <CrossCurrencySwapData>
      <LegData>
        <LegType>Floating</LegType>
        <Payer>true</Payer>
        <Currency>USD</Currency>
        <Notionals>
           <Notional>30000000</Notional>
           <Exchanges>
              <NotionalInitialExchange>true</NotionalInitialExchange>
              <NotionalFinalExchange>true</NotionalFinalExchange>
            </Exchanges>
        </Notionals>
        <DayCounter>ACT/365</DayCounter>
        ...
        <FloatingLegData>
        ...
        </FloatingLegData>
      </LegData>
      <LegData>
        <LegType>Fixed</LegType>
        <Payer>false</Payer>
        <Currency>EUR</Currency>
        <Notionals>
           <Notional>29000000</Notional>
           <Exchanges>
              <NotionalInitialExchange>true</NotionalInitialExchange>
              <NotionalFinalExchange>true</NotionalFinalExchange>
            </Exchanges>
        </Notionals>
        <DayCounter>ACT/365</DayCounter>
        ...
        <FixedLegData>
        ...
        </FixedLegData>
      </LegData>
    </CrossCurrencySwapData>
```

</div>

<div class="listing">

``` xml
    <CrossCurrencySwapData>
      <LegData>
        <LegType>Floating</LegType>
        <Payer>true</Payer>
        <Currency>USD</Currency>
        <Notionals>
           <Notional>30000000</Notional>
           <Exchanges>
              <NotionalInitialExchange>true</NotionalInitialExchange>
              <NotionalFinalExchange>true</NotionalFinalExchange>
            </Exchanges>
        </Notionals>
        <DayCounter>ACT/365</DayCounter>
        ...
        <FloatingLegData>
        ...
        </FloatingLegData>
      </LegData>
      <LegData>
        <LegType>Floating</LegType>
        <Payer>false</Payer>
        <Currency>JPY</Currency>
        <Notionals>
           <Notional>4381340000</Notional> (in JPY)
           <FXReset>
              <ForeignCurrency>USD</ForeignCurrency>
              <ForeignAmount>30000000</ForeignAmount> (in USD)
              <FXIndex>FX-TR20H-USD-JPY</FXIndex>
           </FXReset>
           <Exchanges>
              <NotionalInitialExchange>true</NotionalInitialExchange>
              <NotionalFinalExchange>true</NotionalFinalExchange>
            </Exchanges>
        </Notionals>
        <DayCounter>ACT/365</DayCounter>
        ...
        <FloatingLegData>
        ...
        </FloatingLegData>
      </LegData>
    </CrossCurrencySwapData>
```

</div>

**Non-Deliverable**  
Note that Cross Currency Swaps having legs in non-deliverable currencies
with payment in a deliverable currency are supported by using the
Indexings node (<a href="#ss:indexings" data-reference-type="ref"
data-reference="ss:indexings">[ss:indexings]</a>), setting Settlement to
*Cash* and setting the Currency to the deliverable currency, while
keeping the Notional expressed in the non-deliverable currency amount.

The Indexings node includes a mandatory fx Index field defining the
deliverable and non-deliverable currency pair, and an optional
InitialNotionalFixing field for the contractual fx rate to be applied to
the initial notional exchange. Notice that the InitialNotionalFixing
rate has to be expressed as amount in deliverable or payment currency
per unit of non-deliverable currency, and if omitted defaults to a
projected (if in the future) or an fx fixing from market data (if in the
past). The Indexing node can also include optional FixingCalendar,
IsInArrears and FixingDays fields to determine the date(s) of the fx
fixing(s).

Listing <a href="#lst:ndir_xccy_swap" data-reference-type="ref"
data-reference="lst:ndir_xccy_swap">[lst:ndir_xccy_swap]</a> includes an
example USD-CLP non-deliverable cross currency swap where one leg is in
CLP which is a non-deliverable currency, and the other is in USD which
is deliverable. Note that it is possible for both legs to be in
different non-deliverable currencies.

<div class="listing">

``` xml
<SwapData>
  <Settlement>Cash</Settlement>
  <LegData>
   <LegType>Floating</LegType>
   <Payer>false</Payer>
   <Currency>USD</Currency>
    <Notionals>
     <Notional>1000000</Notional>
      <Exchanges>
       <NotionalInitialExchange>true</NotionalInitialExchange>
       <NotionalFinalExchange>true</NotionalFinalExchange>
      </Exchanges>
    </Notionals>
    ...
  </LegData>
  <LegData>
   <LegType>Floating</LegType>
   <Payer>false</Payer>
   <Currency>USD</Currency><!-- Payment currency is USD rather than CLP -->
    <Notionals>
     <Notional>850000000</Notional><!-- in CLP -->
      <Exchanges>
       <NotionalInitialExchange>true</NotionalInitialExchange>
       <NotionalFinalExchange>true</NotionalFinalExchange>
      </Exchanges>
     </Notionals>
     <Indexings>
      <Indexing>
    <Index>FX-TR20H-CLP-USD</Index><!-- to convert CLP flows into USD -->
    <FixingCalendar>CLP,USD</FixingCalendar>
        <IsInArrears>true</IsInArrears>
        <FixingDays>2</FixingDays>
        <InitialNotionalFixing>0.15</InitialNotionalFixing><!-- applied to initial ntl exchange -->
      </Indexing>
     </Indexings>
    ...
  </LegData>
</SwapData>
```

</div>
