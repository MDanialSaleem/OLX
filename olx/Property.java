package olx;

import java.util.List;

public class Property extends Advertisement{
    int AreaUnits;
    String PropertyType;

    public Property(int views, int shares, int likes, int tittle, int price, String type, String description, String status, Location loc, List<Report> rep, AdminAccount admin, UserAccount creator,  int areaUnits, String propertyType) {
        super(views, shares, likes, tittle, price, type, description, status, loc, rep, admin, creator);
        AreaUnits = areaUnits;
        PropertyType = propertyType;
    }

    public void viewAdvertisement(){
        super.viewAdvertisement();
        System.out.println("AreaUnits "+AreaUnits);
        System.out.println("Property "+PropertyType);
    }
}
