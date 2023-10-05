package com.arqui.tp3.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.arqui.tp3.domain.Career;
import com.arqui.tp3.dto.CareerDTO;
import com.arqui.tp3.dto.EnrolledDTO;
import com.arqui.tp3.service.CareerServiceImpl;

import lombok.RequiredArgsConstructor;



@RestController
@RequestMapping("api/careers")
public class CareerController {
	private CareerServiceImpl careerService;
	
	
	public CareerController(CareerServiceImpl careerService) {
		super();
		this.careerService = careerService;
	}

/*	@GetMapping("/{careerName}/{city}")
	public List<EnrolledDTO> getStudentsByCarrerAndCity(@PathVariable String careerName, @PathVariable String city){
		return this.careerService.getStudentsByCarrerAndCity(careerName, city);
	}*/
	@GetMapping("/orderBy/quantity")
	public List<CareerDTO> getCareersOrderByQuantity() {
		return this.careerService.getCareersOrderByQuantity();
		
	}
	
	@PostMapping("")
	public Career save(Career entity) throws Exception{
		return this.careerService.save(entity);
	}

}

