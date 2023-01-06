package com.example.human.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.human.entities.Identification;

public interface IdentificationRepository extends JpaRepository<Identification, Integer>{

}
