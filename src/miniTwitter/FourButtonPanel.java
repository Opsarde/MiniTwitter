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
 * 
 * @author shun
 */
public class FourButtonPanel extends JPanel {

    private List<JButton> buttons;
    private NodeObject root;

    public FourButtonPanel(LayoutManager layout, NodeObject root) {
        super(layout);
        this.root = root;
        buttons = new ArrayList<>();
        addButton(new JButton("Show User Total"));
        addButton(new JButton("Show Group Total"));
        addButton(new JButton("Show Messages Total"));
        addButton(new JButton("Show Positive Percentage"));
        
        //Adding listener for userCount
        buttons.get(0).addActionListener(new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent e) {
                CountUserVisitor userCount = new CountUserVisitor();
                root.accept(userCount);
                JOptionPane.showMessageDialog(null, "Count: " + userCount.getCount());
            }
        });
        
        //Adding listener for groupCount
        buttons.get(1).addActionListener(new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent e) {
                CountGroupVisitor groupCount = new CountGroupVisitor();
                root.accept(groupCount);
                JOptionPane.showMessageDialog(null, "Count: " + groupCount.getCount());
            }
        });
        
        //Adding listener for messageCount
        buttons.get(2).addActionListener(new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent e) {
                CountMessageVisitor messageCount = new CountMessageVisitor();
                root.accept(messageCount);
                JOptionPane.showMessageDialog(null, "Count: " + messageCount.getCount());
            }
        });
        
        //Adding listener for positivePercent
        buttons.get(3).addActionListener(new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent e) {
                PositivePercentageVisitor positivePercent = new PositivePercentageVisitor();
                root.accept(positivePercent);
                JOptionPane.showMessageDialog(null, "Good Percent: " + positivePercent.getPercent() + "%");
            }
        });
    }
    
    public JButton getButton(int index) {
        return buttons.get(index);
    }

    public void addButton(JButton button) {
        add(button);
        buttons.add(button);
    }
}
