package com.example.human.entities;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="Human")
public class Human {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String dept;
	@OneToOne(cascade = CascadeType.MERGE,fetch = FetchType.EAGER)
	@JoinColumn(name = "idt_id")
	private Identification identification;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDept() {
		return dept;
	}
	public void setDept(String dept) {
		this.dept = dept;
	}
	public Identification getIdentification() {
		return identification;
	}
	public void setIdentification(Identification identification) {
		this.identification = identification;
	}
	public Human(int id, String dept, Identification identification) {
		super();
		this.id = id;
		this.dept = dept;
		this.identification = identification;
	}
	public Human() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
}
