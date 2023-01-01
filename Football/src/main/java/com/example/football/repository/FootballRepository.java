package com.example.football.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.football.entities.Football;

@Repository
public interface FootballRepository extends JpaRepository<Football, Integer> {

}
