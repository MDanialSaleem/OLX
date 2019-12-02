package olx;
import java.time.*;

public class Message {
    LocalDateTime time;
    String text;
    UserAccount sender;

    public Message(String text, UserAccount sender) {
        this.text = text;
        this.sender = sender;
        time = LocalDateTime.now();
    }
    
    public void viewMessage() {
    	System.out.println("===========");
    	System.out.println(sender.getName());
    	System.out.println(time);
    	System.out.println(text);
    	System.out.println("===========");
    	
    }
}
