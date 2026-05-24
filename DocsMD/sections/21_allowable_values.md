\ifdefined\RiskCatalogue\renewcommand{\subsection}{\section}\fi
\newpage
%- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
####  Allowable Values

\label{sec:allowable_values}
%- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -


\begin{longtable}{| p{.25\textwidth} | p{.80\textwidth} |}
\hline
\multicolumn{2}{|l|}{\lstinline!Date!}                    \\\\ \hline
**Date Fields**                   & **Allowable Values**                       \\\\ \hline
 \makecell[cl]{All Date fields: \\\\ \lstinline!StartDate! \\\\ \lstinline!EndDate! \\\\ \lstinline!Date! \\\\ \lstinline!ExerciseDate! \\\\ \lstinline!PayDate! \\\\ \lstinline!ValueDate! \\\\ \lstinline!NearDate! \\\\ \lstinline!FarDate! \\\\ etc} &   \begin{tabular}[l]{@{}l@{}} Any of the following date formats are supported: \\\\  *yyyymmdd* \\\\ *yyyy-mm-dd* \\\\ *yyyy/mm/dd* \\\\ *yyyy.mm.dd* \\\\ *dd-mm-yy* \\\\  *dd/mm/yy* \\\\  *dd.mm.yy* \\\\  *dd-mm-yyyy* \\\\  *dd/mm/yyyy* \\\\  *dd.mm.yyyy* \\\\ \vspace{1pt} \\\\ and \\\\ Dates as  serial numbers, comparable to Microsoft Excel \\\\dates, with a minimum of 367 for Jan 1, 1901,\\ and a maximum of 109574 for Dec 31, 2199.   \end{tabular} \\\\ \hline
  \caption{Allowable Values for Date}
  \label{tab:allow_stand_data}
  \end{longtable}


%\begin{table}[H]
%\centering
%  \begin{tabular} {|p{4cm}|p{11cm}|}
%    \hline
%    \bfseries{Trade Data} & \bfseries{Allowable Values} \\\\
%    \hline
%    \lstinline!Date! & \begin{tabular}[l]{@{}l@{}} The following date formats are supported: \\\\  *yyyymmdd* \\\\ *yyyy-mm-dd* \\\\ *yyyy/mm/dd* \\\\ *yyyy.mm.dd* \\\\ *dd-mm-yy* \\\\  *dd/mm/yy* \\\\  *dd.mm.yy* \\\\  *dd-mm-yyyy* \\\\  *dd/mm/yyyy* \\\\  *dd.mm.yyyy* \\\\ and \\\\ Dates as  serial numbers, comparable to Microsoft Excel \\\\dates, with a minimum of 367 for Jan 1, 1901,\\ and a maximum of 109574 for Dec 31, 2199.  \end{tabular}  \\\\ \hline

%    \lstinline!Roll Convention! & \begin{tabular}[l]{@{}l@{}} 
%*F,  Following, FOLLOWING*\\ 
%*MF, ModifiedFollowing, Modified Following, MODIFIEDF*\\ 
%*P, Preceding, PRECEDING*\\ 
%*MP, ModifiedPreceding, Modified Preceding, MODIFIEDP*\\ 
%*U, Unadjusted, INDIFF *\end{tabular}  \\\\ \hline
%  \end{tabular}
%  \caption{Allowable values for standard trade data.}
%  \label{tab:allow_stand_data}
%\end{table}


\begin{longtable}{| p{.30\textwidth} | p{.75\textwidth} |}
\hline
\multicolumn{2}{|l|}{\lstinline!Convention!}                    \\\\ \hline
**Roll Convention Fields**                   & **Allowable Values**                       \\\\ \hline
\makecell[cl]{ All Convention fields: \\\\ \lstinline!Convention! \\\\ \lstinline!TermConvention! \\\\ \lstinline!PaymentConvention! \\\\ etc} &   \makecell[cl]{
 *F,  Following, FOLLOWING*\\ 
 *MF, ModifiedFollowing, Modified Following, MODIFIEDF*\\ 
 *P, Preceding, PRECEDING*\\ 
 *MP, ModifiedPreceding, Modified Preceding, MODIFIEDP*\\ 
 *U, Unadjusted, INDIFF * \\\\
 *HMMF, HalfMonthModifiedFollowing, HalfMonthMF, Half Month Modified Following, HALFMONTHMF*\\
 *NEAREST * (takes future date in case of equal distance) } \\\\ \hline
  \caption{Allowable Values for Roll Conventions}
  \label{tab:convention}
  \end{longtable}


