package com.pelicula.TuNombrePersonajes.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pelicula.TuNombrePersonajes.model.Personaje;

@Repository
public interface PersonajesRepository extends JpaRepository <Personaje, Long>{
	Optional <Personaje> findByNombre (String nombre);
}
