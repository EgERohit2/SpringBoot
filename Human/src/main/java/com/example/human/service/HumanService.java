package com.example.human.service;

import java.util.List;

import com.example.human.entities.Human;

public interface HumanService {

	public List<Human> getAll();
	
	public Human postData(Human human);
	
	public void updateData(Human human,int id);
	
	public void deleteData(int id);
}
