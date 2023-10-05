package com.arqui.tp3.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.arqui.tp3.domain.Career;
import com.arqui.tp3.dto.CareerDTO;
import com.arqui.tp3.dto.EnrolledDTO;
import com.arqui.tp3.repository.CareerRepository;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
public class CareerServiceImpl {
	
	@Autowired
	private CareerRepository careerRepository;
	
	
	
	public CareerServiceImpl(CareerRepository careerRepository) {
		super();
		this.careerRepository = careerRepository;
	}


	@Transactional
	public Career save(Career entity) throws Exception{
		try {
			return this.careerRepository.save(entity);
		}
		catch(Exception e) {
			throw new Exception(e.getMessage());
		}		
	}
	
	public List<CareerDTO> getCareersOrderByQuantity() {
		return this.careerRepository.getCareersOrderByQuantity().stream().map(career->new CareerDTO(career.getId(), career.getName())).toList();
	}
	

	/*public List<EnrolledDTO> getStudentsByCarrerAndCity(String careerName, String city){
		//para este map uso el primer constructor
		return this.careerRepository.getStudentsByCarrerAndCity(careerName, city).stream().map(enrolled -> new EnrolledDTO(enrolled.getCareerId(), enrolled.getCareerName(), enrolled.getStudentName(), enrolled.getCity())).toList();
	}*/
}
