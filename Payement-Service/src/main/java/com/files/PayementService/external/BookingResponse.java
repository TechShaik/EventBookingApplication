package com.files.PayementService.external;

import java.time.LocalDate;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class BookingResponse {

	private long bookingId;
	private String name;
	private String venue;
	private String location;
	private LocalDate date;
	private long price;
	private long noOfTickets;
}
