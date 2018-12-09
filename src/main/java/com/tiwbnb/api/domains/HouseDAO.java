package com.tiwbnb.api.domains;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface HouseDAO extends CrudRepository<House, Long>{
	public Optional<House> findById(long id);
	
	@Query(value = "SELECT * FROM house h WHERE (?1 = null OR city = ?1) " 
			+ "AND (?2 = null OR price > ?2) AND (?3 = null OR price < ?3) "
			+ "AND (?4 = null OR max_guests > ?4) AND (?5 = null OR shared = ?5) "
			+ "AND (?6 = null OR start_date <= ?6) AND (?7 = null OR end_date >= ?7)", 
			nativeQuery = true)
	public List<House> find(String city, Float minPrice, Float maxPrice, Integer maxGuests, 
			Boolean shared, Date startDate, Date endDate);
	public List<House> findByCity(String city);
}
