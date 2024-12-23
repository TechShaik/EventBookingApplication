package com.files.BookingService.mapper;

 import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.files.BookingService.clients.EventClient;
import com.files.BookingService.dto.BookingResponse;
import com.files.BookingService.external.Event;
import com.files.BookingService.model.Booking;

@Component 
public class Mapper {

	@Autowired
	EventClient eventClient;
	
	public BookingResponse toResponse(Booking booking) {
       Event event = eventClient.showById(booking.getEventId());
        BookingResponse bookingResponse=new BookingResponse();
        bookingResponse.setBookingId(booking.getBookingId());
        bookingResponse.setName(event.getName());
        bookingResponse.setVenue(event.getVenue());
        bookingResponse.setLocation(event.getLocation());
        bookingResponse.setDate(event.getDate());
        bookingResponse.setPrice(event.getPrice());
        bookingResponse.setNoOfTickets(booking.getNoOfTickets());
        return bookingResponse;
        
	}
}
