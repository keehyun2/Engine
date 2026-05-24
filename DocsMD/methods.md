# ORE Methodology

This document contains the methodology and algorithms used in ORE (Open Source Risk Engine).

---

# Introduction

This document contains a brief summary of the methods used in ORE, in
particular the risk analytics in ORE. It may be read in parallel to the
ORE User Guide, the parameterisation instructions and examples provided
there.

We hope that this document provides a starting point for model
validation documentation that may have to be compiled by organisations
that use ORE “in anger”.

The pricing methods applied in ORE are described separately in the ORE
Product Catalogue.

---


---

# Market Risk

## Sensitivity Analysis

ORE’s sensitivity analysis framework uses “bump and revalue” to compute
Interest Rate, FX, Inflation, Equity and Credit sensitivities to

- Discount curves (in the zero rate domain)

- Index curves (in the zero rate domain)

- Yield curves including e.g. equity forecast yield curves (in the zero
  rate domain)

- FX Spots

- FX volatilities

- Swaption volatilities, ATM matrix or cube

- Cap/Floor volatility matrices (in the caplet/floorlet domain)

- Default probability curves (in the “zero rate” domain, expressing
  survival probabilities $S(t)$ in term of zero rates $z(t)$ via
  $S(t)=\exp(-z(t)\times t)$ with Actual/365 day counter)

- Equity spot prices

- Equity volatilities, ATM or including strike dimension

- Zero inflation curves

- Year-on-Year inflation curves

- CDS volatilities

- Base correlation curves

Apart from first order sensitivities (deltas), ORE computes second order
sensitivities (gammas and cross gammas) as well. Deltas are computed
using up-shifts and base values as
$$\delta = \frac{f(x+\Delta)-f(x)}{\Delta},$$ where the shift $\Delta$
can be absolute or expressed as a relative move $\Delta_r$ from the
current level, $\Delta=x\,\Delta_r$. Gammas are computed using up- and
down-shifts
$$\gamma = \frac{f(x+\Delta)+f(x-\Delta) - 2\,f(x)}{\Delta^2},$$ cross
gammas using up-shifts and base values as
$$\gamma_{cross} = \frac{f(x+\Delta_x,y+\Delta_y)-f(x+\Delta_x,y) -f(x,y+\Delta_y) + f(x,y)}{\Delta_x\,\Delta_y}.$$

From the above it is clear that this involves the application of 1-d
shifts (e.g. to discount zero curves) and 2-d shifts (e.g. to Swaption
volatility matrices). The structure of the shift curves/matrices does
not have to match the structure of the underlying data to be shifted, in
particular the shift “curves/matrices” can be less granular than the
market to be shifted. Figure
<a href="#fig_shiftcurve" data-reference-type="ref"
data-reference="fig_shiftcurve">1.1</a> illustrates for the
one-dimensional case how shifts are applied.

<figure id="fig_shiftcurve">
<div class="center">
<embed src="shiftcurve.pdf" />
</div>
<figcaption>1-d shift curve (bottom) applied to a more granular
underlying curve (top). </figcaption>
</figure>

Shifts at the left and right end of the shift curve are extrapolated
flat, i.e. applied to all data of the original curve to the left and to
the right of the shift curve ends. In between, all shifts are
distributed linearly as indicated to the left and right up to the
adjacent shift grid points. As a result, a parallel shift of the all
points on the shift curve yields a parallel shift of all points on the
underlying curve.  
The two-dimensional case is covered in an analogous way, applying flat
extrapolation at the boundaries and “pyramidal-shaped” linear
interpolation for the bulk of the points.

The details of the computation of sensitivities to implied volatilities
in strike direction can be summarised as follows, see also table
<a href="#sensi_config_overview" data-reference-type="ref"
data-reference="sensi_config_overview">1.1</a> for an overview of the
admissible configurations and the results that are obtained using them.

For *Swaption Volatilities*, the initial market setup can be an ATM
surface only or a full cube. The simulation market can be set up to
simulate ATM only or to simulate the full cube, but the latter choice is
only possible if a full cube is set up in the initial market. The
sensitivity set up must match the simulation setup with regards to the
strikes (i.e. it is ATM only if and only if the simulation setup is ATM
only, or it must contain exactly the same strike spreads relative to ATM
as the simulation setup). Finally, if the initial market setup is a full
cube, and the simulation / sensitivity setup is to simulate ATM only,
then sensitivities are computed by shifting the ATM volatility w.r.t.
the given shift size and type and shifting the non-ATM volatilities by
the same absolute amount as the ATM volatility.

For *Cap/Floor Volatilities*, the initial market setup always contains a
set of fixed strikes, i.e. there is no distinction between ATM only and
a full surface. The same holds for the simulation market setup. The
sensitivity setup may contain a different strike grid in this case than
the simulation market. Sensitivity are computed per expiry and per
strike in every case.

For *Equity Volatilities*, the initial market setup can be an ATM curve
or a full surface. The simulation market can be set up to simulate ATM
only or to simulate the full surface, where a full surface is allowed
even if the initial market setup in an ATM curve only. If we have a full
surface in the initial market and simulate the ATM curve only in the
simulation market, sensitivities are computed as in the case of Swaption
Volatilities, i.e. the ATM volatility is shifted w.r.t. the specified
shift size and type and the non-ATM volatilities are shifted by the same
absolute amount as the ATM volatility. If the simulation market is set
up to simulate the full surface, then all volatilities are shifted
individually using the specified shift size and type. In every case the
sensitivities are aggregated on the ATM bucket in the sensitivity
report.

For *FX Volatilities*, the treatment is similar to Equity Volatilities,
except for the case of a full surface definition in the initial market
and an ATM only curve in the simulation market. In this case, the
pricing in the simulation market is using the ATM curve only, i.e. the
initial market’s smile structure is lost.

For *CDS Volatilities* only an ATM curve can be defined.

In all cases the smile dynamics is “sticky strike”, i.e. the implied vol
used for pricing a deal does not change if the underlying spot price
changes.

<div class="center">

<div id="sensi_config_overview">

| Type      | Init Mkt. Config. | Sim. Mkt Config.  | Sensitivity Config. | Pricing      | Sensitivities w.r.t.                                                     |
|:----------|:------------------|:------------------|:--------------------|:-------------|:-------------------------------------------------------------------------|
| Swaption  | ATM               | Simulate ATM only | Shift ATM only      | ATM Curve    | ATM Shifts                                                               |
| Swaption  | Cube              | Simulate Cube     | Shift Smile Strikes | Full Cube    | Smile Strike Shifts[^1]                                                  |
| Swaption  | Cube              | Simulate ATM only | Shift ATM only      | Full Cube    | ATM Shifts[^2]                                                           |
| Cap/Floor | Surface           | Simulate Surface  | Shift Smile Strikes | Full Surface | Smile Strike Shifts                                                      |
| Equity    | ATM               | Simulate ATM only | Shift ATM only      | ATM Curve    | ATM Shifts                                                               |
| Equity    | ATM               | Simulate Surface  | Shift ATM only      | ATM Curve    | Smile Strike Shifts[^3]                                                  |
| Equity    | Surface           | Simulate ATM only | Shift ATM only      | Full Surface | ATM Shifts<sup><a href="#sensismileparallel" data-reference-type="ref"   
                                                                                          data-reference="sensismileparallel">2</a></sup>                           |
| Equity    | Surface           | Simulate Surface  | Shift ATM only      | Full Surface | Smile Strike Shifts<sup><a href="#sensiaggatm" data-reference-type="ref" 
                                                                                          data-reference="sensiaggatm">3</a></sup>                                  |
| FX        | ATM               | Simulate ATM only | Shift ATM only      | ATM Curve    | ATM Shifts                                                               |
| FX        | ATM               | Simulate Surface  | Shift ATM only      | ATM Curve    | Smile Strike Shifts<sup><a href="#sensiaggatm" data-reference-type="ref" 
                                                                                          data-reference="sensiaggatm">3</a></sup>                                  |
| FX        | Surface           | Simulate ATM only | Shift ATM only      | ATM Curve    | ATM Shifts                                                               |
| FX        | Surface           | Simulate Surface  | Shift ATM only      | Full Surface | Smile Strike Shifts<sup><a href="#sensiaggatm" data-reference-type="ref" 
                                                                                          data-reference="sensiaggatm">3</a></sup>                                  |
| CDS       | ATM               | Simulate ATM only | Shift ATM only      | ATM Curve    | ATM Shifts                                                               |

Admissible configurations for Sensitivity computation in ORE

</div>

</div>

## Par Sensitivity Analysis

The “raw” sensitivities in ORE are generated in a computationally
convenient domain (such as zero rates, caplet/floorlet volatilities,
integrated hazard rates, inflation zero rates). These raw sensitivities
are typically further processed in risk analytics such as VaR measures.
On the other hand, for hedging purposes one is rather interested in
sensitivities with respect to fair rates of hedge instruments such as
Forward Rate Agreements, Swaps, flat Caps/Floors, CDS, Zero Coupon
Inflation Swaps.  
It is possible to generate par sensitivities from raw sensitivities
using the chain rule as follows, and this is the approach taken in ORE.
Recall for example the fair swap rate $c$ for some maturity as a
function of zero rates $z_i$ in a single curve setting:
$$c = \frac{1 - e^{-z_n\,t_n}}{\sum_{i=1}^n \delta_i\,e^{-z_i\, t_i}}$$
More realistically, a given fair swap rate might be a function of the
zero rates spanning the discount and index curves in the chosen
currency. In a multi currency curve setting, that swap rate might even
be a function of the zero rates spanning a foreign (collateral) currency
discount curve, foreign and domestic currency index curves. Generally,
we can write any fair par rate $c_i$ as function of raw rates $z_j$,
$$c_i \equiv c_i(z_1, z_2, ..., z_n)$$ This function may not be
available in closed form, but numerically we can evaluate the
sensitivity of $c_i$ with respect to changes in all raw rates,
$$\frac{\partial c_i}{\partial z_j}.$$ These sensitivities form a
*Jacobi* matrix of derivatives. Now let $V$ denote some trade’s price.
Its sensitivity with respect a raw rate change $\partial V/\partial z_k$
can then be expressed in terms of sensitivities w.r.t. par rates using
the chain rule
$$\frac{\partial V}{\partial z_j} = \sum_{i=1}^n \frac{\partial V}{\partial c_i}\,\frac{\partial c_i}{\partial z_j},$$
or in vector/matrix form
$$\nabla_z V = C \cdot \nabla_c V, \qquad C_{ji} = \frac{\partial c_i}{\partial z_j}.$$
Given the raw sensitivity vector $\nabla_z V$, we need to invert the
Jacobi matrix $C$ to obtain the par rate sensitivity vector
$$\nabla_c V = C^{-1} \cdot \nabla_z V.$$

We then compute the Jacobi matrix $C$ by

- setting up par instruments with links to all required term structures
  expressed in terms of raw rates

- “bumping” all relevant raw rates and numerically computing the par
  instrument’s fair rate shift for each bump

- thus filling the Jacobi matrix with finite difference approximations
  of the partial derivatives $\partial c_i/\partial z_j$.

The par rate conversion supports the following par instruments:

- Deposits

- Forward rate Agreements

- Interest Rate Swaps (fixed vs. ibor)

- Overnight Index Swaps

- Tenor Basis Swaps (ibor vs. ibor)

- Overnight Index Basis Swaps (ibor vs. OIS)

- FX Forwards

- Cross Currency Basis Swaps

- Credit Default Swaps

- Caps/Floors

## Economic P&L

The economic P&L of a portfolio denotes the change in its economic value
over a time period $t_1$ to $t_2$. The economic value evolution during
the period is due to three components

- the change in present value from period start to end

- incoming and outgoing cash flows

- accumulated cost of funding required to set up the portfolio initially

In the following, we consider a portfolio consisting of assets in
various currencies. We decompose the portfolio into parts each
denominated in a different currency and value each sub-portfolio in its
currency. We denote the sub-portfolio values at time $t$ in the
respective currency $P_1(t), P_2(t), \dots$. Instruments with cash flows
in more than one currency are decomposed into single-currency
instruments and assigned into the related sub-portfolio. The total
portfolio value expressed in base currency (e.g. EUR) is
$$P(t) = \sum_c P_c(t)\:X_c(t) \label{initial_value_base}$$ where $X_c$
is the exchange rate that converts an amount in currency $c$ into an
amount in base currency by multiplication. All prices $P_c(t)$ denote
*dirty* market values (or theoretical values where market values are not
available) at time $t$.

In the following we consider three points in time,

- $t_0$: the time just before the first actual cash flow has appeared in
  the portfolio under consideration, possibly years ago

- $t_1$: the beginning of the period for which we want to determine P&L

- $t_2$: the end of the period for which we want to determine P&L

### Original P&L

The original P&L is the portfolio’s P&L from portfolio inception $t_0$.
In this case the portfolio value at $t_0$ is $$P(t_0) = 0,$$ and the P&L
up to time $t_2$ is given by the portfolio value at $t_2$ plus the
balance of currency accounts that collect incoming and outgoing cash
flows and are compounded up to time $t_2$:
$$\pi(0, t_2) = P(t_2) + \sum_c X_c(t_2)\:B_c(t_2)
\label{pnl_3}$$ where
$$B_c(t_2) = \sum_{j=0}^{I(t_2)-1} F_c(\tau_j)\:C_c(\tau_j, t_2), \quad C_c(\tau_j, t_2)=\prod_{k=I(\tau_j)}^{I(t_2)-1} (1+r_c(\tau_k)\delta_k),$$
sums and products are taken over daily time steps $\tau_j$ and

|                 |                                                                                                                              |
|:----------------|:-----------------------------------------------------------------------------------------------------------------------------|
| $I(t)$          | is the day’s index associated with time $t$                                                                                  |
| $F_c(\tau_{j})$ | is the net cash flow in currency $c$ on date/time $\tau_j$, possibly zero                                                    |
| $r_c(\tau_j)$   | is the Bank’s overnight funding and investment rate in currency $c$ for interest period $[\tau_j, \,\tau_{j+1}]$ (overnight) |
| $\delta_j$      | is the related day count fraction for period $[\tau_j, \,\tau_{j+1}]$                                                        |

The balances $B_c$ can also be constructed iteratively $$\begin{aligned}
B_c(\tau_{j+1}) &=& B_c(\tau_{j}) (1+r_c(\tau_j)\delta_j) + F_c(\tau_{j+1})
\label{recursion}\\
j &=& 0, 1, 2, \dots \nonumber\\
B_c(\tau_0) &=& 0. \nonumber
\end{aligned}$$

The P&L for a period of interest $[t_1;\,t_2]$ is then computed by
taking the difference $$\begin{aligned}
    \pi(t_1, t_2) &=& \pi(0,t_2) - \pi(0,t_1) \label{pnl_1} \\
        &=& P(t_2) - P(t_1) + \sum_c (X_c(t_2)\: B_c(t_2) - X_c(t_1)\: B_c(t_1))
        \nonumber
\end{aligned}$$

One can show that $$B_c(t_2) = B_c(t_1) \:C_c(t_1, t_2)
    + \sum_{j=I(t_1)}^{I(t_2)-1}F_c(\tau_j)\:C_c(\tau_j, t_2)
\label{bc}$$ which separates the contribution to $B_c(t_2)$ from cash
flows in period $[t_1;t_2]$ (right-most sum) and contributions from
realized P&L and cost of funding of previous periods accumulated in
$B_c(t_1)$. We can now insert
(<a href="#bc" data-reference-type="ref" data-reference="bc">[bc]</a>)
into (<a href="#pnl_1" data-reference-type="ref"
data-reference="pnl_1">[pnl_1]</a>) to eliminate $B_c(t_2)$ and obtain
$$\begin{aligned}
    \pi(t_1, t_2) &=& P(t_2) - P(t_1)
    + \sum_c X_c(t_2) \sum_{j=I(t_1)}^{I(t_2)-1}F_c(\tau_j)\:C_c(\tau_j, t_2)
    \nonumber\\
    && + \sum_c B_c(t_1)\:\left\{X_c(t_2)\:C_c(t_1, t_2) - X_c(t_1)\right\} \label{pnl_1a}
\end{aligned}$$

### Cost of Carry

Separating actual cash flows and prices from compounding effects yields
$$\pi(t_1, t_2) = P(t_2) - P(t_1)
    + \sum_c X_c(t_2)\sum_{j=I(t_1)}^{I(t_2)-1}F_c(\tau_j)
    + CC(t_1,t_2)$$

where the cost of carry term is $$\begin{aligned}
CC(t_1,t_2) &=&
    \sum_c X_c(t_2)\sum_{j=I(t_1)}^{I(t_2)-1}F_c(\tau_j)\:
    \left(C_c(\tau_j, t_2) - 1\right) \nonumber\\
&& + \sum_c \:B_c(t_1)\:\left\{X_c(t_2)\:C_c(t_1, t_2) - X_c(t_1)\right\}
\label{CC}
\end{aligned}$$

### Period P&L after Sell-Down

At time $t_1$, we can write the original P&L (equation
<a href="#pnl_3" data-reference-type="ref"
data-reference="pnl_3">[pnl_3]</a>) in respective currencies
$$\pi_c(t_1) = P_c(t_1) + B_c(t_1), \qquad \pi(t_1) = \sum_c X_c(t_1)\:\pi_c(t_1).$$
Inserting this into
(<a href="#CC" data-reference-type="ref" data-reference="CC">[CC]</a>),
$$\begin{aligned}
CC(t_1,t_2) &=&
    \sum_c X_c(t_2)\sum_{j=I(t_1)}^{I(t_2)-1}F_c(\tau_j)\:
    \left(C_c(\tau_j, t_2) - 1\right) \\
