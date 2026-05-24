# Capital

This chapter describes the various methods to calculate capital
requirements in ORE.

## Standardized Market Risk Capital (SMRC)

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

### Risk Weights

The risk weight depends on the type and the currencies involved in the
trade. All trades supported in ORE and the corresponding risk weights
are shown in Table
<a href="#smrc_risk_weights" data-reference-type="ref"
data-reference="smrc_risk_weights">1.1</a>. The distinction between
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

### Notional

The calculation of the notional of a trade can be involved as it depends
on the trade type and the choice of the pricing engine. We refer to the
documentation of those for technical details. For the trade types in
listed in Table <a href="#smrc_risk_weights" data-reference-type="ref"
data-reference="smrc_risk_weights">1.1</a>, the high-level methodology
is as follows:

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

### Aggregation & Offsetting of Positions

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
data-reference="fx_option_notional_signs">1.2</a>. Finally, we compute
the risk weight $\operatorname{RiskWeight}_j$ of each currency pair $j$,
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
data-reference="fx_option_notional_signs">1.2</a>. Finally, we compute
the risk weight $\operatorname{RiskWeight}_j$ of each commodity $j$,
which is $20\%$. We then aggregate analogously to obtain
$$\begin{aligned}
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
data-reference="option_notional_signs">1.3</a> in the case of option
based trades and simply positive (negative) for long (short) position
trades. Finally, we compute the risk weight
$\operatorname{RiskWeight}_j$ of each equity $j$, which is $25\%$. We
then aggregate analogously $$\begin{aligned}
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
data-reference="smrc_risk_weights">1.1</a>, e.g., all swaps for a
certain index maturing in less than 0.25 years are grouped. Consequently
for each swap-maturity pair $\operatorname{SwapMaturity}_j$ we sum up
the signed notionals for each trade, which are determined by Table
<a href="#swaption_notional_signs" data-reference-type="ref"
data-reference="swaption_notional_signs">1.4</a> in the case of swaption
based trades and simply positive (negative) for long (short) position
trades, to obtain the total for said pair given by $$\begin{aligned}
		\operatorname{SwapMaturityTotal}_{j} := \sum_{i, \text{SwapMaturity}_i = \text{SwapMaturity}_j} SignedNotional_i.
	
\end{aligned}$$ Finally for each swap-maturity pair $j$ we compute the
$\operatorname{RiskWeight}_j$ as given by Table
<a href="#smrc_risk_weights" data-reference-type="ref"
data-reference="smrc_risk_weights">1.1</a> and again aggregate across
all trades via $$\begin{aligned}
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
data-reference="smrc_risk_weights">1.1</a>, e.g., all unique U.S.
government bonds maturing in less than 5 years are grouped. Consequently
for each bond-maturity pair $\operatorname{BondMaturity}_j$ we sum up
the signed notionals for each trade, which are determined by Table
<a href="#option_notional_signs" data-reference-type="ref"
data-reference="option_notional_signs">1.3</a> in the case of option
based trades and simply positive (negative) for long (short) position
trades, to obtain the total for said pair given by $$\begin{aligned}
		\operatorname{BondMaturityTotal}_{j} := \sum_{i, \text{BondMaturity}_i = \text{BondMaturity}_j} SignedNotional_i.
	
\end{aligned}$$ The last distinction made is that those bonds issued by
the U. S. Government are treated differently from all others as
demonstrated in Table
<a href="#smrc_risk_weights" data-reference-type="ref"
data-reference="smrc_risk_weights">1.1</a>. Finally for each bond
maturity pair $j$ we compute the $\operatorname{RiskWeight}_j$ as given
by Table <a href="#smrc_risk_weights" data-reference-type="ref"
data-reference="smrc_risk_weights">1.1</a> and again aggregate across
all trades via $$\begin{aligned}
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

## Counterparty Credit Risk Capital

Financial institutions either apply a *standardized* or an *advanced*
approach for determining the regulatory capital amounts to be assigned
to their derivative activity. The advanced approach is accessible to
institutions with an internal model method (IMM) for credit risk capital
which is approved by the regulator. This method involves sophisticated
analysis of future exposures by Monte Carlo simulation methods using
real-world measure risk factor evolutions . Institutions without
approved IMM have to apply a standardized approach instead, which is
simplified in that it does not require Monte Carlo exposure simulation
but resorts to formulas suggested by the Basel Commitee for Banking
Supervision and enforced by the respective regulator. These formulas
attempt to conservatively approximate the credit exposures which would
have been obtained by more sophisticated IMM approaches.

The former standardized approach (Current Exposure Method) as published
by the Basel Commitee for Banking Supervision (BCBS) in 2006 is
summarized in section <a href="#sec_cem" data-reference-type="ref"
data-reference="sec_cem">1.2.1</a>. A revised standardized approach for
counterparty credit risk from derivative acitvity (SA-CCR) as published
in 2014 is in effect from beginning of 2017.

### Current Exposure Method (CEM)

The key quantity in the current standardized approach (or current
exposure method, CEM) is the exposure at default (EaD) or *credit
equivalent amount* which consists of two additive terms, current
replacement cost and potential future exposure add-on,
$$\text{EaD} = \text{RC} + \text{Notional} \times \text{NettingFactor} \times \text{AddOn}.$$

