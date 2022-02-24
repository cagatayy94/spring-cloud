package com.springcloud.app.notification.dataAccess;

import com.springcloud.app.notification.entities.Notification;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NotificationRepository extends JpaRepository<Notification, Integer> {
}
