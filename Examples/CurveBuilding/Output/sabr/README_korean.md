# SABR 예제 출력 파일 설명 (SABR Example Output Explanation)

## 소프트웨어 엔지니어를 위한 설명

이 문서는 SABR(Stochastic Alpha Beta Rho) 변동성 모델을 사용한 ORE 예제의 출력 파일을 설명합니다.

---

## 예제 개요

### SABR 모델이란?

**SABR = Stochastic Alpha Beta Rho**
- 금리 옵션(스왑션 등)의 변동성을 모델링하는 확률 모델
- 변동성의 "스마일" 현상을 포착 (행사가에 따른 변동성 차이)
- 파라미터:
  - **Alpha**: 변동성 수준
  - **Beta**: 가격과 변동성의 관계 (0~1)
  - **Rho**: 금리와 변동성의 상관관계
  - **Nu**: 변동성 자체의 변동성

### 이 예제의 금융 상품

1. **Swaption_USD_SOFR**: USD SOFR 기반 유럽형 스왑션
   - 만기: 2046년 1월 (20년 스왑)
   - 행사가: 1.537%
   - 행시일: 2026년 1월 8일

2. **Cap_USD_SOFR**: USD SOFR 기반 Cap (금리 상한)
   - 만기: 2025년 3월 (1년)
   - 상한가: 0%

---

## 출력 파일 상세 설명

### 1. npv.csv (순현재가치)

| 컬럼 | 값 | 설명 |
|------|-----|------|
| TradeId | Cap_USD_SOFR | Cap 상품 ID |
| TradeType | Swap | ORE 내부적으로 Swap으로 처리 |
| Maturity | 2025-03-21 | 만기일 |
| NPV | 292.45 USD | Cap의 순현재가치 |
| Notional | 100,000,000 USD | 명목 금액 (1억 USD) |

| TradeId | Swaption_USD_SOFR | 스왑션 상품 ID |
| TradeType | Swaption | 스왑션 |
| Maturity | 2046-01-12 | 기초 자산 만기일 |
| NPV | 248,320.97 USD | 스왑션의 순현재가치 (옵션 프리미엄) |
| Notional | 100,000,000 USD | 명목 금액 |

**해석**:
- **Cap 가치**: 292 USD → 현재 금리 수준에서 Cap 거의 가치 없음 (금리가 낮음)
- **스왑션 가치**: 248,321 USD → 옵션 프리미엄으로 지불해야 함
  - 옵션 매입(Long)이므로 정수익(NPV 양수)은 옵션 프리미엄

---

### 2. additional_results.csv (추가 결과)

#### Cap_USD_SOFR (상세 정보)

| 필드 | 값 | 설명 |
|------|-----|------|
| PricingConfigEngine | DiscountingSwapEngine | 사용 엔진 |
| PricingConfigModel | DiscountedCashflows | 사용 모델 |
| legNPV[1] | 292.45 | 다리 1의 NPV |
| legType[1] | Floating | 변동금리 다리 |
| startDate | 2024-03-21 | 시작일 |
| paymentDate | 2024-06-21 | 첫 지급일 |

#### Swaption_USD_SOFR (스왑션 상세)

| 필드 | 값 | 설명 |
|------|-----|------|
| PricingConfigEngine | BlackBachelierSwaptionEngine | Black-Bachelier 엔진 |
| PricingConfigModel | BlackBachelier | Black-Bachelier 모델 |
| amount[1] | 3,806,060.61 | 고정금리 다리 금액 |
| amount[2] | 1,558,347.22 | 변동금리 다리 금액 |
| rate[1] | 0.037539 (3.75%) | 변동금리 (예측) |
| rate[2] | 0.015370 (1.537%) | 고정금리 (행사가) |
| **impliedVolatility** | **0.00928 (0.928%)** | **내재 변동성** |
| **strike** | **0.015370** | **행사가** |
| **timeToExpiry** | **1.81년** | **만기까지 남은 시간** |
| **atmForward** | **0.037443** | **ATM 포워드 금리** |
| **delta** | **-49,582,996** | **델타 (금리 민감도)** |
| **vega** | **144,687,227** | **베가 (변동성 민감도)** |
| **underlyingNPV** | **-28,450,631** | **기초 자산(NPV) 스왑** |

