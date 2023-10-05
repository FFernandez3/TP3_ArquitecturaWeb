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
public interface StudentRepository extends JpaRepository<Student, Long>  {
	
	//estos metodos son necesarios en el repo? o directo en el service?
		@Query("FROM Student s WHERE s.dni= :dni")
		//List<StudentDTO> getAllOrderByDni();
		public Optional<Student> findById( Long dni);

	// metodos getallstudentbygenre y por id se pueden hacer por el metodo findBy(criterio)
		@Query("SELECT s FROM Student s WHERE s.genre LIKE :genre")
		public List<Student> findByGenre(String genre);
		
		
		@Query("FROM Student s WHERE s.studentId = :studentId")
		public Optional<Student> findByStudentId(Long studentId);
	 //el insert (save) lo vamos a pedir directo en el service al JPARepository
		
		@Query(value="SELECT * FROM student s JOIN student_career sc ON s.dni = sc.id_student JOIN career c ON sc.id_career = c.id WHERE (c.career_name = :careerName) AND (s.city = :city)", nativeQuery=true)
		/*@Query("FROM Student s JOIN StudentCareer sc ON s.dni = sc.student JOIN Career c ON sc.career = c.id WHERE (c.name = :careerName) AND (s.city = :city)")*/
		public List<Student> getStudentsByCarrerAndCity(String careerName, String city);
}
