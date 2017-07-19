package miniTwitter;

public class GetLastUpdatedUserVisitor implements Visitor {

    private User lastUpdatedUser;
    
    @Override
    public void visitUser(User user) {
        if (lastUpdatedUser == null) {
            lastUpdatedUser = user;
        }
        else {
            if (user.getLastUpdateTime() > lastUpdatedUser.getLastUpdateTime()) {
                lastUpdatedUser = user;
            }
        }
    }

    @Override
    public void visitGroup(Group group) {
        for (NodeObject o : group.getChildren()) {
            if (o instanceof User) {
                visitUser((User) o);
            }
            else {
                visitGroup((Group) o);
            }
        }
    }
    
    public User getLastUpdatedUser() {
        return lastUpdatedUser;
    }
    
    @Override
    public String toString() {
        return this.lastUpdatedUser + ", last updated at: " 
                + new java.util.Date(lastUpdatedUser.getLastUpdateTime());
    }

    @Override
    public void reset() {
        lastUpdatedUser = null;
    }
}
