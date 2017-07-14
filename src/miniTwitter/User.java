package miniTwitter;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Observable;
import java.util.Set;

import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;

/**
 * Class: User
 * Description: A user contains ID and list of followers
 * (followers are also users).  Also a list of following
 * users.  Ultimately, it contains list of messages(followers)
 * 
 * @author shun
 */
public class User extends Observable implements NodeObject {
    private DefaultMutableTreeNode node;
    private String userID;
    private Set<User> followers;
    private Set<User> followingUsers;
    private List<Message> messages;

    public User(String userID) {
        this.userID = userID;
        followers = new HashSet<>();
        followingUsers = new HashSet<>();
        messages = new ArrayList<>();
        node = new DefaultMutableTreeNode(this);
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
    public boolean addNodeObject(NodeObject o) {return false;}

    @Override
    public void addMessage(Message message) {
        this.messages.add(message);
    }
    
    @Override
    public void addFollower(User follower) {
        followers.add(follower);
    }
    
    @Override
    public void addFollowingUser(User followingUser) {
        followingUsers.add(followingUser);
    }
    
    @Override
    public String toString() {
        return "User: " + userID;
    }

    @Override
    public List<User> getAllUsers() {return null;}

    @Override
    public Set<User> getFollowers() {
        return followers;
    }

    @Override
    public Set<User> getFollowingUsers() {
        return followingUsers;
    }
    @Override
    public DefaultMutableTreeNode getNode() {
        return this.node;
    }
}
