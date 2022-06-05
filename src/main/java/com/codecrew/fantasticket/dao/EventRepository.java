package com.codecrew.fantasticket.dao;

import com.codecrew.fantasticket.entity.Event;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EventRepository extends JpaRepository<Event, Integer> {
	List<Event> findByType(String type);
	List<Event> findBySubType(String subType);
}