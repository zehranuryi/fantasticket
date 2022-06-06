package com.codecrew.fantasticket.service.impl;

import com.codecrew.fantasticket.dao.EventRepository;
import com.codecrew.fantasticket.entity.Event;
import com.codecrew.fantasticket.enums.EventSubType;
import com.codecrew.fantasticket.enums.EventType;
import com.codecrew.fantasticket.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EventServiceImpl implements EventService {
	@Autowired
	private EventRepository eventRepository;
	
	@Override
	public List<Event> getAll(){
		return eventRepository.findAll();
	}
	
	@Override
	public Event getOne(Integer id){
		return eventRepository.findById(id).orElseThrow(); // TODO: THROW RESOURCE NOT FOUND EXCEPTION
	}
	
	@Override
	public List<Event> getAllByType(EventType eventType){
		return eventRepository.findByType(eventType.name());
	}
	
	@Override
	public List<Event> getAllBySubType(EventSubType subType){
		return eventRepository.findBySubType(subType.name());
	}
	
	@Override
	public Event saveEvent(Event event){
		event.setDayOfDate(event.getDate().getDayOfWeek().name());
		return eventRepository.save(event);
	}
	
	@Override
	public Event updateEvent(Event event, Integer id){
		var oldEvent = getOne(id);
		oldEvent.setEventName(event.getEventName());
		oldEvent.setEventDescription(event.getEventDescription());
		oldEvent.setCapacity(event.getCapacity());
		oldEvent.setDate(event.getDate());
		oldEvent.setDayOfDate(event.getDate().getDayOfWeek().name());
		oldEvent.setImage(event.getImage());
		oldEvent.setHasSeatPlan(event.getHasSeatPlan());
		oldEvent.setUnitPrice(event.getUnitPrice());
		oldEvent.setPlace(event.getPlace());
		oldEvent.setType(event.getType());
		oldEvent.setSubType(event.getSubType());
		oldEvent.setCancelled(event.getCancelled());
		return eventRepository.save(oldEvent);
	}
	
	@Override
	public Event cancelEvent(Integer eventId){
		var event = getOne(eventId);
		event.setCancelled(true);
		return saveEvent(event);
	}
	
	@Override
	public Event changePrice(Integer eventId, Double newPrice){
		var event = getOne(eventId);
		event.setUnitPrice(newPrice);
		return saveEvent(event);
	}
	
	@Override
	public void deleteEvent(Integer id){
		eventRepository.deleteById(id);
	}

	@Override
	public List<Event> getAllByPlace(String place) {
		return eventRepository.findByPlace(place);
	}
	
	// TODO GET TICKETS THAT HAS THE EVENT
}