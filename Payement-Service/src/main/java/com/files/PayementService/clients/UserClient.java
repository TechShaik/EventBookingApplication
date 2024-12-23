package com.files.PayementService.clients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;

import com.files.PayementService.external.User;

@FeignClient(name="USER-SERVICES")
public interface UserClient {

	@GetMapping("/users/getUser")
	public User getUserByToken(@RequestHeader("Authorization") String authHeader);

}
