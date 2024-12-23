package com.files.BookingService.external;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Event {

	private int eventId;
	private String category;
	private String name;
	private String venue;
	private String location;
	private LocalDate date;
	private float price;
	private long ticketsAvailable;

}
