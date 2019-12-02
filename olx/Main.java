package olx;
import java.time.LocalDate;
import java.util.*;

import org.beryx.textio.TextTerminal;
import org.slf4j.*;


import org.beryx.textio.TextIO;
import org.beryx.textio.TextIoFactory;

public class Main {

	public static void main(String[] args) {
		TextIO textIO = TextIoFactory.getTextIO();
		TextTerminal terminal = textIO.getTextTerminal();


		OLX application=OLX.getInstance();
		application.setAdministrator(new AdminAccount("Hadi",LocalDate.now(),"hadi@gmail.com","123456","123"));
		welcomeMessage();
		int temp=4;
		while(true){
			if(temp==4){
				StartupLogin();
				temp=textIO.newIntInputReader().read("Enter your selection");

				userCall(temp);
			}
			else if(temp==1 || temp==2)
			{
				LoggedMenu();
				temp=textIO.newIntInputReader().read("Enter your selection");
				userLoggedcall(temp);
			}
		}

	}






	static boolean userCall(int i){
		TextIO textIO = TextIoFactory.getTextIO();
		TextTerminal terminal = textIO.getTextTerminal();
		if(i==1)
		{OLX.getInstance().registerUser();return true;}
		else if(i==2){
			boolean ret=OLX.getInstance().logInUser();
			if(ret==false)
				terminal.printf("\n\"Wrong Credentials\"\n");
			terminal.printf("\n\"User Successfully Logged in\"\n");

			return true;
		}
		else if(i==3){
			boolean ret=OLX.getInstance().logInAdmin();
			if(ret==false)
				terminal.printf("\n\"Wrong Credentials\"\n");
			terminal.printf("\n\"User Successfully Logged in\"\n");

			return true;
		}
		else
		{
			OLX.getInstance().viewAdvertisements();
		}
		return false;
	}

	static boolean userLoggedcall(int i){
		TextIO textIO = TextIoFactory.getTextIO();
		if(i==1)
		{OLX.getInstance().getCurrentUserAccount().createAdvertisement();}
		else if(i==4){
			OLX.getInstance().logOutUser();
			return true;
		}
		else if(i==2)
		{
			OLX.getInstance().getCurrentUserAccount().printPublishedAds();
			int t=textIO.newIntInputReader().read("Enter your selection");
			OLX.getInstance().getCurrentUserAccount().published.get(t).editAdvertisement();
		}
		else
		{
			OLX.getInstance().viewAdvertisements();
		}
		return false;
	}

	static void welcomeMessage(){
		TextIO textIO = TextIoFactory.getTextIO();
		TextTerminal terminal = textIO.getTextTerminal();

		terminal.printf("\n\"---------------- WELCOME TO OLX --------------------\"\n");
	}


	static void StartupLogin(){
		TextIO textIO = TextIoFactory.getTextIO();
		TextTerminal terminal = textIO.getTextTerminal();

		terminal.printf("\nPress 1 to register as User.\n");
		terminal.printf("\nPress 2 to Login as User.\n");
		terminal.printf("\nPress 3 to Login as Admin.\n");
		terminal.printf("\nPress 4 to view as Published Advertisements.\n");

	}

	static void LoggedMenu(){
		TextIO textIO = TextIoFactory.getTextIO();
		TextTerminal terminal = textIO.getTextTerminal();

		terminal.printf("\n\"----------------Logged Succesfully--------------------\"\n");
		terminal.printf("\nPress 1 to publish as Ad.\n");
		terminal.printf("\nPress 2 to see your published Ad and edit.\n");
		terminal.printf("\nPress 3 to view as Published Advertisements.\n");
		terminal.printf("\nPress 4 to log out.\n");


	}
}