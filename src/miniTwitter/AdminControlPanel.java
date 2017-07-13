package miniTwitter;

import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.*;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;

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
//    private TextButtonPanel userIDPanel;
//    private TextButtonPanel groupIDPanel;
//    private JButton openViewButton;
//    private UtilityPanel utilityPanel;
    
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
                    addToTree(new User(name));
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
                    addToTree(new Group(name));
            }
        });
        textButtonArea.add(groupPanel);
        rightPanel.add(textButtonArea);

        // open view button
        openView = new JButton("Open User View");
        openView.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                OpenViewFrame newWindow = new OpenViewFrame(treePanel.getSelectedObject().getID());
            }
        });
        rightPanel.add(openView);
        
        // four utility button
        utility = new FourButtonPanel(new GridLayout(2, 2));
        rightPanel.add(utility);

        add(rightPanel);
    }

    private void addToTree(NodeObject o) {
        DefaultTreeModel model = treePanel.getModel();
        DefaultMutableTreeNode root = treePanel.getRoot();
        root.add(new DefaultMutableTreeNode(o));
        model.nodesWereInserted(treePanel.getRoot(), new int[] {root.getChildCount() - 1});
    }
    
    public TextButtonPanel getUserPanel() {
        return userPanel;
    }

    public void setUserPanel(TextButtonPanel userPanel) {
        this.userPanel = userPanel;
    }

    public TextButtonPanel getGroupPanel() {
        return groupPanel;
    }

    public void setGroupPanel(TextButtonPanel groupPanel) {
        this.groupPanel = groupPanel;
    }
}
