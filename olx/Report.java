package olx;

public class Report {
    String content;
    String category;
    Status status;
    UserAccount account;

    public Report(String content, String category, Status status, UserAccount account) {
        this.content = content;
        this.category = category;
        this.status = status;
        this.account = account;
    }
}
