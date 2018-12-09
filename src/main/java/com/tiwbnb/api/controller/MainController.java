package com.tiwbnb.api.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tiwbnb.api.domains.House;
import com.tiwbnb.api.domains.HouseDAO;

@RestController
@CrossOrigin
public class MainController {
	
	@Autowired
	HouseDAO daohouse;
	
	@RequestMapping(method = RequestMethod.GET, value="users/{userId}/houses")
	public ResponseEntity<List <House>> findUserHouses(@PathVariable @Validated Long userId) {
		List<House> houses = daohouse.findByOwnerId(userId);
		return ResponseEntity.status(HttpStatus.OK).body(houses);
	}
	
	@RequestMapping(method = RequestMethod.POST, value="/house")
	public ResponseEntity<House> publishHouse(@RequestBody @Validated House pHouse) {
		House newHouse = daohouse.save(pHouse);
		if (newHouse == null) {
			return ResponseEntity.status(HttpStatus.METHOD_NOT_ALLOWED).body(null);
		}
		return ResponseEntity.status(HttpStatus.CREATED).body(newHouse);
	}
	
	@RequestMapping(method = RequestMethod.PUT, value="/house/{houseId}")
	public ResponseEntity<House> editHouse(@RequestBody @Validated House pHouse, @PathVariable @Validated Long houseId) {
		House house = daohouse.findById(houseId).orElse(null);
		if (house == null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
		}
		house.updateHouse(pHouse);
		daohouse.save(house);
		return ResponseEntity.status(HttpStatus.OK).body(house);
	}
	
	@RequestMapping(method = RequestMethod.GET, value="/houses/{houseId}")
	public ResponseEntity<House> findHouseById(@PathVariable @Validated Long houseId) {
		House house = daohouse.findById(houseId).orElse(null);
		if (house == null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
		}
		return ResponseEntity.status(HttpStatus.OK).body(house);
	}
	
	@RequestMapping(method = RequestMethod.GET, value="/houses/{city}")
	public ResponseEntity<List <House>> findHouses(@PathVariable @Validated String city) {
		List<House> houses = daohouse.findByCity(city);
		if (houses.isEmpty()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
		}
		return ResponseEntity.status(HttpStatus.OK).body(houses);
	}
	
	@RequestMapping(method = RequestMethod.GET, value="/houses")
	public ResponseEntity<List <House>> search(
			@RequestParam(value = "city", required = false) String city,
			@RequestParam(value = "minPrice", required = false) Float minPrice,
			@RequestParam(value = "maxPrice", required = false) Float maxPrice,
			@RequestParam(value = "guestCount", required = false) Integer guestCount,
			@RequestParam(value = "shared", required = false) Boolean shared,
			@RequestParam(value = "startDate", required = false) 
				@DateTimeFormat(pattern = "MM/dd/yyyy") Date startDate,
			@RequestParam(value = "endDate", required = false) 
				@DateTimeFormat(pattern = "MM/dd/yyyy") Date endDate) {
		
		List<House> houses = daohouse.find(city, minPrice, maxPrice, guestCount, shared, startDate, endDate);
		return ResponseEntity.status(HttpStatus.OK).body(houses);
	}

}
