### Commodity Option Strip

The structure of a trade node representing a commodity option strip is
shown in listing
<a href="#lst:commodity_option_strip" data-reference-type="ref"
data-reference="lst:commodity_option_strip">[lst:commodity_option_strip]</a>.
This node can be used to represent a strip of commodity average price
options as described in section
<a href="#ss:input_commodityapo" data-reference-type="ref"
data-reference="ss:input_commodityapo">[ss:input_commodityapo]</a> or a
strip of European commodity options as described in section
<a href="#ss:input_commodity_option" data-reference-type="ref"
data-reference="ss:input_commodity_option">[ss:input_commodity_option]</a>.
It consists of the generic `Envelope` and the specific
`CommodityOptionStripData` node.

The `CommodityOptionStripData` node has a `LegData` node with `LegType`
set to `CommodityFloating`. This `LegData` node is described in detail
in sections <a href="#ss:commodityfloatingleg" data-reference-type="ref"
data-reference="ss:commodityfloatingleg">[ss:commodityfloatingleg]</a>
and <a href="#ss:commodity_floating_leg_data" data-reference-type="ref"
data-reference="ss:commodity_floating_leg_data">[ss:commodity_floating_leg_data]</a>.
Note that the `Payer` field in `CommodityFloatingLegData`, while
mandatory, has no impact on flows. The node `IsAveraged` in
`CommodityFloatingLegData` determines whether a strip of European
commodity options or a strip of APOs are created:

- If `IsAveraged` is `false`, a strip of European commodity options is
  created. There is a European put and or European call option created
  for each calculation period. The exercise date of the option in the
  calculation period is given by the *Pricing Date* in the calculation
  period using the rules outlined in section
  <a href="#ss:commodity_floating_leg_data" data-reference-type="ref"
  data-reference="ss:commodity_floating_leg_data">[ss:commodity_floating_leg_data]</a>.
  The quantity is given by the quantity in the calculation period using
  the rules outlined in section
  <a href="#ss:commodity_floating_leg_data" data-reference-type="ref"
  data-reference="ss:commodity_floating_leg_data">[ss:commodity_floating_leg_data]</a>.
  If cash settled, the cash settlement date is given by the payment date
  for the calculation period using the rules outlined in section
  <a href="#ss:commodity_floating_leg_data" data-reference-type="ref"
  data-reference="ss:commodity_floating_leg_data">[ss:commodity_floating_leg_data]</a>.

- If `IsAveraged` is `true`, a strip of commodity average price options
  is created. There is a put and or call option created for each
  calculation period. The exercise date of the option in the calculation
  period is given by the calculation period end date. The quantity is
  given by the quantity in the calculation period using the rules
  outlined in section
  <a href="#ss:commodity_floating_leg_data" data-reference-type="ref"
  data-reference="ss:commodity_floating_leg_data">[ss:commodity_floating_leg_data]</a>.

Each calculation period may contain a put and a call that may be either
bought or sold. The type of option, whether they are bought or sold and
the strike price is determined by the `Calls` and `Puts` nodes. We
describe here the settings for the `Calls` node with the understanding
that analogous descriptions apply to the `Puts` node. If the `Calls`
node is omitted, it is assumed that there are no call options in the
strip.

The `LongShorts` node may contain one `LongShort` node or the same
number of `LongShort` nodes as calculation periods. Each `LongShort`
node has the allowable values `Long` or `Short`. If `LongShort` is
`Long`, then the call option is bought and if `LongShort` is `Short`
then the call option is sold. If a single `LongShort` node is provided,
it is applied to all options in the strip. If the same number of
`LongShort` nodes as calculation periods are provided, a `LongShort`
node is applied to the option in the corresponding period. The optional
`BarrierData` node specifies the barrier terms of the options. See
section <a href="#ss:input_commodityapo" data-reference-type="ref"
data-reference="ss:input_commodityapo">[ss:input_commodityapo]</a> for
details on this. Call and put options can have different barrier terms,
but all call (resp. put) options share the same terms. In listing
<a href="#lst:commodity_option_strip" data-reference-type="ref"
data-reference="lst:commodity_option_strip">[lst:commodity_option_strip]</a>
only the call options have a barrier feature.

Similar to the `LongShorts` node, the `Strikes` node may contain one
`Strike` node or the same number of `Strike` nodes as calculation
periods. If only one is provided, this strike applies to all options in
the strip. If the same number of `Strike` nodes as calculation periods
are provided, a `Strike` node is applied to the option in the
corresponding period. In this way, we support varying strikes across
options in the strip. At least one of `Calls` or `Puts` needs to be
provided for a valid option strip to be created.

The `Premiums` node allows for the addition of premiums. If the
`PremiumAmount` is negative, it is paid and if it is positive, it is
received. See <a href="#ss:premiums" data-reference-type="ref"
data-reference="ss:premiums">[ss:premiums]</a>.

The optional `Style` node can be set to `European` or `American` to
change the exercise style for the strip of options. If not set,
`European` is assumed. If the strip is a strip of APOs, `European` is
assumed and a warning is issued if `Style` is not `European`.

The optional `Settlement` node can be set to `Cash` or `Physical` to
change the settlement method for the strip of options. If not set,
`Cash` is assumed. If the strip is a strip of APOs, `Cash` is assumed
and a warning is issued if `Settlement` is not `Cash`.

The optional `IsDigital` node allows the creation of a strip of
`CommodityDigitalOption`s (see
<a href="#ss:input_commodity_digital_option" data-reference-type="ref"
data-reference="ss:input_commodity_digital_option">[ss:input_commodity_digital_option]</a>).
If set to `true` the node `PayoffPerUnit` needs to be set.

Node `PayoffPerUnit` \[Optional\] specifies the payoff per commodity
unit, expressed in leg currency, in case a digital option is exercised.
If the trade is a strip of digital options, this node must be set. It
accepts real numbers as input.

<div class="listing">

``` xml
<Trade id="...">
  <TradeType>CommodityOptionStrip</TradeType>
  <Envelope>
    ...
  </Envelope>
  <CommodityOptionStripData>
    <LegData>
      <LegType>CommodityFloating</LegType>
      ...
    </LegData>
    <Calls>
      <LongShorts>
        <LongShort>Short</LongShort>
      </LongShorts>
      <Strikes>
        <Strike>5.3</Strike>
      </Strikes>
      <BarrierData>
        <Type>UpAndIn</Type>
        <Style>American</Style>
        <LevelData>
          <Level>
            <Value>70.0</Value>
          </Level>
        </LevelData>
      </BarrierData>
    </Calls>
    <Puts>
      <LongShorts>
        <LongShort>Long</LongShort>
      </LongShorts>
      <Strikes>
        <Strike>8.17</Strike>
      </Strikes>
    </Puts>
    <Premiums> ... </Premiums>
    <Style>European</Style>
    <Settlement>Cash</Settlement>
  </CommodityOptionStripData>
</Trade>
```

</div>
