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
