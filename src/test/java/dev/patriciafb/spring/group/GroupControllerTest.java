package dev.patriciafb.spring.group;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import java.util.Collections;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(GroupController.class)
public class GroupControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private GroupService service; 

    @TestConfiguration
    static class TestConfig {
        @Bean
        public GroupService groupService() {
            return Mockito.mock(GroupService.class);
        }
    }

    @Test
    void testCreate() throws Exception {
        Group group = new Group(1L, "Test Group");
        when(service.save(Mockito.any(Group.class))).thenReturn(group);

        mockMvc.perform(post("/groups")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"id\":1,\"name\":\"Test Group\"}"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(1))
                .andExpect(jsonPath("$.name").value("Test Group"));

        verify(service, times(1)).save(Mockito.any(Group.class));
    }

    @Test
    void testDelete() throws Exception {
        doNothing().when(service).deleteById(1L);

        mockMvc.perform(delete("/groups/1"))
                .andExpect(status().isOk());

        verify(service, times(1)).deleteById(1L);
    } 

    @Test
    void testGetAllEmpty() throws Exception {
        when(service.findAll()).thenReturn(Collections.emptyList());

        mockMvc.perform(get("/groups"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").isEmpty());

        verify(service, times(1)).findAll();
    }
}