package miniTwitter;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * Class: TextButtonPanel
 * Description: panel with JTextField and 
 * JButton combined.  One can get these two
 * components from outside.
 * 
 * @author shun
 */
public class TextButtonPanel extends JPanel {
    private JTextField field;
    private JButton button;
    
    public TextButtonPanel(String name) {
        super();
        field = new JTextField();
        setTextArea(20);
        button = new JButton(name);
        add(field);
        add(button);
    }
    
    public void setTextArea(int column) {
        this.field.setColumns(column);
    }
    public JTextField getField() {
        return field;
    }

    public void setField(JTextField field) {
        this.field = field;
    }

    public JButton getButton() {
        return button;
    }

    public void setButton(JButton button) {
        this.button = button;
    }
}