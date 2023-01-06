package com.example.human.servcieImplementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.example.human.entities.Human;
import com.example.human.repository.HumanRepository;
import com.example.human.service.HumanService;

@Service
public class HumanServiceImplementation implements HumanService {

	@Autowired
	private HumanRepository humanRepository;

	@Override
	public List<Human> getAll(int pageNumber, int pageSize) {
		Pageable pageable = PageRequest.of(pageNumber -1, pageSize);
		Page<Human> page = humanRepository.findAll(pageable);

		return page.getContent();
	}
	
	public List<Human> getAllData()
	{
		return humanRepository.findAll();
	}

	@Override
	public Human postData(Human human) {
		return humanRepository.save(human);
	}

	@Override
	public void updateData(Human human, int id) {
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

