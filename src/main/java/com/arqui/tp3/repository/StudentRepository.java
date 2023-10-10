package com.arqui.tp3.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import org.springframework.stereotype.Repository;

import com.arqui.tp3.domain.Student;
import com.arqui.tp3.dto.EnrolledDTO;
import com.arqui.tp3.dto.StudentDTO;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

	@Query("FROM Student s WHERE s.dni= :dni")
	public Optional<Student> findById(Long dni);

	// punto c
	@Query("FROM Student s ORDER BY s.dni")
	List<Student> getAllStudentsOrderByDNI();

	// punto e
	@Query("SELECT s FROM Student s WHERE s.genre LIKE :genre")
	public List<Student> findByGenre(String genre);

	// punto d
	@Query("FROM Student s WHERE s.studentId = :studentId")
	public Optional<Student> findByStudentId(Long studentId);
	
	//punto g
	@Query(value = "SELECT * FROM student s JOIN student_career sc ON s.dni = sc.id_student JOIN career c ON sc.id_career = c.id WHERE (c.career_name = :careerName) AND (s.city = :city)", nativeQuery = true)
	public List<Student> getStudentsByCarrerAndCity(String careerName, String city);
}
