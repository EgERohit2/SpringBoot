package com.api.restaurants.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.api.restaurants.entities.Restaurants;
import com.api.restaurants.service.RestaurantService;

@RestController
public class RestaurantController {

	@Autowired
	private RestaurantService restaurantservice;

	@GetMapping(value = "/getdetails")
	public ResponseEntity<List<Restaurants>> getAll() {

		List<Restaurants> list1 = this.restaurantservice.getAll();
		if (list1.size() <= 0) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		return ResponseEntity.of(Optional.of(list1));
	}

	@GetMapping(value = "/getdetails/{id}")
	public ResponseEntity<Restaurants> getAllById(@PathVariable int id) {
		Restaurants resto = this.restaurantservice.getAllById(id);
		if (resto == null) {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		}
		return ResponseEntity.of(Optional.of(resto));
	}

	@PostMapping(value = "/deepak")
	public String addRestoData(@RequestBody Restaurants resto) {
		restaurantservice.addData(resto);
		return "saved";
	}

	@PutMapping(value = "/deepak/{id}")
	public String updateRestoData(@RequestBody Restaurants resto, @PathVariable("id") int id) {
		this.restaurantservice.updateData(resto, id);
		return "resto";

	}

	@DeleteMapping(value = "/deepak/{id}")
	public ResponseEntity<String> deleteRestoData(@PathVariable("id") int id)

	{
		try {
			this.restaurantservice.deleteData(id);
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}

	}

	@GetMapping(value = "/get/{foodName}")
	public List<Restaurants> getByName(@PathVariable String foodName) {
		return restaurantservice.getName(foodName);
	}

}