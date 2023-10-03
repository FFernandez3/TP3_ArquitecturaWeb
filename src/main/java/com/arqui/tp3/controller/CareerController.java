package com.arqui.tp3.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.arqui.tp3.domain.Career;
import com.arqui.tp3.dto.EnrolledDTO;
import com.arqui.tp3.service.CareerServiceImpl;

import lombok.RequiredArgsConstructor;



@RestController
@RequiredArgsConstructor
@RequestMapping("api/careers")
public class CareerController {
	private CareerServiceImpl careerService;
	
	@GetMapping("/{careerName}/{city}")
	public List<EnrolledDTO> getStudentsByCarrerAndCity(@PathVariable String careerName, @PathVariable String city){
		return this.careerService.getStudentsByCarrerAndCity(careerName, city);
	}
	
	@PostMapping("")
	public Career save(@PathVariable Career entity) throws Exception{
		return this.careerService.save(entity);
	}

}

