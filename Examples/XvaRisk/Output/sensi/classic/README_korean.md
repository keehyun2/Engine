# XVA 민감도 분석 (XVA Sensitivity Analysis) 출력 설명

## 예제 개요

이 예제는 XVA의 시장 리스크 요인에 대한 민감도 분석을 수행합니다. 금리, 크레딧 스프레드 등이 변할 때 XVA가 어떻게 변하는지 분석합니다.

---

## 핵심 금융 용어

### XVA Sensitivity
- **정의**: 시장 리스크 요인 변화에 대한 XVA의 민감도
- **주요 리스크 요인**:
  - 금리 (Interest Rate)
  - 크레딧 스프레드 (Credit Spread)
  - 환율 (FX Rate)
  - 변동성 (Volatility)

### Jacobian Matrix
- **정의**: 시장 요인과 XVA 간의 민감도 행렬
- **용도**: XVA 헷징 비율 계산

### FCA/FBA/DVA/CVA 민감도
- **FCA (Funding Cost Adjustment)**: 자금 조달 비용 조정 민감도
- **FBA (Funding Benefit Adjustment)**: 자금 조달 혜택 조정 민감도
- **DVA (Debt Value Adjustment)**: 부채 가치 조정 민감도
- **CVA (Credit Valuation Adjustment)**: 신용 가치 조정 민감도

---

## 출력 파일 상세 설명

### 1. xva_sensi_jacobi.csv
**용도**: XVA 민감도 야코비안 행렬

| 리스크 요인 | CVA | DVA | FCA | FBA |
|------------|-----|-----|-----|-----|
| USD_IR_1Y | ΔCVA/ΔIR | ΔDVA/ΔIR | ... | ... |
| USD_CS_5Y | ... | ... | ... | ... |

**해석 예시**:
```
리스크 요인: USD 5Y 금리
CVA 변화: +10,000 USD (금리 1bp ↑ → CVA 1만 USD ↑)
```

---

### 2. xva_sensi_jacobi_inverse.csv
**용도**: 야코비안 역행렬 (헷징 비율 계산용)

---

### 3. xva_zero_sensitivity_fca.csv
**용도**: FCA의 제로 금리 민감도

---

### 4. xva_zero_sensitivity_fba.csv
**용도**: FBA의 제로 금리 민감도

---

### 5. xva_par_sensitivity_cva.csv
**용도**: CVA의 Par 금리 민감도

---

### 6. xva_par_sensitivity_dva.csv
**용도**: DVA의 Par 금리 민감도

---

### 7. xva_par_sensitivity_fca.csv
**용도**: FCA의 Par 금리 민감도

---

### 8. xva_par_sensitivity_dva.csv
**용도**: FBA의 Par 금리 민감도

---

### 9. xva.csv
**용도**: XVA 분해 결과

| 항목 | 설명 |
|------|------|
| CVA | 신용 가치 조정 |
| DVA | 부채 가치 조정 |
| FCA | 자금 조달 비용 조정 |
| FBA | 자금 조달 혜택 조정 |
| Total XVA | 총 XVA |

---

### 10. exposure_*.csv
**용도**: 노출 분석 결과

---

## XVA 민감도 실무 활용

### 1. XVA 헷징
- **금리 리스크 헷징**: 금리 선물/스왑
- **크레딧 리스크 헷징**: CDS, TRS
- **환 리스크 헷징**: FX 선물

### 2. 리스크 한도 설정
- XVA 민감도 기반 한도
- 극단 시나리오 분석

### 3. 가격 책정
- XVA 비용을 가격에 반영
- 고객별 XVA 조정

---

## XVA 구조

```
Total XVA = CVA + DVA + FCA + FBA + ColVA + ...

CVA (Credit Valuation Adjustment)
- 카운터파티 디폴트 리스크

DVA (Debt Valuation Adjustment)
- 자사 디폴트 리스크 (혜택)

FBA/FCA (Funding Benefits/Costs Adjustment)
- 자금 조달 차이 조정

ColVA (Collateral Valuation Adjustment)
- 담보 가치 조정

KVA (Capital Valuation Adjustment)
- 자본 비용 조정
```

---

## 실행 방법

```bash
cd /home/keehyun/dev/Engine/Examples/XvaRisk
ore Input/ore_sensi_classic.xml
```

---

## 출력 파일 위치

```
Output/sensi/classic/
├── xva_sensi_jacobi.csv            # 야코비안 행렬
├── xva_sensi_jacobi_inverse.csv    # 역행렬
├── xva_zero_sensitivity_*.csv      # 제로 금리 민감도
├── xva_par_sensitivity_*.csv       # Par 금리 민감도
├── xva.csv                         # XVA 분해
├── exposure_*.csv                  # 노출 분석
├── npv.csv                         # 순현재가치
└── marketdata.csv                  # 시장 데이터
```

---

## 참고 자료

- **ORE User Guide**: XVA 민감도 장
- **Gregory, Jon**: "The xVA Challenge: Counterparty Risk and Funding"
