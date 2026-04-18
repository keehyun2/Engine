# CDS Par 스트레스 (CDS Par Stress) 출력 설명

## 예제 개요

이 예제는 CDS(Credit Default Swap)의 Par 스프레드에 대한 스트레스 테스트를 수행합니다.

---

## 핵심 금융 용어

### CDS (Credit Default Swap)
- **정의**: 신용 리스크를 보험하는 파생상품
- **구조**: 보호매수자(Protection Buyer)가 프리미엄을 지급하고, 신용사건 발생 시 보호매도자(Protection Seller)가 보상
- **Par Spread**: CDS가 NPV=0이 되는 스프레드

---

## 출력 파일

ParStress/valid_cds 폴더에 CDS 상품의 Par 스트레스 결과가 저장됩니다.

---

## 실행 방법

```bash
ore Input/ore_parstress_cds.xml
```

---

## 참고 자료

- **ORE User Guide**: CDS 스트레스 테스트
