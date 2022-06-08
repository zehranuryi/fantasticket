package com.codecrew.fantasticket.dao;

import com.codecrew.fantasticket.entity.Event;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NotificationRepository extends JpaRepository<Event, Integer> {
}
