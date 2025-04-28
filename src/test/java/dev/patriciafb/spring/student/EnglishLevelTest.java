package dev.patriciafb.spring.student;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class EnglishLevelTest {

    @Test
        void testValueOf() {
            assertEquals(EnglishLevel.A1, EnglishLevel.valueOf("A1"));
            assertEquals(EnglishLevel.B2, EnglishLevel.valueOf("B2"));
            assertThrows(IllegalArgumentException.class, () -> EnglishLevel.valueOf("INVALID"));
    }

    @Test
        void testValues() {
            EnglishLevel[] levels = EnglishLevel.values();
            assertEquals(6, levels.length);
            assertArrayEquals(new EnglishLevel[]{EnglishLevel.A1, EnglishLevel.A2, EnglishLevel.B1, EnglishLevel.B2, EnglishLevel.C1, EnglishLevel.C2}, levels);
    }

    @Test
        void testOrdinal() {
            assertEquals(0, EnglishLevel.A1.ordinal());
            assertEquals(5, EnglishLevel.C2.ordinal());
    }

    @Test
        void testToString() {
            assertEquals("A1", EnglishLevel.A1.toString());
            assertEquals("C2", EnglishLevel.C2.toString());
    }
}