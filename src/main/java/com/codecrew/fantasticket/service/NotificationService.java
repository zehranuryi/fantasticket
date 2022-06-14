package com.codecrew.fantasticket.service;

import com.codecrew.fantasticket.dto.NotificationDto;
import com.codecrew.fantasticket.entity.Notification;

import java.util.List;

public interface NotificationService {

    Notification createNotification(Notification notification);
    
    List<NotificationDto> getNotificationsByUserId(Integer userId);
    
    Notification getOne(Integer id);

    List<Notification> getAll();
}