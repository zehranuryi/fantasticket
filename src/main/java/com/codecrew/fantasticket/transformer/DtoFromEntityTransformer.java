package com.codecrew.fantasticket.transformer;

import com.codecrew.fantasticket.dto.TicketDto;
import com.codecrew.fantasticket.dto.UserResponseDto;
import com.codecrew.fantasticket.entity.Ticket;
import com.codecrew.fantasticket.entity.User;
import org.springframework.stereotype.Service;

@Service
public class DtoFromEntityTransformer {
	
	public TicketDto ticketDtoFromEntity(Ticket ticket){
		return new TicketDto(ticket.getId(),
				ticket.getUser().getId(),
				ticket.getEvent().getId(),
				ticket.getCancelled(),
				ticket.getSeatNumber());
	}
	
	public UserResponseDto userDtoFromEntity(User user){
		return new UserResponseDto(user.getUsername(),
				user.getEmail(),
				user.getPhone(),
				user.getAddress(),
				user.getFullName(),
				user.getRole(),
				user.getToken());
	}
}