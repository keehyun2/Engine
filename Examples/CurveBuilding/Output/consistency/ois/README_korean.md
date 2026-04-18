# OIS 일관성 검증 예제 설명 (Consistency OIS)

## 예제 개요

이 예제는 OIS(Overnight Index Swap) 곡선 구축의 **정확성을 검증**합니다.

### 일관성(Consistency)이란?

**정의**: 구축된 곡선이 입력 시장 데이터를 정확히 재현하는지 확인

**검증 방법**:
1. 시장 데이터로 OIS 곡선 구축 (부트스트래핑)
2. 동일한 곡선으로 OIS 상품 재가격
3. **NPV = 0**이면 일관성 있음 (정확히 재현)

### NPV가 0인 이유

```
구축된 곡선 → OIS 재가격
     ↓
NPV = 고정금리 PV - 변동금리 PV
     ↓
시장 데이터에서 금리 추출했으므로
NPV = 0 (at-par, 액면가 거래)
```

---

## 포트폴리오 구성

### 상품 유형

| 상품 유형 | 통화 | 설명 |
|-----------|------|------|
| BasisSwap | GBP | 6M vs 3M 베이시스 스왑 |
| FRA | CHF | 선도 금리 계약 (FRA) |
| OIS | EUR, USD, GBP, CHF | 익일 인덱스 스왑 |
| Swap | 다양 | 일반 금리 스왑 |

### 총 상품 수

- **BasisSwap (GBP)**: 18개 (1Y ~ 70Y)
- **FRA (CHF)**: 18개
- **OIS**: 다수
- **기타 스왑**: 다수

---

## 출력 파일 분석

### 1. npv.csv (순현재가치)

```csv
#TradeId,TradeType,Maturity,NPV
BasisSwap_6M_3M_GBP_10Y,Swap,2026-02-05,0.000000
BasisSwap_6M_3M_GBP_20Y,Swap,2036-02-05,0.000000
FRA_CHF_1M_6M,ForwardRateAgreement,2016-09-09,0.000000
```

**해석**:
- 모든 NPV = **0.000000**
- **일관성 검증 통과!**
- 곡선이 시장 데이터를 정확히 재현

**소수점 오차**:
```
실제로는 0이 아니지만 매우 작은 값:
- ±1e-10 수준
- 부동소수점 정밀도 한계
- 무시해도 될 수준
```

### 2. todaysmarketcalibration.csv (보정 결과)

각 곡선별 보정 성공 여부:

| 곡선 | 상태 | 설명 |
|------|------|------|
| EUR-EONIA | Success | EUR OIS 곡선 구축 성공 |
| EUR-EURIBOR-6M | Success | EUR 6M 곡선 구축 성공 |
| USD-FedFunds | Success | USD OIS 곡선 구축 성공 |
| GBP-SONIA | Success | GBP OIS 곡선 구축 성공 |
| CHF-SARON | Success | CHF OIS 곡선 구축 성공 |

### 3. curves.csv (이자율 곡선)

400일(1D 간격)에 대한 할인율:

| Tenor | Date | EUR-EONIA | USD-FedFunds | GBP-SONIA |
|-------|------|-----------|--------------|-----------|
| 1D | 2016-02-06 | 0.99999 | 0.99998 | 0.99999 |
| 1M | 2016-03-05 | 0.99961 | 0.99958 | 0.99962 |
| 1Y | 2017-02-06 | 0.99600 | 0.99612 | 0.99605 |
| 5Y | 2021-02-08 | 0.94327 | 0.94305 | 0.94315 |

**해석**:
- 단기 할인율이 1에 가까움 (낮은 금리)
- 장기로 갈수록 할인율 감소
- 통화별로 유사한 수준

---

## 핵심 개념

### 1. 부트스트래핑(Bootstrapping) 검증

**과정**:
```
1. 시장 데이터 수집
   └─ OIS 금리 (1M, 3M, 6M, 1Y, 2Y, ...)

2. 곡선 구축
   └─ 단기 → 장기 순으로 할인율 계산

3. 재가격 테스트
   └─ 구축된 곡선으로 OIS 재가격

4. 일관성 확인
   └─ NPV ≈ 0 이면 성공
```

### 2. 왜 NPV가 0이어야 하는가?

**이론적 근거**:
```
시장 OIS 금리 = f(할인율 곡선)
              ↓
   같은 곡선으로 재가격하면
              ↓
   동일한 금리 도출
              ↓
   NPV = 0 (at-par)
```

**만약 NPV ≠ 0 이면?**
- 곡선 구축 오류
- 보간 방법 문제
- 컨벤션 불일치

### 3. 다양한 통화 검증

| 통화 | OIS 인덱스 | 특징 |
|------|-----------|------|
| EUR | EONIA | 유로존 익일 평균 |
| USD | FedFunds | 연방기금 금리 |
| GBP | SONIA | 파운드 익일 평균 |
| CHF | SARON | 스위스 프랑 익일 평균 |

---

## 검증 항목

### 1. 곡선 부트스트래핑
- [x] 단기(1D~1M) 정확성
- [x] 중기(1Y~5Y) 정확성
- [x] 장기(5Y+) 정확성

### 2. 재가격 정확도
- [x] BasisSwap NPV ≈ 0
- [x] FRA NPV ≈ 0
- [x] OIS NPV ≈ 0

### 3. 통화별 일관성
- [x] EUR EONIA
- [x] USD FedFunds
- [x] GBP SONIA
- [x] CHF SARON

---

## 실무 활용

### 1. 곡선 검증 절차

```python
def verify_curve_consistency():
    # 1. 곡선 구축
    curve = bootstrap_curve(market_data)

    # 2. 재가격
    npv = reprice_swap(curve, original_swap)

    # 3. 검증
    if abs(npv) < tolerance:
        return "PASS"
    else:
        return "FAIL"
```

### 2. 일반적인 오류 원인

| 원인 | 증상 | 해결 |
|------|------|------|
| 보간 방법 | NPV ≠ 0 | LogLinear 확인 |
| 컨벤션 불일치 | NPV ≠ 0 | DayCounter 확인 |
| 날짜 계산 | NPV ≠ 0 | Calendar 확인 |

### 3. 허용 오차 (Tolerance)

```
일반적인 허용 오차:
- 절대값: 1e-6 (0.000001)
- 상대값: 1e-8 (0.000001%)
- ORE 결과: 대부분 1e-10 이하
```

---

## 요약

### ✅ 검증 결과

- **총 상품 수**: 100+ 개
- **NPV = 0**: 모든 상품 (1e-10 이내)
- **결론**: OIS 곡선 구축 **정확함**

### 📊 주요 발견

1. **단기 곡선**: 매우 정확 (NPV ≈ 0)
2. **장기 곡선**: 정확성 유지
3. **다통화 검증**: 모든 통화에서 일관성 확인

### 🎓 학습 포인트

- OIS 곡선 구축 원리 이해
- 재가격을 통한 검증 방법
- 다양한 통화의 OIS 인덱스 특징

---

## 참고 자료

- **ORE User Guide**: CurveBuilding 섹션
- **QuantLib**: Bootstrap tutorial
- **ISDA**: OIS Market Conventions
