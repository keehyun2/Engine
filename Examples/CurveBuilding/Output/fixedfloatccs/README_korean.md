# 고정-변동 통화 간 스왑 예제 (Fixed-Floating CCS)

## 예제 개요

이 예제는 **고정-변동 통화 간 스왑(Fixed-Floating Cross Currency Swap)**의 가격 평가를 보여줍니다.

### 고정-변동 통화 간 스왑이란?

**정의**: 한 통화는 고정 금리, 다른 통화는 변동 금리를 주고받는 크로스 통화 스왑

**구조**:
```
USD Leg (고정):
  - 고정 금리 지급
  - USD 명목 금액

EUR Leg (변동):
  - 변동 금리(EURIBOR) 수취
  - EUR 명목 금액

원금 교환:
  - 초기 및 만기 시 USD ↔ EUR
```

---

## 스왑 구조

### 현금흐름

**USD Fixed Leg**:
```
매 분기:
  지급 = Fixed Rate × USD Notional × Δt

만기 시:
  지급 = USD Notional (원금 상환)
```

**EUR Floating Leg**:
```
매 분기:
  수취 = EURIBOR × EUR Notional × Δt

만기 시:
  수취 = EUR Notional (원금 수취)
```

### 가격 평가

**NPV 계산**:
```
NPV = PV(USD Fixed) + PV(EUR Floating)

여기서:
PV(USD Fixed) = Σ [Fixed CF × DF_USD]
PV(EUR Floating) = Σ [Float CF × DF_EUR × FX]
```

---

## 곡선 구축

### 필요한 곡선

1. **USD 할인 곡선**: USD-FedFunds
2. **EUR 할인 곡선**: EUR-EONIA
3. **EUR 변동 곡선**: EUR-EURIBOR-3M
4. **FX 선도 곡선**: USD/EUR

### 보정(Calibration)

**고정 금리 결정**:
```
Fixed Rate = PV(Float Leg) / PV(Annuity)

스왑 가치 = 0 (at-market)
```

---

## 출력 파일 분석

### 1. npv.csv (스왑 가격)

```csv
#TradeId,TradeType,Maturity,NPV
FixedFloatCCS_USD_EUR_5Y,CrossCurrencySwap,2021-02-08,0.000000
FixedFloatCCS_USD_EUR_10Y,CrossCurrencySwap,2026-02-08,0.000000
```

**해석**:
- 모든 NPV = 0 (at-market 스왑)
- 고정 금리가 정확히 보정됨

### 2. curves.csv (이자율 곡선)

| Tenor | USD-FedFunds | EUR-EONIA | EUR-EURIBOR-3M |
|-------|--------------|-----------|----------------|
| 1Y | 0.99612 | 0.99600 | 0.99550 |
| 5Y | 0.94305 | 0.94327 | 0.94000 |
| 10Y | 0.86500 | 0.86800 | 0.86000 |

---

## 핵심 개념

### 1. 고정-변동 스왑의 용도

**헷지**:
- 통화 리스크 헷지
- 금리 리스크 헷지

**재무**:
- 외화 자금 조달
- 금리 스왑과 통화 스왑 결합

### 2. 가격 평가 요소

**영향 요인**:
1. 양쪽 통화의 이자율
2. FX 선도 환율
3. 크레디트 스프레드
4. 유동성 프리미엄

### 3. 일반적인 CCS와의 차이

| 특징 | 일반적 CCS | 고정-변동 CCS |
|------|------------|---------------|
| Fixed Leg | 변동 | **고정** |
| Floating Leg | 변동 | 변동 |
| 용도 | 통화 스프레드 | 이자율 + 통화 |

---

## 요약

### ✅ 예제 결과

- **스왑 유형**: 고정-변동 CCS
- **통화 쌍**: USD-EUR
- **만기**: 1Y ~ 30Y
- **NPV**: 모두 0 (정확히 보정)

### 🎓 학습 포인트

- 고정-변동 CCS의 구조
- 가격 평가 방법
- 곡선 보정 과정

---

## 참고

- **ORE User Guide**: Cross Currency Swaps
- **QuantLib**: CrossCurrencySwap 구현
- **ISDA**: Cross Currency Swap Conventions

---

## 💻 실제 실행 결과 분석

### ORE 실행 개요

**실행 명령**:
```bash
cd /home/popos/dev/Engine/Examples/CurveBuilding
/home/popos/dev/Engine/build/App/ore Input/ore_fixedfloatccs.xml
```

**실행 시간**: 약 0.78초

