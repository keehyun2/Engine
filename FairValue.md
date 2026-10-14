아래와 같이 설계하면 **입력 생성부터 평가 완료까지** 하나의 흐름으로 관리하기 좋습니다.

---

# 1. 공정가치평가 작업 (fair_value_job)

> 평가 작업(Job) 자체를 관리하는 공통 테이블

| 논리명         | 설명                                |
| ----------- | --------------------------------- |
| 공정가치평가 작업번호 | Job 식별번호                          |
| 평가기준일       | As Of Date                        |
| 상품유형        | FX Forward / Bond                 |
| 원거래번호       | 원 시스템의 Trade ID                   |
| 입력폴더        | Input 폴더명                         |
| 출력폴더        | Output 폴더명                        |
| RDP환율시각    | RDP 마켓데이터 환율 시각                      |
| 평가요청일시      | 평가 요청 시간                          |
| 평가시작일시      | 평가 시작 시간                          |
| 평가종료일시      | 평가 종료 시간                          |
| 오류메시지       | 실패 시 오류 내용                        |
| 평가상태        | READY, RUNNING, SUCCESS, FAILED 등 |
| 평가금액     | NPV                |
| 평가통화     | NPV Currency       |
| 평가소요시간   | 평가 수행 시간(ms 또는 초)  |
| 결과파일생성여부 | Output 생성 여부       |

---

# 2. FX Forward 공정가치평가 입력정보 (fair_value_fxforward)

> portfolio.xml 생성을 위한 입력 정보

| 논리명         | 설명              |
| ----------- | --------------- |
| 공정가치평가 작업번호 | Job FK          |
| 거래번호        | Trade ID        |
| 만기일         | Value Date      |
| 매수통화        | Bought Currency |
| 매수금액        | Bought Amount   |
| 매도통화        | Sold Currency   |
| 매도금액        | Sold Amount     |
| 매수통화국가코드        | Bought Nation Code   |
| 매도통화국가코드        | Sold Nation Code     |
| 거래상대방       | Counterparty    |

---

# 3. 채권 공정가치평가 입력정보 (fair_value_bond)

> portfolio.xml 생성을 위한 입력 정보

| 논리명         | 설명                      |
| ----------- | ----------------------- |
| 공정가치평가 작업번호 | Job FK                  |
| 거래번호        | Trade ID                |
| 채권코드        | Bond Identifier         |
| 발행기관        | Issuer                  |
| 통화          | Currency                |
| 액면금액        | Face Amount             |
| 발행일         | Issue Date              |
| 만기일         | Maturity Date           |
| 쿠폰금리        | Coupon Rate             |
| 쿠폰주기        | Coupon Frequency        |
| 일수계산방식      | Day Count Convention    |
| 영업일조정규칙     | Business Day Convention |
| 결제일수        | Settlement Days         |
| 거래상대방       | Counterparty            |

