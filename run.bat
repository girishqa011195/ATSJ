@echo off
setlocal

rem Clean previous reports and results
rmdir /s /q allure-report
rmdir /s /q allure-results

rem Run Maven tests
mvn clean test -Dallure.results.directory=allure-results
if %ERRORLEVEL% NEQ 0 (
    echo Maven build failed.
    exit /b %ERRORLEVEL%
)

rem Generate Allure report if results exist
if exist allure-results (
    allure generate allure-results --clean -o allure-report
    if %ERRORLEVEL% NEQ 0 (
        echo Allure report generation failed.
        exit /b %ERRORLEVEL%
    )
) else (
    echo Allure results not found. Serving report if available.
    allure serve allure-report
)

endlocal
