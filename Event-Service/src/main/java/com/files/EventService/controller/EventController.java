package com.files.EventService.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.files.EventService.model.Event;
import com.files.EventService.model.EventResponse;
import com.files.EventService.service.EventService;

@RestController
@RequestMapping("/event")
public class EventController {
	
	@Autowired
	EventService eventService;
	
	@GetMapping
    public String home(@RequestHeader("Authorization") String authHeader){
		return "Welcome to Events page...!";
	}
	
	@PostMapping("/add")
	public EventResponse add(@RequestHeader("Authorization") String authHeader,@RequestBody Event event) {
		return eventService.add(event);
	}
	
	@GetMapping("/show")
    public List<Event> show(@RequestHeader("Authorization") String authHeader){
		return eventService.show();
	}
	
	@GetMapping("/{id}")
	public Event showById(@PathVariable long id) throws Exception {
		return eventService.showById(id);
	}
	

	@PutMapping("/update/{id}")
    public EventResponse update(@RequestHeader("Authorization") String authHeader,@PathVariable long id,@RequestBody Event event) throws Exception{
		return eventService.update(id,event);
	}
	
	@DeleteMapping("/delete/{id}")
    public String delete(@RequestHeader("Authorization") String authHeader,@PathVariable long id){
		return eventService.delete(id);
	}
	
	@GetMapping("/bycategory/{category}")
	 public List<EventResponse> bycategory(@RequestHeader("Authorization") String authHeader,@PathVariable String category){
		return eventService.bycategory(category);
	}
	
	@GetMapping("/bylocation/{location}")
	 public List<Event> bylocation(@RequestHeader("Authorization") String authHeader,@PathVariable String location){
		return eventService.bylocation(location);
	}
	
	@GetMapping("/bydate")
	 public List<Event> bydate(@RequestHeader("Authorization") String authHeader,@RequestParam LocalDate date){
		return eventService.findbydate(date);
	}
	
	
}
