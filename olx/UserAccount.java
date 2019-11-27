package olx;

import java.util.Date;
import java.util.List;

public class UserAccount extends Account {
   Boolean unReadMessages;
   Location loc;
   List<Advertisement> published;
   List<Advertisement> likedAds;
   List<Report> Reported;
   List<UserAccount> Followers;
   List<Chat> ChatsInitiated;

    public UserAccount(String name, Date joinDate, String email, String phoneNumber, String password, OLX app, Boolean unReadMessages, Location loc, List<Advertisement> published, List<Advertisement> likedAds, List<Report> reported, List<UserAccount> followers, List<Chat> chatsInitiated) {
        super(name, joinDate, email, phoneNumber, password);
        this.unReadMessages = unReadMessages;
        this.loc = loc;
        this.published = published;
        this.likedAds = likedAds;
        Reported = reported;
        Followers = followers;
        ChatsInitiated = chatsInitiated;
    }
}
