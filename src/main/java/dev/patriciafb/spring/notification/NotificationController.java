package dev.patriciafb.spring.notification;

import org.springframework.web.bind.annotation.*;
import dev.patriciafb.spring.student.Student;
import dev.patriciafb.spring.student.StudentRepository;

import java.util.List;

@RestController
@RequestMapping("/api/notifications")
@CrossOrigin(origins = "*")
public class NotificationController {

    private final NotificationService service;
    private final StudentRepository studentRepo;

    public NotificationController(NotificationService service, StudentRepository studentRepo) {
        this.service = service;
        this.studentRepo = studentRepo;
    }

    @GetMapping("/student/{studentId}")
    public List<NotificationDTO> getNotificationsByStudent(@PathVariable Long studentId) {
    List<Notification> notifications = service.findByRecipientId(studentId);
    return notifications.stream()
            .map(this::toDTO)
            .toList();
}


    @PostMapping
    public NotificationDTO createNotification(@RequestBody NotificationDTO dto) {
        Student recipient = studentRepo.findById(dto.getRecipientId())
            .orElseThrow(() -> new RuntimeException("El estudiante no existe"));

        Notification notification = new Notification(dto.getTitle(), dto.getContent(), recipient);
        return toDTO(service.save(notification));
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }

    private NotificationDTO toDTO(Notification notification) {
        return new NotificationDTO(
            notification.getId(),
            notification.getTitle(),
            notification.getContent(),
            notification.getRecipient() != null ? notification.getRecipient().getId() : null
        );
    }
}
