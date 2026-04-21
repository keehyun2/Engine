# ========================================
# TA002_IR_Swap: 금리 스왑(IR Swap) 가격 결정 예제
# ========================================

## 개요 (Overview)

이 예제는 EUR 기반 20년 만기 금리 스왑(IR Swap)의 가격을 평가하는 방법을 보여줍니다.
ORE(Open Source Risk Engine)를 사용하여 NPV(순현재가치), 캐시플로우, 수익률 곡선을 계산합니다.


## 1. 포트폴리오 (Portfolio)

단일 거래가 포함된 포트폴리오:

**거래: Swap_20y**
- 상품 유형: 금리 스왑 (Interest Rate Swap)
- 만기: 20년 (2016년 3월 1일 ~ 2036년 3월 1일)
- 명목 금액: EUR 10,000,000

**고정 금리 레그 (Fixed Leg):**
- 금리: 연 4% (고정)
- 지급 빈도: 연 1회 (1Y)
- 역할: 금리 수신자 (Fixed Receiver)
- 일수 계산: 30/360

**변동 금리 레그 (Floating Leg):**
- 인덱스: EUR-EURIBOR-6M (유로 6개월 은행간 제안금리)
- 지급 빈도: 반년 1회 (6M)
- 역할: 금리 지급자 (Floating Payer)
- 일수 계산: A360
- 스프레드: 0


## 2. 시장 데이터 (Market)

- 기준일: 2016년 2월 5일
- 시장 데이터: Input/market.txt
- Fixing 데이터: Input/fixings.txt


## 3. 가격 결정 (Pricing)

### 수익률 곡선 구성 (Curves_Configuration_IR_Swap.png 참조)

1. **EUR1D (할인 곡선)**
   - EONIA(Overnight Index Average) 기반 OIS 스왑으로 구축
   - 현금흐름 할인용
   - 구성: 단기 예금 + 1주~30년 OIS

2. **EUR6M (포워딩 곡선)**
   - EURIBOR-6M 인덱스의 미래 금리 예측용
   - 6M 예금 + IRS(Interest Rate Swap)로 구축
   - 할인은 EUR1D 곡선 사용 (이중 곡선 방식)


## 4. 분석 항목 (Analytics)

1. **NPV (Net Present Value)**
   - 출력 파일: Output/npv.csv
   - 스왑의 현재 가치(순현재가치) 계산

2. **Cashflow**
   - 출력 파일: Output/flows.csv
   - 미래 현금흐름 상세 분석

3. **Curves**
   - 출력 파일: Output/curves.csv
   - 구축된 수익률 곡선 데이터 (20년, 월별)


## 5. 예제 실행 (Run Example)

```bash
python run.py
```

실행 후 Output 폴더에서 결과 파일을 확인할 수 있습니다.


## 6. 기대 결과 (Expected Results)

- NPV: 스왑의 현재 가치 (고정/변동 레그의 PV 차이)
- Cashflows: 각 지급일별 예상 현금흐름
- Curves: 부트스트래핑된 EUR1D, EUR6M 수익률 곡선


## 7. 입력 파일 구조

| 파일 | 설명 |
|------|------|
| ore.xml | 메인 ORE 설정 파일 |
| curveconfig.xml | 수익률 곡선 구성 정의 |
| todaysmarket.xml | 할인/포워딩 곡선 매핑 |
| pricingengine.xml | 가격 결정 엔진 설정 |
| conventions.xml | 시장 관습 정의 |
| irswap.xml | 스왑 거래 정의 |
| market.txt | 시장 데이터 (금리) |
| fixings.txt | 과거 Fixing 데이터 |


## 8. 학습 포인트

- ORE를 사용한 IR Swap 가격 평가
- 이중 곡선(Dual Curve) 방식 이해
- 수익률 곡선 부트스트래핑
- EURIBOR 인덱스와 EONIA 할인의 차이
