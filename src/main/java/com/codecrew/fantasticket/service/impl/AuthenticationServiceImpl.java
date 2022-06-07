package com.codecrew.fantasticket.service.impl;

import com.codecrew.fantasticket.dto.LoginRequestDto;
import com.codecrew.fantasticket.dto.UserResponseDto;
import com.codecrew.fantasticket.service.AuthenticationService;
import com.codecrew.fantasticket.service.UserService;
import com.codecrew.fantasticket.util.security.CustomUserDetails;
import com.codecrew.fantasticket.util.security.JwtProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationServiceImpl implements AuthenticationService {
	@Autowired
	private UserService userService;
	
	@Autowired
	private JwtProvider jwtProvider;
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Override
	public UserResponseDto signInReturnWithJwt(LoginRequestDto user){
		
		String username = user.getIdentity();
		
		if(user.getIdentity().contains("@")){
			username = userService.findByEmail(user.getIdentity()).getUsername();
		}
		
		Authentication authentication = authenticationManager
				.authenticate(
						new UsernamePasswordAuthenticationToken(username, user.getPassword()
						)); // Throws not shown !
		String token = jwtProvider.generateToken((CustomUserDetails) authentication.getPrincipal());
		
		var signInUserDto = userService.findByUsernameDTO(username);
		
		signInUserDto.setToken(token);
		
		return signInUserDto;
	}
}