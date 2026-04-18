# 크레딧 파생상품 노출 분석 (Credit Derivatives Exposure) 출력 설명

## 예제 개요

이 예제는 크레딧 파생상품(CDS)의 미래 노출을 계산합니다.

---

## 핵심 금융 용어

### Credit Exposure (신용 노출)
- **CDS (Credit Default Swap)**: 신용 리스크 보험
- **Protection Seller**: 보험 판매자 (프리미엄 수취, 리스크 부담)
- **Protection Buyer**: 보험 구매자 (프리미엄 지급, 리스크 보호)

### CDS Exposure
- **Credit Event 발생 시**: Protection Seller가 Notional을 지급
- **노출**: Notional - Accrued Premium (상환되지 않은 프리미엄)

---

## 출력 파일 상세 설명

### 1. exposure_trade_CDS.csv
**용도**: CDS 노출 분석

---

## 실행 방법

```bash
cd /home/keehyun/dev/Engine/Examples/Exposure
ore Input/ore_credit.xml
```

---

## 참고 자료

- **ORE User Guide**: 크레딧 노출 장
