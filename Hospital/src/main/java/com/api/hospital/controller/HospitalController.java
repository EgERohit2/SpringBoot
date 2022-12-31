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

import com.api.hospital.dto.ErrorResponseDto;
import com.api.hospital.dto.HospitalDto;
import com.api.hospital.dto.SuccessResponseDto;
import com.api.hospital.dtoimpl.DtoImplementation;
import com.api.hospital.entities.Hospital;
import com.api.hospital.exception.DataNotFoundException;
import com.api.hospital.exception.HospitalNotFoundException;
import com.api.hospital.repository.HospitalRepository;
import com.api.hospital.service.HospitalService;

@RestController
@RequestMapping("/users")
public class HospitalController {

	@Autowired
	private HospitalRepository hospitalRepository;

	@Autowired
	private HospitalService hospitalService;

	@GetMapping("/")
	public ResponseEntity<List<Hospital>> getAll(@RequestParam(value = "pageNumber") int pageNumber,
			@RequestParam(value = "pageSize") int pageSize) {

		List<Hospital> database = this.hospitalRepository.findAll();
		// must be know status code before using in code
		if (!database.isEmpty()) {
			List<Hospital> list1 = this.hospitalService.getAll(pageNumber, pageSize);
			return new ResponseEntity<>(list1, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
		}
	}

	@GetMapping("/alldata")
	public List<Hospital> getAllData() {
		List<Hospital> l1 = hospitalService.getAllData();
		return l1;
	}

	@PostMapping // reference tejas
	public ResponseEntity<?> postAll(@RequestBody @Valid Hospital hospital) {
		hospitalService.postAll(hospital);

		try {
			return new ResponseEntity<>(new SuccessResponseDto("Completed", "Post successfully", null),
					HttpStatus.CREATED);
		} catch (DataNotFoundException e) {
			return new ResponseEntity<>(new ErrorResponseDto("Error ", "No data found"), HttpStatus.OK);

		}
	}

	@PutMapping("/{id}")
	public ResponseEntity<?> updateData(@RequestBody Hospital hospital, @PathVariable int id) throws DataNotFoundException{

		try {
			hospitalService.updateData(hospital, id);
			return new ResponseEntity<>(new SuccessResponseDto("Done", "updated", hospital), HttpStatus.OK);
		} catch (DataNotFoundException e) {
			return new ResponseEntity<>(new ErrorResponseDto("error", "NO data found"), HttpStatus.CREATED);
		}
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteData(@PathVariable @Valid int id) {
		hospitalService.deleteData(id);
		return new ResponseEntity<>(new SuccessResponseDto("Completed", "Deleted successfully", null), HttpStatus.OK);
	}

	@GetMapping("/hospital")
	public List<HospitalDto> getAlls() {
		return this.hospitalService.getAlls();
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

	@GetMapping("/{id}")
	public Hospital findById(@PathVariable int id) {
		return hospitalService.findData(id);
	}

}
