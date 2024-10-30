@echo off
rmdir /s /q allure-report
mvn clean test -Dallure.results.directory=allure-results
if exist allure-results (
    allure generate allure-results --clean -o allure-report
) else (
    echo Allure results not found.
)
