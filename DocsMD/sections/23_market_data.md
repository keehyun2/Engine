# Market Data

In this section we discuss the market data, which enters into the
calibration of OREs risk factor evolution models. Market data in the
`market.txt` file is given in three columns; Date, Quote and Quote
value.

- **Date**: The as of date of the market quote value.

  Allowable values: See `Date` in Table
  <a href="#tab:allow_stand_data" data-reference-type="ref"
  data-reference="tab:allow_stand_data">[tab:allow_stand_data]</a>.

- **Quote**: A generic description that contains Instrument Type and
  Quote Type, followed by instrument specific descriptions (see
  <a href="#ss:zero_rate" data-reference-type="ref"
  data-reference="ss:zero_rate">1.1</a> ff.). The base of a quote
  consists of InstType/QuoteType followed by instrument specific
  information separated by slashes "/".

  Allowable values for Instrument Types and Quote Types are given in
  Table <a href="#tab:allow_market_data" data-reference-type="ref"
  data-reference="tab:allow_market_data">1</a>.

- **Quote Value**: The market quote value in decimal form for the given
  quote on the given as of date. Quote values are assumed to be
  mid-market.

  Allowable values: Any real number.

<div id="tab:allow_market_data">

| **Market Data Parameter** | **Allowable Values**                                                                                                                                                                                                                                                                                                                                                                                          |
|:--------------------------|:--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| Instrument Type           | *ZERO, DISCOUNT, MM, MM_FUTURE, FRA, IMM_FRA, IR_SWAP, BASIS_SWAP, CC_BASIS_SWAP, CDS, CDS_INDEX, FX_SPOT, FX_FWD, SWAPTION, CAPFLOOR, FX_OPTION, HAZARD_RATE, RECOVERY_RATE, ASSUMED_RECOVERY_RATE, ZC_INFLATIONSWAP, YY_INFLATIONSWAP, ZC_INFLATIONCAPFLOOR, SEASONALITY, EQUITY_SPOT, EQUITY_FWD, EQUITY_DIVIDEND, EQUITY_OPTION, BOND, INDEX_CDS_OPTION, CPR, COMMODITY, COMMODITY_FWD, COMMODITY_OPTION* |
| Quote Type                | *BASIS_SPREAD, CREDIT_SPREAD, CONV_CREDIT_SPREAD, YIELD_SPREAD, HAZARD_RATE, RATE, RATIO, PRICE, RATE_LNVOL, RATE_NVOL, RATE_SLNVOL, BASE_CORRELATION, SHIFT*                                                                                                                                                                                                                                                 |

Allowable values for Instrument and Quote type market data.

</div>

An excerpt from a typical `market.txt` file is shown in Listing
<a href="#lst:market_txt" data-reference-type="ref"
data-reference="lst:market_txt">[lst:market_txt]</a>.

<div class="listing">

``` xml
2011-01-31 MM/RATE/EUR/0D/1D 0.013750
2011-01-31 MM/RATE/EUR/1D/1D 0.010500
2011-01-31 MM/RATE/EUR/2D/1D 0.010500
2011-01-31 MM/RATE/EUR/2D/1W 0.009500
2011-01-31 MM/RATE/EUR/2D/1M 0.008700
2011-01-31 MM/RATE/EUR/2D/2M 0.009100
2011-01-31 MM/RATE/EUR/2D/3M 0.010200
2011-01-31 MM/RATE/EUR/2D/4M 0.011000

2011-01-31 FRA/RATE/EUR/3M/3M 0.013080
2011-01-31 FRA/RATE/EUR/4M/3M 0.013890
2011-01-31 FRA/RATE/EUR/5M/3M 0.014630
2011-01-31 FRA/RATE/EUR/6M/3M 0.015230

2011-01-31 IR_SWAP/RATE/EUR/2D/3M/1Y 0.014400
2011-01-31 IR_SWAP/RATE/EUR/2D/3M/1Y3M 0.015400
2011-01-31 IR_SWAP/RATE/EUR/2D/3M/1Y6M 0.016500
2011-01-31 IR_SWAP/RATE/EUR/2D/3M/2Y 0.018675
2011-01-31 IR_SWAP/RATE/EUR/2D/3M/3Y 0.022030
2011-01-31 IR_SWAP/RATE/EUR/2D/3M/4Y 0.024670
2011-01-31 IR_SWAP/RATE/EUR/2D/3M/5Y 0.026870
2011-01-31 IR_SWAP/RATE/EUR/2D/3M/6Y 0.028700
2011-01-31 IR_SWAP/RATE/EUR/2D/3M/7Y 0.030125
2011-01-31 IR_SWAP/RATE/EUR/2D/3M/8Y 0.031340
2011-01-31 IR_SWAP/RATE/EUR/2D/3M/9Y 0.032450
```

</div>

## Zero Rate

The instrument specific information to be captured for quotes
representing Zero Rates is shown in Table
<a href="#tab:zero_quote" data-reference-type="ref"
data-reference="tab:zero_quote">2</a>.

<div id="tab:zero_quote">

| **Property**      | **Allowable values**                                                                                                                | **Description**                                                                     |
|:------------------|:------------------------------------------------------------------------------------------------------------------------------------|:------------------------------------------------------------------------------------|
| Instrument Type   | *ZERO*                                                                                                                              |                                                                                     |
| Quote Type        | *RATE, YIELD_SPREAD*                                                                                                                |                                                                                     |
| Currency          | See `Currency` in Table <a href="#tab:allow_stand_data" data-reference-type="ref"                                                   
                     data-reference="tab:allow_stand_data">[tab:allow_stand_data]</a>                                                                     | Currency of the Zero rate                                                           |
| CurveId           | A CCY concatenated with a Tenor. Should match CurveIds in the `yield-curves.xml` file                                               | Unique identifier for the yield curve associated with the zero quote                |
| DayCounter        | See `DayCount Convention` in Table <a href="#tab:daycount" data-reference-type="ref"                                                
                     data-reference="tab:daycount">[tab:daycount]</a>                                                                                     | The day count basis associated with the zero quote                                  |
| Tenor or ZeroDate | Tenor: An integer followed by D, W, M or Y, ZeroDate: See `Date` in Table <a href="#tab:allow_stand_data" data-reference-type="ref" 
                     data-reference="tab:allow_stand_data">[tab:allow_stand_data]</a>                                                                     | Either a Tenor for tenor based zero quotes, or an explicit maturity date (ZeroDate) |

Zero Rate

</div>

Examples with a Tenor and with a ZeroDate:

- ZERO/RATE/USD/USD6M/A365F/6M

- ZERO/RATE/USD/USD6M/A365F/12-05-2018

## Discount Factor

The instrument specific information to be captured for quotes
representing Discount Factors is shown in Table
<a href="#tab:discount_quote" data-reference-type="ref"
data-reference="tab:discount_quote">3</a>.

<div id="tab:discount_quote">

| **Property**         | **Allowable values**                                                                                                                   | **Description**                                                                                              |
|:---------------------|:---------------------------------------------------------------------------------------------------------------------------------------|:-------------------------------------------------------------------------------------------------------------|
| Instrument Type      | *DISCOUNT*                                                                                                                             |                                                                                                              |
| Quote Type           | *RATE*                                                                                                                                 |                                                                                                              |
| Currency             | See `Currency` in Table <a href="#tab:allow_stand_data" data-reference-type="ref"                                                      
                        data-reference="tab:allow_stand_data">[tab:allow_stand_data]</a>                                                                        | Currency of the Discount rate                                                                                |
| CurveId              | A CCY concatenated with a Tenor. Should match CurveIds in the `yield-curves.xml` file                                                  | Unique identifier for the yield curve associated with the discount quote                                     |
| Term or DiscountDate | Term: An integer followed by D, W, M or Y, DiscountDate: See `Date` in Table <a href="#tab:allow_stand_data" data-reference-type="ref" 
                        data-reference="tab:allow_stand_data">[tab:allow_stand_data]</a>                                                                        | Either a Term is used to determine the maturity date, or an explicit maturity date (Discount Date) is given. |

