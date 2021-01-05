# Stock Codingame

Spring Boot application with Gradle wrapper distribution and H2 in-memory database.

## Requirements:

- Java JDK 1.8 or higher

## Run

To run server: `gradlew bootRun`

## API Documentation

`http://localhost:8080/swagger-ui.html`

Endopint example:

- [GET] http://localhost:8080/prices/35455?date=2020-11-29_00:00:00&brandId=1


## Tests

To run integration tests: `gradlew test`

To run acceptance tests: `gradlew cucumber`