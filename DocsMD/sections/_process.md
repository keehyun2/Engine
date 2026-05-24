# ORE Data Flow

The core processing steps followed in ORE to produce risk analytics
results are sketched in Figure
<a href="#fig_process" data-reference-type="ref"
data-reference="fig_process">1</a>. All ORE calculations and outputs are
generated in three fundamental process steps as indicated in the three
boxes in the upper part of the figure. In each of these steps
appropriate data (described below) is loaded and results are generated,
either in the form of a human readable report, or in an intermediate
step as pure data files (e.g. NPV data, exposure data).

<figure id="fig_process">
<div class="center">
<embed src="process.pdf" />
</div>
<figcaption>Sketch of the ORE process, inputs and outputs. </figcaption>
</figure>

The overall ORE process needs to be parametrised using a set of
configuration XML files which is the subject of section
<a href="#sec:configuration" data-reference-type="ref"
data-reference="sec:configuration">[sec:configuration]</a>. The
portfolio is provided in XML format which is explained in detail in and
<a href="#sec:nettingsetinput" data-reference-type="ref"
data-reference="sec:nettingsetinput">[sec:nettingsetinput]</a>. Note
that ORE comes with ‘Schema’ files for all supported products so that
any portfolio xml file can be validated before running through ORE.
Market data is provided in a simple three-column text file with unique
human-readable labelling of market data points, as explained in section
<a href="#sec:market_data" data-reference-type="ref"
data-reference="sec:market_data">[sec:market_data]</a>.  
The first processing step (upper left box) then comprises

- loading the portfolio to be analysed,

- building any yield curves or other ‘term structures’ needed for
  pricing,

- calibration of pricing and simulation models.

The second processing step (upper middle box) is then

- portfolio valuation, cash flow generation,

- going forward - conventional risk analysis such as sensitivity
  analysis and stress testing, standard-rule capital calculations such
  as SA-CCR, etc,

- and in particular, more time-consuming, the market simulation and
  portfolio valuation through time under Monte Carlo scenarios.

This process step produces several reports (NPV, cashflows etc) and in
particular an **NPV cube**, i.e. NPVs per trade, scenario and future
evaluation date. The cube is written to a file in both condensed binary
and human-readable text format.  
The third processing step (upper right box) performs more
‘sophisticated’ risk analysis by post-processing the NPV cube data:

- aggregating over trades per netting set,

- applying collateral rules to compute simulated variation margin as
  well as simulated (dynamic) initial margin posting,

- computing various XVAs including CVA, DVA, FVA, MVA for all netting
  sets, with and without taking collateral (variation and initial
  margin) into account, on demand with allocation to the trade level.

The outputs of this process step are XVA reports and the ‘net’ NPV cube,
i.e. after aggregation, netting and collateral.  
The example section <a href="#sec:examples" data-reference-type="ref"
data-reference="sec:examples">[sec:examples]</a> demonstrates for
representative product types how the described processing steps can be
combined in a simple batch process which produces the mentioned reports,
output files and exposure evolution graphs in one ’go’.
