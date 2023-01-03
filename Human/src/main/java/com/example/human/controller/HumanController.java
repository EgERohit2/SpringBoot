package com.example.human.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.human.entities.Human;
import com.example.human.servcieImplementation.HumanServiceImplementation;

@RequestMapping("/human")
@RestController
public class HumanController {

	@Autowired
	private HumanServiceImplementation humanServiceImplementation;
	
	@GetMapping()
	public List<Human>getAllData(){
		return humanServiceImplementation.getAll();
	}
	
	@PostMapping()
	public Human  postAllData(@RequestBody Human human) {
		return humanServiceImplementation.postData(human);
		
	}
	
	@PutMapping("/{id}")
	public void updateAllData(@RequestBody Human human, @PathVariable int id) {
		humanServiceImplementation.updateData(human,id);
	}
	
	@DeleteMapping("/{id}")
	public String deleteAllData(@PathVariable int id) {
		humanServiceImplementation.deleteData(id);
		return "deleted";
	}
}
