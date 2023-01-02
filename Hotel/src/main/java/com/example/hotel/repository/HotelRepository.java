package com.example.hotel.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.hotel.Dtos.DtoImplementation;
import com.example.hotel.Dtos.HotelDto;
import com.example.hotel.entities.Hotel;

@Repository
public interface HotelRepository extends JpaRepository<Hotel, Integer>{

	

	Page<DtoImplementation> findByOrderById(Pageable pageable, Class<HotelDto> class1);

	Page<DtoImplementation> findByDeptContainingIgnoreCaseOrderById(String trimAllWhitespace, Pageable pageable,
			Class<HotelDto> class1);

	

}
