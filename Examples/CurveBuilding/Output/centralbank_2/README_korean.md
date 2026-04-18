# 중앙은행 곡선 구축 예제 #2 (Central Bank #2)

## 예제 개요

이 예제는 **BOE(영국 중앙은행) 회의일 기반 GBP SONIA OIS 곡선**을 구축합니다. PillarChoice로 `StartDateAndMaturityDate`를 명시적으로 사용합니다.

### centralbank_2의 특징

**PillarChoice: StartDateAndMaturityDate**
```
- 시작일(StartDate)와 만기일(MaturityDate) 모두 고려
- 선도 계약의 기간을 정확히 반영
- 가장 일반적이고 정확한 설정
```

**다른 centralbank 예제와의 비교**:

| 예제 | PillarChoice | 특징 |
|------|--------------|------|
| centralbank_0 | StartDateAndMaturityDate | 기본 설정 |
| centralbank_1 | (명시 없음) | 기본값 사용 |
| **centralbank_2** | **StartDateAndMaturityDate** | **명시적 설정** |
| centralbank_3 | StartDate | 시작일만 |
| centralbank_4 | StartDateAndLastRelevantDate | 마지막 관련일 |

---

## 곡선 구축 전략

### Priority 기반 부트스트래핑

```
Priority 0 (최우선):
  └─ SONIA ON Rate (익일 금리)

Priority 1 (중요):
  └─ BOE 회의일 선도 스왑
     └─ PillarChoice: StartDateAndMaturityDate

Priority 2 (보조):
  ├─ 단기 OIS (1W~2M)
  └─ 표준 OIS (3M~5Y)
```

### BOE 회의일 스왑

**Quote 형식**:
```
IR_SWAP/RATE/GBP/[시작일]/1D/[만기일]

예시:
IR_SWAP/RATE/GBP/20251218/1D/20260205
```

**PillarChoice 차이**:

| PillarChoice | 기준점 | 설명 |
|--------------|--------|------|
| StartDate | 시작일만 | 시작일 기준으로만 처리 |
| StartDateAndMaturityDate | 시작일+만기일 | **기간 모두 고려** |
| StartDateAndLastRelevantDate | 시작일+최종일 | 마지막 현금흐름일 고려 |

---

## 핵심 차이점

### StartDateAndMaturityDate 선택 이유

**장점**:
1. 선도 계약의 기간 정확히 반영
2. 시작일과 만기일 간의 관계 고려
3. 가장 일반적인 선도 계약 처리

**Pillar 위치**:
```
예: 2025-12-18 ~ 2026-02-05 스왑

StartDate: 2025-12-18
MaturityDate: 2026-02-05

두 날짜 모두 곡선의 기준점(Pillar)으로 사용
```

---

## 요약

### ✅ 예제 결과

- **PillarChoice**: StartDateAndMaturityDate (명시적)
- **BOE 회의일**: 4개 모두 반영
- **기간 고려**: 시작일과 만기일 모두 사용

### 🎓 학습 포인트

- PillarChoice의 명시적 설정
- StartDateAndMaturityDate의 장점
- 선도 계약 기간의 정확한 반영

---

## 참고

- **centralbank_3**: StartDate만 사용 (간소화)
- **centralbank_4**: StartDateAndLastRelevantDate (정교화)
- **ORE User Guide**: PillarChoice 설정 옵션

---

## 💻 실제 실행 결과 분석

### ORE 실행 상태

**실행 명령**:
```bash
/home/popos/dev/Engine/build/App/ore Input/ore_centralbank_2.xml
```

**실행 결과**: ⚠️ 추가 시장 데이터 필요

**npv.csv 해석**:
```
OIS 상품 NPV: #N/A
원인: Priority 2 표준 OIS에 대한 시장 데이터 부족
```

### PillarChoice 차이에 따른 영향

**centralbank_2의 특징**:
```
PillarChoice: StartDateAndMaturityDate (명시적)

의미:
- 선도 계약의 시작일과 만기일을 모두 고려
- 계약 기간 전체를 곡선에 반영
- centralbank_1과 동일한 결과 기대 (설정만 명시적)
```

### centralbank 시리즈 실행 가능성

| 예제 | PillarChoice | 실행 가능성 | 설명 |
|------|--------------|-------------|------|
| centralbank_0 | Default | ✅ 가능 | 최소 데이터로 작동 |
| centralbank_1 | Default | ⚠️ 데이터 필요 | Priority 2 추가 |
| centralbank_2 | StartDateAndMaturityDate | ⚠️ 데이터 필요 | 명시적 설정 |
| centralbank_3 | StartDate | ⚠️ 데이터 필요 | 간소화 |
| centralbank_4 | StartDateAndLastRelevantDate | ⚠️ 데이터 필요 | 정교화 |

### 결론

**학습 가치**:
- ✅ PillarChoice 명시적 설정 방법 학습
- ✅ StartDateAndMaturityDate의 장점 이해
- ⚠️ 실제 실행은 추가 데이터 필요

**실무적 팁**:
```
명시적 PillarChoice 설정의 장점:
1. 코드 가독성 향상
2. 의도가 명확히 드러남
3. 다른 개발자에게 혼동 주지 않음
4. 버전 추적 시 용이

추천: 중요한 설정은 항상 명시적으로 지정
```
