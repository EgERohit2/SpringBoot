package com.example.customer.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="bikes")
public class Bikes {
	
	@Id
	private int id;
	private String name;
	private int price;
	@Column(name="customer_id")
	private Integer customer_id;

	public Bikes(Integer customer_id) {
		super();
		this.customer_id = customer_id;
	}

	public Integer getCustomer_id() {
		return customer_id;
	}

	public void setCustomer_id(Integer customer_id) {
		this.customer_id = customer_id;
	}

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

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public Bikes(int id, String name, int price) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
	}

	public Bikes() {
		super();
		// TODO Auto-generated constructor stub
	}

}
