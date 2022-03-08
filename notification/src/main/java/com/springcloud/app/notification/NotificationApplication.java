package com.springcloud.app.notification;

import org.springframework.context.annotation.Bean;
import com.springcloud.app.amqp.RabbitMqMessageProducer;
import com.springcloud.app.notification.config.NotificationConfig;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;


@EnableEurekaClient
@SpringBootApplication(
        scanBasePackages = {
                "com.springcloud.app.notification",
                "com.springcloud.app.amqp",
        }
)
public class NotificationApplication {
    public static void main(String[] args) {
        SpringApplication.run(NotificationApplication.class, args);
    }

    /*
    @Bean
    CommandLineRunner commandLineRunner(RabbitMqMessageProducer producer, NotificationConfig notificationConfig){
        return args -> {
            producer.publish(
                    new Person("çaça", 25),
                    notificationConfig.getInternalExchange(),
                    notificationConfig.getInternalNotificationRoutingKey()
            );
        };
    }

    record Person(String name, int age){}
    */
}
