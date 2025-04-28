package dev.patriciafb.spring.notification;

import dev.patriciafb.spring.student.Student;
import dev.patriciafb.spring.student.StudentRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.List;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@ExtendWith(MockitoExtension.class)
class NotificationControllerTest {

    @Mock
    NotificationService service;

    @Mock
    StudentRepository studentRepo;

    @InjectMocks
    NotificationController controller;

    MockMvc mockMvc;

    @Test
    void testGetNotificationsByStudent() throws Exception {
        mockMvc = MockMvcBuilders.standaloneSetup(controller).build();

        Long studentId = 1L;
        Notification notification = new Notification("Titulo", "Contenido", new Student());
        notification.setId(1L);

        when(service.findByRecipientId(studentId)).thenReturn(List.of(notification));

        mockMvc.perform(get("/api/notifications/student/{studentId}", studentId))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$[0].title").value("Titulo"))
            .andExpect(jsonPath("$[0].content").value("Contenido"));

        verify(service, times(1)).findByRecipientId(studentId);
    }

    @Test
    void testCreateNotification() throws Exception {
        mockMvc = MockMvcBuilders.standaloneSetup(controller).build();

        
        Student student = new Student();
        student.setId(1L);

        Notification savedNotification = new Notification("Nuevo Titulo", "Nuevo Contenido", student);
        savedNotification.setId(1L);

        when(studentRepo.findById(1L)).thenReturn(Optional.of(student));
        when(service.save(any(Notification.class))).thenReturn(savedNotification);

        mockMvc.perform(post("/api/notifications")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"title\":\"Nuevo Titulo\",\"content\":\"Nuevo Contenido\",\"recipientId\":1}"))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$.id").value(1L))
            .andExpect(jsonPath("$.title").value("Nuevo Titulo"));

        verify(studentRepo, times(1)).findById(1L);
        verify(service, times(1)).save(any(Notification.class));
    }

    @Test
    void testDeleteNotification() throws Exception {
        mockMvc = MockMvcBuilders.standaloneSetup(controller).build();

        Long notificationId = 1L;

        doNothing().when(service).delete(notificationId);

        mockMvc.perform(delete("/api/notifications/{id}", notificationId))
            .andExpect(status().isOk());

        verify(service, times(1)).delete(notificationId);
    }
}
