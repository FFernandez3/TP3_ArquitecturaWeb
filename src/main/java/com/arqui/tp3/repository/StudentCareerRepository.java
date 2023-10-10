package com.arqui.tp3.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.arqui.tp3.domain.StudentCareer;



@Repository
public interface StudentCareerRepository extends JpaRepository<StudentCareer, Integer> {

	@Query(value = "SELECT c.career_name AS nombre_carrera, years.anio AS anio, COALESCE(inscriptos.count, 0) AS inscriptos, COALESCE(egresados.count, 0) AS egresados FROM career c CROSS JOIN (SELECT DISTINCT entry_year AS anio FROM student_career UNION SELECT DISTINCT graduation_year AS anio FROM student_career WHERE graduation_year IS NOT NULL ) years LEFT JOIN (SELECT sc.id_career AS career, sc.entry_year AS anio, COUNT(DISTINCT s.dni) AS count FROM student_career sc JOIN student s ON sc.id_student = s.dni GROUP BY sc.id_career, sc.entry_year) inscriptos ON c.id = inscriptos.career AND years.anio = inscriptos.anio LEFT JOIN ( SELECT sc.id_career AS career, sc.graduation_year AS anio, COUNT(DISTINCT s.dni) AS count FROM student_career sc JOIN student s ON sc.id_student = s.dni WHERE sc.graduation_year IS NOT NULL GROUP BY sc.id_career, sc.graduation_year ) egresados ON c.id = egresados.career AND years.anio = egresados.anio ORDER BY c.career_name, years.anio", nativeQuery = true)
	public List<Object[]> getReport();

}
