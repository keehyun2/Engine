# CCS (Cross Currency Swap) 예제

## 개요
이 예제는 **크로스 커런시 스왑(Cross Currency Swap, CCS)**의 노출 리스크와 XVA 계산을 보여줍니다. 서로 다른 통화 간의 이자 지급과 원금 교환을 포함하는 통화 스왑의 잠재적 노출을 분석합니다.

## 상품 설명

### 1. CCSwap (EUR-USD 크로스 커런시 스왑)
- **EUR Leg**: EURIBOR 3M Floating (Payer)
- **USD Leg**: 2.0% Fixed (Receiver)

### 2. XCCY_Swap_EUR_USD (EUR-USD 외환 스왑)
- **USD Leg**: USD LIBOR Floating (Receiver)
- **EUR Leg**: EUR Fixed 1.5% (Payer)

## 실행 방법
```bash
cd /home/keehyun/dev/Engine/Examples/Exposure
python3 run_ccs.py
```

## 주요 학습 포인트
- 환 리스크와 이자율 리스크의 결합
- EUR과 USD 간의 상관관계가 노출에 미치는 영향
- 크로스 커런시 베이시스

*출력 파일은 ORE 실행으로 생성하세요. 대용량 파일(rawcube.csv 등)은 .gitignore로 제외됩니다.*
