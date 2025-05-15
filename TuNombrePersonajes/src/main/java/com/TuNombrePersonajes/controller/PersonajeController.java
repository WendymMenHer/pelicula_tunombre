package com.TuNombrePersonajes.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.TuNombrePersonajes.model.Personaje;
import com.TuNombrePersonajes.service.PersonajesService;

@RestController
//http://localhost:8080/api/personajes/
@RequestMapping(path="/api/personajes/")
public class PersonajeController {
	private final PersonajesService personajeService;

    public PersonajeController(PersonajesService personajeService) {
        this.personajeService = personajeService;
    }
    @GetMapping("/ping")
    public String ping() {
        return "pong";
    }
	@GetMapping
    public List<Personaje> listar() {
        return personajeService.getAllPersonajes();
    } //get all

    @GetMapping(path = "{pjid}")
    public Personaje obtenerPorId(@PathVariable("pjid") Long id) {
        return personajeService.getPersonaje(id);
    }// get 1

    @PostMapping
    public Personaje addPersonaje(@RequestBody Personaje p) {
        return personajeService.addPersonaje(p);
    }// Post 

    @PutMapping(path = "{pjid}")
    public Personaje updatePersonaje(@PathVariable("pjid") Long id, 
    		@RequestParam(required = false) String nombre,
    		@RequestParam(required = false) String imagen,
    		@RequestParam(required = false) String rol,
    		@RequestParam(required = false) String description) {
    	return personajeService.UpdatePersonaje(id, nombre, imagen, rol, description);
    }//Put

    @DeleteMapping(path = "{pjid}")
    public Personaje deletePersonaje(@PathVariable ("pjid") Long id) {
        return personajeService.deletePersonaje(id);
    }//Delete


}
