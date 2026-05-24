### Schedule Data (Rules, Dates and Derived)

The `ScheduleData` trade component node is used within the `LegData`
trade component. The Schedule can be rules based (at least one `Rules`
sub-node exists), dates based (at least one `Dates` sub-node exists,
where the schedule is determined directly by `Date` child elements), or
derived from another schedule in the same leg (at least one `Derived`
sub-node exists). In rules based schedules, the schedule dates are
generated from a set of rules based on the entries of the sub-node
Rules, having the elements `StartDate`, `EndDate`, `Tenor`, `Calendar`,
`Convention`, `TermConvention`, and `Rule`. Example structures of
`ScheduleData` nodes based on rules, dates and derived from a base
schedule are shown in Listing
<a href="#lst:schedule_data_true" data-reference-type="ref"
data-reference="lst:schedule_data_true">[lst:schedule_data_true]</a>,
Listing <a href="#lst:schedule_data_false" data-reference-type="ref"
data-reference="lst:schedule_data_false">[lst:schedule_data_false]</a>,
and Listing
<a href="#lst:schedule_data_derived" data-reference-type="ref"
data-reference="lst:schedule_data_derived">[lst:schedule_data_derived]</a>
respectively.

<div class="listing">

``` xml
              <ScheduleData>
                <Rules>
                  <StartDate>2013-02-01</StartDate>
                  <EndDate>2030-02-01</EndDate>
                  <Tenor>1Y</Tenor>
                  <Calendar>UK</Calendar>
                  <Convention>MF</Convention>
                  <TermConvention>MF</TermConvention>
                  <Rule>Forward</Rule>
                </Rules>
              </ScheduleData>
```

</div>

<div class="listing">

``` xml
              <ScheduleData>
                <Dates>
                  <Calendar>NYB</Calendar>
                  <Convention>Following</Convention>
                  <Tenor>3M</Tenor>
                  <EndOfMonth>false</EndOfMonth>
                  <EndOfMOnthConvention>Following</EndOfMOnthConvention>
                  <IncludeDuplicateDates>false</IncludeDuplicateDates>
                  <Dates>
                    <Date>2012-01-06</Date>
                    <Date>2012-04-10</Date>
                    <Date>2012-07-06</Date>
                    <Date>2012-10-08</Date>
                    <Date>2013-01-07</Date>
                    <Date>2013-04-08</Date>
                  </Dates>
                </Dates> 
              </ScheduleData>
```

</div>

<div class="listing">

``` xml
              <ScheduleData>
                <Derived>
                  <BaseSchedule>ScheduleData</BaseSchedule>
                  <Shift>3M</Shift>
                  <Calendar>GBP</Calendar>
                  <Convention>Following</Convention>
                </Derived> 
              </ScheduleData>
```

</div>

The ScheduleData section can contain any number and combination of
`<Dates>`, `<Rules>` and `<Derived>` sections. The resulting schedule
will then be an ordered concatenation of individual schedules.

The meanings and allowable values of the elements in a `<Rules>` based
section of the `ScheduleData` node follow below.

- `Rules`: a sub-node that determines whether the schedule is set by
  specifying rules that generate the schedule. If existing, the
  following entries are required: `StartDate`, `EndDate`, `Tenor`,
  `Calendar`, `Convention`, and `Rule`. `EndDateConvention` is optional.
  If not existing, a `Dates` or `Derived` sub-node is required.

- `StartDate`: The schedule start date.

  Allowable values: See `Date` in Table
  <a href="#tab:allow_stand_data" data-reference-type="ref"
  data-reference="tab:allow_stand_data">[tab:allow_stand_data]</a>.

- `EndDate`: The schedule end date. This can be omitted to indicate a
  perpetual schedule. Notice that perpetual schedule are only supported
  by specific trade types (e.g. Bond).

  Allowable values: See `Date` in Table
  <a href="#tab:allow_stand_data" data-reference-type="ref"
  data-reference="tab:allow_stand_data">[tab:allow_stand_data]</a>.

- `AdjustEndDateToPreviousMonthEnd` \[Optional\]: Only relevant for
  commodity legs. Allows for the `EndDate` to be on a date other than
  the end of the month. If set to *true* the given `EndDate` is restated
  to the end date of the previous month.

  Allowable values: *true* or *false*. Defaults to false if left blank
  or omitted.

- `Tenor`: The tenor used to generate schedule dates.

  Allowable values: A string where the last character must be *D* or *W*
  or *M* or *Y*. The characters before that must be a positive
  integer.  
  *D* $=$ Day, *W* $=$ Week, *M* $=$ Month, *Y* $=$ Year

  Note that *0D* and *1T* are equivalent valid values, and both cause
  there to be no intermediate dates between `StartDate` and `EndDate`.

