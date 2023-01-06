package com.example.human.servcieImplementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.human.entities.Identification;
import com.example.human.repository.IdentificationRepository;
import com.example.human.service.IdentificationService;
@Service
public class IdentificationServiceImplementation implements IdentificationService{

	@Autowired
	private IdentificationRepository identificationRepository;

	@Override
	public Identification postAll(Identification identification) {
		Identification id = new Identification();
		id.setName(identification.getName());
		id.setGender(identification.getGender());
		
		return  identificationRepository.save(id);
	}
	
	
}
