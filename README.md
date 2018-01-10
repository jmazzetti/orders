# Order demo swagger

1. docker build -t orders:0.0.1 .
2. docker run --name orders -d -p 127.0.0.1:8081:8081 orders:0.0.1

Run it:
Throw docker:
docker run --name orders -d -p 127.0.0.1:8081:8081 orders:1.0

or using any IDE just run Application.java


Swagger API:
http://localhost:8081/api/v2/swagger-ui.html#!

Test orders (mocked data)

Metrics:

Using aspects you can also see the order method metrics here:

http://localhost:8081/api/v2/metrics

example:

gauge.response.orders.id: 55,
counter.status.200.orders.id: 1,