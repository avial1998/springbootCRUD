package com.springboot;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.springboot.dao.StudentRepository;
import com.springboot.entities.Student;

@Configuration
public class StudentConfig {
	@Bean
	CommandLineRunner commandLineRunner(StudentRepository studentRepository) {
		return args->{
			Student avinash=new Student( "Avinash", LocalDate.of(1998, Month.SEPTEMBER, 19));
			Student thanmaya=new Student( "Thanmaya", LocalDate.of(2011, Month.AUGUST, 5));
			studentRepository.saveAll(List.of(avinash,thanmaya));

		};
	}
}
