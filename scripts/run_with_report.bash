cd ..
mvn clean test
cp src/test/resources/environment.properties target/allure-results
cd target
allure serve