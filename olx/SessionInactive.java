package olx;

import java.util.Scanner;

public class SessionInactive extends SessionState {

	@Override
	public UserAccount getCurrentUserAccount() {
		return null;
	}

	@Override
	public AdminAccount getCurrentAdminAccount() {
		return null;
	}

	@Override
	public boolean logInUser() {
		//TAKE APPRORIATE INPUT AND SET APPROPIATE STATE. (WHICH I NO DO IN LAB FINAL SO I GET A D+)//congratulations
		System.out.println("----------------------Login Now-----------------");
		System.out.println("Enter your email.");
		String email=userInputText();
		System.out.println("Enter your password.");
		String Pass=userInputText();

		for(int i=0;i<OLX.getInstance().getAccounts().size();i++)
		{
			if(OLX.getInstance().getAccounts().get(i).Email.equalsIgnoreCase(email) && OLX.getInstance().getAccounts().get(i).Password.equalsIgnoreCase(Pass)) {
				OLX.getInstance().setState(new SessionUser());
				OLX.getInstance().setActiveAccount(OLX.getInstance().getAccounts().get(i));
				return true;
			}
		}
		return false;
	}

	static int userInputInt(){
		Scanner input=new Scanner(System.in);
		return input.nextInt();
	}

	static String userInputText(){
		Scanner input=new Scanner(System.in);
		return input.next();
	}

	@Override
	public boolean loginAdmin() {
		//TAKE APPRORIATE INPUT AND SET APPROPIATE STATE. (WHICH I NO DO IN LAB FINAL SO I GET A D+)
		System.out.println("----------------------Login Now-----------------");
		System.out.println("Enter your email.");
		String email=userInputText();
		System.out.println("Enter your password.");
		String Pass=userInputText();

		if(OLX.getInstance().getAdministrator().Email==email && OLX.getInstance().getAdministrator().Password==Pass)
		{
			OLX.getInstance().setState(new SessionAdmin());
			OLX.getInstance().setActiveAccount(OLX.getInstance().getAdministrator());
			return true;
		}
		return false;
	}

	@Override
	public void logOut() {
		throw new IllegalStateException();
		//this should never be called.
	}
	
}
