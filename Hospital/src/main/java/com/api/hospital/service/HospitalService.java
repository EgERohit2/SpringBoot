package com.api.hospital.service;

import java.util.List;

import com.api.hospital.entities.Hospital;

public interface HospitalService {

	public List<Hospital> getAll(int pageNumber,int pageSize);

	public void postAll(Hospital hospital);
	
	public void updateData(Hospital hospital,int id);
	
	public void deleteData(int id);
	
	public List<Hospital> getAllById(int id);

	
}
