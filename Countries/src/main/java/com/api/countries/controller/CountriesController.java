package com.api.countries.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.countries.entities.Countries;
import com.api.countries.implementation.CountriesServiceImplementation;

@RequestMapping("countries")
@RestController
public class CountriesController {

	@Autowired
	private CountriesServiceImplementation countriesServiceImplementation;
	
	@GetMapping()
	public List<Countries>getAll()
	{
		return countriesServiceImplementation.getAll();
		
	}
	
	@PostMapping()
	public Countries postAll(@RequestBody Countries countries)
	{
		return countriesServiceImplementation.postAll(countries);
		
	}
	
	@PutMapping("/{id}")
	public String updateAll(@RequestBody Countries countries, @PathVariable int id)
	{
		 countriesServiceImplementation.updateAll(countries, id);
		 return "updated";
	}
	
	@DeleteMapping("/{id}")
	public String deleteAll(@PathVariable int id)
	{
		 countriesServiceImplementation.deleteAll(id);
		 return "deleted";
	}
}
