package miniTwitter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


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
        // TODO Auto-generated method stub
        return groupID;
    }

    @Override
    public List<Message> getMessages() {
        List<Message> allMessages = new ArrayList<>();
        for (NodeObject object: objects) {
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
        objects.add(o);
    }

    @Override
    public void addMessage(Message message) {}
    
    @Override
    public String toString() {
        return groupID;
    } 
}
