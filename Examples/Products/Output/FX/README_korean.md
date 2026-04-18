# FX 더블 배리어 옵션 (FX Double Barrier Option) 출력 설명

## 예제 개요

이 예제는 FX 더블 배리어 옵션(FX Double Barrier Option)의 가치 평가를 보여줍니다.

---

## 핵심 금융 용어

### Barrier Option (배리어 옵션)
- **정의**: 기초 자산 가격이 특정 수준(Barrier)에 도달 여부에 따라 페이오프가 결정되는 옵션
- **유형**:
  - **Knock-In**: 배리어 도격 시 옵션 활성화
  - **Knock-Out**: 배리어 도격 시 옵션 소멸

### Double Barrier Option (더블 배리어 옵션)
- **정의**: 상단 배리어(Upper Barrier)와 하단 배리어(Lower Barrier)가 모두 있는 옵션
- **구조**: 두 배리어 사이에서 유효

### FX Barrier Option
- **기초 자산**: 환율 (예: EUR/USD)
- **배리어**: 특정 환율 수준

---

## 출력 파일 상세 설명

### 1. npv.csv
**용도**: 더블 배리어 옵션의 순현재가치

| 컬럼 | 값 | 설명 |
|------|-----|------|
| TradeId | FX_DOUBLE_BARRIER_OPTION | 옵션 식별자 |
| TradeType | FxDoubleBarrierOption | 상품 타입 |
| Maturity | 2031-09-15 | 만기일 |
| NPV | 536 USD | 옵션 가치 |
| Notional | 1,100,000 USD | 명목 금액 |

**해석**:
- 2031년 만기의 장기 옵션
- 명목 대비 낮은 가치 (536 USD / 1.1M USD ≈ 0.05%)
- 배리어 조건이 까다로울수록 가치 ↓

---

## 배리어 옵션 유형

### Double Knock-In
- 두 배리어 중 하나라도 도격하면 옵션 활성화

### Double Knock-Out
- 두 배리어 중 하나라도 도격하면 옵션 소멸
- 배리어 내에서만 유효

### Double One-Touch
- 두 배리어 중 하나에 도격하면 즉시 페이오프

---

## 가치 평가 요소

### 1. 배리어 수준
- 배리어가 현재 환율에 가까울수록 도격 확률 ↑
- Knock-Out: 가치 ↓
- Knock-In: 가치 ↑

### 2. 변동성
- 변동성 ↑ → 배리어 도격 확률 ↑

### 3. 만기
- 만기가 길수록 배리어 도격 확률 ↑

### 4. 환율 추이
- 현재 환율의 위치 (상단/하단 배리어 근접도)

---

## 일반 옵션 vs 배리어 옵션

| 구분 | 일반 옵션 | 배리어 옵션 |
|------|----------|------------|
| 조건 | 만기 시 기초 자산 가격 | 배리어 도격 여부 + 만기 가격 |
| 가치 | 더 높음 | 더 낮음 (조건이 더 엄격) |
| 프리미엄 | 비쌈 | 저렴 |
| 용도 | 일반 헷징 | 특정 시나리오 커버 |

---

## 실무 활용

### 1. 환 리스크 헷징
- "환율이 일정 범위를 벗어나면 보호"
- "환율이 특정 범위 내에서만 옵션 유효"

### 2. 구조화 상품
- FX 투자 증권의 내장 옵션
- Dual Currency Investments

### 3. 기업 헷징
- 수출/기업의 환율 범위 헷징
- 특정 환율 수준 보호

---

## 실행 방법

```bash
cd /home/keehyun/dev/Engine/Examples/Products
python3 build_portfolio.py --n 62  # FX Double Barrier Option
ore Input/ore.xml
```

---

## 출력 파일 위치

```
Output/
├── npv.csv                           # 옵션 가치
├── additional_results.csv            # 배리어 정보
└── marketdata.csv                    # 시장 데이터
```

---

## 참고 자료

- **ORE User Guide**: FX 배리어 옵션 장
- **Hull, John**: "Options, Futures, and Other Derivatives" - 배리어 옵션 장
- **Wilmott, Paul**: "Paul Wilmott on Quantitative Finance" - 이종 옵션 장
