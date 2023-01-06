package com.example.human.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.human.entities.Identification;
import com.example.human.servcieImplementation.IdentificationServiceImplementation;

@RestController
@RequestMapping("/identification")
public class IdentificatonController {

	@Autowired
	private IdentificationServiceImplementation identificationServiceImplementation;
	
	@PostMapping()
	public Identification postAllData(@RequestBody Identification identification) {
		return identificationServiceImplementation.postAll(identification);
		
	}
	
	
}
