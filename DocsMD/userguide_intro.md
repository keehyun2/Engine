# Introduction

The *Open Source Risk Project* aims at providing a transparent platform
for pricing and risk analysis that serves as

- a benchmarking, validation, training, and teaching reference,

- an extensible foundation for tailored risk solutions.

Its main software project is *Open Source Risk Engine* (ORE), an
application that provides

- a Monte Carlo simulation framework for contemporary risk analytics and
  value adjustments

- simple interfaces for trade data, market data and system configuration

- simple launchers and result visualisation in Jupyter, Excel,
  LibreOffice

- unit tests and various examples.

ORE is open source software, provided under the Modified BSD License. It
is based on QuantLib, the open source library for quantitative finance .

### Audience

The project aims at reaching quantitative risk management practitioners
(be it in financial institutions, audit firms, consulting companies or
regulatory bodies) who are looking for accessible software solutions,
and quant developers in charge of the implementation of pricing and risk
methods similar to those in ORE. Moreover, the project aims at reaching
academics and students who would like to teach or learn quantitative
risk management using a freely available, contemporary risk application.
And in the meantime, as ORE is used in risk services at industrial scale
since 2018 with over 150 users, ORE is aimed at firms that consider the
replacement of third party licensed software.

### Contributions

Quaternion Risk Management has been committed to sponsoring the Open
Source Risk project through ongoing project administration, through
providing an initial release and a series of subsequent releases in
order to achieve a wide analytics, product and risk factor class
coverage. Since Quaternion’s acquisition by Acadia Inc. in February
2021, Acadia has been committed to continue the sponsorship. The Open
Source Risk project work continues with former Quaternion operating as
Acadia’s Quantitative Services unit. And with Acadia’s acquisiton by
London Stock Exchange Group (LSEG) in 2023, the journey continues under
the roof of LSEG Post Trade Solutions.

The community is invited to contribute to ORE, through feedback,
discussions and suggested enhancements. Our forum for that has moved to
github, <https://github.com/OpenSourceRisk/Engine/discussions>. Issues
can be reported at <https://github.com/OpenSourceRisk/Engine/Issues>.
And contributions to the source code can be submitted via pull requests
at <https://github.com/OpenSourceRisk/Engine/pulls>. See also the FAQ
section on the ORE site on how to get involved.

## Scope

ORE currently provides portfolio pricing, cash flow generation, market
risk analysis and a range of contemporary derivative portfolio
analytics. The latter are based on a Monte Carlo simulation framework
which yields the evolution of various exposure measures:

- EE aka EPE (Expected Exposure or Expected Positive Exposure)

- ENE (Expected Negative Exposure, i.e. the counterparty’s perspective)

- ‘Basel’ exposure measures relevant for regulatory capital charges
  under internal model methods

- PFE (Potential Future Exposure at some user defined quantile)

and derivative value adjustments (xVA)

- CVA (Credit Value Adjustment)

- DVA (Debit Value Adjustment)

- FVA (Funding Value Adjustment)

- COLVA (Collateral Value Adjustment)

- MVA (Margin Value Adjustment)

for portfolios with netting, variation and initial margin agreements.

The market risk framework provides

- sensitivity analysis, also in the “par” domain

- stress testing, also in the “par” domain

- several parametric VaR versions (Delta VaR, Delta-Gamma Normal VaR,
  Delta-Gamma VaR with Cornish-Fisher expansion and Saddlepoint method)

- historical simulation VaR

- P&L and P&L explain

across all asset classes and products.

Thanks to Acadia’s open-source strategy, ORE’s financial instrument
scope was extended beyond the initial vanilla scope with a series of
quarterly releases since version 7 to cover

- “First Generation” Equity and FX Exotics, released September with ORE
  v7

- Commodity products (Swaps, Basis Swaps, Average Price Options,
  Swaptions), released December 22 with ORE v8

- Credit products (Index CDS and Index CDS Options, Credit-Linked Swaps,
  Synthetic CDOs), released March 23 with ORE v9

- Bond products and Hybrids (Bond Options, Bond Repos, Bond TRS,
  Composite Trades, Convertible Bonds, Generic TRS with mixed basket
  underlyings, CFDs), released in June 23 with ORE v10

