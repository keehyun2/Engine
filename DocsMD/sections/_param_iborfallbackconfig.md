## Ibor Fallback Config: `iborFallbackConfig.xml`

The Ibor Fallback Configuration represents the rules for replacing Ibor
reference rates by risk free rates. If no configuration is specified, a
standard configuration is used. Specifying a custom configuration mainly
serves testing purposes. The fields are:

- EnableIborFallbacks: If false, Ibor fallbacks are disabled.

- UseRfrCurveInTodaysMarket: If true, the todays market Ibor forwarding
  curve for a replaced Ibor index is built using the RfrIndex OIS curve
  and the Spread.

- UseRfrCurveInSimulationMarket: If true, the simulation market Ibor
  forward curve for a replaced Ibor index is built using the RfrIndex
  OIS curve and the Spread.

- Fallback: Each Ibor index to be replaced is declared by

  - IborIndex: the Ibor index name

  - RfrIndex: the rfr index name

  - Spread: the spread to apply to the rfr rate

  - SwitchDate: the date on which the fallback is used

``` xml
<IborFallbackConfig>
    <GlobalSettings>
        <EnableIborFallbacks>true</EnableIborFallbacks>
        <UseRfrCurveInTodaysMarket>true</UseRfrCurveInTodaysMarket>
        <UseRfrCurveInSimulationMarket>true</UseRfrCurveInSimulationMarket>
    </GlobalSettings>
    <Fallbacks>
        <Fallback>
            <IborIndex>CHF-LIBOR-12M</IborIndex>
            <RfrIndex>CHF-SARON</RfrIndex>
            <Spread>0.0020479999999999999</Spread>
            <SwitchDate>2022-01-01</SwitchDate>
        </Fallback>
        <Fallback>
            <IborIndex>CHF-LIBOR-1M</IborIndex>
            <RfrIndex>CHF-SARON</RfrIndex>
            <Spread>-0.000571</Spread>
            <SwitchDate>2022-01-01</SwitchDate>
        </Fallback>
        ....
```
