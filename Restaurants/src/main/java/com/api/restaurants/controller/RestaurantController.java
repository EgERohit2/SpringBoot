package com.api.restaurants.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.api.restaurants.entities.Restaurants;
import com.api.restaurants.service.RestaurantService;

@RestController
public class RestaurantController {

	@Autowired
	private RestaurantService restaurantservice;

	@GetMapping(value = "/getdetails")
	public List<Restaurants> getAll() {
		return this.restaurantservice.getAll();
	}

	@GetMapping(value = "/getdetails/{id}")
	public Restaurants getAllById(@PathVariable int id) {
		return this.restaurantservice.getAllById(id);

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
	public String deleteRestoData(@PathVariable("id") int id)

	{
		this.restaurantservice.deleteData(id);
		return "delete";

	}
	@GetMapping(value="/get/{foodName}")
	public List<Restaurants> getByName(@PathVariable String foodName)
	{
		return restaurantservice.getName(foodName);
	}
	
	
	
}
