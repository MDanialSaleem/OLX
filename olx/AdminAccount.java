package olx;

import java.util.Date;
import java.time.LocalDate;

public class AdminAccount extends Account {

	private boolean hasWaitingAds = false;
	public AdminAccount(String name, LocalDate joinDate, String email, String phoneNumber, String password) {
		super(name, joinDate, email, phoneNumber, password);
	}
	public boolean isHasWaitingAds() {
		return hasWaitingAds;
	}
	public void setHasWaitingAds(boolean hasWaitingAds) {
		this.hasWaitingAds = hasWaitingAds;
	}
	
	

}
