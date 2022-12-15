package com.api.employees.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.api.employees.entities.*;
import com.api.employees.entities.Employees;
import com.api.employees.services.EmployeesService;

@RestController
public class EmployeesController {

	@Autowired
	private EmployeesService employeesservice;
	
	@GetMapping("/fetch")
	public List<Employees> getAllData() {
		return this.employeesservice.getAllData();
	}
	
	@GetMapping("/fetch/{id}")
	public Employees getById(@PathVariable int id)
	{
		return this.employeesservice.getById(id);
		
	}
	
//	@GetMapping("/fetch/{name}")
//	public Employees getByName(@PathVariable String name)
//	{
//		return this.employeesservice.getByName(name);
//		
//	}
	
	@PostMapping("/fetch")
	public Employees addData(@RequestBody Employees employee)
	{
		this.employeesservice.addData(employee);
		return employee;
	}
	
	@DeleteMapping("/fetch/{id}")
	public void deleteData(@PathVariable int id)
	{
		 this.employeesservice.deleteData(id);
	}
	
	@PutMapping("/fetch/{id}")
	public Employees putData(@RequestBody Employees employee,@PathVariable int id)
	{
		this.employeesservice.putData(employee,id);
		return employee;
	}
}
