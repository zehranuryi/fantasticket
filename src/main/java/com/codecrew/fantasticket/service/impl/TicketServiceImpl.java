package com.codecrew.fantasticket.service.impl;

import com.codecrew.fantasticket.dao.TicketRepository;
import com.codecrew.fantasticket.dto.TicketDto;
import com.codecrew.fantasticket.entity.Ticket;
import com.codecrew.fantasticket.service.EventService;
import com.codecrew.fantasticket.service.TicketService;
import com.codecrew.fantasticket.transformer.DtoFromEntityTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TicketServiceImpl implements TicketService {
	@Autowired
	private TicketRepository ticketRepository;
	
	@Autowired
	private DtoFromEntityTransformer dtoFromEntityTransformer;
	
	@Autowired
	private EventService eventService;
	
	@Override
	public List<TicketDto> getAll(){
		return ticketRepository.findAll().stream().map(ticket -> {
			return dtoFromEntityTransformer.ticketDtoFromEntity(ticket);
		}).collect(Collectors.toList());
	}
	
	@Override
	public TicketDto getOne(Integer id){
		var ticket = ticketRepository.findById(id).orElseThrow(); // TODO : ADD EXCEPTION
		return dtoFromEntityTransformer.ticketDtoFromEntity(ticket);
	}
	
	@Override
	public TicketDto saveTicket(TicketDto ticketDto){
		var ticket = new Ticket(ticketDto.getSeatNumber(),
				ticketDto.getCancelled(),
				eventService.getOne(ticketDto.getEventId()),
				null); // TODO: ADD USER SERVICE GET ONE
		return dtoFromEntityTransformer.ticketDtoFromEntity(ticketRepository.save(ticket));
	}
	
	@Override
	public List<TicketDto> getAllTicketsForUser(Integer userId){
		return ticketRepository.findByUserId(userId)
				.stream()
				.map(ticket -> {
					return dtoFromEntityTransformer.ticketDtoFromEntity(ticket);
				}).collect(Collectors.toList());
	}
	
	@Override
	public List<TicketDto> getAllTicketsForEvent(Integer eventId){
		return ticketRepository.findByEventId(eventId)
				.stream()
				.map(ticket -> {
					return dtoFromEntityTransformer.ticketDtoFromEntity(ticket);
				}).collect(Collectors.toList());
	}
	
	@Override
	public TicketDto cancelTicket(Integer ticketId){
		var ticket = ticketRepository.findById(ticketId).orElseThrow(); // TODO: THROW EXCEPTION;
		ticket.setCancelled(true);
		return dtoFromEntityTransformer.ticketDtoFromEntity(ticketRepository.save(ticket));
	}
}