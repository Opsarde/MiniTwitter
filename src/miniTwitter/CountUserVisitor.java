package miniTwitter;

public class CountUserVisitor implements Visitor {

    private int count;

    @Override
    public void visitUser(User user) {
        count++;
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
