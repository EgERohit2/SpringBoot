package com.example.hotel.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="Hotel")
public class Hotel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@NotNull(message="name cannot be null")
	private String name;
	@NotNull(message="dept cannot be null")
	private String dept;
	@NotNull(message="email cannot be null")
	private String email;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDept() {
		return dept;
	}
	public void setDept(String dept) {
		this.dept = dept;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Hotel(int id, String name, String dept, String email) {
		super();
		this.id = id;
		this.name = name;
		this.dept = dept;
		this.email = email;
	}
	public Hotel() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
