package com.api.countries.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.api.countries.entities.Countries;

@Repository
public interface CountriesRepository extends JpaRepository<Countries, Integer>{

}
