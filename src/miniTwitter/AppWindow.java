package miniTwitter;


import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * AppWindow
 * Description: Window JFrame, create
 * GUI on start.
 * Has Singleton pattern
 * 
 * @author shun
 *
 */
public class AppWindow extends JFrame{
    private static AppWindow mainWindow;
    
    private AppWindow() {
    }
    
    public static AppWindow getInstance() {
        if (mainWindow == null)
            mainWindow = new AppWindow();
        return mainWindow;
    }

    public void initialize() {
        AppWindow.create();
    }

    private static void create() {
        //Title
        JFrame frame = new JFrame("Mini Twitter");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //Main ControlPanel layout
        JPanel main = new AdminControlPanel();
        
        //Add components here
        frame.getContentPane().add(main);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

}
