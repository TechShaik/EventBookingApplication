package com.files.EventService.mapper;

import org.springframework.stereotype.Component;

import com.files.EventService.model.Event;
import com.files.EventService.model.EventResponse;

@Component
public class Mapper {

	public EventResponse eventToDto(Event event) {
		EventResponse eventResponse=new EventResponse();
		eventResponse.setEventId(event.getEventId());
		eventResponse.setDate(event.getDate());
		eventResponse.setVenue(event.getVenue());
		eventResponse.setLocation(event.getLocation());
		eventResponse.setName(event.getName());
		eventResponse.setPrice(event.getPrice());
		eventResponse.setTicketsAvailable(event.getTicketsAvailable());
		return eventResponse;
		
	}
}
