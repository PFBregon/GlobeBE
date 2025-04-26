package dev.patriciafb.spring.notification;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import dev.patriciafb.spring.student.Student;


class NotificationTest {

    @Test
    void testNotificationConstructor() {
        Student recipient = new Student(); 
        Notification notification = new Notification("Test Title", "Test Content", recipient);

        assertNotNull(notification);
        assertEquals("Test Title", notification.getTitle());
        assertEquals("Test Content", notification.getContent());
        assertEquals(recipient, notification.getRecipient());
        assertNotNull(notification.getSentAt());
    }
}