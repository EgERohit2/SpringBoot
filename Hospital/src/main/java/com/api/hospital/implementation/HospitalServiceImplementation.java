package com.api.hospital.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.api.hospital.entities.Hospital;
import com.api.hospital.repository.HospitalRepository;
import com.api.hospital.service.HospitalService;

@Service
public class HospitalServiceImplementation implements HospitalService {

	@Autowired
	private HospitalRepository hospitalRepository;

	@Override
	public List<Hospital> getAll(int pageNumber, int pageSize) {
		Pageable pageable = PageRequest.of(pageNumber - 1, pageSize);
		Page<Hospital> page = hospitalRepository.findAll(pageable);
		return page.getContent();

	}

	@Override
	public void postAll(Hospital hospital) {
		hospitalRepository.save(hospital);

	}

	@Override
	public void updateData(Hospital hospital, int id) {
		Hospital h = hospitalRepository.findById(id).orElseThrow();
		h.setName(hospital.getName());
		h.setDept(hospital.getDept());
		hospitalRepository.save(h);
	}

	@Override
	public void deleteData(int id) {
		hospitalRepository.deleteById(id);

	}

	@Override
	public List<Hospital> getAllById(int id) {
		// TODO Auto-generated method stub
		List<Hospital> list2= (List<Hospital>) hospitalRepository.findById(id).orElseThrow();
		return list2;	
	}
	

}
