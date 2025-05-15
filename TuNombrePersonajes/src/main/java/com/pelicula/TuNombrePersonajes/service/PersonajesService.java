package com.pelicula.TuNombrePersonajes.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.pelicula.TuNombrePersonajes.dto.PersonajeDTO;
import com.pelicula.TuNombrePersonajes.model.Personaje;
import com.pelicula.TuNombrePersonajes.repository.PersonajesRepository;


@Service
public class PersonajesService {
	@Autowired
	public final PersonajesRepository personajesRepository;
	@Autowired
	public PersonajesService (PersonajesRepository personajesRepository) {
		this.personajesRepository = personajesRepository;
	}//Constructor
	
	@Cacheable("personajes")
	public List<Personaje> getAllPersonajes(){
		return personajesRepository.findAll();
	}//getAll
	
	public Personaje getPersonaje(Long id) {
		return personajesRepository.findById(id).orElseThrow(
				()-> new IllegalArgumentException("El personaje que buscaste no existe")
				);
	}//Get 1
	
	public Personaje deletePersonaje(Long id) {
		Personaje personaje = null;
		if(personajesRepository.existsById(id)) {
			personaje = personajesRepository.findById(id).get();
			personajesRepository.deleteById(id);
		}// si tiene id
		return personaje;
	}//delete
	
	public Personaje addPersonaje (Personaje personaje) {
		Optional<Personaje> perso = personajesRepository.findByNombre(personaje.getNombre());
		if(perso.isEmpty()) {
			personajesRepository.save(personaje);
			return personaje;
		} else {
			return null;
		}
	}//Add
	
	public Personaje updatePersonaje(Long id, PersonajeDTO dto) {
        Personaje personaje = personajesRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Personaje no encontrado"));

        if (dto.getNombre() != null) {
            personaje.setNombre(dto.getNombre());
        }
        if (dto.getImagen() != null) {
            personaje.setImagen(dto.getImagen());
        }
        if (dto.getRol() != null) {
            personaje.setRol(dto.getRol());
        }
        if (dto.getDescripcion() != null) {
            personaje.setDescripcion(dto.getDescripcion());
        }

        return personajesRepository.save(personaje);
    }//Update
}