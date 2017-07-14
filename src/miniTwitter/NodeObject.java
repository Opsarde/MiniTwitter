package miniTwitter;

import java.util.List;

import javax.swing.JTree;

// Component interface
// 
public interface NodeObject {
    public String getID();
    public List<Message> getMessages();
    public List<NodeObject> getChildren();
    public void addNodeObject(NodeObject o);
    public void addMessage(Message message);
    public void addFollower(User follower);
    public void addFollowingUser(User followingUser);
    public List<User> getAllUsers();
    public JTree getTreeView();
    public String toString();
}