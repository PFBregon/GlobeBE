package dev.patriciafb.spring.student;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import dev.patriciafb.spring.academy.Academy;
import dev.patriciafb.spring.group.Group;
import dev.patriciafb.spring.teacher.Teacher;

import java.util.Arrays;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class StudentServiceTest {

    @Mock
    private StudentRepository studentRepository;

    @InjectMocks
    private StudentService studentService;

    private Student student;

    @BeforeEach
    void setUp() {
        Academy academy = new Academy();
        academy.setId(1L);
        academy.setName("Science Academy");

        Teacher teacher = new Teacher();
        teacher.setId(1L);
        teacher.setName("Mr. Smith");

        Group group = new Group();
        group.setId(1L);
        group.setName("Group A");

        student = new Student(1L, "John", "Doe", EnglishLevel.B1, false, academy, teacher, group);
    }

    @Test
    void testGetAllStudents() {
        when(studentRepository.findAll()).thenReturn(Arrays.asList(student));


        var students = studentService.getAllStudents();

        assertNotNull(students);
        assertFalse(students.isEmpty());
        assertEquals(1, students.size());
        assertEquals("John", students.get(0).getName());

        verify(studentRepository, times(1)).findAll();
    }

    @Test
    void testGetStudentById() {
        when(studentRepository.findById(1L)).thenReturn(Optional.of(student));

        Optional<Student> foundStudent = studentService.getStudentById(1L);

        assertTrue(foundStudent.isPresent());
        assertEquals("John", foundStudent.get().getName());

        verify(studentRepository, times(1)).findById(1L);
    }

    @Test
    void testSaveStudent() {
        when(studentRepository.save(any(Student.class))).thenReturn(student);


        Student savedStudent = studentService.saveStudent(student);


        assertNotNull(savedStudent);
        assertEquals("John", savedStudent.getName());
        assertEquals("Doe", savedStudent.getSurname());

        verify(studentRepository, times(1)).save(any(Student.class));
    }

    @Test
    void testUpdateStudent() {
        Student updatedStudent = new Student();
        updatedStudent.setName("Jane");
        updatedStudent.setSurname("Smith");
        updatedStudent.setLevel(EnglishLevel.A2);
        updatedStudent.setHasAttendanceIssues(true);


        when(studentRepository.findById(1L)).thenReturn(Optional.of(student));
     
        when(studentRepository.save(any(Student.class))).thenReturn(updatedStudent);

   
        Student result = studentService.updateStudent(1L, updatedStudent);


        assertNotNull(result);
        assertEquals("Jane", result.getName());
        assertEquals("Smith", result.getSurname());
        assertEquals(EnglishLevel.A2, result.getLevel());
        assertTrue(result.isHasAttendanceIssues());

        verify(studentRepository, times(1)).findById(1L);
        verify(studentRepository, times(1)).save(any(Student.class));
    }

    @Test
    void testDeleteStudent() {
       
        doNothing().when(studentRepository).deleteById(1L);

        studentService.deleteStudent(1L);

        verify(studentRepository, times(1)).deleteById(1L);
    }
}
