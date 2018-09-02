/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gymproject;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.UIManager;

/**
 * Creates the log in frame for security purposes, allowing certain staff
 * members to be able to make bookings and edit member details.
 *
 * @author Harry Clewlow, Leigh Lawley
 */
public class LoginFrame extends JFrame {

    OneDatabaseToRuleThemAll database;
    LoginFrame frame;
    StaffDatabase sdb1;
    Staff s1;
    boolean s = false;
    boolean enlarge = false;
     Font defaultFont;
       int defaultSize;
    JTextField usernameField;
    JPasswordField passwordField;
    JButton okayButton, cancelButton, disabledUserButton;
    JLabel usernameLabel, passwordLabel;
    JPanel southPanel, centrePanel, usernamePanel, passwordPanel;
/**
 * Method to set the positioning of the log in frame 
 */
    public LoginFrame() {
        super("Gym Manager 2013 Login");
         
        File temp = new File("database.dat");
        if (temp.exists()) {
            database = loadDatabase(temp);
        } else {
            System.out.println("No default database file!");
            database = new OneDatabaseToRuleThemAll();
        }

         defaultFont = UIManager.getDefaults().getFont("Frame.font");
  
        frame = this;
        setLayout(new BorderLayout());
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        usernameField = new JTextField(20);
        usernameLabel = new JLabel("Username:");
        passwordField = new JPasswordField(20);
        passwordLabel = new JLabel("Password: ");
        okayButton = new JButton("Login");
        cancelButton = new JButton("Cancel");
        southPanel = new JPanel();
        centrePanel = new JPanel();

        ImageIcon magnifierIcon = new ImageIcon("resources/images/login_images/Magnifier.PNG");

        disabledUserButton = new JButton("Enlarge", magnifierIcon);

        centrePanel.setLayout(new BorderLayout());
        usernamePanel = new JPanel();
        passwordPanel = new JPanel();

        usernamePanel.add(usernameLabel);
        usernamePanel.add(usernameField);
        passwordPanel.add(passwordLabel);
        passwordPanel.add(passwordField);

        JPanel imagePanel = new JPanel(new BorderLayout());
        ImageIcon imageIcon = new ImageIcon("resources/images/login_images/Software_Logo.PNG");
        JLabel imageLabel = new JLabel(imageIcon);


        centrePanel.add(imageLabel, BorderLayout.NORTH);
        centrePanel.add(usernamePanel, BorderLayout.CENTER);
        centrePanel.add(passwordPanel, BorderLayout.SOUTH);


        southPanel.add(okayButton);
        southPanel.add(cancelButton);
        southPanel.add(disabledUserButton);

        add(centrePanel, BorderLayout.CENTER);
        add(southPanel, BorderLayout.SOUTH);

        okayButton.addActionListener(new OkayListener());
        cancelButton.addActionListener(new CancelListener());
        disabledUserButton.addActionListener(new DisabledUserListener());

        passwordField.addKeyListener(new EnterKeyListener());
        usernameField.addKeyListener(new EnterKeyListener());


        
        getFrame().pack();
        setLocation((int) GymProject.screenWidth / 2 - (this.getWidth() / 2), (int) GymProject.screenHeight / 2 - (this.getHeight() / 2));

        setVisible(true);
    }

    /**
     * Return the JFrame to be used.
     * @return 
     */
    private JFrame getFrame() {
        return this;
    }

    private class OkayListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {
            if (checkDetails()) {
                MainFrame mainFrame = new MainFrame(database, s, enlarge);
                frame.setVisible(false);
                dispose();
            }
        }
    }

    private OneDatabaseToRuleThemAll loadDatabase(File f) {
        OneDatabaseToRuleThemAll d = null;
        try {
            ObjectInputStream input = new ObjectInputStream(new FileInputStream(f));
            d = (OneDatabaseToRuleThemAll) input.readObject();
            input.close();
        } catch (IOException | ClassNotFoundException i) {
            i.printStackTrace();
        }
        return d;
    }

    private class EnterKeyListener implements KeyListener {

        @Override
        public void keyPressed(KeyEvent e) {

            int key = e.getKeyCode();

            if (e.getKeyChar() == KeyEvent.VK_ENTER) {

                if (checkDetails()) {
                     MainFrame mainFrame = new MainFrame(database, s, enlarge);
                    frame.setVisible(false);
                }
            }
        }

        @Override
        public void keyTyped(KeyEvent e) {
        }

        @Override
        public void keyReleased(KeyEvent e) {
        }
    }

    private class CancelListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {
            System.exit(0);
        }
    }

    private class DisabledUserListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {

            if (!enlarge){
            
            Font f = new Font("arial", Font.PLAIN, 30);

            usernameField.setFont(f);
            passwordField.setFont(f);
            okayButton.setFont(f);
            cancelButton.setFont(f);
            disabledUserButton.setFont(f);
            usernameLabel.setFont(f);
            passwordLabel.setFont(f);
            
            enlarge = true;

            getFrame().pack();
            getFrame().setLocation((int) GymProject.screenWidth / 2 - (getFrame().getWidth() / 2), (int) GymProject.screenHeight / 2 - (getFrame().getHeight() / 2));
            }
            else{
                 usernameField.setFont(defaultFont);
            passwordField.setFont(defaultFont);
            okayButton.setFont(defaultFont);
            cancelButton.setFont(defaultFont);
            disabledUserButton.setFont(defaultFont);
            usernameLabel.setFont(defaultFont);
            passwordLabel.setFont(defaultFont);
            
            enlarge = false;

            getFrame().pack();
            getFrame().setLocation((int) GymProject.screenWidth / 2 - (getFrame().getWidth() / 2), (int) GymProject.screenHeight / 2 - (getFrame().getHeight() / 2));
            }
            
        }
    }

    private boolean checkDetails() {
        if ((usernameField.getText().equalsIgnoreCase("admin") && passwordField.getText().equals("admin"))
                || database.getStaffDatabase().checkDetails(usernameField.getText(), passwordField.getText())) {

            s1 = database.getStaffDatabase().getStaff();
            if(usernameField.getText().equalsIgnoreCase("admin") && passwordField.getText().equals("admin")){
                s = true;
            }
            else{
                s= s1.isIsAdmin();
            }
            return true;
        } else {
            JOptionPane.showMessageDialog(getFrame(), "ERROR: The username or password is incorrect", "Logging on to Gym Manager 2013", 0, null);
            return false;
        }
    }
}
