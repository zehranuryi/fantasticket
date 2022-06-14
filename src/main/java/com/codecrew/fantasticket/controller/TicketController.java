package com.codecrew.fantasticket.controller;

import com.codecrew.fantasticket.controller.base.BaseController;
import com.codecrew.fantasticket.dto.TicketDto;
import com.codecrew.fantasticket.exceptions.Result;
import com.codecrew.fantasticket.service.TicketService;
import com.codecrew.fantasticket.util.RestTarget;
import com.codecrew.fantasticket.util.security.CustomUserDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = RestTarget.API + RestTarget.TICKET)
public class TicketController extends BaseController {
	@Autowired
	private TicketService ticketService;
	
	@GetMapping(path = "/by-user-id")
	public ResponseEntity<Result<List<TicketDto>>> getListsByUserId(){
		Integer userId = ((CustomUserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getUser().getId();
		
		return new ResponseEntity(Result.response(ticketService.getAllTicketsForUser(userId)), HttpStatus.OK);
	}
	
	@GetMapping(path = "/by-event-id/{eventId}")
	public ResponseEntity<Result<List<TicketDto>>> getListsByEventId(@PathVariable Integer eventId){
		return new ResponseEntity(Result.response(ticketService.getAllTicketsForEvent(eventId)), HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<Result<TicketDto>> buyTicket(@RequestBody TicketDto ticketDto){
		return new ResponseEntity(Result.response(ticketService.saveTicket(ticketDto)), HttpStatus.CREATED);
	}
	
	@PutMapping(value = "/cancel-ticket/{ticketId}")
	public ResponseEntity<Result<TicketDto>> cancelTicket(@PathVariable Integer ticketId){
		return new ResponseEntity(Result.response(ticketService.cancelTicket(ticketId)), HttpStatus.OK);
	}
}