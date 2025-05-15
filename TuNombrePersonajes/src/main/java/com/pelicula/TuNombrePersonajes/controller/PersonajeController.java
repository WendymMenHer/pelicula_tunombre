package com.pelicula.TuNombrePersonajes.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pelicula.TuNombrePersonajes.dto.PersonajeDTO;
import com.pelicula.TuNombrePersonajes.model.Personaje;
import com.pelicula.TuNombrePersonajes.repository.PersonajesRepository;
import com.pelicula.TuNombrePersonajes.service.PersonajesService;

@RestController
//http://localhost:8080/api/personajes/
@RequestMapping(path="/api/personajes/")
public class PersonajeController {
	private final PersonajesService personajeService;

    public PersonajeController(PersonajesService personajeService) {
        this.personajeService = personajeService;
        System.out.println("Personaje creado");
    }
    @Autowired
    private PersonajesRepository personajeRepository;
    
	@GetMapping
    public List<Personaje> listar() {
        return personajeService.getAllPersonajes();
    } //get all

    @GetMapping(path = "{pjid}")
    public Personaje obtenerPorId(@PathVariable("id") Long id) {
        return personajeService.getPersonaje(id);
    }// get 1

    @PostMapping
    public Personaje addPersonaje(@RequestBody Personaje p) {
        return personajeService.addPersonaje(p);
    }// Post 
    
    @PutMapping("{id}")
    public Personaje updatePersonaje(
            @PathVariable("id") Long id,
            @RequestBody PersonajeDTO personajeDTO) {
        return personajeService.updatePersonaje(id, personajeDTO);
    }//Put

    @DeleteMapping(path = "{pjid}")
    public Personaje deletePersonaje(@PathVariable ("pjid") Long id) {
        return personajeService.deletePersonaje(id);
    }//Delete


}
