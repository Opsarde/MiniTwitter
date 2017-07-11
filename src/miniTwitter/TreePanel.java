package miniTwitter;

import java.awt.GridLayout;

import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreeNode;

/**
 * Left side panel contains
 * User and Group tree.
 * (Note that it uses observer pattern)
 * (when a user or a group added)
 * 
 * @author shun
 */
public class TreePanel extends JPanel {
    
    private Group root;
    private DefaultMutableTreeNode roottest;
    private JTree tree;
    
    
    public TreePanel() {
        super(new GridLayout(1, 0));
        roottest = new DefaultMutableTreeNode("Budgie");
        roottest.add(new DefaultMutableTreeNode("Cute"));
        roottest.add(new DefaultMutableTreeNode("Baby"));
        roottest.add(new DefaultMutableTreeNode("Bird"));
        roottest.add(new DefaultMutableTreeNode("Padding"));
        roottest.add(new DefaultMutableTreeNode("Nice"));
        
        tree = new JTree(roottest);
        JScrollPane treeView = new JScrollPane(tree);
        add(treeView);
    }

}
