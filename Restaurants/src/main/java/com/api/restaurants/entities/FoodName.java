package com.api.restaurants.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class FoodName {
	
	@Id
	private int id;
	private String ownerName;
	private String famous;



	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getOwnerName() {
		return ownerName;
	}

	public void setOwnerName(String ownerName) {
		this.ownerName = ownerName;
	}

	public String getFamous() {
		return famous;
	}

	public void setFamous(String famous) {
		this.famous = famous;
	}



	
}
