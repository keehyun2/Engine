### Synthetic CDO

A Synthetic CDO is set up using a `CdoData` block as shown in listing
<a href="#lst:cdodata" data-reference-type="ref"
data-reference="lst:cdodata">[lst:cdodata]</a>.

<div class="listing">

``` xml
    <CdoData>
      <Qualifier> ItraxxEuropeS9V1 </Qualifier>
      <ProtectionStart> 20140425 </ProtectionStart>
      <UpfrontDate/>
      <UpfrontFee/>
      <AttachmentPoint>0.12</AttachmentPoint>
      <DetachmentPoint>0.22</DetachmentPoint>
      <SettlesAccrual>Y</SettlesAccrual>
      <ProtectionPaymentTime>atDefault</ProtectionPaymentTime>
      <!-- Premium leg -->
      <LegData>
          ...
      </LegData>
      <!-- Basket -->
      <BasketData>
        ...
      </BasketData>
    </CdoData>
```

</div>

The meanings of the elements of the `CdoData` node follow below:

- Qualifier: Used to reference the relevant base correlation curve

- ProtectionStart: The first date where a default event will trigger the
  contract

- UpfrontDate\[Optional\]: Settlement date for the upfront payment.

- UpfrontFee\[Optional\]: The upfront payment, expressed as a rate, to
  be multiplied by notional amount.

- LegData: Premium leg description as in an Index CDS (see section
  <a href="#ss:indexcds" data-reference-type="ref"
  data-reference="ss:indexcds">[ss:indexcds]</a>) with notional
  correspondig to the initial tranche notional

- BasketData: Underlying basket description as in an Index CDS (see
  section <a href="#ss:indexcds" data-reference-type="ref"
  data-reference="ss:indexcds">[ss:indexcds]</a>)

- AttachmentPoint: Losses where protection starts, expressed as a
  fraction of the basket notional

- DetachmentPoint: Losses where protection end, expressed as a fraction
  of the basket notional
