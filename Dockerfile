FROM markhobson/maven-chrome:jdk-20

ENV IS_DOCKER=true

WORKDIR /tests

COPY . .

VOLUME docker:target/allure-results

CMD ["mvn", "clean", "test"]