package com.arqui.tp3.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import org.springframework.stereotype.Repository;

import com.arqui.tp3.domain.Student;
import com.arqui.tp3.dto.StudentDTO;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long>  {
	
	//estos metodos son necesarios en el repo? o directo en el service?
		@Query("FROM Student s WHERE s.dni= :dni")
		//List<StudentDTO> getAllOrderByDni();
		public Optional<Student> findById( Long dni);

	// metodos getallstudentbygenre y por id se pueden hacer por el metodo findBy(criterio)
		@Query("SELECT s FROM Student s WHERE s.genre LIKE :genre")
		public List<Student> findByGenre(String genre);
		
		
		@Query("FROM Student s WHERE s.studentId = :studentId")
		public StudentDTO findByStudentId(Long studentId);
	 //el insert (save) lo vamos a pedir directo en el service al JPARepository
}
