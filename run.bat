rmdir /s /q allure-report
mvn clean test -Dallure.results.directory=allure-report
allure serve allure-report
exit 0