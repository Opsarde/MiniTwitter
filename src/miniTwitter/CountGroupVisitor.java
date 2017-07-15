package miniTwitter;

public class CountGroupVisitor implements Visitor {

    /*
     * The root group is not counted
     */
    private int count;

    @Override
    public void visitUser(User user) {
        //do nothing
    }

    @Override
    public void visitGroup(Group group) {
        for (NodeObject o : group.getChildren()) {
            if (o instanceof Group) {
                count++;
                visitGroup((Group) o);
            }
        }
    }
    
    public int getCount() {
        return count;
    }
}