&& + \sum_c \:(\pi_c(t_1) - P_c(t_1))\:\left\{X_c(t_2)\:C_c(t_1, t_2) - X_c(t_1)\right\},
\end{aligned}$$ shows that there is a contribution to $\pi(t_1,t_2)$,
via the cost of carry, due to compounding and FX effects on previous
periods’ P&L result.

We now take the view that the portfolio is liquidated at time $t_1$, so
that the account balance equals the P&L at $t_1$. We further assume that
this balance is then removed (“sell down” of P&L) and transferred into a
separate portfolio, the Bank’s equity[^4]. The same portfolio is
thereafter set up again so that the currency account balance turns into
a liability $B_c(t_1) = - P_c(t_1)$, and the total starting balance is
$B(t_1)=-P(t_1)$. In contrast to the previous section, this changes the
balance at time $t_1$ suddenly and without relation to an actual cash
flow.

This raises the question how the artificial initial balance is funded
subsequently, in currency for each sub-portfolio or in base currency
only. This choice may vary by portfolio, depend on the actual currencies
in which the Bank can source funding, depend on the location/economy in
which the portfolio is run, which currency is a reasonable benchmark,
etc.

### Funding in Currency

In this section we take the view that each sub-portfolio is funded in
currency so that we start with opening balances $B_c(t_1) = -P_c(t_1)$.

Inserting the artificial opening balances at $t_1$ into
(<a href="#pnl_1a" data-reference-type="ref"
data-reference="pnl_1a">[pnl_1a]</a>) yields $$\begin{aligned}
    \pi_2(t_1, t_2) &=& P(t_2) - P(t_1)
    + \sum_c X_c(t_2) \sum_{j=I(t_1)}^{I(t_2)-1}F_c(\tau_j)\:C_c(\tau_j, t_2)
    \nonumber\\
    && - \sum_c P_c(t_1)\:\left\{X_c(t_2)\:C_c(t_1, t_2) - X_c(t_1)\right\} \nonumber \\
&=& P(t_2)
    + \sum_c X_c(t_2) \sum_{j=I(t_1)}^{I(t_2)-1}F_c(\tau_j)\:C_c(\tau_j, t_2)
    \nonumber\\
    && - \sum_c P_c(t_1)\:X_c(t_2)\:C_c(t_1, t_2)
    \label{pnl_2}
\end{aligned}$$

Note that only exchange rates at $t_2$ enter into the expression.

### Cost of Carry

Separating actual cash flows and prices from compounding effects yields

$$\pi_2(t_1, t_2) = P(t_2) + \sum_c X_c(t_2)\:\left\{-P_c(t_1)
    + \sum_{j=I(t_1)}^{I(t_2)-1}F_c(\tau_j)\right\}
    + CC_2(t_1,t_2)$$

where the cost of carry term is $$\begin{aligned}
CC_2(t_1,t_2) &=& \sum_c \:X_c(t_2)\:
\sum_{j=I(t_1)}^{I(t_2)-1} F_c(\tau_j) \: \left(C_c(\tau_j, t_2) - 1\right)\\
&& - \sum_c \:X_c(t_2)\:P_c(t_1)\:\left(C_c(t_1, t_2) - 1\right)
\end{aligned}$$

### Funding in Base Currency

In this section we assume that the setup cost for the portfolio is
converted into base currency at $t_1$ and funded subsequently in base
currency. This means we insert artificial initial balances $B_c(t_1)=0$
except for the base currency account $B(t_1) = -P(t_1)$. Inserting this
opening balance at $t_1$ into
(<a href="#pnl_1a" data-reference-type="ref"
data-reference="pnl_1a">[pnl_1a]</a>) now yields $$\begin{aligned}
    \pi_3(t_1, t_2) &=& P(t_2)
    + \sum_c X_c(t_2) \sum_{j=I(t_1)}^{I(t_2)-1}F_c(\tau_j)\:C_c(\tau_j, t_2)
    \nonumber\\
    && - P(t_1)\:C(t_1, t_2)
    \label{pnl_4}
\end{aligned}$$

where $C(t_1,t_2)$ is the compounding factor in base currency.

#### Cost of Carry

Separating actual cash flows and prices from compounding effects yields
now

$$\pi_3(t_1, t_2) = P(t_2) - P(t_1)
    + \sum_c X_c(t_2) \sum_{j=I(t_1)}^{I(t_2)-1}F_c(\tau_j)
    + CC_3(t_1, t_2)$$ where $$\begin{aligned}
CC_3(t_1, t_2) &=&
\sum_c X_c(t_2) \sum_{j=I(t_1)}^{I(t_2)-1}F_c(\tau_j)\:(C_c(\tau_j, t_2)-1)\\
&&  - P(t_1)\:(C(t_1, t_2) - 1)
\end{aligned}$$

#### FX Effect

The difference between (<a href="#pnl_2" data-reference-type="ref"
data-reference="pnl_2">[pnl_2]</a>) and
(<a href="#pnl_3" data-reference-type="ref"
data-reference="pnl_3">[pnl_3]</a>) is

$$\pi_2(t_1, t_2) - \pi_3(t_1, t_2) = P(t_1)\:C(t_1, t_2)
    - \sum_c P_c(t_1)\:X_c(t_2)\:C_c(t_1, t_2).$$

The expected value of this difference at period start $t_1$ is zero, but
the retrospectively realized difference at period end $t_2$ is nonzero
in general.

## Risk Hypothetical P&L

In the following we briefly describe approaches to generating P&L
vectors that feed into several subsequent sections for the purpose of
computing risk measures such as Value at Risk or for backtesting a
market risk model.

These P&L’s are different from the economic P&L introduced in section
<a href="#economic_pnl" data-reference-type="ref"
data-reference="economic_pnl">1.3</a> above, but rather
*risk-hypothetical* due to the application of some historical market
moves to the current market which gives rise to a valuation change.

Consider a history of market risk factors $X_i(j)$ where
$i\in\{1,\ldots,n\}$ identifies the risk factor and $j\in\{1,\ldots,m\}$
corresponds to a time $t_j$ on which the risk factor was observed. The
times are assumed to be equally spaced, with $t_{j+1}-t_j$ corresponding
to $1$ business day w.r.t. a given calendar. To generate an overlapping
$k$-day PL, define the $k$ day return at time $t_j$ to be

$$\label{returns}
r_i(j) = R_{T_i}(X_i(j), X_{i}(j+k))$$

for $j=1,\ldots,m-k$. Note that the case of non-overlapping $k$ day
returns fits in with straightforward modifications of the scheme
described here. $R$ defines the return value for two observations of the
same factor, which is one of the following

$$\begin{aligned}
  R_A(x,y) &=& y-x \\
  R_R(x,y) &=& y/x - 1 \\
  R_L(x,y) &=& \log(y/x)
\end{aligned}$$

where the subscript stands for absolute (A), relative (R) and lognormal
(L) returns, respectively. Note that the relative and lognormal returns
are not defined for $x=0$, and we consider a data point with $X_i(j)=0$
and for which we compute relative or lognormal returns to be an error in
the data that needs to be corrected or excluded from the analysis. Also
note that $R_R \approx R_L$ for small values of $y/x-1$, the difference
$R_R-R_L$ approaching zero when $y/x$ approaches $1$.

Now assume $t_m$ to be the reference date (e.g. for the value at risk
calculation) and

$$X(m) = \{ X_i(m) \}_{i=1,\ldots,n}$$

the market factor values on the reference date.

### Full Revaluation P&L

For a given portfolio denote its NPV at $t_m$ by $\nu(X(m))$. Then we
can compute a *full revaluation PL* vector

$$\label{fullrevalpl}
\pi_F = \{ \pi_F(j) \}_{j=1,\ldots,m-k}$$

as

$$\pi_F(j) = \nu( X'(m,j) ) - \nu ( X(m) )$$

by pricing the portfolio under each perturbed market factor vector

$$X'(m,j) = \{ X'_i(m,j) \}_{i=1,\ldots,n}$$

which is defined by

$$\label{histReturns}
  X'_i(m,j) = a_{T_i}( X_i(m),  R_{T_i}(X_i(j),X_i(j+k)) )$$

with the return application function

$$\begin{aligned}
  a_A(x,r) &=& x+r \\
  a_R(x,r) &=& x(1+r) \\
  a_L(x,r) &=& x e^r
\end{aligned}$$

and return types $T_i \in \{ A, R, L \}$, dependent on the particular
factor $X_i$. Table
<a href="#sensiReturnTypes" data-reference-type="ref"
data-reference="sensiReturnTypes">1.2</a> shows a possible choice of
return types for the different risk factors (in ORE notation). Note,
that the factors Discount Curve, Index Curve and Survival Probability
are discount factors resp. survival probabilities that are converted to
zero rate resp. hazard rate shifts by taking the log. Also note, that
the factors Recovery Rate and Basis Correlation are bounded (a recovery
rate must be in $[0,1]$ while the base correlation must be in $[-1,1]$),
so that after a shift is applied, the result has to be capped / floored
appropriately to ensure valid scenario values.

### Sensitivity based P&L

