package com.api.cricket.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.api.cricket.Implementation.CricketServiceImplementation;
import com.api.cricket.entities.*;

@RestController
public class CricketController {

	@Autowired
	private CricketServiceImplementation cricketServiceImplementation;

	@GetMapping("getall")
	public ResponseEntity<List<Cricket>> getAllDetails() {
		List<Cricket> list1 = cricketServiceImplementation.getAll();
		if (list1.size() <= 0) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		return ResponseEntity.of(Optional.of(list1));
	}

	@GetMapping(value = "/getAll/{id}")
	public ResponseEntity<Cricket> getAllById(@PathVariable int id) {

		Cricket cricket = cricketServiceImplementation.getAllById(id);
		if (cricket == null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		return ResponseEntity.of(Optional.of(cricket));
	}

	@PostMapping(value = "/postData")
	public Cricket postData(@RequestBody Cricket cricket) {
		return cricketServiceImplementation.postData(cricket);

	}

	@PutMapping(value = "/putData/{id}")
	public String putData(@RequestBody Cricket cricket, @PathVariable int id) {
		cricketServiceImplementation.putData(cricket, id);
		return "save";
	}

	@DeleteMapping(value = "/deleteData/{id}")
	public String deleteData(@PathVariable int id) {
		return "deleted";

	}

	@GetMapping("/{pageNumber}/{pageSize}")
	public ResponseEntity<List<Cricket>> getDetails(@PathVariable int pageNumber, @PathVariable int pageSize) {
		List<Cricket> list2 = cricketServiceImplementation.getDetailsAll(pageNumber, pageSize);
		if (list2.size() <= 0) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		return ResponseEntity.of(Optional.of(list2));
	}
}
