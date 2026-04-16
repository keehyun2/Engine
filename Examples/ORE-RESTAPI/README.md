# ORE REST API

Open Source Risk Engine(ORE)을 백엔드 계산 엔진으로 사용하는 REST API 서비스입니다.

## 아키텍처

```
Client → REST API (FastAPI) → Redis Queue (RQ) → Worker → ORE Engine (subprocess) → Storage/DB
```

## 기술 스택

- **Python 3.12+**
- **FastAPI** - REST API 프레임워크
- **SQLAlchemy** - ORM (SQLite)
- **RQ (Redis Queue)** - 비동기 작업 큐
- **Jinja2** - ORE XML 템플릿 생성
- **Pydantic** - 데이터 검증

## 설치 및 실행

### 1. 의존성 설치

```bash
cd Examples/ORE-RESTAPI
pip install -r requirements.txt
```

### 2. ORE 실행파일 설정

ORE 실행파일 경로를 환경변수로 설정하거나, 자동 탐색됩니다.

```bash
# Windows
set ORE_PATH=C:\dev\Engine\App\bin\x64\Release\ore.exe

# Linux/Mac
export ORE_PATH=/path/to/ore
```

### 3. 서버 실행 (개발 모드)

DEV_MODE=True (기본값)로 Redis 없이 실행 가능합니다.

```bash
python run_server.py
```

서버 시작 후 Swagger UI: http://localhost:8000/docs

### 4. 프로덕션 모드 (Redis 필요)

```bash
# Redis 실행
redis-server

# 워커 실행
python run_worker.py

# 서버 실행 (DEV_MODE=False)
set ORE_DEV_MODE=False
python run_server.py
```

## API 엔드포인트

| Method | Path | 설명 |
|--------|------|------|
| POST | `/jobs` | 작업 생성 |
| GET | `/jobs/{jobId}` | 상태 조회 |
| GET | `/jobs/{jobId}/result` | 결과 조회 |
| GET | `/jobs/{jobId}/logs` | 로그 조회 |
| GET | `/jobs/{jobId}/files/{filename}` | 파일 다운로드 |
| POST | `/jobs/{jobId}/cancel` | 작업 취소 |

## 요청 예시

### NPV 계산

```bash
curl -X POST http://localhost:8000/jobs \
  -H "Content-Type: application/json" \
  -d @sample_requests/pricing_npv.json
```

### 상태 조회

```bash
curl http://localhost:8000/jobs/{jobId}
```

### 결과 조회

```bash
curl http://localhost:8000/jobs/{jobId}/result
```

### 파일 다운로드

```bash
curl -O http://localhost:8000/jobs/{jobId}/files/npv.csv
```

## 템플릿

| 템플릿 | 설명 | 활성 Analytics |
|--------|------|----------------|
| `pricing-basic` | 기본 가격 계산 | NPV, Cashflow |
| `xva-standard` | XVA 계산 (시뮬레이션 포함) | NPV, Cashflow, Curves, Simulation, XVA |
| `stress-ir-up` | 금리 상승 스트레스 테스트 | NPV, Cashflow, Curves, Stress |
| `stress-ir-down` | 금리 하락 스트레스 테스트 | NPV, Cashflow, Curves, Stress |

## 환경설정

| 변수 | 기본값 | 설명 |
|------|--------|------|
| `ORE_PATH` | 자동 탐색 | ORE 실행파일 경로 |
| `ORE_TIMEOUT_SECONDS` | 600 | 실행 타임아웃 (초) |
| `ORE_DATABASE_URL` | `sqlite:///./ore_api.db` | 데이터베이스 URL |
| `ORE_REDIS_URL` | `redis://localhost:6379/0` | Redis URL |
| `ORE_DEV_MODE` | `True` | 개발 모드 (Redis 불필요) |

## 프로젝트 구조

```
ORE-RESTAPI/
  app/
    api/          # API 라우트
    models/       # SQLAlchemy 모델
    schemas/      # Pydantic 스키마
    services/     # 비즈니스 로직
    workers/      # RQ 워커
  templates/      # Jinja2 XML 템플릿
  jobs/           # 런타임 작업 디렉토리
  sample_requests/ # 샘플 요청 JSON
```
