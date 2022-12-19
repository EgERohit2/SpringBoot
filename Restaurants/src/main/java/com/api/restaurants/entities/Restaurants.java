package com.api.restaurants.entities;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "Restaurants")
public class Restaurants {

	@Id
//	@GeneratedValue(strategy= GenerationType.AUTO)
	private int id;
	
	@OneToOne(cascade = CascadeType.ALL)
	private FoodName foodName;
	private double price;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public FoodName getFoodName() {
		return foodName;
	}

	public void setFoodName(FoodName foodName) {
		this.foodName = foodName;
	}

	@Override
	public String toString() {
		return "Restaurants [id=" + id + ", foodName=" + foodName + ", price=" + price + "]";
	}

	public Restaurants() {
		super();
		// TODO Auto-generated constructor stub
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public Restaurants(int id, FoodName foodName, double price) {
		super();
		this.id = id;
		this.foodName = foodName;
		this.price = price;
	}

}
