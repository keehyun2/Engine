# 스트레스 시나리오 생성 (Stress Scenario Generation) 출력 설명

## 예제 개요

이 예제는 스트레스 테스트용 시나리오를 생성합니다. 어떤 시장 충격이 포트폴리오에 가장 큰 영향을 미치는지 분석합니다.

---

## 핵심 금융 용어

### Stress Scenario Generation
- **정의**: 스트레스 테스트용 시나리오 자동 생성
- **목적**: 최악의 시장 상황 식별
- **방법**: 역최적화(Reverse Optimization) 또는 Monte Carlo

### Reverse Stress Test
- **정의**: 포트폴리오가 특정 손실을 입게 하는 시나리오 찾기
- **목적**: "얼마나 나빠져야 X만 원을 잃는가?"

---

## 출력 파일 상세 설명

### 1. stress_scenarios.csv
**용도**: 생성된 스트레스 시나리오

| 컬럼 | 설명 |
|------|------|
| Scenario | 시나리오 이름 |
| Factor | 리스크 요인 |
| Shift | 시프트 크기 |
| PnL | 예상 손실 |

---

## 실행 방법

```bash
cd /home/keehyun/dev/Engine/Examples/MarketRisk
ore Input/ore_stress_scenario_generation.xml
```

---

## 출력 파일 위치

```
Output/StressScenarioGeneration/
├── stress_scenarios.csv           # 생성된 시나리오
└── marketdata.csv                 # 시장 데이터
```

---

## 참고 자료

- **ORE User Guide**: 스트레스 시나리오 생성 장
