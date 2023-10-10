package com.arqui.tp3.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Data;
import lombok.NoArgsConstructor;

@SuppressWarnings("serial")
@Data
@Entity
@EnableAutoConfiguration
@NoArgsConstructor
public class Student {

	@Id
	private Long dni;

	@Column(nullable = false)
	private String name;
	@Column(nullable = false)
	private String surname;
	@Column(nullable = false)
	private String genre;
	@Column(nullable = false)
	private int age;
	@Column(nullable = false)
	private Long studentId;
	@Column(nullable = false)
	private String city;
	@OneToMany(mappedBy = "student", cascade = CascadeType.MERGE)
	@JsonManagedReference
	private List<StudentCareer> careers;

	public Student() {
		super();
	}

	public Student(Long i, String name, String surname, String genre, int age, Long studentId, String city) {
		super();
		this.dni = i;
		this.name = name;
		this.surname = surname;
		this.genre = genre;
		this.age = age;
		this.studentId = studentId;
		this.city = city;
		this.careers = new ArrayList<StudentCareer>();
	}

	public ArrayList<StudentCareer> getCareers() {
		return new ArrayList<StudentCareer>(this.careers);
	}

	public Long getDni() {
		return dni;
	}

	public void setDni(Long dni) {
		this.dni = dni;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public Long getStudentId() {
		return studentId;
	}

	public void setStudentId(Long studentId) {
		this.studentId = studentId;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

}
