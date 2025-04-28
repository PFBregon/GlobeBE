package dev.patriciafb.spring.teacher;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class TeacherTest {
    @Test
    void testGetFullName() {
        Teacher teacher = new Teacher(1L, "John Doe");
        assertEquals("John Doe", teacher.getFullName());
    }

    @Test
    void testGetId() {
        Teacher teacher = new Teacher(1L, "John Doe");
        assertEquals(1L, teacher.getId());
    }

    @Test
    void testSetFullName() {
        Teacher teacher = new Teacher();
        teacher.setFullName("Jane Doe");
        assertEquals("Jane Doe", teacher.getFullName());
    }

    @Test
    void testSetId() {
        Teacher teacher = new Teacher();
        teacher.setId(2L);
        assertEquals(2L, teacher.getId());
    }

    @Test
    void testConstructorWithParameters() {
        Teacher teacher = new Teacher(3L, "Alice Smith");
        assertEquals(3L, teacher.getId());
        assertEquals("Alice Smith", teacher.getFullName());
    }

    @Test
    void testDefaultConstructor() {
        Teacher teacher = new Teacher();
        assertNull(teacher.getId());
        assertNull(teacher.getFullName());
    }
}
