package miniTwitter;

import java.util.List;

/**
 * Class: User
 * Description: A user contains ID and list of followers
 * (followers are also users).  Also a list of following
 * users.  Ultimately, it contains list of messages(followers)
 * 
 * @author shun
 */
public class User {
    private String userID;
    private List<User> followers;
    private List<User> followingUsers;
    private List<Message> messages;


}
