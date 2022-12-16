package com.api.restaurants.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


import com.api.restaurants.entities.Restaurants;
import com.api.restaurants.repository.RestaurantRepository;

@Component
public class RestaurantService {

	@Autowired
	public RestaurantRepository restaurantrepository;

	public List<Restaurants> getAll() {
		List<Restaurants> list = this.restaurantrepository.findAll();
		return list;
	}

	public Restaurants getAllById(int id) {
		Restaurants restaurant = null;
		restaurant = this.restaurantrepository.findById(id);
		return restaurant;
	}

	public String addData(Restaurants resto) {
		restaurantrepository.save(resto);
		return "saved";
	}

	public void updateData(Restaurants resto, int id) {
		Restaurants restro = restaurantrepository.findById(id);
		resto.setFoodName(resto.getFoodName());
		resto.setPrice(resto.getPrice());
		restaurantrepository.save(resto);
	}

	public void deleteData(int id) {
		restaurantrepository.deleteById(id);
	}

	public List<Restaurants> getName(String foodName) {
		
		return restaurantrepository.findByfoodName(foodName);
	}


	
}
