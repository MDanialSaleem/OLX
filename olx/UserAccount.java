package olx;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.time.LocalDate;
import java.time.ZoneId;

import org.slf4j.*;


import org.beryx.textio.TextIO;
import org.beryx.textio.TextIoFactory;

public class UserAccount extends Account {

    TextIO textIO = TextIoFactory.getTextIO();

    Boolean hasUnreadMessages;
    Boolean hasUnopenedUpdates;
    Location loc;
    List<Advertisement> published;
    List<Advertisement> likedAds;
    List<Report> reportedAds;
    List<UserAccount> Followers;
    List<Chat> ChatsInitiated;

    public UserAccount(String name, LocalDate joinDate, String email, String phoneNumber, String password, OLX app, Location loc) {
        super(name, joinDate, email, phoneNumber, password);
        this.hasUnreadMessages = false;
        this.hasUnopenedUpdates = false;
        this.loc = loc;
        this.published = new ArrayList<Advertisement>();
        this.likedAds = new ArrayList<Advertisement>();
        reportedAds = new ArrayList<Report>();
        Followers = new ArrayList<UserAccount>();
        ChatsInitiated = new ArrayList<Chat>();
    }

    public UserAccount(String name, LocalDate joinDate, String email, String phoneNumber, String password, OLX app, boolean unReadMessages, boolean hasUnopenedUpdates, Location loc, List<Advertisement> published, List<Advertisement> likedAds, List<Report> reported, List<UserAccount> followers, List<Chat> chatsInitiated) {
        super(name, joinDate, email, phoneNumber, password);
        this.hasUnreadMessages = unReadMessages;
        this.hasUnopenedUpdates = hasUnopenedUpdates;
        this.loc = loc;
        this.published = published;
        this.likedAds = likedAds;
        reportedAds = reported;
        Followers = followers;
        ChatsInitiated = chatsInitiated;
    }

	public UserAccount(String name, Date date, String email, String number, String password, Location loc2) {

		super(name, date.toInstant()
			      .atZone(ZoneId.systemDefault())
			      .toLocalDate(), email, number, password);
		
        this.published = new ArrayList<Advertisement>();
        this.likedAds = new ArrayList<Advertisement>();
        reportedAds = new ArrayList<Report>();
        Followers = new ArrayList<UserAccount>();
        ChatsInitiated = new ArrayList<Chat>();
		this.loc = loc2;
	}

	public Advertisement postAdvertisement(Advertisement ad) {
        return null;
        //have to implement this.
    }

    public void likeAdvertisement(Advertisement ad) {
        likedAds.add(ad);
    }

    public void reportAdvertisement(Report report) {
        reportedAds.add(report);
    }

    public void deleteAdvertisement() {
        //tobeimplemented.
    }

    public void sendMessage(UserAccount account, String message) {
        Chat exists = null;
        for (Chat chat : ChatsInitiated) {
            for (int i = 0; i < chat.getParticipants().length; i++) {
                if (account.equals(chat.getParticipants()[i])) {
                    exists = chat;
                }
            }
            if (exists != null) {
                break;
            }
        }

        if (exists == null) {
            exists = new Chat(this, account);
        }
        exists.addMessage(message, this);
    }

    public void followUser(UserAccount user) {
        user.addFollower(this);
    }

    public void addFollower(UserAccount user) {
        Followers.add(user);
    }

    public void notifyUserOfMessage() {
        this.hasUnreadMessages = true;
    }


    public void notiftyUserOfFollowerUpdate() {
        this.hasUnopenedUpdates = true;
    }

    public void notifyFollowers() {
        for (UserAccount follower : Followers) {
            follower.notiftyUserOfFollowerUpdate();
        }
    }

    public Chat getChatWithUser(UserAccount user) {
    	Chat result = null;
    	
    	for(Chat chat : this.ChatsInitiated) {
    		if(chat.isParticipant(user)) {
    			result = chat;
    			break;
    		}
    	}
    	return result;
    }
    public void viewChats() {
    	this.hasUnreadMessages = false;
    	//implement view here.
        int i=0;
        int getThisPt=0;
        Message m1;
        for(Chat getChat:ChatsInitiated)
        {
          if(getChat.getFirstParticipant().Name==this.Name)
          {
             getThisPt=1;
          }
          else if(getChat.getSecoundParticipant().Name==this.Name)
          {
              getThisPt=2;
          }
          if(getThisPt==1)
          {
              OLX.terminal.println(i + "- " + getChat.getSecoundParticipant().Name);
          }
          else if(getThisPt==2)
          {
               OLX.terminal.println(i + "- " + getChat.getFirstParticipant().Name);
          
          }
          OLX.terminal.println(getChat.getLatestMessage());
          OLX.terminal.println(getChat.getTimeOfLatestMessage());
          i++;
        }
      
    }

    public void viewFollowerAds() {
        this.hasUnopenedUpdates = false;
        //implement view here.
    }

    public void printPublishedAds(){
    	for(Advertisement ad : published) {
    		ad.viewAdvertisement();
    	}
    }

