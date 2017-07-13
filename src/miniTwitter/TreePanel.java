package miniTwitter;

import java.awt.GridLayout;

import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTree;
import javax.swing.SwingConstants;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.text.AbstractDocument.LeafElement;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
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
    
    //private DefaultMutableTreeNode root;
    private JTree tree;
    private NodeObject selectedNode;
    private DefaultMutableTreeNode selectedNodeGroup;
    
    public TreePanel() {
        super();
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
//        DefaultMutableTreeNode root = new DefaultMutableTreeNode(new Group("Root"));
//        //add the root child into roottest?
//        root.add(new DefaultMutableTreeNode(""));
//        root.add(new DefaultMutableTreeNode(""));
//        root.add(new DefaultMutableTreeNode(""));
//        root.add(new DefaultMutableTreeNode(""));
//        root.add(new DefaultMutableTreeNode(""));
        DefaultMutableTreeNode root = new DefaultMutableTreeNode(new Group("Root"));
        
        // some hard-coded nodes
        // they are not stored
        DefaultMutableTreeNode john = new DefaultMutableTreeNode(new User("John"));
        DefaultMutableTreeNode bob = new DefaultMutableTreeNode(new User("Bob")); 
        DefaultMutableTreeNode steve = new DefaultMutableTreeNode(new User("Steve")); 
        DefaultMutableTreeNode cs356 = new DefaultMutableTreeNode(new Group("CS356")); 
        root.add(john);
        cs356.add(steve);
        root.add(cs356);
        root.add(bob);
        
        tree = new JTree(root);
        tree.addTreeSelectionListener(new TreeSelectionListener() {
            @Override
            public void valueChanged(TreeSelectionEvent e) {
                // TODO Auto-generated method stub
                DefaultMutableTreeNode node = (DefaultMutableTreeNode)
                        tree.getLastSelectedPathComponent();
                
                if (node == null) return;
                
                selectedNode = (NodeObject) node.getUserObject();
                // Also needs a parent
                if (node.getUserObject() instanceof User)
                    selectedNodeGroup = (DefaultMutableTreeNode) node.getParent();
                else
                    selectedNodeGroup = node;
            }
        });

        JScrollPane treeView = new JScrollPane(tree);
        JLabel viewLabel = new JLabel("TreeView: ");
        add(viewLabel);
        add(treeView);
        //expand by default
        expandAllNodes(tree, 0, tree.getRowCount());
    }
    
    public NodeObject getSelectedObject() {
        return selectedNode;
    }
    
    //Copied from stackoverflow
    private void expandAllNodes(JTree tree, int startingIndex, int rowCount){
        for(int i=startingIndex;i<rowCount;++i){
            tree.expandRow(i);
        }

        if(tree.getRowCount()!=rowCount){
            expandAllNodes(tree, rowCount, tree.getRowCount());
        }
    }
    
    public void add(NodeObject o) {
        DefaultMutableTreeNode newNode = new DefaultMutableTreeNode(o);
        DefaultTreeModel model = (DefaultTreeModel) tree.getModel();
        //DefaultMutableTreeNode root = (DefaultMutableTreeNode) model.getRoot();
        // TODO: Now it only adds to end of the root
        if (selectedNodeGroup != null) {
            selectedNodeGroup.add(newNode);
            model.nodesWereInserted(selectedNodeGroup, new int[] {selectedNodeGroup.getChildCount() - 1});
        }
    }
    
    public DefaultMutableTreeNode getRoot() {
        DefaultMutableTreeNode root = (DefaultMutableTreeNode) tree.getModel().getRoot();
        return root;
    }

    public DefaultTreeModel getModel() {
        return (DefaultTreeModel) tree.getModel();
    }
}