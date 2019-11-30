package olx;

import java.util.List;

public class Mobile extends Advertisement {
    String make;
    Condition condition;

    public Mobile(int views, int shares, int likes, String tittle, int price, String type, String description, Status status, Location loc, List<Report> rep, AdminAccount admin, UserAccount creator, String make, Condition condition) {
        super(views, shares, likes, tittle, price, type, description, status, loc, rep, admin, creator);
        this.make = make;
        this.condition = condition;
    }

    public void viewAdvertisement(){
        super.viewAdvertisement();
        System.out.println("Make "+make);
        System.out.println("Condition "+condition);
    }
}
