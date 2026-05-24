### Fixed Leg Data and Rates

The `FixedLegData` trade component node is used within the `LegData`
trade component when the `LegType` element is set to *Fixed*. The
`FixedLegData` node only includes the `Rates` sub-node which contains
the rates of the fixed leg as child elements of type `Rate`.

An example of a `FixedLegData` node for a fixed leg with constant
notional is shown in Listing
<a href="#lst:fixedleg_data" data-reference-type="ref"
data-reference="lst:fixedleg_data">[lst:fixedleg_data]</a>.

<div class="listing">

``` xml
              <FixedLegData>
                    <Rates>
                        <Rate>0.05</Rate>
                    </Rates>
              </FixedLegData>
```

</div>

The meanings and allowable values of the elements in the `FixedLegData`
node follow below.

- Rates: This node contains child elements of type `Rate`. If the rate
  is constant over the life of the fixed leg, only one rate value should
  be entered. If two or more coupons have different rates, multiple rate
  values are required, each represented by a `Rate` child element. The
  first rate value corresponds to the first coupon, the second rate
  value corresponds to the second coupon, etc. If the number of coupons
  exceeds the number of rate values, the rate will be kept flat at the
  value of last entered rate for the remaining coupons. The number of
  entered rate values cannot exceed the number of coupons.

  Allowable values: Each child element can take any real number. The
  rate is expressed in decimal form, e.g. 0.05 is a rate of 5%.

  As in the case of notionals, the rate schedule can be specified with
  dates as shown in Listing
  <a href="#lst:fixedleg_data_dates" data-reference-type="ref"
  data-reference="lst:fixedleg_data_dates">[lst:fixedleg_data_dates]</a>.

  <div class="listing">

  ``` xml
                <FixedLegData>
                      <Rates>
                          <Rate>0.05</Rate>
                          <Rate startDate='2016-02-04'>0.05</Rate>
                          <Rate startDate='2019-02-05'>0.05</Rate>
                      </Rates>
                </FixedLegData>
  ```

  </div>