- `Calendar`: The calendar used to generate schedule dates. Also used to
  determine payment dates (except for compounding OIS index legs, which
  use the index calendar to determine payment dates).

  Allowable values: See Table
  <a href="#tab:calendar" data-reference-type="ref"
  data-reference="tab:calendar">[tab:calendar]</a> Calendar.

- `Convention`: Determines the adjustment of the schedule dates with
  regards to the selected calendar, i.e. the roll convention.

  Allowable values: See Table
  <a href="#tab:convention" data-reference-type="ref"
  data-reference="tab:convention">[tab:convention]</a> Roll Convention.

- `TermConvention` \[Optional\]: Determines the adjustment of the final
  schedule date with regards to the selected calendar. If left blank or
  omitted, defaults to the value of `Convention`.

  Allowable values: See Table
  <a href="#tab:convention" data-reference-type="ref"
  data-reference="tab:convention">[tab:convention]</a> Roll Convention.

- `Rule` \[Optional\]: Rule for the generation of the schedule using
  given start and end dates, tenor, calendar and roll conventions.

  Allowable values and descriptions: See Table
  <a href="#tab:rule" data-reference-type="ref"
  data-reference="tab:rule">[tab:rule]</a> Rule. Defaults to *Forward*
  if omitted. Cannot be left blank.

- `EndOfMonth` \[Optional\]: Specifies whether the date generation rule
  is different for end of month, so that the last date of each month is
  generated, regardless of number of days in the month.

  If `EndOfMonth` is *true*, and `EndOfMonthConvention` is omitted:  
  - the date is set to the last calendar day in a month if the roll
  convention is *Unadjusted*, and  
  - the date is set to the last business day in a month if the roll
  convention is anything other than *Unadjusted*

  Allowable values: Boolean node, allowing *Y, N, 1, 0, true, false*
  etc. The full set of allowable values is given in Table
  <a href="#tab:boolean_allowable" data-reference-type="ref"
  data-reference="tab:boolean_allowable">[tab:boolean_allowable]</a>.
  Defaults to *false* if left blank or omitted. Must be set to *false*
  or omitted if the date generation Rule is set to *CDS* or *CDS2015*.

- `EndOfMonthConvention` \[Optional\]: Determines the adjustment of the
  end-of-month schedule dates with regards to the selected calendar.
  This field is only used when `EndOfMonth` is *true*. If left blank or
  omitted, then the default *Preceding* / *MF* convention is applied
  (i.e. end-of-month dates will never be adjusted over to the beginning
  of the next month)

  Allowable values: See Table
  <a href="#tab:convention" data-reference-type="ref"
  data-reference="tab:convention">[tab:convention]</a> Roll Convention.

  Allowable values: Boolean node, allowing *Y, N, 1, 0, true, false*
  etc. The full set of allowable values is given in Table
  <a href="#tab:boolean_allowable" data-reference-type="ref"
  data-reference="tab:boolean_allowable">[tab:boolean_allowable]</a>.
  Defaults to *false* if left blank or omitted. Must be set to *false*
  or omitted if the date generation Rule is set to *CDS* or *CDS2015*.

- `FirstDate` \[Optional\]: Date for initial stub period, determining
  the end date of the first period. If omitted the first period will
  follow the date generation rule. Note that for date generation rules
  *CDS* and *CDS2015*, the FirstDate has no impact and the schedule is
  built from IMM dates.

  Allowable values: See `Date` in Table
  <a href="#tab:allow_stand_data" data-reference-type="ref"
  data-reference="tab:allow_stand_data">[tab:allow_stand_data]</a>. The
  FirstDate cannot be before the StartDate of the Schedule, and cannot
  be after the EndDate of the Schedule.

- `LastDate` \[Optional\]: Date for final stub period, determining the
  start date of the last period. If omitted the last period will follow
  the date generation rule. For date generation rules *CDS* and
  *CDS2015*, the LastDate has no impact and the schedule is built from
  IMM dates.

  Allowable values: See `Date` in Table
  <a href="#tab:allow_stand_data" data-reference-type="ref"
  data-reference="tab:allow_stand_data">[tab:allow_stand_data]</a>. The
  LastDate cannot be after the EndDate of the Schedule, and cannot be
  before the StartDate of the Schedule.

- `RemoveFirstDate` \[Optional\]: If true the first date will be removed
  from the schedule. Useful to define a payment schedule using the rules
  for a calculation schedule.

  Allowable values: true, false

- `RemoveLastDate` \[Optional\]: If true the last date will be removed
  from the schedule. Useful to define a fixing or reset schedule using
  the rules for a calculation schedule.

  Allowable values: true, false

The meanings and allowable values of the elements in a `<Dates>` based
section of the `ScheduleData` node follow below.

- `Dates`: a sub-node that determines that the schedule is set by
  specifying schedule dates explicitly.