As an alternative to the full revaluation PL in
<a href="#fullrevalpl" data-reference-type="eqref"
data-reference="fullrevalpl">[fullrevalpl]</a> we can approximate this
PL using a Taylor expansion of $\nu(X'(m,j))$ viewed as a function of
the returns $R_{T_i}$[^5] around the expansion point $(0,0,\ldots,0)$
generating a *sensitivity based PL*,

$$\pi_S = \{ \pi_S(j) \}_{j=1,\ldots,m-k}$$

with

$$\begin{aligned}\label{taylorPl}
  \pi_S(j) = & \sum_{i=1}^n D^i_{T_i}\nu(X(m)) R_{T_i}(X_i(m), X'_i(m,j)) + \\
           \frac{1}{2}& \sum_{i,l=1}^n D^{i,l}_{T_i,T_l}\nu(X(m)) R_{T_i}(X_i(m), X'_i(m,j)) R_{T_l}(X_l(m), X'_l(m,j)),
\end{aligned}$$

where we use sensitivities up to second order. Here $D^i_{T_i}$ denotes
a first or second order derivative operator, depending on the market
factor specific shift type $T_i \in \{ A,R,L \}$, i.e.

$$\begin{aligned}
\label{derivs}
  D^i_A f(x) &=& \frac{\partial f(x)}{\partial x_i}, \\
  D^i_R f(x) = D^i_L f(x) &=& x_i\frac{\partial f(x)}{\partial x_i}
\end{aligned}$$

and using the short hand notation

$$\label{derivs_short}
  D^{i,l}_{T_i,T_l} f(x) = D^i_{T_i} D^l_{T_l} f(x).$$

These first and second order sensitivities may be computed analytically,
or (more common) as finite difference approximations (“bump and revalue”
approximations), see section
<a href="#sec:app_sensi" data-reference-type="ref"
data-reference="sec:app_sensi">1.1</a>. To clarify the relationship of
<a href="#derivs" data-reference-type="eqref"
data-reference="derivs">[derivs]</a> and a finite difference scheme for
derivatives computation in a bit more detail we note that for a absolute
shift $h>0$

$$\frac{f(x+h)-f(x)}{h} \rightarrow f'(x)$$

for $h\rightarrow 0$ by definition of $f'$ while for a relative shift

$$\frac{f(x(1+h))-f(x)}{h} = x \frac{f(x(1+h))-f(x)}{xh} \rightarrow xf'(x)$$

for $h\rightarrow 0$ and for a log shift

$$\label{logshift}
\frac{f(xe^h)-f(x)}{h} \rightarrow xf'(x)$$

using e.g. L’Hospital’s rule, so that

- both a relative and a log shift bump and revalue sensitivity
  approximate the same value $xf'(x)$ in the limit for $h\rightarrow 0$,

- an absolute shift sensitivity can be transformed into a relative / log
  shift sensitivity (in the limit for $h\rightarrow 0$) by multiplying
  with the risk factor value $x$, and vice versa.

We also note that the usual way of bumping continuously compounded zero
rates to compute a Discount Curve or Index Curve sensitivity by $h^*$ is
equivalent to <a href="#logshift" data-reference-type="eqref"
data-reference="logshift">[logshift]</a> with $h=h^*t$, where $t$ is the
maturity of the respective rate. Therefore in practice a log return of
discount factors can not directly be combined with a sensitivity
expressed in zero rate shifts, but has to be scaled by $1/t$ before
doing so.

Since the number of second order derivatives can be quite big in
realistic setups with hundreds or even thousands of market factors, in
practice only part of the second order derivatives might be fed into
<a href="#taylorPl" data-reference-type="eqref"
data-reference="taylorPl">[taylorPl]</a> assuming the rest to be zero.

Note that the types $T_i$ used to generate the historical returns
<a href="#histReturns" data-reference-type="eqref"
data-reference="histReturns">[histReturns]</a> can be different from
those used in the Taylor expansion
<a href="#taylorPl" data-reference-type="eqref"
data-reference="taylorPl">[taylorPl]</a>. It is important though that
the same types $T_i$ are used for the derivatives operators $D^i_{T_i}$
and the returns $R_{T_i}$ in
<a href="#taylorPl" data-reference-type="eqref"
data-reference="taylorPl">[taylorPl]</a>.

A number of configurations are hard-coded into ORE depending on whether
raw sensitivities, backtesting sensitivities or CRIF sensitivities are
being called. These configurations are displayed in
<a href="#sensiReturnTypes" data-reference-type="ref"
data-reference="sensiReturnTypes">1.2</a> - note that there is currently
no distinction made in ORE between raw sensitivities and backtest
sensitivities.

<div id="sensiReturnTypes">

| ORE Risk Factor        | Backtest Sensitivities |            | CRIF Sensitivities |            |
|:-----------------------|:----------------------:|:----------:|:------------------:|:----------:|
| 2-5                    |      Return Type       | Shift Size |    Return Type     | Shift Size |
| Discount Curve         |           A            |   0.01%    |         A          |   0.01%    |
| Index Curve            |           A            |   0.01%    |         A          |   0.01%    |
| Yield Curve            |           A            |   0.01%    |         A          |   0.01%    |
| Dividend Yield         |           A            |   0.01%    |         A          |   0.01%    |
| Equity Forecast Curve  |           A            |   0.01%    |         A          |   0.01%    |
| Swaption Volatility\*  |           R            |     1%     |         A          |   0.01%    |
| Optionlet Volatility\* |           R            |     1%     |         A          |   0.01%    |
| FX Spot\*\*            |           R            |     1%     |         R          |    0.1%    |
| FX Volatility          |           R            |     1%     |         A          |     1%     |
| Equity Spot            |           R            |     1%     |         R          |     1%     |
| Equity Volatility      |           R            |     1%     |         A          |     1%     |
| Yield Volatility       |           R            |     1%     |         R          |     1%     |
| Survival Probability   |           A            |   0.01%    |         A          |   0.01%    |
| CDS Volatility         |           R            |     1%     |         R          |     1%     |
| Correlation            |           R            |     1%     |         \-         |     \-     |
| Base Correlation       |           A            |     1%     |         A          |     1%     |
| Zero Inflation Curve   |           A            |   0.01%    |         A          |   0.01%    |
| YoY Inflation Curve    |           A            |   0.01%    |         A          |   0.01%    |
| Zero Inflation CF Vol  |           R            |     1%     |         R          |     1%     |
| YoY Inflation CF Vol   |           R            |     1%     |         R          |     1%     |
| Commodity Curve        |           R            |     1%     |         R          |     1%     |
| Commodity Volatility   |           R            |     1%     |         A          |     1%     |
| Security Spread        |           A            |   0.01%    |         \-         |     \-     |

Sensitivity return type configuration for raw, backtest and CRIF
sensitivities

</div>

\*We predominantly use normal IR volatilities with an absolute shift of
$0.01\%$. For lognormal IR volatilities an absolute shift of $1\%$
applies. Also, notice that “Optionlet Volatility” is the ORE name for
“Cap / Floor Volatility”.

\*\*During a CRIF run, the FX spot delta is computed using the central
difference approximation by default. A smaller shift size of $0.1\%$ is
used because of this. Furthermore, for FX vanilla European and American
options, there are analytic formulae available for FX deltas. These are
implemented in ORE during a CRIF run.

Note - the values $A$ and $R$ here refer to the absolute and relative
shifts defined in <a href="#derivs" data-reference-type="eqref"
data-reference="derivs">[derivs]</a>.

## Value at Risk

### Historical Simulation VaR

The historical simulation VaR is defined to be a $p$-quantile of the
empirical distribution generated by the full revaluation PL vector
$\pi_F = \{ \pi_F(j) \}_{j}$. Here, with “generated” we mean that we
weigh each $\pi_F(j)$ with the same probability $1/J$, where $J$ denotes
the number of elements in the vector.

### Historical Simulation Taylor VaR

Similarly, the historical simulation Taylor VaR is defined to be the
$p$-quantile of the empirical distribution generated by the sensitivity
based PL vector $\pi_S$ (call side), resp. $-\pi_S$ (post side).

### Parametric VaR

For the computation of the parametric, or variance-covariance VaR, we
rely on a second order sensitivity-based P&L approximation

$$\begin{aligned}
\label{taylorPl2}
  \pi_S & = & \sum_{i=1}^n D^i_{T_i}\,V\cdot Y_i
        + \frac{1}{2} \sum_{i,j=1}^n D^{i,j}_{T_i,T_j}\,V\cdot Y_i\cdot Y_j
\end{aligned}$$

with

- portfolio value $V$

- random variables $Y_i$ representing risk factor returns; these are
  assumed to be multivariate normally distributed with zero mean and
  covariance matrix matrix
  $C = \{ \rho_{i,k} \sigma_i \sigma_k \}_{i,k}$, where $\sigma_i$
  denotes the standard deviation of $Y_i$; covariance matrix $C$ may be
  estimated using the Pearson estimator on historical return data
  $\{ r_i(j) \}_{i,j}$. Since the raw estimate might not be positive
  semidefinite, we apply a salvaging algorithm to ensure this property,
  which basically replaces negative Eigenvalues by zero and renormalises
  the resulting matrix, see ;

- first or second order derivative operators $D$, depending on the
  market factor specific shift type $T_i \in \{ A,R,L \}$ (absolute
  shifts, relative shifts, absolute log-shifts), i.e. $$\begin{aligned}
  \label{derivs2}
    D^i_A \,V(x) &=& \frac{\partial V(x)}{\partial x_i} \\
    D^i_R \,V(x) = D^i_L f(x) &=& x_i\frac{\partial V(x)}{\partial x_i}
  \end{aligned}$$ and using the short hand notation
  $$D^{i,j}_{T_i,T_j} V(x) = D^i_{T_i} D^j_{T_j} V(x)$$ In ORE, these
  first and second order sensitivities are computed as finite difference
  approximations (“bump and revalue”).

To approximate the $p$-quantile of $\pi_S$ in
<a href="#taylorPl2" data-reference-type="eqref"
data-reference="taylorPl2">[taylorPl2]</a> ORE offers the techniques
outlined below.

### Delta Gamma Normal Approximation

The distribution of <a href="#taylorPl2" data-reference-type="eqref"
data-reference="taylorPl2">[taylorPl2]</a> is non-normal due to the
second order terms. The delta gamma normal approximation in ORE computes
mean $m$ and variance $v$ of the portfolio value change $\pi_S$
(discarding moments higher than two) following and provides a simple VaR
estimate $$VaR = m + N^{-1}(q)\,\sqrt{v}$$ for the desired quantile $q$
($N$ is the cumulative standard normal distribution). Omitting the
second order terms in <a href="#taylorPl2" data-reference-type="eqref"
data-reference="taylorPl2">[taylorPl2]</a> yields the delta normal
approximation.

### Cornish-Fisher Expansion

The first four moments of the distribution of $\pi_S$ in
<a href="#taylorPl2" data-reference-type="eqref"
data-reference="taylorPl2">[taylorPl2]</a> can be computed in closed
form using the covariance matrix $C$ and the sensitivities of first and
second order $D_i$ and $D_{i,k}$, see e.g. . Once these moments are
known, an approximation to the true quantile of $\pi_S$ can be computed
using the Cornish-Fisher expansion, see also \[7\], which in practice
often gives a decent approximation of the true value, but may also show
bigger differences in certain configurations.

### Saddlepoint Approximation

Another approximation of the true quantile of $\pi_S$ can be computed
using the Saddlepoint approximation using results from and . This method
typically produces more accurate results than the Cornish-Fisher method,
while still being fast to evaluate.

### Monte Carlo Simulation

By simulating a large number of realisations of the return vector
$Y=\{ Y_i \}_i$ and computing the corresponding realisations of $\pi_S$
in <a href="#taylorPl2" data-reference-type="eqref"
data-reference="taylorPl2">[taylorPl2]</a> we can estimate the desired
quantile as the quantile of the empirical distribution generated by the
Monte Carlo samples. Apart from the Monte Carlo Error no approximation
is involved in this method, so that albeit slow it is well suited to
produce values against which any other approximate approaches can be
tested. Numerically, the simulation is implemented using a Cholesky
Decomposition of the covariance matrix $C$ in conjunction with a pseudo
random number generator (Mersenne Twister) and an implementation of the
inverse cumulative normal distribution to transform $U[0,1]$ variates to
$N(0,1)$ variates.

[^1]: smile strike spreads must match simulation market configuration

[^2]: smile is shifted in parallel<span id="sensismileparallel"
    label="sensismileparallel"></span>

[^3]: result sensitivities are aggregated on ATM<span id="sensiaggatm"
    label="sensiaggatm"></span>

[^4]: Equity is in turn managed and most likely invested into financial
    instruments other than a Bank account

[^5]: i.e. we view $\nu$ as a function of the second argument of
    $a_{T_i}$ in <a href="#histReturns" data-reference-type="ref"
    data-reference="histReturns">[histReturns]</a>

---

# Exposure Simulation

## Risk Factor Evolution

### Cross Asset Model

ORE applies the cross asset model described in detail in to evolve the
market through time. So far the evolution model in ORE supports IR and
FX risk factors for any number of currencies, Equity and Inflation as
well as Credit. Extensions to full simulation of Commodity is planned.  
The Cross Asset Model is based on the Linear Gauss Markov model (LGM)
for interest rates, lognormal FX and equity processes, Dodgson-Kainth
model for inflation, LGM or Extended Cox-Ingersoll-Ross model (CIR++)
for credit, and a single-factor log-normal model for commodity curves.
We identify a single *domestic* currency; its LGM process, which is
labelled $z_0$; and a set of $n$ foreign currencies with associated LGM
processes that are labelled $z_i$, $i=1,\dots,n$.

We denote the equity spot price processes with state variables $s_j$ and
the index of the denominating currency for the equity process as
$\phi(j)$. The dividend yield corresponding to each equity process $s_j$
is denoted by $q_j$.

Following , 13.27 - 13.29 we write the inflation processes in the
domestic LGM measure with state variables $z_{I,k}$ and $y_{I,k}$ for
$k=1,\ldots,K$ and the credit processes in the domestic LGM measure with
state variables $z_{C,k}$ and $y_{C,k}$ for $k=1,\ldots,K$ and single
factor (drift-free) commodity processes in the domestic LGM measure with
state variables $c_l$ for $l=1,\ldots,L$. If we consider $n$ foreign
exchange rates for converting foreign currency amounts into the single
domestic currency by multiplication, $x_i$, $i=1,\dots,n$, then the
cross asset model is given by the system of SDEs $$\begin{aligned}
dz_0 &=& \alpha_0\,dW_0^z \\
dz_i &=& \gamma_i\,dt + \alpha_i\,dW_i^z,  \qquad i>0 \\
\frac{d x_i}{x_i} &=& \mu_i\, dt + \sigma_i\,dW_i^x, \qquad i > 0 \\
\frac{d s_j}{s_j} &=& \mu_j^S\, dt + \sigma_j^S\,dW_j^S \\
dz_{I,k} &=& \alpha_{I,k}(t)dW_k^I \\
dy_{I,k} &=& \alpha_{I,k}(t)H_{I,k}(t)dW_k^I \\
dz_{C,k} &=& \alpha_{C,k}(t)dW_k^C \\
dy_{C,k} &=& H_{C,k}(t)\alpha_{C,k}(t)dW_k^C \\ 
dc_{l} &=& \mu_l^c dt + \sigma^c_l e^{\kappa^c t}dW_l^c \\ \\
\gamma_i &=&
-\alpha_i^2\,H_i -\rho_{ii}^{zx}\,\sigma_i\,\alpha_i + \rho_{i0}^{zz}\,\alpha_i\,\alpha_0\,H_0\\
\mu_i &=& r_0 - r_i + \rho_{0i}^{zx}\,\alpha_0\,H_0\,\sigma_i\\
\mu_j^S &=& (r_{\phi(j)}(t) - q_j(t) + \rho_{0j}^{zs} \alpha_0 H_0 \sigma_j^S - \epsilon_{\phi(j)}
\rho_{j \phi(j)}^{sx}\sigma_j^S \sigma_{\phi(j)}) \\
r_i &=& f_i(0,t) + z_i(t)\,H'_i(t) + \zeta_i(t)\,H_i(t)\,H'_i(t),
\quad \zeta_i(t) = \int_0^t \alpha_i^2(s)\,ds  \\ 
\mu^c_l &=&  \rho_{0c}^{zl} \alpha_0 H_0 \sigma_l^c e^{\kappa_l^ct} - \epsilon_{\phi(l)}
\rho_{l \phi(l)}^{cx} \sigma^x_{\phi(l)} \sigma_l^c  e^{\kappa_l^ct}   \\ \\
dW^\alpha_a\,dW^\beta_b &=& \rho^{\alpha\beta}_{ij}\,dt, \qquad \alpha, \beta \in \{z, x, S, I, C, c\}, \qquad a, b \text{
                              suitable indices }
%\zeta_i(t) &=& \int_0^t \alpha_i^2(s)\,ds,
%\qquad H_i(t) = \int_0^t e^{-\beta_i(s)} \,ds \\
%\beta_i(t) &=& \int_0^t \lambda_i(s)\,ds,
%\qquad \alpha_i(t) = \sigma_i^{HW}(t)\,e^{\beta(t)} \\
\end{aligned}$$ where we have dropped time dependencies for readability,
$f_i(0,t)$ is the instantaneous forward curve in currency $i$, and
$\epsilon_i$ is an indicator such that $\epsilon_i = 1 - \delta_{0i}$,
where $\delta$ is the Kronecker delta.

Parameters $H_i(t)$ and $\alpha_i(t)$ (or alternatively $\zeta_i(t)$)
are LGM model parameters which determine, together with the stochastic
factor $z_i(t)$, the evolution of numeraire and zero bond prices in the
LGM model: $$\begin{aligned}
N(t) &= \frac{1}{P(0,t)}\exp\left\{H_t\, z_t + \frac{1}{2}H^2_t\,\zeta_t \right\}
\label{lgm1f_numeraire} \\
P(t,T,z_t)
&= \frac{P(0,T)}{P(0,t)}\:\exp\left\{ -(H_T-H_t)\,z_t - \frac{1}{2} \left(H^2_T-H^2_t\right)\,\zeta_t\right\}.
\label{lgm1f_zerobond}
\end{aligned}$$

Note that the LGM model is closely related to the Hull-White model in
T-forward measure .

The parameters $H_{I,k}(t)$ and $\alpha_{I,k}(t)$ determine together
with the factors $z_{I,k}(t), y_{I,k}(t)$ the evolution of the spot
Index $I(t)$ and the forward index $\hat{I}(t,T) = P_I(t,T) / P_n(t,T)$
defined as the ratio of the inflation linked zero bond and the nominal
zero bond,

$$\begin{aligned}
  \hat{I}(t,T) &=& \frac{\hat{I}(0,T)}{\hat{I}(0,t)} e^{(H_{I,k}(T)-H_{I,k}(t))z_{I,k}(t)+\tilde{V}(t,T)} \\
  I(t) &=& I(0) \hat{I}(0,t)e^{H_{I,k}(t)z_{I,k}(t)-y_{I,k}(t)-V(0,t)}
\end{aligned}$$

with, in case of domestic currency inflation,

$$\begin{aligned}
  V(t,T) &=& \frac{1}{2} \int_t^T (H_{I,k}(T)-H_{I,k}(s))^2 \alpha_{I,k}^2(s) ds \\
         & & - \rho^{zI}_{0,k} H_0(T) \int_t^T (H_{I,k}(t)-H_{I,k}(s))\alpha_0(s)\alpha_{I,k}(s)ds \\
  \tilde{V}(t,T) &=& V(t,T) - V(0,T) -V(0,t) \\
         &=& -\frac{1}{2}(H_{I,k}^2(T)-H_{I,k}^2(t))\zeta_{I,k}(t,0) \\
         & & +(H_{I,k}(T)-H_{I,k}(t)) \zeta_{I,k}(t,1) \\
         & & +(H_0(T)H_{I,k}(T) - H_0(t)H_{I,k}(t))\zeta_{0I}(t,0) \\
         & & -(H_0(T)-H_0(t))\zeta_{0I}(t,1) \\
  V(0,t) &=& \frac{1}{2}H_{I,k}^2(t)\zeta_{I,k}(t,0)-H_{I,k}(t)\zeta_{I,k}(t,1)+\frac{1}{2}\zeta_{I,k}(t,2) \\
         & & -H_0(t)H_{I,k}(t)\zeta_{0I}(t,0)+H_0(t)\zeta_{0I}(t,1) \\
  \zeta_{I,k}(t,k) &=& \int_0^t H_{I,k}^k(s)\alpha_{I,k}^2(s) ds \\
  \zeta_{0I}(t,k) &=& \rho^{zI}_{0,k}\int_0^t H_{I,k}^k(t) \alpha_0(s) \alpha_{I,k}(s) ds
\end{aligned}$$

and for foreign currency inflation in currency $i>0$, with

$$\begin{aligned}
  \tilde{V}(t,T) &=& V(t,T) -V(0,T) + V(0,T)
\end{aligned}$$

and

$$\begin{aligned}
  V(t,T) &=& \frac{1}{2}\int_t^T (H_{I,k}(T)-H_{I,k}(s))^2 \alpha_{I,k}(s) ds \\
  & & -\rho^{zI}_{0,k} \int_t^T H_0(s)\alpha_0(s)(H_{I,k}(T)-H_{I,k}(s)\alpha_{I,k}(s)) ds \\
  & & -\rho^{zI}_{i,k} \int_t^T (H_i(T)-H_i(s))\alpha_i(s)(H_{I,k}(T)-H_{I,k}(s))\alpha_{I,k}(s) ds \\
  & & +\rho^{xI}_{i,k} \int_t^T \sigma_i(s)(H_{I,k}(T)-H_{I,k}(s))\alpha_{I,k}(s) ds
\end{aligned}$$

#### Commodity

Each commodity component models the commodity price curve as
$$\begin{aligned}
\frac{dF(t,T)}{F(t,T)} &=& \alpha(T) \sigma\,e^{-\kappa\,(T-t)}\, dW(t)  \label{gabillon1f}
\end{aligned}$$ where $\alpha(T) : = \exp( b(T))$ is the time dependent
[^1] multiplier to capture seasonality effect observed in the market for
both commodity future price curves and option volatilities. This model
is a single-factor version of the Gabillon (1991) model that is e.g.
described in . It can also be seen as the Schwartz (1997) model
formulated in terms of forward curve dynamics. The extension to the full
Gabillon model with two factors and time-dependent multiplier[^2]
$$\begin{aligned}
\frac{dF(t,T)}{F(t,T)} &=& \alpha(t)\,
\left( \sigma_S \,e^{-\kappa\,(T-t)}\, dW_S(t) + \sigma_L\,\left(1-e^{-\kappa\,(T-t)}\right)\,dW_L(t)\right) \label{gabillon2f}
\end{aligned}$$ for richer dynamics of the curve and accurate
calibration to options will follow.

The commodity components’ Wiener processes can be correlated. However,
the integration of commodity components into the overall CAM assumes
zero correlations between commodities and non-commodity drivers for the
time being.

To propagate the one-factor model, we can use an artificial
(Ornstein-Uhlenbeck) spot price process $$\begin{aligned}
dX(t) &= -\kappa\,X(t)\,dt + \sigma(t)\,dW(t), \qquad X(0)=0\\
X(t) &= X(s)\,e^{-\kappa(t-s)}+ \int_s^t \sigma\,e^{-\kappa(t-u)}\, dW(u)
\end{aligned}$$ with $$\begin{aligned}
F(t,T) &= F(0,T) \:\exp\left( X(t)\,e^{b(T)-\kappa\,(T-t)} - \frac{1}{2}\,(V(0,T)-V(t,T))  \right) \\
V(t,T) &= e^{2 (b(T)-\kappa T)}\int_t^T\sigma^2\:e^{2\kappa u}\,du.
\end{aligned}$$ Note that $$\V[\ln F(T,T)] = \V[X(T)]$$ is the variance
that is used in the pricing of a Futures Option which in turn is used in
the calibration of the Schwartz model.

Alternatively, one can use the drift-free state variable
$Y(t)=e^{\kappa t} X(t)$ with $$\begin{aligned}
dY(t) &= \sigma \: e^{\kappa \, t} \, dW(t).
\end{aligned}$$ Both choices of state dynamics are possible in ORE.

### Analytical Moments of the Risk Factor Evolution Model

We follow , chapter 16. The expectation of the interest rate process
$z_i$ conditional on $\mathcal{F}_{t_0}$ at $t_0+\Delta t$ is

$$\begin{aligned}
  \mathbb{E}_{t_0}[z_i(t_0+\Delta t)] &=& z_i(t_0) + \mathbb{E}_{t_0}[\Delta z_i],
  \qquad\mbox{with}\quad \Delta z_i = z_i(t_0+\Delta t) - z_i(t_0) \\
  &=& z_i(t_0) -\int_{t_0}^{t_0+\Delta t} H^z_i\,(\alpha^z_i)^2\,du + \rho^{zz}_{0i} \int_{t_0}^{t_0+\Delta t}
  H^z_0\,\alpha^z_0\,\alpha^z_i\,du \\
  & & - \epsilon_i  \rho^{zx}_{ii}\int_{t_0}^{t_0+\Delta t} \sigma_i^x\,\alpha^z_i\,du
\end{aligned}$$

where $\epsilon_i$ is zero for $i=0$ (domestic currency) and one
otherwise.

The expectation of the FX process $x_i$ conditional on
$\mathcal{F}_{t_0}$ at $t_0+\Delta t$ is

$$\begin{aligned}
  \mathbb{E}_{t_0}[\ln x_i(t_0+\Delta t)] &=& \ln x_i(t_0) +  \mathbb{E}_{t_0}[\Delta \ln x_i],
  \qquad\mbox{with}\quad \Delta \ln x_i = \ln x_i(t_0+\Delta t) - \ln x_i(t_0) \\
  &=& \ln x_i(t_0) + \left(H^z_0(t)-H^z_0(s)\right) z_0(s) -\left(H^z_i(t)-H^z_i(s)\right)z_i(s)\\
  &&+ \ln \left( \frac{P^n_0(0,s)}{P^n_0(0,t)} \frac{P^n_i(0,t)}{P^n_i(0,s)}\right) \\
  && - \frac12 \int_s^t (\sigma^x_i)^2\,du \\
  &&+\frac12 \left((H^z_0(t))^2 \zeta^z_0(t) -  (H^z_0(s))^2 \zeta^z_0(s)- \int_s^t (H^z_0)^2
  (\alpha^z_0)^2\,du\right)\\
  &&-\frac12 \left((H^z_i(t))^2 \zeta^z_i(t) -  (H^z_i(s))^2 \zeta^z_i(s)-\int_s^t (H^z_i)^2 (\alpha^z_i)^2\,du
  \right)\\
  && + \rho^{zx}_{0i} \int_s^t H^z_0\, \alpha^z_0\, \sigma^x_i\,du \\
  &&  - \int_s^t \left(H^z_i(t)-H^z_i\right)\gamma_i \,du, \qquad\mbox{with}\quad s = t_0, \quad t = t_0+\Delta t
\end{aligned}$$

with

$$\begin{aligned}
  \gamma_i = -H^z_i\,(\alpha^z_i)^2  + H^z_0\,\alpha^z_0\,\alpha^z_i\,\rho^{zz}_{0i} - \sigma_i^x\,\alpha^z_i\,
  \rho^{zx}_{ii}
\end{aligned}$$

The expectation of the Inflation processes $z_{I,k}, y_{I,k}$
conditional on $\mathcal{F}_{t_0}$ at any time $t>t_0$ is equal to
$z_{I,k}(t_0)$ resp. $y_{I,k}(t_0)$ since both processes are drift free.

The expectation of the equity processes $s_j$ conditional on
$\mathcal{F}_{t_0}$ at $t_0+\Delta t$ is $$\begin{aligned}
\mathbb{E}_{t_0}[\ln s_j(t_0+\Delta t)] &=& \ln s_j(t_0) +  \mathbb{E}_{t_0}[\Delta \ln s_j],
\qquad\mbox{with}\quad \Delta \ln s_j = \ln s_j(t_0+\Delta t) - \ln s_j(t_0) \\
&=& \ln s_j(t_0) +  \ln \left[\frac{P_{\phi(j)}(0,s)}{P_{\phi(j)}(0,t)} \right] - \int_s^t 
q_j(u) 
du - \frac{1}{2} \int_s^t \sigma_{j}^{S}(u) \sigma_{j}^{S}(u) du\\
&&
+\rho_{0j}^{zs} \int_s^t \alpha_0(u) H_0(u) \sigma_j^S(u) du
- \epsilon_{\phi(j)} \rho_{j \phi(j)}^{sx} \int_s^t \sigma_j^S (u)\sigma_{\phi(j)}(u) du\\
&&+\frac{1}{2} \left( H_{\phi(j)}^2(t) \zeta_{\phi(j)}(t) - H_{\phi(j)}^2(s) \zeta_{\phi(j)}(s)
- \int_s^t H_{\phi(j)}^2(u) \alpha_{\phi(j)}^2(u) du \right)\\
&&  + (H_{\phi(j)}(t) - H_{\phi(j)}(s)) z_{\phi(j)}(s) 
+\epsilon_{\phi(j)} \int_s^t \gamma_{\phi(j)} (u) (H_{\phi(j)}(t) - H_{\phi(j)}(u)) du\\
\end{aligned}$$

The expectation of the commodity process $c_l$ conditional on
$\mathcal{F}_{t_0}$ at $t_0+\Delta t$ is

$$\begin{aligned}
\mathbb{E}_{t_0}[c_l(t_0+\Delta t] = c_l(0) + \rho^{zc}_{0l } \int_{0}^t   H_0(u) \alpha_0(u)\sigma_l^c  e^{\kappa_l^c u}  du - \epsilon_{\phi(l)} \rho^{cx}_{l\phi(l)}   \int_0^t  \sigma^x_{\phi(l)}(u) \sigma^c_l e^{\kappa_l^c u} du
\end{aligned}$$

The IR-IR covariance over the interval $[s,t] := [t_0, t_0+\Delta t]$
(conditional on $\mathcal{F}_{t_0}$) is

$$\begin{aligned}
      \mathrm{Cov} [\Delta z_a, \Delta \ln x_b] &=& \rho^{zz}_{0a}\int_s^t \left(H^z_0(t)-H^z_0\right)
  \alpha^z_0\,\alpha^z_a\,du \nonumber\\
      &&- \rho^{zz}_{ab}\int_s^t \alpha^z_a \left(H^z_b(t)-H^z_b\right) \alpha^z_b \,du \nonumber\\
      &&+\rho^{zx}_{ab}\int_s^t \alpha^z_a \, \sigma^x_b \,du.
\end{aligned}$$

The IR-FX covariance over the interval $[s,t] := [t_0, t_0+\Delta t]$
(conditional on $\mathcal{F}_{t_0}$) is

$$\begin{aligned}
      \mathrm{Cov} [\Delta z_a, \Delta \ln x_b] &=& \rho^{zz}_{0a}\int_s^t \left(H^z_0(t)-H^z_0\right)
  \alpha^z_0\,\alpha^z_a\,du \nonumber\\
      &&- \rho^{zz}_{ab}\int_s^t \alpha^z_a \left(H^z_b(t)-H^z_b\right) \alpha^z_b \,du \nonumber\\
      &&+\rho^{zx}_{ab}\int_s^t \alpha^z_a \, \sigma^x_b \,du.
\end{aligned}$$

The FX-FX covariance over the interval $[s,t] := [t_0, t_0+\Delta t]$
(conditional on $\mathcal{F}_{t_0}$) is

$$\begin{aligned}
      \mathrm{Cov}[\Delta \ln x_a, \Delta \ln x_b] &=&
      \int_s^t \left(H^z_0(t)-H^z_0\right)^2 (\alpha_0^z)^2\,du \nonumber\\
      && -\rho^{zz}_{0a} \int_s^t \left(H^z_a(t)-H^z_a\right) \alpha_a^z\left(H^z_0(t)-H^z_0\right) \alpha_0^z\,du
  \nonumber\\
      &&- \rho^{zz}_{0b}\int_s^t \left(H^z_0(t)-H^z_0\right)\alpha_0^z \left(H^z_b(t)-H^z_b\right)\alpha_b^z\,du
  \nonumber\\
      &&+ \rho^{zx}_{0b}\int_s^t \left(H^z_0(t)-H^z_0\right)\alpha_0^z \sigma^x_b\,du \nonumber\\
      &&+ \rho^{zx}_{0a}\int_s^t \left(H^z_0(t)-H^z_0\right)\alpha_0^z\,\sigma^x_a\,du \nonumber\\
      &&- \rho^{zx}_{ab}\int_s^t \left(H^z_a(t)-H^z_a\right)\alpha_a^z \sigma^x_b,du\nonumber\\
      &&- \rho^{zx}_{ba}\int_s^t \left(H^z_b(t)-H^z_b\right)\alpha_b^z\,\sigma^x_a\, du \nonumber\\
      &&+ \rho^{zz}_{ab}\int_s^t \left(H^z_a(t)-H^z_a\right)\alpha_a^z \left(H^z_b(t)-H^z_b\right)\alpha_b^z\,du
  \nonumber\\
      &&+ \rho^{xx}_{ab}\int_s^t\sigma^x_a\,\sigma^x_b \,du
\end{aligned}$$

The IR-INF covariance over the interval $[s,t] := [t_0, t_0+\Delta t]$
(conditional on $\mathcal{F}_{t_0}$) is

$$\begin{aligned}
  \mathrm{Cov}[ \Delta z_a, \Delta z_{I,b} ] & = & \rho_{ab}^{zI} \int_s^t \alpha_a(s) \alpha_{I,b}(s) ds \\
  \mathrm{Cov}[ \Delta z_a, \Delta y_{I,b} ] & = & \rho_{ab}^{zI} \int_s^t \alpha_a(s) H_{I,b}(s) \alpha_{I,b}(s) ds
\end{aligned}$$

The FX-INF covariance over the interval $[s,t] := [t_0, t_0+\Delta t]$
(conditional on $\mathcal{F}_{t_0}$) is

$$\begin{aligned}
  \mathrm{Cov}[ \Delta x_a, \Delta z_{I,b} ] & = & \rho_{0b}^{zI} \int_s^t \alpha_0(s) (H_0(t)-H_0(s)) \alpha_{I,b}(s) ds \\
                                             & & -\rho_{ab}^{zI} \int_s^t \alpha_a(s)(H_a(t)-H_a(s))\alpha_{I,b}(s) ds \\
                                             & & +\rho_{ab}^{xI}\int_s^t \sigma_a(s) \alpha_{I,b}(s) ds \\
  \mathrm{Cov}[ \Delta x_a, \Delta y_{I,b} ] & = & \rho_{0b}^{zI} \int_s^t \alpha_0(s) (H_0(t)-H_0(s)) H_{I,b}(s)\alpha_{I,b}(s) ds \\
                                             & & -\rho_{ab}^{zI} \int_s^t \alpha_a(s)(H_a(t)-H_a(s))H_{I,b}(s)\alpha_{I,b}(s) ds \\
                                             & & +\rho_{ab}^{xI}\int_s^t \sigma_a(s) H_{I,b}(s)\alpha_{I,b}(s) ds
\end{aligned}$$

The INF-INF covariance over the interval $[s,t] := [t_0, t_0+\Delta t]$
(conditional on $\mathcal{F}_{t_0}$) is

$$\begin{aligned}
  \mathrm{Cov}[ \Delta z_{I,a}, \Delta z_{I,b} ] & = & \rho_{ab}^{II} \int_s^t \alpha_{I,a}(s) \alpha_{I,b}(s) ds \\
  \mathrm{Cov}[ \Delta z_{I,a}, \Delta y_{I,b} ] & = & \rho_{ab}^{II} \int_s^t \alpha_{I,a}(s) H_{I,b}(s)
                                                       \alpha_{I,b}(s) ds \\
  \mathrm{Cov}[ \Delta y_{I,a}, \Delta y_{I,b} ] & = & \rho_{ab}^{II} \int_s^t H_{I,a}(s) \alpha_{I,a}(s) H_{I,b}(s) \alpha_{I,b}(s) ds
\end{aligned}$$

The equity/equity covariance over the interval
$[s,t] := [t_0, t_0+\Delta t]$ (conditional on $\mathcal{F}_{t_0}$) is
$$\begin{aligned}
    Cov \left[\Delta ln[s_i], \Delta ln[s_j] \right] &=&
    \rho_{\phi(i) \phi(j)}^{zz}\int_s^t (H_{\phi(i)} (t) - H_{\phi(i)} (u)) (H_{\phi(j)} (t)\\
    && - H_{\phi(j)} (u)) \alpha_{\phi(i)}(u) \alpha_{\phi(j)}(u) du\\
    &&+ \rho_{\phi(i) j}^{zs} \int_s^t (H_{\phi(i)} (t) - H_{\phi(i)} (u)) \alpha_{\phi(i)}(u) \sigma_j^S(u) du\\
    &&+ \rho_{\phi(j) i}^{zs} \int_s^t (H_{\phi(j)} (t) - H_{\phi(j)} (u)) \alpha_{\phi(j)}(u) \sigma_i^S(u) du\\
    &&+ \rho_{ij}^{ss} \int_s^t \sigma_i^S(u) \sigma_j^S(u) du\\
\end{aligned}$$

The equity/FX covariance over the interval
$[s,t] := [t_0, t_0+\Delta t]$ (conditional on $\mathcal{F}_{t_0}$) is
$$\begin{aligned}
    Cov \left[\Delta ln[s_i], \Delta ln[x_j] \right] &=&
    \rho_{\phi(i)0}^{zz} \int_s^t (H_{\phi(i)} (t) - H_{\phi(i)} (u)) (H_0 (t) - H_0 (u)) \alpha_{\phi(i)}(u) 
    \alpha_0(u) 
    du\\
    && - \rho_{\phi(i)j}^{zz} \int_s^t (H_{\phi(i)} (t) - H_{\phi(i)} (u)) (H_j (t) - H_j (u)) \alpha_{\phi(i)} 
    (u)\alpha_j(u) du\\
    && + \rho_{\phi(i)j}^{zx} \int_s^t (H_{\phi(i)} (t) - H_{\phi(i)} (u)) \alpha_{\phi(i)} (u) \sigma_j(u) du\\
    &&+ \rho_{i0}^{sz} \int_s^t (H_0 (t) - H_0 (u)) \alpha_0 (u) \sigma_i^S(u) du\\
    &&- \rho_{ij}^{sz} \int_s^t (H_j (t) - H_j (u)) \alpha_j (u) \sigma_i^S(u) du\\
    &&+ \rho_{ij}^{sx} \int_s^t \sigma_i^S(u) \sigma_j(u) du\\
\end{aligned}$$

The equity/IR covariance over the interval
$[s,t] := [t_0, t_0+\Delta t]$ (conditional on $\mathcal{F}_{t_0}$) is
$$\begin{aligned}
    Cov \left[\Delta ln[s_i], \Delta z_j \right] &=&
    \rho_{\phi(i)j}^{zz} \int_s^t (H_{\phi(i)} (t) - H_{\phi(i)} (u)) \alpha_{\phi(i)} (u) \alpha_j (u) du\\
    &&+ \rho_{ij}^{sz} \int_s^t \sigma_i^S (u) \alpha_j (u) du\\
\end{aligned}$$

The equity/inflation covariances over the interval
$[s,t] := [t_0, t_0+\Delta t]$ (conditional on $\mathcal{F}_{t_0}$) are
as follows: $$\begin{aligned}
    Cov \left[\Delta ln[s_i], \Delta z_{I,j} \right] &=&
    \rho_{\phi(i)j}^{zI} \int_s^t (H_{\phi(i)} (t) - H_{\phi(i)} (u)) \alpha_{\phi(i)} (u) \alpha_{I,j} (u) du\\
    &&+ \rho_{ij}^{sI} \int_s^t \sigma_i^S (u) \alpha_{I,j} (u) du\\    
    Cov \left[\Delta ln[s_i], \Delta y_{I,j} \right] &=&
    \rho_{\phi(i)j}^{zI} \int_s^t (H_{\phi(i)} (t) - H_{\phi(i)} (u)) \alpha_{\phi(i)} (u) H_{I,j} (u) \alpha_{I,j} (u) du\\
    &&+ \rho_{ij}^{sI} \int_s^t \sigma_i^S (u) H_{I,j} (u) \alpha_{I,j} (u) du\\
\end{aligned}$$

The expectation of the Credit processes $z_{C,k}, y_{C,k}$ conditional
on $\mathcal{F}_{t_0}$ at any time $t>t_0$ is equal to $z_{C,k}(t_0)$
resp. $y_{C,k}(t_0)$ since both processes are drift free.

The credit/credit covariances over the interval
$[s,t] := [t_0, t_0+\Delta t]$ (conditional on $\mathcal{F}_{t_0}$) are
as follows: $$\begin{aligned}
    Cov \left[\Delta z_{C,a}, \Delta z_{C,b} \right] &=&
    \rho_{ab}^{CC}\int_s^t \alpha_{C, a}(u) \alpha_{C, b}(u) du\\
  Cov \left[\Delta z_{C,a}, \Delta y_{C,b} \right] &=&
    \rho_{ab}^{CC}\int_s^t \alpha_{C, a}(u) H_{C,b}(u) \alpha_{C, b}(u) du\\
  Cov \left[\Delta y_{C,a}, \Delta y_{C,b} \right] &=&
    \rho_{ab}^{CC}\int_s^t \alpha_{C, a}(u) H_{C,a}(u) \alpha_{C, b}(u) H_{C,b}(u) du\\
\end{aligned}$$

The IR/credit covariances over the interval
$[s,t] := [t_0, t_0+\Delta t]$ (conditional on $\mathcal{F}_{t_0}$) are
as follows: $$\begin{aligned}
    Cov \left[\Delta z_a, \Delta z_{C,b} \right] &=&
    \rho_{ab}^{zC}\int_s^t \alpha_a(u) \alpha_{C, b}(u) du\\
  Cov \left[\Delta z_a, \Delta y_{C,b} \right] &=&
    \rho_{ab}^{zC}\int_s^t \alpha_a(u) H_{C,b}(u) \alpha_{C, b}(u) du\\
\end{aligned}$$

The FX/credit covariances over the interval
$[s,t] := [t_0, t_0+\Delta t]$ (conditional on $\mathcal{F}_{t_0}$) are
as follows: $$\begin{aligned}
  \mathrm{Cov}[ \Delta x_a, \Delta z_{C,b} ] & = & \rho_{0b}^{zC} \int_s^t \alpha_0(s) (H_0(t)-H_0(s)) \alpha_{C,b}(s) ds \\
                                             & & -\rho_{ab}^{zC} \int_s^t \alpha_a(s)(H_a(t)-H_a(s))\alpha_{C,b}(s) ds \\
                                             & & +\rho_{ab}^{xC}\int_s^t \sigma_a(s) \alpha_{C,b}(s) ds \\
  \mathrm{Cov}[ \Delta x_a, \Delta y_{C,b} ] & = & \rho_{0b}^{zC} \int_s^t \alpha_0(s) (H_0(t)-H_0(s)) H_{C,b}(s)\alpha_{C,b}(s) ds \\
                                             & & -\rho_{ab}^{zC} \int_s^t \alpha_a(s)(H_a(t)-H_a(s))H_{C,b}(s)\alpha_{C,b}(s) ds \\
                                             & & +\rho_{ab}^{xC}\int_s^t \sigma_a(s) H_{C,b}(s)\alpha_{C,b}(s) ds
\end{aligned}$$

The inflation/credit covariances over the interval
$[s,t] := [t_0, t_0+\Delta t]$ (conditional on $\mathcal{F}_{t_0}$) are
as follows: $$\begin{aligned}
  \mathrm{Cov}[ \Delta z_{I,a}, \Delta z_{C,b} ] &=&
  \rho_{ab}^{IC}\int_s^t \alpha_{I,a} \alpha_{C,b}(u) du\\
  \mathrm{Cov}[ \Delta z_{I,a}, \Delta y_{C,b} ] &=&
  \rho_{ab}^{IC}\int_s^t \alpha_{I,a} H_{C,b}(u) \alpha_{C,b}(u) du\\
  \mathrm{Cov}[ \Delta y_{I,a}, \Delta z_{C,b} ] &=&
  \rho_{ab}^{IC}\int_s^t \alpha_{I,a} H_{I,a}(u) \alpha_{C,b}(u) du\\
  \mathrm{Cov}[ \Delta y_{I,a}, \Delta y_{C,b} ] &=&
  \rho_{ab}^{IC}\int_s^t \alpha_{I,a} H_{I,a}(u) \alpha_{C,b}(u) H_{C,b}(u) du\\
\end{aligned}$$

The equity/credit covariances over the interval
$[s,t] := [t_0, t_0+\Delta t]$ (conditional on $\mathcal{F}_{t_0}$) are
as follows: $$\begin{aligned}
    Cov \left[\Delta ln[s_i], \Delta z_{C,j} \right] &=&
    \rho_{\phi(i)j}^{zC} \int_s^t (H_{\phi(i)} (t) - H_{\phi(i)} (u)) \alpha_{\phi(i)} (u) \alpha_{C,j} (u) du\\
    &&+ \rho_{ij}^{sC} \int_s^t \sigma_i^S (u) \alpha_{C,j} (u) du\\    
    Cov \left[\Delta ln[s_i], \Delta y_{C,j} \right] &=&
    \rho_{\phi(i)j}^{zC} \int_s^t (H_{\phi(i)} (t) - H_{\phi(i)} (u)) \alpha_{\phi(i)} (u) H_{C,j} (u) \alpha_{C,j} (u) du\\
    &&+ \rho_{ij}^{sC} \int_s^t \sigma_i^S (u) H_{C,j} (u) \alpha_{C,j} (u) du\\
\end{aligned}$$

The commodity/commodity covariance over the interval
$[s,t] := [t_0, t_0+\Delta t]$ (conditional on $\mathcal{F}_{t_0}$) is
$$\begin{aligned}
    Cov \left[\Delta c_i, \Delta c_j \right] &=& \rho_{ij}^{cc} \int_s^t \sigma_i^c(u) e^{\kappa^c_i u } \sigma_j^c(u) e^{\kappa^c_j u } du\\
\end{aligned}$$

The commodity/IR covariance over the interval
$[s,t] := [t_0, t_0+\Delta t]$ (conditional on $\mathcal{F}_{t_0}$) is
$$\begin{aligned}
    Cov \left[\Delta c_i, \Delta z_j \right] &=& \rho_{ij}^{cz} \int_s^t \sigma_i^c e^{\kappa^c_i u} (u) \alpha_j (u) du\\
\end{aligned}$$

The commodity/FX covariance over the interval
$[s,t] := [t_0, t_0+\Delta t]$ (conditional on $\mathcal{F}_{t_0}$) is
$$\begin{aligned}
    Cov \left[\Delta c_i, \Delta ln[x_j] \right] &=& \rho_{i0}^{cz} \int_s^t (H_0 (t) - H_0 (u)) \alpha_0 (u) \sigma_i^c e^{\kappa^c_i u}  du\\
    &&- \rho_{ij}^{cz} \int_s^t (H_j (t) - H_j (u)) \alpha_j (u) \sigma_i^c e^{\kappa^c_i u}  du\\
    &&+ \rho_{ij}^{cx} \int_s^t \sigma_i^c e^{\kappa^c_i u} \sigma^x_j(u) du\\
\end{aligned}$$

The commodity/inflation covariances over the interval
$[s,t] := [t_0, t_0+\Delta t]$ (conditional on $\mathcal{F}_{t_0}$) are
as follows: $$\begin{aligned}
    Cov \left[\Delta c_i, \Delta z_{I,j} \right] &=& \rho_{ij}^{cI} \int_s^t \sigma_i^c e^{\kappa^c_i u } \alpha_{I,j} (u) du\\ 
    Cov \left[\Delta c_i, \Delta y_{I,j} \right] &=&\rho_{ij}^{cI} \int_s^t \sigma_i^c e^{\kappa^c_i u } H_{I,j} (u) \alpha_{I,j} (u) du\\
\end{aligned}$$

The commodity/credit covariances over the interval
$[s,t] := [t_0, t_0+\Delta t]$ (conditional on $\mathcal{F}_{t_0}$) are
as follows: $$\begin{aligned}
    Cov \left[\Delta c_i, \Delta z_{C,j} \right] &=& \rho_{ij}^{cC} \int_s^t \sigma_i^c e^{\kappa^c_i u } \alpha_{C,j} (u) du\\
    Cov \left[\Delta c_i, \Delta y_{C,j} \right] &=&\rho_{ij}^{cC} \int_s^t \sigma_i^c e^{\kappa^c_i u } H_{C,j} (u) \alpha_{C,j} (u) du\\
\end{aligned}$$

### Change of Measure

We can change measure from LGM to the T-Forward measure by applying a
shift transformation to the $H$ parameter of the domestic LGM process,
as explained in and shown in Example 12. This does not involve amending
the system of SDEs above.

In the following we show how to move from the LGM to the Bank Account
measure when we start with the Cross Asset Model in the LGM measure.
This description and the implementation in ORE is limited so far to the
cross currency case.

First note that the stochastic Bank Account (BA) can be written
$$\begin{aligned}
B(t) &= \frac{1}{P(0,t)}\exp\left(\int_0^t (H_t-H_s)\,\alpha_s\,dW_s^B + \frac{1}{2}\int_0^t (H_t-H_s)^2\,\alpha^2_s\,ds \right)
\end{aligned}$$ with Wiener processes in the BA measure. We can express
this in terms of the domestic LGM’s state variable $z(t)$ and an
auxiliary random variable $y(t)$ $$\begin{aligned}
B(t) &= \frac{1}{P(0,t)}\exp\left(H(t)\,z(t) - y(t) + \frac{1}{2} \left(H^2(t)\,\zeta_0(t) + \zeta_2(t)\right)\right)
\intertext{with}
dz(t) &= \alpha(t)\,dW^B(t) - H(t)\,\alpha^2(t)\,dt \\
dy(t) &= H(t)\,\alpha(t)\,dW^B(t) \\
\zeta_n(t) &= \int_0^t \alpha^2(s)\,H^n(s) \,ds
\end{aligned}$$ Note the drift of LGM state variable $z(t)$ in the BA
measure and the auxiliary state variable $y(t)$ which is driven by the
same Wiener process as $z(t)$. The instantaneous correlation of $dz$ and
$dy$ is one, but the terminal correlation of $z(t)$ and $y(t)$ is less
than one because of their different volatility functions. This is all we
need to switch measure to BA in a pure domestic currency case.

To change measure in the cross currency case we need to make changes to
the SDE beyond adding an auxiliary state variable $y$ and adding a drift
to the domestic LGM state. Let us write down the SDEs in the LGM and BA
measure with respective drift terms that ensure martingale properties.

SDE in the LGM measure $$\begin{aligned}
dz_0 &= \alpha_0\,dW_0^z \\
dz_i &= \left(-\alpha_i^2\,H_i -\rho_{ii}^{zx}\,\sigma_i\,\alpha_i + {\color{red} \rho_{i0}^{zz}\,\alpha_i\,\alpha_0\,H_0}\right)\,dt + \alpha_i\,dW_i^z \\
d\ln x_i &= \left(r_0 - r_i - \frac{1}{2}\sigma^2_i + {\color{red} \rho_{0i}^{zx}\,\alpha_0\,H_0\,\sigma_i} \right)\, dt + \sigma_i\,dW_i^x \\
\intertext{SDE in the BA measure}
{\color{blue}dy_0}  & = {\color{blue}\alpha_0\,H_0\,d\widetilde W_0^z} \\
dz_0 &= {\color{blue}-\alpha_0^2\,H_0\,dt} + \alpha_0\,d\widetilde W_0^z \\
dz_i &= \left(-\alpha_i^2\,H_i-\rho_{ii}^{zx}\,\sigma_i\,\alpha_i\right)\,dt + \alpha_i\,d\widetilde W_i^z \\
d\ln x_i &= \left(r_0 - r_i - \frac{1}{2}\sigma^2_i\right)\, dt + \sigma_i\,d\widetilde W_i^x,\qquad 
r_i = f_i(0,t) + z_i(t)\,H'_i(t) + \zeta_i(t)\,H_i(t)\,H'_i(t)
\end{aligned}$$

Blue terms are added, red terms are removed when moving from LGM to BA.

These drift term changes lead to the following changes in conditional
expectations $$\begin{aligned}
\E[\Delta y_0] =& 0 \\
\E[\Delta z_0] =& - {\color{blue}\int_s^t H_0\,\alpha_0^2\,du}  \\
\E[\Delta z_i] =& - \int_s^t H_i\,\alpha_i^2\,du 
  - \rho^{zx}_{ii}\int_s^t \sigma_i^x\,\alpha_i\,du
  + {\color{red}\rho^{zz}_{0i} \int_s^t H_0\,\alpha_0\,\alpha_i\,du } \\
\E[\Delta \ln x] 
  =& \left(H_0(t)-H_0(s)\right) z_0(s) -\left(H_i(t)-H_i(s)\right)\,z_i(s)\\
  &+ \ln \left( \frac{P^n_0(0,s)}{P^n_0(0,t)} \frac{P^n_i(0,t)}{P^n_i(0,s)}\right) \\
  & - \frac12 \int_s^t (\sigma^x_i)^2\,du \\
  &+\frac12 \left(H^2_0(t)\, \zeta_0(t) -  H^2_0(s) \,\zeta_0(s) - \int_s^t H_0^2 \alpha_0^2\,du\right)\\
  &-\frac12 \left(H^2_i(t) \,\zeta_i(t) -  H^2_i(s) \,\zeta_i(s) - \int_s^t H_i^2 \alpha_i^2\,du\right)\\
  & + {\color{red} \rho^{zx}_{0i} \int_s^t H_0\, \alpha_0\, \sigma^x_i\,du} \\
  &  - \int_s^t \left(H_i(t)-H_i\right)\gamma_i \,du \qquad\mbox{with}\qquad
  \gamma_i = -\alpha_i^2\,H_i -\rho_{ii}^{zx}\,\sigma_i\,\alpha_i + {\color{red}\rho_{i0}^{zz}\,\alpha_i\,\alpha_0\,H_0}   \\
  & + {\color{blue}\int_s^t \left(H_0(t)-H_0\right)\,\gamma_0 \,du \qquad \mbox{with}\qquad \gamma_0 = - H_0\,\alpha_0^2}
\end{aligned}$$ and the following additional variances and covariances
$$\begin{aligned}
\mathrm{Var}[\Delta y_0] =& \int_s^t \alpha_0^2\,H_0^2\,du \\
\mathrm{Cov}[\Delta y_0, \Delta z_i] =& \rho^{zz}_{0i} \int_s^t \alpha_0\,H_0\,\alpha_i\,du \\
\mathrm{Cov}[\Delta y_0, \Delta \ln x_i] =& \int_s^t \left(H_0(t)-H_0\right) \alpha_0^2\,H_0\,du \\
&  - \rho^{zz}_{0i}\int_s^t \alpha_0\,H_0\left(H_i(t)-H_i\right)\, \alpha_i \,du \\
&  +\rho^{zx}_{0i}\int_s^t \alpha_0 \, H_0\,\sigma^x_i \,du 
%\mathrm{Var}[\Delta z_i] =& \int_s^t \alpha_i^2\,du \\
%\mathrm{Var}[\Delta \ln x_i] =&
%      \int_s^t \left(H_0(t)-H_0\right)^2 \alpha_0^2\,du \nonumber\\
%      & -2\rho^{zz}_{0i} \int_s^t \left(H_i(t)-H_i\right) \alpha_i\left(H_0(t)-H_0\right) \alpha_0\,du
%  \nonumber\\
%      &+ 2\rho^{zx}_{0i}\int_s^t \left(H_0(t)-H_0\right)\alpha_0 \,\sigma^x_i\,du \nonumber\\
%      &- 2\rho^{zx}_{ii}\int_s^t \left(H_i(t)-H_i\right)\alpha_i \,\sigma^x_i\,du\nonumber\\
%      &+ \int_s^t \left(H_i(t)-H_i\right)^2\alpha_i^2 \,du
%  \nonumber\\
%      &+ \int_s^t(\sigma^x_i)^2\,du \\
%\mathrm{Cov} [\Delta z_i, \Delta z_j] =& \rho^{zz}_{ij}\int_s^t \alpha_i\,\alpha_j\,du \\
%\mathrm{Cov} [\Delta z_i, \Delta \ln x_j] =& \rho^{zz}_{0i}\int_s^t \left(H_0(t)-H_0\right)
%  \alpha_0\,\alpha_i\,du \nonumber\\
%      &- \rho^{zz}_{ij}\int_s^t \alpha_i \,\alpha_j \,\left(H_j(t)-H_j\right) \,du \nonumber\\
%      &+\rho^{zx}_{ij}\int_s^t \alpha_i \, \sigma^x_j \,du.
\end{aligned}$$

Example 36 illustrates the effect of the choice of measure on exposure
simulations.

## Exposures

In ORE we use the following exposure definitions $$\begin{aligned}
\EE(t) = \EPE(t) &= \E^N\left[ \frac{(NPV(t)-C(t))^+}{N(t)} \right] \label{EE}\\
\ENE(t) &= \E^N\left[ \frac{(-NPV(t)+C(t))^+}{N(t)} \right] \label{ENE}
\end{aligned}$$ where $\NPV(t)$ stands for the netting set NPV and
$C(t)$ is the collateral balance[^3] at time $t$. Note that these
exposures are expectations of values discounted with numeraire $N$ (in
ORE the Linear Gauss Markov model’s numeraire) to today, and
expectations are taken in the measure associated with numeraire $N$.
These are the exposures which enter into unilateral CVA and DVA
calculation, respectively, see next section. Note that we sometimes
label the expected exposure
(<a href="#EE" data-reference-type="ref" data-reference="EE">[EE]</a>)
EPE, not to be confused with the Basel III Expected Positive Exposure
below.

Basel III defines a number of exposures each of which is a ’derivative’
of Basel’s Expected Exposure: $$\begin{aligned}
\intertext{Expected Exposure}
EE_B(t) &= \E[\max(NPV(t) - C(t), 0)] \label{basel_ee}\\
\intertext{Expected Positive Exposure}
EPE_B(T) &= \frac{1}{T} \sum_{t<T} EE_B(t)\cdot \Delta t  \label{basel_epe} \\
\intertext{Effective Expected Exposure, recursively defined as running maximum}
EEE_B(t) &= \max(EEE_B(t-\Delta t), EE_B(t)) \label{basel_eee}\\
\intertext{Effective Expected Positive Exposure}
EEPE_B(T) &= \frac{1}{T} \sum_{t<T} EEE_B(t)\cdot \Delta t \label{basel_eepe}
\end{aligned}$$ The last definition, Effective EPE, is used in Basel
documents since Basel II for Exposure At Default and capital
calculation. Following the time averages in the EPE and EEPE
calculations are taken over *the first year* of the exposure evolution
(or until maturity if all positions of the netting set mature before one
year).

To compute $EE_B(t)$ consistently in a risk-neutral setting, we compound
(<a href="#EE" data-reference-type="ref" data-reference="EE">[EE]</a>)
with the deterministic discount factor $P(t)$ up to horizon $t$:
$$EE_B(t) = \frac{1}{P(t)} \:\EE(t)$$

Finally, we define another common exposure measure, the *Potential
Future Exposure* (PFE), as a (typically high) quantile $\alpha$ of the
NPV distribution through time, similar to Value at Risk but at the upper
end of the NPV distribution:

$$\begin{aligned}
  \PFE_\alpha(t) = \left(\inf\left\{ x | F_t(x) \geq \alpha\right\}\right)^+ \label{PFE}
\end{aligned}$$

where $F_t$ is the cumulative NPV distribution function at time $t$.
Note that we also take the positive part to ensure that PFE is a
positive measure even if the quantile yields a negative value which is
possible in extreme cases.

## Exposures using American Monte Carlo

The exposure analysis implemented in ORE that is used in the bulk of the
examples in this user guide, mostly vanilla portfolios, is divided into
two independent steps:

1.  in a first step a list of NPVs (or a “NPV cube”) is computed. The
    list is indexed by the trade ID, the simulation time step and the
    scenario sample number. Each entry of the cube is computed using the
    same pricers as for the T0 NPV calculation by shifting the
    evaluation date to the relevant time step of the simulation and
    updating the market term structures to the relevant scenario market
    data. The market data scenarios are generated using a *risk factor
    evolution model* which can be a cross asset model, but also be based
    on e.g. historical simulation.

2.  in a second step the generated NPV cube is passed to a post
    processor that aggregates the results to XVA figures of different
    kinds.

We label this approach in the following as the *classic* exposure
analysis.

The AMC module in ORE allows to replace the first step by a different
approach which works faster in particular for exotic deals. The second
step remains the same. The risk factor evolution model coincides with
the pricing models for the single trades in this approach and is always
a cross asset model operated in a pricing measure.

For AMC the entries of the NPV cube are now viewed as conditional NPVs
at the simulation time given the information that is generated by the
cross asset model’s driving stochastic process up to the simulation
time. The conditional expectations are then computed using a regression
analysis of some type. In our current implementation this is chosen to
be a parametric regression analysis.

The regression models are calibrated per trade during a training phase
and later on evaluated in the simulation phase. The set of paths in the
two phases is in general different w.r.t. their number, time step
structure, and generation method (Sobol, Mersenne Twister) and seed.
Typically the regressand is the (deflated) dirty *path* NPV of the trade
in question, or also its underlying NPV or an option continuation value
(to take exercise decisions or represent the physical underlying for
physical exercise rights). The regressor is typically the model state.
Certain exotic features that introduce path-dependency (e.g. a TaRN
structure) may require an augmentation of the regressor though (e.g. by
the already accumulated amount in case of the TaRN).

The path NPVs are generated at their *natural event dates*, like the
fixing date for floating rate coupons or the payment date for fixed
cashflows. This reduces the requirements for the cross asset model to
provide closed form expressions for the numeraire and conditional zero
bonds only.

Since the evaluation of the regression functions is computationally
cheap the overall timings of the NPV cube generation are generally
smaller compared to the classic approach, in particular for exotic deals
like Bermudan Swaptions.

From a methodology point of view an important difference between the
classic and the AMC exposure analysis lies in the model consistency:
While the conditional NPVs computed with AMC are by construction
consistent with the risk factor evolution model driving the XVA
simulation, the scenario NPVs in the classic approach are in general not
consistent in this sense unless the market scenarios are fully implied
by the cross asset model. Here “fully implied” means that not only rate
curves, but also market volatility and correlation term structures like
FX volatility surfaces, Swaption volatilities or CMS correlation term
structures as well as other parameters used by the single trade pricers
have to be deduced from the cross asset model, e.g. the mean reversion
of the Hull White 1F model and a suitable model volatility feeding into
a Bermudan Swaption pricer.

We note that the generation of such implied term structures can be
computationally expensive even for simple versions of a cross asset
model like one composed from LGM IR and Black-Scholes FX components
etc., and even more so for more exotic component flavours like Cheyette
IR components, Heston FX components etc.

In the current implementation only a subset of all ORE trade types can
be simulated using AMC while all other trade types are still simulated
using the classic engine. The separation of the trades and the joining
of the resulting classic and AMC cubes is automatic. The post processing
step is run on the joint cube from the classic and AMC simulations as
before.

Trade types supported by AMC so far:

1.  Swap

2.  CrossCurrencySwap

3.  FxOption

4.  BermudanSwaption

5.  MultiLegOption

### AMC valuation engine and AMC pricing engines

The `AMCValuationEngine` is responsible for generating a NPV cube for a
portfolio of AMC enabled trades and (optionally) to populate a
`AggregationScenarioData` instance with simulation data for post
processing, very similar to the classic `ValuationEngine` in ORE.

The AMC valuation engine takes a cross asset model defining the risk
factor evolution. This is set up identically to the cross asset model
used in the  
`CrossAssetModelScenarioGenerator`. Similarly the same parameters for
the path generation (given as a `ScenarioGeneratorData` instance) are
used, so that it is guaranteed that both the AMC engine and the classic
engine produce the same paths, hence can be combined to a single cube
for post processing. It is checked, that a non-zero seed for the random
number generation is used.

The portfolio is build against an engine factory with specific AMC
pricing engine configurations. The AMC engine builders are retrieved
from `getAmcEngineBuilders()` and are special in that unlike usual
engine builders they take two parameters

1.  the cross asset model which serves as a risk factor evolution model
    in the AMC valuation engine

2.  the date grid used within the AMC valuation engine

For technical reasons, the configuration also contains configurations
for  
`CapFlooredIborLeg`, `CapFlooredInterpolatedIborLeg` and `CMS` because
those are used within the trade builders (more precisely the leg
builders called from these) to build the trade. The configuration can be
the same as for T0 pricing for them, it is actually not used by the AMC
pricing engines.

The AMC engine builders build a smaller version of the global cross
asset model only containing the model components required to price the
specific trade. Note that no deal specific calibration of the model is
performed.

The AMC pricing engines perform a T0 pricing and - as a by-product - can
be used as usual T0 pricing engines if a corresponding engine builder is
supplied, see Example 39 (Exposure Simulation using American Monte
Carlo).

In addition the AMC pricing engines perform the necessary calculations
to yield conditional NPVs on the given global simulation grid. How these
calculations are performed is completely the responsibility of the
pricing engines, although some common framework for many trade types is
given by a base engine, see
<a href="#sec:amc_base_engine" data-reference-type="ref"
data-reference="sec:amc_base_engine">1.3.2</a>. This way the
approximation of conditional NPVs on the simulation grid can be tailored
to each product and also each single trade, with regards to

1.  the number of training paths and the required date grid for the
    training (e.g. containing all relevant coupon and exercise event
    dates of a trade)

2.  the order and type of regression basis functions to be used

3.  the choice of the regressor (e.g. a TaRN might require a regressor
    augmented by the accumulated coupon amount)

The AMC pricing engines then provide an additional result labelled
`amcCalculator` which is a class implementing the `AmcCalculator`
interface which consists of two methods: The method `simulatePath()`
takes a `MultiPath` instance representing one simulated path from the
global risk factor evolution model and returns an array of conditional,
deflated NPVs for this path. The method `npvCurrency()` returns the
currency $c$ of the calculated conditional NPVs. This currency can be
different from the base currency $b$ of the global risk factor evolution
model. In this case the conditional NPVs are converted to the global
base currency within the AMC valuation engine by multiplying them with
the conversion factor

$$\label{currency_conversion_factor}
\frac{N_c(t) X_{c,b}(t)}{N_b(t)}$$

where $t$ is the simulation time, $N_c(t)$ is the numeraire in currency
$c$, $N_b(t)$ is the numeraire in currency $b$ and $X_{c,b}(t)$ is the
FX rate at time $t$ converting from $c$ to $b$.

The technical criterion for a trade to be processed within the AMC
valuation is engine is that a) it can be built against the AMC engine
factory described above and b) it provides an additional result
`amcCalculator`. If a trade does not meet these criteria it is simulated
using the classic valuation engine. The logic that does this is located
in the override of the method `XvaAnalyticImpl::runAnalytic()`.

The AMC valuation engine can also populate an aggregation scenario data
instance. This is done only if necessary, i.e. only if no classic
simulation is performed anyway. The numeraire and fx spot values
produced by the AMC valuation engine are identical to the classic
engine. Index fixings are close, but not identical, because the AMC
engine used the T0 curves for projection while the classic engine uses
scenario simulation market curves, which are not exactly matching those
of the T0 market. In this sense the AMC valuation engine produces more
precise values compared to the classic engine.

### The multileg option AMC base engine and derived engines

Example 39 (Exposure Simulation using American Monte Carlo) provides an
overview of the implemented AMC engine builders. These builders use the
following QuantExt pricing engines

1.  `McLgmSwapEngine` for single currency swaps

2.  `McCamCurrencySwapEngine` for cross currency swaps

3.  `McCamFxOptionEngine` for fx options

4.  `McLgmSwaptionEngine` for Bermudan swaptions

5.  `McMultiLegOptionEngine` for Multileg option

All these engine are based on a common `McMultiLegBaseEngine` which does
all the computations. For this each of the engines sets up the following
protected member variables (serving as parameters for the base engine)
in their `calculate()` method:

1.  `leg_`: a vector of `QuantLib::Leg`

2.  `currency_`: a vector of `QuantLib::Currency` corresponding to the
    leg vector

3.  `payer_`: a vector of $+1.0$ or $-1.0$ double values indicating
    receiver or payer legs

4.  `exercise_`: a `QuantLib::Exercise` instance describing the exercise
    dates (may be `nullptr`, if the underlying represents the deal
    already)

5.  `optionSettlement_`: a `Settlement::Type` value indicating whether
    the option is settled physically or in cash

A call to `McMultiLegBaseEngine::calculate()` will set the result member
variables

1.  `resultValue_`: T0 NPV in the base currency of the cross asset model
    passed to the pricing engine

2.  `underlyingValue_`: T0 NPV of the underlying (again in base ccy)

3.  \*`amcCalculator_`: the AMC calculator engine to be used in the AMC
    valuation engine

The specific engine implementations should convert the `resultValue_` to
the npv currency of the trade (as defined by the (ORE) trade builder) so
that they can be used as regular pricing engine consistently within ORE.
Note that only the additional `amcCalculator` result is used by the AMC
valuation engine, not any of the T0 NPVs directly.

### Limitations and Open Points

This sections lists known limitations of the AMC simulation engine.

### Trade Features

Some trade features are not yet supported by the multileg option engine:

1.  exercise flows (like a notional exchange common to cross currency
    swaptions) are not supported

### Flows Generation (for DIM Analysis)

At the current stage the AMC engine does not generate flows which are
required for the DIM analysis in the post processor.

### State interpolation for exercise decisions

During the simulation phase exercise times of a specific trade are not
necessarily part of the simulated time grid. Therefore the model state
required to take the exercise decision has in to be interpolated in
general on the simulated path. Currently this is done using a simple
linear interpolation while from a pure methodology point of view a
Brownian Bridge would be preferable. In our tests we do not see a big
impact of this approximation though.

### Basis Function Selection

Currently the basis function system is generated by specifying the type
of the functions and the order, see Example 39 (Exposure Simulation
using American Monte Carlo). The number of independent variables varies
by product type and details. Depending on the number of independent
variables and the order the number of generated basis functions can get
quite big which slows down the computation of regression coefficients.
It would be desirable to have the option to filter the full set of basis
functions, e.g. by explicitly enumerating them in the configuration, so
that a high order can be chosen even for products with a relatively
large number of independent variables (like e.g. FX Options or Cross
Currency Swaps).

### Outlook: Trade Compression

For vanilla trades where the regression is only required to produce the
NPV cube entries (and not to take exercise decisions etc.) it is not
strictly necessary to do the regression analysis on a single trade
level[^4]. Although in the current implementation there is no direct way
to do the regression analysis on whole (sub-)portfolios instead of
single trades, one can represent such a subportfolio as a single
technical trade (e.g. as a single swap or multileg option trade) to
achieve a similar result. This might lead to better performance than the
usual single trade calculation. However one should also try to keep the
regressions as low-dimensional as possible (for performance and accuracy
reasons) and therefore define the sub-portfolios by e.g. currency, i.e.
as big as possible while at the same time keeping the associated model
dimension as small as possible.

[^1]: See section 7.2 in Andersen for the discussion on dependence of
    seasonality adjustment to calendar days and expiry of future
    contracts.

[^2]: Andersen worked on a two factor set up, where the first factor
    affects the short-end of the futures curve and has the form the
    $e^{b(T)}$, and the second factor has an additional term containing
    $e^{a(T)}h_{\infty}$ for long futures maturities.

[^3]: $C(t)>0$ means that we have *received* collateral from the
    counterparty

[^4]: except single trade exposures are explicitly required of course

---

# Value Adjustments

## CVA and DVA

Using the expected exposures in
<a href="#sec:app_exposure" data-reference-type="ref"
data-reference="sec:app_exposure">[sec:app_exposure]</a> unilateral
discretised CVA and DVA are given by $$\begin{aligned}
\CVA &= \sum_{i} \PD(t_{i-1},t_i)\times\LGD\times \EPE(t_i) \label{CVA}\\
\DVA &= \sum_{i} \PD_{Bank}(t_{i-1},t_i)\times\LGD_{Bank}\times \ENE(t_i) \label{DVA}
\end{aligned}$$ where $$\begin{aligned}
\EPE(t) & \mbox{ expected exposure (\ref{EE})}\\
\ENE(t) & \mbox{ expected negative exposure (\ref{ENE})}\\
PD(t_i,t_j) & \mbox{ counterparty probability of default in } [t_i;t_j]\\
PD_{Bank}(t_i,t_j) & \mbox{ our probability of default in } [t_i;t_j]\\
LGD & \mbox{ counterparty loss given default}\\
LGD_{Bank} & \mbox{ our loss given default}\\
\end{aligned}$$

Note that the choice $t_i$ in the arguments of $\EPE(t_i)$ and
$\ENE(t_i)$ means we are choosing the *advanced* rather than the
*postponed* discretization of the CVA/DVA integral . This choice can be
easily changed in the ORE source code or made configurable.  
Moreover, formulas
(<a href="#CVA" data-reference-type="ref" data-reference="CVA">[CVA]</a>,
<a href="#DVA" data-reference-type="ref" data-reference="DVA">[DVA]</a>)
assume independence of credit and other market risk factors, so that
$\PD$ and $\LGD$ factors are outside the expectations. With the
extension of ORE to credit asset classes and in particular for
wrong-way-risk analysis, CVA/DVA formulas is generalised and is
applicable to calculations with dynamic credit

$$\begin{aligned}
\CVA^{dyn} &= \sum_{i} \E^N\left[\frac{\PD^{dyn}(t_{i-1},t_i)\times \PE(t_i)}{N(t)} \right]\times\LGD \label{CVA_dynamic} \\
\DVA^{dyn} &= \sum_{i} \E^N\left[\frac{\PD^{dyn}_{Bank}(t_{i-1},t_i)\times \NE(t_i)}{N(t)} \right]\times\LGD_{Bank} \label{DVA_dynamic}
\end{aligned}$$ where $$\begin{aligned}
\PE(t) & \mbox{ random variables representing positive exposure at } t: (NPV(t)-C(t))^+\\
\NE(t) & \mbox{ random variables representing negative exposure at } t: (-NPV(t)+C(t))^+\\
PD^{dyn}(t_i,t_j) & \mbox{ random variables representing counterparty probability of default in } [t_i;t_j]\\
PD^{dyn}_{Bank}(t_i,t_j) & \mbox{ random variables representing our probability of default in } [t_i;t_j]\\
LGD & \mbox{ counterparty loss given default}\\
LGD_{Bank} & \mbox{ our loss given default}\\
\end{aligned}$$

## FVA

Any exposure (uncollateralised or residual after taking collateral into
account) gives rise to funding cost or benefits depending on the sign of
the residual position. This can be expressed as a Funding Value
Adjustment (FVA). A simple definition of FVA can be given in a very
similar fashion as the sum of unilateral CVA and DVA which we defined by
(<a href="#CVA" data-reference-type="ref" data-reference="CVA">[CVA]</a>,<a href="#DVA" data-reference-type="ref" data-reference="DVA">[DVA]</a>),
namely as an expectation of exposures times funding spreads:
$$\begin{aligned}
  \FVA &= \underbrace{\sum_{i=1}^n f_l(t_{i-1},t_i)\,\delta_i \, \E^N\left\{S_C(t_{i-1})\, S_B(t_{i-1})\, [-\NPV(t_i)+C(t_i)]^+\,
         D(t_i)\right\}}_{\mbox{Funding Benefit Adjustment (FBA)}}\nonumber\\
       & {} - \underbrace{\sum_{i=1}^n f_b(t_{i-1},t_i)\,\delta_i \, \E^N\left\{S_C(t_{i-1})\, S_B(t_{i-1})\, [\NPV(t_i)-C(t_i)]^+\, D(t_i)\right\}}_{\mbox{Funding Cost Adjustment (FCA)}}\label{eq_simple_fva}
%  \FVA &= - \underbrace{\sum_{i=1}^n f_b(t_{i-1},t_i)\,\delta_i \, \E^N\left[S_C(t_{i-1})\, S_B(t_{i-1})\, (\NPV(t_i))^+\,
 %        D(t_i)\right]}_{\mbox{Funding Cost Adjustment (FCA)}}\nonumber\\
 %      & {} \underbrace{\sum_{i=1}^n f_l(t_{i-1},t_i)\,\delta_i \, \E^N\left[S_C(t_{i-1})\, S_B(t_{i-1})\, (-\NPV(t_i))^+\, D(t_i)\right]}_{\mbox{Funding Benefit Adjustment (FBA)}}\label{eq_simple_fva}
\end{aligned}$$ where $$\begin{aligned}
D(t_i) & \mbox{ stochastic discount factor, $1/N(t_i)$ in LGM}\\
\NPV(t_i) & \mbox{ portfolio value at time } t_i\\
C(t_i) & \mbox{Collateral account balance at time } t_i \\
S_C(t_j) & \mbox{ survival probability of the counterparty}\\
S_B(t_j) & \mbox{ survival probability of the bank}\\
f_b(t_j) & \mbox{ borrowing spread for the bank relative to OIS flat}\\
f_l(t_j) & \mbox{ lending spread for the bank relative to OIS flat}
\end{aligned}$$ For details see e.g. Chapter 14 in Gregory and the
discussion in .

The reasoning leading to the expression above is as follows. Consider,
for example, a single partially collateralised derivative (no collateral
at all or CSA with a significant threshold) between us (the Bank) and
counterparty 1 (trade 1).

We assume that we enter into an offsetting trade with (hypothetical)
counterparty 2 which is perfectly collateralised (trade 2). We label the
NPV of trade 1 and 2 $\NPV_{1,2}$ respectively (from our perspective,
excluding CVA). Then $\NPV_2=-\NPV_1$. The respective collateral amounts
due to trade 1 and 2 are $C_1$ and $C_2$ from our perspective. Because
of the perfect collateralisation of trade 2 we assume $C_2=\NPV_2$. The
imperfect collateralisation of trade 1 means $C_1 \ne \NPV_1$. The net
collateral balance from our perspective is then $C=C_1+C_2$ which can be
written $C=C_1+C_2 = C_1 + \NPV_2 = -\NPV_1 + C_1$.

- If $C>0$ we receive net collateral and pay the overnight rate on this
  notional amount. On the other hand we can invest the received
  collateral and earn our lending rate, so that we have a benefit
  proportional to the lending spread $f_l$ (lending rate minus overnight
  rate). It is a benefit assuming $f_l >0$. $C>0$ means
  $-\NPV_1 + C_1 > 0$ so that we can cover this case with “lending
  notional” $[-\NPV_1 + C_1]^+$.

- If $C<0$ we post collateral amount $-C$ and receive the overnight rate
  on this amount. Amount $-C$ needs to be funded in the market, and we
  pay our borrowing rate on it. This leads to a funding cost
  proportional to the borrowing spread $f_b$ (borrowing rate minus
  overnight). $C<0$ means $\NPV_1 - C_1 > 0$, so that we can cover this
  case with “borrowing notional” $[\NPV_1 - C_1]^+$. If the borrowing
  spread is positive, this term proportional to
  $f_b \times [\NPV_1 - C_1]^+$ is indeed a cost and therefore needs to
  be subtracted from the benefit above.

Formula <a href="#eq_simple_fva" data-reference-type="eqref"
data-reference="eq_simple_fva">[eq_simple_fva]</a> evaluates these
funding cost components on the basis of the original trade’s or
portfolio’s $\NPV$. Perfectly collateralised portfolios hence do not
contribute to FVA because under the hedging fiction, they are hedged
with a perfectly collateralised opposite portfolio, so any collateral
payments on portfolio 1 are cancelled out by those of the opposite sign
on portfolio 2.

## COLVA

When the CSA defines a collateral compounding rate that deviates from
the overnight rate, this gives rise to another value adjustment labeled
COLVA . In the simplest case the deviation is just given by a constant
spread $\Delta$: $$\begin{aligned}
\COLVA &= \E^N\left[ \sum_i -C(t_i)\cdot \Delta \cdot \delta_i \cdot D(t_{i+1}) \right]
\label{COLVA}
\end{aligned}$$ where $C(t)$ is the collateral balance[^1] at time $t$
and $D(t)$ is the stochastic discount factor $1/N(t)$ in LGM. Both
$C(t)$ and $N(t)$ are computed in ORE’s Monte Carlo framework, and the
expectation yields the desired adjustment.  
Replacing the constant spread by a time-dependent deterministic function
in ORE is straight forward.

## Collateral Floor Value

A less trivial extension of the simple COLVA calculation above, also
covered in ORE, is the case where the deviation between overnight rate
and collateral rate is stochastic itself. A popular example is a CSA
under which the collateral rate is the overnight rate *floored at zero*.
To work out the value of this CSA feature one can take the difference of
discounted margin cash flows with and without the floor feature. It is
shown in that the following formula is a good approximation to the
collateral floor value $$\begin{aligned}
\Pi_{Floor} &= \E^N\left[ \sum_i -C(t_i)\cdot (-r(t_i))^+\cdot\delta_i \cdot D(t_{i+1}) \right]
\label{CSA_floor_value_approx}
\end{aligned}$$ where $r$ is the stochastic overnight rate and
$(-r)^+ = r^+ - r$ is the difference between floored and ’un-floored’
compounding rate.  
Taking both collateral spread and floor into account, the value
adjustment is $$\begin{aligned}
\Pi_{Floor,\Delta} &= \E^N\left[ \sum_i -C(t_i)\cdot ((r(t_i)-\Delta)^+-r(t_i))\cdot\delta_i \cdot D(t_{i+1}) \right]
\label{CSA_floor_value_approx_2}
\end{aligned}$$

## Dynamic Initial Margin and MVA

The introduction of Initial Margin posting in non-cleared OTC
derivatives business reduces residual credit exposures and the
associated value adjustments, **CVA** and **DVA**.

On the other hand, it gives rise to additional funding cost. The value
of the latter is referred to as Margin Value Adjustment (**MVA**).  
To quantify these two effects one needs to model Initial Margin under
future market scenarios, i.e. Dynamic Initial Margin (**DIM**).
Potential approaches comprise

- Monte Carlo VaR embedded into the Monte Carlo simulation

- Regression-based methods

- Delta VaR under scenarios

- ISDA’s Standard Initial Margin (SIMM) under scenarios

We skip the first option as too computationally expensive for ORE.

### Regression Approach

In ORE releases up to version 12 we have focussed on a relatively simple
regression approach as in . Consider the netting set values $\NPV(t)$
and $\NPV(t+\Delta)$ that are spaced one margin period of risk $\Delta$
apart. Moreover, let $F(t,t+\Delta)$ denote cumulative netting set cash
flows between time $t$ and $t+\Delta$, converted into the NPV currency.
Let $X(t)$ then denote the netting set value change during the margin
period of risk excluding cash flows in that period:
$$X(t) = \NPV(t+\Delta) + F(t, t+\Delta) - \NPV(t)$$ ignoring
discounting/compounding over the margin period of risk. We actually want
to determine the distribution of $X(t)$ conditional on the ‘state of the
world’ at time $t$, and pick a high (99%) quantile to determine the
Initial Margin amount for each time $t$. Instead of working out the
distribution, we content ourselves with estimating the conditional
variance $\V(t)$ or standard deviation $S(t)$ of $X(t)$, assuming a
normal distribution and scaling $S(t)$ to the desired 99% quantile by
multiplying with the usual factor $\alpha=2.33$ to get an estimate of
the Dynamic Initial Margin $\DIM$:
$$\V(t) = \E_t[X^2] - \E_t^2[X], \qquad S(t)=\sqrt{\V(t)}, \qquad \DIM(t) = \alpha \,S(t)$$
We further assume that $\E_t[X]$ is small enough to set it to the
expected value of $X(t)$ across all Monte Carlo samples $X$ at time $t$
(rather than estimating a scenario dependent mean). The remaining task
is then to estimate the conditional expectation $\E_t[X^2]$. We do this
in the spirit of the Longstaff Schwartz method using regression of
$X^2(t)$ across all Monte Carlo samples at a given time. As a regressor
(in the one-dimensional case) we could use $\NPV(t)$ itself. However, we
rather choose to use an adequate market point (interest rate, FX spot
rate) as regression variable $x$, because this is generalised more
easily to the multi-dimensional case. As regression basis functions we
use polynomials, i.e. regression functions of the form
$c_0 + c_1\,x + c_2\,x^2 + ...+ c_n\,x^n$ where the order $n$ of the
polynomial can be selected by the user. Choosing the lowest order $n=0$,
we obtain the simplest possible estimate, the variance of $X$ across all
samples at time $t$, so that we apply a single $\DIM(t)$ irrespective of
the ‘state of the world’ at time $t$ in that case. The extension to
multi-dimensional regression is also implemented in ORE. The user can
choose several regressors simultaneously (e.g. a EUR rate, a USD rate,
USD/EUR spot FX rate, etc.) in order order to cover complex
multi-currency portfolios.

Given the DIM estimate along all paths, we can next work out the Margin
Value Adjustment in discrete form $$\begin{aligned}
\MVA &= \sum_{i=1}^n (f_b - s_I)\, \delta_i\: S_C(t_i)\: S_B(t_i) \times \E^N\left[
\DIM(t_i)\,D(t_i)\right]. \label{MVA}
\end{aligned}$$ with borrowing spread $f_b$ as in the FVA section
<a href="#sec:fva" data-reference-type="ref"
data-reference="sec:fva">1.2</a> and spread $s_I$ received on initial
margin, both spreads relative to the cash collateral rate.

### VaR under Scenarios: Dynamic Parametric VaR

Because of the limitations of the regression approach, it needs
benchmarking/validation. In we have applied a dynamic parametric VaR
method for that purpose covering

- Delta VaR

- Delta Gamma Normal VaR

- Delta Gamma VaR (Cornish-Fisher)

This has been added to ORE with release 13 and is implemented for the
small range of products that are discussed in , i.e.

- Swaps

- Cross Currency Swaps

- European Swaptions

- FX Forwards

- FX Options

where relevant sensitivities can be computed analytically under
scenarios which feed into the parametric VaR calculation. The covariance
structure of the VaR model is implied from the calibrated cross asset
model (rather than externally provided), because the primary motivation
of the method was benchmarking of the regression approach, in particular
to check the performance of regression methods in option portfolios.

The usage of Dynamic Parametric VaR as Initial Margin proxy is
demonstrated in Example 13 (Dynamic Initial Margin and MVA), compared to
Regression IM.

## KVA

### CCR

The KVA is calculated for the Counterparty Credit Risk Capital charge
(CCR) following the IRB method concisely described in , Appendix 8A. It
is following the Basel rules by computing risk capital as the product of
alpha weighted exposure at default, worst case probability of default at
99.9 and a maturity adjustment factor also described in the Basel annex
4. The risk capital charges are discounted with a capital discount
factor and summed up to give the total CCR KVA after being multiplied
with the risk weight and a capital charge (following the RWA method).

Basel II internal rating based (IRB) estimate of worst case probability
of default: large homogeneous pool (LHP) approximation of Vasicek
(1997), KVA regulatory probability of default is the worst case
probability of default floored at 0.03 (the latter is valid for
corporates and banks, no such floor applies to sovereign
counterparties):
$$\PD_{99.9\%} = \max\left(floor, N \left(\frac{N^{-1}(\PD) + \sqrt{\rho}
  N^{-1}(0.999)}{\sqrt{1 - \rho}}\right) - \PD\right)$$ $N$ is the
cumulative standard normal distribution,

$$\rho = 0.12 \frac{1 - e^{-50 \PD}}{1 - e^{-50}} + 0.24 \left(1 - \frac{1 -
  e^{-50 \PD}}{1 - e^{-50}}\right)$$

Maturity adjustment factor for RWA method capped at 5, floored at 1:
$$\MA(\PD, M) = \min\left(5, \max\left(1, \frac{1 + (M - 2.5) B(\PD)}{1 - 1.5 B(\PD)}\right)\right)$$
where $B(\PD) = (0.11852 - 0.05478 \ln(\PD))^2$ and M is the effective
maturity of the portfolio (capped at 5):

$$M = \min\left(5, 1 + \frac{\sum\limits_{t_k > 1yr} \EE_B(t_k)\Delta t_k
  B(0,t_k)}{\sum\limits_{t_k \leq 1yr} \EEE_B(t_k)\Delta t_k B(0,t_k)}\right)$$

where $B(0,t_k)$ is the risk-free discount factor from the simulation
date $t_k$ to today, $\Delta t_k$ is the difference between time points,
$\EE_B(t_k)$ is the expected (Basel) exposure at time $t_k$ and
$\EEE_B(t_k)$ is the associated effective expected exposure.

Expected risk capital at $t_i$:
$$\RC(t_i) = EAD(t_i) \times LGD \times \PD_{99.9\%} \times \MA(\PD, M)$$
where

- $\EAD(t_i) = \alpha \times \EEPE(t_i)$

- $\EEPE(t_i)$ is estimated as the time average of the running maximum
  of $\EPE(t)$ over the time interval $t_i\leq t\leq t_i+1$

- $\alpha$ is the multiplier resulting from the IRB calculations (Basel
  II defines a supervisory alpha of 1.4, but gives banks the option to
  estimate their own $\alpha$,subject to a floor of 1.2).

- the maturity adjustment MA is derived from the EPE profile for times
  $t\geq t_i$

$\KVA_{CCR}$ is the sum of the expected risk capital amount discounted
at *capital discount rate* $r_{cd}$ and compounded at rate given by the
product of *capital hurdle* $h$ and *regulatory adjustment* $a$:
$$\KVA_{CCR} = \sum_i \RC(t_i) \times \frac{1}{ (1 + r_{cd})^{\delta(t_{i-1}, t_i)}} \times \delta(t_{i-1}, t_i) \times h \times a$$
assuming Actual/Actual day count to compute the year factions $\delta$.

In ORE we compute KVA CCR from both perspectives - “our” KVA driven by
EPE and the counterparty default risk, and similarly “their” KVA driven
by ENE and our default risk.

### BA-CVA

This section briefly summarizes the calculation of a capital value
adjustment associated with the CVA capital charge (in the basic
approach, BA-CVA) as introduced in Basel III . ORE implements the
*stand-alone* capital charge $\SCVA$ for a netting set and computes a
KVA for it[^2]. In the basic approach, the stand-alone capital charge
for a netting set is given by
$$\SCVA = \RW_c\cdot M\cdot \EEPE \cdot\DF$$ with

- supervisory risk weight $\RW_c$ for the counterparty;

- effective netting set maturity $M$ as in section
  <a href="#sec:app_kva" data-reference-type="ref"
  data-reference="sec:app_kva">1.6</a> (for a bank using IMM to
  calculate EAD), but without applying a cap of 5;

- supervisory discount $\DF$ for the netting set which is equal to one
  for banks using IMM to calculate $\EEPE$ and
  $\DF=\left(1-\exp\left(-0.05\,M\right)\right)/(0.05\,M)$ for banks not
  using IMM to calculate $\EEPE$.

The associated capital value adjustment is then computed for each
netting set’s stand-alone CVA charge as above
$$\KVA_{BA-\CVA} = \sum_i \SCVA(t_i) \times \frac{1}{ (1 + r_{cd})^{\delta(t_{i-1}, t_i)}} \times \delta(t_{i-1}, t_i) \times h \times a$$
with $$\SCVA(t_i) = \RW_c \cdot M(t_i)\cdot \EEPE(t_i)\cdot\DF$$ where
we derive both $M$ and EEPE from the EPE profile for times $t\geq t_i$.

In ORE we compute KVA BA-CVA from both perspectives - “our” KVA driven
by EPE and the counterparty risk weight, and similarly “their” KVA
driven by ENE and our risk weight.  
Note: Banks that use the BA-CVA for calculating CVA capital requirements
are allowed to cap the maturity adjustment factor $\MA(\PD,M)$ in
section <a href="#sec:app_kva" data-reference-type="ref"
data-reference="sec:app_kva">1.6</a> at 1 for netting sets that
contribute to CVA capital, if using the IRB approach for CCR capital.

## Collateral (Variation Margin) Model

The collateral model implemented in ORE is based on the evolution of
collateral account balances along each Monte Carlo path taking into
account thresholds, minimum transfer amounts and independent amounts
defined in the CSA, as well as margin periods of risk.

ORE computes the collateral requirement (aka *Credit Support Amount*)
through time along each Monte Carlo path $$\begin{aligned}
\label{eq:CSA}
CSA(t_m) &=
\begin{cases}
\max(0, \NPV(t_m) + \IA - \Th_{rec}),& \NPV(t_m) + \IA \ge 0 \\
\min(0, \NPV(t_m) + \IA + \Th_{pay}),& \NPV(t_m) + \IA < 0
\end{cases}
\end{aligned}$$ where

- $\NPV(t_m)$ is the value of the netting set as of time $t_m$ from our
  perspective,

- $\Th_{rec}$ is the threshold exposure below which we do not require
  collateral, likewise $\TH_{pay}$ is the threshold that applies to
  collateral posted to the counterparty,

- $\IA$ is the sum of all collateral independent amounts attached to the
  underlying portfolio of trades (positive amounts imply that we have
  received a net inflow of independent amounts from the counterparty),
  assumed here to be cash.

As the collateral account already has a value of $C(t_m)$ at time $t_m$,
the collateral shortfall is simply the difference between $C(t_m)$ and
$\CSA(t_m)$. However, we also need to account for the possibility that
margin calls issued in the past have not yet been settled (for instance,
because of disputes). If $M(t_m)$ denotes the net value of all
outstanding margin calls at $t_m$, and $\Delta(t)$ is the difference
$$\Delta(t) = \CSA(t_m) - C(t_m) - M(t_m)$$ between the *Credit Support
Amount* and the current and outstanding collateral, then the actual
margin *Delivery Amount* $D(t_m)$ is calculated as follows:
$$\begin{aligned}
\label{eq:DA}
D(t_m) &=
\begin{cases}
\Delta(t),& \left| \Delta(t) \right| \ge MTA \\
0,& \left| \Delta(t) \right| < MTA
\end{cases}
\end{aligned}$$ where $MTA$ is the minimum transfer amount.

Consider the upper case of <a href="#eq:CSA" data-reference-type="eqref"
data-reference="eq:CSA">[eq:CSA]</a>: If the initial value of the
netting set is zero ($\NPV(t_0)=0$) and if $\Th_{rec}=0$, but the
combined $\IA>0$, then the Credit Support Amount equals the Independent
Amount, $\CSA(t_0)=\IA$. If moreover the initial collateral balance is
zero (because the Independent Amount has not been received yet), then
$\Delta(t_0)=\CSA(t_0)=\IA$, and the delivery amount $D(t_0)$ also
matches the $\IA$ (assuming this exceeds the MTA), so that the next call
leads to the transfer of the Independent Amount to us. For a positive
$\Th_{rec}>0$, the transfer to us is reduced accordingly. In that case
we can view the Independent Amount as an offset to the threshold.

Consider the lower case of <a href="#eq:CSA" data-reference-type="eqref"
data-reference="eq:CSA">[eq:CSA]</a>: If the netting set value is
negative from our perspective and in absolute terms larger than the
$\IA$, then the Credit Support Amount is just the negative difference
$\CSA=-|\NPV| + \IA + \Th_{pay}$ so that we need to post collateral, but
only the amount beyond the combined threshold $\IA + \Th_{pay}$.

#### Margin Period of Risk

After a counterparty defaults, it takes time to close out the portfolio.
During this time period the portfolio value will change upon market
conditions, therefore the portfolio’s close-out value is subject to
market risk, which is referred also as the close-out risk and the
corresponding close-out period is called as the *Margin Period of Risk*
(MPoR).

Therefore, when a loss on the defaulted counterparty is realised at time
$t_d$, the last time the collateral could be received is $t_d-\tau$,
where $\tau$ denotes the MPoR. That is, the collateral at time $t_d$ is
determined by the collateral value at $t_d-\tau$, namely
$CSA(t_d-\tau)$, see equation
<a href="#eq:CSA" data-reference-type="ref"
data-reference="eq:CSA">[eq:CSA]</a>.

In ORE, we have two approaches to incorporate MPoR in the exposure
simulations:

- *Close-out Approach*: Simulating on an auxiliary close-out grid
  additional to the default time grid.

- *Lagged Approach*: Simulating only on a default time grid and delaying
  the margin calls on the grid.

In the *Close-out Approach*, we use an auxiliary “close-out” grid in
addition to the main simulation grid (see the user guide’s simulation
parameterisation section). The main simulation grid is used to compute
“default values” which feed into the collateral balance $C(t$) filtered
by MTA and Threshold etc. The auxiliary “close-out” grid, offset from
the main grid by the MPoR, is used to compute the delayed close-out
values $V(t)$ associated with default time $t$[^3]. The difference
between $V(t)$ and $C(t)$ causes a residual exposure $[V (t)-C(t)]^+$
even if minimum transfer amounts and thresholds are zero, see for
example . This approach allows a detailed modelling of what happens in
the close-out period by calculating the close-out values in different
ways. ORE currently supports two options:

- the close-out value can be computed as of default date, by just
  evolving the market from default date to close-out date (“sticky
  date”), or

- the close-out value can be computed as of close-out date, by evolving
  both valuation date and market over the close-out period (“actual
  date”), i.e., the portfolio ages and cash flows might occur in the
  close-out period causing spikes in the evolution of exposures.

The option “sticky date” is more aggressive in that it avoids any
exposure evolution spikes due to contractual cashflows that occur in the
close-out period after default, the only exposure effect is due to
market evolution over the period. The “actual date” option is more
conservative in that it includes the effect of all contractual cash
flows in the close-out period, in particular outgoing cashflows at any
time in the period which cause an exposure jump upwards. A more detailed
framework for collateralised exposure modelling is introduced in the
article , indicating a potential route for extending ORE.

On the other hand, in the *Lagged Approach* the simulation is conducted
only on a default time grid. The collateral values are calculated, by
delaying the delivery amounts between default times, specified by the
*Margin Period of Risk* (MPoR) which leads to residual exposure.

In table <a href="#table:lagged" data-reference-type="ref"
data-reference="table:lagged">1.1</a>, we present a toy example to
illustrate how the delayed margin calls lead to residual exposures. In
this example, we assume that the default time grid is equally-spaced
with time steps that match the MPoR (which is 1M). Further, we assume
zero threshold and MTA. At the initial time, the delivery amount is
$2.00$, which is the difference between the initial value of the
portfolio and the default value at 1M. If this amount were settled
immediately, then the collateral value would have been $10$ and hence
the residual exposure would have been zero at 1M. The delay of the
delivery amount by MPoR implies a collateral value of $8.00$ until 1M
and hence a residual exposure of $2$.

<div id="table:lagged">

| Time Grid | Default Value | Delivery Amount | Delivery Amount Delayed | Collateral Value | NPV   |
|:----------|:--------------|:----------------|:------------------------|:-----------------|:------|
| 0         | 8.00          | 2.00            | True                    |                  |       |
| 1M        | 10.00         | 5.00            | True                    | 8.00             | 10.00 |
| 2M        | 15.00         | -3.00           | True                    | 10.00            | 15.00 |
| 3M        | 12.00         | -3.00           | True                    | 15.00            | 12.00 |
| 4M        | 9.00          | 5.00            | True                    | 12.00            | 9.00  |
| 5M        | 14.00         | 6.00            | True                    | 9.00             | 14.00 |
| 6M        | 20.00         |                 |                         | 14.00            | 20.00 |

Toy example for delayed margin calls.

</div>

Some remarks and observations:

- *Lagged Approach* has the disadvantage that we need to use
  equally-spaced time grids with time steps that match the MPoR. In the
  above example, let us assume that the MPoR is 2W. Then, delaying the
  first delivery amount by 2W would still imply a collateral value of
  $10.00$ at 1M and hence a zero residual exposure.

- In *Lagged Approach* approach, we support three calculation
  (settlement) types where the delay of the *Delivery Amount* depends on
  its sign. The above example corresponds to a “symmetric” calculation
  type where both positive and negative delivery amounts are settled
  with delay, see the user guide’s Parameterisation section for other
  calculation types.

- In ORE, the *Close-out Approach* is the preferred method -and the
  *Lagged Approach* is the legacy method- to incorporate MPoR in the
  collateral model.

## Exposure Allocation

XVAs and exposures are typically computed at netting set level. For
accounting purposes it is typically required to *allocate* XVAs from
netting set to individual trade level such that the allocated XVAs add
up to the netting set XVA. This distribution is not trivial, since due
to netting and imperfect correlation single trade (stand-alone) XVAs
hardly ever add up to the netting set XVA: XVA is sub-additive similar
to VaR. ORE provides an allocation method (labeled *marginal allocation*
in the following) which slightly generalises the one proposed in .
Allocation is done pathwise which first leads to allocated expected
exposures and then to allocated CVA/DVA by inserting these exposures
into equations
(<a href="#CVA" data-reference-type="ref" data-reference="CVA">[CVA]</a>,<a href="#DVA" data-reference-type="ref" data-reference="DVA">[DVA]</a>).
The allocation algorithm in ORE is as follows:

- Consider the netting set’s discounted $\NPV$ after taking collateral
  into account, on a given path at time $t$:
  $$E(t)=D(0,t)\,(\NPV(t)-C(t))$$

- On each path, compute contributions $A_i$ of the latter to trade $i$
  as $$A_{i} (t) = \left\{ \begin{array}{ll}
  E(t) \times \NPV_{i}(t) / \NPV(t), & |\NPV(t)| > \epsilon \\
  E(t) / n, & |\NPV(t)| \le \epsilon
  \end{array}
  \right.$$ with number of trades $n$ in the netting set and trade $i$’s
  value $\NPV_i(t)$.

- The $\EPE$ fraction allocated to trade $i$ at time $t$ by averaging
  over paths: $$\EPE_i(t) = \E\left[ A_i^+(t) \right]$$

By construction, $\sum_i A_i(t) = E(t)$ and hence
$\sum_i \EPE_i(t) = \EPE(t)$.  
We introduced the *cutoff* parameter $\epsilon>0$ above in order to
handle the case where the netting set value $\NPV(t)$ (almost) vanishes
due to netting, while the netting set ‘exposure’ $E(t)$ does not. This
is possible in a model with nonzero MTA and MPoR. Since a single
scenario with vanishing $\NPV(t)$ suffices to invalidate the expected
exposure at this time $t$, the cutoff is essential. Despite introducing
this cutoff, it is obvious that the marginal allocation method can lead
to spikes in the allocated exposures. And generally, the marginal
allocation leads to both positive and negative $\EPE$ allocations.

As a an example for a simple alternative to the marginal allocation of
$\EPE$ we provide allocation based on today’s single-trade CVAs
$$w_i = \CVA_i / \sum_i \CVA_i.$$ This yields allocated exposures
proportional to the netting set exposure, avoids spikes and negative
$\EPE$, but does not distinguish the ‘direction’ of each trade’s
contribution to $\EPE$ and $\CVA$.

[^1]: see <a href="#sec:app_exposure" data-reference-type="ref"
    data-reference="sec:app_exposure">[sec:app_exposure]</a>, $C(t)>0$
    means that we have *received* collateral from the counterparty

[^2]: In the reduced version of BA-CVA, where hedges are not recognized,
    the total BA-CVA capital charge across all counterparties $c$ is
    given by
    $$K = \sqrt{\left(\rho \sum_c \SCVA_c\right)^2 +(1-\rho^2)\sum_c \SCVA_c^2}$$
    with supervisory correlation $\rho=0.5$ to reflect that the credit
    spread risk factors across counterparties are not perfectly
    correlated. Each counterparty $\SCVA_c$ is given by a sum over all
    netting sets with this counterparty.

[^3]: We note that in ORE when the exposure of an uncollateralised
    netting-set or a single trade without considering the netting-set is
    calculated, then the default value is calculated at the main
    simulation grid, not on the close-out grid.

---

## Capital\n
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

---

<span id="sec:collateralbalances" label="sec:collateralbalances"></span>

The collateral balances file - `collateralbalances.xml` - contains the
list of collateral balances (i.e. margin amounts and independent amount)
under a Credit Support Annex.

The balances of each netting set are defined within their own
`CollateralBalance` node. All of these `CollateralBalance` nodes are
contained as children of a `CollateralBalances` node.

The collateral balances are given in the following XML template:

<div class="listing">

``` xml
    <CollateralBalances>
        <CollateralBalance>
            <NettingSetId> </NettingSetId>
            <Currency>USD</Currency>
            <IndependentAmountHeld/>
            <InitialMargin> </InitialMargin>
            <VariationMargin> </VariationMargin>
        </CollateralBalance>
        <CollateralBalance>
            .......
        </CollateralBalance>
    </CollateralBalances>
```

</div>

The meanings of the various elements of the `CollateralBalance` node are
as follows (default input values for certain analytics are specified in
their own respective sections, otherwise the defaults given below, if
any, are applicable):

- `NettingSetId`: The unique identifier for the (collateralised) ISDA
  netting set.  
  Allowable values: Any string.

- `Currency`: The currency that the collateral balance amounts are
  assumed to be denominated in.  
  Allowable values: See Table
  <a href="#tab:currency" data-reference-type="ref"
  data-reference="tab:currency">[tab:currency]</a>.

- `IndependentAmountHeld` \[Optional\]: The netted sum of all
  independent amounts covered by the CSA.  
  Allowable values: Any number. A negative number implies that the
  counterparty holds the independent amount. If provided, overrides the
  specified independent amount held (if any) in the corresponding
  netting set definitions file. Otherwise (if left blank or omitted),
  the independent amount in the netting set definitions file is used.

- `InitialMargin` \[Optional\]: The initial margin amount received.  
  Allowable values: Any number. A negative number implies that the
  counterparty holds the initial margin.

- `VariationMargin` \[Optional\]: The variation margin amount
  received.  
  Allowable values: Any number. A negative number implies that the
  counterparty holds the variation margin.

---

# CVA Capital

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

## Basic Approach, BA-CVA

There are two flavours of the basic approach

- a reduced version that does not recognise hedges

- a full version that does

Note: The implementation in ORE covers the reduced version so far.

### Reduced Version

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

### Full Version

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

## Standard Approach, SA-CVA

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

### Regulatory CVA Calculation and CVA Sensitivity

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
data-reference="tab:cva_sensi">1</a>.

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

---

# Counterparty Credit Risk Capital

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
data-reference="sec_cem">1.1</a>. A revised standardized approach for
counterparty credit risk from derivative acitvity (SA-CCR) as published
in 2014 is in effect from beginning of 2017.

## Current Exposure Method (CEM)

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
data-reference="tab_addon">1</a> which is in use in this form since
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

## Standardized Approach for Counterparty Credit Risk (SA-CCR)

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

### Exposure at Default (EAD)

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

### Potential Future Exposure (PFE)

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
data-reference="tab:hedgingset">2</a>. The asset class assignment is
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
data-reference="tab_saccr_vols">3</a>.

### Trade-Specific Parameters

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
        data-reference="tab_saccr_vols">3</a>.

    - CDO tranches: $\pm \frac{15}{(1+14\,A)(1+14\,D)}$ for purchased
      (sold) protection, where A and D denote the attachment and
      detachment point of the tranche, respectively

    - Others: $\pm 1$ depending on whether long or short in the primary
      risk factor

### Hedging Set/Subset Add-On

We continue with sketching the hedging set level add-on from
(<a href="#sa-ccr-addon" data-reference-type="ref"
data-reference="sa-ccr-addon">[sa-ccr-addon]</a>).

### Interest Rate

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
data-reference="tab_saccr_vols">3</a>) to obtain the add-on:
$$\text{AddOn}_i^{(\text{IR})} = SF_i^{(\text{IR})} \times \text{EffectiveNotional}_i^{(\text{IR})}$$

### Foreign Exchange

Unlike for IR instruments, FX does not use hedging subsets (i.e. the
notional amounts are maturity independent) so trades within the same
currency pair hedging set are allowed to fully offset each other. The
effective notional calculation is similar to that of IR:
$$\text{EffectiveNotional}_i^{(\text{FX})} = \sum_{j=1}^n \delta_j \times d^{(\text{FX})}_j \times MF_j^{(\text{type})}$$
and
$$\text{AddOn}_i^{(\text{FX})} = SF_i^{(\text{FX})} \times \left|\text{EffectiveNotional}_i^{(\text{FX})}\right|$$

### Credit

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
data-reference="tab_saccr_vols">3</a>).

