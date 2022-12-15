package com.api.employees.services;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.api.employees.entities.Employees;

@Component
public class EmployeesService {

	private static List<Employees> list1 = new ArrayList<>();

	static {
		list1.add(new Employees(11, "deepak", "ewbxui@gmail.com", "78667999"));
		list1.add(new Employees(12, "tejas", "gtri@gmail.com", "123447999"));
		list1.add(new Employees(13, "soham", "soham@gmail.com", "7874573379879"));
	}

	// Get all data
	public List<Employees> getAllData() {
		return list1;
	}

	// Get data by id
	public Employees getById(int id) {
		Employees employee = list1.stream().filter(e -> e.getId() == id).findFirst().get();
		return employee;
	}

	// Get data by name
	public Employees getByName(String name) {
		Employees employee = list1.stream().filter(f -> f.getName() == name).findFirst().get();
		return employee;
	}
	
	//add the data
	public void addData( Employees employee) {
	list1.add(employee);
	
}
	//delete the data
	public void deleteData(int id) {
		list1=list1.stream().filter(Employees-> Employees.getId()!=id).collect(Collectors.toList());
		
	}
	
	//Update the data
	public void putData(Employees employee,int id)
	{
		list1=list1.stream().map(e-> {
			if (e.getId()==id) {
				e.setName(employee.getName());
				e.setEmail(employee.getEmail());
				e.setNumber(employee.getNumber());	
			}
			return e;
		}).collect(Collectors.toList());
	}
}