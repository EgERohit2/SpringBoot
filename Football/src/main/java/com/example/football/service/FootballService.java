package com.example.football.service;

import java.util.List;

import com.example.football.entities.Football;

public interface FootballService {

	public List<Football> getAll(int pageNumber, int pageSize);
}

	