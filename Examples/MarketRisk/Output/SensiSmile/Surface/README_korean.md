# 변동성 표면 민감도 (Volatility Surface Sensitivity) 출력 설명

## 예제 개요

이 예제는 변동성 표면(Volatility Surface) 전체에 대한 민감도를 분석합니다. ATM뿐만 아니라 ITM/OTM을 포함한 전체 행사가 구조를 분석합니다.

---

## 핵심 금융 용어

### Volatility Surface (변동성 표면)
- **정의**: 행사가(Strike)와 만기(Maturity)에 따른 변동성을 3차원으로 표현
- **축**: X축=Strike, Y축=Maturity, Z축=Implied Volatility
- **용도**: 모든 옵션 가치평가 기초

### Surface Sensitivity
- **Strike Sensitivity**: 행사가별 변동성 민감도
- **Term Sensitivity**: 만기별 변동성 민감도
- **Skew**: 행사가에 따른 변동성 기울기
- **Term Structure**: 만기에 따른 변동성 구조

---

## 출력 파일 상세 설명

### 1. curves_fullSurface.csv
**용도**: 전체 표면 곡선 데이터

---

### 2. npv_fullSurface.csv
**용도**: 전체 표면 NPV 데이터

---

### 3. flows_fullSurface.csv
**용도**: 전체 표면 현금흐름

---

## ATM vs Full Surface

| 구분 | ATM | Full Surface |
|------|-----|--------------|
| 행사가 | 하나만 | 전체 범위 |
| 용도 | 일반적 가치평가 | 정밀 헷징 |
| 계산량 | 적음 | 많음 |

---

## 실행 방법

```bash
cd /home/keehyun/dev/Engine/Examples/MarketRisk
ore Input/ore_sensismile_surface.xml
```

---

## 출력 파일 위치

```
Output/SensiSmile/Surface/
├── curves_fullSurface.csv         # 전체 표면 곡선
├── npv_fullSurface.csv            # 전체 표면 NPV
├── flows_fullSurface.csv          # 전체 표면 현금흐름
└── marketdata.csv                 # 시장 데이터
```

---

## 참고 자료

- **ORE User Guide**: 변동성 표면 장
