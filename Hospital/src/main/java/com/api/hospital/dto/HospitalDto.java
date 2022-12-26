package com.api.hospital.dto;

public class HospitalDto {

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

	public HospitalDto(String name, String dept) {
		super();
		this.name = name;
		this.dept = dept;
	}

	public HospitalDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "HospitalDto [name=" + name + ", dept=" + dept + "]";
	}

}
