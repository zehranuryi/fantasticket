package com.codecrew.fantasticket.dao;

import com.codecrew.fantasticket.entity.Event;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventRepository extends JpaRepository<Event, Integer> {
}