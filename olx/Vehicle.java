package com.company;

import java.util.Date;
import java.util.List;

public class Vehicle extends Advertisement {
    String make;
    int year;
    Condition condition;
    Date registeration;
    Fuel fuel;
    float KMdriven;

    public Vehicle( String tittle, int price, String description, Location loc, UserAccount creator, String make, int year, Condition condition, Date registeration, Fuel fuel, float KMdriven) {
        super(tittle, price, "Vehicle", description, loc, creator);
        this.make = make;
        this.year = year;
        this.condition = condition;
        this.registeration = registeration;
        this.fuel = fuel;
        this.KMdriven = KMdriven;
    }

    public Vehicle(int views, int shares, int likes, String tittle, int price, String description, Status status, Location loc, List<Report> rep, AdminAccount admin, UserAccount creator, String make, int year, Condition condition, Date registeration, Fuel fuel, float KMdriven) {
        super(views, shares, likes, tittle, price, "Vehicle", description, status, loc, rep, admin, creator);
        this.make = make;
        this.year = year;
        this.condition = condition;
        this.registeration = registeration;
        this.fuel = fuel;
        this.KMdriven = KMdriven;
    }

    public void viewAdvertisement(){
        super.viewAdvertisement();
        System.out.println("Make "+make);
        System.out.println("Condition "+condition);
        System.out.println("Registeration date "+registeration);
        System.out.println("Fuel "+fuel);
        System.out.println("Km Drivern "+KMdriven);

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
            if(filter.getName().equalsIgnoreCase("Fuel")) {
                satisfies = satisfies && filter.check(this.fuel.name());
            }
        }
        for(Filter<Integer> filter : builder.getIntFilters()) {
            if(filter.getName().equalsIgnoreCase("KMDriven")) {
                satisfies = satisfies && filter.check((int)this.KMdriven);
            }
            if(filter.getName().equalsIgnoreCase("Year")) {
                satisfies = satisfies && filter.check(year);
            }
        }
        return satisfies && super.satisfyQuery(builder);
    }
}