Discount Rate

</div>

If a Term is given in the last element of the quote, it is converted to
a maturity date using the calendar, specified in the conventions. Bear
in mind, only zero conventions (see Listing
<a href="#lst:zero_conventions_tenor" data-reference-type="ref"
data-reference="lst:zero_conventions_tenor">[lst:zero_conventions_tenor]</a>)
can be used for the discount factor instruments.

Examples with a Term and with a DiscountDate:

- DISCOUNT/RATE/EUR/EUR3M/3Y

- DISCOUNT/RATE/EUR/EUR3M/12-05-2018

## FX Spot Rate

<div id="tab:fxspot_quote">

| **Property**    | **Allowable values**                                                              | **Description**      |
|:----------------|:----------------------------------------------------------------------------------|:---------------------|
| Instrument Type | *FX*                                                                              |                      |
| Quote Type      | *RATE*                                                                            |                      |
| Unit currency   | See `Currency` in Table <a href="#tab:allow_stand_data" data-reference-type="ref" 
                   data-reference="tab:allow_stand_data">[tab:allow_stand_data]</a>                   | Unit/Source currency |
| Target currency | See `Currency` in Table <a href="#tab:allow_stand_data" data-reference-type="ref" 
                   data-reference="tab:allow_stand_data">[tab:allow_stand_data]</a>                   | Target currency      |

FX Spot Rate

</div>

Example:

- FX/RATE/EUR/USD

## FX Forward Rate

An FX Forward quote is expected in either a “forward points” quotation,
or an “outright” quotation.

The forward points convention is given by:
$$\mbox{Forward Points} = \frac{\mbox{FX Forward} - \mbox{FX
    Spot}}{\mbox{Conversion Factor}}$$ with conversion factor set to 1.

<div id="tab:fxfwd_quote">

| **Property**    | **Allowable values**                                                              | **Description**                                                  |
|:----------------|:----------------------------------------------------------------------------------|:-----------------------------------------------------------------|
| Instrument Type | *FX_FWD*                                                                          |                                                                  |
| Quote Type      | *RATE*                                                                            |                                                                  |
| Unit currency   | See `Currency` in Table <a href="#tab:allow_stand_data" data-reference-type="ref" 
                   data-reference="tab:allow_stand_data">[tab:allow_stand_data]</a>                   | Unit/Source currency                                             |
| Target currency | See `Currency` in Table <a href="#tab:allow_stand_data" data-reference-type="ref" 
                   data-reference="tab:allow_stand_data">[tab:allow_stand_data]</a>                   | Target currency                                                  |
| Term            | An integer followed by D, W, M or Y.                                              | Period from today to maturity. Alternatively, the maturity date. |

FX Forward Rate

</div>

The forward outright is given by:
$$\mbox{Forward Outright} = \mbox{FX Spot} + \mbox{Forward Points}\times{\mbox{Conversion Factor}}$$
with conversion factor set to 1.

<div id="tab:fxfwd_outright">

| **Property**    | **Allowable values**                                                              | **Description**                                                  |
|:----------------|:----------------------------------------------------------------------------------|:-----------------------------------------------------------------|
| Instrument Type | *FX_FWD*                                                                          |                                                                  |
| Quote Type      | *PRICE*                                                                           |                                                                  |
| Unit currency   | See `Currency` in Table <a href="#tab:allow_stand_data" data-reference-type="ref" 
                   data-reference="tab:allow_stand_data">[tab:allow_stand_data]</a>                   | Unit/Source currency                                             |
| Target currency | See `Currency` in Table <a href="#tab:allow_stand_data" data-reference-type="ref" 
                   data-reference="tab:allow_stand_data">[tab:allow_stand_data]</a>                   | Target currency                                                  |
| Term            | An integer followed by D, W, M or Y.                                              | Period from today to maturity. Alternatively, the maturity date. |

FX Forward Rate

</div>

Example:

- FXFWD/RATE/EUR/USD/1M

- FXFWD/PRICE/EUR/USD/3M

- FXFWD/PRICE/EUR/USD/2026-03-02

## Deposit Rate

<div id="tab:deposit_quote">

| **Property**    | **Allowable values**                                                              | **Description**                                                                                                    |
|:----------------|:----------------------------------------------------------------------------------|:-------------------------------------------------------------------------------------------------------------------|
| Instrument Type | *MM*                                                                              |                                                                                                                    |
| Quote Type      | *RATE*                                                                            |                                                                                                                    |
| Currency        | See `Currency` in Table <a href="#tab:allow_stand_data" data-reference-type="ref" 
                   data-reference="tab:allow_stand_data">[tab:allow_stand_data]</a>                   | Currency of the Deposit rate                                                                                       |
| IndexName       | Optional, any string                                                              | Generally used to differentiate money market rates referencing different interest rate indices with the same tenor |
| Forward start   | An integer followed by D, W, M or Y.                                              | Period from today to start                                                                                         |
| Term            | An integer followed by D, W, M or Y.                                              | Period from start to maturity                                                                                      |

Deposit Rate

</div>

Deposits are usually quoted as ON (Overnight), TN (Tomorrow Next), SN
(Spot Next), SW (Spot Week), 3W (3 Weeks), 6M (6 Months), etc.  
Forward start for ON is today (i.e. forward start = 0D), for TN tomorrow
(forward start = 1D), for SN two days from today (forward start = 2D).
For longer term Deposits, forward start is derived from conventions, see
<a href="#sec:conventions" data-reference-type="ref"
data-reference="sec:conventions">[sec:conventions]</a>, and is between
0D and 2D, i.e. “spot days” are between 0 and 2.

Example:

- MM/RATE/EUR/2D/3M

## FRA Rate

<div id="tab:fra_quote">

| **Property**    | **Allowable values**                                                              | **Description**               |
|:----------------|:----------------------------------------------------------------------------------|:------------------------------|
| Instrument Type | *FRA*                                                                             |                               |
| Quote Type      | *RATE*                                                                            |                               |
| Currency        | See `Currency` in Table <a href="#tab:allow_stand_data" data-reference-type="ref" 
                   data-reference="tab:allow_stand_data">[tab:allow_stand_data]</a>                   | Currency of the FRA rate      |
| Forward start   | An integer followed by D, W, M or Y                                               | Period from today to start    |
| Term            | An integer followed by D, W, M or Y                                               | Period from start to maturity |

FRA Rate

</div>

FRAs are typically quoted as e.g. 6x9 which means forward start 6M from
today, maturity 9M from today, with appropriate adjustment of dates.

IMM FRA quotes are represented as follows.

<div id="tab:imm_fra_quote">

| **Property**    | **Allowable values**                                                              | **Description**                            |
|:----------------|:----------------------------------------------------------------------------------|:-------------------------------------------|
| Instrument Type | *IMM_FRA*                                                                         |                                            |
| Quote Type      | *RATE*                                                                            |                                            |
| Currency        | See `Currency` in Table <a href="#tab:allow_stand_data" data-reference-type="ref" 
                   data-reference="tab:allow_stand_data">[tab:allow_stand_data]</a>                   | Currency of the FRA rate                   |
| Start           | An integer                                                                        | Number of IMM dates from today to start    |
| End             | An integer                                                                        | Number of IMM dates from today to maturity |

IMM FRA Rate

</div>

Example:

- FRA/RATE/EUR/9M/3M

- IMM_FRA/RATE/EUR/2/3

## Money Market Futures Price

<div id="tab:mmfp_quote">

| **Property**    | **Allowable values**                                                              | **Description**                 |
|:----------------|:----------------------------------------------------------------------------------|:--------------------------------|
| Instrument Type | *MM_FUTURE*                                                                       |                                 |
| Quote Type      | *PRICE*                                                                           |                                 |
| Currency        | See `Currency` in Table <a href="#tab:allow_stand_data" data-reference-type="ref" 
                   data-reference="tab:allow_stand_data">[tab:allow_stand_data]</a>                   | Currency of the MM Future price |
