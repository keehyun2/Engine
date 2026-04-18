# 스트레스 테스트 (Stress Test) 출력 설명

## 예제 개요

이 예제는 스트레스 테스트(Stress Testing)를 수행합니다. 극단적인 시장 상황에서 포트폴리오가 얼마나 손실을 볼 수 있는지 분석합니다.

---

## 핵심 금융 용어

### Stress Test (스트레스 테스트)
- **정의**: 극단적인 시장 상황(금리 급등, 환율 폭락 등)에서의 포트폴리오 손실 시뮬레이션
- **목적**: 일상적인 VaR로 포착되지 않는 꼬리 리스크(Tail Risk) 측정
- **소프트웨어적 비유**: 시스템 과부하 테스트 - 최악의 경우에도 견디는지 확인

### Stress Scenario (스트레스 시나리오)
- **Historical**: 과거 사건 재현 (2008 금융위기, 1997 아시아 외환위기 등)
- **Hypothetical**: 가상 시나리오 (금리 2% 급등, 유로존 해체 등)
- **Reverse**: 최악의 시장 움직임 찾기

---

## 출력 파일 상세 설명

### 1. stresstest.csv
**용도**: 스트레스 테스트 결과

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
TradeId: Swap_USD_10Y
Scenario: InterestRateShock_Up200bp
Base NPV: 100,000 USD
Stressed NPV: -500,000 USD
PnL: -600,000 USD
```
- 금리가 2% 상승하면 60만 USD 손실

---

### 2. stress_scenarios.csv
**용도**: 적용된 스트레스 시나리오 정의

| 컬럼 | 설명 |
|------|------|
| Scenario | 시나리오 이름 |
| Factor | 리스크 요인 (금리, 환율 등) |
| Shift | 시프트 크기 |
| Type | 시프트 유형 |

**예시 시나리오**:
```
Scenario: InterestRateShock_Up200bp
Factor: USD_Swap_Curve
Shift: +200bp (금리 2% 상승)

Scenario: FxShock_EURUSD_Down10%
Factor: EUR/USD
Shift: -10% (유로화 10% 절하)
```

---

### 3. stresstest_flows.csv
**용도**: 스트레스 시나리오별 현금흐름 변화

---

### 4. sensitivity.csv
**용도**: 민감도 분석 결과 (일부 시나리오)

---

### 5. sensitivity_scenario.csv
**용도**: 민감도 시나리오 데이터

---

## 실무 활용

### 1. 규제 요구사항
- **CCAR** (미국): 연준 연간 스트레스 테스트
- **EBA Stress Test** (유럽): 유럽은행감독청 스트레스 테스트
- **ICAAP** (바젤): 내부 자본적정성 평가

### 2. 리스크 관리
- 취약한 포지션 식별
- 헷징 전략 수립
- 자본 배분 최적화

### 3. 투자자 보고
- "최악의 경우 손실은 X만 원입니다"

---

## 주요 스트레스 시나리오 예시

| 시나리오 | 설명 | 영향 |
|---------|------|------|
| 금리 충격 | 금리 2% 급등/급락 | 채권, 스왑 가격 변동 |
| 환율 충격 | 주요 통화 10% 변동 | 외환 포지션 손실 |
| 주가 폭락 | 주식 30% 하락 | 주식 파생상품 손실 |
| 신용 위기 | 스프레드 300bp 확대 | 크레딧 손실 |
| 유동성 위기 | 유동성 프리미엄 급증 | 유동성 리스크 |

---

## 실행 방법

```bash
cd /home/keehyun/dev/Engine/Examples/MarketRisk
ore Input/ore_stress.xml
```

---

## 출력 파일 위치

```
Output/Stress/
├── stresstest.csv            # 핵심 스트레스 테스트 결과
├── stress_scenarios.csv      # 시나리오 정의
├── stresstest_flows.csv      # 현금흐름 변화
├── sensitivity.csv           # 민감도
├── npv.csv                   # 순현재가치
├── curves.csv                # 이자율 곡선
├── flows.csv                 # 현금흐름
└── marketdata.csv            # 시장 데이터
```

---

## VaR vs 스트레스 테스트

| 측정 방법 | 목적 | 시장 상황 |
|----------|------|----------|
| VaR | 일상적인 리스크 | 정상 시장 (95-99% 신뢰수준) |
| Stress Test | 꼬리 리스크 | 극단적 상황 (1% 미만) |

---

## 참고 자료

- **ORE User Guide**: 스트레스 테스트 장
- **BCBS 239**: 스트레스 테스트 가이드라인
- **Federal Reserve**: CCAR 가이드라인
