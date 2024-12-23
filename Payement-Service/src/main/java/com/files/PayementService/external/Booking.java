package com.files.PayementService.external;

import java.time.LocalDate;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Booking {
	 
	private long bookingId;
	private long eventId;
	private long user_id;
	private LocalDate bookingDate;
	private long noOfTickets;
	 

}