package com.codecrew.fantasticket.service.impl;

import com.codecrew.fantasticket.dao.EventRepository;
import com.codecrew.fantasticket.dto.ImageRequestDto;
import com.codecrew.fantasticket.entity.Event;
import com.codecrew.fantasticket.entity.Notification;
import com.codecrew.fantasticket.enums.EventSubType;
import com.codecrew.fantasticket.enums.EventType;
import com.codecrew.fantasticket.service.EventService;
import com.codecrew.fantasticket.service.NotificationService;
import com.codecrew.fantasticket.service.TicketService;
import com.codecrew.fantasticket.transformer.DtoFromEntityTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class EventServiceImpl implements EventService {
	@Autowired
	private EventRepository eventRepository;
	
	@Autowired
	private TicketService ticketService;
	
	@Autowired
	private NotificationService notificationService;
	
	@Autowired
	private DtoFromEntityTransformer dtoFromEntityTransformer;
	
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
		return eventRepository.findByType(eventType);
	}
	
	@Override
	public List<Event> getAllBySubType(EventSubType subType){
		return eventRepository.findBySubType(subType);
	}
	
	@Override
	public Event saveEvent(Event event){
		event.setDayOfDate(event.getDate().getDayOfWeek().name());
		event.setCancelled(false);
		event.setSelledSeats(null);
		return eventRepository.save(event);
	}
	
	@Override
	public Event addImage(ImageRequestDto imageRequestDto){
		var event = eventRepository.findById(imageRequestDto.getEventId()).orElseThrow(); // Throw error
		event.setImage(imageRequestDto.getImageUrl());
		return eventRepository.save(event);
	}
	
	@Override
	public Event addSelledSeats(int[] seats, Integer id){
		var event = getOne(id);
		var seatList =  event.getSelledSeats();
		var newSeats = new int[seats.length + (seatList == null ? 0: seatList.length)];
		int track = 0;
		for(int i = 0; i < (seatList == null ? 0: seatList.length); i++){
			track = i;
			newSeats[i] = seatList[i];
		}
		
		for(int j= 0; j< seats.length; j++){
			newSeats[track] = seats[j];
			track +=1;
		}
		
		event.setSelledSeats(newSeats);
		
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
		
		if(event.getCancelled() != null)
		oldEvent.setCancelled(event.getCancelled());
		return eventRepository.save(oldEvent);
	}
	
	@Override
	@Transactional
	public Event cancelEvent(Integer eventId){
		var event = getOne(eventId);
		event.setCancelled(true);
		
		ticketService.getTicketsByEvent(event.getId())
				.stream()
				.forEach(ticket -> {
					ticket.setCancelled(true);
					
					notificationService.createNotification(
							new Notification("Cancelled Ticket",
									"Your "+event.getEventName()+ " ticket has been cancelled due to event is not exist anymore.",
									LocalDateTime.now(),
									ticket.getUser()));
					
					ticketService.saveTicket(dtoFromEntityTransformer.ticketDtoFromEntity(ticket));
				});
		
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
	
	@Override
	public List<Event> getAllByDate(LocalDate date){
		return eventRepository.findAll()
				.stream()
				.filter(event -> {
					LocalDate eventDate = event.getDate().toLocalDate();
					
					return date.equals(eventDate);
				}).collect(Collectors.toList());
	}
	
	// TODO GET TICKETS THAT HAS THE EVENT
}