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
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean loginAdmin() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void logOut() {
		throw new IllegalStateException();
		//this should never be called.
		
	}
	
}
