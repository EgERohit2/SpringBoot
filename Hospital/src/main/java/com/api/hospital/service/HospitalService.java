package com.api.hospital.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;

import com.api.hospital.dto.HospitalDto;
import com.api.hospital.dtoimpl.DtoImplementation;
import com.api.hospital.entities.Hospital;

public interface HospitalService {

	public List<Hospital> getAll(int pageNumber,int pageSize);

	public void postAll(Hospital hospital);
	
	public void updateData(Hospital hospital,int id);
	
	public void deleteData(int id);
	
	public List<HospitalDto>getAlls();
	
	public List<Hospital>getAllData();
	
	public Page<DtoImplementation> findAllWithPage(String search, String pageNumber, String pageSize);
	
	public List<Hospital> findData();
	
	public Hospital findData(int id);

	
}
