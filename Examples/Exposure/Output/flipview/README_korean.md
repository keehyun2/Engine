# Flip View 예제

## 개요
Flip View는 XVA 계산 시 은행과 카운터파티의 관점을 쉽게 전환할 수 있게 해주는 기능입니다.

## Flip View란?

1. **Normal View** (은행 관점)
2. **Reversed View** (카운터파티 관점)

이를 통해 양측의 XVA를 대칭적으로 검증할 수 있습니다.

## 출력 디렉토리
- `normal/` - 은행 관점 결과
- `reversed/` - 카운터파티 관점 결과

## 실행 방법
```bash
cd /home/keehyun/dev/Engine/Examples/Exposure
python3 run_flipview.py
```

*출력 파일은 ORE 실행으로 생성하세요.*
