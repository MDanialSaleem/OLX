package olx;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.time.LocalDate;

import org.slf4j.*;


import org.beryx.textio.TextIO;
import org.beryx.textio.TextIoFactory;

public class UserAccount extends Account {

    TextIO textIO = TextIoFactory.getTextIO();

    Boolean hasUnreadMessages;
    Boolean hasUnopenedUpdates;
    Location loc;
    List<Advertisement> published;
    List<Advertisement> likedAds;
    List<Report> reportedAds;
    List<UserAccount> Followers;
    List<Chat> ChatsInitiated;

    public UserAccount(String name, LocalDate joinDate, String email, String phoneNumber, String password, OLX app,  Location loc) {
        super(name, joinDate, email, phoneNumber, password);
        this.hasUnreadMessages = false;
        this.hasUnopenedUpdates = false;
        this.loc = loc;
        this.published = new ArrayList<Advertisement>();
        this.likedAds = new ArrayList<Advertisement>();
        reportedAds = new ArrayList<Report>();
        Followers = new ArrayList<UserAccount>();
        ChatsInitiated = new ArrayList<Chat>();
    }

    public UserAccount(String name, LocalDate joinDate, String email, String phoneNumber, String password, OLX app, boolean unReadMessages, boolean hasUnopenedUpdates, Location loc, List<Advertisement> published, List<Advertisement> likedAds, List<Report> reported, List<UserAccount> followers, List<Chat> chatsInitiated) {
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

    public void createAdvertisement(){

        String title = textIO.newStringInputReader().withMinLength(1).read("Title");
        int price = textIO.newIntInputReader().read("Price");
        String type = textIO.newStringInputReader().withMinLength(1).read("Type");
        String description = textIO.newStringInputReader().withMinLength(1).read("Description");

        Advertisement ad= new Advertisement(title, price,type,description, this.loc, this) ;

    }

}
