package dev.patriciafb.spring.notification;

import dev.patriciafb.spring.student.Student;
import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Notification {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String content;

    private LocalDateTime sentAt;

    @ManyToOne
    private Student recipient;

    public Notification() {
        this.sentAt = LocalDateTime.now();
    }

    public Notification(String title, String content, Student recipient) {
        this.title = title;
        this.content = content;
        this.recipient = recipient;
        this.sentAt = LocalDateTime.now();
    }

    public Long getId() { return id; }
    public String getTitle() { return title; }
    public String getContent() { return content; }
    public LocalDateTime getSentAt() { return sentAt; }
    public Student getRecipient() { return recipient; }

    public void setId(Long id) { this.id = id; }
    public void setTitle(String title) { this.title = title; }
    public void setContent(String content) { this.content = content; }
    public void setSentAt(LocalDateTime sentAt) { this.sentAt = sentAt; }
    public void setRecipient(Student recipient) { this.recipient = recipient; }
}
