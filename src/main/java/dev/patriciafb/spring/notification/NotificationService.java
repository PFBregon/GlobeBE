package dev.patriciafb.spring.notification;

import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class NotificationService {

    private final NotificationRepository repository;

    public NotificationService(NotificationRepository repository) {
        this.repository = repository;
    }

    public List<Notification> findAll() {
        return repository.findAll();
    }

    public List<Notification> findByRecipientId(Long studentId) {
        return repository.findByRecipientId(studentId);
    }

    public Notification save(Notification notification) {
        return repository.save(notification);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}
