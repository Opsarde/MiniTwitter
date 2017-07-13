package miniTwitter;

import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;

public class OpenViewFrame extends JFrame {
    
    public OpenViewFrame(String name) {
        super(name);
        JPanel mainPanel = new JPanel(new GridLayout(2, 1));
        
        JPanel subPanel1 = new JPanel(new GridLayout(2, 1));
        subPanel1.add(new TextButtonPanel("Follow User"));
        JTextPane followUserPanel = new JTextPane();
        JScrollPane scrollPanel1 = new JScrollPane(followUserPanel);
        subPanel1.add(scrollPanel1);
        
        JPanel subPanel2 = new JPanel(new GridLayout(2, 1));
        subPanel2.add(new TextButtonPanel("Post Tweet"));
        JTextPane tweetPanel = new JTextPane();
        JScrollPane scrollPane2 = new JScrollPane(tweetPanel);
        subPanel2.add(scrollPane2);
        
        mainPanel.add(subPanel1);
        mainPanel.add(subPanel2);
        //TODO
        //make the textPanel not writable
        
        add(mainPanel);

        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        pack();
        setLocationRelativeTo(getRootPane());
        setVisible(true);
    }

}
