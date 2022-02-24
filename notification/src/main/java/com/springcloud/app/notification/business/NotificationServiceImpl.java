package com.springcloud.app.notification.business;

import com.springcloud.app.notification.dataAccess.NotificationRepository;
import com.springcloud.app.notification.entities.Notification;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public record NotificationServiceImpl(NotificationRepository notificationRepository) implements NotificationService{
    @Override
    public Boolean sendNotification(Integer customerId) {
        notificationRepository.save(
                Notification.builder()
                        .customerId(customerId)
                        .createdAt(LocalDateTime.now())
                        .build()
        );

        return true;
    }
}
