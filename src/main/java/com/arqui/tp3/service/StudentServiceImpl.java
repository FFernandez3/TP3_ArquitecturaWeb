package com.arqui.tp3.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.arqui.tp3.domain.Student;
import com.arqui.tp3.dto.EnrolledDTO;
import com.arqui.tp3.dto.StudentDTO;
import com.arqui.tp3.repository.StudentRepository;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service

public class StudentServiceImpl {

	private StudentRepository studentRepository;

	public StudentServiceImpl(StudentRepository studentRepository) {
		super();
		this.studentRepository = studentRepository;
	}

	// save
	@Transactional
	public Student save(Student entity) throws Exception {
		try {
			return this.studentRepository.save(entity);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}

	public Optional<StudentDTO> findById(Long dni) {
		return this.studentRepository.findById(dni).map(student -> new StudentDTO(student.getDni(), student.getName(),
				student.getSurname(), student.getGenre(), student.getAge(), student.getStudentId(), student.getCity()));

	}

	public List<StudentDTO> getAllStudentsOrderByDNI() {
		return this.studentRepository.getAllStudentsOrderByDNI().stream()
				.map(student -> new StudentDTO(student.getDni(), student.getName(), student.getSurname(),
						student.getGenre(), student.getAge(), student.getStudentId(), student.getCity()))
				.toList();

	}

	public List<StudentDTO> findByGenre(String genre) {
		return this.studentRepository.findByGenre(genre).stream()
				.map(student -> new StudentDTO(student.getDni(), student.getName(), student.getSurname(),
						student.getGenre(), student.getAge(), student.getStudentId(), student.getCity()))
				.toList();

	}

	public Optional<StudentDTO> findByStudentId(Long studentId) {
		return this.studentRepository.findByStudentId(studentId)
				.map(student -> new StudentDTO(student.getDni(), student.getName(), student.getSurname(),
						student.getGenre(), student.getAge(), student.getStudentId(), student.getCity()));
	}

	public List<StudentDTO> getStudentsByCarrerAndCity(String careerName, String city) {
		return this.studentRepository.getStudentsByCarrerAndCity(careerName, city).stream()
				.map(student -> new StudentDTO(student.getDni(), student.getName(), student.getSurname(),
						student.getGenre(), student.getAge(), student.getStudentId(), student.getCity()))
				.toList();
	}

}
