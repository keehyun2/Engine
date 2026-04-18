# SMRC (Standard Margin Risk Calculation) 출력 설명

## 예제 개요

이 예제는 SIMM(Standard Initial Margin Model) 기반의 마진 리스크를 계산합니다. 파생상품 거래의 초기 증거금 요구금액을 산출합니다.

---

## 핵심 긔융 용어

### SMRC (Standard Margin Risk Calculation)
- **정의**: ISDA SIMM 모델을 사용하여 초기 증거금(Initial Margin) 계산
- **목적**: 비중앙청산 파생상품의 리스크 관리
- **규제**: 바젤 마진 요구사항 (BCBS-262)

### SIMM (Standard Initial Margin Model)
- **개발**: ISDA(International Swaps and Derivatives Association)
- **목적**: 비중앙청산 파생상품의 증거금 표준화
- **적용**: 2017년 9월부터 도입

### Margin Components
- **Delta Margin**: 델타 리스크 기반 마진
- **Vega Margin**: 변동성 리스크 기반 마진
- **Curvature Margin**: 곡률 리스크 기반 마진
- **Base Correlation**: 기초 자산 상관관계

---

## 출력 파일 상세 설명

### 1. smrc.csv
**용도**: SMRC 계산 결과 요약

| 컬럼 | 설명 |
|------|------|
| Portfolio | 포트폴리오 식별자 |
| ProductClass | 상품 클래스 (InterestRate, FX, Credit, Equity, Commodity) |
| RiskClass | 리스크 클래스 |
| DeltaMargin | 델타 마진 |
| VegaMargin | 베가 마진 |
| CurvatureMargin | 곡률 마진 |
| TotalMargin | 전체 마진 |

**해석 예시**:
```
ProductClass: InterestRate
DeltaMargin: 1,500,000 USD
VegaMargin: 500,000 USD
CurvatureMargin: 300,000 USD
TotalMargin: 2,300,000 USD
```
- 금리 파생상품의 전체 증거금 요구금액은 230만 USD

---

### 2. smrcdetail.csv
**용도**: SMRC 상세 결과

| 컬럼 | 설명 |
|------|------|
| Portfolio | 포트폴리오 |
| RiskFactor | 리스크 요인 |
| Bucket | 버킷 (만기 그룹) |
| Amount | 금액 |
| Weight | 가중치 |
| Margin | 마진 기여도 |

---

### 3. cashflow.csv
**용도**: 마진 관련 현금흐름

---

### 4. npv.csv
**용도**: 순현재가치

---

## SIMM 상품 클래스

| 상품 클래스 | 설명 | 리스크 요인 |
|------------|------|------------|
| InterestRate | 금리 파생상품 | 금리 곡선 |
| FX | 외환 파생상품 | 환율 |
| Credit | 크레딧 파생상품 | 크레딧 스프레드 |
| Equity | 주식 파생상품 | 주가 |
| Commodity | 상품 파생상품 | 상품 가격 |

---

## 실무 활용

### 1. 증거금 계산
- 거래 상대방과의 계약에 따른 증거금 산출
- 일일 재평가(Daily Revaluation)

### 2. 리스크 관리
- 포트폴리오별 증거금 집중도 분석
- 마진 최적화

### 3. 규제 준수
- 바젤 마진 요구사항 준수
- ISDA SIMM 모델 사용

---

## 실행 방법

```bash
cd /home/keehyun/dev/Engine/Examples/MarketRisk
ore Input/ore_smrc.xml
```

---

## 출력 파일 위치

```
Output/SMRC/
├── smrc.csv                     # SMRC 결과 요약
├── smrcdetail.csv               # SMRC 상세 결과
├── cashflow.csv                 # 현금흐름
├── npv.csv                      # 순현재가치
└── marketdata.csv               # 시장 데이터
```

---

## 증거금 계산 구조

```
Total Margin = Delta Margin + Vega Margin + Curvature Margin + Additional Margin

Delta Margin: 가격 변동 리스크
Vega Margin: 변동성 변동 리스크
Curvature Margin: 대형 가격 변동 리스크
```

---

## 참고 자료

- **ORE User Guide**: SMRC/SIMM 장
- **ISDA SIMM**: https://www.isda.org/simm/
- **BCBS-262**: 바젤 마진 요구사항
