package olx;

public class Electronics extends Advertisement {
    String Condition;
    String Make;

    public Electronics(int views, int shares, int likes, int tittle, int price, String type, String description, String status, Location loc, Report rep, SessionUser admin, String condition, String make) {
        super(views, shares, likes, tittle, price, type, description, status, loc, rep, admin);
        Condition = condition;
        Make = make;
    }
}
