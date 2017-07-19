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
    private UtilityButtonPanel utility;
    private JPanel rightPanel;
    
    public AdminControlPanel() {
        super(new GridLayout(1, 2));
        treePanel = new TreePanel();
        add(treePanel);
        rightPanel = new JPanel(new GridLayout(3, 1));
        JPanel textButtonArea = new JPanel(new GridLayout(2, 1));
        
        // One cannot add usedIDs into the tree
        
        // add user row
        userPanel = new TextButtonPanel("Add User");
        userPanel.getButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //add user to the tree
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
                //add group to the tree
                String name = groupPanel.getField().getText();
                if (!name.isEmpty())
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
        // After update, it will be six buttons
        utility = new UtilityButtonPanel(new GridLayout(3, 2), treePanel.getRoot());
        rightPanel.add(utility);

        add(rightPanel);
    }
}
