package miniTwitter;

import java.util.ArrayList;
import java.util.List;

/**
 * Class: User
 * Description: A user contains ID and list of followers
 * (followers are also users).  Also a list of following
 * users.  Ultimately, it contains list of messages(followers)
 * 
 * @author shun
 */
public class User implements NodeObject {
    private String userID;
    private List<User> followers;
    private List<User> followingUsers;
    private List<Message> messages;

    public User(String userID) {
        this.userID = userID;
        followers = new ArrayList<>();
        followingUsers = new ArrayList<>();
        messages = new ArrayList<>();
    }
    @Override
    public String getID() {
        return userID;
    }

    @Override
    public List<Message> getMessages() {
        return messages;
    }

    @Override
    public List<NodeObject> getChildren() {return null;}

    @Override
    public void addNodeObject(NodeObject o) {}

    @Override
    public void addMessage(Message message) {}
    
    @Override
    public String toString() {
        return userID;
    }
}
