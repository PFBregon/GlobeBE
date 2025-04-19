package dev.patriciafb.spring.notification;

public class NotificationDTO {
    private Long id;
    private String title;
    private String content;
    private Long recipientId;

    public NotificationDTO() {}

    public NotificationDTO(Long id, String title, String content, Long recipientId) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.recipientId = recipientId;
    }

    public Long getId() { return id; }
    public String getTitle() { return title; }
    public String getContent() { return content; }
    public Long getRecipientId() { return recipientId; }

    public void setId(Long id) { this.id = id; }
    public void setTitle(String title) { this.title = title; }
    public void setContent(String content) { this.content = content; }
    public void setRecipientId(Long recipientId) { this.recipientId = recipientId; }
}
