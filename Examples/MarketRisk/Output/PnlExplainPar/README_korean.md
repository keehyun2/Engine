# PnL 속성 분석 Par (PnL Explain Par) 출력 설명

## 예제 개요

이 예제는 PnL(Profit & Loss)을 Par 금리 관점에서 분해하여 설명합니다.

---

## 핵심 금융 용어

### PnL Explain (Par)
- **정의**: PnL 변화를 Par 금리 관점에서 분해
- **목적**: Par 시프트가 PnL에 미치는 영향 분석
- **용도**: Par 기반 헷징 전략 수립

---

## 출력 파일 상세 설명

### 1. pnl_additional_results_*.csv
**용도**: PnL 분해 결과 (Par 관점)

---

### 2. par_scenarios.csv
**용도**: Par 시나리오 데이터

---

### 3. zero_scenarios.csv
**용도**: 제로 시나리오 데이터

---

## 실행 방법

```bash
ore Input/ore_pnlexplain_par.xml
```

---

## 출력 파일 위치

```
Output/PnlExplainPar/
├── pnl_additional_results_*.csv  # PnL 분해 결과
├── par_scenarios.csv             # Par 시나리오
├── zero_scenarios.csv            # 제로 시나리오
├── pnl.csv                       # PnL 데이터
└── npv.csv                       # 순현재가치
```

---

## 참고 자료

- **ORE User Guide**: PnL Explain Par 장
