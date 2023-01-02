package com.example.hotel.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.hotel.Dtos.DtoImplementation;
import com.example.hotel.Dtos.ErrorResponseDto;
import com.example.hotel.Dtos.HotelDto;
import com.example.hotel.Dtos.SuccessResponseDto;
import com.example.hotel.entities.Hotel;
import com.example.hotel.serviceImplementation.HotelServiceImplementation;

@RequestMapping("/hotel")
@RestController
public class HotelController {

	@Autowired
	private HotelServiceImplementation hotelServiceImplementation;
	
	@PostMapping()
	public ResponseEntity<?> postData(@Valid @RequestBody Hotel hotel){
		hotelServiceImplementation.postAllData(hotel);
		return new ResponseEntity<>(new SuccessResponseDto("done", "done",null),HttpStatus.CREATED);
		
	}

	@GetMapping("/pagination")
	public ResponseEntity<?>getData(@RequestParam(value="search")String search,
			@RequestParam(value="pageNumber") String pageNumber,@RequestParam(value="pageSize")String pageSize){
		
		Page<DtoImplementation> page= this.hotelServiceImplementation.findAllWithPage(search,pageNumber,pageSize);
		if(page.getTotalElements()!=0) {
			return new ResponseEntity<>(page.getContent(),HttpStatus.OK);
		}
		else {
			return new ResponseEntity<>("",HttpStatus.OK);
		}
		
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteData(@PathVariable int id){
		hotelServiceImplementation.deleteData(id);
		return new ResponseEntity<>(new ErrorResponseDto("done", "deleted"),HttpStatus.OK);
	}
	
}

	

