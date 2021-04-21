# Analytics-Service

This is a Spring Boot Web Application with Redis and HyperLogLog to count daily and monthly Unique Visitors (UV).

## Run the service
```sh
mvn spring-boot:run
```

## Restful API URL
**GET** `/collect?cid=<UUID>`: response is `200` OK with an empty body.
**GET** `/daily_uniques?d=<ISO 8601 date>`: return the number of unique users seen for the given GMT day.
**GET** `/monthly_uniques?d=<ISO 8601 date>`: return the number of unique users seen in the month prior to and including the given GMT day.
