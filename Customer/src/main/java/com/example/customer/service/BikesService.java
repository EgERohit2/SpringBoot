package com.example.customer.service;

import java.util.List;

import com.example.customer.entities.Bikes;

public interface BikesService {

	public List<Bikes> getAll();
	
	public Bikes postData(Bikes bikes);
}
