import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Model {
    private Map<String, List<ChatMessage>> chatHistory;

    public Model() {
        this.chatHistory = new HashMap<>();
    }

    public void addMessage(String username, ChatMessage message) {
        chatHistory.computeIfAbsent(username, k -> new ArrayList<>()).add(message);
    }

    public List<ChatMessage> getUserMessages(String username) {
        return chatHistory.getOrDefault(username, new ArrayList<>());
    }
}