The replacement cost RC is simply given by the current exposure which is
the current positive value of the netting set after subtracting
collateral (C) $$\text{RC} = \max(0, \text{PV} - \text{C}).$$
Replacement cost is aggregated over all derivative contracts and netting
sets.

The second term is supposed to approximately reflect the potential
future exposure over the remaining life of the contract. It depends on
the (fairly rough) product type classification and on time to maturity
in three bands as shown in table
<a href="#tab_addon" data-reference-type="ref"
data-reference="tab_addon">1.5</a> which is in use in this form since
1988.

<div class="center">

<div id="tab_addon">

|               |          |      |        |          |             |
|:--------------|:--------:|:----:|:------:|:--------:|:-----------:|
| Residual      | Interest |  FX  | Equity | Precious |    Other    |
| Maturity      |  Rates   | Gold |        |  Metals  | Commodities |
| $\leq$ 1 Year |   0.0%   |  1%  |   6%   |    7%    |     10%     |
| 1-5 Years     |   0.5%   |  5%  |   8%   |    7%    |     12%     |
| $>$ 5 Years   |   1.5%   | 7.5% |  10%   |    8%    |     15%     |

Add-on factor by product and time to maturity. Single currency interest
rate swaps are assigned a zero add-on, i.e. judged on replacement cost
basis only, if their maturity is less than one year. Forwards, swaps,
purchased options and derivative contracts not covered in the columns
above shall be treated as “Other Commodities”. Credit derivatives (total
return swaps and credit default swaps) are treated separately with 5%
and 10% add-ons depending on whether the reference obigation is regarded
as “qualifying” (public sector entities (!), rated investment grade or
approved by the regulator). N-th to default basket transactions are
assigned an add-on based on the credit quality of n-th lowest credit
quality in the basket.

</div>

</div>

