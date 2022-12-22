package com.api.countries.services;

import java.util.List;

import com.api.countries.entities.Countries;

public interface CountriesServices {

	public List<Countries> getAll();
	
	public Countries postAll(Countries countries);
	
	public Countries updateAll(Countries countries,int id);
	
	public void deleteAll(int id);
	
}
