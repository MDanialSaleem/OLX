package olx;

import java.util.Date;
import java.util.List;

public class UserAccount extends Account {
   Boolean hasUnreadMessages;
   Boolean hasUnopenedUpdates;
   Location loc;
   List<Advertisement> published;
   List<Advertisement> likedAds;
   List<Report> reportedAds;
   List<UserAccount> Followers;
   List<Chat> ChatsInitiated;

    public UserAccount(String name, Date joinDate, String email, String phoneNumber, String password, OLX app, boolean unReadMessages, boolean hasUnopenedUpdates, Location loc, List<Advertisement> published, List<Advertisement> likedAds, List<Report> reported, List<UserAccount> followers, List<Chat> chatsInitiated) {
        super(name, joinDate, email, phoneNumber, password);
        this.hasUnreadMessages = unReadMessages;
        this.hasUnopenedUpdates = hasUnopenedUpdates;
        this.loc = loc;
        this.published = published;
        this.likedAds = likedAds;
        reportedAds = reported;
        Followers = followers;
        ChatsInitiated = chatsInitiated;
    }
    
    public Advertisement postAdvertisement(Advertisement ad) {
    	return null;
    	//have to implement this.
    }
    
    public void likeAdvertisement(Advertisement ad) {
    	likedAds.add(ad);
    }
    
    public void reportAdvertisement(Report report) {
    	reportedAds.add(report);
    }
    
    public void deleteAdvertisement() {
    	//tobeimplemented.
    }
    
    public void sendMessage(UserAccount account, String message) {
    	//implemented
    }
    
    public void followUser(UserAccount user) {
    	Followers.add(user);
    }
    
    
}
