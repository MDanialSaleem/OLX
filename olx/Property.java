package olx;

public class Property extends Advertisement{
    int AreaUnits;
    String PropertyType;

    public Property(int views, int shares, int likes, int tittle, int price, String type, String description, String status, Location loc, Report rep, SessionUser admin, int areaUnits, String propertyType) {
        super(views, shares, likes, tittle, price, type, description, status, loc, rep, admin);
        AreaUnits = areaUnits;
        PropertyType = propertyType;
    }
}
