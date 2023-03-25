
public class View {
    public String welcomeNewUser(String username) {
        return "Welcome " + username + " to ChatCSIfElse, the best chat AI in the world! What can I help you?";
    }

    public String welcomeReturningUser(String username) {
        return "Welcome again " + username + "! Anything else today?";
    }

    public String outOfService() {
        return "Sorry, we are out of service at this moment.";
    }

    public String interestingMessage(String username, String previousMessage) {
        return "That is interesting " + username + ", that you said " + previousMessage
                + ". I will send this message to someone else very soon. Anything else I can help?";
    }
}
