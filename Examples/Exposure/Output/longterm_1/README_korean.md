# Longterm (장기 시뮬레이션) 예제

## 개요
이 예제는 **50년 만기 스왑**의 장기 노출 리스크 시뮬레이션을 보여줍니다.

## Horizon Shift

- **longterm_1**: ShiftHorizon = 0.0 (표준)
- **longterm_2**: ShiftHorizon = 30.0 (30년 후 집중)

## 상품
- Swap_50y: 50년 EUR Interest Rate Swap

## 실행 방법
```bash
cd /home/keehyun/dev/Engine/Examples/Exposure
python3 run_longterm.py
```

*장기 시뮬레이션 결과는 ORE 실행으로 생성하세요. scenariodump.csv는 대용량으로 제외됩니다.*
