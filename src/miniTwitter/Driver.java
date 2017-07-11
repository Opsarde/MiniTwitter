package miniTwitter;


/**
 * Driver class
 * Description: All hardcode and test
 * are here.
 * 
 * @author shun
 */
public class Driver {
    public static void main(String[] args) {
        AppWindow window = AppWindow.getInstance();
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                window.initialize();
            }
        });
    }

}
