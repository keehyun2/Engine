# ORE 예제 한국어 주석 작업 TODO

## 진행 상황

### ✅ 완료된 예제
- [x] ore_prime.xml - Prime 금리 예제 (LIBOR vs Prime)
- [x] ore_sabr.xml - SABR 변동성 모델 예제
- [x] ore_centralbank_0.xml - 중앙은행 예제 #0 (Priority 기반 GBP SONIA 곡선)
- [x] ore_consistency_ois.xml - OIS 일관성 검증 예제
- [x] ore_consistency_xoiseur.xml - 통화 간 OIS EUR 일관성 검증 예제
- [x] ore_consistency_xoisusd.xml - 통화 간 OIS USD 일관성 검증 예제
- [x] ore_bondyieldshifted.xml - 채권 수익률 시프트 곡선 예제
- [x] ore_centralbank_1.xml - 중앙은행 예제 #1 (BOE 회의일 + 표준 OIS)
- [x] ore_centralbank_2.xml - 중앙은행 예제 #2 (PillarChoice: StartDateAndMaturityDate)
- [x] ore_centralbank_3.xml - 중앙은행 예제 #3 (PillarChoice: StartDate)
- [x] ore_centralbank_4.xml - 중앙은행 예제 #4 (PillarChoice: StartDateAndLastRelevantDate)
- [x] ore_discountratio_eur.xml - EUR 할인율 비율 예제
- [x] ore_discountratio_usd.xml - USD 할인율 비율 예제
- [x] ore_fixedfloatccs.xml - 고정-변동 통화 간 스왑 예제

### 🔄 작업 중

### ⏳ 대기 중 (예제 목록)

#### CurveBuilding 예제
- [x] ore_centralbank_1.xml - 중앙은행 예제 #1
- [x] ore_centralbank_2.xml - 중앙은행 예제 #2
- [x] ore_centralbank_3.xml - 중앙은행 예제 #3
- [x] ore_centralbank_4.xml - 중앙은행 예제 #4
- [x] ore_consistency_xoiseur.xml - OIS EUR 일관성 검증
- [x] ore_consistency_xoisusd.xml - OIS USD 일관성 검증
- [x] ore_discountratio_eur.xml - EUR 할인율 비율
- [x] ore_discountratio_usd.xml - USD 할인율 비율
- [x] ore_fixedfloatccs.xml - 고정-변동 통화 간 스왑
- [x] ore_bondyieldshifted.xml - 채권 수익률 시프트

## 최근 완료 작업

### consistency_ois 예제
- **내용**: OIS 곡선 일관성 검증
- **핵심**: 구축된 곡선이 시장 데이터를 정확히 재현하는지 확인
- **결과**: 모든 상품 NPV ≈ 0 (일관성 검증 통과)
- **설명서**: Output/consistency/ois/README_korean.md

### centralbank_0 예제
- **내용**: GBP SONIA OIS 곡선 구축
- **핵심**: Priority 기반 부트스트래핑
- **특징**: BOE 회의일 OIS를 최우선으로 활용
- **설명서**: Output/centralbank_0/README_korean.md

## 작업 내용 요약

### 완료된 파일 (총 14개 예제)

1. **ore_prime.xml** (Prime 금리)
   - 입력 파일: ore_prime.xml, portfolio_prime.xml, curveconfig_prime.xml, 등
   - 출력 설명서: Output/prime/README_korean.md

2. **ore_sabr.xml** (SABR 변동성)
   - 입력 파일: ore_sabr.xml, portfolio_sabr.xml, pricingengine_sabr.xml, 등
   - 출력 설명서: Output/sabr/README_korean.md
   - 시장 데이터 설명: Input/market_sabr_README.txt

