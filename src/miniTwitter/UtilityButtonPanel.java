package miniTwitter;

import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 * ButtonPanel
 * Description: Contains buttons
 * with each button utility.
 * One can add some new buttons to
 * this panel, then it will not get
 * called FourButtonPanel.
 * 
 * @author shun
 */
public class UtilityButtonPanel extends JPanel {

    private List<JButton> buttons;
    private NodeObject root;

    public UtilityButtonPanel(LayoutManager layout, NodeObject root) {
        super(layout);
        buttons = new ArrayList<>();
        this.root = root;
        
        addButton(new JButton("Show User Total"), new CountUserVisitor());
        addButton(new JButton("Show Group Total"), new CountGroupVisitor());
        addButton(new JButton("Show Messages Total"), new CountMessageVisitor());
        addButton(new JButton("Show Positive Percentage"), new PositivePercentageVisitor());
        addButton(new JButton("Display ID Verification"), new CheckIDValidationVisitor());
        addButton(new JButton("Show Last Update User"), new GetLastUpdatedUserVisitor());
    }
    
    public JButton getButton(int index) {
        return buttons.get(index);
    }

    public void addButton(JButton button, Visitor vis) {
        add(button);
        buttons.add(button);
        button.addActionListener(new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent e) {
                root.accept(vis);
                JOptionPane.showMessageDialog(null, vis);
                vis.reset();
            }
        });
    }
}
