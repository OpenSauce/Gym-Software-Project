package gymproject;

import java.awt.BorderLayout;
import javax.swing.ImageIcon;
import javax.swing.*;

/**
 * Create and display the about window for information about the program and company.
 * @author Harry Clewlow, Leigh Lawley
 */
public class AboutFrame extends JFrame {

    public AboutFrame() {
        super("About Alpha Penguin");
        JPanel imagePanel = new JPanel(new BorderLayout());
        ImageIcon imageIcon = new ImageIcon("resources/images/about_images/Software Logo.PNG");
        JLabel imageLabel = new JLabel(imageIcon);

        imagePanel.add(imageLabel, BorderLayout.NORTH);
        imagePanel.add(new JLabel("Information About The Software"), BorderLayout.CENTER);
        add(imagePanel);
        setLocation(300, 300);
        setSize(500, 600);
        
        setVisible(true);
    }
}
