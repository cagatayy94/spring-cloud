# Spring Cloud

Spring Cloud Micro Services Architecture

This repo contains modern spring cloud implementations for personel learning.

This is an example of web application comprising of several components communicating to each other. In other words, this is an example of microservice app. Why is it better than many other examples? Well, because these microservices has solid implementations of spring cloud.

It has varius of modules and also it's ready for local testing, docker compose and minikube

## Cloud Scheme

![Cloud Scheme](https://raw.githubusercontent.com/cagatayy94/spring-cloud/main/spring-cloud-diagram.png)

## Run on Docker

Clone the project

```bash
  git clone https://github.com/cagatayy94/spring-cloud
```

Change directory

```bash
  cd spring-cloud
```

Run the configuration

```bash
  docker-compose up
```

This command below will create all containers and also **pgadmin**, **postgres**, **rabbitmq**, **apigw** containers. But these containers created only for local testing. If you are planing to go **production** then you should use **cloud** **providers** for your database or queue containers.


Note: Don't forget to creating databases for customer, fraud and notification microservices otherwise these containers will not work.

Now you can access the Eureka Server via address: http://localhost:8761/


## API

#### Create new customer

```http
  POST localhost:8083/api/v1/customers
```
Json Body

| Parametre | Tip     | Açıklama                           |
| :-------- | :------- |:-----------------------------------|
| `name` | `string` | **Required**. Name of customer.    |
| `lastname` | `string` | **Required**. Surname of customer. |
| `email` | `string` | **Required**. Email of customer.   |


# Distributed tracing

You can track all requests via http://localhost:9411/zipkin/