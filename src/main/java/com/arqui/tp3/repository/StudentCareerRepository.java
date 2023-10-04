package com.arqui.tp3.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.arqui.tp3.domain.StudentCareer;
import com.arqui.tp3.domain.StudentCareerPK;
import com.arqui.tp3.dto.CareerReportDTO;
import com.arqui.tp3.dto.EnrolledDTO;

@Repository
public interface StudentCareerRepository extends JpaRepository<StudentCareer, Integer> {
	//el insert (save) lo vamos a pedir directo en el service al JPARepository
	
		@Query("SELECT c, size(t) AS quantity FROM Career c JOIN c.students t ORDER BY quantity")
	/*@Query("SELECT c.id, c.name, COUNT(c.id) "
            + "AS quantity FROM Career c "
            + "JOIN StudentCareer sc ON c.id = sc.career"
            + "  GROUP BY c.name ORDER BY quantity")*/
		public List<EnrolledDTO> getCareersOrderByQuantity();
		
		@Query(value="SELECT c.career_name AS nombre_carrera, years.anio AS anio, COALESCE(inscriptos.count, 0) AS inscriptos, COALESCE(egresados.count, 0) AS egresados " 
				+ "FROM career c"
				+ "CROSS JOIN (" 
				+ "    SELECT DISTINCT entryYear AS anio FROM student_career "
				+ "    UNION "
				+ "    SELECT DISTINCT graduationYear AS anio FROM student_career WHERE graduationYear IS NOT NULL "
				+ ") years "
				+ "LEFT JOIN (" 
				+ "    SELECT sc.id_career, sc.entryYear AS anio, COUNT(DISTINCT s.dni) AS count FROM student_career sc " 
				+ "    JOIN student s ON sc.id_student = s.dni "
				+ "    GROUP BY sc.id_career, sc.entryYear "
				+ ") inscriptos ON c.id = inscriptos.career AND years.anio = inscriptos.anio "
				+ "LEFT JOIN ("
				+ "    SELECT sc.id_career, sc.graduationYear AS anio, COUNT(DISTINCT s.dni) AS count FROM  student_career sc "
				+ "    JOIN  student s ON sc.id_student = s.dni " 
				+ "    WHERE sc.graduationYear IS NOT NULL"
				+ "    GROUP BY sc.id_career, sc.graduationYear "
				+ "  ) egresados ON c.id = egresados.career AND years.anio = egresados.anio "
				+ "  ORDER BY c.career_name, years.anio", nativeQuery=true
				)
		public List<CareerReportDTO> getReport();


}
