## Historical Return Configuration

The `ReturnConfiguration` allows the user to specify, for each risk
factor type, how historical returns are computed in historical scenario
generation and backtesting. This configuration controls the return type
(e.g., log, absolute, relative) and an optional displacement for each
risk factor. Additionally, it is possible to override the default return
configuration for specific names (e.g., for a particular equity or
commodity).

The root element is `ReturnConfiguration`, which contains one or more
`<Return>` blocks. Each `Return` must have a `key` attribute, either the
risk factor key type for the default configuration (e.g.,
`DiscountCurve`, `FXSpot`, `EquitySpot`, etc.). or the risk factor key
type plus the underlying name for a specific override (e.g
`EquitySpot/EQUITY1`.

<div class="listing">

``` xml
<ReturnConfiguration>
    <Return key="DiscountCurve">
        <Type>Log</Type>
        <Displacement>0.0</Displacement>
    </Return>
    <Return key="EquitySpot">
        <Type>Relative</Type>
        <Displacement>0.0</Displacement>
    </Return>
    <Return key="EquitySpot/EQUITY_1">
        <Type>Absolute</Type>
        <Displacement>0.0</Displacement>
    </Return>
    <!-- ... more configurations ... -->    
</ReturnConfiguration>
```

</div>

### Elements and Attributes

- `Return key="..."`: Specifies the configuration for a risk factor
  type. The `key` attribute must match a valid risk factor key type or
  the specific key type and name.

  - `Type`: The return type. Allowed values are `Log`, `Absolute`, and
    `Relative`.

  - `Displacement`: The displacement value (floating point). Used to
    avoid division by zero or negative values in relative/log returns.

### Notes

- If no override is specified for a particular name, the default return
  configuration for the risk factor type is used.

- The displacement should be set to a small positive value if the risk
  factor can approach zero, to avoid numerical issues.
