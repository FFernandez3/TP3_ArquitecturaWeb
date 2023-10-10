package com.arqui.tp3.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.arqui.tp3.domain.Student;
import com.arqui.tp3.dto.EnrolledDTO;
import com.arqui.tp3.dto.StudentDTO;
import com.arqui.tp3.service.StudentServiceImpl;

@RestController
@RequestMapping("api/students")
public class StudentController {
	private StudentServiceImpl studentService;
	
	public StudentController(StudentServiceImpl studentService) {
		super();
		this.studentService = studentService;
	}

	@GetMapping("/dni/{dni}") 
	public Optional<StudentDTO> findById(@PathVariable Long dni){
		return this.studentService.findById(dni);
	}
	@GetMapping("/dni") 
	public List<StudentDTO> getAllStudentsOrderByDNI( ){
		return this.studentService.getAllStudentsOrderByDNI();
	}
	
	@GetMapping("/{genre}")
	public List<StudentDTO> findByGenre(@PathVariable String genre){
		return this.studentService.findByGenre(genre);
	}
	@GetMapping("studentID/{studentId}")
	public Optional<StudentDTO> findByStudentId(@PathVariable Long studentId) {
		return this.studentService.findByStudentId(studentId);
	}
	
	@GetMapping("search/{careerName}/{city}")
	public List<StudentDTO> getStudentsByCarrerAndCity(@PathVariable String careerName, @PathVariable String city){
		return this.studentService.getStudentsByCarrerAndCity(careerName, city);
	}
	
	@PostMapping("")
	public Student save(Student entity) throws Exception{
		return this.studentService.save(entity);
	}
	
	
	

}
