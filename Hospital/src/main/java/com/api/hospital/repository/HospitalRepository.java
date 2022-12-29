package com.api.hospital.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.api.hospital.dtoimpl.DtoImplementation;
import com.api.hospital.entities.Hospital;

@Repository
public interface HospitalRepository extends JpaRepository<Hospital, Integer> {

	Page<DtoImplementation> findByDeptContainingIgnoreCaseOrderById(String trimAllWhitespace, Pageable paging,
			Class<DtoImplementation> class1);

	Page<DtoImplementation> findByOrderById(Pageable paging, Class<DtoImplementation> class1);

}
