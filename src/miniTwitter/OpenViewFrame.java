package miniTwitter;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

/**
 * Class: OpenViewFrame
 * Description: User View window initialized
 * with four functional panels. Each user will
 * have its own Frame.
 * 
 * @author shun
 */
public class OpenViewFrame extends JFrame implements Observer {
    private TextButtonPanel followTextAndButton;
    private TextButtonPanel tweetTextAndButton;
    private JTextArea followUserPanel;
    private JTextArea tweetPanel;
    private TimePanel timePanel;
    
    public OpenViewFrame(User user) {
        super(user.getID());
        timePanel = new TimePanel(user);
        JPanel mainPanel = new JPanel(new GridLayout(3, 1));

        //initialize top-part panel for user following
        JPanel subPanel1 = new JPanel(new GridLayout(2, 1));
        followTextAndButton = new TextButtonPanel("Follow User");
        subPanel1.add(followTextAndButton);
        followUserPanel = new JTextArea(5, 20);
        followUserPanel.setEditable(false);
        followUserPanel.setLineWrap(true);
        JScrollPane scrollPanel1 = new JScrollPane(followUserPanel);
        subPanel1.add(scrollPanel1);
        followTextAndButton.getButton().addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                String id = followTextAndButton.getField().getText();
                List<User> availableUsers = user.getRoot().getAllUsers();
                User following = null;
                for (User person : availableUsers) {
                    if (person.getID().equals(id)) {
                        following = person;
                    }
                }
                if (following != null && !following.getID().equals(user.getID())) {
                    user.addFollowingUser(following);
                    following.addFollower(user);
                }
            }
        });
        
        //initialize down-part panel for message posting
        JPanel subPanel2 = new JPanel(new GridLayout(2, 1));
        tweetTextAndButton = new TextButtonPanel("Post Tweet");
        subPanel2.add(tweetTextAndButton);
        tweetPanel = new JTextArea(5, 20);
        tweetPanel.setEditable(false);
        tweetPanel.setLineWrap(true);
        JScrollPane scrollPanel2 = new JScrollPane(tweetPanel);
        subPanel2.add(scrollPanel2);
        tweetTextAndButton.getButton().addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                String msg = tweetTextAndButton.getField().getText();
                user.addMessage(new UserMessage(msg, user));
                for (User followers : user.getFollowers()) {
                    followers.addMessage(new UserMessage(msg, user));
                }
            }
        });

        followUserPanel.setText(user.getFollowingUsersAsString()); 
        tweetPanel.setText(user.getMessagesAsString());

        mainPanel.add(subPanel1);
        mainPanel.add(subPanel2);
        mainPanel.add(new TimePanel(user));
        add(mainPanel);

        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        pack();
        setLocationRelativeTo(getRootPane());
        setVisible(true);
    }

    //Updates the user view when there is change in user
    @Override
    public void update(Observable o, Object arg) {
        if (arg instanceof User) {
            followUserPanel.setText(((User) arg).getFollowingUsersAsString()); 
            tweetPanel.setText(((User) arg).getMessagesAsString());
        }
    }
}
