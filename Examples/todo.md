# ORE 예제 출력 파일 생성 TODO

## 개요
CurveBuilding 예제와 같이 각 예제 디렉토리에 Output 폴더와 한국어 설명서를 생성합니다.

---

## ✅ 완료된 작업

### CurveBuilding (완료 ✓)
- [x] prime - Prime 금리 예제
- [x] sabr - SABR 변동성 모델
- [x] centralbank_0~4 - 중앙은행 예제 (5개)
- [x] consistency_ois - OIS 일관성 검증
- [x] consistency_xoiseur - EUR OIS 일관성
- [x] consistency_xoisusd - USD OIS 일관성
- [x] bondyieldshifted - 채권 수익률 시프트
- [x] discountratio_eur/usd - 할인율 비율 (2개)
- [x] fixedfloatccs - 고정-변동 통화 스왑

---

## 🔄 작업 중

---

## ⏳ 대기 중 (비즈니스 예제만)

### 1. MarketRisk (22개 완료 ✓)
**목적**: 시장 리스크 분석 (VaR, 민감도, 스트레스 테스트)

**예제 목록**:
- [x] Sensitivity - 민감도 분석 (Delta, Gamma, Vega 등)
- [x] SensiSmile - 변동성 스마일 분석 (ATM, Surface)
- [x] ParametricVar - 파라메트릭 VaR (분포 기반 리스크)
- [x] HistSimVar - 역사적 시뮬레이션 VaR
- [x] Stress - 스트레스 테스트 (시나리오 분석)
- [x] ParStress - Par 곡선 스트레스 테스트 (Cap, CDS, ESTR, EUR6M, XCCY, Conversion)
- [x] BaseScenario - 기본 시나리오
- [x] ScenarioStress - 시나리오 기반 스트레스
- [x] SensiStress - 민감도 스트레스
- [x] SMRC - Standard Margin Risk Calculation
- [x] PnlExplain - PnL 속성 분석
- [x] PnlExplainPar - PnL 속성 (Par)
- [x] Pnl - PnL 계산
- [x] ParConversion - Zero-Par 변환
- [x] ZeroToParShift - Zero 곡선에서 Par 곡선으로
- [x] SensiIndexDecomp - 민감도 인덱스 분해
- [x] StressScenarioGeneration - 스트레스 시나리오 생성
- [x] Correlation - 상관관계 분석
- [x] CurveAlgebra - 곡선 대수 연산

**개별 상품 예제**:
- [ ] CallableBond - 콜러블 본드 (조기 상환 가능 채권)
- [ ] CapFloor - 금리 캡/플로어
- [ ] CCS - 통화간 스왑 (Cross Currency Swap)
- [ ] CMSSpread - CMS 스프레드 스왑
- [ ] Commodity - 상품 파생상품
- [ ] Credit - 크레딧 파생상품
- [ ] Equity - 주식 파생상품
- [ ] FBC - Fixed Bond Cashflow
- [ ] FRA - 선도금리계약 (Forward Rate Agreement)
- [ ] Fx - 외환 파생상품
- [ ] HW2F - Hull-White 2요인 모델
- [ ] LongTerm - 장기 리스크 분석

---

### 2. XvaRisk (5개 완료 ✓)
**목적**: XVA (Valuation Adjustment) 계산

**예제 목록**:
- [x] bacva - BA-CVA (Book Value Adjustment for CVA)
- [x] sacva - SA-CVA (Standardized Approach CVA)
- [x] xva_explain - XVA 속성 설명
- [x] xva_sensi - XVA 민감도 (Classic)
- [x] xva_stress - XVA 스트레스 테스트 (Classic)

---

### 3. Exposure (4개 완료 ✓)
**목적**: 담보 없는 노출 리스크 계산

**예제 목록**:
- [x] swap - 스왑 노출 분석
- [x] fx - FX 파생상품 노출
- [x] equity - 주식 파생상품 노출
- [x] credit - 크레딧 파생상품 노출
- [x] commodity - 상품 파생상품 노출
- [ ] sensi - 노출 민감도
- [ ] stress - 노출 스트레스 테스트
- [ ] xva_explain - XVA 설명
- [ ] ccs - CCS 노출
- [ ] flipview - Flip View 노출
- [ ] fx_swap - 외환 스왑 노출
- [ ] hw2f - HW2F 모델 노출
- [ ] longterm - 장기 노출

---

### 4. ExposureWithCollateral
**목적**: 담보가 있는 노출 리스크 계산 (CSA, 마진, 네팅)

**예제 목록**:
- [ ] CSA - Credit Support Annex 예제
- [ ] Margin - 마진 호출 계산
- [ ] Netting - 네팅 집합 계산

---

### 5. CreditRisk
**목적**: 신용 리스크 및 카운터파티 리스크

**예제 목록**:
- [ ] cpm - Counterparty Risk Method
- [ ] saccr - SA-CCR (Standardized Approach for Counterparty Credit Risk)

---

### 6. InitialMargin
**목적**: 초기 마진 계산 (SIMM, DIM)