Finally, the asset class add-on is calculated by applying a partial
offset across the entity-level add-ons:
$${\text{AddOn}^{(\text{CR})} = \sqrt{ \underbrace{\left(\sum_k \rho_k^{(\text{CR})} \cdot \text{AddOn}_k^{(\text{CR})} \right)^2}_{\mbox{systematic component}} + \underbrace{\sum_k \left( 1 - \left( \rho_k^{(\text{CR})} \right)^2 \right) \cdot \left(\text{AddOn}_k^{(\text{CR})}\right)^2}_{\mbox{idiosyncratic component}} }}$$

### Equity

The hedging set/subset construction for equities is similar to that for
credit, so the same calculation applies for effective notional where a
hedging subset is formed for each equity underlying:
$$\text{EffectiveNotional}_k^{(\text{EQ})} = \sum_{j=1}^n \delta_j \times d_j^{(\text{EQ})} \times MF_j^{(\text{type})}$$
Likewise, for the entity-level add-on:
$$\text{AddOn}_k^{(\text{EQ})} = SF_k^{(\text{EQ})} \times \text{EffectiveNotional}_k^{(\text{EQ})}$$
There are only 2 supervisory factors for equities, based on whether the
underlying is a single name or an index (see Table
<a href="#tab_saccr_vols" data-reference-type="ref"
data-reference="tab_saccr_vols">3</a>).

Finally, we apply partial offset once again across the entity-level
add-ons to get the asset class add-on:
$${\text{AddOn}^{(\text{EQ})} = \sqrt{ \underbrace{\left(\sum_k \rho_k^{(\text{EQ})} \cdot \text{AddOn}_k^{(\text{EQ})} \right)^2}_{\mbox{systematic component}} + \underbrace{\sum_k \left( 1 - \left( \rho_k^{(\text{EQ})} \right)^2 \right) \cdot \left(\text{AddOn}_k^{(\text{EQ})}\right)^2}_{\mbox{idiosyncratic component}} }}$$

### Commodity

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

### Capital Charge

The CCR capital charge is then computed as
$$K = \EAD \times \underbrace{\PD \times \LGD}_{\text{Risk Weight}}$$

In the *Standardized Approach*, the risk weight is given by a fixed
percentage depending on the counterparty type and its external rating ,
see table <a href="#tab:standard_weights" data-reference-type="ref"
data-reference="tab:standard_weights">4</a>.

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

### Risk Weighted Assets (RWA)

RWA is calculated as a simple multiple of the capital charge
$$\RWA = 12.5 \times K$$

### Outputs and Reports

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

[^1]: See paragraph 166.

[^2]: See Example 3

---

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

---

