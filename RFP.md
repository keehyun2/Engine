1.	외부 시장 데이터 공급자 연동
 - Refinitiv Real-time Data Platform (RDP)
2.	Market Data Gateway 구축
 - STP 데이터 수신
 - 데이터 정규화
 - 내부 평가 테이블 매핑
3.	Risk Engine 구축
 - Open Source Risk Engine (ORE)
 - Curve 및 Market Data 처리
4.	BO 시스템 연계
 - 평가 테이블 자동 업데이트
 - 재평가 데이터 제공


Curve Construction (ORE)
ORE Risk Engine은 다음의 기능을 제공해야 한다.
 - Yield Curve Construction
 - Discount Curve 생성
 - Interest Rate Term Structure
 - FX Forward Curve


ORE 예제 우선순위 (RFP 매핑)
━━━━━━━━━━━━━━━━━━━━━━━━━━━

RFP 핵심 요구사항과 ORE 예제 매핑:

| RFP 요구사항            | 관련 ORE 예제                              |
|------------------------|--------------------------------------------|
| Yield Curve Construction | CurveBuilding (전체)                       |
| Discount Curve 생성      | CurveBuilding - discount ratio, consistency |
| Interest Rate Term Structure | CurveBuilding - bootstrap, OIS        |
| FX Forward Curve         | CurveBuilding - consistency (FX Forward, XCCY) |
| Risk Engine 전반         | MarketRisk (Sensitivity, VaR, Stress)      |
| BO 평가 테이블 / 재평가  | Products (NPV, Cashflow), MarketRisk (PnL) |


1순위: CurveBuilding (완료됨)
 - RFP에서 명시한 4개 기능이 모두 포함
 - consistency 예제: FX Forward / Cross Currency Basis Swap / OIS 부트스트래핑

2순위: MarketRisk
 - run_sensi.py: Risk Engine 핵심, 민감도 분석
 - run_parametricvar.py / run_histsimvar.py: 리스크 측정 (VaR)
 - run_stress.py / run_parstress.py: 스트레스 테스트
 - run_pnlexplain.py: BO 시스템 재평가 데이터 제공과 직결

3순위: Products
 - 150+ 상품 NPV/Cashflow 계산
 - BO 평가 테이블 자동 업데이트를 위한 상품 커버리지 파악
 - 특히 Swap, FX, Credit 카테고리가 RFP와 직접 연관

4순위: Exposure + XvaRisk
 - 카운터파티 리스크 관리 필요 시
 - Exposure → 노출 시뮬레이션, XvaRisk → CVA/SA-CVA 계산

5순위: InitialMargin, CreditRisk, ExposureWithCollateral
 - SIMM, SA-CCR 등 규제 리스크 계산
 - 규제 요건 있을 경우에 해당
