package com.example.tutorials.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="Tutorial")
public class Tutorial {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(name="name")
	private String name;
	@OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	@JoinColumn(name="pk_fk")
	private List<Comment> cooment;
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
	public List<Comment> getCooment() {
		return cooment;
	}
	public void setCooment(List<Comment> cooment) {
		this.cooment = cooment;
	}
	public Tutorial() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Tutorial(int id, String name, List<Comment> cooment) {
		super();
		this.id = id;
		this.name = name;
		this.cooment = cooment;
	}
	
	
}