    public void viewUserProfile() {
    	//implement view user functionality here.
    }
    public void createAdvertisement() {

        String title = textIO.newStringInputReader().withMinLength(1).read("Title");
        int price = textIO.newIntInputReader().read("Price");

        String description = textIO.newStringInputReader().withMinLength(1).read("Description");

        OLX.terminal.println("Press 1 for Electronics");
        OLX.terminal.println("Press 2 for House");
        OLX.terminal.println("Press 3 for Jobs");
        OLX.terminal.println("Press 4 for Mobile");
        OLX.terminal.println("Press 5 for Pets");
        OLX.terminal.println("Press 6 for Property");
        OLX.terminal.println("Press 7 for Vehicle");


        //taking user input


        int inserted = textIO.newIntInputReader().withMaxVal(7).read("Enter Your Option");
        switch (inserted) {
            case 1:
                Electronics e;
                String make = textIO.newStringInputReader().withMinLength(1).read("Make");
                Condition cond = textIO.newEnumInputReader(Condition.class).read("Condition");
                e = new Electronics(title, price, description, this.loc, this, cond, make);
                OLX.getInstance().addAdvertisement(e);
                this.published.add(e);
                OLX.DBCON.insertAdvertisementElectronics(e.getCreator().getEmail(),
                		e.getTittle(), e.getPrice(), e.getDescription(), e.getStatus().name(), Categories.Electronic.name(), e.getCondition().name(), e.getMake());
                break;
            case 2:
                int b = textIO.newIntInputReader().read("No of Bedrooms");
                int b1 = textIO.newIntInputReader().read("No of Bathrooms");
                int a = textIO.newIntInputReader().read("Area Units");
                PropertyType Prop = textIO.newEnumInputReader(PropertyType.class).read("Property Type");
                House h;

                h = new House(title, price, description, this.loc, this, a,Prop, b, b1);
                OLX.getInstance().addAdvertisement(h);
                this.published.add(h);
                OLX.DBCON.insertAdvertisementHouse(h.getCreator().getEmail(), h.getTittle(), h.getPrice(), h.getDescription(),
                		h.getStatus().name(), Categories.House.name(), h.getNoOfBedrooms(), h.getNoOfBathrooms());
                break;

            case 3:
                Jobs j;
                int n = textIO.newIntInputReader().read("No of Positions");
                String cn = textIO.newStringInputReader().withMinLength(1).read("Company Name");
                String d = textIO.newStringInputReader().withMinLength(1).read("Description");
                j = new Jobs(title, price, description, this.loc, this, n, cn, d);
                OLX.getInstance().addAdvertisement(j);
                this.published.add(j);
                break;

            case 4:
                Mobile m;
                String make1 = textIO.newStringInputReader().withMinLength(1).read("Make");
                Condition cond1 = textIO.newEnumInputReader(Condition.class).read("Condition");

                m = new Mobile(title, price, description, this.loc, this, make1, cond1);
                OLX.getInstance().addAdvertisement(m);
                this.published.add(m);
                break;

            case 5:
                Pets p;
                String breed = textIO.newStringInputReader().withMinLength(1).read("Breed");
                p = new Pets(title, price, description, this.loc, this, breed);
                OLX.getInstance().addAdvertisement(p);
                this.published.add(p);
                break;
            case 6:
                Property pr;
                int a1 = textIO.newIntInputReader().read("Area Units");
                PropertyType Prop1= textIO.newEnumInputReader(PropertyType.class).read("Property Type");

                pr = new Property(title, price, description, this.loc, this, a1, Prop1);
                OLX.getInstance().addAdvertisement(pr);
                this.published.add(pr);
                break;
            case 7:
                Vehicle v;

                String make2 = textIO.newStringInputReader().withMinLength(1).read("Make");
                Condition cond2 = textIO.newEnumInputReader(Condition.class).read("Condition");
                int y = textIO.newIntInputReader().read("Year");
                Fuel f = textIO.newEnumInputReader(Fuel.class).read("Fuel");
                float km = textIO.newFloatInputReader().read("KiloMeter Driven");
                Date d1 = new Date(12 - 13 - 2010);


                v = new Vehicle(title, price, description, this.loc, this, make2, y, cond2, d1, f, km);
                OLX.getInstance().addAdvertisement(v);
                this.published.add(v);
                break;
            default:
                break;

        }

    }

    public void viewProfile(){

        OLX.terminal.println("Name : " + this.Name);
        OLX.terminal.println("Join Date : " + this.JoinDate);
        OLX.terminal.println("Email : " + this.Email);
        OLX.terminal.println("Phone Number : " + this.PhoneNumber);
        OLX.terminal.println("Password : " + this.Password);
        OLX.terminal.println("Location : " + this.loc);
        OLX.terminal.println("Has Unread Messages : " + this.hasUnreadMessages);
        OLX.terminal.println("Has Unopened Updates : " + this.hasUnopenedUpdates);


    }
}