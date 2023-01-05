package com.example.tutorials.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.tutorials.entities.Tutorial;
import com.example.tutorials.serviceImplementation.TutorialsServiceImplementation;

@RequestMapping("/Academy")
@RestController
public class TutorialController {

	@Autowired
	private TutorialsServiceImplementation tutorialsServiceImplementation;
	
	@GetMapping()
	public List<Tutorial> getAllData(){
		return tutorialsServiceImplementation.getAll();
	}
	
	@PostMapping()
	public Tutorial postAllData(@RequestBody Tutorial tutorial) {
		return tutorialsServiceImplementation.postAll(tutorial);
	}
}
