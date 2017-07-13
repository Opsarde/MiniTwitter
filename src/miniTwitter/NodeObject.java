package miniTwitter;

import java.util.List;

// Component interface
// 
public interface NodeObject {
    public String getID();
    public List<Message> getMessages();
    public List<NodeObject> getChildren();
    public void addNodeObject(NodeObject o);
    public void addMessage(Message message);
    public User findUser(String s);
    public String toString();
}