- `Calendar` \[Optional\]: Calendar used to determine the accrual
  schedule dates. Also used to determine payment dates (except for
  compounding OIS index legs, which use the index calendar), and also to
  compute day count fractions for irregular periods when day count
  convention is ActActISMA and the schedule is dates based.

  Allowable values: See Table
  <a href="#tab:calendar" data-reference-type="ref"
  data-reference="tab:calendar">[tab:calendar]</a> Calendar. Defaults to
  *NullCalendar* if omitted, i.e. no holidays at all, not even on
  weekends.

- `Convention` \[Optional\]: Roll Convention to determine the accrual
  schedule dates, and also used to compute day count fractions for
  irregular periods when day count convention is ActActISMA and the
  schedule is dates based.

  Allowable values: See Table
  <a href="#tab:convention" data-reference-type="ref"
  data-reference="tab:convention">[tab:convention]</a> Roll Convention.
  Defaults to *Unadjusted* if omitted.

- `Tenor` \[Optional\]: Tenor used to compute day count fractions for
  irregular periods when day count convention is ActActISMA and the
  schedule is dates based.

  Allowable values: A string where the last character must be *D* or *W*
  or *M* or *Y*. The characters before that must be a positive
  integer.  
  *D* $=$ Day, *W* $=$ Week, *M* $=$ Month, *Y* $=$ Year

  Defaults to *null* if omitted.

- `EndOfMonth` \[Optional\]: Specifies whether the end of month
  convention is applied when calculating reference periods for irregular
  periods when the day count convention is ActActICMA and the schedule
  is dates based.

  Allowable values: Boolean node, allowing *Y, N, 1, 0, true, false*
  etc. The full set of allowable values is given in Table
  <a href="#tab:boolean_allowable" data-reference-type="ref"
  data-reference="tab:boolean_allowable">[tab:boolean_allowable]</a>.
  Defaults to *false* if left blank or omitted.

- `EndOfMonthConvention` \[Optional\]: Whenever the `EndOfMonth` logic
  is applied, this is used as the roll convention along with the
  `Calendar`for any date adjustments.

  Allowable values: See Table
  <a href="#tab:convention" data-reference-type="ref"
  data-reference="tab:convention">[tab:convention]</a> Roll Convention.
  Defaults to *Preceding* if omitted.

- `IncludeDuplicateDates` \[Optional\]: If set to *false* the resulting
  schedule will have unique set of dates and all duplicates will be
  removed. Default to *false*.

- `Dates`: This is a sub-sub-node and contains child elements of type
  `Date`. In this case the schedule dates are determined directly by the
  `Date` child elements. At least two `Date` child elements must be
  provided. Dates must be provided in chronological order. Note that if
  no calendar and roll convention is given, the specified dates must be
  given as adjusted dates.

  Allowable values: Each `Date` child element can take the allowable
  values listed in `Date` in Table
  <a href="#tab:allow_stand_data" data-reference-type="ref"
  data-reference="tab:allow_stand_data">[tab:allow_stand_data]</a>.

The meanings and allowable values of the elements in a `<Derived>`
section of the `ScheduleData` node follow below.

- `BaseSchedule`: The schedule from which the derived schedule will be
  deduced.

  Allowable values: Must be the node name of another schedule in a given
  leg data node.

- `Shift` \[Optional\]: The tenor/period offset to be applied to each
  date in the base schedule in order to obtain the derived schedule.

  Allowable values: A string where the last character must be *D* or *W*
  or *M* or *Y*. The characters before that must be a positive
  integer.  
  *D* $=$ Day, *W* $=$ Week, *M* $=$ Month, *Y* $=$ Year. If left blank
  or omitted, defaults to *0D*.

- `Calendar` \[Optional\]: The calendar adjustment to be applied to each
  date in the base schedule in order to obtain the derived schedule.

  Allowable values: See Table
  <a href="#tab:calendar" data-reference-type="ref"
  data-reference="tab:calendar">[tab:calendar]</a> Calendar. Defaults to
  *NullCalendar* if left blank or omitted, i.e. no holidays at all, not
  even on weekends.

- `Convention` \[Optional\]: The roll convention to be applied to each
  date in the base schedule in order to obtain the derived schedule.

  Allowable values: See Table
  <a href="#tab:convention" data-reference-type="ref"
  data-reference="tab:convention">[tab:convention]</a> Roll Convention.
  Defaults to *Unadjusted* if left blank or omitted.

- `RemoveFirstDate` \[Optional\]: If true the first date will be removed
  from the schedule. Useful to define a payment schedule based on a
  calculation schedule.

  Allowable values: true, false

- `RemoveLastDate` \[Optional\]: If true the last date will be removed
  from the schedule. Useful to define a fixing or reset schedule based
  on a calculation schedule.

  Allowable values: true, false
