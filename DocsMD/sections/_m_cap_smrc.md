# Standardized Market Risk Capital (SMRC)

Calculating market risk capital requirements can be performed using the
*Standardized Market Risk Capital (SMRC)* method. This method is defined
by the regulator and based on the formula $$\begin{aligned}
    \operatorname{SMRC} = \operatorname{Notional} \times \operatorname{RiskWeight}
    \label{EqDefSMRC}
\end{aligned}$$ for every trade in scope.

SMRC is currently supported in ORE for the following trade types
(unsupported types are ignored in calculations):

- *Bond*

- *ForwardBond*

- *BondOption*

- *CommodityForward*

- *CommodityOption*

- *CommoditySwap*

- *EquityOption*

- *EquityPosition*

- *EquityOptionPosition*

- *FXForward*

- *FXOption*

- *TotalReturnSwap*

- *ConvertibleBond*

- *ForwardRateAgreement*

- *CapFloor*

- *Swap*

- *Swaption*

## Risk Weights

The risk weight depends on the type and the currencies involved in the
trade. All trades supported in ORE and the corresponding risk weights
are shown in Table
<a href="#smrc_risk_weights" data-reference-type="ref"
data-reference="smrc_risk_weights">1</a>. The distinction between
*major* and *minor* currencies is given by the following list:

- `major`: USD, CAD, EUR, GBP, JPY, CHF

- `minor`: Any currency that is not major.

For trade types, where multiple currencies are involved, such as
FxForward, the trade currencies are only classified as `major` if all
currencies involved are major, and minor otherwise.

Trades which are based upon Swaps or Bonds depends upon the time until
maturity of the underlying asset. As such trades with shorter time until
maturity have smaller associated risk weights. Furthermore, in the case
of trades dependent upon bonds, the rates are different for those which
are based on US Government bonds.

<div id="smrc_risk_weights">

| Trade Type           | Currencies |    Underlying    | Maturity Time (Years) | Risk Weight |
|:---------------------|:----------:|:----------------:|:---------------------:|:-----------:|
| FxForward            |   major    |        \-        |          \-           |     6%      |
| FxForward            |   minor    |        \-        |          \-           |     20%     |
| FxOption             |   major    |        \-        |          \-           |     6%      |
| FxOption             |   minor    |        \-        |          \-           |     20%     |
| CommodityForward     |    all     |        \-        |          \-           |     20%     |
| CommoditySwap        |    all     |        \-        |          \-           |     20%     |
| CommodityOption      |    all     |        \-        |          \-           |     20%     |
| EquityPosition       |    all     |       all        |          \-           |     25%     |
| EquityOption         |    all     |       all        |          \-           |     25%     |
| EquityOptionPosition |    all     |       all        |          \-           |     25%     |
|                      |    all     |       all        |       $< 0.25$        |     0%      |
|                      |    all     |       all        |        $< 0.5$        |    0.5%     |
|                      |    all     |       all        |       $< 0.75$        |    0.75%    |
|                      |    all     |       all        |         $< 1$         |     1%      |
| Swap                 |    all     |       all        |         $< 2$         |    1.5%     |
| ForwardRateAgreement |    all     |       all        |         $< 3$         |     2%      |
| CapFloor             |    all     |       all        |         $< 5$         |     3%      |
| Swaption             |    all     |       all        |        $< 10$         |     4%      |
|                      |    all     |       all        |        $< 15$         |    4.5%     |
|                      |    all     |       all        |        $< 20$         |     5%      |
|                      |    all     |       all        |        $< 25$         |    5.5%     |
|                      |    all     |       all        |         $>25$         |     6%      |
| ConvertibleBond      |    all     |       all        |          \-           |     15%     |
|                      |    all     | U.S. Govt. Bonds |         $<5$          |    1.5%     |
|                      |    all     | U.S. Govt. Bonds |         $<10$         |    2.5%     |
|                      |    all     | U.S. Govt. Bonds |         $<15$         |    2.75%    |
|                      |    all     | U.S. Govt. Bonds |         $>15$         |     3%      |
|                      |    all     |   Other Bonds    |         $<1$          |     2%      |
| Bond                 |    all     |   Other Bonds    |         $<2$          |     3%      |
| ForwardBond          |    all     |   Other Bonds    |         $<3$          |     5%      |
| BondOption           |    all     |   Other Bonds    |         $<5$          |     6%      |
|                      |    all     |   Other Bonds    |         $<10$         |     7%      |
|                      |    all     |   Other Bonds    |         $<15$         |    7.5%     |
|                      |    all     |   Other Bonds    |         $<20$         |     8%      |
|                      |    all     |   Other Bonds    |         $<25$         |    8.5%     |
|                      |    all     |   Other Bonds    |         $>25$         |     9%      |

