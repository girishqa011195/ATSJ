rmdir /s /q allure-results
mvn clean test -Dallure.results.directory=allure-results
allure serve allure-results
exit 0