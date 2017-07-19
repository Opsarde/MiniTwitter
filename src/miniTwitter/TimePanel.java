package miniTwitter;

import java.awt.GridLayout;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class TimePanel extends JPanel implements Observer {

    private JLabel lastUpdateTime;
    private JLabel creationTime;
    
    public TimePanel(User user) {
        super(new GridLayout(2, 1));
        //The UI might be too big for time label since I
        //used GridLayout
        creationTime = new JLabel("Time created: " + new java.util.Date(user.getCreationTime()));
        lastUpdateTime = new JLabel("Last time updated: " + new java.util.Date(user.getLastUpdateTime()));
        add(creationTime);
        add(lastUpdateTime);
        user.addObserver(this);
    }

    @Override
    public void update(Observable o, Object arg) {
        if (arg instanceof User) {
            long temp = ((User) arg).getLastUpdateTime();
            lastUpdateTime.setText("Last time updated: " + new java.util.Date(temp)); 
        }
    }

}
