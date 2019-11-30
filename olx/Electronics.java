package olx;

import java.util.List;

public class Electronics extends Advertisement {
    Condition condition;
    String Make;

    public Electronics(int views, int shares, int likes, String tittle, int price, String type, String description, Status status, Location loc, List<Report> rep, AdminAccount admin, UserAccount creator, Condition condition, String make) {
    	super(views, shares, likes, tittle, price, type, description, status, loc, rep, admin, creator);
        this.condition = condition;
        Make = make;
    }
}
