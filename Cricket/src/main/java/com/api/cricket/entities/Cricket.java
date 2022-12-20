package com.api.cricket.entities;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

@Entity
public class Cricket {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	private String teamName;
	
	@OneToOne(cascade = CascadeType.ALL)
	private Player player;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTeamName() {
		return teamName;
	}
	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}
	public Player getPlayer() {
		return player;
	}
	public void setPlayer(Player player) {
		this.player = player;
	}
	public Cricket(int id, String teamName, Player player) {
		super();
		this.id = id;
		this.teamName = teamName;
		this.player = player;
	}
//	@Override
//	public String toString() {
//		return "Cricket [id=" + id + ", teamName=" + teamName + ", player=" + player + "]";
//	}
	public Cricket() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
