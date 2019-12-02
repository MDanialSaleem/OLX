package olx;

import org.slf4j.*;

import java.util.ArrayList;

import org.beryx.textio.TextIO;
import org.beryx.textio.TextIoFactory;

public class UserProfileViewer {
	private UserAccount user;
	private TextIO textIO = TextIoFactory.getTextIO();
	
	public UserProfileViewer(UserAccount user) {
		this.user = user;
		this.displayUserProfile();
	}
	
	public void displayUserProfile() {
		user.viewUserProfile();
		System.out.println("Press -1 to go back");
		System.out.println("Press 1 to follow seller");
		System.out.println("Press 2 to share seller profile link");
		System.out.println("Press 3 to chat with the seller ");
		int input = textIO.newIntInputReader().withMinVal(-1).withMaxVal(3).withDefaultValue(-1).read("Input");
		
		
		
		if(input == 1) {
			if(OLX.getInstance().getCurrentUserAccount() == null){
				System.out.println("You must be logged in to perform this action");
			}
			else {
				OLX.getInstance().getCurrentUserAccount().followUser(user);
				System.out.println("You are now following this user");
				//ASLO SEND REQUEST TO DB HERE.
			}
			this.displayUserProfile();
		}
		else if(input == 2) {
			System.out.printf("OLX.COM/%s\n", user.getName());
			this.displayUserProfile();
		}
		else if(input == 3) {
			if(OLX.getInstance().getCurrentUserAccount() == null){
				System.out.println("You must be logged in to perform this action");
			}
			else {
				ChatViewer viewer = new ChatViewer(OLX.getInstance().getCurrentUserAccount(), user);
				viewer.viewChat();
			}
			this.displayUserProfile();
			
		}
		
	}
}
