package com.codecrew.fantasticket.service.impl;

import com.codecrew.fantasticket.dao.NotificationRepository;
import com.codecrew.fantasticket.entity.Notification;
import com.codecrew.fantasticket.service.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NotificationServiceImpl implements NotificationService {

    @Autowired
    private NotificationRepository notificationRepository;

    @Override
    public Notification createNotification(Notification notification) {
        return notificationRepository.save(notification);
    }

    @Override
    public Notification getOne(Integer id) {
        return null;
    }

    @Override
    public List<Notification> getAll() {
        return null;
    }
}