\newpage
\begin{longtable}{| p{.25\textwidth} | p{.80\textwidth} |}
\hline
\multicolumn{2}{|l|}{\lstinline!Currency!}                    \\\\ \hline
**Category**                   & **Allowable Values**                       \\\\ \hline
Fiat Currencies &   \emph{AED,AFN,ALL,AMD,ANG,AOA,ARS,AUD,AWG,AZN,
BAM,BBD,BDT,BGN,BHD,BIF,BMD,BND,BOB,BOV,
BRL,BSD,BTN,BWP,BYN,BZD,CAD,CDF,CHE,CHF,
CHW,CLF,CLP,CNH,CNT,CNY,COP,COU,CRC,CUC,
CUP,CVE,CZK,DJF,DKK,DOP,DZD,EGP,ERN,ETB,
EUR,FJD,FKP,GBP,GEL,GGP,GHS,GIP,GMD,GNF,
GTQ,GYD,HKD,HNL,HRK,HTG,HUF,IDR,ILS,IMP,
INR,IQD,IRR,ISK,JEP,JMD,JOD,JPY,KES,KGS,
KHR,KID,KMF,KPW,KRW,KWD,KYD,KZT,LAK,LBP,
LKR,LRD,LSL,LYD,MAD,MDL,MGA,MKD,MMK,MNT,
MOP,MRU,MUR,MVR,MWK,MXN,MXV,MYR,MZN,NAD,
NGN,NIO,NOK,NPR,NZD,OMR,PAB,PEN,PGK,PHP,
PKR,PLN,PYG,QAR,RON,RSD,RUB,RWF,SAR,SBD,
SCR,SDG,SEK,SGD,SHP,SLL,SOS,SRD,SSP,STN,
SVC,SYP,SZL,THB,TJS,TMT,TND,TOP,TRY,TTD,
TWD,TZS,UAH,UGX,USD,USN,UYI,UYU,UYW,UZS,
VES,VND,VUV,WST,XAF,XAU,XCD,XOF,
XPF,XSU,XUA,YER,ZAR,ZMW,ZWL}
\\ \hline Minor Currencies &  \makecell[l]{*GBp, GBX* (for pennies of GBP) \\\\ *ILa, ILX, ILs, ILA* (for agorot of ILS)  \\\\ *ZAc, ZAC, ZAX* (for cents of ZAR) \\\\ 
    Note: Minor Currency codes are only supported for equity products. } \\\\ \hline
%Pre-Eurozone Currencies   &  *ATS, BEF, DEM, ESP, FIM, FRF, GRD, IEP, ITL, LUF, NLG, PTE* \\\\ \hline
Precious Metals treated as Currencies   &   *XAG, XAU, XPD, XPT*  \\\\ \hline
Cryptocurrencies   &   *BTC, XBT, ETH, ETC, BCH, XRP, LTC* \\\\ \hline
\multicolumn{2}{|l|}{\makecell[l]{This full list of currencies is available via loading the provided {\tt currencies.xml} at start-up.\\
Note: Currency codes must also match available currencies in the {\tt simulation.xml} file.  }  }                  \\\\ \hline
  \caption{Allowable Values for Currency}
  \label{tab:currency}
  \end{longtable}



%\begin{table}[H]
%\centering
%\begin{tabular}{|l|p{6cm}|}
\begin{longtable}{| p{.23\textwidth} | p{.80\textwidth} |}
\hline
\multicolumn{2}{|l|}{\lstinline!Rule!}                    \\\\ \hline
**Allowable Values**                   & **Effect**                       \\\\ \hline
*Backward*   &   Backward from termination date to effective date.   \\\\ \hline
*Forward*   &   Forward from effective date to termination date.  \\\\ \hline
*Zero*   &   No intermediate dates between effective date and termination date.  \\\\ \hline
*ThirdWednesday*   &   All dates but effective date and
                          termination date are taken to be on the
                          third Wednesday of their month (with forward calculation.) \\\\ \hline
*LastWednesday*   &   All dates but effective date and
                          termination date are taken to be on the
                          last Wednesday of their month (with forward calculation.) \\\\ \hline
*ThirdThursday*   &   All dates but effective date and
                          termination date are taken to be on the
                          third Thursday of their month (with forward calculation.) \\\\ \hline
*ThirdFriday*   &   All dates but effective date and
                          termination date are taken to be on the
                          third Friday of their month (with forward calculation.) \\\\ \hline
