# BA-CVA (Book Value Adjustment for CVA) 출력 설명

## 예제 개요

이 예제는 BA-CVA(Book Value Adjustment for CVA)를 계산합니다. CVA(Credit Valuation Adjustment)는 카운터파티 신용 리스크를 포트폴리오 가치에 반영하는 조정항입니다.

---

## 핵심 금융 용어

### CVA (Credit Valuation Adjustment)
- **정의**: 카운터파티 디폴트 리스크로 인한 포트폴리오 가치 감소액
- **의미**: 카운터파티가 디폴트할 경우 예상되는 손실의 현재 가치
- **공식**: CVA = LGD × ∫(EE(t) × PD(t)) × DF(t) dt
  - EE: Expected Exposure (예상 노출)
  - PD: Probability of Default (디폴트 확률)
  - DF: Discount Factor (할인율)
  - LGD: Loss Given Default (디폴트 시 손실률)

### BA-CVA (Book Value Adjustment)
- **정의**: 회계상 가치 조정을 위한 CVA
- **목적**: IFRS 13 등 회계 기준 준수
- **특징**: 시장 리스크 요인을 고려한 CVA

### EAD (Exposure at Default)
- **정의**: 디폴트 시점의 예상 노출 금액

### Effective Maturity
- **정의**: 리스크 가중 계산용 유효 만기

---

## 출력 파일 상세 설명

### 1. bacva.csv
**용도**: BA-CVA 계산 결과

| 컬럼 | 설명 |
|------|------|
| Counterparty | 카운터파티 |
| NettingSet | 네팅 집합 |
| Analytic | 분석 항목 (sCVA, EAD, EffMaturity 등) |
| Value | 값 |

**해석 예시**:
```
Counterparty: CPTY_A
sCVA: 520,752 EUR -> 단순 CVA
EAD: 1,734,262 EUR -> 디폴트 시 예상 노출
EffMaturity: 10.91년 -> 유효 만기
RiskWeight: 5% -> 리스크 가중치

BA_CVA_CAPITAL: 338,488 EUR -> 자본 요구금액
```

---

### 2. capital_crif.csv
**용도**: 리스크 가중 계산 결과

---

### 3. saccr.csv
**용도**: SA-CCR 결과 (표준화 접근법)

---

### 4. saccr_detail.csv, saccrdetail.csv
**용도**: SA-CCR 상세 결과

---

### 5. npv.csv
**용도**: 각 상품의 순현재가치

```
Swap_EUR: -363 EUR (EUR 스왑)
Swap_USD: 88,407 USD (USD 스왑)
```

---

## CVA 계산 구조

```
CVA 계산
├── Expected Exposure (EE) 산출
│   ├── Monte Carlo 시뮬레이션
│   └── 미래 포트폴리오 가치 분포
├── Default Probability (PD) 계산
│   ├── 크레딧 스프레드 커브
│   └── 디폴트 강도 모델
└── CVA = LGD × Σ(EE × PD × DF)
```

---

## 실무 활용

### 1. 회계 기준 준수
- **IFRS 13**: 공정 가치 측정
- **CECL**: 예상 신용손실
- **FASB**: 미국 회계 기준

### 2. 자본 요구금액
- **바젤 III**: CVA 자본 요구금액
- **FRTB**: 마크리스크 자본

### 3. 카운터파티 리스크 관리
- CVA 헷징
- 리스크 한도 설정
- 가격 책정

---

## CVA vs BA-CVA

| 구분 | CVA | BA-CVA |
|------|-----|---------|
| 목적 | 리스크 관리 | 회계 보고 |
| 계산 방법 | 시장 데이터 기반 | 단순화/보수적 |
| 사용 | 데일리 리스크 | 연간 재무제표 |

---

## 실행 방법

```bash
cd /home/keehyun/dev/Engine/Examples/XvaRisk
ore Input/ore_bacva.xml
```

---

## 출력 파일 위치

```
Output/bacva/
├── bacva.csv                   # BA-CVA 결과
├── capital_crif.csv            # 리스크 가중
├── saccr.csv                   # SA-CCR 결과
├── saccr_detail.csv            # SA-CCR 상세
├── npv.csv                     # 순현재가치
├── marketdata.csv              # 시장 데이터
└── log.txt                     # 실행 로그
```

---

## 참고 자료

- **ORE User Guide**: XVA 계산 장
- **Basel III**: CVA 자본 요구금액 가이드라인
- **IFRS 13**: 공정 가치 측정 기준
