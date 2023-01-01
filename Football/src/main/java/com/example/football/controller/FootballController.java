package com.example.football.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.football.entities.Football;
import com.example.football.repository.FootballRepository;
import com.example.football.service.FootballService;

@RequestMapping("/football")
@RestController
public class FootballController {

	@Autowired
	private FootballRepository footballRepository;
	@Autowired
	private FootballService footballService;

	@GetMapping()
	public ResponseEntity<List<Football>> getAll(@RequestParam(value = "pageNumber") int pageNumber,
			@RequestParam(value = "pageSize") int pageSize) {

		List<Football> database = footballRepository.findAll();
		if (!database.isEmpty()) {
			List<Football> list1 = footballService.getAll(pageNumber, pageSize);
			return new ResponseEntity<>(list1, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
		}

	}
}