# 역사적 시뮬레이션 VaR (Historical Simulation VaR) 출력 설명

## 예제 개요

이 예제는 역사적 시뮬레이션 방식으로 VaR(Value at Risk)를 계산합니다. 과거 시장 데이터를 사용하여 미래 손실 분포를 추정합니다.

---

## 핵심 금융 용어

### Historical Simulation VaR
- **방식**: 과거 실제 시장 변동성을 사용하여 VaR 계산
- **장점**: 정규분포 가정이 필요 없음, 꼬리 리스크(Fat Tail) 포착 가능
- **단점**: 과거 데이터에 의존, 미래의 새로운 리스크 포착 어려움

### Historical PnL (Historical Profit & Loss)
- **정의**: 과거 시나리오를 적용했을 때의 수익/손실 시뮬레이션
- **용도**: VaR 백테스팅, 리스크 모델 검증

---

## 출력 파일 상세 설명

### 1. var.csv
**용도**: 역사적 시뮬레이션 VaR 결과

| 컬럼 | 설명 |
|------|------|
| Portfolio | 포트폴리오 식별자 |
| VarLevel | VaR 신뢰수준 (95, 97.5, 99 등) |
| Var | VaR 값 |
| ExpectedShortfall | 기대손실(ES) 값 |
| HistoricalDays | 사용된 역사적 데이터 일수 |

**해석 예시**:
```
Portfolio: Portfolio1
VarLevel: 95
Var: 987,654 USD
HistoricalDays: 250
```
- 과거 250일 데이터 기반 95% VaR은 약 98만 USD

---

### 2. historical_PnL.csv
**용도**: 역사적 시나리오별 PnL 시뮬레이션 결과

| 컬럼 | 설명 |
|------|------|
| Date | 역사적 날짜 |
| Portfolio | 포트폴리오 |
| PnL | 해당 시나리오에서의 PnL |
| ScenarioType | 시나리오 유형 |

**해석 예시**:
```
Date: 2023-01-15
PnL: -1,234,567 USD
```
- 2023년 1월 15일의 시장 변동이 적용되면 123만 USD 손실

---

### 3. marketdata.csv
**용도**: 사용된 시장 데이터

---

### 4. todaysmarketcalibration.csv
**용도**: 오늘 날짜의 시장 보정 결과

---

## 실무 활용

### 1. VaR 백테스팅
- **Kupiec Test**: VaR 모델의 적합성 검정
- **Christoffersen Test**: 예측력과 독립성 검정

### 2. 리스크 모델 선택
- Parametric VaR vs Historical VaR 비교
- 상황에 맞는 최적 방식 선택

### 3. 스트레스 시나리오 선정
- 역사적 큰 충격(2008 금융위기 등) 식별

---

## 실행 방법

```bash
cd /home/keehyun/dev/Engine/Examples/MarketRisk
ore Input/ore_histsimvar.xml
```

---

## VaR 방식 비교

| 방식 | 장점 | 단점 | 사용 시점 |
|------|------|------|----------|
| Parametric VaR | 계산 빠름 | 정규분포 가정 | 일일 리스크 |
| Historical VaR | 비모수적, 꼬리 리스크 포착 | 과거 의존 | 규제 보고 |
| Monte Carlo VaR | 유연함 | 계산 느림 | 복잡 상품 |

---

## 출력 파일 위치

```
Output/HistSimVar/
├── var.csv                   # VaR 결과
├── historical_PnL.csv        # 역사적 PnL 시뮬레이션
├── marketdata.csv            # 시장 데이터
└── log.txt                   # 실행 로그
```

---

## 참고 자료

- **ORE User Guide**: 역사적 시뮬레이션 장
- **Basel Committee**: "Fundamental Review of the Trading Book"
