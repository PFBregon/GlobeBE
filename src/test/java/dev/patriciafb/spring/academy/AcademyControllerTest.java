package dev.patriciafb.spring.academy;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import java.util.Arrays;
import java.util.List;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@WebMvcTest(AcademyController.class)
public class AcademyControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private AcademyService service;

    @TestConfiguration
    static class TestConfig {
        @Bean
        public AcademyService academyService() {
            return Mockito.mock(AcademyService.class);
        }
    }

    @Test
    void testCreate() throws Exception {
        Academy academy = new Academy(1L, "Test Academy");
        when(service.save(Mockito.any(Academy.class))).thenReturn(academy);

        mockMvc.perform(post("/academies")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"id\":1,\"name\":\"Test Academy\"}"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(1))
                .andExpect(jsonPath("$.name").value("Test Academy"));

        verify(service, times(1)).save(Mockito.any(Academy.class));
    }

    @Test
    void testDelete() throws Exception {
        doNothing().when(service).deleteById(1L);

        mockMvc.perform(delete("/academies/1"))
                .andExpect(status().isOk());

        verify(service, times(1)).deleteById(1L);
    }

    @Test
    void testGetAll() throws Exception {
        List<Academy> academies = Arrays.asList(
                new Academy(1L, "Academy 1"),
                new Academy(2L, "Academy 2")
        );
        when(service.findAll()).thenReturn(academies);

        mockMvc.perform(get("/academies"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.length()").value(2))
                .andExpect(jsonPath("$[0].id").value(1))
                .andExpect(jsonPath("$[0].name").value("Academy 1"))
                .andExpect(jsonPath("$[1].id").value(2))
                .andExpect(jsonPath("$[1].name").value("Academy 2"));

        verify(service, times(1)).findAll();
    }
}