| Expiry          | Alphanumeric string of the form YYYY-MM                                           | Expiry month and year           |
| Contract        | String                                                                            | Contract name                   |
| Term            | An integer followed by D, W, M or Y                                               | Underlying Term                 |

Money Market Futures Price

</div>

Expiry month is quoted here as YYYY-MM. The exact expiry date follows
from a date rule defined in the future conventions, see
<a href="#ss:conventions_future" data-reference-type="ref"
data-reference="ss:conventions_future">[ss:conventions_future]</a>.

Example:

- MM_FUTURE/PRICE/EUR/2018-06/LIF3ME/3M

## Overnight Index Futures Price

<div id="tab:oifp_quote">

| **Property**    | **Allowable values**                                                              | **Description**                              |
|:----------------|:----------------------------------------------------------------------------------|:---------------------------------------------|
| Instrument Type | *OI_FUTURE*                                                                       |                                              |
| Quote Type      | *PRICE*                                                                           |                                              |
| Currency        | See `Currency` in Table <a href="#tab:allow_stand_data" data-reference-type="ref" 
                   data-reference="tab:allow_stand_data">[tab:allow_stand_data]</a>                   | Currency of the Overnight Index Future price |
| Expiry          | Alphanumeric string of the form YYYY-MM                                           | Expiry month and year                        |
| Contract        | String                                                                            | Contract name                                |
| Term            | An integer followed by M or Y                                                     | Underlying Term in months or years           |

Overnight Index Futures Price

</div>

Expiry month is quoted here as YYYY-MM. The exact expiry date follows
from a date rule defined in the future conventions, see
<a href="#ss:conventions_future" data-reference-type="ref"
data-reference="ss:conventions_future">[ss:conventions_future]</a>.

Example: Three Months SOFR Futures (DEC 2019):

- OI_FUTURE/PRICE/USD/2019-12/CME:SR3Z2019/3M

## Swap Rate

<div id="tab:swaprate_quote">

| **Property**    | **Allowable values**                                                              | **Description**                                                                                       |
|:----------------|:----------------------------------------------------------------------------------|:------------------------------------------------------------------------------------------------------|
| Instrument Type | *IR_SWAP*                                                                         |                                                                                                       |
| Quote Type      | *RATE*                                                                            |                                                                                                       |
| Currency        | See `Currency` in Table <a href="#tab:allow_stand_data" data-reference-type="ref" 
                   data-reference="tab:allow_stand_data">[tab:allow_stand_data]</a>                   | Currency of the Swap rate                                                                             |
| IndexName       | Optional, any string                                                              | Generally used to differentiate swaps referencing different interest rate indices with the same tenor |
| Forward start   | An integer followed by D, W, M or Y                                               | Generic period from today to start                                                                    |
| Tenor           | An integer followed by D, W, M or Y                                               | Underlying index period                                                                               |
| Term            | An integer followed by D, W, M or Y                                               | Swap length from start to maturity                                                                    |

Swap Rate

</div>

<div id="tab:swaprate_quote_dated">

| **Property**    | **Allowable values**                                                              | **Description**                                                                                       |
|:----------------|:----------------------------------------------------------------------------------|:------------------------------------------------------------------------------------------------------|
| Instrument Type | *IR_SWAP*                                                                         |                                                                                                       |
| Quote Type      | *RATE*                                                                            |                                                                                                       |
| Currency        | See `Currency` in Table <a href="#tab:allow_stand_data" data-reference-type="ref" 
                   data-reference="tab:allow_stand_data">[tab:allow_stand_data]</a>                   | Currency of the Swap rate                                                                             |
| IndexName       | Optional, any string                                                              | Generally used to differentiate swaps referencing different interest rate indices with the same tenor |
| Start Date      | A valid date                                                                      |                                                                                                       |
| Tenor           | An integer followed by D, W, M or Y                                               | Underlying index period                                                                               |
| End Date        | A valid date                                                                      |                                                                                                       |

Swap Rate with Start and End Date

</div>

Forward start for the non-dated variant is usually not quoted, but needs
to be derived from conventions.

Example:

- IR_SWAP/RATE/EUR/2D/6M/10Y

- IR_SWAP/RATE/GBP/20230921/1D/20231102

## Basis Swap Spread

<div id="tab:basisspread_quote">

| **Property**        | **Allowable values**                                                              | **Description**                    |
|:--------------------|:----------------------------------------------------------------------------------|:-----------------------------------|
| Instrument Type     | *BASIS_SWAP*                                                                      |                                    |
| Quote Type          | *BASIS_SPREAD*                                                                    |                                    |
| Flat tenor          | An integer followed by D, W, M or Y                                               | Zero spread leg’s index tenor      |
| Tenor               | An integer followed by D, W, M or Y                                               | Non-zero spread leg’s index tenor  |
| Currency            | See `Currency` in Table <a href="#tab:allow_stand_data" data-reference-type="ref" 
                       data-reference="tab:allow_stand_data">[tab:allow_stand_data]</a>                   | Currency of the basis swap spread  |
| Optional Identifier | String                                                                            | Basis swap name                    |
| Term                | An integer followed by D, W, M or Y                                               | Swap length from start to maturity |

Basis Swap Spread

</div>

Examples:

- BASIS_SWAP/BASIS_SPREAD/6M/3M/CHF/10Y

- BASIS_SWAP/BASIS_SPREAD/3M/1D/USD/2Y

- BASIS_SWAP/BASIS_SPREAD/3M/1D/USD/LIBOR_PRIME/2Y

- BASIS_SWAP/BASIS_SPREAD/3M/1D/USD/LIBOR_FEDFUNDS/2Y

## Cross Currency Basis Swap Spread

<div id="tab:ccbasisspread_quote">

| **Property**    | **Allowable values**                                                              | **Description**                    |
|:----------------|:----------------------------------------------------------------------------------|:-----------------------------------|
| Instrument Type | *CC_BASIS_SWAP*                                                                   |                                    |
| Quote Type      | *BASIS_SPREAD*                                                                    |                                    |
| Flat currency   | See `Currency` in Table <a href="#tab:allow_stand_data" data-reference-type="ref" 
                   data-reference="tab:allow_stand_data">[tab:allow_stand_data]</a>                   | Currency for zero spread leg       |
| Flat tenor      | An integer followed by D, W, M or Y                                               | Zero spread leg’s index tenor      |
| Currency        | See `Currency` in Table <a href="#tab:allow_stand_data" data-reference-type="ref" 
                   data-reference="tab:allow_stand_data">[tab:allow_stand_data]</a>                   | Currency for non-zero spread leg   |
| Tenor           | An integer followed by D, W, M or Y                                               | Non-zero spread leg’s index tenor  |
| Term            | An integer followed by D, W, M or Y                                               | Swap length from start to maturity |

Cross Currency Basis Swap Spread

</div>

Example:

- CC_BASIS_SWAP/BASIS_SPREAD/USD/3M/JPY/6M/10Y

## CDS Spread

<div id="tab:cdsspread_quote">

| **Property**    | **Allowable values**                                                              | **Description**                                 |
|:----------------|:----------------------------------------------------------------------------------|:------------------------------------------------|
| Instrument Type | `CDS`                                                                             |                                                 |
| Quote Type      | `CREDIT_SPREAD` or `CONV_CREDIT_SPREAD`                                           |                                                 |
| Entity          | String                                                                            | The CDS reference entity name                   |
| Tier            | String                                                                            | The CDS tier                                    |
| DocClause       | String                                                                            | Optional, the CDS doc clause                    |
| Currency        | See `Currency` in Table <a href="#tab:allow_stand_data" data-reference-type="ref" 
                   data-reference="tab:allow_stand_data">[tab:allow_stand_data]</a>                   | The CDS currency                                |
| Term            | A valid tenor string                                                              | The CDS tenor                                   |
| RunningSpread   | A number                                                                          | The CDS running coupon in bps e.g. 100 for 0.01 |

