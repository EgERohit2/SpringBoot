package com.example.tutorials.services;

import java.util.List;

import com.example.tutorials.entities.Tutorial;

public interface TutorialServices {

	public List<Tutorial> getAll();
	
	public Tutorial postAll(Tutorial tutorial);
}
