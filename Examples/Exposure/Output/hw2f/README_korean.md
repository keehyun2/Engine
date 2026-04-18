# HW2F (Hull-White 2-Factor) 예제

## 개요
이 예제는 **Hull-White 2요인 모델**을 사용한 노출 리스크 계산을 보여줍니다. 단일 요인보다 더 정교한 이자율 변동성 모델링을 통해 크로스 커런시 스왑의 노출을 분석합니다.

## HW2F 모델이란?

2개의 요인으로 이자율을 모델링합니다:
- **요인 1**: 수준(Level) 변화
- **요인 2**: 기울기(Slope) 변화

## 캘리브레이션
- Historical Calibration - 과거 데이터 기반
- Risk-Neutral Calibration - 시장 가격 기반

## 실행 방법
```bash
cd /home/keehyun/dev/Engine/Examples/Exposure
python3 run_hw2f.py
```

*PCA 분석 결과는 ORE 실행으로 생성하세요.*
