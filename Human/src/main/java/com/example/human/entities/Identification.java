package com.example.human.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="identification")
public class Identification {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="identifcation_id")
	private int identityId;
	private String name;
	private String gender;
	private String number;
	@OneToOne(mappedBy = "identification",fetch = FetchType.EAGER)
	private Human human;
	public int getIdentityId() {
		return identityId;
	}
	public void setIdentityId(int identityId) {
		this.identityId = identityId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	
	public Identification(int identityId, String name, String gender, String number) {
		super();
		this.identityId = identityId;
		this.name = name;
		this.gender = gender;
		this.number = number;
		
	}
	public Identification() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
