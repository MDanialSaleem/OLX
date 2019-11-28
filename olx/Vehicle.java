package olx;

import java.util.Date;

public class Vehicle extends Advertisement {
    String make;
    int year;
    String condition;
    Date registeration;
    String fuel;
    float KMdriven;

    public Vehicle(int views, int shares, int likes, int tittle, int price, String type, String description, String status, Location loc, Report rep, SessionUser admin, String make, int year, String condition, Date registeration, String fuel, float KMdriven) {
        super(views, shares, likes, tittle, price, type, description, status, loc, rep, admin);
        this.make = make;
        this.year = year;
        this.condition = condition;
        this.registeration = registeration;
        this.fuel = fuel;
        this.KMdriven = KMdriven;
    }

    public void viewAdvertisement(){
        super.viewAdvertisement();
        System.out.println("Make "+make);
        System.out.println("Condition "+condition);
        System.out.println("Registeration date "+registeration);
        System.out.println("Fuel "+fuel);
        System.out.println("Km Drivern "+KMdriven);

    }
}
