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
					OLX.terminal.println("Admin Successfully Logged in");
				}
				break;
    		case 4:
    			Search();
    			break;
    		}
    	}
    	else if(loggedInUser != null){
    		OLX.terminal.println("Press 1 to publish Ad.");
    		OLX.terminal.println("Press 2 to see your published Ads");
    		OLX.terminal.println("Press 3 to search");
    		OLX.terminal.println("Press 4 to see follower ads");
    		OLX.terminal.println("Press 5 to Log out.");
    		
    		int userInput = textIO.newIntInputReader()
    				.withMinVal(1)
    				.withMaxVal(5)
    				.read("Input");
    		
    		switch(userInput) {
    		case 1:
    			OLX.getInstance().getCurrentUserAccount().createAdvertisement();
    			break;
    		case 2:
    			OLX.getInstance().getCurrentUserAccount().printPublishedAds();
    			break;
    		case 3:
    			Search();
    			break;
    		case 4:
    			OLX.getInstance().getCurrentUserAccount().viewFollowerAds();
    			break;
    		case 5:
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
    				.withMaxVal(3)
    				.read("Input");
    		
    		switch(userInput) {
    		case 1:
    			loggedInAdmin.viewAdsForApproval();
    			break;
    		case 2:
    			loggedInAdmin.viewReportsForApproval();
    			break;
    		case 3:
    			OLX.getInstance().logOutUser();
    		}
    	}
    	
    	displayMenu();
    }
	
	public static void Search() {
		OLX.terminal.println("Welcome to search");
		String category = textIO.newEnumInputReader(Categories.class).read("Please choose the category").name();
		String searchKeyWord = textIO.newStringInputReader().read("Search keyword: ");
		
		try {
			List<Advertisement> adsReturned = OLX.DBCON.Search(searchKeyWord, category);
				//QUERY DB TO GET RESULTS HERE.
				QueryBuilder builder = new QueryBuilder(adsReturned);
				OLX.terminal.println("Now enter filters. If you do not want to specify a filter, leave it empty");
				int priceUpBound = textIO.newIntInputReader()
						.withDefaultValue(Integer.MAX_VALUE)
						.read("Price upper bound");
				int priceLowerBound = textIO.newIntInputReader()
						.withMaxVal(Integer.MAX_VALUE - 1)
						.withDefaultValue(0)
						.read("Price Lower Bound");
				
				if(priceUpBound != Integer.MAX_VALUE && priceLowerBound != 0) {
					builder.addIntFilter(new RangeFilter<Integer>("Price", priceLowerBound, priceUpBound));
				}
				
				AdvertisementViewer viewer = new AdvertisementViewer(builder.getResults());
				viewer.display();

		}
		catch(Exception e) {
			System.out.println(e);
		}

		
		

	}
		
		
	public static void main2(String[] args) {
		OLX.DBCON.addFollower("dan@gmail.com", "hadi@gmail.com");
	}
    
}