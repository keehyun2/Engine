# 노출 리스크 분석 (Exposure Risk Analysis) 출력 설명

## 예제 개요

이 예제는 파생상품 포지션의 미래 노출(Exposure)을 Monte Carlo 시뮬레이션으로 계산합니다. 담보가 없는 포지션의 잠재적 손실을 분석합니다.

---

## 핵심 금융 용어

### Exposure (노출)
- **정의**: 미래 특정 시점에 카운터파티가 디폴트할 경우 잠재적 손실액
- **Positive Exposure**: 카운터파티가 빚을 지고 있을 때의 노출
- **Negative Exposure**: 자사가 빚을 지고 있을 때의 노출

### EPE (Expected Positive Exposure)
- **정의**: 미래 노출의 평균 (기대 양의 노출)
- **용도**: CVA 계산, 리스크 한도 설정

### ENE (Expected Negative Exposure)
- **정의**: 미래 음의 노출의 평균 (기대 음의 노출)
- **용도**: DVA 계산

### PFE (Potential Future Exposure)
- **정의**: 특정 신뢰수준에서의 최대 노출 (예: 95% PFE)
- **의미**: 95% 확률로 노출이 이 값을 초과하지 않음

### MPOR (Margin Period of Risk)
- **정의**: 마진 통지 후 디폴트 확인까지의 기간
- **일반적**: 10~20일

---

## 출력 파일 상세 설명

### 1. exposure_trade_Swap_20.csv
**용도**: 스왑 상품별 노출 분석

| 컬럼 | 설명 |
|------|------|
| Date | 날짜 |
| Time | 시간 (년) |
| EPE | 기대 양의 노출 |
| ENE | 기대 음의 노출 |
| PFE (95%) | 95% 신뢰수준 최대 노출 |
| Baseline EPE | 기준 EPE |
| Baseline ENE | 기준 ENE |
| Baseline PFE | 기준 PFE |

**해석 예시**:
```
Date: 2026-03-03
Time: 10년
EPE: 500,000 USD -> 기대 양의 노출
ENE: -200,000 USD -> 기대 음의 노출 (자사 유리)
PFE: 2,500,000 USD -> 95% 확률로 이하
```

---

### 2. exposure_nettingset_CPTY_A.csv
**용도**: 네팅 집합별 노출 분석

| 컬럼 | 설명 |
|------|------|
| Date | 날짜 |
| NettingSet | 네팅 집합 |
| EPE | 기대 양의 노출 |
| ENE | 기대 음의 노출 |
| PFE | 최대 노출 |

---

### 3. cube.csv.gz
**용도**: Monte Carlo 큐브 데이터

- **차원**: [포지션] × [날짜] × [시뮬레이션]
- **압축**: Gzip 형식
- **용도**: 상세 노출 분석

---

### 4. netcube.csv
**용도**: 네팅 후 큐브 데이터

---

### 5. rawcube.csv
**용도**: 원시 큐브 데이터

---

### 6. cva_sensitivity_nettingset_CPTY_A.csv
**용도**: CVA 민감도 분석

---

### 7. colva_nettingset_CPTY_A.csv
**용도**: COLVA (Collateral Valuation Adjustment)

---

### 8. additional_results.csv
**용도**: 추가 분석 결과

---

## 노출 곡선 해석

### 정상적인 스왑 노출
```
EPE
  ↑
  │    ┌───┐
  │   ┌─┘   └─┐
  │  ┌─┘       └─┐
  │ ┌─┘           └─
  │─└───────────────→ Time
  │
  └──→

- 초기: 낮은 노출
- 중기: 최대 노출 (잔존 Notional 감소 전)
- 말기: 0으로 수렴 (만기 도달)
```

---

## 실무 활용

### 1. CVA 계산
```
CVA = LGD × ∫(EE(t) × PD(t)) × DF(t) dt

EE(t): Expected Exposure (EPE)
PD(t): Default Probability
```

### 2. 리스크 한도 설정
- **PFE 기반**: PFE의 2~3배를 한도로 설정
- **EPE 기반**: 평균 노출에 가중치 적용

### 3. 담보 협상
- 노출이 큰 포지션에 담보 요구
- CSA (Credit Support Annex) 협상

### 4. 신용 리스크 프라이싹
- 카운터파티 신용 등급별 가격 차이
-高风险 카운터파티 회피

---

## 실행 방법

```bash
cd /home/keehyun/dev/Engine/Examples/Exposure
ore Input/ore_swap.xml
```

---

## 출력 파일 위치

```
Output/
├── exposure_trade_Swap_20.csv       # 상품별 노출
├── exposure_nettingset_*.csv        # 네팅 집합별 노출
├── cube.csv.gz                      # 시뮬레이션 큐브
├── netcube.csv                      # 네팅 큐브
├── cva_sensitivity_*.csv            # CVA 민감도
├── colva_*.csv                      # 담보 가치 조정
├── npv.csv                          # 순현재가치
└── marketdata.csv                   # 시장 데이터
```

---

## Monte Carlo 시뮬레이션 파라미터

| 파라미터 | 값 | 설명 |
|----------|-----|------|
| Dates | 81 | 시뮬레이션 날짜 수 |
| Samples | 1000 | 시뮬레이션 경로 수 |
| Grid | 1×81×1000 | 큐브 차원 |

---

## 참고 자료

- **ORE User Guide**: 노출 리스크 장
- **Basel III**: Counterparty Credit Risk
- **Gregory, Jon**: "The xVA Challenge"
