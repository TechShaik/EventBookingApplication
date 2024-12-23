package com.files.BookingService.model;

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
@Table(name="Bookings")
public class Booking {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long bookingId;
	private long eventId;
	private long user_id;
	private LocalDate bookingDate;
	private long noOfTickets;
	 

}
