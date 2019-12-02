package olx;

import java.util.*;

import org.slf4j.*;
import org.beryx.textio.TextIO;
import org.beryx.textio.TextIoFactory;



public class AdvertisementViewer {
	private ArrayList<Advertisement> list;
	
	private TextIO textIO = TextIoFactory.getTextIO();
	public AdvertisementViewer(ArrayList<Advertisement> list) {
		this.list = list;
	}
	
	
	private void displayAd(Advertisement ad) {
		ad.viewAdvertisement();
		boolean userLoggedIn = OLX.getInstance().getCurrentUserAccount() != null;
		
		System.out.println("Press -1 to go back");
		System.out.println("Press 1 to visit seller profile");
		System.out.println("Press 2 to like advertisement");
		System.out.println("Press 3 to report advertisement");
		
		int input = textIO.newIntInputReader().withMinVal(-1).withMaxVal(3).withDefaultValue(-1).read("Input");

		switch (input) {
		case 1:
			ad.getCreator().viewUserProfile();
			break;
		case 2:
			if(!userLoggedIn) {
				System.out.println("You need to be logged in to perform this action");
			}
			else {
				OLX.getInstance().getCurrentUserAccount().likeAdvertisement(ad);
			}
		case 3:
			if(!userLoggedIn) {
				System.out.println("You need to be logged in to perform this action");
			}
			else {
				ad.reportAdvertisement();
			}
		}
		
	}
	public void display() {
		for(int i = 0; i < list.size(); i++) {
			Advertisement ad = list.get(i);
			System.out.printf("%d %s %d", i, ad.getTittle(), ad.getPrice());
		}
		
		System.out.println("Press the number of ad to view that ad.");
		System.out.println("Press -1 to go back");
		int input = textIO.newIntInputReader()
		        .withMinVal(-1)
		        .withMaxVal(list.size())
		        .withDefaultValue(-1)
		        .read("Input");
		
		if(input > 0) {
			displayAd(list.get(input));
		}
		

	}
}