CDS spread quote

</div>

Currently, only par CDS spreads (quote type `CREDIT_SPREAD`) are
supported. Conventional CDS spreads (quote type `CONV_CREDIT_SPREAD`)
are not supported at this time. As noted in the table above, the CDS
documentation clause and CDS running spread is optional. The following
list shows valid CDS spread quote examples.

- `CDS/CREDIT_SPREAD/JPM/SNRFOR/USD/5Y`

- `CDS/CREDIT_SPREAD/JPM/SNRFOR/USD/5Y/100`

- `CDS/CREDIT_SPREAD/JPM/SNRFOR/USD/XR14/5Y`

- `CDS/CREDIT_SPREAD/JPM/SNRFOR/USD/XR14/5Y/100`

- `CDS/CREDIT_SPREAD/RBS/SUBLT2/EUR/MR14/10Y`

- `CDS/CREDIT_SPREAD/RBS/SUBLT2/EUR/MR14/10Y/500`

- `CDS/CREDIT_SPREAD/RBS/SUBLT2/EUR/1Y`

- `CDS/CREDIT_SPREAD/RBS/SUBLT2/EUR/1Y/500`

- `CDS/CONV_CREDIT_SPREAD/JPM/SNRFOR/USD/5Y`

- `CDS/CONV_CREDIT_SPREAD/JPM/SNRFOR/USD/5Y/100`

- `CDS/CONV_CREDIT_SPREAD/JPM/SNRFOR/USD/XR14/5Y`

- `CDS/CONV_CREDIT_SPREAD/JPM/SNRFOR/USD/XR14/5Y/100`

- `CDS/CONV_CREDIT_SPREAD/RBS/SUBLT2/EUR/MR14/10Y`

- `CDS/CONV_CREDIT_SPREAD/RBS/SUBLT2/EUR/MR14/10Y/500`

- `CDS/CONV_CREDIT_SPREAD/RBS/SUBLT2/EUR/1Y`

- `CDS/CONV_CREDIT_SPREAD/RBS/SUBLT2/EUR/1Y/500`

## CDS Upfront Price

<div id="tab:cds_price_quote">

| **Property**    | **Allowable values**                                                              | **Description**                                 |
|:----------------|:----------------------------------------------------------------------------------|:------------------------------------------------|
| Instrument Type | `CDS`                                                                             |                                                 |
| Quote Type      | `PRICE`                                                                           |                                                 |
| Entity          | String                                                                            | The CDS reference entity name                   |
| Tier            | String                                                                            | The CDS tier                                    |
| Currency        | See `Currency` in Table <a href="#tab:allow_stand_data" data-reference-type="ref" 
                   data-reference="tab:allow_stand_data">[tab:allow_stand_data]</a>                   | The CDS currency                                |
| DocClause       | String                                                                            | Optional, the CDS doc clause                    |
| Term            | A valid tenor string                                                              | The CDS tenor                                   |
| RunningSpread   | A number                                                                          | The CDS running coupon in bps e.g. 100 for 0.01 |

CDS upfront price quote

</div>

As noted in the table above, the CDS documentation clause and CDS
running spread is optional. Note that if the running spread is omitted
from the CDS upfront price quote string, it should be included in any
default curve configuration that uses those quotes. In other words, to
bootstrap a default curve from CDS price quotes, the contractual running
spread needs to be provided in either the quote string or in the default
curve configuration. If both are provided, the running spread in the
quote string takes precedence. The following list shows valid CDS
upfront price quote examples.

- `CDS/PRICE/JPM/SNRFOR/USD/5Y`

- `CDS/PRICE/JPM/SNRFOR/USD/5Y/100`

- `CDS/PRICE/JPM/SNRFOR/USD/XR14/5Y`

- `CDS/PRICE/JPM/SNRFOR/USD/XR14/5Y/100`

- `CDS/PRICE/RBS/SUBLT2/EUR/MR14/10Y`

- `CDS/PRICE/RBS/SUBLT2/EUR/MR14/10Y/500`

- `CDS/PRICE/RBS/SUBLT2/EUR/1Y`

- `CDS/PRICE/RBS/SUBLT2/EUR/1Y/500`

## CDS Recovery Rate

<div id="tab:cdsrecovery_quote">

| **Property**    | **Allowable values**                                                              | **Description**               |
|:----------------|:----------------------------------------------------------------------------------|:------------------------------|
| Instrument Type | `RECOVERY_RATE` or `ASSUMED_RECOVERY_RATE`                                        |                               |
| Quote Type      | `RATE`                                                                            |                               |
| Entity          | String                                                                            | The CDS reference entity name |
| Tier            | String                                                                            | The CDS tier                  |
| Currency        | See `Currency` in Table <a href="#tab:allow_stand_data" data-reference-type="ref" 
                   data-reference="tab:allow_stand_data">[tab:allow_stand_data]</a>                   | The CDS currency              |
| DocClause       | String                                                                            | Optional, the CDS doc clause  |

CDS Recovery Rate

</div>

As noted in the table above, the CDS documentation clause is optional.
The following list shows valid recovery rate quote examples.

- `RECOVERY_RATE/RATE/JPM/SNRFOR/USD`

- `RECOVERY_RATE/RATE/JPM/SNRFOR/USD/XR14`

- `RECOVERY_RATE/RATE/RBS/SUBLT2/EUR/MR14`

- `RECOVERY_RATE/RATE/RBS/SUBLT2/EUR`

## CDS Option Implied Volatility

A CDS option implied volatility quote can take any one of the following
four forms:

1.  `INDEX_CDS_OPTION/RATE_LNVOL/[NAME]/[EXPIRY]`

2.  `INDEX_CDS_OPTION/RATE_LNVOL/[NAME]/[EXPIRY]/[STRIKE]`

3.  `INDEX_CDS_OPTION/RATE_LNVOL/[NAME]/[TERM]/[EXPIRY]`

4.  `INDEX_CDS_OPTION/RATE_LNVOL/[NAME]/[TERM]/[EXPIRY]/[STRIKE]`

The terms in the quote string have the following interpretations:

- The `[NAME]` is the name of the CDS reference entity or index CDS.

- The `[EXPIRY]` is the expiry of the CDS option and may be a tenor or
  an explicit date.

- The `[TERM]` is optional and gives the term of the underlying CDS or
  index CDS. This should be a tenor e.g. 3Y, 5Y, etc.

- The `[STRIKE]` is optional and gives the strike of the CDS or index
  CDS option.

## Security Recovery Rate

Bond recovery rates can also be specified per security. This requires
only one key, the security ID, no need to specify a seniority or
currency as for CDS:

<div id="tab:secrecrate_quote">

| **Property**    | **Allowable values**                       | **Description** |
|:----------------|:-------------------------------------------|:----------------|
| Instrument Type | *RECOVERY_RATE* or *ASSUMED_RECOVERY_RATE* |                 |
| Quote Type      | *RATE*                                     |                 |
| ID              | String                                     | Security ID     |

Security Recovery Rate

</div>

Currently, only par (real) recovery rates (quote type `RECOVERY_RATE`)
are supported.

Example:

- RECOVERY_RATE/RATE/SECURITY_1

- ASSUMED_RECOVERY_RATE/RATE/SECURITY_1

## Hazard Rate (Instantaneous Probability of Default)

This allows to directly pass hazard rates as instantaneous probabilities
of default.

<div id="tab:pd_quote">

| **Property**    | **Allowable values**                                                              | **Description**                       |
|:----------------|:----------------------------------------------------------------------------------|:--------------------------------------|
| Instrument Type | *HAZARD_RATE*                                                                     |                                       |
| Quote Type      | *RATE*                                                                            |                                       |
| Issuer          | String                                                                            | Issuer name                           |
| Seniority       | String                                                                            | Seniority status                      |
| Currency        | See `Currency` in Table <a href="#tab:allow_stand_data" data-reference-type="ref" 
                   data-reference="tab:allow_stand_data">[tab:allow_stand_data]</a>                   | Hazard rate currency                  |
