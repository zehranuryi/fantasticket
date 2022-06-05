package com.codecrew.fantasticket.service;

import com.codecrew.fantasticket.dto.UserRequestDto;
import com.codecrew.fantasticket.dto.UserResponseDto;
import com.codecrew.fantasticket.entity.User;
import com.codecrew.fantasticket.enums.Role;

import javax.persistence.Transient;
import java.util.List;

public interface UserService {
	List<UserResponseDto> getAll();
	
	User findByUsername(String username);
	
	UserResponseDto findByUsernameDTO(String username);
	
	UserResponseDto findByEmailDto(String email);
	
	User findByEmail(String email);
	
	UserResponseDto signInUserReturnDto(UserRequestDto userRequestDto);
	
	@Transient
	UserResponseDto changeRole(Integer userId, Role role);
}