### FX KIKO Barrier Option

European exercise, American barriers.

An FX KIKO Barrier option is an option with both a knock-out and a
knock-in barrier. The knock-out barrier can happen at any time (American
barrier), and once the knock-in barrier is hit the trade becomes a
single (American) barrier knock-out trade. The KIKO option can only be
exercised (one time, European style) if the knock-out barrier is never
touched and the knock-in barrier is touched at least once.

The strike rate and barrier levels of an FX KIKO Barrier Option are
expressed as amount in SoldCurrency per unit BoughtCurrency.

The `FXKIKOBarrierOptionData` node is the trade data container for the
*FxKIKOBarrierOption* trade type.

The `FXKIKOBarrierOptionData` node includes one `OptionData` trade
component sub-node and two `BarrierData` trade component sub-nodes plus
elements specific to the FX KIKO Barrier Option. The structure of an
example `FXKIKOBarrierOptionData` node for a FX KIKO Barrier Option is
shown in Listing
<a href="#lst:fxkikobarrieroption_data" data-reference-type="ref"
data-reference="lst:fxkikobarrieroption_data">[lst:fxkikobarrieroption_data]</a>.

<div class="listing">

``` xml
        <FxKIKOBarrierOptionData>
            <OptionData>
                <LongShort>Long</LongShort>
                <!-- Bought and Sold currencies/amounts are switched for Put -->
                <OptionType>Call</OptionType>
                <Style>European</Style>
                <Settlement>Cash</Settlement>
                <ExerciseDates>
                 <ExerciseDate>2021-12-14</ExerciseDate>
                </ExerciseDates>                
                ...
            </OptionData>
            <Barriers>
                <BarrierData>
                    <Type>UpAndIn</Type>
                    <Levels>
                        <Level>1.2</Level>
                    </Levels>
                </BarrierData>
                <BarrierData>
                    <Type>DownAndOut</Type>
                    <Levels>
                        <Level>1.2</Level>
                    </Levels>
                </BarrierData>
            </Barriers>
            <StartDate>2019-01-25</StartDate>
            <Calendar>TARGET</Calendar>
            <FXIndex>FX-ECB-EUR-USD</FXIndex>
            <BoughtCurrency>EUR</BoughtCurrency>
            <BoughtAmount>1000000</BoughtAmount>
            <SoldCurrency>USD</SoldCurrency>
            <SoldAmount>1100000</SoldAmount>
        </FxKIKOBarrierOptionData>
```

</div>

The meanings and allowable values of the elements in the
`FXKIKOBarrierOptionData` node follow below.

- OptionData: This is a trade component sub-node outlined in section
  <a href="#ss:option_data" data-reference-type="ref"
  data-reference="ss:option_data">[ss:option_data]</a>. The relevant
  fields in the `OptionData` node for an FxKIKOBarrierOption are:

  - `LongShort` The allowable values are *Long* or *Short*.

  - `OptionType` The allowable values are *Call* or *Put*.  
    *Call* means that the holder of the option, upon expiry - assuming
    knock-in or no knock-out - has the right to receive the BoughtAmount
    and pay the SoldAmount.  
    *Put* means that the Bought and Sold currencies/amounts are switched
    compared to the trade data node. For example, holder of
    BoughtCurrency EUR SoldCurrency JPY FX KIKO Barrier Call Option has
    the right to buy EUR using JPY, while holder of the Put counterpart
    has the right to buy JPY using EUR, or equivalently sell EUR for
    JPY. An alternative to define the latter option is to copy the Call
    option with following changes:  
    a) swapping BoughtCurrency with SoldCurrency, b) swapping
    BoughtAmount with SoldAmount and c) inverting the barrier level (for
    example changing 110 to 0.0090909). Here barrier level is quoted as
    amount of EUR per unit JPY, which is not commonly seen on market and
    inconsistent with the format in Call options. For these reasons,
    using Put/Call flag instead is recommended.

  - `Style` The FX KIKO Barrier Option type allows for *European* option
    exercise style only.

  - `Settlement` The allowable values are *Cash* or *Physical*.

  - An `ExerciseDates` node where exactly one ExerciseDate date element
    must be given.

  - Premiums \[Optional\]: Option premium amounts paid by the option
    buyer to the option seller.

    Allowable values: See section
    <a href="#ss:premiums" data-reference-type="ref"
    data-reference="ss:premiums">[ss:premiums]</a>

