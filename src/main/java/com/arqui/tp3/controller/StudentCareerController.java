package com.arqui.tp3.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.arqui.tp3.domain.StudentCareer;
import com.arqui.tp3.dto.CareerReportDTO;
import com.arqui.tp3.dto.EnrolledDTO;
import com.arqui.tp3.service.StudentCareerServiceImpl;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/enrolled")
public class StudentCareerController {
	private StudentCareerServiceImpl studentCareerService;
	
	@GetMapping("/orderBy/quantity")
	public List<EnrolledDTO> getCareersOrderByQuantity() {
		return this.studentCareerService.getCareersOrderByQuantity();
		
	}
	@GetMapping("/report")
	public List<CareerReportDTO> getReport() {
		return this.studentCareerService.getReport();
	}
	@PostMapping("")
	public StudentCareer save(StudentCareer entity) throws Exception{
		return this.studentCareerService.save(entity);
	}

}