package miniTwitter;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

/**
 * Class: User
 * Description: A user contains ID and list of followers
 * (followers are also users).  Also a list of following
 * users.  Ultimately, it contains list of messages(followers)
 * 
 * @author shun
 */
public class User extends Observable implements NodeObject {
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
    public User findUser(String s) {
        if (s.equals(this.userID))
            return this;
        return null;
    }
    
    public void addFollower(User follower) {
        followers.add(follower);
    }
    
    public void addFollowingUser(User followingUser) {
        followingUsers.add(followingUser);
    }
    
    @Override
    public String toString() {
        return "User: " + userID;
    }
}
