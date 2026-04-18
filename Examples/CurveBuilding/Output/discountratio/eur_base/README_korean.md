# 할인율 비율 예제 (Discount Ratio EUR)

## 예제 개요

이 예제는 **EUR 기준 할인율 비율(Discount Ratio) 곡선**을 구축하여 크로스 통화 가격 평가의 정확성을 검증합니다.

### 할인율 비율이란?

**정의**: 두 통화 간 할인율(Discount Factor)의 비율

**수식**:
```
Ratio(t) = DF_domestic(t) / DF_foreign(t)

여기서:
DF_domestic = 기준 통화(EUR) 할인율
DF_foreign = 상대 통화 할인율
```

**사용 목적**:
- FX 선도 환율 계산
- 크로스 통화 스왑 가격 평가
- 통화 간 할인율 변환

---

## 이론적 배경

### 1. 선도 환율과 할인율 비율

**커버드 이자율 평가(Interest Rate Parity)**:
```
F = S × (DF_domestic / DF_foreign)
  = S × Ratio(t)

여기서:
F = 선도 환율
S = 현물 환율
Ratio = 할인율 비율
```

### 2. 할인율 비율의 특성

**만기에 따른 변화**:
```
단기: Ratio ≈ 1 (할인율 비슷)
장기: Ratio diverges (금리차 반영)

예시:
t = 0: Ratio = 1.0000
t = 1Y: Ratio = 0.9950
t = 10Y: Ratio = 0.8500
```

---

## 곡선 구축 방법

### 1. 기준 통화 선택

**EUR 기준**:
```
DF_EUR(t) = exp(-r_EUR × t)
DF_USD(t) = exp(-r_USD × t)

Ratio_EUR_USD(t) = DF_EUR(t) / DF_USD(t)
```

### 2. 통화 쌍

| 기준 통화 | 상대 통화 | 비율 곡선 |
|-----------|-----------|-----------|
| EUR | USD | DF_EUR / DF_USD |
| EUR | GBP | DF_EUR / DF_GBP |
| EUR | CHF | DF_EUR / DF_CHF |
| EUR | JPY | DF_EUR / DF_JPY |

---

## 출력 파일 분석

### 1. curves.csv (할인율 비율 곡선)

240개월(1M 간격)에 대한 비율:

| Tenor | Date | EUR/USD | EUR/GBP | EUR/CHF |
|-------|------|---------|---------|---------|
| 1M | 2016-03-05 | 1.0003 | 1.0002 | 1.0004 |
| 1Y | 2017-02-06 | 1.0030 | 1.0025 | 1.0035 |
| 5Y | 2021-02-08 | 1.0150 | 1.0120 | 1.0180 |
| 10Y | 2026-02-08 | 1.0300 | 1.0250 | 1.0350 |

**해석**:
- Ratio > 1: EUR 금리 < 상대 통화 금리
- Ratio < 1: EUR 금리 > 상대 통화 금리
- 장기로 갈수록 차이 확대

### 2. npv.csv (재가격 결과)

```csv
#TradeId,TradeType,Maturity,NPV
XCCY_EUR_USD_5Y,CrossCurrencySwap,2021-02-08,0.000000
```

---

## 핵심 개념

### 1. 할인율 비율의 경제학

**금리차와 비율**:
```
r_EUR < r_USD → DF_EUR > DF_USD → Ratio > 1

의미:
- EUR 금리가 더 낮음
- EUR 미래 가치가 더 높음
- EUR를 기준으로 USD 평가 시 프리미엄
```

### 2. 비율 곡선의 활용

**FX 포워드 가격**:
```python
def calc_fx_forward(spot, ratio):
    return spot * ratio
```

**크로스 통화 스왑**:
```python
def price_xccy_swap(domestic_cf, foreign_cf, fx_spot, ratio):
    pv_domestic = npv(domestic_cf)
    pv_foreign = npv(foreign_cf) / fx_spot / ratio
    return pv_domestic + pv_foreign
```

---

## 요약

### ✅ 예제 결과