3. **ore_centralbank_0.xml** (중앙은행 #0)
   - 입력 파일: ore_centralbank_0.xml, portfolio_centralbank.xml, curveconfig_centralbank_0.xml, 등
   - 출력 설명서: Output/centralbank_0/README_korean.md

4. **ore_consistency_ois.xml** (OIS 일관성)
   - 입력 파일: ore_consistency_ois.xml
   - 출력 설명서: Output/consistency/ois/README_korean.md

5. **ore_consistency_xoiseur.xml** (XOIS EUR)
   - 입력 파일: ore_consistency_xoiseur.xml
   - 출력 설명서: Output/consistency/xoiseur/README_korean.md

6. **ore_consistency_xoisusd.xml** (XOIS USD)
   - 입력 파일: ore_consistency_xoisusd.xml
   - 출력 설명서: Output/consistency/xoisusd/README_korean.md

7. **ore_bondyieldshifted.xml** (채권 수익률 시프트)
   - 입력 파일: ore_bondyieldshifted.xml, curveconfig_bondyieldshifted.xml, 등
   - 출력 설명서: Output/bondyieldshifted/README_korean.md

8. **ore_centralbank_1.xml** (중앙은행 #1)
   - 입력 파일: ore_centralbank_1.xml, curveconfig_centralbank_1.xml
   - 출력 설명서: Output/centralbank_1/README_korean.md

9. **ore_centralbank_2.xml** (중앙은행 #2)
   - 입력 파일: ore_centralbank_2.xml, curveconfig_centralbank_2.xml
   - 출력 설명서: Output/centralbank_2/README_korean.md

10. **ore_centralbank_3.xml** (중앙은행 #3)
    - 입력 파일: ore_centralbank_3.xml, curveconfig_centralbank_3.xml
    - 출력 설명서: Output/centralbank_3/README_korean.md

11. **ore_centralbank_4.xml** (중앙은행 #4)
    - 입력 파일: ore_centralbank_4.xml, curveconfig_centralbank_4.xml
    - 출력 설명서: Output/centralbank_4/README_korean.md

12. **ore_discountratio_eur.xml** (EUR 할인율 비율)
    - 입력 파일: ore_discountratio_eur.xml, curveconfig_discountratio.xml
    - 출력 설명서: Output/discountratio/eur_base/README_korean.md

13. **ore_discountratio_usd.xml** (USD 할인율 비율)
    - 입력 파일: ore_discountratio_usd.xml, curveconfig_discountratio.xml
    - 출력 설명서: Output/discountratio/usd_base/README_korean.md

14. **ore_fixedfloatccs.xml** (고정-변동 CCS)
    - 입력 파일: ore_fixedfloatccs.xml, curveconfig_fixedfloatccs.xml
    - 출력 설명서: Output/fixedfloatccs/README_korean.md

### 추가 생성 파일

- **Output/prime/README_korean.md**: Prime 예제 출력 설명
- **Output/sabr/README_korean.md**: SABR 예제 출력 설명
- **Output/centralbank_0/README_korean.md**: 중앙은행 예제 #0 설명
- **Output/centralbank_1/README_korean.md**: 중앙은행 예제 #1 설명
- **Output/centralbank_2/README_korean.md**: 중앙은행 예제 #2 설명
- **Output/centralbank_3/README_korean.md**: 중앙은행 예제 #3 설명
- **Output/centralbank_4/README_korean.md**: 중앙은행 예제 #4 설명
- **Output/consistency/ois/README_korean.md**: OIS 일관성 검증 설명
- **Output/consistency/xoiseur/README_korean.md**: XOIS EUR 일관성 검증 설명
- **Output/consistency/xoisusd/README_korean.md**: XOIS USD 일관성 검증 설명
- **Output/bondyieldshifted/README_korean.md**: 채권 수익률 시프트 곡선 설명
- **Output/discountratio/eur_base/README_korean.md**: EUR 할인율 비율 설명
- **Output/discountratio/usd_base/README_korean.md**: USD 할인율 비율 설명
- **Output/fixedfloatccs/README_korean.md**: 고정-변동 CCS 설명
- **Input/market_sabr_README.txt**: SABR 시장 데이터 설명

## 다음 작업

- [x] todo.md 파일 생성
- [ ] ore_consistency_xoiseur.xml (EUR OIS 일관성)
- [ ] ore_discountratio_eur.xml (EUR 할인율 비율)
- [ ] ore_fixedfloatccs.xml (통화 간 스왑)
