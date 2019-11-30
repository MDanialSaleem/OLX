package olx;

import java.util.List;

public class Mobile extends Advertisement {
    String make;
    Condition condition;

    public Mobile( String tittle, int price, String description, Location loc, UserAccount creator, String make, Condition condition) {
        super(tittle, price,"Mobile", description, loc,creator);
        this.make = make;
        this.condition = condition;
    }
    public Mobile(int views, int shares, int likes, String tittle, int price, String description, Status status, Location loc, List<Report> rep, AdminAccount admin, UserAccount creator, String make, Condition condition) {
        super(views, shares, likes, tittle, price,"Mobile", description, status, loc, rep, admin, creator);
        this.make = make;
        this.condition = condition;
    }

    public void viewAdvertisement(){
        super.viewAdvertisement();
        System.out.println("Make "+make);
        System.out.println("Condition "+condition);
    }

    @Override
    public boolean satisfyQuery(QueryBuilder builder) {

        boolean satisfies = true;
        for(Filter<String> filter : builder.getStringFilters()) {
            if(filter.getName().equalsIgnoreCase("Condition")) {
                satisfies = satisfies && filter.check(this.condition.name());
            }
            if(filter.getName().equalsIgnoreCase("Make")) {
                satisfies = satisfies && filter.check(this.make);
            }
        }
        return satisfies && super.satisfyQuery(builder);
    }
}
