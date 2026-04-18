# 민감도 스트레스 (Sensitivity Stress) 출력 설명

## 예제 개요

이 예제는 민감도(Sensitivity) 분석과 스트레스 테스트를 결합합니다. 시장 요인의 큰 변화가 포트폴리오에 미치는 영향을 분석합니다.

---

## 핵심 금융 용어

### Sensitivity Stress
- **정의**: 민감도 분석에 큰 시프트(Stress)를 적용
- **목적**: 일상적인 민감도(1bp 시프트)보다 큰 충격 분석
- **예시**: 금리 100bp, 200bp 급등 시 포트폴리오 변화

### Buckets (버킷)
- **정의**: 리스크 요인을 만기별로 그룹화
- **예시**: 1Y, 2Y, 5Y, 10Y 금리 버킷

### Risk Factors (리스크 요인)
- **금리**: 각 통화별 만기 구조
- **환율**: 통화쌍별 환율
- **변동성**: 행사가별 변동성
- **크레딧**: 발행체별 스프레드

---

## 출력 파일 상세 설명

### 1. sensitivity.csv
**용도**: 민감도 분석 결과

| 컬럼 | 설명 |
|------|------|
| TradeId | 상품 식별자 |
| Factor | 리스크 요인 |
| ShiftSize | 시프트 크기 |
| Base NPV | 기준 NPV |
| Shifted NPV | 시프트 후 NPV |
| Delta | 1차 민감도 |
| Gamma | 2차 민감도 |

---

### 2. sensitivity_scenario.csv
**용도**: 시나리오별 민감도

---

### 3. sensitivity_config.csv
**용도**: 민감도 분석 설정

---

### 4. stresstest.csv
**용도**: 스트레스 테스트 결과 (일부 시나리오)

---

## 실무 활용

### 1. 리스크 한도 설정
- "금리 100bp 상승 시 손실이 X를 초과하면 안 됨"

### 2. 헷징 비율 계산
- 큰 시프트에 대한 헷징 비율

### 3. 극단적 시나리오 분석
- "금리가 급등하면 포트폴리오가 얼마나 취약한가?"

---

## 실행 방법

```bash
cd /home/keehyun/dev/Engine/Examples/MarketRisk
ore Input/ore_sensistress.xml
```

---

## 출력 파일 위치

```
Output/SensiStress/
├── sensitivity.csv               # 민감도 결과
├── sensitivity_scenario.csv      # 시나리오 민감도
├── sensitivity_config.csv        # 분석 설정
├── npv.csv                       # 순현재가치
└── curves.csv                    # 이자율 곡선
```

---

## 일반 민감도 vs 스트레스 민감도

| 구분 | 시프트 크기 | 목적 |
|------|-------------|------|
| 일반 민감도 | 1bp | 일일 리스크 |
| 스트레스 민감도 | 100bp+ | 극단적 상황 |
