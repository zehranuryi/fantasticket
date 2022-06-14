package com.codecrew.fantasticket.controller;

import com.codecrew.fantasticket.dto.NotificationDto;
import com.codecrew.fantasticket.exceptions.Result;
import com.codecrew.fantasticket.service.NotificationService;
import com.codecrew.fantasticket.util.RestTarget;
import com.codecrew.fantasticket.util.security.CustomUserDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = RestTarget.API + RestTarget.NOTIFICATION)
public class NotificationController {
	
	@Autowired
	private NotificationService notificationService;
	
	@GetMapping("/by-user/{userId}")
	public ResponseEntity<Result<List<NotificationDto>>> getNotifications(@PathVariable Integer userId){
		return new ResponseEntity(notificationService.getNotificationsByUserId(userId), HttpStatus.OK);
	}
	
	@GetMapping("/by-current-user")
	public ResponseEntity<Result<List<NotificationDto>>> getNotificationsByCurrent(){
		Integer userId = ((CustomUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getUser().getId();
		
		return new ResponseEntity(notificationService.getNotificationsByUserId(userId), HttpStatus.OK);
	}
}