# InitialMargin (초기 마진) 예제

## 개요
ISDA **SIMM**과 **DIM**을 사용하여 파생상품 포트폴리오의 초기 마진 요구량을 계산합니다.

## SIMM (Standard Initial Margin Model)

- 버전 2.4, 2.5A, 2.6 지원
- MPOR 1일, 10일 지원

## DIM (Daily Initial Margin)

- 회귀 기반 시뮬레이션
- 다양한 상품 시나리오

## 출력 디렉토리

- `SIMM2.4_10D/`, `SIMM2.6_1D/` 등 - SIMM 결과
- `dim/` - DIM 결과
- `IM_SCHEDULE/` - 마진 일정

## 실행 방법
```bash
cd /home/keehyun/dev/Engine/Examples/InitialMargin
python3 run_simm.py
python3 run_dim.py
```

*대용량 scenariodump.csv와 rawcube.csv 파일은 제외됩니다.*
