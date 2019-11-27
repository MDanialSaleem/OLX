package olx;

public class SessionUser extends SessionState {

	@Override
	public UserAccount getCurrentUserAccount() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public AdminAccount getCurrentAdminAccount() {
		return null;
	}

	@Override
	public boolean logInUser() {
		throw new IllegalStateException();
	}

	@Override
	public boolean loginAdmin() {
		throw new IllegalStateException();
	}

	@Override
	public void logOut() {
		//do logout here.
		
	}
	
}
