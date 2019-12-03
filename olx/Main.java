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
    	System.out.println("Welcome to OLX.com");
    	displayMenu();
	}
    
    public static void displayMenu() {
    	UserAccount loggedInUser = OLX.getInstance().getCurrentUserAccount();
    	AdminAccount loggedInAdmin = OLX.getInstance().getCurrentAdminAccount();
    	
    	if(loggedInUser == null && loggedInAdmin == null) {
    		System.out.println("Press 1 to register as User.");
    		System.out.println("Press 2 to Login as User.");
    		System.out.println("Press 3 to Login as Admin.");
    		System.out.println("Press 4 to search advertisements");
    		
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
					System.out.println("Wrong Credentials");
				}
				else 
				{
					System.out.println("User Successfully Logged in");
				}
				break;
    		case 3:
				boolean ret2=OLX.getInstance().logInAdmin();
				if(ret2 == false)
				{
					System.out.println("Wrong Credentials");
				}
				else
				{
					System.out.println("User Successfully Logged in");
				}
				break;
    		case 4:
    			//handle search here.
    			break;
    		}
    	}
    	else if(loggedInUser != null){
    		System.out.println("Press 1 to publish as Ad.");
    		System.out.println("Press 2 to see your published Ads");
    		System.out.println("Press 3 to search");
    		System.out.println("Press 4 to Login as Log out.");
    		
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
    		case 4:
    			OLX.getInstance().logOutUser();
 
    		}
    		
    	}
    	else if(loggedInAdmin != null){
    		//implement admin functionality here.
    	}
    	
    	displayMenu();
    }
    
}