*MondayAfterThird-* 
*Friday*  &   All dates but effective date and
                          termination date are taken to be on the
                          Monday following the third Friday of their month (with forward calculation.) \\\\ \hline
*TuesdayAfterThird-*
*Friday*   &   All dates but effective date and
                          termination date are taken to be on the
                          Tuesday following the third Friday of their month (with forward calculation.) \\\\ \hline
*Twentieth*   &   All dates but the effective date are taken to be the twentieth of their month (used for CDS schedules in emerging markets.)  The termination date is also modified. \\\\ \hline
*TwentiethIMM*   &   All dates but the effective date are  taken to be the twentieth of an IMM month (used for CDS schedules.)  The termination date is also modified. \\\\ \hline
*OldCDS*   &   Same as TwentiethIMM with unrestricted date ends and long/short stub coupon period (old CDS convention).\\ \hline
*CDS*   &    \makecell[tl]{Credit derivatives standard rule defined in 'Big Bang' changes in 2009. \\\\ \\\\ For quarterly periods (\lstinline!Tenor! set to *3M*): \\\\ (Assuming no \lstinline!FirstDate!/\lstinline!LastDate!) \\\\ Dates fall on 20th of March, June, September, December. A *Following* \\\\ roll convention will be applied if the 20th falls on a non-business day. \\\\ If the \lstinline!EndDate! in the schedule is set to a date beyond the rolled \\\\ quarterly CDS date, the actual trade termination date will be on the \\\\ following quarterly CDS date. \\\\ The first coupon will be paid on the quarterly CDS date following the \\\\ \lstinline!StartDate!, and be for the period since the previous quarterly CDS \\\\ date.  \\\\ \\\\ For monthly periods (\lstinline!Tenor! set to *1M*): \\\\ (Assuming no \lstinline!FirstDate!/\lstinline!LastDate!)\\ Dates fall on 20th of each month, but the termination is still adjusted \\\\ to be in line with quarterly periods. \\\\ If the \lstinline!EndDate! in the schedule is set to a date beyond the rolled \\\\ quarterly CDS date (i.e. the 20th+roll Mar, Jun, Sep, Dec), \\\\ the actual termination date will be on the following quarterly CDS \\\\ date, causing a long final stub. \\\\ The first coupon will be paid on the next 20th monthly following the \\\\ \lstinline!StartDate!, and be for the period since the previous month's 20th.}\\ \hline
*CDS2015*   &    \makecell[tl]{Credit derivatives standard rule updated in 2015. \\\\ Same as  *CDS* but with termination dates adjusted to \\\\ 20th June and 20th December. \\\\ For schedule \lstinline!EndDates!  from the 20th of March to the 19th September, \\\\ both included, the termination date will fall on the 20th June (with \\\\  *Following* roll). \\\\ For schedule \lstinline!EndDates! from the 20th September to the 19th March, \\\\ both included, the termination date will fall on the 20th December \\\\ (with *Following* roll).} \\\\ \hline
*EveryThursday*   &  If FirstDate is not given, all thursdays between start and end date.
                          If FirstDate is given, FirstDate plus all thursdays between FirstDate and end date. \\\\ \hline
\caption{Allowable Values for Rule}
\label{tab:rule}
\end{longtable}

\begin{longtable}{| p{.30\textwidth} | p{.70\textwidth} |}
    \hline
    \multicolumn{2}{|l|} {\tt Calendar}  \\\\ \hline
    \bfseries{Allowable Values} & \bfseries{Resulting Calendar} \\\\
    \hline
    *TARGET, TGT, EUR* & Target Calendar  \\\\ \hline
    *CA, CAN, CAD, TRB* & Canada Calendar \\\\ \hline
    *JP, JPN, JPY, TKB* & Japan Calendar \\\\ \hline
    *CH, CHE, CHF, ZUB* & Switzerland Calendar \\\\ \hline
    *GB, GBR, GBP, LNB, UK* & UK Calendar \\\\ \hline
    *US, USA, USD, NYB* & US Calendar \\\\ \hline
    *US-SET* & US Settlement Calendar \\\\ \hline
    *US-GOV* & US Government Bond Calendar \\\\ \hline    
    *US-NYSE, New York stock exchange* & US NYSE Calendar \\\\ \hline
    *US with Libor impact* & US Calendar for Libor fixings \\\\ \hline
    *US-NERC* & US NERC Calendar \\\\ \hline  
    *US-SOFR* & US SOFR fixing Calendar \\\\ \hline
    *AR, ARG, ARS* & Argentina Calendar \\\\ \hline    
    *AU, AUD, AUS* & Australia Calendar \\\\ \hline
    *AT, AUT, ATS* & Austria Calendar \\\\ \hline    
    *BE, BEL, BEF* & Belgium Calendar \\\\ \hline    
    *BW, BWA, BWP* & Botswana Calendar \\\\ \hline
    *BR, BRA, BRL* & Brazil Calendar \\\\ \hline
    *CL, CHL, CLP* & Chile Calendar \\\\ \hline
    *CN, CHN, CNH, CNY* & China Calendar \\\\ \hline
    *CO, COL, COP* & Colombia Calendar \\\\ \hline
    *CY, CYP* & Cyprus Calendar \\\\ \hline
    *CZ, CZE, CZK* & Czech Republic Calendar \\\\ \hline
    *DK, DNK, DKK, DEN* & Denmark Calendar \\\\ \hline
    *FI, FIN* & Finland Calendar \\\\ \hline
    *FR, FRF* & France Calendar \\\\ \hline
    *DE, DEU* & Germany Calendar \\\\ \hline
    *GR, GRC* & Greek Calendar \\\\ \hline
    *HK, HKG, HKD* & Hong Kong Calendar \\\\ \hline
    *HU, HUN, HUF* & Hungary Calendar \\\\ \hline
    *IS, ISL, ISK* & Iceland Calendar \\\\ \hline
    *IN, IND, INR* & India Calendar \\\\ \hline
    *ID, IDN, IDR* & Indonesia Calendar \\\\ \hline
    *IE, IRL* & Ireland Calendar \\\\ \hline
    *IL, ISR, ILS* & Israel Calendar \\\\ \hline
    *Telbor* & Tel Aviv Inter-Bank Offered Rate Calendar \\\\ \hline
    *IT, ITA, ITL* & Italy Calendar \\\\ \hline
    *LU, LUX, LUF* & Luxembourg Calendar \\\\ \hline    
    *MX, MEX, MXN* & Mexico Calendar \\\\ \hline
    *MY, MYS, MYR* & Malaysia Calendar \\\\ \hline
    *NL, NLD, NZD* & New Zealand Calendar\\ \hline
    *NO, NOR, NOK* & Norway Calendar \\\\ \hline
    *PE, PER, PEN* & Peru Calendar \\\\ \hline
    *PH, PHL, PHP* & Philippines Calendar \\\\ \hline
    *PO, POL, PLN* & Poland Calendar \\\\ \hline
    *RO, ROU, RON* & Romania Calendar \\\\ \hline
    *RU, RUS, RUB* & Russia Calendar \\\\ \hline
    *SAU, SAR* & Saudi Arabia \\\\ \hline
    *AE, ARE, AED* & United Arab Emirates \\\\ \hline
    *SG, SGP, SGD* & Singapore Calendar \\\\ \hline
    *ZA, ZAF, ZAR, SA* & South Africa Calendar \\\\ \hline    
    *KR, KOR, KRW* & South Korea Calendar \\\\ \hline
    *ES, ESP* & Spain Calendar \\\\ \hline
    *SE, SWE, SEK, SS* & Sweden Calendar \\\\ \hline        
    *TW, TWN, TWD* & Taiwan Calendar \\\\ \hline
    *TH, THA, THB* & Thailand Calendar \\\\ \hline
    *TR, TUR, TRY* & Turkey Calendar \\\\ \hline
    *UA, UKR, UAH* & Ukraine Calendar \\\\ \hline
    *XASX* & Australian Securities Exchange Calendar \\\\ \hline
    *BVMF* & Brazil Bovespa Calendar \\\\ \hline
    *XTSE* & Canada Toronto Stock Exchange Calendar \\\\ \hline
    *XSHG* & China Shanghai Stock Exchange Calendar \\\\ \hline
    *XFRA* & Germany Frankfurt Stock Exchange \\\\ \hline
    *XETR* & Germany XETRA Calendar \\\\ \hline
    *ECAG* & Germany EUREX Calendar \\\\ \hline
    *EUWA* & Germany EUWAX Calendar \\\\ \hline
    *XJKT* & Indonesia Jakarta Stock Exchange (now IDX) Calendar \\\\ \hline
    *XIDX* & Indonesia Indonesia Stock Exchange Calendar \\\\ \hline
    *XDUB* & Ireland Stock Exchange Calendar \\\\ \hline
    *XTAE* & Israel Tel Aviv Stock Exchange Calendar \\\\ \hline
    *XMIL* & Italy Italian Stock Exchange Calendar \\\\ \hline
    *MISX* & Russia Moscow Exchange Calendar \\\\ \hline
    *XKRX* & Korea Exchange Calendar \\\\ \hline
    *XSWX* & Switzerland SIX Swiss Exchange Calendar \\\\ \hline
    *XLON* & UK London Stock Exchange \\\\ \hline
    *XLME* & UK London Metal Exchange \\\\ \hline
    *XNYS* & US New York Stock Exchange Calendar \\\\ \hline
    *XPAR* & Paris stock exchange \\\\ \hline
    *WMR* & Thomson Reuters WM/Reuters Spot \\\\ \hline
    *IslamicWeekendsOnly* & Islamic Weekends Only Calendar \\\\ \hline
    *WeekendsOnly* & Weekends Only Calendar \\\\ \hline
    *IslamicWeekendsOnly* & Islamic Weekends Only Calendar \\\\ \hline
    *ICE\_FuturesUS* & ICE Futures U.S. Currency, Stock and Credit Index, Metal, Nat Gas, Power, Oil and Environmental \\\\ \hline
    *ICE\_FuturesUS\_1* & ICE Futures U.S. Sugar, Cocoa, Coffee, Cotton and FCOJ \\\\ \hline
    *ICE\_FuturesUS\_2* & ICE Futures U.S. Canola \\\\ \hline
    *ICE\_FuturesEU* & ICE Futures Europe \\\\ \hline
    *ICE\_FuturesEU\_1* & ICE Futures Europe for contracts where 26 Dec is a holiday \\\\ \hline
    *ICE\_EndexEnergy* & ICE Endex European power and natural gas products \\\\ \hline
    *ICE\_EndexEquities* & ICE Endex European equities \\\\ \hline
    *ICE\_SwapTradeUS* & ICE Swap Trade U.S. \\\\ \hline
    *ICE\_SwapTradeUK* & ICE Swap Trade U.K. \\\\ \hline
    *ICE\_FuturesSingapore* & ICE futures Singapore \\\\ \hline
    *CME* & CME group exchange calendar \\\\ \hline
    % *US+TARGET, NYB\_TGT, TGT\_NYB* & US and Target Calendar \\\\ \hline  
    % *NYB\_LNB, LNB\_NYB* & US and UK Calendar \\\\ \hline    
    % *LNB\_ZUB, ZUB\_LNB* & Switzerland and UK Calendar \\\\ \hline   
    % *TGT\_ZUB, ZUB\_TGT* & Switzerland and Target Calendar \\\\ \hline
    % *NYB\_SYB* & US and Australia Calendar \\\\ \hline 
    % *TGT\_BDP, BDP\_TGT* & Hungary and Target Calendar \\\\ \hline         
    % *LNB\_NYB\_TGT* & UK, US and Target Calendar \\\\ \hline
    % *TKB\_TGT\_LNB* & Japan, Target and UK Calendar \\\\ \hline         
    % *LNB\_NYB\_ZUB* & UK, US and Switzerland Calendar \\\\ \hline
    % *LNB\_NYB\_TRB* & UK, US and Canada Calendar \\\\ \hline 
    % *LNB\_NYB\_TKB* & UK, US and Japan Calendar \\\\ \hline   
    *NullCalendar, Null* & Null Calendar, i.e. all days are business days \\\\ \hline                 
  \caption{Allowable Values for Calendar. Combinations of calendars can be provided using comma separated calendar names.}
  \label{tab:calendar}
\end{longtable}

\begin{table}[H]
\centering
  \begin{tabular} {|p{6cm}|p{6cm}|}
    \hline
    %\multicolumn{2}{|l|}{\lstinline{DayCount Convention} }                             \\\\ \hline
    \multicolumn{2}{|l|}{\tt DayCount Convention}                          \\\\ \hline
    \bfseries{Allowable Values} & \bfseries{Resulting DayCount Convention} \\\\
    \hline
    *A360, Actual/360, ACT/360, Act/360*& Actual 360  \\\\ \hline
    *A365, A365F, Actual/365 (Fixed), Actual/365 (fixed), ACT/365.FIXED, ACT/365, ACT/365L, Act/365, Act/365L* & Actual 365 Fixed \\\\ \hline
    *A364, Actual/364, Act/364, ACT/364*& Actual 364  \\\\ \hline
    *Actual/365 (No Leap), Act/365 (NL), NL/365, Actual/365 (JGB)* & Actual 365 Fixed (No Leap Year)\\ \hline
    *Act/365 (Canadian Bond)* & Actual 365 Fixed (Canadian Bond)\\ \hline
    *T360, 30/360, ACT/nACT, 30/360 US, 30/360 (US), 30U/360, 30US/360* & Thirty 360 (US) \\\\ \hline
    *30/360 NASD* & Thirty 360 (NASD) \\\\ \hline
    *30/360 (Bond Basis)* & Thirty 360 (Bond Basis) \\\\ \hline
    *30E/360 (Eurobond Basis), 30E/360, 30/360 AIBD (Euro), 30E/360.ICMA, 30E/360 ICMA* & Thirty 360 (European) \\\\ \hline
    *30E/360E, 30E/360 ISDA, 30E/360.ISDA, 30/360 German, 30/360 (German)* & Thirty 360 (German) \\\\ \hline
    *30/360 Italian, 30/360 (Italian)* & Thirty 360 (Italian) \\\\ \hline
    *ActActISDA, ACT/ACT.ISDA, Actual/Actual (ISDA), ActualActual (ISDA), ACT/ACT, Act/Act, ACT* & Actual Actual (ISDA) \\\\ \hline
    *ActActISMA, Actual/Actual (ISMA), ActualActual (ISMA), ACT/ACT.ISMA* & Actual Actual (ISMA) \\\\ \hline
    *ActActICMA, Actual/Actual (ICMA), ActualActual (ICMA), ACT/ACT.ICMA* & Actual Actual (ICMA) \\\\ \hline
    *ActActAFB, ACT/ACT.AFB, Actual/Actual (AFB), ACT29* & Actual Actual (AFB) \\\\ \hline
    *BUS/252, Business/252* & Brazilian Bus/252 \\\\ \hline
    *1/1* & 1/1  \\\\ \hline
    *Simple* & Simple Day Counter  \\\\ \hline
    *Year* & Year Counter  \\\\ \hline
  \end{tabular}
  \caption{Allowable Values for DayCount Convention}
  \label{tab:daycount}
\end{table}

\begin{table}[H]
\centering
\begin{tabular}{|l|l|}
\hline
%\multicolumn{2}{|l|}{\lstinline!Index!}   \\\\ \hline
\multicolumn{2}{|l|}{\tt Index}   \\\\ \hline
\multicolumn{2}{|l|}{On form CCY-INDEX-TENOR, and matching available  }   \\\\ 
\multicolumn{2}{|l|}{ indices in the market data configuration.} \\\\ \hline
**Index Component** & **Allowable Values**                                                                                                                                                                                                                                                           \\\\ \hline
CCY-INDEX                &
                           \textit{\begin{tabular}[c]{@{}l@{}}
EUR-EONIA\\ EUR-ESTER, EUR-ESTR, EUR-STR 
\\ EUR-EURIBOR, EUR-EURIBOR365\\ EUR-LIBOR\\ EUR-CMS\\
USD-FedFunds\\ USD-SOFR \\\\ USD-Prime\\ USD-LIBOR\\ USD-SIFMA\\ USD-CMS\\
GBP-SONIA\\ GBP-LIBOR\\ GBP-CMS \\\\ GBP-BoEBase \\\\ 
JPY-LIBOR\\ JPY-TIBOR \\\\ JPY-EYTIBOR \\\\ JPY-TONAR \\\\ JPY-CMS \\\\
CHF-LIBOR\\ CHF-SARON\\ 
AUD-LIBOR\\ AUD-BBSW\\ 
CAD-CDOR\\ CAD-BA\\ 
SEK-STIBOR\\ SEK-LIBOR\\ SEK-STINA \\\\ 
DKK-LIBOR\\ DKK-CIBOR \\\\ DKK-CITA \\\\
SGD-SIBOR\\ SGD-SOR \\\\
HKD-HIBOR \\\\ HKD-HONIA \\\\
NOK-NIBOR \\\\
HUF-BUBOR \\\\
IDR-IDRFIX \\\\
INR-MIFOR \\\\
MXN-TIIE \\\\
PLN-WIBOR \\\\
RUB-MOSPRIME \\\\
SKK-BRIBOR \\\\
THB-THBFIX \\\\ THB-THOR \\\\ THB-BIBOR \\\\
NZD-BKBM \\\\
\end{tabular}} \\\\ \hline
TENOR                    & An integer followed by *D, W, M or Y*                                                                                                                                                                                                                                                 \\\\ \hline
\end{tabular}
  \caption{Allowable values for Index.}
  \label{tab:indices}
\end{table}

\begin{table}[H]
\centering
\begin{tabular}{|l|p{10cm}|}
\hline
\multicolumn{2}{|l|} {Defaults for {\tt FixingDays}}   \\\\ \hline
**Index** &**Default value**     \\\\ \hline \hline
Ibor indices    &   2, except for the Ibor indices below:  \\\\ \hline
*USD-SIFMA*    &   1 \\\\ \hline
*GBP-LIBOR*    &   0 \\\\ \hline
*AUD-BBSW*    &   0 \\\\ \hline
*CAD-CDOR*    &   0 \\\\ \hline
*CNY-SHIBOR*    &   1 \\\\ \hline
*HKD-HIBOR*    &   0 \\\\ \hline
*MXN-TIIE*    &   1 \\\\ \hline
*MYR-KLIBOR*    &   0 \\\\ \hline
*TRY-TRLIBOR*    &   0 \\\\ \hline
*ZAR-JIBAR*    &   0 \\\\ \hline \hline
Overnight indices    &   0, except for the Overnight indices below:  \\\\ \hline
*CHF-TOIS*    &   1 \\\\ \hline
*CLP-CAMARA*    &   2 \\\\ \hline
*PLN-POLONIA*    &   1 \\\\ \hline
*DKK-DKKOIS*    &   1 \\\\ \hline
*SEK-SIOR*    &   1 \\\\ \hline
\end{tabular}
  \caption{Defaults for FixingDays}
  \label{tab:fixingdaysdefaults}
\end{table}

\begin{table}[H]
\centering
\begin{tabular}{|l|p{10cm}|}
\hline
%\multicolumn{2}{|l|}{\lstinline!Index!}   \\\\ \hline
\multicolumn{2}{|l|}{\tt FX Index}   \\\\ \hline
**Index Format** &**Allowable Values**     \\\\ \hline
\lstinline!FX-SOURCE-CCY1-CCY2!    &    
The \lstinline!FX-! part of the string stays constant for all currency pairs. \lstinline!SOURCE! is the market data fixing source defined in the market configuration. \lstinline!CCY1! and \lstinline!CCY2! are the ISO currency codes of the fx pair. Fixings are expressed as amount in \lstinline!CCY2! for one unit of \lstinline!CCY1!.\\ \hline
\end{tabular}
  \caption{Allowable values for FX index fixings.}
  \label{tab:fxindex_data}
\end{table}

\begin{table}[H]
\centering
  \begin{tabular} {|l|p{8cm}|}
    \hline
    \multicolumn{2}{|l|}{\tt Inflation CPI Index} \\\\ \hline
    \bfseries{Trade Data} & \bfseries{Allowable Values} \\\\
    \hline
    \lstinline!Index! for CPI leg & Any string (provided it is the ID of an inflation index in the market configuration) \\\\
    \hline
  \end{tabular}
  \caption{Allowable values for CPI index.}
  \label{tab:cpiindex_data}
\end{table}

\begin{table}[H]
\centering
  \begin{tabular} {|p{3cm}|p{12cm}|}
    \hline
    \multicolumn{2}{|l|}{\tt Credit CreditCurveId} \\\\ \hline
    \bfseries{Trade Data} & \bfseries{Allowable Values} \\\\
    \hline
    \lstinline!CreditCurveId!   for credit trades - single name and index & \begin{tabular}[l]{@{}l@{}} Any string (provided it is the ID of a single name or index \\\\ reference entity in the market 
configuration). \\\\ Typically a RED-code with the *RED:* prefix \\\\  Examples: \\\\  *RED:2I65BRHH6*  (CDX N.A. High Yield, Series 13, Version 1) \\\\ *RED:008CA0\textbar{*SNRFOR\textbar{}USD\textbar{}MR14}  (Agilent Tech Senior USD)
\end{tabular}  \\\\ \hline
  \end{tabular}
  \caption{Allowable values for credit \lstinline!CreditCurveId!}
  \label{tab:equity_credit_data}
\end{table}

\begin{table}[H]
\centering
  \begin{tabular} {|l|l|}
    \hline
    \multicolumn{2}{|l|}{\tt Equity Name} \\\\ \hline
    \bfseries{Trade Data} & \bfseries{Allowable Values} \\\\
    \hline
    \lstinline!Name!   for equity trades & \begin{tabular}[l]{@{}l@{}}  Any string (provided it is the ID of an equity in the market \\\\
configuration). \\\\ Typically a RIC-code with the *RIC:* prefix \\\\  Examples: \\\\  *RIC:.SPX*  (S\&P 500 Index) \\\\ *RIC:EEM.N*  (iShares MSCI Emerging Markets ETF)    \\\\  
\end{tabular}  \\\\ \hline
  \end{tabular}
  \caption{Allowable values for equity  \lstinline!Name!.}
  \label{tab:equity_name}
\end{table}

\begin{table}[H]
\centering
  \begin{tabular} {|p{3cm}|p{12cm}|}
    \hline
    \multicolumn{2}{|l|}{\tt Commodity Curve Name} \\\\ \hline
    \bfseries{Trade Data} & \bfseries{Allowable Values} \\\\
    \hline
    \lstinline!Name! for commodity trades & Any string (provided it is the ID of an commodity in the market configuration) \\\\
    \hline
  \end{tabular}
  \caption{Allowable values for commodity data.}
  \label{tab:commodity_data}
\end{table}

\begin{table}[H]
\centering
  \begin{tabular} {|p{3cm}|p{12cm}|}
    \hline
    \multicolumn{2}{|l|}{\lstinline!Tier!} \\\\
    \hline
    **Value** & **Description** \\\\
    \hline
    \lstinline!SNRFOR! & Senior unsecured for corporates or foreign debt for sovereigns \\\\
    \hline
    \lstinline!SUBLT2! & Subordinated or lower Tier 2 debt for banks \\\\
    \hline
    \lstinline!SNRLAC! & Senior loss absorbing capacity \\\\
    \hline
    \lstinline!SECDOM! & Secured for corporates or domestic debt for sovereigns \\\\
    \hline
    \lstinline!JRSUBUT2! & Junior subordinated or upper Tier 2 debt for banks \\\\
    \hline
    \lstinline!PREFT1! & Preference shares or Tier 1 capital for banks \\\\
    \hline
    \lstinline!LIEN1! & First lien \\\\
    \hline
    \lstinline!LIEN2! & Second lien \\\\
    \hline
    \lstinline!LIEN3! & Third lien \\\\
    \hline
  \end{tabular}
  \caption{Allowable values for \lstinline!Tier!}
  \label{tab:tier_data}
\end{table}

\begin{table}[H]
\centering
  \begin{tabular} {|p{3cm}|p{12cm}|}
    \hline
    \multicolumn{2}{|l|}{\lstinline!DocClause!} \\\\
    \hline
    **Value** & **Description** \\\\
    \hline
    \lstinline!CR! & Full or old restructuring referencing the 2003 ISDA Definitions \\\\
    \hline
    \lstinline!MM! & Modified modified restructuring referencing the 2003 ISDA Definitions \\\\
    \hline
    \lstinline!MR! & Modified restructuring referencing the 2003 ISDA Definitions \\\\
    \hline
    \lstinline!XR! & No restructuring referencing the 2003 ISDA Definitions \\\\
    \hline
    \lstinline!CR14! & Full or old restructuring referencing the 2014 ISDA Definitions \\\\
    \hline
    \lstinline!MM14! & Modified modified restructuring referencing the 2014 ISDA Definitions \\\\
    \hline
    \lstinline!MR14! & Modified restructuring referencing the 2014 ISDA Definitions \\\\
    \hline
    \lstinline!XR14! & No restructuring referencing the 2014 ISDA Definitions \\\\
    \hline
  \end{tabular}
  \caption{Allowable values for \lstinline!DocClause!}
  \label{tab:docclause_data}
\end{table}

\begin{table}[H]
\centering
  \begin{tabular} {|p{3cm}|p{12cm}|}
    \hline
    \multicolumn{2}{|l|}{\tt Exchange} \\\\ \hline
    \bfseries{Trade Data} & \bfseries{Allowable Values} \\\\
    \hline
    \lstinline!Exchange!  & Any string, typically a MIC code (provided it is the ID of an exchange in the market configuration) \\\\
    \hline
  \end{tabular}
  \caption{Allowable Values for Exchange}
  \label{tab:mic}
\end{table}

\begin{table}[H]
\centering
  \begin{tabular} {|l|l|}
    \hline
    \multicolumn{2}{|l|}{Boolean nodes} \\\\
    \hline
    **Node Value** & **Evaluates To** \\\\
    \hline
    \lstinline!Y!, \lstinline!YES!, \lstinline!TRUE!, \lstinline!true!, \lstinline!1! & \lstinline!true! \\\\
    \hline
    \lstinline!N!, \lstinline!NO!, \lstinline!FALSE!, \lstinline!false!, \lstinline!0! & \lstinline!false! \\\\
    \hline
  \end{tabular}
  \caption{Allowable values for boolean node}
  \label{tab:boolean_allowable}
\end{table}