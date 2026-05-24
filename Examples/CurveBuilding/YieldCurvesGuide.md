# ORE 수익률 커브 가이드 (Yield Curves Guide)

## 개요

ORE(Open Source Risk Engine)에서 파생상품 가치 평가를 위해 할인 커브(Discount Curve)와 포워드 커브(Forward Curve)를 구축하는 방법을 설명합니다.

## 커브의 종류

### 1. 할인 커브 (Discount Curve)

현금흐름을 현재가치(Present Value)로 할인하기 위해 사용합니다.

**구성 상품:**
- **OIS** (Overnight Index Swap)
- **Deposit** (초기 구간)

**예시 커브 ID:** `EUR1D`, `USD1D`, `GBP1D`

**특징:**
- 무위험 금리(Risk-free Rate)에 가깝습니다
- 단기부트스트래핑을 위해 Deposit(1일)을 사용합니다
- EONIA, Fed Funds, SONIA 등 오버나이트 인덱스 사용

### 2. 포워드 커브 (Forward Curve / Projection Curve)

미래 이자율(Floating Rate)을 예측하기 위해 사용합니다.

**구성 상품:**
- **MM** (Money Market / Deposit) - 1주 ~ 3개월
- **FRA** (Forward Rate Agreement) - 1개월 ~ 1년
- **IR_SWAP** (Interest Rate Swap) - 2년 이상
- **BASIS_SWAP** (Tenor Basis Swap) - 서로 다른 만기 간 베이시스

**예시 커브 ID:** `EUR3M`, `USD3M`, `GBP3M`, `GBP6M`

**특징:**
- 각 통화의 인덱스 만기(3M, 6M 등)에 맞춰 구축
- LIBOR, EURIBOR 등 인덱스 금리를 프로젝션

### 3. 크로스 커런시 커브 (Cross Currency Curve)

다른 통화로 담보된 경우의 할인 커브입니다.

**구성 상품:**
- **FX Forward** (단기)
- **Cross Currency Basis Swap** (중장기)

**예시 커브 ID:** `EUR-IN-USD`, `GBP-IN-USD`

**필요 구성 요소:**
- 기준 통화 할인 커브 (예: `USD1D`)
- 각 통화의 포워드 커브 (예: `EUR3M`, `USD3M`)
- Spot FX 환율

## FX Forward 가치 평가

### 공식

```
F = S × (DF_domestic / DF_foreign)
```

### 사용되는 커브

| 커브 | 용도 |
|------|------|
| EUR1D (할인) | EUR 현금흐름 할인 |
| USD1D (할인) | USD 현금흐름 할인 |
| EUR3M (포워드) | EUR 이자율 프로젝션 |
| USD3M (포워드) | USD 이자율 프로젝션 |
| EUR-IN-USD (크로스) | USD 담보 EUR 할인 |

## Curve Configuration 구조

```xml
<YieldCurve>
  <CurveId>EUR3M</CurveId>
  <Currency>EUR</Currency>
  <DiscountCurve>EUR1D</DiscountCurve>  <!-- 할인 커브 지정 -->
  <Segments>
    <Simple>
      <Type>Deposit</Type>
      <Quotes>...</Quotes>
      <ProjectionCurve>EUR3M</ProjectionCurve>
    </Simple>
    <Simple>
      <Type>FRA</Type>
      <Quotes>...</Quotes>
      <ProjectionCurve>EUR3M</ProjectionCurve>
    </Simple>
    <Simple>
      <Type>Swap</Type>
      <Quotes>...</Quotes>
      <ProjectionCurve>EUR3M</ProjectionCurve>
    </Simple>
  </Segments>
</YieldCurve>
```

## 부트스트래핑 (Bootstrapping)

부트스트래핑은 시장 데이터(Instrument Prices)로부터 제로 커브(Zero Curve)를 계산하는 과정입니다.

**과정:**
1. 단기 상품(Deposit)으로 초기 구간 계산
2. FRA로 중기 포워드 레이트 계산
3. Swap으로 장기 제로 레이트 계산
4. 각 구간을 이어붙여 전체 커브 생성

**보간 방법:**
- `InterpolationVariable`: Discount, ZeroYield, Forward
- `InterpolationMethod`: Linear, LogLinear, Cubic

## 할인 비율 커브 (Discount Ratio Curve)

서로 다른 담보 통화 간의 할인 비율을 계산합니다.

```xml
<YieldCurve>
  <CurveId>GBP-IN-EUR</CurveId>
  <Segments>
    <DiscountRatio>
      <Type>Discount Ratio</Type>
      <BaseCurve currency="EUR">EUR1D</BaseCurve>
      <NumeratorCurve currency="GBP">GBP-IN-USD</NumeratorCurve>
      <DenominatorCurve currency="EUR">EUR-IN-USD</DenominatorCurve>
    </DiscountRatio>
  </Segments>
</YieldCurve>
```

**공식:**
```
DF_GBP-in-EUR = DF_GBP-in-USD / DF_EUR-in-USD
```

## 추가 고려사항

### 1. 커브 일관성 (Curve Consistency)

- 모든 커브는 동일한 Valuation Date를 기준으로 구축
- 커브 간의 Arbitrage-free 조건 확인 필요
- BootstrapConsistency 예제로 검증 가능

### 2. 베이시스 스프레드 (Basis Spread)

- Tenor Basis: 3M vs 6M 인덱스 간 스프레드
- Cross Currency Basis: 서로 다른 통화 간 스프레드
- 이는 유동성, 신용 리스크 반영

### 3. 컨벤션 (Conventions)

- Day Counter: A365, A360, Act/Act
- Business Day Convention: Following, Modified Following
- Roll Convention: EOM (End of Month), IMMD (Imm date)

### 4. 멀티-커런시 포트폴리오

- 각 통화마다 독립적인 할인/포워드 커브 필요
- FX Spot, Forward 데이터 필수
- Cross Currency Basis Swap 데이터 필요

## 실행 예시

```bash
# CurveBuilding 예제 실행
cd /home/keehyun/dev/Engine/Examples/CurveBuilding
python3 run_discountratio.py

# 결과 확인
cat Output/prime/log_structured.json
```

## 참고 파일

- `curveconfig_discountratio.xml` - 커브 설정 예시
- `ore_discountratio_usd.xml` - ORE 설정 파일
- `market_20160205.txt` - 시장 데이터

## 추가 학습 자료

- ORE Documentation: https://opensourcerisk.org/docs/
- QuantLib Curve Bootstrapping: https://www.quantlib.org/
- FX Forward Valuation: `Examples/Products/FxForward`
