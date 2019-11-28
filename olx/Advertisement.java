package olx;

import java.util.List;

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
    
    public String share() {
    	return "return url here";
    }
    
    public void viewAdvertisement() {
    	//PRINT ALL THE DETAILS HERE.
    }
    
    public void editAdvertisement() {
    	//PRINT DETAILS HERE. AS WELL AS ASK USER WHAT DOES HE WANT TO EDIT.
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
