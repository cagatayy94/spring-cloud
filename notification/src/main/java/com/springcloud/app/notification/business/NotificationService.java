package com.springcloud.app.notification.business;

import com.springcloud.clients.notification.NotificationResponse;

public interface NotificationService {
    Boolean sendNotification(Integer customerId);
}
