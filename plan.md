# ORE REST API 개발 요청서 (AI 에이전트용)

## 프로젝트 개요

Open Source Risk Engine(ORE)을 백엔드 계산 엔진으로 사용하여 REST API 서비스를 개발한다.
ORE는 파일 기반(XML / CSV / 설정파일)으로 동작하므로, API 서버는 요청을 받아 입력 파일을 생성하고 ORE 실행 후 결과를 JSON 및 파일 형태로 반환한다.

---

# 목표

다음 기능을 제공하는 운영 가능한 API 서버를 개발한다.

1. 배치 작업(Job) 관리
2. 실행 로그 조회
3. 결과 파일 다운로드

---

# 필수 기술 스택

## 백엔드

* Python 3.12+
* FastAPI
* Pydantic
* Uvicorn

## 비동기 작업

* Celery 또는 RQ

## 저장소

* SQLite (개발용)

## 실행 방식

* ORE CLI 프로그램 subprocess 실행

---

# 아키텍처 요구사항

```text
Client
 ↓
REST API Server
 ↓
Redis Queue
 ↓
Worker
 ↓
ORE Engine
 ↓
Storage / DB
```

---

# 개발 요구사항

## 1. REST API 목록

### 작업 생성

POST /jobs

Request:

```json
{
  "jobType": "npv",
  "template": "pricing-basic",
  "inputs": {
    "portfolio": {},
    "market": {},
    "parameters": {}
  }
}
```

Response:

```json
{
  "jobId": "uuid",
  "status": "queued"
}
```

---

### 상태 조회

GET /jobs/{jobId}

Response:

```json
{
  "jobId": "uuid",
  "status": "queued | running | completed | failed",
  "progress": 0,
  "createdAt": "",
  "updatedAt": ""
}
```

---

### 결과 조회

GET /jobs/{jobId}/result

Response:

```json
{
  "summary": {
    "npv": 12345.67
  },
  "files": [
    "npv.csv",
    "log.txt"
  ]
}
```

---

### 로그 조회

GET /jobs/{jobId}/logs

---

### 파일 다운로드

GET /jobs/{jobId}/files/{filename}

---

# 2. Job 상태값

* queued
* running
* completed
* failed
* cancelled

---

# 3. 디렉토리 구조

```text
/app
  /api
  /models
  /schemas
  /services
  /workers
  /templates
  /storage
/jobs
  /{jobId}
      /input
      /output
```

---

# 4. ORE 실행 방식

Python subprocess 사용.

예시:

```python
subprocess.run(
    ["OREApp", "ore.xml"],
    cwd=job_input_dir,
    timeout=600
)
```

필수 처리:

* timeout
* stderr 캡처
* exit code 확인
* 로그 저장

---

# 5. 템플릿 시스템

ORE 입력파일은 직접 사용자가 작성하지 않도록 한다.

지원 템플릿 예:

* pricing-basic
* xva-standard
* stress-ir-up
* stress-ir-down

사용자 입력 JSON → 내부 XML 생성 방식으로 구현한다.

---

# 6. 데이터베이스 테이블

jobs 테이블:

* id
* job_type
* status
* progress
* request_json
* result_json
* created_at
* updated_at

---

# 7. 에러 처리

표준 에러 응답:

```json
{
  "error": {
    "code": "JOB_FAILED",
    "message": "ORE execution failed"
  }
}
```

---

# 8. 보안 요구사항

* Swagger 활성화
* 파일 경로 traversal 방지

---

# 11. 산출물

반드시 아래 항목 제공:

1. 전체 소스코드
2. requirements.txt
5. README.md
6. 샘플 요청 예제
7. 실행 방법

---

# 12. 코딩 원칙

* 유지보수 가능한 구조
* 서비스 계층 분리
* 타입힌트 사용
* 예외처리 명확히
* 로그 충분히 남길 것

---

참고하세요. 
C:\dev\Engine\Examples\CurveBuilding\run_prime.py
