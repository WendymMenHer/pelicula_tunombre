# CRUD de Personajes – *Your Name (Kimi no Na wa)*

Este proyecto es una API REST desarrollada con **Java 17**, **Spring Boot**, y **MySQL** que permite gestionar personajes de la película animada *Your Name* (*Kimi no Na wa*), dirigida por Makoto Shinkai. Implementa operaciones CRUD básicas y desarrollo backend.

---

## Tecnologías Usadas

- **Lenguaje:** Java 17  
- **Framework:** Spring Boot  
- **Persistencia:** Spring Data JPA + MySQL  
- **Build tool:** Gradle  
- **Patrón de diseño:** MVC  
- **Otros:** DTOs, manejo de excepciones, controladores REST

---

## Funcionalidades

- `GET /api/personajes` – Listar todos los personajes  
- `GET /api/personajes/{id}` – Obtener un personaje por ID  
- `POST /api/personajes` – Crear un nuevo personaje  
- `PUT /api/personajes/{id}` – Modificar uno o más campos de un personaje  
- `DELETE /api/personajes/{id}` – Eliminar un personaje

---

## Entidad Principal: `Personaje`

| Campo        | Tipo    | Descripción                            |
|--------------|---------|----------------------------------------|
| id           | Long    | Identificador único                    |
| nombre       | String  | Nombre del personaje                   |
| imagen       | String  | Nombre del archivo de imagen           |
| rol          | String  | Rol que cumple en la película          |
| descripcion  | String  | Descripción detallada (opcional)       |

---

## Datos de Ejemplo

Se han ingresado manualmente personajes principales de la película, como:

- Taki Tachibana  
- Mitsuha Miyamizu  
- Miki Okudera  
- Katsuhiko Teshigawara  
- Sayaka Natori

---

## Características Técnicas

- API estructurada en capas (`controller`, `service`, `repository`, `model`)
- Uso de DTO (`PersonajeDTO`) para actualizaciones parciales

---

## Cómo Probar

Usar herramientas como **Postman**. Un ejemplo:
//http://localhost:8080/api/personajes/

```http

PUT /api/personajes/1
en el Body agregar:

{
  "descripcion": "Es un chico que vive en Tokio y trabaja en un restaurante italiano."
}
