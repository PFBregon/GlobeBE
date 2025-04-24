package dev.patriciafb.spring.academy;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class AcademyTest {
    @Test
    void testGetId() {
        Academy academy = new Academy(1L, "Test Academy");
        assertEquals(1L, academy.getId());
    }

    @Test
    void testGetName() {
        Academy academy = new Academy(1L, "Test Academy");
        assertEquals("Test Academy", academy.getName());
    }

    @Test
    void testSetId() {
        Academy academy = new Academy();
        academy.setId(2L);
        assertEquals(2L, academy.getId());
    }

    @Test
    void testSetName() {
        Academy academy = new Academy();
        academy.setName("New Academy");
        assertEquals("New Academy", academy.getName());
    }

    @Test
    void testConstructorWithParameters() {
        Academy academy = new Academy(3L, "Parameterized Academy");
        assertEquals(3L, academy.getId());
        assertEquals("Parameterized Academy", academy.getName());
    }

    @Test
    void testDefaultConstructor() {
        Academy academy = new Academy();
        assertNull(academy.getId());
        assertNull(academy.getName());
    }
}
