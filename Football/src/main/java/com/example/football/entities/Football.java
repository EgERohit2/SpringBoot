package com.example.football.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Football")
public class Football {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String player;
	private double sal;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPlayer() {
		return player;
	}

	public void setPlayer(String player) {
		this.player = player;
	}

	public double getSal() {
		return sal;
	}

	public void setSal(double sal) {
		this.sal = sal;
	}

	public Football(int id, String player, double sal) {
		super();
		this.id = id;
		this.player = player;
		this.sal = sal;
	}

	public Football() {
		super();
		// TODO Auto-generated constructor stub
	}

}
