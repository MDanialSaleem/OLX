package olx;

import java.util.*;

public class Advertisement {
    int views;
    int shares;
    int likes;
    int tittle;
    int price;
    String type;
    String description;
    String status;
    Location loc;
    List<Report> reports;
    AdminAccount admin;
    UserAccount creator;

    public Advertisement(int views, int shares, int likes, int tittle, int price, String type, String description, String status, Location loc, List<Report> reports, AdminAccount admin, UserAccount creator) {
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

    public void setTittle(int tittle) {
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
        System.out.println("Press 4 in order to edit type");
        //taking user input
    	Scanner input=new Scanner(System.in);
    	int inserted=input.nextInt();
    	switch (inserted){
            case 1 :
                System.out.println("Enter title");
                String s = input.next();
                this.setTittle(s);
                break;
            case 2 :
                System.out.println("Enter price");
                int s = input.nextInt();
                this.setPrice(s);
                break;
            case 3 :
                System.out.println("Enter description");
                String s = input.next();
                this.setDescription(s);
                break;
            case 4 :
                System.out.println("Enter type");
                String s = input.next();
                this.setType(s);
                break;
        }


    }
    
    public void approveDisapprove(boolean decision) {
    	status = "Approved";
    }
    public void likeAdvertisement() {
    	likes++;
    }
    
    public UserAccount viewSeller() {
    	return creator;
    }
    
    public boolean satisfyQuery(QueryBuilder builder) {
    	//TOBEIMPLEMNTED
    	return true;
    }
    
    
    
}
