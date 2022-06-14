package com.codecrew.fantasticket.service.impl;

import com.codecrew.fantasticket.dao.NotificationRepository;
import com.codecrew.fantasticket.dto.NotificationDto;
import com.codecrew.fantasticket.entity.Notification;
import com.codecrew.fantasticket.service.NotificationService;
import com.codecrew.fantasticket.transformer.DtoFromEntityTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class NotificationServiceImpl implements NotificationService {

    @Autowired
    private NotificationRepository notificationRepository;

    @Autowired
    private DtoFromEntityTransformer dtoFromEntityTransformer;
    
    @Override
    public Notification createNotification(Notification notification) {
        return notificationRepository.save(notification);
    }
    
    @Override
    public List<NotificationDto> getNotificationsByUserId(Integer userId){
        return notificationRepository.findByUserId(userId).stream().map(n -> {
            return dtoFromEntityTransformer.notificationDtoFromEntity(n);
        }).collect(Collectors.toList());
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