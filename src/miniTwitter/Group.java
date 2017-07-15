package miniTwitter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Observable;
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
    private DefaultMutableTreeNode node;
    private String groupID;
    private List<NodeObject> objects;

    public Group(String groupID) {
        this.groupID = groupID;
        objects = new ArrayList<>();
        node = new DefaultMutableTreeNode(this);
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
    public boolean addNodeObject(NodeObject o) {
        if (!hasObject(o)) {
            objects.add(o);
            node.add(o.getNode());
            System.out.println(NodeObject.usedIDs);
            NodeObject.usedIDs.add(o.getID());
            return true;
        }
        return false;
    }
    
    public DefaultMutableTreeNode getNode() {
        return this.node;
    }
    
    private boolean hasObject(NodeObject o) {
        for (String id : NodeObject.usedIDs) {
            if (id.equals(o.getID())) {
                return true;
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
    
    @Override
    public Set<User> getFollowers() {return null;}

    @Override
    public Set<User> getFollowingUsers() {return null;}

    @Override
    public NodeObject getRoot() {
        DefaultMutableTreeNode nodeRoot = (DefaultMutableTreeNode) this.node.getRoot();
        NodeObject root = (NodeObject) nodeRoot.getUserObject();
        return root;
    }

    @Override
    public void accept(Visitor vis) {
        vis.visitGroup(this);
    }
}
