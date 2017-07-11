package miniTwitter;

import java.awt.LayoutManager;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JPanel;

/**
 * ButtonPanel
 * Description: Contains buttons
 * 
 * @author shun
 */
public class FourButtonPanel extends JPanel {

    private List<JButton> buttons;

    public FourButtonPanel(LayoutManager layout) {
        super(layout);
        buttons = new ArrayList<>();
        addButton(new JButton("Show User Total"));
        addButton(new JButton("Show Group Total"));
        addButton(new JButton("Show Messages Total"));
        addButton(new JButton("Show Positive Percentage"));
    }
    
    public JButton getButton(int index) {
        return buttons.get(index);
    }

    public void addButton(JButton button) {
        add(button);
        buttons.add(button);
    }
}
