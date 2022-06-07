package com.codecrew.fantasticket.service;

import com.codecrew.fantasticket.dto.LoginRequestDto;
import com.codecrew.fantasticket.dto.UserResponseDto;

public interface AuthenticationService {
	UserResponseDto signInReturnWithJwt(LoginRequestDto user);
}