**그리스(Greeks) 해석**:
- **Delta (-49,582,996)**: 금리가 1% 상승하면 스왑션 가치가 약 495,829 USD 하락
  - 음수 = 금리 상승 시 손실 (Payer Swaption이므로)
- **Vega (144,687,227)**: 변동성이 1% 상승하면 스왑션 가치가 약 1,446,872 USD 상승
  - 옵션 매입(Long)이므로 변동성 상승 시 이익

---

### 3. curves.csv (이자율 곡선)

SOFR 곡선의 할인율 데이터:

| Tenor | Date | USD-SOFR | USD-FedFunds |
|-------|------|----------|--------------|
| 1M | 2024-04-19 | 0.9958 | 0.9957 |
| 1Y | 2025-03-19 | 0.9514 | 0.9514 |
| 10Y | 2034-03-19 | 0.6914 | 0.6912 |

**해석**:
- 10년 만기 할인율 약 0.69 → 현재 1원이 10년 뒤 약 0.69원 가치
- SOFR와 FedFunds 곡선이 거의 동일 (이 예제에서)

---

### 4. marketdata.csv (시장 데이터)

로딩된 시장 데이터 요약:
- SOFR OIS 금리
- SOFR 선물 가격
- SABR 스왑션 변동성 (다양한 만기/행사가 조합)
- Cap/Floor 변동성

---

### 5. todaysmarketcalibration.csv (시장 보정 결과)

각 상품별 보정(calibration) 결과:
- 사용된 금리 곡선
- 계산된 할인율
- 피팅 오차 정보

---

## 핵심 금융 용어 정리

### 스왑션 (Swaption)
- **정의**: 스왑 계약을 체결할 권리 (의무 아님)
- **유럽형**: 만기일에만 행시 가능
- **미국형**: 만기 전 언제든지 행시 가능
- **Payer**: 고정금리 지급 + 변동금리 수신 권리
- **Receiver**: 고정금리 수신 + 변동금리 지급 권리

### Cap/Floor
- **Cap**: 금리가 상한가 이상 시 차액 지급 (대출자 보호)
- **Floor**: 금리가 하한가 이하 시 차액 지급 (예금자 보호)
- **Collar**: Cap + Floor 조합

### 옵션 그리스 (Greeks)
- **Delta**: 기초 자산 가격 변화에 대한 옵션 가치 민감도
- **Vega**: 변동성 변화에 대한 옵션 가치 민감도
- **Gamma**: Delta의 변화율
- **Theta**: 시간 경과에 대한 옵션 가치 변화

### SABR 모델 파라미터
- **Alpha**: 절대 변동성 수준
- **Beta**: 가격-변동성 관계 (0=정규분포, 1=로그정규분포)
- **Rho**: 금리-변동성 상관관계
- **Nu**: 변동성의 변동성 (Vol of Vol)

---

## 실무 팁

### 1. 스왑션 가치 평가
```
스왑션 가치 = Black-Scholes 유사 공식
- 기초 자산: 스왑의 NPV
- 행사가: 고정금리
- 변동성: SABR 모델에서 추정
```

### 2. Cap 가치 평가
```
Cap 가치 = 각 Caplet의 가치 합
- Caplet: 각 지금일의 미니 옵션
- Black 모델 또는 Bachelier 모델 사용
```

### 3. SABR 변동성 곡면
```
변동성 스마일:
- ITM (In-The-Money): 낮은 변동성
- ATM (At-The-Money): 중간 변동성
- OTM (Out-The-Money): 높은 변동성
```

---

## 참고 자료

- **ORE User Guide**: `/home/popos/dev/Engine/Docs/userguide.pdf`
- **Methods Reference**: `/home/popos/dev/Engine/Docs/methods.pdf`
- **SABR Model Paper**: Hagan et al. (2002) "Managing Smile Risk"
