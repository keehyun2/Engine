# PnL 속성 분석 (PnL Explain) 출력 설명

## 예제 개요

이 예제는 PnL(Profit & Loss)의 변화를 시장 요인별로 분해하여 설명합니다. "어떤 요인 때문에 PnL이 변했는가?"를 분석합니다.

---

## 핵심 금융 용어

### PnL Explain (PnL 속성 분석)
- **정의**: PnL 변화를 시장 요인별(금리, 환율, 변동성 등)로 분해
- **목적**: PnL 변화의 원인 파악
- **용도**: 트레이딩 성과 분석, 리스크 관리

### PnL Attribution Components
- **Curve Move**: 금리 곡선 변화로 인한 PnL
- **Volatility Change**: 변동성 변화로 인한 PnL
- **Time Decay (Theta)**: 시간 경과로 인한 PnL
- **Carry**: 롤오버 수익

---

## 출력 파일 상세 설명

### 1. pnl_additional_results_*.csv
**용도**: PnL 분해 결과

| 컬럼 | 설명 |
|------|------|
| TradeId | 상품 식별자 |
| Component | PnL 구성 요소 |
| PnL | 해당 요인으로 인한 PnL |
| Total PnL | 전체 PnL |

**예시 데이터**:
```
TradeId: Swap_10Y
Component: Curve_Move
PnL: -50,000 USD

Component: Time_Decay
PnL: +500 USD

Total PnL: -49,500 USD
```

---

### 2. additional_results.csv
**용도**: PnL 분해 요약

---

### 3. npv.csv
**용도**: 순현재가치

---

### 4. curves.csv
**용도**: 이자율 곡선

---

### 5. flows.csv
**용도**: 현금흐름

---

## PnL 분해 구조

```
Total PnL = Curve_Move + Volatility_Change + Time_Decay + Carry + Other
```

**예시**:
```
Total PnL: -49,500 USD
├── Curve_Move: -50,000 USD (금리 상승으로 손실)
├── Time_Decay: +500 USD (시간 경과로 이득)
└── Other: 0 USD
```

---

## 실무 활용

### 1. 트레이딩 성과 분석
- "오늘 PnL은 -50만 원인데, 금리 변동 때문에 -50만 원, 시간 경과로 +5천 원"

### 2. 헷징 효과 확인
- 헷징 후 금리 리스크가 줄어들었는지 확인

### 3. 리스크 관리
- 어떤 요인이 가장 큰 PnL 변화를 일으키는지 확인

---

## 실행 방법

```bash
cd /home/keehyun/dev/Engine/Examples/MarketRisk
ore Input/ore_pnlexplain.xml
```

---

## 출력 파일 위치

```
Output/PnlExplain/
├── pnl_additional_results_*.csv  # PnL 분해 결과 (다양한 시나리오)
├── additional_results.csv        # 요약 결과
├── npv.csv                       # 순현재가치
├── curves.csv                    # 이자율 곡선
└── flows.csv                     # 현금흐름
```

---

## 파일명 패턴

```
pnl_additional_results_t0.csv     : 초기 시점 PnL
pnl_additional_results_t1_*.csv   : t1 시점 PnL (다양한 시나리오)
```

---

## 참고 자료

- **ORE User Guide**: PnL Explain 장
