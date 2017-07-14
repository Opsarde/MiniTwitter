package miniTwitter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;


/**
 * Class: Group
 * Description:
 * Contains Users and groups, no same user
 * in different groups.  Has group root as
 * default. I think this is the composite
 * class.
 * 
 * @author shun
 */
public class Group implements NodeObject {
    private String groupID;
    private List<NodeObject> objects;
    //private List<User> users;
    //private List<Group> groups;

    public Group(String groupID) {
        this.groupID = groupID;
        objects = new ArrayList<>();
    }

    @Override
    public String getID() {
        return groupID;
    }

    @Override
    public List<Message> getMessages() {
        List<Message> allMessages = new ArrayList<>();
        for (NodeObject object : objects) {
            allMessages.addAll(object.getMessages());
        }
        return allMessages;
    }

    @Override
    public List<NodeObject> getChildren() {
        return objects;
    }
    
    @Override
    public void addNodeObject(NodeObject o) {
        if (!hasObject(o)) {
            objects.add(o);
        }
    }
    
    private boolean hasObject(NodeObject o) {
        for (NodeObject object : objects) {
            if (o.getID() == object.getID()) {
                return true;
            }
            
            if (object instanceof Group) {
                Group group = (Group) object;
                return group.hasObject(o);
            }
        }
        return false;
    }

    @Override
    public void addMessage(Message message) {}
    
    @Override
    public String toString() {
        return "Group: " + groupID;
    }

    @Override
    public void addFollower(User follower) {}

    @Override
    public void addFollowingUser(User followingUser) {}

    //still testing this function
    @Override
    public List<User> getAllUsers() {
        List<User> users = new ArrayList<>();
        for (NodeObject o : objects) {
            if (o instanceof User) {
                users.add((User) o);
            }
            else {
                users.addAll(o.getAllUsers());
            }
        }
        return users;
    } 
    
    public JTree getTreeView() {
        JTree tree = new JTree(this.toDefaultMutableTreeNode());
        return tree;
    }
    
    private DefaultMutableTreeNode toDefaultMutableTreeNode() {
        DefaultMutableTreeNode node = new DefaultMutableTreeNode(this);
        for (NodeObject o : objects) {
            if (o instanceof User) {
                node.add(new DefaultMutableTreeNode(o));
            }
            else {
                Group group = (Group) o;
                node.add(group.toDefaultMutableTreeNode());
            }
        }
        return node;
    }

    @Override
    public Set<User> getFollowers() {return null;}

    @Override
    public Set<User> getFollowingUsers() {return null;}
}
