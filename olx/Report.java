package olx;

public class Report {
    String content;
    String category;
    String status;
    UserAccount account;

    public Report(String content, String category, String status, UserAccount account) {
        this.content = content;
        this.category = category;
        this.status = status;
        this.account = account;
    }
}
