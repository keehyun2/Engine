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