**예제 목록**:
- [ ] simm - SIMM (Standard Initial Margin Model)
- [ ] simm_cube - SIMM 큐브 분석
- [ ] dim - DIM (Daily Initial Margin)
- [ ] dim2 - DIM v2
- [ ] dim2_cube - DIM 큐브 분석
- [ ] benchmarks - 벤치마크 테스트

---

### 7. Products (150+ 상품 예제)
**목적**: 다양한 금융 상품 가치 평가

**주요 카테고리**:

#### Bond Options (본드 옵션)
- [ ] StrikePrice, StrikeYield

#### Cash (현금 상품)
- [ ] Ascot
- [ ] BondRepo
- [ ] Bonds
- [ ] ConvertibleBond (전환사채)

#### Commodity (상품)
- [ ] APO (Asian Peak Option)
- [ ] Basis Swap
- [ ] Forward
- [ ] Option
- [ ] Swap (LME, NYMEX)
- [ ] Swaption
- [ ] Variance Swap

#### Credit (크레딧)
- [ ] Bond Forward
- [ ] Bond Option
- [ ] Bond TRS (Total Return Swap)
- [ ] Callable Bond
- [ ] CLS (Credit Linked Swap)
- [ ] CDS (Credit Default Swap)
- [ ] Index CDS
- [ ] Index CDS Option
- [ ] RPA (Risk Participation Agreement)
- [ ] Synthetic CDO

#### Equity (주식)
- [ ] Asian Option
- [ ] Barrier Option
- [ ] Binary Option
- [ ] Compo Option
- [ ] Composite Option
- [ ] Delta Hedged
- [ ] European Option
- [ ] Forward
- [ ] FXA
- [ ] WorstOf Rainbow

#### FX (외환)
- [ ] Asian Option
- [ ] Barrier Option
- [ ] Binary Option
- [ ] Digital Option
- [ ] European Option
- [ ] Forward
- [ ] KIKO Barrier
- [ ] Lookback Option
- [ ] RangeAccrual
- [ ] Strike Discount
- [ ] Swap
- [ ] Touch Option
- [ ] Window Barrier

#### Inflation (인플레이션)
- [ ] Bond
- [ ] CapFloor
- [ ] CPI Swap
- [ ] Inflation Futures
- [ ] Swap
- [ ] YoY CapFloor
- [ ] YoY Swap

#### Other (기타)
- [ ] CapFloor
- [ ] CMS (Constant Maturity Swap)
- [ ] Combo
- [ ] FRA (Forward Rate Agreement)
- [ ] Make Delivery
- [ ] Performance Option
- [ ] Scenario
- [ ] Swap (다양한 유형)
- [ ] Swaption
- [ ] TRS (Total Return Swap)

---

### 8. AmericanMonteCarlo
**목적**: 아메리칸 옵션 몬테카를로 시뮬레이션

**예제 목록**:
- [ ] Regression 기반 시뮬레이션
- [ ] Longstaff-Schwartz 알고리즘
- [ ] 조기 행사 옵션 평가

---

### 9. ScriptedTrade
**목적**: 사용자 정의 페이오프 스크립팅

**예제 목록**:
- [ ] Custom Payoff 정의
- [ ] Scripted Valuation

---

## 제외된 기술적 예제
- ~~MinimalSetup~~
- ~~ORE-Python~~
- ~~ORE-API / ORE-REST-API~~
- ~~Performance~~
- ~~TradeGenerator~~
- ~~Academy~~
- ~~Legacy~~

---

## 작업 방법

### 단계 1: 예제 실행
```bash
cd /home/keehyun/dev/Engine/Examples/[카테고리]/
ore Input/[예제].xml
```

### 단계 2: Output 폴더 생성
```bash
mkdir -p Output/[예제명]/
# 결과 파일 이동
```

### 단계 3: 한국어 설명서 작성
```bash
# Output/[예제명]/README_korean.md
```

---

## 우선순위

| 우선순위 | 카테고리 | 이유 |
|---------|---------|------|
| 1 | Products | 가장 기본적이고 많은 상품 커버리지 |
| 2 | MarketRisk | 리스크 관리 핵심 |
| 3 | XvaRisk | XVA는 현대 파생상품 필수 |
| 4 | Exposure | 노출 리스크 계산 |
| 5 | ExposureWithCollateral | 담보 리스크 |
| 6 | CreditRisk | 신용 리스크 |
| 7 | InitialMargin | 마진 계산 |
| 8 | AmericanMonteCarlo | 특수 옵션 |
| 9 | ScriptedTrade | 사용자 정의 |

---

## 예상 작업량

| 카테고리 | 예제 수 | 예상 시간 |
|---------|--------|---------|
| Products | 150+ | 가장 큼 |
| MarketRisk | ~30 | 중간 |
| XvaRisk | ~15 | 중간 |
| Exposure | ~50 | 큼 |
| ExposureWithCollateral | ~10 | 작음 |
| CreditRisk | ~5 | 작음 |
| InitialMargin | ~10 | 작음 |
| AmericanMonteCarlo | ~5 | 작음 |
| ScriptedTrade | ~10 | 작음 |
| **합계** | **~285** | **대형 프로젝트** |
