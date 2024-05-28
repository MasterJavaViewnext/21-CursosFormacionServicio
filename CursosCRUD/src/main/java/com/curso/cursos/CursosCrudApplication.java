package com.curso.cursos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EntityScan(basePackages = "com.curso.cursos.model")
@EnableJpaRepositories(basePackages = "com.curso.cursos.dao")
@SpringBootApplication(scanBasePackages = { "com.curso.cursos.controller", "com.curso.cursos.service" })
public class CursosCrudApplication {

	public static void main(String[] args) {
		SpringApplication.run(CursosCrudApplication.class, args);
	}

}