Risk Weights

</div>

## Notional

The calculation of the notional of a trade can be involved as it depends
on the trade type and the choice of the pricing engine. We refer to the
documentation of those for technical details. For the trade types in
listed in Table <a href="#smrc_risk_weights" data-reference-type="ref"
data-reference="smrc_risk_weights">1</a>, the high-level methodology is
as follows:

FxForward  
The FxForward trade type has a `BoughtAmount` and a `SoldAmount` in a
`BoughtCurrency` and a `SoldCurrency`. The notional is calculated by
converting both amounts into `BaseCcy` using the FX spot rate and then
choosing the bigger of the two, i.e. $$\begin{aligned}
        \operatorname{Notional} = \max( \operatorname{FX}_{\text{base,bought}} \cdot \operatorname{BoughtAmount}, \operatorname{FX}_{\text{base,sold}} \cdot \operatorname{SoldAmount})
    
\end{aligned}$$

FxOption  
The methodology is the same as for FxForward.

CommodityForward  
The CommodityForward trade type has a `Quantity` field and a `Strike`
field. The notional is calculated as $$\begin{aligned}
        \operatorname{Notional} = \operatorname{Strike} \cdot \operatorname{Quantity}.
    
\end{aligned}$$

CommoditySwap  
The `CommoditySwap` trade type contains a collection of legs. Each leg
results in a sequence of flow amount between inception and maturity. The
commodity swap notional is the sum of the (signed) notionals of all of
its CommodityFloating legs. The notional of a CommodityFloating leg is
then calculated by taking the earliest future flow amount of that leg.
For variable-quantity swaps, we take the average quantity (taking into
account spreads and gearing), while assuming the price of the earliest
flow.

CommodityOption  
For the `CommodityOption` trade type the notional is determined by the
agreed `Strike` price times the corresponding `Quantity` value, both of
which are provided in the trade data.

EquityPosition  
The `EquityPosition` trade type consists of an underlying asset (or
basket of assets) with associated asset weight/s. The notional of the
trade is given by the additional field `smrc_notional`. For each asset
in the trade,
$\text{SignedNotional} = \text{smrc\_notional} * {weight}$.

EquityOption  
In the case of `EquityOption` trades the notional is determined by the
agreed `Strike` price times the corresponding `Quantity` value, both of
which are provided in the trade data.

EquityOptionPosition  
The methodology is the same as for `EquityOption`.

ConvertibleBond  
The `ConvertibleBond` trade type has a notional field which may have an
amortising structure. In this case the first of these notional values
which occur after the provided `asof` date is used.

Bond  
The methodology is the same as for `ConvertibleBond`.

ForwardBond  
The methodology is the same as for `ConvertibleBond`.

BondOption  
The BondOption trade type contains information regarding the underlying
option data including the `Strike` and `Quantity` values which are
multiplied by one another to give the notional value.

Swap  
The `Swap` trade type has a `Notional` field for each leg present in the
trade, here the value obtained from the first leg which appears in the
input portfolio is used to represent the trade notional.

Swaption  
The `Swaption` trade type contains a collection of legs. Each leg
results in a sequence of flow amount between inception and maturity. The
notional is defined by taking the maximum over all legs and all current
flow amounts after the `asof` date of the calculation.

