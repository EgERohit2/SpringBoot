package com.example.customer.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.customer.entities.Customer;

public interface CustomerRespository extends JpaRepository<Customer, Integer>{

}
