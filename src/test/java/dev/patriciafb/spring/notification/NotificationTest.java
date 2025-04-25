package dev.patriciafb.spring.notification;

import org.junit.jupiter.api.Test;
import dev.patriciafb.spring.student.Student;
import java.time.LocalDateTime;
import static org.junit.jupiter.api.Assertions.*;

    public class NotificationTest {
        @Test
        void testGetContent() {
            Notification notification = new Notification("Test Title", "Test Content", new Student());
            assertEquals("Test Content", notification.getContent());
        }

        @Test
        void testGetId() {
            Notification notification = new Notification();
            notification.setId(1L);
            assertEquals(1L, notification.getId());
        }

        @Test
        void testGetRecipient() {
            Student student = new Student();
            Notification notification = new Notification("Test Title", "Test Content", student);
            assertEquals(student, notification.getRecipient());
        }

        @Test
        void testGetSentAt() {
            Notification notification = new Notification();
            assertNotNull(notification.getSentAt());
        }

        @Test
        void testGetTitle() {
            Notification notification = new Notification("Test Title", "Test Content", new Student());
            assertEquals("Test Title", notification.getTitle());
        }

        @Test
        void testSetContent() {
            Notification notification = new Notification();
            notification.setContent("Updated Content");
            assertEquals("Updated Content", notification.getContent());
        }

        @Test
        void testSetId() {
            Notification notification = new Notification();
            notification.setId(2L);
            assertEquals(2L, notification.getId());
        }

        @Test
        void testSetRecipient() {
            Student student = new Student();
            Notification notification = new Notification();
            notification.setRecipient(student);
            assertEquals(student, notification.getRecipient());
        }

        @Test
        void testSetSentAt() {
            Notification notification = new Notification();
            LocalDateTime now = LocalDateTime.now();
            notification.setSentAt(now);
            assertEquals(now, notification.getSentAt());
        }

        @Test
        void testSetTitle() {
            Notification notification = new Notification();
            notification.setTitle("Updated Title");
            assertEquals("Updated Title", notification.getTitle());
        }
    }