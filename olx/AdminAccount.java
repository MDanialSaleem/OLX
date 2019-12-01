package com.company;

import java.util.*;
import java.time.LocalDate;

public class AdminAccount extends Account {
	//do no lower to interface here. We need indexed access.
	ArrayList<Advertisement> adsWaitingList;
	ArrayList<Report> reportsWaitingList;
	
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
		for(int i = 0; i < adsWaitingList.size(); i++) {
			System.out.println(i + ": " + adsWaitingList.get(i).getTittle());
		}
		//GET INPUT FROM USER AS TO WICH NUMBER AD HE WANTS TO APPROVE/DISAPPROVE.
		int userInput = 0; //get this from user usint TextIO with suitable up limit decided by size of list.
		decideApproval(adsWaitingList.get(userInput));
	}
	
	public void viewReports() {
		for(int i = 0; i < reportsWaitingList.size(); i++) {
			System.out.println(i +": " + reportsWaitingList.get(i).getAd().getTittle());
		}
		//GET INPUT FROM USER AS TO WICH NUMBER AD HE WANTS TO APPROVE/DISAPPROVE.
		int userInput = 0; //get this from user usint TextIO with suitable up limit decided by size of list.
		decideReport(reportsWaitingList.get(userInput));
		
	}
	
	public void decideApproval(Advertisement ad) {
		ad.viewAdvertisement();
		boolean approval = true; //TAKE THIS INUT FROM USER.
		ad.approveDisapprove(approval, this);
		adsWaitingList.remove(ad);
	}
	
	public void decideReport(Report report) {
		report.viewReport();
		boolean decision = true; //TAKE THIS INPUT FROM USER.
		report.decideReport(decision, this);
		reportsWaitingList.remove(report);
	}
	
	
	
	
	

}
