package olx;

import java.util.List;

public class Pets extends Advertisement{
    String breed;

    public Pets(int views, int shares, int likes, int tittle, int price, String type, String description, String status, Location loc, List<Report> rep, AdminAccount admin, UserAccount creator, String breed) {
        super(views, shares, likes, tittle, price, type, description, status, loc, rep, admin, creator);
        this.breed = breed;
    }

    public void viewAdvertisement(){
        super.viewAdvertisement();
        System.out.println("Breed "+breed);
    }
}
