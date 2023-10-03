package com.arqui.tp3.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.arqui.tp3.domain.StudentCareer;
import com.arqui.tp3.dto.CareerReportDTO;
import com.arqui.tp3.dto.EnrolledDTO;
import com.arqui.tp3.repository.StudentCareerRepository;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class StudentCareerServiceImpl /* implements StudentCareerService */ {

	@Autowired
	private StudentCareerRepository studentCareerRepository;

	// save
	@Transactional
	public StudentCareer save(StudentCareer entity) throws Exception {
		try {
			return this.studentCareerRepository.save(entity);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}
	
	@Transactional
	public List<EnrolledDTO> getCareersOrderByQuantity() {
		return this.studentCareerRepository.getCareersOrderByQuantity().stream().map(
				enrolled -> new EnrolledDTO(enrolled.getCareerId(), enrolled.getCareerName(), enrolled.getQuantity()))
				.toList();
	}

	@Transactional
	public List<CareerReportDTO> getReport() {
		return this.studentCareerRepository.getReport().stream().map(report -> new CareerReportDTO(report.getCareerName(), report.getYears(), report.getRegistered(),
				report.getGraduates()))
		.toList();
	}
}
