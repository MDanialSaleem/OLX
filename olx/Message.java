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
}
