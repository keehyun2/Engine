### Generic Scripted Products

The products in sections
<a href="#sec:doubledigitaloption" data-reference-type="ref"
data-reference="sec:doubledigitaloption">[sec:doubledigitaloption]</a>
to <a href="#sec:tarf" data-reference-type="ref"
data-reference="sec:tarf">[sec:tarf]</a> are internally represented as
*Scripted Trades*, but “wrapped” such that their input XML format still
looks like “classic” ORE XML.

With <a href="#sec:rainbowoption" data-reference-type="ref"
data-reference="sec:rainbowoption">[sec:rainbowoption]</a> and
<a href="#SubSectionExoticVarianceSwap" data-reference-type="ref"
data-reference="SubSectionExoticVarianceSwap">[SubSectionExoticVarianceSwap]</a>
we have seen two examples of the generic Scripted Trade input format.

The Scripted Trade module allows flexible definition of new payoffs
across five of the six asset classes covered in ORE, just by way of
defining the payoff script. The payoff script can be embedded into the
trade XML or can be placed into a separate script library.

Refer to the stand-alone Scripted Trade documentation in
ore/Docs/ScriptedTrade or section
<a href="#app:scriptedtrade" data-reference-type="ref"
data-reference="app:scriptedtrade">[app:scriptedtrade]</a> for an
introduction.
