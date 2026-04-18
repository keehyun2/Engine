# 시나리오 스트레스 테스트 (Scenario Stress Test) 출력 설명

## 예제 개요

이 예제는 다양한 시나리오(Scenario)에 대한 스트레스 테스트를 수행합니다. 사용자 정의 시나리오 또는 역사적 사건을 시뮬레이션합니다.

---

## 핵심 금융 용어

### Scenario Stress Test
- **정의**: 미리 정의된 시나리오에 따른 포트폴리오 손실 분석
- **시나리오 유형**:
  - **Historical**: 과거 사건 재현 (2008 금융위기 등)
  - **Hypothetical**: 가상 시나리오
  - **Reverse**: 최악의 시장 움직임 찾기

### Stress Scenarios
- 금리 충격 (Interest Rate Shock)
- 환율 충격 (FX Shock)
- 주가 폭락 (Equity Crash)
- 변동성 스파이크 (Volatility Spike)

---

## 출력 파일 상세 설명

### 1. stresstest.csv
**용도**: 시나리오별 스트레스 테스트 결과

| 컬럼 | 설명 |
|------|------|
| TradeId | 상품 식별자 |
| Scenario | 시나리오 이름 |
| Base NPV | 기준 NPV |
| Stressed NPV | 스트레스 NPV |
| PnL | 손익 (Stressed - Base) |
| PnL % | 손익 비율 |

**해석 예시**:
```
Scenario: Rate_Shock_Up200bp
Base NPV: 1,000,000 USD
Stressed NPV: -600,000 USD
PnL: -1,600,000 USD
```
- 금리가 2% 상승하면 160만 USD 손실

---

### 2. stress_scenarios.csv
**용도**: 스트레스 시나리오 정의

| 컬럼 | 설명 |
|------|------|
| Scenario | 시나리오 이름 |
| Factor | 리스크 요인 |
| Shift | 시프트 크기 |
| Type | 시프트 유형 |

---

## 주요 시나리오 예시

| 시나리오 | 설명 | 영향 |
|---------|------|------|
| Rate Shock +200bp | 금리 2% 급등 | 채권 가격 하락 |
| FX Shock -10% | 환율 10% 절하 | 외환 손실 |
| Equity Crash -30% | 주식 30% 폭락 | 주식 손실 |
| Vol Spike +50% | 변동성 50% 급등 | 옵션 변동 |

---

## 실행 방법

```bash
cd /home/keehyun/dev/Engine/Examples/MarketRisk
ore Input/ore_scenario_stress.xml
```

---

## 출력 파일 위치

```
Output/ScenarioStress/
├── stresstest.csv              # 핵심 결과
├── stress_scenarios.csv        # 시나리오 정의
└── log.txt                     # 실행 로그
```

---

## 참고 자료

- **ORE User Guide**: 시나리오 스트레스 테스트 장
