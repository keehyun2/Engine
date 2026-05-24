### Formula Based Leg Data

The formula based leg data allows to use complex formulas to describe
coupon payoffs. Its `LegType` is ` FormulaBased`, and it has the data
section `FormulaBasedLegData`. It supports IBOR and CMS based payoffs
with quanto and digital features. The following examples shows the
definition of a coupon paying a capped / floored cross currency EUR-GBP
CMS Spread contingent on a USD CMS barrier.

The `Index` field supports operations of the following kind:

- indices like IBOR and CMS indices, and constants as factors, spreads
  and/or cap/floor values;

- basic operations: $+$, $-$, $\cdot$, $/$;

- operators gtZero() (greater than zero) and geqZero() (greater than or
  equal zero) yielding $1$ if the argument is $>0$ (resp. $\geq 0$) and
  zero otherwise

- functions: abs(), exp(), log(), min(), max(), pow()

In listing <a href="#lst:FBLegdata" data-reference-type="ref"
data-reference="lst:FBLegdata">[lst:FBLegdata]</a>, we present the
`FormulaBasedLegData`.

<div class="listing">

``` xml
<LegData>
  <LegType>FormulaBased</LegType>
  <Payer>true</Payer>
  <Currency>EUR</Currency>
   ...
  <FormulaBasedLegData>
    <Index>gtZero({USD-CMS-5Y}-0.03)*
              max(min(9.0*({EUR-CMS-10Y}-{GBP-CMS-2Y})+0.02,0.08),0.0)</Index>
    <IsInArrears>false</IsInArrears>
    <FixingDays>2</FixingDays>
  </FormulaBasedLegData>
   ...
</LegData>
```

</div>
