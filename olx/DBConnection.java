package olx;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;

import java.sql.ResultSet;

import java.time.LocalDate;

//this should be singleton.
public class DBConnection {
	private static DBConnection instance = null;

	Connection con;
    Statement stmt;
	
	public static DBConnection getInstance() {
		if(instance == null) {
			instance = new DBConnection();
		}
		return instance;
	}
	
	//constructor
	private DBConnection() {
		try
        {
            String s = "jdbc:sqlserver://DESKTOP-795D473:1433;databaseName=OLX";
            con=DriverManager.getConnection(s,"hadi","123");

            stmt = con.createStatement();

        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }

    /*----------------------------------------------Insert Functions-------------------------------------------------*/

    //insert location in table
    void insertLocale(String block,String society, String city, String state)
    {
        try
        {
            String query = "insert into Locale(residenceBlock,society,city,residenceState) values(?,?,?,?)";
            PreparedStatement preparedStmt = con.prepareStatement(query);
            preparedStmt.setString(1, block);
            preparedStmt.setString(2, society);
            preparedStmt.setString(3, city);
            preparedStmt.setString(4, state);

            preparedStmt.executeUpdate();
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }

    //insert in User table
    void insertUser(String fname, String lname, String email, String password,String number, int localeId, String sex, String category)
    {
        try
        {
            String query = "insert into Users(fName ,lName ,email ,userPassword ,joinDate ,phone ,userLocation ,gender ,category ) values(?,?,?,?,?,?,?,?,?)";
            PreparedStatement preparedStmt = con.prepareStatement(query);
            preparedStmt.setString(1, fname);
            preparedStmt.setString(2, lname);
            preparedStmt.setString(3, email);
            preparedStmt.setString(4, password);
            preparedStmt.setDate(5,java.sql.Date.valueOf(LocalDate.now()));
            preparedStmt.setString(6, number);
            preparedStmt.setInt(7, localeId);
            preparedStmt.setString(8, sex);
            preparedStmt.setString(9, category);


            preparedStmt.executeUpdate();
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }

    //insert in Advertisement table
    void insertAdvertisement(int  UserId, String title, int  price, String desc,String ApprovalStatus, int localeId, int AdminId, String category)
    {
        try
        {
            String query = "insert into Advertisement(adPosterID ,title ,price ,adDescription ,approvalStatus,localeID,adminID,category ) values(?,?,?,?,?,?,?,?)";
            PreparedStatement preparedStmt = con.prepareStatement(query);
            preparedStmt.setInt(1, UserId);
            preparedStmt.setString(2, title);
            preparedStmt.setInt(3, price);
            preparedStmt.setString(4, desc);
            preparedStmt.setString(5,ApprovalStatus);
            preparedStmt.setInt(6, localeId);
            preparedStmt.setInt(7, AdminId);
            preparedStmt.setString(8, category);

            preparedStmt.executeUpdate();
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }
    // insert a Job
    void insertAdvertisementJobs(int  UserId, String title, int  price, String desc,String ApprovalStatus, int localeId, int AdminId, String category,String CompanyName,String Jobdesc)
    {
        try
        {
            this.insertAdvertisement(UserId,title,price,desc,ApprovalStatus,localeId,AdminId,category);
            int ID=this.getAdvertisementId(price,localeId,UserId);
            String query = "insert into Jobs(AdvertisementID,companyName,jobDescription ) values(?,?,?)";

            PreparedStatement preparedStmt = con.prepareStatement(query);
            preparedStmt.setInt(1,ID);
            preparedStmt.setString(2, CompanyName);
            preparedStmt.setString(3, Jobdesc);

            preparedStmt.executeUpdate();
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }
  // insert a pet
    void insertAdvertisementPets(int  UserId, String title, int  price, String desc,String ApprovalStatus, int localeId, int AdminId, String category,String breed)
    {
        try
        {
            this.insertAdvertisement(UserId,title,price,desc,ApprovalStatus,localeId,AdminId,category);
            int ID=this.getAdvertisementId(price,localeId,UserId);
            String query = "insert into Pets(AdvertisementID,breed) values(?,?)";

            PreparedStatement preparedStmt = con.prepareStatement(query);
            preparedStmt.setInt(1,ID);
            preparedStmt.setString(2, breed);

            preparedStmt.executeUpdate();
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }
    // insert electronic
    void insertAdvertisementElectronics(int  UserId, String title, int  price, String desc,String ApprovalStatus, int localeId, int AdminId, String category,String condition,String make)
    {
        try
        {
            this.insertAdvertisement(UserId,title,price,desc,ApprovalStatus,localeId,AdminId,category);
            int ID=this.getAdvertisementId(price,localeId,UserId);
            String query = "insert into Electronics(AdvertisementID,condition,make ) values(?,?,?)";

            PreparedStatement preparedStmt = con.prepareStatement(query);
            preparedStmt.setInt(1,ID);
            preparedStmt.setString(2, condition);
            preparedStmt.setString(3, make);

            preparedStmt.executeUpdate();
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }
    //insert Property
    void insertAdvertisementProperty(int  UserId, String title, int  price, String desc,String ApprovalStatus, int localeId, int AdminId, String category,String pcategory)
    {
        try
        {
            this.insertAdvertisement(UserId,title,price,desc,ApprovalStatus,localeId,AdminId,category);
            int ID=this.getAdvertisementId(price,localeId,UserId);
            String query = "insert into Property(AdvertisementID,category ) values(?,?)";

            PreparedStatement preparedStmt = con.prepareStatement(query);
            preparedStmt.setInt(1,ID);
            preparedStmt.setString(2, pcategory);

            preparedStmt.executeUpdate();
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }
    //insertHouse
    void insertAdvertisementHouse(int  UserId, String title, int  price, String desc,String ApprovalStatus, int localeId, int AdminId, String category,int bedrooms, int bathrooms)
    {
        try
        {
            this.insertAdvertisement(UserId,title,price,desc,ApprovalStatus,localeId,AdminId,category);
            int ID=this.getAdvertisementId(price,localeId,UserId);
            String query = "insert into House(AdvertisementID,noOfBedrooms,noOfBathrooms) values(?,?,?)";

            PreparedStatement preparedStmt = con.prepareStatement(query);
            preparedStmt.setInt(1,ID);
            preparedStmt.setInt(2, bedrooms);
            preparedStmt.setInt(3, bathrooms);

            preparedStmt.executeUpdate();
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }
    // insert Mobile
    void insertAdvertisementMobile(int  UserId, String title, int  price, String desc,String ApprovalStatus, int localeId, int AdminId, String category,String condition,String make)
    {
        try
        {
            this.insertAdvertisement(UserId,title,price,desc,ApprovalStatus,localeId,AdminId,category);
            int ID=this.getAdvertisementId(price,localeId,UserId);
            String query = "insert into Mobile(AdvertisementID,condition,make ) values(?,?,?)";

            PreparedStatement preparedStmt = con.prepareStatement(query);
            preparedStmt.setInt(1,ID);
            preparedStmt.setString(2, condition);
            preparedStmt.setString(3, make);

            preparedStmt.executeUpdate();
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }
    //insert Vehicle
    void insertAdvertisementVehicle(int  UserId, String title, int  price, String desc,String ApprovalStatus, int localeId, int AdminId, String category, int regYear,String condition,String make,int Kms , float fueleff)
    {
        try
        {
            this.insertAdvertisement(UserId,title,price,desc,ApprovalStatus,localeId,AdminId,category);
            int ID=this.getAdvertisementId(price,localeId,UserId);
            String query = "insert into Vehicle(AdvertisementID,registrationYear,make,condition,kmDriven,fuelEfficiency  ) values(?,?,?,?,?,?)";

            PreparedStatement preparedStmt = con.prepareStatement(query);
            preparedStmt.setInt(1,ID);
            preparedStmt.setInt(2, regYear);
            preparedStmt.setString(3, make);
            preparedStmt.setString(4, condition);
            preparedStmt.setInt(5, Kms);
            preparedStmt.setFloat(6, fueleff);


            preparedStmt.executeUpdate();
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }
    //insert Report
    void insertReport(int  PuserId, int AdID, int  RuserID, int AuserID,String rptDesc, int status)
    {
        try
        {
            String query = "insert into Report(adPosterID ,AdvertisementID ,ReporterID ,adminID,reportDescription,reportStatus) values(?,?,?,?,?,?)";

            PreparedStatement preparedStmt = con.prepareStatement(query);
            preparedStmt.setInt(1,PuserId);
            preparedStmt.setInt(2, AdID);
            preparedStmt.setInt(3, RuserID);
            preparedStmt.setInt(4, AuserID);
            preparedStmt.setString(5, rptDesc);
            preparedStmt.setInt(6, status);


            preparedStmt.executeUpdate();
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }
    //insert Follower
    void addFollower(int  Follower, int Followee)
    {
        try
        {
            String query = "insert into Followings(FollowerID,FolloweeID) values(?,?)";

            PreparedStatement preparedStmt = con.prepareStatement(query);
            preparedStmt.setInt(1,Follower);
            preparedStmt.setInt(2, Followee);

            preparedStmt.executeUpdate();
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }
    // insert likes
    void addLikes(int AdID)
    {
        try
        {
            String query = "insert into Likes(AdvertisementID) values(?)";

            PreparedStatement preparedStmt = con.prepareStatement(query);
            preparedStmt.setInt(1,AdID);


            preparedStmt.executeUpdate();
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }


/* -------------------------------Display Functions------------------------------------------------------------*/
    void displayLocale()
    {
        try
        {
            ResultSet rs=stmt.executeQuery("select * from Locale");
            while(rs.next())
            {

                System.out.println(rs.getInt(1)+"  "+rs.getString(2)+"  "+rs.getString(3)+"  "+rs.getString(4)+"  "+rs.getString(5));
            }
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }

    void displayUser()
    {
        try
        {
            ResultSet rs=stmt.executeQuery("select * from Users");
            while(rs.next())
            {

                System.out.println(rs.getInt(1)+"  "+rs.getString(2)+"  "+rs.getString(3)+"  "+rs.getString(4)+"  "+rs.getString(5)+"  "+rs.getDate(6)+"  "+rs.getString(7)+"  "+rs.getInt(8)+"  "+rs.getString(9)+"  "+rs.getString(10));
            }
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }

    void displayAds()
    {
        try
        {
            ResultSet rs=stmt.executeQuery("select * from Advertisement");
            while(rs.next())
            {

                System.out.println(rs.getInt(1)+"  "+rs.getInt(2)+"  "+rs.getString(3)+"  "+rs.getInt(4)+"  "+rs.getString(5)+"  "+rs.getDate(6)+"  "+rs.getInt(7)+"  "+rs.getInt(8)+"  "+rs.getString(9));
            }
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }

    void displayJobs()
    {
        try
        {
            ResultSet rs=stmt.executeQuery("select * from Jobs");
            while(rs.next())
            {

                System.out.println(rs.getInt(1)+"  "+rs.getInt(2)+"  "+rs.getString(3)+"  "+rs.getString(4));
            }
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }

    void displayPets()
    {
        try
        {
            ResultSet rs=stmt.executeQuery("select * from Pets");
            while(rs.next())
            {

                System.out.println(rs.getInt(1)+"  "+rs.getInt(2)+"  "+rs.getString(3));
            }
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }

    void displayElectronics()
    {
        try
        {
            ResultSet rs=stmt.executeQuery("select * from Electronics");
            while(rs.next())
            {

                System.out.println(rs.getInt(1)+"  "+rs.getInt(2)+"  "+rs.getString(3)+"  "+rs.getString(4));
            }
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }

    void displayProperty()
    {
        try
        {
            ResultSet rs=stmt.executeQuery("select * from Property");
            while(rs.next())
            {

                System.out.println(rs.getInt(1)+"  "+rs.getInt(2)+"  "+rs.getString(3));
            }
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }

    void displayHouse()
    {
        try
        {
            ResultSet rs=stmt.executeQuery("select * from House");
            while(rs.next())
            {

                System.out.println(rs.getInt(1)+"  "+rs.getInt(2)+"  "+rs.getInt(3)+"  "+rs.getInt(4));
            }
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }

    void displayMobile()
    {
        try
        {
            ResultSet rs=stmt.executeQuery("select * from Mobile");
            while(rs.next())
            {

                System.out.println(rs.getInt(1)+"  "+rs.getInt(2)+"  "+rs.getString(3)+"  "+rs.getString(4));
            }
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }

    void displayVehicle()
    {
        try
        {
            ResultSet rs=stmt.executeQuery("select * from Vehicle");
            while(rs.next())
            {

                System.out.println(rs.getInt(1)+"  "+rs.getInt(2)+"  "+rs.getInt(3)+"  "+rs.getString(4)+"  "+rs.getString(5)+"  "+rs.getInt(6)+"  "+rs.getFloat(7));
            }
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }

    void displayReports()
    {
        try
        {
            ResultSet rs=stmt.executeQuery("select * from Report");
            while(rs.next())
            {

                System.out.println(rs.getInt(1)+"  "+rs.getInt(2)+"  "+rs.getInt(3)+"  "+rs.getInt(4)+"  "+rs.getString(5)+"  "+rs.getInt(6));
            }
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }

    void displayFollowings()
    {
        try
        {
            ResultSet rs=stmt.executeQuery("select * from Followings");
            while(rs.next())
            {

                System.out.println(rs.getInt(1)+"  "+rs.getInt(2));
            }
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }

    void displayLikes()
    {
        try
        {
            ResultSet rs=stmt.executeQuery("select * from Likes");
            while(rs.next())
            {

                System.out.println(rs.getInt(1)+"  "+rs.getInt(2));
            }
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }

/*-------------------------------------------Helper Function-------------------------------------------------*/

    int getAdvertisementId(int price, int locId, int posterId)
    {
        try
        {
            ResultSet rs=stmt.executeQuery("select * from Advertisement where price="+price+"AND localeID="+locId+"AND adPosterID="+posterId);
            rs.next();
            return rs.getInt(1);
        }
        catch(Exception e)
        {
            System.out.println(e);
            return 0;
        }
    }
	
}
