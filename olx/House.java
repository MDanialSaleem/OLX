package olx;

import java.util.List;

public class House extends Property {
    int NoOfBedrooms;
    int NoOfBathrooms;

    public House(int views, int shares, int likes, String tittle, int price, String type, String description, Status status, Location loc, List<Report> rep, AdminAccount admin, UserAccount creator, int areaUnits, PropertyType propertyType, int noOfBedrooms, int noOfBathrooms) {
        super(views, shares, likes, tittle, price, type, description, status, loc, rep, admin,creator, areaUnits, propertyType);
        NoOfBedrooms = noOfBedrooms;
        NoOfBathrooms = noOfBathrooms;
    }

    @Override
    public void viewAdvertisement(){
        super.viewAdvertisement();
        System.out.println("Bedrooms "+NoOfBedrooms);
        System.out.println("Bathrooms "+NoOfBathrooms);

    }
}
