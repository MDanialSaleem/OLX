package olx;

import java.util.*;

public class OLX {
    private OLX instance=null;
    private SessionState sessionState = null;
    private List<Advertisement> advertisements = new ArrayList<Advertisement>();
    private List<Location> locations = new ArrayList<>();
    private List<Account> accounts = new ArrayList<>();
    private Account activeAccount = null;
    
    private OLX(){};
    public OLX getInstance(){
        if(instance==null)
            instance=new OLX();
        return instance;
    }
    public void setState(SessionState s)
    {
        sessionState=s;
    }
    
    
    public void addLocation(Location loc) {
    	locations.add(loc);
    }
    
    public List<Advertisement> search(String keyword) {
    	throw new IllegalStateException();
    }
    
    public void addAdvertisement(Advertisement ad) {
    	advertisements.add(ad);
    }
    
    public void registerUser() {
    	throw new IllegalStateException();
    }
    
    public boolean logInUser() {
    	return sessionState.logInUser();
    }
    public void logOutUser() {
    	sessionState.logOut();
    }
    
    public UserAccount getCurrentUserAccount() {
    	return sessionState.getCurrentUserAccount();
    }
    public AdminAccount getCurrentAdminAccount() {
    	return sessionState.getCurrentAdminAccount();
    }
    
    public boolean logInAdmin() {
    	return sessionState.loginAdmin();
    }
    
    public void setActiveAccount(Account account) {
    	activeAccount = account;
    }
    
    public void deleteAd(Advertisement ad) {
    	advertisements.remove(ad);
    }
    
    public SessionUser getAdminForApproval() {
    	return null; //BIG BIG ISSUES HERE.
    }
    
    
}
