package dev.patriciafb.spring.student;

import dev.patriciafb.spring.academy.Academy;
import dev.patriciafb.spring.teacher.Teacher;
import dev.patriciafb.spring.group.Group;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class StudentTest {

    private Student student;
    private Academy academy;
    private Teacher teacher;
    private Group group;

    @BeforeEach
    void setUp() {
        academy = new Academy();
        academy.setId(1L);
        academy.setName("La Calzada");

        teacher = new Teacher();
        teacher.setId(1L);
        teacher.setName("Mr. Smith");

        group = new Group();
        group.setId(1L);
        group.setName("Group A");

        student = new Student(1L, "John", "Doe", EnglishLevel.B1, false, academy, teacher, group);
    }

    @Test
    void testGetId() {
        assertEquals(1L, student.getId());
    }

    @Test
    void testGetName() {
        assertEquals("John", student.getName());
    }

    @Test
    void testGetSurname() {
        assertEquals("Doe", student.getSurname());
    }

    @Test
    void testGetLevel() {
        assertEquals(EnglishLevel.B1, student.getLevel());
    }

    @Test
    void testGetAcademy() {
        assertEquals(academy, student.getAcademy());
    }

    @Test
    void testGetTeacher() {
        assertEquals(teacher, student.getTeacher());
    }

    @Test
    void testGetGroup() {
        assertEquals(group, student.getGroup());
    }

    @Test
    void testSetName() {
        student.setName("Jane");
        assertEquals("Jane", student.getName());
    }

    @Test
    void testSetSurname() {
        student.setSurname("Smith");
        assertEquals("Smith", student.getSurname());
    }

    @Test
    void testSetLevel() {
        student.setLevel(EnglishLevel.A2);
        assertEquals(EnglishLevel.A2, student.getLevel());
    }

    @Test
    void testSetHasAttendanceIssues() {
        student.setHasAttendanceIssues(true);
        assertTrue(student.isHasAttendanceIssues());
    }

    @Test
    void testSetAcademy() {
        Academy newAcademy = new Academy();
        newAcademy.setId(2L);
        student.setAcademy(newAcademy);
        assertEquals(newAcademy, student.getAcademy());
    }

    @Test
    void testSetTeacher() {
        Teacher newTeacher = new Teacher();
        newTeacher.setId(2L);
        student.setTeacher(newTeacher);
        assertEquals(newTeacher, student.getTeacher());
    }

    @Test
    void testSetGroup() {
        Group newGroup = new Group();
        newGroup.setId(2L);
        student.setGroup(newGroup);
        assertEquals(newGroup, student.getGroup());
    }
}
