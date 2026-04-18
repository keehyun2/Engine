# 민감도 인덱스 분해 (Sensitivity Index Decomposition) 출력 설명

## 예제 개요

이 예제는 민감도를 인덱스(Index)별로 분해합니다. 리스크 요인이 포트폴리오에 미치는 영향을 인덱스 수준에서 분석합니다.

---

## 핵심 금융 용어

### Index Decomposition
- **정의**: 민감도를 인덱스별(예: S&P 500, KOSPI 등)로 분해
- **목적**: 인덱스별 리스크 기여도 분석
- **용도**: 인덱스 헷징, 리스크 분산

### Par Sensitivity
- **정의**: Par 금리 변화에 대한 민감도

### Sensitivity Decomposition
- **Bucket**: 만기별 그룹
- **Currency**: 통화별
- **Index**: 인덱스별

---

## 출력 파일 상세 설명

### 1. parsensitivity.csv
**용도**: Par 민감도 분해 결과

| 컬럼 | 설명 |
|------|------|
| Index | 인덱스 이름 |
| Currency | 통화 |
| Tenor | 만기 |
| Base Par Rate | 기준 Par 금리 |
| Shifted Par Rate | 시프트 Par 금리 |
| Sensitivity | 민감도 |

---

### 2. sensitivity.csv
**용도**: 민감도 분석 결과

---

### 3. scenario_par_rates.csv
**용도**: 시나리오별 Par 금리

---

### 4. scenario.csv
**용도**: 시나리오 데이터

---

## 실무 활용

### 1. 인덱스 헷징
- "S&P 500이 1% 하락하면 포트폴리오가 얼마나 손실인가?"

### 2. 리스크 분산
- 인덱스별 리스크 기여도 확인
- 특정 인덱스에 과도하게 노출된 경우 분산

---

## 실행 방법

```bash
cd /home/keehyun/dev/Engine/Examples/MarketRisk
ore Input/ore_sensi_eq_credit_index_decomposition.xml
```

---

## 출력 파일 위치

```
Output/Sensi_index_decomposition/
├── parsensitivity.csv              # Par 민감도 분해
├── sensitivity.csv                 # 민감도
├── scenario_par_rates.csv          # Par 금리 시나리오
├── scenario.csv                    # 시나리오 데이터
├── npv.csv                         # 순현재가치
└── curves.csv                      # 이자율 곡선
```

---

## 참고 자료

- **ORE User Guide**: 민감도 인덱스 분해 장
