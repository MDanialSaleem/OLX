package olx;

public class Mobile extends Advertisement {
    String make;
    String condition;

    public Mobile(int views, int shares, int likes, int tittle, int price, String type, String description, String status, Location loc, Report rep, SessionUser admin, String make, String condition) {
        super(views, shares, likes, tittle, price, type, description, status, loc, rep, admin);
        this.make = make;
        this.condition = condition;
    }

    public void viewAdvertisement(){
        super.viewAdvertisement();
        System.out.println("Make "+make);
        System.out.println("Condition "+condition);
    }
}
