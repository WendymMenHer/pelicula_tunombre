package com.pelicula.TuNombrePersonajes.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Personaje {
	  @Id
	  @GeneratedValue(strategy = GenerationType.IDENTITY)
	  private Long id;
	  private String nombre;
	  private String imagen;
	  private String rol;
	  private String descripcion;
	  
	//Constructor.
	public Personaje(Long id, String nombre, String imagen, String rol, String descripcion) {
		this.id = id;
		this.nombre = nombre;
		this.imagen = imagen;
		this.rol = rol;
		this.descripcion = descripcion;
	}
	//Constructor vacío
	public Personaje() {
	}
	
	//Getters y setters.
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getImagen() {
		return imagen;
	}
	public void setImagen(String imagen) {
		this.imagen = imagen;
	}
	public String getRol() {
		return rol;
	}
	public void setRol(String rol) {
		this.rol = rol;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	//ToString
	@Override
	public String toString() {
		return "Personaje [id=" + id + ", nombre=" + nombre + ", imagen=" + imagen + ", rol=" + rol + ", descripcion="
				+ descripcion + "]";
	}
}
