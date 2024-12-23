package com.files.EventService.repo;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.files.EventService.model.Event;

@Repository
public interface EventRepo extends JpaRepository<Event, Long>{

	@Query("SELECT e FROM Event e WHERE e.category = :category")
	List<Event> findbyCategory(String category);

	@Query("SELECT e FROM Event e WHERE e.location = :location")
	List<Event> findbyLocation(String location);

	@Query("SELECT e FROM Event e WHERE e.date = :date")
	List<Event> findbyDate(LocalDate date);

}
