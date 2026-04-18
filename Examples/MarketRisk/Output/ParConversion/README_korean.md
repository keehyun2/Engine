# Par-제로 변환 (Par Rate to Zero Rate Conversion) 출력 설명

## 예제 개요

이 예제는 Par Rate와 Zero Rate 간의 변환을 수행합니다. 시장에서 관측된 Par Rate를 Zero Curve로 변환하거나 그 반대를 수행합니다.

---

## 핵심 금융 용어

### Par Rate (Par 금리)
- **정의**: 특정 만기의 스왑이 NPV=0이 되도록 하는 고정 금리
- **특징**: 시장에서 직접 관측 가능 (Swap Rate)
- **용도**: 시장 금리 수준의 대표 지표

### Zero Rate (제로 금리)
- **정의**: 특정 만기까지 단 한 번의 현금흐름이 있는 채권의 수익률
- **특징**: 부트스트래핑(Bootstrapping)으로 계산
- **용도**: 모든 금융상품의 가치평가 기초

### Bootstrapping (부트스트래핑)
- **정의**: 단기 Par Rate부터 시작하여 장기 Zero Curve를 순차적으로 계산하는 방법
- **과정**: 1Y Par → 1Y Zero → 2Y Par → 2Y Zero → ...

### Jacobian Matrix (야코비안 행렬)
- **정의**: Par Rate와 Zero Rate 간 민감도 관계를 나타내는 행렬
- **용도**: 금리 변동성 변환, 리스크 계산

---

## 출력 파일 상세 설명

### 1. parConversion_sensitivity.csv
**용도**: Par-제로 변환 민감도

| 컬럼 | 설명 |
|------|------|
| Tenor | 만기 |
| Par Rate | Par 금리 |
| Zero Rate | 제로 금리 |
| Delta (∂Zero/∂Par) | Par가 1bp 변할 때 Zero 변화 |
| Gamma (∂²Zero/∂Par²) | 2차 민감도 |

**해석 예시**:
```
Tenor: 10Y
Par Rate: 3.50%
Zero Rate: 3.45%
Delta: 0.95
```
- 10년 만기 Par 금리가 1bp 상승하면 제로 금리는 약 0.95bp 상승

---

### 2. parConversionScenarioParRates.csv
**용도**: 시나리오별 Par 금리

---

### 3. jacobi.csv
**용도**: Par-제로 변환 야코비안 행렬

| 행/열 | 1Y | 2Y | 5Y | 10Y |
|-------|----|----|----|-----|
| 1Y Par | 1.00 | 0.00 | 0.00 | 0.00 |
| 2Y Par | 0.50 | 0.95 | 0.00 | 0.00 |
| 5Y Par | 0.30 | 0.40 | 0.85 | 0.00 |
| 10Y Par | 0.20 | 0.25 | 0.35 | 0.80 |

**해석**: 10Y Par가 1bp 변하면 5Y Zero는 0.35bp, 10Y Zero는 0.80bp 변화

---

### 4. jacobi_inverse.csv
**용도**: 야코비안 역행렬 (제로 → Par 변환)

---

### 5. todaysmarketcalibration.csv
**용도**: 오늘 날짜의 시장 보정 결과

---

## Par Rate ↔ Zero Rate 변환

### Par에서 Zero로
```
Zero Rate = Par Rate - 약간의 할인

이유: Par는 스왑의 평균 수익률, Zero는 순간 수익률
```

### Zero에서 Par로
```
Par Rate = (Zero의 가중평균)

이유: Par는 여러 현금흐름의 평균 수익률
```

---

## 실무 활용

### 1. 시장 데이터 보정
- 시장에서 Par Rate 관측 → Zero Curve 계산
- Zero Curve 기반 모든 상품 가치평가

### 2. 금리 리스크 변환
- Par Delta → Zero Delta
- "Par이 1bp 변하면 Portfolio NPV가 얼마나 변하는가?"

### 3. 헷징 비율 계산
- Par 기반 헷징 (Swap Futures)
- Zero 기반 헷징 (Zero Coupon Bonds)

---

## Par vs Zero: 언제 사용?

| 상황 | 사용 곡선 | 이유 |
|------|----------|------|
| 시장 데이터 보고 | Par Curve | 시장에서 직접 관측 |
| 일반적 가치평가 | Zero Curve | 모든 상품 평가에 적합 |
| 리스크 변동성 | Par | 시장 표준 |
| 복잡한 파생상품 | Zero | 정확한 할인 계산 |

---

## 부트스트래핑 예시

```
1Y Swap Rate = 2.50%  →  1Y Zero Rate = 2.50%
2Y Swap Rate = 2.80%  →  2Y Zero Rate = 2.78% (계산)
5Y Swap Rate = 3.20%  →  5Y Zero Rate = 3.15% (계산)
10Y Swap Rate = 3.50% →  10Y Zero Rate = 3.42% (계산)
```

---

## 실행 방법

```bash
cd /home/keehyun/dev/Engine/Examples/MarketRisk
ore Input/ore_parconversion.xml
```

---

## 출력 파일 위치

```
Output/ParConversion/
├── parConversion_sensitivity.csv       # Par-제로 민감도
├── parConversionScenarioParRates.csv  # Par 금리 시나리오
├── jacobi.csv                          # 야코비안 행렬
├── jacobi_inverse.csv                  # 야코비안 역행렬
└── todaysmarketcalibration.csv         # 시장 보정
```

---

## 참고 자료

- **ORE User Guide**: Par-제로 변환 장
- **Hull, John**: "Options, Futures, and Other Derivatives" - 금리 곡선 장
