package com.files.EventService.model;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EventResponse {

	private int eventId;
 	private String name;
	private String venue;
	private String location;
	private LocalDate date;
	private float price;
	private long ticketsAvailable;
	
}