| Term            | An integer followed by D, W, M or Y                                               | Generic period from start to maturity |

Hazard Rate

</div>

Example:

- HAZARD_RATE/RATE/CPTY_A/SR/USD/30Y

- HAZARD_RATE/RATE/CPTY_C/SR/EUR/0Y

## FX Option Implied Volatility

<div id="tab:fximplvol_quote">

| **Property**    | **Allowable values**                                                              | **Description**                                    |
|:----------------|:----------------------------------------------------------------------------------|:---------------------------------------------------|
| Instrument Type | *FX_OPTION*                                                                       |                                                    |
| Quote Type      | *RATE_LNVOL*                                                                      |                                                    |
| Unit currency   | See `Currency` in Table <a href="#tab:allow_stand_data" data-reference-type="ref" 
                   data-reference="tab:allow_stand_data">[tab:allow_stand_data]</a>                   | Unit/Source currency                               |
| Target currency | See `Currency` in Table <a href="#tab:allow_stand_data" data-reference-type="ref" 
                   data-reference="tab:allow_stand_data">[tab:allow_stand_data]</a>                   | Target currency                                    |
| Expiry          | An integer followed by D, W, M or Y                                               | Period from today to expiry                        |
| Strike          | *ATM, RR, BF*                                                                     | ATM (Straddle), RR (Risk Reversal), BF (Butterfly) |

FX Option Implied Volatility

</div>

Volatilities are quoted in terms of strategies - at-the-money straddle,
risk reversal and butterfly.

Example:

- FX_OPTION/RATE_LNVOL/EUR/USD/3M/ATM

## Cap Floor Implied Volatility

<div id="tab:capfloor_implvol_quote">

| **Property**    | **Allowable values**                                                              | **Description**                                                                                                                                     |
|:----------------|:----------------------------------------------------------------------------------|:----------------------------------------------------------------------------------------------------------------------------------------------------|
| Instrument Type | *CAPFLOOR*                                                                        |                                                                                                                                                     |
| Quote Type      | *RATE_LNVOL, RATE_NVOL, RATE_SLNVOL, SHIFT, PRICE*                                | Lognormal quoted volatility, normal quoted volatility, shifted lognormal quoted volatility, shift quote, premium quote.                             |
| Currency        | See `Currency` in Table <a href="#tab:allow_stand_data" data-reference-type="ref" 
                   data-reference="tab:allow_stand_data">[tab:allow_stand_data]</a>                   | Currency of the cap floor quote.                                                                                                                    |
| Index Name      | A string                                                                          | (optional) An interest rate index name giving the index underlying the cap floor quotes. See Table <a href="#tab:indices" data-reference-type="ref" 
                                                                                                       data-reference="tab:indices">[tab:indices]</a>.                                                                                                      |
| Term            | A valid tenor string                                                              | Period from start to cap or floor maturity.                                                                                                         |
| Index Tenor     | A valid tenor string                                                              | Underlying index tenor e.g. `3M` for `EUR-EURIBOR-3M`.                                                                                              |
| ATM             | `1` or `0`                                                                        | True, i.e. `1`, for an ATM quote and false, i.e. `0`, for a strike quote.                                                                           |
| Relative        | `1` or `0`                                                                        | Should be set to `1` for a quote relative to ATM and to `0` for an absolute strike quote.                                                           |
| Strike          | Real number                                                                       | Strike of cap or floor. Should be set to `0` for an ATM quote.                                                                                      |
| Option Style    | C or F                                                                            | (optional) Valid for premium quotes only, indicates whether the datum is a cap or floor quote respectively.                                         |

Cap floor implied volatility quote

</div>

An index name should be used where a currency has more than one index of
a given tenor with an options surface. It must match `IborIndex` in its
corresponding `CapFloorVolatility` configuration, see section
<a href="#sss:capfloorconfig" data-reference-type="ref"
data-reference="sss:capfloorconfig">[sss:capfloorconfig]</a>.

If a cap floor shift quote needs to be provided, i.e. in the case of a
shifted lognormal surface, the quote is of the form
`CAPFLOOR/SHIFT/Currency/Index Tenor` where the meaning of `Currency`
and `Index Tenor` are given in Table
<a href="#tab:capfloor_implvol_quote" data-reference-type="ref"
data-reference="tab:capfloor_implvol_quote">22</a>.

We have the following examples of cap floor implied volatility, shift,
and premium quotes:

- `CAPFLOOR/RATE_LNVOL/EUR/10Y/6M/1/1/0`: 10Y ATM cap floor implied
  lognormal volatility quote where the index tenor is 6M.

- `CAPFLOOR/RATE_LNVOL/EUR/10Y/6M/0/0/0.035`: 10Y 3.5% strike cap floor
  implied lognormal volatility quote where the index tenor is 6M.

- `CAPFLOOR/RATE_SLNVOL/EUR/EURIBOR/5Y/6M/0/0/0.03`: 5Y 3% strike cap
  floor implied shifted lognormal volatility quote where the underlying
  rate is the EUR-EURIBOR-6M.

- `CAPFLOOR/SHIFT/EUR/EURIBOR/6M`: Strike shift convention corresponding
  to shifted lognormal implied capfloor volatility quotes where the
  underlying rate is the EUR-EURIBOR-6M.

- `CAPFLOOR/PRICE/EUR/EURIBOR/5Y/6M/0/0/0.03/C`: 5Y 3% strike cap floor
  premium quote where the underlying rate is the EUR-EURIBOR-6M.

## Swaption Implied Volatility

<div id="tab:swaptimplvol_quote">

| **Property**    | **Allowable values**                                                              | **Description**                                                                                                                     |
|:----------------|:----------------------------------------------------------------------------------|:------------------------------------------------------------------------------------------------------------------------------------|
| Instrument Type | *SWAPTION*                                                                        |                                                                                                                                     |
| Quote Type      | *RATE_LNVOL, RATE_NVOL, RATE_SLNVOL, SHIFT, PRICE*                                | Lognormal quoted volatility, Normal quoted volatility, shifted lognormal quoted volatility, shift, premium quote.                   |
| Currency        | See `Currency` in Table <a href="#tab:allow_stand_data" data-reference-type="ref" 
                   data-reference="tab:allow_stand_data">[tab:allow_stand_data]</a>                   | Currency of the Swaption volatility                                                                                                 |
| Quote Tag       | A string                                                                          | (optional) A tag to differentiate different sets of swaption data in a currency. See note below.                                    |
| Expiry          | An integer followed by D, W, M or Y                                               | Period from start to expiry                                                                                                         |
| Term            | An integer followed by D, W, M or Y                                               | Underlying Swap term                                                                                                                |
| Dimension       | *Smile, ATM*                                                                      | Whether volatility quote is a Smile or ATM                                                                                          |
| Strike          | Real number                                                                       | (not required for ATM), deviation from the ATM strike. Note that trailing 0s are not ignored.                                       |
| Option Style    | P or R                                                                            | (optional) Valid for premium quotes only, indicates whether the datum represents a payer or receiver swaption premium respectively. |

Swaption Implied Volatility

</div>

A quote tag should be used where a currency has more than one index with
a swaption surface. It must match `QuoteTag` in its corresponding
`SwaptionVolatility` configuration, see section
<a href="#sss:swaptionconfig" data-reference-type="ref"
data-reference="sss:swaptionconfig">[sss:swaptionconfig]</a>.

Note: The volatility quote is expected to be an absolute volatility, and
not the deviation from the at-the-money volatility (the latter is e.g.
the quotation convention used by BGC partners).  
If a swaption shift quote needs to be provided, i.e. in the case of a
shifted lognormal surface, the quote is of the form
`SWAPTION/SHIFT/Currency/Term` where the meaning of `Currency` and
`Term` are given in Table
<a href="#tab:swaptimplvol_quote" data-reference-type="ref"
data-reference="tab:swaptimplvol_quote">23</a>.

Examples:

