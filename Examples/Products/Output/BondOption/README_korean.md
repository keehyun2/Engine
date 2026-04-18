# 본드 옵션 (Bond Option) 출력 설명

## 예제 개요

이 예제는 본드 옵션(Bond Option)의 가치 평가를 보여줍니다. 본드 옵션은 특정 채권을 미리 정해진 가격으로 매수/매도할 수 있는 권리입니다.

---

## 핵심 금융 용어

### Bond Option (본드 옵션)
- **정의**: 특정 채권을 행사가(Strike Price)에 매수할 수 있는 콜 옵션 또는 매도할 수 있는 풋 옵션
- **유형**:
  - **Strike Price**: 행사가로 옵션 행사
  - **Strike Yield**: 수익률(Yield)을 행사가로 사용

### Call Option on Bond (본드 콜 옵션)
- **정의**: 채권을 특정 가격에 매수할 수 있는 권리
- **행사 조건**: 채권 가격 > 행사가

### Yield Strike (수익률 행사가)
- **정의**: 행사가를 가격이 아닌 수익률(YTM)로 지정
- **장점**: 만기와 표면금리가 다른 채권 간 비교 용이

---

## 출력 파일 상세 설명

### 1. npv.csv
**용도**: 본드 옵션의 순현재가치

| 컬럼 | 값 | 설명 |
|------|-----|------|
| Bond_Call_Option_StrikePrice | 14,309 EUR | 행사가 기반 옵션 가치 |
| Bond_Call_Option_YieldStrike | 377,118 EUR | 수익률 행사가 기반 옵션 가치 |

**해석**:
- 두 옵션의 기초 자산은 동일한 채권 (2029-05-15 만기, 1천만 EUR 명목)
- 수익률 행사가 방식이 더 높은 가치 → 더 공격적인 행사가 설정

---

### 2. additional_results.csv
**용도**: 추가 분석 결과

- 내포변동성 (Implied Volatility)
- 델타 (Delta): 기초 채권 가격 변화에 대한 옵션 가치 변화
- 감마 (Gamma): 델타의 변화율
- 베가 (Vega): 변동성 변화에 대한 옵션 가치 변화

---

### 3. marketdata.csv
**용도**: 사용된 시장 데이터

- 금리 곡선 (Discount Curve)
- 변동성 표면 (Volatility Surface)
- 채권 가격

---

## 본드 옵션 가치 평가 요소

### 1. 기초 자산 가격
- 채권의 현재 가격이 행사가보다 높을수록 콜 옵션 가치 ↑

### 2. 변동성
- 채권 가격 변동성이 높을수록 옵션 가치 ↑

### 3. 만기
- 옵션 만기가 길수록 가치 ↑ (시간 가치)

### 4. 금리
- 금리 수준과 채권 가치의 관계

---

## Strike Price vs Strike Yield

| 구분 | Strike Price | Strike Yield |
|------|--------------|--------------|
| 행사가 단위 | 가격 (예: 102%) | 수익률 (예: 3.5%) |
| 장점 | 직관적 | 만기/표면금리 다른 채권 비교 용이 |
| 일반적 사용 | 단일 채권 옵션 | 채권 옵션 선물 |

---

## 실행 방법

```bash
cd /home/keehyun/dev/Engine/Examples/Products

# 개별 상품 실행
python3 build_portfolio.py --n 0  # BondOption
ore Input/ore.xml
```

---

## 출력 파일 위치

```
Output/
├── npv.csv                           # 옵션 가치
├── additional_results.csv            # 그리스 값
├── marketdata.csv                    # 시장 데이터
└── log.txt                           # 실행 로그
```

---

## 참고 자료

- **ORE User Guide**: 본드 옵션 장
- **Hull, John**: "Options, Futures, and Other Derivatives" - 본드 옵션 장