- a Scripted Trade framework in October 23 with ORE v11: This allows the
  modelling of complex hybrid payoffs such as Accumulators, TARFs,
  PRDCs, Basket Options, etc, across IR, FX, INF, EQ, COM classes.
  Scripted Trades are fully integrated into the market risk and exposure
  simulation frameworks, supported by American Monte Carlo methods for
  pricing and exposure simulation. The user can now extend the
  instrument scope conveniently by adding payoff scripts (embedded into
  the trade XML or in separate script “library” XML) and without
  recompiling the code base.

- Formula-based legs, Callable Swaps, Flexi Swaps, Balance Guaranteed
  Swaps and American Swaptions in May 24 with ORE v12

These contributions were accompanied by analytics extensions to enhance
ORE usability

- Exposure simulation for xVA and PFE, adding Commodity to the asset
  class coverage, and adding American Monte Carlo for Exotics, released
  in December 22 with ORE v8

- Market Risk including multi-threaded sensitivity analysis, par
  sensitivity conversion, parametric delta/gamma VaR with Cornish-Fisher
  expansion and Saddlepoint method, released in March 23 with ORE v9

- Portfolio Credit Model, released in June 23 with ORE v10

- ISDA’s Standard Initial Margin Model (SIMM), released in June 23 with
  ORE v10

- Historical Simulation VaR, P&L and P&L Explain, released in May 24
  with ORE v12

Recent analytics additions are

- XVA Risk with sensitivities, P&L and P&L explain

- Regulatory Capital for CCR and CVA Risk (SA-CCR, BA-CVA, SA-CVA)

- Dynamic SIMM based on path-wise sensitivities computed with
  Algorithmic Differentiation (AAD)

The product coverage of the latest release of ORE is sketched in Table .

<div class="center">

<div id="tab_coverage">

| Product                                         | Pricing and Cashflows | Sensitivity Analysis | Stress Testing | Exposure Simulation & XVA |
|:------------------------------------------------|:----------------------|:---------------------|:---------------|:--------------------------|
| Fixed and Floating Rate Bonds/Loans             | Y                     | Y                    | Y              | N                         |
| Interest Rate Swaps                             | Y                     | Y                    | Y              | Y                         |
| Caps/Floors                                     | Y                     | Y                    | Y              | Y                         |
| Swaptions, Callable Swaps                       | Y                     | Y                    | Y              | Y                         |
| Constant Maturity Swaps, CMS Caps/Floors        | Y                     | Y                    | Y              | Y                         |
| FX Forwards and Average Forwards                | Y                     | Y                    | Y              | Y                         |
| Cross Currency Swaps                            | Y                     | Y                    | Y              | Y                         |
| FX European and Asian Options                   | Y                     | Y                    | Y              | Y                         |
| FX Exotic Options (see below)                   | Y                     | Y                    | Y              | Y                         |
| Equity Forwards                                 | Y                     | Y                    | Y              | Y                         |
| Equity Swaps                                    | Y                     | Y                    | Y              | N                         |
| Equity European and Asian Options               | Y                     | Y                    | Y              | Y                         |
| Equity Exotic Options (see below)               | Y                     | Y                    | Y              | Y                         |
| Equity Future Options                           | Y                     | Y                    | Y              | Y                         |
| Commodity Forwards and Swaps                    | Y                     | Y                    | Y              | Y                         |
| Commodity European and Asian Options            | Y                     | Y                    | Y              | Y                         |
| Commodity Digital Options                       | Y                     | Y                    | Y              | Y                         |
| Commodity Swaptions                             | Y                     | Y                    | Y              | Y                         |
| CPI Swaps                                       | Y                     | Y                    | N              | Y                         |
| CPI Caps/Floors                                 | Y                     | Y                    | N              | N                         |
| Year-on-Year Inflation Swaps                    | Y                     | Y                    | N              | Y                         |
| Year-on-Year Inflation Caps/Floors              | Y                     | Y                    | N              | N                         |
| Credit Default Swaps, Options                   | Y                     | Y                    | N              | Y                         |
| Index Credit Default Swaps, Options             | Y                     | Y                    | N              | Y                         |
| Credit Linked Swaps                             | Y                     | Y                    | N              | Y                         |
| Index Tranches, Synthetic CDOs                  | Y                     | Y                    | N              | Y                         |
| Composite Trades                                | Y                     | Y                    | Y              | Y                         |
| Total Return Swaps and Contracts for Difference | Y                     | Y                    | Y              | Y                         |
| Convertible Bonds                               | Y                     | Y                    | Y              | N                         |
| ASCOTs                                          | Y                     | Y                    | Y              | Y                         |
| Scripted Trades                                 | Y                     | Y                    | Y              | Y                         |
| Flexi Swaps and Balance Guaranteed Swaps        | Y                     | Y                    | Y              | Y                         |

