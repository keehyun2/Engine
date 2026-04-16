# ORE REST API (Java/Spring Boot)

Open Source Risk Engine(ORE)을 백엔드 계산 엔진으로 사용하는 REST API 서비스의 Java/Spring Boot 구현입니다.

## 기술 스택

- **Java 21 (LTS)**
- **Spring Boot 3.2+**
- **Maven**
- **H2 Database** (인메모리, 개발용)
- **Spring Data JPA**
- **Thymeleaf** (XML 템플릿 렌더링)
- **Spring @Async** (비동기 작업 처리)
- **Lombok** (Boilerplate 감소)
- **Swagger/OpenAPI** (API 문서화)

## 아키텍처

```
Client → REST API (Spring Boot) → @Async → Worker Thread → ORE Subprocess → Storage/DB
```

## 프로젝트 구조

```
ore-rest-api/
├── pom.xml
├── src/main/java/com/ore/api/
│   ├── OreApiApplication.java    # 진입점
│   ├── config/                    # 설정 클래스
│   ├── controller/                # REST 컨트롤러
│   ├── service/                   # 비즈니스 로직
│   ├── repository/                # JPA 리포지토리
│   ├── model/                     # JPA 엔티티
│   ├── dto/                       # 요청/응답 DTO
│   └── exception/                 # 예외 처리
├── src/main/resources/
│   ├── application.yml            # Spring 설정
│   ├── templates/                 # Thymeleaf XML 템플릿
│   └── samples/                   # 샘플 요청 JSON
└── src/main/jobs/                 # 런타임 작업 디렉토리
```

## 설치 및 실행

### 1. 전제 조건

- JDK 21 이상
- Maven 3.9+
- ORE 실행파일 (ore.exe 또는 ore)

### 2. 빌드

```bash
cd ore-rest-api
mvn clean package
```

### 3. ORE 경로 설정

환경변수로 설정:

```bash
# Windows
set ORE_PATH=C:\dev\Engine\App\bin\x64\Release\ore.exe

# Linux/Mac
export ORE_PATH=/path/to/ore
```

또는 `application.yml`에서 설정:

```yaml
ore:
  executable:
    path: "/path/to/ore"
```

### 4. 실행

```bash
# JAR로 실행
java -jar target/ore-rest-api-1.0.0.jar

# 또는 Maven으로 실행
mvn spring-boot:run
```

서버가 `http://localhost:8080`에서 시작됩니다.

### 5. Swagger UI

API 문서 및 테스트: http://localhost:8080/swagger-ui/index.html

## API 엔드포인트

| Method | Path | 설명 |
|--------|------|------|
| POST | `/api/jobs` | 작업 생성 |
| GET | `/api/jobs/{jobId}` | 상태 조회 |
| GET | `/api/jobs/{jobId}/result` | 결과 조회 |
| GET | `/api/jobs/{jobId}/logs` | 로그 조회 |
| GET | `/api/jobs/{jobId}/files/{filename}` | 파일 다운로드 |
| POST | `/api/jobs/{jobId}/cancel` | 작업 취소 |

## 요청 예시

### NPV 계산

```bash
curl -X POST http://localhost:8080/api/jobs \
  -H "Content-Type: application/json" \
  -d @src/main/resources/samples/pricing-npv.json
```

응답:

```json
{
  "jobId": "550e8400-e29b-41d4-a716-446655440000",
  "status": "queued"
}
```

### 상태 조회

```bash
curl http://localhost:8080/api/jobs/{jobId}
```

### 결과 조회

```bash
curl http://localhost:8080/api/jobs/{jobId}/result
```

### 파일 다운로드

```bash
curl -O http://localhost:8080/api/jobs/{jobId}/files/npv.csv
```

## 템플릿

| 템플릿 | 설명 | 활성 Analytics |
|--------|------|----------------|
| `pricing-basic` | 기본 가격 계산 | NPV, Cashflow |
| `xva-standard` | XVA 계산 (시뮬레이션 포함) | NPV, Cashflow, Curves, Simulation, XVA |
| `stress-ir-up` | 금리 상승 스트레스 테스트 | NPV, Cashflow, Curves, Stress |
| `stress-ir-down` | 금리 하락 스트레스 테스트 | NPV, Cashflow, Curves, Stress |

## 설정

### application.yml

```yaml
ore:
  executable:
    path: ""              # ORE 실행파일 경로
    timeout-seconds: 600  # 실행 타임아웃
  jobs:
    base-dir: "./jobs"
  shared-input-dir: "../Input"

spring:
  datasource:
    url: jdbc:h2:mem:oredb
  task:
    execution:
      pool:
        core-size: 4
        max-size: 10
```

## 환경변수

| 변수 | 기본값 | 설명 |
|------|--------|------|
| `ORE_PATH` | (자동 탐색) | ORE 실행파일 경로 |
| `SERVER_PORT` | 8080 | 서버 포트 |

## 개발

### IDE로 실행

1. IntelliJ IDEA 또는 Eclipse에서 프로젝트 열기
2. `OreApiApplication.java`를 실행 가능한 클래스로 설정
3. 디버그 모드로 실행

### 핫 리로드

```bash
mvn spring-boot:run -Dspring-boot.run.fork=false
```

## 프로덕션 배포

### PostgreSQL 사용

`application.yml`에서:

```yaml
spring:
  datasource:
    url: jdbc:postgresql://localhost:5432/oredb
    username: ore
    password: your-password
  jpa:
    hibernate:
      ddl-auto: update
```

의존성 추가 (`pom.xml`):

```xml
<dependency>
    <groupId>org.postgresql</groupId>
    <artifactId>postgresql</artifactId>
</dependency>
```

### Docker

```dockerfile
FROM eclipse-temurin:21-jdk
COPY target/ore-rest-api-1.0.0.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]
```

## 라이선스

이 프로젝트는 ORE(Open Source Risk Engine) 프로젝트의 일부입니다.
