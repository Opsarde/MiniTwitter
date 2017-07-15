package miniTwitter;

public class UserMessage extends Message {
    
    User user;

    public UserMessage(String words, User user) {
        this.words = words;
        this.user = user;
    }
    
    @Override
    public String toString() {
        return user.getID() + ": " + words;
    }
}