The netting factor acknowledges netting also in the potential future
exposure estimate of the netting set. If there is no netting as of
today, i.e. net NPV equals gross NPV, the netting factor is equal to 1,
otherwise it can be as low as 0.4. Additional netting benefit results
from using a central clearing counterparty (CCP):
$$\text{NettingFactor} = \left\{\begin{array}{ll}
\displaystyle 0.4 + 0.6 \times \frac{\max\left(\sum_i PV_i, 0\right)}{\sum_i
  \max(PV_i,0)} & \text{bilateral netting}\\ \\
\displaystyle 0.15 + 0.85 \times \frac{\max\left(\sum_i PV_i, 0\right)}{\sum_i
  \max(PV_i,0)} & \text{central clearing}
\end{array}
\right.$$

Finally, the notional amounts that enter into the potential future
exposure term are understood as effective notional amounts which
e.g. take into account leverage which may be expressed through factors
in structured product payoff formulas.

Note that CEM was valid until end of 2016.

### Standardized Approach for Counterparty Credit Risk (SA-CCR)

With its 2014 publication , the Basel Committee for Banking Supervision
has revised the standardized approach. The new method takes
collateralization into account in a more detailed way than before which
has the potential to reduce the credit equivalent amounts. On the other
hand, the new method attempts to mimic a more conservative potential
exposure, the *effective expected positive exposure* (EEPE) which tends
to increase the resulting credit equivalent amounts. In summary, only a
detailed impact analysis for specific portfolios will be able to tell
whether the overall impact of the new method results in an increase or
in a decrease of derivative capital charges. In the following we
summarize the ingredients of the new methodology.

SA-CCR in ORE currently supports the following trade types per asset
class (unsupported types are ignored in calculations with a structured
warning raised):

- Foreign Exchange: *Swap* (cross currency), *CrossCurrencySwap*,
  *FxBarrierOption*, *FxForward*, *FxOption*, *FxTouchOption*

- Commodity: *CommodityForward*, *CommoditySwap*

- Interest Rate: *Swap* (Vanilla IR, basis and CPI swaps not yet
  supported), *Swaption* (European)

- Equity: *EquityOption*

Note for swap-type products that two legs are required.

#### Exposure at Default (EAD)

The EAD is still composed of a replacement cost and a potential future
exposure add-on term but scaled up by a factor of $1.4$ which is
motivated by the committee’s attempt to mimic a different (higher)
exposure measure: $$\text{EAD} = 1.4 \times (\text{RC} + \text{PFE})$$
On the other hand, the replacement cost per netting set takes into
account more details of the collateral agreement:
$$\text{RC} = \max(\text{PV} - \text{C};\; \text{TH} + \text{MTA} - \text{NICA};\; 0)$$
where

- PV is the netting set mark-to-market value,

- TH is the CSA’s threshold amount,

- MTA the CSA’s minimum transfer amount,

- NICA is the independent collateral amount (i.e. any received
  independent amount plus initial margin amount),

- C is the current collateral (i.e. variation margin plus NICA).

So even if the posted collateral C matches the PV so that the first term
on the right-hand side vanishes, the various CSA slippage terms can
cause a positive replacement cost contribution here. This supposedly
imitates CVA behaviour.

For unmargined netting sets,
$$\text{RC} = \max(\text{PV} - \text{C};\; 0).$$

#### Potential Future Exposure (PFE)

The PFE term is primarily driven by the aggregate add-on factor which is
significantly more complex than in the current standardized approach’s
definition: $$\text{PFE} = \text{Multiplier} \times \text{AddOn}.$$ The
PFE is obtained by scaling down the AddOn using a multiplier which
recognises and rewards excess collateral: $$\begin{aligned}
\text{Multiplier} &= \min\left(1; 0.05 + 0.95 \times \exp\left(\frac{\text{PV}-\text{C}}{1.9
  \times \text{AddOn}} \right)\right)  \\
&=1 \quad \text{if $PV \geq C$}, \\
&<1 \quad \text{if $PV < C$ (excess collateral).} 
\end{aligned}$$ The aggregate/netting set add-on is a composite

$$\text{AddOn} = \sum_a \text{AddOn}^{(a)}$$ where the sum is taken over
the various asset classes in the netting set, and AddOn$^{(a)}$ denotes
the add-on factor for asset class $a$. The add-on factor within each
asset class $a$

$$\label{sa-ccr-addon}
\text{AddOn}^{(a)} = \sum_i \text{AddOn}^{(a)}_i$$ is a sum of the
hedging set add-ons (where AddOn$^{(a)}_i$ is the add-on for hedging set
$i$ in asset class $a$). The list of possible hedging sets for each
asset class is given in Table
<a href="#tab:hedgingset" data-reference-type="ref"
data-reference="tab:hedgingset">1.6</a>. The asset class assignment is
based on a trade’s “primary risk driver”, but split assignment may be
required for complex trades.

<div class="center">

<div id="tab:hedgingset">

| Asset Class      | Hedging Set                               | Hedging Subset                         |
|:-----------------|:------------------------------------------|:---------------------------------------|
| Interest Rate    | Currency                                  | Maturity buckets (*1Y*, *1Y-5Y*, *5Y*) |
| Foreign Exchange | Currency pair                             | \-                                     |
| Equity           | \-                                        | Qualifier                              |
| Credit           | \-                                        | Qualifier                              |
| Commodity        | *Energy*, *Metal*, *Agriculture*, *Other* | Qualifier/Group                        |

Hedging set/subset construction by asset class – See paragraph 161.

</div>

</div>

Note:

- For Interest Rate, a trade is assigned to a hedging subset based on
  the end date of the period referenced by the underlying $E_i$.[^1]

- For Commodity, similar underlyings can be grouped under the same
  hedging subset.[^2] Currently, similar underlyings will be grouped
  together under the following categories: *Coal*, *Crude oil*, *Light
  Ends*, *Middle Distillates*, *Heavy Distillates*, *Natural Gas*,
  *Power*.

- For Equity and Credit, a single hedging set is used for the entire
  asset class. The hedging subset is then given by the underlying
  entity, where partial offsetting is applied across different entities,
  and full offset is applied within each entity.

- Within each asset class, a separate hedging set is reserved for basis
  trades and volatility/variance trades. Basis hedging sets are given in
  the format `QUALIFIER1/QUALIFIER2`. Volatility/variance trades are not
  yet supported.

As mentioned above, the potential future exposure term aims to mimic a
particularly conservative exposure measure. This choice is built into
the definition of the supervisory factors, quoting : “A factor or
factors specific to each asset class is used to **convert the effective
notional amount into Effective EPE** based on the measured volatility of
the asset class. Each factor has been calibrated to reflect the
Effective EPE of a single at-the-money linear trade of unit notional and
one-year maturity. This includes the estimate of realised volatilities
assumed by supervisors for each underlying asset class.” The supervisory
factors are displayed in Table
<a href="#tab_saccr_vols" data-reference-type="ref"
data-reference="tab_saccr_vols">1.7</a>.

#### Trade-Specific Parameters

Before defining the hedging set add-on, AddOn$^{(a)}_i$
(<a href="#sa-ccr-addon" data-reference-type="ref"
data-reference="sa-ccr-addon">[sa-ccr-addon]</a>), for each asset class
we define the trade-specific parameters that will be used.

The trade specific parameters $\delta_i$, $d_j^{(a)}$ and
$MF_i^{(\text{type})}$ are defined (for trade $j$ and asset class $a$)
as follows:

1.  **$d_j^{(a)}$ (trade-level adjusted notional)**

    - **Foreign Exchange**:

      - For trades where one of the legs is in the base currency: The
        adjusted notional is the foreign leg notional converted to the
        base currency.

      - For trades where both legs are denominated in a currency other
        than the base currency: Both leg notionals are converted to the
        base currency, and the larger of the 2 notionals is used as the
        adjusted notional.

    - **Interest Rate, Credit**: $\text{Notional} \times \text{SD}_j$,
      where SD$_j$ is the supervisory duration, with
      $$\text{SD}_j = \frac{\exp{(-0.05 \cdot S_j)} - \exp{(-0.05 \cdot E_j)}}{0.05},$$
      where

      - $S_j$ is the start date (in years) of the period referenced by
        the underlying,

      - $E_j$ is the end date (in years) of the period referenced by the
        underlying.

    - **Equity, Commodity**:
      $\text{Price per unit} \times \text{No.\ of units}$

    - Note: We index the adjusted notional by the asset class $a$ is
      because complex trades can be assigned to multiple asset classes
      and hence have an adjusted notional in more than one asset class.

2.  **$\MF_j^{(\text{type})}$ (maturity factor)**

    - For uncollateralized positions, this is computed from the time to
      maturity $M_j$ (in years) of the trade:
      $MF_j^{(\text{unmargined})} = \sqrt{\min(\max(M_j, 2/52),1)}$.
      Note the floor of 10 business days on $M_j$.

    - For collateralized positions, this is computed from the margin
      period of risk MPR (in years) used:
      $MF_j^{(\text{margined})} = 1.5\cdot\sqrt{\MPR}$

3.  **$\delta_j$ (delta adjustment for direction and non-linearity)**

    - Options: In this case $\delta_j$ is an option delta (derived from
      the Black76 formula),
      $$\delta_j = \omega \cdot \Phi\!\left(\phi \cdot \frac{\ln(P_j/K_j) +
          0.5\,\sigma_j^2\,T_j}{\sigma_j\,\sqrt{T_j}} \right)\!,$$ where

      - $\Phi(\cdot)$ is the cumulative normal distribution function,

      - $P_j$ is the price of the underlying (typically the forward
        price),

      - $K_j$ is the strike price of the option,

      - $T_j$ is the latest option exercise date,

      - $\omega$ is $+1$ for long calls and short puts, $-1$ for short
        calls and long puts,

      - $\phi$ is $+1$ for calls, $-1$ for puts,

      - $\sigma_j$ is the supervisory option volatility as defined in
        Table <a href="#tab_saccr_vols" data-reference-type="ref"
        data-reference="tab_saccr_vols">1.7</a>.

    - CDO tranches: $\pm \frac{15}{(1+14\,A)(1+14\,D)}$ for purchased
      (sold) protection, where A and D denote the attachment and
      detachment point of the tranche, respectively

    - Others: $\pm 1$ depending on whether long or short in the primary
      risk factor

#### Hedging Set/Subset Add-On

We continue with sketching the hedging set level add-on from
(<a href="#sa-ccr-addon" data-reference-type="ref"
data-reference="sa-ccr-addon">[sa-ccr-addon]</a>).

#### Interest Rate

Within currency hedging set $i$, each trade is assigned to 1 of 3
maturity buckets based on the end date of the period referenced by the
trade’s underlying:

- $D_1$: $<$ 1 year

- $D_2$: 1-5 years

- $D_3$: $>$ 5 years

The effective notional $D_{i, k}$ for maturity bucket $k$ of currency
hedging set $i$
$$D_{i, k} = \sum_{j=1}^n \delta_j \times d_j^{(\text{IR})} \times \text{MF}_j^{(\text{type})}.$$
is calculated as the sum of all trades $j$ in each maturity bucket.

Partial offsetting is applied when aggregating the contribution across
the 3 maturity buckets, giving the effective notional for hedging set
$i$:
$$\text{EffectiveNotional}_i^{(\text{IR})} = \sqrt{D_{i,1}^2 + D_{i,2}^2 + D_{i,3}^2 + 1.4 \cdot (D_{i,1}\cdot D_{i,2} + D_{i,2}\cdot D_{i,3}) 
+ 0.6 \cdot D_{i,1} \cdot D_{i,3}}$$ Each contribution is a sum over all
trades in each hedging set $i$ and maturity bucket: One may choose not
to apply any offset across maturity buckets, in which case
$$\text{EffectiveNotional}_i^{(\text{IR})} = |D_{i,1}| + |D_{i,2}| + |D_{i,3}|.$$
Finally, we multiply the effective notional by the supervisory factor
(see Table <a href="#tab_saccr_vols" data-reference-type="ref"
data-reference="tab_saccr_vols">1.7</a>) to obtain the add-on:
$$\text{AddOn}_i^{(\text{IR})} = SF_i^{(\text{IR})} \times \text{EffectiveNotional}_i^{(\text{IR})}$$

#### Foreign Exchange

Unlike for IR instruments, FX does not use hedging subsets (i.e. the
notional amounts are maturity independent) so trades within the same
currency pair hedging set are allowed to fully offset each other. The
effective notional calculation is similar to that of IR:
$$\text{EffectiveNotional}_i^{(\text{FX})} = \sum_{j=1}^n \delta_j \times d^{(\text{FX})}_j \times MF_j^{(\text{type})}$$
and
$$\text{AddOn}_i^{(\text{FX})} = SF_i^{(\text{FX})} \times \left|\text{EffectiveNotional}_i^{(\text{FX})}\right|$$

#### Credit

All credit instruments are assigned to a single hedging set, and hedging
subsets are defined by each underlying entity/name. Trades that
reference the same entity are fully offset, giving the entity-level
effective notional amount (for hedging subset $k$):
$$\text{EffectiveNotional}_k^{(\text{CR})} = \sum_{j=1}^n \delta_j \times d_j^{(\text{CR})} \times MF_j^{(\text{type})}$$
Multiplying by the supervisory factor, we get the entity-level add-on
(for hedging subset $k$):
$$\text{AddOn}_k^{(\text{CR})} = SF_k^{(\text{CR})} \times \text{EffectiveNotional}_k^{(\text{CR})}$$
For single-name entities, the supervisory factor is determined by the
credit rating, while for index entities this is determined based on
whether the index is investment grade or speculative grade (see Table
<a href="#tab_saccr_vols" data-reference-type="ref"
data-reference="tab_saccr_vols">1.7</a>).

Finally, the asset class add-on is calculated by applying a partial
offset across the entity-level add-ons:
$${\text{AddOn}^{(\text{CR})} = \sqrt{ \underbrace{\left(\sum_k \rho_k^{(\text{CR})} \cdot \text{AddOn}_k^{(\text{CR})} \right)^2}_{\mbox{systematic component}} + \underbrace{\sum_k \left( 1 - \left( \rho_k^{(\text{CR})} \right)^2 \right) \cdot \left(\text{AddOn}_k^{(\text{CR})}\right)^2}_{\mbox{idiosyncratic component}} }}$$

#### Equity

The hedging set/subset construction for equities is similar to that for
credit, so the same calculation applies for effective notional where a
hedging subset is formed for each equity underlying:
$$\text{EffectiveNotional}_k^{(\text{EQ})} = \sum_{j=1}^n \delta_j \times d_j^{(\text{EQ})} \times MF_j^{(\text{type})}$$
Likewise, for the entity-level add-on:
$$\text{AddOn}_k^{(\text{EQ})} = SF_k^{(\text{EQ})} \times \text{EffectiveNotional}_k^{(\text{EQ})}$$
There are only 2 supervisory factors for equities, based on whether the
underlying is a single name or an index (see Table
<a href="#tab_saccr_vols" data-reference-type="ref"
data-reference="tab_saccr_vols">1.7</a>).

Finally, we apply partial offset once again across the entity-level
add-ons to get the asset class add-on:
$${\text{AddOn}^{(\text{EQ})} = \sqrt{ \underbrace{\left(\sum_k \rho_k^{(\text{EQ})} \cdot \text{AddOn}_k^{(\text{EQ})} \right)^2}_{\mbox{systematic component}} + \underbrace{\sum_k \left( 1 - \left( \rho_k^{(\text{EQ})} \right)^2 \right) \cdot \left(\text{AddOn}_k^{(\text{EQ})}\right)^2}_{\mbox{idiosyncratic component}} }}$$

#### Commodity

The Commodity asset class uses 4 hedging sets (and no offsetting is
allowed between hedging sets in any asset class), the Commodity add-on
is more specifically defined as:
$$\text{AddOn}^{(\text{COM})} = \text{AddOn}_\text{Energy}^{(\text{COM})} + \text{AddOn}_\text{Metal}^{(\text{COM})} + \text{AddOn}_\text{Agriculture}^{(\text{COM})} + \text{AddOn}_\text{Other}^{(\text{COM})}$$
For Commodity, the calculation of hedging set level add-ons is the same
as the calculation of asset class add-ons for Equity and Credit. As
before, we start with calculating the effective notional at the entity
level (i.e. hedging subset $k$) under hedging set $i$, applying full
offset across trade contributions:
$$\text{EffectiveNotional}_{i,k}^{(\text{COM})} = \sum_{j=1}^n \delta_j \times d_j^{(\text{COM})} \times MF_j^{(\text{type})}$$
Then we calculate the add-on for hedging subset $k$:
$$\text{AddOn}_{i,k}^{(\text{COM})} = SF_i^{(\text{COM})} \times \text{EffectiveNotional}_{i,k}^{(\text{COM})}$$
Finally, we get the add-on for hedging set $i$ (note the correlation
terms are outside the sums as they apply to the hedging set, not to the
hedging subset):
$${\text{AddOn}_i^{(\text{COM})} = \sqrt{ \underbrace{\left( \rho_i^{(\text{COM})} \cdot \sum_k \text{AddOn}_{i,k}^{(\text{COM})} \right)^2}_{\mbox{systematic component}} + \underbrace{ \left( 1 - \left( \rho_i^{(\text{COM})} \right)^2 \right) \cdot \sum_k \left(\text{AddOn}_{i,k}^{(\text{COM})}\right)^2}_{\mbox{idiosyncratic component}} }}$$

<div class="center">

<div id="tab_saccr_vols">

| Asset Class         |   Subclass   | Supervisory Factor | Correlation | Supervisory Option Volatility |
|:--------------------|:------------:|:-------------------|:-----------:|:------------------------------|
| Interest rate       |              | 0.5 %              |     N/A     | 50%                           |
| Foreign exchange    |              | 4.0 %              |     N/A     | 15%                           |
| Credit, Single Name |     AAA      | 0.38%              |     50%     | 100%                          |
| 2-5                 |      AA      | 0.38%              |     50%     | 100%                          |
| 2-5                 |      A       | 0.42%              |     50%     | 100%                          |
| 2-5                 |     BBB      | 0.54%              |     50%     | 100%                          |
| 2-5                 |      BB      | 1.06%              |     50%     | 100%                          |
| 2-5                 |      B       | 1.6%               |     50%     | 100%                          |
| 2-5                 |     CCC      | 6.0%               |     50%     | 100%                          |
| Credit, Index       |      IG      | 0.38%              |     80%     | 80%                           |
| 2-5                 |      SG      | 1.06%              |     80%     | 80%                           |
| Equity, Single Name |              | 32%                |     50%     | 120%                          |
| Equity, Index       |              | 20%                |     80%     | 75%                           |
| Commodity           | Electricity  | 40%                |     40%     | 150%                          |
| 2-5                 |   Oil/Gas    | 18%                |     40%     | 70%                           |
| 2-5                 |    Metals    | 18%                |     40%     | 70%                           |
| 2-5                 | Agricultural | 18%                |     40%     | 70%                           |
| 2-5                 |    Other     | 18%                |     40%     | 70%                           |

Supervisory factors and option volatilities from Table 2.

</div>

</div>

#### Capital Charge

The CCR capital charge is then computed as
$$K = \EAD \times \underbrace{\PD \times \LGD}_{\text{Risk Weight}}$$

In the *Standardized Approach*, the risk weight is given by a fixed
percentage depending on the counterparty type and its external rating ,
see table <a href="#tab:standard_weights" data-reference-type="ref"
data-reference="tab:standard_weights">1.8</a>.

<div id="tab:standard_weights">

|            | AAA to AA- | A+ to A- | BBB+ to BBB- | BB+ to BB- | Below BB- | Unrated |
|:----------:|:----------:|:--------:|:------------:|:----------:|:---------:|:-------:|
| Sovereign  |     0%     |   20%    |     50%      |    100%    |   150%    |  100%   |
| Financials |    20%     |   30%    |     50%      |    100%    |   150%    |  100%   |
| Corporate  |    20%     |   50%    |     75%      |    100%    |   150%    |  100%   |

Example risk weights under the standardized approach for credit risk.

</div>

Under the *Internal Ratings-based Approach (IRB)*, banks can use their
internal estimates of PD (*Foundation IRB*), or of PD and LGD (*Advanced
IRB*).

#### Risk Weighted Assets (RWA)

RWA is calculated as a simple multiple of the capital charge
$$\RWA = 12.5 \times K$$

#### Outputs and Reports

The SA-CCR capital analytic produces several output files:

- **saccr.csv**: Main SA-CCR results, broken down by netting set, asset
  class, and hedging set. Each row shows the calculated capital and its
  components at a specific aggregation level.

  - **NettingSet**: Identifier of the netting set. “All” means
    portfolio-level totals.

  - **AgreementType**, **CallType**, **InitialMarginType**,
    **LegalEntityId**: Collateral agreement and counterparty details.

  - **AssetClass**: Asset class (e.g., Commodity, FX, IR, Equity, All).

  - **HedgingSet**: Hedging set within the asset class (e.g., Metal,
    All).

  - **AddOn**: Add-on amount for the aggregation level.

  - **NPV**: Net present value of the trades in the aggregation.

  - **IndependentAmountHeld**, **InitialMargin**, **VariationMargin**:
    Collateral amounts.

  - **ThresholdAmount**, **MinimumTransferAmount**: CSA terms.

  - **RC**: Replacement cost.

  - **Multiplier**: Multiplier applied to the add-on.

  - **PFE**: Potential future exposure, $PFE = Multiplier \times AddOn$

  - **EAD**: Exposure at default, $\alpha (RC + PFE)$

  - **RW**: Risk weight.

  - **CC**: Capital charge.

  Rows with “All” in most columns show portfolio totals. Rows with
  specific netting sets, asset classes, or hedging sets show breakdowns
  at those levels. Empty fields indicate values not applicable at that
  level.

- **saccr_detail.csv** file provides a detailed, trade-level breakdown
  of the SA-CCR calculation. Each row corresponds to a single trade and
  shows all relevant parameters used in the exposure and add-on
  calculations. This report allows you to trace how each trade
  contributes to the overall capital charge. The columns are as follows:

  - **TradeId**: Unique identifier of the trade.

  - **TradeType**: Type of the trade (e.g., CommoditySwap, FxForward,
    Swaption).

  - **NettingSet**: Netting set identifier for the trade.

  - **AgreementType**, **CallType**, **InitialMarginType**,
    **LegalEntityId**: Collateral agreement and counterparty details
    (may be empty if not applicable).

  - **NPV**: Net present value of the trade.

  - **AssetClass**: Asset class assigned to the trade (e.g., IR, FX,
    Commodity, Equity).

  - **HedgingSet**: Hedging set within the asset class (e.g., currency
    pair for FX).

  - **HedgingSubset**: Further subdivision within the hedging set (e.g.,
    specific commodity group or maturity bucket).

  - **Bucket**: Bucket or group used for add-on aggregation (e.g.,
    maturity bucket for IR).

  - **Qualifier**: Qualifier for the hedging set/subset (e.g., index
    name, underlying entity).

  - **Currency**: Currency of the trade.

  - **delta**: Supervisory delta

  - **d**: Adjusted notional for the trade, as defined by SA-CCR rules.
    For IR and Credit derivatives it is the notional adjusted by the
    supervisory duration. For FX derivatives it is the notional value of
    the foreign currency. For Equity and Commodities its the current
    price times the quantity.

  - **MF**: Maturity factor for the trade.

  - **M**: Maturity of the trade (in years).

  - **S**: Start date of the underlying period (in years, if
    applicable).

  - **E**: End date of the underlying period (in years, if applicable).

  - **T**: Latest option exercise date (in years, if applicable).

  - **SD**: Supervisory duration (for IR and Credit).

  - **CurrentPrice**: Current price of the underlying (if applicable).

  - **NumNominalFlows**: Not used at the moment

  - **Price**: Price used in calculating the supervisory delta for
    options (if applicable).

  - **Strike**: Option strike price (if applicable).

  - **Volatility**: Supervisory option volatility used for the trade (if
    applicable).

  If there is a basis swap with two floating legs, there will be two
  entries in the report, one for each leg / main risk factor.

- **capital_crif.csv**: All data required to compute SA-CCR in the ISDA
  Regulatory Capital Model (CRIF) format.

## CVA Capital

General provisions

- Regulatory CVA may differ from accounting CVA, e.g. excludes the
  effect of the bank’s own default (DVA), there are several best
  practices constraints

- CVA risk is defined as the risk of losses arising from changing CVA
  values in response to changes in counterparty credit spreads and
  market risk factors

- Transactions with qualified central counterparties are excluded from
  CVA Capital calculations

- CVA Capital is calculated for the full portfolio (across all netting
  sets), including CVA hedges

- There are two approaches, basic (BA-CVA) and standardised (SA-CVA),
  the latter requires regulatory approval. SA-CVA banks can carve out
  netting sets and apply BA-CVA to these.

- There is a materiality threshold of 100 billion EUR aggregate notional
  of non-centrally cleared derivatives. When below, a bank can choose to
  set its CVA Capital to 100% of the CCR Capital. The regulator can
  remove this option.

- When calculating CCR Capital, the maturity adjustment factor may be
  capped at 1 for all netting sets contributing to CVA Capital.

### Basic Approach, BA-CVA

There are two flavours of the basic approach

- a reduced version that does not recognise hedges

- a full version that does

Note: The implementation in ORE covers the reduced version so far.

#### Reduced Version

The total BA-CVA Capital charge according to the targeted revised
framework is $$D_{\BACVA} \times K_{reduced}$$ with discount scalar
$D_{BA-CVA} = 0.65$ and
$$K_{reduced} = \sqrt{\underbrace{\left(\rho\sum_c \SCVA_c\right)^2}_{\mbox{systematic component}} + \underbrace{(1-\rho^2)\sum_c \SCVA_c^2}_{\mbox{idiosyncratic component}}}$$
where $\rho=0.5$ and $\SCVA_c$ is the stand-alone BA-CVA charge for
counterparty $c$.

Stand-alone BA-CVA Capital charge, sum over netting sets $\NS$:
$$\SCVA_c=\frac{1}{\alpha} \cdot \RW_c \cdot \sum_{\NS} M_{\NS}\cdot \EAD_{\NS}\cdot \DF_{\NS}$$
where

- $\alpha=1.4$

- $\RW_c$ is the counterparty risk weight, see page 111

- $M_{\NS}$ is the netting set’s effective maturity, see paragraphs 38
  and 39 of Annex 4 of the Basel II framework , page 216-217

- $\EAD_{\NS}$ is the netting set’s exposure at default, calculated in
  the same way as the bank calculates it for minimum capital
  requirements for CCR

- $\DF_{\NS}$ is a supervisory discount factor, equal to 1 for banks
  that use IMM to calculate $\EAD$, otherwise equal to
  $(1-\exp(-0.05\cdot M_{\NS}))/(0.05\cdot M_{\NS})$

Note: The implementation in ORE

- uses the SA-CCR EAD amounts

- ignores the idiosyncratic component so that $$\begin{aligned}
  K_{reduced} &= \rho\sum_c \SCVA_c \\
  \BACVA &= D_{\BACVA} \times \rho\times \sum_c \SCVA_c 
  \end{aligned}$$

#### Full Version

Eligible hedges are single-name or index CDS, referencing the
counterparty directly or a counterparty in the same sector and region.
$$K_{full} = \beta\cdot K_{reduced} + (1-\beta)\cdot K_{hedged}$$ where
$\beta=0.25$ to floor the effect of hedging, and
$$K_{hedged} = \sqrt{\underbrace{\left(\rho\cdot\sum_c(\SCVA_c -\SNH_c)- IH\right)^2}_{\mbox{systematic component}} + \underbrace{(1-\rho^2)\cdot\sum_c (\SCVA_c -\SNH_c)^2}_{\mbox{idiosyncratic component}} + \underbrace{\sum_c \HMA_c}_{\mbox{indirect hedges}} }$$
where

- $\SNH_c$ is a sum across all single-name hedges that are taken out to
  hedge the CVA risk of counterparty $c$:
  $$\SNH_c = \sum_{h\in c} r_{rc}\cdot \RW_h \cdot M^{SN}_h\cdot B^{SN}_h\cdot \DF^{SN}_h$$
  see page 113 and .

- $\IH$ is a sum over index hedges the are taken out to hedge CVA risk:
  $$\IH = \sum_i \RW_i\cdot M^{ind}_i\cdot B^{ind}_i\cdot \DF^{ind}_i$$
  see page 113-114 and .

- $\HMA_c$ is a “hedging misalignment parameter” to avoid that
  single-name hedges can take the capital charge to zero:
  $$\HMA_c = \sum_{h\in c} (1- r_{hc}^2)\cdot \RW_h \cdot M^{SN}_h\cdot B^{SN}_h\cdot \DF^{SN}_h$$
  with same parameters as in the calculation of $\SNH_c$.

Note: The full version of BA-CVA is not implemented in ORE yet.

### Standard Approach, SA-CVA

SA-CVA uses as inputs the sensitivities of regulatory CVA (see below) to
counterparty credit spreads and market risk factors driving covered
transactions’ values.

The SA-CVA calculation generally takes delta and vega risk into account
for five risk types: interest rates (IR), foreign exchange (FX),
reference credit spreads, equity and commodity. Note that vega risk
includes sensitivity of option instruments and sensitivity of the CVA
model calibration to input volatilities.

We denote $s_k^{\CVA}$ the sensitivity of the aggregate CVA to risk
factor $k$ and $s_k^{\Hdg}$ the sensitivity of all eligible CVA hedges
to risk factor $k$. Eligible are hedges of both credit spreads and
exposure components. Shift sizes are specified in section C.6 of .

Given the CVA sensitivities and regulatory risk weights and
correlations, the calculation of SA-CVA is straightforward.

Bucket level capital charge:
$$K_b = \sqrt{ \left[\sum_{k\in b} \WS_k^2 + \sum_{k\ne l \in b} \rho_{kl} \cdot \WS_k \cdot \WS_l\right] + R\cdot \sum_{k\in b} \left(\WS_k^{\Hdg}\right)^2 }$$
where $R=0.01$ and
$$\WS_k = \WS_k^{\CVA} + \WS_k^{\Hdg}, \qquad \WS_k^{\CVA} = \RW_k \cdot s_k^{\CVA}, \qquad \WS_k^{\Hdg} = \RW_k \cdot s_k^{\Hdg}$$
with risk weights $\RW_k$ and correlations $\rho_{kl}$ as specified in
Section C.6 of and in .

Bucket-level capital charges must then be aggregated across buckets
within each risk type :
$$K = m_{\CVA}\cdot\sqrt{ \sum_b K_b^2 + \sum_b \sum_{c\ne b} \gamma_{bc} \cdot K_b \cdot K_c}$$
with multiplier $m_{\CVA}=1.25$ and correlation parameters $\gamma_{bc}$
as specified in Section C.6 of .

#### Regulatory CVA Calculation and CVA Sensitivity

Regulatory CVA is the basis for the calculation of the CVA risk capital
requirement. Calculations of regulatory CVA must be performed for each
counterparty with which a bank has at least one covered position.

Regulatory CVA at a counterparty level must be calculated according to
the following principles pages 115-117:

- Based on Monte Carlo simulation of exposure evolution, consistent with
  front office/accounting CVA

- Risk neutral probability measure

- Model calibration to market data where possible

- Use of PDs implied from credit spreads observed in the market, use of
  market-consensus LGDs

- Netting recognition applies as in accounting CVA

- Collateral (VM, IM): Exposure simulation must capture the effects of
  margining collateral that is recognised as a risk mitigant along each
  exposure path. All the relevant contractual features such as the
  nature of the margin agreement (unilateral vs bilateral), the
  frequency of margin calls, the type of collateral, thresholds,
  independent amounts, initial margins and minimum transfer amounts must
  be appropriately captured by the exposure model; the Margin Period of
  Risk has to be taken into account

The regulatory CVA calculation is based on ORE’s XVA analytics. It takes
CSA details for simulating VM balances into account (thresholds, minimum
transfer amounts), as well as the Margin Period of Risk. Initial Margin
is modelled as a stochastic Dynamic Delta VaR along all Monte Carlo
paths.

The product scope for CVA sensitivity and SA-CVA is so far:

- FX Forwards

- FX Options

- Cross Currency Swaps

For this scope we assume independence of credit and other market
factors. With this simplification, the calculation of CVA sensitivities
w.r.t. credit factors does not require the recalculation of exposure
profiles. IR/FX delta and vega calculation, however, does require the
recalculation of exposures under each shift scenario. The number of
scenarios is minimized and tailored to the portfolio. Moreover we make
use of multithreading and further parallelization techniques to reduce
calculation times. The shifts/recalculations required to cover the
product scope above are listed below in table
<a href="#tab:cva_sensi" data-reference-type="ref"
data-reference="tab:cva_sensi">1.9</a>.

<div class="center">

<div id="tab:cva_sensi">

| Risk Type                                                 | Risk Factor                                      | Shift                                                                                                                                                                                                                                                                    |
|:----------------------------------------------------------|:-------------------------------------------------|:-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| IR Delta for currencies USD, EUR, GBP, AUD, CAD, SEK, JPY | Currency and tenor (1y, 2y, 5y, 10y, 30y)        | Shift of each tenor point for all curves with the given currency curve, absolute shift size 1BP                                                                                                                                                                          |
| IR Delta for any other currency                           | Currency                                         | Parallel shift of all yield curves for given given currency by 1BP                                                                                                                                                                                                       |
| FX Delta                                                  | Foreign currency (vs. a fixed domestic currency) | FX shift for any foreign1/foreign2 currency pair is obtained by triangulation from the “fundamental” foreign/domestic FX rates; relative shift by 1% for the base currency FX rate                                                                                       |
| FX Vega                                                   | Foreign currency (vs. a fixed domestic currency) | Volatility shift for any foreign1/foreign2 currency pair is implied from the “fundamental” foreign1/domestic and foreign2/domestic volatility and a fixed implied correlation; simultaneous 1% relative shift for all volatilities in the fundamental volatility surface |
| Counterparty Credit Delta                                 | Entity and tenor point (0.5y, 1y, 3y, 5y, 10y)   | Absolute shift of the relevant credit spread by 1BP, aggregation of sensitivities across entities within sector buckets 1-7                                                                                                                                              |
| Reference Credit Delta                                    | Reference credit sector (1-15)                   | Simultaneous absolute shift of the relevant credit spreads by 1BP, for all reference names in the bucket, across all tenor points                                                                                                                                        |

Risk factors and shifts.

</div>

</div>

[^1]: See paragraph 166.

[^2]: See Example 3
