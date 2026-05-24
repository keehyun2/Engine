# Trade Data

The trades that make up the portfolio are specified in an XML file where
the portfolio data is specified in a hierarchy of nodes and sub-nodes.
The nodes containing individual trade data are referred to as elements
or XML elements. These are generally the lowest level nodes.

The top level portfolio node is delimited by an opening `<Portfolio>`
and a closing `</Portfolio>` tag. Within the portfolio node, each trade
is defined by a starting `<Trade id="[Tradeid]">` and a closing
`</Trade>` tag. Further, the trade type is set by the TradeType XML
element. Each trade has an Envelope node that includes the same XML
elements for all trade types (Id, Type, Counterparty, Rating,
NettingSetId) plus the Additional fields node, and after that, a node
containing trade specific data.

An example of a `portfolio.xml` file with one Swap trade including the
full envelope node is shown in Listing
<a href="#lst:portfolio" data-reference-type="ref"
data-reference="lst:portfolio">[lst:portfolio]</a>.

<div class="listing">

``` xml
<Portfolio>
  <Trade id="Swap#1">
    <TradeType> Swap </TradeType>
    <Envelope>
      <CounterParty> Counterparty#1 </CounterParty>
      <NettingSetId> NettingSet#2 </NettingSetId>
      <PortfolioIds>
          <PortfoliodId> PF#1 </PortfolioId>
          <PortfoliodId> PF#2 </PortfolioId>
      </PortfolioIds>
      <AdditionalFields>
        <Sector> SectorA </Sector>
        <Book> BookB </Book>
        <Rating> A1 </Rating>
      </AdditionalFields>
    </Envelope>
    <SwapData>
        ...
        [Trade specific data for a Swap]
        ...
    </SwapData>
  </Trade>
</Portfolio>
```

</div>

A description of all portfolio data, i.e. of each node and XML element
in the portfolio file, with examples and allowable values follows below.
There is only one XML elements directly under the top level `Portfolio`
node:

- `TradeType`: ORE currently supports 14 trade types.

  Allowable values: *ForwardRateAgreement, Swap, CapFloor, Swaption,
  FxForward, FxSwap, FxOption, EquityForward, EquityOption,
  VarianceSwap, CommodityForward, CommodityOption, CreditDefaultSwap,
  Bond*
