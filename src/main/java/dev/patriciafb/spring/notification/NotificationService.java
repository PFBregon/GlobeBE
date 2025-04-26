package dev.patriciafb.spring.notification;

import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class NotificationService {

    private final NotificationRepository repo;

    public NotificationService(NotificationRepository repo) {
        this.repo = repo;
    }

    public List<Notification> findAll() {
        return repo.findAll();
    }

    public Notification save(Notification notification) {
        return repo.save(notification);
    }

    public void delete(Long id) {
        repo.deleteById(id);
    }
}
