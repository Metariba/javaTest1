package com.example.test;

import Details.Details;
import Student.Student;
import Student.StudentRepository;
import Student.StudentController;
import Details.DetailRepository;
import Details.DetailsController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan(basePackageClasses = {StudentController.class, DetailsController.class})
@EntityScan(basePackageClasses = {Student.class, Details.class})
@EnableJpaRepositories(basePackageClasses = {StudentRepository.class, DetailRepository.class})
public class TestApplication {
	public static void main(String[] args) {
		SpringApplication.run(TestApplication.class, args);
	}

}



