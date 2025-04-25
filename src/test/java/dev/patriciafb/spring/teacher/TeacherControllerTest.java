package dev.patriciafb.spring.teacher;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.Arrays;
import java.util.List;

import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;

class TeacherControllerTest {

    private MockMvc mockMvc;

    private TeacherService teacherService;

    private ObjectMapper objectMapper;

    private Teacher teacher1;
    private Teacher teacher2;

    @BeforeEach
    void setUp() {
        teacherService = Mockito.mock(TeacherService.class);

        TeacherController teacherController = new TeacherController(teacherService);
        mockMvc = MockMvcBuilders.standaloneSetup(teacherController).build();

        objectMapper = new ObjectMapper();

        teacher1 = new Teacher(1L, "Patricia Fernandez");
        teacher2 = new Teacher(2L, "Carlos Garcia");
    }

    @Test
    void testGetAllTeachers() throws Exception {
        List<Teacher> teachers = Arrays.asList(teacher1, teacher2);

        when(teacherService.findAll()).thenReturn(teachers);

        mockMvc.perform(get("/teachers")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.size()").value(teachers.size()))
                .andExpect(jsonPath("$[0].fullName").value(teacher1.getFullName()))
                .andExpect(jsonPath("$[1].fullName").value(teacher2.getFullName()))
                .andDo(print()); 
    }

    @Test
    void testCreateTeacher() throws Exception {
    Teacher newTeacher = new Teacher(null, "Ana Lopez");

    when(teacherService.save(any(Teacher.class))).thenAnswer(invocation -> {
        Teacher teacher = invocation.getArgument(0);
        teacher.setId(3L); 
        return teacher;
    });

    mockMvc.perform(post("/teachers")
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(objectMapper.writeValueAsString(newTeacher)))
            .andExpect(status().isCreated()) 
            .andExpect(jsonPath("$.id").value(3L)) 
            .andExpect(jsonPath("$.fullName").value("Ana Lopez")) 
            .andDo(print()); 
    }

    @Test
    void testDeleteTeacher() throws Exception {
        Long teacherId = 1L;

    
        mockMvc.perform(delete("/teachers/{id}", teacherId))
            .andExpect(status().isNoContent()) 
            .andExpect(content().string("")) 
            .andDo(print()); 

    Mockito.verify(teacherService).deleteById(eq(teacherId));
}
}