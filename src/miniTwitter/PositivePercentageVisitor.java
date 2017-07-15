package miniTwitter;

public class PositivePercentageVisitor implements Visitor{

    private double totalMessages;
    private double goodMessages;
    
    @Override
    public void visitUser(User user) {
        for(Message msg : user.getMessages()) {
            if (msg.contains("Good", "Great", "Excellent", "Cat")) {
                goodMessages += 1;
            }
            totalMessages += 1;
        }
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
    
    public double getPercent() {
        if (totalMessages == 0) {
            return 0;
        }
        else {
            return Math.round(goodMessages / totalMessages * 100);
        }
    }

}
