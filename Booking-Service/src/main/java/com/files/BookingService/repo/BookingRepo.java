package com.files.BookingService.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.files.BookingService.dto.BookingResponse;
import com.files.BookingService.model.Booking;

@Repository
public interface BookingRepo extends JpaRepository<Booking, Long>{
	 @Query("SELECT b FROM Booking b WHERE b.user_id = :userId")
	    List<Booking> findByUser_Id(long userId);
	 

}
