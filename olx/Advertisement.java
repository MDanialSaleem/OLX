package olx;

import java.util.*;

import org.slf4j.*;


import org.beryx.textio.TextIO;
import org.beryx.textio.TextIoFactory;


public class Advertisement {
    int views;
    int shares;
    int likes;
    String tittle;
    int price;
    String type;
    String description;
    Status status;
    Location loc;
    List<Report> reports;
    AdminAccount admin;
    UserAccount creator;

    TextIO textIO = TextIoFactory.getTextIO();

    public Advertisement( String tittle, int price, String type, String description, Location loc, UserAccount creator) {

        this.tittle = tittle;
        this.price = price;
        this.type = type;
        this.description = description;
        this.status =Status.NOT_APPROVED;
        this.loc = loc;
        this.creator = creator;
        reports= new ArrayList<Report>();
    }

    public Advertisement(int views, int shares, int likes, String tittle, int price, String type, String description, Status status, Location loc, List<Report> reports, AdminAccount admin, UserAccount creator) {
        this.views = views;
        this.shares = shares;
        this.likes = likes;
        this.tittle = tittle;
        this.price = price;
        this.type = type;
        this.description = description;
        this.status = status;
        this.loc = loc;
        this.admin = admin;
        this.creator = creator;
        this.reports = reports;
    }

    public void setTittle(String tittle) {
        this.tittle = tittle;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String share() {
        return "return url here";
    }

    public void viewAdvertisement() {
        System.out.println("Title "+tittle);
        System.out.println("Price "+price);
        System.out.println("Type "+type);
        System.out.println("Description "+description);
        System.out.println("Views "+views);
        System.out.println("Likes "+likes);
    }


    public void editAdvertisement() {
        this.viewAdvertisement();
        //menu for the user
        System.out.println("Press 1 in order to edit title");
        System.out.println("Press 2 in order to edit price");
        System.out.println("Press 3 in order to edit description");
        System.out.println("Press 0 in order to exit");

        //taking user input




        int inserted=textIO.newIntInputReader().withMinVal(0).withMaxVal(3).read("Enter Your Option");
        switch (inserted){
            case 1 :
                String t = textIO.newStringInputReader().withMinLength(1).read("Title");
                this.setTittle(t);
                break;
            case 2 :
                int p= textIO.newIntInputReader().read("Price");
                this.setPrice(p);
                break;
            case 3 :
                String descr = textIO.newStringInputReader().withMinLength(1).read("Description");
                this.setDescription(descr);
                break;

            case 0:
                break;
        }


    }

    public void approveDisapprove(boolean decision) {
        status = Status.APPROVED;
    }
    public void likeAdvertisement() {
        likes++;
    }

    public UserAccount viewSeller() {
        return creator;
    }

    public boolean satisfyQuery(QueryBuilder builder) {
        for(Filter<Integer> filter : builder.getIntFilters()) {
            if(filter.getName().equalsIgnoreCase("Price")) {
                return filter.check(price);
            }
        }
        //in case there is no fitler of importance.
        return true;
    }



}