### Cashflow Leg Data

A Cashflow leg is used to represent one or more custom cashflows, with
specified dates and amounts. Listing
<a href="#lst:cashflowlegdata" data-reference-type="ref"
data-reference="lst:cashflowlegdata">[lst:cashflowlegdata]</a> shows an
example for a leg of type Cashflow.

<div class="listing">

``` xml
      <LegData>
        <Payer>false</Payer>
        <LegType>Cashflow</LegType>
        <Currency>EUR</Currency>
        <PaymentConvention>ModifiedFollowing</PaymentConvention>
        <CashflowData>
          <Cashflow>
            <Amount date="2024-12-15">105000</Amount>
          </Cashflow>
        </CashflowData>
      </LegData>
```

</div>

The CashflowData block contains the following elements:

- Cashflow: This node contains child elements of type `Amount`, each
  representing a cashflow. Each child element should include the date of
  the cashflow using the form:

  ``` xml
  <Amount date="YYYY-MM-DD">[amount]</Amount>
  ```

  Allowable values: Each child element can take any real number.
