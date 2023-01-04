package com.example.customer.serviceImplementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.customer.entities.Bikes;
import com.example.customer.repository.BikesRepsitory;
import com.example.customer.service.BikesService;

@Service
public class BikesServiceImplementation implements BikesService{

	@Autowired
	private BikesRepsitory bikesRepsitory;

	@Override
	public List<Bikes> getAll() {
		return bikesRepsitory.findAll();
	}

	@Override
	public Bikes postData(Bikes bikes) {
		return bikesRepsitory.save(bikes);
	}
	
	
}
