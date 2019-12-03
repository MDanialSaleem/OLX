package olx;
import java.time.LocalDate;
import java.util.*;

import org.slf4j.*;
import org.beryx.textio.TextIO;
import org.beryx.textio.TextIoFactory;


public class Main {
	private static TextIO textIO = TextIoFactory.getTextIO();

    public static void main(String[] args) {
    	OLX application=OLX.getInstance();
    	application.setAdministrator(new AdminAccount("Hadi",LocalDate.now(),"hadi@gmail.com","123456","123"));
    	OLX.terminal.println("Welcome to OLX.com");
    	displayMenu();
	}
    
    public static void displayMenu() {
    	UserAccount loggedInUser = OLX.getInstance().getCurrentUserAccount();
    	AdminAccount loggedInAdmin = OLX.getInstance().getCurrentAdminAccount();
    	
    	if(loggedInUser == null && loggedInAdmin == null) {
    		OLX.terminal.println("Press 1 to register as User.");
    		OLX.terminal.println("Press 2 to Login as User.");
    		OLX.terminal.println("Press 3 to Login as Admin.");
    		OLX.terminal.println("Press 4 to search advertisements");
    		int userInput = textIO.newIntInputReader()
    				.withMinVal(1)
    				.withMaxVal(4)
    				.read("Input");
    		
    		switch(userInput) {
    		case 1:
    			OLX.getInstance().registerUser();
    			break;
    		case 2:
				boolean ret=OLX.getInstance().logInUser();
				if(ret==false)
				{
					OLX.terminal.println("Wrong Credentials");
				}
				else 
				{
					OLX.terminal.println("User Successfully Logged in");
				}
				break;
    		case 3:
				boolean ret2=OLX.getInstance().logInAdmin();
				if(ret2 == false)
				{
					OLX.terminal.println("Wrong Credentials");
				}
				else
				{
					OLX.terminal.println("User Successfully Logged in");
				}
				break;
    		case 4:
    			
    			break;
    		}
    	}
    	else if(loggedInUser != null){
    		OLX.terminal.println("Press 1 to publish as Ad.");
    		OLX.terminal.println("Press 2 to see your published Ads");
    		OLX.terminal.println("Press 3 to search");
    		OLX.terminal.println("Press 4 to Log out.");
    		
    		int userInput = textIO.newIntInputReader()
    				.withMinVal(1)
    				.withMaxVal(4)
    				.read("Input");
    		
    		switch(userInput) {
    		case 1:
    			break;
    		case 2:
    			OLX.getInstance().getCurrentUserAccount().printPublishedAds();
    			break;
    		case 3:
    			//implement search here.
    			break;
    		case 4:
    			OLX.getInstance().logOutUser();
    			break;
 
    		}
    		
    	}
    	else if(loggedInAdmin != null){
    		OLX.terminal.println("Press 1 to view ads for approval");
    		OLX.terminal.println("Press 2 to view reports");
    		OLX.terminal.println("Press 3 to Log out.");
    		int userInput = textIO.newIntInputReader()
    				.withMinVal(1)
    				.withMaxVal(4)
    				.read("Input");
    		
    		switch(userInput) {
    		case 1:
    			loggedInAdmin.viewAdsForApproval();
    			break;
    		case 2:
    			loggedInAdmin.viewReports();
    			break;
    		case 3:
    			OLX.getInstance().logOutUser();
    		}
    	}
    	
    	displayMenu();
    }
    
}