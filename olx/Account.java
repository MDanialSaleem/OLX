package olx;

import java.util.Date;

public class Account {
    String Name;
    Date JoinDate;
    String Email;
    String PhoneNumber;
    String Password;
    public Account(String name, Date joinDate, String email, String phoneNumber, String password) {
        Name = name;
        JoinDate = joinDate;
        Email = email;
        PhoneNumber = phoneNumber;
        Password = password;
    }
	public String getName() {
		return Name;
	}
	public Date getJoinDate() {
		return JoinDate;
	}
	public String getEmail() {
		return Email;
	}
	public String getPhoneNumber() {
		return PhoneNumber;
	}
	public String getPassword() {
		return Password;
	}

}
