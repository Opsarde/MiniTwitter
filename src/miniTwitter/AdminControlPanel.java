package miniTwitter;

import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.List;

import javax.swing.*;

/**
 * Class: AdminControlPanel
 * Description: Panel starts with 
 * 1 by 2 layout.
 * 
 * @author shun
 */
public class AdminControlPanel extends JPanel {
    private JPanel treePanel;
    private JTextField userID, groupID;
    private JButton addUser, addGroup;
    private JButton openView;
    private JButton utility;
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
        textButtonArea.add(new TextButtonPanel("Add User"));
        textButtonArea.add(new TextButtonPanel("Add Group"));
        rightPanel.add(textButtonArea);
        rightPanel.add(new JButton("Open User View"));
        rightPanel.add(new FourButtonPanel(new GridLayout(2, 2)));

        add(rightPanel);
        //addButtonPanel();
//        buttonPanels.add(new ButtonPanel(new GridLayout(2, 2)));
//        buttonPanels.get(0).addButton(new JButton("User ID"));
//        buttonPanels.get(0).addButton(new JButton("Add User"));
//        buttonPanels.get(0).addButton(new JButton("Group ID"));
//        buttonPanels.get(0).addButton(new JButton("Add Group"));
//        buttonPanels.add(new ButtonPanel(new GridLayout(0, 1)));
//        buttonPanels.get(1).addButton(new JButton("Open User View"));
//        buttonPanels.add(new ButtonPanel(new GridLayout(2, 2)));
//        buttonPanels.get(2).addButton(new JButton("Show User Total"));
//        buttonPanels.get(2).addButton(new JButton("Show Group Total"));
//        buttonPanels.get(2).addButton(new JButton("Show Messages Total"));
//        buttonPanels.get(2).addButton(new JButton("Show Positive Percentage"));
//        for (ButtonPanel bp : buttonPanels) {
//            rightPanel.add(bp);
//        }

    }
}
