package com.arqui.tp3.dto;

import com.arqui.tp3.domain.Career;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class CareerDTO {

	private Long id;
	private String name;

	public CareerDTO() {
		super();
	}

	public CareerDTO(Long id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

}
