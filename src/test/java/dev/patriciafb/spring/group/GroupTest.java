package dev.patriciafb.spring.group;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
public class GroupTest {
    @Test
    void testGetId() {
        Group group = new Group(1L, "Test Group");
        assertEquals(1L, group.getId());
    }

    @Test
    void testGetName() {
        Group group = new Group(1L, "Test Group");
        assertEquals("Test Group", group.getName());
    }

    @Test
    void testSetId() {
        Group group = new Group();
        group.setId(2L);
        assertEquals(2L, group.getId());
    }

    @Test
    void testSetName() {
        Group group = new Group();
        group.setName("New Group");
        assertEquals("New Group", group.getName());
    }

    @Test
    void testConstructorWithParameters() {
        Group group = new Group(3L, "Constructor Group");
        assertEquals(3L, group.getId());
        assertEquals("Constructor Group", group.getName());
    }

    @Test
    void testDefaultConstructor() {
        Group group = new Group();
        assertNull(group.getId());
        assertNull(group.getName());
    }
}