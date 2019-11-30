package olx;

import java.util.List;

public class Property extends Advertisement{
    int AreaUnits;
    PropertyType propertyType;

    public Property(int views, int shares, int likes, String tittle, int price, String type, String description, Status status, Location loc, List<Report> rep, AdminAccount admin, UserAccount creator,  int areaUnits, PropertyType propertyType) {
        super(views, shares, likes, tittle, price, type, description, status, loc, rep, admin, creator);
        AreaUnits = areaUnits;
        this.propertyType = propertyType;
    }

    public void viewAdvertisement(){
        super.viewAdvertisement();
        System.out.println("AreaUnits "+AreaUnits);
        System.out.println("Property "+propertyType);
    }
}
