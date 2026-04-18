# 주식 파생상품 노출 분석 (Equity Derivatives Exposure) 출력 설명

## 예제 개요

이 예제는 주식 파생상품(옵션, 선물, 스왑)의 미래 노출을 계산합니다.

---

## 핵심 금융 용어

### Equity Exposure (주식 노출)
- **기초 자산**: 주가 지수 (S&P 500, DAX 등)
- **리스크 요인**: 주가 방향성, 변동성, 배당

### Equity Option Exposure
- **Call Option**: 주가 상승 시 노출 ↑
- **Put Option**: 주가 하락 시 노출 ↑

### Equity Swap Exposure
- **Equity Swap**: 주가 수익률 ↔ 금리 교환
- **노출**: 주가 하락 시 지급 측 노출 ↑

---

## 출력 파일 상세 설명

### 1. exposure_trade_EqCall_SP5.csv
**용도**: S&P 500 콜 옵션 노출

---

### 2. exposure_trade_EqPut_SP5.csv
**용도**: S&P 500 풋 옵션 노출

---

### 3. exposure_trade_EquitySwap_*.csv
**용도**: 주식 스왑 노출

---

## 실행 방법

```bash
cd /home/keehyun/dev/Engine/Examples/Exposure
ore Input/ore_equity.xml
```

---

## 참고 자료

- **ORE User Guide**: 주식 노출 장
