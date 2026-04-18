# 변동성 스마일 민감도 (Volatility Smile Sensitivity) 출력 설명

## 예제 개요

이 예제는 변동성 스마일(Volatility Smile)에 대한 민감도 분석을 수행합니다. 옵션의 변동성이 행사가(Strike Price)에 따라 어떻게 변하는지 분석합니다.

---

## 핵심 금융 용어

### Volatility Smile (변동성 스마일)
- **정의**: 옵션의 암시적 변동성(Implied Volatility)이 행사가(Strike Price)에 따라 U자형을 그리는 현상
- **원인**: 시장이 정규분포보다 극단적인 움직임(Fat Tail)을 더 크게 반영
- **예시**: 2008 금융위기 이후 주식 옵션의 "레버리지 스마일" 현상

### ATM (At-The-Money)
- **정의**: 행사가가 현재 기초 자산 가격과 같은 옵션
- **ITM (In-The-Money)**: 행사가가 현재 가격보다 낮은 콜 옵션 (이미 돈이 되는 옵션)
- **OTM (Out-The-Money)**: 행사가가 현재 가격보다 높은 콜 옵션 (아직 돈이 안 되는 옵션)

### Implied Volatility (암시적 변동성)
- **정의**: 옵션 시장 가격에서 역산한 변동성
- **용도**: 시장의 불확실성 기대치 척도

### Vanna
- **정의**: 변동성이 변할 때 델타(Delta)의 변화
- **공식**: ∂Delta / ∂Volatility

### Volga (Volatility Gamma)
- **정의**: 변동성이 변할 때 베가(Vega)의 변화
- **공식**: ∂Vega / ∂Volatility

---

## 출력 파일 상세 설명

### 1. sensitivity_atmOnly.csv
**용도**: ATM 옵션에 대한 민감도 분석

| 컬럼 | 설명 |
|------|------|
| TradeId | 상품 식별자 |
| OptionType | 옵션 유형 (Call/Put) |
| Strike | 행사가 |
| Maturity | 만기 |
| Delta | 델타 값 |
| Gamma | 감마 값 |
| Vega | 베가 값 (변동성 민감도) |
| Vanna | 변동성 변화 시 델타 변화 |
| Volga | 변동성 변화 시 베가 변화 |

**해석 예시**:
```
TradeId: EURUSD_Option_1Y
Strike: 1.1000 (ATM)
Delta: 0.52
Vega: 0.0580
Vanna: -0.15
Volga: 0.23
```
- EUR/USD 1년 만기 ATM 옵션
- 변동성 1% 상승 시 옵션 가격 5.8bp 상승 (Vega)
- 변동성 상승 시 델타 감소 (Vanna 음수)

---

### 2. curves_atmOnly.csv
**용도**: ATM 기반 곡선 데이터

---

### 3. npv_atmOnly.csv
**용도**: ATM 옵션 순현재가치

---

### 4. flows_atmOnly.csv
**용도**: ATM 옵션 현금흐름

---

### 5. sensitivity_config.csv
**용도**: 민감도 분석 설정

- 어떤 행사가(Strike) 범위를 분석할지
- 변동성 시프트 크기

---

### 6. scenario.csv
**용도**: 변동성 스마일 시나리오 데이터

---

## 실무 활용

### 1. 변동성 스마일 거래
- **Risk Reversal**: OTM 콜 매수 + OTM 풋 매도 (스마일 기울기 베팅)
- **Butterfly**: ATM 매수 + OTM/ITM 매도 (스마일 곡률 베팅)

### 2. 변동성 헷징
- **Vega Hedging**: 변동성 리스크 관리
- **Vanna Hedging**: 변동성-기초자산 상호 헷징

### 3. 마켓 메이킹
- 옵션 호가 시 변동성 스마일 고려
- ATM 옵션의 유동성이 가장 높음

---

## 변동성 스마일 패턴

| 시장 유형 | 스마일 패턴 | 원인 |
|----------|-------------|------|
| 주식 옵션 | 레버리지 스마일 (OTM 풋 변동성 > ATM > ITM) | 주가 폭락 리스크 |
| 외환 옵션 | 대칭적 스마일 | 양방향 변동성 |
| 상품 옵션 | 역 스마일 (ITM 변동성 > OTM) | 공급 제약 |

---

## 실행 방법

```bash
cd /home/keehyun/dev/Engine/Examples/MarketRisk
ore Input/ore_sensismile_atm.xml
```

---

## 출력 파일 위치

```
Output/SensiSmile/Atm/
├── sensitivity_atmOnly.csv        # 핵심 민감도 결과
├── curves_atmOnly.csv             # ATM 곡선
├── npv_atmOnly.csv                # 순현재가치
├── flows_atmOnly.csv              # 현금흐름
├── sensitivity_config.csv         # 분석 설정
├── scenario.csv                   # 시나리오 데이터
└── log.txt                        # 실행 로그
```

---

## 변동성 스마일 관련 그리스 (Greeks)

| 그리스 | 정의 | 헷징 용도 |
|--------|------|----------|
| Delta | 기초자산 변동 민감도 | 주가 헷징 |
| Gamma | Delta 변화율 | 대형 Delta 헷징 |
| Vega | 변동성 민감도 | 변동성 헷징 |
| Vanna | 변동성 변화 시 Delta | 변동성-가격 헷징 |
| Volga | 변동성 변화 시 Vega | 변동성 변동성 헷징 |

---

## 참고 자료

- **ORE User Guide**: 변동성 스마일 장
- **Gatheral, Jim**: "The Volatility Surface" - 변동성 스마일 이론
- **Hull, John**: "Options, Futures, and Other Derivatives" - 옵션 그리스 장
