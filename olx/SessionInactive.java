package olx;

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
		//TAKE APPRORIATE INPUT AND SET APPROPIATE STATE. (WHICH I NO DO IN LAB FINAL SO I GET A D+)
		return false;
	}

	@Override
	public boolean loginAdmin() {
		//TAKE APPRORIATE INPUT AND SET APPROPIATE STATE. (WHICH I NO DO IN LAB FINAL SO I GET A D+)
		return false;
	}

	@Override
	public void logOut() {
		throw new IllegalStateException();
		//this should never be called.
		
	}
	
}
