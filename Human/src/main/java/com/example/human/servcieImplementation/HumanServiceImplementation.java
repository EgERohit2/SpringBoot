package com.example.human.servcieImplementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.human.entities.Human;
import com.example.human.repository.HumanRepository;
import com.example.human.service.HumanService;

@Service
public class HumanServiceImplementation implements HumanService{

	@Autowired
	private HumanRepository humanRepository;

	@Override
	public List<Human> getAll() {
		
		return humanRepository.findAll();
	}

	@Override
	public Human postData(Human human) {
		// TODO Auto-generated method stub
		return humanRepository.save(human);
	}

	@Override
	public void updateData(Human human,int id) {
		Human h = humanRepository.findById(id).orElseThrow();
		
	h.setDept(human.getDept());
	h.setIdentification(human.getIdentification());
	humanRepository.save(h);
	
		
	}

	@Override
	public void deleteData(int id) {
		 humanRepository.deleteById(id);
	}
	
	
}
