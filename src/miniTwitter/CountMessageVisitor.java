package miniTwitter;

public class CountMessageVisitor implements Visitor {

    // Also counts repeated message in each user's
    // feedlist.
    private int count;

    @Override
    public void visitUser(User user) {
        count += user.getMessages().size();
    }

    @Override
    public void visitGroup(Group group) {
        for (NodeObject o : group.getChildren()) {
            if (o instanceof User) {
                visitUser((User) o);
            }
            else if (o instanceof Group) {
                visitGroup((Group) o);
            }
        }
    }
    
    public int getCount() {
        return count;
    }
    
    @Override
    public String toString() {
        return "Count: " + this.getCount();
    }

    @Override
    public void reset() {
        count = 0;
    }
}
