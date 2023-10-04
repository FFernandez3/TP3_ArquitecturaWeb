package com.arqui.tp3.domain;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.*;


@Embeddable
@Getter @Setter
@AllArgsConstructor @NoArgsConstructor
@EqualsAndHashCode
public class StudentCareerPK implements Serializable{
	
	
	@Column(name = "id_Career")
    private Long idCareer;
	
    @Column( name = "id_Student")
    private Long idStudent;
    
	public StudentCareerPK(Long id, Long idStudent) {
		super();
		this.idCareer = id;
		this.idStudent = idStudent;
	}

}
