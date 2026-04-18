# 민감도 분석 (Sensitivity Analysis) 출력 설명

## 예제 개요

이 예제는 ORE의 민감도(Sensitivity) 분석 기능을 보여줍니다. 금융 상품 포트폴리오의 가격이 시장 변수(금리, 환율 등)의 변화에 얼마나 민감한지 분석합니다.

---

## 핵심 금융 용어

### Sensitivity (민감도)
- **정의**: 시장 변수(금리, 환율, 변동성 등)가 1단위 변화할 때 파생상품 가격의 변화량
- **소프트웨어적 비유**: 함수의 도함수(derivative) - 입력이 조금 변할 때 출력이 얼마나 변하는가?

### 주요 민감도 지표
- **Delta (δ)**: 기초 자산 가격이 1단위 변할 때 파생상품 가격 변화
- **Gamma (γ)**: Delta가 기초 자산 가격에 대해 얼마나 민감한지 (Delta의 도함수)
- **Vega (ν)**: 변동성이 1% 변할 때 파생상품 가격 변화
- **Rho (ρ)**: 금리가 1% 변할 때 파생상품 가격 변화
- **Theta (θ)**: 시간이 1일 지날 때 파생상품 가격 변화

### Par Rate (Par Yield)
- **정의**: 특정 만기의 스왑이 NPV=0이 되도록 하는 고정 금리

---

## 출력 파일 상세 설명

### 1. sensitivity.csv
**용도**: 각 상품별 민감도 분석 결과

| 컬럼 | 설명 |
|------|------|
| TradeId | 상품 식별자 |
| Factor | 리스크 요인 (금리, 환율, 변동성 등) |
| ShiftSize | 시프트 크기 (보통 1bp = 0.01%) |
| ShiftType | 시프트 유형 (Absolute, Relative) |
| Base NPV | 기준 NPV |
| Shifted NPV | 시프트 후 NPV |
| Delta | 델타 값 (1차 민감도) |
| Gamma | 감마 값 (2차 민감도) |

**해석 예시**:
```
TradeId: Swap_USD_10Y
Factor: EUR/USD FX Rate
Delta: -100,000
Gamma: 50,000
```
- EUR/USD 환율이 1단위 변하면 상품 가치가 -100,000 변화
- 감마가 양수이므로 환율 상승 시 델타도 증가

---

### 2. parsensitivity.csv
**용도**: Par Rate 기반 민감도 분석

| 컬럼 | 설명 |
|------|------|
| Currency | 통화 |
| Curve | 곡선 타입 |
| Tenor | 기간 |
| Par Rate | Par 금리 |
| Shifted Par Rate | 시프트 후 Par 금리 |
| Base NPV | 기준 NPV |
| Shifted NPV | 시프트 후 NPV |
| Sensitivity | 민감도 |

---

### 3. sensitivity_config.csv
**용도**: 민감도 분석 설정

- 어떤 시장 요인을 시프트할지 정의
- 시프트 크기 (1bp, 10bp 등)
- 시프트 방향 (Up/Down)

---

### 4. jacobi.csv
**용도**: 야코비안 행렬 (Jacobian Matrix)

- 다차원 민감도 분석
- 상품별 곡선별 민감도 행렬

---

### 5. jacobi_inverse.csv
**용도**: 야코비an 역행렬

- 역민감도 분석
- 리스크 요인 간 상관관계 분석

---

### 6. scenario.csv
**용도**: 민감도 시나리오 데이터

- 각 시나리오별 시장 데이터
- 시프트된 곡선 데이터

---

### 7. scenario_par_rates.csv
**용도**: 시나리오별 Par 금리

---

### 8. npv.csv
**용도**: 각 상품의 순현재가치

---

### 9. curves.csv
**용도**: 이자율 곡선 데이터

---

### 10. flows.csv
**용도**: 각 상품별 현금흐름

---

### 11. marketdata.csv
**용도**: 사용된 시장 데이터 요약

---

### 12. log.txt
**용도**: 실행 로그

---

## 실무 활용

### 1. 리스크 관리
- **델타 헷징**: 델타를 중립으로 만들어 가격 변동 리스크 감소
- **감마 리스크**: 큰 가격 변동 시 발생하는 비선형 리스크 관리

### 2. 포트폴리오 최적화
- 민감도가 너무 높은 포지션 축소
- 분산 투자를 통한 리스크 감소

### 3. 규제 요구사항
- FRTB (Fundamental Review of the Trading Book)
- 마진 요구금액 계산

---

## 실행 방법

```bash
cd /home/keehyun/dev/Engine/Examples/MarketRisk
ore Input/ore_sensi.xml
```

---

## 출력 파일 위치

```
Output/Sensi/
├── sensitivity.csv           # 핵심 민감도 결과
├── parsensitivity.csv        # Par 금리 민감도
├── sensitivity_config.csv    # 분석 설정
├── jacobi.csv                # 야코비안 행렬
├── jacobi_inverse.csv        # 야코비안 역행렬
├── scenario.csv              # 시나리오 데이터
├── scenario_par_rates.csv    # Par 금리 시나리오
├── npv.csv                   # 순현재가치
├── curves.csv                # 이자율 곡선
├── flows.csv                 # 현금흐름
├── marketdata.csv            # 시장 데이터
└── log.txt                   # 실행 로그
```

---

## 참고 자료

- **ORE User Guide**: 시장 리스크 분석 장
- **FRTB**: 마진 요구금액 계산 가이드라인
