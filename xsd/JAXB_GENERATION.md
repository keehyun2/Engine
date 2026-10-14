# ORE XSD → JAXB 클래스 생성 방법

`xsd/` 폴더의 ORE 스키마들로부터 JAXB 바인딩 클래스를 생성하는 방법을 설명한다.

## 개요

| 항목 | 값 |
|---|---|
| 루트 스키마 | `input.xsd` (거의 모든 하위 스키마를 `xs:include`) |
| 생성 패키지 | `com.ibk.gcb.batch.trs.mvmn.ore` |
| 출력 위치 | `xsd/generated/com/ibk/gcb/batch/trs/mvmn/ore/` |
| 생성 파일 수 | 630개 `.java` (검증 시점 기준) |
| 바인딩 파일 | `xsd_bindings.xjb` (필수, 아래 참고) |

## 사전 조건

JDK에 포함된 `xjc`가 필요하다. 이 문서는 아래 버전으로 검증되었다.

```
C:\Program Files\jdk\bin\xjc.exe   (XJC 2.2.8, JDK 1.8)
```

확인:

```cmd
xjc -version
```

## 생성 방법

**명령 프롬프트(cmd)에서:**

```cmd
cd C:\Users\ibk\dev\Engine\xsd
rmdir /s /q generated
mkdir generated
"C:\Program Files\jdk\bin\xjc.exe" -encoding UTF-8 -d generated -p com.ibk.gcb.batch.trs.mvmn.ore -b xsd_bindings.xjb input.xsd
```

**Git Bash에서:**

```bash
cd /c/Users/ibk/dev/Engine/xsd
rm -rf generated && mkdir generated
"/c/Program Files/jdk/bin/xjc.exe" -encoding UTF-8 -d generated \
    -p com.ibk.gcb.batch.trs.mvmn.ore -b xsd_bindings.xjb input.xsd
```

옵션 설명:

| 옵션 | 의미 |
|---|---|
| `-encoding UTF-8` | **필수.** 생략하면 이 시스템 xjc가 cp949로 파일을 써서 javadoc 한글 주석이 깨지고 컴파일 실패 |
| `-d generated` | 출력 디렉토리 (사전에 mkdir 필요, 없으면 에러) |
| `-p com.ibk.gcb.batch.trs.mvmn.ore` | 생성될 Java 패키지 |
| `-b xsd_bindings.xjb` | 외부 바인딩 파일 (없으면 아래 충돌들로 생성 실패) |

## xsd_bindings.xjb 필수 커스터마이징

xjc 2.2.8로 이 스키마 셋을 컴파일하면 3종류 충돌이 발생한다. 바인딩 파일이 없으면 생성이 실패하므로 **항상 `-b xsd_bindings.xjb`를 붙인다.**

1. **`jarrowYildrim` 프로퍼티 충돌** (`simulation.xsd`)
   자식 요소 `Index`와 속성 `index`가 같은 Java 프로퍼티명을 만든다.
   → 속성 쪽을 `indexName`으로 리네임.

2. **대소문자 충돌 20건** (`curveconfig.xsd` ↔ `sensitivity.xsd`)
   `curveconfig.xsd`의 camelCase 타입(`swaptionVolatility`)과 `sensitivity.xsd`의
   전소문자 타입(`swaptionvolatility`)이 Windows의 대소문자 무시 파일시스템에서
   같은 파일명이 된다.
   → sensitivity 쪽 20개 타입을 `SensitivitySwaptionVolatility` 식으로 리네임.

3. **`cbCallData` 중첩 `Soft` 충돌** (`instruments.xsd`)
   래퍼 요소 `Soft`와 그 안의 반복 엔트리 `Soft`가 같은 내부 클래스명을 만든다.
   → 엔트리 쪽을 `SoftEntry`로 리네임.

스키마를 수정해 새 충돌이 생기면, xjc 에러 메시지에 나온 파일/행을 보고
같은 방식으로 `<jxb:bindings node="..."><jxb:class name="..."/></jxb:bindings>`를
추가하면 된다.

## 생성 후 검증

컴파일:

```cmd
cd C:\Users\ibk\dev\Engine\xsd
dir /s /b generated\*.java > _sources.txt
javac -encoding UTF-8 -d %TEMP%\xjc_classes @_sources.txt
```

언마샬 스모크 테스트 (예제 XML이 실제 클래스로 파싱되는지):

```java
JAXBContext ctx = JAXBContext.newInstance("com.ibk.gcb.batch.trs.mvmn.ore");
Unmarshaller u = ctx.createUnmarshaller();
JAXBElement<?> je = (JAXBElement<?>) u.unmarshal(new File(".../ore.xml"));
```

검증 이력: 예제 `Examples/Bond-VND-government-zero-rt/input/`의
`ore.xml`, `todaysmarket.xml`, `portfolio.xml`, `curveconfig.xml`,
`conventions.xml`, `pricingengine.xml` 6종이 모두 정상 언마샬됨.

## 주의사항

- **`javax.xml.bind` 기반**: JDK 8 xjc로 생성했으므로 구 JAXB 2.2 API를 사용한다.
  Java 11+ / Spring Boot 3 환경에서 쓰려면 `javax.xml.bind:jaxb-api:2.3.1` +
  `org.glassfish.jaxb:jaxb-runtime:2.3.x` 의존성을 추가해야 한다.
  jakarta 네임스페이스가 필요하면 jaxb-ri 4.x의 최신 xjc로 재생성할 것.
- **`collateralbalance.xsd`는 미포함**: `input.xsd`에서 주석 처리되어 있어
  생성 결과물에 포함되지 않는다. 필요하면 include를 해제한 뒤 재생성.
- **스키마 유효성 검사와 무관**: 이 클래스는 XML↔Java 바인딩용이며,
  xmllint 기반 검증은 기존대로 `check.cmd` / `check.sh`을 사용한다.
