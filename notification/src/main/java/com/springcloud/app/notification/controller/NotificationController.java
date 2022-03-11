package com.springcloud.app.notification.controller;

import com.springcloud.app.notification.business.NotificationService;
import com.springcloud.app.clients.notification.NotificationRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/send-notification")
@Slf4j
public record NotificationController(NotificationService notificationService) {
    @GetMapping("{customerId}")
    public NotificationRequest sendNotification(@PathVariable("customerId") Integer customerId){
        Boolean result = notificationService.sendNotification(customerId);
        log.info("send notification for customer {}", customerId);
        return new NotificationRequest(result);
    }
}
