# CPM (Credit Portfolio Model) 예제

## 개요
신용 포트폴리오 모델을 사용한 **신용 마이그레이션 시뮬레이션**을 보여줍니다.

## 신용 마이그레이션이란?

시간 경과에 따른 신용 등급의 이동(Migration)을 시뮬레이션하여 신용 리스크를 정량화합니다.

## 예제 포트폴리오

- Bond (단일 채권)
- Bond3 (3개 채권)
- Bond10 (10개 채권)
- Bond_Swap (채권 + 스왑)
- Bond_CDS (채권 + CDS)

## 실행 방법
```bash
cd /home/keehyun/dev/Engine/Examples/CreditRisk
python3 run_cpm.py
```

*출력: credit_migration_*.csv, 시각화 PDF*
