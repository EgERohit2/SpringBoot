package com.example.hotel.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.example.hotel.Dtos.DtoImplementation;
import com.example.hotel.Dtos.HotelDto;
import com.example.hotel.entities.Hotel;

public interface HotelService {

	public String postAllData(Hotel hotel);
	
	Page<DtoImplementation> findAllWithPage(String search,String pageNumber,String pgeSize);
	
	public List<HotelDto> getAllDto();
	
	public void deleteData(int id);
}
