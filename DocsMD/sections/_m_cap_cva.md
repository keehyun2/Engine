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
