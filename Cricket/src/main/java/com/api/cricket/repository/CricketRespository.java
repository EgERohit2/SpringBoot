package com.api.cricket.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.api.cricket.entities.Cricket;

public interface CricketRespository extends JpaRepository<Cricket, Integer>{

	

	
}