-  SWAPTION/RATE_LNVOL/EUR/5Y/10Y/ATM (absolute ATM vol quote)

-  SWAPTION/RATE_LNVOL/EUR/5Y/10Y/Smile/0.0050 (absolute vol quote for
  ATM strike plus 50bp)

## Equity Spot Price

<div id="tab:eqspot_quote">

| **Property**    | **Allowable values**                                                              | **Description**                |
|:----------------|:----------------------------------------------------------------------------------|:-------------------------------|
| Instrument Type | *EQUITY_SPOT*                                                                     |                                |
| Quote Type      | *PRICE*                                                                           |                                |
| Name            | String                                                                            | Identifying name of the equity |
| Currency        | See `Currency` in Table <a href="#tab:allow_stand_data" data-reference-type="ref" 
                   data-reference="tab:allow_stand_data">[tab:allow_stand_data]</a>                   | Currency of the equity         |

Equity Spot Price

</div>

## Equity Forward Price

<div id="tab:eqfwd_quote">

| **Property**    | **Allowable values**                                                              | **Description**                |
|:----------------|:----------------------------------------------------------------------------------|:-------------------------------|
| Instrument Type | *EQUITY_FWD*                                                                      |                                |
| Quote Type      | *PRICE*                                                                           |                                |
| Name            | String                                                                            | Identifying name of the equity |
| Currency        | See `Currency` in Table <a href="#tab:allow_stand_data" data-reference-type="ref" 
                   data-reference="tab:allow_stand_data">[tab:allow_stand_data]</a>                   | Currency of the equity         |
| Maturity        | Date string, or integer followed by D, W, M or Y                                  | Maturity of the forward quote  |

Equity Forward Price

</div>

Examples:

- EQUITY_FWD/PRICE/SP5/USD/2016-06-16

- EQUITY_FWD/PRICE/SP5/USD/2Y

## Equity Dividend Yield

<div id="tab:eqdiv_quote">

| **Property**    | **Allowable values**                                                              | **Description**                |
|:----------------|:----------------------------------------------------------------------------------|:-------------------------------|
| Instrument Type | *EQUITY_DIVIDEND*                                                                 |                                |
| Quote Type      | *RATE*                                                                            |                                |
| Name            | String                                                                            | Identifying name of the equity |
| Currency        | See `Currency` in Table <a href="#tab:allow_stand_data" data-reference-type="ref" 
                   data-reference="tab:allow_stand_data">[tab:allow_stand_data]</a>                   | Currency of the equity         |
| Maturity        | Date string, or integer followed by D, W, M or Y                                  | Maturity of the forward quote  |

Equity Dividend Yield Rate

</div>

Examples:

- EQUITY_DIVIDEND/RATE/SP5/USD/2016-06-16

- EQUITY_DIVIDEND/RATE/SP5/USD/2Y

## Equity Option Implied Volatility

<div id="tab:eqimplvol_quote">

| **Property**    | **Allowable values**                                                                                                                         | **Description**                           |
|:----------------|:---------------------------------------------------------------------------------------------------------------------------------------------|:------------------------------------------|
| Instrument Type | *EQUITY_OPTION*                                                                                                                              |                                           |
| Quote Type      | *RATE_LNVOL*                                                                                                                                 |                                           |
| Name            | String                                                                                                                                       | Identifying name of the equity            |
| Currency        | See `Currency` in Table <a href="#tab:allow_stand_data" data-reference-type="ref"                                                            
                   data-reference="tab:allow_stand_data">[tab:allow_stand_data]</a>                                                                              | Currency of the equity                    |
| Expiry          | Date string, or integer followed by D, W, M or Y                                                                                             | Maturity of the forward quote             |
| Strike          | `ATM/AtmSpot` (= `ATM`), `ATM/AtmFwd` (=`ATMF`), `MNY/[Spot|Fwd]/1.2` where $1.2$ is the moneyness level, or a `Real` for an absolute strike | strike                                    |
| CallPut         | `C` for Call, `P` for Put                                                                                                                    | Optional Call/Put flag (defaults to Call) |

Equity Option Implied Volatility

</div>

Volatilities are quoted as a function of strike price - either
at-the-money spot or forward, a moneyness level or else a specified real
number, corresponding to the absolute strike value. Only log-normal
implied volatilities (` RATE_LNVOL`) are supported.

If $K$ is the absolute strike, $S$ the spot, $F$ the forward and $m$ the
moneyness level, we have $K=Sm$ if spot moneyness and $K=Fm$ if forward
moneyness is specified.

Example:

- EQUITY_OPTION/RATE_LNVOL/SP5/USD/6M/ATMF

- EQUITY_OPTION/RATE_LNVOL/SP5/USD/2018-06-30/ATMF

- EQUITY_OPTION/RATE_LNVOL/SP5/USD/6M/MNY/Fwd/1.2

## Equity Option Premium

<div id="tab:eqpremvol_quote">

| **Property**    | **Allowable values**                                                               | **Description**                           |
|:----------------|:-----------------------------------------------------------------------------------|:------------------------------------------|
| Instrument Type | *EQUITY_OPTION*                                                                    |                                           |
| Quote Type      | *PRICE*                                                                            |                                           |
| Name            | String                                                                             | Identifying name of the equity            |
| Currency        | See `Currency` in Table <a href="#tab:allow_stand_data" data-reference-type="ref"  
                   data-reference="tab:allow_stand_data">[tab:allow_stand_data]</a>                    | Currency of the equity                    |
| Expiry          | Date string, or integer followed by D, W, M or Y                                   | Maturity of the forward quote             |
| Strike          | `ATM/AtmSpot` (= `ATM`), `ATM/AtmFwd` (=`ATMF`) or a `Real` for an absolute strike | strike                                    |
| CallPut         | `C` for Call, `P` for Put                                                          | Optional Call/Put flag (defaults to Call) |

Equity Option Premium

</div>

Premiums are quoted as a function of strike price - either at-the-money
spot or forward or else a specified real number, corresponding to the
absolute strike value.

Example:

- EQUITY_OPTION/PRICE/SP5/USD/6M/ATMF

- EQUITY_OPTION/PRICE/SP5/USD/2018-06-30/2000

- EQUITY_OPTION/PRICE/SP5/USD/2018-06-30/2000/C

## Commodity Spot Price

<div id="tab:comspot_quote">

| **Property**    | **Allowable values**                                                              | **Description**                   |
|:----------------|:----------------------------------------------------------------------------------|:----------------------------------|
| Instrument Type | *COMMODITY*                                                                       |                                   |
| Quote Type      | *PRICE*                                                                           |                                   |
| Name            | String                                                                            | Identifying name of the commodity |
| Currency        | See `Currency` in Table <a href="#tab:allow_stand_data" data-reference-type="ref" 
                   data-reference="tab:allow_stand_data">[tab:allow_stand_data]</a>                   | Currency of the commodity         |

Commodity Spot Price

</div>

Examples:

- COMMODITY/PRICE/PM:XAUUSD/USD

## Commodity Forward Price

<div id="tab:comfwd_quote">

| **Property**    | **Allowable values**                                                              | **Description**                   |
|:----------------|:----------------------------------------------------------------------------------|:----------------------------------|
| Instrument Type | *COMMODITY_FWD*                                                                   |                                   |
| Quote Type      | *PRICE*                                                                           |                                   |
| Name            | String                                                                            | Identifying name of the commodity |
| Currency        | See `Currency` in Table <a href="#tab:allow_stand_data" data-reference-type="ref" 
                   data-reference="tab:allow_stand_data">[tab:allow_stand_data]</a>                   | Currency of the commodity         |
| Maturity        | Date string, or integer followed by D, W, M or Y                                  | Maturity of the forward quote     |

Commodity Forward Price

</div>

Examples:

- COMMODITY_FWD/PRICE/NYMEX:CL/USD/2030-11-20

## Commodity Option Implied Volatility

<div id="tab:comimplvol_quote">

