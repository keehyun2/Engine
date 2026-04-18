# ExposureWithCollateral (담보기 노출 리스크) 예제

## 개요
담보가 있는 포트폴리오의 노출 리스크 계산을 보여줍니다. 3개의 다양한 통화 스왑 포트폴리오를 사용하여 담보 계약(CSA), 변동 마진, 초기 마진 등이 노출에 미치는 영향을 분석합니다.

## 시나리오별 디렉토리

- `nocollateral/` - 담보 없는 경우
- `vm_threshold/` - Threshold 기반 VM
- `vm_mta/` - MTA가 있는 VM
- `vm_mpor/` - MPOR 효과
- `vm_threshold_break/` - Threshold + Break
- `vm_threshold_dim/` - Threshold + DIM

## 실행 방법
```bash
cd /home/keehyun/dev/Engine/Examples/ExposureWithCollateral
python3 run_biweekly.py  # Biweekly grid
python3 run_closeout.py  # Close-out grid
python3 run_firstmpor.py # First MPoR adjustment
```

*출력 파일은 ORE 실행으로 생성하세요. 대용량 큐브 파일은 제외됩니다.*
