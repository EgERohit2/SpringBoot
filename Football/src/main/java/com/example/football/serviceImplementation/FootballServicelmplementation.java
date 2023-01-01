package com.example.football.serviceImplementation;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.example.football.entities.Football;
import com.example.football.repository.FootballRepository;
import com.example.football.service.FootballService;

@Service
public class FootballServicelmplementation implements FootballService {

	@Autowired
	private FootballRepository footballRepository;

	@Override
	public List<Football> getAll(int pageNumber, int pageSize) {
		Pageable pageable = PageRequest.of(pageNumber, pageSize);
		Page<Football> page = footballRepository.findAll(pageable);
		
		return page.getContent();
	}

	

}
