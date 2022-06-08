package com.codecrew.fantasticket.service;

import com.codecrew.fantasticket.entity.Notification;

import java.util.List;

public interface NotificationService {

    Notification createNotification(Notification notification);

    Notification getOne(Integer id);

    List<Notification> getAll();
}
