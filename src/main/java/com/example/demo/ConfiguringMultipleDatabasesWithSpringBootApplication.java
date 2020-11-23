package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan(basePackages= {"com.configurations", "com.controller", "com.entities", "com.services", "com.viewmodels"})
@EnableJpaRepositories(basePackages= {"com.repositories"})
@EntityScan(basePackages= {"com.entities"})
public class ConfiguringMultipleDatabasesWithSpringBootApplication {

	public static void main(String[] args) {
		SpringApplication.run(ConfiguringMultipleDatabasesWithSpringBootApplication.class, args);
	}

}
