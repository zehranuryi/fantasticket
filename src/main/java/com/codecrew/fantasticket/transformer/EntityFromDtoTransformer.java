package com.codecrew.fantasticket.transformer;

import com.codecrew.fantasticket.dto.TicketDto;
import com.codecrew.fantasticket.dto.UserRequestDto;
import com.codecrew.fantasticket.entity.Ticket;
import com.codecrew.fantasticket.entity.User;
import org.springframework.stereotype.Service;

@Service
public class EntityFromDtoTransformer {
	
	public User userFromDto(UserRequestDto userRequestDto){
		return new User(userRequestDto.getUsername(),
				userRequestDto.getEmail(),
				userRequestDto.getPhone(),
				userRequestDto.getAddress(),
				userRequestDto.getFullName(),
				userRequestDto.getPassword(),
				null,
				null,
				null);
	}
}