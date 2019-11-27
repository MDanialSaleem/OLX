package olx;

public class House extends Property {
    int NoOfBedrooms;
    int NoOfBathrooms;

    public House(int views, int shares, int likes, int tittle, int price, String type, String description, String status, Location loc, Report rep, SessionUser admin, int areaUnits, String propertyType, int noOfBedrooms, int noOfBathrooms) {
        super(views, shares, likes, tittle, price, type, description, status, loc, rep, admin, areaUnits, propertyType);
        NoOfBedrooms = noOfBedrooms;
        NoOfBathrooms = noOfBathrooms;
    }
}
