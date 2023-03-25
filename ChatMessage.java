import java.time.LocalDateTime;

public class ChatMessage {
    private String message;
    private boolean isUser;
    private LocalDateTime timestamp;

    public ChatMessage(String message, boolean isUser, LocalDateTime timestamp) {
        this.message = message;
        this.isUser = isUser;
        this.timestamp = timestamp;
    }

    // Getters and Setters for message, isUser, and timestamp
}
