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
public interface CareerRepository extends JpaRepository<Career, Long> {

	@Query("SELECT DISTINCT c FROM Career c JOIN c.students s WHERE size(s) > 0 ORDER BY size(s) DESC")
	public List<Career> getCareersOrderByQuantity();

}
