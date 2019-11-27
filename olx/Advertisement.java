package olx;

public class Advertisement {
    int views;
    int shares;
    int likes;
    int tittle;
    int price;
    String type;
    String description;
    String status;
    Location loc;
    Report rep;
    SessionUser Admin;

    public Advertisement(int views, int shares, int likes, int tittle, int price, String type, String description, String status, Location loc, Report rep, SessionUser admin) {
        this.views = views;
        this.shares = shares;
        this.likes = likes;
        this.tittle = tittle;
        this.price = price;
        this.type = type;
        this.description = description;
        this.status = status;
        this.loc = loc;
        this.rep = rep;
        Admin = admin;
    }
}
