package com.files.BookingService.clients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.files.BookingService.external.Event;

@FeignClient(name="EVENT-SERVICES") 
public interface EventClient {

	@GetMapping("event/{id}")
	public Event showById(@PathVariable long id);
}
