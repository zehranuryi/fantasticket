package com.codecrew.fantasticket.dao;

import com.codecrew.fantasticket.entity.Notification;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface NotificationRepository extends JpaRepository<Notification, Integer> {
	List<Notification> findByUserId(Integer userId);
}