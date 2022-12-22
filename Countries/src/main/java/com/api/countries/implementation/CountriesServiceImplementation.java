package com.api.countries.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.countries.entities.Countries;
import com.api.countries.repository.CountriesRepository;
import com.api.countries.services.CountriesServices;

@Service
public class CountriesServiceImplementation implements CountriesServices {

	@Autowired
	private CountriesRepository countriesRepository;

	@Override
	public List<Countries> getAll() {
		
		return countriesRepository.findAll();
	}

	@Override
	public Countries postAll(Countries countries) {
		
		return countriesRepository.save(countries);
	}

	@Override
	public Countries updateAll(Countries countries, int id) 
	{
		Countries country= countriesRepository.findById(id).orElseThrow();
		country.setName(countries.getName());
		country.setCapital(countries.getCapital());
		return countriesRepository.save(country);
		
	}

	@Override
	public void deleteAll(int id) {
		countriesRepository.deleteById(id);
		
	}
	
	
}
