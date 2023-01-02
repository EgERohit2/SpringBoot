package com.example.hotel.serviceImplementation;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.example.hotel.Dtos.DtoImplementation;
import com.example.hotel.Dtos.HotelDto;
import com.example.hotel.entities.Hotel;
import com.example.hotel.repository.HotelRepository;
import com.example.hotel.service.HotelService;




@Service
public class HotelServiceImplementation implements HotelService{

	@Autowired
	private HotelRepository HotelRepository;

	@Override
	public String postAllData(Hotel hotel) {
		HotelRepository.save(hotel);
		return "posted";
	}

	public Page<DtoImplementation> findAllWithPage(String search, String pageNumber, String pageSize) {
		Pageable pageable = PageRequest.of(Integer.parseInt(pageNumber) -1, Integer.parseInt(pageSize));
		Page<DtoImplementation>cvs;
		if ((search=="")||(search == null)||(search.length()==0)) {
			cvs= HotelRepository.findByOrderById(pageable,HotelDto.class);
		}
		else {
			cvs= HotelRepository.findByDeptContainingIgnoreCaseOrderById(StringUtils.trimAllWhitespace(search),pageable,HotelDto.class);
		}
		return cvs;
	}

	@Override
	public List<HotelDto> getAllDto() {
		List<Hotel> l1 = HotelRepository.findAll();
		List<HotelDto> list=new ArrayList<>();
		for (int i = 0; i < l1.size(); i++) {
			HotelDto dto = new HotelDto();
			dto.setName(l1.get(i).getName());
			dto.setDept(l1.get(i).getDept());
			list.add(dto);
		}
		return list;
	}

	@Override
	public void deleteData(int id) {
		HotelRepository.deleteById(id);
		
	}
	
	


	
	
	



	
	
	
}
