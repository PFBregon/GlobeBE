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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Long getRecipientId() {
        return recipientId;
    }

    public void setRecipientId(Long recipientId) {
        this.recipientId = recipientId;
    }
}
