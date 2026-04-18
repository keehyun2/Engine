# XVA 설명 (XVA Explain) 출력 설명

## 예제 개요

이 예제는 XVA 구성 요소를 상세히 분해하여 설명합니다. CVA, DVA, FCA, FBA 등이 어떻게 계산되는지 보여줍니다.

---

## 핵심 금융 용어

### XVA Explain
- **정의**: XVA의 각 구성 요소별 상세 분석
- **목적**: XVA 변동의 원인 파악
- **구성 요소**:
  - 시나리오별 기여도
  - 상품별 기여도
  - 시장 요인별 기여도

---

## 출력 파일 상세 설명

### 1. xvaExplain_summary.csv
**용도**: XVA 설명 요약

| 항목 | 설명 |
|------|------|
| Scenario | 시나리오 |
| XVA_Components | XVA 구성 요소 |
| Base_Value | 기준값 |
| Change_Value | 변화값 |
| Explanation | 설명 |

---

### 2. xvaExplain.csv
**용도**: XVA 설명 상세

---

### 3. xvaExplain_details.csv
**용도**: XVA 설명 추가 상세

---

### 4. par_scenarios.csv
**용도**: Par 금리 시나리오

---

## XVA 설명 구조

```
XVA Explain
├── 시나리오별 분해
│   ├── Base 시나리오
│   ├── Shifted 시나리오
│   └── 차이 분석
├── 구성 요소별 분해
│   ├── CVA 기여도
│   ├── DVA 기여도
│   ├── FCA 기여도
│   └── FBA 기여도
└── 시장 요인별 분해
    ├── 금리 기여도
    ├── 크레딧 스프레드 기여도
    └── 환율 기여도
```

---

## 실행 방법

```bash
cd /home/keehyun/dev/Engine/Examples/XvaRisk
ore Input/ore_explain.xml
```

---

## 출력 파일 위치

```
Output/explain/
├── xvaExplain_summary.csv         # 요약
├── xvaExplain.csv                 # 상세
├── xvaExplain_details.csv         # 추가 상세
├── par_scenarios.csv              # 시나리오
└── marketdata.csv                 # 시장 데이터
```

---

## 참고 자료

- **ORE User Guide**: XVA Explain 장
