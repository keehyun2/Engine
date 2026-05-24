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
