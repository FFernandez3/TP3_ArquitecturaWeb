package com.arqui.tp3.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.arqui.tp3.domain.StudentCareer;
import com.arqui.tp3.dto.CareerReportDTO;

import com.arqui.tp3.repository.StudentCareerRepository;

import jakarta.transaction.Transactional;

@Service

public class StudentCareerServiceImpl {

	private StudentCareerRepository studentCareerRepository;

	public StudentCareerServiceImpl(StudentCareerRepository studentCareerRepository) {
		super();
		this.studentCareerRepository = studentCareerRepository;
	}

	/* @Transactional */ /* no poner transactional pq no se hacen cambios en la BD */
	public List<CareerReportDTO> getReport() {
		List<Object[]> careerReports = this.studentCareerRepository.getReport();
		return careerReports.stream().map(report -> new CareerReportDTO((String) report[0], (Integer) report[1],
				(Long) report[2], (Long) report[3])).collect(Collectors.toList());

	}

	// save
	@Transactional
	public StudentCareer save(StudentCareer entity) throws Exception {
		try {
			return this.studentCareerRepository.save(entity);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}

}