ORE product coverage. FX/Equity Exotics include Barrier, Digital,
Digital Barrier (FX only), Double Barrier, European Barrier, KIKO
Barrier (FX only), Touch and Double Touch Options, Outperformance
options and Pairwise Variance Swaps. Scripted Trades cover single and
multi-asset products across all asset classes except Credit (so far),
see Example_52 and the separate documentation in Docs/ScriptedTrade.

</div>

</div>

The simulation models applied in ORE’s risk factor evolution implement
the models discussed in detail in *Modern Derivatives Pricing and Credit
Exposure Analysis* : The IR/FX/INF/EQ risk factor evolution is based on
a cross currency model consisting of an arbitrage free combination of
Linear Gauss Markov models for all interest rates and lognormal
processes for FX rates and EQ prices, Dodgson-Kainth (or
Jarrow-Yildirim) models for inflation. The model components are
calibrated to cross currency discounting and forward curves, Swaptions,
FX Options, EQ Options and CPI caps/floors. With the 8th release,
Commodity simulation has been added, as well as the foundation for a
multi-factor Hull-White based IR/FX/COM simulation model.

## ORE in Python or Java

ORE is written in C++ and comes with a command line executable `ore.exe`
that supports batch processes. But since early versions of ORE we also
provide language bindings following QuantLib’s example using SWIG, in
ORE’s case with focus on Python and Java modules. The ORE SWIG module
extends (contains) the QuantLib SWIG module and offers moreover access
to a part of ORE’s functionality. Since ORE v9, Python *wheels* are
provided for each release, so that users can install the most recent ORE
Python module by calling

`pip install open-source-risk-engine`

See section on how to use ORE-Python.

Note that, technically, the ORE SWIG module source code has moved into
the ORE Engine repository with release 13, see directory ORE-SWIG there.
And we have removed the separate repository formerly located at
https://github.com/OpenSourceRisk/ORE-SWIG.

## Roadmap

ORE grows with community contributions and the demand of clients who
utilise ORE to replace existing risk applications with the help of the
Quant Services team at Acadia/LSEG.

Moreover, it is generally planned that subsequent ORE releases will
extend the scope of the **Regulatory Capital** analytics in ORE, with

- broader product scope of SA-CCR and BA-CVA

- addition of Market Risk capital (FRTB-SA)

**Performance:** ORE v12 contains applications of **AAD** for
sensitivity analysis, CVA sensitivity (proof-of concept stage), as well
as applications of **GPUs** to parallelize computations (see legacy
Examples 56 and 61), with significant speed-ups. Both areas are active
work in progress, and further enhancements and tests should be released
with the next versions.

**ORE Python:** Moreover, there is demand among ORE users for extended
coverage of the ORE-Python version, so that we also expect steady growth
of the Python wrapper around ORE.

**ORE Service:** ORE v12 contains an implementation of a restful API
around ORE, see folder ore/Api and the example therein. This is written
in Python, uses the ORE-Python module and the Flask web framework. This
implementation is proof of concept, for demonstration purposes and to
encourage the community to extend and contribute alternatives.

## Further Resources

- Open Source Risk Project site: <http://www.opensourcerisk.org>

- Source code and releases: <https://github.com/opensourcerisk/engine>

- Frequently Asked Questions: <http://www.opensourcerisk.org/faqs>

- Follow ORE on Twitter `@OpenSourceRisk` for updates on releases and
  events

- ORE Product Catalogue

- ORE Methodology

- ORE Academy on youtube:
  <https://www.youtube.com/channel/UCrCpkb1-s3pxKd7U-YgJulA>

### Organisation of this document

This document focuses on instructions how to use ORE to cover basic
workflows from individual deal analysis to portfolio processing. After
an overview over the core ORE data flow in section and installation
instructions in section we start in section with a series of examples
that illustrate how to launch ORE using its command line application,
and we discuss typical results and reports.

The description of products, pricing and trade representration in ORE
XML has been carved out and moved to .

And finally, a summary of methodologies applied in ORE can be found in .
