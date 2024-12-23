package com.files.PayementService.clients;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;

 import com.files.PayementService.external.BookingResponse;

 @FeignClient(name="BOOKING-SERVICES")
public interface BookingClient {

	@GetMapping("booking/showbookings")
	public List<BookingResponse> showBookings(@RequestHeader("Authorization") String authHeader);
}

