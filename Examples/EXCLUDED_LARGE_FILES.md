# 제외된 대용량 파일 안내

이 문서는 Git 저장소 크기를 줄이기 위해 제외된 대용량 출력 파일들을 설명합니다.

## 제외된 파일 목록

### 1. 압축된 큐브 파일
- `*.csv.gz` - 압축된 시뮬레이션 큐브 파일

### 2. 시나리오 덤프 파일
- `scenariodump.csv` - 시나리오 분석용 덤프 파일 (수백 MB ~ 수 GB)

### 3. 원시 큐브 파일
- `rawcube.csv` - 원본 시뮬레이션 큐브 (수십 MB ~ 수백 MB)
- `cube.csv` - 시뮬레이션 큐브
- `cube.dat` - 바이너리 큐브 파일
- `netcube.csv` - 네팅 후 큐브

## 제외된 예제별 파일

### InitialMargin/dim
- `Output/dim/A0/scenariodump.csv` - 460 MB
- `Output/dim/B0/scenariodump.csv` - 920 MB
- `Output/dim/C0/scenariodump.csv` - 460 MB
- `Output/dim/D0/scenariodump.csv` - 460 MB
- `Output/dim/*/rawcube.csv` - 33~82 MB (각각)

### Exposure/longterm
- `Output/longterm_1/scenariodump.csv` - 2.2 GB
- `Output/longterm_2/scenariodump.csv` - 2.2 GB

### ExposureWithCollateral
- `Output/*/cube.csv.gz` - 20 MB (각각)
- `Output/*/netcube.csv` - 4~40 MB (각각)

### CreditRisk/CreditPortfolioModel
- `Output/CreditPortfolioModel/cube.dat` - 18 MB
- `Output/CreditPortfolioModel/cube.csv.gz` - 7.5 MB

## 이 파일들을 얻는 방법

### ORE 실행으로 생성
```bash
# 해당 예제 디렉토리에서
cd /home/keehyun/dev/Engine/Examples/[카테고리]
python3 run_[예제].py
```

### 직접 ORE 실행
```bash
ore Input/[예제].xml
```

## 왜 제외했나요?

1. **저장소 크기**: 대용량 파일들은 Git 저장소 크기를 급격히 증가시킵니다
2. **클론 속도**: 대용량 파일들이 있으면 클론하는데 오래 걸립니다
3. **재생산 가능**: 이 파일들은 ORE를 실행하면 언제든 다시 생성할 수 있습니다
4. **네트워크 전송**: 대용량 파일로 인해 push/pull가 자주 실패합니다

## 포함된 파일

다른 중요한 출력 파일들은 모두 포함되어 있습니다:
- `README_korean.md` - 한국어 설명서
- `exposure_*.csv` - 노출 프로파일
- `xva.csv` - XVA 계산 결과
- `npv.csv` - 현재 가치
- `flows.csv` - 현금흐름
- `todaysmarketcalibration.csv` - 시장 캘리브레이션
- `*.pdf` - 시각화 차트
- 기타 분석 결과 파일
