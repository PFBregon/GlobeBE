package dev.patriciafb.spring.notification;

import dev.patriciafb.spring.student.StudentRepository;
import dev.patriciafb.spring.student.Student;

import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.stream.Collectors;

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

    @GetMapping
    public List<NotificationDTO> getAll() {
        return service.findAll().stream().map(this::toDTO).collect(Collectors.toList());
    }

    @PostMapping
    public NotificationDTO create(@RequestBody NotificationDTO dto) {
        Student recipient = studentRepo.findById(dto.getRecipientId()).orElse(null);
        if (recipient == null) {
            throw new RuntimeException("El estudiante no existe");
        }
        
        Notification notification = new Notification(dto.getTitle(), dto.getContent(), recipient);
        return toDTO(service.save(notification));
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