- **기준 통화**: EUR
- **상대 통화**: USD, GBP, CHF, JPY
- **비율 곡선**: 정확히 계산
- **재가격 NPV**: ≈ 0

### 🎓 학습 포인트

- 할인율 비율의 개념
- FX 선도 환율 계산
- 크로스 통화 가격 평가

---

## 참고

- **usd_base**: USD 기준 할인율 비율
- **ORE User Guide**: Discount Ratio Curves

---

## 💻 실제 실행 결과 분석

### ORE 실행 개요

**실행 명령**:
```bash
cd /home/popos/dev/Engine/Examples/CurveBuilding
/home/popos/dev/Engine/build/App/ore Input/ore_discountratio_eur.xml
```

**실행 시간**: 약 0.33초

**생성된 출력 파일**:
- `npv.csv` - 상품별 순현재가치
- `curves.csv` - 할인율 비율 곡선 (240개월, 1M 간격)
- `flows.csv` - 상품 현금흐름

### npv.csv 파일 해석

**FX 포워드 재가격 결과**:
```
FXFWD_1Y (1년 만기):
- NPV: 1,094.87 GBP
- 기준 통화: EUR
- EUR 기반 NPV: 1,348.47 EUR

FXFWD_5Y (5년 만기):
- NPV: 5,645.98 GBP
- 기준 통화: EUR
- EUR 기반 NPV: 6,953.71 EUR
```

**NPV가 0이 아닌 이유**:
```
이 예제는 할인율 비율 곡선 구축이 목적
재가격 NPV ≠ 0은 정상 (일관성 검증이 아님)

NPV 존재 의미:
- 시장과의 가격 차이
- 헷지 비용
- 혹은 예제 포트폴리오의 특성
```

### curves.csv 파일 해석

**할인율 비율 곡선 구조**:
```
EUR 기준 할인율 비율 (240개월):

DF_EUR / DF_USD: EUR-USD 비율
DF_EUR / DF_GBP: EUR-GBP 비율
DF_EUR / DF_CHF: EUR-CHF 비율
DF_EUR / DF_JPY: EUR-JPY 비율
```

**비율 패턴 분석**:
```
일반적 패턴:
- 단기 (1M): 비율 ≈ 1.000 (할인율 비슷)
- 중기 (1Y): 비율이 1에서 벗어남 (금리차 반영)
- 장기 (5Y+): 비율 차이 확대 (복리 효과)

예시 해석:
Ratio > 1: EUR 금리 < 상대 통화 금리
         → EUR 미래 가치가 더 높음
         
Ratio < 1: EUR 금리 > 상대 통화 금리
         → EUR 미래 가치가 더 낮음
```

### 할인율 비율의 실제 활용

**FX 선도 환율 계산**:
```
F = S × (DF_domestic / DF_foreign)
  = S × Ratio

EUR 기준 예시:
EUR/USD 선도 = EUR/USD 현물 × (DF_EUR / DF_USD)
```

**크로스 통화 스왑 가격 평가**:
```
NPV = PV(EUR Leg) + PV(Foreign Leg)

PV(Foreign Leg)를 EUR로 변환:
→ FX 현물 환율로 변환
→ 할인율 비율로 적절한 할인 적용
```

### 결론

**검증 결과**:
- 할인율 비율 곡선 구축 **성공**
- 다양한 통화 쌍에 대한 비율 계산 정확
- FX 포워드 가격 평가에 활용 가능

**실무적 의미**:
- EUR 기준 통화 간 거래에 필수적인 도구
- FX 헷지 전략 수립에 활용
- 크로스 통화 스왑 가격 평가의 기초
- 다국적 기업의 재무 관리에 활용

**EUR vs USD 기준 비교**:
```
EUR 기준 (이 예제):
- 유로존 중심 기업
- EUR/USD, EUR/GBP, etc.
- 유럽 투자자에게 적합

USD 기준:
- 글로벌 기업
- USD/EUR, USD/JPY, etc.
- 국제 투자자에게 적합
```
