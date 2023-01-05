package com.example.tutorials.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.tutorials.entities.Tutorial;

@Repository
public interface TutorialsRepository extends JpaRepository<Tutorial, Integer>{

}
