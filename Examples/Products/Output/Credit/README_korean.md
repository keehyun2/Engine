# 리스크 참여 계약 (Risk Participation Agreement) 출력 설명

## 예제 개요

이 예제는 RPA(Risk Participation Agreement)의 가치 평가를 보여줍니다. RPA는 한 금융기관이 다른 기관의 리스크를 일부 인수하는 계약입니다.

---

## 핵심 금융 용어

### RPA (Risk Participation Agreement)
- **정의**: 한 금융기관(원장 보유자)이 다른 기관(참여자)에게 파생상품 포지션의 리스크를 일부 이전하는 계약
- **목적**: 리스크 분산, 신용 한도 확보
- **구조**: 참여자가 프리미엄을 지급하고, 리스크의 일부를 인수

### Callable Swap의 RPA
- **정의**: 콜러블 스왑(Callable Swap)의 리스크를 참여하는 계약
- **원장 보유자**: 콜러블 스왑 발행자
- **참여자**: 스왑의 리스크/보상을 일부 인수

---

## 출력 파일 상세 설명

### 1. npv.csv
**용도**: RPA의 순현재가치

| 컬럼 | 값 | 설명 |
|------|-----|------|
| TradeId | RPA_CALLABLE | RPA 식별자 |
| TradeType | RiskParticipationAgreement | 상품 타입 |
| Maturity | 2042-04-22 | 만기일 |
| NPV | 41,714 EUR | 리스크 참여 가치 |
| Notional | 10,000,000 EUR | 명목 금액 |

**해석**:
- 2042년 만기의 장기 계약 (약 20년)
- 리스크 참여에 대해 4만 EUR 가치
- 참여자는 프리미엄을 지급하고 리스크 인수

---

### 2. additional_results.csv
**용도**: 추가 분석 결과

- 참여 비율 (Participation Rate)
- 리스크 노출 (Risk Exposure)
- 콜러블 스왑의 콜 옵션 가치

---

## RPA 구조

```
┌─────────────────┐         ┌─────────────────┐
│ 원장 보유자      │────────>│  참여자 (RPA)    │
│ (Original       │ 리스크   │ (Participant)   │
│  Counterparty)  │ 일부 이전│                 │
└─────────────────┘         └─────────────────┘
        ↑                            ↑
        │ 프리미엄 지급              │ 리스크 인수
        └────────────────────────────┘
```

---

## 실무 활용

### 1. 신용 리스크 관리
- 카운터파티 신용 한도 초과 시 리스크 분산
- 여러 참여자에게 리스크 분배

### 2. 자본 최적화
- 리스크 일부 이전으로 자본 요구금액 감소
- BA-CVA 계산에 참여

### 3. 수익 창출
- 리스크 인수로 프리미엄 수익
- 리스크-보상 균형

---

## 실행 방법

```bash
cd /home/keehyun/dev/Engine/Examples/Products
python3 build_portfolio.py --n 25  # RPA
ore Input/ore.xml
```

---

## 출력 파일 위치

```
Output/
├── npv.csv                           # RPA 가치
├── additional_results.csv            # 추가 분석
└── marketdata.csv                    # 시장 데이터
```

---

## 참고 자료

- **ORE User Guide**: RPA 장
- **ISDA**: Risk Participation Agreement 템플릿
