package olx;

import java.sql.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class DBConnection {
    Connection con;
    Statement stmt;

    List<Location> locales = new ArrayList();
    List<Advertisement> ads = new ArrayList<>();
    List<Account> accs = new ArrayList<>();


    // setup connection
    // need to be modified acc to your credentials.
    DBConnection() //cons
    {
        try {
            String s = "jdbc:sqlserver://DESKTOP-795D473:1433;databaseName=OLX";
            con = DriverManager.getConnection(s, "hadi", "123");

            stmt = con.createStatement();

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    //insert location in table
    void insertLocale(String block, String society, String city, String state) {
        try {
            String query = "insert into Locale(residenceBlock,society,city,residenceState) values(?,?,?,?)";
            PreparedStatement preparedStmt = con.prepareStatement(query);
            preparedStmt.setString(1, block);
            preparedStmt.setString(2, society);
            preparedStmt.setString(3, city);
            preparedStmt.setString(4, state);

            preparedStmt.executeUpdate();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    //insert in User table
    void insertUser(String fname, String lname, String email, String password, String number, String block, String society, String city, String state) {
        try {
            insertLocale(block, society, city, state);

            ResultSet rs = stmt.executeQuery("SELECT IDENT_CURRENT ('Locale')");
            rs.next();
            int localeId = rs.getInt(1);


            String query = "insert into Users(fName ,lName ,email ,userPassword ,joinDate ,phone ,userLocation) values(?,?,?,?,?,?,?)";
            PreparedStatement preparedStmt = con.prepareStatement(query);
            preparedStmt.setString(1, fname);
            preparedStmt.setString(2, lname);
            preparedStmt.setString(3, email);
            preparedStmt.setString(4, password);
            preparedStmt.setDate(5, java.sql.Date.valueOf(LocalDate.now()));
            preparedStmt.setString(6, number);
            preparedStmt.setInt(7, localeId);


            preparedStmt.executeUpdate();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    //insert in User table
    void insertAdvertisement(String userEmail, String title, int price, String desc, String ApprovalStatus, String category) {
        try {
            String s = "SELECT UserID From Users where email = ?";
            PreparedStatement prepStmt = con.prepareStatement(s);
            prepStmt.setString(1, userEmail);
            ResultSet rs = prepStmt.executeQuery();
            rs.next();
            int UserId = rs.getInt(1);

            String query = "insert into Advertisement(adPosterID ,title ,price ,adDescription ,approvalStatus,category ) values(?,?,?,?,?,?)";
            PreparedStatement preparedStmt = con.prepareStatement(query);
            preparedStmt.setInt(1, UserId);
            preparedStmt.setString(2, title);
            preparedStmt.setInt(3, price);
            preparedStmt.setString(4, desc);
            preparedStmt.setString(5, ApprovalStatus);
            preparedStmt.setString(6, category);

            preparedStmt.executeUpdate();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    void insertAdvertisementJobs(String userEmail, String title, int price, String desc, String ApprovalStatus, String category, String CompanyName, String Jobdesc) {
        try {
            this.insertAdvertisement(userEmail, title, price, desc, ApprovalStatus, category);
            ResultSet rs = stmt.executeQuery("SELECT IDENT_CURRENT ('Advertisement')");
            rs.next();
            int ID = rs.getInt(1);
            String query = "insert into Jobs(AdvertisementID,companyName,jobDescription ) values(?,?,?)";

            PreparedStatement preparedStmt = con.prepareStatement(query);
            preparedStmt.setInt(1, ID);
            preparedStmt.setString(2, CompanyName);
            preparedStmt.setString(3, Jobdesc);

            preparedStmt.executeUpdate();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    void insertAdvertisementPets(String userEmail, String title, int price, String desc, String ApprovalStatus, String category, String breed) {
        try {
            this.insertAdvertisement(userEmail, title, price, desc, ApprovalStatus, category);
            ResultSet rs = stmt.executeQuery("SELECT IDENT_CURRENT ('Advertisement')");
            rs.next();
            int ID = rs.getInt(1);
            String query = "insert into Pets(AdvertisementID,breed) values(?,?)";

            PreparedStatement preparedStmt = con.prepareStatement(query);
            preparedStmt.setInt(1, ID);
            preparedStmt.setString(2, breed);

            preparedStmt.executeUpdate();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    void insertAdvertisementElectronics(String userEmail, String title, int price, String desc, String ApprovalStatus, String category, String condition, String make) {
        try {
            this.insertAdvertisement(userEmail, title, price, desc, ApprovalStatus, category);
            ResultSet rs = stmt.executeQuery("SELECT IDENT_CURRENT ('Advertisement')");
            rs.next();
            int ID = rs.getInt(1);
            String query = "insert into Electronics(AdvertisementID,condition,make ) values(?,?,?)";

            PreparedStatement preparedStmt = con.prepareStatement(query);
            preparedStmt.setInt(1, ID);
            preparedStmt.setString(2, condition);
            preparedStmt.setString(3, make);

            preparedStmt.executeUpdate();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    void insertAdvertisementProperty(String userEmail, String title, int price, String desc, String ApprovalStatus, String category, String pcategory) {
        try {
            this.insertAdvertisement(userEmail, title, price, desc, ApprovalStatus, category);
            ResultSet rs = stmt.executeQuery("SELECT IDENT_CURRENT ('Advertisement')");
            rs.next();
            int ID = rs.getInt(1);
            String query = "insert into Property(AdvertisementID,category ) values(?,?)";

            PreparedStatement preparedStmt = con.prepareStatement(query);
            preparedStmt.setInt(1, ID);
            preparedStmt.setString(2, pcategory);

            preparedStmt.executeUpdate();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    void insertAdvertisementHouse(String userEmail, String title, int price, String desc, String ApprovalStatus, String category, int bedrooms, int bathrooms) {
        try {
            this.insertAdvertisement(userEmail, title, price, desc, ApprovalStatus, category);
            ResultSet rs = stmt.executeQuery("SELECT IDENT_CURRENT ('Advertisement')");
            rs.next();
            int ID = rs.getInt(1);
            String query = "insert into House(AdvertisementID,noOfBedrooms,noOfBathrooms) values(?,?,?)";

            PreparedStatement preparedStmt = con.prepareStatement(query);
            preparedStmt.setInt(1, ID);
            preparedStmt.setInt(2, bedrooms);
            preparedStmt.setInt(3, bathrooms);

            preparedStmt.executeUpdate();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    void insertAdvertisementMobile(String userEmail, String title, int price, String desc, String ApprovalStatus, String category, String condition, String make) {
        try {
            this.insertAdvertisement(userEmail, title, price, desc, ApprovalStatus, category);
            ResultSet rs = stmt.executeQuery("SELECT IDENT_CURRENT ('Advertisement')");
            rs.next();
            int ID = rs.getInt(1);
            String query = "insert into Mobile(AdvertisementID,condition,make ) values(?,?,?)";

            PreparedStatement preparedStmt = con.prepareStatement(query);
            preparedStmt.setInt(1, ID);
            preparedStmt.setString(2, condition);
            preparedStmt.setString(3, make);

            preparedStmt.executeUpdate();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    void insertAdvertisementVehicle(String userEmail, String title, int price, String desc, String ApprovalStatus, String category, int regYear, String condition, String make, int Kms, float fueleff) {
        try {
            this.insertAdvertisement(userEmail, title, price, desc, ApprovalStatus, category);
            ResultSet rs = stmt.executeQuery("SELECT IDENT_CURRENT ('Advertisement')");
            rs.next();
            int ID = rs.getInt(1);
            String query = "insert into Vehicle(AdvertisementID,registrationYear,make,condition,kmDriven,fuelEfficiency  ) values(?,?,?,?,?,?)";

            PreparedStatement preparedStmt = con.prepareStatement(query);
            preparedStmt.setInt(1, ID);
            preparedStmt.setInt(2, regYear);
            preparedStmt.setString(3, make);
            preparedStmt.setString(4, condition);
            preparedStmt.setInt(5, Kms);
            preparedStmt.setFloat(6, fueleff);


            preparedStmt.executeUpdate();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    void addFollower(String FollowerEmail, String FolloweeEmail) {
        try {
            String s = "SELECT UserID From Users where email = ?";
            PreparedStatement prepStmt = con.prepareStatement(s);
            prepStmt.setString(1, FollowerEmail);
            ResultSet rs = prepStmt.executeQuery();
            rs.next();
            int Follower = rs.getInt(1);

            String s2 = "SELECT UserID From Users where email = ?";
            PreparedStatement prepStmt2 = con.prepareStatement(s2);
            prepStmt2.setString(1, FolloweeEmail);
            ResultSet rs2 = prepStmt2.executeQuery();
            rs.next();
            int Followee = rs2.getInt(1);

            String query = "insert into Followings(FollowerID,FolloweeID) values(?,?)";

            PreparedStatement preparedStmt = con.prepareStatement(query);
            preparedStmt.setInt(1, Follower);
            preparedStmt.setInt(2, Followee);

            preparedStmt.executeUpdate();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    void addLikes(String userEmail, Advertisement obj) {
        try {
            String s2 = "SELECT UserID From Users where email = ?";
            PreparedStatement prepStmt2 = con.prepareStatement(s2);
            prepStmt2.setString(1, userEmail);
            ResultSet rs2 = prepStmt2.executeQuery();
            rs2.next();
            int uId = rs2.getInt(1);

            String s = "SELECT advertisementID From Advertisement where title = ? AND price = ? and adDescription = ?";
            PreparedStatement prepStmt = con.prepareStatement(s);
            prepStmt.setString(1, obj.tittle);
            prepStmt.setInt(2, obj.price);
            prepStmt.setString(3, obj.description);
            ResultSet rs = prepStmt.executeQuery();
            rs.next();
            int AdID = rs.getInt(1);
            String query = "insert into Likes(AdvertisementID) values(?,?)";

            PreparedStatement preparedStmt = con.prepareStatement(query);
            preparedStmt.setInt(2, AdID);
            preparedStmt.setInt(1, uId);


            preparedStmt.executeUpdate();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    // retrieve specific user details
    UserAccount getUser(String userEmail) throws SQLException {
        String s2 = "SELECT * From Users u join Locale l on u.userLocation=l.LocaleID where email = ?";
        PreparedStatement prepStmt2 = con.prepareStatement(s2);
        prepStmt2.setString(1, userEmail);
        ResultSet rs2 = prepStmt2.executeQuery();
        rs2.next();
        /// creating user location object
        String block = rs2.getString(10);
        String society = rs2.getString(11);
        String city = rs2.getString(12);
        String state = rs2.getString(13);

        Location loc = new Location(block, society, city, state);
        /// creating that user object
        String name = rs2.getString(2);
        String email = rs2.getString(4);
        String password = rs2.getString(5);
        String number = rs2.getString(7);
        Date date = new Date();

        UserAccount ussAcc = new UserAccount(name, date, email, number, password, loc);

        /// published advertisements
        int userId = rs2.getInt(1);
        //Jobs Posted
        String s = "Select * from Advertisement a join Jobs j on a.advertisementID=j.AdvertisementID where a.adPosterID=?";
        PreparedStatement prepStmt = con.prepareStatement(s);
        prepStmt.setInt(1, userId);
        ResultSet rs = prepStmt.executeQuery();

        while(rs.next()) {
            String title = rs.getString(3);
            String desc = rs.getString(5);
            int price = rs.getInt(4);
            String companyname = rs.getString(10);
            String jobDesc = rs.getString(11);

            ussAcc.published.add(new Jobs(title, price, desc, loc, ussAcc, 5, companyname, jobDesc));
        }
        //pets posted
        s = "Select * from Advertisement a join Pets j on a.advertisementID=j.AdvertisementID where a.adPosterID=?";
        prepStmt = con.prepareStatement(s);
        prepStmt.setInt(1, userId);
        rs = prepStmt.executeQuery();

        while(rs.next()) {
            String title = rs.getString(3);
            String desc = rs.getString(5);
            int price = rs.getInt(4);
            String breed = rs.getString(10);

            ussAcc.published.add(new Pets(title, price, desc, loc, ussAcc, breed));
        }
        // Electronics
        s = "Select * from Advertisement a join Electronics j on a.advertisementID=j.AdvertisementID where a.adPosterID=?";
        prepStmt = con.prepareStatement(s);
        prepStmt.setInt(1, userId);
        rs = prepStmt.executeQuery();

        while(rs.next()) {
            String title = rs.getString(3);
            String desc = rs.getString(5);
            int price = rs.getInt(4);
            String make = rs.getString(11);
            String condition = rs.getString(10);

            ussAcc.published.add(new Electronics(title, price, desc, loc, ussAcc, Condition.NEW, make));
        }
        // Property
        s = "Select * from Advertisement a join Property j on a.advertisementID=j.AdvertisementID where a.adPosterID=?";
        prepStmt = con.prepareStatement(s);
        prepStmt.setInt(1, userId);
        rs = prepStmt.executeQuery();

        while(rs.next()) {
            String title = rs.getString(3);
            String desc = rs.getString(5);
            int price = rs.getInt(4);

            ussAcc.published.add(new Property(title, price, desc, loc, ussAcc, 550, PropertyType.RENT));
        }
        //Mobile
        s = "Select * from Advertisement a join Mobile j on a.advertisementID=j.AdvertisementID where a.adPosterID=?";
        prepStmt = con.prepareStatement(s);
        prepStmt.setInt(1, userId);
        rs = prepStmt.executeQuery();

        while(rs.next()) {
            String title = rs.getString(3);
            String desc = rs.getString(5);
            int price = rs.getInt(4);
            String make = rs.getString(11);
            String condition = rs.getString(10);

            ussAcc.published.add(new Mobile(title, price, desc, loc, ussAcc, make, Condition.NEW));
        }
        //Vehicle
        s = "Select * from Advertisement a join Vehicle j on a.advertisementID=j.AdvertisementID where a.adPosterID=?";
        prepStmt = con.prepareStatement(s);
        prepStmt.setInt(1, userId);
        rs = prepStmt.executeQuery();

        while(rs.next()) {
            String title = rs.getString(3);
            String desc = rs.getString(5);
            int price = rs.getInt(4);
            String make = rs.getString(11);
            int registerYear = rs.getInt(10);
            String condition = rs.getString(12);
            int Kms = rs.getInt(13);
            Date d = new Date();
            d.getTime();

            ussAcc.published.add(new Vehicle(title, price, desc, loc, ussAcc, make, registerYear, Condition.NEW, d, Fuel.PETROL, Kms));
        }

        return ussAcc;
    }

    /////////////////////////////////////////////////////////////////////////////////////////////////////
    //display Functions
    void displayLocale() {
        try {
            ResultSet rs = stmt.executeQuery("select * from Locale");
            while (rs.next()) {
                locales.add(new Location(rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5)));
                System.out.println(rs.getInt(1) + "  " + rs.getString(2) + "  " + rs.getString(3) + "  " + rs.getString(4) + "  " + rs.getString(5));
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    void displayUser() {
        try {
            ResultSet rs = stmt.executeQuery("select * from Users where category = User");
            while (rs.next()) {
                accs.add(new UserAccount(rs.getString(2), rs.getDate(6), rs.getString(4), rs.getString(7), rs.getString(5), null));
                System.out.println(rs.getInt(1) + "  " + rs.getString(2) + "  " + rs.getString(3) + "  " + rs.getString(4) + "  " + rs.getString(5) + "  " + rs.getDate(6) + "  " + rs.getString(7) + "  " + rs.getInt(8) + "  " + rs.getString(9) + "  " + rs.getString(10));
            }
            ResultSet rs2 = stmt.executeQuery("select * from Users where category = Admin");
            while (rs.next()) {
                accs.add(new AdminAccount(rs.getString(2), rs.getDate(6), rs.getString(4), rs.getString(7), rs.getString(5)));
                System.out.println(rs.getInt(1) + "  " + rs.getString(2) + "  " + rs.getString(3) + "  " + rs.getString(4) + "  " + rs.getString(5) + "  " + rs.getDate(6) + "  " + rs.getString(7) + "  " + rs.getInt(8) + "  " + rs.getString(9) + "  " + rs.getString(10));
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    void displayJobs() {
        try {
            ResultSet rs = stmt.executeQuery("select * from Advertisement ad join Jobs j on ad.advertisementID=j.AdvertisementID");
            while (rs.next()) {
                ads.add(new Jobs(rs.getString(3), rs.getInt(4), rs.getString(5), null, null, 5, rs.getString(12), rs.getString(13)));
                System.out.println(rs.getInt(1) + "  " + rs.getInt(2) + "  " + rs.getString(3) + "  " + rs.getInt(4) + "  " + rs.getString(5) + "  " + rs.getInt(7) + "  " + rs.getInt(8) + "  " + rs.getString(9));
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }


    void displayPets() {
        try {
            ResultSet rs = stmt.executeQuery("select * from Advertisement ad join Pets j on ad.advertisementID=j.AdvertisementID");
            while (rs.next()) {
                ads.add(new Pets(rs.getString(3), rs.getInt(4), rs.getString(5), null, null, rs.getString(12)));
                System.out.println(rs.getInt(1) + "  " + rs.getInt(2) + "  " + rs.getString(3));
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    void displayElectronics() {
        try {
            ResultSet rs = stmt.executeQuery("select * from Advertisement ad join Electronics j on ad.advertisementID=j.AdvertisementID");
            while (rs.next()) {
                ads.add(new Electronics(rs.getString(3), rs.getInt(4), rs.getString(5), null, null, Condition.NEW, rs.getString(13)));
                System.out.println(rs.getInt(1) + "  " + rs.getInt(2) + "  " + rs.getString(3) + "  " + rs.getString(4));
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    void displayProperty() {
        try {
            ResultSet rs = stmt.executeQuery("select * from Advertisement ad join Property j on ad.advertisementID=j.AdvertisementID");
            while (rs.next()) {
                ads.add(new Property(rs.getString(3), rs.getInt(4), rs.getString(5), null, null, 5, PropertyType.RENT));
                System.out.println(rs.getInt(1) + "  " + rs.getInt(2) + "  " + rs.getString(3));
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    void displayHouse() {
        try {
            ResultSet rs = stmt.executeQuery("select * from House");
            while (rs.next()) {
                // to be implemented
                System.out.println(rs.getInt(1) + "  " + rs.getInt(2) + "  " + rs.getInt(3) + "  " + rs.getInt(4));
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    void displayMobile() {
        try {
            ResultSet rs = stmt.executeQuery("select * from Advertisement ad join Mobile j on ad.advertisementID=j.AdvertisementID");
            while (rs.next()) {
                ads.add(new Mobile(rs.getString(3), rs.getInt(4), rs.getString(5), null, null, rs.getString(13), Condition.NEW));
                System.out.println(rs.getInt(1) + "  " + rs.getInt(2) + "  " + rs.getString(3) + "  " + rs.getString(4));
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    void displayVehicle() {
        try {
            ResultSet rs = stmt.executeQuery("select * from Vehicle");
            while (rs.next()) {

                System.out.println(rs.getInt(1) + "  " + rs.getInt(2) + "  " + rs.getInt(3) + "  " + rs.getString(4) + "  " + rs.getString(5) + "  " + rs.getInt(6) + "  " + rs.getFloat(7));
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    void displayReports() {
        try {
            ResultSet rs = stmt.executeQuery("select * from Report");
            while (rs.next()) {

                System.out.println(rs.getInt(1) + "  " + rs.getInt(2) + "  " + rs.getInt(3) + "  " + rs.getInt(4) + "  " + rs.getString(5) + "  " + rs.getInt(6));
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    void displayFollowings() {
        try {
            ResultSet rs = stmt.executeQuery("select * from Followings");
            while (rs.next()) {

                System.out.println(rs.getInt(1) + "  " + rs.getInt(2));
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    void displayLikes() {
        try {
            ResultSet rs = stmt.executeQuery("select * from Likes");
            while (rs.next()) {

                System.out.println(rs.getInt(1) + "  " + rs.getInt(2));
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    //////////////////////////////////////////////////////////////////////////////////////////////////////////////
    // to check wether user Exists or not.
    boolean checkUserInstance(String email) {
        try {
            String s2 = "SELECT UserID From Users where email = ?";
            PreparedStatement prepStmt2 = con.prepareStatement(s2);
            prepStmt2.setString(1, email);
            ResultSet rs2 = prepStmt2.executeQuery();
            if (rs2.next())
                return true;
            return false;
        } catch (Exception e) {
            System.out.println(e);
            return false;
        }
    }

    /*
    // Search query
    List<Advertisement> Search (String Title, String cat) throws SQLException {
        List<Advertisement> retAds = new ArrayList<>();
        if (cat.equalsIgnoreCase("Jobs")) {
            String s = "Select * from Advertisement a join Jobs j on a.advertisementID=j.AdvertisementID where title LIKE '%'+?+'%'";
            PreparedStatement prepStmt = con.prepareStatement(s);
            prepStmt.setString(1, Title);
            ResultSet rs = prepStmt.executeQuery();
            while(rs.next()){
                String title = rs.getString(3);
                String desc = rs.getString(5);
                int price = rs.getInt(4);
                String companyname = rs.getString(10);
                String jobDesc = rs.getString(11);

               retAds.add(new Jobs(title, price, desc, loc, ussAcc, 5, companyname, jobDesc));}
        }
    }

     */
}
