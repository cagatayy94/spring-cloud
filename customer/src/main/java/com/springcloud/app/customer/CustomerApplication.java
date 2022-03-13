package com.springcloud.app.customer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication(
        scanBasePackages = {
                "com.springcloud.app.customer",
                "com.springcloud.app.amqp",
        }
)
@EnableEurekaClient
@EnableFeignClients(
        basePackages = "com.springcloud.app.clients"
)
public class CustomerApplication {
    public static void main(String[] args){
        SpringApplication.run(CustomerApplication.class, args);
    }
}