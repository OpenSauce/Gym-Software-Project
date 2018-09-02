package gymproject;

import java.awt.Toolkit;
import javax.swing.UIManager;

/**
 * Main class to run the program. Sets the size of the window to the current monitor.
 * @author Harry Clewlow, Leigh Lawley
 */
public class GymProject {
    final static double screenWidth = java.awt.Toolkit.getDefaultToolkit().getScreenSize().getWidth();
    final static double screenHeight = java.awt.Toolkit.getDefaultToolkit().getScreenSize().getHeight();
/**
 * Method to load the log in frame.
 * @param args 
 */
    public static void main(String[] args) {
        
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            System.out.println("Error setting native LAF: " + e);
        } 
        
        LoginFrame loginFrame = new LoginFrame();
}}
