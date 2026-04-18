# 커브 대수학 (Curve Algebra) 출력 설명

## 예제 개요

이 예제는 이자율 곡선(Curve) 간 대수 연산을 수행합니다. 두 곡선을 더하거나 빼서 새로운 곡선을 생성합니다.

---

## 핵심 금융 용어

### Curve Algebra (커브 대수학)
- **정의**: 이자율 곡선 간 수학적 연산 (덧셈, 뺄셈, 곱셈 등)
- **용도**: 베이시스 리스크 분석, 스프레드 곡선 구축
- **예시**: LIBOR 곡선 - OIS 곡선 = LIBOR-OIS 스프레드 곡선

### Zero Curve (제로 곡선)
- **정의**: 만기별 할인율(Zero Rate)을 나타내는 곡선
- **용도**: 모든 금융 상품 가치 평가의 기초

### Spread Curve (스프레드 곡선)
- **정의**: 두 곡선 간 차이를 나타내는 곡선
- **예시**: 10년 LIBOR-OIS 스프레드 = 신용 리스크 + 유동성 프리미엄

---

## 출력 파일 상세 설명

### 1. additional_results.csv
**용도**: 커브 연산 결과

| 컬럼 | 설명 |
|------|------|
| Tenor | 기간 (1M, 3M, 6M, 1Y, 5Y, 10Y 등) |
| Date | 날짜 |
| Curve1 | 첫 번째 곡선 값 |
| Curve2 | 두 번째 곡선 값 |
| Sum | 곡선 합 |
| Difference | 곡선 차이 |
| Ratio | 곡선 비율 |

**해석 예시**:
```
Tenor: 10Y
Curve1 (LIBOR): 3.50%
Curve2 (OIS): 2.80%
Difference: 0.70% (LIBOR-OIS 스프레드)
```
- 10년 만기 LIBOR-OIS 스프레드는 70bp
- 은행 간 신용 리스크 + 유동성 프리미엄을 반영

---

### 2. sensitivity.csv
**용도**: 커브 연산 결과에 대한 민감도

---

### 3. stress_scenarios.csv
**용도**: 스트레스 시나리오별 커브 변화

---

### 4. stresstest.csv
**용도**: 커브 스트레스 테스트 결과

---

### 5. npv.csv
**용도**: 순현재가치

---

### 6. curves.csv
**용도**: 이자율 곡선 데이터

---

## 실무 활용

### 1. 스프레드 거래
- **Steepener**: 단기-장기 스프레드 베팅
- **Flattener**: 단기-장기 스프레드 반대 베팅
- **Butterfly**: 중기 곡선 포지션

### 2. 베이시스 리스크 관리
- LIBOR vs OIS 베이시스
- 국고채 vs 스왑 스프레드

### 3. 신용 리스크 추정
- LIBOR-OIS 스프레드 = 은행 간 신용 리스크
- CDS 스프레드 = 기업 신용 리스크

---

## 주요 커브 연산

| 연산 | 용도 | 예시 |
|------|------|------|
| Subtraction | 스프레드 계산 | LIBOR - OIS = 베이시스 |
| Addition | 리스크 합성 | 금리 + 크레딧 = 전체 리스크 |
| Multiplication | 스케일링 | 1.5 × 금리 곡선 |

---

## 실행 방법

```bash
cd /home/keehyun/dev/Engine/Examples/MarketRisk
ore Input/ore_curvealgebra.xml
```

---

## 출력 파일 위치

```
Output/CurveAlgebra/
├── additional_results.csv   # 커브 연산 결과
├── sensitivity.csv          # 민감도
├── stress_scenarios.csv     # 스트레스 시나리오
├── stresstest.csv           # 스트레스 결과
├── npv.csv                  # 순현재가치
├── curves.csv               # 이자율 곡선
├── flows.csv                # 현금흐름
└── marketdata.csv           # 시장 데이터
```

---

## LIBOR-OIS 스프레드 해석

| 기간 | 일반적인 스프레드 | 해석 |
|------|------------------|------|
| 1개월 | 10-20bp | 단기 유동성 리스크 |
| 1년 | 30-50bp | 단기 신용 리스크 |
| 5년 | 50-80bp | 중기 신용 리스크 |
| 10년 | 60-100bp | 장기 신용 리스크 |

---

## 참고 자료

- **ORE User Guide**: 커브 구축 및 연산 장
- **Hull, John**: "Options, Futures, and Other Derivatives" - 금리 곡선 장
