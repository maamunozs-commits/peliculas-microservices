package demo.peliculas;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class PeliculaService {
    private final List<Pelicula> peliculas = List.of(
            new Pelicula(1, "El Padrino", 1972, "Francis Ford Coppola", "Crimen", "La familia Corleone lucha por mantener su poder en el mundo del crimen organizado."),
            new Pelicula(2, "Inception", 2010, "Christopher Nolan", "Ciencia ficcion", "Un grupo de especialistas entra en los sueños de sus objetivos para implantar una idea."),
            new Pelicula(3, "Parasite", 2019, "Bong Joon-ho", "Thriller", "Dos familias de clases opuestas quedan unidas por una relacion tan conveniente como peligrosa."),
            new Pelicula(4, "Spirited Away", 2001, "Hayao Miyazaki", "Fantasia", "Una niña entra en un mundo espiritual y debe rescatar a sus padres para volver a casa."),
            new Pelicula(5, "The Matrix", 1999, "Lana Wachowski y Lilly Wachowski", "Accion", "Un programador descubre que la realidad que conoce es una simulacion controlada por maquinas.")
    );

    public List<Pelicula> obtenerPeliculas() {
        return peliculas;
    }

    public Pelicula obtenerPeliculaPorId(int id) {
        return peliculas.stream()
                .filter(pelicula -> pelicula.getId() == id)
                .findFirst()
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Pelicula no encontrada"));
    }
}
