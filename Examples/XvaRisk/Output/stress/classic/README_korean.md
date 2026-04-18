# XVA 스트레스 테스트 (XVA Stress Test) 출력 설명

## 예제 개요

이 예제는 XVA에 대한 스트레스 테스트를 수행합니다. 극단적인 시장 상황에서 XVA가 어떻게 변하는지 분석합니다.

---

## 핵심 금융 용어

### XVA Stress Test
- **정의**: 극단적 시장 시나리오에서의 XVA 변화 분석
- **목적**:
  - 최악의 경우 XVA 손실 추정
  - 리스크 한도 설정
  - 규제 요구사항 준수

### Stress Scenarios
- **Credit Spread Shock**: 크레딧 스프레드 급등
- **FX Shock**: 환율 급변동
- **Interest Rate Shock**: 금리 급등/급락
- **Volatility Spike**: 변동성 급증

---

## 출력 파일 상세 설명

### 1. xva.csv
**용도**: 스트레스 시나리오별 XVA 결과

| 시나리오 | Base XVA | Stressed XVA | 차이 |
|----------|-----------|--------------|------|
| Base | 1,000,000 | - | - |
| Credit_Shock | 1,000,000 | 1,500,000 | +500,000 |
| FX_Shock | 1,000,000 | 1,200,000 | +200,000 |

---

### 2. exposure_*.csv
**용도**: 스트레스 시나리오별 노출 분석

- **exposure_nettingset_CPTY_A.csv**: 네팅 집합 노출
- **exposure_trade_*.csv**: 개별 상품 노출

---

### 3. npv.csv
**용도**: 각 상품의 순현재가치

---

## 주요 스트레스 시나리오

### 1. Credit Spread Shock
- **크레딧 스프레드 +500bp**
- CVA 급증 → 손실

### 2. FX Shock
- **환율 ±20%**
- Cross Currency XVA 변동

### 3. Interest Rate Shock
- **금리 ±200bp**
- FCA/FBA 변동

### 4. Volatility Spike
- **변동성 +50%**
- 옵션 내장 XVA 변동

---

## 실무 활용

### 1. 리스크 관리
- 최악의 경우 XVA 손실 파악
- 헷징 전략 수립
- 리스크 한도 설정

### 2. 규제 준수
- **SICR/SRI**: Specific/General Risk
- **CCAR**: 연준 스트레스 테스트
- **EBA Stress Test**: 유럽 스트레스 테스트

### 3. 자본 계획
- 극단 상황 자본 요구금액
- 손실 흡수 능력 평가

---

## 실행 방법

```bash
cd /home/keehyun/dev/Engine/Examples/XvaRisk
ore Input/ore_stress_classic.xml
```

---

## 출력 파일 위치

```
Output/stress/classic/
├── xva.csv                         # 스트레스 XVA 결과
├── exposure_*.csv                  # 스트레스 노출 분석
├── npv.csv                         # 순현재가치
└── marketdata.csv                  # 시장 데이터
```

---

## XVA 스트레스 테스트 구조

```
스트레스 테스트
├── 1. 기준 시나리오 (Base)
│   └── 현재 시장 데이터
├── 2. 스트레스 시나리오 적용
│   ├── 크레딧 스프레드 시프트
│   ├── 환율 시프트
│   ├── 금리 시프트
│   └── 변동성 시프트
└── 3. XVA 재계산
    ├── Base vs Stressed 비교
    └── 차이 분석
```

---

## 참고 자료

- **ORE User Guide**: XVA 스트레스 테스트 장
- **BCBS 239**: 스트레스 테스트 가이드라인
