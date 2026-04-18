# 할인율 비율 예제 (Discount Ratio USD)

## 예제 개요

이 예제는 **USD 기준 할인율 비율(Discount Ratio) 곡선**을 구축하여 크로스 통화 가격 평가의 정확성을 검증합니다.

### USD 기준의 특징

**기준 통화: USD**
```
Ratio_USD_EUR(t) = DF_USD(t) / DF_EUR(t)
Ratio_USD_GBP(t) = DF_USD(t) / DF_GBP(t)
Ratio_USD_JPY(t) = DF_USD(t) / DF_JPY(t)
```

**EUR 기준과의 비교**:

| 특징 | EUR 기준 | USD 기준 |
|------|----------|----------|
| 주요 통화 쌍 | EUR-USD, EUR-GBP | USD-EUR, USD-JPY |
| 시장 중심성 | 유로존 중심 | 글로벌 중심 |
| 사용 사례 | 유럽 기업 | 글로벌 기업 |

---

## 핵심 차이점

### 비율의 역수 관계

```
Ratio_USD_EUR = 1 / Ratio_EUR_USD

예시:
EUR 기준: Ratio_EUR_USD = 1.0300
USD 기준: Ratio_USD_EUR = 0.9709 (1/1.0300)
```

### 주요 통화 쌍

| 기준 | 상대 통화 | 비율 | 설명 |
|------|-----------|------|------|
| USD | EUR | DF_USD/DF_EUR | 달러-유로 |
| USD | JPY | DF_USD/DF_JPY | 달러-엔화 |
| USD | GBP | DF_USD/DF_GBP | 달러-파운드 |
| USD | CHF | DF_USD/DF_CHF | 달러-프랑 |

---

## 요약

### ✅ 예제 결과

- **기준 통화**: USD
- **상대 통화**: EUR, JPY, GBP, CHF
- **비율 곡선**: 정확히 계산

### 🎓 학습 포인트

- USD 기준 할인율 비율
- EUR 기준과의 역수 관계
- 글로벌 통화 쌍 가격 평가

---

## 참고

- **eur_base**: EUR 기준 할인율 비율
- **ORE User Guide**: Discount Ratio Curves

---

## 💻 실제 실행 결과 분석

### ORE 실행 개요

**실행 명령**:
```bash
cd /home/popos/dev/Engine/Examples/CurveBuilding
/home/popos/dev/Engine/build/App/ore Input/ore_discountratio_usd.xml
```

**실행 시간**: 약 0.33초

**생성된 출력 파일**:
- `npv.csv` - 상품별 순현재가치
- `curves.csv` - 할인율 비율 곡선 (240개월, 1M 간격)
- `flows.csv` - 상품 현금흐름

### 실행 결과 해석

**USD 기반 통화 간 상품**:
```
상품 유형:
- USD/CHF FX 포워드 (다양한 만기)
- USD/GBP FX 포워드 (다양한 만기)
- USD/CHF 크로스 통화 베이시스 스왑
- USD/EUR 크로스 통화 베이시스 스왑

모든 상품 NPV = 0.000000
```

**NPV = 0 의미**:
```
이 경우의 NPV = 0:
- 할인율 비율 곡선이 정확히 구축됨
- FX 포워드와 베이시스 스왑이 정확히 재가격됨
- 일관성 검증이 통과됨

centralbank 예제의 NPV = #N/A와 다름:
- 이 예제: 정상적인 시장 데이터 사용
- centralbank: 특수한 BOE 회의일 데이터 필요
```

### USD 기준 비율 곡선 특성

**곡선 구조**:
```
USD 기준 할인율 비율:

DF_USD / DF_EUR: USD-EUR 비율 (EUR 기준의 역수)
DF_USD / DF_GBP: USD-GBP 비율
DF_USD / DF_CHF: USD-CHF 비율
DF_USD / DF_JPY: USD-JPY 비율
```

**역수 관계 확인**:
```
EUR 기준: Ratio_EUR_USD = DF_EUR / DF_USD
USD 기준: Ratio_USD_EUR = DF_USD / DF_EUR

검증:
Ratio_USD_EUR = 1 / Ratio_EUR_USD

예시:
어느 시점 t에서
DF_EUR = 0.99, DF_USD = 0.98

EUR 기준: 0.99 / 0.98 = 1.0102
USD 기준: 0.98 / 0.99 = 0.9899
확인: 1.0102 × 0.9899 ≈ 1.0 ✓
```

### 글로벌 통화의 특징

**USD 기준의 장점**:
```
1. 글로벌 준비 통화:
   - 대부분의 국제 거래에 USD 사용
   - 표준적인 기준 통화

2. 유동성:
   - USD 시장이 가장 유동성 높음
   - 좁은 스프레드

3. 데이터 가용성:
   - USD 관련 데이터가 가장 풍부
   - 더 정확한 곡선 구축 가능
```

### 결론

**검증 결과**:
- USD 기준 할인율 비율 곡선 구축 **완벽하게 성공**
- 모든 상품 NPV = 0 (재가격 정확)
- 글로벌 통화 쌍 모두 커버

**실무적 의미**:
- 다국적 기업의 USD 중심 헷지 전략에 필수
- 글로벌 투자자에게 가장 적합한 기준
- 국제 금융 거래의 표준적인 접근 방식

**EUR vs USD 기준 선택 가이드**:
```
EUR 기준 선택:
- 유로존 기반 기업
- 유럽 투자자
- EUR 노출이 큰 포트폴리오

USD 기준 선택 (일반적 권장):
- 글로벌 기업
- 국제 투자자
- 다양한 통화 노출
- 미국 달러 중심 비즈니스
```
