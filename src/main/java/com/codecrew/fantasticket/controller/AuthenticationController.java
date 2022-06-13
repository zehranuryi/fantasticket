package com.codecrew.fantasticket.controller;

import com.codecrew.fantasticket.controller.base.BaseController;
import com.codecrew.fantasticket.dto.LoginRequestDto;
import com.codecrew.fantasticket.dto.UserRequestDto;
import com.codecrew.fantasticket.dto.UserResponseDto;
import com.codecrew.fantasticket.exceptions.Result;
import com.codecrew.fantasticket.service.AuthenticationService;
import com.codecrew.fantasticket.service.UserService;
import com.codecrew.fantasticket.util.RestTarget;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping(path = RestTarget.API + RestTarget.AUTHENTICATION)
public class AuthenticationController extends BaseController {
	private final UserService userService;
	private final AuthenticationService authenticationService;
	
	@Autowired
	public AuthenticationController(UserService userService, AuthenticationService authenticationService) {
		this.userService = userService;
		this.authenticationService = authenticationService;
	}
	
	@PostMapping("sign-up")
	public ResponseEntity<Result<UserResponseDto>> signUp(@RequestBody @Valid UserRequestDto userRequestDto){
		try {
			var user= userService.findByUsername(userRequestDto.getUsername());
			if(user != null)
			return new ResponseEntity(Result.response("A user already exists with username, "+ userRequestDto.getUsername()) ,HttpStatus.CONFLICT);
			
			user = userService.findByEmail(userRequestDto.getEmail());
			if(user != null)
				return new ResponseEntity(Result.response("An account already using email address "+ userRequestDto.getEmail()) ,HttpStatus.CONFLICT);
		}catch (Exception exception){}
		
		return new ResponseEntity(Result.response(userService.signInUserReturnDto(userRequestDto)), HttpStatus.CREATED);
	}
	
	@PostMapping("sign-in")
	public ResponseEntity<Result<UserResponseDto>> signIn(@RequestBody @Valid LoginRequestDto loginRequestDto){
		return new ResponseEntity(Result.response(authenticationService.signInReturnWithJwt(loginRequestDto)), HttpStatus.OK);
	}
}