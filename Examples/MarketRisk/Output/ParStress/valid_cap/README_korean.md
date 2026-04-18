# Cap/Plloor Par 스트레스 (Cap/Floor Par Stress) 출력 설명

## 예제 개요

이 예제는 Cap/Floor 상품의 Par 금리에 대한 스트레스 테스트를 수행합니다.

---

## 핵심 금융 용어

### Cap (금리 상한)
- **정의**: 기준 금리가 상한가(Cap Rate)을 초과할 때 초과분을 지급하는 옵션
- **용도**: 금리 상승 리스크 헷징

### Floor (금리 하한)
- **정의**: 기준 금리가 하한가(Floor Rate)를 밑돌 때 부족분을 지급하는 옵션
- **용도**: 금리 하락 리스크 헷징

### Collar
- **정의**: Cap과 Floor를 동시에 보유
- **용도**: 금리를 일정 범위 내로 제한

---

## 출력 파일

ParStress/valid_cap 폴더에 Cap 상품의 Par 스트레스 결과가 저장됩니다.

---

## 실행 방법

```bash
ore Input/ore_parstress_cap.xml
```

---

## 참고 자료

- **ORE User Guide**: Cap/Floor 스트레스 테스트
