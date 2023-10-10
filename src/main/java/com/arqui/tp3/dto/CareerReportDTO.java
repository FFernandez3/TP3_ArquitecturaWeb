package com.arqui.tp3.dto;

import java.math.BigInteger;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

@Data

@JsonIgnoreProperties(ignoreUnknown = true)
public class CareerReportDTO {
	private String careerName;
	private Integer years;
	private Long dni;
	private Long registered;
	private Long graduates;
	private Integer entryYear;
	private Integer graduationYear;

	public CareerReportDTO() {

	}

	public CareerReportDTO(String careerName, Integer years, Long registered, Long graduates) {
		super();
		this.careerName = careerName;
		this.years = years;
		this.graduates = graduates;
		this.registered = registered;
	}

	public Integer getYears() {
		return years;
	}

	public Long getRegistered() {
		return registered;
	}

	public Long getGraduates() {
		return graduates;
	}

	public String getCareerName() {
		return careerName;
	}

	public Long getDni() {
		return dni;
	}

	public Integer getEntryYear() {
		return entryYear;
	}

	public Integer getGraduationYear() {
		return graduationYear;
	}

	@Override
	public String toString() {
		return "CareerReportDTO [careerName=" + careerName + ", dni=" + dni + ", entryYear=" + entryYear
				+ ", graduationYear=" + graduationYear + "]";
	}

}
