## Calendar Adjustment: `calendaradjustment.xml`

This file `calendaradjustment.xml` list out all additional holidays and
business days that are added to a specified calendar in ORE. These dates
would originally be missing from the calendar and has to be added.The
general structure is shown in listing
<a href="#lst:calendar_adjustment" data-reference-type="ref"
data-reference="lst:calendar_adjustment">[lst:calendar_adjustment]</a>.
In this example, two additional dates had been added to the calendar
“Japan”, one additional holiday and one additional business day. If the
user is not certain whether the date is already included or not, adding
it to the `calendaradjustment.xml` to be safe won’t raise any errors. A
sample `calendaradjustment.xml` file can be found in the global example
input directory. However, it is only used in Example_1.

<div class="longlisting">

``` xml
<CalendarAdjustments>
  <Calendar name="Japan">
    <AdditionalHolidays>
      <Date>2020-01-01</Date>
    </AdditionalHolidays>
    <AdditionalBusinessDays>
      <Date>2020-01-02</Date>
    </AdditionalBusinessDays>
</CalendarAdjustments>
```

</div>

If the parameter `BaseCalendar` is provided then a new calendar will be
created using the specified calendar as a base, and adding any
`AdditionalHolidays` or `AdditionalBusinessDays`. In the example below a
new calendar `CUSTOM_Japan` is being created, it will include any
additional holidays or business days specified in the original `Japan`
calendar plus one additional date.

If a new calendar is added in this way and the schema is being used to
validate XML input, the corresponding calendar name must be prefixed
with ‘CUSTOM\_’.

<div class="longlisting">

------------------------------------------------------------------------

``` xml
<CalendarAdjustments>
  <Calendar name="CUSTOM_Japan">
    <BaseCalendar>Japan</BaseCalendar>
    <AdditionalHolidays>
      <Date>2020-04-06</Date>
    </AdditionalHolidays>
</CalendarAdjustments>
```

</div>
