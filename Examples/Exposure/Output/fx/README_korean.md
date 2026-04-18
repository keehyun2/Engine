# FX 파생상품 노출 분석 (FX Derivatives Exposure) 출력 설명

## 예제 개요

이 예제는 FX 파생상품(옵션, 선물)의 미래 노출을 Monte Carlo 시뮬레이션으로 계산합니다.

---

## 핵심 금융 용어

### FX Exposure (외환 노출)
- **정의**: 외환 파생상품의 미래 노출
- **특징**: 환율 변동성에 민감
- **주요 리스크**:
  - 환율 방향성 리스크
  - 변동성 리스크
  - 이자율 차이 리스크

### FX Option Exposure
- **Call Option**: 기초 자산 가격 상승 시 노출 ↑
- **Put Option**: 기초 자산 가격 하락 시 노출 ↑

### FX Forward Exposure
- **선물 환율과 현물 환율 차이
- 이자율 평가(Interest Rate Parity)에 따른 노출

---

## 출력 파일 상세 설명

### 1. exposure_trade_FX_CALL_OPTION_EURUSD_10Y.csv
**용도**: EUR/USD 콜 옵션 노출

| 컬럼 | 설명 |
|------|------|
| Date | 날짜 |
| EPE | 기대 양의 노출 |
| ENE | 기대 음의 노출 |
| PFE (95%) | 최대 노출 |

**해석 예시**:
```
EUR/USD Call Option
- EUR 강세(EUR/USD 상승) 시 노출 증가
- 만기 근처에서 노출 최대
```

---

### 2. exposure_trade_FX_PUT_OPTION_EURUSD_10Y.csv
**용도**: EUR/USD 풋 옵션 노출

- EUR 약세(EUR/USD 하락) 시 노출 증가

---

### 3. exposure_trade_FXFWD_EURUSD_10Y.csv
**용도**: EUR/USD 선물 노출

---

### 4. exposure_nettingset_CPTY_A.csv
**용도**: 네팅 집합 전체 노출

---

## FX 옵션 노출 특징

### Call Option 노출
```
EPE
  ↑
  │        ┌───
  │       ┌─┘
  │      ┌─┘
  │   ┌──┘
  │ ──┘───────→ Time
  │
  └──→

- 만기에 가까울수록 노출 ↑
- 환율 상승 시 실제 노출 ↑
```

### Put Option 노출
```
EPE
  ↑
  │   ┌──────
  │  ┌┘
  │ ┌┘
  │─┘
  └──────────→ Time

- 만기에 가까울수록 노출 ↑
- 환율 하락 시 실제 노출 ↑
```

---

## FX 선물 노출 특징

### Forward Point
```
Forward Rate = Spot × (1 + r_dom) / (1 + r_for)

Foward Point = Forward Rate - Spot Rate
```

- Forward Point = 시장 기대치
- 현물 환율이 선물 환율과 다르면 노출 발생

---

## 실무 활용

### 1. FX 헷징
- **Natural Hedge**: 반대 방향 포지션
- **FX Forward**: 확정 환율 헷징
- **FX Option**: 선택권 헷징

### 2. 한도 설정
- **FX Option**: 옵션 프리미� + PFE
- **FX Forward**: 전체 노출

### 3. CVA 계산
```
FX CVA = LGD × ∫(EE_FX(t) × PD(t)) × DF(t) dt
```

---

## 실행 방법

```bash
cd /home/keehyun/dev/Engine/Examples/Exposure
ore Input/ore_fx.xml
```

---

## 출력 파일 위치

```
Output/fx/
├── exposure_trade_FX_CALL_OPTION_*.csv   # 콜 옵션 노출
├── exposure_trade_FX_PUT_OPTION_*.csv    # 풋 옵션 노출
├── exposure_trade_FXFWD_*.csv            # 선물 노출
├── exposure_nettingset_*.csv             # 네팅 노출
└── cube.csv.gz                           # 시뮬레이션 큐브
```

---

## FX 리스크 요인

| 요인 | 영향 | 헷징 |
|------|------|------|
| 환율 | 방향성 리스크 | 반대 포지션 |
| 변동성 | 옵션 가치 | Vega 헷징 |
| 금리 차이 | Forward | FX Swap |
| 상관관계 | 크로스 통화 | 다각화 |

---

## 참고 자료

- **ORE User Guide**: FX 노출 장
- **Wystup, Uwe**: "FX Options and Structured Products"
