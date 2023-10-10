package com.arqui.tp3.service;

import java.math.BigInteger;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.arqui.tp3.domain.StudentCareer;
import com.arqui.tp3.dto.CareerReportDTO;
import com.arqui.tp3.dto.EnrolledDTO;
import com.arqui.tp3.repository.StudentCareerRepository;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service

public class StudentCareerServiceImpl /* implements StudentCareerService */ {
	
	private StudentCareerRepository studentCareerRepository;
	
	public StudentCareerServiceImpl(StudentCareerRepository studentCareerRepository) {
		super();
		this.studentCareerRepository = studentCareerRepository;
	}
	
	/*@Transactional*/ /*no poner transactional pq no se hacen cambios en la BD*/
	public List<CareerReportDTO> getReport() {
		List<Object[]> careerReports = this.studentCareerRepository.getReport();
        return careerReports.stream().map(report-> new CareerReportDTO((String)report[0], (Integer)report[1], (Long)report[2], (Long)report[3])).collect(Collectors.toList());
		
	}
	/*return this.studentCareerRepository.getReport().stream().map(report -> new CareerReportDTO(report.getCareerName(), report.getYears(), report.getRegistered(),
				report.getGraduates()))
		.toList();*/

	// save
	@Transactional
	public StudentCareer save(StudentCareer entity) throws Exception {
		try {
			return this.studentCareerRepository.save(entity);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}
	
	
	/*public List<EnrolledDTO> getCareersOrderByQuantity() {
		return this.studentCareerRepository.getCareersOrderByQuantity().stream().map(
				enrolled -> new EnrolledDTO(enrolled.getCareerId(), enrolled.getCareerName(), enrolled.getQuantity()))
				.toList();
	}*/
	/*public List<EnrolledDTO> getCareersOrderByQuantity2() {
		return this.studentCareerRepository.getCareersOrderByQuantity2().stream().map(
				enrolled -> new EnrolledDTO(enrolled.getCareerId(), enrolled.getCareerName(),enrolled.getStudentName(), enrolled.getCity(), enrolled.getQuantity()))
				.toList();
	}*/


}
