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
 * Description: An Observable User class that contains ID and
 * list of followers. Also a list of following
 * users.  Ultimately, it contains list of messages that acts
 * as newsfeed.  
 * 
 * @author shun
 */
public class User extends Observable implements NodeObject {
    private DefaultMutableTreeNode node;
    private String userID;
    private Set<User> followers;
    private Set<User> followingUsers;
    private List<Message> feedList;

    public User(String userID) {
        this.userID = userID;
        followers = new HashSet<>();
        followingUsers = new HashSet<>();
        feedList = new ArrayList<>();
        node = new DefaultMutableTreeNode(this);
    }
    @Override
    public String getID() {
        return userID;
    }

    @Override
    public List<Message> getMessages() {
        return feedList;
    }

    @Override
    public List<NodeObject> getChildren() {return null;}

    @Override
    public boolean addNodeObject(NodeObject o) {return false;}

    @Override
    public void addMessage(Message message) {
        this.feedList.add(message);
        setChanged();
        notifyObservers(this);
    }
    
    @Override
    public void addFollower(User follower) {
        followers.add(follower);
        setChanged();
        notifyObservers(this);
    }
    
    @Override
    public void addFollowingUser(User followingUser) {
        followingUsers.add(followingUser);
        setChanged();
        notifyObservers(this);
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
    
    @Override
    public NodeObject getRoot() {
        DefaultMutableTreeNode nodeRoot = (DefaultMutableTreeNode) this.node.getRoot();
        NodeObject root = (NodeObject) nodeRoot.getUserObject();
        return root;
    }
    @Override
    public void accept(Visitor vis) {
        vis.visitUser(this);
    }

    
}
