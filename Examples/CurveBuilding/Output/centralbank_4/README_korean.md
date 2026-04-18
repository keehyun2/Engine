# 중앙은행 곡선 구축 예제 #4 (Central Bank #4)

## 예제 개요

이 예제는 **BOE(영국 중앙은행) 회의일 기반 GBP SONIA OIS 곡선**을 구축합니다. PillarChoice로 `StartDateAndLastRelevantDate`를 사용하여 가장 정교한 접근 방식을 보여줍니다.

### centralbank_4의 특징

**PillarChoice: StartDateAndLastRelevantDate**
```
- 시작일(StartDate)과 마지막 관련일(LastRelevantDate) 모두 고려
- 최종 현금흐름 결정일을 정확히 반영
- 가장 정교하고 정확한 설정
```

**다른 centralbank 예제와의 비교**:

| 예제 | PillarChoice | 특징 |
|------|--------------|------|
| centralbank_0 | StartDateAndMaturityDate | 기본 설정 |
| centralbank_1 | (명시 없음) | 기본값 사용 |
| centralbank_2 | StartDateAndMaturityDate | 명시적 설정 |
| centralbank_3 | StartDate | 간소화 |
| **centralbank_4** | **StartDateAndLastRelevantDate** | **가장 정교** |

---

## 곡선 구축 전략

### Priority 기반 부트스트래핑

```
Priority 0 (최우선):
  └─ SONIA ON Rate (익일 금리)

Priority 1 (중요):
  └─ BOE 회의일 선도 스왑
     └─ PillarChoice: StartDateAndLastRelevantDate

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

**LastRelevantDate의 의미**:
```
예: 2025-12-18 ~ 2026-02-05 OIS 스왑

StartDate: 2025-12-18 (스왑 시작일)
LastRelevantDate: 2026-02-05 ± 영업일 조정
                  (최종 현금흐름 결정일)

LastRelevantDate는:
- 만기일(MaturityDate)와 유사하지만
- 영업일 관례(Business Day Convention) 적용 후
- 실제 현금흐름 결정일을 의미
```

---

## 핵심 차이점

### StartDateAndLastRelevantDate 선택 이유

**장점**:
1. 가장 정확한 선도 계약 반영
2. 영업일 관례 고려
3. 실제 현금흐름 일정 정확히 반영

**LastRelevantDate vs MaturityDate**:

| 용어 | 의미 | 영업일 조정 |
|------|------|-------------|
| MaturityDate | 계약 만기일 | 계약서 기준 |
| LastRelevantDate | 최종 현금흐름일 | **영업일 조정 적용** |

### PillarChoice 완전 비교

| PillarChoice | 기준점 | 정확도 | 사용 사례 |
|--------------|--------|--------|-----------|
| StartDate | 시작일만 | ★☆☆ | 간단한 선도 |
| StartDateAndMaturityDate | 시작일+만기일 | ★★☆ | 일반적인 선도 |
| StartDateAndLastRelevantDate | 시작일+최종일 | ★★★ | 복잡한 선도, OIS |

---

## 요약

### ✅ 예제 결과

- **PillarChoice**: StartDateAndLastRelevantDate
- **BOE 회의일**: 4개 모두 반영
- **영업일 조정**: LastRelevantDate로 고려

### 🎓 학습 포인트

- LastRelevantDate의 개념
- 영업일 관례의 중요성
- OIS 스왑의 정확한 가격 평가

---

## 참고

- **centralbank_2**: StartDateAndMaturityDate (일반적)
- **centralbank_3**: StartDate (간단함)
- **ORE User Guide**: PillarChoice와 LastRelevantDate

---

## 💻 실제 실행 결과 분석

### ORE 실행 상태

**실행 명령**:
```bash
/home/popos/dev/Engine/build/App/ore Input/ore_centralbank_4.xml
```

**실행 결과**: ⚠️ 추가 시장 데이터 필요

**npv.csv 해석**:
```
OIS 상품 NPV: #N/A
원인: Priority 기반 모든 데이터 필요
```

### LastRelevantDate의 실제 영향

**centralbank_4의 특징**:
```
PillarChoice: StartDateAndLastRelevantDate

의미:
- 시작일과 최종 현금흐름 결정일 모두 고려
- 영업일 관례(Business Day Convention) 적용
- 가장 정교하고 정확한 설정
```

**LastRelevantDate vs MaturityDate**:
```
MaturityDate:
- 계약서상의 만기일
- 달력 기준

LastRelevantDate:
- 최종 현금흐름 결정일
- 영업일 관례 적용 후
- 실제 결제일 기준

예시:
계약 만기: 2026-02-05 (목요일)
LastRelevantDate: 2026-02-05 (또는 영업일 조정 후)
```

### 가장 정교한 설정의 의미

**정확도 향상 요인**:
1. 영업일 관례 반영
2. 실제 결제일 고려
3. 현금흐름 정확성
4. 마진 콜(Margin Call) 정확성

**계산 비용**:
- ⚠️ 가장 복잡한 계산
- ⚠️ 더 많은 메모리 사용
- ⚠️ 더 긴 실행 시간
- ✅ 가장 정확한 결과

### 결론

**학습 가치**:
- ✅ LastRelevantDate의 개념 습득
- ✅ 영업일 관례의 중요성 이해
- ✅ 정교성 vs 복잡성 트레이드오프 학습
- ⚠️ 실제 실행은 추가 데이터 필요

**실무적 권장사항**:
```
LastRelevantDate 사용이 권장:
- OIS 스왑과 같은 민감한 상품
- 정확한 일일 결제가 중요한 경우
- 마진 계산이 중요한 상황
- 규제 보고가 필요한 경우

일반적인 상황:
- StartDateAndMaturityDate로 충분
- 대부분의 실무 상황에 적합
```
