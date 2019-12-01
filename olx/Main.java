package olx;
import java.time.LocalDate;
import java.util.*;

public class Main {

    public static void main(String[] args) {
    	OLX application=OLX.getInstance();
    	application.setAdministrator(new AdminAccount("Hadi",LocalDate.now(),"hadi@gmail.com","123456","123"));
    	welcomeMessage();
		int temp=4;
		while(true){
			if(temp==4){
				StartupLogin();
				temp=userInputInt();
				userCall(temp);
			}
			else if(temp==1 || temp==2)
			{
				LoggedMenu();
				temp=userInputInt();
				userLoggedcall(temp);
			}
		}

	}






    static boolean userCall(int i){
			if(i==1)
			{OLX.getInstance().registerUser();return true;}
			else if(i==2){
				boolean ret=OLX.getInstance().logInUser();
				if(ret==false)
					System.out.println("Wrong Credentials");
				System.out.println("User Successfully Logged in");
				return true;
			}
			else if(i==3){
				boolean ret=OLX.getInstance().logInAdmin();
				if(ret==false)
					System.out.println("Wrong Credentials");
				System.out.println("User Successfully Logged in");
				return true;
			}
			else
			{
				OLX.getInstance().viewAdvertisements();
			}
			return false;
    }

	static boolean userLoggedcall(int i){
		if(i==1)
		{OLX.getInstance().getCurrentUserAccount().createAdvertisement();}
		else if(i==4){
			OLX.getInstance().logOutUser();
			return true;
		}
		else if(i==2)
		{
			OLX.getInstance().getCurrentUserAccount().printPublishedAds();
			int t=userInputInt();
			OLX.getInstance().getCurrentUserAccount().published.get(t).editAdvertisement();
		}
		else
		{
			OLX.getInstance().viewAdvertisements();
		}
		return false;
	}

     static void welcomeMessage(){
    	System.out.println("Welcome to OLX.com");
	 }

	static int userInputInt(){
		Scanner input=new Scanner(System.in);
		return input.nextInt();
	}

	static String userInputText(){
		Scanner input=new Scanner(System.in);
		return input.next();
	}

	static void StartupLogin(){
		System.out.println("Press 1 to register as User.");
		System.out.println("Press 2 to Login as User.");
		System.out.println("Press 3 to Login as Admin.");
		System.out.println("Press 4 to view as Published Advertisements.");
	}

	static void LoggedMenu(){
		System.out.println("----------------Logged Succesfully--------------------");
		System.out.println("Press 1 to publish as Ad.");
		System.out.println("Press 4 to Login as Log out.");
		System.out.println("Press 2 to see your published Ad and edit.");
		System.out.println("Press 3 to view as Published Advertisements.");
	}
}