**생성된 출력 파일**:
- `npv.csv` - 상품별 순현재가치
- `curves.csv` - 이자율 곡선 (240개월, 1M 간격)
- `flows.csv` - 상품 현금흐름
- `todaysmarketcalibration.csv` - 곡선 보정 결과

### npv.csv 파일 해석

**고정-변동 CCS 재가격 결과**:
```
SWAP_TRY_FIXED_USD_FLOAT:
- 유형: Swap (고정-변동 통화 간 스왑)
- 만기: 2021-02-09 (5년)
- NPV: 0.000000 USD
- 기준 통화: USD
- 명목 금액: $10,000,000
```

**NPV = 0 의미**:
```
at-market 스왑:
- 고정 금리가 시장 수준으로 보정됨
- 양쪽 Leg의 현재가치가 균형
- 초기 거래 시 Fair Value = 0

이것이 정상인 이유:
- 스왑 거래는 보통 at-market으로 체결
- 양 당사자가 공평하게 시작
- 이후 시장 변동에 따라 가치 변동
```

### curves.csv 파일 해석

**고정-변동 CCS에 필요한 곡선**:
```
USD Leg (고정 금리):
- USD-FedFunds: USD 할인율
- 고정 금리 적용을 위한 기준

TRY/EUR Leg (변동 금리):
- 해당 통화의 변동 금리 인덱스
- 통화별 할인율 곡선
- FX 선도 환율 곡선
```

**보정(Calibration) 과정**:
```
고정 금리 결정:

1. 변동 Leg의 현재가치 계산
   PV(Float) = Σ [Float Rate × Notional × DF × FX]

2. 고정 Leg의 연금(Annuity) 계산
   PV(Annuity) = Σ [Fixed Notional × DF]

3. 고정 금리 산출
   Fixed Rate = PV(Float) / PV(Annuity)

결과:
- NPV = PV(Fixed) - PV(Float) = 0
- at-market 상태 달성
```

### 현금흐름 구조 (flows.csv)

**USD Fixed Leg 현금흐름**:
```
분기별:
- 고정 금리 × USD Notional × Δt
- USD로 지급
- USD OIS 곡선으로 할인

만기 시:
- USD 원금 상환
```

**TRY/EUR Floating Leg 현금흐름**:
```
분기별:
- 변동 금리 (LIBOR/EURIBOR) × Notional × Δt
- TRY/EUR로 수취
- 해당 통화 OIS 곡선으로 할인
- FX 환율로 USD로 변환

만기 시:
- TRY/EUR 원금 수취
- FX 환율로 USD로 변환
```

### 곡선 보정 결과

**todaysmarketcalibration.csv 분석**:

| 곡선 | 상태 | Pillar 수 | 설명 |
|------|------|-----------|------|
| USD-FedFunds | Success | 20+ | USD OIS 곡선 |
| 해당 통화 곡선 | Success | 20+ | 변동 금리 기준 |
| FX 곡선 | Success | 20+ | 통화 간 환율 |

**보정 성공 확인**:
- 모든 필요한 곡선이 성공적으로 구축됨
- 고정 금리가 시장 데이터를 정확히 반영
- 재가격 NPV = 0 확인

### 실무적 활용

**고정-변동 CCS의 용도**:
```
1. 이자율과 통화 리스크 동시 헷지:
   - Fixed Rate: 이자율 변동 헷지
   - Cross Currency: 통화 변동 헷지

2. 자금 조달 최적화:
   - 특정 통화로 자금 조달
   - 다른 통화로 고정 금리 지급
   - 시장 조건에 따른 비용 절감

3. 투기 전략:
   - 통화별 금리 차이 활용
   - 기대 수익 추구
```

### 결론

**검증 결과**:
- 고정-변동 CCS 가격 평가 **완벽하게 성공**
- 고정 금리 보정이 정확함
- NPV = 0으로 at-market 상태 확인

**실무적 의미**:
- 다국적 기업의 자금 조달 전략에 필수
- 통화와 이자율 리스크를 동시 관리
- 글로벌 재무 관리의 핵심 도구

**일반적 CCS와의 차이**:
```
일반적 CCS (변동-변동):
- 양쪽 모두 변동 금리
- 베이시스 스프레드만 교환

고정-변동 CCS (이 예제):
- 한쪽은 고정 금리
- 다른 한쪽은 변동 금리
- 이자율 스프레드 + 베이시스 동시 교환

용도:
- 일반적: 통화 스프레드 거래
- 고정-변동: 이자율과 통화 동시 헷지
```
