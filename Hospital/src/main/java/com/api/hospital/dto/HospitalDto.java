package com.api.hospital.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

public class HospitalDto {

	@NotBlank(message = "name shouldn't be null")
	private String name;
	@NotNull(message = "dept can not be null")
	private String dept;
	@NotBlank(message = "email souldn't be null")
	private String email;

	public HospitalDto(String email) {
		super();
		this.email = email;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
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
