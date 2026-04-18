# 제로-파 시프트 (Zero to Par Shift) 출력 설명

## 예제 개요

이 예제는 Zero Rate의 시프트를 Par Rate의 시프트로 변환합니다. 제로 곡선이 변할 때 Par 곡선이 어떻게 변하는지 계산합니다.

---

## 핵심 금융 용어

### Zero to Par Shift
- **정의**: Zero Rate 시프트가 Par Rate에 미치는 영향 계산
- **용도**: Zero 기반 헷징을 Par 기반 헷징으로 변환
- **원리**: 제로 곡선이 평행이동하면 Par 곡선도 비슷하게 이동하지만 정확히 같지는 않음

### Par Shifts
- **정의**: 각 만기별 Par Rate 시프트
- **계산**: Zero 시프트 → Jacobian 행렬 → Par 시프트

---

## 출력 파일 상세 설명

### 1. parshifts.csv
**용도**: 제로 시프트에 따른 Par 시프트

| 컬럼 | 설명 |
|------|------|
| Zero Tenor | 제로 곡선 만기 |
| Par Tenor | Par 곡선 만기 |
| Zero Shift | 제로 시프트 크기 |
| Par Shift | Par 시프트 크기 |
| Ratio | Par/Zero 비율 |

**해석 예시**:
```
Zero Tenor: 10Y
Par Tenor: 10Y
Zero Shift: +100bp
Par Shift: +95bp
Ratio: 0.95
```
- 제로 10Y가 100bp 상승하면 Par 10Y는 95bp 상승

---

### 2. todaysmarketcalibration.csv
**용도**: 시장 보정 결과

---

## Zero vs Par 시프트

| 만기 | Zero +100bp → Par 변화 |
|------|------------------------|
| 1Y | +98bp |
| 2Y | +96bp |
| 5Y | +94bp |
| 10Y | +92bp |
| 30Y | +88bp |

**패턴**: 장기일수록 Par 시프트가 Zero 시프트보다 약간 작음

---

## 실행 방법

```bash
cd /home/keehyun/dev/Engine/Examples/MarketRisk
ore Input/ore_zerotoparshift.xml
```

---

## 출력 파일 위치

```
Output/ZeroToParShift/
├── parshifts.csv                 # Par 시프트 결과
└── todaysmarketcalibration.csv   # 시장 보정
```

---

## 참고 자료

- **ORE User Guide**: Zero-Par 변환 장
