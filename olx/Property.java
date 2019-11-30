package olx;

import java.util.List;

public class Property extends Advertisement{
    int AreaUnits;
    PropertyType propertyType;

    public Property( String tittle, int price, String description, Location loc, UserAccount creator,  int areaUnits, PropertyType propertyType) {
        super(tittle, price, "Property", description,  loc,  creator);
        AreaUnits = areaUnits;
        this.propertyType = propertyType;
    }

    public Property(int views, int shares, int likes, String tittle, int price, String description, Status status, Location loc, List<Report> rep, AdminAccount admin, UserAccount creator,  int areaUnits, PropertyType propertyType) {
        super(views, shares, likes, tittle, price, "Property", description, status, loc, rep, admin, creator);
        AreaUnits = areaUnits;
        this.propertyType = propertyType;
    }

    public void viewAdvertisement(){
        super.viewAdvertisement();
        System.out.println("AreaUnits "+AreaUnits);
        System.out.println("Property "+propertyType);
    }
    @Override
    public boolean satisfyQuery(QueryBuilder builder) {

        boolean satisfies = true;
        for(Filter<String> filter : builder.getStringFilters()) {
            if(filter.getName().equalsIgnoreCase("PropertyType")) {
                satisfies = satisfies && filter.check(this.propertyType.name());
            }
        }
        return satisfies && super.satisfyQuery(builder);
    }

}
