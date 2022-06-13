package com.codecrew.fantasticket.service;

import com.codecrew.fantasticket.dto.ImageRequestDto;
import com.codecrew.fantasticket.entity.Event;
import com.codecrew.fantasticket.enums.EventSubType;
import com.codecrew.fantasticket.enums.EventType;

import java.util.List;

public interface EventService {
	List<Event> getAll();
	
	Event getOne(Integer id);
	
	List<Event> getAllByType(EventType eventType);
	
	List<Event> getAllBySubType(EventSubType subType);

	List<Event> getAllByPlace(String place);
	
	Event saveEvent(Event event);
	
	Event addImage(ImageRequestDto imageRequestDto);
	
	Event addSelledSeats(int[] seats, Integer id);
	
	Event updateEvent(Event event, Integer id);
	
	Event cancelEvent(Integer eventId);
	
	Event changePrice(Integer eventId, Double newPrice);
	
	void deleteEvent(Integer id);

}