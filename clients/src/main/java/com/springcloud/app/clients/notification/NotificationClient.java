package com.springcloud.app.clients.notification;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient("notification")
public interface NotificationClient {
    @GetMapping(
        path = "api/v1/send-notification/{customerId}"
    )
    NotificationRequest sendNotification(@PathVariable("customerId") Integer customerId);
}
