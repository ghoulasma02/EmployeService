package com.ingweb.EmployeService;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class EmployeServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmployeServiceApplication.class, args);
	}

	@Bean
	CommandLineRunner star(EmployeRepository employeRepository) {
		return args -> {
			employeRepository.save(new Employe(null,"Aichaoui","Aicha","aicha1.aicha1@adressemail.com"));
			employeRepository.save(new Employe(null,"Mohamed","Ahmed","mohamed.ahmed@adressemail.com"));
			employeRepository.save(new Employe(null,"Gues","Billal","Gues.Billal@adressemail.com"));
			employeRepository.findAll().forEach(emp-> {System.out.println(emp.toString());});
		};
	}
}
