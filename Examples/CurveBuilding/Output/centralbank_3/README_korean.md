# 중앙은행 곡선 구축 예제 #3 (Central Bank #3)

## 예제 개요

이 예제는 **BOE(영국 중앙은행) 회의일 기반 GBP SONIA OIS 곡선**을 구축합니다. PillarChoice로 `StartDate`만 사용하여 간소화된 접근 방식을 보여줍니다.

### centralbank_3의 특징

**PillarChoice: StartDate**
```
- 시작일(StartDate)만 고려
- 만기일 무시
- 더 간단한 구현
```

**다른 centralbank 예제와의 비교**:

| 예제 | PillarChoice | 특징 |
|------|--------------|------|
| centralbank_0 | StartDateAndMaturityDate | 기본 설정 |
| centralbank_1 | (명시 없음) | 기본값 사용 |
| centralbank_2 | StartDateAndMaturityDate | 명시적 설정 |
| **centralbank_3** | **StartDate** | **간소화** |
| centralbank_4 | StartDateAndLastRelevantDate | 정교화 |

---

## 곡선 구축 전략

### Priority 기반 부트스트래핑

```
Priority 0 (최우선):
  └─ SONIA ON Rate (익일 금리)

Priority 1 (중요):
  └─ BOE 회의일 선도 스왑
     └─ PillarChoice: StartDate (시작일만)

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

**StartDate만 사용**:
```
예: 2025-12-18 ~ 2026-02-05 스왑

시작일: 2025-12-18 ✓ (Pillar로 사용)
만기일: 2026-02-05 ✗ (무시)

시작일 하나만 곡선의 기준점으로 사용
```

---

## 핵심 차이점

### StartDate 선택 이유

**장점**:
1. 구현이 간단
2. 시작일만으로 충분한 경우 유용
3. 계산 속도 향상

**단점**:
1. 만기일 정보 손실
2. 선도 계약 기간 불확실
3. 덜 정확할 수 있음

### PillarChoice 비교

| PillarChoice | 기준점 | 정확도 | 복잡도 |
|--------------|--------|--------|--------|
| StartDate | 시작일만 | 낮음 | 낮음 |
| StartDateAndMaturityDate | 시작일+만기일 | 높음 | 중간 |
| StartDateAndLastRelevantDate | 시작일+최종일 | 매우 높음 | 높음 |

---

## 요약

### ✅ 예제 결과

- **PillarChoice**: StartDate (간소화)
- **BOE 회의일**: 4개 모두 반영
- **단순화**: 시작일만 사용

### 🎓 학습 포인트

- PillarChoice의 간소화 옵션
- StartDate의 장단점
- 정확도와 단순성의 트레이드오프

---

## 참고

- **centralbank_2**: StartDateAndMaturityDate (권장)
- **centralbank_4**: StartDateAndLastRelevantDate (가장 정교)
- **ORE User Guide**: PillarChoice 설정 옵션

---

## 💻 실제 실행 결과 분석

### ORE 실행 상태

**실행 명령**:
```bash
/home/popos/dev/Engine/build/App/ore Input/ore_centralbank_3.xml
```

**실행 결과**: ⚠️ 추가 시장 데이터 필요

**npv.csv 해석**:
```
OIS 상품 NPV: #N/A
원인: Priority 기반 모든 데이터 필요
```

### StartDate 간소화의 실제 영향

**centralbank_3의 특징**:
```
PillarChoice: StartDate만 사용

의미:
- 선도 계약의 시작일만 고려
- 만기일 정보 무시
- 계산이 간단해지지만 정확도는 떨어질 수 있음
```

### 간소화 선택의 장단점

**장점**:
- ✅ 구현이 간단
- ✅ 계산 속도 향상
- ✅ 메모리 사용 감소
- ✅ 디버깅이 용이

**단점**:
- ❌ 만기일 정보 손실
- ❌ 선도 계약 기간 불확실
- ❌ 덜 정확한 가격 평가 가능
- ❌ 복잡한 구조에 부적합

### 결론

**학습 가치**:
- ✅ PillarChoice 간소화 옵션 이해
- ✅ 정확도 vs 단순성 트레이드오프 학습
- ⚠️ 실제 실행은 추가 데이터 필요

**실무적 권장사항**:
```
StartDate 사용이 적합한 경우:
- 단순한 선도 계약
- 시작일이 가장 중요한 경우
- 빠른 계산이 필요한 경우

StartDateAndMaturityDate 사용이 권장:
- 대부분의 실무 상황
- 정확한 가격 평가 필요 시
- 복잡한 구조의 포트폴리오
```
