package olx;

import java.sql.Timestamp;

public class Message {
    Timestamp time;
    String text;
    UserAccount account;

    public Message(Timestamp time, String text, UserAccount account) {
        this.time = time;
        this.text = text;
        this.account = account;
    }
}
