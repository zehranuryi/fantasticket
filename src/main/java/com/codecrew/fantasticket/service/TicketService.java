package com.codecrew.fantasticket.service;

import com.codecrew.fantasticket.dto.TicketDto;

import java.util.List;

public interface TicketService {
	List<TicketDto> getAll();
	
	TicketDto getOne(Integer id);
	
	TicketDto saveTicket(TicketDto ticketDto);
	
	List<TicketDto> getAllTicketsForUser(Integer userId);
	
	List<TicketDto> getAllTicketsForEvent(Integer eventId);
	
	TicketDto cancelTicket(Integer ticketId);
}