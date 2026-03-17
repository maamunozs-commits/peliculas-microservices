# Peliculas Microservices

Proyecto academico desarrollado para DUOC UC.

## 1. Identificacion del trabajo

- Institucion: DUOC UC
- Carrera: Ingenieria desarrollo de software
- Asignatura: Desarrollo Full Stack
- Docente: Alonso Castillo
- Estudiante(s): Matias Muñoz
- Fecha: Marzo 2026

## 2. Descripcion general

Este proyecto corresponde a un microservicio REST construido con Spring Boot para la gestion y consulta de peliculas.

La aplicacion expone endpoints simples:

- Obtener el listado completo de peliculas.
- Obtener el detalle de una pelicula segun su identificador.

## 3. Objetivo del proyecto

Implementar un microservicio funcional mediante HTTP, aplicando:

- Arquitectura por responsabilidades (Controller y Service).
- Manejo de respuestas y errores HTTP.

## 4. Tecnologias utilizadas

- Java 21
- Spring Boot 3.5.0
- Maven Wrapper
- Spring Web

## 5. Estructura del proyecto

```text
src/
  main/
    java/demo/peliculas/
      PeliculasServiceApplication.java
      PeliculaController.java
      PeliculaService.java
      Pelicula.java
    resources/
      application.properties
  test/
    java/demo/peliculas/
      PeliculaControllerTest.java
```

## 6. Arquitectura y flujo

1. El cliente realiza una solicitud HTTP.
2. PeliculaController recibe la solicitud.
3. PeliculaService procesa la logica de negocio y devuelve datos.
4. Spring Boot serializa la respuesta a formato JSON.

### Endpoints disponibles

| Metodo | Ruta | Descripcion |
| --- | --- | --- |
| GET | `/peliculas` | Lista todas las peliculas disponibles |
| GET | `/peliculas/{id}` | Busca una pelicula por su identificador |

## 7. Modelo de datos

Cada pelicula contiene los siguientes campos:

- id
- titulo
- año
- director
- genero
- sinopsis

Ejemplo de respuesta JSON:

```json
{
  "id": 3,
  "titulo": "Parasite",
  "año": 2019,
  "director": "Bong Joon-ho",
  "genero": "Thriller",
  "sinopsis": "Dos familias de clases opuestas quedan unidas por una relacion tan conveniente como peligrosa."
}
```

## 8. Ejecucion del proyecto

### Requisitos previos

- Java 21 instalado
- Maven Wrapper incluido en el proyecto

### Levantar en modo desarrollo

En Windows:

```bash
mvnw.cmd spring-boot:run
```

En Linux o macOS:

```bash
./mvnw spring-boot:run
```

La API queda disponible en:

- http://localhost:8080/peliculas

## 9. Criterios de calidad aplicados

- Separacion clara de responsabilidades entre capa de controlador y servicio.
- Respuestas HTTP consistentes.
- Codigo legible y facil de extender.
- Base de pruebas para validar comportamiento principal.
