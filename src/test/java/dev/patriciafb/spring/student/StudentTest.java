package dev.patriciafb.spring.student;

import dev.patriciafb.spring.academy.Academy;
import dev.patriciafb.spring.teacher.Teacher;
import dev.patriciafb.spring.group.Group;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class StudentTest {

    @Test
    void testGetAcademy() {
        Academy academy = new Academy();
        Student student = new Student();
        student.setAcademy(academy);
        assertEquals(academy, student.getAcademy());
    }

    @Test
    void testGetGroup() {
        Group group = new Group();
        Student student = new Student();
        student.setGroup(group);
        assertEquals(group, student.getGroup());
    }

    @Test
    void testGetId() {
        Long id = 1L;
        Student student = new Student();
        student.setId(id);
        assertEquals(id, student.getId());
    }

    @Test
    void testGetLevel() {
        EnglishLevel level = EnglishLevel.C1;
        Student student = new Student();
        student.setLevel(level);
        assertEquals(level, student.getLevel());
    }

    @Test
    void testGetName() {
        String name = "Lucia";
        Student student = new Student();
        student.setName(name);
        assertEquals(name, student.getName());
    }

    @Test
    void testGetSurname() {
        String surname = "Gonzalez";
        Student student = new Student();
        student.setSurname(surname);
        assertEquals(surname, student.getSurname());
    }

    @Test
    void testGetTeacher() {
        Teacher teacher = new Teacher();
        Student student = new Student();
        student.setTeacher(teacher);
        assertEquals(teacher, student.getTeacher());
    }

    @Test
    void testIsHasAttendanceIssues() {
        Student student = new Student();
        student.setHasAttendanceIssues(true);
        assertTrue(student.isHasAttendanceIssues());
    }

    @Test
    void testSetAcademy() {
        Academy academy = new Academy();
        Student student = new Student();
        student.setAcademy(academy);
        assertEquals(academy, student.getAcademy());
    }

    @Test
    void testSetGroup() {
        Group group = new Group();
        Student student = new Student();
        student.setGroup(group);
        assertEquals(group, student.getGroup());
    }

    @Test
    void testSetHasAttendanceIssues() {
        Student student = new Student();
        student.setHasAttendanceIssues(false);
        assertFalse(student.isHasAttendanceIssues());
    }

    @Test
    void testSetId() {
        Long id = 2L;
        Student student = new Student();
        student.setId(id);
        assertEquals(id, student.getId());
    }

    @Test
    void testSetLevel() {
        EnglishLevel level = EnglishLevel.A2;
        Student student = new Student();
        student.setLevel(level);
        assertEquals(level, student.getLevel());
    }

    @Test
    void testSetName() {
        String name = "Jane";
        Student student = new Student();
        student.setName(name);
        assertEquals(name, student.getName());
    }

    @Test
    void testSetSurname() {
        String surname = "Smith";
        Student student = new Student();
        student.setSurname(surname);
        assertEquals(surname, student.getSurname());
    }

    @Test
    void testSetTeacher() {
        Teacher teacher = new Teacher();
        Student student = new Student();
        student.setTeacher(teacher);
        assertEquals(teacher, student.getTeacher());
    }
}
