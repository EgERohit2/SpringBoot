package com.example.human.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.human.entities.Human;

@Repository
public interface HumanRepository extends JpaRepository<Human, Integer>{

}
