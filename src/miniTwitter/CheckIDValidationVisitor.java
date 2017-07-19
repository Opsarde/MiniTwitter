package miniTwitter;

import java.util.ArrayList;
import java.util.List;

public class CheckIDValidationVisitor implements Visitor {

    //List of IDs(NodeObject) that are not valid
    private List<NodeObject> objects;
    
    public CheckIDValidationVisitor() {
        objects = new ArrayList<>();
    }
    
    @Override
    public void visitUser(User user) {
//        if (!user.isValid()) {
//            IDs.add(user);
//        }
        checkID(user);
    }

    @Override
    public void visitGroup(Group group) {
        for (NodeObject o : group.getChildren()) {
            if (o instanceof Group) {
                visitGroup((Group) o);
                //checkID(o);
            }
            checkID(o);
        }
    }

    private void checkID(NodeObject o) {
        if (!o.isValid()) {
            objects.add(o);
        }
    }
    
    public List<NodeObject> getInvalidObject() {
        return objects;
    }
    
    public String InvalidObjectAsString() {
        String s = (objects.isEmpty()) ? "All IDs are valid!" : "Invalid IDs:\n";
        for (NodeObject o : objects) {
            s += o + "\n";
        }
        return s;
    }
    
    @Override
    public String toString() {
        return this.InvalidObjectAsString();
    }

    @Override
    public void reset() {
        objects.clear();
    }
}