- Barriers: This node contains two barrierData nodes, one must be a
  KnockIn barrier (*UpAndIn* or *DownAndIn*) and the other must be a
  KnockOut barrier (*UpAndOut* or *DownAndOut*).

- BarrierData: This is a trade component sub-node outlined in section
  <a href="#ss:barrier_data" data-reference-type="ref"
  data-reference="ss:barrier_data">[ss:barrier_data]</a>.
  FxKIKOBarrierOptions do not currently support rebates. Level specified
  in BarrierData should be quoted as the amount in SoldCurrency per unit
  BoughtCurrency, with both currencies as defined in
  FxKIKOBarrierOptionData node. Changing the option from Call to Put or
  vice versa does not require switching the barrier level, i.e. the
  level stays quoted as SoldCurrency per unit BoughtCurrency, regardless
  of Put/Call. The node StrictComparison forces the barrier to be strict
  if *1*, default is *0*.

  - StrictComparison \[Optional\]: *0*, *1*. Defaults to *0*. If *1* in
    one of the two barriers, it will apply the StrictComparison.
    Determines how the barrier is checked as per:

    *0*: the barrier checks use $<=$, $>=$ for Out-barriers.

    *1*: the barrier checks use strict comparison $<$ and $>$ for
    Out-barriers.

- StartDate\[Optional\]: The start date for checking if a barrier has
  been breached prior to today’s date. If omitted or left blank no check
  is made and it is assumed no barrier has been breached in the past.
  Has no impact if set to today’s date or a date in the future.

  Allowable values: See `Date` in Table
  <a href="#tab:allow_stand_data" data-reference-type="ref"
  data-reference="tab:allow_stand_data">[tab:allow_stand_data]</a>.

- Calendar\[Optional\]: The calendar associated with the FX Index.
  Required if StartDate is set to a date prior to today’s date,
  otherwise optional.

  Allowable values: See Table
  <a href="#tab:calendar" data-reference-type="ref"
  data-reference="tab:calendar">[tab:calendar]</a> Calendar.

- FXIndex\[Optional\]: A reference to an FX Index source to check if the
  barrier has been breached. Required if StartDate is set to a date
  prior to today’s date, otherwise optional and can be omitted but not
  left blank.

  Allowable values: The format of the FX Index is“FX-SOURCE-CCY1-CCY2”
  as described in table
  <a href="#tab:fxindex_data" data-reference-type="ref"
  data-reference="tab:fxindex_data">[tab:fxindex_data]</a>.

- BoughtCurrency: The bought currency of the FX barrier option. See
  OptionData above for more details.

  Allowable values: See Table
  <a href="#tab:currency" data-reference-type="ref"
  data-reference="tab:currency">[tab:currency]</a> `Currency`.

- BoughtAmount: The amount in the BoughtCurrency.

  Allowable values: Any positive real number.

- SoldCurrency: The sold currency of the FX barrier option. See
  OptionData above for more details.

  Allowable values: See Table
  <a href="#tab:currency" data-reference-type="ref"
  data-reference="tab:currency">[tab:currency]</a> `Currency`.

- SoldAmount: The amount in the SoldCurrency.

  Allowable values: Any positive real number.

Note that FX KIKO Options also cover Precious Metals, i.e. with
currencies XAU, XAG, XPT, XPD, and Cryptocurrencies, see supported
Cryptocurrencies in Table
<a href="#tab:currency" data-reference-type="ref"
data-reference="tab:currency">[tab:currency]</a>.
