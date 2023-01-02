package com.example.hotel.Dtos;

public class HotelDto {

	private String name;
	
	private String dept;

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

	public HotelDto(String name, String dept) {
		super();
		this.name = name;
		this.dept = dept;
	}

	public HotelDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
