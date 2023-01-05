package com.example.tutorials.serviceImplementation;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.tutorials.entities.Tutorial;
import com.example.tutorials.repository.TutorialsRepository;
import com.example.tutorials.services.TutorialServices;

@Service
public class TutorialsServiceImplementation implements TutorialServices{

	@Autowired
	private TutorialsRepository tutorialsRepository;
	@Override
	public List<Tutorial> getAll() {
		return tutorialsRepository.findAll();
	}
	@Override
	public Tutorial postAll(Tutorial tutorial) {
		Tutorial t = new Tutorial();
		t.setName(tutorial.getName());
		t.setCooment(new ArrayList<>(tutorial.getCooment()));
		return  tutorialsRepository.save(t);
		
	}
	
	

}

