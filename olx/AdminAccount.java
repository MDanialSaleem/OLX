package olx;

import java.util.Date;

public class AdminAccount extends Account {

	private boolean hasWaitingAds = false;
	public AdminAccount(String name, Date joinDate, String email, String phoneNumber, String password) {
		super(name, joinDate, email, phoneNumber, password);
	}
	public boolean isHasWaitingAds() {
		return hasWaitingAds;
	}
	public void setHasWaitingAds(boolean hasWaitingAds) {
		this.hasWaitingAds = hasWaitingAds;
	}
	
	

}
