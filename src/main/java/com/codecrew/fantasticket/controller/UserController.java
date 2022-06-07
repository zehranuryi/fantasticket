package com.codecrew.fantasticket.controller;

import com.codecrew.fantasticket.controller.base.BaseController;
import com.codecrew.fantasticket.dto.UserResponseDto;
import com.codecrew.fantasticket.exceptions.Result;
import com.codecrew.fantasticket.service.UserService;
import com.codecrew.fantasticket.util.RestTarget;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = RestTarget.API + RestTarget.USER)
public class UserController extends BaseController {
	
	@Autowired
	private UserService userService;
	
	@GetMapping
	public ResponseEntity<Result<List<UserResponseDto>>> getAll(){
		return new ResponseEntity(Result.response(userService.getAll()), HttpStatus.OK);
	}
}