# PnL (Profit & Loss) 출력 설명

## 예제 개요

이 예제는 포트폴리오의 PnL(Profit & Loss)을 계산하고 분석합니다.

---

## 핵심 금융 용어

### PnL (Profit & Loss)
- **정의**: 포트폴리오의 총 수익 또는 손실
- **계산**: (현재 가치 - 이전 가치) + 현금흐름
- **용도**: 트레이딩 성과 측정

---

## 출력 파일 상세 설명

### 1. pnl.csv
**용도**: PnL 계산 결과

| 컬럼 | 설명 |
|------|------|
| TradeId | 상품 식별자 |
| PnL | 총 PnL |
| PnL Component | PnL 구성 요소 |

---

### 2. pnl_explain.csv
**용도**: PnL 속성 설명

---

### 3. pnl_cashflow.csv
**용도**: 현금흐름 기반 PnL

---

### 4. pnl_npv_*.csv
**용도**: NPV 기반 PnL (다양한 시나리오)

---

### 5. pnl_additional_results_*.csv
**용도**: PnL 추가 분석 결과

---

## 실행 방법

```bash
ore Input/ore_pnl.xml
```

---

## 출력 파일 위치

```
Output/Pnl/
├── pnl.csv                       # PnL 결과
├── pnl_explain.csv               # PnL 속성
├── pnl_cashflow.csv              # 현금흐름 PnL
├── pnl_npv_*.csv                 # NPV PnL (시나리오별)
├── pnl_additional_results_*.csv  # 추가 분석
├── npv.csv                       # 순현재가치
└── curves.csv                    # 이자율 곡선
```

---

## 파일명 패턴

```
pnl_npv_t0_*.csv  : 초기 시점 NPV
pnl_npv_t1_*.csv  : t1 시점 NPV (시나리오별)

m0_p0: scenario 0, path 0
m0_p1: scenario 0, path 1
m1_p0: scenario 1, path 0
...
```

---

## 참고 자료

- **ORE User Guide**: PnL 계산 장
