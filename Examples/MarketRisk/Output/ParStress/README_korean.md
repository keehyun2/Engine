# Par 스트레스 테스트 (Par Rate Stress Test) 출력 설명

## 예제 개요

이 예제는 Par Rate(Par 금리)에 대한 스트레스 테스트를 수행합니다. 금리 곡선의 Par Rate가 시프트될 때 포트폴리오의 가치 변화를 분석합니다.

---

## 핵심 금융 용어

### Par Rate (Par 금리)
- **정의**: 특정 만기의 스왑이 NPV=0이 되도록 하는 고정 금리
- **용도**: 시장 금리 수준의 대표 지표
- **예시**: 10년 만기 USD Swap Rate 3.50% = 10년 Par Rate

### Par Stress
- **정의**: Par Rate 곡선에 스트레스 시나리오 적용
- **시나리오 유형**:
  - **Parallel Shift**: 전체 곡선 상승/하락 (예: +100bp)
  - **Steepener**: 단기 금리는 유지, 장기 금리 상승
  - **Flattener**: 단기 금리는 유지, 장기 금리 하락
  - **Curve Twist**: 단기 상승, 장기 하락 (또는 그 반대)

### Key Rate Duration (핵 금리 듀레이션)
- **정의**: 특정 만기 포인트에서 금리가 1bp 변할 때 채권 가격 변화
- **용도**: 만기별 금리 리스크 측정

---

## 출력 파일 상세 설명

### 1. stresstest.csv
**용도**: Par 스트레스 테스트 결과

| 컬럼 | 설명 |
|------|------|
| TradeId | 상품 식별자 |
| Scenario | 시나리오 이름 |
| Base NPV | 기준 NPV |
| Stressed NPV | 스트레스 NPV |
| PnL | 손익 (Stressed - Base) |
| Tenor | 영향받는 만기 |

**해석 예시**:
```
TradeId: Swap_USD_10Y
Scenario: Par_Shift_Up100bp
Base NPV: 100,000 USD
Stressed NPV: -50,000 USD
PnL: -150,000 USD
```
- Par 금리가 100bp 상승하면 15만 USD 손실

```
TradeId: Swap_USD_10Y
Scenario: Par_Steepener
Base NPV: 100,000 USD
Stressed NPV: 25,000 USD
PnL: -75,000 USD
```
- 곡선이 가팔라지면(장기 금리 상승) 7.5만 USD 손실

---

### 2. stress_scenario_par_rates.csv
**용도**: 스트레스 시나리오별 Par 금리

| 컬럼 | 설명 |
|------|------|
| Scenario | 시나리오 이름 |
| Tenor | 만기 |
| Base Par Rate | 기준 Par 금리 |
| Stressed Par Rate | 스트레스 Par 금리 |
| Shift | 시프트 크기 |

**예시**:
```
Scenario: Par_Shift_Up100bp
Tenor: 10Y
Base Par Rate: 3.50%
Stressed Par Rate: 4.50%
Shift: +100bp

Scenario: Par_Steepener
Tenor: 2Y
Base: 2.50%
Stressed: 2.50% (변화 없음)

Tenor: 10Y
Base: 3.50%
Stressed: 4.00% (+50bp)
```

---

### 3. stress_scenarios.csv
**용도**: 스트레스 시나리오 정의

---

### 4. npv.csv
**용도**: 순현재가치

---

### 5. curves.csv
**용도**: 이자율 곡선

---

## 주요 Par 스트레스 시나리오

| 시나리오 | 설명 | 영향 |
|---------|------|------|
| Parallel Shift Up | 전체 곡선 상승 | 금리 인상 기대 |
| Parallel Shift Down | 전체 곡선 하락 | 금리 인하 기대 |
| Steepener | 장기 금리 > 단기 금리 | 경기 회복 기대 |
| Flattener | 장기 금리 < 단기 금리 | 경기 둔화 기대 |
| Short Rate Up | 단기 금리 상승 | 통화 긴축 |
| Long Rate Up | 장기 금리 상승 | 인플레이션 기대 |

---

## 실무 활용

### 1. 금리 리스크 관리
- **DV01**: 금리 1bp 변화 시 가치 변화
- **Key Rate Duration**: 만기별 금리 리스크

### 2. ALM (Asset Liability Management)
- **은행**: 예금 금리(단기) vs 대출 금리(장기) 관리
- **보험사**: 채권 포트폴리오 금리 리스크

### 3. 헷징 전략
- 금리 선물 (Futures)
- 스왑 (Swaps)
- 금리 옵션 (Options)

---

## Par Curve vs Zero Curve

| 구분 | Par Curve | Zero Curve |
|------|-----------|------------|
| 정의 | 스왑 NPV=0 금리 | 할인율 곡선 |
| 용도 | 시장 금리 수준 표현 | 모든 금융상품 가치평가 |
| 계산 | 시장에서 관측 | Par Curve에서 도출 |
| 형태 | Par Curve는 곡선 형태 | Zero Curve는 더 매끄러움 |

---

## 실행 방법

```bash
cd /home/keehyun/dev/Engine/Examples/MarketRisk
ore Input/ore_parstress.xml
```

---

## 출력 파일 위치

```
Output/ParStress/
├── stresstest.csv                      # 핵심 스트레스 결과
├── stress_scenario_par_rates.csv       # Par 금리 시나리오
├── stress_scenarios.csv                # 시나리오 정의
├── npv.csv                             # 순현재가치
├── curves.csv                          # 이자율 곡선
└── marketdata.csv                      # 시장 데이터
```

---

## 곡선 변화 해석

| 곡선 변화 | 경제적 의미 | 영향받는 상품 |
|----------|-------------|--------------|
| Steepening | 경기 회복 | 장기 채권, 스프레드 |
| Flattening | 경기 둔화 | 단기 채권 |
| Inversion | 경기 침체 신호 | 2Y-10Y 스프레드 |
| Parallel Shift | 통화정책 변화 | 모든 금리 상품 |

---

## 참고 자료

- **ORE User Guide**: Par 스트레스 테스트 장
- **Tuckman, Bruce**: "Fixed Income Securities" - 금리 곡선 동학
