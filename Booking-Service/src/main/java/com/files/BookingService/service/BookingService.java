package com.files.BookingService.service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.files.BookingService.dto.BookingResponse;
import com.files.BookingService.mapper.Mapper;
import com.files.BookingService.model.Booking;
import com.files.BookingService.repo.BookingRepo;


@Service
public class BookingService {

	@Autowired
	Mapper mapper;
	@Autowired
	BookingRepo bookingRepo;
	
	public ResponseEntity<?> bookEvent(long user_id, long eventId,long noOfTickets) {
 		  Booking booking=new Booking();
 		   booking.setUser_id(user_id);
 		   booking.setEventId(eventId);
 		   booking.setNoOfTickets(noOfTickets);
 		   booking.setBookingDate(LocalDate.now());
 		     Booking save = bookingRepo.save(booking);
 		     return new ResponseEntity<>(save,HttpStatus.OK);
	}

	public List<BookingResponse> showBookings(long userId) {
		 
		  List<Booking> byUser_Id = bookingRepo.findByUser_Id(userId);
		   
		  return byUser_Id.stream().map(mapper::toResponse).collect(Collectors.toList());
		  
	}
	
}

//	public ResponseEntity<String> cancelEvent(long bookingId) {
// 		  bookingRepo.deleteById(bookingId);
// 		  return new ResponseEntity<String>("Event booking cancelled",HttpStatus.OK);
//	}
//
//	public List<Booking> showBookings(long userId) {
//		 
//		return bookingRepo.findByUser_Id(userId);
//	}
//
//}
