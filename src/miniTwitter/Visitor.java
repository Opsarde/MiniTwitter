package miniTwitter;

public interface Visitor {
    public void visitUser(User user);
    public void visitGroup(Group group);
}
