# 상품 파생상품 노출 분석 (Commodity Derivatives Exposure) 출력 설명

## 예제 개요

이 예제는 상품 파생상품(옵션, 선물, 스왑, 스왑티온)의 미래 노출을 계산합니다.

---

## 핵심 금융 용어

### Commodity Exposure (상품 노출)
- **기초 자산**: 원유, 가스, 금속, 농산물
- **특징**: 계절성, 저장비용, 편의 수익률

---

## 출력 파일 상세 설명

### 1. exposure_trade_CommodityAPO.csv
**용도**: Asian Peak Option 노출

---

### 2. exposure_trade_CommodityForward.csv
**용도**: 상품 선물 노출

---

### 3. exposure_trade_CommodityOption.csv
**용도**: 상품 옵션 노출

---

### 4. exposure_trade_CommoditySwaption.csv
**용도**: 상품 스왑티온 노출

---

## 실행 방법

```bash
cd /home/keehyun/dev/Engine/Examples/Exposure
ore Input/ore_commodity.xml
```

---

## 참고 자료

- **ORE User Guide**: 상품 노출 장
