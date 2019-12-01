package olx;

import java.util.List;

public class Jobs extends Advertisement {
    int noOfPositions;
    String companyName;
    String Description;

    public Jobs(String tittle, int price,  String description,Location loc, UserAccount creator, int noOfPositions, String companyName, String description1) {
        super( tittle, price, "Job", description,  loc, creator);
        this.noOfPositions = noOfPositions;
        this.companyName = companyName;
        Description = description1;
    }
    public Jobs(int views, int shares, int likes, String tittle, int price,  String description, Status status, Location loc, List<Report> rep, AdminAccount admin, UserAccount creator, int noOfPositions, String companyName, String description1) {
        super(views, shares, likes, tittle, price, "Job", description, status, loc, rep, admin, creator);
        this.noOfPositions = noOfPositions;
        this.companyName = companyName;
        Description = description1;
    }

    public void viewAdvertisement(){
        super.viewAdvertisement();
        System.out.println("Number of Positions "+noOfPositions);
        System.out.println("Company Name "+companyName);
    }
}
