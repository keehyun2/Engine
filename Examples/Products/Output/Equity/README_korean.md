# 주식 디지털 옵션 (Equity Digital Option) 출력 설명

## 예제 개요

이 예제는 주식 디지털 옵션(Equity Digital Option)의 가치 평가를 보여줍니다.

---

## 핵심 금융 용어

### Digital Option (디지털 옵션)
- **정의**: 기초 자산 가격이 특정 조건을 충족하면 고정 금액을 지급하는 옵션
- **특징**: 전혀(All-or-Nothing) 페이오프
- **유형**:
  - **Cash-or-Nothing**: 조건 충족 시 현금 지급
  - **Asset-or-Nothing**: 조건 충족 시 기초 자산 지급

### Equity Digital Option
- **기초 자산**: 주식 또는 주식 지수
- **페이오프**: 조건 충족 시 고정 금액 (Payoff Amount)
- **가치 평가 모델**: Black-Scholes-Merton

---

## 출력 파일 상세 설명

### 1. npv.csv
**용도**: 디지털 옵션의 순현재가치

| 컬럼 | 값 | 설명 |
|------|-----|------|
| TradeId | EQDigitalOption | 옵션 식별자 |
| TradeType | EquityDigitalOption | 상품 타입 |
| Maturity | 2026-07-17 | 만기일 |
| NPV | 878,828 USD | 옵션 가치 |
| Notional | 1,000 USD | 지급 금액 |

**해석**:
- 1,000 USD 지급 조건부 옵션
- 현재 가치는 약 878,828 USD (조건 충족 확률이 높음)
- 약 878:1의 레버리지

---

### 2. additional_results.csv
**용도**: 추가 분석 결과

| 키 | 값 | 설명 |
|----|-----|------|
| PricingConfigEngine | AnalyticEuropeanEngine | 해석적 엔진 |
| PricingConfigModel | BlackScholesMerton | BSM 모델 |
| payoffAmount | 1,000 USD | 페이오프 금액 |
| payoffCurrency | USD | 페이오프 통화 |
| isdaAssetClass | Equity | ISDA 자산 클래스 |

---

## 디지털 옵션 vs 일반 옵션

| 구분 | 디지털 옵션 | 일반 옵션 (Vanilla) |
|------|-------------|---------------------|
| 페이오프 | 고정 금액 | 기초 자산 가격 - 행사가 |
| 그리스 | 이분적 | 부드러운 변화 |
| 델타 | 불연속 | 연속 |
| 용도 | 특정 시나리오 베팅 | 일반 헷징/투기 |

---

## 가치 평가 요소

### 1. 조건 충족 확률
- 기초 자산이 행사가를 초과할 확률
- 변동성 ↑ → 확률 ↑
- 만기 ↑ → 확률 변동

### 2. 페이오프 금액
- 조건 충족 시 지급되는 고정 금액

### 3. 할인율
- 미래 가치를 현재가치로 할인

---

## 실무 활용

### 1. 구조화 상품
- 베어러런스 인증서 (Bear Certificates)
- 투자 증권의 내장 옵션

### 2. 특정 시나리오 베팅
- "S&P 500이 3,000을 넘으면 1만 원 지급"

### 3. 이진 옵션 (Binary Options)
- 단기 트레이딩
- 고위험 고수익

---

## 실행 방법

```bash
cd /home/keehyun/dev/Engine/Examples/Products
python3 build_portfolio.py --n 30  # Equity Digital Option
ore Input/ore.xml
```

---

## 출력 파일 위치

```
Output/
├── npv.csv                           # 옵션 가치
├── additional_results.csv            # 모델 정보
└── marketdata.csv                    # 시장 데이터
```

---

## 참고 자료

- **ORE User Guide**: 주식 옵션 장
- **Hull, John**: "Options, Futures, and Other Derivatives" - 디지털 옵션 장
