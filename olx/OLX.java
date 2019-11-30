package olx;



import java.time.LocalDate;

import java.util.*;
import org.slf4j.*;


import org.beryx.textio.TextIO;
import org.beryx.textio.TextIoFactory;

public class OLX {
    TextIO textIO = TextIoFactory.getTextIO();

    private static OLX instance=null;
    private SessionState sessionState = null;
    private List<Advertisement> advertisements = new ArrayList<Advertisement>();
    private List<Location> locations = new ArrayList<>();
    @SuppressWarnings("unused")
	private List<Account> accounts = new ArrayList<>();
    @SuppressWarnings("unused")
    private Account activeAccount = null;
    
    private OLX(){};
    public static OLX getInstance(){
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
        String name = textIO.newStringInputReader().withMinLength(1).read("Username");

        String password = textIO.newStringInputReader().withMinLength(8).withInputMasking(true).read("Password");

        String email = textIO.newStringInputReader().withMinLength(8).read("Email");

        LocalDate now = LocalDate.now();

        String phone = textIO.newStringInputReader().withMinLength(11).read("Phone Number");

        //Account a=new UserAccount(name,now,email,phone,password);
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
