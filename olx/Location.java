package olx;

import java.util.List;

public class Location {
    int LocationID;
    String Block;
    String SocietyName;
    String City;
    String State;
    List<Advertisement> Ads;
    List<UserAccount> uAcc;

    public Location(int locationID, String block, String societyName, String city, String state, List<Advertisement> ads, List<UserAccount> uAcc) {
        LocationID = locationID;
        Block = block;
        SocietyName = societyName;
        City = city;
        State = state;
        Ads = ads;
        this.uAcc = uAcc;
    }

    public void addAds(Advertisement a)
    {
        Ads.add(a);
    }

    public void adduAcc(UserAccount a)
    {
        uAcc.add(a);
    }


}