ForwardRateAgreement  
The `ForwardRateAgreement` trade type has a `Notional` field which is
used in determining the value.

CapFloor  
The methodology is the same as for `Swap`.

## Aggregation & Offsetting of Positions

For each trade $i$ in the portfolio, the SMRC charge
$\operatorname{SMRC}_i$ is calculated using
<a href="#EqDefSMRC" data-reference-type="eqref"
data-reference="EqDefSMRC">[EqDefSMRC]</a> and stored in a detailed
report. The easiest aggregation of all the contributions of the trades
into a single SMRC capital charge number is simply: $$\begin{aligned}
    \operatorname{SMRC} := \sum_{i}{\operatorname{SMRC}_i}
\end{aligned}$$ Notice that this type of aggregation is very
conservative as this formula does not take into account any offsetting
effects between long and short positions of various trades in the
portfolio.

Thus, we produce a second aggregated report, where offsetting between
long and short positions of the same type of market risk is allowed. The
precise definition of this depends on the trade type. We give a
high-level overview of the methodology for some relevant trade types
here:

FxForward  
An FxForward has a linear payoff, where one currency amount is bought
and another is sold. We therefore think of an FxForward as having two
legs - one that pays and one that receives. We compute the list of all
currencies of all FxForwards in the portfolio and then for each currency
$j$ define a currency bucket $\operatorname{CCY}_j$. In that bucket we
sum up with a positive sign all the `boughtAmount`s of all FxForwards
$i$ with `boughtCurrency` equal to $j$ and the same with the
`soldAmount`s, but with a negative sign, thus calculating the total
effective notional amount in that currency: $$\begin{aligned}
        \operatorname{CCY}_{j,\text{bought}} & := \sum_{i, \operatorname{boughtCurrency}_i=j}{\operatorname{boughtAmount}_i \cdot \operatorname{FX}_{\text{base},\text{bought}_i}}, \\
        \operatorname{CCY}_{j,\text{sold}} & :=\sum_{i, \operatorname{soldCurrency}_i=j}{\operatorname{soldAmount}_i \cdot \operatorname{FX}_{\text{base},\text{sold}_i}}, \\
        \operatorname{CCY}_{j} &:= \operatorname{CCY}_{j,\text{bought}} - \operatorname{CCY}_{j,\text{sold}}.
    
\end{aligned}$$ Finally, we aggregate the results of the currency
buckets by weighing its absolute value with the
$\operatorname{RiskWeight}_j$ of that currency, which is again $6\%$, if
the currency is major and $20\%$ otherwise: $$\begin{aligned}
        \operatorname{SMRC}_{\text{FxForward}} := \sum_{j}{\operatorname{RiskWeight}_j |\operatorname{CCY}_j|}.
    
\end{aligned}$$

FxOption  
An FxOption is not a linear trade and thus it cannot be decomposed as
easily into legs like the FxForward. Therefore, for each FxOption $i$ we
compute the unordered set of the currency pair $$\begin{aligned}
        \{ \operatorname{BoughtCurrency}_i, \operatorname{SoldCurrency}_i \}
    
\end{aligned}$$ and then for each such currency pair
$\operatorname{CCYPair}_j$ we sum up the signed notionals of the long
and short put and call options $i$ with that currency pair:
$$\begin{aligned}
        \operatorname{CCYPair}_{j} & := \sum_{i,\text{CCYPair}_i=j,}{\operatorname{SignedNotional}_i},
    
\end{aligned}$$ where the $\operatorname{SignedNotional}_i$ of an option
$i$ has the same absolute value as the notional and the sign is given by
Table <a href="#fx_option_notional_signs" data-reference-type="ref"
data-reference="fx_option_notional_signs">2</a>. Finally, we compute the
risk weight $\operatorname{RiskWeight}_j$ of each currency pair $j$,
which is again $6\%$ if both currencies are major and $20\%$ otherwise.
We then aggregate analogously $$\begin{aligned}
        \operatorname{SMRC}_{\text{FxOption}} := \sum_{j}{\operatorname{RiskWeight}_j |\operatorname{CCYPair}_{j}| }.
    
