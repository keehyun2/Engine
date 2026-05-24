### Leg Data with Amortisation Structures

Amortisation structures can (optionally) be added to a leg as indicated
in the following listing
<a href="#lst:amortisations" data-reference-type="ref"
data-reference="lst:amortisations">[lst:amortisations]</a>, within a
block of information enclosed by `<Amortizations>` and
` </Amortizations>` tags. Note that `<Amortizations>` structures are not
supported for trade type CapFloor.

<div class="listing">

``` xml
      <LegData>
        <LegType> ... </LegType>
        <Payer> ... </Payer>
        <Currency> ... </Currency>
        <Notionals>
          <Notional>10000000</Notional>
        </Notionals>
        <Amortizations>
          <AmortizationData>
            <Type>FixedAmount</Type>
            <Value>1000000</Value>
            <StartDate>20170203</StartDate>
            <Frequency>1Y</Frequency>
            <Underflow>false</Underflow>
          </AmortizationData>
          <AmortizationData>
            ...
          </AmortizationData>
        </Amortizations>
        ...
      </LegData>
```

</div>

The user can specify a sequence of `AmortizationData` items in order to
switch from one kind of amortisation to another etc. Within each
`AmortisationData` block the meaning of elements is

- Type: Amortisation type with allowable values *FixedAmount,
  RelativeToInitialNotional, RelativeToPreviousNotional, Annuity,
  LinearToMaturity.*

- Value \[optional\]: Interpreted depending on `Type`, see below.
  Required for all types except LinearToMaturity.

- StartDate \[optional\]: Amortisation starts on first schedule date on
  or beyond StartDate. If not given, amortisation starts in first
  schedule period. If more than one AmortizationData block is specified,
  the StartDate is mandatory for all blocks except the first.

- EndDate \[optional\]: Amortization is applied for schedule periods
  with start date before EndDate. If more than one AmortizationData
  block is specified, the EndDate is mandatory for all blocks except the
  last.

- Frequency, entered as a period \[optional\]: Frequency of
  amortisations. If not given, an amortization is applied in each
  schedule period, otherwise in each $n$th period, where $n$ is
  determined from Frequency. Amortizations are always applied to whole
  periods though, i.e. not within a period. The frequency is ignored for
  type Annuity, in which case an amortisation is applied in each period.

- Underflow \[optional\]: Allow amortisation below zero notional if
  `true`, otherwise amortisation stops at zero notional. Defaults to
  false;

The amortisation data block’s `Value` element is interpreted depending
on the chosen `Type`:

- FixedAmount: The value is interpreted as a notional amount to be
  subtracted from the current notional on each amortisation date.

- RelativeToInitialNotional: The value is interpreted as a fraction of
  the **initial** notional to be subtraced from the current notional on
  each amortisation date.

- RelativeToPreviousNotional: The value is interpreted as a fraction of
  the **previous** notional to be subtraced from the previous notional
  to get the current notional on each amortisation date.

- Annuity: The value is interpreted as annuity amount (redemption plus
  coupon).

- LinearToMaturity: The value is not relevant, and does not need to be
  provided.

Annuity type amortisation is supported for fixed rate legs as well as
floating (ibor) legs.

Note:

- Floating annuities require at least one previous vanilla coupon in
  order to work out the first amortisation amount.

- Floating legs with annuity amortisation currently do not allow
  switching the amortisation type, i.e. only a single block of
  ` AmortizationData`.
