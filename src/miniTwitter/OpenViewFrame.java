package miniTwitter;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextPane;

/**
 * Class: OpenViewFrame
 * Description: User View window initialized
 * with four functional panels.
 * 
 * @author shun
 */
public class OpenViewFrame extends JFrame implements Observer {
    private TextButtonPanel followTextAndButton;
    private TextButtonPanel tweetTextAndButton;
    private JTextArea followUserPanel;
    private JTextArea tweetPanel;
    
    public OpenViewFrame(User user) {
        super(user.getID());
        JPanel mainPanel = new JPanel(new GridLayout(2, 1));
        
        JPanel subPanel1 = new JPanel(new GridLayout(2, 1));
        followTextAndButton = new TextButtonPanel("Follow User");
        subPanel1.add(followTextAndButton);
        //JTextPane followUserPanel = new JTextPane();
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
                }
                //This line will be updated in observer method
                //followUserPanel.setText(user.getFollowingUsers().toString());
                followUserPanel.setText(user.getFollowingUsers().toString());
            }
        });
        
        JPanel subPanel2 = new JPanel(new GridLayout(2, 1));
        tweetTextAndButton = new TextButtonPanel("Post Tweet");
        subPanel2.add(tweetTextAndButton);
        //JTextPane tweetPanel = new JTextPane();
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
                // should be included in update()
                //tweetPanel.setText(user.getMessages().toString());
                tweetPanel.setText(user.getMessages().toString());
            }
        });
        
        mainPanel.add(subPanel1);
        mainPanel.add(subPanel2);
        
        add(mainPanel);

        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        pack();
        setLocationRelativeTo(getRootPane());
        setVisible(true);
    }

    @Override
    public void update(Observable o, Object arg) {
        // TODO Auto-generated method stub
        
    }

}
