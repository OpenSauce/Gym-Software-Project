package gymproject;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Component;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;
import java.util.GregorianCalendar;
import javax.swing.*;
import javax.swing.border.TitledBorder;

/**
 * Create and display the add staff frame, to allow editing of staff log in account details.
 * @author Harry Clewlow, Leigh Lawley
 */
public class AddStaffFrame extends JFrame {

    StaffDatabase staffList;
    private final String MEMBERDETAILS = "Staff Account Details";
    private String firstName;
    private String lastName;
    private String username;
    private String password;
    private int staffID;
    private boolean isAdmin;
    JTextField staffIDField = new JTextField(25);
    JTextField firstNameField = new JTextField(25), secondNameField = new JTextField(25);
    JTextField usernameField = new JTextField(20);
    JPasswordField passwordField = new JPasswordField(20), passwordField1 = new JPasswordField(20);
    JCheckBox isAdminBox = new JCheckBox("Is Admin");
    JPanel mainPanel;

    public AddStaffFrame(StaffDatabase staffList) {
        super("Add Staff Member");

        this.staffList = staffList;

        mainPanel = new JPanel(new CardLayout());
        mainPanel.add(createMemberPanel(), MEMBERDETAILS);

        getContentPane().add(mainPanel);

        setLocation(300, 300);
        pack();
        setVisible(true);
    }

    private JPanel createMemberPanel() {
        JPanel memberPanel = new JPanel(new BorderLayout()), buttonPanel = new JPanel(new BorderLayout());
        JPanel fieldPanel = new JPanel(new GridBagLayout());
        JButton nextButton = new JButton("Finish");
        nextButton.addActionListener(new FinishButtonListener());

        JPanel staffIDPanel = new JPanel();
        staffIDPanel.add(staffIDField);
        staffIDPanel.setBorder(new TitledBorder("Staff ID:"));
        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.HORIZONTAL;
        c.anchor = GridBagConstraints.NORTH;
        c.gridx = 0;
        c.gridy = 0;
        c.weightx = 0.0;
        c.weighty = 0.0;

        fieldPanel.add(staffIDPanel, c);

        JPanel firstNamePanel = new JPanel();
        firstNamePanel.add(firstNameField);
        firstNamePanel.setBorder(new TitledBorder("First Name:"));
        c = new GridBagConstraints();
        c.fill = GridBagConstraints.HORIZONTAL;
        c.anchor = GridBagConstraints.NORTH;
        c.gridx = 0;
        c.gridy = 1;
        c.weightx = 0.0;
        c.weighty = 0.0;

        fieldPanel.add(firstNamePanel, c);

        JPanel secondNamePanel = new JPanel();
        secondNamePanel.add(secondNameField);

        secondNamePanel.setBorder(new TitledBorder("Second Name:"));
        c = new GridBagConstraints();
        c.fill = GridBagConstraints.HORIZONTAL;
        c.anchor = GridBagConstraints.NORTH;
        c.gridx = 0;
        c.gridy = 2;
        c.weightx = 1.0;
        c.weighty = 0;

        fieldPanel.add(secondNamePanel, c);

        JPanel usernamePanel = new JPanel();
        usernamePanel.add(usernameField);

        usernamePanel.setBorder(new TitledBorder("Username:"));
        c = new GridBagConstraints();
        c.fill = GridBagConstraints.HORIZONTAL;
        c.anchor = GridBagConstraints.NORTH;
        c.gridx = 0;
        c.gridy = 3;
        c.weightx = 1.0;
        c.weighty = 1.0;

        fieldPanel.add(usernamePanel, c);


        JPanel passwordPanel = new JPanel();

        passwordPanel.setBorder(new TitledBorder("Password:"));
        passwordPanel.add(passwordField);
        c = new GridBagConstraints();
        c.fill = GridBagConstraints.HORIZONTAL;
        c.anchor = GridBagConstraints.NORTH;
        c.gridx = 0;
        c.gridy = 4;
        c.weightx = 1.0;
        c.weighty = 1.0;

        fieldPanel.add(passwordPanel, c);

        JPanel passwordPanel1 = new JPanel();

        passwordPanel1.setBorder(new TitledBorder("Confirm Passowrd:"));
        passwordPanel1.add(passwordField1);
        c = new GridBagConstraints();
        c.fill = GridBagConstraints.HORIZONTAL;
        c.anchor = GridBagConstraints.NORTH;
        c.gridx = 0;
        c.gridy = 5;
        c.weightx = 1.0;
        c.weighty = 1.0;

        fieldPanel.add(passwordPanel1, c);

        JPanel isAdminPanel = new JPanel();

        isAdminPanel.setBorder(new TitledBorder("Is an Admin:"));
        isAdminPanel.add(isAdminBox);
        c = new GridBagConstraints();
        c.fill = GridBagConstraints.HORIZONTAL;
        c.anchor = GridBagConstraints.NORTH;
        c.gridx = 0;
        c.gridy = 6;
        c.weightx = 1.0;
        c.weighty = 1.0;

        fieldPanel.add(isAdminPanel, c);

        buttonPanel.add(nextButton, BorderLayout.EAST);
        memberPanel.add(buttonPanel, BorderLayout.SOUTH);
        memberPanel.add(fieldPanel, BorderLayout.CENTER);
        return memberPanel;
    }

    private class FinishButtonListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {


            firstName = firstNameField.getText();
            lastName = secondNameField.getText();

            isAdmin = isAdminBox.isSelected();


            if (staffList.checkStaffID(Integer.parseInt(staffIDField.getText()))) {
                staffID = Integer.parseInt(staffIDField.getText());
            } else {
                JOptionPane.showMessageDialog(getFrame(), "ERROR: The StaffID is already taken", "Creating Staff Account", 0, null);
            }


            if (staffList.checkUsername(usernameField.getText())) {
                username = usernameField.getText();
            } else {
                JOptionPane.showMessageDialog(getFrame(), "ERROR: The username is already taken", "Creating Staff Account", 0, null);
            }

            if (passwordField.getText().equals(passwordField1.getText())) {

                password = passwordField.getText();
                Staff s = new Staff(firstName, lastName, username, password, staffID, isAdmin);
                staffList.addStaff(s);
            } else {
                JOptionPane.showMessageDialog(getFrame(), "ERROR: The username or password is incorrect", "Creating Staff Account", 0, null);
            }

            dispose();
        }
    }

    private JFrame getFrame() {
        return this;
    }
}
