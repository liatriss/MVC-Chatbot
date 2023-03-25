import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.sql.*;


public class Controller {
    private Model model;
    private View view;

    public Controller(Model model, View view) {
        this.model = model;
        this.view = view;
    }

    public static void main(String[] args) throws IOException {
        Model model = new Model();
        View view = new View();
        Controller controller = new Controller(model, view);

        //get username
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Enter your name: ");
        String username = reader.readLine();
        List<ChatMessage> messages = model.getUserMessages(username);

        //send to view file print text
        if (messages.isEmpty()) {
            System.out.println(view.welcomeNewUser(username));
        } else {
            System.out.println(view.welcomeReturningUser(username));
        }

        while (true) {
            String userMessage = reader.readLine();
            LocalDateTime now = LocalDateTime.now();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MMM-dd hh:mm");
            System.out.println("Time :"+now.format(formatter));

            //check time
            if (now.getHour() >=8 || now.getHour() < 17 || now.getDayOfWeek().getValue() >= 6) {
                System.out.println(view.interestingMessage(username, userMessage));
            } else {
                System.out.println(view.outOfService());
            }

            model.addMessage(username, new ChatMessage(userMessage, true, now));
            model.addMessage("ChatCSIfElse", new ChatMessage(view.interestingMessage(username, userMessage), false, now));
        }
    }
}
