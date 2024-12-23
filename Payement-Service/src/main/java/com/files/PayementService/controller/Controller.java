package com.files.PayementService.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.files.PayementService.Services.StripeService;
import com.files.PayementService.clients.BookingClient;
import com.files.PayementService.clients.UserClient;
import com.files.PayementService.dto.StripeRespone;
import com.files.PayementService.external.BookingResponse;
import com.files.PayementService.external.User;

@RestController
@RequestMapping("payement")
public class Controller {
	@Autowired
	private StripeService stripeService; 

	@Autowired
	BookingClient bookingClient;

	@Autowired
	UserClient userClient;

	@PostMapping("/checkout")
	public ResponseEntity<StripeRespone> checkProducts(@RequestHeader("Authorization") String authHeader) throws Exception{
		if (authHeader == null || !authHeader.startsWith("Bearer ")) {
			throw new Exception("Missing or invalid Authorization header");
		}

		User authenticatedUser = userClient.getUserByToken(authHeader);  

		System.out.println("User Object: "+authenticatedUser);
		if (authenticatedUser == null) {
			throw new Exception("User not authenticated or token is invalid");
		}

		long userId = authenticatedUser.getUser_id();
		List<BookingResponse> showBookings = bookingClient.showBookings(authHeader);
		System.out.println(showBookings);
		StripeRespone checkoutProduct = stripeService.checkoutProduct(userId,showBookings);
		return ResponseEntity
				.status(HttpStatus.OK)
				.body(checkoutProduct);
	}

}
