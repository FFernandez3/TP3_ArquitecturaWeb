package com.arqui.tp3.domain;

import java.io.Serializable;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@EnableAutoConfiguration
@NoArgsConstructor
public class StudentCareer implements Serializable {
	
	
	private static final long serialVersionUID = 1L;



	public StudentCareer() {
		super();
	}

	
	@EmbeddedId
	private StudentCareerPK id;
	
	
	@ManyToOne(cascade = CascadeType.PERSIST)
	@MapsId("id")
	@JoinColumn(name = "career", referencedColumnName = "id")
	private Career career;

	@ManyToOne(cascade = CascadeType.PERSIST)
	@MapsId("dni")
	@JoinColumn(name = "student", referencedColumnName = "dni")
	private Student student;

	@Column(nullable = true)
	private Integer graduationYear;
	@Column(nullable = false)
	private Integer entryYear;
	@Column(nullable = false)
	private boolean isGraduated;

	

	public StudentCareer(Career career, Student student, Integer graduationYear, Integer entryYear,
			boolean isGraduated) {
		super();
		this.career = career;
		this.student = student;
		this.graduationYear = graduationYear;
		this.entryYear = entryYear;
		this.isGraduated = isGraduated;
	}

	public Career getCareer() {
		return career;
	}

	public void setCareer(Career career) {
		this.career = career;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public int getGraduationYear() {
		return graduationYear;
	}

	public void setGraduationYear(int graduationYear) {
		this.graduationYear = graduationYear;
	}

	public int getEntryYear() {
		return entryYear;
	}

	public void setEntryYear(int entryYear) {
		this.entryYear = entryYear;
	}

	public boolean isGraduated() {
		return isGraduated;
	}

	public void setGraduated() {
		if (graduationYear == null) {
			this.isGraduated = false;
		} else {
			this.isGraduated = true;
		}

	}

}

