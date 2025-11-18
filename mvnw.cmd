@echo off
REM Minimal Maven wrapper (Windows)
set DIR=%~dp0
set WRAPPER_JAR=%DIR%\.mvn\wrapper\maven-wrapper.jar
if exist "%WRAPPER_JAR%" (
  java -jar "%WRAPPER_JAR%" %*
) else (
  echo Maven wrapper JAR not found: %WRAPPER_JAR%
  echo You can generate it locally with an installed Maven using: mvn -N io.takari:maven:wrapper
  exit /b 1
)
