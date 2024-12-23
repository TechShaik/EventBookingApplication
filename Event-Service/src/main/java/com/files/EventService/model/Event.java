package com.files.EventService.model;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="Event")
public class Event {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int eventId;
	private String category;
	private String name;
	private String venue;
	private String location;
	private LocalDate date;
	private float price;
	private long ticketsAvailable;


}
