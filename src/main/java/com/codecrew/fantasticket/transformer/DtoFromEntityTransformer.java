package com.codecrew.fantasticket.transformer;

import com.codecrew.fantasticket.dto.NotificationDto;
import com.codecrew.fantasticket.dto.TicketDto;
import com.codecrew.fantasticket.dto.UserResponseDto;
import com.codecrew.fantasticket.entity.Notification;
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
				ticket.getSeatNumbers(),
				ticket.getTicketCount(),
				ticket.getTotalAmount());
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
	
	public NotificationDto notificationDtoFromEntity(Notification notification){
		return new NotificationDto(notification.getTitle(),
				notification.getMessage(),
				notification.getDate(),
				notification.getUser().getId());
	}
}