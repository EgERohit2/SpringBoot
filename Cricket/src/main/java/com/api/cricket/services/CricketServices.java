package com.api.cricket.services;

import java.util.List;

import com.api.cricket.entities.*;

public interface CricketServices {
	public List<Cricket> getAll();

	public Cricket getAllById(int id);

	public void putData(Cricket cricket, int id);
	
	public void deleteData(int id);

	public List<Cricket> getDetailsAll(int pageNumber, int pageSize,String sortBy);
}
