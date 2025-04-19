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

    public Notification save(Notification message) {
        return repository.save(message);
    }
}
