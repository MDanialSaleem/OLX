package olx;

import java.util.List;

public class Pets extends Advertisement{
    String breed;

    public Pets(int views, int shares, int likes, String tittle, int price, String type, String description, Status status, Location loc, List<Report> rep, AdminAccount admin, UserAccount creator, String breed) {
        super(views, shares, likes, tittle, price, type, description, status, loc, rep, admin, creator);
        this.breed = breed;
    }

    public void viewAdvertisement(){
        super.viewAdvertisement();
        System.out.println("Breed "+breed);
    }
    
    @Override
    public boolean satisfyQuery(QueryBuilder builder) {
    	
    	boolean satisfies = true;
    	for(Filter<String> filter : builder.getStringFilters()) {
    		if(filter.getName().equalsIgnoreCase("breed")) {
    			satisfies = satisfies && filter.check(breed);
    		}
    	}
    	return satisfies && super.satisfyQuery(builder);
    }
}
