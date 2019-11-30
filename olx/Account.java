package olx;

import java.util.Date;
import java.time.LocalDate;
public class Account {
    String Name;
	LocalDate JoinDate;
    String Email;
    String PhoneNumber;
    String Password;
    public Account(String name, LocalDate joinDate, String email, String phoneNumber, String password) {
        Name = name;
        JoinDate = joinDate;
        Email = email;
        PhoneNumber = phoneNumber;
        Password = password;
    }
	public String getName() {
		return Name;
	}
	public LocalDate getJoinDate() {
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
