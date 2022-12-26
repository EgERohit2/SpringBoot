package com.api.hospital.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.api.hospital.entities.Hospital;

@Repository
public interface HospitalRepository extends JpaRepository<Hospital, Integer>{

	
}