\end{aligned}$$

CommodityForward, CommoditySwap, CommodityOption  
These trades each have an underlying commodity,
$\operatorname{Commodity_i}$, which has an associated notional amount
$\operatorname{SignedNotional_i}$. For each unique commodity,
$\text{Commodity}_j$, we consider the portfolio netted total represented
by $\operatorname{CommodityTotal}_j$ obtained by summing the signed
notionals arising from trades associated with this commodity:
$$\begin{aligned}
        \operatorname{CommodityTotal}_{j} & := \sum_{i,\text{Commodity}_i=\text{Commodity}_j,}{\operatorname{SignedNotional}_i},
    
\end{aligned}$$ where the $\operatorname{SignedNotional}_i$ of a trade
$i$ has the same absolute value as the notional with sign given by Table
<a href="#fx_option_notional_signs" data-reference-type="ref"
data-reference="fx_option_notional_signs">2</a>. Finally, we compute the
risk weight $\operatorname{RiskWeight}_j$ of each commodity $j$, which
is $20\%$. We then aggregate analogously to obtain $$\begin{aligned}
        \operatorname{SMRC}_{\text{Commodity}} := \sum_{j}{\operatorname{RiskWeight}_j |\operatorname{CommodityTotal}_{j}| }.
    
\end{aligned}$$

EquityOption, EquityOptionPosition  
These trades depend upon an underlying equity,
$\operatorname{Equity_i}$, which has an associated notional amount
$\operatorname{SignedNotional_i}$. For each unique equity
$\text{Equity}_j$ we consider the portfolio netted total represented by
$\operatorname{EquityTotal}_j$ obtained by summing up the signed
notionals arising from trades associated with this equity given by:
$$\begin{aligned}
        \operatorname{EquityTotal}_{j} & := \sum_{i,\text{Equity}_i=\text{Equity}_j,}{\operatorname{SignedNotional}_i},
    
\end{aligned}$$ where the $\operatorname{SignedNotional}_i$ of a trade
$i$ has the same absolute value as the notional and the sign is given by
Table <a href="#option_notional_signs" data-reference-type="ref"
data-reference="option_notional_signs">3</a> in the case of option based
trades and simply positive (negative) for long (short) position trades.
Finally, we compute the risk weight $\operatorname{RiskWeight}_j$ of
each equity $j$, which is $25\%$. We then aggregate analogously
$$\begin{aligned}
        \operatorname{SMRC}_{\text{Equity}} := \sum_{j}{\operatorname{RiskWeight}_j |\operatorname{EquityTotal}_{j}| }.
    
\end{aligned}$$

Swap, ForwardRateAgreement, CapFloor, Swaption  
In the case of these trades we consider only floating legs, and consider
the time until maturity of the contract. As such for each trade $i$ we
consider the set of swap-maturity pairs
$\{UnderlyingIndex_i, MaturityDate_i\}$ where the maturity times are
considered on a discrete basis such that all trades with maturity within
a certain window are grouped together, these windows are given in Table
<a href="#smrc_risk_weights" data-reference-type="ref"
data-reference="smrc_risk_weights">1</a>, e.g., all swaps for a certain
index maturing in less than 0.25 years are grouped. Consequently for
each swap-maturity pair $\operatorname{SwapMaturity}_j$ we sum up the
signed notionals for each trade, which are determined by Table
<a href="#swaption_notional_signs" data-reference-type="ref"
data-reference="swaption_notional_signs">4</a> in the case of swaption
based trades and simply positive (negative) for long (short) position
trades, to obtain the total for said pair given by $$\begin{aligned}
        \operatorname{SwapMaturityTotal}_{j} := \sum_{i, \text{SwapMaturity}_i = \text{SwapMaturity}_j} SignedNotional_i.
    
