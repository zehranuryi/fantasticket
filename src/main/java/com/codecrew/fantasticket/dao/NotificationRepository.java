package com.codecrew.fantasticket.dao;

import com.codecrew.fantasticket.entity.Notification;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NotificationRepository extends JpaRepository<Notification, Integer> {
}
