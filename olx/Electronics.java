package olx;

import java.util.List;

public class Electronics extends Advertisement {
    String Condition;
    String Make;

    public Electronics(int views, int shares, int likes, int tittle, int price, String type, String description, String status, Location loc, List<Report> rep, AdminAccount admin, UserAccount creator, String condition, String make) {
    	super(views, shares, likes, tittle, price, type, description, status, loc, rep, admin, creator);
        Condition = condition;
        Make = make;
    }
}
