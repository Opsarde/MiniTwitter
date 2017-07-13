package miniTwitter;

import java.util.List;

import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.MutableTreeNode;

public interface NodeObject {
    public String getID();
    public List<Message> getMessages();
    public List<NodeObject> getChildren();
    public void addNodeObject(NodeObject o);
    public void addMessage(Message message);
    public String toString();
}