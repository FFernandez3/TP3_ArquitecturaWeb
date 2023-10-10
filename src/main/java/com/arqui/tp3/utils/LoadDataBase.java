package com.arqui.tp3.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.arqui.tp3.domain.Career;
import com.arqui.tp3.domain.Student;
import com.arqui.tp3.domain.StudentCareer;
import com.arqui.tp3.repository.CareerRepository;
import com.arqui.tp3.repository.StudentCareerRepository;
import com.arqui.tp3.repository.StudentRepository;

@Configuration
public class LoadDataBase {
	private static final Logger log = LoggerFactory.getLogger(LoadDataBase.class);

	@Bean
	CommandLineRunner initDatabase(StudentRepository  studentRepository, CareerRepository careerRepository, StudentCareerRepository studentCareerRepository) {
		return args -> {
			Career c1 = new Career("TUDAI");
			Career c2 = new Career("Ingenieria");
			Career c3 = new Career("TUARI");
			Career c4 = new Career("Profesorado de Matemática");
			Career c5 = new Career("Profesorado de Física");
			Career c6 = new Career("Licenciatura en Matemática");
			Career c7=new Career("Artes");
			
			Student s1 = new Student(32472514L, "Maria", "Conti", "F", 28, 25678L, "Tandil");
			Student s2 = new Student(39290710L, "Florencia", "Fernandez", "F", 22, 25999L, "Tandil");
			Student s3 = new Student(34258339L, "Florencia", "Bazan", "F", 34, 25946L, "Tandil");
			Student s4 = new Student(35350712L, "Melisa", "Burlando", "F", 24, 25752L, "Tandil");
			Student s5 = new Student(29286713L, "Lucrecia", "Martinez", "F", 39, 24984L, "Tandil");
			Student s6 = new Student(29795841L, "Marcelo", "Perez", "M", 38, 23798L, "Tres Arroyos");
			Student s7 = new Student(34965375L, "Pablo", "Lopez", "M", 32, 24697L, "Tandil");
			Student s8 = new Student(38754159L, "Nicolás", "Esperado", "M", 23, 23467L, "Tres Arroyos");
			Student s9 = new Student(33456789L, "Pedro", "Destino", "M", 36, 24951L, "Azul");
			Student s10 = new Student(31483927L, "Bautista", "Rodriguez", "M", 37, 25678L, "Tandil");
			Student s11 = new Student(35497843L, "Martí", "Navarro", "M", 35, 23472L, "Azul");
			
			StudentCareer sc1 = new StudentCareer(c2,s2,null,2024, false);
			StudentCareer sc2 = new StudentCareer(c1,s3,null,2022, false);
			StudentCareer sc3 = new StudentCareer(c3,s1,null,2023, false);
			StudentCareer sc4 = new StudentCareer(c4,s2,null,2024, false);
			StudentCareer sc5 = new StudentCareer(c5,s5,null,2021, false);
			StudentCareer sc6 = new StudentCareer(c6,s7,null,2019, false);
			StudentCareer sc7 = new StudentCareer(c1,s8,2022,2020, true);
			StudentCareer sc8 = new StudentCareer(c6,s9,null,2024, false);
			StudentCareer sc9 = new StudentCareer(c4,s10,null,2024, false);
			StudentCareer sc10 = new StudentCareer(c3,s11,2021,2019, true);
			StudentCareer sc11 = new StudentCareer(c2,s4,null,2023, false);
			StudentCareer sc12 = new StudentCareer(c5,s6,null,2023, false);
			
			log.info("Preloading " + careerRepository.save(c1));
			log.info("Preloading " + careerRepository.save(c2));
			log.info("Preloading " + careerRepository.save(c3));
			log.info("Preloading " + careerRepository.save(c4));
			log.info("Preloading " + careerRepository.save(c5));
			log.info("Preloading " + careerRepository.save(c6));
			log.info("Preloading " + studentRepository.save(s1));
			log.info("Preloading " + studentRepository.save(s2));
			log.info("Preloading " + studentRepository.save(s3));
			log.info("Preloading " + studentRepository.save(s4));
			log.info("Preloading " + studentRepository.save(s5));
			log.info("Preloading " + studentRepository.save(s6));
			log.info("Preloading " + studentRepository.save(s7));
			log.info("Preloading " + studentRepository.save(s8));
			log.info("Preloading " + studentRepository.save(s9));
			log.info("Preloading " + studentRepository.save(s10));
			log.info("Preloading " + studentRepository.save(s11));
			log.info("Preloading " + studentCareerRepository.save(sc1));
			log.info("Preloading " + studentCareerRepository.save(sc2));
			log.info("Preloading " + studentCareerRepository.save(sc3));
			log.info("Preloading " + studentCareerRepository.save(sc4));
			log.info("Preloading " + studentCareerRepository.save(sc5));
			log.info("Preloading " + studentCareerRepository.save(sc6));
			log.info("Preloading " + studentCareerRepository.save(sc7));
			log.info("Preloading " + studentCareerRepository.save(sc8));
			log.info("Preloading " + studentCareerRepository.save(sc9));
			log.info("Preloading " + studentCareerRepository.save(sc10));
			log.info("Preloading " + studentCareerRepository.save(sc11));
			log.info("Preloading " + studentCareerRepository.save(sc12));
			
		};
	}
}
