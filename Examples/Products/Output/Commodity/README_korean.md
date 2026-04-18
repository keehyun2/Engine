# 상품 옵션 (Commodity Option) 출력 설명

## 예제 개요

이 예제는 상품 옵션(Commodity Option)의 가치 평가를 보여줍니다. 상품 옵션은 원자재(석유, 금, 구리 등)를 기초 자산으로 하는 옵션입니다.

---

## 핵심 금융 용어

### Commodity Option (상품 옵션)
- **정의**: 원자재를 기초 자산으로 하는 옵션
- **기초 자산**: 석유(WTI, Brent), 금, 은, 구리, 천연가스, 농산물 등
- **거래소**: NYMEX, LME, CME 등

### 상품 옵션 특징
- **계약 단위**: 거래소별 상이 (예: NYMEX 원유 1,000배럴)
- **결제 방식**: 현금 결제 또는 인도 결제
- **계약월**: 특정 월에 인도 (F1, F2, ...)

---

## 출력 파일 상세 설명

### 1. npv.csv
**용도**: 상품 옵션의 순현재가치

| 컬럼 | 값 | 설명 |
|------|-----|------|
| TradeId | CommodityOption | 옵션 식별자 |
| TradeType | CommodityOption | 상품 타입 |
| Maturity | 2026-04-19 | 만기일 |
| NPV | -4,269,790 USD | 옵션 가치 (음수 = 매도 포지션) |
| Notional | 35,000,000 USD | 명목 금액 |

**해석**:
- 2026년 만기 상품 옵션 매도 포지션
- 명목 대비 약 12% 손실 가능성
- 3,500만 USD 명미의 상품 포지션 헷징

---

## 상품 옵션 유형

### 1. NYMEX 원유 옵션
- **기초 자산**: WTI 원유
- **계약 단위**: 1,000배럴
- **행사 가격**: $50, $60, $70 등

### 2. LME 금속 옵션
- **기초 자산**: 구리, 알루미늄, 아연, 납, 주석, 니켈
- **계약 단위**: 25톤 (구리 기준)
- **행사 방식**: 유럽형 (European)

### 3. 천연가스 옵션
- **기초 자산**: 천연가스
- **계약 단위**: 10,000 MMBtu
- **거래소**: NYMEX (Henry Hub)

---

## 가치 평가 요소

### 1. 기초 상품 가격
- 현물 가격 (Spot Price)
- 선물 가격 (Futures Price)
- 커브 구조 (F1, F2, ...)

### 2. 변동성
- 상품 변동성은 일반적으로 주식보다 높음
- 계약월별 변동성 차이 (Term Structure)

### 3. 계약월 (Contract Month)
- F1: 최선월 (Front Month)
- F2, F3: 차선월 (Back Months)

### 4. 편의 수익률 (Convenience Yield)
- 실물 보유의 혜택
- 재고 낮을수록 편의 수익률 ↑

---

## 상품 옵션 용도

### 1. 생산자 헷징
- **Call Option 매도**: 가격 상승 시 최소 판매가 보장
- **Put Option 매수**: 가격 하락 보호

### 2. 소비자 헷징
- **Call Option 매수**: 가격 상승 보호
- **Put Option 매도**: 구매 비용 절감

### 3. 투기
- 상품 가격 방향성 베팅
- 변동성 거래

### 4. 스프레드 거래
- Calendar Spread: F1 vs F2
- Location Spread: WTI vs Brent
- Quality Spread: Sweet vs Sour

---

## 일반 옵션 vs 상품 옵션

| 구분 | 일반 옵션 | 상품 옵션 |
|------|----------|----------|
| 기초 자산 | 주식, 지수, 환율 | 원자재 |
| 결제 | 현금 | 현금 + 인도 |
| 배당 | 주식 배당 | 편의 수익률 |
| 계약월 | 단일 만기 | F1, F2, F3... |

---

## 주요 상품 거래소

| 거래소 | 주요 상품 | 계약 단위 |
|--------|----------|----------|
| NYMEX | WTI 원유, 천연가스 | 1,000배럴, 10,000MMBtu |
| LME | 구리, 알루미늄, 아연 | 25톤 |
| CME | 옥수수, 대두, 밀 | 5,000부셸 |
| ICE | Brent 원유 | 1,000배럴 |

---

## 실행 방법

```bash
cd /home/keehyun/dev/Engine/Examples/Products
python3 build_portfolio.py --n 11  # Commodity Option
ore Input/ore.xml
```

---

## 출력 파일 위치

```
Output/
├── npv.csv                           # 옵션 가치
├── additional_results.csv            # 옵션 상세
└── marketdata.csv                    # 시장 데이터
```

---

## 참고 자료

- **ORE User Guide**: 상품 옵션 장
- **Geman, Helyette**: "Commodities and Commodity Derivatives"
- **Eydeland, Alexander**: "Energy and Power Risk Management"
