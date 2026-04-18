# 기본 시나리오 (Base Scenario) 출력 설명

## 예제 개요

이 예제는 ORE의 기본 시나리오(Base Scenario)를 생성하고 시장 데이터를 보정(Calibration)합니다. 모든 분석의 기준이 되는 시나리오입니다.

---

## 핵심 금융 용어

### Base Scenario (기본 시나리오)
- **정의**: 분석의 기준점이 되는 시나리오 (현재 시장 데이터)
- **용도**: 다른 시나리오(스트레스, 리스크 등)와 비교의 기준
- **구성**: 현재 시장의 금리 곡선, 변동성, 환율 등

### Calibration (보정)
- **정의**: 모델 파라미터를 시장 데이터에 맞추어 조정
- **목적**: 모델이 시장 가격을 정확히 재현하도록 함
- **예시**: SABR 모델의 파라미터를 시장 변동성 스마일에 맞춤

### Today's Market (오늘 시장)
- **구성 요소**:
  - 금리 곡선 (Discount Curve, Forward Curve)
  - 변동성 곡선 (Volatility Surface)
  - 환율 (FX Rates)
  - 크레딧 스프레드 (Credit Spreads)

---

## 출력 파일 상세 설명

### 1. scenario.csv
**용도**: 기본 시나리오 데이터

| 컬럼 | 설명 |
|------|------|
| Scenario | 시나리오 이름 (Base) |
| Date | 날짜 |
| Factor | 리스크 요인 |
| Value | 값 |

---

### 2. todaysmarketcalibration.csv
**용도**: 오늘 시장 보정 결과

| 컬럼 | 설명 |
|------|------|
| Curve | 곡선 이름 |
| Tenor | 만기 |
| Rate | 금리/할인율 |
| MarketValue | 시장 값 |
| ModelValue | 모델 값 |
| Error | 보정 오차 |

**해석 예시**:
```
Curve: EUR_Discount
Tenor: 10Y
Rate: 3.50%
MarketValue: 0.704
ModelValue: 0.703
Error: 0.001 (매우 작음 - 보정 성공)
```

---

### 3. todaysmarketcalibration_cashflows.csv
**용도**: 보정에 사용된 현금흐름

---

### 4. marketdata.csv
**용도**: 사용된 시장 데이터 요약

---

## 보정 성공 기준

### 1. 오차 크기
- **Acceptable**: 0.01bp 이하
- **Good**: 0.001bp 이하
- **Excellent**: 0.0001bp 이하

### 2. 현금흐름 재현
- 모든 벤치마크 상품의 NPV ≈ 0
- 시장 가격과 모델 가격의 차이가 작아야 함

---

## 실무 활용

### 1. 기준 설정
- 모든 리스크 분석의 기준점
- "Base vs Stress" 비교

### 2. 모델 검증
- 보정 오차가 크면 모델 수정 필요
- 시장 데이터 품질 확인

### 3. 일일 작업
- 매일 아침 Base Scenario 업데이트
- 전날 장 종가 데이터 사용

---

## 시나리오 비교 예시

| 항목 | Base Scenario | Stress Scenario (+100bp) |
|------|---------------|--------------------------|
| 10Y Swap Rate | 3.50% | 4.50% |
| Portfolio NPV | 1,000,000 | -500,000 |
| PnL | - | -1,500,000 |

---

## 실행 방법

```bash
cd /home/keehyun/dev/Engine/Examples/MarketRisk
ore Input/ore_basescenario.xml
```

---

## 출력 파일 위치

```
Output/BaseScenario/
├── scenario.csv                        # 기본 시나리오 데이터
├── todaysmarketcalibration.csv         # 시장 보정 결과
├── todaysmarketcalibration_cashflows.csv  # 보정 현금흐름
├── marketdata.csv                      # 시장 데이터
└── log.txt                             # 실행 로그
```

---

## 일반적인 작업 순서

```
1. Base Scenario 생성 ← 현재 시장
2. Stress Scenario 생성 ← Base + 시프트
3. Scenario Analysis ← Base vs Stress 비교
4. Sensitivity Analysis ← Base 기준 민감도
5. VaR Calculation ← Base 변동성 기반
```

---

## 참고 자료

- **ORE User Guide**: 시나리오 생성 및 보정 장
- **Brigo, Damiano**: "Interest Rate Models" - 보정 기법
