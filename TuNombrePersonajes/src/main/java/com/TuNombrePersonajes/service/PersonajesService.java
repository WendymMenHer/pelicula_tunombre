package com.TuNombrePersonajes.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.TuNombrePersonajes.model.Personaje;
import com.TuNombrePersonajes.repository.PersonajesRepository;


@Service
public class PersonajesService {
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
	
	public Personaje UpdatePersonaje (Long id, String nombre, String imagen, String rol, String descripcion) {
		Personaje perso = null;
		if (personajesRepository.existsById(id)) {
			Personaje personaje = personajesRepository.findById(id).get();
			if (nombre!=null)personaje.setNombre(nombre);
			if (imagen!=null)personaje.setImagen(imagen);
			if (rol!=null)personaje.setRol(rol);
			if (descripcion!=null)personaje.setDescripcion(descripcion);
			personajesRepository.save(personaje);
			perso = personaje;
		} // if
		return perso;
	}//Update
}