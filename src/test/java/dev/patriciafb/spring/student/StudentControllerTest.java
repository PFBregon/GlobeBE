package dev.patriciafb.spring.student;

import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;

import java.util.Arrays;
import java.util.Optional;
import java.util.List;
public class StudentControllerTest {

    @Mock private StudentService service;
    @Mock private StudentRepository studentRepository;

    @InjectMocks private StudentController controller;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testCreate() {
        StudentDto dto = new StudentDto();
        dto.setName("John");
        dto.setLevel("A1");
        Student student = new Student();
        when(service.saveStudent(any(Student.class))).thenReturn(student);

        StudentDto result = controller.create(dto);

        assertNotNull(result);
        verify(service).saveStudent(any(Student.class));
    }

    @Test
    void testDelete() {
        Long id = 1L;

        controller.delete(id);
        verify(service).deleteStudent(id);
    }

    @Test
    void testGetAll() {
        List<Student> students = Arrays.asList(new Student(), new Student());
        when(service.getAllStudents()).thenReturn(students);

        List<StudentDto> result = controller.getAll();

        assertEquals(2, result.size());
        verify(service).getAllStudents();
    }

    @Test
    void testGetById() {
        Long id = 1L;
        Student student = new Student();
        when(service.getStudentById(id)).thenReturn(Optional.of(student));

        StudentDto result = controller.getById(id);

        assertNotNull(result);
        verify(service).getStudentById(id);
    }

    @Test
    void testLogin() {
        LoginRequest loginRequest = new LoginRequest();
        loginRequest.setUsername("user");
        loginRequest.setPassword("pass");
        Student student = new Student();
        when(studentRepository.findByUsernameAndPassword("user", "pass")).thenReturn(Optional.of(student));

        ResponseEntity<?> response = controller.login(loginRequest);

        assertEquals(200, response.getStatusCode().value());
        verify(studentRepository).findByUsernameAndPassword("user", "pass");
    }

}
