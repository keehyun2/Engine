@echo off
REM ----------------------------------------------------------------------------
REM Maven Wrapper Script for Windows
REM ----------------------------------------------------------------------------

set ERROR_CODE=0

setlocal
set DIRNAME=%~dp0
if "%DIRNAME%" == "" set DIRNAME=.
set APP_BASE_NAME=%~n0
set APP_HOME=%DIRNAME%

REM Resolve absolute path
set "APP_HOME=%APP_HOME:"=%"
for /F "delims=" %%i in ("%APP_HOME%") do set "APP_HOME=%%~fi"

REM Check if Maven is already available in PATH
where mvn >nul 2>nul
if %ERRORLEVEL% EQU 0 (
    goto :runMaven
)

REM Use Maven Wrapper
set WRAPPER_JAR="%APP_HOME%\.mvn\wrapper\maven-wrapper.jar"
if exist %WRAPPER_JAR% (
    goto :runWrapper
)

REM Download Maven Wrapper if not present
echo Downloading Maven Wrapper...
mkdir "%APP_HOME%\.mvn\wrapper" 2>nul
curl -L -o %WRAPPER_JAR% https://repo.maven.apache.org/maven2/org/apache/maven/wrapper/maven-wrapper/3.2.0/maven-wrapper.jar

if not exist %WRAPPER_JAR% (
    echo ERROR: Maven Wrapper JAR not found at %WRAPPER_JAR%
    set ERROR_CODE=1
    goto :error
)

:runWrapper
java -jar %WRAPPER_JAR% %*
goto :end

:runMaven
mvn %*
goto :end

:error
exit /B %ERROR_CODE%

:end
exit /B %ERROR_CODE%
