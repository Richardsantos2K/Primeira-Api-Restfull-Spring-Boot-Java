package com.teste.primeiroexemplo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan("model")
@EnableJpaRepositories(basePackages = "model")
public class PrimeiroExemploApplication {

	public static void main(String[] args) {
		SpringApplication.run(PrimeiroExemploApplication.class, args);
	}

}
