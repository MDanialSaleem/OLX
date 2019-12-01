package olx;

import java.util.*;
import java.time.LocalDate;
import org.slf4j.*;


import org.beryx.textio.TextIO;
import org.beryx.textio.TextIoFactory;
public class AdminAccount extends Account {
	//do no lower to interface here. We need indexed access.
	ArrayList<Advertisement> adsWaitingList;
	ArrayList<Report> reportsWaitingList;

	TextIO textIO = TextIoFactory.getTextIO();

	private boolean hasWaitingAds = false;
	public AdminAccount(String name, LocalDate joinDate, String email, String phoneNumber, String password) {
		super(name, joinDate, email, phoneNumber, password);
		adsWaitingList = new ArrayList<>();
		reportsWaitingList = new ArrayList<>();
	}
	
	
	public boolean hasWaitingAds() {
		return hasWaitingAds;
	}
	public void setHasWaitingAds(boolean hasWaitingAds) {
		this.hasWaitingAds = hasWaitingAds;
	}
	
	public void viewAdsForApproval() {
		for(int i = 1; i <= adsWaitingList.size(); i++) {
			System.out.println(i + ": " + adsWaitingList.get(i).getTittle());
		}


		int userInput = textIO.newIntInputReader().withMinVal(1).withMaxVal( adsWaitingList.size()).read("Enter Ad no"); //get this from user usint TextIO with suitable up limit decided by size of list.
		decideApproval(adsWaitingList.get(userInput));
	}
	
	public void viewReports() {
		for(int i = 1; i <= reportsWaitingList.size(); i++) {
			System.out.println(i +": " + reportsWaitingList.get(i).getAd().getTittle());
		}

		int userInput =textIO.newIntInputReader().withMinVal(1).withMaxVal( reportsWaitingList.size()).read("Enter Report no"); //get this from user usint TextIO with suitable up limit decided by size of list.

		decideReport(reportsWaitingList.get(userInput));
		
	}
	
	public void decideApproval(Advertisement ad) {
		ad.viewAdvertisement();
		boolean approval =  textIO.newBooleanInputReader().read("Approval");
		ad.approveDisapprove(approval, this);
		adsWaitingList.remove(ad);
	}
	
	public void decideReport(Report report) {
		report.viewReport();
		boolean decision = textIO.newBooleanInputReader().read("Decision");
		report.decideReport(decision, this);
		reportsWaitingList.remove(report);
	}
	
	
	
	
	

}
