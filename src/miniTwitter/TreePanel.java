package miniTwitter;

import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.List;

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
import javax.swing.tree.TreePath;

/**
 * Left side panel contains
 * User and Group tree.
 * (when a user or a group added,
 * it also adds to Group root?)
 * 
 * @author shun
 */
public class TreePanel extends JPanel {
    
    private NodeObject root;
    // A list that holds used ID for comparing new ID
    // (Question: Should it be a property in Group class?)
    private List<String> usedIDs;
    private JTree tree;
    private DefaultMutableTreeNode selectedNode;
    private DefaultMutableTreeNode selectedNodeGroup;
    
    public TreePanel() {
        super();
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        //Create a default NodeObject root
        //Also add it to a TreeNode for display and to usedID
        root = new Group("Root");
        //DefaultMutableTreeNode treeRoot = new DefaultMutableTreeNode(root);
        usedIDs = new ArrayList<>();
        usedIDs.add("Root");
        selectedNodeGroup = root.getNode();
        tree = new JTree(root.getNode());

        //hardcode simplified
        add(new User("John"));
        add(new User("Bob"));
        add(new User("Steve"));
        add(new Group("CS356"));
        
        tree.addTreeSelectionListener(new TreeSelectionListener() {
            //get selectedNode and its parent
            @Override
            public void valueChanged(TreeSelectionEvent e) {
                DefaultMutableTreeNode node = (DefaultMutableTreeNode)
                        tree.getLastSelectedPathComponent();
                
                if (node == null) return;
                
                selectedNode = node;
                // Also needs a parent
                if (node.getUserObject() instanceof User) {
                    selectedNodeGroup = (DefaultMutableTreeNode) node.getParent();
                }
                else {
                    selectedNodeGroup = node;
                }
            }
        });

        JScrollPane treeView = new JScrollPane(tree);
        JLabel viewLabel = new JLabel("TreeView: ");
        add(viewLabel);
        add(treeView);
    }
    
    public NodeObject getSelectedObject() {
        return (NodeObject) selectedNode.getUserObject();
    }
    
    //Add Object to the tree and to the NodeObject root
    public void add(NodeObject o) {
        DefaultMutableTreeNode newNode = new DefaultMutableTreeNode(o);
        DefaultTreeModel model = (DefaultTreeModel) tree.getModel();
        
        //DEBUGGING MESSAGE
        System.out.println(root.getChildren());
        System.out.println(root.getAllUsers());
        
        if (!isExisted(o)) {
            ((NodeObject) selectedNodeGroup.getUserObject()).addNodeObject(o);
            model.nodesWereInserted(selectedNodeGroup, new int[] {selectedNodeGroup.getChildCount() - 1});
            usedIDs.add(o.getID());
            tree.scrollPathToVisible(new TreePath(o.getNode().getPath()));

        }
    }

    private boolean isExisted(NodeObject o) {
        for (String id : usedIDs) {
            if (o.getID().equals(id)) {
                return true;
            }
        }
        return false;
    }

    public NodeObject getRoot() {
        return root;
    }

    public DefaultTreeModel getModel() {
        return (DefaultTreeModel) tree.getModel();
    }
}