| **Property**                                   | **Allowable values**                                                                  | **Description**                                                                                                     |
|:-----------------------------------------------|:--------------------------------------------------------------------------------------|:--------------------------------------------------------------------------------------------------------------------|
| Instrument Type                                | *COMMODITY_OPTION*                                                                    |                                                                                                                     |
| Quote Type                                     | *RATE_LNVOL*                                                                          |                                                                                                                     |
| Name                                           | String                                                                                | Identifying name of the commodity                                                                                   |
| Currency                                       | See `Currency` in Table <a href="#tab:allow_stand_data" data-reference-type="ref"     
                                                  data-reference="tab:allow_stand_data">[tab:allow_stand_data]</a>                       | Currency of the commodity                                                                                           |
| Expiry                                         | Date string, or integer followed by D, W, M or Y or continuation notation c1, c2, etc | Expiry of the volatility quote, for continuation notation c1 indicates the next expiry, c2 the one after that, etc. |
|                                                |                                                                                       |                                                                                                                     |
| or Absolute Strike                             |                                                                                       |                                                                                                                     |
| or a `Real` for absolute strikes               |                                                                                       |                                                                                                                     |
| for a call or put option with a given delta.   |                                                                                       |                                                                                                                     |
| `ATM` is for At-The-Money volatility quotes.   |                                                                                       |                                                                                                                     |
| `MNY` is for volatility smile quotes for given |                                                                                       |                                                                                                                     |
| relative moneyness levels.                     |                                                                                       |                                                                                                                     |
| Each Vol Quote Type is described further       |                                                                                       |                                                                                                                     |
| in sub-tables below.                           |                                                                                       |                                                                                                                     |
| Note that instead of a Vol Quote Type, an      |                                                                                       |                                                                                                                     |
| absolute strike level can be entered           |                                                                                       |                                                                                                                     |

Commodity Option Implied Volatility - Root table

</div>

<div id="tab:comimplvol_quote_delta">

| **Property**                               | **Allowable values**  | **Description**                 |
|:-------------------------------------------|:----------------------|:--------------------------------|
| Vol Quote Type                             | `DEL`, `ATM` or `MNY` |                                 |
| Delta Convention                           | `Fwd` or `Spot`       | Delta forward or spot quote     |
| Option Type                                | `Call` or `Put`       | Option type for the delta quote |
|                                            |                       |                                 |
| typically between 0.1                      |                       |                                 |
| and 0.45                                   |                       |                                 |
| that if the underlying commodity price     |                       |                                 |
| increases by 1 unit, the call option price |                       |                                 |
| increases by 0.40 units                    |                       |                                 |

Commodity Option Implied Volatility - Delta Quotes Table

</div>

<div id="tab:comimplvol_quote_atm">

| **Property**                                        | **Allowable values**  | **Description**                                                                     |
|:----------------------------------------------------|:----------------------|:------------------------------------------------------------------------------------|
| Vol Quote Type                                      | `DEL`, `ATM` or `MNY` |                                                                                     |
|                                                     |                       |                                                                                     |
| or `AtmDeltaNeutral`                                |                       |                                                                                     |
| alone, or when the smile is given by moneyness      |                       |                                                                                     |
| (`MNY`) quotes.                                     |                       |                                                                                     |
| The Delta Neutral Atm to be used as standalone,     |                       |                                                                                     |
| or when the smile is given by delta (`DEL`) quotes. |                       |                                                                                     |
|                                                     |                       |                                                                                     |
| Note that when `AtmFwd` or `AtmSpot` are used,      |                       |                                                                                     |
| the string stops here, no further entries “tokens”  |                       |                                                                                     |
| are required                                        |                       |                                                                                     |
| Atm Quote Type                                      | `DEL`                 | When `AtmDeltaNeutral` is used, the quote type must be set to Delta (`DEL`)         |
| Atm Delta Convention                                | `Fwd` or `Spot`       | When `AtmDeltaNeutral` is used, the Atm delta quote can be a Spot or Forward quote. |

Commodity Option Implied Volatility - ATM Quotes Table

</div>

<div id="tab:comimplvol_quote_mny">

| **Property**   | **Allowable values**     | **Description**                                                                                 |
|:---------------|:-------------------------|:------------------------------------------------------------------------------------------------|
| Vol Quote Type | `DEL`, `ATM` or `MNY`    |                                                                                                 |
|                |                          |                                                                                                 |
| Moneyness      | a positive `Real` number | The relative moneyness expressed in decimal form, relative to the AtmSpot or the AtmFwd strikes |

Commodity Option Implied Volatility - Moneyness Quotes Table

</div>

Volatilities are quoted:

- as a function of the delta - either the delta neutral at-the-money
  spot or forward, or for a call or put option with a given delta, or

- as a function of strike price - either at-the-money spot or forward,
  or a relative strike moneyness level, or else

- as a specified real number, corresponding to the absolute strike
  value.

Only log-normal implied commodity volatilities (`RATE_LNVOL`) are
supported.

For strike quoted volatilities, If $K$ is the absolute strike, $S$ the
spot, $F$ the forward and $m$ the moneyness level, we have $K=Sm$ if
spot moneyness and $K=Fm$ if forward moneyness is specified.

Example of delta forward quotes:

COMMODITY_OPTION/RATE_LNVOL/ICE:B/USD/c9/DEL/Fwd/Put/0.40  
COMMODITY_OPTION/RATE_LNVOL/ICE:B/USD/c9/DEL/Fwd/Put/0.45  
COMMODITY_OPTION/RATE_LNVOL/ICE:B/USD/c9/ATM/AtmDeltaNeutral/DEL/Fwd  
COMMODITY_OPTION/RATE_LNVOL/ICE:B/USD/c9/DEL/Fwd/Call/0.45  
COMMODITY_OPTION/RATE_LNVOL/ICE:B/USD/c9/DEL/Fwd/Call/0.40  
Example of delta spot quotes:

COMMODITY_OPTION/RATE_LNVOL/PM:XAGEUR/EUR/1Y/DEL/Spot/Put/0.35  
COMMODITY_OPTION/RATE_LNVOL/PM:XAGEUR/EUR/1Y/DEL/Spot/Put/0.45  
COMMODITY_OPTION/RATE_LNVOL/PM:XAGEUR/EUR/1Y/ATM/AtmDeltaNeutral/DEL  
/Spot  
COMMODITY_OPTION/RATE_LNVOL/PM:XAGEUR/EUR/1Y/DEL/Spot/Call/0.25  
COMMODITY_OPTION/RATE_LNVOL/PM:XAGEUR/EUR/1Y/DEL/Spot/Call/0.15  
Example of forward strike quotes with relative moneyness:

COMMODITY_OPTION/RATE_LNVOL/NYMEX:AA5/USD/c11/MNY/Fwd/1.40  
COMMODITY_OPTION/RATE_LNVOL/NYMEX:AA5/USD/c11/MNY/Fwd/1.20  
COMMODITY_OPTION/RATE_LNVOL/NYMEX:AA5/USD/c11/ATM/AtmFwd  
COMMODITY_OPTION/RATE_LNVOL/NYMEX:AA5/USD/c11/MNY/Fwd/0.80  
COMMODITY_OPTION/RATE_LNVOL/NYMEX:AA5/USD/c11/MNY/Fwd/0.60  
Example of absolute moneyness quotes:

COMMODITY_OPTION/RATE_LNVOL/PM:XAUUSD/USD/c12/1600  
COMMODITY_OPTION/RATE_LNVOL/PM:XAUUSD//USD/c12/1700  
COMMODITY_OPTION/RATE_LNVOL/PM:XAUUSD//USD/c12/1800  
COMMODITY_OPTION/RATE_LNVOL/PM:XAUUSD//USD/c12/1900  
COMMODITY_OPTION/RATE_LNVOL/PM:XAUUSD//USD/c12/2000  

## Zero Coupon Inflation Swap Rate

<div id="tab:zcinflationswap_quote">

