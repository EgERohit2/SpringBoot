package com.api.hospital.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
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

import com.api.hospital.dto.HospitalDto;
import com.api.hospital.dtoimpl.DtoImplementation;
import com.api.hospital.entities.Hospital;
import com.api.hospital.implementation.HospitalServiceImplementation;
import com.api.hospital.service.HospitalService;

@RestController
@RequestMapping("/users")
public class HospitalController {

	@Autowired
	private HospitalService hospitalService;

	@GetMapping("/")
	public ResponseEntity<List<Hospital>> getAll(@RequestParam(value = "pageNumber") int pageNumber,
			@RequestParam(value = "pageSize") int pageSize) {
		List<Hospital> list1 = this.hospitalService.getAll(pageNumber, pageSize);
		if (list1.size() <= 0) {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		}
		return ResponseEntity.ok(list1);

	}

	@PostMapping()

	public void postAll(@RequestBody @Valid Hospital hospital) {
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

	@GetMapping("/hospital")
	public List<HospitalDto> getAlls() {
		return hospitalService.getAlls();
	}

	@GetMapping("/getPagination")
	public ResponseEntity<?> pagination(@RequestParam(value = "search") String search,
			@RequestParam(value = "pageNumber") String pageNumber, @RequestParam(value = "pageSize") String pageSize) {
		Page<DtoImplementation> cvs = hospitalService.findAllWithPage(search, pageNumber, pageSize);
		if (cvs.getTotalElements() != 0) {

			return new ResponseEntity<>((cvs.getContent()), HttpStatus.OK);

		} else {

			return new ResponseEntity<>("", HttpStatus.NOT_FOUND);

		}

	}
}
