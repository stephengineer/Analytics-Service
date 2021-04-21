# Analytics-Service

This is a RESTful Web Service built by [Spring Boot framework](https://spring.io/) with [Redis database](https://redis.io/) and [HyperLogLog algorithm](https://en.wikipedia.org/wiki/HyperLogLog) to count daily and monthly Unique Visitors (UV).

## Run the service
```sh
mvn spring-boot:run
```

## RESTful Request
**GET** `/collect?cid=<UUID>`: response is `200` OK with an empty body.

**GET** `/daily_uniques?d=<ISO 8601 date>`: return the number of unique users seen for the given GMT day.

**GET** `/monthly_uniques?d=<ISO 8601 date>`: return the number of unique users seen in the month prior to and including the given GMT day.


#### REST Request Examples:

**GET** `http://localhost:8080/collect?cid=new`

**GET** `http://localhost:8080/daily_uniques?d=2021-04-21`

**GET** `http://localhost:8080/monthly_uniques?d=2021-04-21`
