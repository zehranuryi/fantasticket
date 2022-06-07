package com.codecrew.fantasticket.controller;

import com.codecrew.fantasticket.controller.base.BaseController;
import com.codecrew.fantasticket.entity.Event;
import com.codecrew.fantasticket.enums.EventSubType;
import com.codecrew.fantasticket.enums.EventType;
import com.codecrew.fantasticket.exceptions.Result;
import com.codecrew.fantasticket.service.EventService;
import com.codecrew.fantasticket.util.RestTarget;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = RestTarget.API + RestTarget.EVENT)
public class EventController extends BaseController {
	@Autowired
	private EventService eventService;
	
	@GetMapping(value = "/all", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Result<List<Event>>> getAll(){
		return new ResponseEntity(Result.response(eventService.getAll()), HttpStatus.OK);
	}
	
	@GetMapping(value = "/event-type/{eventType}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Result<List<Event>>> getAllByEvent(@PathVariable EventType eventType){
		return new ResponseEntity(Result.response(eventService.getAllByType(eventType)), HttpStatus.OK);
	}
	
	@GetMapping(value = "/event-type/{eventSubType}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Result<List<Event>>> getAllByEventSubType(@PathVariable EventSubType eventType){
		return new ResponseEntity(Result.response(eventService.getAllBySubType(eventType)), HttpStatus.OK);
	}

	@GetMapping(value = "/place/{place}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Result<List<Event>>> getAllByPlace(@PathVariable String place){
		return new ResponseEntity(Result.response(eventService.getAllByPlace(place)), HttpStatus.OK);
	}
	
	@GetMapping(value = "/{eventId}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Result<Event>> getOne(@PathVariable Integer eventId){
		return new ResponseEntity(Result.response(eventService.getOne(eventId)), HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<Result<Event>> save(@RequestBody Event event){
		return new ResponseEntity(Result.response(eventService.saveEvent(event)), HttpStatus.CREATED);
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<Result<Event>> update(@RequestBody Event event, @PathVariable Integer id){
		return new ResponseEntity(Result.response(eventService.updateEvent(event, id)), HttpStatus.OK);
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Result<Boolean>> delete(@RequestBody Event event, @PathVariable Integer id){
		eventService.deleteEvent(id);
		return new ResponseEntity(Result.response(true), HttpStatus.OK);
	}
}