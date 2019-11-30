package olx;

import java.util.List;

public class Mobile extends Advertisement {
    String make;
    String condition;

    public Mobile(int views, int shares, int likes, int tittle, int price, String type, String description, String status, Location loc, List<Report> rep, AdminAccount admin, UserAccount creator, String make, String condition) {
        super(views, shares, likes, tittle, price, type, description, status, loc, rep, admin, creator);
        this.make = make;
        this.condition = condition;
    }
}
