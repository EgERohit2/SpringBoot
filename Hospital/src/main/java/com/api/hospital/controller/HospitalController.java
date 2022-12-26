package com.api.hospital.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.api.hospital.entities.Hospital;
import com.api.hospital.service.HospitalService;

@RestController
@RequestMapping("/users")
public class HospitalController {

	@Autowired
	private HospitalService hospitalService;

	@GetMapping("/")
	public List<Hospital> getAll(@RequestParam(value = "pageNumber") int pageNumber,
			@RequestParam(value = "pageSize") int pageSize) {
		return hospitalService.getAll(pageNumber, pageSize);

	}
	
	@GetMapping("/{id}")
	public List<Hospital> getAllById(@PathVariable int id)
	{
		return hospitalService.getAllById(id);
	}

	@PostMapping()
	public void postAll(@RequestBody Hospital hospital) {
		hospitalService.postAll(hospital);

	}

	@PutMapping("/{id}")
	public String updateData(@RequestBody Hospital hospital, @PathVariable int id) {
		hospitalService.updateData(hospital, id);
		return "updated";
	}

	@DeleteMapping("/{id}")
	public String deleteData(@PathVariable int id) {
		hospitalService.deleteData(id);
		return "deleted";
	}


}