| **Property**    | **Allowable values**             | **Description**                         |
|:----------------|:---------------------------------|:----------------------------------------|
| Instrument Type | *ZC_INFLATIONSWAP*               |                                         |
| Quote Type      | *RATE*                           |                                         |
| Index           | String                           | Identifying name of the inflation index |
| Maturity        | integer followed by D, W, M or Y | Maturity of the swap quote              |

Zero Coupon Inflation Swap Rate

</div>

Examples:

- ZC_INFLATIONSWAP/RATE/EUHICPXT/1Y

- ZC_INFLATIONSWAP/RATE/EUHICPXT/2Y

Examples for inflation index names include EUHICP, EUHICPXT, FRHICP,
FRCPI, UKRPI, USCPI, ZACPI, BEHICP, AUCPI.

## Year on Year Inflation Swap Rate

<div id="tab:yyinflationswap_quote">

| **Property**    | **Allowable values**             | **Description**                         |
|:----------------|:---------------------------------|:----------------------------------------|
| Instrument Type | *YY_INFLATIONSWAP*               |                                         |
| Quote Type      | *RATE*                           |                                         |
| Index           | String                           | Identifying name of the inflation index |
| Maturity        | integer followed by D, W, M or Y | Maturity of the swap quote              |

Year on Year Inflation Swap Rate

</div>

Examples:

- YY_INFLATIONSWAP/RATE/EUHICPXT/1Y

- YY_INFLATIONSWAP/RATE/EUHICPXT/2Y

Examples for inflation index names include EUHICP, EUHICPXT, FRHICP,
FRCPI, UKRPI, USCPI, ZACPI, BEHICP.

## Zero Coupon Inflation Cap Floor Price

<div id="tab:zcinflationcapfloorprice_quote">

| **Property**    | **Allowable values**             | **Description**                         |
|:----------------|:---------------------------------|:----------------------------------------|
| Instrument Type | *ZC_INFLATIONCAPFLOOR*           |                                         |
| Quote Type      | *PRICE*                          |                                         |
| Index           | String                           | Identifying name of the inflation index |
| Maturity        | integer followed by D, W, M or Y | Maturity of the swap quote              |
| Cap/Floor       | C or F                           | Cap or Floor tag                        |
| Strike          | Real number                      | Strike                                  |

Zero Coupon Inflation Cap Floor Price

</div>

Examples:

- ZC_INFLATIONCAPFLOOR/PRICE/EUHICPXT/1Y/F/-0.02

- ZC_INFLATIONCAPFLOOR/PRICE/EUHICPXT/2Y/C/0.01

Examples for inflation index names include EUHICP, EUHICPXT, FRHICP,
FRCPI, UKRPI, USCPI, ZACPI, BEHICP.

## Inflation Seasonality Correction Factors

<div id="tab:inflationseasonality_quote">

| **Property**    | **Allowable values** | **Description**                         |
|:----------------|:---------------------|:----------------------------------------|
| Instrument Type | *SEASONALITY*        |                                         |
| Quote Type      | *RATE*               |                                         |
| Type            | MULT                 | Type of the correction factor           |
| Index           | String               | Identifying name of the inflation index |
| Month           | JAN, ..., DEC        | Month of the correction factor          |

Inflation Seasonality Correction Factors

</div>

Examples:

- SEASONALITY/RATE/MULT/EUHICPXT/JAN

- SEASONALITY/RATE/MULT/EUHICPXT/FEB

- SEASONALITY/RATE/MULT/EUHICPXT/NOV

Examples for inflation index names include EUHICP, EUHICPXT, FRHICP,
FRCPI, UKRPI, USCPI, ZACPI, BEHICP.

## Bond Yield Spreads

<div id="tab:bondyieldspread_quote">

| **Property**    | **Allowable values** | **Description**              |
|:----------------|:---------------------|:-----------------------------|
| Instrument Type | *BOND*               |                              |
| Quote Type      | *YIELD_SPREAD*       |                              |
| Name            | String               | Identifying name of the bond |

Bond Yield Spreads

</div>

This quote provides the spread for a specified bond over the benchmark
rate.

Examples:

- BOND/YIELD_SPREAD/SECURITY_1

## Bond Prices

<div id="tab:bondprice_quote">

| **Property**    | **Allowable values** | **Description**              |
|:----------------|:---------------------|:-----------------------------|
| Instrument Type | *BOND*               |                              |
| Quote Type      | *PRICE*              |                              |
| Name            | String               | Identifying name of the bond |

Bond Prices

</div>

This quote provides the price for a specified bond. The reference data
of the bond specifies the further characteristics of the price, i.e.
type (clean or dirty) and quote method (percentage of par or currency
per unit).

Examples:

- BOND/PRICE/SECURITY_1

## Bond Future Price

<div id="tab:bondfutureprice_quote">

| **Property**    | **Allowable values** | **Description**                         |
|:----------------|:---------------------|:----------------------------------------|
| Instrument Type | *BOND_FUTURE*        |                                         |
| Quote Type      | *PRICE*              |                                         |
| Name            | String               | Identifying name of the future contract |

Bond Future Prices

</div>

This quote provides the price for a specified bond future contract.

Examples:

- BOND_FUTURE/PRICE/TYH25

## Bond Future Conversion Factor

<div id="tab:bond_future_conversion_factor">

| **Property**    | **Allowable values** | **Description**                         |
|:----------------|:---------------------|:----------------------------------------|
| Instrument Type | *BOND_FUTURE*        |                                         |
| Quote Type      | *CONVERSION_FACTOR*  |                                         |
| Name            | String               | Identifying name of the bond            |
| FutureContract  | String               | Identifying name of the future contract |

Bond Conversion Factor

</div>

This quote provides the conversion factor for a deliverable bond of a
bond future contract.

Examples:

- BOND_FUTURE/CONVERSION_FACTOR/ISIN:US91282CNF40/TYU25

## Base Correlations

<div id="tab:base_correlation_quote">

| **Property**    | **Allowable values** | **Description**                                                                                |
|:----------------|:---------------------|:-----------------------------------------------------------------------------------------------|
| Instrument Type | *CDS_INDEX*          |                                                                                                |
| Quote Type      | *BASE_CORRELATION*   |                                                                                                |
| Index           | String               | CDS index name                                                                                 |
| Term            | Period (e.g. 5Y)     | Term on the base correlation curve, the curve is flat if quotes for only one term are provided |
| DetachmentPoint | Real in (0...1)      | Detachment point of the equity tranche this quote refers to                                    |

Base correlation quotes

</div>

This quote provides the base correlation for a CDS index’ equity tranche
with the specified detachment point. Example:

- CDS_INDEX/BASE_CORRELATION/2I65BYBD6/5Y/0.03

Typically there are several base correlation quotes per term for several
detachment points such as 0.03, 0.07, 0.15.

## Correlations

<div id="tab:correlation_quote">

| **Property**    | **Allowable values** | **Description**                      |
|:----------------|:---------------------|:-------------------------------------|
| Instrument Type | *Correlation*        |                                      |
| Quote Type      | *RATE or PRICE*      |                                      |
| Index1          | String               | Identifying name of the first index  |
| Index2          | String               | Identifying name of the second index |

Correlation quotes

</div>

This quote either provides the correlation between two indices, in which
case Quote Type is RATE, or a premium that can be used to bootstrap the
correlations, in which case Quote Type is Price. Currently only CMS
Spread correlations are supported, in this case the Price quote is the
price of a CMS Spread Cap.

Examples:

- CORRELATION/RATE/INDEX1/INDEX2/1Y/ATM

## Conditional Prepayment Rates

<div id="tab:cpr_quote">

| **Property**    | **Allowable values** | **Description**              |
|:----------------|:---------------------|:-----------------------------|
| Instrument Type | *CPR*                |                              |
| Quote Type      | *RATE*               |                              |
| Name            | String               | Identifying name of the bond |

Conditional Prepayment Rates

</div>

This quote provides the spread for a specified bond over the benchmark
rate.

Examples:

- CPR/RATE/SECURITY_1
