package olx;

import java.time.LocalDate;

import java.util.*;
import org.slf4j.*;


import org.beryx.textio.TextIO;
import org.beryx.textio.TextIoFactory;
import org.beryx.textio.TextTerminal;

public class OLX {
    private static TextIO textIO = TextIoFactory.getTextIO();
    public static TextTerminal terminal = textIO.getTextTerminal();
    
    private static OLX instance=null;
    private SessionState sessionState = new SessionInactive();
    private List<Advertisement> advertisements = new ArrayList<Advertisement>();
    private List<Location> locations = new ArrayList<>();
    private AdminAccount administrator;
    private List<Account> accounts = new ArrayList<>();
    public List<Advertisement> getAdvertisements() {
        return advertisements;
    }
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

    public void setAdministrator(AdminAccount administrator) {
        this.administrator = administrator;
    }

    public void addLocation(Location loc) {
        locations.add(loc);
    }

    public List<Account> getAccounts() {
        return accounts;
    }

    public List<Advertisement> search(String keyword) {
        throw new IllegalStateException();
    }

    public void addAdvertisement(Advertisement ad) {
        advertisements.add(ad);
    }
    public void addAccount(Account acc) {
        accounts.add(acc);
    }

    public AdminAccount getAdministrator() {
        return administrator;
    }

    public void viewAdvertisements(){
        for(int i=0;i<advertisements.size();i++){
            advertisements.get(i).viewAdvertisement();
        }
    }

    public boolean registerUser() {
            OLX.terminal.println("----------------------Register Now-----------------");
            OLX.terminal.println("Enter your Name.");
            String name=userInputText();
            OLX.terminal.println("Enter your email.");
            String email=userInputText();
            OLX.terminal.println("Enter your phone number.");
            String phone=userInputText();
            OLX.terminal.println("Enter your password.");
            String Password=userInputText();
            OLX.terminal.println("Enter your block.");
            String block=userInputText();
            OLX.terminal.println("Enter your Society.");
            String Society=userInputText();
            OLX.terminal.println("Enter your city.");
            String city=userInputText();
            OLX.terminal.println("Enter your state.");
            String state=userInputText();
            Location loc=new Location(block,Society,city,state);
            this.addLocation(loc);
            this.addAccount(new UserAccount(name, LocalDate.now(),email,phone,Password,this,loc));
            return sessionState.logInUser();
    }

    public boolean logInUser() { return sessionState.logInUser();
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
    public Account getActiveAccount() {
    	return activeAccount;
    }

    public void deleteAd(Advertisement ad) {
        advertisements.remove(ad);
    }

    public AdminAccount getAdminForApproval() {
    	return this.getAdministrator();  //duplicate functions. Marked for remova in next update.
    }

    static int userInputInt(){
        Scanner input=new Scanner(System.in);
        return input.nextInt();
    }

    static String userInputText(){
        Scanner input=new Scanner(System.in);
        return input.next();
    }

    static Condition userInputCondition(){
        OLX.terminal.println("Enter 1 for New or 2 for used");
        Scanner input=new Scanner(System.in);
        int i=input.nextInt();
        if(i==1){return Condition.NEW;};
        return Condition.USED;
    }


}
