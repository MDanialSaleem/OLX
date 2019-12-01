package com.company;

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

    public UserAccount(String name, LocalDate joinDate, String email, String phoneNumber, String password, OLX app, Location loc) {
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
        Chat exists = null;
        for (Chat chat : ChatsInitiated) {
            for (int i = 0; i < chat.getParticipants().length; i++) {
                if (account.equals(chat.getParticipants()[i])) {
                    exists = chat;
                }
            }
            if (exists != null) {
                break;
            }
        }

        if (exists == null) {
            exists = new Chat(this, account);
        }
        exists.addMessage(message, this);
    }

    public void followUser(UserAccount user) {
        user.addFollower(this);
    }

    public void addFollower(UserAccount user) {
        Followers.add(user);
    }

    public void notifyUserOfMessage() {
        this.hasUnreadMessages = true;
    }


    public void notiftyUserOfFollowerUpdate() {
        this.hasUnopenedUpdates = true;
    }

    public void notifyFollowers() {
        for (UserAccount follower : Followers) {
            follower.notiftyUserOfFollowerUpdate();
        }
    }

    public void viewChats() {
        this.hasUnreadMessages = false;
        //implement view here.
    }

    public void viewFollowerAds() {
        this.hasUnopenedUpdates = false;
        //implement view here.
    }

    public void createAdvertisement() {

        String title = textIO.newStringInputReader().withMinLength(1).read("Title");
        int price = textIO.newIntInputReader().read("Price");

        String description = textIO.newStringInputReader().withMinLength(1).read("Description");

        System.out.println("Press 1 for Electronics");
        System.out.println("Press 2 for House");
        System.out.println("Press 3 for Jobs");
        System.out.println("Press 4 for Mobile");
        System.out.println("Press 5 for Pets");
        System.out.println("Press 6 for Property");
        System.out.println("Press 7 for Vehicle");


        //taking user input


        int inserted = textIO.newIntInputReader().withMinVal(1).withMaxVal(7).read("Enter Your Option");
        switch (inserted) {
            case 1:
                Electronics e;
                String make = textIO.newStringInputReader().withMinLength(1).read("Make");
                String cond = textIO.newStringInputReader().withMinLength(1).read("Condition");
                if (cond.equalsIgnoreCase("new"))
                    e = new Electronics(title, price, description, this.loc, this, Condition.NEW, make);
                else if (cond.equalsIgnoreCase("used"))
                    e = new Electronics(title, price, description, this.loc, this, Condition.USED, make);

                break;
            case 2:
                int b = textIO.newIntInputReader().read("No of Bedrooms");
                int b1 = textIO.newIntInputReader().read("No of Bathrooms");
                int a = textIO.newIntInputReader().read("Area Units");
                String Prop = textIO.newStringInputReader().withMinLength(1).read("Property Type");
                House h;
                if (Prop.equalsIgnoreCase("rent"))
                    h = new House(title, price, description, this.loc, this, a, PropertyType.RENT, b, b1);
                else if (Prop.equalsIgnoreCase("sale"))
                    h = new House(title, price, description, this.loc, this, a, PropertyType.SALE, b, b1);
                break;
            case 3:
                Jobs j;
                int n = textIO.newIntInputReader().read("No of Positions");
                String cn = textIO.newStringInputReader().withMinLength(1).read("Company Name");
                String d = textIO.newStringInputReader().withMinLength(1).read("Description");
                j = new Jobs(title, price, description, this.loc, this, n, cn, d);
                break;

            case 4:
                Mobile m;
                String make1 = textIO.newStringInputReader().withMinLength(1).read("Make");
                String cond1 = textIO.newStringInputReader().withMinLength(1).read("Condition");
                if (cond1.equalsIgnoreCase("new"))
                    m = new Mobile(title, price, description, this.loc, this, make1, Condition.NEW);
                else if (cond1.equalsIgnoreCase("used"))
                    m = new Mobile(title, price, description, this.loc, this, make1, Condition.USED);
                break;

            case 5:
                Pets p;
                String breed = textIO.newStringInputReader().withMinLength(1).read("Breed");
                p = new Pets(title, price, description, this.loc, this, breed);
                break;
            case 6:
                Property pr;
                int a1 = textIO.newIntInputReader().read("Area Units");
                String Prop1 = textIO.newStringInputReader().withMinLength(1).read("Property Type");
                if (Prop1.equalsIgnoreCase("rent"))
                    pr = new Property(title, price, description, this.loc, this, a1, PropertyType.RENT);
                else if (Prop1.equalsIgnoreCase("sale"))
                    pr = new Property(title, price, description, this.loc, this, a1, PropertyType.SALE);
                break;
            case 7:
                Vehicle v;

                String make2 = textIO.newStringInputReader().withMinLength(1).read("Make");
                String cond2 = textIO.newStringInputReader().withMinLength(1).read("Condition");
                int y = textIO.newIntInputReader().read("Year");
                String f = textIO.newStringInputReader().read("Fuel");
                Fuel f1;
                if (f.equalsIgnoreCase("Petrol"))
                    f1 = Fuel.PETROL;
                else if (f.equalsIgnoreCase("Gas"))
                    f1 = Fuel.GAS;
                else
                    f1 = Fuel.DIESEL;
                float km = textIO.newFloatInputReader().read("KiloMeter Driven");

                Date d1 = new Date(12 - 13 - 2010);

                if (cond2.equalsIgnoreCase("new"))
                    v = new Vehicle(title, price, description, this.loc, this, make2, y, Condition.NEW, d1, f1, km);
                else if (cond2.equalsIgnoreCase("used"))
                    v = new Vehicle(title, price, description, this.loc, this, make2, y, Condition.USED, d1, f1, km);
                break;

        }

    }
}