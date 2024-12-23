package com.files.BookingService.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.files.BookingService.clients.UserClient;
import com.files.BookingService.dto.BookingResponse;
import com.files.BookingService.external.User;
import com.files.BookingService.model.Booking;
import com.files.BookingService.service.BookingService;
 
@RestController
@RequestMapping("/booking")
  class BookingController {
 
	@Autowired
	BookingService bookingService;
	
	@Autowired
	UserClient userClient;
	
	@GetMapping("/home")
	public String Home(@RequestHeader("Authorization") String authHeader) {
		return "Welcome to Bookings page..!";
	}
	
	@PostMapping("/{eventId}")
	public ResponseEntity<?> bookEvent(@RequestHeader("Authorization") String authHeader, 
	                                   @PathVariable long eventId, 
	                                   @RequestParam long noOfTickets) {
		
		System.out.println("authheader"+authHeader);
	    if (!authHeader.startsWith("Bearer ")) {
	        return new ResponseEntity<>("Invalid Authorization header", HttpStatus.UNAUTHORIZED);
	    }else {

	    User authenticatedUser = userClient.getUserByToken(authHeader);
	    System.out.println("authenticatedUser"+authenticatedUser);
	    if (authenticatedUser == null) {
	        return new ResponseEntity<>("User not authenticated", HttpStatus.UNAUTHORIZED);
	    }

	    long userId = authenticatedUser.getUser_id();
	    System.out.println("userIdddddddddddddddddddddddddd"+userId);
	    return bookingService.bookEvent(userId, eventId, noOfTickets);
	}


}
		
//		@DeleteMapping("cancel/{bookingId}")
//		public ResponseEntity<?> cancelEvent(@RequestHeader("Authorization") String authHeader,@PathVariable long bookingId) {
//			return bookingService.cancelEvent(bookingId);
//			
//		}
			@GetMapping("/showbookings")
			public List<BookingResponse> showBookings(@RequestHeader("Authorization") String authHeader) throws Exception{
				if (authHeader == null || !authHeader.startsWith("Bearer ")) {
					throw new Exception("Missing or invalid Authorization header");
				}

				  User userByToken = userClient.getUserByToken(authHeader);

 				if (userByToken == null) {
					throw new Exception("User not authenticated or token is invalid");
				}
				long userId = userByToken.getUser_id();
				return bookingService.showBookings(userId);
				
			}
}
	
	

