package com.tiwbnb.api.domains;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

public interface HouseDAO extends CrudRepository<House, Long>{
	public Optional<House> findById(long id);
	public List<House> findByCity(String city);
}
