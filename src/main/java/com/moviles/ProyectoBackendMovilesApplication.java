package com.moviles;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.moviles")
public class ProyectoBackendMovilesApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProyectoBackendMovilesApplication.class, args);
	}

}
