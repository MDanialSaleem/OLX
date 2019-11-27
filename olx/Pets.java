package olx;

public class Pets extends Advertisement{
    String breed;

    public Pets(int views, int shares, int likes, int tittle, int price, String type, String description, String status, Location loc, Report rep, SessionUser admin, String breed) {
        super(views, shares, likes, tittle, price, type, description, status, loc, rep, admin);
        this.breed = breed;
    }
}
