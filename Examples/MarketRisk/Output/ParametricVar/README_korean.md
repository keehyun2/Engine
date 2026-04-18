# 파라메트릭 VaR (Parametric Value at Risk) 출력 설명

## 예제 개요

이 예제는 파라메트릭 VaR(Value at Risk) 계산을 보여줍니다. VaR은 주어진 신뢰수준에서 특정 기간 동안 발생할 수 있는 최대 손실금액을 추정합니다.

---

## 핵심 금융 용어

### VaR (Value at Risk, 위험가치)
- **정의**: 특정 신뢰수준(예: 95%, 99%)에서 특정 기간 동안 초과손실이 발생하지 않을 최대 손실금액
- **예시**: "1일 95% VaR이 100만 원" = 내일 95% 확률로 100만 원 이상의 손실은 발생하지 않음
- **소프트웨어적 비유**: 시스템 장애가 발생할 확률이 5% 미만인 최대 장애 크기

### Parametric VaR
- **방식**: 수학적 공식을 사용하여 VaR 계산
- **가정**: 수익률이 정규분포를 따른다고 가정
- **장점**: 계산이 빠름
- **단점**: 꼬리 리스크(Fat Tail)를 과소평가할 수 있음

### Confidence Level (신뢰수준)
- 95%: 20일 중 19일은 VaR을 초과하는 손실이 발생하지 않음
- 99%: 100일 중 99일은 VaR을 초과하는 손실이 발생하지 않음

---

## 출력 파일 상세 설명

### 1. var.csv
**용도**: VaR 계산 결과

| 컬럼 | 설명 |
|------|------|
| Portfolio | 포트폴리오 식별자 |
| RiskClass | 리스크 클래스 (InterestRate, FX, Equity 등) |
| RiskFactor | 리스크 요인 |
| VarLevel | VaR 신뢰수준 (95, 97.5, 99 등) |
| Var | VaR 값 |
| ExpectedShortfall | 기대손실(ES) 값 |
| DeltaGamma | 델타-감마 보정 VaR |
| DeltaGammaES | 델타-감마 보정 ES |

**해석 예시**:
```
Portfolio: Portfolio1
RiskClass: InterestRate
VarLevel: 95
Var: 1,234,567 USD
ExpectedShortfall: 1,567,890 USD
```
- 95% 신뢰수준에서 1일 최대 손실은 약 123만 USD
- 5% 최악 경우 평균 손실(ES)은 약 157만 USD

---

### 2. curves.csv
**용도**: 이자율 곡선 데이터

---

### 3. flows.csv
**용도**: 각 상품별 현금흐름

---

### 4. marketdata.csv
**용도**: 사용된 시장 데이터 요약

---

## 실무 활용

### 1. 리스크 한도 설정
- **예**: "일일 VaR이 100만 USD를 초과하면 포지션 축소"

### 2. 자본적정성 규제
- **바젤 III**: 시장리스크 자본요구금액 계산에 VaR 사용

### 3. 성과 평가
- **리스크 조정 수익률**: 수익 / VaR

### 4. 스탬포(Sigma) 기반 트레이딩
- 리스크 단위당 수익률이 높은 전략 선택

---

## VaR 해석 시 주의사항

### 1. 가정의 한계
- 정규분포 가정이 실제 시장과 다를 수 있음
- 극단적인 시장 상황(사건 리스크)을 포착하지 못할 수 있음

### 2. 역사적 데이터 의존성
- 과거 데이터가 미래를 보장하지 않음

### 3. 백테스팅 필요
- 실제 손실이 VaR을 초과하는 빈도 확인
- 모델이 적절한지 검증 필요

---

## 실행 방법

```bash
cd /home/keehyun/dev/Engine/Examples/MarketRisk
ore Input/ore_parametricvar.xml
```

---

## 출력 파일 위치

```
Output/ParametricVar/
├── var.csv                   # 핵심 VaR 결과
├── npv.csv                   # 순현재가치
├── curves.csv                # 이자율 곡선
├── flows.csv                 # 현금흐름
├── marketdata.csv            # 시장 데이터
└── log.txt                   # 실행 로그
```

---

## VaR vs 다른 리스크 측정

| 측정 방법 | 장점 | 단점 |
|----------|------|------|
| Parametric VaR | 계산 빠름 | 정규분포 가정 |
| Historical VaR | 비모수적 | 과거 데이터 의존 |
| Monte Carlo VaR | 유연함 | 계산 오래 걸림 |
| Expected Shortfall | 꼬리 리스크 고려 | 계산 복잡 |

---

## 참고 자료

- **ORE User Guide**: VaR 계산 장
- **Jorion, Philippe**: "Value at Risk: The New Benchmark for Managing Financial Risk"
- **Basel Committee**: "Minimum Capital Requirements for Market Risk"
