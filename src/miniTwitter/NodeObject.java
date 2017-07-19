package miniTwitter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

import javax.swing.tree.DefaultMutableTreeNode;

/**
 * Component interface
 * Interface: NodeObject
 * Purpose: groups User and Group into a
 * general interface that user can use.
 * Currently, one is not be able to add duplicate IDs
 * into the tree or root. Since both user and group share 
 * a common list UsedIDs, both are inclusive for duplication check.
 */

 
public interface NodeObject {
    public static final long FIRST_CREATION_TIME = System.currentTimeMillis();
    public static List<String> usedIDs = new ArrayList<>(Arrays.asList("Root"));
    public String getID();
    public List<Message> getMessages();
    public String getMessagesAsString();
    public List<NodeObject> getChildren();
    public boolean addNodeObject(NodeObject o);
    public void addMessage(Message message);
    public void addFollower(User follower);
    public void addFollowingUser(User followingUser);
    public Set<User> getFollowers();
    public Set<User> getFollowingUsers();
    public String getFollowingUsersAsString();
    public List<User> getAllUsers();
    public DefaultMutableTreeNode getNode();
    public NodeObject getRoot();
    public boolean isValid();
    public long getCreationTime();
    public long getLastUpdateTime();
    public void accept(Visitor vis);
    public String toString();
}