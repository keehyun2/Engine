### Composite Trade

A composite trade is a hybrid position consisting of multiple component
trades. As such it inherits the characteristics of the trades defined
within it. Examples of Composite Trades include combinations of vanilla
options like straddles.

The `CompositeTradeData` node is the trade data container for the
*CompositeTrade* trade type. A composite trade is a hybrid position
consisting of multiple component trades. The structure of an example
`CompositeTradeData` node for a commodity option is shown in Listing
<a href="#lst:compositetrade_data" data-reference-type="ref"
data-reference="lst:compositetrade_data">[lst:compositetrade_data]</a>.

<div class="listing">

``` xml
        <CompositeTradeData>
          <Currency>USD</Currency>
          <NotionalCalculation>Sum</NotionalCalculation>
          <Components>
            <Trade id="">
              <!-- A valid trade xml -->
            </Trade>
            <Trade id="">
              <!-- A valid trade xml -->
            </Trade>
          </Components>
        </CompositeTradeData>
```

</div>

<div class="listing">

``` xml
        <CompositeTradeData>
          <Currency>USD</Currency>
          <NotionalCalculation>Sum</NotionalCalculation>
          <PortfolioBasket>true</PortfolioBasket>
          <BasketName>NAME</BasketName>
          <IndexQuantity>100</IndexQuantity>
        </CompositeTradeData>
```

</div>

The meanings and allowable values of the elements in the
`CompositeTradeData` node follow below.

- Currency: Defines the currency the NPV of the composite trade will be
  represented in.  
  Allowable values: See Table
  <a href="#tab:currency" data-reference-type="ref"
  data-reference="tab:currency">[tab:currency]</a> `Currency`.

- NotionalCalculation \[Optional\]: The method by which the notional of
  the composite trade will be calculated.  
  Allowable values:

  - *Sum*: The notional will be calculated as the sum of the notionals
    of the constituent trades. This is the default behaviour if the
    field is omitted (unless an override is provided).

  - *Mean* or *Average*: The notional will be calculated as the mean of
    the notionals of the constituent trades.

  - *First*: The notional of the first constituent trade will be used.

  - *Last*: The notional of the first constituent trade will be used.

  - *Min*: The notional will be calculated as the minimum of the
    notionals of the constituent trades.

  - *Max*: The notional will be calculated as the minimum of the
    notionals of the constituent trades.

  - *Override*: the notional will be read directly from the notional
    override field.

- NotionalOverride \[Optional\]: The notional which will be used for the
  trade, overriding any calculation method specified.  
  Allowable values: Any non-negative real number.

- Components: The portfolio of trades that make up the composite
  trade.  
  Allowable values: These trades should be valid xmls that could
  otherwise be entered into the portfolio, with the exception that they
  can have empty ids.

- PortfolioBasket \[Optional\]: Indicate if the Component represent a
  portfolio basket.  
  Allowable values: Boolean true or false.

- BasketName \[Optional\]: The portfolio Id.  
  Allowable values: Any string. Note that if PortfolioBasket is True
  then there must be a BasketName. We look up the Basket within the
  reference data.

- IndexQuantity \[Optional\]: Number of shares of the index.
