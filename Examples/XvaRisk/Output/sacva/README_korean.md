# SA-CVA (Standardized Approach CVA) 출력 설명

## 예제 개요

이 예제는 SA-CVA(Standardized Approach CVA)를 계산합니다. 바젤 III에서 도입된 표준화된 CVA 계산 방식입니다.

---

## 핵심 금융 용어

### SA-CVA (Standardized Approach CVA)
- **정의**: 바젤 III 규제 준수를 위한 표준화 CVA 계산
- **목적**: 카운터파티 신용 리스크 자본 요구금액 산출
- **특징**:
  - 간단하고 투명한 계산
  - 모든 은행에 동일한 방식 적용
  - 시장 리스크 요인 고려

### SA-CCR (Standardized Approach for Counterparty Credit Risk)
- **정의**: 카운터파티 리스크의 표준화 접근법
- **목적**: EAD(Exposure at Default) 계산

### CVA Risk Charge
- **정의**: CVA 변동성 리스크에 대한 자본 요구금액
- **산출**: CVA VaR × 12.5 (곱수)

---

## 출력 파일 상세 설명

### 1. sacva.csv
**용도**: SA-CVA 계산 결과

| 컬럼 | 설명 |
|------|------|
| Counterparty | 카운터파티 |
| NettingSet | 네팅 집합 |
| Analytic | 분석 항목 |
| Value | 값 |

---

### 2. sacvadetail.csv
**용도**: SA-CVA 상세 결과

---

### 3. sacva_sensitivities.csv
**용도**: CVA 민감도 분석

---

### 4. cva_sensitivities.csv
**용도**: CVA 시장 리스크 민감도

---

### 5. exposure_*.csv
**용도**: 노출 분석 결과

- **exposure_nettingset_CPTY_A.csv**: 네팅 집합별 노출
- **exposure_trade_Swap_EUR.csv**: EUR 스왑 노출
- **exposure_trade_Swap_USD.csv**: USD 스왑 노출

---

## SA-CVA 계산 구조

```
SA-CVA 계산
├── 1. RWAo (Risk Weighted Assets) 산출
│   └── SA-CCR로 EAD 계산
├── 2. CVA VaR 계산
│   └── 시장 리스크 요인 시뮬레이션
├── 3. CVA Risk Charge
│   └── max(CVA VaR, CVA stressed VaR)
└── 4. 자본 요구금액
    └── CVA Risk Charge × 12.5
```

---

## 실무 활용

### 1. 규제 준수
- **바젤 III**: CVA 자본 요구금액
- **CRR/CRD IV**: EU 규제
- **Fed guidelines**: 미국 연준 가이드라인

### 2. 리스크 관리
- 카운터파티 리스크 정량화
- 자본 배분 최적화
- CVA 헷징 전략

### 3. 보고
- 규제 기관 보고
- 내부 리스크 보고
- 투자자 공시

---

## SA-CVA vs BA-CVA vs Internal Model

| 구분 | SA-CVA | BA-CVA | Internal Model |
|------|--------|--------|----------------|
| 목적 | 규제 자본 | 회계 가치 | 리스크 관리 |
| 복잡도 | 낮음 | 중간 | 높음 |
| 승인 필요 | 없음 | 있음 | 있음 |
| 사용 | 모든 은행 | 회계 보고 | 대형 은행 |

---

## 실행 방법

```bash
cd /home/keehyun/dev/Engine/Examples/XvaRisk
ore Input/ore_sacva.xml
```

---

## 출력 파일 위치

```
Output/sacva/
├── sacva.csv                       # SA-CVA 결과
├── sacvadetail.csv                 # SA-CVA 상세
├── sacva_sensitivities.csv         # CVA 민감도
├── cva_sensitivities.csv           # 시장 리스크 민감도
├── exposure_*.csv                  # 노출 분석
├── npv.csv                         # 순현재가치
└── marketdata.csv                  # 시장 데이터
```

---

## SA-CVA 공식

```
K = CVA Capital Charge
K = 12.5 × max(CVA VaR, CVA stressed VaR)

CVA = 2.33 × √(h_i × Σ(RW_i × EAD_i^2))

여기서:
- h_i: 리스크 가중치 (5% 또는 1%)
- RW_i: 리스크 가중치
- EAD_i: Exposure at Default
```

---

## 참고 자료

- **ORE User Guide**: SA-CVA 장
- **Basel III**: "Capital requirements for credit risk and CVA"
- **BCBS 279**: CVA framework
