package com.api.hospital.implementation;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.api.hospital.dto.HospitalDto;
import com.api.hospital.dtoimpl.DtoImplementation;
import com.api.hospital.entities.Hospital;
import com.api.hospital.exception.DataNotFoundException;
import com.api.hospital.repository.HospitalRepository;
import com.api.hospital.service.HospitalService;

@Service
public class HospitalServiceImplementation implements HospitalService {

	@Autowired
	private HospitalRepository hospitalRepository;

	@Override
	public List<Hospital> getAll(int pageNumber, int pageSize) {
		Pageable pageable = PageRequest.of(pageNumber - 1, pageSize);
		Page<Hospital> page = hospitalRepository.findAll(pageable);
		return page.getContent();

	}

	@Override // void vs EntityReturnORDtoReturn
	public void postAll(Hospital hospital) {
		hospitalRepository.save(hospital);

	}

	@Override
	public void updateData(Hospital hospital, int id) throws DataNotFoundException {
		Hospital h = hospitalRepository.findById(id).orElseThrow();
		h.setName(hospital.getName());
		h.setDept(hospital.getDept());
		hospitalRepository.save(h);
	}

	@Override
	public void deleteData(int id) {
		hospitalRepository.deleteById(id);

	}

	@Override
	public List<HospitalDto> getAlls() {
		List<Hospital> hospitaList = hospitalRepository.findAll();
		List<HospitalDto> hospitalDtos = new ArrayList<>();
		for (int i = 0; i < hospitaList.size(); i++) {

			HospitalDto hospitalDto = new HospitalDto();
			hospitalDto.setName(hospitaList.get(i).getName());
			hospitalDto.setDept(hospitaList.get(i).getDept());
			hospitalDto.setEmail(hospitaList.get(i).getEmail());
			hospitalDtos.add(hospitalDto);
		}
		return hospitalDtos;
	}

	@Override
	public Page<DtoImplementation> findAllWithPage(String search, String pageNumber, String pageSize) {
		Pageable paging = PageRequest.of(Integer.parseInt(pageNumber) - 1, Integer.parseInt(pageSize));
		Page<DtoImplementation> cvList;
		if ((search == "") || (search == null) || (search.length() == 0)) {
			cvList = hospitalRepository.findByOrderById(paging, DtoImplementation.class);
		} else {
			cvList = hospitalRepository.findByDeptContainingIgnoreCaseOrderById(StringUtils.trimAllWhitespace(search),
					paging, DtoImplementation.class);
		}

		return cvList;
	}

	@Override
	public List<Hospital> getAllData() {
		return hospitalRepository.findAll();
	}

	@Override
	public List<Hospital> findData() {
		return hospitalRepository.findAll();
	}

	@Override
	public Hospital findData(int id) {
		return hospitalRepository.findById(id).orElseThrow(() -> new DataNotFoundException());

	}

}