\end{aligned}$$ Finally for each swap-maturity pair $j$ we compute the
$\operatorname{RiskWeight}_j$ as given by Table
<a href="#smrc_risk_weights" data-reference-type="ref"
data-reference="smrc_risk_weights">1</a> and again aggregate across all
trades via $$\begin{aligned}
        \operatorname{SMRC}_{\text{SwapUnderlying}} := \sum_{j}{\operatorname{RiskWeight}_j |\operatorname{SwapMaturityTotal}_j|}.
    
\end{aligned}$$

ConvertibleBond  
Trades based upon convertible bonds have an underlying asset,
$\operatorname{BondUnderlying}_i$ which determines the returns of the
trade. Each corresponding notional is multiplied by the
$\operatorname{RiskWeight}_j$ which is always given by $15\%$ in this
case and then aggregated analogously as $$\begin{aligned}
        \operatorname{SMRC}_{\text{BondUnderlying}} := \sum_{j}{\operatorname{RiskWeight}_j |\operatorname{BondUnderlying}_j| }.
    
\end{aligned}$$

Bond, ForwardBond, BondOption  
These trades are dependent upon an underlying bond asset, which itself
has a given maturity date. As such for each trade $i$ we consider the
set of bond-maturity pairs $\{UnderlyingBond_i, MaturityDate_i\}$ where
the maturity times are considered on a discrete basis such that all
trades with maturity within a certain window are grouped together, these
windows are given in Table
<a href="#smrc_risk_weights" data-reference-type="ref"
data-reference="smrc_risk_weights">1</a>, e.g., all unique U.S.
government bonds maturing in less than 5 years are grouped. Consequently
for each bond-maturity pair $\operatorname{BondMaturity}_j$ we sum up
the signed notionals for each trade, which are determined by Table
<a href="#option_notional_signs" data-reference-type="ref"
data-reference="option_notional_signs">3</a> in the case of option based
trades and simply positive (negative) for long (short) position trades,
to obtain the total for said pair given by $$\begin{aligned}
        \operatorname{BondMaturityTotal}_{j} := \sum_{i, \text{BondMaturity}_i = \text{BondMaturity}_j} SignedNotional_i.
    
\end{aligned}$$ The last distinction made is that those bonds issued by
the U. S. Government are treated differently from all others as
demonstrated in Table
<a href="#smrc_risk_weights" data-reference-type="ref"
data-reference="smrc_risk_weights">1</a>. Finally for each bond maturity
pair $j$ we compute the $\operatorname{RiskWeight}_j$ as given by Table
<a href="#smrc_risk_weights" data-reference-type="ref"
data-reference="smrc_risk_weights">1</a> and again aggregate across all
trades via $$\begin{aligned}
        \operatorname{SMRC}_{\text{BondUnderlying}} := \sum_{j}{\operatorname{RiskWeight}_j |\operatorname{BondMaturityTotal}_j|}.
    
\end{aligned}$$

<div id="fx_option_notional_signs">

| BoughtCcy | SoldCcy | Type | LongShort | Sign |
|:---------:|:-------:|:----:|:---------:|:----:|
|     X     |    Y    | call |   long    |  \+  |
|     X     |    Y    | call |   short   |  \-  |
|     Y     |    X    | call |   long    |  \-  |
|     Y     |    X    | call |   short   |  \+  |
|     X     |    Y    | put  |   long    |  \-  |
|     X     |    Y    | put  |   short   |  \+  |
|     Y     |    X    | put  |   long    |  \+  |
|     Y     |    X    | put  |   short   |  \-  |

FxOption Notional Signs

</div>

<div id="option_notional_signs">

| Type | LongShort | Sign |
|:----:|:---------:|:----:|
| call |   long    |  \+  |
| call |   short   |  \-  |
| put  |   long    |  \-  |
| put  |   short   |  \+  |

Option Notional Signs

</div>

<div id="swaption_notional_signs">

| PayReceive | LongShort | Sign |
|:----------:|:---------:|:----:|
|    pay     |   long    |  \+  |
|    pay     |   short   |  \-  |
|  receive   |   long    |  \-  |
|  receive   |   short   |  \+  |

Swaption Notional Signs

</div>
