package com.pelicula.TuNombrePersonajes;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class TuNombrePersonajesApplication {

	public static void main(String[] args) {
		SpringApplication.run(TuNombrePersonajesApplication.class, args);
	}

}
