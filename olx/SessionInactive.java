package olx;

import java.util.Scanner;

import org.slf4j.*;
import org.beryx.textio.TextIO;
import org.beryx.textio.TextIoFactory;

public class SessionInactive extends SessionState {

	private TextIO textIO = TextIoFactory.getTextIO();
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
		String email =  textIO.newStringInputReader().withMinLength(1).read("Email");
		String Pass = textIO.newStringInputReader().withMinLength(1).read("Password");

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
	@Override
	public boolean loginAdmin() {
		//TAKE APPRORIATE INPUT AND SET APPROPIATE STATE. (WHICH I NO DO IN LAB FINAL SO I GET A D+)
		String email =  textIO.newStringInputReader().withMinLength(1).read("Email");
		String Pass = textIO.newStringInputReader().withMinLength(1).read("Password");

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
