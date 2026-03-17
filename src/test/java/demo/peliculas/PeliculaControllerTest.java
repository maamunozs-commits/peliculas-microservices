package demo.peliculas;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
@AutoConfigureMockMvc
class PeliculaControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void debeRetornarTodasLasPeliculas() throws Exception {
        mockMvc.perform(get("/peliculas"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.length()").value(5))
                .andExpect(jsonPath("$[0].titulo").value("El Padrino"));
    }

    @Test
    void debeRetornarUnaPeliculaPorId() throws Exception {
        mockMvc.perform(get("/peliculas/3"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(3))
                .andExpect(jsonPath("$.titulo").value("Parasite"));
    }

    @Test
    void debeRetornar404CuandoNoExisteLaPelicula() throws Exception {
        mockMvc.perform(get("/peliculas/99"))
                .andExpect(status().isNotFound());
    }
}
