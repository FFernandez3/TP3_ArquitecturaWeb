package com.arqui.tp3.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class StudentDTO {
	private Long dni;

	private String name;

	private String surname;

	private String genre;

	private int age;

	private Long studentId;

	private String city;

	public StudentDTO() {

	}

	public StudentDTO(Long dni, String name, String surname, String genre, int age, Long studentId, String city) {
		super();
		this.dni = dni;
		this.name = name;
		this.surname = surname;
		this.genre = genre;
		this.age = age;
		this.studentId = studentId;
		this.city = city;
	}

	public Long getDni() {
		return dni;
	}

	public String getName() {
		return name;
	}

	public String getSurname() {
		return surname;
	}

	public String getGenre() {
		return genre;
	}

	public int getAge() {
		return age;
	}

	public Long getStudentId() {
		return studentId;
	}

	public String getCity() {
		return city;
	}

	@Override
	public String toString() {
		return "StudentDTO [dni=" + dni + ", name=" + name + ", surname=" + surname + ", genre=" + genre + ", age="
				+ age + ", studentId=" + studentId + ", city=" + city + "]";
	}
}
