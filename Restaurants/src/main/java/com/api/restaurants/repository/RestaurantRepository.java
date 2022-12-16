package com.api.restaurants.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.api.restaurants.entities.Restaurants;




public interface RestaurantRepository extends JpaRepository<Restaurants, Integer> {

	public Restaurants findById(int id);

	public List<Restaurants> findByfoodName(String foodName);


	
	
}
