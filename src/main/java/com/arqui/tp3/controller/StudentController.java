package com.arqui.tp3.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.arqui.tp3.domain.Student;
import com.arqui.tp3.dto.StudentDTO;
import com.arqui.tp3.service.StudentServiceImpl;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/students")
public class StudentController {
	private StudentServiceImpl studentService;
	
	@GetMapping("/dni") 
	public List<StudentDTO>findAll(@PathVariable Long dni){
		return this.studentService.findAll(dni);
	}
	
	@GetMapping("/{genre}")
	public List<StudentDTO> findByGenre(@PathVariable char genre){
		return this.studentService.findByGenre(genre);
	}
	@GetMapping("/{studentId}")
	public StudentDTO findByStudentId(@PathVariable Long studentId) {
		return this.studentService.findByStudentId(studentId);
	}
	@PostMapping("")
	public Student save(@PathVariable Student entity) throws Exception{
		return this.studentService.save(entity);
	}
	
	
	

}
