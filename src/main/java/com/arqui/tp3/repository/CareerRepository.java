package com.arqui.tp3.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.arqui.tp3.domain.Career;
import com.arqui.tp3.dto.CareerDTO;
import com.arqui.tp3.dto.EnrolledDTO;
import com.arqui.tp3.dto.StudentDTO;

@Repository
public interface CareerRepository extends JpaRepository<Career, Long>  {
	
		
	@Query("SELECT DISTINCT c FROM Career c JOIN c.students s WHERE size(s) > 0 ORDER BY size(s) DESC")
	public List<Career> getCareersOrderByQuantity();
	
	/*@Query(value="SELECT c.id, c.name, s.name, s.city FROM Student s JOIN StudentCareer sc ON s.dni = sc.student JOIN Career c ON sc.career = c.id WHERE (c.name = :careerName) AND (s.city = :city)")*/
	/*@Query(value="SELECT c.id, c.career_name, s.name, s.city FROM student s JOIN student_career sc ON s.dni = sc.id_student JOIN career c ON sc.id_career = c.id WHERE (c.career_name = :careerName) AND (s.city = :city)", nativeQuery=true)
	public List<EnrolledDTO> getStudentsByCarrerAndCity(String careerName, String city);*/
	
	//el insert (save) lo vamos a pedir directo en el service al JPARepository
	
	
	/*@Query("SELECT DISTINCT(s) FROM Student s JOIN s.careers c WHERE c.id = :idCarrera AND e.ciudad = :ciudad ")
	public List<EnrolledDTO> getStudentsByCarrerAndCity(Integer idCarrera, String city);*/
	
	/*@Query("SELECT c.id, c.name, s.name, s.city"
			+ "FROM Student s "
			+ "IN (s.careers) sc "
			+ "WHERE sc.name = :careerName"
			+ "AND s.city = :city")
	public List<EnrolledDTO> getStudentsByCarrerAndCity(String careerName, String city);
	
	/*@Query("SELECT c.id, c.name, s.name, s.city\r\n"
			+ "FROM Student s\r\n"
			+ "JOIN s.careers sc\r\n"
			+ "JOIN sc.career c\r\n"
			+ "WHERE c.name = :careerName\r\n"
			+ "AND s.city = :city")
	public List<EnrolledDTO> getStudentsByCarrerAndCity(String careerName, String city);*/
	
	
}
