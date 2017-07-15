/***************************************************
 * CS 356 - Assignment 1
 * Shun Lu
 * July 13, 2017
 * 
 * Description: This program simulates Twitter's
 * basic functions, including creating users and groups,
 * showing statistics, posting message, and following 
 * users.  Singleton, Composite, Observer, and Visitor
 * patterns are used in this project.
 * 
 **************************************************/
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
