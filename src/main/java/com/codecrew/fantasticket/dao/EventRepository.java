package com.codecrew.fantasticket.dao;

import com.codecrew.fantasticket.entity.Event;
import com.codecrew.fantasticket.enums.EventSubType;
import com.codecrew.fantasticket.enums.EventType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EventRepository extends JpaRepository<Event, Integer> {
	List<Event> findByType(EventType type);
	List<Event> findBySubType(EventSubType subType);
	List<Event> findByPlace(String place);
}