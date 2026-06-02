# ORE Bond 평가 가이드

이 문서는 ORE (Open Source Risk Engine)에서 Bond 평가와 관련된 주요 개념과 예제를 정리한 것입니다.

---

## 목차

1. [Bond 예제 위치](#1-bond-예제-위치)
2. [Bond 유형별 예제](#2-bond-유형별-예제)
3. [Z-Spread 적용 방법](#3-z-spread-적용-방법)
4. [국채/회사채 구분](#4-국채회사채-구분)
5. [BondYieldShifted 곡선 구축](#5-bondyieldshifted-곡선-구축)
6. [Bond 실행 방법](#6-bond-실행-방법)

---

## 1. Bond 예제 위치

ORE에서 Bond 관련 예제는 주로 `Examples/Products/` 디렉토리에 있습니다.

### 주요 디렉토리 구조

```
Examples/
├── Products/
│   ├── Example_Trades/
│   │   ├── Cash_Bonds.xml                    # 기본 Bond 예제
│   │   ├── Cash_BondRepo_and_Bond.xml        # Bond + Repo
│   │   ├── Cash_ConvertibleBond.xml          # 전환사채
│   │   ├── Credit_Bond_Forward.xml           # 채권 선도
│   │   ├── Credit_Bond_TRS.xml               # 채권 TRS
│   │   ├── Credit_BondOption.xml             # 채권 옵션
│   │   └── Credit_CallableBond.xml          # 조기상환가능채권
│   ├── Input/
│   │   ├── portfolio.xml                     # 포트폴리오
│   │   ├── pricingengine.xml                  # 프라이싱 엔진
│   │   ├── todaysmarket.xml                  # 마켓 데이터 설정
│   │   ├── curveconfig.xml                   # 커브 설정
│   │   ├── marketdata.csv                    # 마켓 데이터
│   │   └── referencedata.xml                 # 참조 데이터
│   └── run.py                                # 실행 스크립트
└── CurveBuilding/
    └── Input/
        └── ore_bondyieldshifted.xml          # 곡선 구축 예제
```

---

## 2. Bond 유형별 예제

### 2.1 Cash_Bonds.xml (기본 Bond 예제)

가장 기본적인 Bond 평가 예제 파일입니다.

| Trade ID | 설명 |
|----------|------|
| `Bond_Fixed` | 고정 쿠폰 채권 (Fixed Rate Bond) - 5% 금리, 10년물 |
| `Bond_Floating` | 변동 쿠폰 채권 (Floating Rate Note) - EURIBOR + 100bps |
| `Bond_Fixed_Then_Floating` | 고정→변동 쿠폰 변경 채권 |
| `Bond_Amortizing_FixedAmount` | 고정금액 상각 채권 |
| `Bond_Amortizing_Percentage_Initial` | 초기잔앨 기준 퍼센트 상각 |
| `Bond_Amortizing_Percentage_Previous` | 이전잔앨 기준 퍼센트 상각 |
| `Bond_Amortizing_Fixed_Annuity` | 고정 상환액 (年金) 방식 |
| `Bond_Amortizing_Floating_Annuity` | 변동 상환액 방식 |
| `FwdBond_*` | 선도 채권 (Forward Bond) 예제들 |

### 2.2 Bond XML 구조 예시

```xml
<Trade id="Bond_Fixed">
  <TradeType>Bond</TradeType>
  <Envelope>
    <CounterParty>CPTY_C</CounterParty>
    <NettingSetId/>
    <AdditionalFields/>
  </Envelope>
  <BondData>
    <IssuerId>CPTY_C</IssuerId>
    <CreditCurveId>CPTY_C</CreditCurveId>
    <SecurityId>SECURITY_1</SecurityId>
    <ReferenceCurveId>EUR-EURIBOR-6M</ReferenceCurveId>
    <SettlementDays>2</SettlementDays>
    <Calendar>TARGET</Calendar>
    <IssueDate>2025-02-03</IssueDate>
    <LegData>
      <LegType>Fixed</LegType>
      <Payer>false</Payer>
      <Currency>EUR</Currency>
      <Notionals>
        <Notional>10000000.000000</Notional>
      </Notionals>
      <DayCounter>ACT/ACT</DayCounter>
      <PaymentConvention>F</PaymentConvention>
      <FixedLegData>
        <Rates>
          <Rate>0.05</Rate>
        </Rates>
      </FixedLegData>
      <ScheduleData>
        <Rules>
          <StartDate>2025-02-03</StartDate>
          <EndDate>2035-02-03</EndDate>
          <Tenor>1Y</Tenor>
          <Calendar>TARGET</Calendar>
          <Convention>F</Convention>
          <TermConvention>F</TermConvention>
          <Rule>Forward</Rule>
          <EndOfMonth/>
        </Rules>
      </ScheduleData>
    </LegData>
  </BondData>
</Trade>
```

---

## 3. Z-Spread 적용 방법

### 3.1 개념

Z-Spread(Zero-Volatility Spread)는 할인율 커브에 더해지는 상수 스프레드로, 채권의 시장 가격을 이론적으로 설명합니다.

```
Adjusted Discount Rate = Base Rate + Z-Spread
```

### 3.2 ORE에서의 구현

#### 코드 레벨 구현 (bond.cpp:79-81)

```cpp
if (!securityId.empty())
    yts = Handle<YieldTermStructure>(QuantLib::ext::make_shared<ZeroSpreadedTermStructure>(
        yts, market_->securitySpread(securityId, configuration(MarketContext::pricing))));
```

#### Pricing Engine 파라미터 (bond.hpp)

| 파라미터 | 기본값 | 설명 |
|----------|--------|------|
| `SpreadOnIncomeCurve` | true | 스프레드를 income 커브에도 적용 |
| `TreatSecuritySpreadAsCreditSpread` | false | 스프레드를 신용스프레드로 처리 |
| `IncludePastCashflows` | false | 과거 캐시플로우 포함 여부 |

### 3.3 Z-Spread 데이터 입력 방법

#### Market 데이터 파일 (market.txt 또는 marketdata.csv)

```
20160205 BOND/YIELD_SPREAD/SECURITY_1 0.03  # 300bp z-spread
20160205 BOND/YIELD_SPREAD/SECURITY_2 0.025 # 250bp z-spread
```

#### Curve Config XML (curveconfig.xml)

```xml
<SpreadQuote>BOND/YIELD_SPREAD/SECURITY_1</SpreadQuote>
```

### 3.4 Z-Spread 적용 구조도

```
┌─────────────────────────────────────────────────────────────┐
│  Market Data: BOND/YIELD_SPREAD/SECURITY_ID (예: 0.03)      │
└─────────────────────────────────────────────────────────────┘
                            │
                            ▼
┌─────────────────────────────────────────────────────────────┐
│  market_->securitySpread(securityId) 로 조회                │
└─────────────────────────────────────────────────────────────┘
                            │
                            ▼
┌─────────────────────────────────────────────────────────────┐
│  ZeroSpreadedTermStructure(yts, spread)                     │
│  → 할인커브에 상수 z-spread 더함                              │
│  → r(t) + z-spread (모든 만기에 동일하게 적용)                │
└─────────────────────────────────────────────────────────────┘
                            │
                            ▼
┌─────────────────────────────────────────────────────────────┐
│  DiscountingRiskyBondEngine                                 │
│  - yts: 할인율 커브 (+ z-spread 적용됨)                        │
│  - dpts: 신용커브 (default probability)                       │
│  - recovery: 회수율                                          │
│  - spreadOnIncome: true면 income 커브에도 적용               │
└─────────────────────────────────────────────────────────────┘
```

### 3.5 Pricing Engine XML 설정 예시

```xml
<Product type="Bond" currency="EUR">
  <Parameter name="SpreadOnIncomeCurve">true</Parameter>
  <Parameter name="TreatSecuritySpreadAsCreditSpread">false</Parameter>
  <Parameter name="IncludePastCashflows">false</Parameter>
</Product>
```

---

## 4. 국채/회사채 구분

### 4.1 구분 기준

ORE에서 **CounterParty**가 아닌 **IssuerId**로 국채/회사채를 구분합니다.

| 필드 | 위치 | 용도 |
|------|------|------|
| **CounterParty** | `<Envelope>` | XVA 계산용 거래상대방 (Credit Risk) |
| **IssuerId** | `<BondData>` | 채권 발행자 (국채/회사채 구분) |

### 4.2 IssuerId 예시

```xml
<!-- 국채 예시 -->
<BondData>
  <IssuerId>IRELAND (GOVERNMENT)</IssuerId>
  <IssuerId>ITALY, REPUBLIC OF (GOVERNMENT)</IssuerId>
  <IssuerId>KOREA, REPUBLIC OF (GOVERNMENT)</IssuerId>
</BondData>

<!-- 회사채 예시 -->
<BondData>
  <IssuerId>DELIVERY HERO SE</IssuerId>
  <IssuerId>SAMSUNG ELECTRONICS</IssuerId>
  <IssuerId>HYUNDAI MOTOR</IssuerId>
</BondData>
```

### 4.3 ReferenceData.xml 예시

| ISIN | IssuerId | 유형 |
|------|----------|------|
| ISIN:IE00BH3SQ895 | IRELAND (GOVERNMENT) | **국채** |
| ISIN:IT0005177909 | ITALY, REPUBLIC OF (GOVERNMENT) | **국채** |
| ISIN:DE000A3H2WP2 | DELIVERY HERO SE | **회사채** |
| ISIN:US531229AR32 | SIRIUS XM HOLDINGS INC | **회사채** |

### 4.4 CreditCurveId로도 구분 가능

```xml
<!-- 국채: 일반적으로 낮은 신용스프레드 -->
<CreditCurveId>KGB_10Y</CreditCurveId>  <!-- 한국국채 10년 -->

<!-- 회사채: 회사별 신용등급에 따른 스프레드 -->
<CreditCurveId>SAMSUNG_AA_CRV</CreditCurveId>  <!-- 삼성전자 AA등급 -->
```

### 4.5 Bond XML 구조에서의 위치

```xml
<Trade id="Bond_1">
  <TradeType>Bond</TradeType>
  <Envelope>
    <CounterParty>CPTY_A</CounterParty>  <!-- XVA 용도 -->
  </Envelope>
  <BondData>
    <IssuerId>HYUNDAI MOTOR</IssuerId>  <!-- 발행자 (회사채) -->
    <CreditCurveId>HYUNDAI_CRV</CreditCurveId>
    <SecurityId>KIS:12345</SecurityId>
  </BondData>
</Trade>
```

---

## 5. BondYieldShifted 곡선 구축

### 5.1 개념

**BondYieldShifted** 세그먼트 타입을 사용하여 기존 할인율 곡선을 채권 시장 수익률만큼 시프트하여 신용 스프레드 곡선을 구축합니다.

### 5.2 동작 원리

```
┌─────────────────────────────────────────────────────────────┐
│  1. 기준 곡선 (예: USD1D 단기 할인율)                         │
└─────────────────────────────────────────────────────────────┘
                            │
                            ▼
┌─────────────────────────────────────────────────────────────┐
│  2. 채권 시장 가격 수집 (BOND/PRICE/*)                        │
│     - 각 채권의 듀레이션 계산                                  │
│     - 각 채권의 수익률(YTM) 계산                               │
└─────────────────────────────────────────────────────────────┘
                            │
                            ▼
┌─────────────────────────────────────────────────────────────┐
│  3. 수익률 차이만큼 기준 곡선 시프트                           │
│     Shifted Rate = Base Rate + Bond Spread                   │
└─────────────────────────────────────────────────────────────┘
                            │
                            ▼
┌─────────────────────────────────────────────────────────────┐
│  4. 보간으로 연속 곡선 생성 (30Y 만기 커버)                    │
└─────────────────────────────────────────────────────────────┘
```

### 5.3 설정 파일 구성

| 파일 | 설명 |
|------|------|
| `ore_bondyieldshifted.xml` | 메인 ORE 설정 |
| `curveconfig_bondyieldshifted.xml` | BondYieldShifted 세그먼트 정의 |
| `todaysmarket_bondyieldshifted.xml` | 시장 데이터 매핑 |
| `market_bondyieldshifted.csv` | 채권 가격 데이터 |
| `portfolio_bondyieldshifted.xml` | 제로 쿠폰 채권 포트폴리오 |
| `conventions_bondyieldshifted.xml` | 채권 컨벤션 |

### 5.4 사용 목적

- **신용 스프레드 곡선** 구축 (회사채 가격 반영)
- 채권 시장 데이터를 기반으로 한 **위험중립 할인율 곡선** 생성
- 국채 금리 + 신용스프레드 = 회사채 할인율 곡선

### 5.5 실무 적용 예시

```xml
<!-- 예: 삼성전자 회사채 곡선 구축 -->
1. 기준: KGB_10Y (한국국채 10년)
2. 삼성전자 채권 가격: BOND/PRICE/SAMSUNG_2Y, 3Y, 5Y...
3. 수익률 시프트: KGB + 삼성전자 스프레드
4. 결과: 삼성전자 신용 곡선 (2Y~30Y)
```

---

## 6. Bond 실행 방법

### 6.1 Products 예제 실행

```bash
cd Examples/Products
python run.py
```

### 6.2 CurveBuilding 예제 실행

```bash
cd Examples/CurveBuilding
# ore_bondyieldshifted.xml 설정으로 ORE 실행
ore Input/ore_bondyieldshifted.xml
```

### 6.3 출력 파일

| 파일 | 설명 |
|------|------|
| `npv.csv` | 채권별 Net Present Value |
| `flows.csv` | 캐시플로우 상세 (활성화 시) |
| `curves.csv` | 구축된 곡선 데이터 |
| `log.txt` | 실행 로그 |

---

## 7. 참고 코드 위치

### Bond 관련 소스 코드

| 파일 | 설명 |
|------|------|
| `OREData/ored/portfolio/bond.hpp` | Bond 데이터 모델 |
| `OREData/ored/portfolio/bond.cpp` | Bond XML 파싱 |
| `OREData/ored/portfolio/builders/bond.hpp` | Bond Pricing Engine Builder |
| `OREData/ored/portfolio/builders/bond.cpp` | Bond Pricing Engine 구현 |
| `OREData/ored/utilities/bondindexbuilder.hpp` | Bond Index Builder |

### QuantLib Bond 관련

| 파일 | 설명 |
|------|------|
| `QuantLib/ql/pricingengines/bond/discountingbondengine.hpp` | 할인 채권 엔진 |
| `QuantLib/ql/termstructures/yield/zerospreadedtermstructure.hpp` | Z-Spread 적용 |
| `QuantLib/ql/instruments/bond.hpp` | Bond 클래스 |

---

## 8. 요약

| 항목 | 핵심 내용 |
|------|----------|
| **Bond 예제 위치** | `Examples/Products/Example_Trades/Cash_Bonds.xml` |
| **Z-Spread 적용** | `ZeroSpreadedTermStructure`로 할인율에 상수 스프레드 추가 |
| **Z-Spread 입력** | Market 데이터의 `BOND/YIELD_SPREAD/SECURITY_ID` |
| **국채/회사채 구분** | `IssuerId` (발행자 ID)로 구분, CounterParty 아님 |
| **BondYieldShifted** | 채권 수익률만큼 기준 곡선 시프트하여 신용 곡선 구축 |
| **실행 방법** | `cd Examples/Products && python run.py` |

---

*문서 작성일: 2026-06-01*
*ORE 버전: ORE (Open Source Risk Engine)*
