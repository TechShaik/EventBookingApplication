package com.files.BookingService.clients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;

import com.files.BookingService.external.User;

@FeignClient(name="USER-SERVICES") 
public interface UserClient {

	@GetMapping("users/get/{id}")
	public User getUser(@PathVariable long id);
	
	@GetMapping("users/getUser")
	public User getUserByToken(@RequestHeader("Authorization") String authHeader);

	 
}
