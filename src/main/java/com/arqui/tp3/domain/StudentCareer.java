package com.arqui.tp3.domain;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@EnableAutoConfiguration
@NoArgsConstructor
public class StudentCareer {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@JsonBackReference
	@ManyToOne(fetch = FetchType.LAZY)

	@JoinColumn(name = "id_Career", nullable = false)
	private Career career;

	@JsonBackReference
	@ManyToOne(fetch = FetchType.LAZY)

	@JoinColumn(name = "id_Student", nullable = false)
	private Student student;

	@Column(nullable = true)
	private Integer graduationYear;
	@Column(nullable = false)
	private Integer entryYear;
	@Column(nullable = false)
	private boolean isGraduated;

	public StudentCareer() {
		super();
	}

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
