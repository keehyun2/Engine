## Envelope

The envelope node contains basic identifying details of a trade (` Id`,
`Type`, `Counterparty`, `NettingSetId`), a `PortfolioIds` node
containing a list of portfolio assignments, plus an `AdditionalFields`
node where custom elements can be added for informational purposes such
as `Book` or `Sector`. Beside the custom elements within the
` AdditionalFields` node, the envelope contains the same elements for
all Trade types. The `Id`, `Type`, `Counterparty` and `NettingSetId`
elements must have non-blank entries for ORE to run. The meanings and
allowable values of the various elements in the `Envelope` node follow
below.

- `Id`: The `Id` element in the envelope is used to identify trades
  within a portfolio. It should be set to identical values as the
  `Trade id=" "` element.

  Allowable values: Any alphanumeric string. The underscore (\_) sign
  may be used as well.

- `Counterparty`: Specifies the name of the counterparty of the trade.
  It is used to show exposure analytics by counterparty.

  Allowable values: Any alphanumeric string. Underscores (\_) and blank
  spaces may be used as well.

- `NettingSetId` \[Optional\]: The `NettingSetId` element specifies the
  identifier for a netting set. If a `NettingSetId` is specified, the
  trade is eligible for close-out netting under the terms of an
  associated ISDA agreement. The specified `NettingSetId` must be
  defined within the netting set definitions file (see section
  <a href="#sec:nettingsetinput" data-reference-type="ref"
  data-reference="sec:nettingsetinput">[sec:nettingsetinput]</a>). If
  left blank or omitted the trade will not belong to any netting set,
  and thus not be eligible for netting.

  Allowable values: Any alphanumeric string. Underscores (\_) and blank
  spaces may be used as well.

- `PortfolioIds` \[Optional\]: The PortfolioIds node allows the
  assignment of a given trade to several portfolios, each enclosed in
  its own pair of tags `<PortfolioId>` and ` </PortfolioId>` . Note that
  ORE does not assume a hierarchical organisation of such portfolios. If
  present, the portfolio IDs will be used in the generation of some ORE
  reports such as the VaR report which provides breakdown by any
  portfolio id that occurs in the trades’ envelopes.

  Allowable values for each PortfolioId: Any string.

- `AdditionalFields` \[Optional\]: The AdditionalFields node allows the
  insertion of additional trade information using custom XML elements.
  For example, elements such as Sector, Desk or Folder can be used. The
  elements within the `AdditionalFields` node are used for informational
  purposes only, and do not affect any analytics in ORE.

  Allowable values: Any custom element.
