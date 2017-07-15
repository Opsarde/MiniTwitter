package miniTwitter;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

/**
 * Class: AdminControlPanel
 * Description: Panel starts with 
 * 1 by 2 layout.
 * 
 * @author shun
 */
public class AdminControlPanel extends JPanel {
    private TreePanel treePanel;
    private TextButtonPanel userPanel, groupPanel;
    private JButton openView;
    private FourButtonPanel utility;
    private JPanel rightPanel;
    
    public AdminControlPanel() {
        super(new GridLayout(1, 2));
        treePanel = new TreePanel();
        add(treePanel);
        rightPanel = new JPanel(new GridLayout(3, 1));
        JPanel textButtonArea = new JPanel(new GridLayout(2, 1));
        
        // add user row
        userPanel = new TextButtonPanel("Add User");
        //When clicking add user button:
        userPanel.getButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //add user to the tree and to root group
                String name = userPanel.getField().getText();
                if (!name.isEmpty())
                    treePanel.add(new User(name));
            }
        });
        textButtonArea.add(userPanel);
        
        // add group row
        groupPanel = new TextButtonPanel("Add Group");
        groupPanel.getButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = groupPanel.getField().getText();
                if (!name.isEmpty())
                    //addToTree(new Group(name));
                    treePanel.add(new Group(name));
            }
        });
        textButtonArea.add(groupPanel);

        rightPanel.add(textButtonArea);

        // open view button
        openView = new JButton("Open User View");
        openView.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                NodeObject selected = treePanel.getSelectedObject();
                if (selected != null && selected instanceof User) {
                    User user = (User) selected;
                    OpenViewFrame newWindow = new OpenViewFrame(user);
                    user.addObserver(newWindow);
                }
            }
        });
        rightPanel.add(openView);
        
        // four utility button
        utility = new FourButtonPanel(new GridLayout(2, 2), treePanel.getRoot());
        rightPanel.add(utility);

        add(rightPanel);
    }
}
