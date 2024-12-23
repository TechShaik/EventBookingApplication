package com.files.EventService.service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.files.EventService.mapper.Mapper;
import com.files.EventService.model.Event;
import com.files.EventService.model.EventResponse;
import com.files.EventService.repo.EventRepo;
 
@Service
public class EventService {

	@Autowired
	private  EventRepo repo;
	
	@Autowired
	private Mapper mapper;
	
	public EventResponse add(Event event) {
 		  Event save = repo.save(event);
 		  return mapper.eventToDto(save);
	}

	public List<Event> show() {
 		return repo.findAll();
	}

	public EventResponse update(long id,Event event) throws Exception {
 		  Event e1 = repo.findById(id).orElseThrow(()->new Exception("Event not found"));
		  e1.setCategory(event.getCategory());
		  e1.setDate(event.getDate());
		  e1.setVenue(event.getVenue());
		  e1.setLocation(event.getLocation());
		  e1.setName(event.getName());
		  e1.setPrice(event.getPrice());
		  e1.setTicketsAvailable(event.getTicketsAvailable());
           Event save = repo.save(e1);	
           return mapper.eventToDto(save);
	}

	public String delete(long id) {
 		  repo.deleteById(id);
		  return "Event deleted successfully";
	}

	public List<EventResponse> bycategory(String category) {
 		  List<Event> findbyCategory = repo.findbyCategory(category);
 		  return  findbyCategory.stream().map(mapper::eventToDto).collect(Collectors.toList());
	}

	public List<Event> bylocation(String location) {
 		return repo.findbyLocation(location);
	}

	 

	public List<Event> findbydate(LocalDate date) {
		 
		return repo.findbyDate(date);
	}

	public Event showById(long id) throws Exception {
		 
		return repo.findById(id).orElseThrow(()-> new Exception("Event not found"));
	}

}
