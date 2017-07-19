package miniTwitter;

/**
 * Interface: Visitor
 * Description: This interface has four inherited
 * classes which are userCount, groupCount, messageCount
 * and positivePercentage operations. 
 * @author shun
 *
 */
public interface Visitor {
    public void visitUser(User user);
    public void visitGroup(Group group);
    public String toString();
    public void reset();
}
