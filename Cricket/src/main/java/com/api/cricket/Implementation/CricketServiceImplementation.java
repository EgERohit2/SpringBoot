package com.api.cricket.Implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Sort;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.api.cricket.entities.Cricket;
import com.api.cricket.repository.CricketRespository;
import com.api.cricket.services.CricketServices;


@Service
public class CricketServiceImplementation implements CricketServices {

	@Autowired
	private CricketRespository cricketRespository;

	@Override
	public List<Cricket> getAll() {
		// TODO Auto-generated method stub
		return cricketRespository.findAll();
	}

	@Override
	public Cricket getAllById(int id) {
		// TODO Auto-generated method stub
		Cricket list = null;
		try {
			list = cricketRespository.findById(id).orElseThrow();
		} catch (Exception e) {
			// TODO: handle exception
		}

		return list;
	}

	public Cricket postData(Cricket cricket) {
		// TODO Auto-generated method stub
		return cricketRespository.save(cricket);
	}

	public void putData(Cricket cricket, int id) {
		// TODO Auto-generated method stub
		Cricket cric = cricketRespository.findById(id).orElseThrow();
		cric.setTeamName(cricket.getTeamName());
		cric.setPlayer(cricket.getPlayer());
		cricketRespository.save(cric);

	}

	@Override
	public void deleteData(int id) {
		// TODO Auto-generated method stub
		cricketRespository.deleteById(id);
	}

	@Override
	public List<Cricket> getDetailsAll(int pageNumber, int pageSize) {
		
		Pageable pageable =PageRequest.of(pageNumber, pageSize);
		Page<Cricket> page = cricketRespository.findAll(pageable);
		return page.getContent();
	
	}
}
