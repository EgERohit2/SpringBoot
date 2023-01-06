package com.example.human.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.human.entities.Human;
import com.example.human.repository.HumanRepository;
import com.example.human.servcieImplementation.HumanServiceImplementation;

@RequestMapping("/human")
@RestController
public class HumanController {

	@Autowired
	private HumanServiceImplementation humanServiceImplementation;
	
	@Autowired
	private HumanRepository humanRepository;
	
	@GetMapping()
	public ResponseEntity<List<Human>>getAllData(@RequestParam(value="pageNumber")int pageNumber, @RequestParam(value="pageSize")int pageSize){
		List<Human> database = this.humanRepository.findAll();
		if (!database.isEmpty()) {
			List<Human> list1 = this.humanServiceImplementation.getAll(pageNumber,pageSize);
			return new ResponseEntity<>(list1,HttpStatus.OK);
		}
		else {
		return new ResponseEntity<>(null,HttpStatus.OK);
	}
		
	}
	@GetMapping("/ha")
	public List<Human> GetAllData()
	{
		return humanServiceImplementation.getAllData();
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


//
//public ResponseEntity<List<Hospital>> getAll(@RequestParam(value = "pageNumber") int pageNumber,
//		@RequestParam(value = "pageSize") int pageSize) {
//
//	List<Hospital> database = this.hospitalRepository.findAll();
//	// must be know status code before using in code
//	if (!database.isEmpty()) {
//		List<Hospital> list1 = this.hospitalService.getAll(pageNumber, pageSize);
//		return new ResponseEntity<>(list1, HttpStatus.OK);
//	} else {
//		return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
//	}